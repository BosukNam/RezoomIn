<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

	<!-- Modal -->
	<div class="modal fade" id="military_modal" tabindex="-1" role="dialog"
		aria-labelledby="military_modal_label" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="military_modal_label">병역사항</h3>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="military_form" name="military_form" method="POST">
						<input type="hidden" name="type" id="military_type" value="">
						<input type="hidden" name="resume_category" id="military_category" value="military">
						<div class="form-group">
							<label for="military-select" class="col-md-2 control-label">병역구분</label>
							<div class="col-md-3">
								<select class="form-control" id="military-select" name="pass">
								  <option selected="selected">필</option>
								  <option>미필</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label for="militaryDate" class="col-md-2 control-label">복무기간</label>
							<div class="col-md-9">
								<div class="input-group input-daterange">
									<input type="text" class="form-control year-month-picker" name="startDate"  id="militaryDate1"
										placeholder="복무기간을 선택해주세요"> <span class="input-group-addon">~</span>
									<input type="text" class="form-control year-month-picker" name="endDate"  id="militaryDate2"
										placeholder="복무기간을 선택해주세요">
								</div>
							</div>
						</div>
						<div class="form-group">
								<label for="militaryCategory" class="col-md-2 control-label">군별구분</label>
								<div class="col-md-3">
									<select class="form-control" id="militaryCategory" name="category">
									  <option>---</option>
									  <c:forEach var="item" items="${requestScope.militaryCategory}">
									  	<option value="${item.categoryCode}/${item.category}">${item.category}</option>
									  </c:forEach>
									</select>
								</div>
								<label for="militaryClass" class="col-md-3 control-label">계급</label>
								<div class="col-md-3">
									<select class="form-control" id="militaryClass" name="rank">
									  <option>---</option>
									  <c:forEach var="item" items="${requestScope.militaryRankCategory}">
									  	 <option value="${item.rankCode}/${item.rank}">${item.rank}</option>
									   </c:forEach>
									</select>
								</div>
							</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" id="save-military-btn">저장</button>

				</div>
			</div>
		</div>
	</div>
