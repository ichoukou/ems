<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加用户</h4>
                </div>
                                
                <div class="modal-body">
               <input type="hidden" id="addStaff_id">
                
                    <div class="form-group">
                        <span>
                            <label for="addUname" style="width: 100px">账号:</label>
                            <input onblur="addUname_check()" type="text" style="width: 300px;height: 34px" id="addUname">
                            <span class=" control-label" id="addUname_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                        </span>
                    </div>
                     <div class="form-group">
                        <span>
                            <label for="addPass" style="width: 100px">密码:</label>
                            <input onblur="addPass_check()" type="password" style="width: 300px;height: 34px" id="addPass">
                           <span class=" control-label" id="addPass_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                     
                        </span>
                    </div>
                     <div class="form-group">
                        <span>
                            <label for="addEmployId" style="width: 100px">所属员工:</label>
                            <input onblur="addEmployId_check()" type="text" style="width: 300px;height: 34px" id="addEmployId">
                          <span class=" control-label" id="addEmployId_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                           
                        </span>
                    </div>
                      <div class="form-group">
                        <span>
                            <label for="addName" style="width: 100px">姓名:</label>
                            <input onblur="addName_check()" type="text" style="width: 300px;height: 34px" id="addName">
                  <span class=" control-label" id="addName_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                            
                        </span>
                    </div>
                     <div class="form-group">
                        <span>
                            <label for="addPhoneNum" style="width: 100px">手机:</label>
                            <input onblur="addPhoneNum_check()" onkeyup="value=value.replace(/[^\d]/g,'')" type="text" style="width: 300px;height: 34px" id="addPhoneNum">
                 <span class=" control-label" id="addPhoneNum_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                            
                        </span>
                    </div>
                      <div class="form-group">
                        <span>
                            <label for="userHouse_op" style="width: 100px;">所属养老院:</label>

                            <select style="width:300px;height: 34px;font-weight: bold" id="userHouse_op"  disabled="disabled">

                            </select>
               <span class=" control-label" id="userHouse_op_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                            
                        </span>
                    </div>
                       <div class="form-group">
                        <span>
                            <label for="user_op" style="width: 100px;">角色:</label>
                            <select style="width:300px;height: 34px;font-weight: bold" id="user_op">         
                            </select>
                          <span class=" control-label" id="user_op_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                            
                        </span>
                        
                    </div>     
                </div>
                <div class="modal-footer">
                    <button id="add_close_btn" type="button" class="btn btn-default" data-dismiss="modal" onclick="closeModal()">关闭</button>
                    <button  type="button" class="btn btn-primary"  onclick="addUser()">保存</button>                                
                </div>
            </div>
        </div>
    </div>
</form>