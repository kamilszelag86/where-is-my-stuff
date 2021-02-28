<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kamil
  Date: 26.02.2021
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form:form method="post" modelAttribute="user">
        Imię: <form:input path="firstName"/>
        Nazwisko: <form:input path="lastName"/>
        Email: <form:input path="email"/>
        <form:errors path="email"/><br>
        Hasło: <form:input path="password" type="password"/>
        <form:errors path="password"/><br>
        <input type="submit" value="Zarejestruj">

    </form:form>
</div>
</body>
</html>
