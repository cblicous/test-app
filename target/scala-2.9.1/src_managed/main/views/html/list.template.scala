
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
object list extends BaseScalaTemplate[play.api.templates.Html,Format[play.api.templates.Html]](play.api.templates.HtmlFormat) with play.api.templates.Template5[String,Page[scala.Tuple2[Item, Option[Company]]],Int,String,play.api.mvc.Flash,play.api.templates.Html] {

    /**/
    def apply/*1.2*/(userEmail : String,currentPage: Page[(Item, Option[Company])], currentOrderBy: Int, currentFilter: String)(implicit flash: play.api.mvc.Flash):play.api.templates.Html = {
        _display_ {
def /*16.2*/header/*16.8*/(orderBy: Int, title: String):play.api.templates.Html = {_display_(

Seq[Any](format.raw/*16.41*/("""
    <th class="col"""),_display_(Seq[Any](/*17.20*/orderBy)),format.raw/*17.27*/(""" header """),_display_(Seq[Any](/*17.36*/if(scala.math.abs(currentOrderBy) == orderBy){/*17.83*/{if(currentOrderBy < 0) "headerSortDown" else "headerSortUp"}})),format.raw/*17.144*/("""">
        <a href=""""),_display_(Seq[Any](/*18.19*/link(0, Some(orderBy)))),format.raw/*18.41*/("""">"""),_display_(Seq[Any](/*18.44*/title)),format.raw/*18.49*/("""</a>
    </th>
""")))};def /*6.2*/link/*6.6*/(newPage: Int, newOrderBy: Option[Int] = None) = {{
    routes.Application.list(newPage, newOrderBy.map { orderBy =>
        if(orderBy == scala.math.abs(currentOrderBy)) -currentOrderBy else orderBy
    }.getOrElse(currentOrderBy), currentFilter)
    
}};
Seq[Any](format.raw/*1.145*/("""

"""),format.raw/*5.42*/("""
"""),format.raw/*11.2*/("""

"""),format.raw/*15.37*/("""
"""),format.raw/*20.2*/("""


"""),_display_(Seq[Any](/*23.2*/main/*23.6*/ {_display_(Seq[Any](format.raw/*23.8*/("""
<script type="text/javascript">
<!--

//-->

function collectThisItem(item_url,id) """),format.raw("""{"""),format.raw/*29.40*/("""
//$("#autosaveUpdates").html("Saving ... ");
methodURL = item_url
	
	$.ajax("""),format.raw("""{"""),format.raw/*33.10*/("""
	    type: "GET",
	    contentType: "application/text; charset=utf-8",
	    url: methodURL,
	    async: true,
	    success: function (data) """),format.raw("""{"""),format.raw/*38.32*/("""
	    	button = $("#btnAdd"+id);
	    	button.attr("disabled","disabled");
	    	button.html("added !");
	    """),format.raw("""}"""),format.raw/*42.7*/(""",
	    
	    error: function (result) """),format.raw("""{"""),format.raw/*44.32*/("""
	        alert("Due to unexpected errors we were unable to load data");
	    """),format.raw("""}"""),format.raw/*46.7*/("""
	    
	"""),format.raw("""}"""),format.raw/*48.3*/(""");

"""),format.raw("""}"""),format.raw/*50.2*/("""

</script>

    <h1>"""),_display_(Seq[Any](/*54.10*/Messages("items.list.title", currentPage.total))),format.raw/*54.57*/("""</h1>

          <!-- """),format.raw/*61.25*/("""  --> 
       <a href=""""),_display_(Seq[Any](/*62.18*/routes/*62.24*/.Collection.list())),format.raw/*62.42*/("""">View my Collection</a>
                  
    """),_display_(Seq[Any](/*64.6*/flash/*64.11*/.get("success").map/*64.30*/ { message =>_display_(Seq[Any](format.raw/*64.43*/("""
        <div class="alert-message warning">
            <strong>Done!</strong> """),_display_(Seq[Any](/*66.37*/message)),format.raw/*66.44*/("""
        </div>
    """)))})),format.raw/*68.6*/("""

    <div id="actions">
        
        """),_display_(Seq[Any](/*72.10*/helper/*72.16*/.form(action=routes.Application.list())/*72.55*/ {_display_(Seq[Any](format.raw/*72.57*/("""
            <input type="search" id="searchbox" name="f" value=""""),_display_(Seq[Any](/*73.66*/currentFilter)),format.raw/*73.79*/("""" placeholder="Filter by item name...">
            <input type="submit" id="searchsubmit" value="Filter by name" class="btn primary">
        """)))})),format.raw/*75.10*/("""
        
        <a class="btn primary" id="add" href=""""),_display_(Seq[Any](/*77.48*/routes/*77.54*/.Application.create())),format.raw/*77.75*/("""">Add a new item</a>
        
    </div>
    
    """),_display_(Seq[Any](/*81.6*/Option(currentPage.items)/*81.31*/.filterNot(_.isEmpty).map/*81.56*/ { items =>_display_(Seq[Any](format.raw/*81.67*/("""
        
        <table class="items zebra-striped">
            <thead>
                <tr>
                    """),_display_(Seq[Any](/*86.22*/header(2, "Item name"))),format.raw/*86.44*/("""
                    """),_display_(Seq[Any](/*87.22*/header(3, "Introduced"))),format.raw/*87.45*/("""
                    """),_display_(Seq[Any](/*88.22*/header(4, "url"))),format.raw/*88.38*/("""
                    """),_display_(Seq[Any](/*89.22*/header(5, "image"))),format.raw/*89.40*/("""
                    <td></td>
                </tr>
            </thead>
            <tbody>

                """),_display_(Seq[Any](/*95.18*/items/*95.23*/.map/*95.27*/ {/*96.21*/case (item, company) =>/*96.44*/ {_display_(Seq[Any](format.raw/*96.46*/("""
                        <tr>
                            <td><a href=""""),_display_(Seq[Any](/*98.43*/routes/*98.49*/.Application.edit(item.id.get))),format.raw/*98.79*/("""">"""),_display_(Seq[Any](/*98.82*/item/*98.86*/.name)),format.raw/*98.91*/("""</a></td>
                            <td>
                                """),_display_(Seq[Any](/*100.34*/item/*100.38*/.introduced.map(_.format("dd MMM yyyy")).getOrElse/*100.88*/ {_display_(Seq[Any](format.raw/*100.90*/(""" <em>-</em> """)))})),format.raw/*100.103*/("""
                            </td>
                            <td>
                               <img src=" """),_display_(Seq[Any](/*103.44*/item/*103.48*/.image)),format.raw/*103.54*/("""" border="0" />
                            </td>
                            <td>
                                """),_display_(Seq[Any](/*106.34*/company/*106.41*/.map(_.name).getOrElse/*106.63*/ {_display_(Seq[Any](format.raw/*106.65*/(""" <em>-</em> """)))})),format.raw/*106.78*/("""
                            </td>
                            <td>
         	                    """),_display_(Seq[Any](/*109.32*/if(Item.isItemCollected(item.id.get,userEmail))/*109.79*/{_display_(Seq[Any](format.raw/*109.80*/("""
		    	                   <a id="btnAdd"""),_display_(Seq[Any](/*110.41*/item/*110.45*/.id.get)),format.raw/*110.52*/("""" class="btn primary" onClick="javascript:collectThisItem('"""),_display_(Seq[Any](/*110.112*/routes/*110.118*/.Collection.add(item.id.get))),format.raw/*110.146*/("""',"""),_display_(Seq[Any](/*110.149*/item/*110.153*/.id.get)),format.raw/*110.160*/(""")"  disabled="disabled"> Already Collect ! </button>
                                """)))}/*111.35*/else/*111.40*/{_display_(Seq[Any](format.raw/*111.41*/("""
                	               <a id="btnAdd"""),_display_(Seq[Any](/*112.47*/item/*112.51*/.id.get)),format.raw/*112.58*/("""" class="btn primary" onClick="javascript:collectThisItem('"""),_display_(Seq[Any](/*112.118*/routes/*112.124*/.Collection.add(item.id.get))),format.raw/*112.152*/("""',"""),_display_(Seq[Any](/*112.155*/item/*112.159*/.id.get)),format.raw/*112.166*/(""")">Collect ! </button>
                                """)))})),format.raw/*113.34*/("""                            </td>
                        </tr>
                    """)))}})),format.raw/*116.18*/("""

            </tbody>
        </table>

        <div id="pagination" class="pagination">
            <ul>
                """),_display_(Seq[Any](/*123.18*/currentPage/*123.29*/.prev.map/*123.38*/ { page =>_display_(Seq[Any](format.raw/*123.48*/("""
                    <li class="prev">
                        <a href=""""),_display_(Seq[Any](/*125.35*/link(page))),format.raw/*125.45*/("""">&larr; Previous</a>
                    </li> 
                """)))}/*127.18*/.getOrElse/*127.28*/ {_display_(Seq[Any](format.raw/*127.30*/("""
                    <li class="prev disabled">
                        <a>&larr; Previous</a>
                    </li>
                """)))})),format.raw/*131.18*/("""
                <li class="current">
                    <a>Displaying """),_display_(Seq[Any](/*133.36*/(currentPage.offset + 1))),format.raw/*133.60*/(""" to """),_display_(Seq[Any](/*133.65*/(currentPage.offset + items.size))),format.raw/*133.98*/(""" of """),_display_(Seq[Any](/*133.103*/currentPage/*133.114*/.total)),format.raw/*133.120*/("""</a>
                </li>
                """),_display_(Seq[Any](/*135.18*/currentPage/*135.29*/.next.map/*135.38*/ { page =>_display_(Seq[Any](format.raw/*135.48*/("""
                    <li class="next">
                        <a href=""""),_display_(Seq[Any](/*137.35*/link(page))),format.raw/*137.45*/("""">Next &rarr;</a>
                    </li> 
                """)))}/*139.18*/.getOrElse/*139.28*/ {_display_(Seq[Any](format.raw/*139.30*/("""
                    <li class="next disabled">
                        <a>Next &rarr;</a>
                    </li>
                """)))})),format.raw/*143.18*/("""
            </ul>
        </div>
        
    """)))}/*147.6*/.getOrElse/*147.16*/ {_display_(Seq[Any](format.raw/*147.18*/("""
        
        <div class="well">
            <em>Nothing to display</em>
        </div>
        
    """)))})),format.raw/*153.6*/("""

        
""")))})),format.raw/*156.2*/("""

            """))}
    }
    
