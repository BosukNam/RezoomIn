<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>포트폴리오 미리보기</title>

<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/dataTables.bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link href="../css/footer.css" rel="stylesheet" type="text/css">

<!-- chart js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
<!-- 이미지 촬영 -->
</head>

<body>
 <jsp:include page="header.jsp"></jsp:include>
 
 <div class="container fluid" style="padding-top:100px;" id="asdfd">
	<div class="panel panel-default" style="width:800px; height:550px; margin:0 auto">
	  <div class="panel-heading">포트폴리오 미리보기</div>
		<div class="panel-body">
			<div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="false">
			
				<!-- indicators -->
				<ol class="carousel-indicators" id="indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				</ol>

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
				<!-- 개발 가능 언어 4개, 5개인 경우 프로필 시작 -->
					<div class="item active">
						<div class="carousel-content"><br>
							<div class="row">
								<div class="col-md-3 col-md-offset-2">
									<img src="/TestFinalProject/resources/images/hwang.JPG" width="200px" height="180px">
									<h4 align="center">${requestScope.profile.name }(28)</h4>
									<p align="center">${requestScope.profile.birthDate }
									<p>
								</div>

								<div class="col-md-5 col-md-offset-1"> <br>
								<div class="col-md-offset-1" style="width:300px; height:200px;" >
							  	<canvas id="horizontal-barChart" width="300" height="200"></canvas>
								</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-5 col-md-offset-2">
								<h2>수상경력</h2>
									<br>
								<c:forEach var ="award" items="${requestScope.Award}">
   									<c:if test="${award.category =='IT 수상'}">
										<p>● ${award.content}
										(${award.target }, ${award.date})<p>
    								</c:if>
    							</c:forEach>
								</div>
								<div class="col-md-5">
									<h2>개발 가능 툴</h2>
									<br>
									<c:forEach var ="tool" items="${requestScope.programmingSkill}">
									
									<c:if test="${tool.value.field =='1'}">
    									<input type="hidden" class="languageName" value="${tool.value.name}">
    									<input type="hidden" class="languagelevel" value="${tool.value.skill_rank_name}">
    								</c:if>
    								<c:if test="${tool.value.field =='0'}">
    									<p>● ${tool.value.name}<p>
    								</c:if> 
    								</c:forEach>
							</div>
						</div>
					</div>
					</div>
					<!-- 개발 가능 언어 4개, 5개인 경우 프로필 끝 -->
					
					
					
					<!-- 프로젝트 -->
					<div class="item">
						<div class="carousel-content">
							<div>
								<h1 style="margin-top:200px" align="center">프로젝트</h1> <hr>
							</div>
						</div>
					</div>
					
					<!-- 목차 시작 -->
					<div class="item">
						<div class="carousel-content"><br>
							 <div class="col-md-offset-1 col-md-5">
								<img src="${pageContext.request.contextPath }/resources/images/index.png" width="300px" height="470px">
							</div>
							 <div class="col-md-offset-1">
								<h1>프로젝트 개요</h1>
								<c:if test="${!empty requestScope.projectIntro}">
    									<h4>● 프로젝트 소개</h4>
    							</c:if>
								<c:if test="${!empty requestScope.developmentEnvironment }">
    									<h4>● 개발 기간</h4>
    							</c:if>
								<c:if test="${!empty requestScope.developmentEnvironment }">
    									<h4>● 개발 인원</h4>
    							</c:if>
    							<c:set var="doneLoop" value="false" />   
								<c:forEach var ="tool" items="${requestScope.programmingSkill}">
									<c:if test="${not doneLoop}">
    									<c:if test="${tool.value.field =='0'}">
    										<c:forEach var = "use" items="${ requestScope.useSkill }">
    										<c:if test ="${use.name eq tool.value.name}">
    											<h4>● 개발 툴</h4>
    											<c:set var="doneLoop" value="true" />
    										</c:if> 
    										
    										</c:forEach>
    										
    									</c:if>
    								 </c:if>
    							</c:forEach>
								<br><br><br>
								<c:if test="${!empty requestScope.MRAT }">
    									<h2>주요 역할 및 담당</h2>
										<h4>● 주요 역할 및 담당</h4>
    							</c:if>
								
							</div>
						</div>
					</div>
					<div class="item">
						<div class="carousel-content"><br>
							 <div class="col-md-offset-1 col-md-5">
								<img src="${pageContext.request.contextPath }/resources/images/index.png" width="300px" height="470px">
							</div>
							 <div class="col-md-offset-1">
								<h1>프로젝트 내용</h1>
								
								<c:set var="doneLoop" value="false" />   
								<c:forEach var ="language" items="${requestScope.programmingSkill}">
									<c:if test="${not doneLoop}">
    									<c:if test="${language.value.field =='1'}">
    										<c:forEach var = "use" items="${ requestScope.useSkill }">
    										<c:if test ="${use.name eq language.value.name}">
    											<h4>● 사용 언어 기술</h4>
    											<c:set var="doneLoop" value="true" />
    										</c:if> 
    										</c:forEach>
    									</c:if>
    								 </c:if>
    							</c:forEach>
    							<c:if test="${!empty requestScope.library}">
    								<h4>● 라이브러리(Framework)</h4>
    							</c:if>
    							<c:if test="${!empty requestScope.systemArchitecture or !empty requestScope.softwareArchitecture}">
    								<h4>● 프로그램 환경</h4>
    								<c:if test="${!empty requestScope.systemArchitecture}">
    									<h5> - System Architecture</h5>
    								</c:if>
    								<c:if test="${!empty requestScope.softwareArchitecture}">
    									<h5> - Software Architecture</h5>
    								</c:if>
    							</c:if>
							</div>
						</div>
					</div>
					<!-- 목차 끝 -->
					
					<!-- 개요 시작 -->
					<div class="item">
						<div class="carousel-content">
							<div class="col-md-offset-2">
									<h1 style="margin-top: 200px;">프로젝트 소개</h1>
							</div>
							<hr>
							<div class="col-md-offset-8">
									<c:if test="${!empty requestScope.projectIntro}">
    									<h4>● 프로젝트 소개</h4>
    							</c:if>
								<c:if test="${!empty requestScope.developmentEnvironment }">
    									<h4>● 개발 기간</h4>
    							</c:if>
								<c:if test="${!empty requestScope.developmentEnvironment }">
    									<h4>● 개발 인원</h4>
    							</c:if>
    							<c:set var="doneLoop" value="false" />   
								<c:forEach var ="tool" items="${requestScope.programmingSkill}">
									<c:if test="${not doneLoop}">
    									<c:if test="${tool.value.field =='0'}">
    										<c:forEach var = "use" items="${ requestScope.useSkill }">
    										<c:if test ="${use.name eq tool.value.name}">
    											<h4>● 개발 툴</h4>
    											<c:set var="doneLoop" value="true" />
    										</c:if> 
    										
    										</c:forEach>
    										
    									</c:if>
    								 </c:if>
    							</c:forEach>
								
								<br>
								<c:if test="${!empty requestScope.MRAT }">
     							<h3>주요 역할 및 담당</h3>
										<h4>● 주요 역할 및 담당</h4> 
    							</c:if>
							</div>
						</div>
					</div>
					
					<c:if test="${!empty requestScope.projectIntro}">
    				<div class="item">
						<div class="carousel-content">
						  	<div class="col-md-offset-1">
								<h2> 개요 <small> 프로젝트 소개</small></h2> <hr>
							</div>
							<div class="col-md-offset-1">
							<h3> ● 기획 의도</h3>
							 <h5> - 자바 프로그램 언어 입문서 </h5>
							 <img src="${pageContext.request.contextPath }/resources/images/example.JPG" width="700px" height="300px">
							</div>
						</div>
					</div>
    				</c:if>
					<c:if test="${!empty requestScope.developmentEnvironment }">
    				<div class="item">
						<div class="carousel-content">
						  <div class="col-md-offset-1">
								<h2> 개요 <small> 개발기간 및 개발인원</small> </h2> <hr>
							</div>
						</div>
					</div>
    				</c:if>
					<c:set var="doneLoop" value="false" />   
								<c:forEach var ="language" items="${requestScope.programmingSkill}">
									<c:if test="${not doneLoop}">
    									<c:if test="${language.value.field =='0'}">
    										<c:forEach var = "use" items="${ requestScope.useSkill }">
    											<c:if test ="${use.name eq language.value.name}">
    											<div class="item">
													<div class="carousel-content">
													  <div class="col-md-offset-1">
															<h2> 개요 <small> 개발 툴</small> </h2> <hr>
														</div>
														<c:forEach var ="pass" items="${requestScope.programmingSkill}">
    														<c:if test="${pass.value.field =='0'}">
    															<c:forEach var = "man" items="${ requestScope.useSkill }">
    																<c:if test ="${man.name eq pass.value.name}">
																		<div class="col-md-offset-1">
																		<div class='col-xs-4 col-md-3'>
									    									<div class='thumbnail'> 
									    									<div class='lang-thumb'><img src= '${pageContext.request.contextPath }${pass.value.skill_name_image } 'alt='' width="100px" height="100px">
									    									<div class='caption' id="${pass.value.name}" style="text-align: center;">${pass.value.name}</div>
									    									<input type="hidden" value=${pass.value.register_no } class="hidden_language">
									    									</div></div></div>
																		</div>
																	</c:if>
																</c:forEach>
															</c:if>
														</c:forEach>
													</div>
												</div>
    											<c:set var="doneLoop" value="true" />
    										</c:if>
    										</c:forEach>
    									</c:if>
 								 </c:if>
						</c:forEach>
					<c:if test="${!empty requestScope.MRAT }">
					<!-- <div class="item">
						<div class="carousel-content">
						  <div class="col-md-offset-1">
								<h2> 개요 <small> 주요 역할 및 담당 업무</small> </h2> <hr>
							</div>
						</div>
					</div> -->
    				</c:if>
					
					<!-- 개요 끝 -->
					
					 <!-- 주요 역할 및 담당 시작
					<div class="item">
						<div class="carousel-content">
							<div class="col-md-offset-2">
									<h1 style="margin-top: 200px;">주요 역할 및 담당</h1>
							</div>
							<hr>
							<div class="col-md-offset-8">
									<h4>주요 역할 및 담당</h4>
							</div>
						</div>
					</div>
					
					<div class="item">
						<div class="carousel-content">
						  <div class="col-md-offset-1">
								<h2>주요 역할 및 담당</h2> <hr>
							</div>
						</div>
					</div>
					주요 역할 및 담당 끝 --> 
					
					<!-- 프로젝트 내용 시작 -->
					<div class="item">
						<div class="carousel-content">
							<div class="col-md-offset-2">
									<h1 style="margin-top: 200px;">프로젝트 내용</h1>
							</div>
							<hr>
							<div class="col-md-offset-8">
							<c:set var="doneLoop" value="false" />   
							<c:forEach var ="language" items="${requestScope.programmingSkill}">
									<c:if test="${not doneLoop}">
    									<c:if test="${language.value.field =='1'}">
    										<c:forEach var = "use" items="${ requestScope.useSkill }">
    										<c:if test ="${use.name eq language.value.name}">
    											<h4>● 사용 언어 기술</h4>
    											<c:set var="doneLoop" value="true" />
    										</c:if> 
    										</c:forEach>
    									</c:if>
    								 </c:if>
    							</c:forEach>
    							<c:if test="${!empty requestScope.library}">
    								<h4>● 라이브러리(Framework)</h4>
    							</c:if>
    							<c:if test="${!empty requestScope.systemArchitecture or !empty requestScope.softwareArchitecture}">
    								<h4>● 프로그램 환경</h4>
    								<c:if test="${!empty requestScope.systemArchitecture}">
    									<h5>- System Architecture</h5>
    								</c:if>
    								<c:if test="${!empty requestScope.softwareArchitecture}">
    									<h5>- Software Architecture</h5>
    								</c:if>
    							</c:if>
							</div>
						</div>
					</div>
					<c:set var="doneLoop" value="false" />   
								<c:forEach var ="language" items="${requestScope.programmingSkill}">
									<c:if test="${not doneLoop}">
    									<c:if test="${language.value.field =='1'}">
    										<c:forEach var = "use" items="${ requestScope.useSkill }">
    											<c:if test ="${use.name eq language.value.name}">
    											<div class="item">
													<div class="carousel-content">
													  <div class="col-md-offset-1">
															<h2> 내용 <small> 사용기술 언어</small> </h2> <hr>
														</div>
														<c:forEach var ="pass" items="${requestScope.programmingSkill}">
    														<c:if test="${pass.value.field =='1'}">
    															<c:forEach var = "man" items="${ requestScope.useSkill }">
    																<c:if test ="${man.name eq pass.value.name}">
																		<div class="col-md-offset-1">
																		<div class='col-xs-4 col-md-3'>
									    									<div class='thumbnail'> 
									    									<div class='lang-thumb'><img src= '${pageContext.request.contextPath }${pass.value.skill_name_image } 'alt='' width="100px" height="100px">
									    									<div class='caption' id="${pass.value.name}" style="text-align: center;" >${pass.value.name}</div>
									    									<input type="hidden" value=${pass.value.register_no } class="hidden_language">
									    									</div></div></div>
																		</div>
																	</c:if>
																</c:forEach>
															</c:if>
														</c:forEach>
													</div>
												</div>
    											<c:set var="doneLoop" value="true" />
    										</c:if>
    										</c:forEach>
    									</c:if>
 								 </c:if>
						</c:forEach>
					<c:if test="${!empty requestScope.library}">
						<div class="item">
							<div class="carousel-content">
							  <div class="col-md-offset-1">
									<h2> 내용 <small> 라이브러리(Framework)</small> </h2> <hr>
								</div>
							</div>
						</div>
					</c:if>
	
					<!-- 프로젝트 내용 끝 -->
					
					<!-- 프로그램 설계 구조 시작 -->
					<div class="item">
						<div class="carousel-content">
							<div class="col-md-offset-2">
									<h1 style="margin-top: 200px;">프로그램 환경 </h1>
							</div>
							<hr>
							<div class="col-md-offset-8">
									<h4>● System Architecture</h4>
									<h4>● Software Architecture</h4>
							</div>
						</div>
					</div>
					<c:if test="${!empty requestScope.systemArchitecture}">
					<c:if test="${ requestScope.systemArchitecture.tier_category ne 'ti1'}">
					<div class="item">
						<div class="carousel-content">
						  <div class="col-md-offset-1">
								<h2> 프로그램 설계 구조 <small> System Architecture 네트워크 기반</small> </h2> <hr>
							</div>
						  <div class="col-md-offset-1">
						  <img src="http://www.webonspot.com/images/slideicon/Create%20a%20Modern%20Website.png" 
						  style="width:250px; height:200px;">
						  <img src="https://openclipart.org/image/2400px/svg_to_png/163741/web-server.png"
						  style="width:180px; height:200px;">
							</div>
						</div>
					</div>
					</c:if>
					<c:if test="${ requestScope.systemArchitecture.tier_category eq 'ti1'}">
					<div class="item">
						<div class="carousel-content">
						  <div class="col-md-offset-1">
								<h2> 프로그램 설계 구조 <small> System Architecture 비 네트워크 기반</small> </h2> <hr>
							</div>
						</div>
					</div>
					</c:if>
					</c:if>
					<c:if test="${!empty requestScope.usecaseValue}">
					<div class="item">
						<div class="carousel-content">
						  <div class="col-md-offset-1">
								<h2> Software Architecture <small> 유즈케이스</small> </h2> <hr>
							</div>
							<div class="col-md-offset-2" >
							<div class="usecase12">
								<img src="${pageContext.request.contextPath }/resources/images/usecase/usecase.JPG" alt=""
							height="380px">
								<div class="actor">
									${requestScope.usecaseValue.actor }
								</div>
								<div class="case1"> ${requestScope.usecaseValue.case1 } 
								<br><br><br><br>
								 ${requestScope.usecaseValue.case2 }
								<br><br><br><br><br>
								 ${requestScope.usecaseValue.case3 }
								 <br><br><br><br>
								  ${requestScope.usecaseValue.case4 }
								    
								</div>
							</div>
							
							</div>
						</div>
					</div>
					</c:if>
					<c:if test="${!empty requestScope.softwareArchitecture}">
					<div class="item">
						<div class="carousel-content">
						  <div class="col-md-offset-1">
								<h2> Software Architecture <small> 다이어그램</small> </h2> <hr>
							</div>
							<div class="col-md-offset-2" >
							<div class="usecase12">
								<img src="${pageContext.request.contextPath }/resources/images/diagram.jpg" alt=""
							height="380px" width="500px">
								</div>
							</div>
							
							</div>
						</div>
					</c:if>
					
					<!-- 프로그램 설계 구조 끝 -->
					
				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
	</div>
