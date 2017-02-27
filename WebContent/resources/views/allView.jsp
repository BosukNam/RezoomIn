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
	<!-- container 시작 -->
	<div class="col-md-8 container">
         <h1>이력서</h1>
         <h1>자기소개서</h1>
         <h1>포트폴리오</h1>
    </div>
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
</html>