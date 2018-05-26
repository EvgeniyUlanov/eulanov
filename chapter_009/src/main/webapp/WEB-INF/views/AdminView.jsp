<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin page</title>
    <style>
        <%@ include file="css/styles.css" %>
    </style>
    <script type="text/javascript">
        <%@ include file="js/jquery-3.3.1.min.js" %>
        <%@ include file="js/myScript.js" %>
    </script>
</head>
<body>
<header>
    Admin Page. You are logged as "${currentUser}".
</header>

<div id="header">
    <ul class="navigation" id="nav">
        <li><a class="add" href="#addUser">Add User</a></li>
        <li><a class="sign" href="#signOut">Sign Out</a></li>
        <li><a class="table" href="#usersTable">Users table</a></li>
    </ul>
</div>

<div id="addUser" class="content">
    <form class="add" action="${pageContext.servletContext.contextPath}/add" method="post">
        <input id='name' name='name' placeholder="name" required/>
        <input id='login' name='login' placeholder="login" required/>
        <input id='email' name='email' placeholder="email"/>
        <input id='password' name='password' placeholder="password"/>
        <label>Role:
            <select id='roleId' name='role'>
            </select>
        </label><br/>
        <label>Country:
            <select id='countryId' name="country">
            </select>
        </label><br/>
        <label>City:
            <select id='cityId' name="city">
            </select>
        </label>
        <input class="btn" type="submit" value="add new user">
    </form>
</div>
<div id="signOut" class="content">
    <form action="${pageContext.servletContext.contextPath}/signout" method='post'>
        <input type='submit' value='sign out'/>
    </form>
</div>


<div id="usersTable" class="content">
    Here is all users:<br>
    <table class="tableUsers" style="border: 1px solid black;" cellpadding="1" cellspacing="1" border="1">
        <tr>
            <th>name</th>
            <th>login</th>
            <th>email</th>
            <th>creation date</th>
            <th>role</th>
            <th>password</th>
            <th>country</th>
            <th>city</th>
        </tr>

        <c:forEach var="user" items="${users}">
            <tr>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.date}"/></td>
                <td><c:out value="${user.role}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td><c:out value="${user.city}"/></td>
                <form method='post'>
                    <input type="hidden" value="${user.login}" name='login'/>
                    <td><input class="btn" type="submit" value='delete user'
                               formaction="${pageContext.servletContext.contextPath}/delete"/></td>
                </form>
                <form method="post">
                    <input type="hidden" value="${user.login}" name="login"/>
                    <input type="hidden" value="${user.name}" name="name"/>
                    <input type="hidden" value="${user.email}" name="email"/>
                    <input type="hidden" value="${user.password}" name="password"/>
                    <td><input class="btn" type="submit" value='update user'
                               formaction="${pageContext.servletContext.contextPath}/updateUser"/></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</div>

<div id="test">
    <table id="testTable" style="border: 1px solid black;" cellpadding="1" cellspacing="1" border="1">
        <tr>
            <th>name</th>
            <th>login</th>
            <th>email</th>
            <th>creation date</th>
            <th>role</th>
            <th>password</th>
            <th>country</th>
            <th>city</th>
        </tr>
    </table>
</div>


</body>
</html>
