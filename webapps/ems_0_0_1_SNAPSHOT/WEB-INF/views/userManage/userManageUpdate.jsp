<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">更新用户</h4>
                </div>
                                
                <div class="modal-body">
                 <input type="hidden" id="user_id">
                 <input type="hidden" id="updateStaff_id">
                 
                    <div class="form-group">
                        <span>
                            <label for="updateUname" style="width: 100px">账号:</label>
                            <input onblur="updateUname_check()" type="text" style="width: 300px;height: 34px" id="updateUname">
                            <span class=" control-label" id="updateUname_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                            
                        </span>
                    </div>
                     <div class="form-group">
                        <span>
                            <label for="updatePass" style="width: 100px">密码:</label>
                            <input onblur="updatePass_check()" type="password" style="width: 300px;height: 34px" id="updatePass">
                             <span class=" control-label" id="updatePass_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
 
                        </span>
                    </div>
                     <div class="form-group">
                        <span>
                            <label for="updateEmployId" style="width: 100px">所属员工:</label>
                            <input onblur="updateEmployId_check()"type="text" style="width: 300px;height: 34px" id="updateEmployId">
                            <span class=" control-label" id="updateEmployId_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>

                        </span>
                    </div>
                      <div class="form-group">
                        <span>
                            <label for="updateName" style="width: 100px">姓名:</label>
                            <input onblur="updateName_check()" type="text" style="width: 300px;height: 34px" id="updateName">
                            <span class=" control-label" id="updateName_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>

                        </span>
                    </div>
                     <div class="form-group">
                        <span>
                            <label for="updatePhoneNum" style="width: 100px">手机:</label>
                            <input onblur="updatePhoneNum_check()"  onkeyup="value=value.replace(/[^\d]/g,'')" type="text" style="width: 300px;height: 34px" id="updatePhoneNum">
                            <span class=" control-label" id="updatePhoneNum_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>

                        </span>
                    </div>
                      <div class="form-group">
                        <span>
                            <label for="updateUserHouse_op" style="width: 100px;">所属养老院:</label>
                            <select style="width:300px;height: 34px;font-weight: bold" id="updateUserHouse_op" disabled="disabled">

                            </select>
                            <span class=" control-label" id="updateUserHouse_op_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>

                        </span>
                    </div>
                       <div class="form-group">
                        <span>
                            <label for="updateUser_op" style="width: 100px;">角色:</label>
                            <select style="width:300px;height: 34px;font-weight: bold" id="updateUser_op">         
                            </select>
                            <span class=" control-label" id="updateUser_op_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>

                        </span>
                    </div>     
                </div>
                <div class="modal-footer">
                    <button id="update_close_btn" type="button" class="btn btn-default" data-dismiss="modal" onclick="closeModal()">关闭</button>
                    <button type="button" class="btn btn-primary"  onclick="updateUser()">保存</button>
                </div>
                </div>
            </div>
        </div>
    </div>
</form>