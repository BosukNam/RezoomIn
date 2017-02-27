<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>사이트에 오신걸 환영합니다.</title>
    <!-- 부트스트랩 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet"   href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker3.min.css">
    <link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/godofont.css">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/morris.js/0.5.1/morris.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/scripts/project_intro.js"></script>
    <script src="${pageContext.request.contextPath }/resources/scripts/project_role.js"></script>
    <script src="${pageContext.request.contextPath }/resources/scripts/project_content.js"></script>
    <script src="${pageContext.request.contextPath }/resources/scripts/project_chart.js"></script>
    <link href="${pageContext.request.contextPath }/resources/css/header.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/css/custom.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/css/footer.css" rel="stylesheet" type="text/css">
  
   
   
  </head>
<body>
   <jsp:include page="header.jsp"/>
   <br>
   <input type="hidden" value="${requestScope.register_no }" id="project_no">
   <jsp:include page="side.html"/>
   <div class="container">
      <div class="row">
      
         <div class="col-sm-9 col-md-10 main">
                <h3 class="col-md-12 page-header">Project</h3>
                <div class="col-md-12 placeholders">
               <div class="col-md-4">
                  <div class="thumbnail">
                     <div>
                        <button type="button" class="close" data-dismiss="modal"
                           aria-label="Close">
                           <span aria-hidden="true">&times;</span>
                        </button>
                     </div>
                     <br>
                     <div class="thumb-content">
                     	<img src='/TestFinalProject/resources/images/checklist.png' width="250px" height="250px" alt=''>
                     	<div class="caption">개 요</div>
                     </div>
                  </div>
               </div>
               <div class="col-md-4">
                  <div class="thumbnail">
                     <div>
                        <button type="button" class="close" data-dismiss="modal"
                           aria-label="Close">
                           <span aria-hidden="true">&times;</span>
                        </button>
                     </div>
                     <br>
                     <div class="thumb-content">
                     <img src='/TestFinalProject/resources/images/teamwork.png' height="250px" width="250px" alt=''>
                     <div class="caption">주요 역할 및 담당</div>
                     </div>
                     </div>
                  </div>
               <div class="col-md-4">
                  <div class="thumbnail">
                     <div>
                        <button type="button" class="close" data-dismiss="modal"
                           aria-label="Close">
                           <span aria-hidden="true">&times;</span>
                        </button>
                     </div>
                     <br>
                     <div class="thumb-content">
                     <img src='/TestFinalProject/resources/images/projectcontent.png' alt=''>
                     <div class="caption">프로젝트 내용</div>
                     </div>
                  </div>
               </div>
               </div>
          </div> 
      </div>
   </div>
   <jsp:include page="project_intro.jsp"></jsp:include>
   <jsp:include page="project_role.jsp"></jsp:include>
   <jsp:include page="project_content.jsp"></jsp:include>
   <jsp:include page="chart_inputform.jsp"></jsp:include>
   <jsp:include page="system_architecture.jsp"></jsp:include>
   <jsp:include page="software_architecture.jsp"></jsp:include>
   <jsp:include page="usecase.jsp"></jsp:include>
