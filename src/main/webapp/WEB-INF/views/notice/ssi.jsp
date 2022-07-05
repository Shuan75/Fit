<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- ssi.jsp 공통 코드 --%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.util.*"%>
<%@ page import="net.utility.*"%>
<jsp:useBean id="dao" class="kr.fit.notice.NoticeDAO" scope="page"></jsp:useBean>
<jsp:useBean id="dto" class="kr.fit.notice.NoticeDTO" scope="page"></jsp:useBean>


<%
request.setCharacterEncoding("UTF-8");
%>
