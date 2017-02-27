<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자기소개서 미리보기(정적)</title>

<!-- 부트스트랩 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/scripts/html2canvas.js"></script>
<script src="${pageContext.request.contextPath }/resources/scripts/jquery.printPage.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/godofont.css">
<style type="text/css">

.letterBox {
	background-color: rgb(255, 235, 152);
	margin: 10px;
	padding: 10px;
	box-shadow: 10px 10px 5px -4px rgba(0, 0, 0, 0.4);
	border-bottom-right-radius: 15px 25px;
}

/* h4 {
	font-weight: bold;
} */
/* 이렇게 넣으면 편하긴 하지만 PDF 출력시 반영이 안됨... */

</style>

<script type="text/javascript">
	$(function() {
		$("#btPersonalPDFsave").on('click', function() {
			var html = $("#content").html();
			var input = $("<input>") 
            .attr("type", "hidden")
            .attr("name", "html").val(html); 
			$('#frm').append($(input));
			$("#frm").submit(); 
			
		});

		$("#btPersonalIMGsave").on('click', function() {
			html2canvas($('#top'), 
				    {
				      onrendered: function (canvas) {
				        var a = document.createElement('a');
				        // toDataURL defaults to png, so we need to request a jpeg, then convert for file download.
				        a.href = canvas.toDataURL("image/jpeg").replace("image/jpeg", "image/octet-stream");
				        a.download = 'introduce.jpg';
				        a.click();
				      }
				    });
		});

		
		$("#btPersonalPrintPage").on('click', function() {
			var html = $("#content").html();
			var mywindow = window.open('', '자기소개서','height=500,width=1000');
	        mywindow.document.write('<html><head><h1>자기소개서</h1>');
	        /*optional stylesheet*/ //mywindow.document.write('<link rel="stylesheet" href="main.css" type="text/css" />');
	        mywindow.document.write('</head><body >');
	        mywindow.document.write(html);
	        mywindow.document.write('</body></html>');

	        mywindow.print();
	        mywindow.close();
		});

		
		$.ajax({
			url:'/TestFinalProject/getpersonalreport.do',
			type:'post',
			data:{"id":'yeeee4'},
			success:function(res){ // 응답 온 데이터
				var obj = JSON.parse(res);
				console.log(obj);
				
				if(obj.biography==false){
					$("#1").html('');
				}
				else{
					if(obj.child==null){
						$("#childhood").html('');
					}else{
						$("#childhoodContent").html(obj.child);
					}
					if(obj.student==null){
						$("#student").html('');
					}else{
						$("#studentContent").html(obj.student);
					}
					if(obj.univ==null){
						$("#univ").html('');
					}else{
						$("#univContent").html(obj.univ);
					}
					if(obj.company==null){
						$("#company").html('');
					}else{
						$("#companyContent").html(obj.company);
					}
					if(obj.keyword==null){
						$("#keyword").html('');
					}else{
						var keywords = obj.keyword;
						var text = "- ";

						for (var k in keywords) {
						    text += keywords[k];
						    text += "  ";
						}
						
						$("#keywordContent").html(text);
					}
					if(obj.hobby==null){
						$("#hobby").html('');
					}else{
						var hobbies = obj.hobby;
						var text = "- ";

						for (var h in hobbies) {
						    text += hobbies[h];
						    text += "  ";
						}
						
						$("#hobbyContent").html(text);
					}
					if(obj.skill==null){
						$("#skill").html('');
					}else{
						var skills = obj.skill;
						var text = "- ";

						for (var s in skills) {
						    text += skills[s];
						    text += "  ";
						}
						
						$("#skillContent").html(text);
					}
				}
				
				if(obj.strength==false){
					$("#2").html('');
				}
				else{
					$("#strengthReportContent").html(obj.strengthReport);
				}
				
				if(obj.experience==false){
					$("#3").html('');
				}
				else{
					var experiences = obj.overcome;
					$("#experienceReportContent").html('');
					
					for (var e in experiences) {
						$("#experienceReportContent").
						append('<font size="3px" style="font-weight: bold;">&nbsp;&nbsp;&nbsp;- '+
						experiences[e].title+'</font><div class="letterBox">'+experiences[e].content+
						'</div><br>');
					}
				}
				
				if(obj.ready==false){
					$("#4").html('');
				}
				else{
					$("#readyConditionContent").html(obj.readyCondition);
				}
				
				if(obj.goal==false){
					$("#5").html('');
				}
				else{
					var goals = obj.goalReport;
					$("#goalReportContent").html('');

					for (var g in goals) {
						$("#goalReportContent").append("<h3>&nbsp;&nbsp;&nbsp; ● "+goals[g]+"</h3>");
					}
				}
				
			},
			error : function() {
				alert("으이구!~~");
			}
		});
	});
