<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kamil
  Date: 27.02.2021
  Time: 12:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Witaj ${currentUser.user.firstName} ${currentUser.user.lastName}</h2><br>
<h1>Zalogowano jako ${currentUser.username}</h1>
<c:forEach items="${currentUser.authorities}" var="auth">
    ${auth}
</c:forEach>

</body>
</html>
