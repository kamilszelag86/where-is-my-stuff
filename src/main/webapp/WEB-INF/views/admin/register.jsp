<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<jsp:include page="../fragments/head.jsp"/>

<body class="bg-gradient-primary">

<div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
                <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
                <div class="col-lg-7">
                    <div class="p-5">
                        <div class="text-center">
                            <h1 class="h4 text-gray-900 mb-4"><spring:message code="register.message"/></h1>
                        </div>
                        <form:form cssClass="user" method="post" modelAttribute="user">
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <spring:message code="form.firstname" var="msg"/>
                                    <form:input path="firstName" cssClass="form-control form-control-user"
                                                id="exampleFirstName" placeholder="${msg}"/><br>
                                    <form:errors path="firstName" cssClass="alert-danger"/>
                                </div>
                                <div class="col-sm-6">
                                    <spring:message code="form.lastname" var="msg"/>
                                    <form:input path="lastName" cssClass="form-control form-control-user"
                                                id="exampleLastName" placeholder="${msg}"/><br>
                                    <form:errors path="lastName" cssClass="alert-danger"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <spring:message code="form.username" var="msg"/>
                                <form:input path="username" cssClass="form-control form-control-user"
                                            id="exampleInputEmail" placeholder="${msg}"/><br>
                                <form:errors path="username" cssClass="alert-danger"/>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <spring:message code="form.password" var="msg"/>
                                    <form:input path="password" type="password"
                                                cssClass="form-control form-control-user"
                                                id="exampleInputPassword" placeholder="${msg}"/><br>
                                    <form:errors path="password" cssClass="alert-danger"/>
                                </div>
                                <div class="col-sm-6">
                                    <spring:message code="form.confirm-password" var="msg"/>
                                    <form:input path="confirmPassword" type="password"
                                                class="form-control form-control-user"
                                                id="exampleRepeatPassword" placeholder="${msg}"/><br>
                                    <div class="alert-danger">${confirmMessage}</div>
                                </div>
                            </div>
                            <spring:message code="form.register.submit" var="msg"/>
                            <input type="submit" class="btn btn-primary btn-user btn-block"
                                   value="${msg}"/>
                            <hr>
                        </form:form>
                        <div class="text-center">
                            <a class="small" href="<c:url value="/login"/>"><spring:message code="login.message"/></a>
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
