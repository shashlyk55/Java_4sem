<%--
  Created by IntelliJ IDEA.
  User: ilyac
  Date: 11.04.2023
  Time: 00:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:out value="1 + 2 * 3 = "/>
    <c:out value="${1 + 2 * 3}"/>

    <p><b>If tag</b></p>
    <c:set var="user" value="Ilya" scope="session"/>
    <c:if test="${user eq 'Ilya'}">
        <c:out value="You joined as admin"/>
    </c:if>

    <p><b>Choose tag</b></p>
    <c:set var="age" value="18" scope="page"/>
    <c:choose>
        <c:when test="${age == 18}">
            <c:out value="You are an adult "/>
        </c:when>
        <c:otherwise>
            <c:out value="You are a kid"/>
        </c:otherwise>
    </c:choose>

    <p><b>ForEach tag</b></p>
    <%
        String[] lp = {"A", "B", "C", "D","E"};
        request.setAttribute("lp", lp);
    %>
    <c:forEach items="${lp}" var="lang">
        <li>${lang}</li>
    </c:forEach>

    <p><b>Catch tag</b></p>
    <c:catch var="exception">
        <% int num = 0 / 0; %>
    </c:catch>
    <c:if test="${exception != null}">
        <p>Exception : ${exception} <br/>
            Message : ${exception.message}</p>
    </c:if>
</body>
</html>
