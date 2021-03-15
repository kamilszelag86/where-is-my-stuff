<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    Aby móc korzystać z aplikacji musisz należeć do zespołu.<br>
    Stwórz nowy zespół lub dołącz do jednego z już istniejących.
</div><br>
<div>
    <form:form method="post" action="app/team/create" modelAttribute="newTeam">
        Nazwa:<br>
        <form:input path="name"/><br>
        <input type="submit" value="Stwórz zespół">
    </form:form>
</div>
<br><br>
<div>
    <form:form method="post" action="app/team/add">
        Wybierz zespół:<br>
        <select name="team">
            <c:forEach var="t" items="${teams}">
                <option value="${t.id}">${t.name}</option>
            </c:forEach>
        </select><br>
        <input type="submit" value="Dołącz">
    </form:form>
</div>
</body>
</html>
