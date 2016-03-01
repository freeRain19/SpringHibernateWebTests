<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Test View</title>
</head>
<body bgcolor="#58E1BF">

	<h2 align="center">Select your subject</h2>
	<form action="selectTest" method="post">
		<table border="4" bgcolor="#4690FF" bordercolor="yellow"
			align="center" width="800">
			<tr align="center">
				<td><b>Test name</b> <br></td>
				<td><b>select test</b> <br></td>
				<td><b>subject</b> <br></td>
			</tr>
			<c:forEach var="i" begin="1" end="${tests.size()}">
				<tr align="center">
					<td width="30%">${tests[i-1].testName}</td>
					<td><input type="radio" name="idTest"
						value="${tests[i-1].idTest}">${tests[i-1].idTest}</td>
					<td>${tests[i-1].nameSubject}</td>
				</tr>
			</c:forEach>

			<tr>
				<td colspan="3" align="center"><input type="submit"
					value="To do test"></td>
			</tr>
		</table>
	</form>

	<table border="4" bgcolor="#4690FF" bordercolor="yellow" align="center"
		width="800">
		<tr align="center">
			<td>Your last result =${resultTest}%</td>
		</tr>
	</table>
	<a href="/webapp/">back to Main page</a>
</body>
</html>