
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
object list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template3[Seq[Item],User,Map[Long, Seq[Image]],play.api.templates.Html] {

    /**/
    def apply/*1.2*/( items: Seq[Item], user: User, imageMap : Map[Long, Seq[Image]]):play.api.templates.Html = {
        _display_ {

Seq[Any](format.raw/*1.67*/("""
"""),_display_(Seq[Any](/*2.2*/main/*2.6*/ {_display_(Seq[Any](format.raw/*2.8*/("""

<h1>Your Collection """),_display_(Seq[Any](/*4.22*/(user.name))),format.raw/*4.33*/("""</h1>
<div class="collectionBoard">
"""),_display_(Seq[Any](/*6.2*/for(item <- items) yield /*6.20*/ {_display_(Seq[Any](format.raw/*6.22*/("""
  <div class="collectionCase">
  <img src=""""),_display_(Seq[Any](/*8.14*/item/*8.18*/.image)),format.raw/*8.24*/("""" border="0" /><br/>
  """),_display_(Seq[Any](/*9.4*/item/*9.8*/.name)),format.raw/*9.13*/(""" ($"""),_display_(Seq[Any](/*9.17*/item/*9.21*/.id)),format.raw/*9.24*/(""")
  <br/>
  <a class="btn primary" id="add" href=""""),_display_(Seq[Any](/*11.42*/routes/*11.48*/.UserImage.addImage(item.id.get))),format.raw/*11.80*/("""">Add a UserImage</a>

  <div id="userImages">
	"""),_display_(Seq[Any](/*14.3*/for(image <- imageMap(item.id.get)) yield /*14.38*/ {_display_(Seq[Any](format.raw/*14.40*/("""
	<div>
		<img src=""""),_display_(Seq[Any](/*16.14*/image/*16.19*/.url)),format.raw/*16.23*/("""" />
		"""),_display_(Seq[Any](/*17.4*/image/*17.9*/.name)),format.raw/*17.14*/("""
	
	</div>
  </div>
	""")))})),format.raw/*21.3*/(""" 
	</div>
	""")))})),format.raw/*23.3*/("""
</div>

""")))})))}
    }
    
    def render(items:Seq[Item],user:User,imageMap:Map[Long, Seq[Image]]) = apply(items,user,imageMap)
    
    def f:((Seq[Item],User,Map[Long, Seq[Image]]) => play.api.templates.Html) = (items,user,imageMap) => apply(items,user,imageMap)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu May 03 14:43:38 CEST 2012
                    SOURCE: C:/repositories/play/test-app/app/views/collection/list.scala.html
                    HASH: c7c61f631bcf4802b3c69def1fc2dcc3f6551cbb
                    MATRIX: 545->1|687->66|724->69|735->73|773->75|833->100|865->111|938->150|971->168|1010->170|1092->217|1104->221|1131->227|1190->252|1201->256|1227->261|1266->265|1278->269|1302->272|1391->325|1406->331|1460->363|1547->415|1598->450|1638->452|1697->475|1711->480|1737->484|1781->493|1794->498|1821->503|1878->529|1923->543
                    LINES: 19->1|22->1|23->2|23->2|23->2|25->4|25->4|27->6|27->6|27->6|29->8|29->8|29->8|30->9|30->9|30->9|30->9|30->9|30->9|32->11|32->11|32->11|35->14|35->14|35->14|37->16|37->16|37->16|38->17|38->17|38->17|42->21|44->23
                    -- GENERATED --
                */
            