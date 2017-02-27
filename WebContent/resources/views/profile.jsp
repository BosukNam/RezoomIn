<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
    <title>사이트에 오신걸 환영합니다.</title>
 	<!-- 부트스트랩 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker3.min.css">
    <link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/godofont.css">
    <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
    <!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script> 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>
 <%--    <link href="${pageContext.request.contextPath }/resources/css/header.css" rel="stylesheet" type="text/css"> --%>
    <link href="${pageContext.request.contextPath }/resources/css/custom.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/resources/css/footer.css" rel="stylesheet" type="text/css">
    
  </head>
<body>
	<c:set var="path" value="${pageContext.request.contextPath }" />
	<jsp:include page="header.jsp"/>
	<div class="col-md-12">
	<jsp:include page="side.html"/>
	<div class="col-md-8 container" align="center">
			<div class="main" align="center">
		          <h3 class="col-md-12 page-header">Profile</h3>
		          <div class="col-md-12 placeholders">
		          <div class="panel panel-default">
  				  	<div class="panel-heading">
  				  		<h3 class="panel-title">보유 기술 언어 <span class="glyphicon glyphicon-plus-sign" aria-hidden="true" id="language-plus"></span></h3>
  					</div>
  						<div class="panel-body">
    						<div id="language">
    							<c:forEach var ="language" items="${requestScope.ProgrammingSKill}">
    									<c:if test="${language.field=='1'}">
    									<div class='col-xs-3 col-md-2'>
    									<div class='thumbnail'> 
    									<button type='button' class='close close-language' aria-label='Close'>
    									<span aria-hidden='true'>&times;</span></button><br>
    									<div class='lang-thumb'><img src= '${path}${language.skill_name_image } 'alt='' width="100px" height="100px">
    									<div class='caption' id="${language.name}">${language.name}</div>
    									<input type="hidden" value=${language.register_no } class="hidden_language">
    									</div></div></div>
    								</c:if>
    							</c:forEach>
							</div>
  						</div>
					</div>
				</div>
				<div class="col-md-12 placeholders">
				<div class="panel panel-default">
  				  	<div class="panel-heading">
    					<h3 class="panel-title">개발 가능 툴<span class="glyphicon glyphicon-plus-sign" aria-hidden="true" id="develop-plus"></span></h3>
  					</div>
  						<div class="panel-body">
    						<div id="develop-tool">
    							<c:forEach var ="tool" items="${requestScope.ProgrammingSKill}">
    								<c:if test="${tool.field =='0'}">
    									<div class='col-xs-3 col-md-2'>
    									<div class='thumbnail'>
    									<button type='button' class='close close-tool' aria-label='Close'>
    									<span aria-hidden='true'>&times;</span></button><br>
    									<div class='dev-thumb'><img src='${path}${tool.skill_name_image } ' alt='' width="100px" height="100px">
    									<div class='caption' id="${tool.name}">${tool.name}</div>
    									<input type="hidden" value=${tool.register_no } class="hidden_tool">
    									</div></div></div>
    								</c:if>
    							</c:forEach>
							</div>
						</div>
					</div>
	  			</div>
				<div class="col-md-12 placeholders">
					<div class="panel panel-default">
  					  	<div class="panel-heading">
    						<h3 class="panel-title">수상 경력</h3>
  						</div>
  						<div class="panel-body">
							<c:forEach var ="award" items="${requestScope.awards}">
   								<c:if test="${award.category =='IT 수상'}">
   									<div class='col-md-3'>
    									<div class='panel panel-default'>
    										<button type='button' class='close close-panel' aria-label='Close'>
    										<span aria-hidden='true'>&times;</span></button>
    									<div class="awards-panel">
											<div class="panel-heading">
												<h3 class="panel-title" style="text-align: center">${award.field }</h3>
											</div>
											<div class="panel-body">
												수상 날짜 : <span class="award-profile-date">${award.date}</span>	<br> 
												수상자 : <span class="award-profile-target"> ${award.target }</span><br>
												주최기관 : <span class="award-profile-publication"> ${award.publication }</span><br> 
												수상명 : <span class="award-profile-name">${award.name }</span><br>
												수상내역 : <span class="award-profile-content">${award.content}</span>
												<input type="hidden" class="profile-career-key" value="${award.registerNo}">
											</div>
										</div>
   									</div>
    								</div>
    							</c:if>
    						</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
		<jsp:include page="language_skill.jsp"></jsp:include>
		<jsp:include page="developer_tool.jsp"></jsp:include>
		<jsp:include page="award.jsp"></jsp:include>
		<jsp:include page="footer.html"></jsp:include>
