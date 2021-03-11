<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form:form method="post" modelAttribute="item" enctype="multipart/form-data">
        <form:hidden path="user.id" value="${currentUser.user.id}"/>
        Nazwa: <form:input path="name"/><br>
        <form:errors path="name"/><br>
        Opis: <form:input path="description"/><br>
        Lokalizacja: <form:select path="location.id" items="${locations}" itemLabel="name" itemValue="id"/><br>
        Kategorie: <form:checkboxes path="categories" items="${categories}" itemLabel="name" itemValue="id"/><br>
        Dodaj zdjęcie: <input type="file" name="image" accept="image/jpeg"/><br>
        <input type="submit" value="Zapisz">
    </form:form>
</div>

</body>
</html>
