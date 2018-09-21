<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="member.register" /></title>
</head>
<body>
	<h2><spring:message code="member.info" /></h2>
	<%-- <form action="step3" method="post"> --%>
	<form:form action="step3" commandName="registerRequest">
		<p>
			<label><spring:message code="email" /> : <br />
				<!-- <input type="text" name="email" id="email" /> -->
				<form:input path="email" />
			</label>
		</p>
		<p>
			<label><spring:message code="name" /> : <br />
				<!-- <input type="text" name="name" id="name" /> -->
				<form:input path="name" />
			</label>
		</p>
		<p>
			<label><spring:message code="password" /> : <br />
				<!-- <input type="text" name="password" id="password" /> -->
				<form:input path="password" />
			</label>
		</p>
		<p>
			<label><spring:message code="password.confirm" /> : <br />
				<!-- <input type="text" name="confirmPassword" id="confirmPassword" /> -->
				<form:input path="confirmPassword" />
			</label>
		</p>
		<input type="submit" value="<spring:message code="register.btn" />">
	<%-- </form> --%>
	</form:form>
</body>
</html>