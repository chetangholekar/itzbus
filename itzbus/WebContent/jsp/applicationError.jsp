<%@ page language="java" import="com.itz.bus.info.*,com.itz.bus.ws.*,in.vrllogistics.www.webs.WS.Journey,in.vrllogistics.www.webs.WS.Boarding_point,java.util.*" %>


<%@page import="eleclipse.util.PropertySupport"%><html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Bus Portal - ItzCash</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="PayOnWeb, PowerToWeb, ItzCash">
    <meta name="author" content="Itzcash">
    <!-- Le styles -->
    <link href="<%=request.getContextPath()%>/css/demo_table.css" rel="stylesheet"> 
    <link href="../css/bootstrap.css" rel="stylesheet">
    <link href="../css/bootstrap-responsive.css" rel="stylesheet">
    <!-- <link rel="stylesheet" href="../css/jquery-ui.css" /> -->
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
    <link href="../css/dropdown_menu.css" media="screen" rel="stylesheet" type="text/css" />
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">
    <link rel="shortcut icon" href="ico/favicon.png">
	
	<script type="text/javascript" src="../js/dropdown_menu.js"></script>
	<script src="<%=request.getContextPath()%>/javascript/jquery-1.8.2.min.js"></script>
    <script type="text/javascript">
    	var jq = jQuery.noConflict();
	</script>
    
  </head>


<body>
<%PropertySupport support = new PropertySupport("ItzBus");
  String loginUrl = support.getResource("LoginURL","");
%>



  <div class="container-fluid">
      <div class="row-fluid">
        <div class="span12">

<%
if(request.getAttribute("msg") != null){
%>
<div class="alert fade in">
        <button data-dismiss="alert" class="close" type="button">&times;</button>
    <font color="#FF0000" size="2" face="Arial, Helvetica, sans-serif"><b><%=request.getAttribute("msg")%></b></font>
</div>
<%}%>

<div class="hero-unit">
            <div class="radious"> 

 <table cellspacing="0" cellpadding="0" style="width:100%; height:350px">
    <tbody><tr>
      <td style="padding:15px 15px 15px 15px">
               <table cellspacing="0" cellpadding="0" align="center" style=" width:60%; border: #7B0204 2px solid; height:150px ">
              <tbody><tr>
                 <td align="center" style="font-family:Verdana; font-size:16px; font-weight:bold; color:Red; ">                   
                 </td>
              </tr>
              <tr>
                 <td align="left" style="font-family:Verdana; font-size:16px; font-weight:bold; color:#253C86; padding:0 0 0 10px ;height:50px">
                  APPLICATION SECURITY ERROR !!
                 </td>
              </tr>
              <tr>
                  <td align="left" style="font-family:Verdana; font-size:12px; color:#253C86; padding:0 0 0 10px ">
                   This error has occured for one of the following reasons :  
                    <ul style="line-height: 2; list-style-position: inside; font-family: Verdana">
                    <li> You have kept the browser window idle for a long time. </li>
                     <li> You have used Back/Forward/Refresh button of your Browser. </li>
                      <li> You have clicked twice on any options/buttons. </li>
                       <li> You are accessing the application URL from a saved or static page. </li>
                    </ul>
                    <p><a href="<%=loginUrl%>" class="btn btn-warning">Click here to Login</a></p>
                 </td>
              </tr>
              <tr>
                <td style="height:10px">
                </td>
              </tr>
              <tr>
                 <td align="left" style="font-family:Verdana; font-size:16px; font-weight:bold; color:Red; padding:0 0 0 10px ">
                 </td>
              </tr>
          </tbody></table>
      </td>
    </tr>
</tbody></table>
 


</body>
</div>
</div>

<jsp:include page="Footer.jsp" flush="true" />