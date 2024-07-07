<%--
  Created by IntelliJ IDEA.
  User: ilyac
  Date: 11.04.2023
  Time: 00:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p><b>Date</b></p>
<c:set var="Date" value="<%=new java.util.Date()%>" />
<fmt:setLocale value="en-EN"/>
<p>English date: <fmt:formatDate value="${Date}"/></p>
<fmt:setLocale value="ru-RU"/>
<p>Russian date: <fmt:formatDate value="${Date}"/></p>
<p><b>Styles of time:</b></p>
<li>
    short: <fmt:formatDate value="${Date}" type="time" timeStyle="short"/>
</li>
<li>
    medium: <fmt:formatDate value="${Date}" type="time" timeStyle="medium"/>
</li>
<li>
    long: <fmt:formatDate value="${Date}" type="time" timeStyle="long"/>
</li>
<p>
    <b>Formatted Date and Time:</b>
    <fmt:formatDate type="both" value="${Date}" />
</p>

<p><b>Number formatting</b></p>
<c:set var="number" value="123.123"/>
<li>
    Default: <fmt:formatNumber value="${number}"/>
</li>
<li>
    Percent: <fmt:formatNumber value="${number}" type="percent"/>
</li>
<li>
    Currency: <fmt:formatNumber value="${number}" type="currency"/>
</li>
<li>
    Max fraction = 2: <fmt:formatNumber value="${number}" type="number" maxFractionDigits="2"/>
</li>

<br>
<table>
    <tr>
        <td colspan="2" class="table-header">
            <p>
                <b>
                    Formatting:
                    <fmt:formatDate value="${Date}" type="both"
                                    timeStyle="long" dateStyle="long" />
                </b>
            </p>
        </td>
    </tr>

    <c:forEach var="zone"
               items="<%=java.util.TimeZone.getAvailableIDs()%>">
        <tr>
            <td>
                <c:out value="${zone}" />
            </td>
            <td>
                <fmt:timeZone value="${zone}">
                    <fmt:formatDate value="${Date}" timeZone="${zone}"
                                    type="both"/>
                </fmt:timeZone>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
