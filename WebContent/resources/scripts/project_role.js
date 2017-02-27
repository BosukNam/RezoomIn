/**
 * 프로젝트 주요역할및 담당
 */
$(function(){
	//주요 역할 및 담당 삭제
	$('#major-role-cancel').click(function() {
		var registerNo = $('#set-project-role-and-task')
		if(registerNo.attr("value")!="0"){
			$.ajax({
				type : "POST",
				url : "/TestFinalProject/deleteRoleAndTask.do",
				data : {
					registerNo:registerNo.attr("value")
				},
				success : function(res) {
					if (res.trim() == "true") {
						alert("성공!")
						registerNo.attr("id", "0")
						$('#project-role-text').val('')
						$('#project-task-text').val('')
					} else {
						alert("실패");
					}
					// 데이터지우기
					// 데이터없을때 예외처리하기
				},
				error : function() {
					/* 서버 에러 */
					alert("서버 오류");
				}
			})
		}
	})
	// 주요 역할 및 담당 수정 및 등록
	$('#major-role-savebtn').click(function() {
		var registerNo = $('#set-project-role-and-task');
		//만약 registerNo 가 -1이면 새로등록, 아니면 기존에 있는 내용 수정
		var url="/TestFinalProject/updateRoleAndTask.do"
		if (registerNo.attr("value") == "0") {
			url="/TestFinalProject/insertRoleAndTask.do"
		}
		alert("text"+$('#project-role-text').val() + "url : "+url);
		$.ajax({
			type : "POST",
			url : url,
			data : {
				registerNo : registerNo.attr("value"),
				projectNo : 1,
				role : $('#project-role-text').val(),
				task : $('#project-task-text').val()
			},
			success : function(res) {
				var data = res.trim();
				if(data!="0"){
					alert("성공!")
					registerNo.attr("value",data);
				}
				alert(data);
			},
			error : function() { 
				alert("주요 역할 및 담당-주요 역할 및 담당 등록 또는 수정 서버 오류");
			}
		})
	})
})