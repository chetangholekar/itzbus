<%@ page language="java" import="com.itz.bus.info.*,com.itz.bus.ws.*,in.vrllogistics.www.webs.WS.Journey,in.vrllogistics.www.webs.WS.Boarding_point,java.util.*" %>
<%

	String srcStation = null;
	String destStation = null;
	String srcStationName = null;
	String destStationName = null;
	
	String journeyDate = (String)request.getAttribute("jrnyDate");
	srcStation = (String)request.getAttribute("sourceStation");
	destStation = (String)request.getAttribute("destStation");
	srcStationName = (String)request.getAttribute("sourceStationName");
	destStationName = (String)request.getAttribute("destStationName");
	
	if(srcStation == null || destStation == null){
		session.removeAttribute("getAvailBusDetails");
	}
	session.removeAttribute("tktDtlInfo");
	VRLJourneyInfo[] jrny = (VRLJourneyInfo[])session.getAttribute("getAvailBusDetails");
	
%>
<jsp:include page="Header.jsp" flush="true" />
<body onload="getVRLSourceStation()">
<%
if(request.getAttribute("success")!= null){
%>
	<div class="alert fade in">
	        <button data-dismiss="alert" class="close" type="button">&times;</button>
	    <font color="green" size="2" face="Arial, Helvetica, sans-serif"><b><%=request.getAttribute("success")%></b></font>
	</div>
<%
}else if(request.getAttribute("msg") != null){
%>
	<div class="alert fade in">
	        <button data-dismiss="alert" class="close" type="button">&times;</button>
	    <font color="#FF0000" size="2" face="Arial, Helvetica, sans-serif"><b><%=request.getAttribute("msg")%></b></font>
	</div>
	<%}%>
<div class="hero-unit">
<div class="radious"> 
<script type='text/javascript' src='../dwr/interface/ItzBus.js'></script>
<script type='text/javascript' src='../dwr/engine.js'></script>
<script type='text/javascript' src='../dwr/util.js'></script>
<script language="javascript" src="<%=request.getContextPath()%>/javascript/dwr.js"></script>
<script language="javascript" src="<%=request.getContextPath()%>/javascript/jquery.dataTables.js"></script>
<script>
function validate()
{
    var sourceStation = document.vrlHome.source_station.value;
    var destStation = document.vrlHome.dest_station.value;
    var journeyDate = document.vrlHome.journey_Date.value;

    if(sourceStation == "")
    {
        alert("Select source station");
        document.vrlHome.source_station.focus();
        return false;
    }
    else if(destStation == "")
    {
        alert("Select destination station");
        document.vrlHome.dest_station.focus();
        return false;
    }
    else if(journeyDate == "")
    {
        alert("Select Date of journey");
        var matches = /^(\d{2})[-\/](\d{2})[-\/](\d{4})$/.exec(journeyDate);
        if (matches == null) return false;
        var d = matches[2];
        var m = matches[1] - 1;
        var y = matches[3];
        var composedDate = new Date(y, m, d);
        var flag =  composedDate.getDate() == d && composedDate.getMonth() == m && composedDate.getFullYear() == y;

        document.vrlHome.journey_Date.focus();
        return false;
    }
    else{ 
		var submitfile;
		submitfile = "../servlet/VRLBookingServiceServlet";
		document.vrlHome.submitAction.value = "SearchAvailBus";
		document.vrlHome.srcStnName.value = DWRUtil.getText("source_station");
		document.vrlHome.destStnName.value = DWRUtil.getText("dest_station");
		document.forms[0].action = submitfile;
    }
	
}
function bookValidate(Id)
{
	 	var flag = false; 
	    var boardingpoint = "boardingPoint"+Id;
	    for (i = 0; i < document.getElementsByName("seatDet"+Id).length; i++)
    	{
	      	
    		if(document.getElementsByName("seatDet"+Id)[i].checked == true)
    		{
	      		flag=true;
	      	} 
    	}	
 
        
	   if(flag == false){
	      alert("Please Select Atleast one seat");
	      return false;
	   }
	   else{

		   if(document.getElementById(boardingpoint).value == "")
		   {
			   alert("Please Select boarding point");
			      return false;
		   }
		   else
		   {
			    var submitfile;
				submitfile = "../servlet/VRLBookingServiceServlet?Id="+Id;
				document.vrlHome.submitAction.value = "bookTicketDetails";
				document.forms[0].action = submitfile;
		   }
	   }
	
}

function fnFormatDetails ( oTable, nTr )
{
	var aData = oTable.fnGetData( nTr );
	var callUrl = "../servlet/VRLBookingServiceServlet?submitAction=GetBusDetailsByString&busType="+aData[7]+"&jrnyId="+aData[8];
	//var ret = jq.ajax({ url: callUrl,async: false}).responseText;
	
	var request = jq.ajax({ url: callUrl,async: false});
	var ret = request.responseText;
	//request.readyState;
    //alert('1');
    //alert(ret);
   // alert('readyState'+request.readyState);
   // alert('status'+request.status);
	
	var sOut = ret;
	return sOut;
}

