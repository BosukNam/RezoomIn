<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Modal -->
	<div class="modal fade" id="system-architecture-form" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<input type = "hidden" id="system_architecture_hidden" value="-1">
					<h3 class="modal-title" id="system-architecture name">시스템 환경</h3>
				</div>
				<div class="modal-body">
					<div class="form-group">
							<label class="col-md-3 control-label">시스템 환경 : </label>
							<div class="col-md-9">
								<div class="col-md-6">
									<select name="config-select" id="config-select" size=1>
										<option value="0">환경 선택</option>
										<option value="ti1">Standard</option>
										<option value="ti2">2 tier</option>
										<option value="ti3">multi tier</option>
									</select>
								</div>
							</div>
					</div>
					<br><br>
					<div class="form-group" id="client-tier">
							<label class="col-md-3 control-label">클라이언트 환경  : </label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="client-config"
									id="client-config" placeholder="Tool을 작성 해주세요.">	
							</div>
					</div>
					<br><br>
					<div class="form-group" id="2-tier">
							<label class="col-md-3 control-label">시스템 환경 : </label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="system-config"
									id="system-config" placeholder="Tool을 작성 해주세요.">
							</div>
					</div>
					<br><br>
					<div class="form-group" id="multi-tier">
							<label class="col-md-3 control-label">미들 웨어 : </label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="middle-config"
									id="middle-config" placeholder="Tool을 작성 해주세요.">
							</div>
					</div>
				</div>
				<br><br>
				<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="saveBtn_system_architecture">저장</button>
				<button type="button" class="btn btn-default" id="cancelBtn_system_architecture" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
<!--End modal -->