<script>
   $(function(){
	   //테스트용
	  //프로젝트 클릭할 때 프로젝트 정보가져오는 부분필요(프로젝트 번호, 이름,등등)
	  $('#project').attr("value","1")
	  //날짜정보와 인원수 정보에 프로젝트 번호 설정)
	  $('#set-project-date').attr("value","1");
	  $('#set-project-people-no').attr("value","1")
	  
	  
	  
	  
      $('#client-tier').hide();
      $('#2-tier').hide();
      $('#multi-tier').hide();
      
      $('#config-select').change(function(){
         if($('#config-select option:selected').val()=="ti3"){
            $('#client-tier').show();
            $('#multi-tier').show();
            $('#2-tier').show();
            $('#system-config').val('');
            $('#middle-config').val('');
            $('#client-config').val('');
         }
         else if($('#config-select option:selected').val()=="ti1"){
            $('#client-tier').show();
            $('#multi-tier').hide();
            $('#2-tier').hide();
            $('#client-config').val('');
            $('#system-config').val('');
            $('#middle-config').val('');
         }
         else if($('#config-select option:selected').val()=="ti2"){
            $('#client-tier').show();
            $('#multi-tier').hide();
            $('#2-tier').show();
            $('#system-config').val('');
            $('#middle-config').val('');
            $('#client-config').val('');
         }
         else{
            $('#client-tier').hide();
            $('#multi-tier').hide();
            $('#2-tier').hide();
            $('#client-config').val('');
            $('#system-config').val('');
            $('#middle-config').val('');
         }
      })
      
      $('.thumb-content').click(function(){
         var contentName = $(this).find('.caption').html();
      if(contentName.trim()==("개 요")){
         $('#intro').modal('show');
      } else if(contentName.trim()==("프로젝트 내용")){
      	 $('#project-content').modal('show');
      }
      else{
    	  	var projectNo=$('#project')
    	  	var registerNo=$('#set-project-role-and-task')
        	$.ajax({
        	   	type:"POST",
        	   	url:"/TestFinalProject/selectRoleAndTask.do",
        	   	data:{
        	   		projectNo:projectNo.attr("value")
        	   	},
        	   	success:function(res){
        	   		var data=res.trim();
        	   		//alert(data);
        	   		if(data!="ERROR"){
	        	   		var result=JSON.parse(data);
	        	   		var role=result.role;
	        	   		var task=result.task;
	        	   		var num=result.registerNo;
	        	   		
	        	   		$('#project-role-text').val(role);
	        	   		$('#project-task-text').val(task);
        	   		}
        	   	},
        	   	error:function(){
        	   		alert("오류");
        	   	}
        	}) 
            $('#major-role').modal('show');       
      }
      $('#input-date-group input').datepicker({
          format: "yyyy년 mm월 dd일",
          autoclose : true
      });
      $('#chart-btn').click(function(){
         $('#chart-modal').modal('show');
      })
      
      
      
      $('#software-architecture-btn').click(function(){
         $('#software-architecture-form').modal('show');
      })
      $('#system-architecture-btn').click(function(){
         $('#system-architecture-form').modal('show');
      })
      
      $('#project-tools-select').change(function(){
         $('#project-tools-name').val($('#project-tools-select option:selected').val());
         $('#etc-projectDeveloper').prop("checked",false);
         $('#project-tools-name').prop('disabled', true);
         
      })
      
      $('#project-tools-select').change(function(){
         $('#project-tools-name').val($('#project-tools-select option:selected').val());
         $('#etc-projectDeveloper').prop("checked",false);
         $('#project-tools-name').prop('disabled', true);
         
      })
      $('#etc-projectDeveloper').click(function(){
         $('#project-tools-select').val("0");
         $('#project-tools-name').prop('disabled', false);
         $('#project-tools-name').val('');
      });
      
      $('#language-btn').click(function(){
         var language = $('#myLanguage-skill').val()
      });
     
    })

    
    
    /* 유즈케이스 선택  */
    $('#case1_div').hide();
    $('#case2_div').hide();
    $('#case3_div').hide();
    $('#case4_div').hide();
    
    
    
    $('#usecase-select').change(function(){
    	if($('#usecase-select option:selected').val()=="0"){
    		$('#case2_div').hide();
    	    $('#case3_div').hide();
    	    $('#case4_div').hide();
    	    $('#case1_div').hide();
    	    $('#case2').val('');
    	    $('#case3').val('');
    	    $('#case4').val('');
    	    $('#case1').val('');
    	    
         }
    	else if($('#usecase-select option:selected').val()=="case1"){
        
    		$('#case1_div').show();
    	    $('#case2_div').hide();
    	    $('#case3_div').hide();
    	    $('#case4_div').hide();
    	    $('#case1').val('');
    	    $('#case2').val('');
    	    $('#case3').val('');
    	    $('#case4').val('');
         }
         else if($('#usecase-select option:selected').val()=="case2"){
        	$('#case1_div').show();
     	    $('#case2_div').show();
     	    $('#case3_div').hide();
     	    $('#case4_div').hide();
     	    $('#case1').val('');
     	    $('#case2').val('');
     	    $('#case3').val('');
     	    $('#case4').val('');
         }
         else if($('#usecase-select option:selected').val()=="case3"){
        	$('#case1_div').show();
     	    $('#case2_div').show();
     	    $('#case3_div').show();
     	    $('#case4_div').hide();
     	    $('#case1').val('');
     	    $('#case2').val('');
     	    $('#case3').val('');
     	    $('#case4').val('');
          }
         else{
        	$('#case1_div').show();
     	    $('#case2_div').show();
     	    $('#case3_div').show();
     	    $('#case4_div').show();
     	    $('#case1').val('');
     	    $('#case2').val('');
     	    $('#case3').val('');
     	    $('#case4').val('');
         }
      })
 })
 </script>
 <jsp:include page="footer.html"></jsp:include>
 </body>
 </html>
              
