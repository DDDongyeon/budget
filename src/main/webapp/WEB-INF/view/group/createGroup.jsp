<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<html>
<head>
	<style>
	@import url('https://fonts.googleapis.com/css2?family=Inter&display=swap');
	</style>
	<link href="${path}/resources/css/group_create.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=yes">
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
		<button class="back-page" type="button" onclick="history.back()">
			<img src="${pageContext.request.contextPath}/resources/images/back-page.svg" alt="SVG">
		</button>
		<h1 class="create-group">그룹 만들기</h1>
	</div>
    <form action="/group/create" method="post">
    	<div class="register-form">
    		<div class="group-name1">
    			<div class="group-name-text">그룹 명</div><br>
		        <input class="group-name-rectangle" type="text" name="g_name"><br>
		    </div>
		    <div class="group-size">
		    	<div class="group-size-text">그룹 인원</div><br>
		        <input class="group-size-rectangle" type="text" name="g_maxpeople">
		        <div class="group-size-text2">(최대 30명)</div><br>
		    </div>
		    <div class="tag1">
		            <div class="tag-text">필수 태그</div><br>
		            <div class="tags">
			            <div onclick="selectRtag('청소년')" class="tag-button" id="tagButton1">
			      			<div class="tags-text">청소년</div>      
			           </div>
			            <div onclick="selectRtag('대학생')" class="tag-button" id="tagButton2">
			      			<div class="tags-text">대학생</div>       
			           </div>
			            <div onclick="selectRtag('취준생')" class="tag-button" id="tagButton3">
							<div class="tags-text">취준생</div> 
			            </div>
			            <div onclick="selectRtag('직장인')" class="tag-button" id="tagButton4">
			      			<div class="tags-text">직장인</div>       
			            </div>
			            <input type="hidden" name="g_rtag" id="selectedRtag" value="">
			            <br>
		            </div>
		    </div>
		    <div class="tag2">
		    	<div class="tag2-text">해시 태그</div><br>
		       	<input class="tag2-rectangle" type="text" name="g_tag"><br>
		    </div>
		    <div class="group-comment">
		    	 <div class="group-comment-text">그룹 설명</div><br>
		         <textarea class="group-comment-rectangle" name="g_content" cols="30" rows="3"></textarea><br>
		    </div>
        </div>
        <button class="submit-rectangle" type="submit" name="bgroupcommit">
        	<div class="submit-rectangle-text">생성 완료</div>
       </button>
    </form>

    <script>
        function selectRtag(value) {
            document.getElementById("selectedRtag").value = value;

            // 선택된 버튼 스타일 변경
            var buttons = document.getElementsByClassName("tag-button");
            for (var i = 0; i < buttons.length; i++) {
                if (buttons[i].innerText === value) {
                    buttons[i].style.background= "#0F9978";
                    buttons[i].style.fontWeight = "bold";
                } else {
                    buttons[i].style.background = "rgba(121, 204, 184, 0.77)";
                    buttons[i].style.fontWeight = "normal";
                }
            }
        }
    </script>
</body>
</html>
