<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<style>
    .popover-content{
        padding-bottom: 14px;
        padding-top: 14px;
    }
    tr {
        padding-bottom: 14px;
        padding-top: 14px;
    }
    td {
        vertical-align: middle;
        padding-bottom: 7px;
        font-size: 14px;
    }
    table {
        max-width: 100%;
        background-color: transparent;
        border-collapse: collapse;
        border-spacing: 0;
    }
</style>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="width: 800px">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">更新数据</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="Leave_id">
                    <div class="form-group row">
                        <label for="updateFStaffName" class="col-sm-2 control-label">员工姓名</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="updateFStaffName"name="updateFStaffName">

                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="updateFStartTime" class="col-sm-2 control-label">请假日期</label>
                        <div class="col-sm-4">
                            <input onblur="update_FStartTime()" class="form-control" type="text" id="updateFStartTime" onFocus="WdatePicker({readOnly:true,maxDate:'#F{$dp.$D(\'addFStopTime\')}'})">
                            <label id="update_FStartTime_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                        </div>

                        <label for="updateFStopTime" class="col-sm-2 control-label">销假日期</label>
                        <div class="col-sm-4">
                            <input onblur="update_FStopTime()" class="form-control" type="text" id="updateFStopTime" onFocus="WdatePicker({readOnly:true,minDate:'#F{$dp.$D(\'addFStartTime\')}'})">
                            <label id="update_FStopTime_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="updateFLeaveReason" class="col-sm-2 control-label">请假事由</label>
                        <div class="col-sm-4">
                            <textarea style="resize:none;" class="form-control" name="updateFLeaveReason" id="updateFLeaveReason" placeholder="请假事由"></textarea>
                        </div>
                        <label for="updateFExplain" class="col-sm-2 control-label">说明</label>
                        <div class="col-sm-4">
                            <textarea style="resize:none;" class="form-control" name="updateFExplain" id="updateFExplain" placeholder="说明"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <span class=" control-label" id="up_time_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                    <button id="update_close_btn" type="button" class="btn btn-default" data-dismiss="modal" onclick="closeModal()">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="updateLeave()">保存</button>
                </div>
            </div>
        </div>

    </div>
</form>