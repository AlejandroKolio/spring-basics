<%--
  Created by IntelliJ IDEA.
  User: alexander.shakhov
  Date: 17.05.2018
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>List Customers</title>
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h3>CRM - Customer Relationship Manager</h3>
    </div>
</div>

<div id="container">
    <div id="content">
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>
            <c:forEach var="customer" items="${customers}">
                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>

</html>









