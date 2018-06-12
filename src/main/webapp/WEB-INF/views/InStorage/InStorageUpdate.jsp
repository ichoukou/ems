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
                    <input type="hidden" id="update_Goods_number">
                    <div align="center" class="popover-content" style="width:100%;" >
                        <div class="form-group row" >

                            <label class="control-label col-sm-1" for="update_number">单据编号</label>
                            <div class="col-sm-2">
                                <input type="hidden" id="update_id">
                                <input class="form-control" name="update_number" id="update_number"  style="width: 160px;height: 30px"  readonly/>
                            </div>

                            <label class="control-label col-sm-1" for="updatefInStorageDate">入库日期</label>
                            <div class="col-sm-2" >
                                <input id="updatefInStorageDate" class="form-control" type="text" onFocus="WdatePicker({lang:'zh-cn',minDate:'%y-%M-%d'})" style="width:150px;height: 30px" />
                            </div>

                            <label class="control-label col-sm-1" for="update_operator">经办人</label>
                            <div class="col-sm-1" style="padding-left: 0px;margin-left: 0px;">
                                <select class="form-control" name="update_operator" id="update_operator" style="width: 100px;height: 30px" >

                                </select>
                            </div>

                            <label class="control-label col-sm-1" for="update_explain">说明</label>
                            <div class="col-sm-3 ">
                                <textarea class="form-control" name="update_explain" id="update_explain"style="width: 230px;height: 30px;resize: none"  ></textarea>
                            </div>
                        </div>
                        <table id="update_storageInDetailed" class="table table-bordered" style="border:solid 2px #1AB394;">
                            <thead>
                            <tr>
                                <th  style="width: 40px">

                                </th>
                                <th style="text-align: center;width: 120px ;display:none;" >
                                    <div class="th-inner ">STOCK_ACCOUNT</div>
                                </th>
                                <th style="text-align: center;width: 120px " >
                                    <div class="th-inner ">仓库</div>
                                </th>
                                <th style="text-align: center;width: 120px ;display:none;" >
                                    <div class="th-inner ">仓库ID</div>
                                </th>
                                <th style="text-align: center; width: 120px ">
                                    <div class="th-inner ">保管员</div>
                                </th>
                                <th style="text-align: center; width: 120px;display:none; " >
                                    <div class="th-inner ">保管员ID</div>
                                </th>
                                <th style="text-align: center; width: 150px;" >
                                    <div class="th-inner ">物资</div>
                                </th>
                                <th style="text-align: center; width: 150px;display:none;" >
                                    <div class="th-inner ">物资ID</div>
                                </th>
                                <th style="text-align: center; width: 120px;" >
                                    <div class="th-inner ">规格</div>
                                </th>
                                <th style="text-align: center; width: 70px" >
                                    <div class="th-inner ">数量</div>
                                </th>
                                <th style="text-align: center; " >
                                    <div class="th-inner ">备注</div>
                                </th>
                                <th style="text-align: center;display:none;" >
                                    <div class="th-inner ">剩余数量</div>
                                </th>

                            </tr>
                            </thead>
                            <tbody>

                        </table>
                    </div>
                </div>
                <div class="modal-footer" style="margin-right: 30px">
                    <span class=" control-label" id="in_message_update" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                    <button type="button" class="btn btn-primary"  onclick="update_In_Add();" data-toggle="modal" >增加</button>
                    <button type="button" class="btn btn-primary"  onclick="update_In_Delect()">删除</button>
                    <button type="button" class="btn btn-primary"  onclick="update_In_Save()">保存</button>
                    <button id="update_close_btn"  type="button" class="btn btn-default" onclick="closeModal()" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>

    </div>
</form>
