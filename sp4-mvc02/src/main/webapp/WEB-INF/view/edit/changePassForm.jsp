<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="change.pwd.title" /></title>
</head>
<body>
<%-- commandName="command" commandName에 들어간 이름이 command일 경우 생략이 가능! --%>
	<form:form>
		<p>
		<label><spring:message code="currentPassword" /><br />
		<form:password path="currentPassword"/> <!-- 필드명 -->
		<form:errors path="currentPassword" />	<!-- 필수입니다 라는 메시지를 띄우기 위한 -->
		</label>
		</p>
		<p>
		<label><spring:message code="newPassword" /><br />
		<form:password path="newPassword"/>
		<form:errors path="newPassword" />
		</label>
		</p>
		<input type="submit" value="<spring:message code="change.btn" />">
	</form:form>
</body>
</html>