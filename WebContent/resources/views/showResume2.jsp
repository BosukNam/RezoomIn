<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!--부트스트랩  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.13/css/dataTables.bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker3.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!-- date picker -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/scripts/resumeModal.js"></script>
</head>
<style type="text/css">
.panel-body {
	height: 300px;
	overflow: hidden;
}

.timeline_school {
	height: 20px;
	width: 5%;
	position: absolute;
	background-color: rgb(80, 170, 120);
	margin-left: 10px;
	border-radius: 10px;
}

#resume_timeline .panel-body {
	height: 400px;
}

#timeline_container {
	margin-top: 200px;
	width: 600px;
}

.timeline {
	margin-top: 10px;
	margin-bottom: 10px;
	background-color: #425c7f;
	width: 600px;
	height: 18px;
	border-radius: 10px;
	color: #fff;
	font-size: 0;
	background-color: #425c7f;
}

.period {
	border-radius: 10px;
	width: 10%;
	margin-top: 0;
	box-sizing: border-box;
	display: inline-block;
	height: 18px;
	font-size: 14px;
	text-align: center;
	cursor: pointer;
}

.period-active {
	background-color: #afb4ba;
}

/*미리보기 모달 css  */
/* @font-face {
	font-family: 'Godo';
	font-style: normal;
	font-weight: 400;
	src:
		url('//cdn.jsdelivr.net/korean-webfonts/1/corps/godo/Godo/GodoM.woff2')
		format('woff2'),
		url('//cdn.jsdelivr.net/korean-webfonts/1/corps/godo/Godo/GodoM.woff')
		format('woff');
}

@font-face {
	font-family: 'Godo';
	font-style: normal;
	font-weight: 700;
	src:
		url('//cdn.jsdelivr.net/korean-webfonts/1/corps/godo/Godo/GodoB.woff2')
		format('woff2'),
		url('//cdn.jsdelivr.net/korean-webfonts/1/corps/godo/Godo/GodoB.woff')
		format('woff');
}

.godo * {
	font-family: 'Godo', sans-serif;
} */

/** 이하는 공통 **/
.normal {
	font-style: normal;
}

.w250 {
	font-weight: 250;
}

.w300 {
	font-weight: 300;
}

.w350 {
	font-weight: 350;
}

.w400 {
	font-weight: 400;
}

.w500 {
	font-weight: 500;
}

.w700 {
	font-weight: 700;
}

.w800 {
	font-weight: 800;
}

.w900 {
	font-weight: 900;
}

body {
	font-family: 'Godo'
}

#preview_resume_modal {
	font-family: 'Godo'
}
/*이력서 헤더  */
.resume_header {
	text-align: center;
}

.resume_title {
	text-align: center;
	color: #eeeeee;
	/* font-size: 20px; */
	padding-top:2px;
	height: 80px;
	border-radius: 5px;
	background-color: #b97711;
	border: 0px;
}

.resume_heading .profile_image>img {
	margin-top: 50px;
}

.resume_heading .resume_personinfo {
	margin-top: 20px;
}

.resume_contents {
	border-color: #eee;
	border-image: none;
	border-radius: 3px;
	border-style: solid;
	border-width: 1px 1px 1px 5px;
	margin-bottom: 5px;
	padding: 10px;
	border-left-color: #d9534f;
}

.resume_contents>h3 {
	padding: 0 0 0 20px;
	color: #d9534f;
	margin-top: 10px;
}

.resume_contents .resume_timeline {
	margin-bottom: 150px;
	margin-top: 150px;
	margin-left: 80px;
}

.modal_fullsize {
	width: 90%;
	height: 90%;
	margin: 100px;
	padding: 0;
}
/*이력서 토글 버튼 css  */
.badgebox {
	opacity: 0;
}

.badgebox+.badge {
	text-indent: -999999px;
	width: 27px;
}

.badgebox:focus+.badge {
	box-shadow: inset 0px 0px 5px;
}

.badgebox:checked+.badge {
	text-indent: 0;
}


