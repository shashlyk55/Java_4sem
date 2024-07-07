<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome Page</title>
</head>
<body>
<h1>Welcome, ${sessionScope.username}!</h1>
<form action="main" method="post">
    <input type="hidden" name="command" value="logout"/>
    <input type="submit" value="Logout"/>
</form>
</body>
</html>
