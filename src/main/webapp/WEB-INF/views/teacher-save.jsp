<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  <style><%@include file="/WEB-INF/views/css/form.css"%>
  .teacher{
    transform: translate(0em,0em);
  }
  </style>
</head>
<body>
<div class="teacher">
<h1>Save teacher</h1>
<form action="/saveTeacher" method="post">
  <label>first name:</label><input type="text" name="fName">
  <label>last name:</label><input type="text" name="lName">
  <label>email:</label><input type="text" name="email">
  <c:forEach items="${courseConnectionWithTeacher}" var="company">
    <input type="checkbox" id="${company.id}" name="id" value="${company.id}">
    <label for="${company.id}">${company.courseName}</label>
  </c:forEach>
  <input type="submit" value="save">
</form>
</div>
</body>
</html>
