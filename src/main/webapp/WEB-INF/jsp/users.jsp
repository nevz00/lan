<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<a href="users/create"><spring:message code="user.add"/></a>
<%--<form method="post" action="users?action=email">--%>
<%--<dl>--%>
    <%--<dt>Find by email</dt>--%>
    <%--<dd><input type="text" name="email" value="${param.email}"></dd>--%>
<%--</dl>--%>
<%--<button type="submit">Search</button>--%>
<%--</form>--%>
<table border="1" cellpadding="8" cellspacing="0">
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
            <td><a href="users/update?id=${user.id}"><spring:message code="common.update"/></a></td>
            <td><a href="users/delete?id=${user.id}"><spring:message code="common.delete"/></a></td>
        </tr>
    </c:forEach>
</table>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
