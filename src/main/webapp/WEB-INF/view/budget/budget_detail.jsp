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
@import url('https://fonts.googleapis.com/css2?family=Abhaya+Libre:wght@800&display=swap');
</style>
<link href="${path}/resources/css/budget_detail.css" rel="stylesheet">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<jsp:include page="${path}/WEB-INF/view/navbar-budget.jsp" />
</head>
<body>
	<script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
    	var dataArray=[
    		['Category', 'Money']
    		<c:forEach items="${consumeList}" var="c">
    			,['${c.c_category}', ${c.c_money}]
    		</c:forEach>
    	];
    	var categoryColors=[];
    	<c:forEach items="${consumeList}" var="c" varStatus="status">
        	categoryColors.push(getCategoryColor(${c.c_categoryid}-1));
        </c:forEach>
        
    	var data = google.visualization.arrayToDataTable(dataArray);
        var options = {
          colors: categoryColors,
          backgroundColor: 'transparent',
          chartArea: {width: '90%', height: '100%', left:'10%'},
          legend: {position: 'right'}
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart'));

        chart.draw(data, options);
      }
      function getCategoryColor(index) {
    	 var colors = ['#3B82A1', '#43B8B1', '#4D97ED', '#FF9900', '#FFA8A4']; 
    	 return colors[index % colors.length];
    }
    </script>
    
    
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
		<h1 class="my-budget">마이 버찌</h1>
	</div>
	<div class="budget-rectangle">	
		<div class="budget-comment">
			<div class="cherry">
				<img src="/resources/images/cherry.png">
			</div>
			<div class="budget-name">${bd_name}</div><br>
			<div class="budget-detail">목표금액 ${bd_goal} 남은금액 ${bd_goalleft} #DAY-${bd_dateleft}</div>
		</div>
	</div>	
	
	<div class="my-consume">나의 지출</div>
	<div class="budget-date">${bd_start}~${bd_end}</div>
	
	<div class="container">
		<div class="consume-list">
			<% int itemCount=0; %>
			<c:forEach items="${consumeList}" var="c">
			<div class="list">
				<div class="consume-rectangle">
					<div class="consume-name-rectangle${c.c_categoryid}">
				      <div class="consume-name">${c.c_category}</div>
					</div>
					<div class="money">
						<img src="${pageContext.request.contextPath}/resources/images/money.svg" alt="SVG">
					</div>
			        <div class="consume-money">${c.c_money}</div>
				</div>
			</div>
				<% itemCount++; %>
		    </c:forEach>
	   </div>
   </div>
   <div class="my-pattern">
	   	내 소비패턴
	   <div id="piechart" style="width: 300px; height: 230px; left:10px; margin:10px;"></div>
	   <div class="result-wrapper">
		   <div class="result"></div>
		   <div class="tree">
			   	<img src="${pageContext.request.contextPath}/resources/images/pin.svg" alt="SVG">
		   </div>
		   <div class="result-name">총 소비 금액 : ${bd_goalnow}원</div>
		   <div class="result-name2">지금까지 <span>"${categorymax}"</span>에 가장 많이 쓰셨네요 !</div>
	   </div>
   </div>	  
  
   <script>
		var container = document.querySelector('.container');
	    var consumeList = document.querySelector('.consume-list');
		var itemCount = <%= itemCount %>;
	    container.style.height = consumeList.offsetHeight + (itemCount - 1) * 80 + 'px';
	    
	    var myPattern = document.querySelector('.my-pattern');
	    myPattern.style.position = 'absolute';
		myPattern.style.top = container.offsetHeight + 235+ 'px';
   </script>
 
  
</body>
</html>
