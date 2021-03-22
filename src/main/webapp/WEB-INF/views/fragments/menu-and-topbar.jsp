<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<sec:authentication property="principal.user" var="user"/>

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<c:url value="/app"/>">
            <div class="sidebar-brand-text mx-3">MY APP</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Nav Item - Items -->
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/app/item/all"/>">
                <i class="fas fa-fw "></i>
                <span>Przedmioty</span></a>
        </li>

        <!-- Nav Item - Locations -->
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/app/location/all"/>">
                <i class="fas fa-fw "></i>
                <span>Lokalizacje</span></a>
        </li>

        <!-- Nav Item - Categories -->
        <li class="nav-item">
            <a class="nav-link" href="<c:url value="/app/category/all"/>">
                <i class="fas fa-fw "></i>
                <span>Kategorie</span></a>
        </li>
        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">
        
        <c:if test="${user.team.haveActiveRequests}">
            <li class="nav-item">
                <a class="nav-link" href="<c:url value="/app/category/all"/>">
                    <i class="fas fa-fw "></i>
                    <span>Żądania dołączenia do zespołu</span></a>
            </li>
        </c:if>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>

    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">
            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>

                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Twój zespół: ${user.team.name}</h6>
                </div>

                <!-- Topbar Navbar -->
                <ul class="navbar-nav ml-auto">

                    <div class="topbar-divider d-none d-sm-block"></div>
                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 ">Witaj, ${user.firstName}</span>
                            <img class="img-profile rounded-circle"
                                 src="<c:url value="https://cdn4.iconfinder.com/data/icons/small-n-flat/24/user-alt-512.png"/>">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">

                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Logout
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->
