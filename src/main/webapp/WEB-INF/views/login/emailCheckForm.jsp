<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emailCheckForm</title>
</head>
<body>
	<div style="text-align: center">
		<h3>* 이메일 중복확인 *</h3>
		<form action="emailCheckProc.do" onsubmit="return blankCheck()">
			이메일 : <input type="text" name="email" id="email" maxlength="30" autofocus="autofocus"> 
					<input type="submit" value="중복확인">
		</form>
	</div>

	<script> 
		function blankCheck() {
			var email = document.getElementById("email").value;
			email = email.trim();
			var regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
			  if(email == "") {
				alert('이메일을 입력해주세요.');
				return false;
		
		      }

				else if (regEmail.test(email) === false) {
		          alert('이메일형식이 아닙니다.');
		          return false;
				
			}
		return true;
	}
	</script>
</body>
</html>