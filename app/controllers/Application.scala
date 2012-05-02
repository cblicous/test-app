package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._

import anorm._

import views._
import models._
import controllers._

/**
 * Manage a database of computers
 */
object Application extends Controller with Secured { 
  
  /**
   * This result directly redirect to the application home.
   */
	// val Home = Redirect(routes.Application.list(0, 2, ""))
  val Home = Redirect(routes.Collection.list())
  /**
   * Describe the computer form (used in both edit and create screens).
   */ 


  
  val itemForm = Form(
    mapping(
      "id" -> ignored(NotAssigned:Pk[Long]),
      "name" -> nonEmptyText,
      "image" -> nonEmptyText,
      "url" -> nonEmptyText,
      "itemType" -> nonEmptyText,
      "introduced" -> optional(date("yyyy-MM-dd")),
      "company" -> optional(longNumber)
    )(Item.apply)(Item.unapply)
  )
  
  // -- Actions

  /**
   * Handle default path requests, redirect to items list
   */  
  def index = Action { Home }
  
  /**
   * Display the paginated list of items.
   *
   *  def IsAuthenticated(f: => String => Request[AnyContent] => Result) = {
   *  
   *  A play.api.mvc.Action is basically a (play.api.mvc.Request => play.api.mvc.Result) function that handles a request and generates a result to be sent to the client.
   * @param page Current page number (starts from 0)
   * @param orderBy Column to be sorted
   * @param filter Filter applied on computer names
   */
  def list(page: Int, orderBy: Int, filter: String) = IsAuthenticated{  username => implicit request => 
 
	    Ok(html.list(username,
	      Item.list(page = page, orderBy = orderBy, filter = ("%"+filter+"%")),
	      orderBy, filter
	    ))

  }
  
  
  /**
   * Display the 'edit form' of a existing Computer.
   *
   * @param id Id of the computer to edit
   */
  def edit(id: Long) = Action {
    Item.findById(id).map { item =>
      Ok(html.editForm(id, itemForm.fill(item)))
    }.getOrElse(NotFound)
  }
  
  /**
   * Handle the 'edit form' submission 
   *
   * @param id Id of the computer to edit
   */
  def update(id: Long) = Action { implicit request =>
    itemForm.bindFromRequest.fold(
      formWithErrors => BadRequest(html.editForm(id, formWithErrors)),
      item => {
        Item.update(id, item)
        Home.flashing("success" -> "Item %s has been updated".format(item.name))
      }
    )
  }
  
  /**
   * Display the 'new item form'.
   */
  def create = Action { 
    Ok(html.createForm(itemForm))
  }
  
  /**
   * Handle the 'new item form' submission.
   */
  def save = Action { implicit request =>
    itemForm.bindFromRequest.fold(
      formWithErrors => BadRequest(html.createForm(formWithErrors)),
      item => {
        Item.insert(item)
        Home.flashing("success" -> "Item %s has been created".format(item.name))
      }
    )
  }
  
  /**
   * Handle computer deletion.
   */
  def delete(id: Long) = Action {
    Item.delete(id)
    Home.flashing("success" -> "Items has been deleted")
  }



}
            