<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<style>
    .modal-content{
        background-color:#F0F0F0;
    }
</style>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" id="modal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">新增奖惩</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group row">
                        <label for="addFStaffName" class="col-sm-2 control-label">员工姓名</label>
                        <div class="col-sm-4">
                            <select onblur="add_FStaffName()" class="form-control" id="addFStaffName"name="addFStaffName">
                            </select>
                            <label id="add_FStaffName_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                        </div>
                        <label for="addFRewardDate" class="col-sm-2 control-label">日期</label>
                        <div class="col-sm-4">
                            <input class="form-control" onblur="add_FRewardDate()" onFocus="WdatePicker({readOnly:true,maxDate:new Date()})" type="text" id="addFRewardDate">
                            <label id="add_FRewardDate_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="addFRewardType" class="col-sm-2 control-label">奖惩类型</label>
                        <div class="col-sm-4">
                            <select onblur="add_FRewardType()" class="form-control" id="addFRewardType"name="addFRewardType">
                            </select>
                            <label id="add_FRewardType_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                        </div>
                        <label for="addFRewardMoney" class="col-sm-2 control-label">金额</label>
                        <div class="col-sm-4">
                            <input onblur="add_FRewardMoney()" class="form-control" type="text" id="addFRewardMoney">
                            <label id="add_FRewardMoney_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="addFRewardReason" class="col-sm-2 control-label">奖惩原因</label>
                        <div class="col-sm-4">
                            <textarea style="resize:none;" class="form-control" name="addFRewardReason" id="addFRewardReason" placeholder="奖惩原因"></textarea>
                        </div>
                        <label for="addFExplain" class="col-sm-2 control-label">说明</label>
                        <div class="col-sm-4">
                            <textarea style="resize:none;" class="form-control" name="addFExplain" id="addFExplain" placeholder="说明"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button id="add_close_btn" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="addRewards()">保存</button>
                </div>
            </div>
        </div>

    </div>
</form>