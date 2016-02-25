<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ERROR</title>
</head>
<body bgcolor = "#8CFFEC">
	<h1 align="center">ERROR 404 page</h1>
	<br>
	<h2>
		<c:out value="${error}" />
	</h2>
	<br>
	<form>
		<input type=button value="previous page" onClick=history.back()>
	</form>

</body>
</html>