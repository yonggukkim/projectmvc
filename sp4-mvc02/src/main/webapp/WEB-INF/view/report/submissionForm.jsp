<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 일반적인 폼 태그(default:application)는 아스키코드(일반문자형식)로 값이 날아감 -->
<form action="submitReport1" method="post" enctype="multipart/form-data">
학번 : <input type="text" name="studentNumber" />
<br />
리포트 파일 : <input type="file" name="report" />
<br />
<input type="submit" />
</form>
</body>
</html>