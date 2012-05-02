// @SOURCE:/play-2.0/samples/scala/computer-database/conf/routes
// @HASH:7db78b4e1828d153d4dc3fbd8e38ff8cd70bf3b4
// @DATE:Tue Apr 24 17:45:46 CEST 2012

import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._


import Router.queryString


// @LINE:43
// @LINE:40
// @LINE:37
// @LINE:36
// @LINE:33
// @LINE:32
// @LINE:29
// @LINE:25
// @LINE:22
// @LINE:19
// @LINE:16
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers {

// @LINE:43
class ReverseAssets {
    


 
// @LINE:43
def at(file:String) = {
   Call("GET", "/assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                        

                      
    
}
                            

// @LINE:19
// @LINE:16
class ReverseCollection {
    


 
// @LINE:19
def add(id:Long) = {
   Call("GET", "/mycollection/add/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        
 
// @LINE:16
def list() = {
   Call("GET", "/mycollection")
}
                                                        

                      
    
}
                            

// @LINE:11
// @LINE:10
// @LINE:9
class ReverseLogin {
    


 
// @LINE:10
def authenticate() = {
   Call("POST", "/login")
}
                                                        
 
// @LINE:11
def logout() = {
   Call("GET", "/logout")
}
                                                        
 
// @LINE:9
def login() = {
   Call("GET", "/login")
}
                                                        

                      
    
}
                            

// @LINE:40
// @LINE:37
// @LINE:36
// @LINE:33
// @LINE:32
// @LINE:29
// @LINE:6
class ReverseApplication {
    


 
// @LINE:29
def list(p:Int = 0, s:Int = 2, f:String = "") = {
   Call("GET", "/items" + queryString(List(if(p == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("p", p)), if(s == 2) None else Some(implicitly[QueryStringBindable[Int]].unbind("s", s)), if(f == "") None else Some(implicitly[QueryStringBindable[String]].unbind("f", f)))))
}
                                                        
 
// @LINE:40
def delete(id:Long) = {
   Call("POST", "/items/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete")
}
                                                        
 
// @LINE:32
def create() = {
   Call("GET", "/items/new")
}
                                                        
 
// @LINE:37
def update(id:Long) = {
   Call("POST", "/items/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        
 
// @LINE:33
def save() = {
   Call("POST", "/items")
}
                                                        
 
// @LINE:6
def index() = {
   Call("GET", "/")
}
                                                        
 
// @LINE:36
def edit(id:Long) = {
   Call("GET", "/items/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                        

                      
    
}
                            

// @LINE:25
// @LINE:22
class ReverseUserImage {
    


 
// @LINE:22
def addImage(itemId:Long) = {
   Call("GET", "/mycollection/image/add/" + implicitly[PathBindable[Long]].unbind("itemId", itemId))
}
                                                        
 
// @LINE:25
def upload() = {
   Call("POST", "/mycollection/image/upload")
}
                                                        

                      
    
}
                            
}
                    


// @LINE:43
// @LINE:40
// @LINE:37
// @LINE:36
// @LINE:33
// @LINE:32
// @LINE:29
// @LINE:25
// @LINE:22
// @LINE:19
// @LINE:16
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.javascript {

// @LINE:43
class ReverseAssets {
    


 
// @LINE:43
def at = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"/assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:19
// @LINE:16
class ReverseCollection {
    


 
// @LINE:19
def add = JavascriptReverseRoute(
   "controllers.Collection.add",
   """
      function(id) {
      return _wA({method:"GET", url:"/mycollection/add/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        
 
// @LINE:16
def list = JavascriptReverseRoute(
   "controllers.Collection.list",
   """
      function() {
      return _wA({method:"GET", url:"/mycollection"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:11
// @LINE:10
// @LINE:9
class ReverseLogin {
    


 
// @LINE:10
def authenticate = JavascriptReverseRoute(
   "controllers.Login.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"/login"})
      }
   """
)
                                                        
 
// @LINE:11
def logout = JavascriptReverseRoute(
   "controllers.Login.logout",
   """
      function() {
      return _wA({method:"GET", url:"/logout"})
      }
   """
)
                                                        
 
// @LINE:9
def login = JavascriptReverseRoute(
   "controllers.Login.login",
   """
      function() {
      return _wA({method:"GET", url:"/login"})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:40
// @LINE:37
// @LINE:36
// @LINE:33
// @LINE:32
// @LINE:29
// @LINE:6
class ReverseApplication {
    


 
// @LINE:29
def list = JavascriptReverseRoute(
   "controllers.Application.list",
   """
      function(p,s,f) {
      return _wA({method:"GET", url:"/items" + _qS([(p == """ +  implicitly[JavascriptLitteral[Int]].to(0) + """ ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("p", p)), (s == """ +  implicitly[JavascriptLitteral[Int]].to(2) + """ ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("s", s)), (f == """ +  implicitly[JavascriptLitteral[String]].to("") + """ ? null : (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("f", f))])})
      }
   """
)
                                                        
 
// @LINE:40
def delete = JavascriptReverseRoute(
   "controllers.Application.delete",
   """
      function(id) {
      return _wA({method:"POST", url:"/items/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                                                        
 
// @LINE:32
def create = JavascriptReverseRoute(
   "controllers.Application.create",
   """
      function() {
      return _wA({method:"GET", url:"/items/new"})
      }
   """
)
                                                        
 
// @LINE:37
def update = JavascriptReverseRoute(
   "controllers.Application.update",
   """
      function(id) {
      return _wA({method:"POST", url:"/items/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        
 
// @LINE:33
def save = JavascriptReverseRoute(
   "controllers.Application.save",
   """
      function() {
      return _wA({method:"POST", url:"/items"})
      }
   """
)
                                                        
 
// @LINE:6
def index = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"/"})
      }
   """
)
                                                        
 
// @LINE:36
def edit = JavascriptReverseRoute(
   "controllers.Application.edit",
   """
      function(id) {
      return _wA({method:"GET", url:"/items/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                                                        

                      
    
}
                            

// @LINE:25
// @LINE:22
class ReverseUserImage {
    


 
// @LINE:22
def addImage = JavascriptReverseRoute(
   "controllers.UserImage.addImage",
   """
      function(itemId) {
      return _wA({method:"GET", url:"/mycollection/image/add/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("itemId", itemId)})
      }
   """
)
                                                        
 
// @LINE:25
def upload = JavascriptReverseRoute(
   "controllers.UserImage.upload",
   """
      function() {
      return _wA({method:"POST", url:"/mycollection/image/upload"})
      }
   """
)
                                                        

                      
    
}
                            
}
                    


// @LINE:43
// @LINE:40
// @LINE:37
// @LINE:36
// @LINE:33
// @LINE:32
// @LINE:29
// @LINE:25
// @LINE:22
// @LINE:19
// @LINE:16
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:6
package controllers.ref {

// @LINE:43
class ReverseAssets {
    


 
// @LINE:43
def at(path:String, file:String) = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]))
)
                              

                      
    
}
                            

// @LINE:19
// @LINE:16
class ReverseCollection {
    


 
// @LINE:19
def add(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Collection.add(id), HandlerDef(this, "controllers.Collection", "add", Seq(classOf[Long]))
)
                              
 
// @LINE:16
def list() = new play.api.mvc.HandlerRef(
   controllers.Collection.list(), HandlerDef(this, "controllers.Collection", "list", Seq())
)
                              

                      
    
}
                            

// @LINE:11
// @LINE:10
// @LINE:9
class ReverseLogin {
    


 
// @LINE:10
def authenticate() = new play.api.mvc.HandlerRef(
   controllers.Login.authenticate(), HandlerDef(this, "controllers.Login", "authenticate", Seq())
)
                              
 
// @LINE:11
def logout() = new play.api.mvc.HandlerRef(
   controllers.Login.logout(), HandlerDef(this, "controllers.Login", "logout", Seq())
)
                              
 
// @LINE:9
def login() = new play.api.mvc.HandlerRef(
   controllers.Login.login(), HandlerDef(this, "controllers.Login", "login", Seq())
)
                              

                      
    
}
                            

// @LINE:40
// @LINE:37
// @LINE:36
// @LINE:33
// @LINE:32
// @LINE:29
// @LINE:6
class ReverseApplication {
    


 
// @LINE:29
def list(p:Int, s:Int, f:String) = new play.api.mvc.HandlerRef(
   controllers.Application.list(p, s, f), HandlerDef(this, "controllers.Application", "list", Seq(classOf[Int], classOf[Int], classOf[String]))
)
                              
 
// @LINE:40
def delete(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.delete(id), HandlerDef(this, "controllers.Application", "delete", Seq(classOf[Long]))
)
                              
 
// @LINE:32
def create() = new play.api.mvc.HandlerRef(
   controllers.Application.create(), HandlerDef(this, "controllers.Application", "create", Seq())
)
                              
 
// @LINE:37
def update(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.update(id), HandlerDef(this, "controllers.Application", "update", Seq(classOf[Long]))
)
                              
 
// @LINE:33
def save() = new play.api.mvc.HandlerRef(
   controllers.Application.save(), HandlerDef(this, "controllers.Application", "save", Seq())
)
                              
 
// @LINE:6
def index() = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq())
)
                              
 
// @LINE:36
def edit(id:Long) = new play.api.mvc.HandlerRef(
   controllers.Application.edit(id), HandlerDef(this, "controllers.Application", "edit", Seq(classOf[Long]))
)
                              

                      
    
}
                            

// @LINE:25
// @LINE:22
class ReverseUserImage {
    


 
// @LINE:22
def addImage(itemId:Long) = new play.api.mvc.HandlerRef(
   controllers.UserImage.addImage(itemId), HandlerDef(this, "controllers.UserImage", "addImage", Seq(classOf[Long]))
)
                              
 
// @LINE:25
def upload() = new play.api.mvc.HandlerRef(
   controllers.UserImage.upload(), HandlerDef(this, "controllers.UserImage", "upload", Seq())
)
                              

                      
    
}
                            
}
                    
                