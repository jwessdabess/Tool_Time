<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/includes/header.html" />
<link rel="stylesheet" href="styles/login.css" type="text/css" />
<br><h1>Member Sign In</h1><br>

<body>
<form action="MembershipServlet" method="post">
	<fieldset>
		Email
		<input type="text" name="email" autofocus> 
		<br>
		Password
		<input type="text" name="password" type="password">
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