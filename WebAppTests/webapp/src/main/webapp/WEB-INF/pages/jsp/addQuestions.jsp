<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Add questions</title>
</head>
<body bgcolor="#AFF0FF">
	<form action="addQuestion" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<table border="2" bgcolor="#91C7D3" bordercolor="yellow"
			align="center" width="800">
			<tr align="center" bgcolor=#85E1AF>
				<td><b>Please, input question text</b><br></td>
				<td><textarea required rows="3" cols="33" name="textQuestion"></textarea>
				</td>
				<td>True / False field</td>
			</tr>
			<c:forEach var="i" begin="1" end="5">
				<tr align="center">
					<td width="30%"><b>Please, input answer <c:out
								value="${i }" /> text
					</b><br></td>
					<td><input required align="center"
						name="textAnswer<c:out value="${i}"/>"></td>
					<td width="20%">This answer is <br> <input
						name="state<c:out value="${i}"/>" type="radio" value="1">Valid
						<input name="state<c:out value="${i }"/>" type="radio" value="0"
						checked>Invalid
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3" align="center"><input type="submit"
					value="Add Question"> <input type="reset" value=Reset>
				</td>
			</tr>
		</table>
	</form>
	<br>
	<a href="/webapp/">back to Login page</a>
</body>
</html>