%-- 
    Document   : electrical
    Created on : Apr 28, 2018, 12:58:22 PM
    Author     : MikeWilkinson
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%--<c:import url="/web/includes/header.html" /> --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${department} Department</title>
        <link href="styles/departments.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="scripts/filterSelection.js"></script> 
    </head>
    <body onload="filterSelection('all')">
        <div class="main">
        <h1 align="center">Shop ${department} ${category}</h1> 
        <div class="row">
                <c:forEach items="${products}" var="product">
                        <div class="column ${product.category}">                     
                        <div class="content">
                            <img src= ${product.imagePath} style="width:100%"/>  
                            <h3>${product.name}</h3>
                            <h5>${product.description}</h5> 
                            <p><b>PLU: </b> ${product.PLU} </p>
                            <h4>Cost: <fmt:formatNumber value = "${product.cost}" type = "currency"/> </h4>
                            <p><b>Dimensions: </b> ${product.dimensions} </p> 
                            <input class ="button" type= "submit" class="button" name="addToCart ${productCount}" value="Add To Cart" />
                        </div>
                        </div>
                </c:forEach>
            
        </div>
        </div>
    </body>
</html>
