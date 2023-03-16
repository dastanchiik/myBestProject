<%--
  Created by IntelliJ IDEA.
  User: dastan
  Date: 09.03.2023
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style><%@include file="/WEB-INF/views/css/table.css"%></style>

</head>
<body>
<table border="1px" style="color: green">
    <thead>
    <tr>
        <th>id</th>
        <th>company name</th>
        <th>locatedCountry</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${all}" var="company">
    <tr>
        <td>${company.id}</td>
        <td>
            <a href="/get/by/${company.id}">${company.companyName}</a>
        </td>
        <td>${company.locatedCountry}</td>
        <td><button type="submit"><a href="/courses">course</a></button></td>
        <td><button type="submit"><a href="/groups">groups</a></button></td>
        <td>
            <form action="/deleteCompany/${company.id}" method="get">
            <button type="submit">DELETE</button>
            </form>
        </td>
        <td>
            <form action="/update/${company.id}" method="get">
            <button type="submit">UPDATE</button>
            </form>
        </td>
        <td>
            <form action="/findAll/${company.id}" method="get">
                <button type="submit">CONNECTIONS</button>
            </form>
        </td>
    </tr>
    </c:forEach>
    </tbody>
</table>
<div class="button">
<button><a href="/companyForm" class="company">create new company</a></button><br>
</div>
</body>
</html>
