
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

Seq(format.raw/*16.41*/("""
    <th class="col"""),_display_(Seq(/*17.20*/orderBy)),format.raw/*17.27*/(""" header """),_display_(Seq(/*17.36*/if(scala.math.abs(currentOrderBy) == orderBy){/*17.83*/{if(currentOrderBy < 0) "headerSortDown" else "headerSortUp"}})),format.raw/*17.144*/("""">
        <a href=""""),_display_(Seq(/*18.19*/link(0, Some(orderBy)))),format.raw/*18.41*/("""">"""),_display_(Seq(/*18.44*/title)),format.raw/*18.49*/("""</a>
    </th>
""")))};def /*6.2*/link/*6.6*/(newPage: Int, newOrderBy: Option[Int] = None) = {{
    routes.Application.list(newPage, newOrderBy.map { orderBy =>
        if(orderBy == scala.math.abs(currentOrderBy)) -currentOrderBy else orderBy
    }.getOrElse(currentOrderBy), currentFilter)
    
}};
Seq(format.raw/*1.145*/("""

"""),format.raw/*5.42*/("""
"""),format.raw/*11.2*/("""

"""),format.raw/*15.37*/("""
"""),format.raw/*20.2*/("""


"""),_display_(Seq(/*23.2*/main/*23.6*/ {_display_(Seq(format.raw/*23.8*/("""
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

    <h1>"""),_display_(Seq(/*54.10*/Messages("items.list.title", currentPage.total))),format.raw/*54.57*/("""</h1>

          <!-- """),format.raw/*61.25*/("""  --> 
       <a href=""""),_display_(Seq(/*62.18*/routes/*62.24*/.Collection.list())),format.raw/*62.42*/("""">View my Collection</a>
                  
    """),_display_(Seq(/*64.6*/flash/*64.11*/.get("success").map/*64.30*/ { message =>_display_(Seq(format.raw/*64.43*/("""
        <div class="alert-message warning">
            <strong>Done!</strong> """),_display_(Seq(/*66.37*/message)),format.raw/*66.44*/("""
        </div>
    """)))})),format.raw/*68.6*/("""

    <div id="actions">
        
        """),_display_(Seq(/*72.10*/helper/*72.16*/.form(action=routes.Application.list())/*72.55*/ {_display_(Seq(format.raw/*72.57*/("""
            <input type="search" id="searchbox" name="f" value=""""),_display_(Seq(/*73.66*/currentFilter)),format.raw/*73.79*/("""" placeholder="Filter by item name...">
            <input type="submit" id="searchsubmit" value="Filter by name" class="btn primary">
        """)))})),format.raw/*75.10*/("""
        
        <a class="btn primary" id="add" href=""""),_display_(Seq(/*77.48*/routes/*77.54*/.Application.create())),format.raw/*77.75*/("""">Add a new item</a>
        
    </div>
    
    """),_display_(Seq(/*81.6*/Option(currentPage.items)/*81.31*/.filterNot(_.isEmpty).map/*81.56*/ { items =>_display_(Seq(format.raw/*81.67*/("""
        
        <table class="items zebra-striped">
            <thead>
                <tr>
                    """),_display_(Seq(/*86.22*/header(2, "Item name"))),format.raw/*86.44*/("""
                    """),_display_(Seq(/*87.22*/header(3, "Introduced"))),format.raw/*87.45*/("""
                    """),_display_(Seq(/*88.22*/header(4, "url"))),format.raw/*88.38*/("""
                    """),_display_(Seq(/*89.22*/header(5, "image"))),format.raw/*89.40*/("""
                    <td></td>
                </tr>
            </thead>
            <tbody>

                """),_display_(Seq(/*95.18*/items/*95.23*/.map/*95.27*/ {/*96.21*/case (item, company) =>/*96.44*/ {_display_(Seq(format.raw/*96.46*/("""
                        <tr>
                            <td><a href=""""),_display_(Seq(/*98.43*/routes/*98.49*/.Application.edit(item.id.get))),format.raw/*98.79*/("""">"""),_display_(Seq(/*98.82*/item/*98.86*/.name)),format.raw/*98.91*/("""</a></td>
                            <td>
                                """),_display_(Seq(/*100.34*/item/*100.38*/.introduced.map(_.format("dd MMM yyyy")).getOrElse/*100.88*/ {_display_(Seq(format.raw/*100.90*/(""" <em>-</em> """)))})),format.raw/*100.103*/("""
                            </td>
                            <td>
                               <img src=" """),_display_(Seq(/*103.44*/item/*103.48*/.image)),format.raw/*103.54*/("""" border="0" />
                            </td>
                            <td>
                                """),_display_(Seq(/*106.34*/company/*106.41*/.map(_.name).getOrElse/*106.63*/ {_display_(Seq(format.raw/*106.65*/(""" <em>-</em> """)))})),format.raw/*106.78*/("""
                            </td>
                            <td>
         	                    """),_display_(Seq(/*109.32*/if(Item.isItemCollected(item.id.get,userEmail))/*109.79*/{_display_(Seq(format.raw/*109.80*/("""
		    	                   <a id="btnAdd"""),_display_(Seq(/*110.41*/item/*110.45*/.id.get)),format.raw/*110.52*/("""" class="btn primary" onClick="javascript:collectThisItem('"""),_display_(Seq(/*110.112*/routes/*110.118*/.Collection.add(item.id.get))),format.raw/*110.146*/("""',"""),_display_(Seq(/*110.149*/item/*110.153*/.id.get)),format.raw/*110.160*/(""")"  disabled="disabled"> Already Collect ! </button>
                                """)))}/*111.35*/else/*111.40*/{_display_(Seq(format.raw/*111.41*/("""
                	               <a id="btnAdd"""),_display_(Seq(/*112.47*/item/*112.51*/.id.get)),format.raw/*112.58*/("""" class="btn primary" onClick="javascript:collectThisItem('"""),_display_(Seq(/*112.118*/routes/*112.124*/.Collection.add(item.id.get))),format.raw/*112.152*/("""',"""),_display_(Seq(/*112.155*/item/*112.159*/.id.get)),format.raw/*112.166*/(""")">Collect ! </button>
                                """)))})),format.raw/*113.34*/("""                            </td>
                        </tr>
                    """)))}})),format.raw/*116.18*/("""

            </tbody>
        </table>

        <div id="pagination" class="pagination">
            <ul>
                """),_display_(Seq(/*123.18*/currentPage/*123.29*/.prev.map/*123.38*/ { page =>_display_(Seq(format.raw/*123.48*/("""
                    <li class="prev">
                        <a href=""""),_display_(Seq(/*125.35*/link(page))),format.raw/*125.45*/("""">&larr; Previous</a>
                    </li> 
                """)))}/*127.18*/.getOrElse/*127.28*/ {_display_(Seq(format.raw/*127.30*/("""
                    <li class="prev disabled">
                        <a>&larr; Previous</a>
                    </li>
                """)))})),format.raw/*131.18*/("""
                <li class="current">
                    <a>Displaying """),_display_(Seq(/*133.36*/(currentPage.offset + 1))),format.raw/*133.60*/(""" to """),_display_(Seq(/*133.65*/(currentPage.offset + items.size))),format.raw/*133.98*/(""" of """),_display_(Seq(/*133.103*/currentPage/*133.114*/.total)),format.raw/*133.120*/("""</a>
                </li>
                """),_display_(Seq(/*135.18*/currentPage/*135.29*/.next.map/*135.38*/ { page =>_display_(Seq(format.raw/*135.48*/("""
                    <li class="next">
                        <a href=""""),_display_(Seq(/*137.35*/link(page))),format.raw/*137.45*/("""">Next &rarr;</a>
                    </li> 
                """)))}/*139.18*/.getOrElse/*139.28*/ {_display_(Seq(format.raw/*139.30*/("""
                    <li class="next disabled">
                        <a>Next &rarr;</a>
                    </li>
                """)))})),format.raw/*143.18*/("""
            </ul>
        </div>
        
    """)))}/*147.6*/.getOrElse/*147.16*/ {_display_(Seq(format.raw/*147.18*/("""
        
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
                    DATE: Thu Apr 26 00:33:38 CEST 2012
                    SOURCE: /play-2.0/samples/scala/computer-database/app/views/list.scala.html
                    HASH: 3d0260fcc84991afaee05939d5ed063b72472b6f
                    MATRIX: 576->1|780->643|794->649|886->682|937->702|966->709|1006->718|1061->765|1146->826|1198->847|1242->869|1276->872|1303->877|1341->273|1352->277|1632->144|1661->271|1689->531|1719->641|1747->893|1781->897|1793->901|1827->903|1959->988|2084->1066|2273->1208|2430->1319|2516->1358|2641->1437|2696->1446|2747->1451|2800->1473|2869->1520|2919->1764|2974->1788|2989->1794|3029->1812|3108->1861|3122->1866|3150->1885|3196->1898|3308->1979|3337->1986|3389->2007|3463->2050|3478->2056|3526->2095|3561->2097|3658->2163|3693->2176|3869->2320|3957->2377|3972->2383|4015->2404|4096->2455|4130->2480|4164->2505|4208->2516|4355->2632|4399->2654|4452->2676|4497->2699|4550->2721|4588->2737|4641->2759|4681->2777|4824->2889|4838->2894|4851->2898|4862->2922|4894->2945|4929->2947|5032->3019|5047->3025|5099->3055|5133->3058|5146->3062|5173->3067|5281->3143|5295->3147|5355->3197|5391->3199|5438->3212|5581->3323|5595->3327|5624->3333|5772->3449|5789->3456|5821->3478|5857->3480|5903->3493|6034->3592|6091->3639|6126->3640|6199->3681|6213->3685|6243->3692|6336->3752|6353->3758|6405->3786|6441->3789|6456->3793|6487->3800|6593->3887|6607->3892|6642->3893|6721->3940|6735->3944|6765->3951|6858->4011|6875->4017|6927->4045|6963->4048|6978->4052|7009->4059|7098->4115|7217->4218|7373->4342|7394->4353|7413->4362|7457->4372|7562->4445|7595->4455|7681->4521|7701->4531|7737->4533|7908->4671|8013->4744|8060->4768|8097->4773|8153->4806|8191->4811|8213->4822|8243->4828|8319->4872|8340->4883|8359->4892|8403->4902|8508->4975|8541->4985|8623->5047|8643->5057|8679->5059|8846->5193|8913->5241|8933->5251|8969->5253|9107->5359|9151->5371
                    LINES: 19->1|21->16|21->16|23->16|24->17|24->17|24->17|24->17|24->17|25->18|25->18|25->18|25->18|27->6|27->6|33->1|35->5|36->11|38->15|39->20|42->23|42->23|42->23|48->29|52->33|57->38|61->42|63->44|65->46|67->48|69->50|73->54|73->54|75->61|76->62|76->62|76->62|78->64|78->64|78->64|78->64|80->66|80->66|82->68|86->72|86->72|86->72|86->72|87->73|87->73|89->75|91->77|91->77|91->77|95->81|95->81|95->81|95->81|100->86|100->86|101->87|101->87|102->88|102->88|103->89|103->89|109->95|109->95|109->95|109->96|109->96|109->96|111->98|111->98|111->98|111->98|111->98|111->98|113->100|113->100|113->100|113->100|113->100|116->103|116->103|116->103|119->106|119->106|119->106|119->106|119->106|122->109|122->109|122->109|123->110|123->110|123->110|123->110|123->110|123->110|123->110|123->110|123->110|124->111|124->111|124->111|125->112|125->112|125->112|125->112|125->112|125->112|125->112|125->112|125->112|126->113|128->116|135->123|135->123|135->123|135->123|137->125|137->125|139->127|139->127|139->127|143->131|145->133|145->133|145->133|145->133|145->133|145->133|145->133|147->135|147->135|147->135|147->135|149->137|149->137|151->139|151->139|151->139|155->143|159->147|159->147|159->147|165->153|168->156
                    -- GENERATED --
                */
            