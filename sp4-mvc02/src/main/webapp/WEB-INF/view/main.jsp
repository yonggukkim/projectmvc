<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- prefix에 정해진 c 태그 uri를 저장  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty authInfo}">
	<p>환영합니다.</p>
		<p><a href="<c:url value='/login' />">
		[로그인하기]</a>
		<p><a href="<c:url value='/register/step1' />">
		[회원 가입하기]</a>
	</p>
	</c:if>
	<c:if test="${!empty authInfo}">
		<p>${authInfo.name}님, 환영합니다.</p>
		<a href="<c:url value="/edit/changePassword" />">[비밀번호 변경]</a>
		<a href="<c:url value="/logout" />">[로그아웃]</a>
	</c:if>
</body>
</html>