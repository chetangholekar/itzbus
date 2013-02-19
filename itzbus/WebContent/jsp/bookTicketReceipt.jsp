<%@ page language="java" import="com.itz.bus.info.*,com.itz.bus.ws.*,in.vrllogistics.www.webs.WS.Journey,in.vrllogistics.www.webs.WS.Boarding_point,java.util.*" %>

<jsp:include page="Header.jsp" flush="true" />

<%   
	VRLBusTicketDetailsInfo detailsInfo = (VRLBusTicketDetailsInfo)session.getAttribute("tktDtlInfo");
    VRLBusPassengerDetInfo[] passengerDetInfo = null;
    if(detailsInfo != null){
    	passengerDetInfo = (VRLBusPassengerDetInfo[])detailsInfo.getBusPassengerDetInfos();
    }

%>
<div class="hero-unit">
<div class="radious"> 

<script type="text/javascript">
  function printReceipt(){
	  window.open('<%=request.getContextPath()%>/servlet/VRLTicketReceiptServlet',
								   'Search','width=600,height=400,scrollbars=yes,status=no,location=no',
						   'scrollbar=yes');

	}
</script>


<form name="tktBook" method="post" class="form-horizontal bs-docs-example">
<legend>Ticket Receipt</legend>
<div align='center' style='color:red'>

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
<%
}
%>
</div>


<fieldset>
		<div class="control-group">
		    	<label class="control-label" for="temppnr">PNR</label>
		    	<div class="controls">
	    			<input type="text" name="mobileno" size="12" maxlength="10" value="<%=detailsInfo.getConfirmPNR()%>" readonly/>
	    		</div> 
	   	</div>
	   	
	   	<div class="control-group">
		    	<label class="control-label" for="totalfare">Total Fare :</label>
	    		<div class="controls">
	    			<input type="text" name="totalfare" size="8" value="<%= new java.text.DecimalFormat("0.00").format((double)detailsInfo.getTotalfare()/100)%>" maxlength="6" id="totalfare" readonly/>
	    		</div> 
	   	</div>	   	
	   	
	   	<div class="control-group">
		    	<label class="control-label" for="mobileno">Mobile No. :</label>
	    		<div class="controls">
	    			<input type="text" name="mobileno" size="12" maxlength="10" value="<%=detailsInfo.getMobileno()%>" readonly/>
	    		</div> 
	   	</div>
	   	
	   	<div class="control-group">
		    	<label class="control-label" for="emailid">Email id :</label>
	    		<div class="controls">
	    			<input type="text" name="emailid" size="35" maxlength="30" id="emailid" value="<%=detailsInfo.getEmailid()%>" readonly/>
	    		</div> 
	   	</div>
</fieldset>	   	
	<table class="table table-bordered table-striped">
	<thead>
	<tr>
		<th>Sr.No.</th>
	    <th>Name</th>
	    <th>Gender</th>
	    <th>Age</th>
	    <th>Seat No</th>
    </tr>
    </thead>
    
    <%if(passengerDetInfo != null){
    	  for(int k=0; k< passengerDetInfo.length; k++)
			{
    		  int id = passengerDetInfo[k].getPassgengerid();
    		  String name = passengerDetInfo[k].getPassengername();
    		  String gender = passengerDetInfo[k].getGender() != null ? (passengerDetInfo[k].getGender().equalsIgnoreCase("M") ? "Male" : "Female" ) : "";
    		  int age = passengerDetInfo[k].getAge();
    		  String seatNo = passengerDetInfo[k].getSeatId();
				
				%>
				<tr>
				<td><%= id%></td>
				<td><%= name%></td>
				<td><%= gender%></td>
				<td><%= age%></td>
				<td><%= seatNo%></td>
				</tr>
			<%}
      }%>
    
</table>

<div class="control-group">

	   		<div class="controls">
	   			<input name="receipt" value="Print Ticket" type="button" onclick="printReceipt();" class="btn btn-warning">	           
		    </div>	    
		    
</div>

</form> 
</div>
</div>
</body>
<jsp:include page="Footer.jsp" flush="true" />