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
<form:form action="processForm" modelAttribute="account">
    First Name: <form:input path="firstName"/>
    <br>
    Last Name: <form:input path="lastName"/>
    <br>
    Country:
    <br>
    <form:select path="country">
        <form:options items="${account.countries}"/>
    </form:select>
    <br>
    Language:
    <br>
    Java <form:radiobutton path="programmingLanguage" value="Java"/>
    C# <form:radiobutton path="programmingLanguage" value="C#"/>
    C++ <form:radiobutton path="programmingLanguage" value="C++"/>
    Swing <form:radiobutton path="programmingLanguage" value="Swing"/>
    <br>
    Operating Systems:
    <br>
    Linux <form:checkbox path="operatingSystems" value="Linux"/>
    Mac OS <form:checkbox path="operatingSystems" value="Mac OS"/>
    MS Windows <form:checkbox path="operatingSystems" value="MS Windows"/>
    <input type="submit" value="Submit">
</form:form>


</body>
</html>
