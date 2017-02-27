/**
 * 
 */
$(function(){
				// 타임라인 크기 설정
			var periodSize = $('.period_time').length;
			$('.timeline').css('width',(180*periodSize)+'px');
			$('#timeline_container').css('width',(180*periodSize+30)+'px');
			$('#timeline_container').css('margin-left','30px');
			
			// 타임라인 항목 내용 팝오버
			$('.timeline_school').hover(function() {
				$(this).popover('show');
			}, function() {
				$(this).popover('hide');
			})
});