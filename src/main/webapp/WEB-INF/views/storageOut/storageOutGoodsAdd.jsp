<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="addGoodsModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" id="modal" style="width: 98%;">
            <div class="modal-content" style="background-color:#F0F0F0;height: 600px">

                <div class="panel panel-default">
                    <div class="panel-heading" style="background: #2F4050 ;color: white">查询条件:</div>

                    <div class="panel-body">
                        <form id="formSearch" class="form-horizontal">
                            <div class="form-group row" style="margin-top:15px">

                                <label class="control-label col-sm-1" for="out_goodsAdd_material">物品名称</label>
                                <div class="col-sm-2">
                                    <input class="form-control" name="out_goodsAdd_material" id="out_goodsAdd_material"style="width: 150px;" />
                                </div>

                                <label class="control-label col-sm-1" for="out_goodsAdd_store">仓库</label>
                                <div class="col-sm-2">
                                    <select class="form-control" name="out_goodsAdd_store" id="out_goodsAdd_store" style="width: 150px;" >

                                    </select>
                                </div>

                                <label class="control-label col-sm-1" for="out_goodsAdd_type">物品分类</label>
                                <div class="col-sm-2">
                                    <select class="form-control" name="out_goodsAdd_type" id="out_goodsAdd_type"style="width: 150px;" >

                                    </select>
                                </div>

                                <div class="col-sm-3" style="text-align:center;" >
                                    <button  type="button" id="btn_clear" class="btn btn-primary" onclick="clearSelect()">清空</button>
                                    <button  style="margin-left: 20px" type="button" id="btn_query" class="btn btn-primary" onclick="queryOutMaterialList();">查询</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <table id="tb_Stock"></table>
                <div class="modal-footer" style="margin-right: 30px">
                    <button id="out_goodsAdd"  onclick="out_goodsadd();" type="button" class="btn btn-primary" >添加</button>
                    <button id="out_goodsAdd_close_btn"  type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>


        </div>
    </div>
</form>