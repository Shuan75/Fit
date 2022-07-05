<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>



<link href="../assets/css/styles.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="../css/style2.css" type="text/css">


<body>
	
	<div class="product_view">
		<h2>${dto.c_name}</h2>
		<table>
			<caption>
				<details class="hide">
					<summary>상품정보</summary>
					판매가, 상품코드, 옵션 및 결제금액 안내
				</details>
			</caption>
			<colgroup>
			<col style="width:173px;">
			<col>
			</colgroup>
	<tbody>
			<tr>
				<th>강의설명</th>
				<td>${dto.c_content}</td>
			</tr>
			<tr>
				<th>강사명</th>
				<td>${dto.u_name}</td>
			</tr>

			<tr>
				<th>레벨</th>
				<td>${dto.c_level}</td>
			</tr>
			<tr>
				<th>수강요일</th>
				<td>${dto.c_day}</td>
			</tr>
			<tr>
				<th>수강시간</th>
				<td>${dto.c_time}</td>
			</tr>
			<tr>
				<th>수강기간</th>
				<td>${dto.c_period}</td>
			</tr>

			<tr>
				<th>판매가</th>
				<td class="total"><b>${dto.c_price}</b>원</td>
			</tr>
			</tbody>
		</table>
		<div class="img">
			<img src="../assets/images/ft_bbbl2.png" alt="">
		</div>
		<div class="btns">
			<a href="#a" class="btn1">장바구니</a>
			<a href="#a" class="btn2">구매하기</a>
		</div>
		
		<div class='bottom'>
			<button type="button" class="btn btn-light"
					onclick="location.href='program.do?c_code=${dto.c_code}'">강의목록</button>
		</div>
		
	</div>

</body>


<%@ include file="../footer.jsp"%>
