<%--
  Created by IntelliJ IDEA.
  User: alexandershakhov
  Date: 08.05.2018
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Confirmation</title>
</head>
<body>
<h4>The customer is confirmed: ${customer.firstName} ${customer.lastName}</h4>
<h4>The customer free passes: ${customer.freePasses}</h4>
<h4>The customer postal code: ${customer.postalCode}</h4>
<h4>The customer course code: ${customer.courseCode}</h4>
</body>
</html>
