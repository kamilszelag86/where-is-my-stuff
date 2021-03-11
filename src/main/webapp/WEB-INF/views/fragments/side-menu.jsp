<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<body>

<!-- Sidebar -->
<ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

    <!-- Sidebar - Brand -->
    <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<c:url value="/"/>">
        <div class="sidebar-brand-icon rotate-n-15">
            <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Nazwa</div>
    </a>

    <!-- Divider -->
    <hr class="sidebar-divider my-0">

    <!-- Nav Item - Dashboard -->
    <li class="nav-item">
        <a class="nav-link" href="index.html">
            <i class="fas fa-fw "></i>
            <span>Dashboard</span></a>
    </li>

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

    <!-- Sidebar Toggler (Sidebar) -->
    <div class="text-center d-none d-md-inline">
        <button class="rounded-circle border-0" id="sidebarToggle"></button>
    </div>

</ul>
<!-- End of Sidebar -->
  
  </body>
</html>
