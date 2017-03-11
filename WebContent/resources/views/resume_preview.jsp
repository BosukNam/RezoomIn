<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>이력서 미리보기</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="/RezoomIn/resources/css/myBoot.css">
<link href="/RezoomIn/resources/css/footer.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/resources/css/godofontToHeader.css" rel="stylesheet" type="text/css">
<style>

</style>
</head>
<body>
<jsp:include page="header.jsp"/><br><br>
<jsp:include page="resume2.jsp"/>

<br>
<div id="buttons" align="center">
	<button type="button" class="btn btn-primary" id="btResumePDFsave">PDF저장</button>
	<button type="button" class="btn btn-primary" id="btResumeIMGsave">이미지저장</button>
	<button type="button" class="btn btn-primary" id="btPrintResumePage">인쇄</button>
</div>
<br><br>
<jsp:include page="footer.html"/>
</body>

</html>
