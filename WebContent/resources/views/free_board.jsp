<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
	<title>자유게시판</title>
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
	      	<li>
	      	</li>
	      </ul>
	    </div>
	<!-- container 시작 -->
	<div class="col-md-8 container">
		<div class="row">
			<div class="col-md-6">
				<h1 class="text-muted" style="margin-top: 0px">자유게시판</h1>
			</div>
			<form action="/1221_noticeBoard/main.do" id="formData">
					<div class="col-md-2">
			      		<select class="form-control" id="freeBoard-select" name="freeBoard-select">
							<option value="title">제목</option>
							<option value="content">본문</option>
							<option value="name">이름</option>
							<option value="date">등록일</option>
						</select>
					</div>
					<div class="col-md-3">
						<input type="text" class="form-control" id="keyword" name="keyword" placeholder="검색내용">
					</div>
			</form>
			<div class="col-md-1">
				<div class="btn btn-default" id="searchBtn">찾기</div>
			</div>
		</div>
		
		
		<div class="col-md-12">
		<h4>게시글(${fn:length(list)})</h4>
		</div>
		
		
		<div class="col-md-12">				
			<table class="table table-bordered" id="board_table">
				<c:forEach var="board" items="${list}" varStatus="status">
					<c:if test="${status.count%5 eq 1 }">
						<tbody>
					</c:if>
						<tr>
							<td>
								<a href="/TestFinalProject/freeBoard_detail.do?key=${board[0]}"><h5>${board[5]}</h5></a>
								<h6>${board[1]} | ${board[3]}</h6>
							</td>
						</tr>
						<c:if test="${status.count%5 eq 0 }">
							</tbody>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class="row">
			<div class="col-md-9">
				<nav>
					<ul class="pagination" style="margin-top: 0px">
						<li id="pagination_prev">
							<span aria-hidden="true">&laquo;</span>
						</li>
						<c:forEach items="${requestScope.list }" step="5" varStatus="status">
						<li class="pagination_board"><a href="#">${status.count}</a></li>
						</c:forEach>
						<li id="pagination_next">
							<span aria-hidden="true">&raquo;</span>
						</li>
					</ul>
				</nav>
			</div>
			<div class="col-md-3" align="right">
				<button type="button" class="btn btn-default" id="newBtn">쓰기</button>	
			</div>	
		</div>
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
    <script>
		$(function() {
			$('#searchBtn').click(function() { 
				if($('#keyword').val()!='')
					$('#formData').submit();
			})
		})
	</script>
</html>