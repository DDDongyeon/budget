<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>budget_register</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Inter&display=swap');
</style>
<link href="${path}/resources/css/budget_register.css" rel="stylesheet">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
</head>
<body>
	<div class="container">
		<div class="top-rectangle">
			<div class="time">9:40</div>
			<div class="data">
				<img src="${pageContext.request.contextPath}/resources/images/data.svg" alt="SVG">
			</div>
			<div class="wifi">
				<img src="${pageContext.request.contextPath}/resources/images/wifi.svg" alt="SVG">
			</div>
			<div class="battery">
				<img src="${pageContext.request.contextPath}/resources/images/battery.svg" alt="SVG">
			</div>
			<div class="back-page" onclick="history.back()">
				<img src="${pageContext.request.contextPath}/resources/images/back-page.svg" alt="SVG">
			</div>
			<h1 class="make-budget">버찌 만들기</h1>
		</div>
		<form action="/budget/create" method="post">
			<div class="register-form">
				<input type="hidden" name="goal_now" value="0">
				<div class="budget-name">
					<div class="budget-name-title">버찌 제목</div><br>
					<input class="budget-name-rectangle" type="text" name="title"><br>
				</div>
				<div class="start-date">
					<div class="start-date-title">시작 날짜</div><br>
					<input class="start-date-rectangle" type="date" name="start_date"><br>
				</div>
				<div class="end-date">
					<div class="end-date-title">종료 날짜</div><br>
					<input class="end-date-rectangle" type="date" name="end_date"><br>
				</div>
				<div class="budget-money">
					<div class="budget-money-title">버찌 금액</div><br>
					<div class="cherry-img">
						<img src="/resources/images/cherry.png">
					</div>
					<input class="budget-money-rectangle" type="number" name="goal"><br>		
				</div>
				<div class="one-text">
					<div class="one-text-title">다짐 한마디</div><br>
					<textarea class="one-text-rectangle" name="comment" cols="30" rows="3"></textarea><br>
				</div>
			</div>	
			<button class="submit-rectangle" type="submit" name="budgetcommit">
				<div class="submit-rectangle-text">생성 완료</div>
			</button>
			</form>
		</div>		
</body>
</html>
