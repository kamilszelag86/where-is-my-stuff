<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<sec:authentication property="principal.user" var="user"/>
<jsp:include page="../fragments/head.jsp"/>
<body id="page-top">

<jsp:include page="../fragments/menu-and-topbar.jsp"/>

<!--Begin Page Content-->
<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Twój zespół: ${user.team.name}</h1>
    </div>

    <c:if test="${not empty activeRequests}">
        <!-- Content Row -->
        <div class="row">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Wnioski o dołączenie:</h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>Użytkownik</th>
                                <th>Imię</th>
                                <th>Nazwisko</th>
                                <th>Akcje</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${activeRequests}" var="request">
                                <tr>
                                    <td>${request.user.username}</td>
                                    <td>${request.user.firstName}</td>
                                    <td>${request.user.lastName}</td>
                                    <td>
                                        <form:form method="post" action="/app/team/approve">
                                            <input type="hidden" name="request" value="${request.id}">
                                            <button type="submit" class="btn btn-success btn-icon-split">
                                                <span class="icon text-white-50">
                                                <i class="fas fa-check"></i>
                                                </span>
                                                <span class="text">Zaakceptuj</span>
                                            </button>
                                        </form:form>
                                        <form:form method="post" action="/app/team/reject">
                                            <input type="hidden" name="request" value="${request.id}">
                                            <button type="submit" class="btn btn-danger btn-icon-split">
                                                <span class="icon text-white-50">
                                                <i class="fas fa-trash"></i>
                                                </span>
                                                <span class="text">Odrzuć</span>
                                            </button>
                                        </form:form>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </c:if>

    <!-- Content Row -->
    <div class="row">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Członkowie zespołu:</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Użytkownik</th>
                            <th>Imię</th>
                            <th>Nazwisko</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${teamMembers}" var="member">
                            <tr>
                                <td>${member.username}</td>
                                <td>${member.firstName}</td>
                                <td>${member.lastName}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
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