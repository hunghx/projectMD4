<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AD
  Date: 10/5/2024
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/sign-in" method="post">
    <label for="">Username</label>    <input type="text" name="username"> <br>
    <label for="">Password</label>    <input type="text" name="password"> <br>
    <c:if test="${error!=null}">
        <p style="color: red">${error}</p>
    </c:if>
    <button type="submit">Login</button>
</form>
</body>
</html>
