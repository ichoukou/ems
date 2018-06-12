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
           <div class="modal-dialog" style="width: 800px">
            <div class="modal-content" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加仓库</h4>
                </div>                             
                <div class="modal-body">

                    <div class="form-group row">
                         
                         <label for="addfStoreHouseName" class="col-sm-3 control-label">仓库名称
                         <span class=" control-label" id="addfStoreHouseName_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span></label>
                         
                        <div class="col-sm-3">
                            <input onblur="addfStoreHouseName_check()"  type="text" class="form-control" id="addfStoreHouseName" name="fStoreHouseName" placeholder="必填项">
                        </div>


                        <label for="addfStoremanName" class="col-sm-3 control-label" >负责人
                        <span class=" control-label" id="addfStoremanName_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                        </label>
                        <div class="col-sm-3">
                            <select class="form-control" id="addfStoremanName" name="fStoremanName">
                            </select>
                        </div>
                    </div>
                    
                    <div class="form-group row">
                                 
                    <label for="addfAddress" class="col-sm-3 control-label">联系地址
                         <span class=" control-label" id="addfAddress_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span></label>
                    <div class="col-sm-3">
                            <input onblur="addfAddress_check()"  type="text" class="form-control" id="addfAddress" name="fAddress" placeholder="必填项">
                        </div>
                     
                    <label for="addfTel" class="col-sm-3 control-label" >联系电话
                    <span class=" control-label" id="addfTel_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                       
                       </label>
                     <div class="col-sm-3">
                          <input  onblur="addfTel_check()" onkeyup="value=value.replace(/[^\d]/g,'')" type="text" class="form-control" id="addfTel" name="fTel" placeholder="必填项">                                                                       
                        </div> 
                    
                     
                         
                  
                    </div>
        

                    <div class="form-group row">
                 
                        <label for="addfRemarks" class="col-sm-3 control-label">仓库备注</label>
                        <div class="col-sm-9">
                            <textarea class="form-control"  style="resize: none;"  name="fRemarks" id="addfRemarks" ></textarea>
                        </div>
                    </div>
      
              
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="addHome()">仓库保存</button>                                                    
                    <button id="add_close_btn" type="button" class="btn btn-primary" data-dismiss="modal" onclick="closeModal()">关闭</button>                                                                        
                </div>
            </div>
        </div>
      </div>
</form>