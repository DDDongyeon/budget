<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<c:set var="s" value="${ start.getDayOfWeek().getValue() }" />
<c:set var="e"
	value="${ start.withDayOfMonth(start.lengthOfMonth()).getDayOfMonth() }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">

<title>MyCalendar</title>
<link href="${path}/resources/css/calendar_home.css" rel="stylesheet">
</head>
<body style="margin-bottom: 100px;">
	<%@ include file="../navbar-home.jsp"%>
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
				
				
		</div>
	
		<div class="box">
			<div class="month">
				<p class="year">${ start.getYear() }<span
						style="font-size: 14px">년</span>
				</p>
				<button style="margin-right: 60px"
					onclick="prev(${start.getYear()}, ${start.getMonthValue()}, 1)">
					<img alt="" src="${path}/resources/images/Polygon1.svg">
				</button>

				<span style="font-size: 24px;">${ start.getMonthValue() }</span>월
				<button style="margin-left: 60px"
					onclick="next(${start.getYear()}, ${start.getMonthValue()}, 1)">
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
				<c:if test="${s != 7}">
					<c:forEach var="i" begin="1" end="${s}" step="1">
						<button class="blankbtn">
							<div class="btn">
								<p></p>
							</div>
						</button>
					</c:forEach>
				</c:if>
				<c:forEach var="k" begin="1" end="${e}" step="1">
					<button class="daybtn"
						onclick="location.href = '/hMyCalendar?year=${start.getYear()}&&month=${start.getMonthValue()}&&day=${k}'">
						<div class="btn">
							<c:choose>
								<c:when test="${k == pick.getDayOfMonth()}">
									<span class="pick">${k}</span>
								</c:when>
								<c:when
									test="${start.getMonthValue() == now.getMonthValue() && k == now.getDayOfMonth()}">
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


	<div class="dayconsumes">
		<div class="present">
			${start.getMonthValue() }월  ${pick.getDayOfMonth() }일
		</div>
		<c:set var="totalMoney" value="0" />

		<c:forEach var="consume" items="${dayConsumes}">
			<c:set var="totalMoney" value="${totalMoney + consume.c_money}" />
		</c:forEach>

		<c:if test="${totalMoney ne 0}">
			<div class="total-box">
				<a href="/consume/list/${start.getYear()}-${String.format("%02d", start.getMonthValue())}-${String.format("%02d", pick.getDayOfMonth())}" onclick="openModal()" >
				<img src="${pageContext.request.contextPath}/resources/images/total_cherry.svg" alt="아이콘 이미지"  style= "height: 20px; margin-left: 10px;">
				<span class="total-name"> 총소비액: </span>
 				<span class="total-money">	${totalMoney} </span>
 					</a>
			</div>
			<br>
		</c:if>

		<c:forEach var="entry" items="${categoryMap}">
			<c:set var="categoryTotal" value="0" />
			<c:set var="categoryKey" value="${entry.key}" />
			<c:set var="categoryName" value="${entry.value}" />

			<c:forEach var="consume" items="${dayConsumes}">
				<c:if test="${categoryKey eq consume.c_categoryid}">
					<c:set var="categoryTotal"
						value="${categoryTotal + consume.c_money}" />
				</c:if>
			</c:forEach>

			<c:if test="${categoryTotal ne 0}">
				<div class="category-box">
		             <div class="c${entry.key }">${categoryName}</div> 
		             <span class="c-money"> ${categoryTotal}  </span> 
	            </div>
            <br>
			</c:if>
		</c:forEach>
	</div>



	<script src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script type="text/javascript"> 
	
		function prev(y, m, d){
			console.log(d)
			let month = m - 1; let year = y; let day = d;
			if (month == 0){
				month = 12
				year -= 1
			}
			
			link = "/hMyCalendar?year="+year+"&&month="+month+"&&day="+day;
			location.href = link;
		}
		
		function next(y, m, d){
			let month = m + 1; let year = y; let day = d;
			if (month == 13){
				month = 1 
				year += 1
			}
			
			link = "/hMyCalendar?year="+year+"&&month="+month+"&&day="+day;
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
		function openModal(event) {
		    
			var modal = document.getElementById("myModal");
		    modal.style.display = "block";
		  }
    </script>
</body>
</html>