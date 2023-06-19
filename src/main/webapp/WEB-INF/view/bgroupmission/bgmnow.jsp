<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0">
    <title>그룹 미션 현황</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Inter&display=swap');
    </style>
    <link href="${path}/resources/css/group_mission.css" rel="stylesheet">
</head>
<body>
<%@ include file="../navbar-group.jsp"%>
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
    <h1 class="my-budget">${g_name}</h1>
    </div>
    <br><br><br><br><br>
    <div class="container">
    <div class="banner">
    <a class="banner-img"><img src="${pageContext.request.contextPath}/resources/images/alarm.svg" alt="SVG"></a>
    <span class="name">${name}</span>
    </div>
    <div class="goal">목표 금액: ${goal}</div>
    <div class="remain">남은 일수: ${remain}</div>
    <div class="line1"></div>
    <br><br><br><br><br>
        <c:forEach var="member" items="${member}" varStatus="i">
    <div class="box">
    			<a class = "img"><img src="${pageContext.request.contextPath}/resources/images/cheeryicon.svg" alt="SVG"></a>
                <a class = "member">${member}</a>
                <a class = "membercs"> ${membercs[i.index]}원</a>
        </div>
        </c:forEach>
    </div>
    

</body>
</html>
