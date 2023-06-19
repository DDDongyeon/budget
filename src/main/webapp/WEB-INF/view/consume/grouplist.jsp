<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.time.format.DateTimeFormatter" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<link href="${path}/resources/css/consume_details.css" rel="stylesheet">
<style>
.consume-item {
    display: flex;
}

.modal-container {
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
<title>그룹 상세 소비 내역</title>
</head>
<body>
<div class="modal-container">
    <div class="modal-content">
        <a class="modal-close" onclick="closeModal()"><img
					src="${pageContext.request.contextPath}/resources/images/XXX.svg"
					alt="SVG"></a>
        <a class="day"> ${parsedDate}</a>
        <h3 style="padding-top: 15px;"><img
					src="${pageContext.request.contextPath}/resources/images/likehamburger.svg"
					alt="SVG" style="width: 22px; height: 22px; margin-right: 10px;">소비왕 순</h3>
        
        <c:forEach var="nickname" items="${consumeList}" varStatus="status">
            <div class="nick">${nickname}</div>
            <c:forEach var="item" items="${consumeMap[nickname]}">
            <div class="consume-item">
                <a class="money">-${item.c_money}</a>
                <a class="category-rectangle${item.c_categoryId}">
				      ${item.c_category}
					</a>
                <a class="content" >${item.c_content}</a>
				<%-- <a class="cno" href="${pageContext.request.contextPath}/group/feed/comment?consumeNo=${item.c_no}">
				<img
					src="${pageContext.request.contextPath}/resources/images/comment.svg"
					alt="SVG">
					</a> --%>
            </div>
            </c:forEach>
        </c:forEach>
    </div>
</div>

<script>
function closeModal() {
    document.querySelector('.modal-container').style.display = 'none';
    history.back(); 
}


</script>
</body>
</html>
