// @SOURCE:/play-2.0/samples/scala/computer-database/conf/routes
// @HASH:7db78b4e1828d153d4dc3fbd8e38ff8cd70bf3b4
// @DATE:Tue Apr 24 17:45:46 CEST 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString

object Routes extends Router.Routes {


// @LINE:6
val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart("/"))))
                    

// @LINE:9
val controllers_Login_login1 = Route("GET", PathPattern(List(StaticPart("/login"))))
                    

// @LINE:10
val controllers_Login_authenticate2 = Route("POST", PathPattern(List(StaticPart("/login"))))
                    

// @LINE:11
val controllers_Login_logout3 = Route("GET", PathPattern(List(StaticPart("/logout"))))
                    

// @LINE:16
val controllers_Collection_list4 = Route("GET", PathPattern(List(StaticPart("/mycollection"))))
                    

// @LINE:19
val controllers_Collection_add5 = Route("GET", PathPattern(List(StaticPart("/mycollection/add/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:22
val controllers_UserImage_addImage6 = Route("GET", PathPattern(List(StaticPart("/mycollection/image/add/"),DynamicPart("itemId", """[^/]+"""))))
                    

// @LINE:25
val controllers_UserImage_upload7 = Route("POST", PathPattern(List(StaticPart("/mycollection/image/upload"))))
                    

// @LINE:29
val controllers_Application_list8 = Route("GET", PathPattern(List(StaticPart("/items"))))
                    

// @LINE:32
val controllers_Application_create9 = Route("GET", PathPattern(List(StaticPart("/items/new"))))
                    

// @LINE:33
val controllers_Application_save10 = Route("POST", PathPattern(List(StaticPart("/items"))))
                    

// @LINE:36
val controllers_Application_edit11 = Route("GET", PathPattern(List(StaticPart("/items/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:37
val controllers_Application_update12 = Route("POST", PathPattern(List(StaticPart("/items/"),DynamicPart("id", """[^/]+"""))))
                    

// @LINE:40
val controllers_Application_delete13 = Route("POST", PathPattern(List(StaticPart("/items/"),DynamicPart("id", """[^/]+"""),StaticPart("/delete"))))
                    

// @LINE:43
val controllers_Assets_at14 = Route("GET", PathPattern(List(StaticPart("/assets/"),DynamicPart("file", """.+"""))))
                    
def documentation = List(("""GET""","""/""","""controllers.Application.index"""),("""GET""","""/login""","""controllers.Login.login"""),("""POST""","""/login""","""controllers.Login.authenticate"""),("""GET""","""/logout""","""controllers.Login.logout"""),("""GET""","""/mycollection""","""controllers.Collection.list"""),("""GET""","""/mycollection/add/$id<[^/]+>""","""controllers.Collection.add(id:Long)"""),("""GET""","""/mycollection/image/add/$itemId<[^/]+>""","""controllers.UserImage.addImage(itemId:Long)"""),("""POST""","""/mycollection/image/upload""","""controllers.UserImage.upload"""),("""GET""","""/items""","""controllers.Application.list(p:Int ?= 0, s:Int ?= 2, f:String ?= "")"""),("""GET""","""/items/new""","""controllers.Application.create"""),("""POST""","""/items""","""controllers.Application.save"""),("""GET""","""/items/$id<[^/]+>""","""controllers.Application.edit(id:Long)"""),("""POST""","""/items/$id<[^/]+>""","""controllers.Application.update(id:Long)"""),("""POST""","""/items/$id<[^/]+>/delete""","""controllers.Application.delete(id:Long)"""),("""GET""","""/assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""))
             
    
def routes:PartialFunction[RequestHeader,Handler] = {        

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.index, HandlerDef(this, "controllers.Application", "index", Nil))
   }
}
                    

// @LINE:9
case controllers_Login_login1(params) => {
   call { 
        invokeHandler(_root_.controllers.Login.login, HandlerDef(this, "controllers.Login", "login", Nil))
   }
}
                    

// @LINE:10
case controllers_Login_authenticate2(params) => {
   call { 
        invokeHandler(_root_.controllers.Login.authenticate, HandlerDef(this, "controllers.Login", "authenticate", Nil))
   }
}
                    

// @LINE:11
case controllers_Login_logout3(params) => {
   call { 
        invokeHandler(_root_.controllers.Login.logout, HandlerDef(this, "controllers.Login", "logout", Nil))
   }
}
                    

// @LINE:16
case controllers_Collection_list4(params) => {
   call { 
        invokeHandler(_root_.controllers.Collection.list, HandlerDef(this, "controllers.Collection", "list", Nil))
   }
}
                    

// @LINE:19
case controllers_Collection_add5(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Collection.add(id), HandlerDef(this, "controllers.Collection", "add", Seq(classOf[Long])))
   }
}
                    

// @LINE:22
case controllers_UserImage_addImage6(params) => {
   call(params.fromPath[Long]("itemId", None)) { (itemId) =>
        invokeHandler(_root_.controllers.UserImage.addImage(itemId), HandlerDef(this, "controllers.UserImage", "addImage", Seq(classOf[Long])))
   }
}
                    

// @LINE:25
case controllers_UserImage_upload7(params) => {
   call { 
        invokeHandler(_root_.controllers.UserImage.upload, HandlerDef(this, "controllers.UserImage", "upload", Nil))
   }
}
                    

// @LINE:29
case controllers_Application_list8(params) => {
   call(params.fromQuery[Int]("p", Some(0)), params.fromQuery[Int]("s", Some(2)), params.fromQuery[String]("f", Some(""))) { (p, s, f) =>
        invokeHandler(_root_.controllers.Application.list(p, s, f), HandlerDef(this, "controllers.Application", "list", Seq(classOf[Int], classOf[Int], classOf[String])))
   }
}
                    

// @LINE:32
case controllers_Application_create9(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.create, HandlerDef(this, "controllers.Application", "create", Nil))
   }
}
                    

// @LINE:33
case controllers_Application_save10(params) => {
   call { 
        invokeHandler(_root_.controllers.Application.save, HandlerDef(this, "controllers.Application", "save", Nil))
   }
}
                    

// @LINE:36
case controllers_Application_edit11(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Application.edit(id), HandlerDef(this, "controllers.Application", "edit", Seq(classOf[Long])))
   }
}
                    

// @LINE:37
case controllers_Application_update12(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Application.update(id), HandlerDef(this, "controllers.Application", "update", Seq(classOf[Long])))
   }
}
                    

// @LINE:40
case controllers_Application_delete13(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        invokeHandler(_root_.controllers.Application.delete(id), HandlerDef(this, "controllers.Application", "delete", Seq(classOf[Long])))
   }
}
                    

// @LINE:43
case controllers_Assets_at14(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(_root_.controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String])))
   }
}
                    
}
    
}
                