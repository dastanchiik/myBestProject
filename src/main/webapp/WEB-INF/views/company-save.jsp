<%--
  Created by IntelliJ IDEA.
  User: dastan
  Date: 09.03.2023
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/views/css/form.css"%>
    </style>

</head>
<body>
<h1 style="text-align: center">Save company</h1>
<form action="/saveCompany" method="post">
    <label for="companyName">Company name</label>
    <input class="form-control" name="name" id="companyName" aria-describedby="companyName"
           placeholder="Enter company name">
    <label for="locatedCountry">Country:</label>
    <input type="text" class="form-control" name="located" id="locatedCountry" placeholder="Enter located country">
    <input type="submit" value="save">
</form>
</body>
</html>
