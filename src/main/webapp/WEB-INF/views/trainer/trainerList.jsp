<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="../header.jsp"%>
<link rel="stylesheet" type="text/css" href="../assets/css/styles.css" />

<div id="doc" class="yui-t1">
	<div id="bd">
		<div id="yui-main">
			<div class="yui-b">
				<div class="yui-gb">
					<div class="yui-u first">
						<div class="content">
							<table class="tg">
								<tr>
									<td class="tg-0lax"><img src="../storage/trainerKim.png" width="228px" height="190px"><br></td>
								</tr>
								<tr>
									<th class="tg-0lax">${list.id }</th>
								</tr>
								<tr>
									<td class="tg-0lax">${list.u_name }</td>
								</tr>
								<tr>
									<td class="tg-0lax">${list.inform }</td>
								</tr>
 
								<tr>
									<td class="tg-0lax">${list.u_code }</td>
								</tr>
 

							</table>
						</div>
					</div>
					<div class="yui-u">
						<div class="content">
							
						</div>
					</div>
					<div class="yui-u">
						<div class="content">Content Here</div>
					</div>
				</div>
			</div>
		</div>
		<div class="yui-b">
			<div id="secondary">강사 소개</div>
		</div>
	</div>
</div>


<%@ include file="../footer.jsp"%>