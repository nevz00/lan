<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>UserForm</title>
</head>
<body>
    <h3><a href="../../index.html">Home</a></h3>
    <h2>${param.action == 'create' ? 'Create user' : 'Edit user'}</h2>
    <hr>
    <jsp:useBean id="user" type="ru.sarrz.lan.model.User" scope="request"/>
    <form method="post" action="users">
        <input type="hidden" name="id" value="${user.id}">
        <dl>
            <dt>FirstName:</dt>
            <dd><input type="text" value="${user.firstName}" size=40 name="firstName" required></dd>
        </dl>
        <dl>
            <dt>LastName:</dt>
            <dd><input type="text" value="${user.lastName}" size=40 name="lastName" required></dd>
        </dl>
        <dl>
            <dt>Email</dt>
            <dd><input type="email" value="${user.email}" name="email" required></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
</body>
</html>
