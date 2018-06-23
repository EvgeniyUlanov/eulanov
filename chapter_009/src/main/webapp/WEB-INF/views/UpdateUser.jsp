<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Update page</title>
    <style>
        <%@include file="../../resources/css/styles.css"%>
    </style>
</head>
<body>
<header>
    You are updating user - <c:out value="${param.name}"/>; login - <c:out value="${param.login}"/>
</header>
<c:set var="role" value="admin"/>
<form class="update" action="${pageContext.servletContext.contextPath}/update" method='post'>
    <input type="hidden" name="oldLogin" value="${param.login}">
    <input name='name' value="${param.name}"/>
    <input name='login' value="${param.login}"/>
    <input name='email' value="${param.email}"/>
    <input name='password' value="${param.password}"/>
    <c:if test="${sessionScope.get('role') == role}">
        <label>Role:
            <select name='role'>
                <option value="user">user</option>
                <option value="admin">admin</option>
            </select>
        </label>
    </c:if>
    <input class="btn" type='submit' value='update user'>
    <input class="btn" type="submit" value="cancel" formaction="${pageContext.servletContext.contextPath}/">
</form>
</body>
</html>
