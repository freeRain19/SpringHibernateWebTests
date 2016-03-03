<%@page contentType="text/html"  pageEncoding="UTF-8"  language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<Title>Enter new test</Title>
</head>
<body bgcolor="#fdf5aa">
	<h2 align="center">Add new Test</h2>
	<form action=inputTest method="post">
		<table border="2" bgcolor="#4690FF" bordercolor="yellow"
			align="center" width="800">
			<tr align="center">
				<td width="50%"><b>Select subject for test</b> <br></td>

				<td><select required="required" name=subject width="300">
						<option value="Chemistry">Chemistry</option>
						<option value="Physics">Physics</option>
						<option value="English">English</option>
				</select></td>
			</tr>
			<tr align="center">
				<td><b>Please, input test name</b><br></td>
				<td><input  name="testName"></td>
			</tr>
			<tr><td align="center" colspan="2"><input type="submit" value="A D D new Test" align="center"></td></tr>
		</table>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
	</form>
	<a href="/webapp/">back to Main page</a>
</body>
</html>