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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
</head>
<body>
<section>
    <div class="container">
        <div class="welcome">
            <h2>
                Welcome to Precision Medicine Database
                <c:if test="${not empty username}">
                    <c:out value=" ${username}!"></c:out>
                </c:if>
            </h2>
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
        <hr>
        <div class="form">
            <form method="get" action="search">
                <p>Search for any Drug, Gene or Variant:</p> <br>
                <input type="text" name="search"><br>
                <br>
                <input type="submit">
            </form>
        </div>
    </div>
</section>
</body>
</html>