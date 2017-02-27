<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Modal -->
	<div class="modal fade" id="intro" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="myModalLabel">개 요</h3>
				</div>
				<div class="modal-body">
					<div class="panel-group" id="accordion" role="tablist"
						aria-multiselectable="true">
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingOne">
								<h4 class="panel-title">
									<a  data-toggle="collapse" 
										data-parent="#accordion" href="#collapseOne" 
										aria-expanded="false" aria-controls="collapseOne" id="pc1"> 
										프로그램 소개 </a>
								</h4>
							</div>
							<div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
								<div class="panel-body" value="0" id="set-project-project-intro">
									<textarea class="form-control" rows="10" id="program-intro-text"></textarea>
									<label class="btn btn-default btn-file"> 파일 선택 <input type="file" class="hidden" id="selectBtn"></label>
									<button class="btn btn-default chart-btn" value="pc1">
										<img alt="" src="http://image.flaticon.com/icons/svg/265/265733.svg" width="20px" height="20px">
									</button>
									<button type="button" class="btn btn-primary" id="program-intro-save">저장</button>
									<button type="button" class="btn btn-default" id="program-intro-delete">삭제</button>
									<input type="text" id="image_path_pc1" hidden="hidden">
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingTwo">
								<h4 class="panel-title">
									<a class="collapsed" data-toggle="collapse"
										data-parent="#accordion" href="#collapseTwo"
										aria-expanded="false" aria-controls="collapseTwo" id="project_date">
										프로젝트 기간 </a>
								</h4>
							</div>
							<div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
								<div class="panel-body" value="0" id="set-project-date">
										기간 입력:
										<input type="text" size="12" id="program-term-start"> ~ 
										<input type="text" size="12" id="program-term-end"> 
										<button type="button" class="btn btn-primary" id="program-term-save">저장</button>
										<button type="button" class="btn btn-default" id="program-term-cancel">삭제</button>
									
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingThree">
								<h4 class="panel-title">
									<a class="collapsed" data-toggle="collapse"
										data-parent="#accordion" href="#collapseThree"
										aria-expanded="false" aria-contㅇrols="collapseThree" id="project_people_no">
										인 원 </a>
								</h4>
							</div>
							<div id="collapseThree" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingThree">
								<div class="panel-body" value="0", id="set-project-people-no">
									인원 수 입력 : 
									<input type="number" min=1 id="people-number">
									<button type="button" class="btn btn-primary" id="people-number-save">저장</button>
									<button type="button" class="btn btn-default" id="people-number-cancel">삭제</button>
								</div>
							</div>
						</div>
						<div class="panel panel-default">
							<div class="panel-heading" role="tab" id="headingFour">
								<h4 class="panel-title">
									<a class="collapsed" data-toggle="collapse"
										data-parent="#accordion" href="#collapseFour"
										aria-expanded="false" aria-controls="collapseFour" id="project_develop_tool_no">
										개 발 툴 </a>
								</h4>
							</div>
							<div id="collapseFour" class="panel-collapse collapse"
								role="tabpanel" aria-labelledby="headingFour">
								<div class="panel-body" value="0" id="set-project-develop-tool">
									<div class="form-group">
										<div class="col-md-12" id="use-tool">
										</div>
									</div><br>
									<button type="button" class="btn btn-primary" id="develop-tool-save" >저장</button>
									<button type="button" class="btn btn-default" id="develop-tool-reset">초기화</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
<!--End modal -->
