
package views.html.image

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import play.api.i18n._
import play.api.mvc._
import play.api.data._
import views.html._
/**/
object imageForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Long,String,play.api.templates.Html] {

    /**/
    def apply/*2.2*/(itemId: Long, userEmail : String):play.api.templates.Html = {
        _display_ {import helper._


Seq(format.raw/*2.36*/("""


"""),format.raw/*6.1*/("""
"""),_display_(Seq(/*7.2*/main/*7.6*/ {_display_(Seq(format.raw/*7.8*/("""

	"""),_display_(Seq(/*9.3*/form(action = routes.UserImage.upload, 'enctype -> "multipart/form-data")/*9.76*/ {_display_(Seq(format.raw/*9.78*/("""
	
	    File:      
	    <input type="file" name="picture"> <br/>
	    <input type="text" name="url"> <br/>
	    <input type="text" name="userEmail" value=""""),_display_(Seq(/*14.50*/userEmail)),format.raw/*14.59*/(""""> <br/>
	    <input type="text" name="itemId" value=""""),_display_(Seq(/*15.47*/itemId)),format.raw/*15.53*/("""">     <br/>
	    
	    <p>
	        <input type="submit"  class="btn primary">
	    </p>
	    
	""")))})),format.raw/*21.3*/("""
""")))})))}
    }
    
    def render(itemId:Long,userEmail:String) = apply(itemId,userEmail)
    
    def f:((Long,String) => play.api.templates.Html) = (itemId,userEmail) => apply(itemId,userEmail)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 24 17:25:58 CEST 2012
                    SOURCE: /play-2.0/samples/scala/computer-database/app/views/image/imageForm.scala.html
                    HASH: a271badd7181f0182f0284d21449d74969eddad0
                    MATRIX: 520->2|642->36|671->56|702->58|713->62|746->64|779->68|860->141|894->143|1082->300|1113->309|1199->364|1227->370|1356->468
                    LINES: 19->2|23->2|26->6|27->7|27->7|27->7|29->9|29->9|29->9|34->14|34->14|35->15|35->15|41->21
                    -- GENERATED --
                */
            