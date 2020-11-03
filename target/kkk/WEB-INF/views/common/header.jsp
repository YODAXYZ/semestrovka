<%--
  Created by IntelliJ IDEA.
  User: aleksandr
  Date: 21.10.2020
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: #1E835F">
        <div>
            <a href="<%= request.getContextPath() %>/"><h1 class="navbar-brand">Corona Analytics</h1></a>
        </div>
        <c:if test="${empty emailStatus}">
            <ul class="navbar-nav navbar-collapse justify-content-end">
                <li><a href="<%= request.getContextPath() %>/login" class="nav-link">Login</a></li>
                <li><a href="<%= request.getContextPath() %>/register" class="nav-link">SignUp</a></li>
            </ul>
        </c:if>
        <c:if test="${not empty emailStatus}">
            <ul class="navbar-nav navbar-collapse justify-content-end">
                <li><a href="<%= request.getContextPath() %>/profile" class="nav-link">Profile</a></li>
                <li><a href="<%= request.getContextPath() %>/log_out" class="nav-link">Log Out</a></li>
            </ul>
        </c:if>
        ${user}
    </nav>
</header>
</html>
