<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html>


	<!-- Modal -->
	<div class="modal fade" id="photo_modal" tabindex="-1" role="dialog"
		aria-labelledby="photo_modal_label" aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="photo_modal_label">사진업로드</h3>
				</div>
				<div class="modal-body">
				<input type="hidden" name="resume_category" id="photo_category" value="photo">
				<c:choose>
					<c:when test="${requestScope.personalInfo.photo eq null}">
						<img src="https://x.myspacecdn.com/new/common/images/user.png" style="margin-left:50px;"
							id="profileImg" width="180px" >
					</c:when>
					<c:otherwise>
						<img src="${requestScope.personalInfo.photo}" style="margin-left:50px;"
					id="profileImg" width="180px" >
					</c:otherwise>
				</c:choose>
					<div style="margin-top:10px; margin-left:50px;">
					<label class="btn btn-default btn-file"> 사진 선택 <input type="file" class="hidden" id="photo-select-btn"></label>
					<button type="button" class="btn btn-primary" id="photo-delete-btn">사진 지우기</button></div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="photo-save-btn">저장</button>
				</div>
			</div>
		</div>
	</div>
