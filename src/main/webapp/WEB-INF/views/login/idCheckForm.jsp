<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>idCheckForm</title>
</head>
<body>
	<div style="text-align: center">
		<h3>* 아이디 중복확인 *</h3>
		<form action="idCheckProc.do" onsubmit="return blankCheck()">
			아이디 : <input type="text" name="id" id="id" maxlength="30" autofocus="autofocus"> 
					<input type="submit" value="중복확인">
		</form>
	</div>

	<script> 
		function blankCheck() {
			var id = document.getElementById("id").value;
			id = id.trim();
			var regId = /^[a-z]+[a-z0-9]{5,20}$/g;
			var lengId = /^[a-z0-9_]{5,20}$/;
			  if(lengId.test(id) === false) {
				alert('아이디는 5~20글자 이내로 입력해주세요.');
				return false;
		
		      } 
			 else if (regId.test(id) === false) {
		          alert('아이디는 영문자로 시작하는 6~20자 영문자 또는 숫자이어야 합니다.');
		          return false;
		       } 
		return true;
	}
	</script>
</body>
</html>