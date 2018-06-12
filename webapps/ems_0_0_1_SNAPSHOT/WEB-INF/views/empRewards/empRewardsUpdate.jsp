<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<style>
    .modal-content{
        background-color:#F0F0F0;
    }
</style>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" id="modal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">更新奖惩</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="Rewards_id">
                    <div class="form-group row">
                        <label for="updateFStaffName" class="col-sm-2 control-label">员工姓名</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="updateFStaffName"name="updateFStaffName">
                            </select>
                            <label id="update_FStaffName_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                        </div>
                        <label for="updateFRewardDate" class="col-sm-2 control-label">日期</label>
                        <div class="col-sm-4">
                            <input class="form-control" onblur="update_FRewardDate()" onFocus="WdatePicker({readOnly:true,maxDate:new Date()})" type="text" id="updateFRewardDate">
                            <label id="update_FRewardDate_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="updateFRewardType" class="col-sm-2 control-label">奖惩类型</label>
                        <div class="col-sm-4">
                            <select onblur="update_FRewardType()" class="form-control" id="updateFRewardType"name="updateFRewardType">
                            </select>
                            <label id="update_FRewardType_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                        </div>
                        <label for="updateFRewardMoney" class="col-sm-2 control-label">金额</label>
                        <div class="col-sm-4">
                            <input onblur="update_FRewardMoney()" class="form-control" type="text" id="updateFRewardMoney">
                            <label id="update_FRewardMoney_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="updateFRewardReason" class="col-sm-2 control-label">奖惩原因</label>
                        <div class="col-sm-4">
                            <textarea style="resize:none;" class="form-control" name="updateFRewardReason" id="updateFRewardReason" placeholder="奖惩原因"></textarea>
                        </div>
                        <label for="updateFExplain" class="col-sm-2 control-label">说明</label>
                        <div class="col-sm-4">
                            <textarea style="resize:none;" class="form-control" name="updateFExplain" id="updateFExplain" placeholder="说明"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button id="update_close_btn" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="updateRewards()">保存</button>
                </div>
            </div>
        </div>

    </div>
</form>