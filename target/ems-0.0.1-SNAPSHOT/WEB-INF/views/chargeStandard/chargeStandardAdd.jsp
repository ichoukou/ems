<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2016/12/1
  Time: 14:38
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
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="width: 950px">
            <div class="modal-content" style="height: 540px">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">新增费用项目</h4>
                </div>
                
                
                
                
                <div class="modal-body">

                        <div class="form-group row">
                            <label for="addChrgeNumber" class="col-sm-2 control-label">费用编码</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="addChrgeNumber" readonly="readonly" name="addChrgeNumber">
                            </div>

                            <label for="addChrgeName" class="col-sm-2 control-label">费用名称</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="addChrgeName" name="addChrgeName">
                                <%--<label id="add_ChrgeName" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>--%>
                            </div>
                        </div>


                    <div class="form-group row">
                        <label for="addPrice" class="col-sm-2 control-label">费用价格</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="addPrice" name="addPrice" placeholder="price">
                        </div>

                        <label id="aUnit" class="col-sm-2 control-label" value="单位">单位</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="addUnit" name="addUnit">

                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="addChrgeType" class="col-sm-2 control-label" id="ChrgeType" value="费用类型">费用类型</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="addChrgeType" name="addChrgeType">

                            </select>
                        </div>

                        <label id="aChargeCycle" class="col-sm-2 control-label" value="费用周期">费用周期</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="addChargeCycle" name="addChargeCycle">

                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label id="aNursingLevel" class="col-sm-2 control-label" value="项目等级">项目等级</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="addNursingLevel" name="addNursingLevel">

                            </select>
                        </div>

                        <%--<label id="aValue" class="col-sm-2 control-label" value="分值">分值</label>--%>
                        <%--<div class="col-sm-4">--%>
                            <%--<select class="form-control" id="addValue" name="addValue">--%>

                            <%--</select>--%>
                        <%--</div>--%>
                    </div>

                    <div class="form-group row">
                        <label for="addChrgeStartDate" class="col-sm-2 control-label">阶段费用开始时间</label>
                        <div class="col-sm-4">
                            <input onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" type="text" class="form-control" id="addChrgeStartDate" name="addChrgeStartDate">
                        </div>

                            <label for="addChrgeStopDate" class="col-sm-2 control-label">阶段费用结束时间</label>
                        <div class="col-sm-4">
                            <input onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" type="text" class="form-control" id="addChrgeStopDate" name="addChrgeStopDate">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="addValidityStartDate" class="col-sm-2 control-label">费用有效期开始时间</label>
                        <div class="col-sm-4">
                            <input onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" type="text" class="form-control" id="addValidityStartDate" name="addValidityStartDate">
                        </div>

                        <label for="addValidityEndDate" class="col-sm-2 control-label">费用有效期结束时间</label>
                        <div class="col-sm-4">
                            <input onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" type="text" class="form-control" id="addValidityEndDate" name="addValidityEndDate">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 control-label">退租时退款</label>
                        <div class="col-sm-4">
                            <input class="addRefundType" type="checkbox" name="addRefundType" id="addRefundType" value="1"/>是
                        </div>

                        <label class="col-sm-2 control-label">状态</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="addStatus" name="addStatus">
                                <option value="11">启用</option>
                                <option value="10">禁用</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 control-label">全院必收费用</label>
                        <div class="col-sm-4">
                            <input class="addIsALLFee" type="checkbox" name="addIsALLFee" id="addIsALLFee" value="1"/>是
                        </div>

                        <label class="col-sm-2 control-label">循环收取费用</label>
                        <div class="col-sm-4">
                            <input class="addIsCycleFee" type="checkbox" name="addIsCycleFee" id="addIsCycleFee" value="1"/>是
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="addExplain" class="col-sm-2 control-label">说明</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" name="addExplain" id="addExplain" placeholder="说明"></textarea>
                        </div>
                    </div>


                </div>
                
                
                
                
                
                
                
                <div class="modal-footer" style="text-align:center;">
                    <div class="col-sm-6">
                     <button type="button" class="btn btn-default" onclick="closeModal()" data-dismiss="modal">关闭</button>
                    </div>
                    <div class="col-sm-6">
                     <button type="button" class="btn btn-primary" onclick="addChargeStandard()">保存</button>
                    </div>
                </div>
            </div>
        </div>

    </div>
</form>