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
        <h1 class="h3 mb-0 text-gray-800"><spring:message code="item.details"/></h1>
    </div>

    <!-- Content Row -->
    <div class="row">

        <div class="card shadow mb-4">
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered dataTable">
                        <tr>
                            <th><spring:message code="name"/></th>
                            <td>${item.name}</td>
                        </tr>
                        <tr>
                            <th><spring:message code="description"/></th>
                            <td>${item.description}</td>
                        </tr>
                        <tr>
                            <th><spring:message code="location"/></th>
                            <td>
                                <a href="<c:url value="/app/location/show/${item.location.id}"/>">${item.location.name}</a>
                            </td>
                        </tr>
                        <tr>
                            <th><spring:message code="categories"/></th>
                            <td>
                                <c:forEach var="category" items="${item.categories}">
                                    <a href="<c:url value="/app/category/show/${category.id}"/>">${category.name}</a><br>
                                </c:forEach>
                            </td>
                        </tr>
                        <tr>
                            <th><spring:message code="added.by"/></th>
                            <td>${item.user.firstName} ${item.user.lastName}</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>

        <!-- Illustrations -->
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary"><spring:message code="image"/></h6>
            </div>
            <div class="card-body">
                <div class="text-center">
                    <c:choose>
                        <c:when test="${not empty item.itemImagePath}">
                            <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 30rem;"
                                 src="${item.itemImagePath}" alt="">
                        </c:when>
                        <c:otherwise>
                            <form:form action="/app/item/image" method="post" enctype="multipart/form-data">
                                <input type="hidden" name="item" value="${item.id}"/>
                                <spring:message code="item.add.image"/>:<br><br>
                                <input type="file" name="image" accept="image/*"/><br><br>
                                <button type="submit" class="btn btn-success btn-icon-split btn-sm">
                                    <span class="icon text-white-50">
                                    <i class="fas fa-check"></i>
                                    </span>
                                    <span class="text"><spring:message code="save"/></span>
                                </button>
                            </form:form>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="card shadow mb-4">
            <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary"><spring:message code="receipt"/></h6>
            </div>
            <div class="card-body">
                <div class="text-center">
                    <c:choose>
                        <c:when test="${not empty item.receiptImagePath}">
                            <img class="img-fluid px-3 px-sm-4 mt-3 mb-4" style="width: 25rem;"
                                 src="${item.receiptImagePath}" alt="">
                        </c:when>
                        <c:otherwise>
                            <form:form action="/app/item/receipt" method="post" enctype="multipart/form-data">
                                <input type="hidden" name="item" value="${item.id}"/>
                                <spring:message code="item.add.receipt"/>:<br><br>
                                <input type="file" name="receipt" accept="image/*"/><br><br>
                                <button type="submit" class="btn btn-success btn-icon-split btn-sm">
                                    <span class="icon text-white-50">
                                    <i class="fas fa-check"></i>
                                    </span>
                                    <span class="text"><spring:message code="save"/></span>
                                </button>
                            </form:form>
                        </c:otherwise>
                    </c:choose>
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