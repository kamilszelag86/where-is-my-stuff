<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2><spring:message code="home.message"/></h2><br>
<div>
    <sec:authorize access="!isAuthenticated()">
        <a href="<c:url value="/login"/>" class="btn">Zaloguj</a>
    </sec:authorize>
</div>
<br><br>
<div>
    <sec:authorize access="isAuthenticated()">
        <form action="<c:url value="/logout"/>" method="post">
            <input class="fa fa-id-badge" type="submit" value="<spring:message  code="logout.button"/>">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </sec:authorize>
</div>
</body>
</html>
