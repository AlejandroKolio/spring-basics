<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://getbootstrap.com/favicon.ico">
    <title>Register New User</title>

    <!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="https://getbootstrap.com/docs/4.1/examples/sign-in/signin.css" rel="stylesheet">
</head>

<body class="text-center bg-dark">
<form:form cssClass="form-signin" action="${pageContext.request.contextPath}/register/processRegistrationForm" modelAttribute="user" >

    <h1 class="h3 mb-3 font-weight-normal text-light">Registration Form</h1>

    <!-- Check for registration error -->
    <c:if test="${registrationError != null}">
        <div class="alert alert-danger col-xs-offset-1 col-xs-10">${registrationError}</div>
    </c:if>

    <label for="userName" class="sr-only">Username</label>
    <form:input path="userName" placeholder="username" class="form-control"/>

    <label for="password" class="sr-only">Password</label>
    <form:password path="password" placeholder="password" class="form-control"/>

    <button class="btn btn-lg btn-outline-warning btn-block" type="submit">Register</button>

    <a class="btn btn-lg btn-outline-primary btn-block" href="${pageContext.request.contextPath}/">Back</a>

</form:form>
</body>


</html>
