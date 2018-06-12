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
                    <h4 class="modal-title" id="myModalLabel">添加订单</h4>
                </div>                             
                <div class="modal-body">
                
<!--  更改有 隐藏字段     <input type="hidden"  class="form-control" id="addNursinghomeID" name="addNursinghomeID" value="3">
 -->                       

                        <div class="form-group row">
                            <label for="addOrderNumber" class="col-sm-1 control-label">工单号</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="addOrderNumber" readonly="readonly" name="fOrderNo">
                            </div>

                            <label for="addfServiceObject" class="col-sm-2 control-label">服务对象</label>
                            <div class="col-sm-2" >
                                <select class="form-control" id="addfServiceObject" name="fServiceObject">
                                </select>
                            </div> 

                            <label for="addfOrderType" class="col-sm-2 control-label">工单类型</label>
                            <div class="col-sm-2">
                              <select class="form-control" id="addfOrderType" name="fOrderType">
                                </select>
                            </div>
                        </div>


                    <div class="form-group row">
                        <label for="addfRecieveDept" class="col-sm-2 control-label">受理部门</label>
                        <div class="col-sm-2">
                            <select class="form-control" id="addfRecieveDept" name="fRecieveDept">
                            </select>                     
                        </div>

                        <label for="addfCallPhone" class="col-sm-2 control-label" >来电人电话</label>
                        <div class="col-sm-2">
                         <input  onkeyup="value=value.replace(/[^\d]/g,'')" type="text" class="form-control" id="addfCallPhone" name="fCallPhone" placeholder="来电人电话">                          
                        </div>
                        
                          <label for="addfServiceProvide" class="col-sm-2 control-label" >服务方</label>
                        <div class="col-sm-2">
                            <select class="form-control" id="addfServiceProvide" name="fServiceProvide">
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="addfRecieveUser" class="col-sm-2 control-label"  >接单人</label>
                        <div class="col-sm-2">
                            <select class="form-control" id="addfRecieveUser" name="fRecieveUser">
                            </select>
                        </div>

                        <label for="addfCallName" class="col-sm-2 control-label"  >来电人姓名</label>
                        <div class="col-sm-2">
                        <input type="text" class="form-control" id="addfCallName" name="fCallName" placeholder="来电人姓名">                                              
                        </div>

                        <label for="addfServiceUser" class="col-sm-2 control-label" >服务人员</label>
                        <div class="col-sm-2">
                            <select class="form-control" id="addfServiceUser" name="fServiceUser">
                            </select>
                        </div>
                    </div>
                    


                    <div class="form-group row">
                    
                         <label for="addfRecieveTime" class="col-sm-2 control-label">接单时间
                         <span class=" control-label" id="addfRecieveTime_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span></label>
                         
                        <div class="col-sm-2">
                            <input onblur="addfRecieveTime_check()" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text" class="form-control" id="addfRecieveTime" name="fRecieveTime">
                        </div>

                         <label for="addfObjectName" class="col-sm-2 control-label" >服务对象姓名</label>
                        <div class="col-sm-2">
                          <input type="text" class="form-control" id="addfObjectName" name="fObjectName" placeholder="服务对象姓名">                                              

                        </div> 

                        <label for="addfServiceType" class="col-sm-2 control-label" >服务大类
                                           <span class=" control-label" id="addfServiceType_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                        </label>
                        <div class="col-sm-2">
                            <select class="form-control" id="addfServiceType" name="fServiceType">
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                     <label for="addfOrderEmergency" class="col-sm-2 control-label" >工单紧急程度 </label>
                        <div class="col-sm-2">
                            <select class="form-control" id="addfOrderEmergency" name="fOrderEmergency">
                            </select>
                        </div>
                    
                       <label for="addfObjectPhone" class="col-sm-2 control-label" >服务对象电话</label>
                        <div class="col-sm-2">
                          <input  onkeyup="value=value.replace(/[^\d]/g,'')" type="text" class="form-control" id="addfObjectPhone" name="fObjectPhone" placeholder="服务对象电话">                                                                       
                        </div> 
                    
                       <label for="addfServiceItem" class="col-sm-2 control-label" >服务项目
                                          <span class=" control-label" id="addfServiceItem_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                       </label>
                        <div class="col-sm-2">
                           <select class="form-control" id="addfServiceItem" name="fServiceItem">
                            </select>                       
                         </div> 
                         
                  
                    </div>
                    <div class="form-group row">
                        <label for="addfPayStyle" class="col-sm-2 control-label" >付款方式</label>
                        <div class="col-sm-2">
                           <select class="form-control" id="addfPayStyle" name="fPayStyle">
                            </select>                       
                         </div> 
                         
                    
                         
                        <label for="addfRequestTime" class="col-sm-2 control-label">要求服务时间</label>
                        <div class="col-sm-2">
                      <input onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text" class="form-control" id="addfRequestTime" name="fRequestTime">

                        </div>
                         
                         <label for="addfPrice" class="col-sm-2 control-label">单价 
                         <span class=" control-label" id="addfPrice_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                         
                         </label>
                        <div class="col-sm-2">
                          <input type="text" class="form-control" id="addfPrice"  readonly="readonly" name="fPrice" >                                                                       
                        </div>    
                    </div>
                    <div class="form-group row">
                          <label for="addfDealStatus" class="col-sm-2 control-label" >处理状态</label>
                        <div class="col-sm-2">
                           <select class="form-control" id="addfDealStatus" name="fDealStatus">
                            </select>                       
                         </div>
                        <label for="addfTotal"class="col-sm-2 control-label">金额 </label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="addfTotal" readonly="readonly" name="fTotal" >
                        </div>


                         
                             <label for="addfNumber" class="col-sm-2 control-label">数量
                           <span class=" control-label" id="addfNumber_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                             
                             </label>
                        <div class="col-sm-2">
                          <input  onkeyup="value=value.replace(/[^\d]/g,'')" type="text" class="form-control" id="addfNumber" name="fNumber" >                                                                       
                        </div>
                         
                    </div>

                    <div class="form-group row">

                        <label for="addfServiceAdd" class="col-sm-2 control-label">服务地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="addfServiceAdd" name="fServiceAdd" >
                        </div>

                    </div>

                    <div class="form-group row">
                        <label for="addfOrderExplain" class="col-sm-2 control-label">工单说明 </label>
                        <div class="col-sm-10">
                            <textarea class="form-control"  style="resize: none;"  name="fOrderExplain" id="addfOrderExplain" ></textarea>
                        </div>
                    </div>
      
              
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="addOrder()">订单保存</button>                                                    
                    <button id="add_close_btn" type="button" class="btn btn-primary" onclick="closeModal()" data-dismiss="modal" >关闭</button>
                </div>
            </div>
        </div>
      </div>
</form>