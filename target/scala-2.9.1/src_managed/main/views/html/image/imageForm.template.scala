
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


Seq[Any](format.raw/*2.36*/("""


"""),format.raw/*6.1*/("""
"""),_display_(Seq[Any](/*7.2*/main/*7.6*/ {_display_(Seq[Any](format.raw/*7.8*/("""

	"""),_display_(Seq[Any](/*9.3*/form(action = routes.UserImage.upload, 'enctype -> "multipart/form-data")/*9.76*/ {_display_(Seq[Any](format.raw/*9.78*/("""
	
	    File:      
	    <input type="file" name="picture"> <br/>
	    <input type="text" name="url"> <br/>
	    <input type="text" name="name"> <br/>
	    <input type="text" name="image"> <br/>
	    
	    <input type="text" name="userEmail" value=""""),_display_(Seq[Any](/*17.50*/userEmail)),format.raw/*17.59*/(""""> <br/>
	    <input type="text" name="itemId" value=""""),_display_(Seq[Any](/*18.47*/itemId)),format.raw/*18.53*/("""">     <br/>
	    
	    <p>
	        <input type="submit"  class="btn primary">
	    </p>
	    
	""")))})),format.raw/*24.3*/("""
""")))})))}
    }
    
    def render(itemId:Long,userEmail:String) = apply(itemId,userEmail)
    
    def f:((Long,String) => play.api.templates.Html) = (itemId,userEmail) => apply(itemId,userEmail)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu May 03 12:21:28 CEST 2012
                    SOURCE: C:/repositories/play/test-app/app/views/image/imageForm.scala.html
                    HASH: b7303e7829edb3961bf54e8d51a841500f3199a3
                    MATRIX: 520->3|648->37|680->61|717->64|728->68|766->70|806->76|887->149|926->151|1220->409|1251->418|1343->474|1371->480|1506->584
                    LINES: 19->2|23->2|26->6|27->7|27->7|27->7|29->9|29->9|29->9|37->17|37->17|38->18|38->18|44->24
                    -- GENERATED --
                */
            