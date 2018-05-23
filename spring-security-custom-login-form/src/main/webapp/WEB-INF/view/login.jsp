<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: alexander.shakhov
  Date: 23.05.2018
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Custom Login Page</title>
</head>
<body>
    <h4>Sign in</h4>

    <div class="container">
        <form:form action="${pageContext.request.contextPath}/authenticateUser" method="post">
            <c:if test="${param.error != null}">
                <i style="color: crimson"> Sorry! You entered invalid username/password.</i>
            </c:if>
            <p>
                Username: <input type="text" name="username" />
            </p>
            <p>
                Password: <input type="password" name="password" />
            </p>

            <input type="submit" value="Login" />
        </form:form>
    </div> <!-- /container -->
</body>
</html>
