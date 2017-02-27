<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/myBoot.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>청소년기 test</title>
<script src="../scripts/l-by-l.js"></script>
<link href='http://fonts.googleapis.com/css?family=Lato:400,300,100,700' rel='stylesheet' type='text/css'>
<script>

$(function(){
	/* $('.covervid-video').coverVid(1920, 1080); */
	$("#studentBackground").on('click',function() {
		 $(".example3").lbyl({
		        content: "Lorem ipsum dolor sit amet, consectetur adipiscing elit"+
		        "Fusce iaculis a quam a pellentesque. Proin maximus, nulla non molestie scelerisque,"+
		        "Fusce iaculis a quam a pellentesque. Proin maximus, nulla non molestie scelerisque,"+
		        "Fusce iaculis a quam a pellentesque. Proin maximus, nulla non molestie scelerisque,"+
		        "Fusce iaculis a quam a pellentesque. Proin maximus, nulla non molestie scelerisque,"+
		        "Fusce iaculis a quam a pellentesque. Proin maximus, nulla non molestie scelerisque,"+
		        " ligula purus lacinia massa, et dapibus quam mi at mi.",
		        speed: 10,
		        type: 'fade',
		        fadeSpeed: 500, // Only relevant when the 'type' is set to 'fade'
		        finished: function(){} // Finished Callback
		    });
	});
	
});

</script>
</head>
<body>

	<div id="studentBackground" class="example3">
		<h1>소통의 리더쉽</h1>
		<p>고등학교시절 갓 입학했을 때부터 졸업할 때까지 반장을 맡아 작지만 다부지고 책임감 있는 
		리더십으로 선생님과 친구들의 중계자 연결고리 역할을 잘한다는 소리를 들었습니다. 
		반장을 하면서 3년 동안 전교 임원을 겸했으며 선생님과 친구들의 추천으로 모범상도 받았습니다. </p>
		<p> ... (Click!)</p>
	</div>
	


</body>
</html>