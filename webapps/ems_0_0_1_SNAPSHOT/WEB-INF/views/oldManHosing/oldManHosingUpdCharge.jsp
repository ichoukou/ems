<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2016/12/15
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="updChargeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

        <div class="modal-dialog" style="width: 950px">
            <div class="modal-content" style="height: 540px">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">老人费用修改</h4>
                </div>

                <div class="modal-body">
                    <input type="hidden" id="oldManId_selected">
                    <input type="hidden" id="oldManName_selected">
                    <div id="">
                        <div class="col-xs-5">
                            <div style="text-align: center;font-size: 20px;">待选费用</div>
                            <select name="from" id="sel1" class="form-control" size="13"
                                    multiple="multiple">

                            </select>
                        </div>

                        <div class="col-xs-2" style="padding-top: 60px;">

                            <%--<button type="hidden" id="undo_redo_rightAll"--%>
                                    <%--class="btn btn-default btn-block">--%>
                                <%--<i class="glyphicon glyphicon-forward"></i>--%>
                            <%--</button>--%>
                            <button type="button" id="btn1"
                                    class="btn btn-default btn-block">
                                <i class="glyphicon glyphicon-chevron-right"></i>
                            </button>
                            <button type="button" id="btn2"
                                    class="btn btn-default btn-block">
                                <i class="glyphicon glyphicon-chevron-left"></i>
                            </button>
                            <%--<button type="hidden" id="undo_redo_leftAll"--%>
                                    <%--class="btn btn-default btn-block">--%>
                                <%--<i class="glyphicon glyphicon-backward"></i>--%>
                            <%--</button>--%>

                        </div>

                        <div class="col-xs-5">
                            <div style="text-align: center;font-size: 20px;">已选费用</div>
                            <select name="to" id="sel2" class="form-control"
                                    size="13" multiple="multiple"></select>
                        </div>

                        <div class="col-xs-2">
                        </div>
                        <div class="col-xs-2">
                            <button class="btn btn-warning btn-block" id="b2" onclick="updChargeStatus_upd(this.value,false)" value="0">停止已选费用</button>
                        </div>

                        <div class="col-xs-4">
                            <%--总费用：<input type="text" id="totalCost2">--%>
                        </div>

                        <div class="col-xs-2">
                            <button class="btn btn-primary btn-block" id="b1" onclick="updChargeStatus_upd(this.value,true)" value="1">保存已选费用</button>
                        </div>
                    </div>
                </div>

            </div>
        </div>

    </div>
</form>