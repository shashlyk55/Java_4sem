<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <style>
    *{
      margin: 5px;
    }
  </style>
</head>
<body><h2>Вход</h2>
<form action="LogInServlet">
  <label>Login: </label><br>
  <input name="name_login" type="text"/><br>
  <label>Password: </label><br>
  <input name="password_login" type="password"/><br>
  <input type="submit" value="Войти"/>
</form>
<a href="RegisterPage.jsp">Регистрация</a>
</body>
</html>