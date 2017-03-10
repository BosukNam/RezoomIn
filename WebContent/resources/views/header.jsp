<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.header_style{
	background-color:#F5F0E5;
	margin-top:0px;
}
.header_presentation>li{
	margin : 0px 100px 0px 50px;
	
}
.header_presentation>li>a, 
.header_presentation>li>a>small{
	color : #545C5B;
	font-size : 1.3em;
}
.page_margin{
	margin-top : 70px;
}
.personal_info_style{
	margin-right : 20px;
}
.personal_info_style>a{
	margin : 0 5px;
	color : #545C5B;
	font-size: 1.1em;
}
.header_nav_style{
}
</style>
<div class="header_style">
<div style="margin-top:0px">
<div class="row">
<div class="col-md-4">
	<img src="${pageContext.request.contextPath}/resources/images/logo/new.png" class="img-responsive"
	 width="150px" height="50px" style="padding:10px 0 0 15px">
	 </div>
	<!-- <div class="container"> -->
	<input type="hidden" id="check-login" value="${sessionScope.islogin}">
		<div class="col-md-4 col-md-offset-4" id="after-login" hidden="true" style="margin-top : 20px">
		<nav class="nav nav-pills pull-right personal_info_style">
			<!-- <img src="http://place-hold.it/30x30" class="img-circle"> -->
			<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
			<span>${sessionScope.memberID}</span>
			<a href="/RezoomIn/search.do"><small>내 정보</small></a> 
			<a href="#" id="main-logout"><small>로그아웃</small></a>
		</nav>
		</div> 
		<div class="col-md-4 col-md-offset-4" id="before-login" style="margin-top : 20px">
		<nav class="nav nav-pills pull-right personal_info_style">
			<a href="#" id="join">회원가입</a>
			<a href="#" id="login">로그인</a>
		</nav>
		</div>
		</div>
	<!-- </div> -->
		<div style="margin-top : 20px">
		<nav style="margin-left : 220px">
			<ul class="nav nav-pills pull-left header_presentation header_nav_style" id="menu-bar">
<%-- 				<li role="presentation">
					<img src="${pageContext.request.contextPath }/resources/images/logo/logo.png" class="img-responsive">
				</li> --%>
				<li role="presentation" id="service_introduce"><a href="${pageContext.request.contextPath}/main.do">서비스 소개</a></li>
				<li role="presentation" id="resume_main"><a href="${pageContext.request.contextPath}/preview.do">이력서</a></li>
				<li role="presentation" id="profile_main"><a href="${pageContext.request.contextPath}/personalpage.do?type=load">자기소개서</a></li>	
				<li role="presentation" id="portfolio_main"><a href="${pageContext.request.contextPath}/initProgrammingSkill.do?">포트폴리오</a></li>	
				<li role="presentation" >
					<a href="${pageContext.request.contextPath}/resources/views/myResume_main.jsp"
					>MyResume<span class="glyphicon glyphicon-book" aria-hidden="true"></span></a>
				</li>
			</ul>
		</nav>
		</div>
	</div>
	<div class="row page_margin"></div>
	</div>
	<div class="row" style="margin-bottom : 50px"></div>

	<!-- login_modal 시작-->
	<jsp:include page="login_modal.jsp"></jsp:include>
	<!-- login_modal 끝 -->
	<!-- join_modal 시작 -->
	<jsp:include page="join_modal.jsp"></jsp:include>
	<!-- join_modal 끝 -->
<script>
	$(function(){
		if($('#check-login').val()=='true'){
			$('#after-login').show();
			$('#before-login').hide();
		}
		else{
			$('#after-login').hide();
			$('#before-login').show();
		}
		
	});

	$('#main-logout').click(function(){
	  	location.replace("/RezoomIn/privatelogout.do");
	})
	
	$('#login').click(function(){
  		$('#login-modal').modal('show')
  	})
  	$('#join').click(function(){
  		$('#join-modal').modal('show')
  	})
  	
</script>
