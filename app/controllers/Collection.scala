package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import anorm._

import views._
import models._
import controllers._

object Collection extends Controller with Secured {

    def add(id:Long) = IsAuthenticated { userEmail => _ =>
    User.findByEmail(userEmail).map { user =>
      Ok( {
    		  Item.addItemToUser(id,userEmail)
    		  "ok";
      	}
        )
      
    }.getOrElse(Forbidden)
  }

    
  def list = IsAuthenticated { userEmail => _ =>
    User.findByEmail(userEmail).map { user =>
      Ok(
        views.html.collection.list(
          Item.findItemsByUser(userEmail), 
          user
        )
      )
    }.getOrElse(Forbidden)
  }



  
}