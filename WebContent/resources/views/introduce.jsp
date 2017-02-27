<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자기소개 test-Page</title>
<style>
/*  버튼 효과  */
.color-pattern-1 {
    background: #fff;
}
/* General button style (reset) */
.button_style {
    border: none;
    color: #000;
    background-color :#fff; /* beforeColor */
    cursor: pointer;
    padding: 20px 60px;
    display: inline-block;
    text-transform: uppercase;
    letter-spacing: 1px;
    font-weight: 800;
    font-size : 1.2em;
    outline: none;
    position: relative;

    transition: all 0.5s;
}
.button_style:after {
    content: '';
    position: absolute;
    z-index: -1;

    transition: all 0.5s;
}
/* Button 1 */
.button-1 {
    border: 3px solid #fff; /* beforeColor */
    color: #000;
}

/* Button 1a */
.button-1a:hover,
.button-1a:active {
    color: #fff;
    background: #ec1b5a;	/* AfterColor */
    border : 3px solid #ec1b5a; /* AfterColor */
}
/* Button 2 */
.button-2 {
    border: 3px solid #fff; /* beforeColor */
    color: #000;
}

/* Button 2a */
.button-2a:hover,
.button-2a:active {
    color: #fff;
    background: #79aefe;	/* AfterColor */
    border : 3px solid #79aefe; /* AfterColor */
}
</style>
<script type="text/javascript">
	$(function() {
		$("#addBtn").on('click', function() {
			$('#addModal').modal('show');
		});
		$("#showBtn").on('click', function() {
			location.replace("/TestFinalProject/previewperson.do");
		});
		$("#growup").on('click', function() {
			/* location.replace("/TestFinalProject/ngrowup.do"); */
			location.replace("/TestFinalProject/personalpage.do?type=new");
		});
		$("#strength").on('click', function() {
			/* location.replace("/TestFinalProject/nstrength.do"); */
			location.replace("/TestFinalProject/strengthpage.do?type=new");
		});
		$("#overcome").on('click', function() {
			/* location.replace("/TestFinalProject/novercome.do"); */
			location.replace("/TestFinalProject/experiencepage.do?type=new");
		});
		$("#ready").on('click', function() {
			/* location.replace("/TestFinalProject/nready.do"); */
			location.replace("/TestFinalProject/readypage.do?type=new");
		});
		$("#goal").on('click', function() {
			/* location.replace("/TestFinalProject/ngoal.do"); */
			location.replace("/TestFinalProject/goalpage.do?type=new");
		});
	});
</script>
<%--   <link href="${pageContext.request.contextPath }/resources/css/header.css" rel="stylesheet" type="text/css"> --%>
</head>
<body>
<br><br>

    <section class="color-pattern-1">
        <div>
            <button class="button button_style button-1 button-1a" id="addBtn">추가하기</button>
            <br><br>
            <button class="button button_style button-2 button-2a" id="showBtn">미리보기</button>
        </div>
    </section>
	<!-- <button id="addBtn" class="">추가하기</button><br><br>
	<button id="showBtn">미리보기</button> -->
<!-- MODAL 시작-->
		<div class="modal fade" id="addModal">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">

					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<b><font size="5">자기소개서 구성요소 추가</font></b>
					</div>

				<div class="modal-body container">
				
					<div class="row">
					
					<div class="col-md-3" id="growup">
					<div class="panel panel-success" align="center">
						<div class="panel-heading" align="center">
							<b><font size="3">성장과정</font></b>
						</div>
						<img src="https://images.sciencedaily.com/2014/02/140226102130_1_540x360.jpg"
						width="260px" height="180px" >
						
					</div>
					</div>
					
					<div class="col-md-3" id="strength">
					<div class="panel panel-success" align="center">
						<div class="panel-heading" align="center">
							<b><font size="3">장점</font></b>
						</div>
						<img src="http://www.tabatatimes.com/wp-content/uploads/2015/09/Perform-Multi-Joint.jpg"
						width="260px" height="180px">
					</div>
					</div>
					
					<div class="col-md-3" id="overcome">
					<div class="panel panel-success" align="center">
						<div class="panel-heading" align="center">
							<b><font size="3">극복과정</font></b>
						</div>
						<img src="http://www.startyourbusinessmag.com/wp-content/uploads/2014/05/OvercomeFear.jpg"
						width="260px" height="180px">
					</div>
					</div>
					
					</div>
					<div class="row">
					
					<div class="col-md-3" id="ready">
					<div class="panel panel-success" align="center">
						<div class="panel-heading" align="center">
							<b><font size="3">준비과정</font></b>
						</div>
						<img src="http://sparkl.com/talking-points/postimages/buildingblocks.jpg"
						width="260px" height="100%">
					</div>
					</div>
					
					<div class="col-md-3" id="goal">
					<div class="panel panel-success" align="center">
						<div class="panel-heading" align="center">
							<b><font size="3">비전 및 목표</font></b>
						</div>
						<img src="http://static.wixstatic.com/media/c3835d_5373700212b04928b1dde707de2f0e9e.jpg"
						width="260px" height="180px">
					</div>
					</div>
					
					</div>
				</div>

			</div>
			</div>
		</div>
		<!-- MODAL 끝 -->


</body>
</html>