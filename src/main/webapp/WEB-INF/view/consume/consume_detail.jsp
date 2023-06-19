<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<style>
 @import
	url('https://fonts.googleapis.com/css2?family=Inter&display=swap'); 
</style>
<link href="${path}/resources/css/consume_detail.css" rel="stylesheet">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="top-rectangle">
			<div class="time">9:40</div>
			<div class="data">
				<img
					src="${pageContext.request.contextPath}/resources/images/data.svg"
					alt="SVG">
			</div>
			<div class="wifi">
				<img
					src="${pageContext.request.contextPath}/resources/images/wifi.svg"
					alt="SVG">
			</div>
			<div class="battery">
				<img
					src="${pageContext.request.contextPath}/resources/images/battery.svg"
					alt="SVG">
			</div>
			<button class="back-page" type="button" onclick="history.back()">
				<img
					src="${pageContext.request.contextPath}/resources/images/back-page.svg"
					alt="SVG">
			</button>
			<h1 class="title">상세 내역</h1>
	</div>
		
	<%-- <%@ include file="../navbar.jsp"%> --%>
	<!-- <h1>상세 내역</h1> -->


	<%-- <h2>${csm_date_modify }</h2> --%>
	<div class="form">
		<h2 class="date">${year}년 ${month}월 ${day}일</h2>  
		<c:forEach var="entry" items="${categoryMap}">
			<c:set var="key" value="${entry.key}" />
			<c:set var="value" value="${entry.value}" />
	
			<c:if test="${key eq csm.c_categoryid}"> 
				<div class="c${entry.key}"> 
					 <div class="cfont"> ${value}</div>
				 </div>
			</c:if>
		</c:forEach>
	
		<br>
		<div class="money">
			<div class="mfont">	${csm.c_money } </div>
		 </div>
		<hr class="dot-line">
		<div class=content>
			${csm.c_content }
		</div>
		<%-- <img src="${pageContext.request.contextPath}/resources/${csm.c_image}"
			alt="이미지" /> --%>
		<%-- <img src="${csm.c_image}" alt="이미지" /> --%>
		<%-- <img src="${path}/resources/jpg/${csm.c_image}" width="400">  --%>
	
		<c:if test="${csm.c_image ne 'none'}">
			
				<img class="img" src="${path}/resources/jpg/${csm.c_image}" width="400" alt="이미지">
							
		</c:if>
	</div>
	<button class="btn1" type="button">수정</button>
	<button class="btn2" type="button">삭제</button>
</div>


</body>
</html>