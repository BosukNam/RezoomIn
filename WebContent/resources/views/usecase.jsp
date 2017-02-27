<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Modal -->
	<div class="modal fade" id="usecase-form" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<input type = "hidden" id="usecase_file_hidden" value="-1">
					<input type = "hidden" id="usecase_hidden" value="-1">
					<h3 class="modal-title" id="usecase">유즈케이스</h3>
				</div>
				<div class="modal-body">
					<div class="form-group">
							<label class="col-md-3 control-label">Case 선택  : </label>
							<div class="col-md-9">
								<div class="col-md-6">
									<select name="usecase-select" id="usecase-select" size=1>
										<option value="0">케이스 분류</option>
										<option value="case1">Case 1</option>
										<option value="case2">Case 2</option>
										<option value="case3">Case 3</option>
										<option value="case4">Case 4</option>
									</select>
								</div>
							</div>
					</div>
					<br><br>
					<div class="form-group" id="actor_div">
							<label class="col-md-3 control-label">Actor  : </label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="actor"
									id="actor" placeholder="Actor을 작성 해주세요.">	
							</div>
					</div>
					<br><br>
					<div class="form-group" id="case1_div">
							<label class="col-md-3 control-label">Case 1 : </label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="case1"
									id=case1 placeholder="case1을 작성 해주세요.">
							</div>
					</div>
					<br><br>
					<div class="form-group" id="case2_div">
							<label class="col-md-3 control-label">Case 2 : </label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="case2"
									id="case2" placeholder="case2을 작성 해주세요.">
							</div>
					</div>
					<br><br>
					<div class="form-group" id="case3_div">
							<label class="col-md-3 control-label">Case 3 : </label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="case3"
									id="case3" placeholder="case3을 작성 해주세요.">
							</div>
					</div>
					<br><br>
					<div class="form-group" id="case4_div">
							<label class="col-md-3 control-label">Case 4 : </label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="case4"
									id=case4 placeholder="case4을 작성 해주세요.">
							</div>
					</div>
					
				</div>
				<br><br>
				<div class="modal-footer">
				<button type="button" class="btn btn-primary" id="saveBtn_usecase">저장</button>
				<button type="button" class="btn btn-default" id="cancelBtn_usecase" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
<!--End modal -->