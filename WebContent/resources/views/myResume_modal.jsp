<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<div class="modal fade" id="myResume-modal">
  <div class="modal-dialog modal-lg" id="dialog-style">
    <div class="modal-content">
      <div class="modal-header" id="modal-header">
        <div class="row">
        <div class="col-md-10">
	        <ul class="nav nav-pills">
			  <li role="presentation" id="modal-resume"><a href="#">이력서</a></li>
			  <li role="presentation" id="modal-introduce"><a href="#">자기소개서</a></li>
			  <li role="presentation" id="modal-portfolio"><a href="#">포트폴리오</a></li>
			</ul>
		</div>
		<div class="col-md-2">
        	<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      	</div>
      	</div>
      </div>
      <div class="modal-body">
        <div id="flipbook">
			  <div class="hard"><img alt="" src="${pageContext.request.contextPath }/resources/images/myresumeindex.JPG" width="500px" height="800px"> </div> 
			  <div class="hard"><img alt="" src="${pageContext.request.contextPath }/resources/images/myresumeback.JPG" width="500px" height="800px"></div>
			  
				  <div style="max-height: 800px"><jsp:include page="showResume2.jsp"></jsp:include></div>
				
				  <div><jsp:include page="showIntroduce.jsp"></jsp:include></div>


					<div>
						<!-- 개발 가능 언어 4개, 5개인 경우 프로필 시작 -->
						<div class="row">
							<div class="col-md-3 col-md-offset-1">
								<img src="https://dummyimage.com/200x180/d0f5e9/000000.png">
								<h4 align="center">남보석(28)</h4>
								<p align="center">1990.0.0
								<p>
							</div>

							<div class="col-md-5 col-md-offset-1">
								<br>
								<div class="col-md-offset-1"
									style="width: 300px; height: 200px;">
									<canvas id="horizontal-barChart" width="300" height="200"></canvas>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-4 col-md-offset-1">
								<h2>수상경력</h2>
								<br>
								<p>● 수상경력_1(이름, 날짜)
								<p>
								<p>● 수상경력_2(이름, 날짜)
								<p>
								<p>● 수상경력_3(이름, 날짜)
								<p>
								<p>● 수상경력_4(이름, 날짜)
								<p>
							</div>
							<div class="col-md-4 col-md-offset-1">
								<h2>개발 가능 툴</h2>
								<br>
								<p>● Eclipse
								<p>
								<p>● Visual Studio
								<p>
							</div>
						</div>
						<!-- 개발 가능 언어 4개, 5개인 경우 프로필 끝 -->
					</div>

					<div>
						<!-- 프로젝트 -->
						<h1 style="margin-top: 200px" align="center">프로젝트 제목</h1>
						<hr>
						<!-- 프로젝트 끝 -->
					</div>
				  
				  <div>
				  <!-- 목차 시작 -->
							 <div class="col-md-offset-1">
								<h1>프로젝트명 개요</h1><br>
								<h4>● 프로젝트명 소개</h4>
								<h4>● 개발 기간</h4>
								<h4>● 개발 인원</h4>
								<h4>● 개발 툴</h4>
								
								<br><br><br>
								<h1>주요 역할 및 담당</h1><br>
								<h4>● 주요 역할 및 담당</h4>
							</div>
				  </div>
				  
				  <div>
							 <!-- <div class="col-md-offset-1 col-md-5">
								<img src="https://dummyimage.com/300x470/d0f5e9/000000.png">
							</div> -->
							 <div class="col-md-offset-1">
								<h1>프로젝트명 내용</h1><br>
								<h4>● 사용 기술 언어</h4>
								<h4>● framework</h4>
								<h4>● diagram</h4>
								<h4>● 내용1</h4>
								<h4>● 내용2</h4>
								<h4>● 내용3</h4>
							</div>
					<!-- 목차 끝 -->
				  </div>
				  
				  <div>
				  <!-- 개요 시작 -->
							<div class="col-md-offset-2">
									<h1 style="margin-top: 200px;">프로젝트명 개요</h1>
							</div>
							<hr>
							<div class="col-md-offset-8">
									<h4>프로젝트명 소개</h4>
									<h4>개발 기간</h4>
									<h4>개발 인원</h4>
									<h4>개발 툴</h4>
									<h4>주요 역할 및 담당 업무</h4>
							</div>
				  </div>
				  
				  <div>
						  	<div class="col-md-offset-1">
								<h2> 개요 <small> 프로젝트 명 소개</small></h2> <hr>
							</div>
							
							<div class="row">
							  	<div class="col-md-offset-1" style="width:300px; height:300px;" >
							  	<canvas id="barChart" width="300" height="300"></canvas>
								</div>
							</div>
				  </div>
				  
				  <div>
						  <div class="col-md-offset-1">
								<h2> 개요 <small> 개발기간 및 개발인원</small> </h2> <hr>
							</div>
				  </div>
				  
				  <div>
						  <div class="col-md-offset-1">
								<h2> 개요 <small> 개발 툴</small> </h2> <hr>
							</div>
				  </div>
				  
				  <div>
						  <div class="col-md-offset-1">
								<h2> 개요 <small> 주요 역할 및 담당 업무</small> </h2> <hr>
							</div>
				  </div>
				  
				  <div>
				  <!-- 프로젝트 내용 시작 -->
							<div class="col-md-offset-2">
									<h1 style="margin-top: 200px;">프로젝트 명 내용</h1>
							</div>
							<hr>
							<div class="col-md-offset-8">
									<h4>사용기술 언어</h4>
									<h4>framework</h4>
									<h4>내용1</h4>
									<h4>내용2</h4>
							</div>
				  </div>
				  
				  <div>
						  <div class="col-md-offset-1">
								<h2> 프로젝트 명 내용 <small> 사용기술 언어</small> </h2> <hr>
							</div>
				  </div>
				  
				  <div>
						  <div class="col-md-offset-1">
								<h2> 프로젝트 명 내용 <small> framework</small> </h2> <hr>
							</div>
					<!-- 프로젝트 내용 끝 -->
				  </div>
				  
				  <div>
				  <!-- 프로그램 설계 구조 시작 -->
							<div class="col-md-offset-2">
									<h1 style="margin-top: 200px;">프로젝트 명 내용</h1>
							</div>
							<hr>
							<div class="col-md-offset-8">
									<h4>System Architecture</h4>
									<h4>Software Architecture</h4>
							</div>
				  </div>
				  
				  <div>
						  <div class="col-md-offset-1">
								<h2> 프로그램 설계 구조 <small> System Architecture 네트워크 기반</small> </h2> <hr>
							</div>
						  <div class="col-md-offset-1">
						  <img src="http://www.webonspot.com/images/slideicon/Create%20a%20Modern%20Website.png" 
						  style="width:250px; height:200px;">
						  <img src="https://openclipart.org/image/2400px/svg_to_png/163741/web-server.png"
						  style="width:180px; height:200px;">
							</div>
				  </div>
				  
				  <div>
						  <div class="col-md-offset-1">
								<h2> 프로그램 설계 구조 <small> System Architecture 비 네트워크 기반</small> </h2> <hr>
							</div>
				  </div>
				  
				  <div>
						  <div class="col-md-offset-1">
								<h2> 프로그램 설계 구조 <small> Software Architecture</small> </h2> <hr>
							</div>
					<!-- 프로그램 설계 구조 끝 -->
				  </div>
				  
				  
			  <div class="hard"><img alt="" src="${pageContext.request.contextPath }/resources/images/myresumeback.JPG" width="500px" height="800px"></div>
			  <div class="hard"><img alt="" src="${pageContext.request.contextPath }/resources/images/myresumeback.JPG" width="500px" height="800px"></div>
		</div>
      </div>

    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->