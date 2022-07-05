/**
 * myscript.js
 */

function bbsCheck() {

	// 1) 작성자 2글자 이상 입력

	var wname = document.getElementById("wname").value; // 작성자가져오기
	wname = wname.trim();
	if (wname.length < 2) {
		alert("작성자 2글자 이상 입력해 주세요.");
		document.getElementById("wname").focus();
		return false;
	}



	// 2) 제목 2글자 이상 입력
	var subject = document.getElementById("subject").value; // 작성자가져오기
	subject = subject.trim();
	if (subject.length < 2) {
		alert("제목을 2글자 이상 입력해 주세요.");
		document.getElementById("subject").focus();
		return false;
	}


	// 3) 내용 2글자 이상 입력
	var content = document.getElementById("content").value; // 작성자가져오기
	content = content.trim();
	if (content.length < 2) {
		alert("내용을 2글자 이상 입력해 주세요.");
		document.getElementById("content").focus();
		return false;
	}


	// 4) 비밀번호는 4글자 이상이면서, 숫자형 기호만 입력

	var passwd = document.getElementById("password").value;
	passwd = passwd.trim();
	if (passwd.length < 4 || isNaN(passwd)) {
		alert("비밀번호는 4글자 이상 숫자로 입력해주세요.");
		document.getElementById("password").focus();
		return false;
	}

	return true;

}

function pwCheck() {

	var passwd = document.getElementById("password").value;
	passwd = passwd.trim();
	if (passwd.length < 4 || isNaN(passwd)) {
		alert("비밀번호는 4글자 이상 숫자로 입력해주세요.");
		document.getElementById("password").focus();
		return false;

	}

	var message = "삭제한 내용은 복구되지 않습니다.\n 계속 진행하시겠습니까 ?";
	if (confirm(message)) {
		// 확인 true => form을 server로 전송
		return true;
	} else {
		return false;
	}
}

function loginCheck() {

	var id = document.getElementById("id").value;
	id = id.trim();
	if (!(id.length >= 5 && id.length <= 10)) {
		alert("ID는 5글자 이상 10글자미만으로 입력해주세요.");
		document.getElementById("id").focus();
		return false;

	}

	var passwd = document.getElementById("password").value;
	passwd = passwd.trim();
	if (!(passwd.length >= 5 && passwd.length <= 10)) {
		alert("비밀번호는 5글자 이상 10글자이내로 입력해주세요.");
		document.getElementById("password").focus();
		return false;

	}
	return true;

}

function idCheck() {



	//window.open("http://www.naver.com", "idwin", "width=400, height=350");
	window.open("idCheckForm.do", "idwin", "width=400, height=350");


}

function emailCheck() {

	window.open("emailCheckForm.do", "email", "width=400, height=350");

}

function memberCheck() {

	var space = /\s/g;

	// 생년월일 
	var birth = document.getElementById("birth").value;
	if (birth.value == "") {
		alert("생년월일을 입력해주세요.");
		document.getElementById("birth").focus();
		return false;
	}
	var birthCheck = /^(19[0-9][0-9]|20\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$/;

	if (!birthCheck.test(birth)) {
		alert("생년월일은 숫자로만 8자리로 입력해주세요.");
		document.getElementById("birth").focus();
		return false;
	}


	// var regId = /^[a-zA-Zㄱ-힣][a-zA-Zㄱ-힣 ]*$/;

	if (!id.value) {
		document.getElementById("id");
		alert("아이디를 입력해주세요.");
		return false;
	}
	if (!email.value) {
		document.getElementById("email");
		alert("이메일을 입력해주세요.");
		return false;
	}
	/*	if(!birth.value) {
			document.getElementById("birth");
			alert("생년월일을 입력해주세요.");
			return false;
		}*/

	//2)비밀번호 8~25글자 인지?
	var passwd = document.getElementById("password").value;
	var repasswd = document.getElementById("repassword").value;
	if (passwd.value == "") {
		alert("비밀번호를 입력해주세요.");
		document.getElementById("password").focus();
		return false;
	}

	var pwdCheck = /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,25}$/;
	if (!pwdCheck.test(passwd)) {
		alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리 사용해야 합니다.");
		document.getElementById("password").focus();
		return false;
	}
	if (!pwdCheck.test(repasswd)) {
		alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~25자리 사용해야 합니다.");
		document.getElementById("repassword").focus();
		return false;
	}

	//3)비밀번호와 비밀번호확인이 서로 일치하는지?
	if (passwd != repasswd) {
		alert("비밀번호가 일치하지 않습니다.");
		document.getElementById("password").focus();
		document.getElementById("repassword");
		return false;
	}

	//4)이름 두글자 이상 인지?
	var u_name = document.getElementById("u_name").value;
	var regU_name = /^[가-힣]{2,4}|[a-zA-Z]{2,10}\s[a-zA-Z]{2,10}$/;

	if (u_name.length < 2) {
		alert("이름을 2글자이상으로 입력해주세요.");
		document.getElementById("u_name").focus();
		return false;
	}

	if (u_name.value == "") {
		alert("이름을 입력해주세요.");
		document.getElementById("u_name").focus();
		return false;
	}
	if (!regU_name.test(u_name)) {
		alert("이름은 한글2~4글자거나 영문2~10글자이여야합니다.");
		document.getElementById("u_name").focus();
		return false;
	}
	//5)이메일 5글자 인지?



	var tel = document.getElementById("pnum").value;
	var telReg = /[^0-9]/g;

	///^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
	// var regNumber = /[^0-9]/g;
	// tel = tel.replace(regNumber, "");
	//if (!telReg.test(tel.value)) {
	//	alert("숫자만 입력해주세요.");
	//	alert("010-1234-5678");
	//	document.getElementById("tel").focus();
	//	return false;
	//}


	
	
	
	return true;



}
//var isRecaptchachecked=false;

//function recaptchaCallback(){// 리캡챠 체크 박스 클릭시 isRecaptchachecked 값이 true로 변경

//  isRecaptchachecked = true;

//}
function findIDCheck() { // 아이디 비번 찾기 유효성 검사
	// 1 이름 두글자 이상인지

	//2 이메일 주소 5글자 이상인지

}

function pdsCheck() { // 포토갤러리 유효성검사

	// 이름

	// 제목

	// 비밀번호


	// 첨부 파일
	// => 확장명이 이미지 파일 (png, jpg, gif)인지

	var filename = document.getElementById("filename").value; // ex) sky.png
	filename = filename.trim();
	if (filename.length == 0) {
		alert("첨부 파일을 선택해주세요");
		return false;
	} else {
		// filename 변수에서 마지막 .의 순서값
		var dot = filename.lastIndexOf(".");
		// 확장명 : 마지막 . 이후 문자열 자르기
		var ext = filename.substr(dot + 1);
		// 확장명을 전부 소문자 치환
		ext = ext.toLowerCase();
		if (ext == "png" || ext == "jpg" || ext == "gif") {
			return true;
		} else {
			alert("이미지 파일만 업로드 가능합니다.");
			return false;
		}



	}


}

function pwCheck2() {
	var passwd = document.getElementById("passwd").value;
	passwd = passwd.trim();
	if (passwd.length < 4 || isNaN(passwd)) {
		alert(" 비밀 번호4글자 이상 숫자로 입력해주세요");
		document.getElementById("passwd").focus();
		return false;
	}

	var message = "첨부파일도 삭제됩니다.\n 계속 진행하시겠습니까?";
	if (confirm(message)) {
		return true;
	} else {
		return false;
	}
}














