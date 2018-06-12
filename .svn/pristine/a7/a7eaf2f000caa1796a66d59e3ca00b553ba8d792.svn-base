<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2016/12/4
  Time: 17:43
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
                    <h4 class="modal-title" id="myModalLabel">新增大厦</h4>
                </div>
                <div class="modal-body">

                    <%--<input type="hidden"  class="form-control" id=""  value="1">--%>

                    <input type="hidden"  class="form-control" id="addfAdministratorsID" name="addfAdministratorsID" value="2">
                    <input type="hidden"  class="form-control" id="addfBuildingNumber" name="addfBuildingNumber" value="3">

                    <div class="form-group">
                        <label for="addName">大厦名称</label>
                        <input onblur="check_addName()" type="text" class="form-control" id="addName" placeholder="必填项">
                        <label id="errorName" style="color: red" >&nbsp;&nbsp;&nbsp;</label>
                    </div>
                    <div class="form-group">
                        <label for="addfStatus" >状态</label>
                        <select onblur="check_addfStatus()" id="addfStatus" class="form-control">
                            <option value="">--请选择--</option>
                            <option value="11">启用</option>
                            <option value="10">禁用</option>
                        </select>
                        <label id="errorType" style="color: red" >&nbsp;&nbsp;&nbsp;</label>
                    </div>
                    <div class="form-group">
                        <label for="addfExplain">说明</label>
                        <textarea class="form-control" id="addfExplain" placeholder="value"></textarea>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" onclick="closeModal()">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="addBuilding()">保存</button>
                </div>
            </div>
        </div>

    </div>
</form>