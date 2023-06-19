<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<html>
<head>
	<style>
	@import url('https://fonts.googleapis.com/css2?family=Inter&display=swap');
	</style>
	<link href="${path}/resources/css/group_feed.css" rel="stylesheet">
<title>GroupFeed</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
    <jsp:include page="${path}/WEB-INF/view/navbar-group.jsp" />
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
			<h1 class="group-name">${groupName}</h1>
		</div>
<hr>
<div class="container">
<a class="feed" onclick="location.href='/group/feed?groupNo=${g_no}'">
	<span class="feed-content">피드</span>
	</a>
		<a class="calendar" onclick="location.href='/group/groupcalendar'">
		<span class="calendar-content">캘린더</span>
		</a>
	<div class="banner" onclick="location.href='/bgm/now${bgmNo}'">
    <a class="banner-img"><img src="${pageContext.request.contextPath}/resources/images/alarm.svg" alt="SVG"></a>
    <div class="name" onclick="goToGroupMissionPage(${bgmNo})">${name}</div>
    </div>
<div class="last">최신등록순</div>
<div class="box">
	<div class="box-list">
		<% int itemCount=0; %>
		<c:forEach items="${consumes}" var="consume">
		<div class="feedlist">
			<div class="cherryicon">
				<img src="${pageContext.request.contextPath}/resources/images/cheeryicon.svg" alt="SVG">
			</div>
			<div class="consume-user">${consume.user_nickname}</div>
		    <div class="consume-date">${consume.c_date}</div><br>
			<div class="consume-money">-${consume.c_money}원</div>
			<div class="consume-category-rectangle${consume.c_categoryid}">
				<div class="consume-category">${categoryMap.get(consume.c_categoryid)}</div>
			</div><br>
			<div class="consume-content">${consume.c_content}</div>
			<c:if test="${not empty consume.c_image}"><img class="consume-img" src="${path}/resources/jpg/${consume.c_image}" width="30" height="30"></c:if>
			<div class="comment" onclick="goToComment(${consume.c_no})">
				<img src="${pageContext.request.contextPath}/resources/images/commentimg.svg" alt="SVG">
				<div class="commentNum">${consume.commentNum}</div>
			</div>
			
			<div class="like" data-consume-no="${consume.c_no}" onclick="increaseLikeCount(${consume.c_no})">
				<img src="${pageContext.request.contextPath}/resources/images/likeimg.svg" alt="SVG">
	   			<div class="likeNum">${consume.c_like}</div>
			</div>
			
			<div class="cline"></div>
		</div>
		<% itemCount++; %>
		</c:forEach>
		<script>
			var box = document.querySelector('.box');
			var box_list = document.querySelector('.box-list');
	        var itemCount = <%= itemCount %>;
	        box.style.height = box_list.offsetHeight + (itemCount) * 80 + 'px';
		</script>
	</div>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    // 좋아요 수를 증가시키는 Ajax 요청
    function increaseLikeCount(consumeNo) {
      $.ajax({
        type: 'POST',
        url: '/consume/increaseLikeCount',
        data: { consumeNo: consumeNo },
        success: function() {
          // 성공적으로 처리되었을 때의 동작
          console.log('좋아요 수 증가 완료');
          // 업데이트된 좋아요 수를 가져와서 화면에 업데이트
          updateLikeCount(consumeNo);
        },
        error: function() {
          // 요청이 실패했을 때의 동작
          console.error('좋아요 수 증가 실패');
        }
      });
    }

    // 업데이트된 좋아요 수를 가져와서 화면에 업데이트하는 함수
    function updateLikeCount(consumeNo) {
      $.ajax({
        type: 'GET',
        url: '/consume/getConsume',
        data: { consumeNo: consumeNo },
        success: function(response) {
          const updatedLikeCount = response.c_like;
          const likeElement = $('div[data-consume-no="' + consumeNo + '"]');
          const containerElement = $('<div>').addClass('like-container');
          const imageElement = $('<img>').attr('src', '${pageContext.request.contextPath}/resources/images/likeimg.svg');
          const textElement = $('<span>').text(updatedLikeCount);
          
          containerElement.append(imageElement, textElement);
          likeElement.empty(); // 기존 내용 제거
          likeElement.append(containerElement);
		},
        error: function() {
          console.error('Failed to fetch updated data');
        }
      });
    }

    function goToComment(consumeNo) {
        location.href="/group/feed/comment?consumeNo=" + consumeNo;  // 댓글 등록 및 조회 페이지로 이동
    }

    function goToGroupMissionPage(bgmNo) {
        // 슬래쉬 없애야하나?
        // location.href=“/bgm/now{bgm_n}”;
        location.href="/bgm/now" + bgmNo;
    }
</script>

</body>
</html>