<%@ page language="java" import="com.itz.bus.info.*,com.itz.bus.ws.*,in.vrllogistics.www.webs.WS.*,in.vrllogistics.www.webs.WS.Boarding_point,java.util.*" %>
<jsp:include page="Header.jsp" flush="true" />
<link href="<%=request.getContextPath()%>/css/TableTools.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/TableTools_JUI.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/modal.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/jquery.dataTables.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/javascript/TableTools.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/javascript/ZeroClipboard.js"></script>
<%
  VRLBusTicketDetailsInfo[] ticketDetailsInfos = null;
  if(request.getAttribute("ticketHistory") != null){
	  ticketDetailsInfos = (VRLBusTicketDetailsInfo[])request.getAttribute("ticketHistory");
	  
  }
  
  String fromDate = (String)request.getAttribute("fromDate");
  String toDate = (String)request.getAttribute("toDate");
  String status = (String)request.getAttribute("status");
%>
<script type="text/javascript">
	 
function validate()
{
	var fromDate = document.vrlReport.fromDate.value;
	var toDate = document.vrlReport.toDate.value;
	var status = document.vrlReport.status.value;	

	if(fromDate == ""){
		 alert("Select From Date");
	     return false;
	}
	if(toDate == ""){
		 alert("Select To Date");
	     return false;
	}
	if(status == ""){
		 alert("Select Status");
	     return false;
	}	
    return true;
}


function printReceipt(pnr){
	var url = '<%=request.getContextPath()%>/servlet/VRLBookingServiceServlet?submitAction=printTicket&pnrNo='+pnr;
	window.open(url,
								   'Print','width=600,height=400,scrollbars=yes,status=no,location=no',
						   'scrollbar=yes');
	}

function emailReceipt(pnr){
	document.email_form.conPnr.value = pnr;
	document.email_form.readOnly = true;
	
}

function validteEmail(){
	if(!(document.email_form.email.value.match(/^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z])+$/))){
		alert("Please enter a valid Email.");
		document.email_form.email.focus();
		return false;
	}
	if(!(document.email_form.conPnr.value != null)){
		alert("Please enter a valid PNR.");
		document.email_form.conPnr.focus();
		return false;
	}
}
</script>
<body>
<div class="hero">
  <div class="container">
    <div class="row">

 <a href="#x" class="overlay" id="email_form"></a>
        <div class="popup">
            <p>Please enter your details here</p>
            <form method="post" action="../servlet/VRLBookingServiceServlet" autocomplete="off" name="email_form" onsubmit="return validteEmail();">
            <input type="hidden" name="submitAction" value="emailTicket"> 
            <div>
                <label for="conPnr">PNR No.</label>
                <input id="conPnr" class="input-large"  type="text" maxLength="100" name="conPnr" size="20">
            </div>
            <div>
                <label for="email">Email Id</label>
                <input id="email" class="input-large" placeholder="Email Id"  type="text" maxLength="100" name="email" size="20">
            </div>            
            <button class="btn btn-primary" type="submit">Submit</button>
            </form>
            <a class="close" href="#close"></a>
        </div>


</div>
</div>
</div>
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
<form name="vrlReport" method="post" class="form-horizontal bs-docs-example" onsubmit="return validate();" action="<%=request.getContextPath()%>/servlet/VRLBookingServiceServlet">
<legend>Booking History</legend>
<fieldset>
	<div class="control-group">
	   	<label class="control-label" for="datepicker">From Date<font color="red">*</font></label>
	  		<div class="controls">
	  			
	  			<input type="text" id="from" name="fromDate" value="<%=( fromDate != null ? fromDate : "")%>"/>
	  		</div> 
  	</div>
  	<div class="control-group">
	   	<label class="control-label" for="toDate">To Date<font color="red">*</font></label>
	  		<div class="controls">
	  			<input type="text" id="to" name="toDate" value="<%=( toDate != null ? toDate : "")%>"/>
	  		</div> 
  	</div>
  	<div class="control-group">
	   	<label class="control-label" for="toDate">Ticket Type<font color="red">*</font></label>
	  		<div class="controls">
	  			<select name="status">
	  			  <option value="A" <%=((status != null && status.equalsIgnoreCase("A")) ? "selected" : "")%>>All</option>
	  			  <option value="S" <%=((status != null && status.equalsIgnoreCase("S")) ? "selected" : "")%>>Booked</option>
	  			  <option value="C" <%=((status != null && status.equalsIgnoreCase("C")) ? "selected" : "")%>>Canceled</option>
	  			  <option value="P" <%=((status != null && status.equalsIgnoreCase("P")) ? "selected" : "")%>>Pending</option>
	  			</select>
	  		</div> 
  	</div>
  	<div class="control-group">
  		<div class="controls">
  		<input type="submit" value="Search" name="Search" class="btn btn-warning">
          <input type="reset" name="submit" value="Reset" class="btn btn-warning">
    	</div>
	</div>
