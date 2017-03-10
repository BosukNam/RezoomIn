<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자기소개 test-Page</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="/RezoomIn/resources/css/myBoot.css">
 <link href="/RezoomIn/resources/css/footer.css" rel="stylesheet" type="text/css">
 <link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/godofont.css">
<style>
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
</style>
</head>
<body>
 <jsp:include page="header.jsp"/>
<div class="col-md-2" align="center" id="left">
<jsp:include page="introduce.jsp"></jsp:include>
</div>

<div class="col-md-6" align="center">
		<div class="panel panel-primary">
			<div class="panel-heading" align="center">
				<h4>성장과정</h4>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-3" id="child">
						<div class="panel panel-success" align="center">
							<div class="panel-heading" align="center">
								<b><font size="3">유년기</font></b>
							</div>
							<img
								src="http://userscontent2.emaze.com/images/0712e1cc-0e01-48a7-b442-4ecc48e64b91/ee8f44fc-63df-4406-b909-1c2ba39d72c6image6.jpg"
								width="120px" height="80px" >
						</div>
					</div>

					<div class="col-md-3" id="student">
						<div class="panel panel-success" align="center">
							<div class="panel-heading" align="center">
								<b><font size="3">청소년기</font></b>
							</div>
							<img
								src="http://www.shesps.com/UploadFolder/editor_img/201510/20151016150247_709.png"
								width="120px" height="80px">
						</div>
					</div>

					<div class="col-md-3" id="univ">
						<div class="panel panel-success" align="center">
							<div class="panel-heading" align="center">
								<b><font size="3">대학생활</font></b>
							</div>
								<img
								src="http://magazine.hankyung.com/magazinedata/images/photo/201405/4201cf423157927cf34aa21919f6711a.jpg"
								width="120px" height="80px" >
								
						</div>
					</div>

					<div class="col-md-3" id="company">
						<div class="panel panel-success" align="center">
							<div class="panel-heading" align="center">
								<b><font size="3">회사생활</font></b>
							</div>
							<img
								src="http://blog.kcomwel.or.kr/attach/1/3859738025.jpg"
								width="120px" height="80px">
						</div>
					
				</div>
				</div>
				<div class="row">
					
					<div class="col-md-3" id="hobby">
						<div class="panel panel-success" align="center">
							<div class="panel-heading" align="center">
								<b><font size="3">취미</font></b>
							</div>
							<img
								src="http://cfile30.uf.tistory.com/image/253DA644542227D01E4EF3"
								width="120px" height="80px">
						</div>
					</div>
					<c:forEach var="item" items="${requestScope.hobbyMap}">
						<input type="hidden" value="${item.value.iconURL}" class="${item.value.iconCode}">
					</c:forEach>

					<div class="col-md-3" id="skill">
						<div class="panel panel-success" align="center">
							<div class="panel-heading" align="center">
								<b><font size="3">특기</font></b>
							</div>
							<img
								src="http://kpioc.cdn2.cafe24.com/math/cover.jpg"
								width="120px" height="80px">
						</div>
					</div>
					<c:forEach var="item" items="${requestScope.skillMap}">
						<input type="hidden" value="${item.value.iconURL}" class="${item.value.iconCode}">
					</c:forEach>

					<div class="col-md-3" id="keyword">
						<div class="panel panel-success" align="center">
							<div class="panel-heading" align="center">
								<b><font size="3">대표 키워드</font></b>
							</div>
							<img
								src="http://previews.123rf.com/images/flybird163/flybird1631411/flybird163141100183/36318074-who-am-i-text-write-on-paper-Stock-Photo.jpg"
								width="120px" height="80px">
						</div>
					</div>
				</div>
				
				<button type="button" class="btn btn-default btn">확인</button>
				<button type="button" class="btn btn-default btn">취소</button>
			</div>
			
		</div>
		
</div> 

