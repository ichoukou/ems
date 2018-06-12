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
<form id="up_form_validate" class="form-horizontal notprint">
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="width: 1100px">
            <div class="modal-content" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">更新养老院</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="updatefID"  name="updatefID" >

                    <div class="form-group row">
                        <label for="updatefNursingName" class="col-sm-2 control-label">养老院名称</label>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" id="updatefNursingName"  name="updatefNursingName"  placeholder="必填项"><%-- --%>
                        </div>

                        <div class="col-sm-2"></div>
                        <label for="updatefFreeDays" class="col-sm-2 control-label">请假退费天数</label>
                        <div class="col-sm-3" >
                            <input  onkeyup="value=value.replace(/[^\d]/g,'')" class="form-control" id="updatefFreeDays" name="updatefFreeDays">

                        </div>


                    </div>
                    <div class="form-group row">
                        <label for="updatefLeader" class="col-sm-2 control-label" >管理人</label>
                        <div class="col-sm-3">
                            <input class="form-control" id="updatefLeader" name="updatefLeader" placeholder="必填项">

                        </div>

                        <div class="col-sm-2"></div>
                        <label for="updatefLeaderPhone" class="col-sm-2 control-label" >管理人电话</label>
                        <div class="col-sm-3">
                            <input  onkeyup="value=value.replace(/[^\d]/g,'')" type="text" class="form-control" id="updatefLeaderPhone" name="updatefLeaderPhone" placeholder="来电人电话">
                        </div>


                    </div>
                    <div class="form-group row">
                        <label for="updatefDate" class="col-sm-2 control-label">截止时间</label>

                        <div class="col-sm-3">
                            <input  onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" type="text" class="form-control" id="updatefDate" name="updatefDate">
                        </div>

                        <div class="col-sm-2"></div>
                        <label for="updatefStatus" class="col-sm-2 control-label"  >是否启用</label>
                        <div class="col-sm-3">
                            <select type="text" class="form-control" id="updatefStatus" name="updatefStatus" placeholder="来电人姓名">
                                <option value="1">正常</option>
                                <option value="0">停用</option>
                            </select>
                        </div>

                    </div>
                    <div class="form-group row">

                        <label for="updatefNursingAdd" class="col-sm-2 control-label">地址</label>
                        <div class="col-sm-3">
                            <textarea class="form-control"  style="resize: none;height: 65px;"  name="updatefNursingAdd" id="updatefNursingAdd"  placeholder="必填项"></textarea>
                        </div>

                        <div class="col-sm-2"></div>
                        <label for="updatefRemarks" class="col-sm-2 control-label">说明 </label>
                        <div class="col-sm-3">
                            <textarea class="form-control"  style="resize: none;height: 65px;"  name="updatefRemarks" id="updatefRemarks" ></textarea>
                        </div>

                    </div>

                    <div class="form-group row">
                        <label for="updatefChargeModeID" class="col-sm-2 control-label" >收费模式 </label>
                        <div class="col-sm-6">
                            <select class="form-control" id="updatefChargeModeID" name="updatefChargeModeID">
                            </select>
                        </div>

                    </div>
                    <div class="form-group row">

                        <label  class="col-sm-2 control-label" >属性：</label>


                        <input type="checkbox"  id="updatefFirstFee"  name="updatefFirstFee"  style="width: 20px;height: 20px;">
                        <label for="updatefFirstFee" >入住当天是否收费</label>&nbsp;&nbsp;&nbsp;&nbsp;

                        <input type="checkbox"  id="updatefLastFee"  name="updatefLastFee"  style="width: 20px;height: 20px;">
                        <label for="updatefLastFee" >退住当天是否收费</label>&nbsp;&nbsp;&nbsp;&nbsp;

                        <input type="checkbox"  id="updatefBedFree"  name="updatefBedFree"  style="width: 20px;height: 20px;">
                        <label for="updatefBedFree" >请假时是否退床费 </label>&nbsp;&nbsp;&nbsp;&nbsp;

                        <input type="checkbox"  id="updatefServiceFree"  name="updatefServiceFree"  style="width: 20px;height: 20px;">
                        <label for="updatefServiceFree" >请假时是否退综合服务费 </label>&nbsp;&nbsp;&nbsp;&nbsp;

                        <input type="checkbox" id="updatefMealFree"  name="updatefMealFree"  style="width: 20px;height: 20px;">
                        <label for="updatefMealFree" >请假时是否退餐费</label>

                    </div>



                </div>
                <div class="modal-footer">
                    <button type="submit" type="button" class="btn btn-primary">保存</button>
                    <button id="update_close_btn" type="button" class="btn btn-primary" onclick="closeModal()" data-dismiss="modal" >关闭</button>
                </div>
            </div>
        </div>
    </div>
</form>