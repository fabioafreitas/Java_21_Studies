<%--
  Created by IntelliJ IDEA.
  User: fbioa
  Date: 01/06/2025
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="../styles/my_styles.css" />
</head>
<body>
<header>
    <nav class="nav-container">
        <a class="button-wrap button-default" href="/">Initial Page</a>
        <a class="button-wrap button-default" href="/register">Login Page</a>
    </nav>
</header>
<form class="content" action="/register" method="post">
    <input type="text" name="username" placeholder="Create an username" required><br><br>
    <input type="password" name="create-password" placeholder="Create a password" required><br><br>
    <input type="password" name="confirm-password" placeholder="Repeat the Password" required><br><br>
    <input type="submit" value="Register">
    <c:if test="${not empty error}">
        <p style="color: red">${error}</p>
    </c:if>
</form>



</body>
</html>
