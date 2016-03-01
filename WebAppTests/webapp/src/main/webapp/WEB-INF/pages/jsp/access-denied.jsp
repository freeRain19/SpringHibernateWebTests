
<html xmlns:jsp="http://java.sun.com/JSP/Page"
	  xmlns:c="http://java.sun.com/jsp/jstl/core">

<jsp:directive.page pageEncoding="UTF-8" contentType="text/html; UTF-8"/>
<head>
	<title>AccessDenied page</title>
</head>
<body bgcolor="#FF2D37">
<div align="center">
<h1>ACCESS DENIED</h1>
	<h3>Dear <strong>${user}</strong>, You are not authorized to access this page</h3>
	<c:url var="logout" value="/logout"/>
	<b><a href="${logout}">Logout</a></b>
	</div>
</body>
</html>