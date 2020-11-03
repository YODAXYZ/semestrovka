<%--
  Created by IntelliJ IDEA.
  User: aleksandr
  Date: 21.10.2020
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>SignUp</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

</head>

<body>
<jsp:include page="../common/header.jsp" />
<div class="container ">

    <h2 style="margin: 50px 0 13px 13px;">User Register Form</h2>
    <div class="col-md-6 col-md-offset-3">

        <form action="<%=request.getContextPath()%>/register" method="post">

            <div class="form-group">
                <label>Nick name:</label> <input type="text" class="form-control" id="nickName" placeholder="Nick name" name="nickName" value="${nickName}" required>
            </div>

            <div class="form-group">
                <label>Email:</label> <input type="text" class="form-control" id="email" placeholder="Email" name="email" value="${email}" required>
            </div>

            <div class="form-group">
                <label>Password:</label> <input type="password" class="form-control" id="password" placeholder="Password" name="password" value="${password}" required>
            </div>

            <div class="form-group">
                <label>Repeat password:</label> <input type="password" class="form-control" id="repeatPassword" placeholder="Repeat password" name="repeatPassword" value="${repeatPassword}" required>
            </div>

            <c:if test="${not empty password_status_2}">
                <div class="form-group">
                    <div class="alert alert-danger" role="alert">
                        Password length must be more then 8 !
                    </div>
                </div>
            </c:if>

            <c:if test="${not empty email_status_2}">
                <div class="form-group">
                    <div class="alert alert-danger" role="alert">
                        Email address invalid !
                    </div>
                </div>
            </c:if>

            <c:if test="${not empty email_status}">
                <div class="form-group">
                    <div class="alert alert-danger" role="alert">
                        This email already exist !
                    </div>
                </div>
            </c:if>

            <c:if test="${not empty password_status}">
                <div class="form-group">
                    <div class="alert alert-danger" role="alert">
                        This password not similar !
                    </div>
                </div>
            </c:if>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>
<jsp:include page="../common/footer.jsp" />
</body>

</html>
