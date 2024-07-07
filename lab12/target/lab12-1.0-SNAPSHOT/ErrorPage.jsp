<%--
  Created by IntelliJ IDEA.
  User: Ваня
  Date: 13.04.2024
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h3>Упс...Что-то пошло не так!</h3>
    <p>Error occur: <%=request.getAttribute("exception")%></p>
</body>
</html>
