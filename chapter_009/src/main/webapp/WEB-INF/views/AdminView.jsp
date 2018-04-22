<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin page</title>
    <style>
        <%@ include file="css/styles.css" %>
    </style>
</head>
<body>
<header>
    Admin Page. You are logged as "${currentUser}".
</header>
<aside>
    <form class="add" action="${pageContext.servletContext.contextPath}/add" method="post">
        <input name='name' placeholder="name" required/>
        <input name='login' placeholder="login" required/>
        <input name='email' placeholder="email"/>
        <input name='password' placeholder="password"/>
        <label>Role:
            <select name='role'>
                <option value="user">user</option>
                <option value="admin">admin</option>
            </select>
        </label>
        <input class="btn" type="submit" value="add new user">
    </form>
    <form action="${pageContext.servletContext.contextPath}/signout" method='post'>
        <input type='submit' value='sign out'/>
    </form>
</aside>

Here is all users:<br>
<table class="tableUsers" style="border: 1px solid black;" cellpadding="1" cellspacing="1" border="1">
    <tr>
        <th>name</th>
        <th>login</th>
        <th>email</th>
        <th>creation date</th>
        <th>role</th>
        <th>password</th>
    </tr>

    <c:forEach var="user" items="${users}">
        <tr>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.login}"/></td>
            <td><c:out value="${user.email}"/></td>
            <td><c:out value="${user.date}"/></td>
            <td><c:out value="${user.role}"/></td>
            <td><c:out value="${user.password}"/></td>
            <form method='post'>
                <input type="hidden" value="${user.login}" name='login'/>
                <td><input class="btn" type="submit" value='delete user' formaction="${pageContext.servletContext.contextPath}/delete"/></td>
            </form>
            <form method="post">
                <input type="hidden" value="${user.login}" name="login"/>
                <input type="hidden" value="${user.name}" name="name"/>
                <input type="hidden" value="${user.email}" name="email"/>
                <input type="hidden" value="${user.password}" name="password"/>
                <td><input class="btn" type="submit" value='update user' formaction="${pageContext.servletContext.contextPath}/updateUser"/></td>
            </form>
        </tr>
    </c:forEach>
</table>


</body>
</html>
