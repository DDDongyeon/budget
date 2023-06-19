<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<html>
<head>
    <meta charset="utf-8">
	<link href="${path}/resources/css/groupComment.css" rel="stylesheet">
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

       <div class="main">
                <div class="consume-frame">
                    <img class="budgetProfileIcon" src="${path}/resources/images/budgetProfile.svg" alt="SVG">
                    <div class="consumeContent-frame">
                        <div class="consumerNickname">${consume.user_nickname}</div>
                        <div class="consumeContent">${consume.c_content}</div>
                        <div class="consumeDate">${consume.c_date}</div>
                        <div class="consumePrice">-${consume.c_money}원</div>
                        <span class="consumeCategory${consume.c_categoryid}">${categoryMap.get(consume.c_categoryid)}</span>
                    </div>
                    <c:if test="${not empty consume.c_image}"><img class="image" src="${path}/resources/jpg/${consume.c_image}"></c:if>
                </div>

                  <div class="line"></div>

                <div class="commentWrite-frame">
                    <div class="commentWriteLetter">코멘트 남기기</div>
                    <div class="commentWriteRec">
                        <form><input type="text" id="commentInput"></form>
                    </div>
                    <div class="registerBtn" onclick="writeComment(${consume.c_no}, document.getElementById('commentInput').value)">
                        <div class="registerLetter">등록</div>
                    </div>
                </div>

                <div class="commentList-frame">
                    <c:forEach items="${comments}" var="comment">
                        <div class="cmtList">
                            <div class="comment">
                                <div class="commentWriter">${comment.user_nickname}</div>
                                <div class="commentContent">${comment.cmn_content}</div>
                                <div class="commentDate">${comment.cmn_date}</div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
       </div>



<script>
        //뒤로가기
        function goBack() {
            window.history.back();
        }

        //코멘트 등록 버튼
        function writeComment(cNo, cmtInput) {
            var consumeNo = cNo;
            var form = document.createElement("form");
            form.method = "POST";
            form.action = "/group/feed/comment?consumeNo=" + consumeNo;

            var input = document.createElement("input");
            input.type = "hidden";
            input.name = "inputComment";
            input.value = cmtInput;
            form.appendChild(input);

            document.body.appendChild(form);
            form.submit();
        }

</script>

</body>
</html>