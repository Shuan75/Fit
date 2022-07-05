<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- auth. jsp 공통 코드 -->
<!-- 로그인 상태 정보 확인 -->
<%
String s_id = "";
String s_password = "";
String s_rating = "";
if (session.getAttribute("s_id") == null || session.getAttribute("s_password") == null
		|| session.getAttribute("s_rating") == null) {
	// 비로그인
	s_id = "guest";
	s_password = "guest";
	s_rating = "guest";
} else {
	// 로그인 성공시
	s_id = (String) session.getAttribute("s_id");
	s_password = (String) session.getAttribute("s_password");
	s_rating = (String) session.getAttribute("s_rating");

}
%>