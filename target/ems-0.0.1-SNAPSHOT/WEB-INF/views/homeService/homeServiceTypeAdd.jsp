<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Modal -->
<style>
    .popover-content{
        padding-bottom: 14px;
        padding-top: 14px;
    }
    tr {
        padding-bottom: 14px;
        padding-top: 14px;
    }
    td {
        vertical-align: middle;
        padding-bottom: 7px;
        font-size: 14px;
    }
    table {
        max-width: 100%;
        background-color: transparent;
        border-collapse: collapse;
        border-spacing: 0;
    }
    .modal-content{
        background-color:#F0F0F0;
    }
</style>
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="typeAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" id="modal" style="width: 500px">
            <div class="modal-content" style="background-color:#F0F0F0;">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">类型增加</h4>
                </div>
                <div class="modal-body">
                    <div align="center" class="popover-content" style="width: 450px;margin-left: 50px">
                        <table style="width: 600px;position: relative;max-width: 100%; background-color: transparent;border-collapse: collapse;border-spacing: 0;">
                            <tbody>
                            <tr>
                                <td >类型编号:</td>
                                <td>
                                    <input id="type_add_number" class="input_text" type="text"   placeholder="类型编号" readonly style="width: 150px;height: 30px">
                                </td>
                            </tr>
                            <tr>
                                <td >类型名称:</td>
                                <td>
                                    <input  id="type_add_name" class="input_text" type="text"  placeholder="类型名称"  style="width: 150px;height: 30px">
                                    <label id="type_add_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="modal-footer">
                    <button id="typeadd_close_btn" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="addHomeServiceType()">增加</button> </div>
            </div>
        </div>
    </div>
</form>