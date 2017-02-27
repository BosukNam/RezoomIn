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
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/godofont.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/footer.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/resumeTimeline.css">
<%-- 	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/header.css"> --%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!-- date picker -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/scripts/resumeIndex.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/scripts/resumeModal.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/scripts/resumeTimeline.js"></script>
	<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/scripts/resumeAward.js"></script>
<%-- 	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/sidebar_effect.css">
		<script type="text/javascript"
	src="${pageContext.request.contextPath }/resources/scripts/sidebar_effect.js"></script> --%>
</head>
<style type="text/css">
.panel-body {
	height: 300px;
	overflow: hidden;
}

/*미리보기 모달 css  */
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
	font-size: 50px;
	border-radius: 5px;
	background-color: #b97711;
	border: 0px;
}

.resume_heading .profile_image>img {
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
/*각 컴포넌트 헤더 css  */


.destacados{
    padding: 20px 0;
	text-align: center;
}
.destacados > div > div{
	padding: 10px;
	border: 1px solid transparent;
	border-radius: 4px;
	transition: 0.2s;
}
.destacados > div:hover > div{
	margin-top: -10px;
	border: 1px solid rgb(200, 200, 200);
	box-shadow: rgba(0, 0, 0, 0.1) 0px 5px 5px 2px;
	background: rgba(200, 200, 200, 0.1);
	transition: 0.5s;
}
/*  버튼 효과  */
.color-pattern-1 {
    background: #fff;
}
/* General button style (reset) */
.button_style {
    border: none;
    color: #000;
    background-color :#fff; /* beforeColor */
    cursor: pointer;
    padding: 20px 60px;
    display: inline-block;
    text-transform: uppercase;
    letter-spacing: 1px;
    font-weight: 800;
    font-size : 1.2em;
    outline: none;
    position: relative;

    transition: all 0.5s;
}
.button_style:after {
    content: '';
    position: absolute;
    z-index: -1;

    transition: all 0.5s;
}
/* Button 1 */
.button-1 {
    border: 3px solid #fff; /* beforeColor */
    color: #000;
}

/* Button 1a */
.button-1a:hover,
.button-1a:active {
    color: #fff;
    background: #ec1b5a;	/* AfterColor */
    border : 3px solid #ec1b5a; /* AfterColor */
}
</style>
<body>
	<c:set var="path" value="${pageContext.request.contextPath}" />
	<!--header 시작  -->
	<jsp:include page="header.jsp"></jsp:include>
	<!--header 끝  -->

 	<div class="col-md-2 color-pattern-1">
		<div align="center">
			<!-- <button class="btn btn-default" type="button" id="preview_resume"
				data-toggle="modal" data-target="#preview_resume_modal">미리보기</button> -->
		<form action="${path}/preview.do" method="GET" id="preview_form">
			<input type="hidden" id="preview" name="preview" value="preview">
		<button class="button button_style button-1 button-1a" id="preview_btn"> 미리보기</button>
		</form>
		</div>
		<br>
	</div>
	<div class="col-xs-20 col-md-10">
		<div class="container" id="resume_contents">
			<div class="container" id="layer">
				<div class="col-xs-6 col-md-3" id="resume_photo">
					<button type="button" class="btn btn-primary btn-lg"
						data-toggle="modal" data-target="#photo_modal">
						<c:choose>
							<c:when test="${requestScope.personalInfo.photo eq null}">
								<img src="https://x.myspacecdn.com/new/common/images/user.png" id="photo_img" style="height: 270px; margin-top: 30px;"
									class="img-rounded img-responsive">
							</c:when>
							<c:otherwise>
								<img src="${requestScope.personalInfo.photo}" id="photo_img" style="height: 270px; margin-top: 30px;"
									class="img-rounded img-responsive">
							</c:otherwise>
						</c:choose>
					</button>
				</div>
			
				<div class="col-xs-18 col-md-9">
					<div class="resume_component">
						<div class="panel panel-info" id="resume_personinfo">
							<div class="panel-heading">
							<span class="resume-component-font-size">기본 인적 사항 </span><span class="header_component">
								<c:choose>
									<c:when test="${requestScope.personalInfo.name eq null}">
										<button class="btn btn-default" type="button" id="person_info_btn" data-target="#personal_info_modal">추가</button>
									</c:when>
									<c:otherwise>
										<button class="btn btn-default" type="button" id="person_info_btn" data-target="#personal_info_modal" disabled="disabled">추가</button>
									</c:otherwise>
								</c:choose>
									<button class="btn btn-default" type="button"
										data-toggle="button">보기</button>
								</span>
							</div>
							<div class="panel-body">
						<c:choose>
							<c:when test="${requestScope.personalInfo.name ne null}" >
							    <h1 style="text-align: center" hidden="true">추가해주세요</h1>
								<div class="line_component" id="personal_info">
							</c:when>
							<c:otherwise>
								<h1 style="text-align: center">추가해주세요</h1>
								<div class="line_component" id="personal_info" hidden="true">
							</c:otherwise>
						</c:choose>
								<ul class="list-group">
									<li class="list-group-item"><img
											src="${path}/resources/images/icons/user.png" width="32"
											height="32"><span id="personal_name">${requestScope.personalInfo.name}</span>
											<span class="span_line_component">
												<button class="btn btn-primary" type="button"
													id="personalInfo_modify_btn">편집</button>
												<button class="btn btn-primary" type="button"
													id="personalInfo_delete_btn">삭제</button>
									</span></li>
									<li class="list-group-item"><span id="personal_englishname"> ${requestScope.personalInfo.englishName}</span></li>
									<li class="list-group-item"><span><img
												src="${path}/resources/images/icons/cake.png" width="32"
												height="32"></span> <span id="personal_birthDate"> ${requestScope.personalInfo.birthDate}</span></li>
									<li class="list-group-item"><span><img
												src="${path}/resources/images/icons/email.png" width="32"
												height="32"></span> <span id="personal_email"> ${requestScope.personalInfo.email}</span></li>
									<li class="list-group-item"><span><img
												src="${path}/resources/images/icons/house.png" width="32"
												height="32"></span> <span id="personal_addr"> ${requestScope.personalInfo.address}</span></li>
									<li class="list-group-item"><span><img
												src="${path}/resources/images/icons/cell.png" width="32"
												height="32"></span> <span id="personal_phone">${requestScope.personalInfo.phoneNo}</span></li>
									<li class="list-group-item"><span id="personal_gender">${requestScope.personalInfo.gender}</span></li>
								</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container" id="layer">
				<div class="col-xs-12 col-md-6">
					<div class="resume_component">
						<div class="panel panel-info" id="resume_education">
							<div class="panel-heading">
							<span class="resume-component-font-size">학력사항 </span><span class="header_component">
								<button class="btn btn-default" type="button"
									id="education_add_btn" 
									data-target="#school_info_modal">추가</button>
								<button class="btn btn-default" type="button"
									data-toggle="button">보기</button>
							</span>
							</div>
							<div class="panel-body">
							<!-- 데이터가 없으면 추가해주세요, 데이터가 있으면 뿌려주고 -->
							 <c:choose>
							 	<c:when test="${requestScope.school[0] eq null && requestScope.school[1] eq null
												 && requestScope.school[2] eq null}">
									<h1 style="text-align: center">추가해주세요</h1>
								</c:when>
								<c:otherwise>
									<h1 style="text-align: center" hidden="true">추가해주세요</h1>
								</c:otherwise>
							</c:choose>
								 <c:choose>
								 	<c:when test="${requestScope.school[0] ne null}">
										<div class="line_component" id="highschool">								 	
									</c:when>
									<c:otherwise>
										<div class="line_component" id="highschool" hidden="true">
									</c:otherwise>
								</c:choose>
								<ul class="list-group">
									<li class="list-group-item">
									<input type="hidden" class="register_no" value="${requestScope.school[0].registerNo}">
									<img
										src="${path}/resources/images/icons/school.png" width="32"
										height="32"><span id="highschool_text">${requestScope.school[0].name}</span> <span
										class="span_line_component">
											<button class="btn btn-primary school_modify_btn" type="button"
												>편집</button>
											<button class="btn btn-primary school_delete_btn" type="button"
												>삭제</button>
									</span></li>
									<li class="list-group-item duration">${requestScope.school[0].startDate} ~ ${requestScope.school[0].endDate}</li>
								</ul>
								</div>
								
								 <c:choose>
								 	<c:when test="${requestScope.school[1] ne null}">
										<div class="line_component" id="university">								 	
									</c:when>
									<c:otherwise>
										<div class="line_component" id="university" hidden="true">
									</c:otherwise>
								</c:choose>
								<ul class="list-group">
									<li class="list-group-item">
								<input type="hidden" class="register_no" value="${requestScope.school[1].registerNo}">
									<img src="${path}/resources/images/icons/university.png" width="32"
										height="32"><span id="university_text">${requestScope.school[1].name}</span><span
										class="span_line_component">
											<button class="btn btn-primary school_modify_btn" type="button"
												>편집</button>
											<button class="btn btn-primary school_delete_btn" type="button"
												>삭제</button>
									</span></li>
									<li class="list-group-item duration">${requestScope.school[1].startDate} ~ ${requestScope.school[1].endDate}<p class="duration"></p></li>
								</ul>
								</div>
								
								<c:choose>
								 	<c:when test="${requestScope.school[2] ne null}">
										<div class="line_component" id="graduateschool">								 	
									</c:when>
									<c:otherwise>
										<div class="line_component" id="graduateschool" hidden="true">
									</c:otherwise>
								</c:choose>
								<ul class="list-group">
									<li class="list-group-item">
								<input type="hidden" class="register_no" value="${requestScope.school[2].registerNo}">
									<img src="${path}/resources/images/icons/university.png" width="32"
										height="32"><span id="graduateschool_text">${requestScope.school[2].name}</span><span
										class="span_line_component">
											<button class="btn btn-primary school_modify_btn" type="button"
												>편집</button>
											<button class="btn btn-primary school_delete_btn" type="button"
												>삭제</button>
									</span></li>
									<li class="list-group-item duration">${requestScope.school[2].startDate} ~ ${requestScope.school[2].endDate}</li>
								</ul>
								</div> 
							</div>
						</div>
					</div>
				</div>
				
				<div class="col-xs-12 col-md-6">
					<div class="resume_component">
						<div class="panel panel-info" id="resume_career">
							<div class="panel-heading">
									경력사항 <span class="header_component">
										<button class="btn btn-default" type="button"
											id="career_add_btn" data-target="#career_modal" id="career_add_btn">추가</button>
										<button class="btn btn-default" type="button"
											data-toggle="button" id="career_preview_btn">보기</button>
									</span>
							</div>
							<div class="panel-body">
									<!-- 데이터가 없으면 추가해주세요, 데이터가 있으면 뿌려주고 -->
									<c:choose>
										<c:when test="${requestScope.careerSelect[0] eq null}">
											<h1 style="text-align: center">추가해주세요</h1>
										</c:when>
										<c:otherwise>
											<c:forEach var="career" items="${careerSelect}">
								<div class="line_component">
											<ul class="list-group">
												<li class="list-group-item"><span class="img_span"><img
													src="${path}/resources/images/icons/bag.png"
													width="32" height="32"></span><span class="career_company_span">${career['name']}</span><span
													class="span_line_component">
														<button class="btn btn-primary career_modify_btn" type="button">편집</button>
														<button class="btn btn-primary career_delete_btn" type="button">삭제</button>
												</span></li>
												<li class="list-group-item"><span class="career_date_span">${career['startDate']} ~ ${career['endDate']}</span></li>
												<li class="list-group-item"><span class="career_position_span">직급 ${career['position']}</span></li>
												<li class="list-group-item"><span class="career_department_span">부서 ${career['department']}</span></li>
												<li class="list-group-item"><span class="career_task_span">담당업무 ${career['task']}</span></li>
												<li class="list-group-item"><span class="career_retirement_span">퇴사사유 ${career['retirementReason']}</span></li>
												<li class="hidden"><span class="career_register_span">${career['registerNo']}</span></li>
											</ul>
								</div>
									</c:forEach>
									</c:otherwise>
									</c:choose>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container" id="layer">
				<div class="col-xs-8 col-md-4">
					<div class="resume_component">
						<div class="panel panel-info" id="resume_language">
							<div class="panel-heading">
									어학 시험 <span class="header_component">
										<button class="btn btn-default" type="button"
											data-target="#languageExam_modal" id="languageExam_add_btn">추가</button>
										<button class="btn btn-default" type="button"
											data-toggle="button">보기</button>
									</span>
							</div>
							<div class="panel-body" id="line_languageExam">
									<c:forEach var="exam" items="${exam }">
								<div class="line_component">
										<ul class="list-group">
											<li class="list-group-item"><span class="img_span"><img
													src="${path}/resources/images/icons/translate.png"
													width="32" height="32"></span><span class="languageExam_name_span">${exam['name']}</span><span
												class="span_line_component">
													<button class="btn btn-primary languageExam_modify_btn" type="button">편집</button>
													<button class="btn btn-primary languageExam_delete_btn" type="button">삭제</button>
											</span></li>
											<li class="list-group-item"><span class="languageExam_date_span">${exam['date']}</span></li>
											<li class="list-group-item"><span class="languageExam_grade_span">${exam['grade']}</span></li>
											<li class="hidden"><span class="languageExam_register_span">${exam['registerNo']}</span></li>
										</ul>
								</div>
									</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-8 col-md-4">
					<div class="resume_component">
						<div class="panel panel-info" id="resume_certificate">
							<div class="panel-heading">
									자격증 <span class="header_component">
										<button class="btn btn-default" type="button"
											 data-target="#certificate_modal" id="certificate_add_btn">추가</button>
										<button class="btn btn-default" type="button"
											data-toggle="button" id="certificate_preview_btn">보기</button>
									</span>
							</div>
							<div class="panel-body" id="line_certificate">
									<c:forEach var="certificate" items="${certificateSelect }">
								<div class="line_component">
										<ul class="list-group">
											<li class="list-group-item"><span class="certificate_name_span">${certificate['name']}</span><span
												class="span_line_component">
													<button class="btn btn-primary certificate_modify_btn" type="button">편집</button>
													<button class="btn btn-primary certificate_delete_btn" type="button">삭제</button>
											</span></li>
											<li class="list-group-item"><span class="certificate_date_span">${certificate['date']}</span></li>
											<li class="list-group-item"><span class="certificate_publication_span">${certificate['publication']}</span></li>
											<li class="hidden"><span class="certificate_register_span">${certificate['registerNo']}</span></li>
										</ul>
								</div>
									</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-8 col-md-4">
					<div class="resume_component">
						<div class="panel panel-info" id="resume_awards">
							<div class="panel-heading">
									수상 경력 <span class="header_component">
										<button class="btn btn-default" type="button"
											id="add-award-btn" data-target="#award_modal">추가</button>
										<button class="btn btn-default" type="button"
											data-toggle="button">보기</button>
									</span>
							</div>
							<div class="panel-body">
								<c:choose>
									<c:when test="${requestScope.award[0] eq null}">
										<!-- 데이터가 없으면 추가해주세요, 데이터가 있으면 뿌려주고 -->
										<h1 style="text-align: center">추가해주세요</h1>
									</c:when>
									<c:otherwise>
									<c:forEach var="award" items="${award}">
								<div class="line_component">
										<ul class="list-group">
											<li class="list-group-item"><span class="img_span"><img
												src="${path}/resources/images/icons/Award.png" width="32"
												height="32"></span><span class="award_category_span">${award['category']}</span><span
												class="span_line_component">
													<button class="btn btn-primary award_modify_btn" type="button">편집</button>
													<button class="btn btn-primary award_delete_btn" type="button">삭제</button>
											</span></li>
											<li class="list-group-item"><span class="award_field_span">${award['field']}</span></li>
											<li class="list-group-item"><span class="award_target_span">${award['target']}</span></li>
											<li class="list-group-item"><span class="award_name_span">${award['name']}</span></li>
											<li class="list-group-item"><span class="award_date_span">${award['date']}</span></li>
											<li class="list-group-item"><span class="award_publication_span">${award['publication']}</span></li>
											<li class="list-group-item"><span class="award_content_span">${award['content']}</span></li>
											<li class="hidden"><span class="award_register_span">${award['registerNo']}</span></li>
										</ul>
								</div>
									</c:forEach>
									</c:otherwise>
									</c:choose>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container" id="layer">
				<div class="col-xs-8 col-md-4">
					<div class="resume_component">
						<div class="panel panel-info" id="resume_overseas">
							<div class="panel-heading">
									해외 연수 <span class="header_component">
										<button class="btn btn-default" type="button" id="foreignStudy_add_btn"
											data-target="#foreignStudy_modal">추가</button>
										<button class="btn btn-default" type="button"
											data-toggle="button">보기</button>
									</span>
							</div>
							<div class="panel-body">
									<c:forEach var="foreign" items="${foreignAct }">
								<div class="line_component">
										<ul class="list-group">
											<li class="list-group-item"><span class="img_span"><img
												src="${path}/resources/images/icons/Airplane.png" width="32"
												height="32"></span><span class="foreignStudy_category_span">${foreign['category']}</span>
												<span class="span_line_component">
													<button class="btn btn-primary foreignStudy_modify_btn" type="button">편집</button>
													<button class="btn btn-primary foreignStudy_delete_btn" type="button">삭제</button>
											</span></li>
											<li class="list-group-item">
											<span class="foreignStudy_date_span">${foreign['startDate']} ~ ${foreign['endDate']}</span>
											</li><li class="list-group-item"><span class="foreignStudy_content_span">${foreign['content']}</span>
											</li><li class="hidden"><span class="foreignStudy_register_span">${foreign['registerNo']}</span></li>
										</ul>
								</div>
									</c:forEach>
								</div>
							</div>
						</div>
					</div>
				<div class="col-xs-8 col-md-4">
					<div class="resume_component">
						<div class="panel panel-info" id="resume_military">
							<div class="panel-heading">
							병역 사항 <span class="header_component">
								
							<c:choose>
								<c:when test="${requestScope.military eq null}">
									<button class="btn btn-default" type="button" id="add_military_btn" data-target="#military_modal">추가</button>
								</c:when>
								<c:otherwise>
									<button class="btn btn-default" type="button" id="add_military_btn" data-target="#military_modal" disabled="disabled">추가</button>
								</c:otherwise>
							</c:choose>
								<button class="btn btn-default" type="button" data-toggle="button">보기</button>
							</span>
							</div>
							<div class="panel-body">

							<!-- 데이터가 없으면 추가해주세요, 데이터가 있으면 뿌려주고 -->

								<div class="line_component">
							<c:choose>
								<c:when test="${requestScope.military eq null}">
									<h1 style="text-align: center">추가해주세요</h1>
									<ul class="list-group" id="military" hidden="true">
								</c:when>
								<c:otherwise>
									<h1 style="text-align: center" hidden="true">추가해주세요</h1>
									<ul class="list-group" id="military">
								</c:otherwise>
							</c:choose>
									<li class="list-group-item"><span id="military_text">${requestScope.military.pass}</span><span
										class="span_line_component">
											<button class="btn btn-primary" type="button" id="modify-military-btn">편집</button>
											<button class="btn btn-primary" type="button" id="delete-military-btn">삭제</button>
									</span></li>
									<li class="list-group-item duration">${requestScope.military.startDate} ~ ${requestScope.military.endDate}</li>
								</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-8 col-md-4">
					<div class="resume_component">
						<div class="panel panel-info" id="resume_activity">
							<div class="panel-heading">
									봉사 / 대외 활동 <span class="header_component">
										<button class="btn btn-default" type="button" data-target="#activity_modal" id="activity_add_btn">추가</button>
										<button class="btn btn-default" type="button" data-toggle="button">보기</button>
									</span>
							</div>
							<div class="panel-body">
									<!-- 데이터가 없으면 추가해주세요, 데이터가 있으면 뿌려주고 -->
									<!-- <h1 style="text-align: center">추가해주세요</h1> -->
									<c:forEach var="externAct" items="${externAct }">
								<div class="line_component">
										<ul class="list-group">
											<li class="list-group-item"><span class="img_span"><img
												src="${path}/resources/images/icons/running-silhouettes.png" width="32"
												height="32"></span><span class="activity_category_span">${externAct['category']}</span>
												<span
												class="span_line_component">
													<button class="btn btn-primary activity_modify_btn" type="button">편집</button>
													<button class="btn btn-primary activity_delete_btn" type="button">삭제</button>
											</span></li>
											<li class="list-group-item"><span class="activity_date_span">${externAct['startDate']} ~ ${externAct['endDate']}</span></li>
											<li class="list-group-item"><span class="activity_content_span">${externAct['content']}</span></li>
											<li class="hidden"><span class="activity_register_span">${externAct['registerNo'] }</span></li>
										</ul>
								</div>
									</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="container" id="layer">
				<div class="col-xs-8 col-md-8">
					<div class="resume_component">
						<div class="panel panel-info" id="resume_timeline">
							<div class="panel-heading">
									타임라인 <span class="header_component">
										<button class="btn btn-default" type="button">추가</button>
										<button class="btn btn-default" type="button"
											data-toggle="button">보기</button>

									</span>
							</div>
							<div class="panel-body">
								<div class="container" id="timeline_container">
									<div class="row">
										<div class="timeline">
										<c:forEach var="x" begin="1907" end="2017">
											<div class="period_time">${x}</div>

										</c:forEach>
										</div>
									</div>
									<div class="row">
										<div class="timeline_school"
												style="height: 20px; width: 200px; background-color: rgb(30, 40, 50); top: -5px; left:-10px; position:relative"
												data-container="body" data-toggle="popover"
												data-placement="left" title="고등학교"
												data-content="2012.01 ~ 2016.12"></div> <!-- left:-10px default로 주자 / position은 relative로 -->
										<div class="timeline_school"
												style="height: 25px; width: 200px; background-color:rgb(80, 140, 140); left: 190px; position:relative" 
												data-container="body" data-toggle="popover"
												data-placement="left" title="대학교"
												data-content="2013.03 ~ 2015.10"></div> <!-- left:-10px default로 주자 / position은 relative로 -->

									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-8 col-md-4" id="resume_etc">
						<!-- 				<div class="resume_component">
					<div class="panel panel-default" id="resume_wishwork">
						<div class="panel-heading">
							희망 근무 조건 <span>
								<button class="btn btn-default" type="button">+</button>
								<button class="btn btn-default" type="button" data-toggle="button">보기</button>
							</span>
						</div>
						<div class="panel-body">Panel content</div>
					</div>
				</div> -->
					<div class="resume_component">
						<div class="panel panel-info" id="resume_remark">
							<div class="panel-heading">
							보훈 / 장애 여부 <span class="header_component" id="add_remark_btn"
								data-target="#unusual_modal">
							<c:choose>
								<c:when test="${requestScope.unusual eq null}">
								<button class="btn btn-default" type="button" id="unusual_add_btn">추가</button>
								</c:when>
								<c:otherwise>
								<button class="btn btn-default" type="button" id="unusual_add_btn" disabled="disabled">추가</button>
								</c:otherwise>
							</c:choose>
								<button class="btn btn-default" type="button" data-toggle="button">보기</button>
							</span>
							</div>
								<div class="panel-body">
									<div class="line_component">
							<c:choose>
								<c:when test="${requestScope.unusual eq null}">
									<h1 style="text-align: center">추가해주세요</h1>
									<ul class="list-group" id="remark" hidden="true">
								</c:when>
								<c:otherwise>
									<h1 style="text-align: center" hidden="true">추가해주세요</h1>
									<ul class="list-group" id="remark">
								</c:otherwise>
							</c:choose>
									<li class="list-group-item"><span id="remark_text1">보훈 ${requestScope.unusual.isRewarded}</span><span
										class="span_line_component" id="span_line_component">
											<button class="btn btn-primary" type="button" id="modify-remark-btn">편집</button>
											<button class="btn btn-primary" type="button" id="delete-remark-btn">삭제</button>
									</span></li>
									<li class="list-group-item"><span id="remark_text2">장애 ${requestScope.unusual.isDisabled}
									${requestScope.unusual.disability}</span></li>
								</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				</div>
				</div>
				</div>
	<!--footer 시작  -->
	<jsp:include page="footer.html"></jsp:include>
	<!--footer 끝  -->
	<jsp:include page="photo.jsp"></jsp:include>
	<jsp:include page="personalInfo.jsp"></jsp:include>
	<jsp:include page="school.jsp"></jsp:include>
	<jsp:include page="career.jsp"></jsp:include>
	<jsp:include page="languageExam.jsp"></jsp:include>
	<jsp:include page="certificate.jsp"></jsp:include>
	<jsp:include page="award.jsp"></jsp:include>
	<jsp:include page="foreignStudy.jsp"></jsp:include>
	<jsp:include page="military.jsp"></jsp:include>
	<jsp:include page="activity.jsp"></jsp:include>
	<jsp:include page="unusual.jsp"></jsp:include>
	<jsp:include page="ResumeDetail.jsp"></jsp:include>
	<!-- Delete Modal -->
	<div class="modal fade" id="delete_resume_modal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">호이</span>
					</button>
					<h4 class="modal-title">호이</h4>
				</div>
				<div class="modal-body">
					<p>하이</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">후이</button>
					<button type="button" class="btn btn-primary">후이</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	
