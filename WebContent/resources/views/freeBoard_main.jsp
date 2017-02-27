<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html lang="ko">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>학부게시판</title>
<link href="<%=request.getContextPath() %>/resources/bootstrap-dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<!-- Content 시작 -->
	<div class="container">
		<div class="col-md-7">
		<h1>학부게시판</h1>
		</div>
		<form action="/1221_noticeBoard/main.do" id="formData">
			<div class="col-md-2">
				<div class="col-md-3">
					<select class="form-control" id="freeBoard-select" name="freeBoard-select">
						<option value="title">제목</option>
						<option value="content">본문</option>
						<option value="name">이름</option>
						<option value="date">등록일</option>
					</select>
				</div>
			</div>
			<div class="col-md-2">
				<input type="text" class="form-control" id="keyword" name="keyword" placeholder="검색내용">
			</div>
		</form>
			<div class="col-md-1">
				<div class="btn btn-default" id="searchBtn">찾기</div>
			</div>
		<div class="col-md-12">
		<hr >
		<h4>게시판(${fn:length(list)})</h4>
		</div>
		<div class="col-md-12">				
			<table class="table table-bordered" id="board_table">
				<c:forEach var="board" items="${list}" varStatus="status">
					<c:if test="${status.count%5 eq 1 }">
						<tbody>
					</c:if>
						<tr>
							<td>
								<a href="/1221_noticeBoard/detail.do?key=${board.key}"><h5>${board.title}</h5></a>
								<h6>${board.name} | ${board.today}</h6>
							</td>
						</tr>
						<c:if test="${status.count%5 eq 0 }">
							</tbody>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-md-9">
			<nav>
				<ul class="pagination">
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
		<div class="col-md-3">
		<button type="button" class="btn btn-default" id="newBtn">쓰기</button>	
		</div>
	</div>
	<!-- Content 끝 -->
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/bootstrap-dist/js/bootstrap.min.js"></script>
	<script>
	</script>
	<script type="text/javascript">
		$(function(){
			board_set(1);
		
			$('.pagination_board a').click(function(){
				var num=$(this).html();
				board_set(num);
			})
			$('#pagination_prev').click(function(){
				var num=$('.pagination_board.active a').html();
				if(num!=1)
					board_set(num-1);

			})
			$('#pagination_next').click(function(){
				var num=$('.pagination_board.active a').html();
				if(num!=$('.pagination_board').length)
					board_set(Number(num)+1);
			})
		})
		function board_set(page_num){
			$('#board_table tbody').hide();
			$('.pagination_board').removeClass('active');
			$('#pagination_prev').removeClass('disabled');
			$('#pagination_next').removeClass('disabled');
			
			if(page_num==1){
				$('#pagination_prev').addClass('disabled');
			}
			else if(page_num==$('.pagination_board').length){
				$('#pagination_next').addClass('disabled');
			}
			
			$('#board_table tbody').eq(page_num-1).show();
			$('.pagination_board').eq(page_num-1).addClass('active');
		}
	</script>
	<script>
		$(function() {
			$('#newBtn').click(function() {
				//링크지만 서버를 다녀오는 것이다.(주의!)
				location.replace("/1221_noticeBoard/resources/views/new.html");
			})
		})
	</script>
	<script>
		$(function() {
			$('#searchBtn').click(function() { 
				if($('#keyword').val()!='')
					$('#formData').submit();
			})
		})
	</script>
</body>
</html>