</script>


</head>

<body data-spy="scroll" data-target=".navbar" data-offset="50">

	<jsp:include page="header.jsp" />


	<div class="col-md-2" align="center" id="left">
		<jsp:include page="introduce.jsp"></jsp:include>
	</div>
	
	<form action="<%=request.getContextPath()%>/PDF_i.do" method="post" id="frm"></form>
	<br><br>
	<div class="container main-container"  id="top"
	style="padding-top: 0px; width: 800px; margin: 0 auto;">
		<div class="panel panel-default">
			<div class="panel-heading">
				자기소개서 미리보기
				<button id="btPersonalPrintPage" style="float: right;">인쇄</button>
				<button id="btPersonalIMGsave" style="float: right;">이미지 파일 저장</button>
				<button id="btPersonalPDFsave" style="float: right;">PDF 파일 저장</button>
			</div>
			<!-- The navbar - The <a> elements are used to jump to a section in the scrollable area -->
				<nav class="navbar navbar-inverse" style="height: 50px;">
					<ul class="nav navbar-nav">
						<li><a href="#1">성장과정</a></li>
						<li><a href="#2">장점</a></li>
						<li><a href="#3">극복과정</a></li>
						<li><a href="#4">준비과정</a></li>
						<li><a href="#5">비전 및 목표</a></li>
					</ul>
				</nav>
			
			<div class="panel-body" id="content">
			<!-- The scrollable area -->
				<!-- Section 1 -->
				<div id="1">
					<div id="childhood">
					<h4 style="font-weight: bold;">● 유년기</h4>
					<div class="letterBox" id="childhoodContent">Lorem ipsum dolor sit amet,
						consectetur adipiscing elit. Integer tempus arcu neque, vitae
						gravida nulla malesuada vel. Etiam vel turpis pharetra, venenatis
						lacus vel, condimentum mi. Sed laoreet enim ex, at commodo risus
						consequat ullamcorper. Nulla pretium commodo metus in cursus.
						Proin non metus ex. Curabitur eget nisl luctus, cursus risus ac,
						accumsan ante. Nulla vulputate porta rhoncus. Integer sit amet
						lectus eget massa pulvinar accumsan vel sit amet magna. Fusce
						luctus vitae massa sed dapibus. Vestibulum nec tortor ac erat
						tincidunt consectetur.</div>
					<br>
					</div>
					<div id="student">
					<h4 style="font-weight: bold;">● 청소년기</h4>
					<div class="letterBox" id="studentContent">Lorem ipsum dolor sit amet,
						consectetur adipiscing elit. Integer tempus arcu neque, vitae
						gravida nulla malesuada vel. Etiam vel turpis pharetra, venenatis
						lacus vel, condimentum mi. Sed laoreet enim ex, at commodo risus
						consequat ullamcorper. Nulla pretium commodo metus in cursus.
						Proin non metus ex. Curabitur eget nisl luctus, cursus risus ac,
						accumsan ante. Nulla vulputate porta rhoncus. Integer sit amet
						lectus eget massa pulvinar accumsan vel sit amet magna. Fusce
						luctus vitae massa sed dapibus. Vestibulum nec tortor ac erat
						tincidunt consectetur.</div>
					<br>
					</div>
					<div id="univ">
					<h4 style="font-weight: bold;">● 대학생활</h4>
					<div class="letterBox" id="univContent">Lorem ipsum dolor sit amet,
						consectetur adipiscing elit. Integer tempus arcu neque, vitae
						gravida nulla malesuada vel. Etiam vel turpis pharetra, venenatis
						lacus vel, condimentum mi. Sed laoreet enim ex, at commodo risus
						consequat ullamcorper. Nulla pretium commodo metus in cursus.
						Proin non metus ex. Curabitur eget nisl luctus, cursus risus ac,
						accumsan ante. Nulla vulputate porta rhoncus. Integer sit amet
						lectus eget massa pulvinar accumsan vel sit amet magna. Fusce
						luctus vitae massa sed dapibus. Vestibulum nec tortor ac erat
						tincidunt consectetur.</div>
					<br>
					</div>
					<div id="company">
					<h4 style="font-weight: bold;">● 회사생활</h4>
					<div class="letterBox" id="companyContent">Lorem ipsum dolor sit amet,
						consectetur adipiscing elit. Integer tempus arcu neque, vitae
						gravida nulla malesuada vel. Etiam vel turpis pharetra, venenatis
						lacus vel, condimentum mi. Sed laoreet enim ex, at commodo risus
						consequat ullamcorper. Nulla pretium commodo metus in cursus.
						Proin non metus ex. Curabitur eget nisl luctus, cursus risus ac,
						accumsan ante. Nulla vulputate porta rhoncus. Integer sit amet
						lectus eget massa pulvinar accumsan vel sit amet magna. Fusce
						luctus vitae massa sed dapibus. Vestibulum nec tortor ac erat
						tincidunt consectetur.</div>
					<br>
					</div>
					<div id="hobby">
					<h4 style="font-weight: bold;">● 취미</h4>
					<div class="letterBox" id="hobbyContent">
					- 야구, 게임<br>
					</div>
					<br>
					</div>
					<div id="skill">
					<h4 style="font-weight: bold;">● 특기</h4>
					<div class="letterBox" id="skillContent">
					- 요리, 엑셀<br>
					</div>
					<br>
					</div>
					<div id="keyword">
					<h4 style="font-weight: bold;">● 대표키워드</h4>
					<div class="letterBox" id="keywordContent">
					- 근면, 성실, 열정<br>
					</div>
					<br>
					</div>
				</div>

				<!-- Section 2 -->
				<div id="2">
					<h4 style="font-weight: bold;">● 장점</h4>
					<div class="letterBox" id="strengthReportContent">Lorem ipsum dolor sit amet,
						consectetur adipiscing elit. Integer tempus arcu neque, vitae
						gravida nulla malesuada vel. Etiam vel turpis pharetra, venenatis
						lacus vel, condimentum mi. Sed laoreet enim ex, at commodo risus
						consequat ullamcorper. Nulla pretium commodo metus in cursus.
						Proin non metus ex. Curabitur eget nisl luctus, cursus risus ac,
						accumsan ante. Nulla vulputate porta rhoncus. Integer sit amet
						lectus eget massa pulvinar accumsan vel sit amet magna. Fusce
						luctus vitae massa sed dapibus. Vestibulum nec tortor ac erat
						tincidunt consectetur.</div>
					<br>
				</div>

				<!-- Section 3 -->
				<div id="3">
					<h4 style="font-weight: bold;">● 극복과정</h4>
					<div id="experienceReportContent">
					<font size="3px" style="font-weight: bold;">&nbsp;&nbsp;&nbsp;-
						평화스러운 청춘은 찾아 바이며, 위하여 끓는 칼이다.</font>
					<div class="letterBox">Lorem ipsum dolor sit amet,
						consectetur adipiscing elit. Integer tempus arcu neque, vitae
						gravida nulla malesuada vel. Etiam vel turpis pharetra, venenatis
						lacus vel, condimentum mi. Sed laoreet enim ex, at commodo risus
						consequat ullamcorper. Nulla pretium commodo metus in cursus.
						Proin non metus ex. Curabitur eget nisl luctus, cursus risus ac,
						accumsan ante. Nulla vulputate porta rhoncus. Integer sit amet
						lectus eget massa pulvinar accumsan vel sit amet magna. Fusce
						luctus vitae massa sed dapibus. Vestibulum nec tortor ac erat
						tincidunt consectetur.</div>
					<br> <font size="3px" style="font-weight: bold;">&nbsp;&nbsp;&nbsp;-
						평화스러운 청춘은 찾아 바이며, 위하여 끓는 칼이다.</font>
					<div class="letterBox">Lorem ipsum dolor sit amet,
						consectetur adipiscing elit. Integer tempus arcu neque, vitae
						gravida nulla malesuada vel. Etiam vel turpis pharetra, venenatis
						lacus vel, condimentum mi. Sed laoreet enim ex, at commodo risus
						consequat ullamcorper. Nulla pretium commodo metus in cursus.
						Proin non metus ex. Curabitur eget nisl luctus, cursus risus ac,
						accumsan ante. Nulla vulputate porta rhoncus. Integer sit amet
						lectus eget massa pulvinar accumsan vel sit amet magna. Fusce
						luctus vitae massa sed dapibus. Vestibulum nec tortor ac erat
						tincidunt consectetur.</div>
					<br> <font size="3px" style="font-weight: bold;">&nbsp;&nbsp;&nbsp;-
						평화스러운 청춘은 찾아 바이며, 위하여 끓는 칼이다.</font>
					<div class="letterBox">Lorem ipsum dolor sit amet,
						consectetur adipiscing elit. Integer tempus arcu neque, vitae
						gravida nulla malesuada vel. Etiam vel turpis pharetra, venenatis
						lacus vel, condimentum mi. Sed laoreet enim ex, at commodo risus
						consequat ullamcorper. Nulla pretium commodo metus in cursus.
						Proin non metus ex. Curabitur eget nisl luctus, cursus risus ac,
						accumsan ante. Nulla vulputate porta rhoncus. Integer sit amet
						lectus eget massa pulvinar accumsan vel sit amet magna. Fusce
						luctus vitae massa sed dapibus. Vestibulum nec tortor ac erat
						tincidunt consectetur.</div>
					<br>
					</div>
				</div>

				<!-- Section 4 -->
				<div id="4">
					<h4 style="font-weight: bold;">● 준비과정</h4>
					<div class="letterBox" id="readyConditionContent">Lorem ipsum dolor sit amet,
						consectetur adipiscing elit. Integer tempus arcu neque, vitae
						gravida nulla malesuada vel. Etiam vel turpis pharetra, venenatis
						lacus vel, condimentum mi. Sed laoreet enim ex, at commodo risus
						consequat ullamcorper. Nulla pretium commodo metus in cursus.
						Proin non metus ex. Curabitur eget nisl luctus, cursus risus ac,
						accumsan ante. Nulla vulputate porta rhoncus. Integer sit amet
						lectus eget massa pulvinar accumsan vel sit amet magna. Fusce
						luctus vitae massa sed dapibus. Vestibulum nec tortor ac erat
						tincidunt consectetur.</div>
					<br>
				</div>

				<!-- Section 5 -->
				<div id="5">
					<h4 style="font-weight: bold;">● 비전 및 목표</h4>
					<div class="letterBox" id="goalReportContent">
					<h3>&nbsp;&nbsp;&nbsp; ● 이것을 용감하고 것은 굳세게 그러므로 만천하의 오직 눈에 것이다.</h3>
					<h3>&nbsp;&nbsp;&nbsp; ● 대한 귀는 커다란 그들은 이상의 것이다. 따뜻한 현저하게 곧 긴지라
						뿐이다.</h3>
					<h3>&nbsp;&nbsp;&nbsp; ● 소리다.이것은 황금시대를 방황하였으며,</h3>
					<h3>&nbsp;&nbsp;&nbsp; ● 아름다우냐? 생의 무엇을 우리 품었기 사람은 튼튼하며, 쓸쓸하랴?</h3>
					<h3>&nbsp;&nbsp;&nbsp; ● 긴지라 관현악이며, 인간은 용감하고 풀밭에 돋고, 말이다.</h3>
					<h3>&nbsp;&nbsp;&nbsp; ● 끓는 인도하겠다는 피어나기 뭇 청춘의 기쁘며, 청춘의 쓸쓸하랴?</h3>
					</div>
				</div>
			</div>
			

		</div>
	</div>
	<div class="navbar-fixed-bottom"><a href="#top" style="float: right; margin-right: 15%;">맨위로▲</a></div>


	<jsp:include page="footer.html"></jsp:include>
</body>


<script>

</script>

</html>