</style>
<body>
<!-- Modal -->
<c:set var="path" value="${pageContext.request.contextPath}" />

	<div class="col-md-12" >
					<div class="container" style="width:430px">
						<div class="row">
							<div
								class="col-md-12">
								<div class="resume_title"><h1>이력서</h1></div>
								<div class="panel panel-default">
									<div class="resume_heading">
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
														<li class="list-group-item" style="height: 40px; padding: 5px; margin: 0px" ><img
															src="${path}/resources/images/icons/user.png" width="32"
															height="32"> ${requestScope.personalInfo.name} 
															 / ${requestScope.personalInfo.englishName}</li>
														<li class="list-group-item" style="height: 40px; padding: 5px; margin: 0px"><img
															src="${path}/resources/images/icons/cake.png" width="32"
															height="32"> ${requestScope.personalInfo.birthDate}</li>
														<li class="list-group-item" style="height: 40px; padding: 5px; margin: 0px"><img
															src="${path}/resources/images/icons/email.png" width="32"
															height="32"> ${requestScope.personalInfo.email}</li>
														<li class="list-group-item" style="height: 40px; padding: 5px; margin: 0px"><img
															src="${path}/resources/images/icons/cell.png" width="32"
															height="32"> ${requestScope.personalInfo.phoneNo}</li>
														<li class="list-group-item" style="height: 40px; padding: 5px; margin: 0px"><img
															src="${path}/resources/images/icons/house.png" width="32"
															height="32"> ${requestScope.personalInfo.address}</li>
													</ul>
												</div>
											</div>
										</div>
									</div>
									<div class="button_set" id="resume_button_set" style="margin: 0px; padding: 0px;">
										<div>
											<label for="totalview_check"
												class="btn btn-success col-md-12">전체보기 <input
												type="checkbox" id="totalview_check" class="badgebox" checked><span
												class="badge">&check;</span>
											</label>
											
											<!-- <label for="timeline_check" class="btn btn-primary">타임라인
												<input type="checkbox" id="timeline_check" class="badgebox"><span
												class="badge">&check;</span>
											</label> -->
											
											<label for="school_check" class="btn btn-primary">학력사항
												<input type="checkbox" id="school_check" class="badgebox"><span
												class="badge">&check;</span>
											</label> 
											
											<label for="career_check" class="btn btn-primary">경력
												<input type="checkbox" id="career_check" class="badgebox"><span
												class="badge">&check;</span>
											</label>
											
											<label for="language_exam_check"
												class="btn btn-primary">어학 시험 <input
												type="checkbox" id="language_exam_check" class="badgebox"><span
												class="badge">&check;</span>
											</label>
											
											<label for="certificate_check"
												class="btn btn-primary">자격증 <input
												type="checkbox" id="certificate_check" class="badgebox"><span
												class="badge">&check;</span>
											</label><label for="awards_check" class="btn btn-primary">수상
												경력 <input type="checkbox" id="awards_check" class="badgebox"><span
												class="badge">&check;</span>
											</label><label for="foreign_study_check"
												class="btn btn-primary">해외 연수 <input
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
									
									
									<!-- <div class="resume_contents" id="timeline_preview">
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
									</div> -->
									
									
									
									<div class="resume_contents" id="school_preview">
										<h3>학력사항</h3>
										<c:forEach var="school" items="${requestScope.school}">
											<div id="line_component">
												<ul class="list-group">
													<li class="list-group-item"><img
														src="${path}/resources/images/icons/school.png" width="32"
														height="32"> ${school.name} </li>
													<li class="list-group-item"> ${school.startDate} ~ ${school.endDate} </li>
													<li class="list-group-item"> ${school.track} / ${school.major}</li>
												</ul>
											</div>
										</c:forEach>
									</div>
									<div class="resume_contents" id="career_preview">
										<h3>경력</h3>
										<c:forEach var="career" items="${careerSelect}">
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item"><img
													src="${path}/resources/images/icons/bag.png" width="32"
													height="32"> ${career.name}</li>
												<li class="list-group-item"> ${career.startDate} ~ ${career.endDate }</li>
												<li class="list-group-item"> ${career.department} /  ${career.position}</li>
												<li class="list-group-item"> ${career.task}</li>
												<li class="list-group-item"> 퇴사사유 - ${career.retirementReason}</li>
											</ul>
										</div>
										</c:forEach>
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
										<c:forEach var="award" items="${award}">
										<div id="line_component">
											<ul class="list-group">
												<li class="list-group-item"><img
													src="${path}/resources/images/icons/Award.png" width="32"
													height="32"> ${award.name}</li>
												<li class="list-group-item">${award.date} / ${award.publication} 주관</li>
												<li class="list-group-item">${award.category} - ${award.field}</li>
												<li class="list-group-item">${award.target}</li>
												<li class="list-group-item">${award.content}</li>
											</ul>
										</div>
										</c:forEach>
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
												<li class="list-group-item">${requestScope.military.pass}</li>
												<li class="list-group-item">${requestScope.military.startDate} ~ ${requestScope.military.endDate}</li></li>
												<li class="list-group-item">${requestScope.military.category} / ${requestScope.military.rank}</li>
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
												<li class="list-group-item">보훈 ${requestScope.unusual.isRewarded}</li>
												<li class="list-group-item">장애 ${requestScope.unusual.isDisabled}
									${requestScope.unusual.disabilityClass}</li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
</body>
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
</html>