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
    <div class="welcome">
        <h2>Sign In</h2>
    </div>
    <div class="form">
        <form action="login" method="post">
            Username: <input type="text" name="username"> <br>
            Password: <input type="password" name="password"> <br>
            <input type="submit">
        </form>
    </div>
    <h3>Not registered yet? <a href="register">Register now!</a></h3>
</body>
</html>
