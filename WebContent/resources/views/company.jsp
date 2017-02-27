<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/myBoot.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회사생활 test</title>
<script src="../scripts/l-by-l.js"></script>
<link href='http://fonts.googleapis.com/css?family=Lato:400,300,100,700' rel='stylesheet' type='text/css'>
<script>

$(function(){
	/* $('.covervid-video').coverVid(1920, 1080); */
	$("#companyBackground").on('click',function() {
		 $(".example2").lbyl({
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

	<div id="companyBackground" class="example2">
		<h1>Lorem Ipsum Dolor</h1>
		<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed
			diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam
			erat volutpat.</p>
		<p>Ut wisi enim ad minim veniam, quis nostrud exerci tation
			ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo
			consequat.</p>
	</div>
	


</body>
</html>