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
	<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">事故修改</h4>
				</div>
				<div class="modal-body">
					<div class="form-group row">
						<label for="up_oldManId" class="col-sm-2 control-label">老人</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="up_oldManId" name="up_oldManId" readonly="readonly">
						</div>
						<label  class="col-sm-3 control-label" id="up_errorName"></label>
					</div>
					<div class="form-group row">
						<label for="up_recordType" class="col-sm-2 control-label">事故类型</label>
						<div class="col-sm-4">
							<select class="form-control" id="up_recordType"
								name="up_recordType">
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label for="up_fKeeper" class="col-sm-2 control-label">责任人</label>
						<div class="col-sm-4">
							<select class="form-control" id="up_fKeeper"
								name="up_fKeeper">
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label for="up_fRecordDate" class="col-sm-2 control-label">事故时间</label>
						<div class="col-sm-4">
							<input type="text" id="up_fRecordDate" name="up_fRecordDate" height="30px" class="Wdate" readonly="readonly"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}',lang:'en'})" />
						</div>
						<label  class="col-sm-3 control-label" id="up_errorDate"></label>
					</div>
					<div class="form-group row">
						<label for="up_fExplain" class="col-sm-2 control-label">事故原因
						</label>
						<div class="col-sm-6">
							<textarea class="form-control" rows="5" style="resize: none;"
								name="up_fExplain" id="up_fExplain"></textarea>
						</div>
						<label  class="col-sm-3 control-label" id="up_errorReason"></label>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-sm-2">
						<input type="text" hidden="" class="form-search" name="up_fID"
							id="up_fID" />
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary"  id="up_Button" data-dismiss="modal" onclick="updateRecord()">保存</button>
					<button id="uddate_close_btn" type="button" class="btn btn-primary" data-dismiss="modal"
						 onclick="clearInput()">关闭</button>
				</div>
			</div>
		</div>
	</div>
</form>