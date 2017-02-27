<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

	<!-- Modal -->
	<div class="modal fade" id="school_info_modal" tabindex="-1" role="dialog"
		aria-labelledby="school_info_modal_label" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="school_info_modal_label">학력사항</h3>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="school_form">
					<input type="hidden" name="type" id="school_type" value="">
					<input type="hidden" name="resume_category" id="school_category" value="school">
					<input type="hidden" name="school_registerNo" id="school_registerNo">
						<div class="form-group">
							<label for="schoolCategory" class="col-md-2 control-label">분류</label>
							<div class="col-md-4">
								<select class="form-control" id="schoolCategory"
									name="category">
									<option selected="selected" value='choice' disabled="disabled">분류를 선택해주세요</option>
									<c:forEach var="item" items="${requestScope.schoolCategory}">
										<option value="${item.categoryCode}/${item.category}">${item.category}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group" id="schoolForm">
							<label for="school" class="col-md-2 control-label">학교명</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="name"
									id="school" placeholder="학교명을 입력해주세요">
							</div>
							<div id="schoolAreaForm">
								<label for="schoolArea" class="col-md-1 control-label">지역</label>
								<div class="col-md-4">
									<input type="text" class="form-control" name="location"
										id="schoolArea" placeholder="지역을 입력해주세요">
								</div>
							</div>
						</div>
						<div class="form-group" id="majorForm">
							<label for="highSchoolMajor" class="col-md-2 control-label">계열</label>
							<div class="col-md-4">
								<select class="form-control" id="highSchoolMajor"
									name="track">
									<option value='choice' disabled="disabled">---</option>
									<c:forEach var="item" items="${requestScope.schoolTrackCategory}">
										<option value="${item.trackCode}/${item.track}">${item.track}</option>
									</c:forEach>
								</select>
							</div>
							<label for="major" class="col-md-1 control-label">전공</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="major" id="major"
									placeholder="전공을 입력해주세요">
							</div>
						</div>
						<div class="form-group" id="gradeForm">
							<label for="schoolGrade" class="col-md-2 control-label">학점</label>
							<div class="col-md-4">
								<div class="input-group">
									<input type="text" class="form-control" id="grade" name="grade"
										placeholder="학점을 입력해주세요" aria-describedby="basic-addon2">
									<span class="input-group-addon" id="basic-addon2">/</span> <select
										class="form-control" id="schoolGradeTotal"
										name="totalGrade">
										<option value='choice'>---</option>
										<c:forEach var="item" items="${requestScope.schoolTotalGradeCategory}">
											<option value="${item.totalGradeCode}/${item.totalGrade}">${item.totalGrade}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group" id="stateDegreeForm">
							<label for="state" class="col-md-2 control-label">상태</label>
							<div class="col-md-4">
								<select class="form-control" id="state" name="state">
									<option value='choice'>---</option>
									<c:forEach var="item" items="${requestScope.schoolStateCategory}">
										<option value="${item.stateCode}/${item.state}">${item.state}</option>
									</c:forEach>
								</select>
							</div>
							<label for="degree" class="col-md-1 control-label">학위</label>
							<div class="col-md-4">
								<select class="form-control" id="degree" name="degree">
									<option value='choice' disabled="disabled">----</option>
									<c:forEach var="item" items="${requestScope.schoolDegreeCategory}">
										<option value="${item.degreeCode}/${item.degree}">${item.degree}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group" id="schoolDateForm">
							<label for="schoolDate" class="col-md-2 control-label">재학기간</label>
							<div class="col-md-9">
								<div class="input-group input-daterange">
									<input type="text" class="form-control year-month-picker" id="schoolDate1" name="startDate"
										placeholder="입학일을 선택해주세요"> <span class="input-group-addon">~</span>
									<input type="text" class="form-control year-month-picker" id="schoolDate2" name="endDate"
										placeholder="졸업일을 선택해주세요">
								</div>
							</div>
					
				</div>
			</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" id="save_school_btn">저장</button>
				</div>
			</div>
		</div>
	</div>
