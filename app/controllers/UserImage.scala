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
      "name" -> text,
      "image" -> text,
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
	 

	 val md5 = MessageDigest.getInstance("MD5")
	 md5.reset()
	 md5.update(("filename + System.currentTimeMillis ").getBytes())
	 
     val md5hash = md5.digest().map(0xFF & _).map { "%02x".format(_) }.foldLeft(""){_ + _}
     val path = Play.current.path
     val filenameNew =  "/public/usermedia/" + md5hash + filename
     val filenameWithPath = path +filenameNew
	 filePart.ref.moveTo(new File(filenameNew),true)
	 
	 var imageMaybe = filledForm.value
	 
	  imageMaybe match {
	  	case Some( image) => {
	  				var newImage = Image(null,image.name,filename,filenameNew ,image.user_Email,image.item_Id)
	  				 Image.insert(newImage)
	  		}
	  	case None => {
	  		println("No name value")
	  	}
	  }


	 // MAP : List (1,2,3,4) map ( s => s.length) wird zu 
	 // 1.legth 2.length 3.length 
	 
	 //fold left : 
	 // List (1,2,3,4) foldleft ((s,i) => s + i)) 
	 // wird zu 
	 
	 // scala> List("How","long","are","we?") map (_.length)
	// res7: List[Int] = List(3, 4, 3, 3)

	 if (filledForm.hasErrors){
		 // todo : errorhandling
		// BadRequest(html.image.imageForm(formWithErrors))
	 }
	

	   // Ok("File uploaded")
	 Redirect(routes.Collection.list)
  }
}
  
}