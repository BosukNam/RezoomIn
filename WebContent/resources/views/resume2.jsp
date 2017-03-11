<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="/RezoomIn/resources/css/myBoot.css">
<link href="/RezoomIn/resources/css/footer.css" rel="stylesheet" type="text/css">


<script src="/RezoomIn/resources/scripts/html2canvas.js"></script>
<script src="/RezoomIn/resources/scripts/jquery.printPage.js"></script>
<link href="/RezoomIn/resources/css/print.css" rel="stylesheet" media="print" />


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
				url : '/RezoomIn/PDF_i',
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
					url : "http://localhost:8089/RezoomIn/resources/views/resume.jsp",
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
	 
	 <table class="table table-bordered" border="1" style="background-color: white;">
	 
	 				<!-- 병역사항 -->
			 		<tr class="active">
			 			<th colspan="7">인적사항</th>
			 		</tr>
			 		
			 		 <tr><td rowspan="6"align="center" style="vertical-align: middle;">
			 		 <img src="/RezoomIn/resources/images/hwang.JPG"
			 		  style="width: 8em; height: 8em; margin: 0px; padding: 0px; ">
			 		  </td></tr>
				 	
				 	<tr>
				 		<th>이름</th>
				 		<td colspan="2"> ${requestScope.personalInfo.name}</td>
				 		<th>영문이름</th>
				 		<td colspan="2"> ${requestScope.personalInfo.englishName}</td>
				 	</tr>
				 	<tr>
				 		<th>생년월일</th>
				 		<td colspan="2"> ${requestScope.personalInfo.birthDate} </td>
				 		<th>성별</th>
				 		<td colspan="2"> ${requestScope.personalInfo.gender}</td>
				 	</tr>
				 	<tr>
				 		<th>이메일</th>
				 		<td colspan="2"> ${requestScope.personalInfo.email}</td>
				 		<th>연락처</th>
				 		<td colspan="2"> ${requestScope.personalInfo.phoneNo}</td>
				 	</tr>
				 	<tr>
					 	<th>주소</th>
					 	<td colspan="5"> ${requestScope.personalInfo.address}</td>
				 	</tr>
				 	<tr>
				 		<th>보훈대상</th>
				 		<td colspan="2"> ${requestScope.unusual.isRewarded}</td>
				 		<th>장애대상 / 등급</th>
				 		<td colspan="2"> ${requestScope.unusual.isDisabled} / ${requestScope.unusual.disability}</td>
				 	</tr>
				 	
				 	<!-- 병역사항 -->
				 	<tr class="active">
				 		<th colspan="7">병역사항</th>
				 	</tr>
				 	<tr>
				 		<th colspan="2">병역구분</th>
				 		<td> ${requestScope.military.pass} </td>
				 		<th colspan="2">복무기간</th>
				 		<td colspan="2"> ${requestScope.military.startDate} ~  ${requestScope.military.endDate}</td>
				 	</tr>
				 	<tr>
				 		<th colspan="2">군별구분</th>
				 		<td> ${requestScope.military.category}</td>
				 		<th colspan="2">군별계급</th>
				 		<td colspan="2"> ${requestScope.military.rank}</td>
				 	</tr>
				 	 <!-- 학력사항 -->
				 	<tr class="active">
				 		<th colspan="7">학력사항</th>
				 	</tr>
				 	<!-- 고등학교 -->
				 	<c:if test="${requestScope.school[0] ne null}">
					 	<tr>
					 		<th rowspan="3">고등학교</th>
					 	</tr>
					 	<tr>
					 		<th>학교명</th>
					 		<td> ${requestScope.school[0].startDate}</td>
					 		<th>재학기간</th>
					 		<td colspan="3">${requestScope.school[0].startDate} ~ ${requestScope.school[0].endDate}</td>
					 	</tr>
						<tr>
					 		<th>계열</th>
					 		<td>${requestScope.school[0].track}</td>
					 		<th>전공</th>
					 		<td colspan="3">${requestScope.school[0].major}</td>
					 	</tr>
				 	</c:if>
				 	<!-- 고등학교 끝 -->
				 
				 	<!-- 대학교 시작 -->
				 	<c:if test="${requestScope.school[1] ne null}">
					 	<tr>
					 		<th rowspan="4">대학교</th>
					 	</tr>
					 	<tr>
					 		<th>학교명</th>
					 		<td>${requestScope.school[1].name}</td>
					 		<th>재학기간</th>
					 		<td colspan="3">${requestScope.school[1].startDate} ~ ${requestScope.school[1].endDate}</td>
					 	</tr>
						<tr>
					 		<th>계열</th>
					 		<td>${requestScope.school[1].track}</td>
					 		<th>전공</th>
					 		<td>${requestScope.school[1].major}</td>
					 		<th>학위</th>
					 		<td>${requestScope.school[1].degree}</td>
					 	</tr>
					 	<tr>
					 		<th>학점</th>
					 		<td>${requestScope.school[1].grade} / ${requestScope.school[1].totalGrade}</td>
					 		<th>상태</th>
					 		<td>${requestScope.school[1].state}</td>
					 		<th>지역</th>
					 		<td>${requestScope.school[1].location}</td>
					 	</tr>
				 	</c:if>
				 	<!-- 대학교 끝 -->
				 	<!-- 대학원 시작 -->
				 	<c:if test="${requestScope.school[2] ne null}">
					 	<tr>
					 		<th rowspan="4">대학원</th>
					 	</tr>
					 	<tr>
					 		<th>학교명</th>
					 		<td>${requestScope.school[2].name}</td>
					 		<th>재학기간</th>
					 		<td colspan="3">${requestScope.school[1].startDate} ~ ${requestScope.school[1].endDate}</td>
					 	</tr>
						<tr>
					 		<th>계열</th>
					 		<td>${requestScope.school[2].track}</td>
					 		<th>전공</th>
					 		<td>${requestScope.school[2].major}</td>
					 		<th>학위</th>
					 		<td>${requestScope.school[2].degree}</td>
					 	</tr>
					 	<tr>
					 		<th>학점</th>
					 		<td>${requestScope.school[2].grade} / ${requestScope.school[2].totalGrade}</td>
					 		<th>상태</th>
					 		<td>${requestScope.school[2].state}</td>
					 		<th>지역</th>
					 		<td>${requestScope.school[2].location}</td>
					 	</tr>
				 	</c:if>
				 	<!-- 대학원 끝 -->
				 	
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
				 	<c:forEach var="career" items="${careerSelect}">
				 	<tr>
				 		<td>구글</td>
				 		<td colspan="2">${career.startDate} ~ ${career.endDate}</td>
				 		<td>${career.position}</td>
				 		<td>${career.department}</td>
				 		<td>${career.task}</td>
				 		<td>${career.retirementReason}</td>
				 	</tr>
				 	</c:forEach>
				 	
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
				 	<c:forEach var="award" items="${award}">
				 	<tr>
				 		<td>${award.category} / ${award.field}</td>
				 		<td>${award.name}</td>
				 		<td>${award.date}</td>
				 		<td>${award.target}</td>
				 		<td colspan="2">${award.publication}</td>
				 		<td>${award.content}</td>
				 	</tr>
				 	</c:forEach>
				 	
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
					 		<td>2017년 2월</td>
					 		<td>산업인력공단</td>
					 		<td colspan="2">토익</td>
					 		<td>800</td>
					 		<td>2016년 11월</td>
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
				 	<c:forEach var="foreign" items="${foreignAct}">
					 	<tr>
					 		<td>${foreign.category}</td>
					 		<td>${foreign.startDate} ~ ${foreign.endDate}</td>
					 		<td colspan="5">${foreign.content}</td>
					 	</tr>
				 	</c:forEach> 
				 	<c:forEach var="externAct" items="${externAct}">
				 		<tr>
				 			<td>${externAct.category}</td>
				 			<td>${externAct.startDate} ~ ${externAct.endDate}</td>
				 			<td colspan="5">${externAct.content}</td>
				 		</tr>
				 	</c:forEach>
				</table>
		</div>
		</div>
