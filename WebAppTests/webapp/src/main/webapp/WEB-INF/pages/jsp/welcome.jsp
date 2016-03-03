<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<html xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:spring="http://www.springframework.org/tags">


<body background="<c:url value="/resources/img/quiz.jpg"/>">
	<div align="center">
		<font size="4" face="fantasy" color="yellow"><spring:message
				code="YOUAREWELCOME" /></font>
	</div>
	<security:authorize access="hasRole('ROLE_student')">
		<div align="center">
			<a href="viewtests"><img alt="Viewtests"
				src="<c:url value="/resources/img/blueToDo.png" />" /> </a>
		</div>
	</security:authorize>

	<security:authorize access="hasRole('ROLE_tutor')">
		<div align="center">
			<a href="addTest"><img align="center" alt="Add new Test"
				height="70" width="200"
				src="<c:url value="/resources/img/blueAdd.png"/>"></a>
		</div>
	</security:authorize>

</body>
</html>