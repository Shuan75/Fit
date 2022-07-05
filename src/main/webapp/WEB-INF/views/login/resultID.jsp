<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<h3>아이디 / 비밀번호 찾기 결과</h3>

<tr>
	<th>이름</th>
	 <td style="text-align: left"><input type="text" name="u_name" id="u_name" size="15" maxlength="20" value="${dto.u_name }" readonly></td>
	<td>${dto.u_name}</td>
</tr>
<tr>
	<th>이메일</th>
	<td>${dto.email}</td>
</tr>




<%@ include file="../footer.jsp"%>