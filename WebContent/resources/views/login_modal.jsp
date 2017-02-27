<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal fade" id="login-modal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			<h3 class=" modal-title" id="searchDetail_modal_label"> LOGIN</h3>
      </div>
      <div class="modal-body">
        <form class="form-horizontal" id="private_form" method="POST">		
			<div class="form-group">
				<label for="joinEmail" class="col-md-4 control-label">아이디</label>
					<div class="col-md-5">
						<input type="text" class="form-control" id="loginEmail"
							name="loginEmail" placeholder="아이디를 입력해주세요">
					</div>
			</div>
			<div class="form-group">
				<label for="joinPassword" class="col-md-4 control-label">비밀번호</label>
				<div class="col-md-5">
					<input type="password" class="form-control" id="loginPassword"
						name="loginPassword" placeholder="비밀번호를 입력해주세요">
				</div>
			</div>
			<div class="form-group">
				<label class="radio-inline col-md-offset-4">
				  <input type="radio" name="member_check" id="private_member_check" value="private"> 개인회원
				</label>
				<label class="radio-inline">
				  <input type="radio" name="member_check" id="company_member_check" value="company"> 기업회원
				</label>
			</div>
			</form>
      </div>
      <div class="modal-footer" align="center">
        <button type="button" class="btn btn-primary" id="loginBtn">로그인</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script>
$('#loginBtn').click(function(){
	if($('#loginEmail').val()==''){
		alert("아이디를 입력하세요!");
		return false;
	}
	else if($('#loginPassword').val()==''){
		alert("비밀번호를 입력하세요!");
		return false;
	}
	else if(!$("input[name='member_check']:checked").val())
	{
		alert('개인회원/기업회원 중 하나를 선택하세요!');
		return false
	}
	else
	{
	 	if($('input[name="member_check"]:checked').val() == 'private')
		{
			$.ajax({
				type:"POST",
				url:"/TestFinalProject/privatelogin.do",
				data:{
					id:$('#loginEmail').val(),
					pwd:$('#loginPassword').val(),	
				},
				success:function(res)
				{
					if(res.trim()=='LOGIN-SUCCESS'){
					  	$('#login-modal').modal('hide');
					  	location.replace("/TestFinalProject/privateafterlogin.do");
					}
					else if(res.trim()=='NO-ID'){
						alert("존재하지 않는 아이디입니다!");
					}
					else{
						alert("비밀번호가 일치하지 않습니다!");
					}
					$('#loginEmail').val('');
					$('#loginPassword').val('');
				},
				error:function(){
					alert("서버 오류");
					$('#loginEmail').val('');
					$('#loginPassword').val('');
				}
			});
		}
		else
		{
			$.ajax({
				type:"POST",
				url:"/TestFinalProject/companylogin.do",
				data:{
					id:$('#loginEmail').val(),
					pwd:$('#loginPassword').val(),	
				},
				success:function(res)
				{
					if(res.trim()=='LOGIN-SUCCESS'){
					  	$('#login-modal').modal('hide');
					  	location.replace("/TestFinalProject/companypage.do");
					}
					else if(res.trim()=='NO-ID'){
						alert("존재하지 않는 아이디입니다!");
					}
					else{
						alert("비밀번호가 일치하지 않습니다!");
					}
					$('#loginEmail').val('');
					$('#loginPassword').val('');
				},
				error:function(){
					alert("서버 오류");
					$('#loginEmail').val('');
					$('#loginPassword').val('');
				}
			});
		}
	}
})
</script>