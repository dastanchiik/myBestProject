<%--
  Created by IntelliJ IDEA.
  User: dastan
  Date: 11.03.2023
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/views/css/form.css"%></style>
</head>
<body>
<form action="/student/update/${company.id}" method="post">
  <label>first name:</label><input value="${company.firstName}" type="text" name="name">
    <label>last name:</label><input value="${company.lastName}" type="text" name="lName">
    <label>email:</label><input value="${company.email}" type="text" name="email">
    <label>format:</label><input value="${company.studyFormat}" name="format">
    <input type="submit" value="update">
</form>
</body>
</html>
