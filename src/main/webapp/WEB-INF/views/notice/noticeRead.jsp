<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ include file="../member/auth.jsp" %>
<%@ include file="ssi.jsp" %>     --%>
<%@ include file="../header.jsp" %>    
<!-- 본문시작 bbsRead.jsp -->

<link href="../assets/css/styles.css" rel="stylesheet" type="text/css">


<body>
<div class="container">
<!-- 

	 /*    dao.incrementCnt(bbsno); //조회수 증가 */
	    
 -->
<%-- 		<table class="table">
		<tr>
			<th class="success">제목</th>
			<td><%=dto.%></td>
		</tr>
		
<%
				//사용자가 입력한 엔터(\n)를 <br>태그로 바꾸기
				String content=Utility.convertChar(dto.getContent());
				out.print(content);
%>
			</td>

		<tr>
			<th class="success">조회수</th>
			<td><%=dto.getReadcnt()%></td>
		</tr>
		<tr>
			<th class="success">IP</th>
			<td><%=dto.getIp()%></td>
		</tr>		
		</table>
 --%>		<br>
<%-- 		<input type="button" value="답변쓰기" class="btn btn-info"    onclick="location.href='bbsReply.jsp?bbsno=<%=bbsno%>'">
		<input type="button" value="수정"    class="btn btn-warning" onclick="location.href='bbsUpdate.jsp?bbsno=<%=bbsno%>'">
		<input type="button" value="삭제"    class="btn btn-danger"  onclick="location.href='bbsDel.jsp?bbsno=<%=bbsno%>'">
 --%>


		<table class="table">
		<tbody>
		<tr>
			<th class="success">제목</th>
			<td style="text-align: left;">${dto.bbs_title}</td>
		</tr>
		<tr>
			<th class="success">내용</th>
			<td style="text-align: left;">${dto.bbs_contents}
<%-- <%
				//사용자가 입력한 엔터(\n)를 <br>태그로 바꾸기
				String content=Utility.convertChar(dto.getContent());
				out.print(content);
%> --%>
			</td>
		</tr>
		<tr>
			<th class="success">조회수</th>
			
			<%-- <td><%=dto.getReadcnt()%></td> --%>
		</tr>
		<tr>
			<th class="success">작성자</th>
			<td style="text-align: left;">${dto.bbs_id}</td>
			<%-- <td><%=dto.getWname()%></td> --%>
		</tr>
		<tr>
			<th class="success">작성일</th>
			<td style="text-align: left;">${dto.bbs_cdate}</td>
			<%-- <td><%=dto.getRegdt()%></td> --%>
		</tr>
		

		</table>
			
		<div class='bottom'>
			<input type="button" value="수정" onclick="location.href='noticeUpdate.do?bbs_num=${dto.bbs_num}'">			
            <input type="button" value="삭제" onclick="location.href='noticeDel.do?bbs_num=${dto.bbs_num}'" >
      <!--     <input type="button"  value="삭제" onclick="return confirm('삭제글은 복구할 수 없습니다. 삭제하시겠습니까?')" onclick="location.href='noticeList.do'"> -->
          
            
 <%--            <input type="button"  value="삭제" onclick="location.href='noticeDel.do?bbs_num=${dto.bbs_num}'" > --%>
           
            <input type="button"  value="목록" onclick="location.href='noticeList.do'">
            
<%-- 			<button type="button" class="btn btn-light" onclick="location.href='noticeUpdate?bbs_num=${dto.bbs_num}'">수정</button>
			<button type="button" class="btn btn-light" onclick="location.href='noticeDel.do?bbs_num=${dto.bbs_num}'">삭제</button>
 --%>		</div>
				


</div>

</body>




<!-- 본문끝 -->
<%@ include file="../footer.jsp" %>    








