<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="header.jsp"%>
<%-- <%@ include file="login/ssi.jsp"%> --%>

   
   <form name="loginfrm" id="loginfrm" method="post" action="login.do"  onsubmit="return loginCheck()"><!-- myscript.js에서 함수 작성 -->
		<table class="table">
		<tr>
		    <td>
			   <input type="text" name="id" id="id" placeholder="아이디" maxlength="10" required>
		    </td>
		    <td rowspan="2">
		       <!-- type=image의 기본속성이 submit -->
			   <input type="image" src="../assets/images/bt_login.gif">		   
		    </td>
		</tr>
		<tr>
		   <td>
		      <input type="password" name="password" id="password" placeholder="비밀번호" maxlength="10" required>
		   </td>
		</tr>
		<tr>
		   <td colspan="2">
		      <label><input type="checkbox" name="c_id" value="SAVE">아이디 저장</label>			  
			  &nbsp;&nbsp;&nbsp;
			  <a href="#" onclick="location.href='member.do'">회원가입</a>
			  &nbsp;&nbsp;&nbsp;
			  <a href="findID.jsp">아이디/비밀번호찾기</a>
		   </td>
		</tr>		  
		</table>
	</form>
   
   
   
   
   
<%@ include file="footer.jsp"%>
