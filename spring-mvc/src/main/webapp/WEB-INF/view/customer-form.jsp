<%--
  Created by IntelliJ IDEA.
  User: alexandershakhov
  Date: 08.05.2018
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Customer Form</title>
    <style>
        .error {
            color: crimson
        }
    </style>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>


<br>
<div class="container">
    <div class="row">
        <div class="col-sm">
            <i>Fill out the form when (*) is required fields</i>
            <form:form action="processCustomerForm" modelAttribute="customer">
                <div class="form-group">
                    <label class="form-control">First Name(*): <form:input path="firstName"/>
                        <form:errors path="firstName" cssClass="error"/>
                    </label>
                </div>
                <div class="form-group">
                    <label class="form-control">Last Name(*): <form:input path="lastName"/>
                        <form:errors path="lastName" cssClass="error"/>
                    </label>
                </div>
                <div class="form-group">
                    <label class="form-control">
                        Free passes: <form:input path="freePasses"/>
                        <form:errors cssClass="error" path="freePasses"/>
                    </label>
                </div>
                <div class="form-group">
                    <label class="form-control">
                        Postal Code: <form:input path="postalCode"/>
                        <form:errors cssClass="error" path="postalCode"/>
                    </label>
                </div>
                <div class="form-group">
                    <label class="form-control">
                        Course Code: <form:input path="courseCode"/>
                        <form:errors cssClass="error" path="courseCode"/>
                    </label>
                </div>
                <input type="submit" value="Submit" class="btn btn-primary"/>
            </form:form>
        </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
