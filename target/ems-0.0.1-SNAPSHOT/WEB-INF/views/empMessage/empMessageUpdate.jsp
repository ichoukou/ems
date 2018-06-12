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
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" id="modal" style="width: 1100px">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">更新操作</h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="emp_id">
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
                                    <input type="hidden" id="up_imageName" value="">
                                    <img id="Imagel2" src="/ems/img/a3.jpg" style="height: 135px;width: 110px;">
                                    <input type="file" name="myfiles" id="updateFileUpload2" onchange="onUpdateFile('2')" class="input_text" style="width: 110px">
                                    <label id="update_FileUpload1_message" style="color: red;width:140px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">姓名：</td>
                                <td>
                                    <input onblur="update_textName()" name="textName" type="text" maxlength="3" id="updatetxtName" placeholder="必填项" required style="width: 160px;height: 27px">
                                    <label id="update_textName_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                                <td align="right">性别：</td>
                                <td>
                                    <select onblur="update_addSex()" name="dropSex" id="updateSex" class="input_text" required style="width: 160px;height: 27px">
                                        <option value=""></option>
                                        <option value="男">男</option>
                                        <option value="女">女</option>
                                    </select>
                                    <label id="update_addSex_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                                <td align="right">&nbsp;状态：</td>
                                <td>
                                    <select onblur="update_addStature()" name="dropStature" id="updateStature" required style="width: 160px;height: 27px">
                                        <option value=""></option>
                                        <option value="在职">在职</option>
                                        <option value="离职">离职</option>
                                    </select>
                                    <label id="update_addStature_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">民族：</td>
                                <td>
                                    <select name="nation" id="updateNation" class="input_text" required style="width: 160px;height: 27px">
                                    </select>
                                </td>
                                <td align="right">部门：</td>
                                <td>
                                    <select onblur="update_addDepartment()" name="emp" id="updateDepartment" required style="width: 160px;height: 27px">
                                    </select>
                                    <label id="update_addDepartment_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                                <td align="right">职务：</td>
                                <td>
                                    <select name="duty" id="updateDuty" required style="width: 160px;height: 27px">
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">职称：</td>
                                <td>
                                    <select name="jobTitle" id="updateTitle" required style="width: 160px;height: 27px">
                                    </select>
                                </td>
                                <td align="right">薪资类别：</td>
                                <td>
                                    <select name="sal" id="updateSal" required style="width: 160px;height: 27px">
                                    </select>
                                </td>
                                <td align="right">身份证号：</td>
                                <td>
                                    <input onblur="update_idCard()" name="idCard" id="updateIdentityCardID" type="text" maxlength="18" id="" placeholder="必填项" required style="width: 160px;height: 27px">
                                    <label id="update_idCard_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">政治面貌：</td>
                                <td>
                                    <input name="political" type="text" maxlength="20" id="updatePoliticalStatus"  required style="width: 160px;height: 27px">
                                </td>
                                <td align="right">入职日期：</td>
                                <td>
                                    <input onblur="update_inData()" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" type="text" id="updateEntryDate" style="width: 160px;height: 27px">
                                    <label id="update_inData_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>

                                <td align="right">解聘日期：</td>
                                <td>
                                    <input onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" type="text" id="updateDismissalDate" style="width: 160px;height: 27px">
                                </td>
                            </tr>
                            <tr>
                                <td align="right">户籍：</td>
                                <td>
                                    <input name="census" type="text" maxlength="40" id="updateCensus"  required style="width: 160px;height: 27px">
                                </td>
                                <td align="right">毕业院校：</td>
                                <td>
                                    <input name="school" type="text" maxlength="40" id="updateGraduateSchool" placeholder="" required style="width: 160px;height: 27px">
                                </td>
                                <td align="right">学历：</td>
                                <td>
                                    <select name="education" id="updateEducation" required style="width: 160px;height: 27px">
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">专业：</td>
                                <td>
                                    <input name="major" type="text" maxlength="40" id="updateMajor" placeholder="" required style="width: 160px;height: 27px">
                                </td>
                                <td align="right">电脑水平：</td>
                                <td>
                                    <select name="computer" id="updateComputer" required style="width: 160px;height: 27px">
                                    </select>
                                </td>
                                <td align="right">所持证书：</td>
                                <td>
                                    <input name="usbKey" type="text" maxlength="200" id="updateCertificate" placeholder="" required style="width: 160px;height: 27px">
                                </td>
                            </tr>
                            <tr>
                                <td align="right">银行卡号：</td>
                                <td>
                                    <input onblur="update_cardId()" name="cardId" type="text" maxlength="19" id="updateBankCard"  required style="width: 160px;height: 27px">
                                    <label id="update_cardId_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                                <td align="right">固定电话：</td>
                                <td>
                                    <input name="FTel" type="text" maxlength="16" id="updateTel" placeholder="010-7772222" required style="width: 160px;height: 27px">
                                </td>
                                <td align="right">邮政编号：</td>
                                <td>
                                    <input name="FPostcode" type="text" maxlength="11" id="updatePostcode"  required style="width: 160px;height: 27px">
                                </td>
                            </tr>
                            <tr>
                                <td align="right">出生日期：</td>
                                <td>
                                    <input onblur="update_birth()" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" type="text" id="updateBirth" style="width: 140px;height: 27px">
                                    <input name="updateFruit" id="updateFruit" type="checkbox" value="1" />农历
                                    <label id="update_birth_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                                <td align="right">婚姻状况：</td>
                                <td>
                                    <select name="marry" id="updateMaritalStatus" required style="width: 160px;height: 27px">
                                    </select>
                                </td>
                                <td align="right">健康状况：</td>
                                <td>
                                    <input name="health" type="text" maxlength="20" id="updateHealth"  required style="width: 160px;height: 27px">
                                </td>
                            </tr>
                            <tr>
                                <td align="right">外语水平：</td>
                                <td>
                                    <select name="foreign" id="updateLanguageLevel" required style="width: 160px;height: 27px">
                                    </select>
                                </td>
                                <td align="right">所属大厦：</td>
                                <td>
                                    <select onblur="update_FBuildingID()" name="FBuildingID" id="updateBuildingID" required style="width: 160px;height: 27px">
                                    </select>
                                    <label id="update_FBuildingID_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                                <td align="right">手机：</td>
                                <td>
                                    <input onblur="update_FMobileTel()" name="FMobileTel" type="text" maxlength="11" id="updateMobileTel"  required style="width: 160px;height: 27px">
                                    <label id="update_FMobileTel_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                            </tr>
                            <tr>
                                <td align="right">养老院：</td>
                                <td>
                                    <select onblur="update_FNursinghomeID()" name="updateFNursinghomeID" id="updateFNursinghomeID" required style="width: 160px;height: 27px">
                                    </select>
                                    <label id="update_FNursinghomeID_message" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                </td>
                                <td align="right">微信号：</td>
                                <td><input name="updateFWechatNumber" type="text" maxlength="20" id="updateFWechatNumber"  required style="width: 160px;height: 27px"></td>
                            </tr>
                            <tr>
                                <td align="right">通讯地址：</td>
                                <td colspan="2">
                                    <input name="Phone" type="text" maxlength="200" id="updateMalingAddress"  required style="width: 270px;height: 27px">
                                </td>
                                <td align="right">备注：</td>
                                <td colspan="2">
                                    <input name="remark" type="text" maxlength="200" id="updateRemark"  required style="width: 240px;height: 27px">
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="modal-footer">
                    <button id="update_close_btn" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" onclick="updateEmp()">保存</button>
                </div>
            </div>
        </div>

    </div>
</form>