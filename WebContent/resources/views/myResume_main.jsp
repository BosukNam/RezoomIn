<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
	<title>noname_project</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/dataTables.bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
	<!-- date picker -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>
<!-- 	<link href="../css/header.css" rel="stylesheet"> -->
	<link href="../css/footer.css" rel="stylesheet">
	<link href="../css/make_book.css" rel="stylesheet">
	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker3.min.css">
	<link rel="stylesheet" type="text/css" href="../css/animate.min.css">
	<link rel="stylesheet" type="text/css" href="../css/carouselStyle.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/resources/css/myResume.css">
	<script src="../scripts/l-by-l.js"></script>
	<script src="../scripts/about_book.js"></script>

  </head>
  <body>
	<!-- header 시작 -->
  	<jsp:include page="header.jsp"></jsp:include>
	<!-- header 끝 -->
	<div class="col-md-12">
    <div class="col-md-2 sidebar">
      <ul class="nav nav-sidebar">
      </ul>
    </div>
	<!-- container 시작 -->
	<div class="col-md-8 container">
        <div class="main" align="center" class="my_resume_book">
        	<img src="${pageContext.request.contextPath }/resources/images/myresumeindex.JPG" id="view-book" data-target="#myResume-modal">
		</div>
    </div>
	<!-- container 끝 -->
	<div class="col-md-2 sidebar">
	   	<ul class="nav nav-right-sidebar">
	    </ul>
	</div>
	</div>
	<!-- footer 시작 -->
    <jsp:include page="footer.html"></jsp:include>
    <!-- footer 끝 -->
	<!-- book modal 시작-->
	<jsp:include page="myResume_modal.jsp"></jsp:include>
	<!-- book modal 끝 -->
  </body>
  
  <script type="text/javascript" src="../scripts/turn.js"></script>
  <!-- chart js -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>	
  
  <style>

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

@font-face {
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
}

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

</style>

<script>

var ctx = $('#pieChart1');
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


var ctx = $('#horizontal-barChart');
var myChart = new Chart(ctx, {
    type: 'horizontalBar',
    data: {
        labels: ["java", "jsp", "c", "c++", "c#"],
        datasets: [{
            label: '개발 가능 언어',
            data: [4, 5, 2, 3, 5],
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
                'rgba(75, 192, 192, 0.2)',
                'rgba(153, 102, 255, 0.2)',
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

 
 /* 
  * indicator 개수 item 개수(페이지 수)에 맞게 동적으로 생성
  */
 $(function(){
 	for(var i = 1; i < $('.item').size(); i++)
 		$('#indicators').append('<li data-target="#carousel-example-generic" data-slide-to=' + i + '></li>');
 	
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
	
	  
 });
</script>


</html>