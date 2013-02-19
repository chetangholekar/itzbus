<%@ page import="com.itz.bus.info.UserInfo"%>
<%
	boolean login = false; 
	boolean sessioncheck = false;
	UserInfo userInfoHeader = (UserInfo)session.getAttribute("userInfo");
	if (userInfoHeader != null)
	{
		sessioncheck = true;
		login = true;
	}
	
	if (!sessioncheck)
    {
        //RequestDispatcher requestdispatcher = request.getRequestDispatcher("/jsp/applicationError.jsp");
        //requestdispatcher.forward(request,response);
        //session.invalidate();
       // return;
		out.println("<script language=javascript>");
	 	out.println("window.location.replace('"+request.getContextPath()+"/jsp/applicationError.jsp');");
	 	out.println("</script>");
    }
%>
<!DOCTYPE html>
<html lang="en">
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
    <link rel="stylesheet" href="../css/jquery-ui.css" />
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
	
	<script type="text/javascript" src="../javascript/dropdown_menu.js"></script>
	<script src="<%=request.getContextPath()%>/javascript/jquery-1.8.2.min.js"></script>
    <script type="text/javascript">
    	var jq = jQuery.noConflict();
	</script>
    
  </head>
  <body>
    <div class="navbar">
      <div class="top"></div>
      <div class="header">      
        <div id="iNavLogo">
        	<a accesskey="0" title="" href=""><img class="Logo" title="" alt="" src="../images/logo.png" /></a>
        </div>
        <div class="top-link">
        <ul>
        <%
		if (login)
		{%>
			<li id="logout">Welcome <%=userInfoHeader.getCompanyName()%>[<%=userInfoHeader.getUserCode()%>]&nbsp;&nbsp;&nbsp;<a href="../jsp/logout.jsp" class="btn btn-warning">LogOut</a></li>
        <%} else {%>
        	<!--<li id="logout"><A href="../jsp/Login.jsp">Home</A></li>
        --><%}%>
        </ul>
        </div>
        </div>  
      
    </div>

    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span12">
        
            <div class="menu">
	        <ul id="nav">
		    	<li class="top">
	    			<a href="../jsp/home.jsp" class="top">Home</a>		    
	    		</li>
	            <li class="top"><a href="#" class="top"><span class="down">Transactions</span></a>
		            <ul class="sub">
					    <li><a href="../jsp/cancelTicket.jsp">Cancel Ticket</a></li>
					</ul>
	            </li>		
	            <li class="top"><a href="#" class="top"><span class="down">Report</span></a>
		            <ul class="sub">
					    <li><a href="../jsp/ticketHistory.jsp">Transaction Report</a></li>
					</ul>
	            </li>
	   			<li class="top">
	    			<a href="../jsp/logout.jsp" class="top">Logout</a>		    
	    		</li>
	    
	</ul>
	</div>
	