<%--
  Created by IntelliJ IDEA.
  User: dastan
  Date: 11.03.2023
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/views/css/table.css"%></style>
</head>
<body>
<table border="1px">
    <thead>
    <tr>
        <th>id</th>
        <th>first name</th>
        <th>last name</th>
        <th>email</th>
        <th>format</th>
    </tr>
    </thead>
    <tbody>
    <s:forEach var="student" items="${all}">
        <tr>
            <td>${student.id}</td>
            <td><a href="/get/student/by/${student.id}">${student.firstName}</a></td>
            <td>${student.lastName}</td>
            <td>${student.email}</td>
            <td>${student.studyFormat}</td>
            <td>
                <form action="/deleteStudent/${student.id}" method="get">
                    <button type="submit">DELETE</button>
                </form>
            </td>
            <td>
                <form action="/izmenit/student/${student.id}">
                    <button type="submit">UPDATE</button>
                </form>
            </td>
        </tr>
    </s:forEach>
    </tbody>
</table>
<button><a href="/studentForm">create new student</a></button>
<button><a href="/companies">main</a></button>
</body>
</html>
