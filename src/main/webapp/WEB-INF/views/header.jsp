<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="auth.jsp" %> 

 <!DOCTYPE html>
<html lang="ko">

  <head> 
	
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900" rel="stylesheet">
  	<script src="../assets/js/myscript.js"></script>
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>    
    
    <title>Fitness</title>
    
    <!-- Bootstrap core CSS -->
    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Additional CSS Files -->
     <link href="../assets/css/fontawesome.css" rel="stylesheet">
     <link href="../assets/css/templatemo-grad-school.css" rel="stylesheet">
     <link href="../assets/css/owl.css" rel="stylesheet">
     <link href="../assets/css/lightbox.css" rel="stylesheet">

  </head>

<body>

    <!--header-->
  <header class="main-header clearfix" role="header">
    <div class="logo">
      <a href="#" onclick="location.href='home.do'"><em>BETTER</em> </a>
    </div>
    <a href="#menu" class="menu-link"><i class="fa fa-bars"></i></a>
    <nav id="menu" class="main-nav" role="navigation">
      <ul class="main-menu">
        <li><a href="#section1">Home</a></li>
        <li class="has-submenu"><a href="#section2">About Us</a>
          <ul class="sub-menu">
            <li><a href="#section2">Who we are?</a></li>
            <li><a href="#section3">How it works?</a></li>
          </ul>
        </li>
        
        <li class="has-submenu"><a href="#" onclick="location.href='program.do'">PROGRAM</a>
        <ul class="sub-menu"></ul>
          </li>
        <li><a href="#" onclick="location.href='list.do'">PLECTURERS</a></li>
        
        <!-- <li><a href="#section5">Video</a></li> -->
        <li class="has-submenu">>
        <a href="#" onclick="location.href='noticeList.do'">COMMUNITY</a>
         <ul class="sub-menu">
            <li><a href="#section2">공지사항</a></li>
            <li><a href="#section3">자유게시판</a></li>
            <li><a href="#section3">질문게시판</a></li>
            <li><a href="#section3">후기게시판</a></li>
          </ul>
        </li>
        
<%if(s_id.equals("guest") || s_password.equals("guest") || s_rating.equals("guest")) {
	

	Cookie[] cookies = request.getCookies();
	String c_id = "";
	if(cookies!=null) {
		
		for(int i = 0; i<cookies.length; i++) {
			Cookie cookie = cookies[i]; 
			if(cookie.getName().equals("c_id")==true) {
				c_id = cookie.getValue(); // cookie 변수값가져오기
				
			}
			
		}
		
	} 
%>
        <li><a href="#" onclick="location.href='login.do'">LOGIN</a></li>
       
        
        <% } else {%>
        	<li><a href="#">${s_id }님 환영합니다.</a></li>
    		<li><a href="#" onclick="location.href='logout.do'" >로그아웃</a></li>
    		<li><a href="#" onclick="location.href='modify.do?id=${s_id}'">마이페이지</a></li>
    		<%
        	/* out.println("<a href='myPage/myPage.jsp?id=<%=id%'>[마이페이지]</a>");
         */
        	
        } %>
      
      </ul>
    </nav>
  </header>
  <div style="padding: 83px;">
   