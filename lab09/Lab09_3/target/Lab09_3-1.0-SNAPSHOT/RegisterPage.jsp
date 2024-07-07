<%--
  Created by IntelliJ IDEA.
  User: Ваня
  Date: 13.04.2024
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RegisterPage</title>
    <style>
        *{
            margin: 5px;
        }
    </style>
</head>
<body>
<h2>Регистрация</h2>
<form action="RegisterServlet">
    <label>Login: </label><br>
    <input name="name_register" type="text"/><br>
    <label>Password: </label><br>
    <input name="password_register" type="password"/><br>
    <input type="submit" value="Регистрация"/>
</form>
<a href="index.jsp">Войти</a>
</body>
</html>
