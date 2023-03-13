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
    <input type="submit" value="save">
</form>
</body>
</html>
