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
<form id="ts_form_validate" class="form-horizontal notprint">
	<div class="modal fade" id="transferModal" tabindex="-1" role="dialog"
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
						<label for="outAccount" class="col-sm-2 control-label">转出账户</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" readonly="readonly" style="background-color: #FFFFFF;border: thin;" id="outAccount" name="outAccount"/>
						</div>
						<label for="restAmount" class="col-sm-2 control-label">可转金额</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" readonly="readonly" style="background-color: #FFFFFF;border: thin;"  id="restAmount" name="restAmount">
						</div>
					</div>
					<div class="form-group row">
						<label for="outAmount" class="col-sm-2 control-label">转账金额</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="outAmount" name="outAmount">
						</div>
						<label for="inAccount" class="col-sm-2 control-label">转入账户</label>
						<div class="col-sm-4">
							<select class="form-control" id="inAccount"
								name="inAccount">
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label for="fDate" class="col-sm-2 control-label">转账日期</label>
						<div class="col-sm-4">
                    		<input	onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'nowtime\')}',readOnly:true})" type="text"  class="form-control" name="fDate" id="fDate">
						</div>
						<label for="ts_fKeeper" class="col-sm-2 control-label">经手人</label>
						<div class="col-sm-4">
							<select class="form-control" id="ts_fKeeper"
								name="ts_fKeeper">
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label for="fRemarks" class="col-sm-2 control-label">转账备注</label>
						<div class="col-sm-10">
						<textarea class="form-control" name="fRemarks" id="fRemarks" rows="3"></textarea>
						</div> 
					</div>
					<div class="form-group row">
						<div class="col-sm-2">
                    		<input type="text" class="form-control" style="visibility: hidden;"  id="fOutId" name="fOutId">
						</div>
						<div class="col-sm-2">
							<input type="text" class="form-control"  style="visibility: hidden" name="nowtime" id="nowtime"/>
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