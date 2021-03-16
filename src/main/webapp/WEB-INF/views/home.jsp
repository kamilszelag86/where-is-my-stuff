<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2><spring:message code="home.message"/></h2><br>
<h3>Aby skorzystać z aplikacji musisz się zalogować.</h3><br>

<a href="<c:url value="/login"/>" class="btn">Zaloguj</a><br><br>

<h3>Nie masz konta? Zarejestruj się?</h3><br>
<a href="<c:url value="/register"/>" class="btn">Załóż konto</a>

