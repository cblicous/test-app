package models

import java.util.{Date}

import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._

case class Company(id: Pk[Long] = NotAssigned, name: String)
case class Item(id: Pk[Long] = NotAssigned, name: String,image:String ,url:String ,itemType : String ,introduced: Option[Date],  companyId: Option[Long])

/**
 * Helper for pagination.
 */
case class Page[A](items: Seq[A], page: Int, offset: Long, total: Long) {
  lazy val prev = Option(page - 1).filter(_ >= 0)
  lazy val next = Option(page + 1).filter(_ => (offset + items.size) < total)
}

object Item {
  
  // -- Parsers
  
  /**
   * Parse a Computer from a ResultSet
   */
  val simple = {
    get[Pk[Long]]("item.id") ~
    get[String]("item.name") ~
    get[String]("item.image") ~
    get[String]("item.url") ~
    get[String]("item.itemType") ~
    get[Option[Date]]("item.introduced") ~
    get[Option[Long]]("item.company_id") map {
      case id~name~image~url~itemType~introduced~companyId => Item(id, name, image, url,itemType, introduced, companyId)
    }
  }
  
  /**
   * Parse a (Item,Company) from a ResultSet
   */
  val withCompany = Item.simple ~ (Company.simple ?) map {
    case item~company => (item,company)
  }
  
  // -- Queries
  
  /**
   * Retrieve a computer from the id.
   * 
   * Option is a datatype which can be some or none 
   * 
   case Some(item) => {
     println(item.name.trim.toUppercase)
   }
   case None => {
     println("No item value")
   }
   */
  def findById(id: Long): Option[Item] = {
   val item = DB.withConnection { implicit connection =>
      SQL("se lect * from Item where id = {id}").on('id -> id).as(Item.simple.singleOpt)
    }
   item
  }
  
    
  def isItemCollected(itemId:Long,userEmail : String):Boolean =  {
 	   val result:Long = DB.withConnection { implicit connection => {
 		   SQL("select count(*) as c from item_owner where item_id = {itemId} AND user_email = {userEmail}").on('itemId -> itemId,'userEmail -> userEmail).as(scalar[Long].single)
 	   		}
  		}	
      if(result == 0) {
    	    false
    	  } else {
    	    true 
    	  }
   }
  

  /**
   * Finds items possesed by the user 
   */
    def findItemsByUser(userEmail: String): Seq[Item] = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          select * from item 
          join item_owner on item.id = item_owner.item_id 
          where item_owner.user_email = {userEmail}
        """
      ).on(
        'userEmail -> userEmail
      ).as(Item.simple *)
    }
  }
  
  
  /**
   * Collect an item
   */
  def addItemToUser(item: Long, userEmail: String) {
    DB.withConnection { implicit connection =>
      SQL("insert into item_owner values({item}, {userEmail})").on(
        'item -> item,
        'userEmail -> userEmail
      ).executeUpdate()
    }
  }
  
  
  /**
   * Return a page of (Computer,Company).
   *
   * @param page Page to display
   * @param pageSize Number of computers per page
   * @param orderBy Computer property used for sorting
   * @param filter Filter applied on the name column
   */
  def list(page: Int = 0, pageSize: Int = 10, orderBy: Int = 1, filter: String = "%"): Page[(Item, Option[Company])] = {
    
    val offest = pageSize * page
    
    DB.withConnection { implicit connection =>
      
      val items = SQL(
        """
          select * from item 
          left join Company on item.company_id = company.id
          where item.name like {filter}
          order by {orderBy} nulls last
          limit {pageSize} offset {offset}
        """
      ).on(
        'pageSize -> pageSize, 
        'offset -> offest,
        'filter -> filter,
        'orderBy -> orderBy
      ).as(Item.withCompany *)

      val totalRows = SQL(
        """
          select count(*) from item 
          left join company on item.company_id = company.id
          where item.name like {filter}
        """
      ).on(
        'filter -> filter
      ).as(scalar[Long].single)

      Page(items, page, offest, totalRows)
      
    }
    
  }
  
  /**
   * Update a item.
   *
   * @param id The item id
   * @param computer The computer values.
   */
  def update(id: Long, item: Item) = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          update Item
          set name = {name}, introduced = {introduced}, image = {image},itemType = {itemType},url= {url}, company_id = {company_id}
          where id = {id}
        """
      ).on(
        'id -> id,
        'name -> item.name,
        'introduced -> item.introduced,
        'image -> item.image,
        'url -> item.url,
        'itemType -> item.itemType,
        'company_id -> item.companyId
      ).executeUpdate()
    }
  }
  
  /**
   * Insert a new item.
   *
   * @param computer The item values.
   */
  def insert(item: Item) = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          insert into item values (
            (select next value for item_seq), 
            {name},  {image}, {url}, {itemType} ,{introduced},{company_id}
          )
        """
      ).on(
        'name -> item.name,
        'image -> item.image,
        'url -> item.url,
        'itemType -> item.itemType,
        'introduced -> item.introduced,
        'company_id -> item.companyId
      ).executeUpdate()
    }
  }
  
  
  /**
   * Delete a item.
   *
   * @param id Id of the item to delete.
   */
  def delete(id: Long) = {
    DB.withConnection { implicit connection =>
      SQL("delete from item where id = {id}").on('id -> id).executeUpdate()
    }
  }
  
}



object Company {
    
  /**
   * Parse a Company from a ResultSet
   */
  val simple = {
    get[Pk[Long]]("company.id") ~
    get[String]("company.name") map {
      case id~name => Company(id, name)
    }
  }
  
  /**
   * Construct the Map[String,String] needed to fill a select options set.
   */
  def options: Seq[(String,String)] = DB.withConnection { implicit connection =>
    SQL("select * from company order by name").as(Company.simple *).map(c => c.id.toString -> c.name)
  }
  
}

