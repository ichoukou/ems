<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<style>

</style>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div style="overflow-y: auto;" class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" id="modal" style="width:97%;">
            <div class="modal-content" style="background-color:#F0F0F0;">
                <div class=" panel-heading" style="background: #2F4050">
                    <div class="panel-heading" id="myModalLabel"  style="background: #2F4050 ;color: white">入库单更新
                        <span class=" control-label" id="update_in_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span></div>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="update_id">
                    <div align="center" class="popover-content" style="width:100%;" >
                        <div class="form-group row">
                            <label for="updateFPurchaseDate" class="col-sm-2 control-label">采购日期</label>
                            <div class="col-sm-4">
                                <input id="updateFPurchaseDate" class="form-control" type="text" onFocus="WdatePicker({readOnly:true,maxDate:new Date()})" />
                            </div>

                            <label for="updateFTel" class="col-sm-2 control-label">电话</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" id="updateFTel" name="updateFTel">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="updateFSupplyMome" class="col-sm-2 control-label">供货方式</label>
                            <div class="col-sm-4">
                                <select class="form-control" id="updateFSupplyMome"name="updateFSupplyMome">

                                </select>
                            </div>

                            <label for="updateFPaymentMode" class="col-sm-2 control-label">支付方式</label>
                            <div class="col-sm-4">
                                <select class="form-control" id="updateFPaymentMode" name="updateFPaymentMode">

                                </select>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="updateFReceivingPlace" class="col-sm-2 control-label">收获地点</label>
                            <div class="col-sm-10">
                                <input class="form-control" name="updateFReceivingPlace" id="updateFReceivingPlace" placeholder="收获地点">
                            </div>
                        </div>
                        <%--<div class="form-group row">--%>
                            <%--<label for="updateFRemarks" class="col-sm-2 control-label">采购说明</label>--%>
                            <%--<div class="col-sm-10">--%>
                                <%--<textarea style="resize:none;" class="form-control" name="updateFRemarks" id="updateFRemarks" placeholder="说明"></textarea>--%>
                            <%--</div>--%>
                        <%--</div>--%>
                        <div >
                            <table id="update_Materials" class="table table-bordered" style="border:solid 2px #1AB394;">
                                <thead>
                                <tr>
                                    <th  style="width: 40px">
                                    </th>
                                    <th style="text-align: center;width: 90px " >
                                        <div class="th-inner ">商品名称</div>
                                    </th>
                                    <th style="text-align: center;display:none;" >
                                        <div class="th-inner ">商品ID</div>
                                    </th>
                                    <th style="text-align: center;width: 90px " >
                                        <div class="th-inner ">仓库</div>
                                    </th>
                                    <th style="text-align: center;display:none;" >
                                        <div class="th-inner ">仓库ID</div>
                                    </th>
                                    <th style="text-align: center;width: 90px " >
                                        <div class="th-inner ">仓管员</div>
                                    </th>
                                    <th style="text-align: center;display:none;" >
                                        <div class="th-inner ">仓管员ID</div>
                                    </th>
                                    <th style="text-align: center; width: 225px ">
                                        <div class="th-inner ">供应商</div>
                                    </th>
                                    <th style="text-align: center;display:none; " >
                                        <div class="th-inner ">供应商ID</div>
                                    </th>
                                    <th style="text-align: center; width: 80px;" >
                                        <div class="th-inner ">采购数量</div>
                                    </th>
                                    <th style="text-align: center; width: 50px;" >
                                        <div class="th-inner ">单位</div>
                                    </th>
                                    <th style="text-align: center; width: 50px;" >
                                        <div class="th-inner ">单价</div>
                                    </th>
                                    <th style="text-align: center; width: 50px;">
                                        <div class="th-inner ">金额</div>
                                    </th>
                                    <th style="text-align: center;">
                                        <div class="th-inner ">备注</div>
                                    </th>
                                </tr>
                                </thead>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="modal-footer" style="margin-right: 30px">
                    <span class=" control-label" id="up_in_in_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                    <button type="button" class="btn btn-primary"  onclick="update_in_Add();" data-toggle="modal">增加</button>
                    <button type="button" class="btn btn-primary"  onclick="update_in_Delect()">删除</button>
                    <button type="button" class="btn btn-primary"  onclick="update_in_Save()">保存</button>
                    <button id="update_close_btn"  type="button" class="btn btn-default" onclick="closeModal()" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>

    </div>
</form>