<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/includes/header.html" />
<link rel="stylesheet" href="styles/login.css" type="text/css" />
<script type="text/javascript" src="scripts/register.js"></script>
<br><h1>Register an Account</h1><br>

<body>
<form action="MembershipServlet" method="post">
	<fieldset>
		<label for="firstName">First name:</label>
			<input name="firstName" id="firstName" autofocus required type="text">
		<label for="lastName">Last name:</label>
			<input name="lastName" id="lastName" required type="text">
		<label for="email">Email Address:</label>
			<input name="email" id="email" required type="text">
		<label for="txtPassword">Password</label>
			<input name="Password" id="txtPassword" type="password"><br><br>
		<label for="txtConfirmPassword">Password (verify)</label>
		<input name="ConfirmPassword" id="txtConfirmPassword" type="password">
	</fieldset>
    <fieldset id="billing" class="text">
	 	<legend>Billing Address</legend>
		<label for="bStreet">Street Address:</label>
			<input name="bStreet" id="bStreet" required type="text">
		<label for="bCity">City:</label>
			<input name="bCity" id="bCity" required type="text">
		<label for="bState">State:</label>
			<select id="bState" name="bState" required><option value="---">---</option><option value="Alabama">Alabama</option><option value="Alaska">Alaska</option><option value="Arizona">Arizona</option><option value="Arkansas">Arkansas</option><option value="California">California</option><option value="Colorado">Colorado</option><option value="Connecticut">Connecticut</option><option value="Delaware">Delaware</option><option value="District of Columbia">District of Columbia</option><option value="Florida">Florida</option><option value="Georgia">Georgia</option><option value="Hawaii">Hawaii</option><option value="Idaho">Idaho</option><option value="Illinois">Illinois</option><option value="Indiana">Indiana</option><option value="Iowa">Iowa</option><option value="Kansas">Kansas</option><option value="Kentucky">Kentucky</option><option value="Louisiana">Louisiana</option><option value="Maine">Maine</option><option value="Maryland">Maryland</option><option value="Massachusetts">Massachusetts</option><option value="Michigan">Michigan</option><option value="Minnesota">Minnesota</option><option value="Mississippi">Mississippi</option><option value="Missouri">Missouri</option><option value="Montana">Montana</option><option value="Nebraska">Nebraska</option><option value="Nevada">Nevada</option><option value="New Hampshire">New Hampshire</option><option value="New Jersey">New Jersey</option><option value="New Mexico">New Mexico</option><option value="New York">New York</option><option value="North Carolina">North Carolina</option><option value="North Dakota">North Dakota</option><option value="Ohio">Ohio</option><option value="Oklahoma">Oklahoma</option><option value="Oregon">Oregon</option><option value="Pennsylvania">Pennsylvania</option><option value="Rhode Island">Rhode Island</option><option value="South Carolina">South Carolina</option><option value="South Dakota">South Dakota</option><option value="Tennessee">Tennessee</option><option value="Texas">Texas</option><option value="Utah">Utah</option><option value="Vermont">Vermont</option><option value="Virginia">Virginia</option><option value="Washington">Washington</option><option value="West Virginia">West Virginia</option><option value="Wisconsin">Wisconsin</option><option value="Wyoming">Wyoming</option></select><br><br>
		<label for="bZip">Zip code:</label>
			<input name="bZip" id="bZip" required pattern="\d{5}([\-]\d{4})?" title="Must be 99999 or 99999-9999" type="text">
     </fieldset>
     <fieldset id="delivery" class="text">
		<legend>Delivery Address</legend>
			<label> same as billing </label>
			<input type="checkbox" onclick="SetBilling(this.checked);"/><br><br>
			<label for="dStreet">Street Address:</label>
				<input name="dStreet" id="dStreet" required type="text">
			<label for="dCity">City:</label>
				<input name="dCity" id="dCity" required type="text">
			<label for="deliveryState">State:</label>
				<select id="dState" name="dState" required><option value="---">---</option><option value="Alabama">Alabama</option><option value="Alaska">Alaska</option><option value="Arizona">Arizona</option><option value="Arkansas">Arkansas</option><option value="California">California</option><option value="Colorado">Colorado</option><option value="Connecticut">Connecticut</option><option value="Delaware">Delaware</option><option value="District of Columbia">District of Columbia</option><option value="Florida">Florida</option><option value="Georgia">Georgia</option><option value="Hawaii">Hawaii</option><option value="Idaho">Idaho</option><option value="Illinois">Illinois</option><option value="Indiana">Indiana</option><option value="Iowa">Iowa</option><option value="Kansas">Kansas</option><option value="Kentucky">Kentucky</option><option value="Louisiana">Louisiana</option><option value="Maine">Maine</option><option value="Maryland">Maryland</option><option value="Massachusetts">Massachusetts</option><option value="Michigan">Michigan</option><option value="Minnesota">Minnesota</option><option value="Mississippi">Mississippi</option><option value="Missouri">Missouri</option><option value="Montana">Montana</option><option value="Nebraska">Nebraska</option><option value="Nevada">Nevada</option><option value="New Hampshire">New Hampshire</option><option value="New Jersey">New Jersey</option><option value="New Mexico">New Mexico</option><option value="New York">New York</option><option value="North Carolina">North Carolina</option><option value="North Dakota">North Dakota</option><option value="Ohio">Ohio</option><option value="Oklahoma">Oklahoma</option><option value="Oregon">Oregon</option><option value="Pennsylvania">Pennsylvania</option><option value="Rhode Island">Rhode Island</option><option value="South Carolina">South Carolina</option><option value="South Dakota">South Dakota</option><option value="Tennessee">Tennessee</option><option value="Texas">Texas</option><option value="Utah">Utah</option><option value="Vermont">Vermont</option><option value="Virginia">Virginia</option><option value="Washington">Washington</option><option value="West Virginia">West Virginia</option><option value="Wisconsin">Wisconsin</option><option value="Wyoming">Wyoming</option></select><br><br>
			<label for="dZip">Zip code:</label>
				<input name="dZip" id="dZip" required pattern="\d{5}([\-]\d{4})?" title="Must be 99999 or 99999-9999" type="text">
      </fieldset>
      <fieldset id="paymentInfo" class="text">
      	<legend>Payment</legend>
				<label for="visa">Visa</label>
					<input name="paymentMethod" id="visa" value="visa" type="radio" required>
				<label for="masterCard">Master Card</label>
					<input type="radio" name="paymentMethod" id="masterCard" value="masterCard">
				<label for="discover">Discover</label>
					<input type="radio" name="paymentMethod" id="discover" value="discover">
				<label for="amEx">American Express</label>
					<input type="radio" name="paymentMethod" id="amEx" value="amEx"><br><br>
				<label for="cardNumber">Card # </label>
					<input name="cardNumber" id="cardNumber" required type="text"><br>
				<label for="visa">Expiration</label>
				<select name="ExpDay" required>
					<option value="1">01</option>
					<option value="2">02</option>
					<option value="3">03</option>
					<option value="4">04</option>
					<option value="5">05</option>
					<option value="6">06</option>
					<option value="7">07</option>
					<option value="8">08</option>
					<option value="9">09</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
				</select>
				<select name="ExpYear" required>
					<option value="2018">2018</option>
					<option value="2019">2019</option>
					<option value="2020">2020</option>
					<option value="2021">2021</option>
					<option value="2022">2022</option>
				</select><br>
				<br><label for="cvv">CVV</label>
				<input name="cvv" id="cvv" required type="text">
				      <DIV ID="password_result">&nbsp;</DIV>
      <div id="buttonContainer">
      	  <input type="hidden" name="action" value="register"> 
          <input type="submit" value="Register" id="orderButton" onclick="return Validate()" />
       </div>				
      </fieldset>
      </form>
</body>
</html>