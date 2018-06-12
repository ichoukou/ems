<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/4
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">修改楼层</h4>
                </div>
                <div class="modal-body">

                    <input type="hidden" id="floor_id">
                    <input type="hidden"  class="form-control" id="updfNursinghomeID"  value="1">
                    <input type="hidden"  class="form-control" id="updfFloorNumber" name="updfFloorNumber" value="3">


                    <div class="form-group">
                        <label for="updfBuildingID">大厦名称</label>
                        <select id="updfBuildingID" class="form-control">
                            <%--<option value="裕惠大厦">裕惠大厦</option>--%>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="updfFLoorName">楼层名称</label>
                        <input onblur="check_upd()" type="text" class="form-control" id="updfFLoorName" placeholder="name">
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
                        <label for="updfAdministratorsID">楼层管理员</label>
                        <input type="text" class="form-control" id="updfAdministratorsID" placeholder="name">
                    </div>
                    <div class="form-group">
                        <label for="updfExplain">说明</label>
                        <textarea class="form-control" id="updfExplain" placeholder="value"></textarea>
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="updFloor()">保存</button>
                </div>
            </div>
        </div>

    </div>
</form>
