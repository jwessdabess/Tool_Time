<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/web/includes/header.html" />
<link rel="stylesheet" href="styles/login.css" type="text/css" />
<br><h1>Member Sign In</h1><br>

<body>
	<fieldset>
		Email
		<input type="text" name="email" autofocus required> 
		<br>
		Password
		<input type="text" name="password" required>
		<br>
		<form action="MembershipServlet" method="post">
			<input type="hidden" name="Login" value="Login"> 
			<input type="submit" value="Login">
		</form>
		<h2>New member?</h2>
		<form action="MembershipServlet" method="post">
			<input type="hidden" name="Register" value="Register"> 
			<input type="submit" value="Register">
		</form>
		<br>
		<p>
		If you are experiencing difficulty logging in or registering, please contact
		your store for further support
		</p>
	</fieldset>
</body>
</html>