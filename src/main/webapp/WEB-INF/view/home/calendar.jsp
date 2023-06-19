<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="s" value="${ start.getDayOfWeek().getValue() }" />
<c:set var="e" value="${ start.withDayOfMonth(start.lengthOfMonth()).getDayOfMonth() }" />
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">

<title>calendar</title>
<link href="${path}/resources/css/calendar.css" rel="stylesheet">
</head>
<body>
	<%@ include file="../navbar-home.jsp"%>

	<div class="container">
		<div class="box">
			<div class="month">
			
				<p class="year">${ start.getYear() }<span style="font-size: 14px">년</span></p>
				<button style="margin-right: 60px" onclick="prev(${start.getYear()}, ${start.getMonthValue()})">
					<img alt="" src="${path}/resources/images/Polygon1.svg">
				</button>

				<span style="font-size: 24px;">${ start.getMonthValue() }</span>월
				<button style="margin-left: 60px">
					<img alt="" src="${path}/resources/images/Polygon2.svg">
				</button>
				<div class="total">${arr[0]}</div>
			</div>
			
			
			<div class="week">
				<div class="w" style="color: #FF3535;">일</div>
				<div class="w">월</div>
				<div class="w">화</div>
				<div class="w">수</div>
				<div class="w">목</div>
				<div class="w">금</div>
				<div class="w" style="color: #3269F5;">토</div>	
			</div>
			<div class="day">
				<c:forEach var="i" begin="1" end="${s}" step="1">
					<button class="blankbtn">
						<div class="btn"><p>　</p></div>
					</button>
				</c:forEach>
				
				<c:forEach var="k" begin="1" end="${e}" step="1">
					<button class="daybtn" onclick="location.href = '/hMyCalendar?year=${start.getYear()}&&month=${start.getMonthValue()}&&day=${k}'"> 
						<div class="btn">
							<c:choose>
								<c:when test="${k == pick.getDayOfMonth()}">
									<span class="pick">${k}</span>
								</c:when>							
								<c:when test="${k == now.getDayOfMonth()}">
									<span style="color: #F87670">${k}</span>
								</c:when>	
								<c:when test="${(k+s)%7 == 0 or (k+s)%7 == 1}">
									<span style="color: #8CA1B6">${k}</span>
								</c:when>
								<c:otherwise>
									<span>${k}</span>
								</c:otherwise>						
							</c:choose>
							<c:if test="${arr[k] != 0}">
								<div class="daytotal">${arr[k]}</div>
							</c:if>
						</div>
						
					</button>
				</c:forEach>
								
			</div>
		</div>
	</div>

	<c:forEach items="${dayConsumes}" var="consume" >
		${consume}
	</c:forEach>
	 
	<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript"> 
	
		function prev(y, m){
			let month = m - 1; let year = y
			if (month == 0){
				month = 12
				year -= 1
			}
			
			link = "/hMyCalendar?year="+year+"&&month="+month
			location.href = link;
		}
	
/* 		function prev(y, m){
			let month = m - 1; let year = y
			if (month == 0){
				month = 12
				year -= 1
			}
	
			$.ajax({
				url: "/calendar/"+year+"/"+month,
				type: "GET",
				data: {
					year: year,
					month: month
				},
				success: function(response){
					console.log("success")
				}	
			})
		} */
		
    </script> 
</body>
</html>