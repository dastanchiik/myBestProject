<%--
  Created by IntelliJ IDEA.
  User: dastan
  Date: 11.03.2023
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/views/css/form.css"%></style>
</head>
<body>
<h1>Update Group</h1>
<form action="/group/update/${group.id}" method="post">
    <label>Group name:</label><input value="${group.groupName}" type="text" name="name">
    <label>date of start:</label><input value="${group.dateOfStart}" type="text" name="start">
    <label>date of finish:</label><input value="${group.dateOfFinish}" type="text" name="finish">
    <input type="submit" value="update">
</form>
</body>
</html>
