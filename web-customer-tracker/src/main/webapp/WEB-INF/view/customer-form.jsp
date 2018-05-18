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

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/add-customer-style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h3>CRM - Customer Relationship Manager</h3>
    </div>

    <div id="container">
        <h4>Save Customer</h4>
        <form:form action="saveCustomer" modelAttribute="customer" method="post">
            <!-- need to associate this data with customer id -->
            <form:hidden path="id" />

            <table>
                <tbody>
                <tr>
                    <td><label>First Name:</label></td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td><label>Last Name:</label></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td><label>Email:</label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <br>
                <tr>
                    <td><label></label></td>
                    <td><input type="submit" value="Save"/></td>
                </tr>
                </tbody>
            </table>
        </form:form>

        <div style="clear; both;"></div>
        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Go Back</a>
        </p>
    </div>
</div>

</body>
</html>
