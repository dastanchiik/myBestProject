<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dastan
  Date: 11.03.2023
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/views/css/form.css" %>
        .select {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 4px;
            width: 200px;
        }

        .select option {
            font-size: 16px;
        }

    </style>
</head>
<body>
<div class="box">
    <h1>Save student</h1>
    <form action="/saveStudent" method="post">
        <div class="input-box">
            <input type="text" name="name" placeholder="first name:">
            <i></i>
        </div>
        <div class="input-box">
            <input type="text" name="lName" placeholder="last name:">
            <i></i>
        </div>
        <div class="input-box">
            <input type="text" name="email" placeholder="email:">
            <i></i>
        </div>
        <div class="input-box">
<%--            <input type="text" name="format" placeholder="Study format:">--%>
            <select name="format" class="select">
                <option>ONLINE</option>
                <option>OFFLINE</option>
            </select>
            <i></i>
        </div>
        <c:forEach items="${groupConnection}" var="company">
            <input type="checkbox" id="${company.id}" name="id" value="${company.id}">
            <label for="${company.id}">${company.groupName}</label>
        </c:forEach>
        <input type="submit" value="save">
    </form>
</div>
</body>
</html>
