<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <c:forEach var="category" items="${categories}">
        <tr>
            <td>${category.name}</td>
            <td>${category.description}</td>
            <td><a href="<c:url value="/app/category/edit/${category.id}"/>">Edytuj</a>
                <a href="<c:url value="/app/category/delete/${category.id}"/>">Usuń</a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
