<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>


<link href="../css/noticestyle.css" rel="stylesheet" type="text/css">


<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8">
        <h2 class="text-center">게시글 수정</h2><p>&nbsp;</p>
        <form name="noticefrm" id="noticefrm" method="post" action="noticeUpdate.do">
        <input type="hidden" name="bbs_num" value="${dto.bbs_num}">
        
            <div class="table table-responsive">
            <table class="table table-striped">
            <tr>
                <td class="danger">작성자</td>
                <td><input type="text" class="form-control" id="bbs_id" placeholder="작성자(2자-10자)" name="bbs_id" value="${dto.bbs_id}" readonly></td>
                
                <td class="danger">작성일</td>
                <td>${dto.bbs_cdate}</td>
            </tr>
            <tr>
                <td class="danger">제목</td>
                <td colspan="3">
                	<input type="text" class="form-control" id="bbs_title" placeholder="제목 입력(4-100)" name="bbs_title" maxlength="100" required="required" pattern=".{4,100}" value="${dto.bbs_title}">
                </td>
            </tr>
            
            <tr>
                <td class="danger">카테고리</td>
                <td colspan="3">
                	<input type="text" class="form-control" id="bbs_diff" placeholder="게시판구분을 선택해주세요" name="bbs_diff" maxlength="100" required="required" value="${dto.bbs_diff}">
                </td>
            </tr>
            
             
      <!--       <tr>
                <td class="danger">패스워드</td>
                <td colspan="3"><input type="password"  class="form-control" name="password"></td>
            </tr>
       -->       
            <tr>
                <td class="danger">글내용</td>
                <td colspan="3">
                	<textarea class="form-control" rows="5" id="bbs_contents" name="bbs_contents" placeholder="내용 작성">${dto.bbs_contents}</textarea>
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










<div class="container">
	<h2>게시판 수정</h2>
	<form name="noticefrm" id="noticefrm" method="post" action="noticeUpdate.do">
	<input type="hidden" name="bbs_num" value="${dto.bbs_num}">
		<div class="form-group">
			<label for="writer">작성자</label>
			<input type="text" class="form-control" id="bbs_id" placeholder="작성자(2자-10자)"
				name="bbs_id" value="${dto.bbs_id}">
		</div>
		
		
		<div class="form-group">
			<label for="title">제목</label>
			<input type="text" class="form-control" id="bbs_title"
					placeholder="제목 입력(4-100)" name="bbs_title" maxlength="100" required="required" pattern=".{4,100}" value="${dto.bbs_title}">
			</div>
			<div class="form-group">
				<label for="diff">구분</label>
				<input type="text" class="form-control" id="bbs_diff"
					placeholder="게시판구분을 선택해주세요" name="bbs_diff" maxlength="100" required="required" value="${dto.bbs_diff}">
			</div>
			
			<div class="form-group">
				<label for="content">내용</label>
<!-- 				 여러줄의 데이터를 입력하고 하고자 할때 textarea 태그를 사용한다.
				 textarea 안에 있는 모든 글자는 그대로 나타난다. 공백문자, tag, enter
 -->				<textarea class="form-control" rows="5" id="bbs_contents" name="bbs_contents" placeholder="내용 작성">${dto.bbs_contents}</textarea>
			</div>
			
			<div class='bottom'>
				<input type="submit"  value="등록">
				<input type="submit"  value="목록" onclick="location.href='noticeList.do'">
			</div>
			

		<%-- 			
			<div class='bottom'>
				<input type="submit"  value="글쓰기" onclick="location.href='create.do?bbs_num=${dto.bbs_num}'">		
			</div>
 --%>

		<!-- <button type="submit" class="btn btn-default">등록</button> -->

	</form>
</div>




<%@ include file="../footer.jsp"%>