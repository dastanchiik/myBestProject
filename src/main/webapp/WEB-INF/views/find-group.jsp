<%--
  Created by IntelliJ IDEA.
  User: dastan
  Date: 11.03.2023
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/views/css/forFind.css"%></style>
</head>
<body>
<table border="1px" style="margin: auto">
    <thead>
    <tr>
        <th>id</th>
        <th>group name</th>
        <th>date of start</th>
        <th>date of finish</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${group.id}</td>
        <td>${group.groupName}</td>
        <td>${group.dateOfStart}</td>
        <td>${group.dateOfFinish}</td>
    </tr>
    </tbody>
</table>
<button><a href="/groups">roll-back</a></button>
<button><a href="/companies">main</a></button>
</body>
</html>
