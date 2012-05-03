
package views.html

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
object main extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Html,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(content: Html):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.17*/("""

<!DOCTYPE html>
<html>
    <head>
        <title>Items database</title>
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*7.70*/routes/*7.76*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*7.119*/(""""> 
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*8.70*/routes/*8.76*/.Assets.at("stylesheets/main.css"))),format.raw/*8.110*/(""""> 
        <script src=""""),_display_(Seq[Any](/*9.23*/routes/*9.29*/.Assets.at("javascript/jquery-1.7.1.min.js"))),format.raw/*9.73*/("""" type="text/javascript"></script>
    </head>
    <body>
        
        <div id="navigation" >
            <h1 class="fill">
                <a href=""""),_display_(Seq[Any](/*15.27*/routes/*15.33*/.Application.index())),format.raw/*15.53*/("""">
                   first demo ' &mdash; Item database
                </a> 
                   </h1> 
           	 		<a href=""""),_display_(Seq[Any](/*19.26*/routes/*19.32*/.Collection.list())),format.raw/*19.50*/(""""> my collection </a> |
           	 		<a href=""""),_display_(Seq[Any](/*20.26*/routes/*20.32*/.Application.list(0, 2, ""))),format.raw/*20.59*/(""""> All Items</a> | 
           	 		<a href=""""),_display_(Seq[Any](/*21.26*/routes/*21.32*/.Login.logout)),format.raw/*21.45*/(""""> Logout</a> | <br/>           	 
            	</div>
        

        
        <section id="main">
            """),_display_(Seq[Any](/*27.14*/content)),format.raw/*27.21*/("""
        </section>
        
    </body>
</html>
"""))}
    }
    
    def render(content:Html) = apply(content)
    
    def f:((Html) => play.api.templates.Html) = (content) => apply(content)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu May 03 11:07:00 CEST 2012
                    SOURCE: C:/repositories/play/test-app/app/views/main.scala.html
                    HASH: 4b9a684f5689937b9723ebcad2b50d351b132c20
                    MATRIX: 502->1|594->16|778->165|792->171|857->214|966->288|980->294|1036->328|1098->355|1112->361|1177->405|1373->565|1388->571|1430->591|1600->725|1615->731|1655->749|1741->799|1756->805|1805->832|1887->878|1902->884|1937->897|2094->1018|2123->1025
                    LINES: 19->1|22->1|28->7|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|36->15|36->15|36->15|40->19|40->19|40->19|41->20|41->20|41->20|42->21|42->21|42->21|48->27|48->27
                    -- GENERATED --
                */
            