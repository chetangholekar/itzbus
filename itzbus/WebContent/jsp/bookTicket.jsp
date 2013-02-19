<%@ page language="java" import="com.itz.bus.info.*,com.itz.bus.ws.*,in.vrllogistics.www.webs.WS.Journey,in.vrllogistics.www.webs.WS.Boarding_point,java.util.*" %>

<jsp:include page="Header.jsp" flush="true" />
<div class="hero-unit">
<div class="radious"> 
<%	  
	  //String[] seatDet =(String[])request.getParameterValues("seatDet");
	  String[] seatDet =(String[])request.getParameterValues("seatDet"+request.getParameter("Id"));
	  String Id = request.getParameter("Id");
	  VRLBusTicketDetailsInfo busTicketDetailsInfo = null; 
	  busTicketDetailsInfo = (VRLBusTicketDetailsInfo)session.getAttribute("busTicketInfo"); 
	 
	  String stNo = "";   
	  int noOfPass = seatDet.length;
	  if(seatDet.length != 0){
    	  for(int k=0;k<seatDet.length;k++)
			{
    		    stNo = seatDet[k];
				/*String jouneyId = (String)request.getParameter("journeyId_"+stNo); 
				String seatNo = (String)request.getParameter("seatNo_"+stNo);
				String seatId = (String)request.getParameter("seatId_"+stNo);*/	
    		    String jouneyId = (String)request.getParameter("journeyId"+Id+"_"+stNo); 
				String seatNo = (String)request.getParameter("seatNo"+Id+"_"+stNo);
				String seatId = (String)request.getParameter("seatId"+Id+"_"+stNo);
			}
      }
	  
	  double totalfare = 0;
%>

<script type="text/javascript">

function backMenu(){
	var submitfile = "../jsp/home.jsp";
	document.forms[0].action = submitfile;
}

function bookTicket()
{
	var noOfPass = document.tktBook.noOfPass.value;
	for(var i=0;i < noOfPass;i++){
        var passengerName = document.getElementById('name_'+i).value;
        var age = document.getElementById('age_'+i).value;
		
		if(passengerName == ""){
			alert("Please Enter Passenger Name");
			document.getElementById('name_'+i).focus;
			return false;
		}	
		if(age == "" || age == 0){
			alert("Please Enter Valid Passenger Age");
			document.getElementById('age_'+i).focus;
			return false;
		}
	}	
	var mobileno = document.tktBook.mobileno.value;
    var emailid = document.tktBook.emailid.value;
    //var accountno = document.tktBook.accountno.value;
    //var password = document.tktBook.accpassword.value;
    
    var noOfPasngers = document.tktBook.total.length;
    //alert("total Passngers = "+noOfPasngers);    
    
   /*if(noOfPasngers != 0){
    for(var i=0;i <= noOfPasngers;i++ ){
    	//alert(document.getElementById('name_'+i));
    	if(document.getElementById('name_'+i).value == ""){
        	alert("OK");
        	alert(document.getElementById('name_'+i).value);
    		document.getElementById('name_'+i).focus;			
			return false;
			}
		//return false;       
    }
	//}*/ 
    
    if(mobileno == "")
    {
        alert("Please enter mobile number.");
        document.tktBook.mobileno.focus();
        return false;
    }
    if(mobileno.length > 0 && mobileno.length < 10)
    {
        alert("Mobile No. cannot be less than 10 digits");
        return false;
    }
    else if(IsNumeric(mobileno))
    {
      document.tktBook.mobileno.value=Number(mobileno);
      mobileno=document.tktBook.mobileno.value;
      if(!((mobileno).length  == 10))
      {
          alert("Please enter valid Mobile Number");
          document.tktBook.mobileno.value.focus();
          return false;
      }
    }
    else
    {
        alert("Mobile No. should be numeric");
        return false;
    }
    if(mobileno.length==10)
    {
        var invalidNo = new Array();
        invalidNo[0]="9999999999";
        invalidNo[1]="8888888888";
        invalidNo[2]="1111111111";
        invalidNo[3]="7777777777";
        invalidNo[4]="0000000000";
        invalidNo[5]="2222222222";
        invalidNo[6]="3333333333";
        invalidNo[7]="4444444444";
        invalidNo[8]="5555555555";
        invalidNo[9]="6666666666";
        invalidNo[10]="1234567890";
        for (i=0;i<invalidNo.length;i++)
         {
             if(mobileno==invalidNo[i])
             {
                 alert("Please enter valid Mobile No.");
                 document.forms[0].mobileno.focus();
                 return false;
             }
         }
    }    
    if(emailid == "")
    {
        alert("Please enter emailid");
        document.tktBook.emailid.focus(); 
        return false;
    }    
    /*else if(accountno == "")
    {
        alert("Please enter Account number.");
        document.tktBook.accountno.focus();
        return false;
    }
    else if(accountno.length < 12)
    {
        alert("Please enter 12 digit card number.");
        document.tktBook.accountno.focus();
        return false;
    }
    else if(password == "")
    {
        alert("Please enter card password.");
        document.tktBook.accpassword.focus();
        return false;
    }
    else if(password.length < 4 )
    {
        alert("Please enter 4 digit password.");
        document.tktBook.accpassword.focus();
        return false;
    }  */  
	else
	{
    	var submitfile;
		submitfile = "../servlet/VRLPaymentServlet";
		document.forms[0].action = submitfile;
	}
}

