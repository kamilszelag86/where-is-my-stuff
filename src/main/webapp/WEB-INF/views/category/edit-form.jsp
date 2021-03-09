<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form:form action="./" method="post" modelAttribute="category">
        <form:hidden path="user.id"/>
        <form:hidden path="id"/>
        Nazwa: <form:input path="name"/><br>
        <form:errors path="name"/><br>
        Opis: <form:input path="description"/><br>
        <input type="submit" value="Zapisz">

    </form:form>
</div>

</body>
</html>
