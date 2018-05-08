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
    <title>Customer Form</title>
    <style>
        .error {
            color: crimson
        }
    </style>
</head>
<body>
<i>Fill out the form when (*) is required fields</i>
<form:form action="processCustomerForm" modelAttribute="customer">
    First Name(*): <form:input path="firstName"/>
    <form:errors path="firstName" cssClass="error"/>
    <br>
    Last Name(*): <form:input path="lastName"/>
    <form:errors path="lastName" cssClass="error"/>
    <br>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
