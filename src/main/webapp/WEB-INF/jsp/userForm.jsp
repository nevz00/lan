<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<section>


    <jsp:useBean id="user" type="ru.sarrz.lan.model.User" scope="request"/>
    <h3><spring:message code="${user.isNew() ? 'user.add' : 'user.edit'}"/></h3>
    <form method="post" action="users">
        <input type="hidden" name="id" value="${user.id}">
        <dl>
            <dt><spring:message code="user.firstName"/></dt>
            <dd><input type="text" value="${user.firstName}" size=40 name="firstName" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="user.lastName"/></dt>
            <dd><input type="text" value="${user.lastName}" size=40 name="lastName" required></dd>
        </dl>
        <dl>
            <dt><spring:message code="user.email"/></dt>
            <dd><input type="email" value="${user.email}" name="email" required></dd>
        </dl>
        <button type="submit">Save</button>
        <button onclick="window.history.back()" type="button">Cancel</button>
    </form>
    </section>
</body>
</html>
