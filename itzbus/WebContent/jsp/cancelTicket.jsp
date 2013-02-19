<%@ page language="java" import="com.itz.bus.info.*,com.itz.bus.ws.*,in.vrllogistics.www.webs.WS.*,in.vrllogistics.www.webs.WS.Boarding_point,java.util.*" %>
<jsp:include page="Header.jsp" flush="true" />
<%      
		VRLBusTicketDetailsInfo vrlBustktDtlInfo = null;
        Cancell_ticket_result cancellTicketResult = null;
        String processStep = null;
		String back = null;
		vrlBustktDtlInfo = (VRLBusTicketDetailsInfo)request.getAttribute("busTicketDetailsInfo");
		cancellTicketResult = (Cancell_ticket_result)request.getAttribute("successResult");
%>
<script type="text/javascript">
	 
	 function SubmitForm(evt) {
	    var evt = evt || window.event; // event object
	    var target = evt.target || window.event.srcElement; // event target
	    var targetID = target.getAttribute("id"); // event target id
	    var submitfile;
		
		if(targetID == "doCancellation"){

			var submitfile = "../servlet/VRLBookingServiceServlet";
			document.vrlCancel.submitAction.value = "cancelTicket";
		    document.forms[0].action = submitfile;
			document.forms[0].method = "post";
			
		}
		             
		//document.forms[0].action = submitfile;
	    }
  
	function doValidation(vrlCancel) {
    	if(document.vrlCancel.confirmPNR.value ==""){
           alert("Kindly enter PNR Number");
           document.vrlCancel.confirmPNR.focus();
		   return false;
	    }
	    else{
			searchBookedTicket();
	    }
	}  
	
	function searchBookedTicket() {
		var submitfile = "../servlet/VRLBookingServiceServlet";
		document.vrlCancel.submitAction.value = "searchBookedTicket";
		document.forms[0].action = submitfile;
		document.forms[0].method = "post";
	}
</script>
<body>
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
<form name="vrlCancel" method="post" class="form-horizontal bs-docs-example">
<legend>Cancel ticket</legend>
<%if(vrlBustktDtlInfo == null){%>
	<fieldset>
			<div class="control-group">
			    	<label class="control-label" for="confirmPNR">PNR Number<font color="red">*</font></label>
		    		<div class="controls">
		    			<input type="text" class="FieldText" id="confirmPNR" name="confirmPNR" value="<%=((vrlBustktDtlInfo != null)?vrlBustktDtlInfo.getConfirmPNR() :"") %>" maxlength="8" size="15">
		    		</div> 
		   	</div>
		   	<div class="control-group">
		   		<div class="controls">
		   		<input type="submit" value="Search" name="Search" onclick="return doValidation(document.vrlCancel);" class="btn btn-warning">
	            <input type="reset" name="submit" value="Reset" class="btn btn-warning">
			    </div>
			</div>
	</fieldset>
<%} %>


<%if(vrlBustktDtlInfo != null){%>
	<fieldset>
		<div class="control-group">
		    	<label class="control-label" for="confirmPNR">PNR Number</label>
	    		<div class="controls">
	    			<input type="text" class="FieldText" id="confirmPNR" name="confirmPNR" value="<%=((vrlBustktDtlInfo != null)?vrlBustktDtlInfo.getConfirmPNR() :"") %>" readonly="readonly">
	    		</div> 
	   	</div>
	   	<div class="control-group">
		    	<label class="control-label" for="confirmPNR">OrderId</label>
	    		<div class="controls">
	    			<%=vrlBustktDtlInfo.getOrderid()%><input type="hidden" name="orderid" id="orderid" value="<%=vrlBustktDtlInfo.getOrderid()%>">
	    		</div> 
	   	</div>
	   	<div class="control-group">
		    	<label class="control-label" for="confirmPNR">Transaction ID</label>
	    		<div class="controls">
	    			<%= vrlBustktDtlInfo.getPgid()%>
	    		</div> 
	   	</div>
	   		<div class="control-group">
		    	<label class="control-label" for="confirmPNR">Date of Booking</label>
	    		<div class="controls">
	    			<%= vrlBustktDtlInfo.getRequestdate()%>
	    		</div> 
	   	</div>
	   	<div class="control-group">
		    	<label class="control-label" for="confirmPNR">Source Station</label>
	    		<div class="controls">
	    			 <%= vrlBustktDtlInfo.getSource()%>
	    		</div> 
	   	</div>
	   	<div class="control-group">
		    	<label class="control-label" for="confirmPNR">Destination Station</label>
	    		<div class="controls">
	    			 <%= vrlBustktDtlInfo.getDestination()%>
	    		</div> 
	   	</div>
	   	<div class="control-group">
		    	<label class="control-label" for="confirmPNR">Total Fare</label>
	    		<div class="controls">
	    			 <%= vrlBustktDtlInfo.getTotalfare()/100%>
	    		</div> 
	   	</div>
	   	<div class="control-group">
		    	<label class="control-label" for="confirmPNR">Mobile No</label>
	    		<div class="controls">
	    			 <%= vrlBustktDtlInfo.getMobileno()%>
	    		</div> 
	   	</div>
	   		<div class="control-group">
		    	<label class="control-label" for="confirmPNR">Email Id</label>
	    		<div class="controls">
	    			 <%= vrlBustktDtlInfo.getEmailid()%>
	    		</div> 
	   	</div>
	   	<div class="control-group">
	   		<div class="controls">
	   		<input type="submit" class="btn btn-warning" id="doCancellation" name="doCancellation"	value="Cancel ticket" onclick="SubmitForm(event)">
	   		</div>
		</div>
	</fieldset>
<%}%>
 <%if(cancellTicketResult != null){%>
 	 <fieldset>
	 <div class="control-group">
	    	<label class="control-label" for="confirmPNR">CNR Number</label>
    		<div class="controls">
    			 <%=cancellTicketResult.getCnr_no()%>
    		</div> 
   	  </div>
	 <div class="control-group">
	    	<label class="control-label" for="confirmPNR">Refund Amount</label>
    		<div class="controls">
    		<%=new java.text.DecimalFormat("0.00").format((double)cancellTicketResult.getRefund_amount())%> Rs.
    		</div> 
   	</div>
	 </fieldset>
 <%} %>  			
<input type="hidden" name="submitAction" value=""> 
</form>
</div>
</div>
</body>
<jsp:include page="Footer.jsp" flush="true" />