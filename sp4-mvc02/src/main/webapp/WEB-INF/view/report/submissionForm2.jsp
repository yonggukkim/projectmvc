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
	<!-- 업로드되는 파일이 파일명만 보내지고 파일의 내용은 아스키코드로 변환되지 않기 때문에 binary형식으로 바꿀 수 있는 multipart 사용 -->
<form action="submitReport3" method="post" enctype="multipart/form-data">
학번 : <input type="text" name="studentNumber" />
<br />
리포트 파일 : <input type="file" name="report" />
<br />
<input type="submit" />
</body>
</html>