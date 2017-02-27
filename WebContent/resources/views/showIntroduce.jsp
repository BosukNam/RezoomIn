<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자기소개서 미리보기(동적!!)</title>

<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../css/animate.min.css">
<link rel="stylesheet" type="text/css" href="../css/carouselStyle.css">
<script src="../scripts/l-by-l.js"></script>
	
<style type="text/css">
.panel-heading{
	text-align: center;
	font-weight: bold;
}

</style>

<script>
 
/* Demo Scripts for Bootstrap Carousel and Animate.css article
* on SitePoint by Maria Antonietta Perna
*/
(function( $ ) {

	//Function to animate slider captions 
	function doAnimations( elems ) {
		//Cache the animationend event in a variable
		var animEndEv = 'webkitAnimationEnd animationend';
		
		elems.each(function () {
			var $this = $(this),
				$animationType = $this.data('animation');
			$this.addClass($animationType).one(animEndEv, function () {
				$this.removeClass($animationType);
			});
		});
	}
	
	//Variables on page load 
	var $myCarousel = $('#carousel-example-generic'),
		$firstAnimatingElems = $myCarousel.find('.item:first').find("[data-animation ^= 'animated']");
		
	//Initialize carousel 
	$myCarousel.carousel();
	
	//Animate captions in first slide on page load 
	doAnimations($firstAnimatingElems);
	
	//Pause carousel  
	$myCarousel.carousel('pause');
	
	
	//Other slides to be animated on carousel slide event 
	$myCarousel.on('slide.bs.carousel', function (e) {
		var $animatingElems = $(e.relatedTarget).find("[data-animation ^= 'animated']");
		doAnimations($animatingElems);
	});  
	
})(jQuery);
</script>

</head>

