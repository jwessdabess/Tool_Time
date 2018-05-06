<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <%@ include file = "includes/header.jsp" %>
    <title>Tool Time Home</title>
    <script type="text/javascript" src="scripts/slideshow.js"></script>
    </head>
    <body>
    <%@include file = "includes/navbar.jsp" %>
	<div>
		<img class="slides" src="images/hardware1.jpg" alt="Hardware Image"/>
		<img class="slides" src="images/electrical.jpg" alt="Electrical" />
		<img class="slides" src="images/renovated_bathroom.JPG" alt="Bathroom" />
		<img class="imageRight" src="images/Tool_Time.jpg" alt="Tool Time"/>
	</div>
	<div class="copyRight">
		&copy; Tool Time, Inc. 742 Evergreen Terrace, Springfield, Oregon 97403
	</div>
	<script>
	var myIndex = 0;
	carousel();

	function carousel() {
		var i;
		var x = document.getElementsByClassName("slides");
		for (i = 0; i < x.length; i++) {
		   x[i].style.display = "none";  
		}
		myIndex++;
		if (myIndex > x.length) {myIndex = 1;}    
		x[myIndex-1].style.display = "block";  
		setTimeout(carousel, 5000); // Change image every 2 seconds
	}
	</script>
</body>
</html>
