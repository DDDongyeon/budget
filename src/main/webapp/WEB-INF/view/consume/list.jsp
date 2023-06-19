<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">

<title>Insert title here</title>
</head>
<body>
	<h1>내 소비 내역 리스트</h1>
	<h2>날짜 출력</h2>
	<table>
		<thead>
			<tr>
				<th>소비번호</th>
				<th>유저번호</th>
				<th>소비 금액</th>
				<th>카테고리</th>
				<th>이미지</th>
				<th>내 코멘트</th>
				
			</tr>
		</thead>
		
		<tbody>
			<c:forEach var="consume" items="${csmList}">
					
				<tr>
                   
					<td>${consume.c_no}</td>
					<td>${consume.user_no}</td>
					<td>${consume.c_money}</td>
					<td>${consume.c_categoryid}</td>
					<td>${consume.c_image}</td>
					<td>${consume.c_content}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>