<input type="hidden" value="${from}" id="from">
<div class="col-md-4" align="center">
<jsp:include page="introduce_right.jsp"/>
</div>
<!-- MODAL 시작-->
		<div class="modal fade" id="childModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<b><font size="3">유년기</font></b>
					</div>
					
					<div class="modal-body container">
					<div class="row">
					<div class="wrap col-md-6">
    				<textarea class="form-control" name="content1" id="content1" maxlength="1000" placeholder="어린시절에 대한 내용을 입력해주세요"></textarea>
					</div>
					</div>
					
					<div class="row">
					<div class="col-md-6" align="right" style="margin-left:13px;">
					<span id="counter1-1">###</span><span id="counter1">###</span></div>
					</div>
					
					<div class="row">
					<div class="col-md-6" align="center">
					<button type="button" id="addChildBtn" class="btn btn-default btn">확인</button>
					<button type="button" id="cancelChildBtn" data-dismiss="modal" class="btn btn-default btn">취소</button>
					</div>
					</div>
					</div>
				</div>
			</div>
		</div>
		<!-- MODAL 끝 -->
		
		<!-- MODAL 시작-->
		<div class="modal fade" id="studentModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<b><font size="3">청소년기</font></b>
					</div>
					
					<div class="modal-body container">
					<div class="row">
					<div class="wrap col-md-6">
    				<textarea class="form-control" name="content2" id="content2" maxlength="1000" placeholder="청소년 시절의 내용을 입력해주세요"></textarea>
					</div>
					</div>
					
					<div class="row">
					<div class="col-md-6" align="right" style="margin-left:13px;">
					<span id="counter2-1">###</span><span id="counter2">###</span></div>
					</div>
					
					<div class="row">
					<div class="col-md-6" align="center">
					<button type="button" id="addStudentBtn" class="btn btn-default btn">확인</button>
					<button type="button" id="cancelStudentBtn" data-dismiss="modal" class="btn btn-default btn">취소</button>
					</div>
					</div>
					</div>
				</div>
			</div>
		</div>
		<!-- MODAL 끝 -->
		
		<!-- MODAL 시작-->
		<div class="modal fade" id="univModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<b><font size="3">대학생활</font></b>
					</div>
					
					<div class="modal-body container">
					<div class="row">
					<div class="wrap col-md-6">
    				<textarea class="form-control" name="content3" id="content3" maxlength="1000" placeholder="대학생활에 대한 내용을 입력해주세요"></textarea>
					</div>
					</div>
					
					<div class="row">
					<div class="col-md-6" align="right" style="margin-left:13px;">
					<span id="counter3-1">###</span><span id="counter3">###</span></div>
					</div>
					
					<div class="row">
					<div class="col-md-6" align="center">
					<button type="button" id="addUnivBtn" class="btn btn-default btn">확인</button>
					<button type="button" id="cancelUnivBtn" data-dismiss="modal" class="btn btn-default btn">취소</button>
					</div>
					</div>
					</div>
				</div>
			</div>
		</div>
		<!-- MODAL 끝 -->
		
		<!-- MODAL 시작-->
		<div class="modal fade" id="companyModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<b><font size="3">회사생활</font></b>
					</div>
					
					<div class="modal-body container">
					<div class="row">
					<div class="wrap col-md-6">
    				<textarea class="form-control" name="content4" id="content4" maxlength="1000" placeholder="회사 재직 시절의 내용을 입력해주세요"></textarea>
					</div>
					</div>
					
					<div class="row">
					<div class="col-md-6" align="right" style="margin-left:13px;">
					<span id="counter4-1">###</span><span id="counter4">###</span></div>
					</div>
					
					<div class="row">
					<div class="col-md-6" align="center">
					<button type="button" id="addCompanyBtn" class="btn btn-default btn">확인</button>
					<button type="button" id="cancelCompanyBtn" data-dismiss="modal" class="btn btn-default btn">취소</button>
					</div>
					</div>
					</div>
				</div>
			</div>
		</div>
		<!-- MODAL 끝 -->
		
		<!-- MODAL 시작-->
		<div class="modal fade" id="hobbyModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<div align="left">
						<b><font size="3">취미</font></b>
						</div>
					</div>
					
					<div class="modal-body container">
					
					<div class="row">
					<div class="col-md-3">
						<div class="row" align="left">
						&nbsp;&nbsp;&nbsp;아이콘
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;취미명
						</div>
						
						<div class="row" align="left">
								&nbsp;
								<button type="button" class="btn btn-default"
									data-container="body" data-toggle="popover"
									data-html="true"
									data-content='<div id="popover-content">
									
									<c:forEach var="item" items="${requestScope.hobbyMap}">
									<c:if test="${item.value.iconCode ne 'IH18'}"><img src="${item.value.iconURL}" width="30px" height="30px" id="${item.value.iconCode}"> </c:if>
									</c:forEach>
									<c:forEach var="item" items="${requestScope.hobbyMap}">
									<c:if test="${item.value.iconCode eq 'IH18'}"><img src="${item.value.iconURL}" width="30px" height="30px" id="${item.value.iconCode}"> </c:if>
									</c:forEach>
									
									</div>' 
									data-placement="bottom" id="myPop">
									<img src="http://image.flaticon.com/icons/svg/136/136832.svg"
										width="30px" height="30px">
									<input type="hidden" name="hicon" value="IH18">
								</button>

								&nbsp; <input type="text" placeholder="취미명을 입력해주세요"
								 id="hobbyName" size="29px">
							</div>
						<div class="row" align="center">
						<button type="button" class="btn btn-default btn" id="addHobbyBtn">취미 추가</button>
						</div>
					</div>
					<div class="row">
					<form action="specialtyhobby.do" method="get" id="hobbyFrm">
					<div class="thumbnail col-md-3" style="height:168px; right:0px" id="iconList"></div>
					<input type="hidden" value="yeeee4" name="memberID">
					<input type="hidden" value="hobby" name="from">
					</form>
					</div>
					<div class="row">
					<div style="padding-left: 580px" id="iconCnt">0/5</div>
					</div>
						
					</div>
					</div>
					
					<div class="row">
					<div class="col-md-12" align="center" style="height: 45px;">
					<button type="button" data-dismiss="modal" class="btn btn-default btn" id="hobbyConfirmBtn">확인</button>
					<button type="button" data-dismiss="modal" class="btn btn-default btn" id="hobbyCancelBtn">취소</button>
					</div>
					</div>
					</div>
				</div>
			</div>
		<!-- MODAL 끝 -->
		
		<!-- MODAL 시작-->
		<div class="modal fade" id="skillModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<div align="left">
						<b><font size="3">특기</font></b>
						</div>
					</div>
					
					<div class="modal-body container">
					
					<div class="row">
					<div class="col-md-3">
						<div class="row" align="left">
						&nbsp;&nbsp;&nbsp;아이콘
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;특기명
						</div>
						<div class="row" align="left">
								&nbsp;
								<button type="button" class="btn btn-default"
									data-container="body" data-toggle="popover"
									data-html="true"
									data-content='<div id="spopover-content">
									
									<c:forEach var="item" items="${requestScope.skillMap}">
									<c:if test="${item.value.iconCode ne 'IS18'}"><img src="${item.value.iconURL}" width="30px" height="30px" id="${item.value.iconCode}"> </c:if>
									</c:forEach>
									<c:forEach var="item" items="${requestScope.skillMap}">
									<c:if test="${item.value.iconCode eq 'IS18'}"><img src="${item.value.iconURL}" width="30px" height="30px" id="${item.value.iconCode}"> </c:if>
									</c:forEach>
									
									</div>' 
									data-placement="bottom" id="smyPop">
									<img src="http://image.flaticon.com/icons/svg/136/136832.svg"
										width="30px" height="30px">
									<input type="hidden" name="sicon" value="IS18">
								</button>

								&nbsp; <input type="text" placeholder="특기명을 입력해주세요"
								 id="skillName" name="skillName" size="29px">
							</div>
						<div class="row" align="center">
						<button type="button" class="btn btn-default btn" id="addSkillBtn">특기 추가</button>
						</div>
					</div>
					<div class="row">
					<form action="specialtyskill.do" method="get" id="skillFrm">
					<div class="thumbnail col-md-3" style="height:168px; right:0px" id="siconList"></div>
					<input type="hidden" value="yeeee4" name="memberID">
					<input type="hidden" value="skill" name="from">
					</form>
					</div>
					<div class="row">
					<div style="padding-left: 580px" id="siconCnt">0/5</div>
					</div>
						
					</div>
					</div>
					
					<div class="row">
					<div class="col-md-12" align="center" style="height: 45px;">
					<button type="button" data-dismiss="modal" class="btn btn-default btn" id="skillConfirmBtn">확인</button>
					<button type="button" data-dismiss="modal" class="btn btn-default btn" id="skillCancelBtn">취소</button>
					</div>
					</div>
					</div>
				</div>
			</div>
		<!-- MODAL 끝 -->
		
		<!-- MODAL 시작-->
		<div class="modal fade" id="keywordModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<div align="left">
						<b><font size="3">대표 키워드</font></b>
						</div>
					</div>
					
					<div class="modal-body container">
					
					<div class="row">
					<div class="col-md-3">
						<div class="row" align="left">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;대표 키워드
						</div>
						<div class="row" align="left">
								&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" placeholder="나를 대표할 수 있는 키워드 입력해주세요"
								 id="keywordName" name="keywordName" size="35px">
							</div>
						<div class="row" align="center">
						<button type="button" class="btn btn-default btn" id="addKeywordBtn">대표 키워드 추가</button>
						</div>
					</div>
					<div class="row">
					<form action="personalkey.do" method="post" id="keywordFrm">
					<div class="thumbnail col-md-3" style="height:220px" id="keywordList"></div>
					<input type="hidden" name="memberID" value="yeeee4">
					</form>
					</div>
					<div class="row">
					<div style="padding-left: 580px" id="keywordCnt">0/5</div>
					</div>
						
					</div>
					</div>
					
					<div class="row">
					<div class="col-md-12" align="center" style="height: 45px;">
					<button type="button" data-dismiss="modal" class="btn btn-default btn" id="keywordConfirmBtn">확인</button>
					<button type="button" data-dismiss="modal" class="btn btn-default btn" id="keywordCancelBtn">취소</button>
					</div>
					</div>
					</div>
				</div>
			</div>
		<!-- MODAL 끝 -->
		