jq(document).ready(function() {
	/*
	 * Insert a 'details' column to the table
	 */
	var nCloneTh = document.createElement( 'th' );
	var nCloneTd = document.createElement( 'td' );
	nCloneTd.innerHTML = '<img src="<%=request.getContextPath()%>/images/details_open.png">';
	nCloneTd.className = "center";
	
	jq('#example thead tr').each( function () {
		this.insertBefore( nCloneTh, this.childNodes[0] );
	} );
	
	jq('#example tbody tr').each( function () {
		this.insertBefore(  nCloneTd.cloneNode( true ), this.childNodes[0] );
	} );

	//
	
	/*
	 * Initialse DataTables, with no sorting on the 'details' column
	 */
	var oTable = jq('#example').dataTable( {
		"aoColumnDefs": [
			{ "bSortable": false, "aTargets": [ 0 ] }
		],
		"aaSorting": [[1, 'asc']],
		"aoColumns": [null,null,null,null,null,null,null,{"bVisible": false},{"bVisible": false}],
		"bPaginate": false
		
	});
	
	/* Add event listener for opening and closing details
	 * Note that the indicator for showing which row is open is not controlled by DataTables,
	 * rather it is done here
	 */
	jq('#example tbody td img').live('click', function () {
		var nTr = jq(this).parents('tr')[0];
		if ( oTable.fnIsOpen(nTr) )
		{
			/* This row is already open - close it */
			this.src = "<%=request.getContextPath()%>/images/details_open.png";
			oTable.fnClose( nTr );
		}
		else
		{
			/* Open this row */
			this.src = "<%=request.getContextPath()%>/images/details_close.png";
			oTable.fnOpen( nTr, fnFormatDetails(oTable, nTr), 'details' );
		}
	} );


	
} );

function getTodaysDate (val) {
    var t = new Date, day, month, year = t.getFullYear();
    if (t.getDate() < 10) {
        day = "0" + t.getDate();
    }
    else {
        day = t.getDate();
    }
    if ((t.getMonth() + 1) < 10) {
        month = "0" + (t.getMonth() + 1 - val);
    }
    else {
        month = t.getMonth() + 1 - val;
    }

    return (day + '/' + month + '/' + year);
   }


</script>
<legend>Book Ticket</legend>
<form name="vrlHome" method="post">
<fieldset>
		<div class="control-group">
		    	<label class="control-label" for="source_station">Source Station </label>
	    		<div class="controls">
	    			<select name="source_station" id="source_station" onchange="getVRLDestinationStation();">
	    				<option value="<%=srcStation%>"></option>
	    			</select>
	    		</div> 
	   	</div>
	   	<div class="control-group">
		    	<label class="control-label" for="dest_station">Destination Station </label>
	    		<div class="controls">
	    			<select name="dest_station" id="dest_station">
	    				<option  value="<%=destStation%>"></option>
	    			</select>
	    		</div> 
	   	</div>
	   	<div class="control-group">
		    	<label class="control-label" for="datepicker">Journey Date </label>
	    		<div class="controls">
	    			<input type="text" name="journey_Date" id="datepicker" value="<%=((journeyDate!=null)?journeyDate:"")%>" autocomplete="off" size="12">
	    		</div> 
	   	</div>
	   	<div class="control-group">
		    	<div class="controls">
	    			<input name="submit" value="Search" width="50" type="submit" onclick="return validate();" class="btn btn-warning">
	    			<input type="hidden" name="srcStnName" id="srcStnName" value="<%=srcStationName%>"></input>
	    			<input type="hidden" name="destStnName" id="destStnName" value="<%=destStationName%>"></input>
	    			<input type="hidden" name="srcStationId" id="srcStationId" value="<%=srcStation%>"></input>
	    			<input type="hidden" name="destStationId" id="destStationId" value="<%=destStation%>"></input>
	    		</div> 
	   	</div>
</fieldset>	
<%if(jrny != null){ %>
<script type="text/javascript" charset="utf-8">
	jq(document).ready(function() {
		jq('#example').dataTable();
	} );
</script>
<table cellpadding="0" cellspacing="0" border="0" class="display" id="example" width="100%">
<thead>
	<tr align="center">									
		<th>J.Source</th>
		<th>J.Destination</th>													
		<th>Boarding</th>
		<th>Duration</th>
		<th>Bus Type</th>
		<th>Available Seat</th>
		<th>Bus Type</th>
		<th>Index</th>
	 </tr>
</thead>
<tbody>
<%
for(int i=0;i<jrny.length;i++)
{
	if(jrny[i] != null){
		String rowClass = (((i%2) == 0) ? "even gradeC" : "odd gradeX");
		int totalMinutes = jrny[i].getJourney_min(); 
		int hours = (int) totalMinutes/60;     
		int minutes = (int)totalMinutes%60;  
		String duration = hours +":"+ minutes +" hrs";
	
%>
	<tr align="center"  class="<%=rowClass%>">									
		<td><%=srcStationName%></td>
		<td><%=destStationName%></td>													
		<td><%=jrny[i].getBoarding_points()[0].getBoarding_point_time()%></td>
		<td><%=duration%></td>
		<td align="left"><%=jrny[i].getBus_type()%></td>
		<td><%=jrny[i].getNo_of_seats_available()%></td>
		<td><%=jrny[i].getBus_id()%></td>
		<td><%=i%></td>
	</tr>
<%} }%>
</tbody>
</table> 
<%} %> 
<br>
<input type="hidden" name="submitAction" value=""/>
</form>
</body>
<script src="<%=request.getContextPath()%>/javascript/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/javascript/jquery-ui.js"></script>
<script language="javascript" type="text/javascript">
jq(function() {
	jq( "#datepicker" ).datepicker({ minDate: -0, numberOfMonths: 2,dateFormat: "dd/mm/yy" }).val(getTodaysDate(0));;
	jq( document ).tooltip();

});

</script>

<style type="text/css">
	div.ui-datepicker{
	font-size:10px;
	}
</style>


<jsp:include page="Footer.jsp" flush="true" />