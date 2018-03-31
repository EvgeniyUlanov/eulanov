<%@ page import="ru.job4j.users.User" %>
<%@ page import="ru.job4j.users.UserStore" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Using Servlets</title>
</head>
<body>
<form action="${pageContext.servletContext.contextPath}/add" method="post">
    Name : <input name="name"/>
    Login : <input name="login"/>
    Email : <input name="email"/>
    <input type="submit" value="add new user">
</form>

<form action="${pageContext.servletContext.contextPath}/update" method='post'>
    Name : <input name='name'/>
    Login : <input name='login'/>
    Email : <input name='email'/>
    <input type='submit' value='update user'>
</form>

<form action="${pageContext.servletContext.contextPath}/delete" method='post'>
    Name : <input name='name'/>
    <input type='submit' value='delete user'>
</form>
<br/>
<table style="border: 1px solid black;" cellpadding="1" cellspacing="1" border="1">
    <tr>
        <th>name</th>
        <th>login</th>
        <th>email</th>
        <th>creation date</th>
    </tr>

    <c:forEach var="user" items="${users}">
        <tr>
            <th><c:out value="${user.name}"/></th>
            <th><c:out value="${user.login}"/></th>
            <th><c:out value="${user.email}"/></th>
            <th><c:out value="${user.date}"/></th>
        </tr>
    </c:forEach>
</table>

</body>
</html>
