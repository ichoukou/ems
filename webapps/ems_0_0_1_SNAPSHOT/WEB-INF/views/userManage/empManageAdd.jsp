<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Modal -->
<form id="formSearch" class="form-horizontal">
    <div style="overflow-y: auto;" class="modal fade" id="empModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="width: 1100px">
   
            <div class="modal-content">
                <div class="modal-header">
                 <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加员工 <span class=" control-label" id="emp_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                    </h4>
                </div>
                <div class="modal-body" style="padding-top: 0px;padding-bottom: 0px;padding-left: 0px;padding-right: 0px;">
                <div class="panel-body" style="padding-bottom:0px;">
                <!-- 条件查询 --> 
                   <div class="panel-body">
                <div class="form-group" style="margin-top:15px">

                    <label class="control-label col-sm-1" for="searchEmpName">姓名</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="searchEmpName" style="width: 150px">
                    </div>

                    <label class="control-label col-sm-1" for="searchEmpStatus">状态</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="searchStatus" id="searchEmpStatus"style="width: 150px">
                            <option value="">选择员工状态</option>
                            <option value="在职">在职</option>
                            <option value="离职">离职</option>
                        </select>
                    </div>
                    <label class="control-label col-sm-1" for="searchEmpDepartment">部门</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="searchDepartment" id="searchEmpDepartment"style="width: 150px">
                        </select>
                    </div>
                    <div class="col-sm-1 " >
                        <button type="button"  id="btn_query" class="btn btn-primary" onclick="queryMessage()">查询</button>
                    </div>

                    <div class="col-sm-1 ">
                        <button type="button"  id="btn_clear" class="btn btn-primary" onclick="clearMessage()">清空</button>
                    </div>
                    <div class="col-sm-1 "></div>
                </div>
        </div>              
 <div class="form-group " style="margin-left: 50px;margin-right: 50px;margin-bottom: 10px;" >
<table id="tb_empManger" class="table table-hover"  border="1" height="10px" width="10px">

</table>
</div>
                        
   </div>                 
                    
                    
                </div>
                
                
                <div class="modal-footer">
                   <span class=" control-label" id="emp_footer_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span> 
                    <button  type="button" class="btn btn-primary"  onclick="addEmp()">添加</button>                                
                </div>
                
                
                
                
            </div>
        </div>
        </div>
</form>