<%--
  Created by IntelliJ IDEA.
  User: ilyac
  Date: 11.04.2023
  Time: 00:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><b>Make love, not war exploded!</b></p>
    <c:set var="string" value="Make love , not war exploded !"/>

    <c:if test="${fn:containsIgnoreCase(string, 'war')}">
        <p>The string contains 'world' (ignore case)</p>
    </c:if>

    <c:if test="${fn:endsWith(string, '!')}">
        <p>The string ends with '!'</p>
    </c:if>

    <c:if test="${fn:startsWith(string, 'Make')}">
        <p>The string starts with 'Make'</p>
    </c:if>

    <p>Length: ${fn:length("sadsa")}</p>
    <p>Words: ${string3}</p>
</body>
</html>
