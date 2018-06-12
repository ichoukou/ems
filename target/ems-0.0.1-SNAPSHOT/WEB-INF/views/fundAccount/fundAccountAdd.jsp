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
<form id="form_validate" class="form-horizontal notprint">
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">创建账户</h4>
				</div>
				<div class="modal-body">
					<div class="form-group row">
						<label for="fname" class="col-sm-2 control-label">账户名称</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fname" name="fname">
						</div>
						<label for="fNumber" class="col-sm-2 control-label">账户号</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="fNumber" name="fNumber">
						</div>
					</div>
					<div class="form-group row">
						<label for="fAmount" class="col-sm-2 control-label">期初金额</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="fAmount" name="fAmount">
						</div>
						<label for="fKeeper" class="col-sm-2 control-label">负责人</label>
						<div class="col-sm-4">
							<select class="form-control" id="fKeeper"
								name="fKeeper">
							</select>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary"  id="addButton">保存</button>
					<button id="add_close_btn" type="button" class="btn btn-primary" data-dismiss="modal"
						 onclick="clearInput()">关闭</button>
				</div>
			</div>
		</div>
	</div>
</form>