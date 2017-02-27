/**
 * 프로젝트 개요
 */
//등록된 게시물이 없는데 삭제할 경우 생각하기
//프로젝트 소개
$(function(){
	//프로젝트 소개-삭제
	$('#program-intro-delete').click(function(){         
	   var registerNo=$('#set-project-project-intro');
	   var projectNo=$('#project');
	   //데이터없을때 예외처리하기
	   if(registerNo.attr("value")!="0"){
		   $.ajax({
		      type:"POST",
		      url:"/TestFinalProject/deleteProgramContent.do",
		      data:{
		         registerNo:registerNo.attr("value"),
		         projectNo:projectNo.attr('value'),
		         category:"pc1"
		      },
		      success:function(res){
		          var data=res.trim();
		    	  if(data=="true"){
		           alert("성공!")
		           registerNo.attr("value",0);
		           $('#program-intro-text').val('');
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
	//프로젝트 소개-프로그램 등록 또는 수정
	$('#program-intro-save').click(function(){
	   var registerNo=$('#set-project-project-intro');
	   var projectNo=$('#project');
	   var url="updateProgramImageAndContent.do";
	   //등록확인
	   if(registerNo.attr("value")=="0"){
		  url="insertProgramContent.do"
	   }
	   url="/TestFinalProject/"+url;
	   alert(url+$('#program-intro-text').val()+registerNo.attr("value"));	
	   $.ajax({
	      type:"POST",
	      url:url,
	      data:{
	         category:"pc1",
	         content:$('#program-intro-text').val(),
//	         imagePath:$('#image_path_pc1').val(),
	         imagePath:'none',
	         registerNo:registerNo.attr("value"),
	         projectNo:projectNo.attr('value')
	      },
	      success:function(res){
	         var data=res.trim();
	         if(data!="0"){
	            registerNo.attr("value",data);
	            alert(data);
	         } else{
	            alert("개요-프로젝트 소개 등록 또는 수정 실패");
	         }
	      },
	      error:function(){
	         /* 서버 에러 */
	         console.log("개요-프로젝트 소개 등록 또는 수정 서버 오류");
	      }
	   })
	})
})
//프로젝트 개발 환경
$(function(){
	$('#program-term-cancel').click(function(){
		var registerNo = $('#set-project-date')
		if($('#set-project-date').attr('value')!="0"){
			$.ajax({
				type:"POST",
				url:"/TestFinalProject/updateDate.do",
				data:{
					registerNo:$('#set-project-date').attr("value"),
				},
				success:function(res){
			         var data=res.trim();
			         if(data!=false){
			            registerNo.attr("value",0);
			            $('#program-term-start').val('')
			            $('#program-term-end').val('')
			            alert(data);
			         } else{
			            alert("개요-프로젝트 기간 수정 실패");
			         }
			    },
			    error:function(){
			         /* 서버 에러 */
			         console.log("개요-프로젝트 기간 수정 서버 오류");
			    }
			})
		}
	})
	$('#program-term-save').click(function(){
		var registerNo=$('#set-project-date');
		//var registerNo = $('#set-project-date')
			$.ajax({
				type:"POST",
				url:"/TestFinalProject/updateDate.do",
				data:{
					registerNo:registerNo.attr('value'),
		            startDate:$('#program-term-start').val(),
		            endDate:$('#program-term-end').val()
				},
				success:function(res){
			         var data=res.trim();
			         if(data!="0"){
			        	 //프로젝트 레지스터 번호 
			        	var result=JSON.parse(data)
			        	var startDate=result.startDate
			        	var endDate=result.endDate
			        	$('#program-term-start').val(startDate)
			        	$('#program-term-end').val(endDate)
			        	registerNo.attr('value',result.registerNo)
			            alert(data);
			         } else{
			            alert("개요-프로젝트 기간 수정 실패");
			         }
			    },
			    error:function(){
			         /* 서버 에러 */
			         console.log("개요-프로젝트 기간 수정 서버 오류");
			    }
			})
	})
	$('#people-number-save').click(function(){
		var registerNo=$('#set-project-people-no')
		$.ajax({
			type:"POST",
			url:"/TestFinalProject/updatePoepleNo.do",
			date:{
				//프로젝트 레지스터 번호
				regsterNo:registerNo.attr("value"),
				people:$('#people-number').val()
			},
			success:function(res){
		         var data=res.trim();
		         if(data!="0"){
		        	 //프로젝트 레지스터 번호
		            registerNo.attr("value",data);
		            alert(data);
		         } else{
		            alert("개요-프로젝트 기간 수정 실패");
		         }
		    },
		    error:function(){
		         /* 서버 에러 */
		         console.log("개요-프로젝트 기간 수정 서버 오류");
		    }
		})
	})
	$('#people-number-cancle').click(function(){
		var registerNo=$('#set-project-people-no')
		if(registerNo.attr("value")!="0"){
			$.ajax({
				type:"POST",
				url:"/TestFinalProject/updatePoepleNo.do",
				date:{
					//프로젝트 레지스터 번호
					registerNo:registerNo.attr("value",data)
				},
				success:function(res){
			         var data=res.trim();
			         if(data!="0"){
			        	 //프로젝트 레지스터 번호?
			            registerNo.attr("value",0);
			            alert(data);
			         } else{
			            alert("개요-프로젝트 기간 수정 실패");
			         }
			    },
			    error:function(){
			         /* 서버 에러 */
			         console.log("개요-프로젝트 기간 수정 서버 오류");
			    }
			})
		}
	})
})
//프로젝트 사용 개발 툴
$(function(){
      //사용 개발 툴 삭제
      $('#develop-tool-reset').click(function(){
      }) 
      //사용 개발 툴
      $('#develop-tool-save').click(function(){
    	  var project_no = $('#project_no').val();
      	  var register_no = "";
      	  $('.developmentTool[name="project-tool"]').each(function(){
      		  if(this.checked)
      			  register_no += this.value+"/";
      	  });
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
      })

      
      //사용 개발 툴 검색
      $('#project_develop_tool_no').click(function(){
    	  console.log("오니")
    	  	searchUseTool();
      	 })
      function searchUseTool(){
    	 
    	  	  $.ajax({
    	            type:"POST",
    	            url:"/TestFinalProject/searchUseSkillByField.do",
    	            data:{
    	               field:"0",
    	              project_no: 1
    	             },
    	            success:function(res)
    	            {
    	               var data=JSON.parse(res);
    	              console.log(data);
    	               $('#use-tool').html('');
    	               $.each(data,function(index,element){
    	             	 if(element.isUse==true){
    	             		 $('#use-tool').append("<div class='col-md-3'><input type='checkbox'" 
    	                     		 +"class='developmentTool' checked=true name='project-tool'"
    	                     		 +"value='"+element.register_no+"'>"
    	                          +element.name+"</div>");
    	             	 }else{
    	             		 $('#use-tool').append("<div class='col-md-3'><input type='checkbox'" 
    	                     		 +"class='developmentTool' name='project-tool'"
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
      //프로젝트인원클릭했을 경우
      $('#project_people_no').click(function(){
    	  var registerNo=$('#set-project-people-no')
    	  $.ajax({
    		  type:"POST",
    		  url:"/TestFinalProject/selectPeopleNo.do",
    		  data:{
    			  registerNo:registerNo.attr("value")
    		  },
    		  success:function(res){
    			  var data=res.trim();
    			  alert(data);
    			  
    			  var result=JSON.parse(data);
    			  registerNo.attr("value", result.registerNo)
    			  $('#people-number').val(result.peopleNo)
    			  //인원하고 프로젝트 번호?
    		  },
    		  error:function(){
    			  alert("오류");
    		  }
    	  })
      })
      $('#project_date').click(function(){
    	 var registerNO= $('#set-project-date');
    	 $.ajax({
    		  type:"POST",
    		  url:"/TestFinalProject/selectProjectDate.do",
    		  data:{
    			  registerNo:registerNO.attr("value")
    		  },
    		  success:function(res){
    			  var date=res.trim();
    			  if(date!="ERROR"){
    				  var result=JSON.parse(date)
    				  alert(result);
    				  
    				  $('#program-term-start').val(result.startDate);
    				  $('#program-term-end').val(result.endDate);
    			  }
    			  //날짜하고 프로젝트 번호
    		  },
    		  error:function(){
    			  alert("오류");
    		  }
    	  }) 
      })

      $('#pc1').click(function(){
    	 var registerNo=$('#set-project-project-intro')
    	 var projectNo=$('#project')
	     $.ajax({
	   		  type:"POST",
	   		  url:"/TestFinalProject/selectProgramContent.do",
	   		  data:{
	   			  projectNo:$('#project').attr('value'),
	   			  category:"pc1"
	   		  },
	   		  success:function(res){
	   			  var data=res.trim();
	   			  var result=JSON.parse(data);
	   			  if(result!="ERROR"){
	   				  registerNo.attr("value",result.registerNo);
	   				  $('#image_path_pc1').val(result.image_path);
	   				  $('#program-intro-text').val(result.content);
	   				  var chartNo=result.chartNo;
	   				  alert(chartNo);
	   			  }
	   			  alert(data);
	   			  //내용하고 이미지 주소
	   		  },
	   		  error:function(){
	   			  alert("오류");
	   		  }
	   	 }) 
     })
})
