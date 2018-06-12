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
<form id="up_form_validate" class="form-horizontal notprint">
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改账户</h4>
				</div>
				<div class="modal-body">
					<div class="form-group row">
						<label for="up_fname" class="col-sm-2 control-label">账户名称</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="up_fname" name="up_fname">
						</div>
						<label for="up_fNumber" class="col-sm-2 control-label">账户号</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="up_fNumber" name="up_fNumber">
						</div>
					</div>
					<div class="form-group row">
						<label for="up_fAmount" class="col-sm-2 control-label">期初金额</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="up_fAmount" name="up_fAmount">
						</div>
						<label for="up_fKeeper" class="col-sm-2 control-label">负责人</label>
						<div class="col-sm-4">
							<select class="form-control" id="up_fKeeper"
								name="up_fKeeper">
							</select>
						</div>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-2">
						<input type="text" hidden="" class="form-search" name="up_fId"
							id="up_fId" />
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