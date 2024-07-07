<%@ page import="org.example.lab10.University" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Ваня
  Date: 13.04.2024
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>


<html>
<head>
    <title>Title</title>
    <style>
        *{
            margin: 5px;
        }
        main{
            display: flex;
            flex-direction: row;
        }
    </style>
</head>
<body>
<jsp:include page="Header.jsp"/>
    <main>
        <div>
            <table border="1">
                <thead>
                <tr>
                    <th>Название</th>
                    <th>Город</th>
                </tr>
                </thead>
                <tbody>
                <%-- В этом примере предполагается, что у вас есть список объектов User --%>
                <% for (University univer : (List<University>)session.getAttribute("univerList")) { %>
                <tr>
                    <td><%= univer.getName() %></td>
                    <td><%= univer.getCity() %></td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
        <div>
            <form action="MainPageServlet">
                <h3>Добавление университета</h3>
                <input type="text" name="univername" placeholder="Название"/><br>
                <input type="text" name="univercity" placeholder="Город"/><br>
                <input type="submit" value="добавить"/><br>
                <p>${addErrorText}</p>
            </form>
            <form action="DeleteUniverServlet">
                <h3>Удаление университета</h3>
                <label>Название универстета: </label>
                <input type="text" name="deleteUniverName"/><br>
                <input type="submit" value="Удалить"/>
                <p>${deleteErrorText}</p>
            </form>
        </div>
        <div>
            <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"
                               url="jdbc:mysql://localhost/users_db?useSSL=false"
                               user="root"  password="123qweasdzxc"/>

            <sql:query dataSource="${db}" var="rs">
                select * FROM UNIVER;
            </sql:query>

            <table>
                <c:forEach var="table" items="${rs.rows}">
                    <tr>
                        <td><c:out value="${table.name}"/></td>
                        <td><c:out value="${table.city}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </main>
<jsp:include page="Footer.jsp"/>
</body>
</html>
