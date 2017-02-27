<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="join-modal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		<h3 class=" modal-title" id="searchDetail_modal_label"> JOINUS!</h3>
      </div>
      <div class="modal-body">
      <div role="tabpanel">

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist" id="member_tab">
    <li role="presentation" class="active"><a href="#private_member" aria-controls="private_member" role="tab" data-toggle="tab">개인회원</a></li>
    <li role="presentation"><a href="#company_member" aria-controls="company_member" role="tab" data-toggle="tab">기업회원</a></li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content" id="my">
  <!-- 개인회원가입 탭 -->
    <div role="tabpanel" class="tab-pane active" id="private_member" style="margin-top:20px; margin-bottom:20px">
		<form class="form-horizontal" id="private_join_form" method="POST">		
			<div class="form-group">
				<label class="col-md-4 control-label">아이디</label>
					<div class="col-md-5">
						<input type="text" class="form-control" id="private_id"
							name="private_id" placeholder="아이디를 입력해주세요">
					</div>
					<div class="col-md-2">
						<button class="btn btn-default" id="private_checkID_btn">중복확인</button>
					</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label">비밀번호</label>
				<div class="col-md-5">
					<input type="password" class="form-control" id="private_pw"
						name="private_pw" placeholder="비밀번호를 입력해주세요">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label">비밀번호
					확인</label>
				<div class="col-md-5">
					<input type="password" class="form-control" id="private_pw_check"
						name="private_pw_check" placeholder="비밀번호를 다시 입력해주세요">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label">이름</label>
				<div class="col-md-5">
					<input type="text" class="form-control" id="private_name"
						name="private_name" placeholder="이름을 입력해주세요">
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-4 control-label">이메일</label>
				<div class="col-md-5">
					<input type="email" class="form-control" id="private_email"
						name="private_email" placeholder="이메일을 입력해 주세요">
				</div>
			</div>
			<div class="checkbox col-md-offset-3">
			    <label>
			      <input type="checkbox" name="private_check" id="private_check"> 이용약관, 개인정보 수집 및 이용 동의
			      <a href="#"> 보기</a>
			    </label>
			</div>
		</form>
      </div>
    <!-- 기업회원가입 탭 -->
    <div role="tabpanel" class="tab-pane" id="company_member" style="margin-top:20px; margin-bottom:20px">
	    <form class="form-horizontal" id="company_join_form" method="POST">
				<div class="form-group">
					<label class="col-md-4 control-label">아이디</label>
					<div class="col-md-5">
						<input type="text" class="form-control" id="company_id"
							name="company_id" placeholder="아이디를 입력해주세요">
					</div>
						<div class="col-md-2">
							<button class="btn btn-default" id="company_checkID_btn">중복확인</button>
						</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">비밀번호</label>
					<div class="col-md-5">
						<input type="password" class="form-control" id="company_pw"
							name="company_pw" placeholder="비밀번호를 입력해주세요">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">비밀번호 확인</label>
					<div class="col-md-5">
						<input type="password" class="form-control" id="company_pw_check"
							name="company_pw_check" placeholder="비밀번호를 다시 입력해주세요">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">담당자 이름</label>
					<div class="col-md-5">
						<input type="text" class="form-control" id="company_manager_name"
							name="company_manager_name" placeholder="담당자 이름을 입력해주세요">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">담당자 이메일</label>
					<div class="col-md-5">
						<input type="email" class="form-control" id="company_email"
							name="company_email" placeholder="담당자 이메일을 입력해 주세요">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">기업명</label>
					<div class="col-md-5">
						<input type="text" class="form-control" id="company_name"
							name="company_name" placeholder="기업명을 입력해 주세요">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">사업자번호</label>
					<div class="col-md-5">
						<input type="text" class="form-control" id="company_num"
							name="company_num" placeholder="사업자번호를 입력해 주세요">
					</div>
					<div class="checkbox col-md-offset-2">
				 </div>
				</div>
				<div class="checkbox col-md-offset-3">
				    <label>
				      <input type="checkbox" id="company_check" name="company_check" > 이용약관, 개인정보 수집 및 이용 동의
				      <a href="#"> 보기</a>
				    </label>
				 </div>
			</form>
	    </div>
 </div>
 </div>

</div>
      <div class="modal-footer">
		<div class="form-group">
			<div class="col-md-offset-4 col-md-4">
				<button type="button" class="btn btn-primary btn-lg btn-block" id="joinBtn">회원가입</button>
			</div>
		</div>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script>

function hasClass(element, cls) {
    return (' ' + element.className + ' ').indexOf(' ' + cls + ' ') > -1;
}

