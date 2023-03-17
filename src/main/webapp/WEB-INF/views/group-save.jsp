<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dastan
  Date: 11.03.2023
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/views/css/form.css"%></style>
</head>
<body>
<h1>Save group</h1>
<form action="/saveGroups" method="post">
    <label>group name:</label><input type="text" name="name">
    <label>date of start:</label><input type="text" name="start">
    <label>date of finish:</label><input type="text" name="finish">
    <br>
    <h1>company connection</h1>
    <c:forEach items="${companyConnection}" var="company">
        <input type="checkbox" id="${company.id}" name="companyId" value="${company.id}">
        <label for="${company.id}">${company.companyName}</label>
    </c:forEach>
    <br>
    <h1>course connection</h1>
    <c:forEach items="${courseConnection}" var="company">
        <input type="radio" id="${company.id}" name="courseId" value="${company.id}">
        <label for="${company.id}">${company.courseName}</label>
    </c:forEach>
    <input type="submit" value="save">
</form>
</body>
</html>
