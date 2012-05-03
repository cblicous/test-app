
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
object login extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Form[scala.Tuple2[String, String]],Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(form: Form[(String,String)])(implicit flash: Flash):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.54*/("""

<html>
    <head>
        <title>Login</title>
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq[Any](/*6.59*/routes/*6.65*/.Assets.at("images/favicon.png"))),format.raw/*6.97*/("""">
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*7.70*/routes/*7.76*/.Assets.at("stylesheets/login.css"))),format.raw/*7.111*/("""">
    </head>
    <body>
        
        <header>
            <a href=""""),_display_(Seq[Any](/*12.23*/routes/*12.29*/.Application.index)),format.raw/*12.47*/("""" id="logo"> Login</a>
        </header>
        
        """),_display_(Seq[Any](/*15.10*/helper/*15.16*/.form(routes.Login.authenticate)/*15.48*/ {_display_(Seq[Any](format.raw/*15.50*/("""
            
            <h1>Sign in</h1>
            
            """),_display_(Seq[Any](/*19.14*/form/*19.18*/.globalError.map/*19.34*/ { error =>_display_(Seq[Any](format.raw/*19.45*/("""
                <p class="error">
                    """),_display_(Seq[Any](/*21.22*/error/*21.27*/.message)),format.raw/*21.35*/("""
                </p>
            """)))})),format.raw/*23.14*/("""
            
            """),_display_(Seq[Any](/*25.14*/flash/*25.19*/.get("success").map/*25.38*/ { message =>_display_(Seq[Any](format.raw/*25.51*/("""
                <p class="success">
                    """),_display_(Seq[Any](/*27.22*/message)),format.raw/*27.29*/("""
                </p>
            """)))})),format.raw/*29.14*/("""
            
            <p>
                <input type="email" name="email" placeholder="Email" id="email" value=""""),_display_(Seq[Any](/*32.89*/form("email")/*32.102*/.value)),format.raw/*32.108*/("""">
            </p>
            <p>
                <input type="password" name="password" id="password" placeholder="Password">
            </p>
            <p>
                <button type="submit" id="loginbutton">Login</button>
            </p>
            
        """)))})),format.raw/*41.10*/("""
        
        <p class="note">
            Try <em>cb@test.de</em> with <em>test</em> as password.
        </p>
            
    </body>
</html>
    


"""))}
    }
    
    def render(form:Form[scala.Tuple2[String, String]],flash:Flash) = apply(form)(flash)
    
    def f:((Form[scala.Tuple2[String, String]]) => (Flash) => play.api.templates.Html) = (form) => (flash) => apply(form)(flash)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu May 03 11:07:00 CEST 2012
                    SOURCE: C:/repositories/play/test-app/app/views/login.scala.html
                    HASH: d3683314b4ffd3a90e6f95909cc526914894f61f
                    MATRIX: 539->1|668->53|815->165|829->171|882->203|990->276|1004->282|1061->317|1176->396|1191->402|1231->420|1329->482|1344->488|1385->520|1425->522|1534->595|1547->599|1572->615|1621->626|1715->684|1729->689|1759->697|1828->734|1893->763|1907->768|1935->787|1986->800|2082->860|2111->867|2180->904|2337->1025|2360->1038|2389->1044|2701->1324
                    LINES: 19->1|22->1|27->6|27->6|27->6|28->7|28->7|28->7|33->12|33->12|33->12|36->15|36->15|36->15|36->15|40->19|40->19|40->19|40->19|42->21|42->21|42->21|44->23|46->25|46->25|46->25|46->25|48->27|48->27|50->29|53->32|53->32|53->32|62->41
                    -- GENERATED --
                */
            