<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>


 nav {
    display: flex;
    justify-content: center;
    position: fixed;
    bottom: 0;
    left: 0;
    width: 100%;
    height: 65px; 
    background: #FFFFFF;
    border-radius: 25px 25px 0px 0px;
    z-index: 9999;
  }
  
.container2 {
    display: flex;
    list-style-type: none;
    padding: 0;
  }
  
.navbtn {
    margin: 15px;
    background-color: transparent;
    border: none;
  }

</style>
<meta charset="UTF-8">
<title>네비게이션 하단 바</title>
</head>
<body>
<nav>
  <div class="container2">
  	<a href="/home">
	    <button class="navbtn" type="button">
	  		<img src="${pageContext.request.contextPath}/resources/images/home.svg" alt="SVG">  
	    </button>
    </a>
    <a href="/group">
	    <button type="button" class="navbtn">
	  		<img src="${pageContext.request.contextPath}/resources/images/group.svg" alt="SVG">  
	    </button>
    </a>
    <a href="/consume/create">
    <button class="navbtn" type="button">
    	<img id="plusImage" src="${pageContext.request.contextPath}/resources/images/plus.svg" alt="SVG">  
    </button>
    </a>
    <a href="/budget/budget_list">
	    <button type="button" class="navbtn">
	    	<img src="${pageContext.request.contextPath}/resources/images/cherry2.svg" alt="SVG">  
	    </button>
    </a>
    <a href="/Buser/mypage">
	    <button class="navbtn" type="button">
	    	<img src="${pageContext.request.contextPath}/resources/images/colormypage.svg" alt="SVG">  
	    </button>
    </a>
  </div>
</nav>
</body>
</html>