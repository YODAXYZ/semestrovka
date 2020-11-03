<%--
  Created by IntelliJ IDEA.
  User: aleksandr
  Date: 26.10.2020
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Main</title>
    <script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <jsp:include page="WEB-INF/views/common/header.jsp" />
    <div class="container">
        <h1 style="margin-top: 50px" class="text-center">Statistic</h1><br>
        <c:if test="${not empty emailStatus}">
            <h4 style="margin-bottom: 20px" class="text-center">${main_info}</h4>
            <c:if test="${not empty images}">
                <img width="380px" height="380px" class="rounded float-left" src="template/plots_images/CaseStat.png" alt="">
                <img width="380px" height="380px" class="rounded float-right" src="template/plots_images/FullStat.png" alt="">
                <br>
            </c:if>
            <a href="http://localhost:8080/send-statistic"><button type="button" id="send-stat" onclick="myFunction()" class="btn btn-secondary btn-lg btn-block">Send statistic to my email !</button></a>
        </c:if>
        <c:if test="${empty emailStatus}">
            <h1 class="display-4">If you want send statistic to email. And take more info. <a href="http://localhost:8080/login">Login</a> or
                <a href="http://localhost:8080/register">Registration</a> !</h1><br>
        </c:if>

        <c:if test="${not empty temp}">
            <table style="margin-bottom: 100px" class="table table-striped">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Country</th>
                    <th scope="col">Cases</th>
                    <th scope="col">Deaths</th>
                    <th scope="col">Region</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${temp}" var="tr" >
                        <tr>
                            <c:forEach items="${tr}" var="elem">
                                <td>${elem}</td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
    <jsp:include page="WEB-INF/views/common/footer.jsp" />
    <script src="template/js/button_alert.js"></script>
</body>
</html>
