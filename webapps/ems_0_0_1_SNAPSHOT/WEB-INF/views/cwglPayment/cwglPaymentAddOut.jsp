<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2017/2/27
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="addOutModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="width:400px;">
            <div class="modal-content" >
                <div class="modal-header" >
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">添加支出分类</h4>
                </div>
                <div class="modal-body" >
                    <input id="add_number" hidden/>
                    <div class="form-group">
                        <label>所属父类</label>
                        <select class="form-control" id="addOut_father_id"  name="fHigherUpID" style="width: 250px;height: 30px">
                            <%--<input class="form-control" id="addfparentid">--%>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="addOutfname">分类名称</label>
                        <input type="text" class="form-control" id="addOutfname" placeholder="必填项" style="width: 250px;height: 30px">
                        <label id="addOut_name_message" style="color: red;width: 250px;height: auto" >&nbsp;&nbsp;&nbsp;</label>
                    </div>
                    <%--<div class="form-group">--%>
                        <%--<label style="font-size: 14px;">类型:</label>--%>
                        <%--<input type="checkbox" id="checkbox1" name="checkbox" value="1">支出--%>
                        <%--<input type="checkbox" id="checkbox2" name="checkbox" value="0">收入--%>
                        <%--<label id="add_type_message" style="color: red;width: 250px;height: auto" >&nbsp;&nbsp;&nbsp;</label>--%>
                    <%--</div>--%>
                </div>
                <div class="modal-footer">
                    <button id="add_btn" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary"  onclick="addOutPayment()">保存</button>
                </div>
            </div>
        </div>

    </div>
</form>
