/**
 * 
 */
 let submit_check = function() {
	let reg_name = /^[가-힣]{2,10}$/;
	let reg_password = /^[A-Za-z0-9]{6,12}$/;
	let reg_hp = /^(010|070|080)\d{3,4}\d{4}$/; //d:digit 자리수
	let reg_email = /^[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/i;
	
	//이름
	if(!document.userInfoForm.nickname.value){
		alert("닉네임을 입력하세요");
		document.userInfoForm.nickname.focus();
		return false;
	}
	else if(!reg_name.test(document.userInfoForm.nickname.value)) {
		alert("닉네임을 확인 하세요(한글2~10글자)");
		document.userInfoForm.nickname.value = "";
		document.userInfoForm.nickname.focus();
		return false;
	}
	
	//비밀번호
	if(document.userInfoForm.password.value != document.userInfoForm.repassword.value){
		alert("비밀번호가 일치하지 않습니다.");
		document.userInfoForm.password.focus();
		return false;
	}
	
	if(!document.userInfoForm.password.value){
		alert("비밀번호를 입력하세요 (영문 6~12자리)");
		document.userInfoForm.password.focus();
		return false;
	}
	else if(!reg_password.test(document.userInfoForm.password.value)) {
		alert("비밀번호를 확인 하세요(영문 6~12자리)");
		document.userInfoForm.password.value = "";
		document.userInfoForm.password.focus();
		return false;
	}
	
	//핸드폰
	if(!document.userInfoForm.hp1.value || !document.userInfoForm.hp2.value || !document.userInfoForm.hp3.value){
		alert("핸드폰번호를 입력하세요");
		document.userInfoForm.userHp.focus();
		return false;
	}
	else if(!reg_hp.test(document.userInfoForm.hp1.value + document.userInfoForm.hp2.value + document.userInfoForm.hp3.value)) {
		alert("핸드폰번호를 확인 하세요");
		document.userInfoForm.hp1.value = "";
		document.userInfoForm.hp2.value = "";
		document.userInfoForm.hp3.value = "";
		document.userInfoForm.hp1.focus();
		return false;
	}
}

let selectEmailChk = function() {
	if(document.userInfoForm.email3.value != "0"){
		document.userInfoForm.email2.value = document.userInfoForm.email3.value;
	}
	else{
		document.userInfoForm.email2.focus();
		document.userInfoForm.email2.value = "";
	}
}

let deleteconfirm = function(path) {
	if(confirm("정말 탈퇴 하시겠습니까?")){
		window.location=path+"/memberDeleteAction.do";
	}
}