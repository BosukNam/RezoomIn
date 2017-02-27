<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원검색</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="/TestFinalProject/resources/css/myBoot.css">
<link href="/TestFinalProject/resources/css/footer.css" rel="stylesheet" type="text/css">
<!-- <link href="/TestFinalProject/resources/css/godofont.css" rel="stylesheet" type="text/css"> -->
 <link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/godofont.css">


</head>
<body>
<jsp:include page="company_header.jsp"/><br>
<div class="container" style="margin-top:50px">
	<h1 style="text-align:center"> 인재를 찾아보세요 </h1><br>
	
	<div class="row">
		<div class="col-md-2 col-md-offset-3">
			<select class="form-control" id="search_select">
				<option>기술분야</option>
		  		<option>Language</option>
		  		<option>OS</option>
		  		<option>Database</option>
			</select>
		</div>
		<div class="col-md-3">
			<input type="text" class="form-control" id="search_input" placeholder="검색어를 입력하세요">
		</div>
		<div class="col-md-2">
			<button class="btn btn-default glyphicon glyphicon-search" id="search_btn">검색</button>
		</div>
	</div>
	<br>
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<table id="board" class="table table-hover">
				<thead>
					<tr class="info">
						<th>No</th>
						<th>이름</th>
						<th>이메일</th>
						<th hidden>아이디</th>
						<th>숙련도</th>
					</tr>
				</thead>
				<c:forEach var="item" items="${requestScope.data}" varStatus="status">
			    	<c:if test="${status.count % 10 eq 1}">
			    		<tbody>
			    	</c:if>
			    	<tr>
			    		<td>${status.count}</td>
			    		<td>${item.name}</td>
			    		<td>${item.email}</td>
			    		<td>${item.id}</td>
			    		<td>${item.rank}</td>
			    	</tr>
			    	<c:if test="${status.count % 10 eq 0}">
			    		</tbody>
			    	</c:if>
	    		</c:forEach>
			</table>
		</div>
	</div>
	<br>
	<!-- 페이지네이션 시작 
	<div class="col-md-offset-5" >
		<nav id="page_nav">
		  <ul class="pagination" id="page_ul">
		    <li>
		      <a id="prev" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <c:forEach var="item" items="${requestScope.data}" varStatus="status" step="10">
		    	<li class="page_item"><a href="#">${status.count}</a></li>
		    </c:forEach>
		    <li>
		      <a id="next" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
	</div>
	 페이지네이션 끝 -->
</div>
<jsp:include page="search_show.jsp"/>
<jsp:include page="footer.html"/>
</body>
<script>
/*
 * table 내용  
 */
function setPage(pageNum){
	$('#prev').removeClass('disabled');
	$('#next').removeClass('disabled');
	$('#board tbody').hide();
	$('.page_item').removeClass('active');
	
	if(pageNum == 1)
		$('#prev').addClass('disabled');
	
	else if(pageNum == $('#board tbody').length)
		$('#next').addClass('disabled');
	
	/* eq는 0부터 시작 */
	$('#board tbody').eq(pageNum-1).show();
	$('.page_item').eq(pageNum-1).addClass('active');
	
}

function pagination(){
	$('.page_item a').on('click', function(){
		var cur = $(this).html();
		setPage(cur);
	})
	
	$('#prev').on('click', function(){
		var cur = $('.page_item.active a').html();
		setPage(cur - 1);
	})
	$('#next').on('click', function(){
		var cur = $('.page_item.active a').html();
		setPage(Number(cur) + 1);
	})
}

$(function(){
	setPage(1);
	pagination();
	//click();
})

/*
 * selectBox 선택 값에 따른 검색창 비활성화
 */
function select(){
	if($('#search_select option:selected').val() == '기술분야')
		{
			$('#search_input').val('기술분야를 선택해주세요');
			$('#search_input').attr('disabled', true);
		}
	else
		{
			$('#search_input').val('');
			$('#search_input').attr('disabled', false);
		}
}
 
$(function(){
	select();
	$("#search_select").change(function() {
		select();
	});
	
});

/* $(function(){
	$('#search_btn').on('click', function(){
		$('#searchDetail_modal').modal(show);
	});
}); */
/*
 * 검색 비동기 처리 
 */
 $(function(){
	$('#search_btn').click(function(){
		var search_input = $('#search_input').val();
		var search_select = $('#search_select').val();

		if(search_select != '기술분야' && search_input == '' )
			alert('검색어를 입력하세요');
		
		else
		{
		$.ajax({
			url: '${pageContext.request.contextPath}/searchMember.do',
			type:'GET',
			data:{
				"search_select" : search_select,
				"search_input" : search_input
			},
			success:function(response){
				console.log(response);
				var data=JSON.parse(response);
				console.log(data);

				$('#board tbody').remove();
				$('.page_item').remove();
			
				for(var i=0; i < data.length/10; i++){
					$('#next').before('<li class="page_item"><a href="#">' + (i+1) + '</a></li>');
				}

				$.each( data, function( key, value ) {
					if(key % 10 == 0)
						$('#board').append('<tbody>');

					$('#board > tbody:last-child').append('<tr><td>' + (key+1) + '</td><td>' + data[key].name  
							+ '</td><td>' + data[key].email + '<td style="display:none">'
							+ data[key].id + '</td><td>' +data[key].rank + '</td></tr>');
				
					if(key % 10 == 9)
						$('#board').append('</tbody>');
					});
				
				setPage(1);
				pagination();
				click()
			},
			error:function(){
				alert('검색결과가 없습니다');
			}
		});
		}
	});

});

function click(){
	$('#board tbody tr').click(function(){
		var num=$(this).find('td:eq(3)').html();
		$('#searchDetail_modal').modal('show');
	});
}
</script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/godofont.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/myBoot.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/footer.css">
</html>
