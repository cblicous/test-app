package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import anorm._
import views._
import models._
import controllers._
import java.security.MessageDigest



/**
 *   Form<UploadResource> filledForm = uploadForm.bindFromRequest();

    if (filledForm.hasErrors()) {
        return badRequest(views.html.upload.render(filledForm));
    } else {
        UploadResource resource = filledForm.get();
        MultipartFormData body = request().body().asMultipartFormData();
        FilePart resourceFile = body.getFile("resourceFile");


     }
 */
object UserImage extends Controller with Secured {

    val imageForm = Form(
    mapping(
      "id" -> ignored(NotAssigned:Pk[Long]),
      "url" -> text,
      "userEmail" -> text,
      "itemId" ->longNumber
    )(Image.apply)(Image.unapply)
  )
  
  def addImage(itemId:Long) = IsAuthenticated { userEmail => implicit request =>
        Ok(html.image.imageForm(itemId,userEmail))
  }
  
  def upload = Action { request => {
	  import java.io.File
 
	 val body =  request.body.asMultipartFormData
	 val file = body.get.file("picture")
	 val filePart = file.get

	 val filledForm = imageForm.bindFromRequest()(request)
	 
	 val filename = filePart.filename 
	 val contentType = filePart.contentType
	 filePart.ref.moveTo(new File("../../public/usermedia/" + filename))

	 val md5 = MessageDigest.getInstance("MD5")
	 md5.reset()
	 md5.update(("filename + System.currentTimeMillis ").getBytes())

     val md5hash = md5.digest().map(0xFF & _).map { "%02x".format(_) }.foldLeft(""){_ + _}
  
	 if (filledForm.hasErrors){
		 // todo : errorhandling
		// BadRequest(html.image.imageForm(formWithErrors))
	 }
	

	   Ok("File uploaded")
  }
}
  
}