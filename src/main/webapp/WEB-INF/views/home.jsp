<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<jsp:include page="fragments/head.jsp"/>

<body class="bg-gradient-dark">

<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <div class="row">
                <div class="p-5">
                    <div class="text-center">
                        <h1 class="h3 text-gray-900 mb-2 font-weight-bold">Where Is My Stuff</h1>
                        <br>
                        <hr>
                    </div>
                    <div class="text-left">
                        <p class="h5 text-gray-900 mb-2">
                            <br>
                            <spring:message code="about.message"/>
                            <br>
                        </p>
                        <hr>
                    </div>
                    <div class="text-center">
                        <p class="mb-4"><spring:message code="home.login.message"/></p>
                        <a href="<c:url value="/login"/>" class="btn btn-primary btn-user btn-block">
                            <spring:message code="login.button"/>
                        </a>
                        <br><br>
                        <p class="mb-4"><spring:message code="home.register.message"/></p>
                        <a href="<c:url value="/register"/>" class="btn btn-primary btn-user btn-block">
                            <spring:message code="form.register.submit"/>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<jsp:include page="fragments/foot.jsp"/>

</body>
</html>
