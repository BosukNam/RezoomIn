<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Modal -->
<div class="modal fade" id="chart-modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h3 class="modal-title" id="myModalLabel">차트</h3>
				</div>
				<div class="modal-body">
					<div class="panel panel-default">
						<div class="panel-heading">
							<img src="http://image.flaticon.com/icons/svg/189/189057.svg" alt="" width="20px" height="20px" id="barchart">
							<img src="http://image.flaticon.com/icons/svg/138/138343.svg" alt="" width="20px" height="20px" id="piechart">
							<img src="http://image.flaticon.com/icons/svg/252/252034.svg" alt="" width="20px" height="20px" id="linechart">
						</div>
						<div class="panel-body">
							<div style="height:550px">
								<div class="col-md-12"><canvas id="myChart" width="400px" height="225px"></canvas></div>
								<form action="." method="post" id="chart-form">
								<table class="table table-bordered">
									<tbody>
										<tr>
											<th><input type="text" class="form-control chart-category"  name="item" value="항목"></th>
											<td><input type="text" class="form-control chart-data" name="data" value="1" ></td>
										</tr>	
										<tr>
											<th><input type="text" class="form-control chart-category"  name="item" value="항목"></th>
											<td><input type="text" class="form-control chart-data" name="data" value="2"></td>
										</tr>
										<tr>
											<th><input type="text" class="form-control chart-category"  name="item" value="항목"></th>
											<td><input type="text" class="form-control chart-data" name="data" value="3"></td>
										</tr>
										<tr>
											<th><input type="text" class="form-control chart-category" name="item" value="항목"></th>
											<td><input type="text" class="form-control chart-data" name="data" value="4"></td>
										</tr>
										<tr>
											<th><input type="text" class="form-control chart-category" name="item" value="항목"></th>
											<td><input type="text" class="form-control chart-data" name="data" value="5"></td>
										</tr>
									</tbody>
								</table>
								</form>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" id="chart-cancel">삭제</button>
					<button type="button" class="btn btn-primary" id="chart-save">저장</button>
				</div>
			</div>
		</div>
	</div>
	
<!-- End modal -->