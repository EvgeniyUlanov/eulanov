<%@ page import="ru.job4j.users.User" %>
<%@ page import="ru.job4j.users.UserStore" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Using Servlets</title>
</head>
<body>

<form action="<%=request.getContextPath()%>/add" method="post">
    Name : <input name="name"/>
    Login : <input name="login"/>
    Email : <input name="email"/>
    <input type="submit" value="add new user">
</form>

<form action="<%=request.getContextPath()%>/update" method='post'>
    Name : <input name='name'/>
    Login : <input name='login'/>
    Email : <input name='email'/>
    <input type='submit' value='update user'>
</form>

<form action="<%=request.getContextPath()%>/delete" method='post'>
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
    <% for (User user : UserStore.getUserStore().getAll()) {%>
    <tr>
        <th><%=user.getName()%></th>
        <th><%=user.getLogin()%></th>
        <th><%=user.getEmail()%></th>
        <th><%=user.getDate().toString()%></th>
    </tr>
    <% } %>
</table>

</body>
</html>
