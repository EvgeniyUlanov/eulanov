<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Sign in</title>
    <link href="${pageContext.servletContext.contextPath}/WEB-INF/views/css/styles.css" type="text/css"
          rel="stylesheet"/>
    <style>
        <%@include file="css/styles.css"%>
    </style>
    <script type="text/javascript">
       function validate() {
            var result = true;
            if (document.getElementsByName("login")[0].value === "") {
                result = false;
                alert("enter login");
            }
            return result;
        }
    </script>
</head>
<body>
    <fieldset>
        <legend>Sing in</legend>
        <form action="${pageContext.servletContext.contextPath}/sign" method="post" onsubmit="return validate();">
            <input name="login" placeholder="login"/>
            <input type="password" name="password" placeholder="password"/>
            <input class="btn" type="submit" value="Sign in">
        </form>
    </fieldset>
</body>
</html>
