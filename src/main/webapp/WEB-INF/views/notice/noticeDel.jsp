<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>



  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">


<div class="row">
 <div class="col-xs-2 col-md-2"></div>
 	<div class="col-xs-8 col-md-8">
 		<h2 class="text-center">게시글 삭제</h2><p>&nbsp;</p>
 		<form name="noticefrm" id="noticefrm" method="post" action="noticeDel.do" >
		<input type="hidden" id="bbs_num" name="bbs_num" value="${dto.bbs_num}">
 		
 		  <div class="table table-responsive">
	 		<table class="table">
	 			<tr>
	 				<td class="table-active">작성자</td>
	 				<td>${dto.bbs_id}></td>
	 				<td class="table-active">작성일</td>
	 				<td>${dto.bbs_cdate}</td>
	 			</tr>
	 			<tr>
	 			  <td class="table-active">제목</td>
	 			  <td colspan="3">${dto.bbs_title}</td>
	 			</tr>

	 			<tr>
	 			 <td class="table-active">패스워드</td>
	 			 <td><input type="password" name="pass"  class="form-control"></td>
	 			</tr>

	 			<tr>
	 			  <td colspan="4" class="text-center">
	 			  	 <input type="hidden" name="password"  value="${bbs_password}">
	 			  	 <input type="hidden"  value="${bbs_num}"  name="num" >
	 			  	 <input type="submit" value="글삭제" class="btn btn-danger">&nbsp;&nbsp;
	 			  	 <input type="button" value="목록보기" class="btn btn-primary" onclick="location.href='noticeList.do'">
	 			  </td>
	 			</tr>

	 		 </table>
	 	   </div>
 		</form>
	 </div>
</div>




<%@ include file="../footer.jsp"%>