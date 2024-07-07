<%--
  Created by IntelliJ IDEA.
  User: ilyac
  Date: 11.04.2023
  Time: 00:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
    <title>Sql JSTL tags</title>
</head>
<body>
<sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3307/Java?verifyServerCertificate=false&useSSL=false&requireSSL=false"
                   user="root"  password="root"/>

<sql:query dataSource="${db}" var="rs">
    select * FROM usersandadmins;
</sql:query>

<table>
    <tr>
        <th>Name User</th>
        <th>Password</th>
        <th>Status</th>
    </tr>

    <c:forEach var="table" items="${rs.rows}">
        <tr>
            <td><c:out value="${table.NameUser}"/></td>
            <td><c:out value="${table.Password}"/></td>
            <td><c:out value="${table.Status}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>