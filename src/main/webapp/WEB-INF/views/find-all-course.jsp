<%--
  Created by IntelliJ IDEA.
  User: dastan
  Date: 10.03.2023
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="course" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file="/WEB-INF/views/css/table.css" %>
    </style>

</head>
<body>
<table border="1px">
    <thead>
    <tr>
        <th>id</th>
        <th>course name</th>
        <th>duration</th>
    </tr>
    </thead>
    <tbody>
    <course:forEach items="${alls}" var="courses">
        <tr>
            <td>${courses.id}</td>
            <td><a href="/get/course/by/${courses.id}">${courses.courseName}</a></td>
            <td>${courses.duration}</td>
            <td>
                <button><a href="/teachers">teacher</a></button>
            </td>
            <td>
                <form action="/deleteCourse/${courses.id}" method="get">
                    <button type="submit">DELETE</button>
                </form>
            </td>
            <td>
                <form action="/updates/course/${courses.id}" method="get">
                    <button type="submit">UPDATE</button>
                </form>
            </td>
        </tr>
    </course:forEach>
    </tbody>
</table>
<div>
    <button><a href="/courseForm">create new course</a></button>
    <br>
    <button><a href="/companies">main</a></button>
</div>
</body>
</html>
