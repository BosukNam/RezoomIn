<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="/TestFinalProject/resources/css/myBoot.css">
<link href="/TestFinalProject/resources/css/footer.css" rel="stylesheet" type="text/css">


<script src="resources/scripts/html2canvas.js"></script>
<script src="resources/scripts/jquery.printPage.js"></script>
<link href="resources/css/print.css" rel="stylesheet" media="print" />

<script type="text/javascript">
	$(function() {
		$("#btResumePDFsave").on('click', function() {
			var html = $("#resumeContent").html();

			$.ajax({
				type : 'post',
				url : '/TestFinalProject/PDF_i',
				data : {
					"html" : html
				},
				success : function(res) {
					alert(res);
				},
				error : function() {
					alert("실패!!");
				}
			});
		});

		$("#btResumeIMGsave").on('click', function() {
					    
			html2canvas($('#resumeTop'), 
				    {
				      onrendered: function (canvas) {
				        var a = document.createElement('a');
				        a.href = canvas.toDataURL("image/jpeg").replace("image/jpeg", "image/octet-stream");
				        a.download = 'resume.jpg';
				        a.click();
				      }
				    });
		});

		/* $("#btPrintResumePage")
		.printPage(
				{
					url : "http://localhost:8089/TestFinalProject/resources/views/resume.jsp",
					attr : "href",
					message : "도큐먼트 인쇄를 준비중입니다."
				}); */
				
		$("#btPrintResumePage").on('click', function() {
			
			var html = $("#resumeContent").html();
			var mywindow = window.open('', '이력서','height=500,width=1000');
	        mywindow.document.write('<html><head>');
	        mywindow.document.write('</head><body >');
	        mywindow.document.write(html);
	        mywindow.document.write('</body></html>');

	        mywindow.print();
	        mywindow.close();
			
		});

	})
