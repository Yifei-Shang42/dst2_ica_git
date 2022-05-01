<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%--
  Created by IntelliJ IDEA.
  User: surface
  Date: 4/21/2022
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Result Display</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
    <div class="container">
        <div class="welcome">
            <a href="index.jsp"><h2 class="title">Precision Medicine Database</h2></a>
<%--            <h3 class="sub-title">${db.substring(0,1).toUpperCase()+db.substring(1)}</h3> <br>--%>
            <h3 class="sub-title">${search}</h3> <br>
        </div>
        <div class="result-container">
            <div class="sidenav">
                <a href="display?search=${search}&db=${db}&section=overview" class="nav-item">Overview</a><br>
                <c:if test="${db.equals('Drug')}">
                    <a href="display?search=${search}&db=${db}&section=drug-label" class="nav-item">Drug Labels</a><br>
                </c:if>
                <a href="display?search=${search}&db=${db}&section=clinical-annotation" class="nav-item">Clinical Annotation</a><br>
                <a href="display?search=${search}&db=${db}&section=related-to" class="nav-item">Related To</a><br>
                <a href="display?search=${search}&db=${db}&section=literature" class="nav-item">Literature</a><br>
                <a href="display?search=${search}&db=${db}&section=pathway" class="nav-item">Pathways</a><br>
            </div>
            <div class="res-table">
                <table>
                    <thead>
                    <tr>
                        <c:forEach items="${output[0].getHead()}" var="head">
                            <th>
                                <c:out value="${head}"></c:out>
                            </th>
                        </c:forEach>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${output.getData()}" var="row">
                        <tr>
                            <c:forEach items="${row}" var="data">
                                <td>
                                    <c:if test="">
                                        <a href="display?search=${}&db=${}&section=overview">
                                            <c:out value="${data}"></c:out>
                                        </a>
                                    </c:if>
                                    <c:if test="">

                                    </c:if>

                                </td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="footer">
            <p class="foot">Developed by 2020BMI DST2 Group 3, ZJE Institute</p>
            <p class="foot">Data Source: <a href="https://www.pharmgkb.org/">PharmGKB Database</a></p>
        </div>
    </div>
</body>
</html>
