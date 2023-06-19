<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">


<title>Insert title here</title>
</head>
<body>
	<%@ include file="../navbar-mypage.jsp"%>
	<a href="/Buser/logout">로그아웃</a>
	<hr> 당신의 정보는 <br>
	${buser }
</body>
</html>