$(function(){
	
	
	$('#joinBtn').click(function(){
	
		/*
		활성화되어있는 탭 검사 
		*/
		var tabname = document.getElementById("company_member");
		var target =  hasClass(tabname,'active');
		
		/*
		 * 기업회원가입인 경우
		 */
		if(target == true)
		{
			if($('#company_id').val() == '')
			{
				alert('아이디를 입력해주세요!');
				return false;
			}
			else if($('#company_pw').val() == '')
			{
				alert('비밀번호를 입력해주세요!');
				return false;
			}
			else if($('#company_pw_check').val() == '')
			{
				alert('비밀번호 확인을 입력해주세요!');
				return false;
			}
			else if($('#company_pw').val() != $('#company_pw_check').val())
			{
				alert('비밀번호와 비밀번호 확인이 일치하지않아요! 다시입력해주세요');
				$('#company_pw').val('');
				$('#company_pw_check').val('');
				return false;
			}
			else if($('#company_manager_name').val() == '')
			{
				alert('담당자 이름을 입력해주세요!');
				return false;
			}
			else if($('#company_email').val() == '')
			{
				alert('담당자 이메일을 입력해주세요!');
				return false;
			}
			else if($('#company_name').val() == '')
			{
				alert('기업명을 입력해주세요!');
				return false;
			}
			else if($('#company_num').val() == ''){
				alert('사업자번호를 입력해주세요!');
				return false;
			}
			else if(!$("input:checkbox[name='company_check']").is(":checked"))
			{
				alert('이용약관에 동의해주세요.');
				return false;
			} 
			
			var form = $('#company_join_form').serializeObject();
			console.log(form);
			
			$.ajax({
				type: "POST",
				url: "/TestFinalProject/companyjoin.do",
				data: form,
				success:function(res)
				{
					if(res.trim()=='JOIN-SUCCESS'){
					  	alert("회원가입이 완료되었습니다.");
					  	$('#join-modal').modal('hide');
					  	$('#company_id').val('');
						$('#company_pw').val('');
						$('#company_pw_check').val('');
						$('#company_manager_name').val('');
						$('#company_email').val('');
						$('#company_name').val('');
						$('#company_num').val('');
					}
					else{
						/* 로직 관련 에러 */
						alert("회원가입에 실패하였습니다.");
					}
				},
				error:function(){
					/* 서버 에러 */
					alert("서버 오류");
				}
			});
		}
		
		/*
		 * 개인회원가입인 경우
		 */
		else
		{
			if($('#private_id').val() == '')
			{
				alert('아이디를 입력해주세요!');
				return false;
			}
			else if($('#private_pw').val() == '')
			{
				alert('비밀번호를 입력해주세요!');
				return false;
			}
			else if($('#private_pw_check').val() == '')
			{
				alert('비밀번호 확인을 입력해주세요!');
				return false;
			}
			else if($('#private_pw').val() != $('#private_pw_check').val())
			{
				alert('비밀번호와 비밀번호 확인이 일치하지않아요! 다시입력해주세요');
				$('#private_pw').val('');
				$('#private_pw_check').val('');
				return false;
			}
			else if($('#private_name').val() == '')
			{
				alert('이름을 입력해주세요!');
				return false;
			}
			else if($('#private_email').val() == '')
			{
				alert('이메일을 입력해주세요!');
				return false;
			}
			else if(!$("input:checkbox[name='private_check']").is(":checked"))
			{
				alert('이용약관에 동의해주세요.');
				return false;
			}
			
			
			var form = $('#private_join_form').serializeObject();
			console.log(form);
			
			$.ajax({
				type: "POST",
				url: "/TestFinalProject/privatejoin.do",
				data: form,
				success:function(res)
				{
					if(res.trim()=='JOIN-SUCCESS'){
					  	alert("회원가입이 완료되었습니다.");
					  	$('#join-modal').modal('hide');
					  	$('#private_id').val('');
						$('#private_pw').val('');
						$('#private_pw_check').val('');
						$('#private_email').val('');
						$('#private_name').val('');
					}
					else{
						/* 로직 관련 에러 */
						alert("회원가입에 실패하였습니다.");
					}
				},
				error:function(){
					/* 서버 에러 */
					alert("가입 서버 오류");
				}
			});
		}
	});

	$.fn.serializeObject = function(){
	    var o = {};
	    var a = this.serializeArray();
	    $.each(a, function() {
	    	var name = $.trim(this.name),
	    		value = $.trim(this.value);
	    	
	        if (o[name]) {
	            if (!o[name].push) {
	                o[name] = [o[name]];
	            }
	            o[name].push(value || '');
	        } else {
	            o[name] = value || '';
	        }
	    });
	    return o;
	};
});


</script>