<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹 정보</title>
</head>
<body>

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
      <button class="back-page" type="button" onclick="location.href='/budget/budget_list'">
         <img src="${pageContext.request.contextPath}/resources/images/back-page.svg" alt="SVG">
      </button>
      <h1 class="my-budget">상단바</h1>
   </div>
	<h1>그룹 미션 정보</h1> <br>
	<a>미션 이름 : ${name}</a><br>
	<a>목표 금액 : ${goal}</a><br>
<%-- 	<a>시작일 : ${start}</a><br> 
	<a>종료일 : ${end}</a><br>
 --%>
 	<a>미션 설명 : ${content}</a><br>
	
</body>
</html>