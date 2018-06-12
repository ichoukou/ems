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
           <div class="modal-dialog" style="width: 800px">
            <div class="modal-content" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">更改仓库</h4>
                </div>                             
                <div class="modal-body">
                 <input type="hidden"  class="form-control" id="updatefid" name="updatefid" >
                   <input type="hidden"  class="form-control" id="updatefStoreHouseNumber" name="fStoreHouseNumber" >
                    <input type="hidden"  class="form-control" id="updatefNursingHomeID" name="fNursingHomeID" >
                                
                    <div class="form-group row">
                    
                         <label for="updatefStoreHouseName" class="col-sm-3 control-label">仓库名称
                         <span class=" control-label" id="updatefStoreHouseName_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span></label>
                         
                        <div class="col-sm-3">
                            <input onblur="updatefStoreHouseName_check()"  type="text" class="form-control" id="updatefStoreHouseName" name="fStoreHouseName" placeholder="必填项">
                        </div>


                        <label for="updatefStoremanName" class="col-sm-3 control-label" >负责人
                        <span class=" control-label" id="updatefStoremanName_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                        </label>
                        <div class="col-sm-3">
                            <select class="form-control" id="updatefStoremanName" name="fStoremanName">
                            </select>
                        </div>
                    </div>
                    
                    <div class="form-group row">
                   <label for="updatefAddress" class="col-sm-3 control-label">联系地址
                         <span class=" control-label" id="updatefAddress_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span></label>
                         
                        <div class="col-sm-3">
                            <input onblur="updatefAddress_check()"  type="text" class="form-control" id="updatefAddress" name="fAddress" placeholder="必填项">
                        </div>
                    
                       <label for="updatefTel" class="col-sm-3 control-label" >联系电话
                    <span class=" control-label" id="updatefTel_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                       
                       </label>
                        <div class="col-sm-3">
                          <input  onblur="updatefTel_check()" onkeyup="value=value.replace(/[^\d]/g,'')" type="text" class="form-control" id="updatefTel" name="fTel" placeholder="必填项">                                                                       
                        </div> 
                    
                     
                         
                  
                    </div>
        

                    <div class="form-group row">
                        <label for="updatefRemarks" class="col-sm-3 control-label">备注</label>
                        <div class="col-sm-9">
                            <textarea class="form-control"  style="resize: none;"  name="fRemarks" id="updatefRemarks" ></textarea>
                        </div>
                    </div>
      
              
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="updateHome()">仓库保存</button>                                                    
                    <button id="update_close_btn" type="button" class="btn btn-primary" data-dismiss="modal" onclick="closeModal()">关闭</button>                                                                        
                </div>
            </div>
        </div>
      </div>
</form>