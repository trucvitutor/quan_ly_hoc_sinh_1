<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 19/02/2024
  Time: 1:39 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student" method="post">
    <h2>Form tạo mới</h2>
    <input type="hidden" name="action" value="create">

    <table>
        <tr>
            <td>name </td>
            <td>  <input type="text" name="name"> </td>
        </tr>
        <tr>
            <td>email </td>
            <td>  <input type="text" name="email"> </td>
        </tr>
        <tr>
            <td>address </td>
            <td> <input type="text" name="address"> </td>
        </tr>
        <tr>
            <td>
                <button type="submit">
                    create
                </button>
            </td>
        </tr>
    </table>



</form>
</body>
</html>
