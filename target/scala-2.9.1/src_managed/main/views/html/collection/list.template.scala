
package views.html.collection

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
object list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Seq[Item],User,play.api.templates.Html] {

    /**/
    def apply/*1.2*/( items: Seq[Item], user: User):play.api.templates.Html = {
        _display_ {

Seq(format.raw/*1.33*/("""
"""),_display_(Seq(/*2.2*/main/*2.6*/ {_display_(Seq(format.raw/*2.8*/("""

<h1>Your Collection """),_display_(Seq(/*4.22*/(user.name))),format.raw/*4.33*/("""</h1>
<div class="collectionBoard">
"""),_display_(Seq(/*6.2*/for(item <- items) yield /*6.20*/ {_display_(Seq(format.raw/*6.22*/("""
  <div class="collectionCase">
  <img src=""""),_display_(Seq(/*8.14*/item/*8.18*/.image)),format.raw/*8.24*/("""" border="0" /><br/>
  """),_display_(Seq(/*9.4*/item/*9.8*/.name)),format.raw/*9.13*/(""" ($"""),_display_(Seq(/*9.17*/item/*9.21*/.id)),format.raw/*9.24*/(""")
  <br/>
  <a class="btn primary" id="add" href=""""),_display_(Seq(/*11.42*/routes/*11.48*/.UserImage.addImage(item.id.get))),format.raw/*11.80*/("""">Add a UserImage</a>
        
  </div>
""")))})),format.raw/*14.2*/(""" 
</div>

""")))})))}
    }
    
    def render(items:Seq[Item],user:User) = apply(items,user)
    
    def f:((Seq[Item],User) => play.api.templates.Html) = (items,user) => apply(items,user)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Apr 26 11:12:13 CEST 2012
                    SOURCE: /play-2.0/samples/scala/computer-database/app/views/collection/list.scala.html
                    HASH: 5194f584169fcb087ffc5baa30924d784ec50a8c
                    MATRIX: 523->1|626->32|657->34|668->38|701->40|754->63|786->74|852->111|885->129|919->131|994->176|1006->180|1033->186|1086->210|1097->214|1123->219|1157->223|1169->227|1193->230|1275->281|1290->287|1344->319|1416->360
                    LINES: 19->1|22->1|23->2|23->2|23->2|25->4|25->4|27->6|27->6|27->6|29->8|29->8|29->8|30->9|30->9|30->9|30->9|30->9|30->9|32->11|32->11|32->11|35->14
                    -- GENERATED --
                */
            