<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비전 및 목표 test-Page</title>

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
				<h4>비전 및 목표</h4>
			</div>
		
		<div class="container col-md-12" align="right">
			<button type="button" class="btn btn-default" id="addGoalBtn">비전 및 목표 추가</button>
			&nbsp;&nbsp;<label id="goalCnt">1/10</label>
		</div>
		<br>
		
		<form action="goal_report" method="get" id="goalFrm">
			<div class="panel-body">
				<div class="thumbnail" align="left">
				<button type="button" class="close close-btn" style="padding-right: 5px">&times;</button>
				<input type="text" placeholder="비전 및 목표를 입력해주세요" name="goal" size="75px">
				</div>
			</div>
			<input type="hidden" value="yeeee4" name="memberID">
		</form>
		<div class="row row-centered" style="margin-bottom: 10px">
			<button type="button" class="btn btn-default btn" id="confirmBtn">확인</button>
			<button type="button" class="btn btn-default btn" id="cancelBtn">취소</button>
		</div>
</div>
</div>

<input type="hidden" value="${from}" id="from">
<div class="col-md-4" align="center" style="margin-top:0px">
<jsp:include page="introduce_right.jsp"/>
</div> 
<jsp:include page="footer.html"/>
</body>

<script type="text/javascript">
	$(function() {
		
		if($('#from').val()=='load'){
			$.ajax({
				/* type:'post',
				url:'/TestFinalProject/goal.do', */
				type:'get',
				url:'/TestFinalProject/goalload.do',
				data:{"id":'yeeee4'},
				success:function(res){
					var obj = JSON.parse(res);
					console.log(obj);
					
					$('.panel-body').html('');
					goalCnt=0;
					for(var k=0; k<obj.goal.length;k++){
						console.log(obj.goal[k]);
						 goalCnt++;
						$('.panel-body').append('<div class="thumbnail" align="left">'+
								'<button type="button" class="close close-btn" style="padding-right: 5px">&times;</button>'+
								'<input type="text" value="'+obj.goal[k]+'" name="goal" size="75px"></div>'
						);
					}
					 $('#goalCnt').html(goalCnt+'/10');
					 $(".close-btn").on('click',function() {
							$(this).parentsUntil('.panel-body').detach();
							goalCnt--;
						    $('#goalCnt').html(goalCnt+'/10');
							$(this).onclick(null);
						});
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
		
		 var goalCnt=1;
	     $(".close-btn").on('click',function() {
				$(this).parentsUntil('.panel-body').detach();
				goalCnt--;
			    $('#goalCnt').html(goalCnt+'/10');
				$(this).onclick(null);
		});
	     
	     $("#confirmBtn").on('click',function() {
	        
	    	 var names = $('input[name="goal"]');
	    	 for(var k=0;k<names.length;k++){
	    		 if(names[k].value==''){
	    			 alert("입력 항목이 비어있습니다!");
	    			 return false;
	    		 }
	    		 else if(calByte(names[k].value)>100){
	 				alert("글자수를 초과했습니다!!\n(한글 33글자, 영문 100글자 내로 입력하세요)");
					return false;
				}
	    		 console.log(names[k].value);
	    	 }
	    	 
	    	 var formData = $("#goalFrm").serialize();
	    	 
				$.ajax({
					/* url:'/TestFinalProject/goal.do',
					type:'POST', */
					url:'/TestFinalProject/goalreport.do',
					type:'get',
					data : formData,
					success:function(res){ // 응답 온 데이터
						 alert(res);
							$(".goal").show();
					},
					error:function(){
						alert("으이구!~~");
					}
				});
	    	
	     });
	     $("#cancelBtn").on('click',function() {
			$('.panel-body').html('<div class="thumbnail" align="left">'+
					'<button type="button" class="close close-btn" style="padding-right: 5px">&times;</button>'+
					'<input type="text" placeholder="비전 및 목표를 입력해주세요" name="goal" size="75px"></div>'
			);
			$(".close-btn").on('click',function() {
				$(this).parentsUntil('.panel-body').detach();
				goalCnt--;
				$('#goalCnt').html(goalCnt+'/10');
				$(this).onclick(null);
			});
			goalCnt=1;
			$('#goalCnt').html('1/10');
	     });
	     
	      $("#addGoalBtn").on('click',function() {
	    	  if(goalCnt==10){
					alert("더 이상 등록할 수 없습니다!!");
					return false;
				}
	    	  goalCnt++;
			  $('#goalCnt').html(goalCnt+'/10');
				$('.panel-body').append('<div class="thumbnail" align="left">'+
						'<button type="button" class="close close-btn" style="padding-right: 5px">&times;</button>'+
						'<input type="text" placeholder="비전 및 목표를 입력해주세요" name="goal" size="75px"></div>'
				);
				$(".close-btn").on('click',function() {
					$(this).parentsUntil('.panel-body').detach();
					goalCnt--;
				    $('#goalCnt').html(goalCnt+'/10');
					$(this).onclick(null);
				});
		});
	});
</script>

</html>