<script>
	$(function(){

		
        //플러스 버튼 클릭시 언어 생성
		$('#language-plus').click(function(){
			var count = $('#language').children().length;
			if(count>11){
				alert("더이상 생성할 수 없습니다.");
				return false;
			}
			$('#hidden-language-modal').prop("class","insert");
			$('#language-modal').modal('show');
				
			
		})
		
 		//저장 버튼 클릭시 처리 방식
		$('#language-skill-save').click(function(){
			var language = $('#myLanguage-skill').val();
			
			var type;
			if($("#language-select option:selected").val()!="0"){
				 type = "Language";
			 }
	     	else if($("#database-select option:selected").val()!="0"){
				 type = "Database";
			}
			else if($("#os-select option:selected").val()!="0"){
				 type = "OS";
			}
			else{
				 type = "Etc";
			}
			var state = $('#hidden-language-modal').attr('class');
			var proficienty = $('.proficiency-language:checked').val();
			var registerNo = $('#hidden-language-registerNo').val();
			var url;
			if(state=="modify"){
				url = '/TestFinalProject/modifyProgrammingSkill.do'
			}else{
				url = '/TestFinalProject/addProgrammingSkill.do'
			}
			
				$.ajax({
					url: url,
					type:'post',
					data:{
						"name" : language,
						"type" : type,
						"field" : "1",
						"rank" : proficienty,
						"register_no" : registerNo 
					},
					success:function(res){
					$('#language-modal').modal('hide');
					if(state=="modify"){
						var data = JSON.parse(res);
						var target = $('#hidden-language-modal').attr('value');
						$('#'+target).html(language);
						$('.caption[id='+target+']').attr('id', language);
						$('#'+language).prev().prop("src","${path}"+data.skill_name_image);
						alert("수정이 완료 되었습니다.")
					}else{
						 
						makeLanguage(res, language);
						$('#myLanguage-skill').val('');
						$('.proficiency-language').prop("checked", false);
						$('#language-select').val("0");
						$('#database-select').val("0");
						$('#os-select ').val("0");
						$('#etc-selectLanguage').prop("checked",false);
						$('#myLanguage-skill').prop('disabled', true);
						alert("등록이 완료 되었습니다.")
					}
					$('#hidden-language-registerNo').val("-1");
					$('.close-language:last').click(function(){
						var register_no = $(this).parent('.thumbnail').find('.hidden_language').val();
						var target = this;
						$.ajax({
							url:'/TestFinalProject/deleteProgrammingSkill.do',
							type:'post',
							data:{
								"register_no" : register_no
							},success:function(){
								alert("삭제 되었습니다.")
								$(target).parentsUntil('#language').detach();
								
							},error:function(){
								alert("삭제에 실패하였습니다.");
							}
						})
					})
					//thumb.html(language);
					},
					error:function(){		
					}
							
				})		
		})
		$('.lang-thumb').click(function() {
				 modifyLanguage(this);	
				 $('#language-modal').modal('show');
				
		})
		
		$('.close-language').click(function(){
			var register_no = $(this).parent('.thumbnail').find('.hidden_language').val();
			console.log(register_no);
			var target = this;
			$.ajax({
				url:'/TestFinalProject/deleteProgrammingSkill.do',
				type:'post',
				data:{
					"register_no" : register_no
				},success:function(){
					alert("삭제 되었습니다.")
					$(target).parentsUntil('#language').detach();
					
				},error:function(){
					alert("삭제에 실패하였습니다.");
				}
			})
		})
		function makeLanguage(res, language){
        	var data = JSON.parse(res);
        	
        	for(var i = 0; i<data.length; i++){
        		if(data[i].skill_name==language)
        		{
        			$('#language').append("<div class='col-xs-3 col-md-2'>"
        					 + "<div class='thumbnail'>"
        					 + "<button type='button' class='close close-language' aria-label='Close'>"
        					 + "<span aria-hidden='true'>&times;</span></button><br>"
        					 + "<div class='lang-thumb'><img src= alt='' width=100px height=100px>"
        					 + "<div class='caption' id="+language+">"+language+"</div>"
        					 + "<input type='hidden' value="+data[i].register_no+" class='hidden_language'>"
        					 + "</div></div></div>")
        					 
        					 $('#'+language).prev().prop("src","${path}"+data[i].skill_name_image);
        		}
        	}
        	
			 $('.lang-thumb:last').click(function() {
				 modifyLanguage(this);
				 $('#language-modal').modal('show');
				
			})
		
		}
		
		function modifyLanguage(lan){
			var name = $(lan).find('.caption').html();
			$('#hidden-language-modal').prop("class","modify");
			$('#hidden-language-modal').prop("value", name)
			
			 $.ajax({
				url:'/TestFinalProject/searchProgrammingSkill.do',
				type:'post',
				data:{
					"name" : name
				},success:function(res){
					var language = JSON.parse(res);
					$('.proficiency-language[value='+language.rank+']').prop("checked","checked"); 
					if(language.type=='database'){
						$('#database-select > option[value='+language.name+']').prop("selected", "true");
					}else if(language.type=='os'){
						$('#los-select > option[value='+language.name+']').prop("selected", "true");
					}else if(language.type=='language'){
						$('#language-select > option[value='+language.name+']').prop("selected", "true");
					}else if(language.type=='etc'){
						$('#etc-selectLanguage').prop("checked", "checked");
					}
					$('#myLanguage-skill').val(language.name);
					$('#hidden-language-registerNo').val(language.register_no);
					
				},error:function(){
					alert("검색에 실패하셨습니다.");
				}
			})
			
		}
		//////////////////////사  용  언   어   기   술   끝//////////////////////////////
		$('#develop-plus').click(function(){
			var count = $('#develop-tool').children().length;
			if(count>4){
				alert("더이상 생성할 수 없습니다.");
				return false;
			}
			$('#hidden-develop-modal').prop("class","insert");
			$('#develop-modal').modal('show');
			
			})
		$('#developer-tool-save').click(function(){
			var tool = $('#myDeveloper-skill').val()
			var type;
		
			if($("#tools-select option:selected").val()!="0"){
				 type = "Tool";
			 }else{
				 type = "Etc";
			}
			var state = $('#hidden-develop-modal').attr('class');
			var proficienty = $('.proficiency-tool:checked').val();
			var registerNo = $('#hidden-tool-registerNo').val();
			var url;
			if(state=="modify"){
				url = '/TestFinalProject/modifyProgrammingSkill.do'
			}else{
				url = '/TestFinalProject/addProgrammingSkill.do'
			}
			console.log(type);
			$.ajax({
					url: url,
					type:'post',
					data:{
						"name" : tool,
						"type" : type,
						"field" : "0",
						"rank" : proficienty,
						"register_no" : registerNo 
				},
				success:function(res){
				$('#develop-modal').modal('hide');
				if(state=="modify"){
					var data = JSON.parse(res);
					var targetTool = $('#hidden-develop-modal').attr('value');
					$('#'+targetTool).html(tool)
					$('.caption[id='+targetTool+']').attr('id', tool);
					$('#'+tool).prev().prop("src","${path}"+data.skill_name_image);
					alert("수정이 완료 되었습니다.")
				}
				else{
					makeTool(res, tool);
					$('#myDeveloper-skill').val('');
					$('.proficiency-tool').prop("checked", false);
					$('#tools-select').val("0");
					$('#etc-selectDeveloper').prop("checked",false);
					$('#myDeveloper-skill').prop('disabled', true);		
					alert("등록이 완료 되었습니다.")
				 }
				$('#hidden-tool-registerNo').val("-1");	
				$('.close-tool:last').click(function(){
					var register_no = $(this).parent('.thumbnail').find('.hidden_tool').val();
					console.log(register_no);
					var target = this;
					$.ajax({
						url:'/TestFinalProject/deleteProgrammingSkill.do',
						type:'post',
						data:{
							"register_no" : register_no
						},success:function(){
							alert("삭제 되었습니다.");
							$(target).parentsUntil('#develop-tool').detach();
							
						},error:function(){
							alert("삭제에 실패하였습니다.");
						}
					})
				
				})
					//thumb.html(language);
				},
				error:function(){		
				}
							
			})
			
		})
		$('.dev-thumb').click(function() {
			$('#develop-modal').modal('show');
			modifyTool(this);
		})
		
		function makeTool(res, tool){
		var data = JSON.parse(res);
        	
        	for(var i = 0; i<data.length; i++){
        		if(data[i].skill_name==tool)
        		{
        			 $('#develop-tool').append("<div class='col-xs-3 col-md-2'>"
        							 + "<div class='thumbnail'>"
        							 + "<button type='button' class='close close-tool' aria-label='Close'>"
        							 + "<span aria-hidden='true'>&times;</span></button><br>"
        							 + "<div class='dev-thumb'><img src= alt='' width=100px height=100px>"
        							 + "<div class='caption' id="+tool+">"+tool+"</div>"
        							 + "<input type='hidden' value="+data[i].register_no+" class='hidden_tool'>"
        							 + "</div></div></div>");
        			 $('#'+tool).prev().prop("src","${path}"+data[i].skill_name_image);
        		}
        	}
        	
			$('.dev-thumb:last').click(function() {
				 $('#develop-modal').modal('show');
				 modifyTool(this);	
			})
		
		}
			
		function modifyTool(tool){
			var name = $(tool).find('.caption').html();
		  	$('#hidden-develop-modal').attr("class","modify");
			$('#hidden-develop-modal').attr("value", name);
			 
			 $.ajax({
					url:'/TestFinalProject/searchProgrammingSkill.do',
					type:'post',
					data:{
						"name" : name
					},success:function(res){
					var tools = JSON.parse(res);
					$('.proficiency-tool[value='+tools.rank+']').prop("checked","checked");
					if(tool.type=='tool'){
						$('#tools-select > option[value='+tools.name+']').prop("selected", "true");
					}else{
						$('#etc-selectDeveloper').prop("checked", "checked");
					}
					$('#myDeveloper-skill').val(tools.name);
					$('#hidden-tool-registerNo').val(tools.register_no);
				},error:function(){
					alert("검색에 실패하셨습니다.");
				}
			})
		}
		$('.close-tool').click(function(){
			var register_no = $(this).parent('.thumbnail').find('.hidden_tool').val();
			var target = this;
			$.ajax({
				url:'/TestFinalProject/deleteProgrammingSkill.do',
				type:'post',
				data:{
					"register_no" : register_no
				},success:function(){
					alert("삭제 되었습니다.");
					$(target).parentsUntil('#develop-tool').detach();
					
				},error:function(){
					alert("삭제에 실패하였습니다.");
				}
			})
		
		})
		$('.input-group input').datepicker({
					
			format: "yyyy년 mm월",
		    startView: "months", 
		    minViewMode: "months",
					
		});
		
	
		
		$('#language-select').change(function(){
			$('#myLanguage-skill').val($('#language-select option:selected').val());
			$('#database-select').val("0");
			$('#os-select ').val("0");
			$('#etc-selectLanguage').prop("checked",false);
			$('#myLanguage-skill').prop('disabled', true);
		})
		$('#database-select').change(function(){
			$('#myLanguage-skill').val($('#database-select option:selected').val());
			$('#language-select').val("0");
 			$('#os-select').val("0");
 			$('#etc-selectLanguage').prop("checked",false);
 			$('#myLanguage-skill').prop('disabled', true);
		})
		$('#os-select').change(function(){
			$('#myLanguage-skill').val($('#os-select option:selected').val());
			$('#language-select').val("0")
			$('#database-select').val("0")
			$('#etc-selectLanguage').prop("checked",false);
			$('#myLanguage-skill').prop('disabled', true);
		})
		$('#etc-selectLanguage').click(function(){
			$('#language-select').val("0");
			$('#database-select').val("0");
			$('#os-select ').val("0");
			$('#myLanguage-skill').prop('disabled', false);
			$('#myLanguage-skill').val('');
		})
		
		
		$('#tools-select').change(function(){
			$('#myDeveloper-skill').val($('#tools-select option:selected').val());
			$('#etc-selectDeveloper').prop("checked",false);
			$('#myDeveloper-skill').prop('disabled', true);
			
		})
		$('#etc-selectDeveloper').click(function(){
			$('#tools-select').val("0");
			$('#myDeveloper-skill').prop('disabled', false);
			$('#myDeveloper-skill').val('');
		});
		
// 		$('#language-btn').click(function(){
// 			var language = $('#myLanguage-skill').val()
// 		})
// 		$('#language-btn').click(function(){
// 			$('#language-modal').modal('hide')
// 		})
		$('#developer-btn').click(function(){
			$('#develop-modal').modal('hide')
		})
	
		$('#language-skill-cancel').click(function(){
			$('#language-select').val("0");
			$('#database-select').val("0");
			$('#os-select ').val("0");
			$('#myLanguage-skill').val("");
			$('#etc-selectLanguage').prop("checked",false);
			$('.col-md-3 input').prop("checked",false);
			$('.proficiency').prop("checked",false);
		})
		$('#developer-tool-cancel').click(function(){
			$('#tools-select').val('0');
			$('#myDeveloper-skill').val('');
			$('#etc-selectDeveloper').prop("checked",false);
			$('.col-md-4 input').prop("checked",false);
			$('.proficiency').prop("checked",false);
		})
		
		$('.awards-panel').on('click', function() {
			$('#award_modal').modal('show');
			/* 값 초기화  */
			
				/* 필드 초기화  */
				$('#award-category option:eq(0)').prop('selected','selected');
				$('#award-field').show();
				var field = $('#award-field').html();	
				if(field == "동적으로"){
					$('#award-field option:eq(0)').prop('selected','selected');
				}else if(field == "받아와야"){
					$('#award-field option:eq(1)').prop('selected','selected');
				}else{
					$('#award-field option:eq(2)').prop('selected','selected');
				}
			
			console.log($('.award-profile-target').html());
			/* 수상자 초기화 */
			$('#award-target').val($(this).find('.award-profile-target').html());
			/* 수상명 초기화 */
			$('#award-name').val($(this).find('.award-profile-name').html());
			/* 수상일 초기화 */
			$('#award-date').val($(this).find('.award-profile-date').html());
			/* 주최기관 초기화 */
			$('#award-publication').val($(this).find('.award-profile-publication').html());
			/* 수상내역 초기화 */
			$('#award-content').val($(this).find('.award-profile-content').html());
			/* 편집 모달이라는 속성 부여 */
			$('#award_type').prop('value', 'editAward');
			$('#award_key').prop('value', $(this).find('.profile-career-key').attr('value'));
		});
		/*
		 * 수상 경력 - 삭제 클릭 시 
		 */
		 $('.close-panel').on('click', function(){
				var registerNo = $('.profile-career-key').val();
				alert(registerNo);
				var transfer = {registerNo : registerNo, career_type : "deleteAward"};
				$.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/initProgrammingSkill.do",
					data : transfer,
					dataType : 'json',
					success : function(res){
						if(res.result === "삭제 성공"){
							target.parent().parent().remove();
							alert("삭제 성공");
						}else{
							alert("삭제 실패");
						}
					},
					error : function(res){
						alert("실패");
					}
				});
			
		 });
		$('#save-award-btn').on('click', function() {
			$('#award_modal').modal('hide');
			
			/* 편집 모달이면 */
			
				var formData = $('#award-form').serialize();
				alert(formData);
				$.ajax({
					type : "POST",
					url : "${pageContext.request.contextPath}/initProgrammingSkill.do",
					data : formData,
					success : function(res) {
						var result = JSON.parse(res);
						/* var key = res.trim();
						alert(key); */
						
						var key = $('#award_key').val();
						alert(key);
						$('.profile-career-key[value='+key+']').parent().find('.award-profile-target').html($('#award-target').val());
						/* 수상명 초기화 */
						$('.profile-career-key[value='+key+']').parent().find('.award-profile-name').html($('#award-name').val());
						/* 수상일 초기화 */
						$('.profile-career-key[value='+key+']').parent().find('.award-profile-date').html($('#award-date').val());
						/* 주최기관 초기화 */
						$('.profile-career-key[value='+key+']').parent().find('.award-profile-publication').html($('#award-publication').val());
						/* 수상내역 초기화 */
						$('.profile-career-key[value='+key+']').parent().find('.award-profile-content').html($('#award-content').val());
						
					},
					error : function() {
						alert("실패");
					}
				});
				$('#award_type').attr('value', '');
				
			});
		
	})
</script>


 </body>
</html>