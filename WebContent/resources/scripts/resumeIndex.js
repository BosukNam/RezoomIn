/**
 * 
 */
$(function(){
	// 라인 컴포넌트 커서 위치시에 버튼(편집 / 삭제) 보여주기 - 동적처리완료
	// 마우스 커서 올라갔을 때
	$(document).on('mouseenter','.line_component ul', function(){
		$(this).find('li .span_line_component').show();
		$(this).css('background-color', 'lightgray');
	});
	// 마우스 커서가 벗어났을 때
	$(document).on('mouseleave','.line_component ul', function(){
		$(this).find('li .span_line_component').hide();
		$(this).css('background-color', 'white');
	});
});