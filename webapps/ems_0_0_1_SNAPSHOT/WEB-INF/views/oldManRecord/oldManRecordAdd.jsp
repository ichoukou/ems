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
					<h4 class="modal-title" id="myModalLabel">新增事故</h4>
				</div>
				<div class="modal-body">
					<div class="form-group row">
						<label for="oldManId" class="col-sm-2 control-label">老人</label>
						<div class="col-sm-4">
                            <input type="hidden" id="addfOldManID"/>
                            <input onclick="selectOldMan()" type="text" class="form-control"  placeholder="单击选择老人" id="oldManName" name="oldManName">
                        </div>
						<label  class="col-sm-3 control-label" id="errorName"></label>
					</div>
					<div class="form-group row">
						<label for="recordType" class="col-sm-2 control-label">事故类型</label>
						<div class="col-sm-4">
							<select class="form-control" id="recordType"
								name="recordType">
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label for="fKeeper" class="col-sm-2 control-label">责任人</label>
						<div class="col-sm-4">
							<select class="form-control" id="fKeeper"
								name="fKeeper">
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label for="fRecordDate" class="col-sm-2 control-label">事故时间</label>
						<div class="col-sm-4">
							<input type="text" id="fRecordDate" name="fRecordDate" height="30px" class="Wdate" readonly="readonly"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}',lang:'en'})" />
						</div>
						<label  class="col-sm-3 control-label" id="errorDate"></label>
					</div>
					<div class="form-group row">
						<label for="fExplain" class="col-sm-2 control-label">事故原因
						</label>
						<div class="col-sm-6">
							<textarea class="form-control" rows="5" style="resize: none;"
								name="fExplain" id="fExplain"></textarea>
						</div>
						<label  class="col-sm-3 control-label" id="errorReason"></label>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary"  id="addButton"  onclick="add()">保存</button>
					<button id="add_close_btn" type="button" class="btn btn-primary" data-dismiss="modal"
						 onclick="clearInput()">关闭</button>
				</div>
			</div>
		</div>
	</div>
</form>