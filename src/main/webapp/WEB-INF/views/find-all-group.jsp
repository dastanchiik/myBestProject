<%--
  Created by IntelliJ IDEA.
  User: dastan
  Date: 11.03.2023
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="course" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head> <title>Title</title>
    <style><%@include file="/WEB-INF/views/css/table.css"%></style>
</head>
<body>
<table border="1px">
    <thead>
    <tr>
        <th>id</th>
        <th>group name</th>
        <th>date of start</th>
        <th>date of finish</th>
    </tr>
    </thead>
    <tbody>
    <course:forEach items="${all}" var="courses">
        <tr>
            <td>${courses.id}</td>
            <td><a href="/get/group/by/${courses.id}">${courses.groupName}</a></td>
            <td>${courses.dateOfStart}</td>
            <td>${courses.dateOfFinish}</td>
            <td><button><a href="/students">student</a></button></td>
            <td>
                <form action="/deleteCourse/${courses.id}" method="get">
                    <button type="submit">DELETE</button>
                </form>
            </td>
            <td>
                <form action="/upDate/group/ ${courses.id}" method="get">
                    <button type="submit">UPDATE</button>
                </form>
            </td>
        </tr>
    </course:forEach>
    </tbody>
</table>
<div>
    <button><a href="/groupForm">create new group</a></button><br>
    <button><a href="/companies">main</a></button>
</div>
</body>
</html>
