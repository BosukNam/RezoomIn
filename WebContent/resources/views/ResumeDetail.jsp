<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Modal -->
<c:set var="path" value="${pageContext.request.contextPath }" />
<div class="modal fade" id="preview_resume_modal" tabindex="-1"
	role="dialog" aria-labelledby="preview_resume_modal_label"
	aria-hidden="true">
	<div class="modal-dialog modal_fullsize">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>

				<h3 class="modal-title" id="preview_resume_modal_label">이력서
					미리보기</h3>
			</div>
			<div class="modal-body">
				<div class="container">
					<div class="resume">
						<div class="resume_header">
							<!-- 
				<div class="resume_title">이력서</div> -->
						</div>
					</div>
					<div class="container">
						<div class="row">
							<div
								class="col-xs-12 col-sm-12 col-md-offset-1 col-md-10 col-lg-offset-2 col-lg-8">
								<div class="resume_title">이력서</div>
								<div class="panel panel-default">
									<div class="panel-heading resume_heading">
										<div class="row">
											<div class="col-lg-12">
												<div class="col-xs-12 col-sm-4 col-md-4">
													<figure class="profile_image">
														<img class="img-circle img-responsive"
															src="http://placehold.it/300x300">
													</figure>
												</div>
												<div class="col-xs-12 col-sm-8 col-md-8 resume_personinfo">
													<ul class="list-group">
														<li class="list-group-item"><img
															src="${path}/resources/images/icons/user.png" width="32"
															height="32"> 오메이징</li>
														<li class="list-group-item"><img
															src="${path}/resources/images/icons/cake.png" width="32"
															height="32"> 생일</li>
														<li class="list-group-item"><img
															src="${path}/resources/images/icons/email.png" width="32"
															height="32"> 이메일</li>
														<li class="list-group-item"><img
															src="${path}/resources/images/icons/cell.png" width="32"
															height="32"> 연락처</li>
														<li class="list-group-item"><img
															src="${path}/resources/images/icons/house.png" width="32"
															height="32"> 주소</li>
													</ul>
												</div>
											</div>
										</div>
									</div>
									<div class="button_set" id="resume_button_set">
										<div>
											<label for="totalview_check"
												class="btn btn-success col-md-12">전체보기 <input
												type="checkbox" id="totalview_check" class="badgebox" checked><span
												class="badge">&check;</span>
											</label><label for="timeline_check" class="btn btn-primary">타임라인
												<input type="checkbox" id="timeline_check" class="badgebox"><span
												class="badge">&check;</span>
											</label><label for="school_check" class="btn btn-primary">학력사항
												<input type="checkbox" id="school_check" class="badgebox"><span
												class="badge">&check;</span>
											</label> <label for="career_check" class="btn btn-primary">경력
												<input type="checkbox" id="career_check" class="badgebox"><span
												class="badge">&check;</span>
											</label><label for="language_exam_check"
												class="btn btn-primary com-md-2">어학 시험 <input
												type="checkbox" id="language_exam_check" class="badgebox"><span
												class="badge">&check;</span>
											</label><label for="certificate_check"
												class="btn btn-primary com-md-2">자격증 <input
												type="checkbox" id="certificate_check" class="badgebox"><span
												class="badge">&check;</span>
											</label><label for="awards_check" class="btn btn-primary">수상
												경력 <input type="checkbox" id="awards_check" class="badgebox"><span
												class="badge">&check;</span>
											</label><label for="foreign_study_check"
												class="btn btn-primary com-md-2">해외 연수 <input
												type="checkbox" id="foreign_study_check" class="badgebox"><span
												class="badge">&check;</span>
											</label><label for="military_check" class="btn btn-primary">병역
												사항 <input type="checkbox" id="military_check"
												class="badgebox"><span class="badge">&check;</span>
											</label><label for="activity_check" class="btn btn-primary">봉사
												/ 대외 활동 <input type="checkbox" id="activity_check"
												class="badgebox"><span class="badge">&check;</span>
											</label><label for="unusual_check" class="btn btn-primary">보훈
												/ 장애 여부 <input type="checkbox" id="unusual_check"
												class="badgebox"><span class="badge">&check;</span>
											</label>
										</div>
									</div>
									
									<div class="resume_contents" id="timeline_preview">
										<h3>타임라인</h3>
										<div class="container resume_timeline">
											<div class="row">
												<div class="timeline">
													<div class="period">2010</div>
													<div class="period">2011</div>
													<div class="period">2012</div>
													<div class="period">2013</div>
													<div class="period">2014</div>
													<div class="period">2015</div>
													<div class="period">2016</div>
													<div class="period">2017</div>
													<div class="period">2018</div>
													<div class="period">2019</div>
												</div>
											</div>
											<div class="row">
												<div class="timeline_school"
													style="height: 20px; width: 40%; background-color: rgb(30, 40, 50); margin-left: 120px;"
													data-container="body" data-toggle="popover"
													data-placement="left" title="고등학교"
													data-content="2012.01 ~ 2016.12"></div>
												<div class="timeline_school"
													style="height: 25px; width: 20%; position: absolute; background-color: rgb(80, 140, 140); margin-left: 200px;"
													data-container="body" data-toggle="popover"
													data-placement="left" title="대학교"
													data-content="2013.03 ~ 2015.10"></div>
											</div>
										</div>
									</div>
									<div class="resume_contents" id="school_preview">
										<h3>학력사항</h3>
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item"><img
													src="${path}/resources/images/icons/school.png" width="32"
													height="32"> 고등학교명</li>
												<li class="list-group-item">기간</li>
											</ul>
										</div>
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item"><img
													src="${path}/resources/images/icons/university.png"
													width="32" height="32"> 대학교명</li>
												<li class="list-group-item">기간</li>
											</ul>
										</div>
									</div>
									<div class="resume_contents" id="career_preview">
										<h3>경력</h3>
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item"><img
													src="${path}/resources/images/icons/bag.png" width="32"
													height="32"> 회사명1</li>
												<li class="list-group-item">기간</li>
											</ul>
										</div>
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item"><img
													src="${path}/resources/images/icons/bag.png" width="32"
													height="32"> 회사명2</li>
												<li class="list-group-item">기간</li>
											</ul>
										</div>
									</div>
									<div class="resume_contents" id="language_exam_preview">
										<h3>어학 시험</h3>
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item"><img
													src="${path}/resources/images/icons/translate.png"
													width="32" height="32"> 시험명1</li>
												<li class="list-group-item">취득일</li>
												<li class="list-group-item">점수 / 등급</li>
											</ul>
										</div>
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item"><img
													src="${path}/resources/images/icons/translate.png"
													width="32" height="32"> 시험명2</li>
												<li class="list-group-item">취득일</li>
												<li class="list-group-item">점수 / 등급</li>
											</ul>
										</div>
									</div>
									<div class="resume_contents" id="certificate_preview">
										<h3>자격증</h3>
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item">자격증명1</li>
												<li class="list-group-item">취득일</li>
												<li class="list-group-item">발행처</li>
											</ul>
										</div>
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item">자격증명2</li>
												<li class="list-group-item">취득일</li>
												<li class="list-group-item">발행처</li>
											</ul>
										</div>
									</div>
									<div class="resume_contents" id="awards_preview">
										<h3>수상 경력</h3>
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item"><img
													src="${path}/resources/images/icons/Award.png" width="32"
													height="32">수상명1</li>
												<li class="list-group-item">수상날짜1</li>
												<li class="list-group-item">수여기관1</li>
												<li class="list-group-item">수상내역1</li>
											</ul>
										</div>
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item"><img
													src="${path}/resources/images/icons/Award.png" width="32"
													height="32">수상명2</li>
												<li class="list-group-item">수상날짜2</li>
												<li class="list-group-item">수여기관2</li>
												<li class="list-group-item">수상내역2</li>
											</ul>
										</div>
									</div>
									<div class="resume_contents" id="foreign_study_preview">
										<h3>해외연수</h3>
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item"><img
													src="${path}/resources/images/icons/Airplane.png"
													width="32" height="32">체류기간1</li>
												<li class="list-group-item">내용1</li>
											</ul>
										</div>
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item"><img
													src="${path}/resources/images/icons/Airplane.png"
													width="32" height="32">체류기간1</li>
												<li class="list-group-item">내용1</li>
											</ul>
										</div>
									</div>
									<div class="resume_contents" id="military_preview">
										<h3>병역사항</h3>
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item">병역구분1</li>
												<li class="list-group-item">기간1</li>
											</ul>
										</div>
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item">병역구분1</li>
												<li class="list-group-item">기간1</li>
											</ul>
										</div>
									</div>
									<div class="resume_contents" id="activity_preview">
										<h3>봉사 / 대외 활동</h3>
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item"><img
													src="${path}/resources/images/icons/help.png" width="32"
													height="32">봉사1</li>
												<li class="list-group-item">활동 기간1</li>
												<li class="list-group-item">내용1</li>
											</ul>
										</div>
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item">봉사2</li>
												<li class="list-group-item">활동 기간2</li>
												<li class="list-group-item">내용2</li>
											</ul>
										</div>
									</div>
									<div class="resume_contents" id="unusual_preview">
										<h3>보훈 / 장애 여부</h3>
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item">보훈 대상1</li>
												<li class="list-group-item">비장애1</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<script>
					$(function() {
						// 초기 버튼 모두 체크상태
						$('#resume_button_set input').prop('checked',true);
						$('#resume_button_set input').attr('checked',true);
						$('.timeline_school').hover(function() {
							$(this).popover('show');
						}, function() {
							$(this).popover('hide');
						});
						// 전체 보기 버튼
						$('#totalview_check').change(function(){
							if($(this).prop('checked') == true){
								$('#resume_button_set input').prop('checked',true);
								$('.resume_contents').show();
							}else{
								$('#resume_button_set input').prop('checked',false);
								$('.resume_contents').hide();
							}
							/* $('.button_set input').addClass() */
						});
						$('#resume_button_set input').change(function(){
							// 하나라도 해제시 전체보기 버튼 unchecked로
							if($(this).prop('checked') == false){
								$('#totalview_check').prop('checked',false);
							}
							if( $("#resume_button_set input:checked").length + 1 ==  $("#resume_button_set input").length){
								$('#totalview_check').prop('checked', true);
							}
						});
						// 타임라인 버튼
						$('#timeline_check').change(function() {
							if ($(this).prop('checked') == true) {
								$('#timeline_preview').show();
							} else {
								$('#timeline_preview').hide();
							}
						});
						// 학력사항 버튼
						$('#school_check').change(function() {
							if ($(this).prop('checked') == true) {
								// 학력사항 버튼 on
								$('#school_preview').show();
							} else {
								// 학력사항 버튼 off
								$('#school_preview').hide();
							}
						})
						// 경력 버튼
						$('#career_check').change(function() {
							if ($(this).prop('checked') == true) {
								
								$('#career_preview').show();
							} else {
								
								$('#career_preview').hide();
							}
						})
						// 어학 시험 버튼
						$('#language_exam_check').change(function() {
							if ($(this).prop('checked') == true) {
								
								$('#language_exam_preview').show();
							} else {
								
								$('#language_exam_preview').hide();
							}
						})
						// 자격증 버튼
						$('#certificate_check').change(function() {
							if ($(this).prop('checked') == true) {
	
								$('#certificate_preview').show();
							} else {
								
								$('#certificate_preview').hide();
							}
						})
						// 수상 경력 버튼
						$('#awards_check').change(function() {
							if ($(this).prop('checked') == true) {
								// 수상 경력 버튼 on
								$('#awards_preview').show();
							} else {
								// 수상 경력 버튼 off
								$('#awards_preview').hide();
							}
						})
						// 해외 연수 버튼
						$('#foreign_study_check').change(function() {
							if ($(this).prop('checked') == true) {
								// 해외 연수 버튼 on
								$('#foreign_study_preview').show();
							} else {
								// 해외 연수 버튼 off
								$('#foreign_study_preview').hide();
							}
						})
						// 병역 사항 버튼
						$('#military_check').change(function() {
							if ($(this).prop('checked') == true) {
								// 병역 사항 버튼 on
								$('#military_preview').show();
							} else {
								// 병역 사항 버튼 off
								$('#military_preview').hide();

							}
						})
						// 봉사 / 대외 활동 버튼
						$('#activity_check').change(function() {
							if ($(this).prop('checked') == true) {
								// 봉사 / 대외 활동 버튼 on
								$('#activity_preview').show();
							} else {
								// 봉사 / 대외 활동 버튼 off
								$('#activity_preview').hide();

							}
						})
						// 보훈 / 장애 여부 버튼
						$('#unusual_check').change(function() {
							if ($(this).prop('checked') == true) {
								// 보훈 / 장애 여부 버튼 on
								$('#unusual_preview').show();
							} else {
								// 보훈 / 장애 여부 버튼 off
								$('#unusual_preview').hide();
							}
						})
					});
				</script>
			</div>
		</div>
	</div>
</div>
<!--End modal -->

