<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 2019-12-3
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
<section>
    <div class="container">
        <div class="welcome">
            <a href="index.jsp">
                <h2 class="title">
                    Welcome to Precision Medicine Database
                    <c:if test="${not empty username}">
                        <c:out value=" ${username}!"></c:out>
                    </c:if>
                </h2>
            </a>

        </div>
        <div class="sign-in">
            <c:choose>
                <c:when test="${not empty username}">
                    <button><a href="logout">Sign Out</a></button>
                </c:when>
                <c:otherwise>
                    <button><a href="signin.jsp">Sign In</a></button>
                </c:otherwise>
            </c:choose>
        </div>
        <div class="form">
            <form method="get" action="search">
                <p>Search for any Drug, Gene or Variant:</p> <br>
                <input type="text" name="search"><br>
                <input type="submit">
            </form>
        </div>
        <div class="footer">
            <p class="foot">Developed by 2020BMI DST2 Group 3, ZJE Institute</p>
            <p class="foot">Data Source: <a href="https://www.pharmgkb.org/">PharmGKB Database</a></p>
        </div>
    </div>
</section>
</body>
</html>