</script>



 <div class="container" id="resumeTop">
 <div class="col-md-9 col-sm-9" style="border:1px solid #000;">
 	<!-- <button id="btPrintResumePage" style="float: right;">인쇄</button>
	<button id="btResumeIMGsave" style="float: right;">이미지 파일 저장</button>
	<button id="btResumePDFsave" style="float: right;">PDF 파일 저장</button> -->
	<div id="resumeContent">
				
	 <br><br><h1 style="text-align: center" >이  력  서</h1><br><br>
	 <div style="margin-left:70px">
		 <div class="row">
		 	<div class="col-md-2 col-sm-2" style="margin-left:20px; margin-top:20px" >
		 		<img src="https://x.myspacecdn.com/new/common/images/user.png" style="width:150px; height:200px">
		 	</div>
		 	<div class="col-md-8 col-sm-8" style="margin-left:32px">
			 	<table class="table table-bordered">
			 		<tr class="active">
			 			<th colspan="4">인적사항</th>
			 		</tr>
				 	<tr>
				 		<th>이름</th>
				 		<td>김예은</td>
				 		<th>영문이름</th>
				 		<td>Yeeun Kim</td>
				 	</tr>
				 	<tr>
				 		<th>생년월일</th>
				 		<td>1994-06-23</td>
				 		<th>성별</th>
				 		<td>여성</td>
				 	</tr>
				 	<tr>
				 		<th>이메일</th>
				 		<td>yeeee4@naver.com</td>
				 		<th>연락처</th>
				 		<td>010-3043-7177</td>
				 	</tr>
				 	<tr>
					 	<th>주소</th>
					 	<td colspan="3">서울시 방배본동 784-17 원빌딩 3층</td>
				 	</tr>
				 	<tr>
				 		<th>보훈대상</th>
				 		<td>해당사항없음</td>
				 		<th>장애대상 / 등급</th>
				 		<td>해당사항없음</td>
				 	</tr>
				</table>
			</div>
		</div>
		 	 <!-- 병역사항 -->
		 	 <div class="col-md-11 col-sm-11">
			 	<table class="table table-bordered">
				 	<tr class="active">
				 		<th colspan="4">병역사항</th>
				 	</tr>
				 	<tr>
				 		<th>병역구분</th>
				 		<td>미필</td>
				 		<th>복무기간</th>
				 		<td>-</td>
				 	</tr>
				 	<tr>
				 		<th>군별구분</th>
				 		<td>-</td>
				 		<th>군별계급</th>
				 		<td>-</td>
				 	</tr>
				</table>
			</div>
			 <!-- 학력사항 -->
		 	 <div class="col-md-11 col-sm-11">
			 	<table class="table table-bordered">
				 	<tr class="active">
				 		<th colspan="7">학력사항</th>
				 	</tr>
				 	<!-- 고등학교 -->
				 	<tr>
				 		<th rowspan="3">고등학교</th>
				 	</tr>
				 	<tr>
				 		<th>학교명</th>
				 		<td>렉토피아고등학교</td>
				 		<th>재학기간</th>
				 		<td colspan="3">2010-03 ~ 2013-02</td>
				 	</tr>
					<tr>
				 		<th>계열</th>
				 		<td>이과</td>
				 		<th>전공</th>
				 		<td colspan="3">생물화학</td>
				 	</tr>
				 	<!-- 고등학교 끝 -->
				 	<!-- 대학교/대학원 -->
				 	<tr>
				 		<th rowspan="4">대학교</th>
				 	</tr>
				 	<tr>
				 		<th>학교명</th>
				 		<td>숭실대학교</td>
				 		<th>재학기간</th>
				 		<td colspan="3">2014-03 ~ 2018-02</td>
				 	</tr>
					<tr>
				 		<th>계열</th>
				 		<td>이과</td>
				 		<th>전공</th>
				 		<td>컴퓨터학부</td>
				 		<th>학위</th>
				 		<td>학사</td>
				 	</tr>
				 	<tr>
				 		<th>학점</th>
				 		<td>4.5 / 4.5</td>
				 		<th>상태</th>
				 		<td>졸업예정</td>
				 		<th>지역</th>
				 		<td>서울</td>
				 	</tr>
				 	<!-- 대학교/대학원 끝 -->		 	
				</table>
			</div>
			
			<!-- 경력사항 -->
		 	 <div class="col-md-11 col-sm-11">
			 	<table class="table table-bordered">
				 	<tr class="active">
				 		<th colspan="7">경력사항</th>
				 	</tr>
				 	<tr>
				 		<th>회사명</th>
				 		<th>경력기간</th>
				 		<th>직급</th>
				 		<th>부서</th>
				 		<th>담당업무</th>
				 		<th>퇴직사유</th>
				 	</tr>
				 	<tr>
				 		<td>구글</td>
				 		<td>2002-02 ~ 2010-04</td>
				 		<td>팀장</td>
				 		<td>소프트웨어</td>
				 		<td>개발</td>
				 		<td>학업</td>
				 	</tr>
				 	<tr>
				 		<td>네이버</td>
				 		<td>2002-02 ~ 2010-04</td>
				 		<td>팀장</td>
				 		<td>소프트웨어</td>
				 		<td>개발</td>
				 		<td>학업</td>
				 	</tr>
				</table>
			</div>
			
			<!-- 수상경력 -->
		 	 <div class="col-md-11 col-sm-11">
			 	<table class="table table-bordered">
				 	<tr class="active">
				 		<th colspan="7">수상경력</th>
				 	</tr>
				 	<tr>
				 		<th>분류/분야</th>
				 		<th>수상명</th>
				 		<th>수상날짜</th>
				 		<th>수상자</th>
				 		<th>주최기관</th>
				 		<th>수상내역</th>
				 	</tr>
				 	<tr>
				 		<td>IT수상/소프트웨어</td>
				 		<td>네이버상</td>
				 		<td>2014.03</td>
				 		<td>개인</td>
				 		<td>네이버</td>
				 		<td>대상</td>
				 	</tr>
			 	</table>
			</div>
			<div class="row">
				<!-- 자격증 -->
			 	 <div class="col-md-5 col-sm-5" style="margin-left:15px">
				 	<table class="table table-bordered">
					 	<tr class="active">
					 		<th colspan="3">자격증</th>
					 	</tr>
					 	<tr>
					 		<th>자격증명</th>
					 		<th>취득일</th>
					 		<th>발행처</th>
					 	</tr>
					 	<tr>
					 		<td>정보처리기사</td>
					 		<td>2016.10</td>
					 		<td>산업인력공단</td>
					 	</tr>
					</table>
				</div>
				<!-- 어학시험 -->
			 	 <div class="col-md-5 col-sm-5" style="margin-left:40px" >
				 	<table class="table table-bordered">
					 	<tr class="active">
					 		<th colspan="3">어학시험</th>
					 	</tr>
					 	<tr>
					 		<th>시험명</th>
					 		<th>취득일</th>
					 		<th>발행처</th>
					 	</tr>
					 	<tr>
					 		<td>토익</td>
					 		<td>2016.04</td>
					 		<td>ETS</td>
					 	</tr>
					</table>
				</div>
			</div>
			 <!-- 대외활동/해외연수 -->
		 	 <div class="col-md-11 col-sm-11">
 			 	<table class="table table-bordered">
				 	<tr class="active">
				 		<th colspan="3">대외활동 / 해외연수</th>
				 	</tr>
				 	<tr>
				 		<th>구분</th>
				 		<th>기간</th>
				 		<th>내용</th>
				 	</tr>
				 	<tr>
				 		<td>봉사활동</td>
				 		<td>2010.03 ~ 2011.11</td>
				 		<td>대학생 봉사활동</td>
				 	</tr>
				 	<tr>
				 		<td>어학연수</td>
				 		<td>2015.03 ~ 2016.11</td>
				 		<td>캐나다</td>
				 	</tr>
				</table><br><br>
			</div>
			</div>
		</div>
	</div>
</div>
