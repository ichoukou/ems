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
<form class="form-horizontal notprint" id="form_validate" >
	<div class="modal fade" id="fundAccountBillUpd" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改账户明细信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-group row">
						<label class="control-label col-sm-2" for="up_fInAmount">收入金额</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="up_fInAmount" id="up_fInAmount"/>
						</div>
						<label class="control-label col-sm-2" for="up_fInnumber">单号</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="up_fInnumber" id="up_fInnumber" readonly="readonly"/>
						</div>
						</div>
					<div class="form-group row">
						<label class="control-label col-sm-2 " for="up_fInDate">收账日期</label>
						<div class="col-sm-4 ">
							<input class="form-control" style="width: 166px;" placeholder="点击选择时间"
								onFocus="WdatePicker({readOnly:true})"
								type="text" class="form-control" id="up_fInDate"
								name="up_fInDate">
						</div>
						<label class="control-label col-sm-2 " for="up_fInPayments">收入杂项</label>
						<div class="col-sm-4 ">
							<select class="form-control" name="up_fInPayments"
								id="up_fInPayments">
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-sm-2" for="up_fInFundaccount">记入账户</label>
						<div class="col-sm-4">
							<select class="form-control" name="up_fInFundaccount"
								id="up_fInFundaccount">
							</select>
						</div>
						<label class="control-label col-sm-2" for="up_fInBusinessitem">业务项目</label>
						<div class="col-sm-4">
						<select class="form-control" name="up_fInBusinessitem"
								id="up_fInBusinessitem">
							</select>
						</div>
					</div>
					<div class="form-group row">	
						<label class="control-label col-sm-2" for="up_fInOperator">经手人</label>
						<div class="col-sm-4">
							<select class="form-control" name="up_fInOperator"
								id="up_fInOperator">
							</select>
						</div>
						<label class="control-label col-sm-2" for="up_fInPayment">支付人</label>
						<div class="col-sm-4">
						<input type="text" class="form-control" name="up_fInPayment" id="up_fInPayment"/>
						</div>
					</div>
					<div class="form-group row">
					 <label class="control-label col-sm-2" for="up_fInProofdoc">凭据编号</label>
						<div class="col-sm-4">
						<input type="text" class="form-control" name="up_fInProonum" id="up_fInProonum" readonly="readonly"/>
						</div>
						<label class="control-label col-sm-2" for="up_fInProofdoc">凭据文件</label>
						<div class="col-sm-4">
						<input type="file" class="form-control" name="up_fInProofdoc" id="up_fInProofdoc"/>
						</div>
					</div>
					<div class="form-group row">
					<label for="up_fInRemarks" class="control-label col-sm-2">记账说明
					</label>
						<div class="col-sm-8">
							<textarea class="form-control" rows="3" style="resize: none;"
								name="up_fInRemarks" id="up_fInRemarks"></textarea>
						</div>
						<div class="col-sm-1">
						<input type="text" class="form-control" style="visibility: visible;" name="up_fId" id="up_fId"/>
						</div>
					</div>
					<div class="form-group row">
					<label for="up_fInRemarks" class="control-label col-sm-2">修改说明
					</label>
						<div class="col-sm-8">
							<textarea class="form-control" rows="3" style="resize: none;"
								name="up_fUpRemarks" id="up_fUpRemarks"></textarea>
						</div>
						<div class="col-sm-1">
							<input type="text" class="form-control" hidden="hidden" name="restAmount" id="restAmount"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-3" style="text-align:center;">
                    	</div>
					</div>
				</div>
				<div class="modal-footer">
					 <button type="submit" style="margin-left: 30px" id="btn_query" class="btn btn-primary">保存</button>
					<button id="add_close_btn" type="button" class="btn btn-primary"
						data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
</form>