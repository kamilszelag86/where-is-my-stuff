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

    <a href="<c:url value="/app/location/add"/>" class="btn btn-secondary btn-icon-split btn-lg">
                    <span class="icon text-white-50">
                      <i class="fas fa-arrow-right"></i>
                    </span>
        <span class="text">Dodaj lokalizację</span>
    </a><br><br>
    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Lista lokalizacji</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                    <tr>
                        <th>Nazwa</th>
                        <th>Opis</th>
                        <th>Akcje</th>
                    </tr>
                    </thead>
                    <tfoot>
                    <tr>
                        <th>Nazwa</th>
                        <th>Opis</th>
                        <th>Akcje</th>
                    </tr>
                    </tfoot>
                    <tbody>
                    <c:forEach var="location" items="${locations}">
                        <tr>
                            <td>
                                <a href="<c:url value="/app/location/show/${location.id}"/>">${location.name}</a>
                            </td>
                            <td>${location.description}</td>
                            <td>
                                <a href="<c:url value="/app/location/edit/${location.id}"/>"
                                   class="btn btn-secondary btn-icon-split">
                                                <span class="icon text-white-50">
                                                <i class="fas fa-arrow-right"></i>
                                                </span>
                                    <span class="text">Edytuj</span>
                                </a>
                                <a href="<c:url value="/app/location/delete/${location.id}"/>"
                                   class="btn btn-danger btn-icon-split">
                                                <span class="icon text-white-50">
                                                <i class="fas fa-trash"></i>
                                                </span>
                                    <span class="text">Usuń</span>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
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