<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="user.*"
	import="java.lang.*, java.text.*, java.util.*" %>
<link rel="stylesheet" href="styles/login.css" type="text/css" />
<%@include file = "includes/navbar.jsp" %>
<br><h1>Member Sign In</h1><br>

<%	boolean logged = (boolean) session.getAttribute("logged");
	if (!logged)
		out.print("<h3> " + "You are not logged in. Please log in to view profile" +
			"</h3>");%>

<body>
    <head>
    <%@ include file = "includes/header.jsp" %>
    <title>Tool Time Login</title>
    <script type="text/javascript" src="scripts/slideshow.js"></script>
    </head>
<form action="MembershipServlet" method="post">
	<fieldset>
		Email
		<input type="text" name="email" autofocus> 
		<br>
		Password
		<input type="password" name="password">
		<br>
		<input type="hidden" name="action" value="login"> 
		<input type="submit" value="Login">
		</fieldset>
</form>
<form action="MembershipServlet" method="post">
<fieldset>
		<h2>New member?</h2>
		<input type="submit" value="Register">
		<input type="hidden" name="action" value="toRegister"> 
		<br>
		<p>
		If you are experiencing difficulty logging in or registering, please contact
		your store for further support
		</p>
	</fieldset>
</form>
</body>
</html>