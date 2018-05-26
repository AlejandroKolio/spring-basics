<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="">
	<meta name="author" content="">
	<title>Registration Confirmation</title>

	<!-- Bootstrap core CSS -->
	<link href="https://getbootstrap.com/docs/4.1/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- Custom styles for this template -->
	<link href="https://getbootstrap.com/docs/4.1/examples/sign-in/signin.css" rel="stylesheet">
</head>
<body class="text-center bg-dark">
<div class="container">
	<div class="py-5 text-center">
		<h2 class="text-light">Registration Successful</h2>
		<a class="altColor" href="${pageContext.request.contextPath}/login">Now you may login with new username</a>
	</div>
</div>
</body>
</html>
