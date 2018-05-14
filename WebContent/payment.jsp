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
		<title>Confirm Payment</title>
        <link href="styles/departments.css" rel="stylesheet" type="text/css">
    </head>
	<body>
		<%@include file = "includes/navbar.jsp" %>
	<br><h1>Confirm Payment</h1>
	
	<fieldset id="paymentItems" class="text">
		<legend>Items in Cart</legend>
		<c:forEach items="${cartItems}" var="cartItem">
			<p>${cartItem.name} - 
			<fmt:formatNumber value = "${cartItem.cost}" type = "currency"/>
			</p>
		</c:forEach>
	</fieldset>
	
	<fieldset id="paymentTotal" class="text">
		<legend>Total</legend>
		<fmt:formatNumber value = "${totalCost}" type = "currency"/>
	</fieldset>
    
	<fieldset id="paymentInfo" class="text">
		<legend>Payment Method</legend>
		
		<h2>Payment will be processed to your <%out.print(user.getCreditCardType());%> 
			ending in <%out.print(user.getCardNumber() % 10000);%> </h2>
		<br><br>
		
		<div id="buttonContainer">
			<form action="OrderProcess" method="post">
			<input type="submit" value="Process Payment" id="paymentButton" />
			</form>
		</div>		
	
	</fieldset>
		
</body>
</html>