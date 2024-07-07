<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql"prefix="sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>

<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<p>Length of "qwerty": ${fn:length("qwerty")}</p>


<p><b>Date</b></p>
<c:set var="Date" value="<%=new java.util.Date()%>" />
<fmt:setLocale value="en-EN"/>
<p>English date: <fmt:formatDate value="${Date}"/></p>
<fmt:setLocale value="ru-RU"/>
<p>Russian date: <fmt:formatDate value="${Date}"/></p>

<h3>Вход</h3>
<form action="SignInServlet">
  <label>Логин </label><br>
  <input type="text" name="login_signin" placeholder="Логин"/><br>
  <label>Пароль </label><br>
  <input type="password" name="passworn_signin" placeholder="Пароль"/><br>
  <input type="submit" value="Войти"/>
  <p>${errorText}</p>
</form>
<a href="RegisterPage.jsp">Регистрация</a>

<x:parse var="users">
  <c:import url="users.xml"/>
</x:parse>

<c:catch var="exception">
  <table>
    <tr>
      <th>User logins</th>
    </tr>
    <x:forEach var="item" select="$users/users/user">
      <tr>
        <td><x:out select="$item/login/text()"/></td>
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