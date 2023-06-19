<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">

<title>그룹 미션 등록</title>
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
	<h1>그룹 미션 만들기</h1>
	<form action="/bgm/create" method="post">
		미션 이름<br><input type="text" name="bgm_name"><br>
		목표 금액<br><input type="text" name="bgm_goal"><br>
		미션 설명<br><textarea name="bgm_content" cols="30" rows="3"></textarea><br>		
		시작 일<br><input type="date" name="bgm_start"><br>	
		종료 일<br><input type="date" name="bgm_end"><br>	
		<button type="submit">생성</button>
	</form>
</body>
</html>






