<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kamil
  Date: 08.03.2021
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
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