</body>



<style>
	#myCarousel {
	  width: 800px;
	  height:550px;
	}
	.carousel-inner{
	  width: 800px;
	  max-height: 550px !important;
	}
	.panel-body{
		padding:0px;
	}
	.carousel-control.left, .carousel-control.right {
    background-image: none
	}
	.carousel-indicators {
	    bottom: 40px;
	}
	.carousel-indicators li{
	border:1px solid #D3D3D3;
	}
	.carousel-indicators .active {
    background-color: #D3D3De;
    }
    
    .usecase12{
    	position:relative;
    }
    .usecase12 .case1{
    	position:absolute;
    	top:45px;
    	left:290px;
    	width:700px;
    }
    .actor{
    	position:absolute;
    	top:250px;
    	left:40px;
    	width:700px;
    }
    

	#donut-example1{
	min-height:200px;
	}
	#donut-example2{
	min-height:200px;
	}
	#donut-example3{
	min-height:200px;
	}
	
	.donuts .col-md-offset-1 {
	    margin-left: 6%;
	}
	.progress-class{
	margin:auto;
	}
	.progress-bar-vertical {
	  width: 20px;
	  min-height: 170px;
	  display: flex;
	  align-items: flex-end;
	  margin-right: 20px;
	  float: left;
	}
	
	.progress-bar-vertical .progress-bar {
	  width: 100%;
	  height: 0;
	  -webkit-transition: height 0.6s ease;
	  -o-transition: height 0.6s ease;
	  transition: height 0.6s ease;
	}

