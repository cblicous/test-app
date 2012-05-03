
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
object editForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template2[Long,Form[Item],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(id: Long, itemForm: Form[Item]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.f) }};
Seq[Any](format.raw/*1.34*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.75*/("""

"""),_display_(Seq[Any](/*7.2*/main/*7.6*/ {_display_(Seq[Any](format.raw/*7.8*/("""
    
    <h1>Edit Item</h1>
    
    """),_display_(Seq[Any](/*11.6*/form(routes.Application.update(id))/*11.41*/ {_display_(Seq[Any](format.raw/*11.43*/("""
        
        <fieldset>
        
            """),_display_(Seq[Any](/*15.14*/inputText(itemForm("name"), '_label -> "Item name"))),format.raw/*15.65*/("""
            """),_display_(Seq[Any](/*16.14*/inputText(itemForm("url"), '_label -> "Url date"))),format.raw/*16.63*/("""
           	"""),_display_(Seq[Any](/*17.14*/inputText(itemForm("itemType"), '_label -> "itemType date"))),format.raw/*17.73*/("""
            """),_display_(Seq[Any](/*18.14*/inputText(itemForm("introduced"), '_label -> "introduced date"))),format.raw/*18.77*/("""
            
            """),_display_(Seq[Any](/*20.14*/select(
                itemForm("company"), 
                Company.options, 
                '_label -> "Company", '_default -> "-- Choose a company --",
                '_showConstraints -> false
            ))),format.raw/*25.14*/("""
        
        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Save this item" class="btn primary"> or 
            <a href=""""),_display_(Seq[Any](/*31.23*/routes/*31.29*/.Application.list())),format.raw/*31.48*/("""" class="btn">Cancel</a> 
        </div>
        
    """)))})),format.raw/*34.6*/("""
    
    """),_display_(Seq[Any](/*36.6*/form(routes.Application.delete(id), 'class -> "topRight")/*36.63*/ {_display_(Seq[Any](format.raw/*36.65*/("""
        <input type="submit" value="Delete this item" class="btn danger">
    """)))})),format.raw/*38.6*/("""
    
""")))})),format.raw/*40.2*/("""
"""))}
    }
    
    def render(id:Long,itemForm:Form[Item]) = apply(id,itemForm)
    
    def f:((Long,Form[Item]) => play.api.templates.Html) = (id,itemForm) => apply(id,itemForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu May 03 11:07:00 CEST 2012
                    SOURCE: C:/repositories/play/test-app/app/views/editForm.scala.html
                    HASH: f7b804294ef8cc5180715c0469b809d6fe13f8b3
                    MATRIX: 517->1|635->58|667->82|746->33|776->55|805->131|844->136|855->140|893->142|971->185|1015->220|1055->222|1146->277|1219->328|1270->343|1341->392|1392->407|1473->466|1524->481|1609->544|1674->573|1914->791|2128->969|2143->975|2184->994|2273->1052|2321->1065|2387->1122|2427->1124|2540->1206|2580->1215
                    LINES: 19->1|22->5|22->5|23->1|25->4|26->5|28->7|28->7|28->7|32->11|32->11|32->11|36->15|36->15|37->16|37->16|38->17|38->17|39->18|39->18|41->20|46->25|52->31|52->31|52->31|55->34|57->36|57->36|57->36|59->38|61->40
                    -- GENERATED --
                */
            