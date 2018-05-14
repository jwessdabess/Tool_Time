<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       	<%@ include file = "includes/header.jsp" %>
		<title>Cart</title>
        <link href="styles/departments.css" rel="stylesheet" type="text/css">
    </head>
<body>
		<%@include file = "includes/navbar.jsp" %>
		<br />
		<br />
		<table >
            <thead>
                <tr>
                    <th>
                        <b> Shopping Cart</b> 
                    </th>
                    <th>
                        <b>Cost</b>
                    </th>
                </tr>
            </thead>
        	<tbody>
			<c:forEach items="${cartItems}" var="cartItem">
				<tr>
					<td style ="text-align: left;">
					<form action="CartServlet" method="post">
					<img src= ${cartItem.imagePath} style="width:15%"/>
					<h3>${cartItem.name} </h3>
					<br/>
					<input type="hidden" name="SKU" value="${cartItem.SKU}">
					<input type="hidden" name="viewCart" value="true">
					<input type="submit" class="deleteButton" name= "removeFromCart" value = "Remove"/>
					</form>
					</td>
					<td style ="text-align: right;">
                    <fmt:formatNumber value = "${cartItem.cost}" 
                    					type = "currency"/>
                    </td>
				</tr>
				
			</c:forEach>
			<tr >
             <td style ="text-align: right;"><h2>Total</h2></td>
             <td style ="text-align: right;">
             <fmt:formatNumber value = "${totalCost}" 
                                              type = "currency"/>
               </td>
            </tr> 
			</tbody>
		</table>
		<form action="CartServlet" method="post">
		<input type="submit" class="button" name= "checkout" value = "Proceed to Checkout"/>
		</form>
		
</body>
</html>