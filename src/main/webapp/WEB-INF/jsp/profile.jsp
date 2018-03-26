<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="topjava" tagdir="/WEB-INF/tags" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <%--@elvariable id="userTo" type="ru.javawebinar.topjava.to.UserTo"--%>
        <h2>${userTo.firstName} <spring:message code="${register ? 'app.register' : 'app.profile'}"/></h2>

        <form:form modelAttribute="userTo" class="form-horizontal" method="post" action="${register ? 'register' : 'profile'}"
                   charset="utf-8" accept-charset="UTF-8">

            <spring:message code="user.firstName" var="userFirstName"/>
            <topjava:inputField label='${userFirstName}' firstName="firstName"/>

            <spring:message code="user.firstName" var="userLastName"/>
            <topjava:inputField label='${userLastName}' firstName="lastName"/>

            <spring:message code="user.email" var="userEmail"/>
            <topjava:inputField label='${userEmail}' firstName="email"/>

            <spring:message code="user.password" var="userPassword"/>
            <topjava:inputField label='${userPassword}' firstName="password" inputType="password"/>


            <div class="form-group">
                <div class="col-xs-offset-2 col-xs-10">
                    <button type="submit" class="btn btn-primary">
                        <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
                    </button>
                </div>
            </div>
        </form:form>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>