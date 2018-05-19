<%--
  Created by IntelliJ IDEA.
  User: alexander.shakhov
  Date: 18.05.2018
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Form</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <%--    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
        <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/add-customer-style.css">--%>
</head>
<body>
<div class="container bg-dark">
    <div class="row justify-content-md-center">
        <div class="pos-f-t">
            <h3 class="col-md-auto text-lg-center text-light">Save Customer Form
                <span class="badge badge-secondary">CRUD</span></h3>

        </div>
    </div>
</div>

<div class="container">
    <form:form action="saveCustomer" modelAttribute="customer" method="post">
        <!-- need to associate this data with customer id -->
        <form:hidden path="id"/>
        <div class="form-row">
            <div class="form-group col-md-7">
                <label>First Name</label>
                <form:input cssClass="form-control" path="firstName" placeholder="First Name"/>
            </div>
            <div class="form-group col-md-7">
                <label>Last Name</label>
                <form:input cssClass="form-control" path="lastName" placeholder="Last Name"/>
            </div>
            <div class="form-group col-md-7">
                <label>Email</label>
                <form:input cssClass="form-control" path="email" placeholder="Email"/>
            </div>
        </div>
        <button type="submit" class="btn btn-outline-success my-2 my-sm-0" value="Save">Save
        </button>
        <button type="button" class="btn btn-outline-primary"><a
                href="${pageContext.request.contextPath}/customer/list">Go Back</a></button>
    </form:form>
</div>


</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
</body>
</html>
