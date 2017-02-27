<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html5>
<!-- Modal -->
	<div class="modal fade" id="searchDetail_modal" tabindex="-1" role="dialog"
		aria-labelledby="searchDetail_modal_label" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content"  style="width:1000px; max-height:5000px;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="searchDetail_modal_label">상세보기</h3>
				</div>
				<div class="modal-body">
	<div role="tabpanel">

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#resume_tab" aria-controls="resume" role="tab" data-toggle="tab">이력서</a></li>
    <li role="presentation"><a href="#introduce_tab" aria-controls="introduce" role="tab" data-toggle="tab">자기소개서</a></li>
    <li role="presentation"><a href="#portfolio_tab" aria-controls="portfolio" role="tab" data-toggle="tab">포트폴리오</a></li>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="resume_tab" style="margin-top:20px">
    	<jsp:include page="resume3.jsp"/>
    	<br>
    	<div id="buttons" align="center">
	<button type="button" class="btn btn-primary" id="btResumePDFsave">PDF저장</button>
	<button type="button" class="btn btn-primary" id="btPrintResumePage">인쇄</button>
	<button type="button" class="btn btn-default"  data-dismiss="modal" aria-label="Close">닫기</button>
	<br>
</div>
    </div>
    
    <div role="tabpanel" class="tab-pane" id="introduce_tab">
    	<jsp:include page="showIntroduce2-1.jsp"/>
    	<br>
    	<div id="buttons" align="center">
	<button type="button" class="btn btn-primary" id="btIntroducePDFsave">PDF저장</button>
	<button type="button" class="btn btn-primary" id="btPrintIntroducePage">인쇄</button>
	<button type="button" class="btn btn-default"  data-dismiss="modal" aria-label="Close">닫기</button>
	<br>
    </div>
     </div>
    <div role="tabpanel" class="tab-pane" id="portfolio_tab">
    	<jsp:include page="showPortfolio.jsp"/>
    포트폴리오<br>
    <div id="buttons" align="center">
	<button type="button" class="btn btn-primary" id="">PDF저장</button>
	<button type="button" class="btn btn-primary" id="">인쇄</button>
	<button type="button" class="btn btn-default"  data-dismiss="modal" aria-label="Close">닫기</button>
	<br>
    </div>
    </div>

 </div>

</div>
				</div>
				<div class="modal-footer">
					<!-- <button type="button" class="btn btn-primary" id="save-pdf-btn">PDF저장</button>
					<button type="button" class="btn btn-primary" id="save-image-btn">이미지저장</button>
					<button type="button" class="btn btn-primary" id="print-btn">인쇄</button> -->
				</div>
			</div>
		</div>
</div>
