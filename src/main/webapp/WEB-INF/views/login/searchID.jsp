<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<h3>아이디 / 비밀번호 찾기</h3>
	<form method="post" action="findIdProc.do" onsubmit="return findIDCheck()">
		<table class="table">
			<tr>
				<th>이름</th>
				<td><input type="text" name="u_name" id="u_name" placeholder="이름"
					maxlength="20" required></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="email" id="email"
					placeholder="이메일" required></td>
			</tr>
			<tr class="mobileNo">
				<th>
					<label for="phone">휴대폰 번호</label>
				</th>
				<td>
					<p>
						<input id="phone" type="text" name="phone" title="전화번호 입력" required/>
						<button id="phoneChk" class="doubleChk">인증번호 보내기</button><br/>
						<input id="phone2" type="text" name="phone2" title="인증번호 입력" disabled required/>
						<button id="phoneChk2" class="doubleChk">본인인증</button><br/>
						<span class="point successPhoneChk">휴대폰 번호 입력후 인증번호 보내기를 해주십시오.</span>
						<input type="hidden" id="phoneDoubleChk"/>
					</p>
					<p class="tip">			
					</p>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="아이디/비번찾기"
					class="btn btn-primary" /> <input type="reset" value="취소"
					class="btn btn-primary" /></td>
			</tr>	
		</table>	
	</form>
<script>
var code2 = "";
$("#phoneChk").click(function(){
	alert("인증번호 발송이 완료되었습니다.\n휴대폰에서 인증번호 확인을 해주십시오.");
	var phone = $("#phone").val();
	$.ajax({
        type:"GET",
        url:"phoneCheck?phone=" + phone,
        cache : false,
        success:function(data){
        	if(data == "error"){
        		alert("휴대폰 번호가 올바르지 않습니다.")
				$(".successPhoneChk").text("유효한 번호를 입력해주세요.");
				$(".successPhoneChk").css("color","red");
				$("#phone").attr("autofocus",true);
        	}else{	        		
        		$("#phone2").attr("disabled",false);
        		$("#phoneChk2").css("display","inline-block");
        		$(".successPhoneChk").text("인증번호를 입력한 뒤 본인인증을 눌러주십시오.");
        		$(".successPhoneChk").css("color","green");
        		$("#phone").attr("readonly",true);
        		code2 = data;
        	}
        }
    });
});


$("#phoneChk2").click(function(){
	if($("#phone2").val() == code2){
		$(".successPhoneChk").text("인증번호가 일치합니다.");
		$(".successPhoneChk").css("color","green");
		$("#phoneDoubleChk").val("true");
		$("#phone2").attr("disabled",true);
	}else{
		$(".successPhoneChk").text("인증번호가 일치하지 않습니다. 확인해주시기 바랍니다.");
		$(".successPhoneChk").css("color","red");
		$("#phoneDoubleChk").val("false");
		$(this).attr("autofocus",true);
	}
});


</script>
<script>
function findIDCheck() {
	var	phone2 = document.getElementById("phone2").value;
	if (phone2.value == "") {
		alert("본인인증을 진행해주세요.");
		document.getElementById("phone2").focus;
		return false;
	}
/* 	if (!phone2.value) {
		document.getElementById("phone2");
		alert("본인인증을 진행해주세요.");
		return false;
	}
	 */
}
</script>
<%@ include file="../footer.jsp"%>