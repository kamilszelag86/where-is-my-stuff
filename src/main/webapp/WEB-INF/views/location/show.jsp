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
        <h1 class="h3 mb-0 text-gray-800">Szczegóły lokalizacji</h1>
    </div>

    <!-- Content Row -->
    <div class="row">

        <div class="card shadow mb-4">
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered dataTable">
                        <tr>
                            <th>Nazwa</th>
                            <td>${location.name}</td>
                        </tr>
                        <tr>
                            <th>Opis</th>
                            <td>${location.description}</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Lista przedmiotów w danej lokalizacji</h6>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>Nazwa</th>
                            <th>Opis</th>
                            <th>Kategorie</th>
                            <th>Akcje</th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>Nazwa</th>
                            <th>Opis</th>
                            <th>Kategorie</th>
                            <th>Akcje</th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <c:forEach var="item" items="${items}">
                            <tr>
                                <td>${item.name}</td>
                                <td>${item.description}</td>
                                <td>
                                    <c:forEach var="category" items="${item.categories}">
                                        <p>${category.name}</p>
                                    </c:forEach>
                                </td>
                                <td>
                                    <a href="<c:url value="/app/item/edit/${item.id}"/>"
                                       class="btn btn-secondary btn-icon-split">
                                                <span class="icon text-white-50">
                                                <i class="fas fa-arrow-right"></i>
                                                </span>
                                        <span class="text">Edytuj</span>
                                    </a>
                                    <a href="<c:url value="/app/item/delete/${item.id}"/>"
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