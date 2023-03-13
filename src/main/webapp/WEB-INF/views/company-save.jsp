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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <style><%@include file="/WEB-INF/views/css/form.css"%>
    body{
        background-image: url("https://community.atlassian.com/t5/image/serverpage/image-id/29794i31C751E7412E80D9?v=v2");
    }
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
