<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="modal fade" id="member_drop_modal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" align="center">회원 탈퇴</h4>
      </div>
      <div class="modal-body">
        <p align="center" id="drop_msg">정말로 탈퇴하시겠습니까?</p>
        <div class="row" style="color:red" id="drop_pwd_message" hidden="hidden">비밀번호를 확인해주세요</div>
        	<form class="form-horizontal" id="dropForm" method="POST" action="/TestFinalProject/drop.do" hidden="hidden">
				<!-- 비밀번호  -->
				<div class="form-group">
					<label for="drop_password" class="cols-sm-2 control-label">비밀번호</label>
					<div class="cols-sm-10">
						<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
							<input type="password" class="form-control" id="dropPwd" name="editPwd" placeholder="비밀번호를 입력해주세요"/>
						</div>
					</div>
				</div>
			</form>
		<input type="text" class="row" id="hiddenVal" hidden="hidden" value="1"/>
		</div>
      <div class="modal-footer">
      <div id="init_btn_set">
        <button type="button" class="btn btn-default" data-dismiss="modal" id="drop_cancel">취소</button>
        <button type="button" class="btn btn-primary" id="drop_confirm">확인</button>
       </div>
       <div id="final_btn_set" hidden="hidden">
        <button type="button" class="btn btn-success" id="final_drop_btn" data-dismiss="modal">확인</button>
        </div>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

