<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../header.jsp"%>
<%@ include file="../footer.jsp"%>

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900" rel="stylesheet">

<title>trainerList</title>


<link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<link href="../assets/css/fontawesome.css" rel="stylesheet">
<link href="../assets/css/templatemo-grad-school.css" rel="stylesheet">
<link href="../assets/css/owl.css" rel="stylesheet">
<link href="../assets/css/lightbox.css" rel="stylesheet">
</head>

<body>

	<table class="table table-hover">
		<thead>
			<tr class="success">
				<th>제목</th>
				<th>사진</th>
				<th>조회수</th>
				<th>작성자</th>
				<th>작성일</th>
				<c:forEach var="dto" items="${list}">
					<tr>
						<td>${dto.id}</td>
						<%-- <td><a href="../media/list.do?mediagroupno=${dto.mediagroupno}">${dto.title}</a></td> --%>
						<td>
						<input type="button" value="수정" onclick="">
						<input type="button" value="삭제" onclick="">
						</td>
					</tr>
				</c:forEach>

			</tr>
		</thead>
	</table>
</body>
</html>