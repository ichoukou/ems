<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade notprint" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" id="modal" style="width: 98%;">
            <div class="modal-content" style="background-color:#F0F0F0;">

                <div class="panel panel-default">
                    <div class="panel-heading" style="background: #2F4050 ;color: white">物品盘点:</div>

                    <div class="panel-body">
                        <form id="formSearch" class="form-horizontal">
                            <div class="form-group row" style="margin-top:15px">

                                <label class="control-label col-sm-1" for="add_checkDate">盘点时间</label>
                                <div class="col-sm-2">
                                    <input  id="add_checkDate" placeholder="请选择日期" class="form-control" type="text" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd',minDate:'%y-%M-01',maxDate:'%y-%M-%ld'})" style="width:150px;height: 30px" />
                                </div>

                                <label class="control-label col-sm-1" for="add_store">所在仓库</label>
                                <div class="col-sm-2">
                                    <select class="form-control" name="add_store" id="add_store" style="width: 150px;"  onchange="getStorageMaretial()" placeholder="-请选择-" >

                                    </select>
                                </div>

                                <label class="control-label col-sm-1" for="add_checkman">盘点人</label>
                                <div class="col-sm-2">
                                    <select class="form-control" name="add_checkman" id="add_checkman" style="width: 150px;"  placeholder="-请选择-" >

                                    </select>
                                </div>
                                <label class="control-label col-sm-1" for="add_remarks">描述</label>
                                <div class="col-sm-2">
                                    <textarea type="text" class="form-control" id="add_remarks"  style="width: 150px;height: 80px;resize: none;"></textarea>
                                </div>
                            </div>

                        </form>
                    </div>
                </div>
                <div  align="center" class="panel-heading" style="width: 100%;height: 60px; background-color: #F5F5F5" ><h2 class="modal-title" style="color: black"><span id="add_date"></span><span id="add_storage"></span>盘点表</h2>
                </div>
                <table id="check_add_table"></table>
                <div class="modal-footer" style="margin-right: 30px">
                    <button   onclick="add_checklist();" type="button" class="btn btn-primary" >添加</button>
                    <button id="out_close_btn"  type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>


        </div>
    </div>
</form>
