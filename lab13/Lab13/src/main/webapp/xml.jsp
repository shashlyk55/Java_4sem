<%--
  Created by IntelliJ IDEA.
  User: ilyac
  Date: 11.04.2023
  Time: 00:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<x:parse var="cars">
    <c:import url="cars.xml"/>
</x:parse>

<c:catch var="exception">
    <table>
        <tr>
            <th>Model</th>
            <th>Company</th>
            <th>Price</th>
        </tr>
        <x:forEach var="item" select="$cars/cars/car">
            <tr>
                <td><x:out select="$item/model/text()"/></td>
                <td><x:out select="$item/company/text()"/></td>
                <td><x:out select="$item/price/text()"/></td>
            </tr>
        </x:forEach>
    </table>
</c:catch>
<c:if test="${exception != null}">
    <p>Exception : ${exception} <br/>
        Message : ${exception.message}</p>
</c:if>
</body>
</html>
