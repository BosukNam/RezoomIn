<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="/TestFinalProject/resources/css/myBoot.css">
<link href="/TestFinalProject/resources/css/footer.css" rel="stylesheet" type="text/css">


<script src="/TestFinalProject/resources/scripts/html2canvas.js"></script>
<script src="/TestFinalProject/resources/scripts/jquery.printPage.js"></script>
<link href="/TestFinalProject/resources/css/print.css" rel="stylesheet" media="print" />

<script type="text/javascript">
	$(function() {
		$("#btResumePDFsave").on('click', function() {
			
			
			var html = $("#resumeContent").html();
			
			var input = $("<input>")
            .attr("type", "hidden")
            .attr("name", "html").val(html);
			$('#frm').append($(input));
			
			$("#frm").submit();

			/* $.ajax({
				type : 'post',
				url : '/TestFinalProject/PDF_i',
				data : {
					"html" : html
				}
			   ,success : function(res) {
					alert(res);
				},
				error : function() {
					alert("실패!!");
				} 
			});  */
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

<form action="<%=request.getContextPath()%>/PDF_r.do" method="post" id="frm"></form>
 <div class="container" id="resumeTop" style="width: 900px;" >
 <div style="border:1px solid #000;  padding: 10px;" id="resumeContent">
 	<!-- <button id="btPrintResumePage" style="float: right;">인쇄</button>
	<button id="btResumeIMGsave" style="float: right;">이미지 파일 저장</button>
	<button id="btResumePDFsave" style="float: right;">PDF 파일 저장</button>--> 
	 <br><br><h1 style="text-align: center" >이  력  서</h1><br><br>
	 
	 <table class="table table-bordered" border="1" style="background-color: white">
	 
	 				<!-- 병역사항 -->
			 		<tr class="active">
			 			<th colspan="7">인적사항</th>
			 		</tr>
			 		
			 		 <tr><td rowspan="6"align="center" style="vertical-align: middle;">
			 		 <img src="/TestFinalProject/resources/images/namboss.jpg"
			 		  style="width: 8em; height: 8em; margin: 0px; padding: 0px; ">
			 		  </td></tr>
				 	
				 	<tr>
				 		<th>이름</th>
				 		<td colspan="2"> 남보석</td>
				 		<th>영문이름</th>
				 		<td colspan="2"> Nam bo seok</td>
				 	</tr>
				 	<tr>
				 		<th>생년월일</th>
				 		<td colspan="2"> 1990-11-5 </td>
				 		<th>성별</th>
				 		<td colspan="2"> 남성</td>
				 	</tr>
				 	<tr>
				 		<th>이메일</th>
				 		<td colspan="2"> popman90@naver.com</td>
				 		<th>연락처</th>
				 		<td colspan="2"> 010-4068-0393</td>
				 	</tr>
				 	<tr>
					 	<th>주소</th>
					 	<td colspan="5"> 서울시 서초구 방배본동 784-17번지 원빌딩 3층</td>
				 	</tr>
				 	<tr>
				 		<th>보훈대상</th>
				 		<td colspan="2"> 해당사항 없음</td>
				 		<th>장애대상 / 등급</th>
				 		<td colspan="2"> 해당사항 없음 </td>
				 	</tr>
				 	
				 	<!-- 병역사항 -->
				 	<tr class="active">
				 		<th colspan="7">병역사항</th>
				 	</tr>
				 	<tr>
				 		<th colspan="2">병역구분</th>
				 		<td> 필</td>
				 		<th colspan="2">복무기간</th>
				 		<td colspan="2"> 2011-05 ~ 2013-06</td>
				 	</tr>
				 	<tr>
				 		<th colspan="2">군별구분</th>
				 		<td> 육군</td>
				 		<th colspan="2">군별계급</th>
				 		<td colspan="2"> 병장</td>
				 	</tr>
				 	 <!-- 학력사항 -->
				 	<tr class="active">
				 		<th colspan="7">학력사항</th>
				 	</tr>
					 	<tr>
					 		<th rowspan="3">고등학교</th>
					 	</tr>
					 	<tr>
					 		<th>학교명</th>
					 		<td> 광문고등학교</td>
					 		<th>재학기간</th>
					 		<td colspan="3"> 2006.03 ~ 2009.02</td>
					 	</tr>
						<tr>
					 		<th>계열</th>
					 		<td> 이과</td>
					 		<th>전공</th>
					 		<td colspan="3">화학</td> 
					 	</tr>
				 
					 	<tr>
					 		<th rowspan="4">대학교</th>
					 	</tr>
					 	<tr>
					 		<th>학교명</th>
					 		<td> 한양대학교</td>
					 		<th>재학기간</th>
					 		<td colspan="3"> 2009.03 ~ 2015.02</td>
					 	</tr>
						<tr>
					 		<th>계열</th>
					 		<td> 이과</td>
					 		<th>전공</th>
					 		<td> 도시공학과</td>
					 		<th>학위</th>
					 		<td> 학사</td>
					 	</tr>
					 	<tr>
					 		<th>학점</th>
					 		<td> 4.5 / 4.5</td>
					 		<th>상태</th>
					 		<td> 졸업</td>
					 		<th>지역</th>
					 		<td> 서울</td>
					 	</tr>
				 	<!-- 대학교 끝 -->
				 	<!-- 경력사항 -->
				 	<tr class="active">
				 		<th colspan="7">경력사항</th>
				 	</tr>
				 	<tr>
				 		<th>회사명</th>
				 		<th colspan="2">경력기간</th>
				 		<th>직급</th>
				 		<th>부서</th>
				 		<th>담당업무</th>
				 		<th>퇴직사유</th>
				 	</tr>
				 	
				 	<tr>
				 		<td>네이버</td>
				 		<td colspan="2">2015-09 ~ 2016-02</td>
				 		<td>인턴</td>
				 		<td>소프트웨어</td>
				 		<td>개발</td>
				 		<td>학업</td>
				 	</tr>	
				 	
				 	<!-- 수상경력 -->
				 	<tr class="active">
				 		<th colspan="7">수상경력</th>
				 	</tr>
				 	<tr>
				 		<th>분류/분야</th>
				 		<th>수상명</th>
				 		<th>수상날짜</th>
				 		<th>수상자</th>
				 		<th colspan="2">주최기관</th>
				 		<th>수상내역</th>
				 	</tr>
				 	<tr>
				 		<td>IT수상/소프트웨어</td>
				 		<td>소프트웨어상</td>
				 		<td>2014.03</td>
				 		<td>개인</td>
				 		<td colspan="2">네이버</td>
				 		<td>대상</td>
				 	</tr>
				 	
				 	
				 	<!-- 자격증 어학시험 -->
					 	<tr class="active">
					 		<th colspan="3">자격증</th>
					 		<th colspan="4">어학시험</th>
					 	</tr>
					 	<tr>
					 		<th>자격증명</th>
					 		<th>취득일</th>
					 		<th>발행처</th>
					 		<th colspan="2">시험명</th>
					 		<th>점수 / 등급</th>
					 		<th>취득일</th>
					 	</tr>
					 	<tr>
					 		<td>정보처리기사</td>
					 		<td>2016.10</td>
					 		<td>산업인력공단</td>
					 		<td colspan="2">토익</td>
					 		<td>900</td>
					 		<td>2016.04</td>
					 	</tr>
					 	
					 	
					 	<!-- 대외활동/해외연수 -->
				 	<tr class="active">
				 		<th colspan="7">대외활동 / 해외연수</th>
				 	</tr>
				 	<tr>
				 		<th>구분</th>
				 		<th>기간</th>
				 		<th colspan="5">내용</th>
				 	</tr>
				 	<tr>
				 		<td>봉사활동</td>
				 		<td>2010.03 ~ 2011.11</td>
				 		<td colspan="5">대학생 봉사활동</td>
				 	</tr>
				 	<tr>
				 		<td>어학연수</td>
				 		<td>2014.03 ~ 2014.11</td>
				 		<td colspan="5">캐나다</td>
				 	</tr>
				</table>
		</div>
		</div>
