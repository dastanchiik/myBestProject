<%--
  Created by IntelliJ IDEA.
  User: dastan
  Date: 11.03.2023
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <style><%@include file="/WEB-INF/views/css/form.css"%></style>
</head>
<body>
<form action="/saveTeacher" method="post">
  <label>first name:</label><input type="text" name="fName">
  <label>last name:</label><input type="text" name="lName">
  <label>email:</label><input type="text" name="email">
  <input type="submit" value="save">
</form>
</body>
</html>
