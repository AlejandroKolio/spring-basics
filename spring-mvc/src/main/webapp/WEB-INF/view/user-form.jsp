<%--
  Created by IntelliJ IDEA.
  User: alexandershakhov
  Date: 06.05.2018
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User Registration Form</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="user">
        First Name: <form:input path="firstName"/>
        <br>
        Last Name: <form:input path="lastName"/>
        <input type="submit" value="Submit">
    </form:form>


</body>
</html>
