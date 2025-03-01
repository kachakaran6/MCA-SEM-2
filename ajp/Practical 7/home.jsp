<%--
Document : home
Created on : Mar 10, 2024, 8:59:57 AM

Author : JIGAR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
<%
String un = (String)session.getAttribute("un");

%>
<h2>Welcome <%= un %></h2>
</body>
</html>