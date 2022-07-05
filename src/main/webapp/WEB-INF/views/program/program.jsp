<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="../header.jsp"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>program.jsp</title>


<link href="../assets/css/styles.css" rel="stylesheet" type="text/css">

<!-- <link rel="stylesheet" type="text/css" href="styles.css"> -->

<link href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900" rel="stylesheet">



<!-- <link rel="stylesheet" href="../css/style2.css" type="text/css"> -->

</head>
<body>
	<div class="title">강의 목록</div>
	<input type="hidden" name="c_code" value="${requestScope.c_code}">
	
	 <table class="table">

    <tbody>
		<c:forEach var="dto" items="${list}">
			<tr>
				<td><a href="read.do?c_code=${dto.c_code}">${dto.c_name}</a></td>
		   <%-- <td><a href="#" onclick="location.href='read.do?c_code=${c_code}'">${dto.c_name}</a></td> --%>
			</tr>
		
		</c:forEach>

    </tbody>
  </table>
	

	<div class="title">강의 목록</div>
	<input type="hidden" name="c_code" value="${requestScope.c_code}">
	<table>
		<tr>
			<th>강의명</th>
		</tr>

		<!-- MediagroupCont의 list()함수에서 mav.addObject("list")를 가리킴 -->
		<c:forEach var="dto" items="${list}">
			<tr>
				<td><a href="read.do?c_code=${dto.c_code}">${dto.c_name}</a></td>
		   <%-- <td><a href="#" onclick="location.href='read.do?c_code=${c_code}'">${dto.c_name}</a></td> --%>
			</tr>

		</c:forEach>
	</table>
</body>




<%@ include file="../footer.jsp"%>