<script>

   /*    $.메소드명 = function(인자명) {
      } */
      $(function() {
         
         // 삭제 모달 창 닫아두기
         $('#delete_resume_modal').modal('hide');

         // 추가, 보기 버튼 숨기기
         $('.header_component').hide();
         //
         $('.span_line_component').hide();

         // 컴포넌트 선택자
         var component = $('.resume_component div');
         // 라인 컴포넌트 선택자
         var lineComponent = $('.line_component ul');

/*          $(document).on('hover','.line_component ul', function() {
            
            $(this).find('li .span_line_component').show();
            $(this).css('background-color', 'lightgray');
               }, function() {
            $(this).find('li .span_line_component').hide();
            $(this).css('background-color', 'white');

         }); */
         /*            $(lineComponent).find('li .span_line_component :eq(1)').click(
          function() {
          // 삭제 모달 창
          /* var modal = $('#delete_resume_modal'); */
         // 모달 전체 닫아두기
         /* modal.show(); */
         var target = $(this).parent().parent().parent();
         var parent = target.parent();
         target.remove();
         /*                   // 내용 없으면 가려준다.
          if (parent.find('*').html() == null) {
          parent.hide();
          } 
          })  */
         // 컴포넌트 내용 숨긴 부분
         /*          component.find('.panel-body').hide(); */
         // 컴포넌트 커서 위치시에 버튼 보여주기
         component.hover(function() {/* 
               $(this).css('box-shadow', '0px 0px 2px 2px lightgray'); */
            $(this).find('div>.header_component').show();
            /*             $(this).find('div>.header_component :eq(0)').on(
             'click',
             function() {
             $(this).parent().parent().parent().find(
             '.panel-body').show();
             }); */
         }, function() {/* 
                $(this).css('box-shadow', '0px 0px 2px 2px white'); */
            $(this).find('div>.header_component').hide();
         });
         // 보기 버튼 클릭시 스크롤바 show or hide
         $('.header_component').find(' :eq(1)').on('click', function() {
            var target = $(this).parent().parent().parent();
            
            if(target.prop('id') == 'resume_timeline'){
               if ($(this).html() == "보기") {
                  target.find('.panel-body').css("overflow-x", "scroll");
                  $(this).html("보기해제");
               } else {
                  target.find('.panel-body').css("overflow-x", "");
                  $(this).html("보기");
               }
            }else{
               if ($(this).html() == "보기") {
                  target.find('.panel-body').css("overflow-y", "scroll");
                  $(this).html("보기해제");
               } else {
                  target.find('.panel-body').css("overflow-y", "");
                  $(this).html("보기");
               }
            }

            
            //var target = $(this).parent().parent().parent();
         });
         // 타임라인 
         $(function() {
            $('.timeline').on('click', '.period_time', function() {
               $('.period_time').removeClass('period-active');
               $(this).addClass('period-active');
            })
         })

  
$(function(){
	/*
	 * 인적사항 
	 */
	/* 추가 버튼 클릭 시 추가 모달이라는 속성 부여 & 폼 초기화 */
	$('#person_info_btn').on('click', function(){
		$('#personal_info_modal').modal('show');
		$('#personal_form input').val('');
		
		$('#female').val('female');
		$('#female').prop('checked', false);
		$('#male').val('male');
		$('#male').prop('checked', false);


		$('#personal_type').attr('value', 'add');
		$('#personal_category').attr('value', 'profile');
	});
	/* 수정 버튼 클릭 시 데이터를 뿌려준다*/
	$('#personalInfo_modify_btn').on('click', function(){
		$('#personal_info_modal').modal('show');
		$('#personal_type').attr('value', 'search');
		 var resume_category = $('#personal_category').attr('value');

		 $.ajax({
				type : "GET",
				url  : "${pageContext.request.contextPath}/searchPersonalInfo.do",
				data :  {
						type:'search',
						resume_category:resume_category,
					},
				success : function(response) {
					console.log(response);
					var data = JSON.parse(response);
					var msg = data.msg.trim();
					
					if(msg == 'SEARCH-SUCCESS')
					{

						$("#name").val(data.name);
						$("#englishName").val(data.englishName);
						$("#birthDate-picker").val(data.birthDate);
						$("#email").val(data.email);
						$("#address").val(data.address);
						$("#phone").val(data.phone);
						
						var gender = data.gender;

						if('여성' == gender)
							$('#female').prop('checked', true);
						else if('남성' == gender)
							$('#male').prop('checked', true);

						console.log(data.gender);

					}
					else
						alert('인적사항 조회에 실패했습니다');
					
					$('#personal_type').attr('value', '');
				},
				error : function() {
					alert("인적사항 조회 오류!");
					$('#personal_type').attr('value', '');
				}
			});

			});
	
	/* 삭제 버튼 클릭 시 */
	$('#personalInfo_delete_btn').on('click', function(){
		if(confirm('정말로 삭제하시겠습니까? 복구가 안돼요')) 
		{ 
		 var type = 'delete';
		 var resume_category = $('#personal_category').attr('value');
		 $.ajax({
				type : "GET",
				url  : "${pageContext.request.contextPath}/deletePersonalInfo.do",
				data :  {
						type:'delete',
						resume_category:resume_category
					},
				success : function(res) {
					var msg = res.trim();
					if(msg == 'DELETE-SUCCESS')
					{
 						alert('삭제되었습니다');
 						$('#personal_info').hide();
 						$('#person_info_btn').removeAttr('disabled');
						$('#resume_personinfo h1').show();	

					}
					else
						alert('삭제에 실패했습니다');
					
					$('#personal_type').attr('value', '');
				},
				error : function() {
					alert("개인신상정보 삭제 오류!");
					$('#personal_type').attr('value', '');
				}

			});
		}
	});
	/* 저장 버튼 클릭 시 */
 	$('#save_personal_btn').on('click', function() {
 		console.log($('#personal_type').attr('value'));
		$('#personal_info_modal').modal('hide');
		
		/* 추가에 대한 저장이면 */
			if($('#personal_type').attr('value') == 'add')
			{
				$('#resume_personinfo h1').hide();	
				var formData = $('#personal_form').serialize();
				 $.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/addPersonalInfo.do",
					data : formData,
					success : function(res) {
						var msg = res.trim();
 						$('#personal_type').attr('value', '');

 						if(msg == 'ADD-SUCCESS')
 						{
	 						alert('등록되었습니다');
	 						$('#personal_info').show();
	 						
	 						$('#personal_name').text($('#name').val());
	 						$('#personal_englishname').text($('#englishName').val());
	 						$('#personal_birthDate').text($('#birthDate-picker').val());
	 						$('#personal_email').text($('#email').val());
	 						$('#personal_addr').text($('#address').val());
	 						$('#personal_phone').text($('#phone').val());
	 						
	 						var gender = $('input[name=gender]:checked').val();
	 						if('female' == gender)
	 							$('#personal_gender').text('여성');
	 						else if('male' == gender)
	 							$('#personal_gender').text('남성');

	 						$('#person_info_btn').attr('disabled', 'disabled');
 						}
 						else
 							alert('등록에 실패했습니다');
 						
					},
					error : function() {
						alert("개인신상정보 등록 오류!");
 						$('#personal_type').attr('value', '');
					}

				});
			}
		/* 수정에 대한 저장이면 */
			else
			{
				$('#resume_personinfo h1').hide();	
				var formData = $('#personal_form').serialize();
				 $.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/modifyPersonalInfo.do",
					data : formData,
					success : function(res) {
						var msg = res.trim();
 						if(msg == 'MODIFY-SUCCESS')
 						{
	 						alert('수정되었습니다');
	 						$('#personal_info').show();
	 						
	 						$('#personal_type').attr('value', '');
	 						$('#personal_name').text($('#name').val());
	 						$('#personal_englishname').text('');
	 						$('#personal_englishname').text($('#englishName').val());
	 						$('#personal_birthDate').text($('#birthDate-picker').val());
	 						$('#personal_email').text($('#email').val());
	 						$('#personal_addr').text($('#address').val());
	 						$('#personal_phone').text($('#phone').val());
	 						
	 						var gender = $('input[name=gender]:checked').val().trim();
	 						if('female' == gender)
	 							$('#personal_gender').text('여성');
	 						else if('male' == gender)
	 							$('#personal_gender').text('남성');
 						}
 						else
 							alert('수정에 실패했습니다');
					},
					error : function() {
						alert("개인신상정보 수정 오류!");
					}
				});
			}
	});

 	/*
     * 해외연수 - 추가 클릭 시 
     */
    $('#foreignStudy_add_btn').on('click', function() {
       $('#foreignStudy_modal').modal('show');

       /* 추가 모달이라는 속성 부여 */
       $('#foreignStudy_type').attr('value', 'addActivity');
    });
    /*
     * 해외연수 - 편집 클릭 시 
     */
    $(document).on('click', '.line_component .foreignStudy_modify_btn',function() {
       var ul = $($(this).parent().parent().parent());
       /* 값 초기화  */
       /* 카테고리 초기화  */
       /* 날짜 초기화  */
       var date = $('li .foreignStudy_date_span').html().split(' ');
       $('#foreignDate1').val(date[0] +' '+date[1]);
       $('#foreignDate2').val(date[3] +' '+date[4]);
       /* 내용 초기화 */
       $('#foreignContent').val($(ul).find('li .foreignStudy_content_span').html());
       /* 등록번호 속성 추가  */
       $('#foreignStudy_key').attr('value', $(ul).find('li .foreignStudy_register_span').html());
       /* 모달 출력 */
       $('#foreignStudy_modal').modal('show');
       /* 추가 모달이라는 속성 부여 */
       $('#foreignStudy_type').attr('value', 'editActivity');
    });
    /*
     * 해외연수 - 삭제 클릭 시 
     */
     $(document).on('click', '.line_component .foreignStudy_delete_btn',function(){
          var target = $(this).parent().parent().parent().find('.foreignStudy_register_span')
          var registerNo = target.html();
          var transfer = {"registerNo" : registerNo, "activity_type" : "deleteActivity"};
          $.ajax({
             type : "POST",
             url : "${pageContext.request.contextPath}/deleteForeignStudy.do",
             data : transfer,
             dataType : 'json',
             success : function(res){
                if(res.result === "삭제 성공"){
                   target.parent().parent().remove();
                   alert("삭제하였습니다.");
                }else{
                   alert("삭제에 실패하였습니다");
                }
             },
             error : function(res){
                alert("실패");
             }
          });
       
     });
    /*
     * 해외연수 - 저장 클릭 시 
     */
    $('#save-foreign-btn').on('click', function() {
       $('#foreignStudy_modal').modal('hide');
       /* 추가 모달이면 */
       if ($('#foreignStudy_type').attr('value') == 'addActivity') 
       {
          $('#resume_overseas h1').hide();
 
          var formData = $('#foreign-form').serializeObject();
          $.ajax({
             type : "POST",
             url : "${pageContext.request.contextPath}/addForeignStudy.do",
             data : formData,
             success : function(res) {
                var result = JSON.parse(res);
                /* var key = res.trim();
                alert(key); */
                alert('등록되었습니다.');
                $('#resume_overseas .panel-body').append('<div class="line_component"><ul class="list-group">'
                      + '<li class="list-group-item">'
                      + '<span class="img_span"><img src="${path}/resources/images/icons/Airplane.png" '
                      + 'width="32" height="32"></span>'
                      + '<span class="foreignStudy_category_span">'+result.category+'</span>'
                      + '<span class="span_line_component">'
                      + '<button class="btn btn-primary foreignStudy_modify_btn" type="button">편집</button>'
                      + '<button class="btn btn-primary foreignStudy_delete_btn" type="button">삭제</button>'
                      + '</span></li>'
                      + '<li class="list-group-item"><span ' 
                      + 'class="foreignStudy_date_span">' +result.startDate+' ~ '+ result.endDate + '</span></li>'
                      + '<li class="list-group-item"><span class="foreignStudy_content_span">'+result.content+'</span>'
                      + '</li><li class="hidden"><span class="foreignStudy_register_span">'+result.registerNo +'</span>'
                      + '</li></ul></div>');
                      $('#foreignStudy_type').attr('value', '');
                },
             error : function() {
                alert("등록에 실패하였습니다.");
             }
          });
       } 
       /* 편집 모달이면 */
       else {
          var formData = $('#foreign-form').serializeObject();
          $.ajax({
             type : "POST",
             url : "${pageContext.request.contextPath}/editForeignStudy.do",
             data : formData,
             success : function(res) {
                var result = JSON.parse(res);
                /* var key = res.trim();
                alert(key); */
                var length = $('#resume_overseas ul').length;
                for(var i = 0 ; i < length; ++i){
                   if($('#resume_overseas ul:eq('+i+') .foreignStudy_register_span').html() == result.registerNo){
                      $('#resume_overseas ul:eq('+i+') .foreignStudy_category_span').html(result.category);
                      $('#resume_overseas ul:eq('+i+') .foreignStudy_date_span').html(result.startDate +' ~ '+result.endDate);
                      $('#resume_overseas ul:eq('+i+') .foreignStudy_content_span').html(result.content);
                   }
                }
             },
             error : function() {
                alert("실패");
             }
          });
          $('#foreignStudy_type').attr('value', '');
       }
    });
 });
 /*
  *어학시험 - 추가 클릭 시 
  */
 $('#languageExam_add_btn').on('click', function() {
    $('#languageExam_modal').modal('show');

    /* 추가 모달이라는 속성 부여 */
    $('#languageExam_type').attr('value', 'addLanguageExam');
    
    
 });
 /*
  * 어학시험 - 편집 클릭 시 
  */
 $(document).on('click', '.line_component .languageExam_modify_btn',function() {
    var lang_ul = $(this).parent().parent().parent();
    $('#languageExam_modal').modal('show');
    /* 값 초기화  */
    /* 시험명 초기화 */
    $('#examName').val($(lang_ul).find('li .languageExam_name_span').html());
    /* 취득일 초기화 */
    $('#languageExamDate').val($(lang_ul).find('li .languageExam_date_span').html());
    /* 점수 / 등급  초기화 */
    $('#examGrade').val($(lang_ul).find('li .languageExam_grade_span').html());
    /* 등록번호 속성 부여  */
    $('#languageExam_key').attr('value', $(lang_ul).find('li .languageExam_register_span').html());

    /* 편집 모달이라는 속성 부여 */
    $('#languageExam_type').attr('value', 'editLanguageExam');
 });
 /*
  * 어학 시험 - 삭제 클릭 시 
  */
  $(document).on('click', '.line_component .languageExam_delete_btn',function(){
       var target = $(this).parent().parent().parent().find('.languageExam_register_span')
       var registerNo = target.html();
       var transfer = {"registerNo" : registerNo, "career_type" : "deleteLanguageExam"};
       $.ajax({
          type : "POST",
          url : "${pageContext.request.contextPath}/deleteLanguageExam.do",
          data : transfer,
          dataType : 'json',
          success : function(res){
             if(res.result === "삭제 성공"){
                target.parent().parent().remove();
                alert("삭제에 성공하였습니다.");
             }else{
                alert("삭제에 실패하였습니다.");
             }
          },
          error : function(res){
             alert("실패");
          }
       });
    
  });
 $('#save_languageExam_btn').on('click', function() {
    $('#languageExam_modal').modal('hide');
    /* 추가 모달이면 */
    if ($('#languageExam_type').attr('value') == 'addLanguageExam') 
    {
       var formData = $('#languageExam_form').serializeObject();
       $.ajax({ 
          type : "POST",
          url : "${pageContext.request.contextPath}/addLanguageExam.do",
          data : formData,
          success : function(res) {
             var result = JSON.parse(res);
             $('#resume_language .panel-body').append(
                '<div class="line_component"><ul class="list-group">'
                + '<li class="list-group-item"><span class="img_span"><img src="${path}/resources/images/icons/translate.png" width="32"height="32">'
                + '</span><span class="languageExam_name_span">'
                + result.name
                + '</span><span class="span_line_component">'
                + '<button class="btn btn-primary languageExam_modify_btn" type="button">편집</button>'
                + '<button class="btn btn-primary languageExam_delete_btn" type="button">삭제</button>'
                + '</span></li>'
                + '<li class="list-group-item"><span class="languageExam_date_span">'
                + result.date + '</span></li><li class="list-group-item"><span class="languageExam_grade_span">'
                + result.grade + '</span></li><li class="hidden"><span class="languageExam_register_span">'
                + result.registerNo +'</span></li></ul></div>');
             },
          error : function() {
                alert("서버 실패");
             }
          });
       $('#languageExam_type').attr('value', '');
    } 
    /* 편집 모달이면 */
    else 
    {
       var formData = $('#languageExam_form').serializeObject();
       $.ajax({
          type : "POST",
          url : "${pageContext.request.contextPath}/editLanguageExam.do",
          data : formData,
          success : function(res) {
             var result = JSON.parse(res);
             /* var key = res.trim();
             alert(key); */
             var length = $('#resume_language ul').length;
             for(var i = 0 ; i < length; ++i){
                if($('#resume_language ul:eq('+i+') .languageExam_register_span').html() === result.registerNo){
                   $('#resume_language ul:eq('+i+') .languageExam_name_span').html(result.name);
                   $('#resume_language ul:eq('+i+') .languageExam_date_span').html(result.date);
                   $('#resume_language ul:eq('+i+') .languageExam_grade_span').html(result.grade);
                }
             }
          },
          error : function() {
             alert("서버 실패");
          }
       });
       $('#languageExam_type').attr('value', '');
       
    }

 });

	
	/*
	 * 학력사항 - 저장 버튼 클릭 시
	 */
	 /* 추가 버튼 클릭 시 추가 모달이라는 속성 부여 & 폼 초기화 */
		$('#education_add_btn').on('click', function(){
			$('#school_info_modal').modal('show');
			$('#school_type').attr('value', 'add');
			$('#school_category').attr('value', 'school');
		});
		/* 수정 버튼 클릭 시 데이터를 가져와 뿌려준다*/
		$('.school_modify_btn').on('click', function(){
			$('#school_info_modal').modal('show');
			$('#school_type').attr('value', 'search');
			
			var element=$(this).closest('ul');
			var registerNo = $(this).closest('ul').find('input[type=hidden]').val();
			var resume_category = $('#school_category').attr('value');

			 $.ajax({
					type : "GET",
					url  : "${pageContext.request.contextPath}/searchSchoolInfo.do",
					data :  {
							type:'search',
							resume_category:resume_category,
							registerNo:registerNo,
						},
					success : function(response) {
					
						console.log(response);
						var data = JSON.parse(response);
						var msg = data.msg.trim();
						
 						if(msg == 'SEARCH-SUCCESS')
 						{
 							$('#schoolCategory').val(data.categoryCode + "/" + data.category).change();
 							$("#school").val(data.name);
 							$("#schoolArea").val(data.location);
 							$("#highSchoolMajor").val(data.trackCode + "/" + data.track).change();
 							$("#major").val(data.major);
 							$("#grade").val(data.grade);
 							$("#schoolGradeTotal").val(data.totalGradeCode+"/"+data.totalGrade).change();
 							$("#degree").val(data.degreeCode + "/" + data.degree).change();
 							$("#state").val(data.stateCode + "/" + data.state).change();
 							$("#schoolDate1").val(data.startDate);
 							$("#schoolDate2").val(data.endDate);
 							$('#school_registerNo').val(registerNo);
 						}
 						else
 							alert('학력사항 조회에 실패했습니다');
 						
 						$('#school_type').attr('value', '');
					},
					error : function() {
						alert("학력사항 조회 오류!");
 						$('#school_type').attr('value', '');
					}

				});
			
		});
		/* 삭제 버튼 클릭 시 */
		$('.school_delete_btn').on('click', function(){
			var element=$(this).closest('ul');
			var registerNo = $(this).closest('ul').find('input[type=hidden]').val();
			if(confirm('정말로 삭제하시겠습니까? 복구가 안돼요')) 
			{ 
			 var type = 'delete';
			 var resume_category = $('#school_category').attr('value');
			 $.ajax({
					type : "GET",
					url  : "${pageContext.request.contextPath}/deleteSchoolInfo.do",
					data :  {
							type:'delete',
							resume_category:resume_category,
							registerNo:registerNo,
						},
					success : function(res) {
						var msg = res.trim();
 						if(msg == 'DELETE-SUCCESS')
 						{
	 						alert('삭제되었습니다');
	 						$(element).parent().hide();
	 						
	 						if($('#highschool').attr('hidden')
	 							&& $('#university').attr('hidden')
	 								&& $('#graduateschool').attr('hidden'))
		 						$('#resume_education h1').show();

	 								 						
 						}
 						else
 							alert('삭제에 실패했습니다');
 						
 						$('#school_type').attr('value', '');
					},
					error : function() {
						alert("학력사항 삭제 오류!");
 						$('#school_type').attr('value', '');
					}

				});
			}
		});
	$('#save_school_btn').on('click', function() {
				$('#school_info_modal').modal('hide');
				$('#resume_education .panel-body').show();
				$('#resume_education h1').hide();

				var resume_category = $('#school_category').attr('value');

				/* 등록에 대한 저장일 경우 */
				if($('#school_type').attr('value') == 'add')
				{
					var formData = $('#school_form').serialize();
					 $.ajax({
						type : "POST",
						url : "${pageContext.request.contextPath}/addSchoolInfo.do",
						data :  formData,
						success : function(res) {
							var array = res.trim().split('/');
	 						$('#school_type').attr('value', '');

	 						if(array[0] == 'ADD-SUCCESS')
	 						{
		 						alert('등록되었습니다');
		 						/*
								 * 분류 - 고등학교로 저장 시 
								 */
								var cate = $('#schoolCategory').val().split('/');
								if (cate[1] == '고등학교') {
									$('#highschool').show();
									$('#highschool .register_no').val(array[1]);
									$('#highschool_text').text($('#school').val());
									$('#highschool .duration').text(
											$('#schoolDate1').val() + " ~ "
													+ $('#schoolDate2').val());
									
								} else if (cate[1] == '대학교') {
									$('#university').show();
									$('#university .register_no').val(array[1]);
									$('#university_text').text($('#school').val());
									$('#university .duration').text(
											$('#schoolDate1').val() + " ~ "
													+ $('#schoolDate2').val());
									
								} else if (cate[1] == '대학원') {
									$('#graduateschool').show();
									$('#graduateschool .register_no').val(array[1]);
									$('#graduateschool_text').text($('#school').val());
									$('#graduateschool .duration').text(
											$('#schoolDate1').val() + " ~ "
													+ $('#schoolDate2').val());
								}
	 						}
	 						else
	 							alert('등록에 실패했습니다');
	 						
						},
						error : function() {
							alert("학력사항 등록 오류!");
	 						$('#school_type').attr('value', '');
							}

						});
					}					
				/* 수정에 대한 저장일 경우 */
				else
				{
					$('#school_category').attr('value', 'modify');
					var formData = $('#school_form').serialize();
					console.log(formData);
					var registerNo = $('#school_registerNo').val();
					console.log(registerNo);
					 $.ajax({
						type : "POST",
						url : "${pageContext.request.contextPath}/modifySchoolInfo.do",
						data : formData + "&registerNo=" + registerNo,
						success : function(res) {
							var msg = res.trim();
	 						if(msg == 'MODIFY-SUCCESS')
	 						{
		 						alert('수정되었습니다');
		 						/*
								 * 분류 - 고등학교로 저장 시 
								 */
								 var cate = $('#schoolCategory').val().split('/');
								if (cate[1] == '고등학교') {
									$('#highschool').show();
									$('#highschool_text').text($('#school').val());
									$('#highschool .duration').text(
											$('#schoolDate1').val() + " ~ "
													+ $('#schoolDate2').val());
								} else if (cate[1] == '대학교') {
									$('#university').show();
									$('#university_text').text($('#school').val());
									$('#university .duration').text(
											$('#schoolDate1').val() + " ~ "
													+ $('#schoolDate2').val());
								} else if (cate[1] == '대학원') {
									$('#graduateschool').show();
									$('#graduateschool_text').text($('#school').val());
									$('#graduateschool .duration').text(
											$('#schoolDate1').val() + " ~ "
													+ $('#schoolDate2').val());
									}	
			 					}else
			 						alert('수정에 실패했습니다');
			 						
								},
								error : function() {
									alert("학력사항 수정 오류!");
									}
								});
							}
					});
			
	/*
	 * 자격증 - 추가 클릭 시 
	 */
	$('#certificate_add_btn').on('click', function() {
		$('#certificate_modal').modal('show');

		/* 추가 모달이라는 속성 부여 */
		$('#certificate_type').attr('value', 'addCertificate');
		
		
	});
	/*
	 * 자격증 - 편집 클릭 시 
	 */
	$(document).on('click', '.line_component .certificate_modify_btn',function() {
		var certificate_ul = $(this).parent().parent().parent();
		$('#certificate_modal').modal('show');
		/* 값 초기화  */
		/* 자격증명 초기화 */
		$('#certificate').val($(certificate_ul).find('li .certificate_name_span').html());
		/* 취득일 초기화 */
		$('#certificate_date').val($(certificate_ul).find('li .certificate_date_span').html());
		/* 발행처 초기화 */
		$('#certificate_publication').val($(certificate_ul).find('li .certificate_publication_span').html());
		/* 등록번호 속성부여  */
		$('#certificate_key').attr('value', $(certificate_ul).find('li .certificate_register_span').html());
		/* 편집 모달이라는 속성 부여 */
		$('#certificate_type').attr('value', 'editCertificate');
	});
	/*
	 * 자격증 - 삭제 클릭 시 
	 */
	 $(document).on('click', '.line_component .certificate_delete_btn',function(){
			var target = $(this).parent().parent().parent().find('.certificate_register_span')
			var registerNo = target.html();
			var transfer = {"registerNo" : registerNo, "career_type" : "deleteCertificate"};
			$.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/deleteCertificate.do",
				data : transfer,
				dataType : 'json',
				success : function(res){
					if(res.result === "삭제 성공"){
						target.parent().parent().remove();
						alert("삭제하였습니다.");
					}else{
						alert("삭제에 실패하였습니다.");
					}
				},
				error : function(res){
					alert("실패");
				}
			});
		
	 });
	$('#save_certificate_btn').on('click', function() {
		$('#certificate_modal').modal('hide');
		/* 추가 모달이면 */
		if ($('#certificate_type').attr('value') == 'addCertificate') 
		{
			$('#resume_certificate h1').hide();

			var formData = $('#certificate_form').serializeObject();
			$.ajax({ 
				type : "POST",
				url : "${pageContext.request.contextPath}/addCertificate.do",
				data : formData,
				success : function(res) {
					var result = JSON.parse(res);
					$('#resume_certificate .panel-body').append(
						'<div class="line_component"><ul class="list-group">'
						+ '<li class="list-group-item">'
						+ '<span class="certificate_name_span">'
						+ result.name + '</span><span class="span_line_component">'
						+ '<button class="btn btn-primary certificate_modify_btn" type="button">편집</button>'
						+ '<button class="btn btn-primary certificate_delete_btn" type="button">삭제</button>'
						+ '</span></li>'
						+ '<li class="list-group-item"><span class="certificate_date_span">'
						+ result.date + '</span></li><li class="list-group-item"><span class="certificate_publication_span">'
						+ result.publication + '</span></li>'
						+ '<li class="hidden"><span class="certificate_register_span">'+result.registerNo +'</span></li></ul></div>');
					
					},
				error : function() {
						alert("서버 실패");
					}
				});
			$('#certificate_type').attr('value', '');
		} 
		/* 편집 모달이면 */
		else 
		{
			var formData = $('#certificate_form').serializeObject();
			$.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/editCertificate.do",
				data : formData,
				success : function(res) {
					var result = JSON.parse(res);
					/* var key = res.trim();
					alert(key); */
					var length = $('#resume_certificate ul').length;
					for(var i = 0 ; i < length; ++i){
						if($('#resume_certificate ul:eq('+i+') .certificate_register_span').html() == result.registerNo){
							$('#resume_certificate ul:eq('+i+') .certificate_name_span').html(result.name);
							$('#resume_certificate ul:eq('+i+') .certificate_date_span').html(result.date);
							$('#resume_certificate ul:eq('+i+') .certificate_publication_span').html(result.publication);
						}
					}
				},
				error : function() {
					alert("실패");
				}
			});
			$('#certificate_type').attr('value', '');
			/* $('#' + $('#activity_key').attr('value') + ' .date_span').text($('#activityDate1').val() + ' ~ ' + $('#activityDate2').val());
			$('#' + $('#activity_key').attr('value') + ' .content_span').text($('#activityContent').val()); */
		}

	});
	/*
	 * 병역사항
	 */
	 /* 추가 버튼 클릭 시 추가 속성 부여 */
	$('#add_military_btn').on('click', function(){
		$('#military_modal').modal('show');
		$('#military_form input').val('');
		$('#military_type').attr('value', 'add');
		$('#military_category').attr('value', 'military');

	});
	/* 수정 버튼 클릭 시 */
	$('#modify-military-btn').on('click', function(){
		$('#military_modal').modal('show');
		$('#military_type').attr('value', 'search');
		 var resume_category = $('#military_category').attr('value');

		 $.ajax({
				type : "GET",
				url  : "${pageContext.request.contextPath}/searchMilitary.do",
				data :  {
						type:'search',
						resume_category:resume_category,
					},
				success : function(response) {
					console.log(response);
					var data = JSON.parse(response);
					var msg = data.msg.trim();
					
					if(msg == 'SEARCH-SUCCESS')
					{
						$('#military-select').val(data.military_select).change();

						$("#militaryDate1").val(data.startDate);
						$("#militaryDate2").val(data.endDate);
						$("#militaryCategory").val(data.militaryCategoryCode + "/" + data.militaryCategory).change();
						$("#militaryClass").val(data.militaryRankCode + "/" + data.militaryRank).change();
					}
					else
						alert('병역사항 조회에 실패했습니다');
					
					$('#military_type').attr('value', '');
				},
				error : function() {
					alert("병역사항 조회 오류!");
					$('#military_type').attr('value', '');
				}

			});
	});
	/* 삭제 버튼 클릭 시 */
	$('#delete-military-btn').on('click', function(){
		if(confirm('정말로 삭제하시겠습니까? 복구가 안돼요')) 
		{
			var type = 'delete';
			 var resume_category = $('#military_category').attr('value');

			 $.ajax({
				type : "GET",
				url : "${pageContext.request.contextPath}/deleteMilitary.do",
				data : {
					type:'delete',
					resume_category:resume_category
				},
				success : function(res) {
					var msg = res.trim();

					if(msg == 'DELETE-SUCCESS')
					{
 						alert('삭제되었습니다');
 						$('#military').hide();	
 						$('#resume_military h1').show();
 						$('#add_military_btn').removeAttr('disabled');
					}
					else
						alert('삭제에 실패했습니다');
					$('#military_type').attr('value', '');
				},
				error : function() {
					alert("병역사항 삭제 오류!");
					$('#military_type').attr('value', '');
				}
			 });
		}
			
	});
	/* 저장 버튼 클릭 시 */ 
	$('#save-military-btn').on('click', function(){
		$('#military_modal').modal('hide');
		$('#resume_military h1').hide();
		
		/* 등록에 대한 저장일 경우 */
		if($('#military_type').attr('value') == 'add')
		{
			//$('#resume_military h1').hide();	
			var formData = $('#military_form').serialize();
			 $.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/addMilitary.do",
				data : formData,
				success : function(res) {
					var msg = res.trim();
					$('#military_type').attr('value', '');

					if(msg == 'ADD-SUCCESS')
					{
 						alert('등록되었습니다');
 						$('#military').show();		
 						$('#military_text').text($('#military-select option:selected').val());
 						$('#military .duration').text($('#militaryDate1').val() + " ~ " + $('#militaryDate2').val());
 					
 						$('#add_military_btn').attr('disabled', 'disabled');
					}
					else
						alert('등록에 실패했습니다');
					
				},
				error : function() {
					alert("병역사항 등록 오류!");
					$('#military_type').attr('value', '');
					}

				});
			}
		/* 수정에 대한 저장일 경우 */
		else
		{
			//$('#resume_military h1').hide();	
			var formData = $('#military_form').serialize();
			 $.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/modifyMilitary.do",
				data : formData,
				success : function(res) {
					var msg = res.trim();

					if(msg == 'MODIFY-SUCCESS')
					{
 						alert('수정되었습니다');
 						$('#military').show();		
 						$('#military_text').text($('#military-select option:selected').val());
 						$('#military .duration').text($('#militaryDate1').val() + " ~ " + $('#militaryDate2').val());
					}
					else
						alert('수정에 실패했습니다');
					
				},
				error : function() {
					alert("병역사항 수정 오류!");
					}

				});
			}
	});
	/*
	 * 보훈장애사항
	 */
	 /* 추가 버튼 클릭 시 추가 속성 부여 */
	 $('#add_remark_btn').on('click', function(){
		$('#unusual_modal').modal('show');
		$('#unusual_type select option:eq(0)').prop("selected", true);
		$('#unusual_type').attr('value', 'add');
		$('#unusual_category').attr('value', 'unusual');
	});
	/* 수정 버튼 클릭 시 */
	$('#modify-remark-btn').on('click', function(){
		$('#unusual_modal').modal('show');
		$('#unusual_type').attr('value', 'search');
		 var resume_category = $('#unusual_category').attr('value');

		 $.ajax({
				type : "GET",
				url  : "${pageContext.request.contextPath}/searchUnusual.do",
				data :  {
						type:'search',
						resume_category:resume_category,
					},
				success : function(response) {
					console.log(response);
					var data = JSON.parse(response);
					var msg = data.msg.trim();
					
					if(msg == 'SEARCH-SUCCESS')
					{
						$('#isRewarded').val(data.isRewarded).change();
						$("#isDisabled").val(data.isDisabled).change();
						$("#disabilityClass").val(data.disabilityCode + "/" +data.disability).change();
					}
					else
						alert('보훈장애사항 조회에 실패했습니다');
					
					$('#unusual_type').attr('value', '');
				},
				error : function() {
					alert("보훈장애사항 조회 오류!");
					$('#unusual_type').attr('value', '');
				}

			});
	});
	/* 삭제 버튼 클릭 시 */
	$('#delete-remark-btn').on('click', function(){
		if(confirm('정말로 삭제하시겠습니까? 복구가 안돼요'))
		{
			 var type = 'delete';
			 var resume_category = $('#unusual_category').attr('value');
			 $.ajax({
					type : "GET",
					url  : "${pageContext.request.contextPath}/deleteUnusual.do",
					data :  {
							type:'delete',
							resume_category:resume_category
						},
					success : function(res) {
						var msg = res.trim();

 						if(msg == 'DELETE-SUCCESS')
 						{
	 						alert('삭제되었습니다');
	 						$('#remark').hide();	
	 						$('#resume_remark h1').show();
	 						$('#unusual_add_btn').removeAttr('disabled');
 						}
 						else
 							alert('삭제에 실패했습니다');
					},
					error : function() {
						alert("보훈장애사항 삭제 오류!");
						}
					});
		}
	});
	/* 저장 버튼 클릭 시 */
	$('#save-unusual-btn').on('click', function(){
		$('#unusual_modal').modal('hide');
		$('#resume_remark h1').hide();

		/* 등록에 대한 저장일 경우 */
		if($('#unusual_type').attr('value') == 'add')
		{
			var formData = $('#unusual_form').serialize();
			 $.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/addUnusual.do",
				data : formData,
				success : function(res) {
					var msg = res.trim();
					$('#unusual_type').attr('value', '');

					if(msg == 'ADD-SUCCESS')
					{
 						alert('등록되었습니다');
 						$('#remark').show();		
 						$('#remark_text1').text("보훈 " + $('#isRewarded option:selected').val());

 	
 						var disability_select = $('#isDisabled option:selected').val();
 						if(disability_select == '대상')
 						{
 							//var class = $('#disabilityClass option:selected').val().split('/');
 							$('#remark_text2').text("장애 " + disability_select) //+ " " + class[1];
 						}
 						else
 							$('#remark_text2').text("장애 " + $('#isDisabled option:selected').val());
 					
 						$('#unusual_add_btn').attr('disabled', 'true');
					}
					else
						alert('등록에 실패했습니다');
					
				},
				error : function() {
					alert("보훈장애사항 등록 오류!");
					$('#unusual_type').attr('value', '');
					}

				});
			}
		/* 수정에 대한 저장일 경우 */
		else
		{
			var formData = $('#unusual_form').serialize();
			 $.ajax({
				type : "POST",
				url : "${pageContext.request.contextPath}/modifyUnusual.do",
				data : formData,
				success : function(res) {
					var msg = res.trim();

					if(msg == 'MODIFY-SUCCESS')
					{
 						alert('수정되었습니다');
 						$('#remark_text1').text("보훈 "+ $('#isRewarded option:selected').val());

 						var disability_select = $('#isDisabled option:selected').val();
 						if(disability_select == '대상')
 						{
 							$('#remark_text2').text("장애 " + disability_select) //+ " " + class[1];
 						}
 						else
 							$('#remark_text2').text("장애 " + $('#isDisabled option:selected').val());
					}
					else
						alert('수정에 실패했습니다');
					
				},
				error : function() {
					alert("보훈장애사항 수정 오류!");
					}
				});
			}
	});
	/*
     * 수상경력 - 추가 클릭 시 
     */
    $('#add-award-btn').on('click', function() {
       $('#award_modal').modal('show');

       /* 추가 모달이라는 속성 부여 */
       $('#award_type').attr('value', 'addAward');
       
       
    });
    /*
     * 수상경력 - 편집 클릭 시 
     */
    $(document).on('click', '.line_component .award_modify_btn',function() {
       var award_ul = $(this).parent().parent().parent();
       $('#award_modal').modal('show');
       /* 값 초기화  */
       /* 카테고리 초기화  */
       var category = $(award_ul).find('li .award_category_span').html();
       if(category == "IT 수상"){
          /* 필드 초기화  */
          $('#award-category option:eq(0)').prop('selected','selected');
          $('#award-field').show();
          var field = $('li .award_field_span').html();   
          
          // 수정 필요
          if(field == "동적으로"){
             $('#award-field option:eq(0)').prop('selected','selected');
          }else if(field == "받아와야"){
             $('#award-field option:eq(1)').prop('selected','selected');
          }else{
             $('#award-field option:eq(2)').prop('selected','selected');
          }
       }else{
          $('#award-field-form').hide();
          $('#award-field-form').val("");
          $('#award-category option:eq(1)').prop('selected','selected');
       }
       
       /* 수상자 초기화 */
       $('#award-target').val($(award_ul).find('li .award_target_span').html());
       /* 수상명 초기화 */
       $('#award-name').val($(award_ul).find('li .award_name_span').html());
       /* 수상일 초기화 */
       $('#award-date').val($(award_ul).find('li .award_date_span').html());
       /* 주최기관 초기화 */
       $('#award-publication').val($(award_ul).find('li .award_publication_span').html());
       /* 수상내역 초기화 */
       $('#award-content').val($(award_ul).find('li .award_content_span').html());
       
       /* 등록번호 속성부여  */
       $('#award_key').attr('value', $(award_ul).find('li .award_register_span').html());

       /* 편집 모달이라는 속성 부여 */
       $('#award_type').attr('value', 'editAward');
    });
    /*
     * 수상 경력 - 삭제 클릭 시 
     */
      $(document).on('click', '.line_component .award_delete_btn',function(){
          var target = $(this).parent().parent().parent().find('.award_register_span')
          var registerNo = target.html();
          var transfer = {"registerNo" : registerNo, "career_type" : "deleteAward"};
          $.ajax({
             type : "POST",
             url : "${pageContext.request.contextPath}/deleteAward.do",
             data : transfer,
             dataType : 'json',
             success : function(res){
                if(res.result === "삭제 성공"){
                   target.parent().parent().remove();
                   alert("삭제하였습니다.");
                }else{
                   alert("삭제에 실패하였습니다.");
                }
             },
             error : function(res){
                alert("서버 실패");
             }
          });
       
     });
    $('#save-award-btn').on('click', function() {
       $('#award_modal').modal('hide');
       $('#award-field-val').attr('value', $('#award-field option:selected').html());
       $('#award-category-val').attr('value', $('#award-category option:selected').html());
       /* 추가 모달이면 */
       if ($('#award_type').attr('value') == 'addAward') 
       {
          $('#resume_awards h1').hide();

          var formData = $('#award-form').serializeObject();
          var tmp;
          $.ajax({ 
             type : "POST",
             url : "${pageContext.request.contextPath}/addAward.do",
             data : formData,
             success : function(res) {
                var result = JSON.parse(res);
                $('#resume_awards .panel-body').append(
                   '<div class="line_component"><ul class="list-group">'
                   + '<li class="list-group-item"><span class="img_span">'
                   + '<img src="${path}/resources/images/icons/Award.png" width="32"height="32">'
                   + '</span><span class="award_category_span">'
                   + result.category
                   + '</span><span class="span_line_component">'
                   + '<button class="btn btn-primary award_modify_btn" type="button">편집</button>'
                   + '<button class="btn btn-primary award_delete_btn" type="button">삭제</button>'
                   + '</span></li>'
                   + '<li class="list-group-item"><span class="award_field_span">'
                   + result.field + '</span></li><li class="list-group-item"><span class="award_target_span">'
                   + result.target + '</span></li><li class="list-group-item"><span class="award_name_span">'
                   + result.name + '</span></li><li class="list-group-item"><span class="award_date_span">'
                   + result.date + '</span></li>'
                   + '<li class="list-group-item"><span class="award_publication_span">'
                   + result.publication + '</span></li><li class="list-group-item"><span class="award_content_span">'
                   + result.content + '</span></li>'
                   + '<li class="hidden"><span class="award_register_span">'+result.registerNo +'</span></li></ul></div>');                     
                },
             error : function() {
                   alert("서버 실패");
                }
             });
          $('#award_type').attr('value', '');
       } 
       /* 편집 모달이면 */
       else 
       {
          var formData = $('#award-form').serializeObject();
          $.ajax({
             type : "POST",
             url : "${pageContext.request.contextPath}/editAward.do",
             data : formData,
             success : function(res) {
                var result = JSON.parse(res);
                /* var key = res.trim();
                alert(key); */
                var length = $('#resume_awards ul').length;
                for(var i = 0 ; i < length; ++i){
                   if($('#resume_awards ul:eq('+i+') .award_register_span').html() === result.registerNo){
                      $('#resume_awards ul:eq('+i+') .award_category_span').html(result.category);
                      $('#resume_awards ul:eq('+i+') .award_field_span').html(result.field);
                      /* if(result.category === "기타수상"){
                         $('#resume_award ul:eq('+i+') .award_field_span').parent().hide();
                      }else{
                         $('#resume_award ul:eq('+i+') .award_field_span').parent().show();
                      } */
                      $('#resume_awards ul:eq('+i+') .award_target_span').html(result.target);
                      $('#resume_awards ul:eq('+i+') .award_name_span').html(result.name);
                      $('#resume_awards ul:eq('+i+') .award_date_span').html(result.date);
                      $('#resume_awards ul:eq('+i+') .award_publication_span').html(result.publication);
                      $('#resume_awards ul:eq('+i+') .award_content_span').html(result.content);
                   }
                }
             },
             error : function() {
                alert("서버 실패");
             }
          });
          $('#award_type').attr('value', '');
          
       }

    });
    /*
     * 경력사항 - 추가 클릭 시 
     */
    $('#career_add_btn').on('click', function() {
       $('#career_modal').modal('show');

       /* 추가 모달이라는 속성 부여 */
       $('#career_type').attr('value', 'addCareer');
    });
    /*
     * 경력 사항 - 편집 클릭 시 
     */
    $(document).on('click','.line_component .career_modify_btn',function() {
       var ul = $($(this).parent().parent().parent());
       /* 값 초기화  */
       /* 회사명 초기화  */
       $('#company').val($(ul).find('li .career_company_span').html());
       /* 기간 초기화  */
       var date = $(ul).find('li .career_date_span').html().split(' ');
       $('#companyDate1').val(date[0] +' '+date[1]);
       $('#companyDate2').val(date[3] +' '+date[4]);
       /* 직급 초기화 */
       $('#companyPosition').val($(ul).find('li .career_position_span').html());
       /* 부서 초기화  */
       $('#companyDepartment').val($(ul).find('li .career_department_span').html());
       /* 담당업무 초기화 */
       $('#companyTask').val($(ul).find('li .career_task_span').html());
       /* 퇴직사유 초기화 */
       $('#retirementReason').val($(ul).find('li .career_retirement_span').html());
       /* 모달 출력 */
       $('#career_modal').modal('show');
       /* 추가 모달이라는 속성 부여 */
       $('#career_type').attr('value', 'editCareer');
       $('#career_key').attr('value', $(ul).find('li .career_register_span').html());
    });
    $('#save-career-btn').on('click', function() {
       $('#career_modal').modal('hide');

       /* 추가 모달이면 */
       if ($('#career_type').attr('value') == 'addCareer') 
       {
          $('#resume_career h1').hide();

          var formData = $('#career-form').serializeObject();
          $.ajax({
             type : "POST",
             url : "${pageContext.request.contextPath}/addCareer.do",
             data : formData,
             success : function(res) {
                var result = JSON.parse(res);
                $('#resume_career .panel-body').append(
                            '<div class="line_component"><ul class="list-group">'
                            + '<li class="list-group-item">'
                            + '<span class="img_span"><img src="${path}/resources/images/icons/bag.png" width="32"height="32"></span>'
                            + '<span class="career_company_span">'
                            + result.name + '</span>'
                            + '<span class="span_line_component">'
                            + '<button class="btn btn-primary career_modify_btn" type="button">편집</button>'
                            + '<button class="btn btn-primary career_delete_btn" type="button">삭제</button>'
                            + '</span></li>'
                            + '<li class="list-group-item"><span class="career_date_span">'
                            + result.startDate + ' ~ ' + result.endDate
                            + '</span></li><li class="list-group-item"><span class="career_position_span">'
                            + result.position
                            + '</span></li><li class="list-group-item"><span class="career_department_span">'
                            + result.department + '</span></li><li class="list-group-item"><span class="career_task_span">'
                            + result.task + '</span></li><li class="list-group-item"><span class="career_retirement_span">'
                            + result.reason + '</span></li><li class="hidden"><span class="career_register_span">'
                            + result.registerNo + '</span></li></ul></div>');

                //$('#resume_career .span_line_component:last').hide();

                
             },
             error : function() {
                alert("서버 실패");
             }
          });
          $('#career_type').attr('value', '');
       }
       /* 
        * 편집 모달이면 
        */
       else{
          var formData = $('#career-form').serializeObject();
          $.ajax({
             type : "POST",
             url : "${pageContext.request.contextPath}/editCareer.do",
             data : formData,
             success : function(res) {
                var result = JSON.parse(res);
                /* var key = res.trim();
                alert(key); */
                var length = $('#resume_career ul').length;
                for(var i = 0 ; i < length; ++i){
                   if($('#resume_career ul:eq('+i+') .career_register_span').html() == result.registerNo){
                      $('#resume_career ul:eq('+i+') .career_company_span').html(result.name);
                      $('#resume_career ul:eq('+i+') .career_date_span').html(result.startDate +' ~ '+result.endDate);
                      $('#resume_career ul:eq('+i+') .career_position_span').html(result.position);
                      $('#resume_career ul:eq('+i+') .career_department_span').html(result.department);
                      $('#resume_career ul:eq('+i+') .career_task_span').html(result.task);
                      $('#resume_career ul:eq('+i+') .career_retirement_span').html(result.reason);
                   }
                }
             },
             error : function() {
                alert("서버 실패");
             }
          });
          $('#career_type').attr('value', '');
          /* $('#' + $('#activity_key').attr('value') + ' .date_span').text($('#activityDate1').val() + ' ~ ' + $('#activityDate2').val());
          $('#' + $('#activity_key').attr('value') + ' .content_span').text($('#activityContent').val()); */
       }
    });
    /*
     * 경력 사항 - 삭제 클릭 시 
     */
     $(document).on('click','.line_component .career_delete_btn' ,function(){
          var target = $(this).parent().parent().parent().find('.career_register_span')
          var registerNo = target.html();
          var transfer = {"registerNo" : registerNo, "career_type" : "deleteCareer"};
          $.ajax({
             type : "POST",
             url : "${pageContext.request.contextPath}/deleteCareer.do",
             data : transfer,
             dataType : 'json',
             success : function(res){
                if(res.result === "삭제 성공"){
                   target.parent().parent().remove();
                   alert("삭제하였습니다.");
                }else{
                   alert("삭제에 실패하였습니다.");
                }
             },
             error : function(res){
                alert("실패");
             }
          });
       
     });
    /*
     * 봉사/대외활동 - 추가 클릭 시 
     */
    $('#activity_add_btn').on('click', function() {
       $('#activity_modal').modal('show');

       /* 추가 모달이라는 속성 부여 */
       $('#activity_type').attr('value', 'addActivity');
    });
    /*
     * 봉사/대외활동 - 편집 클릭 시 
     */
    $(document).on('click', '.line_component .activity_modify_btn',function() {
       var ul = $($(this).parent().parent().parent());
       /* 값 초기화  */
       /* 카테고리 초기화  */
       var category = $(ul).find('li .activity_category_span').html();
       if(category == "봉사 활동"){
          $('#activity_category_code option:eq(0)').prop('selected','selected');
       }else if(category == "대외 활동"){
          $('#activity_category_code option:eq(1)').prop('selected','selected');
       }else{
          $('#activity_category_code option:eq(2)').prop('selected','selected');
       }
       /* 날짜 초기화  */
       var date = $('li .activity_date_span').html().split(' ');
       $('#activityDate1').val(date[0] +' '+date[1]);
       $('#activityDate2').val(date[3] +' '+date[4]);
       /* 내용 초기화 */
       $('#activityContent').val($(ul).find('li .activity_content_span').html());
       /* 등록번호 속성 추가  */
       $('#activity_key').attr('value', $(ul).find('li .activity_register_span').html());
       /* 모달 출력 */
       $('#activity_modal').modal('show');
       /* 추가 모달이라는 속성 부여 */
       $('#activity_type').attr('value', 'editActivity');
    });
    /*
     * 봉사/대외활동 - 삭제 클릭 시 
     */
     $(document).on('click', '.line_component .activity_delete_btn',function(){
          var target = $(this).parent().parent().parent().find('.activity_register_span')
          var registerNo = target.html();
          var transfer = {"registerNo" : registerNo, "activity_type" : "deleteActivity"};
          $.ajax({
             type : "POST",
             url : "${pageContext.request.contextPath}/deleteActivity.do",
             data : transfer,
             dataType : 'json',
             success : function(res){
                if(res.result === "삭제 성공"){
                   target.parent().parent().remove();
                   alert("삭제하였습니다.");
                }else{
                   alert("삭제에 실패하였습니다.");
                }
             },
             error : function(res){
                alert("서버 실패");
             }
          });
       
     });
    /*
     * 봉사/대외활동 - 저장 클릭 시 
     */
    $('#save-activity-btn').on('click', function() {
       $('#activity_modal').modal('hide');
       $('#activity_category').attr('value',$('#activity_category_code option:selected').html());
       /* 추가 모달이면 */
       if ($('#activity_type').attr('value') == 'addActivity') 
       {
          $('#resume_activity h1').hide();
 
          var formData = $('#activity-form').serializeObject();
          $.ajax({
             type : "POST",
             url : "${pageContext.request.contextPath}/addActivity.do",
             data : formData,
             success : function(res) {
                var result = JSON.parse(res);
                /* var key = res.trim();
                alert(key); */
                $('#resume_activity .panel-body').append('<div class="line_component"><ul class="list-group">'
                      + '<li class="list-group-item">'
                      + '<span class="img_span"><img src="${path}/resources/images/icons/running-silhouettes.png" '
                      + 'width="32" height="32"></span>'
                      + '<span class="activity_category_span">'+result.category+'</span>'
                      + '<span class="span_line_component">'
                      + '<button class="btn btn-primary activity_modify_btn" type="button">편집</button>'
                      + '<button class="btn btn-primary activity_delete_btn" type="button">삭제</button>'
                      + '</span></li>'
                      + '<li class="list-group-item"><span ' 
                      + 'class="activity_date_span">' +result.startDate+' ~ '+ result.endDate + '</span></li>'
                      + '<li class="list-group-item"><span class="activity_content_span">'+result.content+'</span>'
                      + '</li><li class="hidden"><span class="activity_register_span">'+result.registerNo +'</span>'
                      + '</li></ul></div>');
                      $('#activity_type').attr('value', '');
                },
             error : function() {
                alert("서버 실패");
             }
          });
       } 
       /* 편집 모달이면 */
       else {
          var formData = $('#activity-form').serializeObject();
          $.ajax({
             type : "POST",
             url : "${pageContext.request.contextPath}/editActivity.do",
             data : formData,
             success : function(res) {
                var result = JSON.parse(res);
                /* var key = res.trim();
                alert(key); */
                var length = $('#resume_activity ul').length;
                for(var i = 0 ; i < length; ++i){
                   if($('#resume_activity ul:eq('+i+') .activity_register_span').html() == result.registerNo){
                      $('#resume_activity ul:eq('+i+') .activity_category_span').html(result.category);
                      $('#resume_activity ul:eq('+i+') .activity_date_span').html(result.startDate +' ~ '+result.endDate);
                      $('#resume_activity ul:eq('+i+') .activity_content_span').html(result.content);
                   }
                }
             },
             error : function() {
                alert("서버 실패");
             }
          });
          $('#activity_type').attr('value', '');
       }
    });
    
    /* 사진 모달 */
    	$("#photo-select-btn").change(function() {
    				var uurl = window.URL.createObjectURL(this.files[0]);
    				$('#profileImg').attr('src',
    						window.URL.createObjectURL(this.files[0]));
    			});

    	$("#photo-delete-btn").click(function() {
    			$('#profileImg').attr('src',
    					"https://www.garajyeri.com/public/images/no_pic.png");
    		});
    	/*
    	 * 저장 버튼 클릭 시 비동기처리로 폼 전송
    	 */
    	$('#photo-save-btn').on('click', function() {
    	    var src = $('#profileImg').attr('src');
    	    
    		if(src != "https://www.garajyeri.com/public/images/no_pic.png")
    		{
    	       var formData = new FormData();
    	       var file = $('#photo-select-btn')[0].files[0];
    	       formData.append("uploadfile", file);
    	       
    	       console.log(formData.get("uploadfile"));
    	       $.ajax({
    	    	   	type:"POST",
    	            url:"${pageContext.request.contextPath}/uploadPhoto.do",
    	            processData:false,
    	            contentType:false,
    	            data:formData,
    	            success:function(data){
    	            	var res = data.trim();
    	            	if(res == 'UPLOAD-SUCCESS')
    	            		alert("사진을 업로드하였습니다.");
    	            	else if(res == 'UPLOAD-FAIL')
    	            		alert("사진 업로드에 실패하였습니다.");
    	            	
    	            	$('#photo_img').attr('src',
        						window.URL.createObjectURL(file));

    	            },error:function(err){
    	            	console.log(err);
    		           alert("사진 업로드 서버 실패.");
    	           }
    	       });
    		}
    		else{
        	       $.ajax({
        	    	   	type:"GET",
        	            url:"${pageContext.request.contextPath}/deletePhoto.do",
        	            processData:false,
        	            contentType:false,
        	            success:function(data){
        	            	var res = data.trim();
        	            	if(res == 'DELETE-SUCCESS')
        	            		alert("사진을 삭제하였습니다.");
        	            	else if(res == 'DELETE-FAIL')
        	            		alert("사진 삭제에 실패하였습니다.");
        	            	
        	            	$('#photo_img').attr('src',
            					"https://www.garajyeri.com/public/images/no_pic.png");
        	        
        	            },error:function(err){
        		           alert("사진 삭제 서버 실패.");
        	           }
        	       });
    		}
    	       $('#photo_modal').modal('hide');
    	});

    	$('#preview_btn').on('click', function(){
    	 $('#preview_form').submit();
    	});
    	
	$.fn.serializeObject = function(){
	    var o = {};
	    var a = this.serializeArray();
	    $.each(a, function() {
	    	var name = $.trim(this.name),
	    		value = $.trim(this.value);
	    	
	        if (o[name]) {
	            if (!o[name].push) {
	                o[name] = [o[name]];
	            }
	            o[name].push(value || '');
	        } else {
	            o[name] = value || '';
	        }
	    });
	    return o;
	};
 });
</script>
</body>
</html>

