package models

import anorm._
import anorm.SqlParser._

import play.api.db._

/**
 * Needed to add Application
 */
import play.api.Play.current


case class Image(id: Pk[Long] = NotAssigned, url: String, userEmail : String,itemId: Long)

	
object Image {

    val simple:anorm.RowParser[models.Image] = {
			get[Pk[Long]]("image.id") ~  
			get[String]("image.url") ~
			get[String]("image.useremail")~
			get[Long]("image.itemid")  map {
			case  id~url~useremail~itemid => Image( id,url,useremail,itemid )
	    }
    }
    
   
      /**
   * Insert a new item.
   *
   * @param computer The item values.
   */
  def insert(image: Image) = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          insert into item values (
            (select next value for item_seq), 
            {name},  {image}, {url}, {itemType} ,{introduced},{company_id}
          )
        """
      ).on(
      ).executeUpdate()
    }
  }
  
  
  /**
   * Finds items possesed by the user 
   */
    def findImagesByUser(userEmail: String,itemId: Long): Seq[Image] = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          select * from image 
          where image.useremail = {userEmail} AND 
          image.itemid = {itemId}
        """
      ).on(
        'userEmail -> userEmail,
         'itemId -> itemId
      ).as(Image.simple *)
    }
  }
  
  
    
}