<jsp:include page="footer.html"/>
</body>

<script type="text/javascript">
	$(function() {
		
		function calByte(obj){
			var str = obj.val();
			var str_len = str.length;

			var rbyte = 0;
			var rlen = 0;
			var one_char = "";
			var str2 = "";

			for (var i = 0; i < str_len; i++) {
				one_char = str.charAt(i);
				if (escape(one_char).length > 4) {
					rbyte += 3; //한글2Byte
				} else {
					rbyte++; //영문 등 나머지 1Byte
				}
			}
			return rbyte;
		}
		
		function calByteVal(obj){
			var str = obj;
			var str_len = str.length;

			var rbyte = 0;
			var rlen = 0;
			var one_char = "";
			var str2 = "";

			for (var i = 0; i < str_len; i++) {
				one_char = str.charAt(i);
				if (escape(one_char).length > 4) {
					rbyte += 3; //한글2Byte
				} else {
					rbyte++; //영문 등 나머지 1Byte
				}
			}
			return rbyte;
		}

		$("#addChildBtn").on('click', function() {
			
			if(calByte($('#content1'))==0){
				alert("내용을 입력해주세요!!");
				return false;
			}else if(calByte($('#content1'))>1000){
				alert("글자수를 초과했습니다!!\n(한글 333글자, 영문 1000글자 내로 입력하세요)");
				return false;
			}
			
			var obj = new Object();
            obj.childhood = $('#content1').val();
            obj.id = 'yeeee4';
            var jsonData = JSON.stringify(obj);
            
			$.ajax({
				/* url:'/RezoomIn/gchild.do',
				type:'POST', */
				url:'/RezoomIn/personal.do',
				type:'post',
				data : { json : jsonData },
				success:function(res){ // 응답 온 데이터
					$('#childModal').modal('hide');
					 alert(res);
						/* $('#content1').html('');
						$('#counter1').html('0/1000 byte');
						$('#counter1-1').html('0 글자 '); */
					$(".history").show();
				},
				error:function(){
					alert("으이구!~~");
				}
			});
		});
		$("#cancelChildBtn").on('click', function() {
			/* $('#childModal').modal('hide');
			$('#content1').val('');
			$('#counter1').html('0/1000 byte')
			$('#counter1-1').html('0 글자 ') */
		});
		$("#addStudentBtn").on('click', function() {
			if(calByte($('#content2'))==0){
				alert("내용을 입력해주세요!!");
				return false;
			}else if(calByte($('#content2'))>1000){
				alert("글자수를 초과했습니다!!\n(한글 333글자, 영문 1000글자 내로 입력하세요)");
				return false;
			}

			var obj = new Object();
            obj.student = $('#content2').val();
            obj.id = 'yeeee4';
            var jsonData = JSON.stringify(obj);
            
			$.ajax({
				url:'/RezoomIn/personal.do',
				type:'post',
				data : { json : jsonData },
				success:function(res){ // 응답 온 데이터
					 $('#studentModal').modal('hide');
					 alert(res);
						/* $('#content2').val('');
						$('#counter2').html('0/1000 byte')
						$('#counter2-1').html('0 글자 ') */
					 $(".history").show();
				},
				error:function(){
					alert("으이구!~~");
				}
			});
		});
		$("#cancelStudentBtn").on('click', function() {
			/* $('#studentModal').modal('hide');
			$('#content2').val('');
			$('#counter2').html('0/1000 byte')
			$('#counter2-1').html('0 글자 ') */
		});
		$("#addUnivBtn").on('click', function() {
			if(calByte($('#content3'))==0){
				alert("내용을 입력해주세요!!");
				return false;
			}else if(calByte($('#content3'))>1000){
				alert("글자수를 초과했습니다!!\n(한글 333글자, 영문 1000글자 내로 입력하세요)");
				return false;
			}

			var obj = new Object();
            obj.univ = $('#content3').val();
            obj.id = 'yeeee4';
            var jsonData = JSON.stringify(obj);
            
			$.ajax({
				url:'/RezoomIn/personal.do',
				type:'post',
				data : { json : jsonData },
				success:function(res){ // 응답 온 데이터
					 $('#univModal').modal('hide');
					 alert(res);
						/* $('#content3').val('');
						$('#counter3').html('0/1000 byte')
						$('#counter3-1').html('0 글자 ') */
					 $(".history").show();
				},
				error:function(){
					alert("으이구!~~");
				}
			});
		});
		$("#cancelUnivBtn").on('click', function() {
			/* $('#univModal').modal('hide');
			$('#content3').val('');
			$('#counter3').html('0/1000 byte')
			$('#counter3-1').html('0 글자 ') */
		});
		$("#addCompanyBtn").on('click', function() {
			if(calByte($('#content4'))==0){
				alert("내용을 입력해주세요!!");
				return false;
			}else if(calByte($('#content4'))>1000){
				alert("글자수를 초과했습니다!!\n(한글 333글자, 영문 1000글자 내로 입력하세요)");
				return false;
			}

			var obj = new Object();
            obj.company = $('#content4').val();
            obj.id = 'yeeee4';
            var jsonData = JSON.stringify(obj);
            
			$.ajax({
				url:'/RezoomIn/personal.do',
				type:'post', 
				data : { json : jsonData },
				success:function(res){ // 응답 온 데이터
					$('#companyModal').modal('hide');
					 alert(res);
						/* $('#content4').val('');
						$('#counter4').html('0/1000 byte')
						$('#counter4-1').html('0 글자 ') */
					 $(".history").show();
				},
				error:function(){
					alert("으이구!~~");
				}
			});
		});
		$("#cancelCompanyBtn").on('click', function() {
			/* $('#companyModal').modal('hide');
			$('#content4').val('');
			$('#counter4').html('0/1000 byte')
			$('#counter4-1').html('0 글자 ') */
		});
		
		$('#content1').keyup(function (e){
	          var content = $(this).val();
	          var byteCnt = calByte($(this)); 
	          $(this).height(((content.split('\n').length + 1) * 1.5) + 'em');
	          $('#counter1').html(byteCnt + '/1000 byte');
	          $('#counter1-1').html(content.length + ' 글자 ');
	          if(byteCnt>1000){
	        	  $('#counter1').css('background','rgba(255,0,0,0.5)')
	          }
	          else{
	        	  $('#counter1').css('background','')
	          }
	      });
	      $('#content1').keyup();

	      $('#content2').keyup(function (e){
	          var content = $(this).val();
	          var byteCnt = calByte($(this)); 
	          $(this).height(((content.split('\n').length + 1) * 1.5) + 'em');
	          $('#counter2').html(byteCnt + '/1000 byte');
	          $('#counter2-1').html(content.length + ' 글자 ');
	          if(byteCnt>1000){
	        	  $('#counter2').css('background','rgba(255,0,0,0.5)')
	          }
	          else{
	        	  $('#counter2').css('background','')
	          }
	      });
	      $('#content2').keyup();
	      
	      $('#content3').keyup(function (e){
	          var content = $(this).val();
	          var byteCnt = calByte($(this)); 
	          $(this).height(((content.split('\n').length + 1) * 1.5) + 'em');
	          $('#counter3').html(byteCnt + '/1000 byte');
	          $('#counter3-1').html(content.length + ' 글자 ');
	          if(byteCnt>1000){
	        	  $('#counter3').css('background','rgba(255,0,0,0.5)')
	          }
	          else{
	        	  $('#counter3').css('background','')
	          }
	      });
	      $('#content3').keyup();
	      
	      $('#content4').keyup(function (e){
	          var content = $(this).val();
	          var byteCnt = calByte($(this)); 
	          $(this).height(((content.split('\n').length + 1) * 1.5) + 'em');
	          $('#counter4').html(byteCnt + '/1000 byte');
	          $('#counter4-1').html(content.length + ' 글자 ');
	          if(byteCnt>1000){
	        	  $('#counter4').css('background','rgba(255,0,0,0.5)')
	          }
	          else{
	        	  $('#counter4').css('background','')
	          }
	      });
	      $('#content4').keyup();
		
		$("#myPop").popover();
		$('#myPop').on('shown.bs.popover', function() {
			for(var cnt=1; cnt<=18; cnt++){
				var iconCode = "IH"+cnt;
				var iconURL = $('#'+iconCode).attr('src');
				
				console.log(iconCode);
				$('#'+iconCode).on('click', function() {
					console.log(this);
					$('#myPop').popover('hide');
					$('#myPop').html('<img src="'+$(this).attr('src')+'" width="30px" height="30px">'
							+'<input type="hidden" name="hicon" value="'+$(this).attr('id')+'">');
				});
			} 
		});
		
		
		
		
		
		$("#smyPop").popover();
		$('#smyPop').on('shown.bs.popover', function() {
			for(var cnt=1; cnt<=18; cnt++){
				var iconCode = "IS"+cnt;
				var iconURL = $('#'+iconCode).attr('src');
				
				console.log(iconCode);
				$('#'+iconCode).on('click', function() {
					console.log(this);
					$('#smyPop').popover('hide');
					$('#smyPop').html('<img src="'+$(this).attr('src')+'" width="30px" height="30px">'
							+'<input type="hidden" name="sicon" value="'+$(this).attr('id')+'">');
				});
			} 
		});
		
		
		
		$("#child").on('click', function() {
			$('#childModal').modal('show');
			
			if($('#from').val()=='load'){
				$.ajax({
					type:'get',
					url:'/RezoomIn/personalload.do',
					data:{"id":'yeeee4'},
					success:function(res){
						var obj = JSON.parse(res);
						
						$('#content1').html(obj.child);
						console.log(obj.child);
						
						  var content = obj.child;
				          var byteCnt = calByteVal(obj.child); 
				          $('#counter1').html(byteCnt + '/1000 byte');
				          $('#counter1-1').html(content.length + ' 글자 ');
				          if(byteCnt>1000){
				        	  $('#counter1').css('background','rgba(255,0,0,0.5)')
				          }
				          else{
				        	  $('#counter1').css('background','')
				          }
					},
					error:function(){
						alert("실패!!");
					}
				});
			}
			
		});
		
		
		
		
		
		$("#student").on('click', function() {
			$('#studentModal').modal('show');
				
			if($('#from').val()=='load'){
				$.ajax({
					type:'get',
					url:'/RezoomIn/personalload.do',
					data:{"id":'yeeee4'},
					success:function(res){
						var obj = JSON.parse(res);
						$('#content2').html(obj.student);
						console.log(obj.student);
						
						var content = obj.student;
				          var byteCnt = calByteVal(obj.student); 
				          $('#counter2').html(byteCnt + '/1000 byte');
				          $('#counter2-1').html(content.length + ' 글자 ');
				          if(byteCnt>1000){
				        	  $('#counter2').css('background','rgba(255,0,0,0.5)')
				          }
				          else{
				        	  $('#counter2').css('background','')
				          }
						
					},
					error:function(){
						alert("실패!!");
					}
				});
			}
			
		});
		$("#univ").on('click', function() {
			$('#univModal').modal('show');
			
			if($('#from').val()=='load'){
				$.ajax({
					type:'get',
					url:'/RezoomIn/personalload.do',
					data:{"id":'yeeee4'},
					success:function(res){
						var obj = JSON.parse(res);
						$('#content3').html(obj.univ);
						console.log(obj.univ);
						
						var content = obj.univ;
				          var byteCnt = calByteVal(obj.univ); 
				          $('#counter3').html(byteCnt + '/1000 byte');
				          $('#counter3-1').html(content.length + ' 글자 ');
				          if(byteCnt>1000){
				        	  $('#counter3').css('background','rgba(255,0,0,0.5)')
				          }
				          else{
				        	  $('#counter3').css('background','')
				          }
						
					},
					error:function(){
						alert("실패!!");
					}
				});
			}
		});
		$("#company").on('click', function() {
			$('#companyModal').modal('show');
			
			if($('#from').val()=='load'){
				$.ajax({
					type:'get',
					url:'/RezoomIn/personalload.do',
					data:{"id":'yeeee4'},
					success:function(res){
						var obj = JSON.parse(res);
						$('#content4').html(obj.company);
						console.log(obj.company);
						
						var content = obj.company;
				          var byteCnt = calByteVal(obj.company); 
				          $('#counter4').html(byteCnt + '/1000 byte');
				          $('#counter4-1').html(content.length + ' 글자 ');
				          if(byteCnt>1000){
				        	  $('#counter4').css('background','rgba(255,0,0,0.5)')
				          }
				          else{
				        	  $('#counter4').css('background','')
				          }
						
					},
					error:function(){
						alert("실패!!");
					}
				});
			}			
		});
		$("#hobby").on('click', function() {
			$('#hobbyModal').modal('show');
			
				$.ajax({
					type:'get',
					url:'/RezoomIn/specialtyload.do',
					data:{"id":'yeeee4'},
					success:function(res){
						var obj = JSON.parse(res);
						console.log(res);
						
						$('#iconList').html('');
						$('#iconCnt').html('0/5');
						hobbyCnt=0;
						for(var k=0; k<obj.hobby.length;k++){
							console.log(obj.hobby[k]);
							$('#iconList').append("<span><div>"
									+'<img src="'+$('.'+obj.hobby[k].iconCode).val()+'" name="hicon" width="30px" height="30px">'
									+'<input type="hidden" name="hicon" value="'+obj.hobby[k].iconCode+'">'
									+" "+obj.hobby[k].name
									+"<button type='button' class='myClose close-btn'>&times;</button>"
									+'<input type="hidden" name="hobby" value="'+obj.hobby[k].name+'">'
									+ "</div></span>");
									$('#hobbyName').val("");
							hobbyCnt++;
						}
						$('#iconCnt').html(hobbyCnt+'/5');
						
						$(".close-btn").on('click',function() {
							$(this).parentsUntil('#iconList').detach();
							hobbyCnt--;
							$('#iconCnt').html(hobbyCnt+'/5');
							$(this).onclick(null);
						});
					},
					error:function(){
						alert("실패!!");
					}
				});
			
			
		});
		$('#hobbyModal').on('hidden.bs.modal', function (e) {
			$('#myPop').popover('hide');
		});
		$('#skillModal').on('hidden.bs.modal', function (e) {
			$('#smyPop').popover('hide');
		});
		$("#skill").on('click', function() {
			$('#skillModal').modal('show');
			

				$.ajax({
					type:'get',
					url:'/RezoomIn/specialtyload.do',
					data:{"id":'yeeee4'},
					success:function(res){
						var obj = JSON.parse(res);
						console.log(res);
						
						 $('#siconList').html('');
						 $('#siconCnt').html('0/5');
						 skillCnt=0;
						for(var k=0; k<obj.skill.length;k++){
							console.log(obj.skill[k]);
							$('#siconList').append("<span><div>"
									+'<img src="'+$('.'+obj.skill[k].iconCode).val()+'" name="sicon" width="30px" height="30px">'
									+'<input type="hidden" name="sicon" value="'+obj.skill[k].iconCode+'">'
									+" "+obj.skill[k].name
									+"<button type='button' class='myClose close-btn'>&times;</button>"
									+'<input type="hidden" name="skill" value="'+obj.skill[k].name+'">'
									+ "</div></span>");
									$('#skillName').val("");
							skillCnt++;
						}
						$('#siconCnt').html(skillCnt+'/5');
						
						$(".close-btn").on('click',function() {
							$(this).parentsUntil('#siconList').detach();
							skillCnt--;
							$('#siconCnt').html(skillnt+'/5');
							$(this).onclick(null);
						});
						
					},
					error:function(){
						alert("실패!!");
					}
				});
			
		});
		$("#keyword").on('click', function() {
			$('#keywordModal').modal('show');
			
			if($('#from').val()=='load'){
				$.ajax({
					/* type:'post',
					url:'/RezoomIn/keyword.do', */
					type:'get',
					url:'/RezoomIn/personalload.do',
					data:{"id":'yeeee4'},
					success:function(res){
						var obj = JSON.parse(res);
						console.log(obj);
						
						keywordCnt=0;
						$('#keywordList').html('');
						for(var k=0; k<obj.keyword.length;k++){
							console.log(obj.keyword[k]);
							$('#keywordList').append('<span><div class="btn btn-circle btn-primary" name="keyword">'
									+" "+obj.keyword[k]
									+"<button type='button' class='myClose close-btn'>&times;</button>"
									+'<input type="hidden" value="'+obj.keyword[k]+'" name="keyword">'
									+ "</div></span>");
							keywordCnt++;
						}
						$('#keywordCnt').html(keywordCnt+'/5');
						
						$(".close-btn").on('click',function() {
							$(this).parentsUntil('#keywordList').detach();
							keywordCnt--;
							$('#keywordCnt').html(keywordCnt+'/5');
							$(this).onclick(null);
						});
						
					},
					error:function(){
						alert("실패!!");
					}
				});
			}
			
		});
	
		var hobbyCnt=0;
		
		$("#addHobbyBtn").on('click',function() {
			
			$('#myPop').popover('hide');
			
			if(hobbyCnt==5){
				alert("더 이상 등록할 수 없습니다!!");
				return false;
			}
			else if ($('#hobbyName').val() == "") {
					alert("취미명을 입력하세요!!");
					return false;
				}
			else if(calByte($('#hobbyName'))>30){
				alert("취미명이 너무 깁니다!!\n(한글 10글자, 영문 30글자 내로 입력하세요)");
				return false;
			}
			hobbyCnt++;
			$('#iconCnt').html(hobbyCnt+'/5');
		
			var txt = $.trim($('#hobbyName').val());
			var img = $.trim($('#myPop').html());
			//정규표현식필요... 음 아니면 attr이용?
			$('#myPop').html('<img src="http://image.flaticon.com/icons/svg/136/136832.svg" width="30px" height="30px">'
					+'<input type="hidden" name="hicon" value="IH18">');
				
				$('#iconList').append("<span><div>"
							+img
							+" "+txt
							+"<button type='button' class='myClose close-btn'>&times;</button>"
							+'<input type="hidden" name="hobby" value="'+txt+'">'
							+ "</div></span>");
							$('#hobbyName').val("");
							
							 var obj = new Object();
				             obj.name = txt;
				             obj.img = img;
				             var jsonData = JSON.stringify(obj);
							
							$(".close-btn").on('click',function() {
								$(this).parentsUntil('#iconList').detach();
								hobbyCnt--;
								$('#iconCnt').html(hobbyCnt+'/5');
								$(this).onclick(null);
							});
							$('#hobbyName').val("");
				});
		$("#hobbyConfirmBtn").on('click',function() {
			var formData = $("#hobbyFrm").serialize();
			$.ajax({
				/* url:'/RezoomIn/hobbies.do',
				type:'POST', */
				url:'/RezoomIn/specialtyhobby.do',
				type:'get',
				data : formData,
				success:function(res){ // 응답 온 데이터
					 alert(res);
					 $('#myPop').html('<img src="http://image.flaticon.com/icons/svg/136/136832.svg" width="30px" height="30px">'+
							 '<input type="hidden" name="hicon" value="IH18">');
					 $('#iconList').html('');
						$('#hobbyName').val("");
						hobbyCnt=0;
						$('#iconCnt').html('0/5');
						$(".history").show();
				},
				error:function(){
					alert("으이구!~~");
				}
			});
		});
		$("#hobbyCancelBtn").on('click',function() {
			$('#myPop').html('<img src="http://image.flaticon.com/icons/svg/136/136832.svg" width="30px" height="30px">'+
					'<input type="hidden" name="hicon" value="IH18">');
			 $('#iconList').html('');
				$('#hobbyName').val("");
				hobbyCnt=0;
				$('#iconCnt').html('0/5');	
		});
		
		var skillCnt=0;
		$("#addSkillBtn").on('click',function() {
			$('#smyPop').popover('hide');
			if(skillCnt==5){
				alert("더 이상 등록할 수 없습니다!!");
				return false;
			}
			else if ($('#skillName').val() == "") {
					alert("특기명을 입력하세요!!");
					return false;
				}
			else if(calByte($('#skillName'))>30){
				alert("특기명이 너무 깁니다!!\n(한글 10글자, 영문 30글자 내로 입력하세요)");
				return false;
			}
			skillCnt++;
			$('#siconCnt').html(skillCnt+'/5');
			var txt = $.trim($('#skillName').val());
			var img = $.trim($('#smyPop').html());
			$('#smyPop').html('<img src="http://image.flaticon.com/icons/svg/136/136832.svg" width="30px" height="30px">'+
					'<input type="hidden" name="sicon" value="IS18">');
				
				$('#siconList').append("<span><div>"
							+img
							+" "+txt
							+"<button type='button' class='myClose close-btn'>&times;</button>"
							+'<input type="hidden" name="skill" value="'+txt+'">'
							+ "</div></span>");
							$('#skillName').val("");
							
							
							 var obj = new Object();
				             obj.name = txt;
				             obj.img = img;
				             var jsonData = JSON.stringify(obj);
							
							$(".close-btn").on('click',function() {
								$(this).parentsUntil('#siconList').detach();
								skillCnt--;
								$('#siconCnt').html(skillCnt+'/5');
								$(this).onclick(null);
							});
							$('#skillName').val("");
				});
		$("#skillConfirmBtn").on('click',function() {
			var formData = $("#skillFrm").serialize();
			$.ajax({
				/* url:'/RezoomIn/skills.do',
				type:'POST', */
				url:'/RezoomIn/specialtyskill.do',
				type:'get',
				data : formData,
				success:function(res){ // 응답 온 데이터
					 alert(res);
				
					 $('#smyPop').html('<img src="http://image.flaticon.com/icons/svg/136/136832.svg" width="30px" height="30px">'+
							 '<input type="hidden" name="sicon" value="IS18">');
					 $('#siconList').html('');
						$('#skillName').val("");
						skillCnt=0;
						$('#siconCnt').html('0/5');
						$(".history").show();
				},
				error:function(){
					alert("으이구!~~");
				}
			});
		});
		
		$("#skillCancelBtn").on('click',function() {
					 $('#smyPop').html('<img src="http://image.flaticon.com/icons/svg/136/136832.svg" width="30px" height="30px">'+
							 '<input type="hidden" name="sicon" value="IS18">');
					 $('#siconList').html('');
						$('#skillName').val("");
						skillCnt=0;
						$('#siconCnt').html('0/5');
		});
		
		var keywordCnt=0;
		$("#addKeywordBtn").on('click',function() {
			if(keywordCnt==5){
				alert("더 이상 등록할 수 없습니다!!");
				return false;
			}
			else if ($('#keywordName').val() == "") {
					alert("대표 키워드를 입력하세요!!");
					return false;
				}
			else if(calByte($('#keywordName'))>30){
				alert("대표 키워드가 너무 깁니다!!\n(한글 10글자, 영문 30글자 내로 입력하세요)");
				return false;
			}
			keywordCnt++;
			$('#keywordCnt').html(keywordCnt+'/5');
			var txt = $.trim($('#keywordName').val());
				
				$('#keywordList').append('<span><div class="btn btn-circle btn-primary">'
							+" "+txt
							+"<button type='button' class='myClose close-btn'>&times;</button>"
							+'<input type="hidden" value="'+txt+'" name="keyword">'
							+ "</div></span>");
							$('#keywordName').val("");
							
							
							var obj = new Object();
				             obj.name = txt;
				             var jsonData = JSON.stringify(obj);
				             
							$(".close-btn").on('click',function() {
								$(this).parentsUntil('#keywordList').detach();
								keywordCnt--;
								$('#keywordCnt').html(keywordCnt+'/5');
								$(this).onclick(null);
							});
							$('#keywordName').val("");
				});
		
		$("#keywordConfirmBtn").on('click',function() {
			var formData = $("#keywordFrm").serialize();
			$.ajax({
				/* url:'/RezoomIn/keyword.do',
				type:'POST', */
				type:'post',
				url:'/RezoomIn/personalkey.do',
				data : formData,
				success:function(res){ // 응답 온 데이터
					 alert(res);
					
					 $('#keywordModal').modal('hide');
					 /* $('#keywordList').html('');
						$('#keywordName').val("");
						keywordCnt=0;
						$('#keywordCnt').html('0/5'); */
					 $(".history").show();
				},
				error:function(){
					alert("으이구!~~");
				}
			});
		});
		$("#keywordCancelBtn").on('click',function() {
					 /* $('#keywordList').html('');
						$('#keywordName').val("");
						keywordCnt=0;
						$('#keywordCnt').html('0/5'); */
		});
		
		
				
		});
</script>

</html>
