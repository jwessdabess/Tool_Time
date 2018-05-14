<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="user.*, database.Cart" %>
<c:import url="/includes/header.jsp" />

<%
	User user = (User) session.getAttribute("results");
%>

<!DOCTYPE html>
<html>
    <head>
       	<%@ include file = "includes/header.jsp" %>
		<title>Order Confirmation</title>
        <link href="styles/departments.css" rel="stylesheet" type="text/css">
    </head>
<body>
		<%@include file = "includes/navbar.jsp" %>
	<br><h1>Thank You For Your Order</h1>
    
	<fieldset id="paymentInfo" class="text">
		<legend>Payment Method</legend>
		
		<h2>Thank you for placing an order with Tool Time! Your order is complete! </h2>
		<h2>An order confirmation has been sent to <%out.print(user.getEmail());%>  </h2>
		<br><br>
	
	</fieldset>
		
</body>
</html>