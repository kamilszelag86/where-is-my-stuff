<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/head.jsp"/>

<body class="bg-gradient-primary">
<div>
<sec:authorize access="isAuthenticated()">
    <% response.sendRedirect("app"); %>
</sec:authorize>
</div>

<div class="container">

    <!-- Outer Row -->
    <div class="row justify-content-center">

        <div class="col-xl-10 col-lg-12 col-md-9">

            <div class="card o-hidden border-0 shadow-lg my-5">
                <div class="card-body p-0">
                    <!-- Nested Row within Card Body -->
                    <div class="row">
                        <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
                        <div class="col-lg-6">
                            <div class="p-5">
                                <div class="text-center">
                                    <h1 class="h4 text-gray-900 mb-4"><spring:message code="login.welcome"/></h1>
                                </div>
                                <form:form class="user" method="post">
                                    <div class="form-group">
                                        <input type="text" name="username" class="form-control form-control-user"
                                               id="exampleInputEmail"
                                               aria-describedby="emailHelp"
                                               placeholder="<spring:message code="form.username"/>">
                                    </div>
                                    <div class="form-group">
                                        <input type="password" name="password" class="form-control form-control-user"
                                               id="exampleInputPassword"
                                               placeholder="<spring:message code="form.password"/>">
                                    </div>
<%--                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>--%>

                                    <input type="submit" value="<spring:message code="login.button"/>"
                                           class="btn btn-primary btn-user btn-block"/>

                                </form:form>
                                <hr>
                                <div class="text-center">
                                    <a class="small" href="<c:url value="/register"/>"><spring:message
                                            code="register.message"/> </a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>

    </div>

</div>

<jsp:include page="../fragments/foot.jsp"/>

</body>
</html>
