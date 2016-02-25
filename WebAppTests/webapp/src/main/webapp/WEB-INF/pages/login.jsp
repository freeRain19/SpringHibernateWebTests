<%@ page language="java" contentType="text/html" 	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body bgcolor="#B39006">
	<form action="validate" method="post">
		<table align="center" border="1" bgcolor="#00CCFF">
			<tr>
				<td width="70">Name :</td>
				<td width="70"><input required="required" name="name" /></td>
			</tr>
			<tr>
				<td width="70">Password:</td>
				<td width="70"><input required="required" type="password"
					name="password"></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input align="center"
					type="submit" value="Login">
			</tr>
		</table>
		<input type="hidden" name="Action" value="validate" />
	</form>

	<h3 align="center">
		<c:out value="${incorrect}"/>
	</h3>
</body>
</html>