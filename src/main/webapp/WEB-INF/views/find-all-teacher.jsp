<%--
  Created by IntelliJ IDEA.
  User: dastan
  Date: 11.03.2023
  Time: 20:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2px">
    <thead>
    <tr>
        <th>id</th>
        <th>first name</th>
        <th>last name</th>
        <th>email</th>
    </tr>
    </thead>
    <tbody>
    <t:forEach items="${all}" var="teacher">
        <tr>
            <td>${teacher.id}</td>
            <td>
                <a href="/get/teacher/by/${teacher.id}">${teacher.firstName}</a>
            </td>
            <td>${teacher.lastName}</td>
            <td>${teacher.email}</td>
            <td>
                <form action="/deleteTeacher/${teacher.id}" method="get">
                    <button type="submit">DELETE</button>
                </form>
            </td>
            <td>
                <form action="/zamenit/teacher/${teacher.id}">
                    <button type="submit">UPDATE</button>
                </form>
            </td>
        </tr>
    </t:forEach>
    </tbody>
</table>
<button><a href="/teacherForm">create new teacher</a></button>
<button><a href="/allRemove/teacher">delete all</a></button>
<button><a href="/companies">main</a></button>
</body>
</html>
