<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <h3><spring:message code="user.title"/></h3>
        <br/>

        <button type="button" class="btn btn-lg btn-block btn-outline-primary"><spring:message code="common.add"/></button>

        <br/><br/>
        <table class="table table-striped display">
            <thead>
            <tr>
        <th><spring:message code="user.firstName"/></th>
        <th><spring:message code="user.lastName"/></th>
        <th><spring:message code="user.email"/></th>
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
            <td><a><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
            <td><a><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
            </tr>
        </c:forEach>
    </table>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
