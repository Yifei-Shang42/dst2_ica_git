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
<body>
<div>
    <h2>
        Welcome to Precision Medicine Database
        <c:if test="${not empty username}">
            <c:out value=" ${username}!"></c:out>
        </c:if>
    </h2>
    <c:choose>
        <c:when test="${not empty username}">
            <a href="logout">Sign Out</a>
            <br>
        </c:when>
        <c:otherwise>
            <a href="signin.jsp">Sign In</a>
            <br>
        </c:otherwise>
    </c:choose>

    <form method="get" action="search">
        Search for any drug, gene or variant: <br>
        <input type="text" name="search"><br>
        <input type="submit">
    </form>
</div>
</body>
</html>
