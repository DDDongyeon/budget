<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<style>
 @import
	url('https://fonts.googleapis.com/css2?family=Inter&display=swap'); 
</style>
<link href="${path}/resources/css/signup.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">

    <title>회원가입</title>
</head>
<body>
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
			<h1 class="title">회원 가입</h1>
	</div>
	<div class="signupNav">
		<div class="statusbar"></div>
		<div class="signupTitle">
			<a href="/"><img class="prev" alt="" src="${path}/resources/images/prev.svg"></a>
			
			<div class="signup">회원가입</div>
		</div>
	</div>
	
	<div>
	    <form action="signup" method="post">
	    	<div class="signupForm">
		        <div>
		            <label for="user_id"><p>사용자ID</p></label>
		            <input type="text" name="user_id" id="user_id">
		        </div>
		        <div>
		            <label for="user_pwd"><p>비밀번호</p></label>
		            <input type="password" name="user_pwd" id="user_pwd">
		        </div>
		        <div>
		            <label for="user_pwd2"><p>비밀번호 확인</p></label>
		            <input type="password" name="user_pwd2" id="user_pwd2">
		        </div>
		        <div>
		            <label for="user_name"><p>이름</p></label>
		            <input type="text" name="user_name" id="user_name">
		        </div>
		        <div>
		            <label for="user_nickname"><p>닉네임</p></label>
		            <input type="text" name="user_nickname" id="user_nickname">
		        </div>
		        <div>
		            <label for="user_email"><p>이메일</p></label>
		            <input type="email" name="user_email" id="user_email">
		        </div>
		         <!-- 에러 메시지 출력 -->
		        <%-- 아이디 중복 메시지 출력 --%>
		        <c:if test="${not empty error}">
		            <p>${error}</p>
		        </c:if>
	    	</div>
	        <button class="signupBtn" type="submit">회원가입</button>
	    </form>
	</div>
</body>
</html>
