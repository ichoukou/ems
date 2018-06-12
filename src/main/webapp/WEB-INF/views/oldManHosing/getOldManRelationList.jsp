<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Modal -->
<style>
.modal-body .row label {
	line-height: 30px;
}

.row {
	margin-bottom: 5px;
}
</style>
<form  class="form-horizontal notprint">
	<div class="modal fade" id="relationList" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true" style="overflow-y: auto;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">老人亲属列表</h4>
				</div>
				<div class="modal-body" id="test">
					<div>
						<span>
							<label id="nocheck"></label>
						</span>
						<!-- 根据老人id查询亲属信息 -->
						<input type="hidden" id="fQueryId"/>
					</div>
					<table id="tb_relation"></table>
					<!-- 控制修改 -->					
				</div>
				<div class="modal-footer">
				<button id="queryRel_btn" type="button" class="btn btn-default" data-toggle="modal" data-target="#relationUpd"  style="display:none">
					</button>
					<button type="button" class="btn btn-primary"  id="updateRelButton"
						onclick="updateRel()">修改</button>
					<button id="add_close_btn" type="button" class="btn btn-primary"
						data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
</form>
