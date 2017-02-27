
/*
 * datepicker 포맷 맞추기
 */
$(function(){
	/*
	 * 연도, 월만 나오는 datepicker
	 */
	$('.year-month-picker').each(function() {
		$(this).datepicker({
			format : "yyyy년 mm월",
			startView : "months",
			minViewMode : "months",

		});
	});
	
	/*
	 * 연도, 월, 일 나오는 datepicker
	 */
	$('#birthDate-picker').datepicker({
		format : "yyyy년 mm월 dd일",

	});
	
});

/*
 * 모달이 뜰 때 새로 추가인지, 모달인지 
 */
$(function(){
	/*
	 * 학력사항
	 */
	
	/* 추가 버튼 클릭 시 */
	$('#education_add_btn').on('click', function() {
		allHide();
		var selects = $('#school_info_modal select');
		for (var i = 0; i < selects.length; ++i) {
			$(selects[i]).val('choice');
		}
		$("#school_info_modal input").val('');
	});
	
	/* 편집 버튼 클릭 시 */
	$('#highschool_modify_btn').on('click', function() {
		$('#school_info_modal').modal('show');
		$('#schoolCategory').val("고등학교");
	});
	
	$('#university_modify_btn').on('click', function() {
		$('#school_info_modal').modal('show');
		$('#schoolCategory').val("대학교");
	});
	
	$('#graduateschool_modify_btn').on('click', function() {
		$('#school_info_modal').modal('show');
		$('#schoolCategory').val("대학원");
	});
	
	/* 삭제 버튼 클릭 시 */
	$('#highschool_delete_btn').on('click', function() {
		$('#highschool').hide();
		$('#highschool_text').text('');
		$('#highschool .duration').text('');
		

	});
	
	$('#university_delete_btn').on('click', function() {
		$('#university').hide();		
		$('#university_text').text('');
		$('#university .duration').text('');
		
		$('#resume_education h1').show();
	});
	
	$('#graduateschool_delete_btn').on('click', function() {
		$('#graduateschool').hide();		
		$('#graduateschool_text').text('');
		$('#graduateschool .duration').text('');
		
		$('#resume_education h1').show();
	});
	
//	/*
//	 * 병역사항
//	 */
//	/* 추가 버튼 클릭 시 */
//	$('military_add_btn').on('click', function() {
//		/*
//		 * 병역사항 이미 등록되어있을 시 모달창 띄우지 않는다
//		 */
//	});
//	/* 편집 버튼 클릭 시 */
//	$('#military_modify_btn').on('click', function() {
//		$('#military_modal').modal('show');
//		/*
//		 * 디비의 데이터 수정 
//		 */
//	});
//	
//	/* 삭제 버튼 클릭 시 */
//	$('#military_delete_btn').on('click', function() {
//		$('#military').hide();
//		$('#military_text').text('');
//		$('#military .duration').text('');
//
//		$('#resume_military h1').show();
//		/*
//		 * 디비의 데이터 삭제
//		 */
//		$('#military_add_btn').removeAttr('disabled');
//	});
//	
//	/*
//	 * 장애, 보훈사항
//	 */
//	/* 추가 버튼 클릭 시 */
//	$('#unusual_add_btn').on('click', function() {
//		/*
//		 * 장애, 보훈사항 이미 등록되어있을 시 모달창 띄우지 않는다
//		 */
//	});
//	/* 편집 버튼 클릭 시 */
//	$('#unusual_modify_btn').on('click', function() {
//		$('#unusual_modal').modal('show');
//		/*
//		 * 디비의 데이터 수정
//		 */
//	});
//	/* 삭제 버튼 클릭 시 */
//	$('#unusual_delete_btn').on('click', function() {
//		$('#remark').hide();
//		$('#remark_text1').text('');
//		$('#remark_text2').text('');
//
//		$('#resume_remark h1').show();
//		$('#unusual_add_btn').removeAttr('disabled');
//
//		/*
//		 * 디비의 데이터 삭제
//		 */
//	});
//	/*
//	 * 경력사항
//	 */
//	
});


/* 학력사항 */
/*
 * 학교분류에 따른 입력폼 보여주기
 */
function allHide() {
	$('#schoolForm').hide();
	$('#majorForm').hide();
	$('#schoolAreaForm').hide();
	$('#stateDegreeForm').hide();
	$('#schoolDateForm').hide();
	$('#gradeForm').hide();
}

$(function() {
	allHide();

	$('#schoolCategory').change(function() {

		var category = $('#schoolCategory option:selected').val().split('/');
		if (category[1] == '분류를 선택해주세요') {
			allHide();
		} else if (category[1] == '고등학교') {
			allHide();
			$('#schoolForm').show();
			$('#majorForm').show();
			$('#schoolDateForm').show();
		} else {
			allHide();
			$('#schoolForm').show();
			$('#majorForm').show();
			$('#schoolAreaForm').show();
			$('#stateDegreeForm').show();
			$('#schoolDateForm').show();
			$('#gradeForm').show();
		}
	});

});

/* 커리어 모달 */
$(function(){
});

/* 어학 시험 모달 */
$(function() {
});

/* 자격증 모달 */
$(function() {
});

/* 수상경력 모달 */
$(function() {
 	var category = $('#award-category');
 	$('#award-category').change(function(){
 		 if(category.find(' option:selected').html() == '기타 수상')
 			 $('#award-field-form').hide();
 		 else
 			 $('#award-field-form').show();
 	});
});

/* 해외 연수 모달 */
$(function(){
});

/* 병역사항 모달 */
$(function() {

	$('#military-select').change(function() {
		if ($('#military-select option:selected').val() == '필') {
			$('#militaryDate1').removeAttr('disabled');
			$('#militaryDate2').removeAttr('disabled');
			$('#militaryCategory').removeAttr('disabled');
			$('#militaryClass').removeAttr('disabled');
		} else {
			$('#militaryDate1').attr('disabled', 'disabled');
			$('#militaryDate2').attr('disabled', 'disabled');
			$('#militaryCategory').attr('disabled', 'disabled');
			$('#militaryClass').attr('disabled', 'disabled');
		}
	});
});

/* 봉사활동 모달 */
$(function(){
});

/* 보훈 장애 */
$(function() {
	/*
	 * 장애대상여부가 비대상일 경우 장애등급 비활성화
	 */
	$('#isDisabled').change(function() {
		if ($('#isDisabled option:selected').val() == '대상')
			$('#disabilityClass').removeAttr('disabled');
		else {
			$('#disabilityClass').val('---');
			$('#disabilityClass').attr('disabled', 'disabled');
		}
	});

});

