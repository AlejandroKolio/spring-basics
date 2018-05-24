<%--
  Created by IntelliJ IDEA.
  User: alexandershakhov
  Date: 06.05.2018
  Time: 13:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Confirmation</title>
</head>
<body>

<p>The student is confirmed: ${account.firstName} ${account.lastName} </p>
<br>
<p>The student country is:   ${account.country} </p>
<br>
<p>The student program language is:   ${account.programmingLanguage} </p>
<br>
<p>Operating Systems</p>
<ul>
    <c:forEach var="os" items="${account.operatingSystems}">
        <li>${os}</li>
    </c:forEach>
</ul>
</body>
</html>
