<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary"><spring:message code="item.edit"/></h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <form:form method="post" action="./" modelAttribute="item" enctype="multipart/form-data">
                    <form:hidden path="user.id" value="${user.id}"/>
                    <form:hidden path="team.id" value="${user.team.id}"/>
                    <form:hidden path="id"/>
                    <form:hidden path="itemImage"/>
                    <form:hidden path="receiptImage"/>
                    <spring:message code="name"/>:<br>
                    <form:input path="name"/><br>
                    <form:errors path="name" cssClass="alert-danger"/><br>
                    <spring:message code="description"/>:<br>
                    <form:input path="description"/><br><br>
                    <spring:message code="location"/>:<br>
                    <form:select path="location">
                        <form:option value="0" label="--Wybierz lokalizację--"/>
                        <form:options items="${locations}" itemLabel="name" itemValue="id"/>
                    </form:select><br><br>
                    <spring:message code="categories"/>:<br>
                    <form:checkboxes path="categories" items="${categories}" itemLabel="name" itemValue="id"
                                     delimiter="<br>"/><br><br>
                    <spring:message code="item.add.image"/>:<br>
                    <input type="file" name="image" accept="image/*"/><br><br>
                    <spring:message code="item.add.receipt"/>:<br>
                    <input type="file" name="receipt" accept="image/*"/><br><br>
                    <button type="submit" class="btn btn-success btn-icon-split btn-lg">
                        <span class="icon text-white-50">
                            <i class="fas fa-check"></i>
                        </span>
                        <span class="text"><spring:message code="save.changes"/></span>
                    </button>
                </form:form>
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
