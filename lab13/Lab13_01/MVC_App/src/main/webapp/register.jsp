<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register Page</title>
</head>
<body>
<h1>Register</h1>
<form action="main" method="post">
    <input type="hidden" name="command" value="register"/>
    Username: <input type="text" name="username"/><br/>
    Password: <input type="password" name="password"/><br/>
    <input type="submit" value="Register"/>
</form>
<c:if test="${param.error != null}">
<p style="color: red">${param.error}</p>
</c:if>
<c:if test="${param.success != null}">
<p style="color: green
