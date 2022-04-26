<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: surface
  Date: 4/25/2022
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
</head>
<body>
<div class="container">
    <div class="welcome">
        <a href="index.jsp"><h2 class="title">Precision Medicine Database</h2></a>
        <h3 class="sub-title">Register Your Account</h3>
    </div>
    <div class="form">
        <form action="register" method="post">
            Username: <input type="text" name="username"> <br>
            Password: <input type="password" name="password"> <br>
            <input type="submit">
        </form>
        <c:if test="${success==true}">
            <h3>Register Successful!</h3>
        </c:if>
        <c:if test="${success==false}">
            <h3>Invalid Username!</h3>
        </c:if>
    </div>
    <div class="footer">
        <p class="foot">Developed by 2020BMI DST2 Group 3, ZJE Institute</p>
        <p class="foot">Data Source: <a href="https://www.pharmgkb.org/">PharmGKB Database</a></p>
    </div>
</div>
</body>
</html>
