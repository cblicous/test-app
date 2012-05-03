package models

import anorm._
import anorm.SqlParser._

import play.api.db._

/**
 * Needed to add Application
 */
import play.api.Play.current


case class Image(id: Pk[Long] = NotAssigned,name: String, image: String, url: String, user_Email : String,item_Id: Long)

	
object Image {

    val simple:anorm.RowParser[models.Image] = {
			get[Pk[Long]]("image.id") ~  
			get[String]("image.name") ~
			get[String]("image.image") ~
			get[String]("image.url") ~
			get[String]("image.user_email")~
			get[Long]("image.item_id")  map {
			case  id~name~image~url~useremail~itemid => Image( id,name,image,url,useremail,itemid )
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
          insert into image values (
            (select next value for image_seq), 
            {name},  {image}, {url}, {itemId},{userEmail}
          )
        """
      ).on( 'name -> image.name,
        'image -> image.image,
        'url -> image.url,
        'userEmail -> image.user_Email,
        'itemId -> image.item_Id
      ).executeUpdate()
    }
  }
  
  
  /**
   * Finds items possesed by the user 
   */
    def findImagesByUser(user_Email: String,item_Id: Long): Seq[Image] = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          select * from image 
          where image.user_email = {user_Email} AND 
          image.item_id = {item_Id}
        """
      ).on(
        'user_Email -> user_Email,
         'item_Id -> item_Id
      ).as(Image.simple *)
    }
  }
  
  
    
}