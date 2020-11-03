<%--
  Created by IntelliJ IDEA.
  User: aleksandr
  Date: 26.10.2020
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<jsp:include page="../common/header.jsp"></jsp:include>
<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
    <h2 style="margin: 50px 0 13px 0;">Login Form</h2>
    <form action="<%=request.getContextPath()%>/login" method="post">

        <div class="form-group">
            <label for="uname">Email:</label> <input type="text" class="form-control" id="email" placeholder="User Name" name="email" value="${email}" required>
        </div>

        <div class="form-group">
            <label for="uname">Password:</label> <input type="password" class="form-control" id="password" placeholder="Password" name="password" value="${password}" required>
        </div>
        <c:if test="${not  empty status}">
            <div class="form-group">
                <div class="alert alert-danger" role="alert">
                    Not correct email or password
                </div>
            </div>
        </c:if>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
<jsp:include page="../common/footer.jsp"></jsp:include>
</body>

</html>
