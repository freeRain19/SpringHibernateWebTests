<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"
	session="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>

<title>Answer test</title>

</head>
<body bgcolor="#4274F2">
	<h2 align="center">Answer these questions</h2>
	<form action="checkTest" method="post">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<table bgcolor="#80E9F2" bordercolor="#D0FF00" border="1"
			align="center" width="600">
			<c:set var="i" value="${1}" />
			<h3 align="center">
				<c:out value="${currentTest.nameSubject}"></c:out>
			</h3>
			<h3 align="center">
				Test name :
				<c:out value="${currentTest.testName}"></c:out>
			</h3>

			<c:forEach items="${qDto.questions}" var="question">
				<tr bgcolor="#FFFC64">
					<td>${question.textQuestion}</td>
					<td></td>
				</tr>

				<c:forEach items="${question.answers}" var="answer">
					<tr align="center">
						<td><b>${answer.answerText} </b><br></td>
						<td width="30%"><input name="answer<c:out value="${i}"/>"
							type="checkbox" value="1"> <c:out value="${i}"></c:out></td>
					</tr>
					<c:set var="i" value="${i+1}" />
				</c:forEach>
			</c:forEach>
		</table>
		<br>
		<c:if test="${qDto.page-1>0}">
			<div align="left">
				<input type="submit" id="but1" name="page" value="${qDto.page-1}" />
			</div>
		</c:if>
		<c:if test="${qDto.remainPage>0}">
			<div align="right">
				<input type="submit" id="but2" name="page" value="${qDto.page+1}" />
			</div>
		</c:if>
		<c:if test="${qDto.remainPage==0}">
			<div align="center">
				<input type="submit" name="finish" value="Finish test" />
			</div>
		</c:if>
		<input type="hidden" name="Action" value="CheckTest" />
	</form>
	<h4 align="center">Remain ${qDto.remainPage} questions</h4>
</body>
</html>