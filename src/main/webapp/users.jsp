<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<hr/>
<a href="users?action=create">Add Meal</a>
<hr/>
<form method="post" action="users?action=email">
<dl>
    <dt>Find by email</dt>
    <dd><input type="text" name="email" value="${param.email}"></dd>
</dl>
<button type="submit">Search</button>
</form>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Email</th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <c:forEach items="${users}" var="user">
        <jsp:useBean id="user" scope="page" type="ru.sarrz.lan.model.User"/>
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <%--<td>--%>
                    <%--&lt;%&ndash;${user.date}&ndash;%&gt;--%>
                    <%--&lt;%&ndash;<%=TimeUtil.toString(meal.getDateTime())%>&ndash;%&gt;--%>
                    <%--&lt;%&ndash;${fn:replace(meal.dateTime, 'T', ' ')}&ndash;%&gt;--%>
                    <%--&lt;%&ndash;${fn:formatDateTime(meal.dateTime)}&ndash;%&gt;--%>
            <%--</td>--%>
            <td><a href="users?action=update&id=${user.id}">Update</a></td>
            <td><a href="users?action=delete&id=${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
