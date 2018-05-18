<%--
  Created by IntelliJ IDEA.
  User: alexander.shakhov
  Date: 17.05.2018
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>List Customers</title>
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h3>CRM - Customer Relationship Manager</h3>
        <link type="text/css"
              rel="stylesheet"
              href="${pageContext.request.contextPath}/assets/css/style.css" />
    </div>
</div>

<div id="container">
    <div id="content">

        <%-- Button to add customers --%>
    <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>

            <!--  add a search box -->
            <form:form action="search" method="POST">
                Search customer:
                <input type="text" name="searchName" />
                <input type="submit" value="Search" class="add-button" />
            </form:form>

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>
            <c:forEach var="customer" items="${customers}">
                <c:url var="updateLink" value="/customer/showFormForUpdate">
                    <c:param name="customerId" value="${customer.id}"/>
                </c:url>
                <c:url var="deleteLink" value="/customer/delete">
                    <c:param name="customerId" value="${customer.id}"/>
                </c:url>
                <tr>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td>
                        <a href="${updateLink}">Update</a>
                        |
                        <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false; ">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>

</body>

</html>









