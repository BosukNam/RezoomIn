<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
	<!-- Modal -->
	<div class="modal fade" id="career_modal" tabindex="-1" role="dialog"
		aria-labelledby="career_modal_label" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="career_modal_label">경력사항</h3>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="career-form">
					<input type="hidden" name="registerNo" id="career_key" value=''> 						
						
						<div class="form-group">
							<label for="company" class="col-md-2 control-label">회사명</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="name"
									id="company" placeholder="회사명을 입력해주세요">
							</div>
						</div>

						<div class="form-group">
							<label for="companyDate" class="col-md-2 control-label">기간</label>
							<div class="col-md-9">
								<div class="input-group input-daterange">
									<input type="text" class="form-control year-month-picker" id="companyDate1" name="startDate"
										placeholder="경력기간을 선택해주세요"> <span class="input-group-addon">~</span>
									<input type="text" class="form-control year-month-picker" id="companyDate2" name="endDate"
										placeholder="경력기간을 선택해주세요">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="CompanyPostion" class="col-md-2 control-label">직급</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="position"
										id="companyPosition" placeholder="직급을 입력해주세요">
							</div>
							<label for="companyDepartment" class="col-md-1 control-label">부서</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="department"
									id="companyDepartment" placeholder="부서를 입력해주세요">
							</div>
						</div>
						<div class="form-group">
							<label for="companyTask" class="col-md-2 control-label">담당업무</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="task"
									id="companyTask" placeholder="담당업무를 입력해주세요">
							</div>
							<label for="retirementReason" class="col-md-1 control-label">퇴직사유</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="retirementReason"
									id="retirementReason" placeholder="퇴직사유를 입력해주세요">
							</div>
						</div>

					</form>
					<input type="hidden" name="career_type" id="career_type" value=''>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" id="save-career-btn">저장</button>
				</div>
			</div>
		</div>
	</div>
