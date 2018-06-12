<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/4
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">修改大厦</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="building_id">

                    <input type="hidden"  class="form-control" id="updfNursinghomeID"  value="1">

                    <input type="hidden"  class="form-control" id="updfAdministratorsID" name="updfAdministratorsID" value="2">
                    <input type="hidden"  class="form-control" id="updfBuildingNumber" name="updfBuildingNumber" value="3">

                    <div class="form-group">
                        <label for="updName">大厦名称</label>
                        <input onblur="check_upd()" type="text" class="form-control" id="updName">
                        <label id="errorUpdName" style="color: red" >&nbsp;&nbsp;&nbsp;</label>
                    </div>
                    <div class="form-group">
                        <label for="updfStatus" >状态</label>
                        <select id="updfStatus" class="form-control">
                            <option >--请选择--</option>
                            <option value="11">启用</option>
                            <option value="10">禁用</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="updfExplain">说明</label>
                        <textarea class="form-control" id="updfExplain"></textarea>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="updBuilding()">保存</button>
                </div>
            </div>
        </div>

    </div>
</form>
