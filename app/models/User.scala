package models
import anorm.Pk
import anorm.NotAssigned
import play.api.db._
import play.api.Play.current

import anorm._
import anorm.SqlParser._


	case class User( email: String, password: String, name: String)

	object User {

  /**
   * Parse a User from a ResultSet
   * str("name") ~ int("population") map { case n~p => (n,p) }
   * o_O
   */
  val simple = {
  
    get[String]("user.email") ~
    get[String]("user.password") ~
    get[String]("user.name") map {
      case email~password~name => User( email, password, name)
    }
  }
  

  
  // -- Queries
  
  /**
   * Retrieve a computer from the id.
   */
  def findById(id: Long): Option[User] = {
    DB.withConnection { implicit connection =>
      SQL("select * from User where id = {id}").on('id -> id).as(User.simple.singleOpt)
    }
  }
  
    // -- Queries
  
  /**
   * Retrieve a computer from the id.
   */
  def findByEmail(email: String): Option[User] = {
    DB.withConnection { implicit connection =>
      SQL("select * from User where email = {email}").on('email -> email).as(User.simple.singleOpt)
    }
  }
  
   /**
   * Authenticate a User.
   */
  def authenticate(email: String, password: String): Option[User] = {
    

    DB.withConnection { implicit connection =>
      SQL(
        """
         select * from user where 
         email = {email} and password = {password}
        """
      ).on(
        'email -> email,
        'password -> password
      ).as(User.simple.singleOpt)
    } 

    
  }
   
  
  /**
   * Update a User.
   *
   * @param id The USer id
   * @param User The user values.
   */
  def update(id: Long, user: User) = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          update Item
          set name = {name}, email = {email}, password = {password}
          where id = {id}
        """
      ).on(
        'id -> id,
        'name -> user.name,
        'email -> user.email,
        'password -> user.password
      ).executeUpdate()
    }
  }
  
  /**
   * Insert a new item.
   *
   * @param computer The item values.
   */
  def insert(user: User) = {
    DB.withConnection { implicit connection =>
      SQL(
        """
          insert into user values (
            (select next value for user_seq), 
            {name},  {email}, {password}
          )
        """
      ).on(
        'name -> user.name,
        'email -> user.email,
        'password -> user.password
      ).executeUpdate()
    }
  }
  
  
  /**
   * Delete a computer.
   *
   * @param id Id of the computer to delete.
   */
  def delete(id: Long) = {
    DB.withConnection { implicit connection =>
      SQL("delete from item where id = {id}").on('id -> id).executeUpdate()
    }
  }
  
}
	
