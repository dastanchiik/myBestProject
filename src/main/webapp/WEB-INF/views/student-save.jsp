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
    <style><%@include file="/WEB-INF/views/css/form.css"%></style>
</head>
<body>
<form action="/saveStudent" method="post">
    <label>first name:</label><input type="text" name="name">
    <label>last name:</label><input type="text" name="lName">
    <label>email</label><input type="text" name="email">
    <label>format:</label><input type="text" name="format">
    <input type="submit" value="save">
</form>
</body>
</html>
