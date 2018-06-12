<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<style>

</style>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div style="overflow-y: scroll;"  class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" id="modal" style="width:97%;">
            <div class="modal-content" style="background-color:#F0F0F0;">
                <div class=" panel-heading" style="background: #2F4050">
                    <div class="panel-heading" id="myModalLabel"  style="background: #2F4050 ;color: white"><span id="out_add_title" style="background: #2F4050 ;color: white">出库单新增</span></div>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="add_Goods_number">
                    <div align="center" class="popover-content" style="width:100%;" >
                        <div class="form-group row" >

                            <label class="control-label col-sm-1" for="add_number">单据编号</label>
                            <div class="col-sm-2">
                                <input class="form-control" name="add_number" id="add_number"  style="width: 160px;height: 30px"  readonly/>
                            </div>

                            <label class="control-label col-sm-1" for="add_outTime">出库日期</label>
                            <div class="col-sm-2" >
                                <input id="add_outTime" placeholder="请选择日期" class="form-control" type="text" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-%d'})" style="width:150px;height: 30px" />
                            </div>

                            <label class="control-label col-sm-1" for="add_operator">经办人</label>
                            <div class="col-sm-1" style="padding-left: 0px;margin-left: 0px;">
                                <select class="form-control" name="add_operator" id="add_operator" style="width: 100px;height: 30px" >

                                </select>
                            </div>

                            <label class="control-label col-sm-1" for="add_explain">说明</label>
                            <div class="col-sm-3 ">
                                <textarea  class="form-control" name="add_explain" id="add_explain"style="width: 230px;height: 30px;resize: none"  ></textarea>
                            </div>
                        </div>
                        <table id="add_storageOutDetailed" class="table table-bordered" style="border:solid 2px #1AB394;">
                            <thead>
                            <tr>
                                <th  style="width: 40px">

                                </th>
                                <th style="text-align: center;width: 70px " >
                                    <div class="th-inner ">序号</div>
                                </th>
                                <th style="text-align: center;width: 120px ;display:none;" >
                                    <div class="th-inner ">STOCK_ACCOUNT_ID</div>
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
                                <th style="text-align: center;display:none;" >
                                    <div class="th-inner ">最小库存</div>
                                </th>
                                <th style="text-align: center;display:none;" >
                                    <div class="th-inner ">fid</div>
                                </th>

                            </tr>
                            </thead>
                            <tbody>
                            <%--<tr data-index="3">--%>
                            <%--<td style="text-align: center; "><input name="btSelectItem" type="checkbox"></td>--%>
                            <%--<td style="text-align: center; ">4</td>--%>
                            <%--<td style="text-align: center; ">2016-05-12</td>--%>
                            <%--<td style="text-align: center; ">仓库2</td>--%>
                            <%--<td style="text-align: center; ">张召</td>--%>
                            <%--<td style="text-align: center; ">CC</td>--%>
                            <%--<td style="text-align: center; ">2222222</td>--%>
                            <%--<td style="text-align: center; ">爱好草稿纸</td>--%>
                            <%--</tr>--%>
                        </table>
                    </div>
                </div>
                <div class="modal-footer" style="margin-right: 30px">
                    <button id="out_add_add" type="button" class="btn btn-primary"  data-toggle="modal" data-target="#addGoodsModal">增加</button>
                    <button id="out_add_delect" type="button" class="btn btn-primary" >删除</button>
                    <button id="out_add_save" type="button" class="btn btn-primary" >保存</button>
                    <button id="add_close_btn"  type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>

    </div>
</form>
