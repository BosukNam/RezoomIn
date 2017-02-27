/**
 * 프로젝트 소개
 */
//사용자 정의 수정 등록
$(function(){
	/* 사용기술 저장 버튼 처리 부분 */
    $('#saveBtn_userSkill').click(function(){
	  var project_no = $('#project_no').val();
  	  var register_no = "";
  	  $('.developmentLanguage[name="project-language"]').each(function(){
  		  if(this.checked)
  			  register_no += this.value+"/";
  	  })
  	  insertUserSKill(project_no, register_no);
  	  console.log(project_no);
  	  
    })
    function insertUserSKill(project_no, register_no){
    	 $.ajax({
     		  type:"GET",
               url:"/TestFinalProject/insertUseSkill.do",
               data:{
               	"registerArray" : register_no,
               	"project_no": 1
                },
                success:function(){
             	   alert("성공했당");
             	   
                },error:function(){
             	   
                }
     	  })
    }
    /* 사용자 정의 내용 저장 버튼 클릭 시*/ 
	$('#btn-content-save').click(function(){
		var registerNo=$('#set-project-user-defined');
		var projectNo=$('#project');
		var url="updateProgramImageAndContent.do";
		   //등록확인
		if (registerNo.attr("value") == "0") {
			url = "insertProgramContent.do"
		}
		url = "/TestFinalProject/" + url;
		alert(url + $('#user-defined-content').val()
				+ registerNo.attr("value"));
		$.ajax({
			type : "POST",
			url : url,
			data : {
				category : "pc2",
				content : $('#user-defined-content').val(),
				// imagePath:$('#image_path_pc1').val(),
				imagePath : 'none',
				registerNo : registerNo.attr("value"),
				projectNo : projectNo.attr('value')
			},
			success : function(res) {
				var data = res.trim();
				if (data != "0") {
					registerNo.attr("value", data);
					alert(data);
				} else {
					alert("사용자정의내용-등록 또는 수정 실패");
				}
			},
			error : function() {
				/* 서버 에러 */
				console.log("사용자정의내용-프로젝트 소개 등록 또는 수정 서버 오류");
			}
			})
	})
	/* 사용자 정의 내용 삭제 */
	$('#btn-content-cancle').click(function(){
		var registerNo=$('#set-project-user-defined');
		var projectNo=$('#project');
		   //데이터없을때 예외처리하기
		   if(registerNo.attr("value")!="0"){
			   $.ajax({
			      type:"POST",
			      url:"/TestFinalProject/deleteProgramContent.do",
			      data:{
			         registerNo:registerNo.attr("value"),
			         projectNo:projectNo.attr('value'),
			         category:"pc2"
			      },
			      success:function(res){
			          var data=res.trim();
			    	  if(data=="true"){
			           alert("성공!")
			           registerNo.attr("value",0);
			           $('#user-defined-content').val('');
			         } else{
			            alert("실패");
			         }
			      },
			      error:function(){
			         /* 서버 에러 */
			         alert("서버 오류");
			      }
			   })
		   }
	})
	/* Library 패널 버튼 클릭 시 */
    $('#library-title').click(function(){
  	  searchLibrary("프로젝트 내용");
    })
          
    /* 사용기술 패널 버튼 클릭 시 */
    $('#useSkill-title').click(function(){
  	  searchUseSkill("프로젝트 내용");
    })
    
    /* 사용 기술 언어 취소 버튼 시 초기화 처리*/
    $('#cancelBtn_userSkill').click(function(){
  	 $('#collapseFive').prop("class","panel-collapse collapse");
    })
    
    
     /* 사용 기술 언어 검색 함수 */
    function searchUseSkill(contentName){
    	
  	  $.ajax({
            type:"POST",
            url:"/TestFinalProject/searchUseSkillByField.do",
            data:{
               field:"1",
              project_no: 1
             },
            success:function(res)
            {
               var data=JSON.parse(res);
               $('#use-language').html('');
               $.each(data,function(index,element){
             	 if(element.isUse==true){
             		 $('#use-language').append("<div class='col-md-3'><input type='checkbox'" 
                     		 +"class='developmentLanguage' checked=true name='project-language'"
                     		 +"value='"+element.register_no+"'>"
                          +element.name+"</div>");
             	 }else{
             		 $('#use-language').append("<div class='col-md-3'><input type='checkbox'" 
                     		 +"class='developmentLanguage' name='project-language'"
                     		 +"value='"+element.register_no+"'>"
                          +element.name+"</div>");
             	 }
               console.log(element.isUse);
               });
             
            },
            error:function(){
               /* 서버 에러 */
               alert("서버 오류");
            }
         })
    } 
    
    /* 사용 기술 언어 취소 버튼 시 초기화 처리*/
    $('#cancelBtn_library').click(function(){
  	 $('#collapseSix').prop("class","panel-collapse collapse");
    })
	    /* 라이브러리 이미지 업로드 버튼 처리  */
	    $('#saveBtn_library_img').click(function(){
	  	  var state;
	  	  var registerNo = $('#library_hidden').val();
	  	  if(registerNo==-1){
	  		  state = "insert"
	  	  }else{
	  		  state = "update";
	  	  }
	  	  //업로드 할 파일을 폼 폼객체에 저장한다.
	  	  var formData = new FormData();
	  	  formData.append("uploadfile",$('#library-img-upload')[0].files[0])
	  	  formData.append("content", $('#library-content-text').val());
	  	  formData.append("state" , state);
	  	  formData.append("flag", "프로젝트 내용");
	  	  formData.append("category", "library");
	  	  formData.append("registerNo", registerNo);
			 console.log(formData.get("uploadfile"));
	  	  $.ajax({
	  		  type:"POST",
	            url:"/TestFinalProject/readmyproject.do",
	            processData:false,
	            contentType:false,
	            data:formData,
	            success:function(){
	          	  alert("등록되었습니다.");
	            },error:function(){
	          	  
	            }
	  	  })
	  	  
	  	  
    })
    
    
    /*라이브러리 검색 함수 */
    function searchLibrary(contentName){
        $.ajax({
            type:"POST",
            url:"/TestFinalProject/",
            data:{
               state : "search",
               flag:contentName,
               category:"Library"
             },success:function(res){
          	   var data = JSON.parse(res);
          	   $('#library_hidden').val(data[0].registerNo);
          	   $('#library-content-text').html(data[0].content);
             },error:function(){
          		alert("서버오류")
             }
        })
     }
    /* 시스템 환경(아키텍처) 버튼 클릭 시 */
    $('#system-architecture-btn').click(function(){
       $('#system-architecture-form').modal('show');
       searchSystemArchitecture();
      
    })
    /* 시스템 환경(아키텍처) 검색 함수 */
    function searchSystemArchitecture(){
    	$.ajax({
    		  type:"POST",
              url:"/TestFinalProject/searchSystemArchitecture.do",
              data:{
                 project_no : 1
              },
              success:function(res){
            	  if(res!="no"){
            		  var data = JSON.parse(res);
                	  $('#config-select > option[value='+data.tier_category+']').prop("selected", "true");
                	  $('#client-config').val(data.client);
                	  $('#system-config').val(data.server);
                	  $('#middle-config').val(data.middle_ware);
                	  $('#system_architecture_hidden').val(data.register_no);
                	  if(data.tier_category=='ti1'){
                		  	$('#client-tier').show();
           	            	$('#multi-tier').hide();
           	            	$('#2-tier').hide();
                	  }else if(data.tier_category=='ti2'){
           	            	$('#client-tier').show();
           	            	$('#multi-tier').hide();
           	            	$('#2-tier').show();
                	  }else if(data.tier_category=='ti3'){
                	      	$('#client-tier').show();
                	      	$('#multi-tier').show();
                	      	$('#2-tier').show();
                	  }else{
             	            $('#client-tier').hide();
             	            $('#multi-tier').hide();
             	            $('#2-tier').hide();
                	  }
            	  }
            	 
              },
              error:function(){
            	  
              }
    	  })
    }
    
    /* 시스템 환경(아키텍처) 저장 버튼 클릭 시*/
    $('#saveBtn_system_architecture').click(function(){
  	  var register_no = $('#system_architecture_hidden').val();
  	  var tier = $('#config-select option:selected').val()
  	  var client = $('#client-config').val();
  	  var server = $('#system-config').val();
  	  var middle_ware =  $('#middle-config').val();
  	  console.log(register_no);
  	  if(register_no==-1){
  		  url = "/TestFinalProject/insertSystemArchitecture.do"
  	  }else {
  		  url = "/TestFinalProject/updateSystemArchitecture.do"
  	  }
  	  
  	  $.ajax({
  		  type:"POST",
            url:url,
            data:{
            	register_no : register_no,
            	project_no : 1,
            	tier_category : tier,
            	client : client,
            	server : server,
            	middle_ware : middle_ware
            },
            success:function(){
            	$('#system-architecture-form').modal('hide');
            	alert("성공하였습니다.")
            },
            error:function(){
            }
  	  })
    })
    
    /* 시스템 환경(아키텍처) 취소 버튼 클릭시 */
    $('#cancelBtn_system_architecture').click(function(){
    	$('#client-config').val("");
        $('#system-config').val("");
        $('#middle-config').val("");
    })
    /* 유즈 케이스 작성하기 버튼을 클릭했을 시 처리 */
    $('#usercase-register').click(function(){
    	$('#usecase-form').modal("show");
    	searchSoftArchitecture()
    })
    /* 유즈케이스 확인 버튼 클릭했을 시 처리 */
    $('#saveBtn_usecase').click(function(){
    	var usecase =  $('#actor').val()+"/"+$('#case1').val()+"/"+$('#case2').val()
      	+"/"+$('#case3').val()+"/"+$('#case4').val()+"/";
    	$('#usecase_file_hidden').val(usecase);
    	$('#usecase-form').modal("hide");
    })
    /* 소프트웨어 환경 저장 버튼 클릭 시 처리 */
    $('#saveBtn_software_architecture').click(function(){
    	var url;
    	var register_no = $('#usecase_hidden').val();
    	var caseSelect =  $('#usecase-select option:selected').val()
      	var usecase_count =0;
    	console.log(caseSelect);
    	if(caseSelect=='case1'){
    		usecase_count = 2;
      	}else if(caseSelect=='case2'){
      		usecase_count = 3;
      	}else if(caseSelect=='case3'){
      		usecase_count = 4;
      	}else if(caseSelect=='case4'){
      		usecase_count = 5;
      	}
    	console.log(usecase_count);
      	var usecase = $('#usecase_file_hidden').val();
      	console.log(usecase);
      	if(register_no==-1){
      		url = "/TestFinalProject/insertSoftwareArchitecture.do"
      	}else {
      		url = "/TestFinalProject/updateSoftwareArchitecture.do"
      	}
      	var formData = new FormData();
      	formData.append("diagram_image",$('#diagram-Btn')[0].files[0])
      	formData.append("register_no", register_no);
      	formData.append("project_no" , 1);
      	formData.append("usecase_file", usecase);
      	formData.append("usecase_count", usecase_count);
      	$.ajax({
      		type:"POST",
      		url:url,
      		processData:false,
      		contentType:false,
      		data:formData,
      		success:function(){
      			$('#software-architecture-form').modal('hide');
      			alert("등록되었습니다.");
      		},error:function(){
      		}
      	})
    })
    /* 소프트 웨어 환경 검색 함수*/
    function searchSoftArchitecture(){
    	$.ajax({
    		  type:"POST",
              url:"/TestFinalProject/searchSoftwareArchitecture.do",
              data:{
                 project_no : 1
              },
              success:function(res){
            	  if(res!="no"){
            		  var data = JSON.parse(res);
            		  $('#usecase_hidden').val(data.register_no);
            		  console.log(data);
            		  var category;
        			  if(data.usecase_count == 2){
        				  category = "case1"
        			  }else if(data.usecase_count== 3){
        				  category = "case2"
        			  }else if(data.usecase_count== 4){
        				  category = "case3"
            	      }else{
            	    	  category = "case4"
            	      }
                	  $('#usecase-select > option[value='+category+']').prop("selected", "true");
	            	  $('#actor').val(data.actor);  
                	  $('#case1').val(data.case1);
                	  $('#case2').val(data.case2);
                	  $('#case3').val(data.case3);
                	  $('#case4').val(data.case4);
                	  if(category=="0"){
                  		$('#case2_div').hide();
                  	    $('#case3_div').hide();
                  	    $('#case4_div').hide();
                  	    $('#case1_div').hide();
                       }
                  	else if(category=="case1"){
                      
                  		$('#case1_div').show();
                  	    $('#case2_div').hide();
                  	    $('#case3_div').hide();
                  	    $('#case4_div').hide();
                       }
                       else if(category=="case2"){
                      	$('#case1_div').show();
                   	    $('#case2_div').show();
                   	    $('#case3_div').hide();
                   	    $('#case4_div').hide();
                       }
                       else if(category=="case3"){
                      	$('#case1_div').show();
                   	    $('#case2_div').show();
                   	    $('#case3_div').show();
                   	    $('#case4_div').hide();
                        }
                       else{
                      	$('#case1_div').show();
                   	    $('#case2_div').show();
                   	    $('#case3_div').show();
                   	    $('#case4_div').show();
                       }
            	  }
            	 
              },
              error:function(){
            	  
              }
    	  })
    }
    $('#pc2').click(function(){
   	 	 var registerNo=$('#set-project-user-defined')
   	 	 var projectNo=$('#project')
	     $.ajax({
	   		  type:"POST",
	   		  url:"/TestFinalProject/selectProgramContent.do",
	   		  data:{
	   			  projectNo:$('#project').attr('value'),
	   			  category:"pc2"
	   		  },
	   		  success:function(res){
	   			  var data=res.trim();
	   			  var result=JSON.parse(data);
	   			  if(result!="ERROR"){
	   				  registerNo.attr("value",result.registerNo);
	   				  $('#image_path_pc2').val(result.image_path);
	   				  $('#user-defined-content').val(result.content);
	   				  var chartNo=result.chartNo;
	   				  alert(chartNo);
	   			  }
	   			  alert(data);
	   		  },
	   		  error:function(){
	   			  alert("오류");
	   		  }
	   	 }) 
    })
})
//사용자 정의 수정 삭제
