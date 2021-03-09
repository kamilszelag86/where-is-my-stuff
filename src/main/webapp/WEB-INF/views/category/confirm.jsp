<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/app/category/all"/>">
    <button>NIE</button>
</a>
<div>
    <form:form method="post" action="./">
        <input type="hidden" name="categoryId" value="${categoryId}">
        <button type="submit">TAK</button>
    </form:form>
</div>
</body>
</html>
