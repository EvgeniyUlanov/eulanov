<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Sign in</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script type="text/javascript" src="resources/js/myScript.js"></script>
</head>
<body>
<div class="container h-100">
    <div class="row h-100 justify-content-center align-items-center">
        <form action="${pageContext.servletContext.contextPath}/sign" method="post" onsubmit="return validate();">
            <div class="form-group">
                <label for="exampleInputEmail1">Login</label>
                <input name="login" class="form-control" id="exampleInputEmail1" placeholder="Enter login">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input name="password" type="password" class="form-control" id="exampleInputPassword1"
                       placeholder="Enter password">
            </div>
            <button type="submit" class="btn btn-primary">Sing in</button>
        </form>
    </div>
</div>
</body>
</html>
