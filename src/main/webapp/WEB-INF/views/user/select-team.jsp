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

    <c:choose>
        <c:when test="${user.joinTeamRequest.status == 'ACTIVE'}">
            <div class="row">
                <div class="card mb-4 py-3 border-bottom-info border-left-info border-info">
                    <div class="card-body text-info">
                        <spring:message code="team.your.request"/> ${user.joinTeamRequest.team.name} <spring:message code="request.active"/>
                    </div>
                </div>
            </div>
            <form:form method="post" action="/app/team/request/cancel">
                <input type="hidden" name="request" value="${user.joinTeamRequest.id}">
                <button type="submit" class="btn btn-danger btn-icon-split btn-lg">
                <span class="icon text-white-50">
                    <i class="fas fa-trash"></i>
                </span>
                    <span class="text"><spring:message code="request.cancel"/></span>
                </button>
            </form:form>
        </c:when>
        <c:otherwise>
            <c:if test="${user.joinTeamRequest.status == 'REJECTED'}">
                <div class="row">
                    <div class="card mb-4 py-3 border-bottom-danger border-left-danger border-danger">
                        <div class="card-body text-danger">
                            <spring:message code="team.your.request"/> ${user.joinTeamRequest.team.name} <spring:message code="request.rejected"/>
                        </div>
                    </div>
                </div>
            </c:if>
            <p class="mb-4">
                <spring:message code="team.message"/><br>
            </p>
            <div class="row">
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary"><spring:message code="team.create.new"/></h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <form:form method="post" action="/app/team/create" modelAttribute="newTeam">
                                <spring:message code="name"/>:<br>
                                <form:input path="name"/><br>
                                <form:errors path="name" cssClass="alert-danger"/><br>
                                <button type="submit" class="btn btn-success btn-icon-split btn-lg">
                        <span class="icon text-white-50">
                            <i class="fas fa-check"></i>
                        </span>
                                    <span class="text"><spring:message code="team.create"/></span>
                                </button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary"><spring:message code="team.join.existing"/></h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <form:form method="post" action="/app/team/join">
                                <spring:message code="team.name.input"/>:<br>
                                <input type="text" name="teamName"><br>
                                <c:if test="${invalidTeam}">
                                    <p class="alert-danger"><spring:message code="team.invalid.name"/></p>
                                </c:if>
                                <br>
                                <button type="submit" class="btn btn-secondary btn-icon-split btn-lg">
                        <span class="icon text-white-50">
                            <i class="fas fa-arrow-right"></i>
                        </span>
                                    <span class="text"><spring:message code="team.join"/></span>
                                </button>
                            </form:form>
                        </div>
                    </div>
                </div>
            </div>

        </c:otherwise>
    </c:choose>

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