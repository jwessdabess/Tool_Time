<%-- 
    Document   : electrical
    Created on : Apr 28, 2018, 12:58:22 PM
    Author     : MikeWilkinson
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       	<%@ include file = "includes/header.jsp" %>
        <title>${department} Department</title>
        <link href="styles/departments.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="scripts/filterSelection.js"></script> 
    </head>
    <body onload="filterSelection('all')"> 
    	<%@include file = "includes/navbar.jsp" %>
        <div class="main">
        <h1 align="center">Shop ${department}</h1>
        <div id="myBtnContainer">
            <button class="btn active" onclick="filterSelection('all')"> Show all</button>
            <c:forEach items="${categories}" var="category">
                <button class="btn" onclick="filterSelection('${category}')"> ${category}</button>
            </c:forEach>
        </div> 
        <div class="row">
                <c:forEach items="${products}" var="product">
                        <div class="column ${product.category}">                     
                        <div class="content">
                            <img src= ${product.imagePath} style="width:100%"/> 
                            <div class="name_block">
                            <h3>${product.name}</h3>
                            </div> 
                            <h4>Cost: <fmt:formatNumber value = "${product.cost}" type = "currency"/> </h4>
                            <input class ="button" type= "submit" class="button" name="addToCart_${product.SKU}" value="Add To Cart" />
                        </div>
                        </div>
                </c:forEach>
        </div>
        </div> 
    </body>
</html>
