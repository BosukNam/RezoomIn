<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Modal -->
	<div class="modal fade" id="major-role" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="myModalLabel">주요 역할 및 담당</h3>
				</div>
				
				
				<div class="modal-body">
					<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title" style="text-align: center">주요 역할 및 담당</h3>
							</div>
							<div class="panel-body" value="0" id="set-project-role-and-task">
								<textarea class="form-control" rows="1" id="project-role-text"></textarea>
								<textarea class="form-control" rows="10" id="project-task-text"></textarea>
								<button type="button" class="btn btn-primary" id="major-role-savebtn">저장</button>
								<button type="button" class="btn btn-default" id="major-role-cancel">삭제</button>
							</div>
						</div>
				</div>
			</div>
		</div>
	</div>
<!--End modal -->