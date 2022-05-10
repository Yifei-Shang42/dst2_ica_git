<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%--
  Created by IntelliJ IDEA.
  User: surface
  Date: 4/21/2022
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
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
                <a href="display?search=${search}&db=${db}&section=overview" class="nav-item">Overview</a><br><br>
                <c:if test="${db.equals('drug')}">
                    <a href="display?search=${search}&db=${db}&section=drug-label" class="nav-item">Drug Labels</a><br><br>
                </c:if>
                <a href="display?search=${search}&db=${db}&section=clinical-annotation" class="nav-item">Clinical Annotation</a><br><br>
                <a href="display?search=${search}&db=${db}&section=related-to" class="nav-item">Related To</a><br><br>
                <a href="display?search=${search}&db=${db}&section=literature" class="nav-item">Literature</a><br><br>
                <a href="display?search=${search}&db=${db}&section=pathway" class="nav-item">Pathways</a><br><br>
            </div>
            <div class="res-table">
                <c:if test="${!output.isEmpty()}">
                    <div class="current-section">
                        <c:if test="${section.equals('overview')}">
                            <h3>Overview</h3>
                        </c:if>
                        <c:if test="${section.equals('clinical-annotation')}">
                            <h3>Clinical Annotation</h3>
                        </c:if>
                        <c:if test="${section.equals('related-to')}">
                            <h3>Related To</h3>
                        </c:if>
                        <c:if test="${section.equals('literature')}">
                            <h3>Literature</h3>
                        </c:if>
                        <c:if test="${section.equals('pathway')}">
                            <h3>Pathway</h3>
                        </c:if>
                    </div>
                        <table class="table">
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
                    </c:if>
                <c:if test="${output.isEmpty()}">
                        <h2>
                            Sorry, no records are available for <c:out value="${search}"></c:out> in this section.
                        </h2>
                    </c:if>
            </div>
        </div>
        <div class="footer">
            <p class="foot">Developed by 2020BMI DST2 Group 3, ZJE Institute</p>
            <p class="foot">Data Source: <a href="https://www.pharmgkb.org/">PharmGKB Database</a></p>
        </div>
    </div>
</body>
</html>
