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
            <h3 class="sub-title">${search}</h3> <br>
        </div>
        <div class="result-container">
            <div class="sidenav">
                <a href="">Overview</a><br>
                <a href="">Clinical Annotation</a><br>
                <a href="">Related To</a><br>
                <a href="">Literature</a><br>
                <a href="">Pathways</a><br>
            </div>
            <div class="result">
                <p>This is result</p>
            </div>
        </div>
        <br>
        <hr>
        <div class="footer">
            <p class="foot">Developed by 2020BMI DST2 Group 3, ZJE Institute</p>
            <p class="foot">Data Source: <a href="https://www.pharmgkb.org/">PharmGKB Database</a></p>
        </div>
    </div>
</body>
</html>