</fieldset>


<%if(ticketDetailsInfos != null){ %>
<script type="text/javascript" charset="utf-8">
	jq(document).ready(function() {
		//jq('#example').dataTable();

		jq('#example').dataTable( {
			"sDom": 'T<"clear">lfrtip',
			"oTableTools": {
				"sSwfPath": "../swf/copy_csv_xls_pdf.swf"
			}
		} );
		
	} );
</script>
<table cellpadding="0" cellspacing="0" border="0" class="display" id="example" width="100%">
<thead>
	<tr align="center">	
	    <th>Sr.No</th>	
	    <th>PNR</th>							
		<th>J.Source</th>
		<th>J.Destination</th>		
		<th>Booking Time</th>											
		<th>Journey Date Time</th>
		<th>Fare</th>
		<th></th>
	 </tr>
</thead>
<tbody>
<%
for(int i=0; i<ticketDetailsInfos.length; i++)
{
	String rowClass = (((i%2) == 0) ? "even gradeC" : "odd gradeX");
%>
	<tr align="center"  class="<%=rowClass%>">
		<td><%=i+1%></td>									
		<td>
		<% if(ticketDetailsInfos[i].getStatus() != null && ticketDetailsInfos[i].getStatus().equalsIgnoreCase("S")){  %>
			<%=ticketDetailsInfos[i].getConfirmPNR() != null ? ticketDetailsInfos[i].getConfirmPNR() : ""%>
		<%}%>
		<% if(ticketDetailsInfos[i].getStatus() != null && ticketDetailsInfos[i].getStatus().equalsIgnoreCase("P")){  %>
			<%=ticketDetailsInfos[i].getTempPNR() != null ? ticketDetailsInfos[i].getTempPNR() : ""%>
		<%}%>
		
		</td>
		<td><%=ticketDetailsInfos[i].getSource()%></td>
		<td><%=ticketDetailsInfos[i].getDestination()%></td>
		<td><%=ticketDetailsInfos[i].getRequestdate()%></td>
		<td><%=ticketDetailsInfos[i].getJourneydatetime()%></td>
		<td><%=new java.text.DecimalFormat("0.00").format((double)ticketDetailsInfos[i].getTotalfare()/100)%></td>
		<td>
		<% if(ticketDetailsInfos[i].getStatus() != null && ticketDetailsInfos[i].getStatus().equalsIgnoreCase("S")){  %>
			<a class="btn btn-warning"  href="#" onclick="printReceipt(<%=ticketDetailsInfos[i].getConfirmPNR()%>)">Print ticket</a>
			<a class="btn btn-warning"  href="#email_form" onclick="emailReceipt(<%=ticketDetailsInfos[i].getConfirmPNR()%>)">Email ticket</a>
		<%}%>
		<% if(ticketDetailsInfos[i].getStatus() != null && ticketDetailsInfos[i].getStatus().equalsIgnoreCase("P")){  %>
			Pending
		<%}%>
		<% if(ticketDetailsInfos[i].getStatus() != null && ticketDetailsInfos[i].getStatus().equalsIgnoreCase("C")){  %>
			Canceled - CNR No - <%=ticketDetailsInfos[i].getCnrNo()%>, Refund Amount - <%=new java.text.DecimalFormat("0.00").format((double)ticketDetailsInfos[i].getRefundAmount()/100)%>
		<%}%>
		</td>
	</tr>
<%}%>
</tbody>
</table> 
<%} %> 
		
<input type="hidden" name="submitAction" value="tktHistory"> 
</form>
</div>
</div>
</body>
<script src="<%=request.getContextPath()%>/javascript/bootstrap.js"></script>
<script src="<%=request.getContextPath()%>/javascript/jquery-ui.js"></script>
<script language="javascript" type="text/javascript">

jq(function() {
	jq( "#from" ).datepicker({
		dateFormat: "dd/mm/yy",
		showOn: "button",
		buttonImage: "<%=request.getContextPath()%>/images/calendar.gif",
		buttonImageOnly: true,
		onClose: function( selectedDate ) {
		jq( "#to" ).datepicker( "option", "minDate", selectedDate );
		}
	});
	jq( "#to" ).datepicker({
		dateFormat: "dd/mm/yy",
		showOn: "button",
		buttonImage: "<%=request.getContextPath()%>/images/calendar.gif",
		buttonImageOnly: true,
		onClose: function( selectedDate ) {
		jq( "#from" ).datepicker( "option", "maxDate", selectedDate );
		}
	});
});
</script>
<style type="text/css">
	div.ui-datepicker{
	font-size:10px;
	}
</style>
<jsp:include page="Footer.jsp" flush="true" />