</style>

<script>
/* 
 * indicator 개수 item 개수(페이지 수)에 맞게 동적으로 생성
 */
$(function(){
	for(var i = 1; i < $('.item').size(); i++)
		$('#indicators').append('<li data-target="#myCarousel" data-slide-to=' + i + '></li>');
	 
	
});

/* var ctx = $('#pieChart1');
var myChart = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: ["java"],
        datasets: [{
            label: '# of Votes',
            data: [80],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
            ],
            borderColor: [
                'rgba(255,99,132,1)',
            ],
            borderWidth: 1
        }]
    },
    options: {
         responsive: true,
        maintainAspectRatio: true
    }
});
var ctx = $('#pieChart2');
var myChart = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: ["jsp"],
        datasets: [{
            label: '# of Votes',
            data: [70],
            backgroundColor: [
              'rgba(54, 162, 235, 0.2)',
            ],
            borderColor: [
             'rgba(54, 162, 235, 1)',
            ],
            borderWidth: 1
        }]
    },
    options: {
         responsive: true,
        maintainAspectRatio: true
    }
});
var ctx = $('#pieChart3');
var myChart = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: ["c++"],
        datasets: [{
            label: '# of Votes',
            data: [50],
            backgroundColor: [
                 'rgba(255, 206, 86, 0.2)',
            ],
            borderColor: [
                 'rgba(255, 206, 86, 1)',
            ],
            borderWidth: 1
        }]
    },
    options: {
         responsive: true,
        maintainAspectRatio: true
    }
});
 */



