<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
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
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" id="modal" style="width: 1100px">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">新增员工</h4>
                </div>
                <div class="modal-body">
                    <div class="popover-content" style="width: 1000px;">
                        <table style="width: 950px;position: relative; top: -30px;">
                            <tbody>
                            <tr>
                                <td></td>
                                <td></td>
                                <td>&nbsp;</td>
                                <td>&nbsp;</td>
                                <td></td>
                                <td></td>
                                <td rowspan="8" style="text-align: center;vertical-align: middle;">
                                    <input type="hidden" id="imageName" value="">
                                    <img id="Imagel" src="/ems/img/a3.jpg" style="height: 135px;width: 110px;">
                                  <input onchange="onChangFile('1')" type="file" name="myfiles" id="FileUpload1" class="input_text" style="width: 110px">
                                  <label id="add_FileUpload1_message" style="color: red;width:140px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">姓名：</td>
                                <td>
                                    <input onblur="add_textName()" name="textName" type="text" id="txtName" placeholder="必填项" required style="width: 160px;height: 27px">
                                    <label id="add_textName_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                                <td align="right">性别：</td>
                                <td>
                                    <select onblur="add_addSex()" name="dropSex" id="addSex" class="input_text" required style="width: 160px;height: 27px">
                                        <option value="" selected="selected"></option>
                                        <option value="男">男</option>
                                        <option value="女">女</option>
                                    </select>
                                    <label id="add_addSex_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                                <td align="right">&nbsp;状态：</td>
                                <td>
                                   <select onblur="add_addStature()" name="dropStature" id="addStature" required style="width: 160px;height: 27px">
                                       <option value="" selected="selected"></option>
                                       <option value="在职">在职</option>
                                       <option value="离职">离职</option>
                                   </select>
                                    <label id="add_addStature_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                            </tr>
                            <tr>
                                </td>
                                <td align="right">民族：</td>
                                <td>
                                    <select name="nation" id="nation" class="input_text" required style="width: 160px;height: 27px">
                                    </select>
                                </td>
                                <td align="right">部门：</td>
                                <td>
                                <select onblur="add_addDepartment()" name="emp" id="addDepartment" required style="width: 160px;height: 27px">
                                </select>
                                    <label id="add_addDepartment_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                                <td align="right">职务：</td>
                                <td>
                                <select name="duty" id="addDuty" required style="width: 160px;height: 27px">
                                </select>
                                    <label id="add_addDuty_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">职称：</td>
                                <td>
                                    <select name="jobTitle" id="addJobTitle" required style="width: 160px;height: 27px">
                                    </select>
                                </td>
                                <td align="right">薪资类别：</td>
                                <td>
                                    <select name="sal" id="addSal" required style="width: 160px;height: 27px">
                                    </select>
                                </td>
                                <td align="right">身份证号：</td>
                                <td>
                                    <input onblur="add_idCard()" name="idCard" id="idCard" type="text" maxlength="18" required style="width: 160px;height: 27px">
                                    <label id="add_idCard_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">政治面貌：</td>
                                <td>
                                    <input name="political" type="text" maxlength="20" id="political"  required style="width: 160px;height: 27px">
                                </td>
                                <td align="right">入职日期：</td>
                                <td>
                                    <input onblur="add_inData()" onFocus="WdatePicker({readOnly:true,maxDate:'#F{$dp.$D(\'outData\')||\'new Date()\'}'})" type="text" id="inData" style="width: 160px;height: 27px">
                                    <label id="add_inData_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                                <td align="right">解聘日期：</td>
                                <td>
                                    <input onFocus="WdatePicker({readOnly:true,minDate:'#F{$dp.$D(\'inData\')}',maxDate:new Date()})" type="text" id="outData" style="width: 160px;height: 27px">
                                </td>
                            </tr>
                            <tr>
                                <td align="right">户籍：</td>
                                <td>
                                    <input name="census" type="text"  maxlength="40" id="census"  required style="width: 160px;height: 27px">
                                </td>
                                <td align="right">毕业院校：</td>
                                <td>
                                    <input name="school" type="text" maxlength="40" id="school" placeholder="" required style="width: 160px;height: 27px">
                                </td>
                                <td align="right">学历：</td>
                                <td>
                                    <select name="education" id="addEducation" required style="width: 160px;height: 27px">
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">专业：</td>
                                <td>
                                    <input name="major" type="text" maxlength="40" id="major" placeholder="" required style="width: 160px;height: 27px">
                                </td>
                                <td align="right">电脑水平：</td>
                                <td>
                                    <select name="computer" id="addComputer" required style="width: 160px;height: 27px">
                                    </select>
                                </td>
                                <td align="right">所持证书：</td>
                                <td>
                                    <input name="usbKey" type="text" maxlength="200" id="usbKey" placeholder="" required style="width: 160px;height: 27px">
                                </td>
                            </tr>
                            <tr>
                                <td align="right">银行卡号：</td>
                                <td>
                                    <input onblur="add_cardId()" name="cardId" type="text" maxlength="19" id="cardId"  required style="width: 160px;height: 27px">
                                    <label id="add_cardId_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                                <td align="right">固定电话：</td>
                                <td>
                                    <input name="FTel" type="text" maxlength="16" id="FTel" placeholder="010-7772222"  required style="width: 160px;height: 27px">
                                </td>
                                <td align="right">邮政编号：</td>
                                <td>
                                    <input name="FPostcode" type="text" id="FPostcode"  required style="width: 160px;height: 27px">
                                </td>
                            </tr>
                            <tr>
                                <td align="right">出生日期：</td>
                                <td>
                                    <input onblur="add_birth()" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" type="text" id="birth" style="width: 140px;height: 27px">
                                    <input name="Fruit" type="checkbox" value="农历" />农历
                                    <label id="add_birth_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                                <td align="right">婚姻状况：</td>
                                <td>
                                    <select name="marry" id="addMarry" required style="width: 160px;height: 27px">
                                    </select>
                                </td>
                                <td align="right">健康状况：</td>
                                <td>
                                    <input name="health" type="text" maxlength="20" id="health"  required style="width: 160px;height: 27px">
                                </td>
                            </tr>
                            <tr>
                                <td align="right">外语水平：</td>
                                <td>
                                    <select name="foreign" id="addForeign" required style="width: 160px;height: 27px">
                                    </select>
                                </td>
                                <td align="right">所属大厦：</td>
                                <td>
                                    <select onblur="add_FBuildingID()" name="FBuildingID" id="FBuildingID" required style="width: 160px;height: 27px">
                                    </select>
                                    <label id="add_FBuildingID_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                                <td align="right">手机：</td>
                                <td>
                                    <input onblur="add_FMobileTel()" name="FMobileTel" type="text" maxlength="11" id="FMobileTel"  required style="width: 160px;height: 27px">
                                    <label id="add_FMobileTel_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">养老院：</td>
                                <td>
                                    <select onblur="add_FNursinghomeID()" name="FNursinghomeID" id="FNursinghomeID" required style="width: 160px;height: 27px">
                                    </select>
                                    <label id="add_FNursinghomeID_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                                <td align="right">微信号：</td>
                                <td><input name="FWechatNumber" type="text" maxlength="20" id="FWechatNumber"  required style="width: 160px;height: 27px"></td>
                            </tr>
                            <tr>
                                <td align="right">通讯地址：</td>
                                <td colspan="2">
                                    <input name="Phone" type="text" maxlength="200" id="Phone"  required style="width: 270px;height: 27px">
                                </td>
                                <td align="right">备注：</td>
                                <td colspan="2">
                                    <input name="remark" type="text" maxlength="200" id="remark"  required style="width:240px;height: 27px">
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="modal-footer">
                    <button id="add_close_btn" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="addEmp()">保存</button>
                </div>
            </div>
        </div>

    </div>
</form>