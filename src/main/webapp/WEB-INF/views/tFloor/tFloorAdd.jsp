<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2016/12/4
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">新增楼层</h4>
                </div>
                <div class="modal-body">

                    <input type="hidden"  class="form-control" id="addfFloorNumber" name="addfFloorNumber" value="3">

                    <div class="form-group" style="display: inline-block;">
                        <label for="addfBuildingID">大厦名称</label>
                        <select onblur="addCheck_BuildingID_floor()" id="addfBuildingID" class="form-control" style="width: 300px">
                            <%--<option value="裕惠大厦">裕惠大厦</option>--%>
                        </select>

                    </div>
                    &nbsp;&nbsp;&nbsp;<label id="errorName" style="color: red" >&nbsp;&nbsp;&nbsp;</label>

                    <div class="form-group" style="display: inline-block;">
                        <label for="addfFLoorName">楼层名称</label>
                        <input onblur="addCheck_floorName_floor()" type="text" class="form-control" id="addfFLoorName" placeholder="必填项"  style="width: 300px">
                    </div>
                    <label id="errorFloorName" style="color: red" >&nbsp;&nbsp;&nbsp;</label>

                    <div class="form-group" style="display: inline-block;">
                        <label for="addfStatus" >状态</label>
                        <select onblur="addCheck_Status_floor()" id="addfStatus" class="form-control"  style="width: 300px">
                            <option value="">--请选择--</option>
                            <option value="11">启用</option>
                            <option value="10">禁用</option>
                        </select>
                    </div>
                    <label id="errorType" style="color: red" >&nbsp;&nbsp;&nbsp;</label>

                    <div class="form-group">
                        <label for="addfAdministratorsID">楼层管理员</label>
                        <input type="text" class="form-control" id="addfAdministratorsID" placeholder="name"  style="width: 300px">
                    </div>
                    <div class="form-group">
                        <label for="addfExplain">说明</label>
                        <textarea class="form-control" id="addfExplain" placeholder="value"></textarea>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" onclick="closeModal()">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="addFloor()">保存</button>
                </div>
            </div>
        </div>

    </div>
</form>