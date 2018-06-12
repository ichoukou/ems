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
<form class="form-horizontal notprint" id="del_form_validate" >
	<div class="modal fade" id="fundAccountBillDel" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">删除账户明细信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-group row">
						<label class="control-label col-sm-2" for="del_fInAmount">收入金额</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="del_fInAmount" id="del_fInAmount" readonly="readonly"/>
						</div>
						<label class="control-label col-sm-2" for="del_fInnumber">单号</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" name="del_fInnumber" id="del_fInnumber" readonly="readonly"/>
						</div>
						</div>
					<div class="form-group row">
						<label class="control-label col-sm-2 " for="del_fInDate">收账日期</label>
						<div class="col-sm-4 ">
							<input class="form-control" style="width: 166px;" placeholder="点击选择时间"
								onFocus="WdatePicker({readOnly:true})"
								type="text" class="form-control" id="del_fInDate"
								name="del_fInDate">
						</div>
						<label class="control-label col-sm-2 " for="del_fInPayments">收入杂项</label>
						<div class="col-sm-4 ">
							<select class="form-control" name="del_fInPayments"
								id="del_fInPayments"  disabled="disabled">
							</select>
						</div>
					</div>
					<div class="form-group row">
						<label class="control-label col-sm-2" for="del_fInFundaccount">记入账户</label>
						<div class="col-sm-4">
							<select class="form-control" name="del_fInFundaccount"
								id="del_fInFundaccount" disabled="disabled">
							</select>
						</div>
						<label class="control-label col-sm-2" for="del_fInBusinessitem">业务项目</label>
						<div class="col-sm-4">
						<select class="form-control" name="del_fInBusinessitem"
								id="del_fInBusinessitem" disabled="disabled">
							</select>
						</div>
					</div>
					<div class="form-group row">	
						<label class="control-label col-sm-2" for="up_fInOperator">经手人</label>
						<div class="col-sm-4">
							<select class="form-control" name="del_fInOperator"
								id="del_fInOperator" disabled="disabled">
							</select>
						</div>
						<label class="control-label col-sm-2" for="del_fInPayment">支付人</label>
						<div class="col-sm-4">
						<input type="text" class="form-control" name="del_fInPayment" id="del_fInPayment" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group row">
					 <label class="control-label col-sm-2" for="up_fInProofdoc">凭据编号</label>
						<div class="col-sm-4">
						<input type="text" class="form-control" name="up_fInProonum" id="del_fInProonum" readonly="readonly"/>
						</div>
						<label class="control-label col-sm-2" for="del_fInProofdoc">凭据文件</label>
						<div class="col-sm-4">
						<input type="file" class="form-control" name="del_fInProofdoc" id="del_fInProofdoc" readonly="readonly"/>
						</div>
					</div>
					<div class="form-group row">
					<label for="up_fInRemarks" class="control-label col-sm-2">记账说明
					</label>
						<div class="col-sm-8">
							<textarea class="form-control" rows="3" style="resize: none;"
								name="del_fInRemarks" id="del_fInRemarks" readonly="readonly"></textarea>
						</div>
						<div class="col-sm-1">
						<input type="text" class="form-control" style="visibility:hidden;" name="del_fId" id="del_fId"/>
						</div>
					</div>
					<div class="form-group row">
					<label for="del_fInRemarks" class="control-label col-sm-2">删除说明
					</label>
						<div class="col-sm-8">
							<textarea class="form-control" rows="3" style="resize: none;"
								name="del_fUpRemarks" id="del_fUpRemarks"></textarea>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-3" style="text-align:center;">
                    	</div>
					</div>
				</div>
				<div class="modal-footer">
					 <button type="submit" style="margin-left: 30px"  class="btn btn-primary">删除</button>
					<button id="del_close_btn" type="button" class="btn btn-primary"
						data-dismiss="modal" >关闭</button>
				</div>
			</div>
		</div>
	</div>
</form>