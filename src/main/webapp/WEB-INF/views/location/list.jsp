<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <c:forEach var="location" items="${locations}">
        <tr>
            <td>${location.name}</td>
            <td>${location.description}</td>
            <td><a href="<c:url value="/app/location/edit/${location.id}"/>">Edytuj</a>
                <a href="<c:url value="/app/location/delete/${location.id}"/>">Usuń</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
