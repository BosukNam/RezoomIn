<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Modal -->
	<div class="modal fade" id="software-architecture-form" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="software-architecture name">소프트웨어 환경(설계 구조)</h3>
				</div>
				<div class="modal-body">
				<div class="form-group">
							<label class="col-md-6 control-label">유즈 케이스  : </label>
							<div class="col-md-6">
								 <button type="button" class="btn btn-default" id="usercase-register">작성하기</button>
							</div>
					</div>
					<br><br>
					<div class="form-group">
							<label class="col-md-6 control-label">다이어그램 : </label>
							<div class="col-md-6">
								<label class="btn btn-default btn-file"> 파일 선택 <input type="file" class="hidden" id="diagram-Btn" accept="image/gif, image/jpeg, image/png"></label>
							</div>
					</div>
				</div>
				<br><br>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="saveBtn_software_architecture">저장</button>
					<button type="button" class="btn btn-default" id="cancelBtn_software_architecture" data-dismiss="modal">취소</button>
					
				</div>
			</div>
		</div>
	</div>
<!--End modal -->