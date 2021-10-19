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

    <a href="<c:url value="/app/item/add"/>" class="btn btn-secondary btn-icon-split btn-lg">
                    <span class="icon text-white-50">
                      <i class="fas fa-arrow-right"></i>
                    </span>
        <span class="text"><spring:message code="item.add"/></span>
    </a><br><br>

    <div class="row">
        <form:form method="post" action="/app/item/location">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary"><spring:message code="item.list"/></h6>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th></th>
                                <th><spring:message code="name"/></th>
                                <th><spring:message code="image"/></th>
                                <th><spring:message code="description"/></th>
                                <th><spring:message code="location"/></th>
                                <th><spring:message code="categories"/></th>
                                <th><spring:message code="actions"/></th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th></th>
                                <th><spring:message code="name"/></th>
                                <th><spring:message code="image"/></th>
                                <th><spring:message code="description"/></th>
                                <th><spring:message code="location"/></th>
                                <th><spring:message code="categories"/></th>
                                <th><spring:message code="actions"/></th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach var="item" items="${items}">
                                <tr>
                                    <td><input type="checkbox" name="itemsToMove" value="${item.id}"></td>
                                    <td><a href="<c:url value="/app/item/show/${item.id}"/>">${item.name}</a></td>
                                    <td><img src="${item.itemImagePath}" height="70"/></td>
                                    <td>${item.description}</td>
                                    <td>
                                        <a href="<c:url value="/app/location/show/${item.location.id}"/>">${item.location.name}</a>
                                    </td>
                                    <td>
                                        <c:forEach var="category" items="${item.categories}">
                                            <a href="<c:url value="/app/category/show/${category.id}"/>">${category.name}</a><br>
                                        </c:forEach>
                                    </td>
                                    <td>
                                        <a href="<c:url value="/app/item/edit/${item.id}"/>"
                                           class="btn btn-secondary btn-icon-split">
                                                <span class="icon text-white-50">
                                                <i class="fas fa-arrow-right"></i>
                                                </span>
                                            <span class="text"><spring:message code="edit"/></span>
                                        </a>
                                        <a href="<c:url value="/app/item/delete/${item.id}"/>"
                                           class="btn btn-danger btn-icon-split">
                                                <span class="icon text-white-50">
                                                <i class="fas fa-trash"></i>
                                                </span>
                                            <span class="text"><spring:message code="delete"/></span>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <spring:message code="location.select"/>:<br>
            <select name="location">
                <c:forEach var="location" items="${locations}">
                    <option value="${location.id}">${location.name}</option>
                </c:forEach>
            </select>
            <button type="submit" class="btn btn-success btn-icon-split btn-lg">
                        <span class="icon text-white-50">
                            <i class="fas fa-arrow-right"></i>
                        </span>
                <span class="text"><spring:message code="move.selected"/></span>
            </button>
        </form:form>
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