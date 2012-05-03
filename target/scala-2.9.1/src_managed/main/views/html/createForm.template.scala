
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
Seq[Any](format.raw/*1.24*/("""

"""),format.raw/*4.1*/("""
"""),format.raw/*5.75*/(""" 

"""),_display_(Seq[Any](/*7.2*/main/*7.6*/ {_display_(Seq[Any](format.raw/*7.8*/("""
    
    <h1>Add a Item</h1>
    
    """),_display_(Seq[Any](/*11.6*/form(routes.Application.save())/*11.37*/ {_display_(Seq[Any](format.raw/*11.39*/("""
        
        <fieldset>
        
            """),_display_(Seq[Any](/*15.14*/inputText(itemForm("name"), '_label -> "Item name"))),format.raw/*15.65*/("""
            """),_display_(Seq[Any](/*16.14*/inputText(itemForm("image"), '_label -> "Image"))),format.raw/*16.62*/("""
            """),_display_(Seq[Any](/*17.14*/inputText(itemForm("url"), '_label -> "Url "))),format.raw/*17.59*/("""
      		"""),_display_(Seq[Any](/*18.10*/inputText(itemForm("itemType"), '_label -> "itemType "))),format.raw/*18.65*/("""

            """),_display_(Seq[Any](/*20.14*/select(
                itemForm("company"), 
                Company.options, 
                '_label -> "Company", '_default -> "-- Choose a company --",
                '_showConstraints -> false
            ))),format.raw/*25.14*/("""
            

        </fieldset>
        
        <div class="actions">
            <input type="submit" value="Create this Item" class="btn primary"> or 
            <a href=""""),_display_(Seq[Any](/*32.23*/routes/*32.29*/.Application.list())),format.raw/*32.48*/("""" class="btn">Cancel</a> 
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
                    DATE: Thu May 03 11:07:00 CEST 2012
                    SOURCE: C:/repositories/play/test-app/app/views/createForm.scala.html
                    HASH: a2161dc2dbb2de4911cecb6c270e029c082cdd77
                    MATRIX: 514->1|622->48|654->72|733->23|763->45|792->121|832->127|843->131|881->133|960->177|1000->208|1040->210|1131->265|1204->316|1255->331|1325->379|1376->394|1443->439|1490->450|1567->505|1620->522|1860->740|2082->926|2097->932|2138->951|2227->1009
                    LINES: 19->1|22->5|22->5|23->1|25->4|26->5|28->7|28->7|28->7|32->11|32->11|32->11|36->15|36->15|37->16|37->16|38->17|38->17|39->18|39->18|41->20|46->25|53->32|53->32|53->32|56->35
                    -- GENERATED --
                */
            