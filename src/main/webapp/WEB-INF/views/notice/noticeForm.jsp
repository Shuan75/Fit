<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ include file="../header.jsp"%>


<link href="../css/noticestyle.css" rel="stylesheet" type="text/css">

<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <h2 class="text-center">게시글 작성</h2><p>&nbsp;</p>
        <form action="create.do" method="post">
            <div class="table table-responsive">
            <table class="table table-striped">
            <tr>
                <td class="danger">작성자</td>
                <td><input type="text" class="form-control" id="bbs_id" placeholder="작성자(2자-10자)" name="bbs_id"></td>
          
            </tr>
            <tr>
                <td class="danger">제목</td>
                <td colspan="3">
                	<input type="text" class="form-control" id="bbs_title" placeholder="제목 입력(4-100)" name="bbs_title" maxlength="100" required="required" pattern=".{4,100}">
                </td>
            </tr>
             
            <tr>
                <td class="danger">게시판 구분</td>
                <td colspan="3">
					<!-- <input type="text" value="Notice" selected="selected" class="form-control" id="bbs_diff" placeholder="게시판구분을 선택해주세요" name="bbs_diff" maxlength="100" required="required"> -->
					    
					    <select name="bbs_diff">
					        <option value="Notice" selected="selected" >공지사항</option>
					        <option value="Free">자유게시판</option>
					        <option value="Que">질문게시판</option>
					        <option value="Rev">후기게시판</option>
					    </select>
        
                </td>
            </tr>
             
            <tr>
                <td class="danger">글내용</td>
                <td colspan="3">
                	<textarea class="form-control" rows="5" id="bbs_contents" name="bbs_contents" placeholder="내용 작성"></textarea>
                </td>
            </tr>
             
            <tr>  
                <td colspan="4"  class="text-center">
	                <input type="submit"  value="등록">
					<input type="submit"  value="목록" onclick="location.href='noticeList.do'">	                
                 </td>
            </tr>
          </table>
         
     
            </div>
        </form>   
    </div>
</div>



<!-- <div class="container">
	<h2>게시판 글쓰기</h2>
	<form name="noticefrm" id="noticefrm" method="post" action="create.do">
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" class="form-control" id="bbs_title"
				   placeholder="제목 입력(4-100)" name="bbs_title" maxlength="100" required="required" pattern=".{4,100}">
			</div>
	            
                
			<div class="form-group">
				<label for="diff">구분</label>
				<input type="text" class="form-control" id="bbs_diff" placeholder="게시판구분을 선택해주세요" name="bbs_diff" maxlength="100" required="required">
			</div>
			
			<div class="form-group">
				<label for="content">내용</label>
				<textarea class="form-control" rows="5" id="bbs_contents" name="bbs_contents" placeholder="내용 작성"></textarea>
			</div>
			<div class="form-group">
				<label for="writer">작성자</label>
				<input type="text" class="form-control" id="bbs_id" placeholder="작성자(2자-10자)" name="bbs_id">
			</div>
			
			<div class='bottom'>
				<input type="submit"  value="등록">
				<input type="submit"  value="목록" onclick="location.href='noticeList.do'">
			</div>
			

	</form>
</div>



 -->
<%@ include file="../footer.jsp"%>