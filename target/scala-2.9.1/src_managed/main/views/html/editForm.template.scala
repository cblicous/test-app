
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
Seq(format.raw/*1.34*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.75*/("""

"""),_display_(Seq(/*7.2*/main/*7.6*/ {_display_(Seq(format.raw/*7.8*/("""
    
    <h1>Edit Item</h1>
    
    """),_display_(Seq(/*11.6*/form(routes.Application.update(id))/*11.41*/ {_display_(Seq(format.raw/*11.43*/("""
        
        <fieldset>
        
            """),_display_(Seq(/*15.14*/inputText(itemForm("name"), '_label -> "Item name"))),format.raw/*15.65*/("""
            """),_display_(Seq(/*16.14*/inputText(itemForm("url"), '_label -> "Url date"))),format.raw/*16.63*/("""
           	"""),_display_(Seq(/*17.14*/inputText(itemForm("itemType"), '_label -> "itemType date"))),format.raw/*17.73*/("""
            """),_display_(Seq(/*18.14*/inputText(itemForm("introduced"), '_label -> "introduced date"))),format.raw/*18.77*/("""
            
            """),_display_(Seq(/*20.14*/select(
                itemForm("company"), 
                Company.options, 
                '_label -> "Company", '_default -> "-- Choose a company --",
                '_showConstraints -> false
            ))),format.raw/*25.14*/("""
        
        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Save this item" class="btn primary"> or 
            <a href=""""),_display_(Seq(/*31.23*/routes/*31.29*/.Application.list())),format.raw/*31.48*/("""" class="btn">Cancel</a> 
        </div>
        
    """)))})),format.raw/*34.6*/("""
    
    """),_display_(Seq(/*36.6*/form(routes.Application.delete(id), 'class -> "topRight")/*36.63*/ {_display_(Seq(format.raw/*36.65*/("""
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
                    DATE: Tue Apr 24 17:07:29 CEST 2012
                    SOURCE: /play-2.0/samples/scala/computer-database/app/views/editForm.scala.html
                    HASH: e94a4f0e7cafaec0e9de57b1e18dd1965cec161c
                    MATRIX: 517->1|634->54|666->78|740->33|768->52|796->127|828->130|839->134|872->136|941->175|985->210|1020->212|1102->263|1175->314|1220->328|1291->377|1336->391|1417->450|1462->464|1547->527|1605->554|1840->767|2043->939|2058->945|2099->964|2185->1019|2226->1030|2292->1087|2327->1089|2438->1169|2476->1176
                    LINES: 19->1|22->5|22->5|23->1|25->4|26->5|28->7|28->7|28->7|32->11|32->11|32->11|36->15|36->15|37->16|37->16|38->17|38->17|39->18|39->18|41->20|46->25|52->31|52->31|52->31|55->34|57->36|57->36|57->36|59->38|61->40
                    -- GENERATED --
                */
            