<%--
  Created by IntelliJ IDEA.
  User: zhangxin
  Date: 2017/3/3
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" id="modal">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">实收费用明细</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="pay_id">
                    <div class="form-group row">
                        <label for="updateOldManName" class="col-sm-3 control-label">老人姓名：</label>
                        <div class="col-sm-3">
                            <input class="form-control" id="updateOldManName"name="updateOldManName">
                        </div>
                        <label for="updateDuringTime" class="col-sm-2 control-label">期间：</label>
                        <div class="col-sm-3">
                            <input class="form-control" id="updateDuringTime"name="updateDuringTime">
                        </div>
                </div>
                    <div>
                        <table id="incomeDetail"  class="table table-bordered" style="border:solid 2px #1AB394; ">
                            <thead style="font-size: 18px;font-weight: bold;">
                                <td width="107px;">序号</td><td width="107px;">单据号</td>
                                <td width="107px;">应收金额</td><td width="107px;">实收金额</td>
                                <td width="107px;">余额</td>
                            </thead>
                            <tbody id="oldManList" style="font-size: 14px;">

                            </tbody>
                        </table>
                    </div>
                <div class="modal-footer">
                    <button id="update_close_btn" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
        </div>
    </div>
</form>
