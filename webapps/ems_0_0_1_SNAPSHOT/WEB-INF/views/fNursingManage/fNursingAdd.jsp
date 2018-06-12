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
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="width: 1100px">
            <div class="modal-content" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加养老院</h4>
                </div>
                <div class="modal-body">

                    <div class="form-group row">
                        <label for="addfNursingName" class="col-sm-2 control-label">养老院名称</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="addfNursingName"  name="addfNursingName"  placeholder="必填项"><%-- --%>
                        </div>

                    <div class="col-sm-2"></div>
                        <label for="addfFreeDays" class="col-sm-2 control-label">请假退费天数</label>
                        <div class="col-sm-3" >
                            <input  onkeyup="value=value.replace(/[^\d]/g,'')" class="form-control" id="addfFreeDays" name="addfFreeDays">

                        </div>


                    </div>
                   <div class="form-group row">
                        <label for="addfLeader" class="col-sm-2 control-label" >管理人</label>
                        <div class="col-sm-3">
                            <input class="form-control" id="addfLeader" name="addfLeader" placeholder="必填项">

                        </div>

                        <div class="col-sm-2"></div>
                        <label for="addfLeaderPhone" class="col-sm-2 control-label" >管理人电话</label>
                        <div class="col-sm-3">
                            <input  onkeyup="value=value.replace(/[^\d]/g,'')" type="text" class="form-control" id="addfLeaderPhone" name="addfLeaderPhone" placeholder="来电人电话">
                        </div>


                    </div>
                    <div class="form-group row">
                        <label for="addfDate" class="col-sm-2 control-label">截止时间</label>

                        <div class="col-sm-3">
                            <input  onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" type="text" class="form-control" id="addfDate" name="addfDate">
                        </div>

                        <div class="col-sm-2"></div>
                        <label for="addfStatus" class="col-sm-2 control-label"  >是否启用</label>
                        <div class="col-sm-3">
                            <select type="text" class="form-control" id="addfStatus" name="addfStatus" placeholder="来电人姓名">
                            <option value="1">正常</option>
                            <option value="0">停用</option>
                            </select>
                        </div>

                    </div>
                    <div class="form-group row">

                        <label for="addfNursingAdd" class="col-sm-2 control-label">地址</label>
                        <div class="col-sm-3">
                            <textarea class="form-control"  style="resize: none;height: 65px;"  name="addfNursingAdd" id="addfNursingAdd"  placeholder="必填项"></textarea>
                        </div>

                        <div class="col-sm-2"></div>
                        <label for="addfRemarks" class="col-sm-2 control-label">说明 </label>
                        <div class="col-sm-3">
                            <textarea class="form-control"  style="resize: none;height: 65px;"  name="addfRemarks" id="addfRemarks" ></textarea>
                        </div>

                    </div>

                    <div class="form-group row">
                        <label for="addfChargeModeID" class="col-sm-2 control-label" >收费模式 </label>
                        <div class="col-sm-6">
                            <select class="form-control" id="addfChargeModeID" name="addfChargeModeID">
                            </select>
                        </div>

                    </div>
                    <div class="form-group row">

                        <label  class="col-sm-2 control-label" >属性：</label>


                            <input type="checkbox"  id="addfFirstFee"  name="addfFirstFee"  style="width: 20px;height: 20px;">
                            <label for="addfFirstFee" >入住当天是否收费</label>&nbsp;&nbsp;&nbsp;&nbsp;

                            <input type="checkbox"  id="addfLastFee"  name="addfLastFee"  style="width: 20px;height: 20px;">
                            <label for="addfLastFee" >退住当天是否收费</label>&nbsp;&nbsp;&nbsp;&nbsp;

                             <input type="checkbox"  id="addfBedFree"  name="addfBedFree"  style="width: 20px;height: 20px;">
                             <label for="addfBedFree" >请假时是否退床费 </label>&nbsp;&nbsp;&nbsp;&nbsp;

                             <input type="checkbox"  id="addfServiceFree"  name="addfServiceFree"  style="width: 20px;height: 20px;">
                             <label for="addfServiceFree" >请假时是否退综合服务费 </label>&nbsp;&nbsp;&nbsp;&nbsp;

                             <input type="checkbox" id="addfMealFree"  name="addfMealFree"  style="width: 20px;height: 20px;">
                             <label for="addfMealFree" >请假时是否退餐费</label>

                    </div>



                </div>
                <div class="modal-footer">
                    <button type="submit" type="button" class="btn btn-primary">保存</button>
                    <button id="add_close_btn" type="button" class="btn btn-primary" onclick="closeModal()" data-dismiss="modal" >关闭</button>
                </div>
            </div>
        </div>
    </div>
</form>