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
    <c:choose>
        <c:when test="${isEmpty}">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary"><spring:message code="location.delete.confirm"/></h6>
                </div>
                <div class="card-body">
                    <div class="chart-bar">
                        <a href="<c:url value="/app/location/all"/>" class="btn btn-primary btn-icon-split btn-lg">
                        <span class="icon text-gray-600">
                          <i class="fas fa-arrow-right"></i>
                        </span>
                            <span class="text"><spring:message code="no.button"/></span>
                        </a><br><br>
                        <form:form method="post" action="./">
                            <input type="hidden" name="locationId" value="${locationId}">
                            <button type="submit" class="btn btn-danger btn-icon-split btn-lg">
                        <span class="icon text-white-50">
                                                    <i class="fas fa-trash"></i>
                                                    </span>
                                <span class="text"><spring:message code="yes.button"/></span>
                            </button>
                        </form:form>
                    </div>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <div class="card mb-4 py-3 border-bottom-danger border-left-danger">
                <div class="card-body">
                    <spring:message code="location.delete.alert"/>
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
