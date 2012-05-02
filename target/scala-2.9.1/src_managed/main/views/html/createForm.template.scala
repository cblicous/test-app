
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
object createForm extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[Item],play.api.templates.Html] {

    /**/
    def apply/*1.2*/(itemForm: Form[Item]):play.api.templates.Html = {
        _display_ {import helper._

implicit def /*5.2*/implicitFieldConstructor/*5.26*/ = {{ FieldConstructor(twitterBootstrapInput.f) }};
Seq(format.raw/*1.24*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.75*/(""" 

"""),_display_(Seq(/*7.2*/main/*7.6*/ {_display_(Seq(format.raw/*7.8*/("""
    
    <h1>Add a Item</h1>
    
    """),_display_(Seq(/*11.6*/form(routes.Application.save())/*11.37*/ {_display_(Seq(format.raw/*11.39*/("""
        
        <fieldset>
        
            """),_display_(Seq(/*15.14*/inputText(itemForm("name"), '_label -> "Item name"))),format.raw/*15.65*/("""
            """),_display_(Seq(/*16.14*/inputText(itemForm("image"), '_label -> "Image"))),format.raw/*16.62*/("""
            """),_display_(Seq(/*17.14*/inputText(itemForm("url"), '_label -> "Url "))),format.raw/*17.59*/("""
      		"""),_display_(Seq(/*18.10*/inputText(itemForm("itemType"), '_label -> "itemType "))),format.raw/*18.65*/("""

            """),_display_(Seq(/*20.14*/select(
                itemForm("company"), 
                Company.options, 
                '_label -> "Company", '_default -> "-- Choose a company --",
                '_showConstraints -> false
            ))),format.raw/*25.14*/("""
            

        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Create this Item" class="btn primary"> or 
            <a href=""""),_display_(Seq(/*32.23*/routes/*32.29*/.Application.list())),format.raw/*32.48*/("""" class="btn">Cancel</a> 
        </div>
        
    """)))})),format.raw/*35.6*/("""
    
""")))})))}
    }
    
    def render(itemForm:Form[Item]) = apply(itemForm)
    
    def f:((Form[Item]) => play.api.templates.Html) = (itemForm) => apply(itemForm)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Apr 24 17:07:29 CEST 2012
                    SOURCE: /play-2.0/samples/scala/computer-database/app/views/createForm.scala.html
                    HASH: fc541d60429e69728ee1b2b7f4d037aaeab90fa4
                    MATRIX: 514->1|621->44|653->68|727->23|755->42|783->117|816->121|827->125|860->127|930->167|970->198|1005->200|1087->251|1160->302|1205->316|1275->364|1320->378|1387->423|1428->433|1505->488|1551->503|1786->716|1996->895|2011->901|2052->920|2138->975
                    LINES: 19->1|22->5|22->5|23->1|25->4|26->5|28->7|28->7|28->7|32->11|32->11|32->11|36->15|36->15|37->16|37->16|38->17|38->17|39->18|39->18|41->20|46->25|53->32|53->32|53->32|56->35
                    -- GENERATED --
                */
            