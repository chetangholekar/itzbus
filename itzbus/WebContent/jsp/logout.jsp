<%@ page language="java" import="eleclipse.util.PropertySupport" %>
<%
	session.invalidate();
	session = null;
%>
<html>
<head><title>Logout</title></head>
<body>
<%
PropertySupport support = new PropertySupport("ItzBus");
	  String loginUrl = support.getResource("LoginURL","");
%>

<script language="">
        location.href = "http://demo.itzcash.com/itzcpms/jsp/login.jsp";
</script>
<noscript>
<br><br><br>
<h2 align="center">Click <a href="http://demo.itzcash.com/itzcpms/jsp/login.jsp">here</a> to continue.</h2>
</noscript>
</body>
</html>
