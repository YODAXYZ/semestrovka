<%--
  Created by IntelliJ IDEA.
  User: aleksandr
  Date: 27.10.2020
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Profile</title>
    <link rel="stylesheet" href="../../../template/css/profile.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<jsp:include page="../common/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container emp-profile">
    <c:if test="${not empty emailStatus}">
        <div method="GET" action="#">
            <div class="row">
                <div class="col-md-6">
                    <div class="profile-head">
                        <h5>
                            ${nameStatus}
                        </h5>
                    </div>
                </div>
                <div class="col-md-3">
                    <a href="http://localhost:8080/edit-profile"><input type="submit" class="profile-edit-btn" name="btnAddMore" value="Edit Profile"/></a>
                </div>
                <div class="col-md-3">
                    <a href="http://localhost:8080/delete-profile"><input type="submit" class="profile-delete-btn" name="btnAddMore" value="Delete Profile"/></a>
                </div>
            </div>
                <div class="col-md-8">
                    <div class="tab-content profile-tab" id="myTabContent">
                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Nick Name</label>
                                </div>
                                <div class="col-md-6">
                                    <p>${nameStatus}</p>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6">
                                    <label>Email</label>
                                </div>
                                <div class="col-md-6">
                                    <p>${emailStatus}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
    </c:if>
    <c:if test="${empty emailStatus}">
        <div class="profile-head">
            <h5>
                To see the profile register or log in
            </h5>
        </div>
    </c:if>
</div>
<jsp:include page="../common/footer.jsp" />
</body>
</html>
