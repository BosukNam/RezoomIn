<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../css/myBoot.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>유년기 test</title>
<script src="../scripts/l-by-l.js"></script>
<link href='http://fonts.googleapis.com/css?family=Lato:400,300,100,700' rel='stylesheet' type='text/css'>
<script>

$(function(){
	/* $('.covervid-video').coverVid(1920, 1080); */
	$("#childBackground").on('click',function() {
		 $(".example1").lbyl({
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

	<div id="childBackground" class="example1">
		<h1>Lorem 22 Dolor</h1>
		Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed
			diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam
			erat volutpat.
		Ut wisi enim ad minim veniam, quis nostrud exerci tation
			ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo
			consequat.
	</div>
	


</body>
</html>