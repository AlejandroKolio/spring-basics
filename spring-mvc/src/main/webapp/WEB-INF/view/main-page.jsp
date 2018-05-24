<%--
  Created by IntelliJ IDEA.
  User: alexandershakhov
  Date: 05.05.2018
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/my-test.css">
    <script src="${pageContext.request.contextPath}/assets/js/simple-test.js"></script>
</head>

<body>

<h2>Spring MVC Demo - Home Page</h2>

<a href="hello/showForm">Plain Hello World</a>
<br>
<a href="account/showForm">User Form</a>
<br>
<a href="customer/showCustomerForm">Customer Form</a>
<br>

<br><br>

<img src="${pageContext.request.contextPath}/assets/img/com.udemy.spring.spring-logo.png" />

<br><br>

<input type="button" onclick="doSomeWork()" value="Click Me"/>

</body>
</html>