    def render(userEmail:String,currentPage:Page[scala.Tuple2[Item, Option[Company]]],currentOrderBy:Int,currentFilter:String,flash:play.api.mvc.Flash) = apply(userEmail,currentPage,currentOrderBy,currentFilter)(flash)
    
    def f:((String,Page[scala.Tuple2[Item, Option[Company]]],Int,String) => (play.api.mvc.Flash) => play.api.templates.Html) = (userEmail,currentPage,currentOrderBy,currentFilter) => (flash) => apply(userEmail,currentPage,currentOrderBy,currentFilter)(flash)
    
    def ref = this

}
                /*
                    -- GENERATED --
                    DATE: Thu May 03 11:07:00 CEST 2012
                    SOURCE: C:/repositories/play/test-app/app/views/list.scala.html
                    HASH: b734e7abac57c9e1cea00c6ff0c88a8e9a9f285e
                    MATRIX: 576->1|780->658|794->664|891->697|948->718|977->725|1022->734|1077->781|1162->842|1220->864|1264->886|1303->889|1330->894|1370->278|1381->282|1671->144|1702->275|1731->541|1763->655|1792->912|1834->919|1846->923|1885->925|2023->1016|2152->1098|2346->1245|2507->1360|2595->1401|2722->1482|2779->1493|2832->1500|2894->1526|2963->1573|3015->1824|3076->1849|3091->1855|3131->1873|3217->1924|3231->1929|3259->1948|3310->1961|3429->2044|3458->2051|3512->2074|3595->2121|3610->2127|3658->2166|3698->2168|3801->2235|3836->2248|4014->2394|4109->2453|4124->2459|4167->2480|4257->2535|4291->2560|4325->2585|4374->2596|4531->2717|4575->2739|4634->2762|4679->2785|4738->2808|4776->2824|4835->2847|4875->2865|5029->2983|5043->2988|5056->2992|5067->3017|5099->3040|5139->3042|5249->3116|5264->3122|5316->3152|5355->3155|5368->3159|5395->3164|5510->3242|5524->3246|5584->3296|5625->3298|5672->3311|5823->3425|5837->3429|5866->3435|6022->3554|6039->3561|6071->3583|6112->3585|6158->3598|6297->3700|6354->3747|6394->3748|6473->3790|6487->3794|6517->3801|6615->3861|6632->3867|6684->3895|6725->3898|6740->3902|6771->3909|6878->3997|6892->4002|6932->4003|7017->4051|7031->4055|7061->4062|7159->4122|7176->4128|7228->4156|7269->4159|7284->4163|7315->4170|7405->4227|7526->4333|7694->4464|7715->4475|7734->4484|7783->4494|7895->4569|7928->4579|8016->4647|8036->4657|8077->4659|8252->4801|8364->4876|8411->4900|8453->4905|8509->4938|8552->4943|8574->4954|8604->4960|8687->5006|8708->5017|8727->5026|8776->5036|8888->5111|8921->5121|9005->5185|9025->5195|9066->5197|9237->5335|9308->5387|9328->5397|9369->5399|9513->5511|9560->5526
                    LINES: 19->1|21->16|21->16|23->16|24->17|24->17|24->17|24->17|24->17|25->18|25->18|25->18|25->18|27->6|27->6|33->1|35->5|36->11|38->15|39->20|42->23|42->23|42->23|48->29|52->33|57->38|61->42|63->44|65->46|67->48|69->50|73->54|73->54|75->61|76->62|76->62|76->62|78->64|78->64|78->64|78->64|80->66|80->66|82->68|86->72|86->72|86->72|86->72|87->73|87->73|89->75|91->77|91->77|91->77|95->81|95->81|95->81|95->81|100->86|100->86|101->87|101->87|102->88|102->88|103->89|103->89|109->95|109->95|109->95|109->96|109->96|109->96|111->98|111->98|111->98|111->98|111->98|111->98|113->100|113->100|113->100|113->100|113->100|116->103|116->103|116->103|119->106|119->106|119->106|119->106|119->106|122->109|122->109|122->109|123->110|123->110|123->110|123->110|123->110|123->110|123->110|123->110|123->110|124->111|124->111|124->111|125->112|125->112|125->112|125->112|125->112|125->112|125->112|125->112|125->112|126->113|128->116|135->123|135->123|135->123|135->123|137->125|137->125|139->127|139->127|139->127|143->131|145->133|145->133|145->133|145->133|145->133|145->133|145->133|147->135|147->135|147->135|147->135|149->137|149->137|151->139|151->139|151->139|155->143|159->147|159->147|159->147|165->153|168->156
                    -- GENERATED --
                */
            