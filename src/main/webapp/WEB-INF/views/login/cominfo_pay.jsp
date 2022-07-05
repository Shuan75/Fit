<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="../css/noticestyle.css" rel="stylesheet" type="text/css">
<%@ include file="../header.jsp"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js" integrity="sha512-bLT0Qm9VnAYZDflyKcBaQ2gg0hSYNQrJ8RilYldYQ1FxQYoCLtUjuuRuZo+fjqhx/qtq/1itJ0C2ejDxltZVFg==" crossorigin="anonymous" type="text/javascript"></script>
<script src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js" type="text/javascript"></script>

<style>
section {
	display: -webkit-flex;
	display: flex;
}

article {
	-webkit-flex: 3;
	-ms-flex: 3;
	flex: 3;
	padding: 10px;
}
</style>

<section class="mypage">

	<nav>
		<div id="navigation">
			<div class="snb">
				<h2>마이페이지</h2>
				<ul>
					<li><a href="#" onclick="location.href='modify.do?id=${s_id}'">회원정보수정</a></li>
					<li><a href="#" onclick="location.href='calendar.do'">달력</a></li>
					<li><a href="#" onclick="location.href='chart.do'">차트</a></li>
					<li><a href="#" onclick="location.href='pay.do'">결제</a></li>
					<li><a href="#" onclick="location.href='chat.do'">온라인강의</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<article>
	
	<h5>이용권</h5>		
	<table class = pay border="1">
		<tr><td rowspan="2" class="pay_detail">이용권</td><td>월 기본 제공 </td><td><%-- <%=bvo.getFree_coupon() %> --%>/5</td></tr>
		<tr><td>남은 구매 이용권 횟수</td><td id = "pay_coupon"><%-- <%=bvo.getPay_coupon() %> --%> </td></tr>
	</table>
		
	<div class ="btns">
		<input type="button" id="check1" value="구매">
		<input type="button" id="check2" value="환불">
	</div>
	
<script type="text/javascript">
$(document).ready(function(){
	   <%-- var pay = <%=bvo.getPay_coupon() %>; --%>
	   console.log(pay);
	   	  
		var IMP = window.IMP;
		var code = "imp********"; //가맹점 식별코드
		IMP.init(code);
		
		$("#check1").click(function(e){
			//결제요청
			IMP.request_pay({
				//name과 amout만있어도 결제 진행가능
				//pg : 'kakao', //pg사 선택 (kakao, kakaopay 둘다 가능)
				pay_method: 'card',
				merchant_uid : 'merchant_' + new Date().getTime(),
				name : '결제테스트', // 상품명
				amount : 1,
				<%-- buyer_email : '<%=email%>', --%>
				<%-- buyer_name : '<%=mvo.getName()%>', --%>
				<%-- buyer_tel : '<%= mvo.getPhone()%>',  //필수항목 --%>
				//결제완료후 이동할 페이지 kko나 kkopay는 생략 가능
				//m_redirect_url : 'https://localhost:8080/payments/complete'
			}, function(rsp){
				if(rsp.success){//결제 성공시
					var msg = '결제가 완료되었습니다';
					var result = {
					"imp_uid" : rsp.imp_uid,
					"merchant_uid" : rsp.merchant_uid,
					<%-- "biz_email" : '<%=email%>', --%>
					"pay_date" : new Date().getTime(),
					"amount" : rsp.paid_amount,
					"card_no" : rsp.apply_num,
					"refund" : 'payed'
					}
					console.log("결제성공 " + msg);
					$.ajax({
						url : '/samsam/insertPayCoupon.do', 
				        type :'POST',
				        data : JSON.stringify(result,
				        		['imp_uid', 'merchant_uid', 'biz_email', 
				        			'pay_date', 'amount', 'card_no', 'refund']),
				        contentType:'application/json;charset=utf-8',
				        dataType: 'json', //서버에서 보내줄 데이터 타입
				        success: function(res){
				        			        	
				          if(res == 1){
							 console.log("추가성공");	
							 pay += 5;
							 $('#pay_coupon').html(pay);			           
				          }else{
				             console.log("Insert Fail!!!");
				          }
				        },
				        error:function(){
				          console.log("Insert ajax 통신 실패!!!");
				        }
					}) //ajax
					
				}
				else{//결제 실패시
					var msg = '결제에 실패했습니다';
					msg += '에러 : ' + rsp.error_msg
				}
				console.log(msg);
			});//pay
		}); //check1 클릭 이벤트
		 
		$("#check2").click(function(e){
		      console.log("남은이용권"+$('#pay_coupon').text());
		      if($('#pay_coupon').text() >= 5){
			$.ajax({
					url: "/samsam/coupon_cancel.do",
					type:"post",
					//datatype:"json",
					contentType : 'application/x-www-form-urlencoded; charset = utf-8',
					data : {
						"biz_email" : '<%-- <%=email%> --%>' // 주문번호
						//"cancle_request_amount" : 2000, //환불금액
						//"reason": "테스트 결제 환불", //환불사유
						//"refund_holder": "홍길동", //[가상계좌 환불시 필수입력] 환불 가상계좌 예금주
						//"refund_bank":"88", //[가상계좌 환불시 필수입력] 환불 가상계좌 은행코드(ex Kg이니시스의 경우 신한은행 88)
						//"refund_account": "56211105948400" // [가상계좌 환불시 필수입력] 환불 가상계좌 번호
					}
				}).done(function(result){ //환불 성공
					 pay -= 5;
					 $('#pay_coupon').html(pay);	
					console.log("환불 성공 : "+ result);
				}).fail(function(error){
					console.log("환불 실패 : "+ error);
				});//ajax
			} else{
				console.log("환불 실패 : 남은 결제권 환불 불가");
			}
		}); //check2 클릭
	}); //doc.ready
</script>
	
	</article>
</section>
<%@ include file="../footer.jsp"%>
