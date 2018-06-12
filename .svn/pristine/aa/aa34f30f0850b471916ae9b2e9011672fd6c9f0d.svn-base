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
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
           <div class="modal-dialog" style="width: 1100px">
            <div class="modal-content" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">更改订单</h4>
                </div>                             
                <div class="modal-body">
                
         <input type="hidden"  class="form-control" id="updatefid" name="updatefid" >
                     

                        <div class="form-group row">
                            <label for="updateOrderNumber" class="col-sm-1 control-label">工单号</label>
                            <div class="col-sm-3">
                                <input type="text" class="form-control" id="updateOrderNumber" readonly="readonly" name="fOrderNo">
                            </div>

                            <label for="updatefServiceObject" class="col-sm-2 control-label">服务对象</label>
                            <div class="col-sm-2" >
                                <select class="form-control" id="updatefServiceObject" name="fServiceObject">
                                </select>
                            </div> 

                            <label for="updatefOrderType" class="col-sm-2 control-label">工单类型</label>
                            <div class="col-sm-2">
                              <select class="form-control" id="updatefOrderType" name="fOrderType">
                                </select>
                            </div>
                        </div>


                    <div class="form-group row">
                        <label for="updatefRecieveDept" class="col-sm-2 control-label">受理部门</label>
                        <div class="col-sm-2">
                            <select class="form-control" id="updatefRecieveDept" name="fRecieveDept">
                            </select>                     
                        </div>

                        <label for="updatefCallPhone" class="col-sm-2 control-label" >来电人电话</label>
                        <div class="col-sm-2">
                         <input  onkeyup="value=value.replace(/[^\d]/g,'')" type="text" class="form-control" id="updatefCallPhone" name="fCallPhone" placeholder="来电人电话">                          
                        </div>
                        
                          <label for="updatefServiceProvide" class="col-sm-2 control-label" >服务方</label>
                        <div class="col-sm-2">
                            <select class="form-control" id="updatefServiceProvide" name="fServiceProvide">
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="updatefRecieveUser" class="col-sm-2 control-label"  >接单人</label>
                        <div class="col-sm-2">
                            <select class="form-control" id="updatefRecieveUser" name="fRecieveUser">
                            </select>
                        </div>

                        <label for="updatefCallName" class="col-sm-2 control-label"  >来电人姓名</label>
                        <div class="col-sm-2">
                        <input type="text" class="form-control" id="updatefCallName" name="fCallName" placeholder="来电人姓名">                                              
                        </div>

                        <label for="updatefServiceUser" class="col-sm-2 control-label" >服务人员</label>
                        <div class="col-sm-2">
                            <select class="form-control" id="updatefServiceUser" name="fServiceUser">
                            </select>
                        </div>
                    </div>
                    


                    <div class="form-group row">
                         <label for="updatefRecieveTime" class="col-sm-2 control-label">接单时间
                         <span class=" control-label" id="updatefRecieveTime_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span></label>                  
                         
                        <div class="col-sm-2">
                            <input onblur="updatefRecieveTime_check()" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text" class="form-control" id="updatefRecieveTime" name="fRecieveTime">
                        </div>

                         <label for="updatefObjectName" class="col-sm-2 control-label" >服务对象姓名</label>
                        <div class="col-sm-2">
                          <input type="text" class="form-control" id="updatefObjectName" name="fObjectName" placeholder="服务对象姓名">                                              

                        </div> 

                        <label for="updatefServiceType" class="col-sm-2 control-label" >服务大类
                   <span class=" control-label" id="updatefServiceType_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                        
                        </label>
                        <div class="col-sm-2">
                            <select class="form-control" id="updatefServiceType" name="fServiceType">
                            </select>
                        </div>
                    </div>
                    <div class="form-group row">
                     <label for="updatefOrderEmergency" class="col-sm-2 control-label" >工单紧急程度 </label>
                        <div class="col-sm-2">
                            <select class="form-control" id="updatefOrderEmergency" name="fOrderEmergency">
                            </select>
                        </div>
                    
                       <label for="updatefObjectPhone" class="col-sm-2 control-label" >服务对象电话</label>
                        <div class="col-sm-2">
                          <input  onkeyup="value=value.replace(/[^\d]/g,'')" type="text" class="form-control" id="updatefObjectPhone" name="fObjectPhone" placeholder="服务对象电话">                                                                       
                        </div> 
                    
                       <label for="updatefServiceItem" class="col-sm-2 control-label" >服务项目
                       <span class=" control-label" id="updatefServiceItem_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                       
                       </label>
                        <div class="col-sm-2">
                           <select class="form-control" id="updatefServiceItem" name="fServiceItem">
                            </select>                       
                         </div> 
                         
                  
                    </div>
                    <div class="form-group row">
                        <label for="updatefPayStyle" class="col-sm-2 control-label" >付款方式</label>
                        <div class="col-sm-2">
                           <select class="form-control" id="updatefPayStyle" name="fPayStyle">
                            </select>                       
                         </div> 
                         
                    
                         
                        <label for="updatefRequestTime" class="col-sm-2 control-label">要求服务时间</label>
                        <div class="col-sm-2">
                            <input onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd HH:mm:ss'})" type="text" class="form-control" id="updatefRequestTime" name="fRequestTime">
                        </div>
                         
                         <label for="updatefPrice" class="col-sm-2 control-label">单价 
                 <span class=" control-label" id="updatefPrice_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                         
                         </label>
                        <div class="col-sm-2">
                          <input type="text" class="form-control" id="updatefPrice"  readonly="readonly" name="fPrice" >                                                                       
                        </div>    
                    </div>
                    <div class="form-group row">
                          <label for="updatefDealStatus" class="col-sm-2 control-label" >处理状态</label>
                        <div class="col-sm-2">
                           <select class="form-control" id="updatefDealStatus" name="fDealStatus">
                            </select>                       
                         </div>
                        <label for="updatefTotal"class="col-sm-2 control-label">金额
                            <span class=" control-label" id="updatefTotal_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>

                        </label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" id="updatefTotal" readonly="readonly" name="fTotal" >
                        </div>

                         
                             <label for="updatefNumber" class="col-sm-2 control-label">数量
                 <span class=" control-label" id="updatefNumber_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                             
                             </label>
                        <div class="col-sm-2">
                          <input type="text"  onkeyup="value=value.replace(/[^\d]/g,'')" class="form-control" id="updatefNumber" name="fNumber" >                                                                       
                        </div>
                         
                    </div>

                    <div class="form-group row">
                        <label for="updatefServiceAdd" class="col-sm-2 control-label">服务地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="updatefServiceAdd" name="fServiceAdd" >
                        </div>

                    </div>

                    <div class="form-group row">
                        <label for="updatefOrderExplain" class="col-sm-2 control-label">工单说明 </label>
                        <div class="col-sm-10">
                            <textarea class="form-control"  style="resize: none;"  name="fOrderExplain" id="updatefOrderExplain" ></textarea>
                        </div>
                    </div>
      
              
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary"  onclick="updateOrder()">订单保存</button>                                                                       
                    <button id="update_close_btn" type="button" onclick="closeModal()" class="btn btn-primary" data-dismiss="modal" >关闭</button>

             
                </div>
            </div>
        </div>
      </div>
</form>