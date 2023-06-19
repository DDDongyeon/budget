<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>budget_start</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Inter&display=swap');
</style>
<link href="${path}/resources/css/budget_start.css" rel="stylesheet">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<jsp:include page="${path}/WEB-INF/view/navbar-budget.jsp" />
</head>
<body>
	<div class="top-rectangle">
		<div class="time">9:40</div>
		<div class="hamburger">
			<img src="${pageContext.request.contextPath}/resources/images/hamburger.svg" alt="SVG">
		</div>
		<div class="data">
			<img src="${pageContext.request.contextPath}/resources/images/data.svg" alt="SVG">
		</div>
		<div class="wifi">
			<img src="${pageContext.request.contextPath}/resources/images/wifi.svg" alt="SVG">
		</div>
		<div class="battery">
			<img src="${pageContext.request.contextPath}/resources/images/battery.svg" alt="SVG">
		</div>
		<h1 class="my-budget">마이 버찌</h1>
	</div>
	<div class="no-budget">
		<p>생성된 버찌가 없습니다.</p>
		<p>핑크색 플러스 버튼을 눌러</p>
		<p>버찌를 생성해 보세요!</p>
	</div>
	<button class="registerbtn" type="button" onclick="location.href='/budget/budget_register'">
		<img src="${pageContext.request.contextPath}/resources/images/budgetbtn.svg" alt="SVG">
	</button>
</body>
</html>
