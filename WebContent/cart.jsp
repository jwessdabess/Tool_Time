<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       	<%@ include file = "includes/header.jsp" %>
		<title>Cart</title>
        <link href="styles/departments.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="scripts/filterSelection.js"></script> 
    </head>
<body>
		<%@include file = "includes/navbar.jsp" %>
		<b>Cart for ${user.firstName} ${user.lastName}</b>
		<br />
		<br />
		<table >
            <thead>
                <tr>
                    <th>
                        <b> Your Items</b> 
                    </th>
                    <th></th>
                    <th>
                        <b>Cost</b>
                    </th>
                    <th></th>
                </tr>
            </thead>
        	<tbody>
			<c:forEach items="${cart.CartItems}" var="cartItem">
				<tr>
					<td></td>
					<td align="right">
                    <fmt:formatNumber value = "${cartItem.cost}" 
                    					type = "currency"/>
                    </td>
				</tr>
			</c:forEach>
			<tr >
             <td></td>
             <td align="right">
             <b>Total</b> <fmt:formatNumber value = "${totalCost}" 
                                              type = "currency"/>
               </td>
            </tr> 
			</tbody>
		</table>
</body>
</html>