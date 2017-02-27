<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

	<!-- Modal -->
	<div class="modal fade" id="foreignStudy_modal" tabindex="-1" role="dialog"
		aria-labelledby="foreignStudy_modal_label" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="foreignStudy_modal_label">해외 연수</h3>
				</div>
				<div class="modal-body">
					<form class="form-horizontal"  id="foreign-form">
						<input type="hidden" name="registerNo" id="foreignStudy_key" value=''>
						<input type="hidden" id="foreignCategory" name="category" value="해외 연수">
						<input type="hidden" id="foreign_category_code" name="categoryCode" value="${requestScope.foreignCategory.categoryCode}"/>
						<div class="form-group">
							<label for="foreignDate" class="col-md-2 control-label">체류기간</label>
						<div class="col-md-9">
							<div class="input-group input-daterange">
									<input type="text" class="form-control year-month-picker" name="startDate"
										placeholder="체류기간을 선택해주세요" id="foreinDate1"> <span class="input-group-addon">~</span>
									<input type="text" class="form-control year-month-picker" name="endDate"
										placeholder="체류기간을 선택해주세요"  id="foreinDate2">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="foreignContent" class="col-md-2 control-label">내용</label>
							<div class="col-md-9">							
							<textarea class="form-control" rows="5" name="content" id="foreignContent"></textarea>
							</div>
						</div>
					</form>
					<input type="hidden" name="activity_type" id="foreignStudy_type" value=''>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" id="cancel_foreign_btn">취소</button>
					<button type="button" class="btn btn-primary" id="save-foreign-btn">저장</button>
				</div>
			</div>
		</div>
	</div>
