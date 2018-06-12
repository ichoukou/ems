<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2017/1/6
  Time: 20:33
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
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">
                        <span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">老人销假</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="data_id">
                    <input type="hidden" value="dsaf444" id="updfNumber">
                    <input type="hidden" value="4" id="updfNursinghomeID">
                    <input type="hidden" value="33" id="updfCreatorID">
                    <input type="hidden" value="2017-01-06" id="updfCreateTime">
                    <div class="form-group row">
                        <label class="col-sm-2 control-label">老人</label>
                        <div class="col-sm-4">
                            <input type="hidden" id="updfOldManID"/>
                            <input type="text" class="form-control" id="updoldManName" name="updoldManName" readonly="readonly">
                        </div>
                        <%--<label  class="col-sm-3 control-label" id="errorName"></label>--%>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-label">状态</label>
                        <div class="col-sm-4">
                            <input class="form-control" type="text" value="请假" id="updfLeaveStatus"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-label">请假日期</label>
                        <div class="col-sm-4">
                            <input  class="form-control"  readonly="readonly" type="text" id="updfStartTime" placeholder="必填项">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-label">销假日期</label>
                        <div class="col-sm-4">
                            <input onblur="check_updLeave()" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" class="form-control" type="text" id="updfStopTime">
                            <label id="errorUpdTime" style="color: red" >&nbsp;&nbsp;&nbsp;</label>
                        </div>
                        <%--<label  class="col-sm-3 control-label" id="errorDate"></label>--%>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 control-label">说明
                        </label>
                        <div class="col-sm-6">
							<textarea class="form-control" rows="5" style="resize: none;"
                                      name="fExplain" id="updfExplain"></textarea>
                        </div>
                        <label  class="col-sm-3 control-label" id="errorReason"></label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary"  id="addButton" onclick="updOldManLeave()">保存</button>
                    <button id="add_close_btn" type="button" class="btn btn-primary"
                            onclick="closeModal()">关闭</button>
                </div>
            </div>
        </div>
    </div>
</form>