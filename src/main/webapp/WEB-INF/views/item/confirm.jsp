<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/app/item/all"/>">
    <button>NIE</button>
</a>
<div>
    <form:form method="post" action="./">
        <input type="hidden" name="itemId" value="${itemId}">
        <button type="submit">TAK</button>
    </form:form>
</div>
</body>
</html>