var languageName = $('.languageName');
var languageLevel = $('.languagelevel');
var names = [];
var levels = [];
 for(var i = 0; i<languageName.length; ++i){
	 names.push(languageName[i].value)
	 if(languageLevel[i].value == "입문"){
		 levels.push(1); 
	 }else if(languageLevel[i].value == "초급"){
		 levels.push(2);
	 }else if(languageLevel[i].value == "중급"){
		 levels.push(3);
	 }else if(languageLevel[i].value == "고급"){
		 levels.push(4);
	 }
	 
} 
console.log(levels);
var ctx = $('#horizontal-barChart');
var myChart = new Chart(ctx, {
	

    type: 'horizontalBar',
    data: {
        labels: names,
        datasets: [{
            label: '개발 가능 언어',
            data: levels,
            backgroundColor: [
				'rgba(255,99,132,0.2)',
				'rgba(54, 162, 235, 0.2)',
				'rgba(255, 206, 86, 0.2)',
				'rgba(75, 192, 192, 0.2)',
				'rgba(153, 102, 255, 0.2)',
				'rgba(255, 159, 64, 0.2)',
				'rgba(54, 162, 235, 0.2)',
				'rgba(255, 206, 86, 0.2)',
				'rgba(75, 192, 192, 0.2)',
				'rgba(153, 102, 255, 0.2)'
            ]/* ,
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)'
            ],
            borderWidth: 1 */
        }]
    },
    options: {
         responsive: true,
        maintainAspectRatio: true,
        
        scales: {
            xAxes: [{
            	 display: true,
                 ticks: {
                     beginAtZero: true   // minimum value will be 0.
                 }
                }],
        },
    }
});
var ctx = $('#barChart');
var myChart = new Chart(ctx, {
    type: 'bar',
    scaleOverride : true,
    scaleSteps : 5,
    scaleStepWidth : 1,
    scaleStartValue : 0, 
    data: {
        labels: ["java", "jsp", "c", "c++", "c#", "phython", "android", "jstl", "jquery", "oracle"],
        datasets: [{
            label: '개발 가능 언어',
            data: [1, 2, 3, 4, 5, 1, 2, 3, 4, 5],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
                'rgba(255, 159, 64, 0.2)',
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)'
            ]/* ,
            borderColor: [
                'rgba(255,99,132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)'
            ],
            borderWidth: 1 */
        }]
    },
    options: {
         responsive: true,
        maintainAspectRatio: true,
        scales: {
            yAxes: [{
            	 display: true,
                 ticks: {
                     beginAtZero: true   // minimum value will be 0.
                 }
                }],
        },
    }
});

</script>

</html>
