<%-- 
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
        <h1 align="center">Shop ${department}</h1> 
        <div class="row">
                <c:forEach items="${categories}" var="category">
                        <div class="column ${category.name}">                     
                        <div class="content">
                            <a href="http://localhost:8080/ToolTime/DepartmentsServlet?department=${department}&category=${category.name}">
                                <img src= ${category.imagePath} style="width:100%"/> 
                            </a>
                            <h3>${category.name}</h3>  
                        </div>
                        </div>
                </c:forEach>
        </div>
        </div>
    </body>
</html>

