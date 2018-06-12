<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2017/2/27
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="updateOutModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="width:400px;">
            <div class="modal-content" >
                <div class="modal-header" >
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">更新分类</h4>
                </div>
                <div class="modal-body" >
                    <input id="updateOut_id" hidden/>
                    <input id="fnursinghomeID" value="414" hidden/>
                    <div class="form-group">
                        <label for="updateOut_father_id">所属父类</label>
                        <input type="hidden" id="old_updateOut_father_id">
                        <select class="form-control" id="updateOut_father_id" onchange="check_updOut_RefatherId()" name="fHigherUpID" style="width: 250px;height: 35px">

                        </select>
                    </div>
                    <div class="form-group">
                        <label for="updOutfname">分类名称</label>
                        <input type="text" class="form-control" id="updOutfname" placeholder="必填项" style="width: 250px;height: 30px">
                        <label id="updateOut_name_message" style="color: red;width: 250px;height: auto" >&nbsp;&nbsp;&nbsp;</label>
                    </div>
                    <%--<div class="form-group">--%>
                    <%--<label style="font-size: 14px;">类型:</label>--%>
                    <%--<input type="checkbox" id="chkItem1" name="checkboxUpd" value="1">支出--%>
                    <%--<input type="checkbox" id="chkItem2" name="checkboxUpd" value="0">收入--%>
                    <%--&lt;%&ndash;<label id="add_type_message" style="color: red;width: 250px;height: auto" >&nbsp;&nbsp;&nbsp;</label>&ndash;%&gt;--%>
                    <%--</div>--%>
                    <%--<div class="form-group">--%>
                    <%--<label for="update_sorting_name">分类名称</label>--%>
                    <%--<input type="text" class="form-control" id="update_sorting_name" placeholder="必填项" style="width: 250px;height: 35px" onblur="update_name_check()">--%>
                    <%--<label id="update_name_message"  style="color: red;width: 250px;height: 20px" >&nbsp;&nbsp;&nbsp;</label>--%>
                    <%--</div>--%>
                    <%--<div class="form-group" >--%>
                    <%--<label for="update_remarks">备注</label>--%>
                    <%--<textarea type="text" class="form-control" id="update_remarks"  style="width: 250px;height: 80px;resize: none;"></textarea>--%>

                    <%--</div>--%>
                </div>
                <div class="modal-footer">
                    <button id="updateOut_btn" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary"  onclick="updateOutCwglPayment()">修改</button>
                </div>
            </div>
        </div>

    </div>
</form>
