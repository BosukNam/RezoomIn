<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/scripts/member_edit/member_edit.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/resources/scripts/member_edit/member_drop.js"></script>		
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
    <div class="row"></div> <!-- 라인 정리 -->
	<!-- container 시작 -->
	 <!--수정 창 컨테이너 - edit_container -->
		<div class="container col-md-8 edit_container">
			<div class="row main">
				<div class="main-login main-center">
					<div align="center">
						<h1 class="glyphicon glyphicon glyphicon-edit" style="display: inline;"> 회원정보수정</h1>
						<!-- 수정 상태 메시지 -->
						<h3 class="row" style="color:red" id="modify_message" hidden="hidden">수정 실패!! 회원 정보를 확인해주세요</h3>
					</div>
					<!--입력 폼 부분 - form_container -->
					<div class="container col-md-8 col-md-offset-2 form_container">
					<form class="form-horizontal" id="editForm" method="POST" action="/RezoomIn/edit.do"> <!--  -->
						<!-- ID  -->
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">I D</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="editID" id="editID" value="yeeee4"<%-- "${info[3]}"  --%>readonly="readonly"/>
								</div>
							</div>
						</div>
						<!-- 비밀번호  -->
						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">비밀번호</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" id="editPwd" name="editPwd" value="0000"<%-- ${info[1]} --%>/>
								</div>
							</div>
						</div>
						<!-- 비밀번호 확인 -->
						<div class="form-group">
							<label for="confirm" class="cols-sm-2 control-label">비밀번호 확인</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<input type="password" class="form-control" id="editPwdCheck" name="editPwdCheck" placeholder="비밀번호를 다시 입력해주세요"/>
								</div>
							</div>
						</div>
						<!-- 패스워드 메시지 -->
						<div class="row" style="color:red" id="pwd_message" hidden="hidden">비밀번호를 확인해주세요</div>
						<!-- 이름  -->
						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">이름</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-users fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" id="editName" name="editName" value="남보석"<%-- "${info[2]}" --%>/>
								</div>
							</div>
						</div>
						<!-- 이메일  -->
						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">이메일</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" id="editEmail" name="editEmail" value="popman90@naver.com"<%-- "${info[0]}" --%>/>
								</div>
							</div>
						</div>
						<!-- 버튼 그룹 -->
						<div class="form-group">
							<button type="button" class="btn btn-primary btn-lg btn-block" id="editBtn">회원 정보 수정</button>
							<button type="button" class="btn btn-default btn-lg btn-block" id="dropBtn"  data-toggle="modal" 
							data-target="#member_drop_modal">회원 탈퇴</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 회원 탈퇴 모달 창 -->
	<jsp:include page="member_edit/member_drop_modal.jsp"></jsp:include>
	<!-- 예전 부분 -->
<%-- 		
	<div class="col-md-8 container">
	 <div class="main" align="center">
		<h1 class="glyphicon glyphicon glyphicon-edit" style="display: inline;">회원정보수정</h1>
		<form class="form-horizontal" id="editForm" method="POST" action="/RezoomIn/edit.do">
		<div class="form-group">
		<label for="editText" class="col-md-2 col-md-offset-3 control-label input_title">ID</label>
		<div class="row col-md-offset-7"></div>
			<div class="col-md-4 col-md-offset-4">
				<input type="text" class="form-control" id="editPhone" name="editPhone" value="yeeee4""${info[3]}" readonly="readonly">
			</div>
		</div>
		<div class="form-group">
			<label for="editPwd" class="col-md-2 col-md-offset-3 control-label input_title">비밀번호</label>
			<div class="row col-md-offset-7"></div>
			<div class="col-md-4 col-md-offset-4">
				<input type="password" class="form-control" id="editPwd" name="editPwd" value="0000"${info[1]}>
			</div>
		</div>
		<div class="form-group">
			<label for="editPwdCheck" class="col-md-2 col-md-offset-3 control-label input_title">비밀번호 확인</label>
			<div class="row col-md-offset-7"></div>
			<div class="col-md-4 col-md-offset-4">
				<input type="password" class="form-control" id="editPwdCheck" name="editPwdCheck" placeholder="비밀번호를 다시 입력해주세요">
			</div>
		</div>
		<div class="form-group">
			<label for="editName" class="col-md-2 col-md-offset-3 control-label input_title">이름</label>
			<div class="row col-md-offset-7"></div>
			<div class="col-md-4 col-md-offset-4">
				<input type="text" class="form-control" id="editName" name="editName" value="남보석""${info[2]}">
			</div>
		</div>
		<div class="form-group">
			<label for="editEmail" class="col-md-2 col-md-offset-3 control-label input_title">이메일</label>
			<div class="row col-md-offset-7"></div>
			<div class="col-md-4 col-md-offset-4">
				<input type="email" class="form-control" id="editEmail" name="editEmail" value="popman90@naver.com""${info[0]}" >
			</div>
		</div>
	</form>
		<div class="col-md-offset-4 col-md-4">
			<button type="button" class="btn btn-primary btn-lg btn-block" id="dropBtn">회원 정보 수정</button>
			<button type="button" class="btn btn-default btn-lg btn-block" id="editBtn">회원 탈퇴</button>
		</div>
	</div>
    </div> --%>
	<!-- container 끝 -->
	<div class="col-md-2 sidebar">
	   	<ul class="nav nav-right-sidebar">
	    </ul>
	</div>
	</div>
	<!-- footer 시작 -->
    <jsp:include page="footer.html"></jsp:include>
    <!-- footer 끝 -->
  </body>
<script>
</script>
</html>