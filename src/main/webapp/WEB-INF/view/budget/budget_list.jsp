<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Budget</title>
<style>
@import url('https://fonts.googleapis.com/css2?family=Inter&display=swap');
</style>
<link href="${path}/resources/css/budget_list.css" rel="stylesheet">
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
		<div class="container">
			<div class="budget-list">
				<% int itemCount=0; %>
				<c:forEach items="${budgetList}" var="bd">
				<div class="list">
					<button  class="button1" type="button" onclick="location.href='/budget/budget_detail${bd.bd_no}'">
						<div class="cherry">
							<img src="/resources/images/cherry.png">
						</div>
						<div class="budget-name">${bd.bd_name}</div><br>
						<div class="budget-detail">목표금액 : ${bd.bd_goal} 남은금액 : ${bd.bd_goalleft} </div>
						<div class="line"></div>
					</button>
				</div>	
					<% itemCount++; %>
				</c:forEach>
				<script>
					var container = document.querySelector('.container');
			        var budgetList = document.querySelector('.budget-list');
			        var itemCount = <%= itemCount %>;
			        container.style.height = budgetList.offsetHeight + (itemCount) * 80 + 'px';
				</script>
			</div>
		</div>
		<button class="button2" type="button" onclick="location.href='/budget/budget_register'">
			<img src="${pageContext.request.contextPath}/resources/images/budgetbtn.svg" alt="SVG">
		</button>
</body>
</html>
