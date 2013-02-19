<%@ page language="java" import="com.itz.bus.info.*,com.itz.bus.ws.*,in.vrllogistics.www.webs.WS.Journey,in.vrllogistics.www.webs.WS.Boarding_point,java.util.*" %>
<jsp:include page="Header.jsp" flush="true" />
<div class="hero-unit">
<div class="radious"> 
<script>

	function confirmPNR()
	{	    
		var accountno = document.confPNR.accountno.value;
	    var password = document.confPNR.accpassword.value;
	    if(accountno == "")
	    {
	        alert("Please enter Account number.");
	        document.confPNR.accountno.focus();
	        return false;
	    }
	    else if(accountno.length < 12)
	    {
	        alert("Please enter 12 digit card number.");
	        document.confPNR.accountno.focus();
	        return false;
	    }
	    else if(password == "")
	    {
	        alert("Please enter card password.");
	        document.confPNR.accpassword.focus();
	        return false;
	    }
	    else if(password.length < 4 )
	    {
	        alert("Please enter 4 digit password.");
	        document.confPNR.accpassword.focus();
	        return false;
	    }else{
	    	var submitfile;
			submitfile = "../servlet/VRLConfirmPNRServlet"; 
	    	document.confPNR.confirmpnr.value = "confirmPNR";			
			document.forms[0].action = submitfile;          
	    }
	}

</script>

<%   
	VRLBusTicketDetailsInfo detailsInfo = (VRLBusTicketDetailsInfo)session.getAttribute("tktDtlInfo");
    VRLBusPassengerDetInfo[] passengerDetInfo = null;
    if(detailsInfo != null){
    	passengerDetInfo = (VRLBusPassengerDetInfo[])detailsInfo.getBusPassengerDetInfos();
    }

%>
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
<form name="confPNR" method="post" class="form-horizontal bs-docs-example" autocomplete="off">
<legend>Confirm PNR</legend>

<fieldset>
<%if(detailsInfo != null){%>

<fieldset>
		<div class="control-group">
		    	<label class="control-label" for="temppnr">Temp PNR</label>
		    	<div class="controls">
	    			<%=detailsInfo.getTempPNR()%>
	    		</div> 
	   	</div>
	   	
		<div class="control-group">
		    	<label class="control-label" for="fare">Ticket Fare :</label>
	    		<div class="controls">
	    			<input type="text" name="fare" size="8" value="<%=new java.text.DecimalFormat("0.00").format((double)detailsInfo.getTotalfare()/100)%>" maxlength="6" id="fare" readonly/>
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
	   	
	   		<div class="control-group">
		    	<label class="control-label" for="accountno">Account Number :</label>
	    		<div class="controls">
	    			<input type="text" name="accountno" size="15" maxlength="12" id=accountno title="Please provide your Account Number."/>
	    		</div> 
	   	</div>
	   	
	   	<div class="control-group">
		    	<label class="control-label" for="accpassword">Password</label>
	    		<div class="controls">
	    			<input type="password" name="accpassword" size="10" maxlength="4" id="accpassword" title="Please provide your Account Password."/>
	    		</div> 
	   	</div>
	   
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
</fieldset>


	   	<div class="control-group">
	   		<div class="controls">
	   			<input name="confirmpnr" value="Confirm" type="submit" onclick="return confirmPNR();" class="btn btn-warning">	           
		    </div>
		</div>

<%}%>

</fieldset>
<input type="hidden" name="confirmPNRToken" value="<%=new java.util.Random().nextLong()%>">
</form> 
</body>
<script src="<%=request.getContextPath()%>/javascript/jquery-ui.js"></script>
<script language="javascript" type="text/javascript">
jq(function() {
	var tooltips = jq( "[title]" ).tooltip();
});

</script>



</div>
</div>
<jsp:include page="Footer.jsp" flush="true" />