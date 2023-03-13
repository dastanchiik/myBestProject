<%--
  Created by IntelliJ IDEA.
  User: dastan
  Date: 11.03.2023
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2px">
  <thead>
  <tr>
  <th>id</th>
    <th>first name</th>
    <th>last name</th>
    <th>email</th>
  </tr>
  </thead>
  <tbody>
  <tr>
    <td>${company.id}</td>
    <td>${company.firstName}</td>
    <td>${company.lastName}</td>
    <td>${company.email}</td>
  </tr>
  </tbody>
</table>
<button><a href="/students">roll-back</a></button>
<button><a href="/companies">main</a></button>
</body>
</html>
