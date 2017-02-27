/**
 * 	회원 정보 수정
 */

 
$(function(){
	// 입력 내용
	var id = $('#editID');
	var pwd = $('#editPwd');
	var pwdCheck = $('#editPwdCheck');
	var name = $('#editName');
	var eMail = $('#editEmail');
	// 상태 메시지
	var modifyMsg = $('#modify_message');
	// 비밀번호 다를경우 메시지 출력
	pwdCheck.focus(function(){
		if(pwd.val() !== pwdCheck.val()){
			$('#pwd_message').prop('hidden','');
		}else{
			$('#pwd_message').prop('hidden','hidden');
		}

	});
	pwdCheck.blur(function(){
		if(pwd.val() !== pwdCheck.val()){
			$('#pwd_message').prop('hidden','');
		}else{
			$('#pwd_message').prop('hidden','hidden');
		}
	});
	$(this).on('change',function(){
		if(pwd.val() === pwdCheck.val()){
			$('#pwd_message').prop('hidden','hidden');
		}
	})
	$('#editBtn').click(function(){
		if(id.val() === "" || pwd.val() ==="" || pwdCheck.val() ==="" || name.val() ==="" || eMail.val() === ""){
			modifyMsg.prop('style','color:red');
			modifyMsg.html('수정 실패!! 회원 정보를 확인해주세요');
			modifyMsg.prop('hidden','');
		}else{
			modifyMsg.prop('style','color:blue');
			modifyMsg.html('수정 완료');
			modifyMsg.prop('hidden','');
		}
	});
	// 회원 정보 수정 눌렀을 때 데이터 전송
/*	$('#editBtn').click(function(){
		$('#editForm').submit();
	});*/
})