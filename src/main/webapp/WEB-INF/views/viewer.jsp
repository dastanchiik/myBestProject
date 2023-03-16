<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dastan
  Date: 16.03.2023
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/views/css/forView.css"%></style>
</head>
<body>
<h3>courses:</h3>
<table border="2px">
    <thead>
    <tr>
        <th>ID</th>
        <th>Course Name</th>
        <th>Duration</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${courses}" var="course">
        <tr>
            <td>${course.id}</td>
            <td>${course.courseName}</td>
            <td>${course.duration}</td>
        </tr>
    </c:forEach>
    </tbody>
</table><br>
<h3>groups:</h3>
<br><table border="2px">
    <thead>
    <tr>
        <th>ID</th>
        <th>group Name</th>
        <th>date of start</th>
        <th>date of finish</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${groups}" var="course">
        <tr>
            <td>${course.id}</td>
            <td>${course.groupName}</td>
            <td>${course.dateOfStart}</td>
            <td>${course.dateOfFinish}</td>
        </tr>
    </c:forEach>
    </tbody>
</table><br>
<h3>students:</h3>
<br><table border="2px">
<thead>
<tr>
    <th>Id</th>
    <th>first name</th>
    <th>last name</th>
    <th>email</th>
</tr>
</thead>
    <tbody>
    <c:forEach items="${students}" var="student">
    <tr>
        <td>${student.id}</td>
        <td>${student.firstName}</td>
        <td>${student.lastName}</td>
        <td>${student.email}</td>
    </tr>
    </c:forEach>
    </tbody>
</table><br>
<h3>teachers:</h3>
<br><table border="2px">
    <thead>
    <tr>
        <th>Id</th>
        <th>first name</th>
        <th>last name</th>
        <th>email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${teachers}" var="teacher">
        <tr>
            <td>${teacher.id}</td>
            <td>${teacher.firstName}</td>
            <td>${teacher.lastName}</td>
            <td>${teacher.email}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
