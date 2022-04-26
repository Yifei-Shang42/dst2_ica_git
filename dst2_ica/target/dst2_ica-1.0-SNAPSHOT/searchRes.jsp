<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%--
  Created by IntelliJ IDEA.
  User: surface
  Date: 4/21/2022
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Results</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
</head>
<body>
<div class="container">
    <div class="welcome">
        <a href="index.jsp"><h2 class="title">Precision Medicine Database</h2></a>
        <h3 class="sub-title">Your Search for ${search} Returned ${output.size()} Result(s):</h3> <br>
    </div>
    <br>
    <hr>
    <div class="res-table">
        <table>
            <thead>
                <tr>
                    <th>Results:</th>
                    <th>Category:</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${output}" var="result">
                <tr>
                    <td>
                        <p><a href="display?search=${result[0]}&db=${result[1]}">
                            <c:out value="${result[0]}"></c:out>
                        </a></p>
                    </td>
                    <td>
                        <p><c:out value="${result[1]}"></c:out></p>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="footer">
        <p class="foot">Developed by 2020BMI DST2 Group 3, ZJE Institute</p>
        <p class="foot">Data Source: <a href="https://www.pharmgkb.org/">PharmGKB Database</a></p>
    </div>
</div>
</body>
</html>
