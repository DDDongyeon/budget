<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<style>
 @import
	url('https://fonts.googleapis.com/css2?family=Inter&display=swap'); 
</style>
<style>
.modal {
    position: fixed;
    z-index: 9999;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
    position: relative;
    width: 80%;
    height: 65%; /* Increase the height to 90% */
    overflow-y: auto;
    background-color: #FFFFFF;
    box-shadow: 0px 16px 40px rgba(112, 144, 176, 0.2);
    border-radius: 20px;
    padding: 15px;
    /*  z-index: 99999; /* 모달의 층위 설정 */ */
}

.modal-close {
    position: absolute;
    top: 15px;
    right: 15px;
    cursor: pointer;
}

.modal-close:hover {
    color: red;
}

</style>
<link href="${path}/resources/css/consume_date.css" rel="stylesheet">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%@ include file="../navbar-home.jsp"%>
	<div class=container>
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
			<h1 class="title">소비 내역</h1>
	</div> 
	--%>
	<div id="myModal" class="modal">
  		<div class="modal-content">
    	<span class="close" onclick="closeModal()">&times;</span>
			<div class="list">
				<!-- 홈화면에서 총소비 누르면 보여줄 리스트 -->
					<!-- <h1>날짜별 소비 내역 리스트</h1> -->
					<%-- <h2>${c_date}</h2>
				 --%>
					<h2 class="date">${year}년 ${month}월 ${day}일</h2>  
					<table class="table">
						<!-- <thead>
							<tr>
								<th>번호</th>
								<th>소비 금액</th>
								<th>카테고리</th>
				
								
							</tr>
						</thead>
				 -->
						<tbody>
					
							<c:forEach var="consume" items="${csmList}" varStatus="loop">
								
									<tr class="csm">
									<%-- 	<td>${loop.count}</td>
										 --%>
										<td class="pay"><a href="/consume/detail/${consume.c_no}">-${consume.c_money}</a>
										</td>
										<c:forEach var="entry" items="${categoryMap}">
											<c:set var="key" value="${entry.key}" />
											<c:set var="value" value="${entry.value}" />
					
											<c:if test="${key eq consume.c_categoryid}">
												<td class="c${entry.key}">${value}</td>
											</c:if>
										</c:forEach>
										<%-- <td>${consune.c_categoryid}</td> --%>
										<%-- 
										<td>${consume.c_image}</td>
										<td>${consume.user_no}</td>
										--%>
										<td class="content">${consume.c_content}</td>
									</tr>
									
								
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	
	
	<script>
 
	
	  function closeModal() {
	    var modal = document.getElementById("myModal");
	    modal.style.display = "none";
	    history.back(); 
	  }
	</script>
</body>
</html>