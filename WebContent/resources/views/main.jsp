<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
	<title>ResumeIn</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/dataTables.bootstrap.min.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/godofont.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
<!-- 	<link href="/RezoomIn/resources/css/header.css" rel="stylesheet"> -->
	<link href="/RezoomIn/resources/css/footer.css" rel="stylesheet">
	<link href="/RezoomIn/resources/css/carousel_main.css" rel="stylesheet">
  </head>
  <body>
	<!-- header 시작 -->
  		<jsp:include page="header.jsp"></jsp:include>
	<!-- header 끝 -->
	<!-- container 시작 -->
		<div align="center" id="content">
        	<!-- <h1><span class="glyphicon glyphicon-edit" aria-hidden="true">ResumeIn</span></h1>
        	<h4>취준생들을 위한 특별한 이력서</h4> -->
			<div id="carousel-example-generic" class="carousel slide vertical" style="background-attachment: fixed; background-position-y: 0px;"
				data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					<li data-target="#carousel-example-generic" data-slide-to="3"></li>
				</ol>
				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<div class="item active">
						<div class="row" id="first-carousel">
						<img src="${pageContext.request.contextPath}/resources/images/r3.png" alt="..." id="carousel1">
						<!-- Three columns of text below the carousel -->
						<!-- 	<div class="col-lg-4">
								<img class="img-circle"
									src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
									alt="Generic placeholder image" width="140" height="140">
								<h2>이력서</h2>
								<p>Donec sed odio dui. Etiam porta sem malesuada magna
									mollis euismod. Nullam id dolor id nibh ultricies vehicula ut
									id elit. Morbi leo risus, porta ac consectetur ac, vestibulum
									at eros. Praesent commodo cursus magna.</p>

							</div>
							/.col-lg-4
							<div class="col-lg-4">
								<img class="img-circle"
									src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
									alt="Generic placeholder image" width="140" height="140">
								<h2>자기소개서</h2>
								<p>Duis mollis, est non commodo luctus, nisi erat porttitor
									ligula, eget lacinia odio sem nec elit. Cras mattis consectetur
									purus sit amet fermentum. Fusce dapibus, tellus ac cursus
									commodo, tortor mauris condimentum nibh.</p>

							</div>
							/.col-lg-4
							<div class="col-lg-4">
								<img class="img-circle"
									src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw=="
									alt="Generic placeholder image" width="140" height="140">
								<h2>포트폴리오</h2>
								<p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis
									in, egestas eget quam. Vestibulum id ligula porta felis euismod
									semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris
									condimentum nibh, ut fermentum massa justo sit amet risus.</p>
							</div> -->
							<!-- /.col-lg-4 -->
						</div>
						<!-- /.row -->
					</div>
					<div class="item">
						<img src="${pageContext.request.contextPath}/resources/images/r2.png" alt="..." id="carousel1">
						
				      <!-- <hr class="featurette-divider">
				
				      <div class="row featurette">
				        <div class="col-md-7">
				          <h2 class="featurette-heading">First featurette heading. <span class="text-muted">It'll blow your mind.</span></h2>
				          <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
				        </div>
				        <div class="col-md-5">
				          <img class="featurette-image img-responsive center-block" src="http://lorempixel.com/500/500" alt="Generic placeholder image">
				        </div>
				      </div>
				
				      <hr class="featurette-divider"> -->
					</div>
					<div class="item">
						<img src="${pageContext.request.contextPath}/resources/images/r1.png" alt="..." id="carousel1">
						
					    <!-- <hr class="featurette-divider">	
					    <div class="row featurette">
					    	<div class="col-md-7 col-md-push-5">
					        	<h2 class="featurette-heading">Oh yeah, it's that good. <span class="text-muted">See for yourself.</span></h2>
					          	<p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
					        </div>
					        <div class="col-md-5 col-md-pull-7">
					          	<img class="featurette-image img-responsive center-block" src="http://lorempixel.com/500/500" alt="Generic placeholder image">
					        </div>
					   	</div>					
					    <hr class="featurette-divider">
					</div>
					<div class="item">
						<img src="http://placehold.it/800x400" alt="...">
						
				      	<hr class="featurette-divider">
				
				      	<div class="row featurette">
				        	<div class="col-md-7">
				          		<h2 class="featurette-heading">And lastly, this one. <span class="text-muted">Checkmate.</span></h2>
				          		<p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
				        	</div>
				        	<div class="col-md-5">
				          		<img class="featurette-image img-responsive center-block" src="http://lorempixel.com/500/500" alt="Generic placeholder image">
				        	</div>
				    	</div>
				      	<hr class="featurette-divider">
					</div> -->
				</div>
				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a>
				<a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>	
		</div>
		</div>
	<!-- container 끝 -->
	<!-- footer 시작 -->
    <jsp:include page="footer.html"></jsp:include>
    <!-- footer 끝 !-->
	
  </body>
  <script>
  $(function(){
  	var check=$('#check-login').html();
	if(check=="NEW"){
	  	$('#before-login').show();
	  	$('#after-login').hide();
	}
  	
  	$('#carousel-example-generic').bind('slide.bs.carousel', function (event) {
    	console.log(event.direction);
    	console.log(event);
    	//$('.item').show();
    	
	});
  	$('.carousel-control').click(function(event){
  		console.log($('#carousel-example-generic'));
  	})
  })
  </script>
  <!-- footer랑 header 접근 유효범위 설정 -->
  <style>
  .carousel-control.left, .carousel-control.right {
    background-image: none
	}
  </style>
</html>