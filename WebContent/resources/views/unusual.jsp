<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html5>
	<!-- Modal -->
	<div class="modal fade" id="unusual_modal" tabindex="-1" role="dialog"
		aria-labelledby="unusual_modal_label" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="unusual_modal_label">보훈 · 장애사항</h3>
				</div>
				<div class="modal-body">
				<form class="form-horizontal" id="unusual_form">
				<input type="hidden" name="type" id="unusual_type" value="">
				<input type="hidden" name="resume_category" id="unusual_category" value="unusual">
				
						<div class="form-group">
							<label for="isRewarded" class="col-md-3 control-label">보훈대상여부</label>
							<div class="col-md-3">
								<select class="form-control" id="isRewarded" name="isRewarded">
								  <option>해당사항 없음</option>
								  <option>대상</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="isDisabled" class="col-md-3 control-label">장애대상여부</label>
							<div class="col-md-3">
								<select class="form-control" id="isDisabled" name="isDisabled">
								  <option>해당사항 없음</option>
								  <option>대상</option>
								</select>
							</div>
							<label for="disabilityClass" class="col-md-2 control-label">장애급수</label>
							<div class="col-md-2">
								<select class="form-control" id="disabilityClass" name="disability" disabled>
								  <option>---</option>
								  <c:forEach var="item" items="${requestScope.unusualCategory}">
								  	<option value="${item.disabilityCode}/${item.disability}">${item.disability}</option>
								  </c:forEach>
								</select>
							</div>
						</div>

					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" id="save-unusual-btn">저장</button>
				</div>
			</div>
		</div>
	</div>
