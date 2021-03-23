<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/head.jsp"/>

<body id="page-top">

<jsp:include page="../fragments/menu-and-topbar.jsp"/>

<!--Begin Page Content-->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Twój zespół</h1>
    </div>

    <!-- Content Row -->
    <div class="row">
        <c:forEach items="${teamMembers}" var="member">
            ${member.firstName} ${member.lastName} - ${member.username}<br>
        </c:forEach>
    </div>

    <!-- Content Row -->
    <div class="row">
        <h3>Wnioski o dołączenie:</h3><br>
        <c:forEach items="${activeRequests}" var="request">
            ${request.user.firstName} ${request.user.lastName} - ${request.user.username}<br>
        </c:forEach>
    </div>

</div>
<!-- /.container-fluid -->

<jsp:include page="../fragments/foot.jsp"/>
<!-- Page level plugins -->
<script src="<c:url value="/theme/vendor/datatables/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/theme/vendor/datatables/dataTables.bootstrap4.min.js"/>"></script>

<!-- Page level custom scripts -->
<script src="<c:url value="/theme/js/demo/datatables-demo.js"/>"></script>
</body>

</html>