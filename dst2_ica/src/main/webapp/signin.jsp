<%--
  Created by IntelliJ IDEA.
  User: surface
  Date: 4/21/2022
  Time: 7:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
</head>
<body>
<div class="container">
    <div class="welcome">
        <a href="index.jsp"><h2 class="title">Precision Medicine Database</h2></a>
        <h3 class="sub-title">Sign In</h3>
    </div>
    <div class="form">
        <form action="login" method="post">
            Username: <input type="text" name="username"> <br>
            Password: <input type="password" name="password"> <br>
            <input type="submit">
        </form>
    </div>
    <div class="register">
        <h3 id="register">Not registered yet? </h3>
        <a href="register.jsp">Register now!</a>
    </div>
    <div class="footer">
        <p class="foot">Developed by 2020BMI DST2 Group 3, ZJE Institute</p>
        <p class="foot">Data Source: <a href="https://www.pharmgkb.org/">PharmGKB Database</a></p>
    </div>
</div>
</body>
</html>
