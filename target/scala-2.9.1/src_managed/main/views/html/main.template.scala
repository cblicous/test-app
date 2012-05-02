
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

Seq(format.raw/*1.17*/("""

<!DOCTYPE html>
<html>
    <head>
        <title>Items database</title>
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq(/*7.70*/routes/*7.76*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*7.119*/(""""> 
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq(/*8.70*/routes/*8.76*/.Assets.at("stylesheets/main.css"))),format.raw/*8.110*/(""""> 
        <script src=""""),_display_(Seq(/*9.23*/routes/*9.29*/.Assets.at("javascript/jquery-1.7.1.min.js"))),format.raw/*9.73*/("""" type="text/javascript"></script>
    </head>
    <body>
        
        <div id="navigation" >
            <h1 class="fill">
                <a href=""""),_display_(Seq(/*15.27*/routes/*15.33*/.Application.index())),format.raw/*15.53*/("""">
                   first demo ' &mdash; Item database
                </a> 
                   </h1> 
           	 		<a href=""""),_display_(Seq(/*19.26*/routes/*19.32*/.Collection.list())),format.raw/*19.50*/(""""> my collection </a> |
           	 		<a href=""""),_display_(Seq(/*20.26*/routes/*20.32*/.Application.list(0, 2, ""))),format.raw/*20.59*/(""""> All Items</a> | 
           	 		<a href=""""),_display_(Seq(/*21.26*/routes/*21.32*/.Login.logout)),format.raw/*21.45*/(""""> Logout</a> | <br/>           	 
            	</div>
        

        
        <section id="main">
            """),_display_(Seq(/*27.14*/content)),format.raw/*27.21*/("""
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
                    DATE: Tue Apr 24 17:07:29 CEST 2012
                    SOURCE: /play-2.0/samples/scala/computer-database/app/views/main.scala.html
                    HASH: 59aa26ea8deabb6ba66dd7934c8cb08126fb8411
                    MATRIX: 502->1|589->16|762->159|776->165|841->208|944->281|958->287|1014->321|1070->347|1084->353|1149->397|1334->551|1349->557|1391->577|1552->707|1567->713|1607->731|1687->780|1702->786|1751->813|1827->858|1842->864|1877->877|2023->992|2052->999
                    LINES: 19->1|22->1|28->7|28->7|28->7|29->8|29->8|29->8|30->9|30->9|30->9|36->15|36->15|36->15|40->19|40->19|40->19|41->20|41->20|41->20|42->21|42->21|42->21|48->27|48->27
                    -- GENERATED --
                */
            