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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
</head>
<body>
<div class="container">
    <div class="welcome">
        <a href="index.jsp"><h2 class="title">Precision Medicine Database</h2></a>
        <h3 class="sub-title">Your Search for ${search} Returned ${output.size()} Result(s):</h3> <br>
    </div>
    <br>
    <div class="res-table">
        <table>
            <thead>
                <tr>
                    <c:forEach items="${output[0].getHead()}" var="head">
                        <th>
                            <c:out value="head"></c:out>
                        </th>
                    </c:forEach>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${output}" var="result">
                <tr>
                    <c:forEach items="${result.getData()}" var="data">
                        <td>
                            <c:if test="${data.hasLink()}">
                                <c:if test="${data.hasMultipleLinks()}">
                                    <c:forEach items="${data.getInfoList()}" var="info">
                                        <a href="${data.getLink().replaceAll("~", info.replaceAll(" ", "%20"))}">
                                            <c:out value="${info}"></c:out>
                                        </a>
                                        <br>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${!data.hasMultipleLinks()}">
                                    <a href="${data.getLink()}">
                                        <c:out value="${data.getInfo()}"></c:out>
                                    </a>
                                </c:if>
                            </c:if>
                            <c:if test="${!data.hasLink()}">
                                <p>
                                    <c:out value="${data.getInfo()}"></c:out>
                                </p>
                            </c:if>
                        </td>
                    </c:forEach>
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
