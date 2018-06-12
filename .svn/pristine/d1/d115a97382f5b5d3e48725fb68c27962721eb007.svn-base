<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" id="modal" style="width: 500px">
            <div class="modal-content" style="background-color:#F0F0F0;">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">修改操作</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="emp_id">
                    <div align="center" class="popover-content" style="width: 450px;margin-left: 50px">
                        <table style="width: 600px;position: relative;max-width: 100%; background-color: transparent;border-collapse: collapse;border-spacing: 0;">
                            <tbody>
                            <tr>
                                <td >项目编号:</td>
                                <td>
                                    <input id="update_item_number" class="input_text" type="text"   placeholder="编号"  readonly style="width: 150px;height: 30px">
                                </td>
                            </tr>
                            <tr>
                                <td >项目类型:</td>
                                <td>
                                    <select id="update_item_type" class="input_text"  style="width: 150px;height: 30px">

                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td >项目名称:</td>
                                <td>
                                    <input id="update_item_name" class="input_text" type="text"   placeholder="项目名称" style="width: 150px;height: 30px" onblur="update_name_check()">
                                    <label id="update_itemname_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                            </tr>
                            <tr>
                                <td >项目单价:</td>
                                <td>
                                    <input id="update_item_price" class="input_text" type="text"  placeholder="保留两位小数" style="width: 150px;height: 30px" onblur="update_price_check()" onkeyup="value=value.replace(/[^\d.]/g,'')">
                                    <label id="update_price_message" style="color: red;width: 140px;height: auto"></label>
                                </td>
                            </tr>
                            <tr>
                                <td style="padding-top: 0px">项目单位:</td>
                                <td>
                                    <select id="update_item_unit" class="input_text"  style="width: 150px;height: 30px">

                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td >项目状态:</td>
                                <td>
                                    <select id="update_item_status" class="input_text" style="width: 150px;height: 30px">
                                        <%--<option value="1" selected>启用(默认)</option>--%>
                                        <option value="1" >启用</option>
                                        <option value="0" >禁用</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td >项目说明:</td>
                                <td rowspan="2">
                                    <textarea  id="update_item_explain" style="width:150px;height: 60px;resize: none;"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="modal-footer">
                    <button id="update_close_btn"  type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="updateHomeServiceItem()">修改</button>
                </div>
            </div>
        </div>

    </div>
</form>
