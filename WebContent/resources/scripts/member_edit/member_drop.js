/**
 * 회원 탈퇴
 */
$(function(){
	var hiddenVal = $('#hiddenVal');	// 조건을 위한 value값
	var msg = $('#drop_msg');			// 기본 출력 메시지
	var form = $('#dropForm')			// 비밀번호 입력폼 
	var confirmBtn = $('#drop_confirm');	// 기본 확인 버튼
	var cancelBtn = $('#drop_cancel');		// 기본 취소 버튼
	var finalBtn = $('#final_drop_btn');	// 최종 탈퇴 버튼
	var dropPwd = $('#dropPwd');			// 비밀번호 입력
	var dropPwdMsg = $('#drop_pwd_message');	// 유효하지 않은 비밀번호 입력시 메시지
	/*기본 확인 버튼 눌렀을 때*/
	$(confirmBtn).on('click', function(){
		/*첫 번째 화면*/
		if(hiddenVal.val() === '1'){
			form.prop('hidden', '');
			msg.html('탈퇴를 위해 비밀번호를 입력해주세요!!');
			hiddenVal.prop('value','2');
		}
		/*두 번째 화면*/
		else{
			// 비밀번호 틀리면(현재는 null값으로)
			if(dropPwd.val() === ''){
				dropPwdMsg.prop('hidden','');
			}else{
				form.prop('hidden','hidden');
				dropPwdMsg.prop('hidden','hidden');
				hiddenVal.prop('value', '3');
				msg.html('회원 탈퇴를 완료하였습니다');
				$('#init_btn_set').prop('hidden','hidden');
				$('#final_btn_set').prop('hidden','');
			}
		}
	});
	/*기본 취소 버튼 눌렀을 때*/
	$(cancelBtn).on('click',function(){
		/*첫 번째 화면으로 모달 초기화*/
		dropPwd.val('');
		form.prop('hidden','hidden');
		dropPwdMsg.prop('hidden','hidden');
		hiddenVal.prop('value', '1');
		msg.html('정말로 탈퇴하시겠습니까?');
	});
	/*최종 탈퇴 버튼 눌렀을 때*/
	$(finalBtn).on('click', function(){
		// 첫 번째 화면으로 모달 초기화
		form.prop('hidden','hidden');
		hiddenVal.prop('value', '1');
		msg.html('정말로 탈퇴하시겠습니까?');
		$('#init_btn_set').prop('hidden','');
		$('#final_btn_set').prop('hidden','hidden');
		dropPwd.val('');
	});
	// 회원 정보 삭제 눌렀을 때 데이터 전송
/*	$('#dropBtn').click(function(){
		location.replace("/TestFinalProject/delete.do");
	});*/
})