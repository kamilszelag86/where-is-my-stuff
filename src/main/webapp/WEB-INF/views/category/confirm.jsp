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
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Czy na pewno chcesz usunąć kategorię??</h6>
        </div>
        <div class="card-body">
            <div class="chart-bar">
                <a href="<c:url value="/app/category/all"/>" class="btn btn-primary btn-icon-split btn-lg">
                        <span class="icon text-gray-600">
                          <i class="fas fa-arrow-right"></i>
                        </span>
                    <span class="text">NIE</span>
                </a><br><br>
                <form:form method="post" action="./">
                    <input type="hidden" name="categoryId" value="${categoryId}">
                    <button type="submit" class="btn btn-danger btn-icon-split btn-lg">
                        <span class="icon text-white-50">
                                                    <i class="fas fa-trash"></i>
                                                    </span>
                        <span class="text">TAK</span>
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
