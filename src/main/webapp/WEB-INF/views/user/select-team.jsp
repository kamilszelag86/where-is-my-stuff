<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<sec:authentication property="principal.user" var="user"/>

<body>
<div>
    <c:choose>
        <c:when test="${user.joinTeamRequest.active}">
            Twoja prośba o dołączenie do zespołu ${user.joinTeamRequest.team.name} czeka na akceptację.
        </c:when>
        <c:when test="${user.joinTeamRequest.rejected}">
            Twoja prośba o dołączenie do zespołu ${user.joinTeamRequest.team.name} została odrzucona.<br>
            Stwórz nowy zespół lub dołącz do jednego z już istniejących.<br><br>
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
        </c:when>
        <c:otherwise>
            Aby móc korzystać z aplikacji musisz należeć do zespołu.<br>
            Stwórz nowy zespół lub dołącz do jednego z już istniejących.<br><br
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
        </c:otherwise>

    </c:choose>
</div>

</body>
</html>
