<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
	<title>noname_project</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/dataTables.bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>	
	<link href="../css/header.css" rel="stylesheet">
	<link href="../css/footer.css" rel="stylesheet">
  </head>
  <body>
	<!-- header 시작 -->
  	<jsp:include page="header.jsp"></jsp:include>
	<!-- header 끝 -->
	<div class="col-md-12">
    <div class="col-md-2 sidebar">
      <ul class="nav nav-sidebar">
      </ul>
    </div>
	<!-- Content 시작 -->
	<div class="container">
		<div class="col-md-6">
			<h1>학부게시판</h1>
		</div>
		<div class="col-md-12">
		<hr>
			<h3>${requestScope.info[4]}</h3>
		<hr>
		</div>
		<div class="col-md-12">
			<h6>${requestScope.info[1]} | ${requestScope.info[3]}</h6>
		</div>
		<div class="show">
			<div class="col-md-12">
				<h5>${info[5]}</h5>
			</div>
			<div class="col-md-4 col-md-offset-8">
				<button type="button" class="btn btn-default" id="editBtn">수정</button>
				<button type="button" class="btn btn-default" id="deleteBtn">삭제</button>
				<button type="button" class="btn btn-primary" id="mainBtn">목록으로</button>
			</div>
		</div>
	</div>
	<!-- Content 끝 -->
	
	<!-- Modal 시작-->
	<div class="modal fade" id="checkModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<!-- 아이콘 이미지 -->
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title"><span id="btn_flag"></span> 비밀번호 확인</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="checkForm">
						<div class="form-group">
							<label for="inputPwd_check" class="col-sm-3 control-label">작성자 비밀번호</label>
							<div class="col-sm-9">
								<input type="password" class="form-control" id="inputPwd_check" name="inputPwd_check"
									placeholder="Password">
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" id="checkBtn">확인</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>

	<!-- /.modal -->
	<!-- Modal 끝 -->

	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<!-- footer 시작 -->
    <jsp:include page="footer.html"></jsp:include>
    <!-- footer 끝 -->
  </body>
</body>
</html>