<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="user.*"
	import="java.lang.*, java.text.*, java.util.*" %>
<c:import url="includes/navbar.jsp" />
<link rel="stylesheet" href="styles/login.css" type="text/css" />
<script type="text/javascript" src="scripts/register.js"></script>
<br><h1>My Account</h1><br>

<%
	User user = (User) session.getAttribute("results");
%>

<body>
    <head>
    <%@ include file = "includes/header.jsp" %>
    <title>Tool Time Login</title>
    <script type="text/javascript" src="scripts/slideshow.js"></script>
    </head>
	<fieldset>
		<label for="firstName">First name:</label>
			<input name="lastName" id="lastName" value=<%out.print(user.getFirstName());%> readonly type="text">
		<label for="lastName">Last name:</label>
			<input name="lastName" id="lastName" value=<%out.print(user.getLastName());%> readonly type="text">
		<label for="email">Email Address:</label>
			<input name="email" id="email" value=<%out.print(user.getEmail());%> readonly type="text">
	</fieldset>
    <fieldset id="billing" class="text">
	 	<legend>Billing Address</legend>
		<label for="bStreet">Street Address:</label>
			<input name="bStreet" id="bStreet" value=<%out.print(user.getbStreet());%> readonly type="text">
		<label for="bCity">City:</label>
			<input name="bCity" id="bCity" value=<%out.print(user.getbCity());%> readonly type="text">
		<label for="bState">State:</label>
			<input name="bState" id="bState" value=<%out.print(user.getbState());%> readonly type="text">
		<label for="bZip">Zip code:</label>
			<input name="bZip" id="bZip" value=<%out.print(user.getbZip());%> readonly type="text">
     </fieldset>
     <fieldset id="delivery" class="text">
		<legend>Delivery Address</legend>
			<label for="dStreet">Street Address:</label>
				<input name="dStreet" id="dStreet" value=<%out.print(user.getdStreet());%> readonly type="text">
			<label for="dCity">City:</label>
				<input name="dCity" id="dCity" value=<%out.print(user.getdCity());%> readonly type="text">
			<label for="deliveryState">State:</label>
				<input name="dState" id="dState" value=<%out.print(user.getdState());%> readonly type="text">
			<label for="dZip">Zip code:</label>
				<input name="dZip" id="dZip" readonly value=<%out.print(user.getdZip());%> type="text">
      </fieldset>
      <fieldset id="paymentInfo" class="text">
      	<legend>Payment</legend>
				<label for="CreditCardType">Zip code:</label>
					<input name="CreditCardType" id="CreditCardType" readonly value=<%out.print(user.getCreditCardType());%> type="text">
				<label for="cardNumber">Card # </label>
					<input name="cardNumber" id="cardNumber" readonly value=<%out.print(user.getCardNumber());%> type="text"><br>
				<label for="exp">Expiration</label>
					<input name="ExpDay" id="ExpDay" readonly value=<%out.print(user.getExpDay());%> type="text"><br>
				<label for="expYear">Expiration</label>
					<input name="expYear" id="expYear" readonly value=<%out.print(user.getExpYear());%> type="text"><br>
				<label for="cvv">CVV</label>
				<input name="cvv" id="cvv" readonly value=<%out.print(user.getCvv());%> type="text">
				      <DIV ID="password_result">&nbsp;</DIV>				
      </fieldset>
</body>
</html>