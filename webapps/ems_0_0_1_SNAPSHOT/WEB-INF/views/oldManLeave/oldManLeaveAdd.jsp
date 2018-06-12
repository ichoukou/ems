<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2016/12/29
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
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
    <div class="modal fade" id="addLeaveModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">老人请假</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group row">
                        <label class="col-sm-2 control-label">老人</label>
                        <div class="col-sm-4">
                            <input type="hidden" id="addOldManLeaveID"/>
                            <input onclick="selectOldMan()" type="text" class="form-control" id="oldManLeaveName" name="oldManName">
                        </div>
                        <label class="col-sm-3 control-label" id="errorOldManName" style="color: red" >&nbsp;&nbsp;&nbsp;</label>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-label">状态</label>
                        <div class="col-sm-4">
                            <input class="form-control" type="text" value="请假" id="fLeaveStatus"/>
                        </div>
                        <%--<label class="col-sm-3 control-label" id="errorExplain" style="color: red" >&nbsp;&nbsp;&nbsp;</label>--%>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-label">报假日期</label>
                        <div class="col-sm-4">
                            <input onblur="addCheck_startTime_leave()" class="form-control" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" type="text" id="addfStartTime">
                        </div>
                        <label class="col-sm-3 control-label" id="errorStartTime" style="color: red" >&nbsp;&nbsp;&nbsp;</label>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-label">销假日期</label>
                        <div class="col-sm-4">
                            <input value="保存以后再销假" class="form-control" type="text" id="fStopTime" readonly="readonly">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="fExplain" class="col-sm-2 control-label">说明
                        </label>
                        <div class="col-sm-6">
							<textarea class="form-control" rows="5" style="resize: none;"
                                      name="fExplain" id="fExplain"></textarea>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary"  id="addButton" onclick="addOldManLeave()">保存</button>
                    <button id="add_close_btn" type="button" class="btn btn-primary" onclick="closeModal()">关闭</button>
                </div>
            </div>
        </div>
    </div>
</form>