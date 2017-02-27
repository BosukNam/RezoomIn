<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html> -->

<!-- <head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<!-- <title>기본인적사항</title>
 -->
<!-- 부트스트랩 -->
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker3.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

date picker
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.min.js"></script>
 -->
<!-- </head>
<body> -->
	<!-- Button trigger modal -->
<!-- 	<button type="button" class="btn btn-primary btn-lg"
		data-toggle="modal" data-target="#myModal">기본인적사항
	</button> -->

	<!-- Modal -->
	<div class="modal fade resume_modal" id="personal_info_modal" tabindex="-1" role="dialog"
		aria-labelledby="personal_info_modal_label" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="personal_info_modal_label">기본 인적 사항</h3>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="personal_form" name="personal_form" method="POST">
					
					<input type="hidden" name="resume_category" id="personal_category" value='profile'>
					<input type="hidden" name="type" id="personal_type" value=''>
	
						<div class="form-group">
							<label for="name" class="col-md-2 control-label">이름</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="name" id="name"
									placeholder="이름을 입력해주세요">
							</div>
							<label for="englishName" class="col-md-2 control-label">영문이름</label>
							<div class="col-md-4">
								<input type="text" class="form-control" name="englishName"
									id="englishName" placeholder="영문이름을 입력해주세요">
							</div>
						</div>
						<div class="form-group">
							<label for="birth" class="col-md-2 control-label">생년월일</label>
							<div class="col-md-10">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="생년월일을 선택하세요" id="birthDate-picker" name="birthDate">
									<span class="input-group-addon" id="basic-addon2"> <span
										class="glyphicon glyphicon-th" id="birth-date"></span>
									</span>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="email">
								<label for="inputEmail3" class="col-md-2 control-label">이메일</label>
								<div class="col-md-10">
									<input type="email" class="form-control" name="email"
										id="email" placeholder="이메일을 입력해주세요">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="address" class="col-md-2 control-label">주소</label>
							<div class="col-md-10">
								<input type="text" class="form-control" name="address"
									id="address" placeholder="주소를 입력해주세요">
							</div>
						</div>
						<div class="form-group">
							<label for="phone" class="col-md-2 control-label">연락처</label>
							<div class="col-md-4">
								<input type="tel" class="form-control" id="phone"
									placeholder="연락처를 입력해주세요" name="phoneNo">
							</div>
							<label for="gender" class="col-md-2 control-label">성별</label> 
							<label class="radio-inline"> 
								<input type="radio" name="gender" id="female" value="female"> 여성
							</label> 
							<label class="radio-inline"> 
								<input type="radio" name="gender" id="male" value="male"> 남성
							</label>
						</div>
						<input type="hidden" class="form-control" name="photo">
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-primary" id="save_personal_btn">저장</button>
				</div>
			</div>
		</div>
	</div>