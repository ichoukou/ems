<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <!-- Modal -->
 <form id="form_validate" class="form-horizontal">
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width:800px;">
    <div class="modal-content" >
      <div class="modal-header" >
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">新增部门</h4>
      </div>
      <div class="modal-body" >
         <div class="form-group">
		    <label for="addfHigherUpID">上级部门</label>
            <select class="form-control" id="addfHigherUpID" placeholder="fHigherUpID" name="fHigherUpID" style="width: 226px">
	    
	     </select>
  	   </div>
       <div class="form-group">

		    <label for="addfDepartmentName">部门名称   <span  id="addfDepartmentName_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
            </label>
		    <input  onblur="addEmp_check()" type="text" class="form-control" id="addfDepartmentName" placeholder="必填项" style="
    width: 226px">

       </div>
	  <div class="form-group">
	    <span><label for="addfDepartmentAttrbute" style="width: 100px" id="addfDepartmentAttrbute">部门属性:<span  id="addfDepartmentAttrbute_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span></label>
                           
                            <input type="radio" value="接待" name="fDepartmentAttrbute">
                                <label style="width: 47px">接待</label>
                            <input type="radio" value="运营" name="fDepartmentAttrbute">
                                <label style="width: 47px">运营</label>
                            <input type="radio" value="财务" name="fDepartmentAttrbute">
                                <label style="width: 47px">财务</label>
                            <input type="radio" value="护理" name="fDepartmentAttrbute">
                                <label style="width: 47px">护理</label>
                            <input type="radio" value="医疗" name="fDepartmentAttrbute">
                                <label style="width: 47px">医疗</label>
                            <input type="radio" value="餐饮" name="fDepartmentAttrbute">
                                <label style="width: 47px">餐饮</label>
                            <input type="radio" value="后勤" name="fDepartmentAttrbute">
                                <label style="width: 47px">后勤</label>
                            <input type="radio" value="行政" name="fDepartmentAttrbute">
                                <label style="width: 47px">行政</label>
                             <input type="radio" value="人事" name="fDepartmentAttrbute">
                                <label style="width: 47px">人事</label>
                        </span>
	  </div>
	  <div class="form-group">
	    <span><label for="addSortNumber">是否排班:
	    <input type="checkbox" class="form-control" id="addSortNumber" placeholder="SortNumber" name="fSortNumber" style=" width: 14px; height: 14px; display:inline-block;margin-left: 40px;margin-right: 10px;">是否为部门员工安排班次</label>
	    </span>
	  </div>
	    <div class="form-group">
	  <label for="addParameter">是否排人:
	    <input type="checkbox" class="form-control" id="addParameter" placeholder="Parameter" name="fParameter" style=" width: 14px; height: 14px; display:inline-block;margin-left: 40px;margin-right: 10px;" >是否为部门安排负责区域房间</label>
	  </div>
	  <div class="form-group">
	    <label for="addPortalType">是否排房:
	    <input type="checkbox" class="form-control" id="addPortalType" placeholder="PortalType" name="fPortalType" style=" width: 14px; height: 14px; display:inline-block;margin-left: 40px;margin-right: 10px;">是否为部门安排负责区域房间</label>
	  </div> 
	 
      </div>
      <div class="modal-footer" >
        <button type="button" id="add_emp1" class="btn btn-default"  data-dismiss="modal"  onclick="closeModal()">关闭</button>
        <button type="button" class="btn btn-primary"   onclick="addDepartmentManager()">保存</button>
      </div>
    </div>
  </div>

</div>
</form>