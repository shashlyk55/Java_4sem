<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="my" uri="/WEB-INF/mytags.tld" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello my frend!" %>
</h1>
<br/>
    <p><a href="Controller?COMMAND=core">core</a></p>
    <p><a href="Controller?COMMAND=formatting">formatting</a></p>
    <p><a href="Controller?COMMAND=sql">sql</a></p>
    <p><a href="Controller?COMMAND=xml">xml</a></p>
    <p><a href="Controller?COMMAND=functions">functions</a></p>
</body>
</html>