<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: kamil
  Date: 25.02.2021
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3><spring:message code="about.message"/></h3><br>
<div>
<sec:authorize access="isAuthenticated()">
    <p>Zalogowany jako: <sec:authentication property="username"/></p>
    <p>Posiada role: <sec:authentication property="au"/></p>
</sec:authorize>
</div>
<form action="<c:url value="/logout"/>" method="post">
    <input class="fa fa-id-badge" type="submit" value="<spring:message  code="logout.button"/>">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

</body>
</html>
