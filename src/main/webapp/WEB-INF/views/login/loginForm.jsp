<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../header.jsp"%>
<%if(s_id.equals("guest") || s_password.equals("guest") || s_rating.equals("guest")) {
	// id 저장 쿠키 확인
	// userPC 에 저장된 모든 쿠키값 가져오기
	Cookie[] cookies = request.getCookies();
	String c_id = "";
	if(cookies!=null) {
		// cookie 존재여부
		for(int i = 0; i<cookies.length; i++) { // 모든 쿠키값을 검색한다
			Cookie cookie = cookies[i]; // cookie 하나씩 가져오기
			if(cookie.getName().equals("c_id")==true) {
				c_id = cookie.getValue(); // cookie 변수값가져오기
				
			}
			
		}
		
	}
%>
   
   <form name="loginfrm" id="loginfrm" method="post" action="login.do"  onsubmit="return loginCheck()"><!-- myscript.js에서 함수 작성 -->
		<table class="table">
		<tr>
		    <td>
			   <input type="text" name="id" id="id" value="<%=c_id %>" placeholder="아이디" maxlength="10" required>
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
		      <label><input type="checkbox" name="c_id" value="SAVE" <%if(!c_id.isEmpty()){out.print("checked");} %>>아이디 저장</label>			  
			  &nbsp;&nbsp;&nbsp;
			  <a href="#" onclick="location.href='member.do'">회원가입</a>
			  &nbsp;&nbsp;&nbsp;
			  <a href="#" onclick="location.href='searchID.do'">아이디/비밀번호찾기</a>
		   </td>
		</tr>		  
		</table>
	</form>
   
   
   <%} else {
	
	}
	%>
   
   
<%@ include file="../footer.jsp"%>
