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
    <form class="add">
        <input id='name' name='name' placeholder="name" required/>
        <input id='login' name='login' placeholder="login" required/>
        <input id='email' name='email' placeholder="email"/>
        <input id='password' name='password' placeholder="password"/>
        <label>Role:
            <select id="roleToAdd" class='roleId' name='role'>
            </select>
        </label><br/>
        <label>Country:
            <select id="countryToAdd" class='countryId' name="country">
            </select>
        </label><br/>
        <label>City:
            <select id="cityToAdd" class='cityId' name="city">
            </select>
        </label>
        <input class="btn" id="addUserButton" type="button" value="add new user">
    </form>
</div>

<div id="signOut" class="content">
    <form action="${pageContext.servletContext.contextPath}/signout" method='post'>
        <input type='submit' value='sign out'/>
    </form>
</div>

<div id="update" class="content">
    <form class="updateForm">
        <input id='oldLogin' type="hidden"/>
        <input id='nameToUpdate' name='name' placeholder="name" required/>
        <input id='loginToUpdate' name='login' placeholder="login" required/>
        <input id='emailToUpdate' name='email' placeholder="email"/>
        <input id='passwordToUpdate' name='password' placeholder="password"/>
        <label>Role:
            <select id="roleToUpdate" class='roleId' name='role'>
            </select>
        </label><br/>
        <label>Country:
            <select id="countryToUpdate" class='countryId' name="country">
            </select>
        </label><br/>
        <label>City:
            <select id="cityToUpdate" class='cityId' name="city">
            </select>
        </label>
        <input class="btn" id="updateUserButton" type="button" value="update user">
    </form>
</div>

<div id="usersTable" class="content">
    Here is all users:<br>
    <table id="tableUsers" cellpadding="1" cellspacing="1" border="1">
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
