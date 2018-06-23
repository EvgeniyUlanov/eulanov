<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Admin page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="resources/css/styles.css" type="text/css" rel="stylesheet"/>
    <script type="text/javascript" src="resources/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="resources/js/myScript.js"></script>
</head>
<body background="resources/img/back.jpg">

<nav class="navbar navbar-expand-lg">
    <div>ADMIN PAGE. You are logged as "${currentUser}"</div>
    <div class="collapse navbar-collapse " id="navbarSupportedContent">
        <ul class="navbar-nav mr-4 navigation" id="nav">
            <li class="nav-item"><a class="table nav-link" href="#usersTable">Users table</a></li>
            <li class="nav-item"><a class="add nav-link" href="#addUser">Add User</a></li>
        </ul>
        <form action="${pageContext.servletContext.contextPath}/signout" method='post'>
            <input class="btn btn-primary" type='submit' value='sign out'/>
        </form>
    </div>
</nav>

<div class="content row justify-content-center align-items-center" id="usersTable">
    <div class="container">
        <h1 class="text-center">Here is all users</h1>
        <table id="tableUsers" class="table">
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
</div>

<div class="container content" id="addUser">
    <h1 class="text-center">Here you can add new user</h1>
    <div class="row justify-content-center align-items-center">
        <form class="add">
            <label for="name">Name</label>
            <input id='name' name='name' class="form-control" placeholder="name" required/>
            <label for="login">Login</label>
            <input id='login' name='login' class="form-control" placeholder="login" required/>
            <label for="email">Email</label>
            <input id='email' name='email' class="form-control" placeholder="email"/>
            <label for="password">Password</label>
            <input id='password' name='password' class="form-control" placeholder="password"/>
            <label for="roleToAdd">Role:
                <select id="roleToAdd" class='roleId form-control' name='role'></select>
            </label>
            <label for="countryToAdd">Country:
                <select id="countryToAdd" class='countryId form-control' name="country">
                </select>
            </label>
            <label for="cityToAdd">City:
                <select id="cityToAdd" class='cityId form-control' name="city">
                </select>
            </label>
            <input class="btn btn-success" id="addUserButton" type="button" value="add new user">
        </form>
    </div>
</div>

<div class="container content" id="update">
    <h1 class="text-center">This is update form</h1>
    <div class="row justify-content-center align-items-center">
        <form class="updateForm">
            <input id='oldLogin' type="hidden"/>
            <label for="nameToUpdate">New name</label>
            <input id='nameToUpdate' class="form-control" name='name' placeholder="name" required/>
            <label for="loginToUpdate">New Login</label>
            <input id='loginToUpdate' class="form-control" name='login' placeholder="login" required/>
            <label for="emailToUpdate">New email</label>
            <input id='emailToUpdate' class="form-control" name='email' placeholder="email"/>
            <label for="passwordToUpdate">New Password</label>
            <input id='passwordToUpdate' class="form-control" name='password' placeholder="password"/>
            <label for="roleToUpdate">Role:
                <select id="roleToUpdate" class='roleId form-control' name='role'>
                </select>
            </label>
            <label for="countryToUpdate">Country:
                <select id="countryToUpdate" class='countryId form-control' name="country">
                </select>
            </label>
            <label for="cityToUpdate">City:
                <select id="cityToUpdate" class='cityId form-control' name="city">
                </select>
            </label>
            <input class="btn btn-success" id="updateUserButton" type="button" value="update user">
        </form>
    </div>
</div>

</body>
</html>
