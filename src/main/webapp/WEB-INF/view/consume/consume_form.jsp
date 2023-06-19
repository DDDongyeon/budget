<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<style>
 @import
	url('https://fonts.googleapis.com/css2?family=Inter&display=swap'); 
</style>
<link href="${path}/resources/css/consume_form.css" rel="stylesheet">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
</head>
<body>
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
			<button class="back-page" type="button" onclick="history.back()">
				<img
					src="${pageContext.request.contextPath}/resources/images/back-page.svg"
					alt="SVG">
			</button>
			<h1 class="title">소비 등록</h1>
		</div>
		<%-- <%@ include file="../navbar.jsp"%> --%>

		<!-- <h5>소비 등록</h5> -->
		<form action="${pageContext.request.contextPath}/consume/create"
			method="post" enctype="multipart/form-data">
			<div class="register-form">
				<div class="date">
					 <div class="date-title"><!-- <label for="date2"> --> 소비일 <!-- </label>  --></div><br>
					  <input class="date-box" type="date" name="date"  id="date" >
				</div>
				<div class="amount">
					<div class="amount-title">소비 금액</div><br>
					<input class="amount-box" type="text" name="amount" id="amount">
				</div>
				<div class="category">
					 <div class="category-title">카테고리 설정</div><br> 
					 <select class="category-box" name="category" id="category">
					<option value="1">식비</option>
					<option value="2">카페/간식</option>
					<option value="3">술/유흥</option>
					<option value="4">생활</option>
					<option value="5">패션쇼핑</option>
					<option value="6">뷰티/미용</option>
					<option value="7">교통비</option>
					<option value="8">주거비</option>
					<option value="9">의료/건강</option>
					<option value="10">문화</option>
					<option value="11">금융</option>
					<option value="12">여행/숙박</option>
					<option value="13">교육/학습</option>
					<option value="14">가족</option>
					<option value="15">반려동물</option>
					<option value="16">경조사/선물</option>
					<option value="17">멍청비용</option>
					<option value="18">기타</option>

					</select>
				</div>
				<div class="memo">
				 	<div class="memo-title">소비 메모</div>
					<textarea class="memo-box" name="memo" id="memo" rows="5"></textarea>
				</div>
				
				<div class="photo">
					<label for="photo" class="photo-icon">
  						<img class="img-btn" src="/resources/images/imgbtn.svg"" alt="아이콘 이미지">
					</label>
				  <input  type="file" name="photo" id="photo" style="display: none;">
				    <div class="photo-box">
				    <span id="file-name"></span>
					</div>				   
				</div> 
			</div>
			<button class="submit-rectangle" type="submit" name="budgetcommit">
				<div class="submit-rectangle-text">저장</div>
			</button>
					<!-- <input type="submit" value="등록"> -->
		</form>
	</div>
	
<script>
  const photoInput = document.getElementById('photo');
  const fileName = document.getElementById('file-name');

  photoInput.addEventListener('change', function() {
    if (photoInput.files.length > 0) {
      fileName.textContent = photoInput.files[0].name;
    } else {
      fileName.textContent = '';
    }
  });
</script>

</body>
</html>