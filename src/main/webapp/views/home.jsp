<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 10/5/2024
  Time: 10:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Đây là trang chủ</h1>
<a href="/register">Đăng kí</a>
<a href="/login">Đăng nhập</a>
<a href="/logout">Đăng xuất</a>
<span>${sessionScope.get("user_login").fullName}</span>
</body>
</html>
