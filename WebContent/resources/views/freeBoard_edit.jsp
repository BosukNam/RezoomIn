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
			<h1>게시글 수정</h1>
		</div>
		<div class="col-md-12">
		<form action="/RezoomIn/update.do" id="formData" method="post">
			<hr>
			<input type="hidden" name="flag" value="edit">
			<input type="hidden" name="key" value="${info[0]}">
			<div class="form-group">
				<label for="inputName">작성자명</label> 
				<input type="text" class="form-control" id="inputName" name="inputName" value="${info[1]}">
			</div>
			<div class="form-group">
				<label for="inputName">비밀번호</label> 
				<input type="password" class="form-control" id="inputPwd" name="inputPwd" value="${info[2]}">
			</div>
			<div class="form-group"> 
				<label for="inputName">제목</label> 
				<input type="text" class="form-control" id="inputTitle" name="inputTitle" value="${info[4]}">
			</div>
			<div class="form-group">
				<label for="inputName">내용</label> 
				<textarea class="form-control" rows="3" id="inputContent" name="inputContent">${info[5]}</textarea>
			</div>
		</form>
		</div>
		<div class="col-md-2 col-md-offset-10">
			<div class="btn btn-primary" id="updateBtn">완료</div>
			<div class="btn btn-primary" id="cancleBtn">취소</div>	
		
		</div>
	</div>
	<!-- Content 끝 -->



	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<div class="col-md-2 sidebar">
	   	<ul class="nav nav-right-sidebar">
	    </ul>
	</div>
	</div>
	<!-- footer 시작 -->
    <jsp:include page="footer.html"></jsp:include>
    <!-- footer 끝 -->
  </body>
</html>