function IsNumeric(sText)
{
   var ValidChars = "0123456789";
   var IsNumber=true;
   var Char;

   for (i = 0; i < sText.length && IsNumber == true; i++)
      {
        Char = sText.charAt(i);
        if (ValidChars.indexOf(Char) == -1)
        {
            IsNumber = false;
        }
      }
   return IsNumber;
}
    
</script>


<form name="tktBook" method="post" class="form-horizontal bs-docs-example">
<legend>Book Ticket</legend>
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

<table class="table table-bordered table-striped">
	<thead>
	<tr>
	    <th>Name</th>
	    <th>Gender</th>
	    <th>Age</th>
	    <th>Seat No</th>
	    <th>Fare</th>
    </tr>
    </thead>
    
    <%if(seatDet.length != 0){
    	  
    	  for(int k=0;k<seatDet.length;k++)
			{
    		    stNo = seatDet[k];				
				String jouneyId = (String)request.getParameter("journeyId"+Id+"_"+stNo); 
				String seatNo = (String)request.getParameter("seatNo"+Id+"_"+stNo);
				String seatId = (String)request.getParameter("seatId"+Id+"_"+stNo);
				String fare = (String)request.getParameter("fare"+Id+"_"+stNo);
				double doubleFare = Double.parseDouble(fare);
				totalfare = totalfare + doubleFare;
				%>
				<tr>
				<td><input type="hidden" name="total" id="total_<%=k%>" value="<%=k%>">
				<%=k+1%><font color="red">*</font>&nbsp;&nbsp;<input type="text" id="name_<%=k%>" size="30" name="name_<%=k%>"></input></td>
				<td><input type="radio" name="sex_<%=k%>" value="M" class='mval' checked='checked' /> M &nbsp;&nbsp;<input type="radio" class='mval' name="sex_<%=k%>" value="F" /> F</td>
				<td><input type="text" name="age_<%=k%>" size="3" id="age_<%=k%>" maxlength="2"></input></td>
				<td><input type="text" value="<%=seatId%>" id="seatId_<%=k%>" size="5" name="seatId_<%=k%>" readonly/></td>
				<td><%=fare%></td>
				<input type="hidden" value="<%=seatNo%>" id="seatNo_<%=k%>" name="seatNo_<%=k%>" readonly/>
				</tr>
			<%}
      }%>
    
</table>



<fieldset>
		<div class="control-group">
		    	<label class="control-label" for="fare">Ticket Fare :</label>
	    		<div class="controls">
	    			<input type="text" name="fare" size="8" value="<%=new java.text.DecimalFormat("0.00").format((double)totalfare)%>" maxlength="6" id="fare" readonly/>
	    		</div> 
	   	</div>
	   	<div class="control-group">
		    	<label class="control-label" for="mobileno">Mobile No. :</label>
	    		<div class="controls">
	    			<input type="text" name="mobileno" size="12" maxlength="10" id="mobileno" title="Please provide your Mobile Number."/>
	    		</div> 
	   	</div>
	   	
	   	<div class="control-group">
		    	<label class="control-label" for="emailid">Email Id :</label>
	    		<div class="controls">
	    			<input type="text" name="emailid" size="35" maxlength="30" id="emailid" title="Please provide your Email Id."/>
	    		</div> 
	   	</div>
	   	
	   	<%--  
	   	<div class="control-group">
		    	<label class="control-label" for="accountno">Account Number :</label>
	    		<div class="controls">
	    			<input type="text" name="accountno" size="15" maxlength="12" id=accountno/>
	    		</div> 
	   	</div>
	   	
	   	<div class="control-group">
		    	<label class="control-label" for="accpassword">Password</label>
	    		<div class="controls">
	    			<input type="password" name="accpassword" size="10" maxlength="4" id="accpassword"/>
	    		</div> 
	   	</div>
	  
	     --%>
	    
	   	<div class="control-group">
	   		<div class="controls">
	   			<input name="submitAction" value="Book" type="submit" onclick="return bookTicket();" class="btn btn-warning">				
	   			<input name="submitAction" value="Back" type="submit" onclick="return backMenu();" class="btn btn-warning">
	            <input type="reset" name="submit" value="Reset" class="btn btn-warning">
		    </div>
		</div>
</fieldset>
<input type="hidden" name="noOfPass" value="<%=noOfPass%>">
<input type="hidden" name="bookTicketToken" value="<%=new java.util.Random().nextLong()%>">
</form> 

<script src="<%=request.getContextPath()%>/javascript/jquery-ui.js"></script>
<script language="javascript" type="text/javascript">
jq(function() {
	var tooltips = jq( "[title]" ).tooltip();
});

</script>
</div>
</div>
</body>
<jsp:include page="Footer.jsp" flush="true" />