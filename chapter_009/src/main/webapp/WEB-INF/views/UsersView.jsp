<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User page</title>
    <style>
        <%@ include file="css/styles.css" %>
    </style>
</head>
<body>
<header>
    User Page. You are logged as "${currentUser.login}".
</header>
<c:set var="user" value="${currentUser}"/>

<fieldset class="userSet">
    <legend>Settings</legend>
    Name: <c:out value="${user.name}"/><br/>
    Login: <c:out value="${user.login}"/><br/>
    Email: <c:out value="${user.email}"/><br/>
    Password: <c:out value="${user.password}"/><br/>
    Role: <c:out value="${user.role}"/><br/>
    Create Date: <c:out value="${user.date}"/><br/>
</fieldset>
<fieldset>
    <legend>Actions</legend>
    <form method='post'>
        <input type="hidden" value="${user.login}" name='login'/>
        <input type="submit" value='delete user' formaction="${pageContext.servletContext.contextPath}/delete"/>
    </form>
    <form method="post">
        <input type="hidden" value="${user.login}" name="login"/>
        <input type="hidden" value="${user.name}" name="name"/>
        <input type="hidden" value="${user.email}" name="email"/>
        <input type="hidden" value="${user.password}" name="password"/>
        <input type="submit" value='update user' formaction="${pageContext.servletContext.contextPath}/updateUser"/>
    </form>

    <form action="${pageContext.servletContext.contextPath}/signout" method='post'>
        <input type='submit' value='sign out'/>
    </form>
</fieldset>


<br/>

</table>

</body>
</html>
