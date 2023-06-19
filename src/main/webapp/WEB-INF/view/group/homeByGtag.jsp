<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=yes;">
        <link href="${path}/resources/css/groupHomeByTag.css" rel="stylesheet" type="text/css">
        <script src="${path}/resources/js/groupHomeByTag.js" type="text/javascript"></script>
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

    <!-- 그룹 홈 페이지 -->

        <div class="header">
            <div class="time">9:40</div>
            <div class="data"><img src="${path}/resources/images/data.svg" alt="SVG"></div>
            <div class="wifi"><img src="${path}/resources/images/wifi.svg" alt="SVG"></div>
            <div class="battery"><img src="${path}/resources/images/battery.svg" alt="SVG"></div>
            <h1 class="groupLetter">그룹</h1>
        </div>

    <div class="container">
        <div class="main">
            <div class="search-box">
                <div class="search"></div>
                <form><input type="search" id="searchInput"></form>
                <img class="searchIcon" onclick="goToSearchPage('searchInput')" src="${path}/resources/images/돋보기.svg" alt="SVG">
            </div>

            <div class="myGroup-box">
                <div class="myGroupLetter">나의 그룹</div>
                <div class="createBtn"></div>
                <div class="createLetter" onclick="goToGroupCreationPage()">만들기</div>

                <div class="userGroup-container">
                    <div class="userGroupList-box">
                        <c:forEach items="${groupsWithMemberCount}" var="userGroup">
                            <div class="list">
                                <div class="userGroupBtn-box" onclick="goToGroupFeed(${userGroup.g_no})">
                                    <img class="budgetBucketIcon" src="${path}/resources/images/budgetBucket.svg" alt="SVG">
                                    <div class="userGroupName">${userGroup.g_name}</div>
                                    <span class="userGroupTag">#${userGroup.g_tag}</span>
                                    <div class="userGroupPeopleNum">${userGroup.memberCount}/${userGroup.g_maxpeople}명</div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>

            <div class="groupRecommend-box">
                <div class="groupRecommendLetter">그룹 추천</div>
                <div class="requiredTag-box">
                    <div class="tag1" id="tag1" onclick="showGroupsByTag('청소년')">
                        <div class="tag1Letter">#청소년</div>
                    </div>
                    <div class="tag2" id="tag2" onclick="showGroupsByTag('대학생')">
                        <div class="tag2Letter">#대학생</div>
                    </div>
                    <div class="tag3" id="tag3" onclick="showGroupsByTag('취준생')">
                        <div class="tag3Letter">#취준생</div>
                    </div>
                    <div class="tag4" id="tag4" onclick="showGroupsByTag('직장인')">
                        <div class="tag4Letter">#직장인</div>
                    </div>
                </div>

                <div class="HgroupList-container">
                    <div class="HgroupList-box">
                        <c:forEach items="${groupsByGtag}" var="group">
                            <div class="Hlist">
                                <div class="HgroupBtn-box" onclick="openModal(${group.g_no})">
                                    <div class="HgroupName">${group.g_name}</div>
                                    <div class="HgroupTag">#${group.g_tag}</div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>

        <%@ include file="/WEB-INF/view/navbar-group.jsp" %>
    </div>

</body>
</html>
