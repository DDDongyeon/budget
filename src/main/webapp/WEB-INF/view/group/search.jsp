<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=yes;">
        <link href="${path}/resources/css/groupSearch.css" rel="stylesheet" type="text/css">
        <script src="${path}/resources/js/groupSearch.js" type="text/javascript"></script>
    </head>

    <body>
        <!-- 모달 창 -->
        <div id="groupModal" class="modal">
            <div class="modal-content">
                <span class="close" onclick="closeModal()">&times;</span>
                <div id="groupInfo">
                    <!-- 그룹 정보 표시 -->
                </div>
            </div>
        </div>

        <div class="header">
            <div class="time">9:40</div>
            <div class="data"><img src="${path}/resources/images/data.svg" alt="SVG"></div>
            <div class="wifi"><img src="${path}/resources/images/wifi.svg" alt="SVG"></div>
            <div class="battery"><img src="${path}/resources/images/battery.svg" alt="SVG"></div>
            <div class="backIcon" onclick="goBack()"><img src="${path}/resources/images/back-page.svg" alt="SVG"></div>
            <h1 class="searchLetter">그룹 검색</h1>
        </div>

            <div class="search-box">
                <div class="search"></div>
                <form><input type="search" id="searchInput"></form>
                <img class="searchIcon" onclick="goToSearchPage('searchInput')" src="${path}/resources/images/돋보기.svg" alt="SVG">
            </div>

    <div class="container">
         <div class="groupList-box">
               <% int itemCount=0; %>
                <c:forEach items="${groupsBySearch}" var="group" >
                <div class="list">
                    <div class="groupBtn" onclick="openModal(${group.g_no})">
                        <div class="groupName">${group.g_name}</div>
                        <div class="groupRecTag">#${group.g_requiredTag}</div>
                        <div class="groupExTag"># ${group.g_tag}</div>
                    </div>
               </div>
                   <% itemCount++; %>
                </c:forEach>
                <script>
               var container = document.querySelector('.container');
                 var groupList = document.querySelector('.groupList-box');
                 var itemCount = <%= itemCount %>;
                 container.style.height = groupList.offsetHeight + (itemCount) * 90 + 'px';
            </script>
        </div>
    </div>

    <%@ include file="/WEB-INF/view/navbar-group.jsp" %>
    </body>
</html>