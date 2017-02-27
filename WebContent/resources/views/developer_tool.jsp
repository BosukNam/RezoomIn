<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Modal -->
	<div class="modal fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true" id="develop-modal">
		<input type="hidden" class="" id="hidden-develop-modal" value="">
		<input type="hidden" id = "hidden-tool-registerNo" value="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">개발 가능 툴</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
							<label class="col-md-3 control-label">개발 가능 툴 : </label>
							<div class="col-md-9">
								<div class="col-md-6">
									<select name="tools" id="tools-select" size=1>
										<option value="0">툴 선택</option>
										<option value="eclipse">eclipse</option>
										<option value="sts">sts</option>
										<option value="visual studio">visual studio</option>
									</select>
								</div>
								<div class="col-md-6">
									<input type="checkbox" value="직접입력" id="etc-selectDeveloper">기타
								</div>
							</div>
					</div>
					<br><br>
					<div class="form-group">
							<label class="col-md-3 control-label">개발 가능 언어 : </label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="myDeveloper-skill"
									id="myDeveloper-skill" placeholder="Tool을 선택해주세요." disabled="disabled">
							</div>
					</div>
					<br><br>
					<div class="form-group">
						<label class="col-md-3 control-label">숙련도 : </label>
						<div class="col-md-9">
							<c:forEach var ="rank" items="${requestScope.rankcategory}">
							<c:if test="${rank.skill_rank_code !='sr1' }">
							<div class ="col-md-3"><input type="radio" name="training-language" class="proficiency-tool" value="${rank.skill_rank_code }">${rank.skill_rank_name }</div>
							</c:if>
							</c:forEach>
						</div>
					</div>					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="developer-tool-save">저장</button>
					<button type="button" class="btn btn-default" id="developer-tool-cancel" data-dismiss="modal">취소</button>
				</div>
			</div>
		</div>
	</div>
<!-- end Modal -->