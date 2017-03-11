/**
 * 차트관련 자바스크립트
 */

$(function(){
	//차트
	var ctx=document.getElementById("myChart");
	//차트 항목 입력 정보
	var category = document.querySelectorAll(".chart-category");
	//차트 데이터 입력 정보
	var chart_datas = document.querySelectorAll(".chart-data");
	var data = {
    		labels: [category[0].value, 
                     category[1].value,
                     category[2].value,
                     category[3].value,
                     category[4].value],  
            datasets: [
                {
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.7)',
                        'rgba(54, 162, 235, 0.7)',
                        'rgba(255, 206, 86, 0.7)',
                        'rgba(75, 192, 192, 0.7)',
                        'rgba(153, 102, 255, 0.7)'
                    ],
                    borderColor: [
                        'rgba(255, 99, 132, 1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)'
                    ],
                    borderWidth: 1,
                    data: [chart_datas[0].value,
                           chart_datas[1].value,
                           chart_datas[2].value,
                           chart_datas[3].value,
                           chart_datas[4].value]
                }
            ]
        };
	var field;
	 //차트 modal 조회-defualt 차트는 bar 차트
	$('.chart-btn').click(function(){
		var value=$(this).attr('value');
		var registerNo;
		if(value=='pc1')
			registerNo=$('#set-project-project-intro')
		else
			registerNo=$('#user-defined-content')
		console.log('chart');
		$.ajax({
			type:"POST",
			url:"/RezoomIn/selectChart.do",
			data:{
				registerNo:registerNo.attr('value')
			},
			success:function(res){
				var check=res.trim()
				if(check!="chart"){
					var result=JSON.parse(check);
					var table_type;
					var items=new Array();
					var datas=new Array();
					var table_item;
					var table_data;
					var table_registerNo;
					$.each(result,function(index, element){
						if(index==0){
							table_type=element.type;
							
						}
						else if(index==1){
							table_registerNo=element.registerNo;
							//console.log("table_type",table_type);
						}else{
							table_item=element.item;
							table_data=element.data;
							console.log(table_item+table_data);
							category[index-2].value=table_item;
							items.push(table_item);
							chart_datas[index-2].value=table_data;
							datas.push(table_data);
						}
						
					})
					data.labels=items;
					data.datasets["0"].data=datas;
					initChart(table_type);
	
					$('#chart-modal').modal('show');
				}
			},error:function(){
				alert("개요-차트 조회 서버오류");
			}
		})
    })
    //세로 막대 그래프 선택
    $('#barchart').click(function(){
    	initChart("bar");
    	
    })
    //파이(원) 그래프 선택
    $('#piechart').click(function(){
    	initChart("pie");
    })
    //라인 그래프 선택
    $('#linechart').click(function(){
  	    initChart("line");
    })
    
    //차트 초기화 함수
    var initChart=function(chartType){       
      ctx.setAttribute("class", chartType);
      new Chart(ctx, {
      		type: chartType,
        	data: data,
        	options: {
        		responsive: true,
           		maintainAspectRatio: true
          }
      });
    }
    //console.log(data);
    var changeTable=function(changeTable){
    	var table = new Array();
        $.each(changeTable,function(index, element){
        	var element_value=element.value;
        	if(element_value!=""){
        		table.push(element_value);
        		console.log("element : "+element_value);
        	}
        })
        return table;
    }
    //항목 입력 이벤트 발생시 차트 변경
    $('.chart-category').keyup(function(){   
        var changeCategory = document.querySelectorAll(".chart-category");  
        changeTable(changeCategory);
        data.labels = changeTable(changeCategory);
        initChart(ctx.getAttribute("class"));
      })
      //데이터 입력 이벤트 발생시 차트 변경
      $('.chart-data').keyup(function(){   
          var changeData = document.querySelectorAll(".chart-data");
          data.datasets["0"].data = changeTable(changeData);
          initChart(ctx.getAttribute("class"));
      });
      //차트 저장(등록 또는 수정)
      $('#chart-save').click(function(){
    	  //programIntro가 -1인 경우 차트 생성
    	  //programIntro가 -1이 아닌 경우 차트 수정
    	  alert(field);
    	  var registerNo=field.parent();
    	  var url="/RezoomIn/readmyproject.do"
    	  if(registerNo.attr("id")=="-1"){
    		  url="/RezoomIn/insertChart.do"
    	  }
    	  //projectIntro인지, userdefined인지 구분하여 쿼리 추가하기
    	  var formData=new $('#chart-form').serialize()+
    	  					+"&program_content_no="+registerNo.attr("id")
    	  console.log(formData);
    	  $.ajax({
    		type:"POST",
    		url:url,
    		data:formData,
    		success:function(res){
    			var data=res.trim();
    			if(data!="-1"){
    				registerNo.attr("id",data);
    			}else{
    				alert("차트 등록 또는 수정 실패");
    			}
    		},
    		error:function(){
    			alert("차트 등록 또는 수정 서버 오류");
    		}
    	  })
      })
      //차트 삭제
      $('#chart-cancel').click(function(){
    	var registerNo=$('#program-intro-save').parent();
        $.ajax({
        	type:"POST",
        	url:"/RezoomIn/readmyproject.do",
        	data:{
        		state:"delete",
				flag:"차트",
				registerNo:registerNo.attr("id")
        	},
        	success:function(res){
        		var data=res.trim();
        		if(data=="-1"||data=="CHART-DELETE"){
        			alert("삭제 성공!");
        			$('.chart-data').val('1');
        	        $('.chart-category').val('항목');
        	        $('.chart-category:first').trigger('keyup'); 
        	        $('.chart-data:first').trigger('keyup');
        	        if(data=="-1"){
        	        	registerNo.attr("id",data);
        	        }
        		}else{
        			alert("실패");
        		}
        	},
        	error:function(){
        		alert("차트 삭제 서버 오류");
        	}
        })
     })
})