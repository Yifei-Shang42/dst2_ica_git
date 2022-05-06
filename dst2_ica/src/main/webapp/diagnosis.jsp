<%--
  Created by IntelliJ IDEA.
  User: surface
  Date: 5/6/2022
  Time: 7:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Diagnostic System</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
</head>
<body>
<div class="container">
    <div class="welcome">
        <a href="index.jsp"><h2 class="title">Precision Medicine Database</h2></a>
        <h3 class="sub-title">Diagnosis System</h3> <br>
    </div>
    <br>
    <div class="form">
        <form method="post" action="diagnosis">
            <p>Input a List of Variant IDs (How to generate them? <a href="guideline.pdf">CLICK HERE</a>)</p>
            <textarea name="searchList" cols="40" rows="5"></textarea><br>
            <input type="file" name="file" size="50"><br>
            <input type="submit">
        </form>
    </div>
    <div class="footer">
        <p class="foot">Developed by 2020BMI DST2 Group 3, ZJE Institute</p>
        <p class="foot">Data Source: <a href="https://www.pharmgkb.org/">PharmGKB Database</a></p>
    </div>
</div>
</body>
</html>
