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
    <style>
        <%@include file="/WEB-INF/views/css/form.css" %>
    </style>
</head>
<body>
<div class="box">
    <h1>Save COURSE</h1>
    <form action="/saveCourse" method="post">
        <div class="input-box">
            <input type="text" name="name" placeholder="Course name:">
            <i></i>
        </div>
        <div class="input-box">
            <input type="text" name="duration" placeholder="Duration:">
            <i></i>
        </div>
        <c:forEach items="${connection}" var="company">
            <input type="checkbox" id="${company.id}" name="id" value="${company.id}">
            <label for="${company.id}">${company.companyName}</label>
        </c:forEach>
        <button type="submit" value="save">Submit</button>
    </form>
</div>
</body>
</html>
