<%@page contentType="text/html"  pageEncoding="UTF-8"  language="java"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
			<input type="hidden" name="Action" value="intputTest" />
	</form>
</body>
</html>