<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

	<!-- Modal -->
	<div class="modal fade" id="activity_modal" tabindex="-1" role="dialog"
		aria-labelledby="activity_modal_label" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="activity_modal_label">대외 활동</h3>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="activity-form">
						<input type="hidden" name="registerNo" id="activity_key" value=''>
						<div class="form-group">
							<label for="activityCategory" class="col-md-2 control-label">구분</label>
							<div class="col-md-4">
								<select class="form-control" id="activity_category_code" name="categoryCode">
								  <c:forEach var="category" items="${requestScope.activityCategory }">
								  	<option value="${category.key }">${category.value.category}</option>
								  </c:forEach>
								</select>
								<input type="text" hidden="hidden" name="category" id="activity_category"/>
							</div>
						</div>
						<div class="form-group">
							<label for="activityDate" class="col-md-2 control-label">활동기간</label>
						<div class="col-md-9">
							<div class="input-group input-daterange">
									<input type="text" class="form-control year-month-picker" name="startDate" id="activityDate1"
										placeholder="활동기간을 선택해주세요"> <span class="input-group-addon">~</span>
									<input type="text" class="form-control year-month-picker" name="endDate" id="activityDate2"
										placeholder="활동기간을 선택해주세요">
								</div>
								
							</div>
						</div>
						<div class="form-group">
							<label for="activityContent" class="col-md-2 control-label">내용</label>
							<div class="col-md-9">							
							<textarea class="form-control" rows="5" name="content" id="activityContent"></textarea>
							</div>
						</div>
					</form>
					<input type="hidden" name="activity_type" id="activity_type" value=''>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" id="save-activity-btn">저장</button>
 				</div>
			</div>
		</div>
	</div>
