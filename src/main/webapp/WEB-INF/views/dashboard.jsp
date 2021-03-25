<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<sec:authentication property="principal.user" var="user"/>
<jsp:include page="fragments/head.jsp"/>

<body id="page-top">

<jsp:include page="fragments/menu-and-topbar.jsp"/>

<!--Begin Page Content-->
<div class="container-fluid">

    <!-- Page Heading -->
    <h1 class="h3 mb-4 text-gray-800">Twój zespół: ${user.team.name}</h1>

    <p class="mb-4">Ilość wszystkich przedmiotów: ${itemCount}</p>
    <p class="mb-4">Ilość wszystkich lokalizacji: ${locationCount}</p>

</div>
<!-- /.container-fluid -->

<jsp:include page="fragments/foot.jsp"/>

</body>

</html>