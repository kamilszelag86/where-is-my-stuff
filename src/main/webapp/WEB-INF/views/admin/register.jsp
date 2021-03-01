<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                            <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                        </div>
                        <form:form cssClass="user" method="post" modelAttribute="user">
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <form:input path="firstName" cssClass="form-control form-control-user"
                                                id="exampleFirstName" placeholder="First Name"/><br>
                                    <form:errors path="firstName" cssClass="alert-danger"/>
                                </div>
                                <div class="col-sm-6">
                                    <form:input path="lastName" cssClass="form-control form-control-user"
                                                id="exampleLastName" placeholder="Last Name"/><br>
                                    <form:errors path="lastName" cssClass="alert-danger"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <form:input path="username" cssClass="form-control form-control-user"
                                            id="exampleInputEmail" placeholder="Username"/><br>
                                <form:errors path="username" cssClass="alert-danger"/>
                            </div>
                            <div class="form-group row">
                                <div class="col-sm-6 mb-3 mb-sm-0">
                                    <form:input path="password" cssClass="form-control form-control-user"
                                                id="exampleInputPassword" placeholder="Password"/><br>
                                    <form:errors path="password" cssClass="alert-danger"/>
                                </div>
                                <div class="col-sm-6">
                                    <input type="password" class="form-control form-control-user"
                                           id="exampleRepeatPassword" placeholder="Repeat Password">
                                </div>
                            </div>
                            <input type="submit" class="btn btn-primary btn-user btn-block"
                                   value="Register Account"/>
                            <hr>
                        </form:form>
                        <hr>
                        <div class="text-center">
                            <a class="small" href="forgot-password.html">Forgot Password?</a>
                        </div>
                        <div class="text-center">
                            <a class="small" href="<c:url value="/login"/>">Already have an account? Login!</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<jsp:include page="../fragments/foot.jsp"/>

<%--<div>--%>
<%--    <form:form method="post" modelAttribute="user">--%>
<%--        Imię: <form:input path="firstName"/>--%>
<%--        <form:errors path="firstName" cssClass="invalid-feedback"/><br>--%>
<%--        Nazwisko: <form:input path="lastName"/>--%>
<%--        <form:errors path="lastName" cssClass="alert-danger"/><br>--%>
<%--        Username: <form:input path="username"/>--%>
<%--        <form:errors path="username"/><br>--%>
<%--        Hasło: <form:input path="password" type="password"/>--%>
<%--        <form:errors path="password"/><br>--%>
<%--        <input type="submit" value="Zarejestruj">--%>

<%--    </form:form>--%>
<%--</div>--%>

</body>
</html>
