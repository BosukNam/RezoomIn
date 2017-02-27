<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Modal -->
	<div class="modal fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true" id="language-modal">
		<input type="hidden" class="" id="hidden-language-modal" value="">
		<input type="hidden" id="hidden-language-registerNo" value="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">보유 기술 언어</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
							<label class="col-md-3 control-label">언어 선택 : </label>
							<div>
							<div class="col-md-2">
								<select name="Language" id="language-select" size=1>
									<option value="0">언어 선택</option>
									<option value="java">Java</option>
									<option value="C">C</option>
									<option value="jsp">Jsp</option>
									<option value="jstl">Jstl</option>
									<option value="jquery">Jquery</option>
									<option value="C++">C++</option>
									<option value="C#">C#</option>
									<option value="asp">asp</option>
									<option value="php">php</option>
									<option value="html">html</option>
									
								</select>
							</div>
							<div class="col-md-2">
								<select name="Database" id="database-select" size=1>
									<option value="0">DB 선택</option>
									<option value="ms-sql">ms-sql</option>
									<option value="oracle">oracle</option>
									<option value="mysql">mysql</option>
									<option value="db2">db2</option>
									<option value="altibase">altibase</option>
								</select>
							</div>
							<div class="col-md-2">
								<select name="OS" id="os-select" size=1>
									<option value="0">OS 선택</option>
									<option value="linux">linux</option>
									<option value="aix">aix</option>
									<option value="unix">unix</option>
									<option value="windows">windows</option>
								</select>
							</div>
							<div class="col-md-2">
								<input type="checkbox" value="직접입력" id="etc-selectLanguage">기타
							</div>
							
					</div>
					<br><br>
					<div class="form-group">
							<label class="col-md-3 control-label">개발 가능 언어 : </label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="myLanguage-skill"
									id="myLanguage-skill" placeholder="언어를 선택해주세요." disabled="disabled">
							</div>
					</div>
					<br><br>
					<div class="form-group">
						<label class="col-md-3 control-label">숙련도 : </label>
						<div class ="col-md-9">
							<c:forEach var ="rank" items="${requestScope.rankcategory}">
							<div class ="col-md-3"><input type="radio" name="training-language" class="proficiency-language" value="${rank.skill_rank_code}">${rank.skill_rank_name }</div>
							</c:forEach>
						</div>
					</div>					
				</div>
				<br><br>
				<div class="modal-footer">
				
					<button type="button" class="btn btn-primary" id="language-skill-save">저장</button>
					<button type="button" class="btn btn-default" id="language-skill-cancel" data-dismiss="modal">취소</button>
					
				</div>
			</div>
			
		</div>
	</div>
</div>
<!-- End modal -->	