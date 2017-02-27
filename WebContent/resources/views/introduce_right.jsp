<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자기소개 test-Page</title>

<script type="text/javascript">
	$(function() {
		
		$(".history").hide();
		$(".strength").hide();
		$(".experience").hide();
		$(".ready").hide();
		$(".goal").hide();
		
		$.ajax({
			url:'/TestFinalProject/getpersonalreport.do',
			type:'post',
			data:{"id":'yeeee4'},
			success:function(res){ // 응답 온 데이터
				var obj = JSON.parse(res);
				console.log(obj);
				
				if(obj.biography==true){
					$(".history").show();
				}
				if (obj.experience == true) {
					$(".experience").show();
				}
				if (obj.goal == true) {
					$(".goal").show();
				}
				if (obj.ready == true) {
					$(".ready").show();
				}
				if (obj.strength == true) {
					$(".strength").show();
				}
			},
			error : function() {
				alert("으이구!~~");
			}
		});

		$("#historyThm").on('click', function() {
			/* location.replace("/TestFinalProject/lgrowup.do"); */
			location.replace("/TestFinalProject/personalpage.do?type=load");
		});
		$("#strengthThm").on('click', function() {
			/* location.replace("/TestFinalProject/lstrength.do"); */
			location.replace("/TestFinalProject/strengthpage.do?type=load");
		});
		$("#experienceThm").on('click', function() {
			/* location.replace("/TestFinalProject/lovercome.do"); */
			location.replace("/TestFinalProject/experiencepage.do?type=load");
		});
		$("#readyThm").on('click', function() {
			/* location.replace("/TestFinalProject/lready.do"); */
			location.replace("/TestFinalProject/readypage.do?type=load");
		});
		$("#goalThm").on('click', function() {
			/* location.replace("/TestFinalProject/lgoal.do"); */
			location.replace("/TestFinalProject/goalpage.do?type=load");
		});
		$("#historyClose").on('click', function() {
			if (confirm("성장과정을 삭제하시겠습니까?\n(입력한 모든 내용이 삭제됩니다)")) {
				$.ajax({
					url : '/TestFinalProject/personaldel.do',
					type : 'post',
					async : false,
					data : {
						id : 'yeeee4'
					},
					success : function(res) { // 응답 온 데이터
						alert(res);
					},
					error : function() {
						alert("으이구!~~");
					}
				});
				$(this).parentsUntil('.my-panel').detach();
			}
			$(this).onclick(null);
		});
		$("#strengthClose").on('click', function() {
			if (confirm("장점을 삭제하시겠습니까?\n(입력한 모든 내용이 삭제됩니다)")) {
				$.ajax({
					url : '/TestFinalProject/strengthdel.do',
					type : 'post',
					async : false,
					data : {
						id : 'yeeee4'
					},
					success : function(res) { // 응답 온 데이터
						alert(res);
					},
					error : function() {
						alert("으이구!~~");
					}
				});
				$(this).parentsUntil('.my-panel').detach();
			}
			$(this).onclick(null);
		});
		$("#experienceClose").on('click', function() {
			if (confirm("극복과정을 삭제하시겠습니까?\n(입력한 모든 내용이 삭제됩니다)")) {
				$.ajax({
					url : '/TestFinalProject/experiencedel.do',
					type : 'post',
					async : false,
					data : {
						id : 'yeeee4'
					},
					success : function(res) { // 응답 온 데이터
						alert(res);
					},
					error : function() {
						alert("으이구!~~");
					}
				});
				$(this).parentsUntil('.my-panel').detach();
			}
			$(this).onclick(null);
		});
		$("#readyClose").on('click', function() {
			if (confirm("준비과정을 삭제하시겠습니까?\n(입력한 모든 내용이 삭제됩니다)")) {
				$.ajax({
					url : '/TestFinalProject/readydel.do',
					type : 'post',
					async : false,
					data : {
						id : 'yeeee4'
					},
					success : function(res) { // 응답 온 데이터
						alert(res);
					},
					error : function() {
						alert("으이구!~~");
					}
				});
				$(this).parentsUntil('.my-panel').detach();
			}
			$(this).onclick(null);
		});
		$("#goalClose").on('click', function() {
			if (confirm("비전 및 목표를 삭제하시겠습니까?\n(입력한 모든 내용이 삭제됩니다)")) {
				$.ajax({
					url : '/TestFinalProject/goaldel.do',
					type : 'post',
					async : false,
					data : {
						id : 'yeeee4'
					},
					success : function(res) { // 응답 온 데이터
						alert(res);
					},
					error : function() {
						alert("으이구!~~");
					}
				});
				$(this).parentsUntil('.my-panel').detach();
			}
			$(this).onclick(null);
		});

		// 데이터가 있으면 썸네일 출력되도록 함수 만들기!!~~

	});
</script>

</head>
<body>

<div class="my-panel">

		<div class="history">
		<div class='thumbnail col-md-3' align="center" style="margin: 10px">
			<button type='button' class='close close-tbtn' id='historyClose' aria-label='Close'>
				<span aria-hidden='true'>&times;</span>
			</button>
			<div id="historyThm">
				<br>
				<div class='lang-thumb'>
					<img src='https://images.sciencedaily.com/2014/02/140226102130_1_540x360.jpg' width="90px" height="60px" >
					<div class='caption'>성장과정</div>
				</div>
			</div>
		</div>
		</div>
		
		<div class="strength">
		<div class='thumbnail col-md-3' align="center" style="margin: 10px">
			<button type='button' class='close close-tbtn' id='strengthClose' aria-label='Close'>
				<span aria-hidden='true'>&times;</span>
			</button>
			<div id="strengthThm">
				<br>
				<div class='lang-thumb'>
					<img src='http://www.tabatatimes.com/wp-content/uploads/2015/09/Perform-Multi-Joint.jpg' width="90px" height="60px" >
					<div class='caption'>장점</div>
				</div>
			</div>
		</div>
		</div>
		
		<div class="experience">
		<div class='thumbnail col-md-3' align="center" style="margin: 10px">
			<button type='button' class='close close-tbtn' id='experienceClose' aria-label='Close'>
				<span aria-hidden='true'>&times;</span>
			</button>
			<div id="experienceThm">
				<br>
				<div class='lang-thumb'>
					<img src='http://www.startyourbusinessmag.com/wp-content/uploads/2014/05/OvercomeFear.jpg' width="90px" height="60px" >
					<div class='caption'>극복과정</div>
				</div>
			</div>
		</div>
		</div>
		
		<div class="ready">
		<div class='thumbnail col-md-3' align="center" style="margin: 10px">
			<button type='button' class='close close-tbtn' id='readyClose' aria-label='Close'>
				<span aria-hidden='true'>&times;</span>
			</button>
			<div id="readyThm">
				<br>
				<div class='lang-thumb'>
					<img src="http://sparkl.com/talking-points/postimages/buildingblocks.jpg"
						width="90px" height="60px">
					<div class='caption'>준비과정</div>
				</div>
			</div>
		</div>
		</div>
		
		<div class="goal">
		<div class='thumbnail col-md-3' align="center" style="margin: 10px">
			<button type='button' class='close close-tbtn' id='goalClose' aria-label='Close'>
				<span aria-hidden='true'>&times;</span>
			</button>
			<div id="goalThm">
				<br>
				<div class='lang-thumb'>
					<img src="http://static.wixstatic.com/media/c3835d_5373700212b04928b1dde707de2f0e9e.jpg"
						width="90px" height="60px">
					<div class='caption'><font size="2.5px">비전 및 목표</font></div>
				</div>
			</div>
		</div>
		</div>
	
</div>

</body>
</html>