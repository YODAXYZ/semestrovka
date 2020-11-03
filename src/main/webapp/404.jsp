<%--
  Created by IntelliJ IDEA.
  User: aleksandr
  Date: 27.10.2020
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page errorPage="404.jsp" %>--%>
<%@ page isErrorPage="true"%>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="../../../template/css/error-page.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container emp-profile">
        <div class="profile-head">
            <h1> 404 </h1>
            <h5>
               Ooops ! Something was wrong !
            </h5>
        </div>
</div>
<jsp:include page="../common/footer.jsp" />
</body>
</html>
