
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

Seq(format.raw/*1.54*/("""

<html>
    <head>
        <title>Login</title>
        <link rel="shortcut icon" type="image/png" href=""""),_display_(Seq(/*6.59*/routes/*6.65*/.Assets.at("images/favicon.png"))),format.raw/*6.97*/("""">
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq(/*7.70*/routes/*7.76*/.Assets.at("stylesheets/login.css"))),format.raw/*7.111*/("""">
    </head>
    <body>
        
        <header>
            <a href=""""),_display_(Seq(/*12.23*/routes/*12.29*/.Application.index)),format.raw/*12.47*/("""" id="logo"> Login</a>
        </header>
        
        """),_display_(Seq(/*15.10*/helper/*15.16*/.form(routes.Login.authenticate)/*15.48*/ {_display_(Seq(format.raw/*15.50*/("""
            
            <h1>Sign in</h1>
            
            """),_display_(Seq(/*19.14*/form/*19.18*/.globalError.map/*19.34*/ { error =>_display_(Seq(format.raw/*19.45*/("""
                <p class="error">
                    """),_display_(Seq(/*21.22*/error/*21.27*/.message)),format.raw/*21.35*/("""
                </p>
            """)))})),format.raw/*23.14*/("""
            
            """),_display_(Seq(/*25.14*/flash/*25.19*/.get("success").map/*25.38*/ { message =>_display_(Seq(format.raw/*25.51*/("""
                <p class="success">
                    """),_display_(Seq(/*27.22*/message)),format.raw/*27.29*/("""
                </p>
            """)))})),format.raw/*29.14*/("""
            
            <p>
                <input type="email" name="email" placeholder="Email" id="email" value=""""),_display_(Seq(/*32.89*/form("email")/*32.102*/.value)),format.raw/*32.108*/("""">
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
                    DATE: Tue Apr 24 17:17:41 CEST 2012
                    SOURCE: /play-2.0/samples/scala/computer-database/app/views/login.scala.html
                    HASH: ec61729e85b503682d8940de083edc6dd723a910
                    MATRIX: 539->1|663->53|800->160|814->166|867->198|969->270|983->276|1040->311|1145->385|1160->391|1200->409|1290->468|1305->474|1346->506|1381->508|1481->577|1494->581|1519->597|1563->608|1650->664|1664->669|1694->677|1761->712|1819->739|1833->744|1861->763|1907->776|1996->834|2025->841|2092->876|2241->994|2264->1007|2293->1013|2596->1284
                    LINES: 19->1|22->1|27->6|27->6|27->6|28->7|28->7|28->7|33->12|33->12|33->12|36->15|36->15|36->15|36->15|40->19|40->19|40->19|40->19|42->21|42->21|42->21|44->23|46->25|46->25|46->25|46->25|48->27|48->27|50->29|53->32|53->32|53->32|62->41
                    -- GENERATED --
                */
            