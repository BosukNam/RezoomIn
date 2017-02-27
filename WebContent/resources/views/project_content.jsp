<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Modal -->
	<div class="modal fade" id="project-content" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="myModalLabel">프로젝트 내용</h3>
				</div>
				<div class="modal-body">
					<div class="panel-group" id="accordion2" role="tablist"
						aria-multiselectable="true">
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingFive">
								<h4 class="panel-title">
									<a  data-toggle="collapse" 
										data-parent="#accordion2" href="#collapseFive" 
										aria-expanded="false" aria-controls="collapseFive" id="useSkill-title"> 
										사용기술 언어 </a>
								</h4>
							</div>
							<div id="collapseFive" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingFive">
								<div class="panel-body">
									<div class="col-md-12" id="use-language">
									
									</div>
								</div>
								<button type="button" class="btn btn-primary" id="saveBtn_userSkill">저장</button>
								<button type="button" class="btn btn-default" id="cancelBtn_userSkill">취소</button>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingSix">
								<h4 class="panel-title">
									<a class="collapsed" data-toggle="collapse"
										data-parent="#accordion2" href="#collapseSix"
										aria-expanded="false" aria-controls="collapseSix" id="library-title">
										라이브러리(Framework)</a>
								</h4>
							</div>
							<div id="collapseSix" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingSix">
								<div class="panel-body">
									<input type = "hidden" id="library_hidden" value="-1">
									<textarea class="form-control" rows="10" id="library-content-text"></textarea>
									<label class="btn btn-default btn-file"> 파일 선택 <input type="file" class="hidden" id="library-img-upload" accept="image/gif, image/jpeg, image/png" name="library-img-upload"></label>
									<button type="button" class="btn btn-primary" id="saveBtn_library_img">저장</button>
									<button type="button" class="btn btn-default" id = "cancelBtn_library">취소</button>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingSeven">
								<h4 class="panel-title">
									<a class="collapsed" data-toggle="collapse"
										data-parent="#accordion2" href="#collapseSeven"
										aria-expanded="false" aria-controls="collapseSeven">
										UML(설계문서) </a>
								</h4>
							</div>
							<div id="collapseSeven" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingSeven">
								<div class="panel-body">
										<div class="col-md-6"><button type="button" class="btn btn-danger" id="system-architecture-btn">System Architecture(시스템 환경)</button></div>
										<div class="col-md-6"><button type="button" class="btn btn-primary" id="software-architecture-btn">Software Architecture(프로그램 설계)</button></div>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingEight">
								<h4 class="panel-title">
									<a class="collapsed" data-toggle="collapse"
										data-parent="#accordion2" href="#collapseEight"
										aria-expanded="false" aria-controls="collapseEight" id="pc2">
										사용자 정의 내용 </a>
										<!-- <span class="glyphicon glyphicon-plus-sign" aria-hidden="true"
									id="develop-plus"></span> -->
								</h4>
							</div>
							<div id="collapseEight" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingEight">
								<div class="panel-body" id="set-project-user-defined" value="0">
									<textarea class="form-control" rows="10" id="user-defined-content"></textarea>
									<label class="btn btn-default btn-file"> 파일 선택 <input type="file" class="hidden" id="selectBtn"></label>
									<button class="btn btn-default chart-btn" value="projectContent">
									<img alt="" src="http://image.flaticon.com/icons/svg/265/265733.svg" width="20px" height="20px"></button>
									<button type="button" class="btn btn-primary" id="btn-content-save">저장</button>
									<button type="button" class="btn btn-default" data-dismiss="" id="btn-content-cancle">취소</button>
									<input type="text" id="image_path_pc2" hidden="hidden">
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<!--End modal -->
