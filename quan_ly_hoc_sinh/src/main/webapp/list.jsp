<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 19/02/2024
  Time: 10:27 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> danh sách</h2>
<p>
    <a href="student?action=create">thêm</a>
</p>
<form method="post">
    <table border="1px">
        <tr>
            <td>id</td>
            <td>name</td>
            <td>email</td>
            <td>address</td>
        </tr>


        <c:forEach items="${ds}" var="student">
            <tr>
                <td>${student.getId()}</td>
                <td>${student.getName()}</td>
                <td>${student.getEmail()}</td>
                <td>${student.getAddress()}</td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
