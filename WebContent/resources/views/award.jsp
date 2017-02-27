<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

	<!-- Modal -->
	<div class="modal fade" id="award_modal" tabindex="-1" role="dialog"
		aria-labelledby="award_modal_label" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="award_modal_label">수상경력</h3>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="award-form">
					
					<input type="hidden" name="registerNo" id="award_key" value=''>

	
						<div class="form-group">
							<label for="award-category" class="col-md-3 control-label">분류</label>
							<div class="col-md-6">
								<select class="form-control" id="award-category" name="categoryCode">
								  <c:forEach var="category" items="${awardCategory}">
								  <option value="${category.key}">${category.value.category}</option>
								  </c:forEach>
								</select>
								<input type="hidden" name="category" id="award-category-val" value=""/>
							</div>
						</div>
						<div class="form-group" id="award-field-form">
							<label for="award-field" class="col-md-3 control-label">분야</label>
							<div class="col-md-6">
							<select class="form-control" name="fieldCode" id="award-field">
 							<c:forEach var="field" items="${requestScope.awardField }">
								<option value="${field.key }">${field.value.field }</option>
							</c:forEach>
							</select>
							<input type="hidden" name="field" id="award-field-val" value=""/>
							</div>
						</div>
						<div class="form-group" id="award-target">
							<label for="award-target" class="col-md-3 control-label">수상자</label>
							<div class="col-md-6">
									<input type="text" class="form-control" name="target"
									id="award-target" placeholder="수상자(개인명/팀명)를 입력해주세요">
							</div>
						</div>
						<div class="form-group">
							<label for="award-name" class="col-md-3 control-label">수상명</label>
							<div class="col-md-6">
								<input type="text" class="form-control" name="name"
									id="award-name" placeholder="수상명을 입력해주세요">
							</div>
						</div>
						<div class="form-group">
							<label for="award-date" class="col-md-3 control-label">수상날짜</label>
							<div class="col-md-6">
								<div class="input-group">
									<input type="text" class="form-control year-month-picker" placeholder="수상날짜를 선택하세요"
									id="award-date" name="date">
									<span class="input-group-addon" id="basic-addon2"> <span
										class="glyphicon glyphicon-th"></span>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="award-publication" class="col-md-3 control-label">주최기관</label>
							<div class="col-md-6">
								<input type="text" class="form-control" name="publication"
									id="award-publication" placeholder="주최기관을 입력해주세요">
							</div>
						</div>
						<div class="form-group">
							<label for="award-content" class="col-md-3 control-label">수상내역</label>
							<div class="col-md-6">
								<input type="text" class="form-control" name="content"
									id="award-content" placeholder="수상내역을 입력해주세요">
							</div>
						</div>
					</form>
					<input type="hidden" name="career_type" id="award_type" value=''>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" id="cancel_award_btn">취소</button>
					<button type="button" class="btn btn-primary" id="save-award-btn">저장</button>
				</div>
			</div>
		</div>
	</div>

