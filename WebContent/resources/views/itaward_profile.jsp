<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- Modal -->
	<div class="modal fade" id="awards-modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="myModalLabel">수상경력</h3>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label for="award-category" class="col-md-3 control-label">분류</label>
							<div class="col-md-6">
								<select class="form-control" id="award-category" name="award-category">
								  <option>IT수상</option>
								  <option>기타수상</option>
								</select>
							</div>
						</div>
						<div class="form-group" id="award-field">
							<label for="award-field" class="col-md-3 control-label">분야</label>
							<div class="col-md-6">
								<select class="form-control" name="award-field">
								  <option>동적으로</option>
								  <option>받아와야</option>
								  <option>하는부분</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="certificate" class="col-md-3 control-label">수상명</label>
							<div class="col-md-6">
								<input type="text" class="form-control" name="certificate"
									id="certificate" placeholder="수상명을 입력해주세요">
							</div>
						</div>
						<div class="form-group">
							<label for="certificateDate" class="col-md-3 control-label">수상날짜</label>
							<div class="col-md-6">
								<div class="input-group">
									<input type="text" class="form-control" value="수상날짜를 선택하세요" id="awards-date">
									<span class="input-group-addon" id="basic-addon2"> <span
										class="glyphicon glyphicon-th" id="examDate"></span>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="publication" class="col-md-3 control-label">주최기관</label>
							<div class="col-md-6">
								<input type="text" class="form-control" name="awardPublication"
									id="awardPublication" placeholder="주최기관을 입력해주세요">
							</div>
						</div>
						<div class="form-group">
							<label for="publication" class="col-md-3 control-label">수상내역</label>
							<div class="col-md-6">
								<input type="text" class="form-control" name="publication"
									id="publication" placeholder="수상내역을 입력해주세요">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" id="saveBtn">저장</button>
				</div>
			</div>
		</div>
	</div>
<!--End modal -->