<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- logout.jsp 공통코드 -->
<%
session.removeAttribute("s_id");
session.removeAttribute("s_password");
session.removeAttribute("s_rating");

response.sendRedirect("../main.jsp");


%>