<body>
		

 <div class="container main-container" style="padding-top:10px; width: 460px; ">
	<div class="panel panel-default" style="margin:0; height: 580px">
	  <div class="panel-heading" style="height: 50px;">자기소개서</div>
		<div class="panel-body" style="width: 430px;  height: 550px;">
			<div id="carousel-example-generic" style="width: 430px;" class="carousel slide" data-ride="carousel" data-interval="false">
			
			
				<!-- indicators -->
				<ol class="carousel-indicators" id="indicators" style="height: 10px">
					<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
				</ol> 
				

				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
				
					<!-- 프로젝트 -->
					<div class="item active" style=" width: 430px;">
						<div class="carousel-content">
							<div>
								<h1 style="margin-top:200px;" align="center">자기소개서</h1> <hr>
							</div>
						</div>
					</div>

					<!-- 목차 시작 -->
					<div class="item" style=" width: 430px;">
						<div class="carousel-content">
							<div align="center">
								<h1 style="margin-top: 90px;">목차</h1>
								<h2 style="margin-top: 50px;">● 성장과정</h2>
								<h2 style="margin-top: 20px;">● 장점</h2>
								<h2 style="margin-top: 20px;">● 극복과정</h2>
								<h2 style="margin-top: 20px;">● 준비과정</h2>
								<h2 style="margin-top: 20px;">● 비전 및 목표</h2>
							</div>
						</div>
					</div>
					<!-- 목차 끝 -->
					
					<!-- 성장과정 시작 -->
					<div class="item" style="width: 430px; height: 550px;">
						<div class="carousel-content">
							<div class="col-md-offset-2">
									<h1 style="margin-top: 200px;">성장과정</h1>
							</div>
							<hr>
							<div class="col-md-offset-8">
								<h4>유년기</h4>
								<h4>청소년기</h4>
								<h4>대학생활</h4>
								<h4>회사생활</h4>
								<h4>취미</h4>
								<h4>특기</h4>
								<h4>대표키워드</h4>
							</div>
						</div>
					</div>
					
					<div class="item" style=" width: 430px; height: 550px;">
						<div class="carousel-content">
						  <div class="col-md-offset-1">
								<h2> 성장과정 <small> 유년기</small></h2> <hr>
							</div>
						  <jsp:include page="child.jsp"/>
						</div>
					</div>
					<div class="item" style=" width: 430px; height: 550px;">
						<div class="carousel-content">
						  <div class="col-md-offset-1">
								<h2> 성장과정 <small> 청소년기</small></h2> <hr>
							</div>
						<jsp:include page="student.jsp"/>
						</div>
					</div>
					<div class="item" style=" width: 430px; height: 550px;">
						<div class="carousel-content">
						  <div class="col-md-offset-1">
								<h2> 성장과정 <small> 대학생활</small></h2> <hr>
							</div>
						<jsp:include page="univ.jsp"/>
						</div>
					</div>
					<div class="item" style=" width: 430px; height: 550px;">
						<div class="carousel-content">
						  <div class="col-md-offset-1">
								<h2> 성장과정 <small> 회사생활</small></h2> <hr>
							</div>
						<jsp:include page="company.jsp"/>
						</div>
					</div>
						<div class="item" style=" width: 430px; height: 625px;">
							<div class="carousel-content">
								<div class="col-md-offset-1">
									<h2>
										성장과정 <small> 취미</small>
									</h2>
									<hr>
								</div>
							</div>
							<div class="carousel-caption" style="width: 430px; height: 550px;">
									<h3 class="icon-container"
										data-animation="animated bounceInDown">
										<span class="glyphicon glyphicon-heart">김예김예은</span>
									</h3>
									<h3 class="icon-container"
										data-animation="animated bounceInDown">
										<span class="glyphicon glyphicon-heart">밥김보내멈ㄴ</span>
									</h3>
									<h3 class="icon-container"
										data-animation="animated bounceInDown">
										<span class="glyphicon glyphicon-heart">비타님ㄴ</span>
									</h3>
									<h3 class="icon-container"
										data-animation="animated bounceInDown">
										<span class="glyphicon glyphicon-heart">ㅁddddasdfasdfddddddddddd </span>
									</h3>
									<h3 class="icon-container"
										data-animation="animated bounceInDown">
										<span class="glyphicon glyphicon-heart">ㅇㄹ미나문ㅇ</span>
									</h3>
								</div>
						</div>

					<div class="item" style=" width: 430px; height: 625px;">
						<div class="carousel-content">
						  <div class="col-md-offset-1">
								<h2> 성장과정 <small> 특기</small></h2> <hr>
							</div>
						</div>
						<div class="carousel-caption" style="width: 430px; height: 550px;">
									<h3 class="icon-container"
										data-animation="animated bounceInDown">
										<span class="glyphicon glyphicon-heart">김예김예은</span>
									</h3>
									<h3 class="icon-container"
										data-animation="animated bounceInDown">
										<span class="glyphicon glyphicon-heart">밥김보내멈ㄴ</span>
									</h3>
									<h3 class="icon-container"
										data-animation="animated bounceInDown">
										<span class="glyphicon glyphicon-heart">비타님ㄴ</span>
									</h3>
									<h3 class="icon-container"
										data-animation="animated bounceInDown">
										<span class="glyphicon glyphicon-heart">ㅁddddasdfasdfddddddddddd </span>
									</h3>
									<h3 class="icon-container"
										data-animation="animated bounceInDown">
										<span class="glyphicon glyphicon-heart">ㅇㄹ미나문ㅇ</span>
									</h3>
								</div>
					</div>
					<div class="item" style=" width: 430px; height: 700px;">
						<div class="carousel-content">
						  <div class="col-md-offset-1">
								<h2> 성장과정 <small> 대표키워드</small></h2> <hr>
							</div>
						</div>
						<div class="carousel-caption" style="width: 430px; height: 600px;">
									<h3 class="icon-container"
										data-animation="animated bounceInDown">
										<span>근면성실</span>
									</h3>
									<h3 class="icon-container"
										data-animation="animated bounceInDown">
										<span>배려심</span>
									</h3>
									<h3 class="icon-container"
										data-animation="animated bounceInDown">
										<span>도전정신</span>
									</h3>
									<h3 class="icon-container"
										data-animation="animated bounceInDown">
										<span>끈기와 열정</span>
									</h3>
									<h3 class="icon-container"
										data-animation="animated bounceInDown">
										<span>웃음바이러스</span>
									</h3>
								</div>
					</div>
					<!-- 성장과정 끝 -->
					
					<!-- 장점 시작 -->
					<div class="item" style=" width: 430px; height: 550px;">
						<div class="carousel-content">
							<div class="col-md-offset-2">
									<h1 style="margin-top: 200px;">장 점</h1>
							</div>
							<hr>
						</div>
					</div>
					
					<div class="item" style=" width: 430px; height: 550px;">
						<div class="carousel-content">
						  <div class="col-md-offset-1">
								<h2>장 점</h2> <hr>
							</div>
							<jsp:include page="showStrength.jsp"/>
						</div>
					</div>
					<!-- 장점 끝 -->
					
					<!-- 극복과정 시작 -->
					<div class="item" style=" width: 430px; height: 550px;">
						<div class="carousel-content">
							<div class="col-md-offset-2">
									<h1 style="margin-top: 200px;">극복과정</h1>
							</div>
							<hr>
						</div>
					</div>
					
					<div class="item" style=" width: 430px; height: 550px;">
						<div class="carousel-content">
						  <div class="col-md-offset-1">
								<h2>극복과정</h2> <hr>
							</div>
							<jsp:include page="showOvercome.jsp"/>
						</div>
					</div>
					<!-- 극복과정 끝 -->
					
					<!-- 준비과정 시작 -->
					<div class="item" style=" width: 430px; height: 550px;">
						<div class="carousel-content">
							<div class="col-md-offset-2">
									<h1 style="margin-top: 200px;">준비과정</h1>
							</div>
							<hr>
						</div>
					</div>
					
					<div class="item" style=" width: 430px; height: 550px;">
						<div class="carousel-content">
						  <div class="col-md-offset-1">
								<h2>준비과정</h2> <hr>
							</div>
							<jsp:include page="showReady.jsp"/>
						</div>
					</div>
					<!-- 준비과정 끝 -->
					
					<!-- 비전 및 목표 시작 -->
					<div class="item" style=" width: 430px; height: 800px;">
						<div class="carousel-content">
							<div class="col-md-offset-2">
									<h1 style="margin-top: 200px;">비전 및 목표</h1>
							</div>
							<hr>
						</div>
					</div>
					
					<div class="item" style=" width: 430px; height: 460px;">
						<div class="carousel-content">
						  <div class="col-md-offset-1">
								<h2>비전 및 목표</h2> <hr>
							</div>
							<div class="carousel-caption col-md-12" id="goalBackground">
									<h3 data-animation="animated zoomIn">작고 구할 들어 피가 아니한 있는가? 지혜는 인생을 속에 곧 봄날의 살 그들의 무엇이 아름다우냐?</h3>
									<h3 data-animation="animated zoomIn">낙원을 트고, 듣기만 그리하였는가? 그들에게 할지니, 얼음 산야에 하는 위하여 수 품고 운다.</h3>
									<h3 data-animation="animated zoomIn">청춘 있는 풀이 무엇을 것은 약동하다. 놀이 얼음이 오아이스도 실로 위하여서.</h3>
									<h3 data-animation="animated zoomIn">아니한 쓸쓸한 유소년에게서 것은 이것은 보는 새가 아니다.</h3>
									<h3 data-animation="animated zoomIn">석가는 풍부하게 아름다우냐? 품었기 아니더면, 위하여서, 청춘의 이는 때문이다.</h3>
									<h3 data-animation="animated zoomIn">사라지지 두기 인생에 풀이 창공에 같지 얼음 군영과 말이다.</h3>
									<h3 data-animation="animated zoomIn">봄바람을 무엇을 보이는 천하를 원질이 노년에게서 열락의 봄바람이다.</h3>
									<h3 data-animation="animated zoomIn">위하여 군영과 풍부하게 없으면, 창공에 용감하고 타오르고 남는 쓸쓸하랴?</h3>
									<h3 data-animation="animated zoomIn">끓는 그들은 산야에 위하여, 있는 무엇을 사막이다.</h3>
									<h3 data-animation="animated zoomIn">모래뿐일 인간의 그들에게 주며, 청춘을 보배를 되려니와, 황금시대의 때문이다.</h3>
						</div>
						</div>
					</div>
					<!-- 비전 및 목표 끝 -->
					
				</div>

				<!-- Left and right controls -->
				<a class="left carousel-control" href="#carousel-example-generic" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
	</div>
 

</body>

</html>