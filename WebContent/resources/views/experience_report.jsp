<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>극복과정 test-Page</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="/TestFinalProject/resources/css/myBoot.css">
 <link href="/TestFinalProject/resources/css/footer.css" rel="stylesheet" type="text/css">




</head>
<body>
 <jsp:include page="header.jsp"/>
<div class="col-md-2" align="center" id="left">
<jsp:include page="introduce.jsp"></jsp:include>
</div>



<div class="col-md-6" align="center">
		<div class="panel panel-primary">
			<div class="panel-heading" align="center">
				<h4>극복과정</h4>
			</div>
		
		<div class="container col-md-12" align="right">
			<button type="button" class="btn btn-default" id="addOvercomeBtn">극복과정 추가</button>
			&nbsp;&nbsp;<label id="overcomeCnt">1/5</label>
		</div>
		<br>
		
		<form action="experience_report" method="get" id="overcomeFrm">
			<div class="panel-body">
				<div class="thumbnail" align="left">
				<button type="button" class="close close-btn" style="padding-right: 5px">&times;</button>
				<input type="text" placeholder=" 문제 및 난관을 입력해주세요" name="problem" size="75px">
    				<textarea class="form-control" style="min-height: 9em;" name="overcome"
    				 maxlength="1000" placeholder="극복과정을 입력해주세요"></textarea>
				</div>
			</div>
			<input type="hidden" value="yeeee4" name="memberID">
		</form>
		<div class="row row-centered" style="margin-bottom: 10px">
		<button type="button" class="btn btn-default btn" id="comfirmBtn">확인</button>
		<button type="button" class="btn btn-default btn" id="cancelBtn">취소</button>
		</div>
</div> 
</div>
<input type="hidden" value="${from}" id="from">
<div class="col-md-4" align="center">
<jsp:include page="introduce_right.jsp"/>
</div>
<%--  <jsp:include page="footer.html"/> --%>
</body>

<script type="text/javascript">
	$(function() {
		
		if($('#from').val()=='load'){
			$.ajax({
				/* type:'post',
				url:'/TestFinalProject/overcome.do', */
				type:'get',
				url:'/TestFinalProject/experienceload.do',
				data:{"id":'yeeee4'},
				success:function(res){
					var obj = JSON.parse(res);
					console.log(res);
					
					overcomeCnt=0;
					 $('.panel-body').html('');
					for(var k=0; k<obj.overcome.length;k++){
						console.log(obj.overcome[k]);
						 $('.panel-body').append('<div class="thumbnail" align="left">'+
									'<button type="button" class="close close-btn" style="padding-right: 5px">&times;</button>'+
									'<input type="text" value="'+obj.overcome[k].title+'" name="problem" size="75px">'+
					    				'<textarea class="form-control" style="min-height: 9em;" name="overcome"'+
					    				 ' maxlength="1000">'+obj.overcome[k].content+'</textarea></div>'
							);
						 $(".close-btn").on('click',function() {
								$(this).parentsUntil('.panel-body').detach();
								overcomeCnt--;
							    $('#overcomeCnt').html(overcomeCnt+'/5');
								$(this).onclick(null);
							});
						 overcomeCnt++;
					}
					  $('#overcomeCnt').html(overcomeCnt+'/5');
					
					
				},
				error:function(){
					alert("실패!!");
				}
			});
		}
		
		function calByte(obj){
			var str = obj;
			var str_len = obj.length;

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
		
		
		 var overcomeCnt=1;
	     $(".close-btn").on('click',function() {
				$(this).parentsUntil('.panel-body').detach();
				overcomeCnt--;
			    $('#overcomeCnt').html(overcomeCnt+'/5');
				$(this).onclick(null);
		});
	     
	     $("#comfirmBtn").on('click',function() {
	    	 var titles = $('input[name="problem"]');
	    	 var contents = $('textarea');
	    	 
	    	 for(var k=0;k<titles.length;k++){
	    		 if(titles[k].value==''){
	    			 alert("제목이 비어있습니다!");
	    			 return false;
	    		 }
	    		 else if(calByte(titles[k].value)>100){
	 				alert("문제 및 난관 글자수를 초과했습니다!!\n(한글 33글자, 영문 100글자 내로 입력하세요)");
					return false;
				}
	    		 else if(contents[k].value==''){
	    			 alert("내용이 비어있습니다!");
	    			 return false;
	    		 }
	    		 else if(calByte(contents[k].value)>1000){
	 				alert("극복과정 글자수를 초과했습니다!!\n(한글 333글자, 영문 1000글자 내로 입력하세요)");
					return false;
				}
	    		 console.log(titles[k].value);
	    		 console.log(contents[k].value);
	    	 }
	    	 
	    	 var formData = $("#overcomeFrm").serialize();
	    	 
				$.ajax({
					/* url:'/TestFinalProject/overcome.do',
					type:'POST', */
					url:'/TestFinalProject/experiencereport.do',
					type:'post',
					data : formData,
					success:function(res){ // 응답 온 데이터
						 alert(res);
						 $(".experience").show();
					},
					error:function(){
						alert("으이구!~~");
					}
				});
	     });
	     $("#cancelBtn").on('click',function() {
						 $('.panel-body').html('<div class="thumbnail" align="left">'+
									'<button type="button" class="close close-btn" style="padding-right: 5px">&times;</button>'+
									'<input type="text" placeholder=" 문제 및 난관을 입력해주세요" name="problem" size="75px">'+
					    				'<textarea class="form-control" style="min-height: 9em;" name="overcome"'+
					    				 ' maxlength="1000" placeholder="극복과정을 입력해주세요"></textarea></div>'
							);
							$(".close-btn").on('click',function() {
								$(this).parentsUntil('.panel-body').detach();
								overcomeCnt--;
							    $('#overcomeCnt').html(overcomeCnt+'/5');
								$(this).onclick(null);
							});
						overcomeCnt=1;
						 $('#overcomeCnt').html('1/5');
	     });
	     
	     
	      $("#addOvercomeBtn").on('click',function() {
	    	  if(overcomeCnt==5){
					alert("더 이상 등록할 수 없습니다!!");
					return false;
				}
	    	  overcomeCnt++;
			  $('#overcomeCnt').html(overcomeCnt+'/5');
				$('.panel-body').append('<div class="thumbnail" align="left">'+
						'<button type="button" class="close close-btn" style="padding-right: 5px">&times;</button>'+
						'<input type="text" placeholder=" 문제 및 난관을 입력해주세요" name="problem" size="75px">'+
		    				'<textarea class="form-control" style="min-height: 9em;" name="overcome"'+
		    				 ' maxlength="1000" placeholder="극복과정을 입력해주세요"></textarea></div>'
				);
				$(".close-btn").on('click',function() {
					$(this).parentsUntil('.panel-body').detach();
					overcomeCnt--;
				    $('#overcomeCnt').html(overcomeCnt+'/5');
					$(this).onclick(null);
				});
		});
	});
</script>

</html>