//book만들기
 $(function(){

  $("#view-book").click(function(){
  	$('#myResume-modal').modal('show')
  })
  
  $("#flipbook").turn({
	      width: 400,
	      height: 300,
	      autoCenter: true
	  });
	  $("#flipbook").turn("size", 1000, 600);

	  $("#modal-resume").click(function(){
		  	//page는 hard표지 포함
		  	$("#flipbook").turn("page", 3);
		  	$("#flipbook").turn("resize");
		  })
	  $("#modal-introduce").click(function(){
	  	//page는 hard표지 포함
	  	$("#flipbook").turn("page", 4);
	  	$("#flipbook").turn("resize");
	  })
	  $("#modal-portfolio").click(function(){
	  	//page는 hard표지 포함
	  	$("#flipbook").turn("page", 6);
	  	$("#flipbook").turn("resize");
	  })
  
 });