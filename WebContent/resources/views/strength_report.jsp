<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>장점 test-Page</title>

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
				<h4>장점</h4>
			</div>
			<div class="panel-body">
				<div class="modal-body">
    				<textarea class="form-control" id="content" style="min-height: 9em;"
    				 maxlength="1000" placeholder="자신의 장점에 대하여 입력해주세요"></textarea>
					
					<div class="row">
					<div align="right" style="margin-right:13px;">
					<span id="counter5-1">###</span><span id="counter5">###</span></div>
					</div>
			</div>

			<button type="button" class="btn btn-default btn" id="addStrengthBtn">확인</button>
			<button type="button" class="btn btn-default btn" id="cancelBtn">취소</button>
		</div>
</div> 
</div>
<input type="hidden" value="${from}" id="from">
<div class="col-md-4" align="center">
<jsp:include page="introduce_right.jsp"/>
</div>
 <jsp:include page="footer.html"/>
</body>

<script type="text/javascript">
	$(function() {
		
		if($('#from').val()=='load'){
			$.ajax({
				/* type:'post', */
				type:'get',
				/* url:'/TestFinalProject/strength.do', */
				url:'/TestFinalProject/strengthload.do',
				data:{"id":'yeeee4'},
				success:function(res){
					var obj = JSON.parse(res);
					$('#content').html(obj.strength);
					console.log(obj.strength);
					
					 var content = obj.strength;
			          var byteCnt = calByteVal(obj.strength); 
			          $('#counter5').html(byteCnt + '/1000 byte');
			          $('#counter5-1').html(content.length + ' 글자 ');
			          if(byteCnt>1000){
			        	  $('#counter5').css('background','rgba(255,0,0,0.5)')
			          }
			          else{
			        	  $('#counter5').css('background','')
			          }
				},
				error:function(){
					alert("실패!!");
				}
			});
		}
		
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
		
		$("#addStrengthBtn").on('click', function() {
			if(calByte($('#content'))==0){
				alert("내용을 입력해주세요!!");
				return false;
			}
			else if(calByte($('#content'))>1000){
				alert("글자수를 초과했습니다!!\n(한글 333글자, 영문 1000글자 내로 입력하세요)");
				return false;
			}
			
			var obj = new Object();
            obj.content = $('#content').val();
            obj.id = 'yeeee4';
            var jsonData = JSON.stringify(obj);
			
			$.ajax({
				/* url:'/TestFinalProject/strength.do', */
				url:'/TestFinalProject/strengthreport.do',
				/* type:'POST', */
				type:'GET',
				data : { json : jsonData },
				success:function(res){ // 응답 온 데이터
					 alert(res);
					$(".strength").show();
				},
				error:function(){
					alert("으이구!~~");
				}
			});
		});
		$("#cancelBtn").on('click', function() {
			$('#content').val('');
			$('#counter5').html('0/1000 byte')
			$('#counter5-1').html('0 글자 ')
		});
		
		$('#content').keyup(function (e){
	          var content = $(this).val();
	          var byteCnt = calByte($(this)); 
	          $(this).height(((content.split('\n').length + 1) * 1.5) + 'em');
	          $('#counter5').html(byteCnt + '/1000 byte');
	          $('#counter5-1').html(content.length + ' 글자 ');
	          if(byteCnt>1000){
	        	  $('#counter5').css('background','rgba(255,0,0,0.5)')
	          }
	          else{
	        	  $('#counter5').css('background','')
	          }
	      });
	      $('#content').keyup();
	});
</script>

</html>