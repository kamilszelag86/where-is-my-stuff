<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    Witaj ${currentUser.user.firstName}<br>
    <a href="<c:url value="/app/item/add"/>">Dodaj przedmiot</a>
    <br>
</div>

<table border="1">
    <c:forEach var="item" items="${items}">
        <tr>
            <td>${item.name}</td>
            <td>${item.description}</td>
            <td>${item.location.name}</td>
            <td><img src="<c:url value="${item.itemImagePath}"/>" height="80"/></td>
            <td><a href="<c:url value="/app/item/edit/${item.id}"/>">Edytuj</a>
                <a href="<c:url value="/app/item/delete/${item.id}"/>">Usuń</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
