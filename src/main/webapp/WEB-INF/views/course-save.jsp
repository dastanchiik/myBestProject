<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dastan
  Date: 10.03.2023
  Time: 17:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/views/css/form.css"%></style>
</head>
<body>
<h1 style="text-align: center">Save COURSE</h1>
<form action="/saveCourse" method="post">
    <div class="form-group">
        <label for="courseName">Course name</label>
        <input class="form-control" name="name" id="courseName" aria-describedby="courseName"
               placeholder="Enter course name">
    </div>
    <div class="form-group">
        <label for="duration">Duration</label>
        <input type="text" class="form-control" name="duration" id="duration" placeholder="Enter duration">
        <c:forEach items="${connection}" var="company">
            <input type="checkbox" id="${company.id}" name="id" value="${company.id}">
            <label for="${company.id}">${company.companyName}</label>
        </c:forEach>
    </div>
    <button type="submit" class="btn btn-primary" value="save">Submit</button>
</form>
</body>
</html>
