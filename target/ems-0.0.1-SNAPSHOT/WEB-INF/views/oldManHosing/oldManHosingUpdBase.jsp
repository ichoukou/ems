<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2017/2/6
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="updBaseModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

        <div class="modal-dialog" style="width: 1050px">
            <div class="modal-content" style="height: 500px">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">修改老人基本信息</h4>
                </div>

                <head>
                    <title>Title</title>
                    <style>
                        select{
                            width: 90px;
                            height: 23px;
                        }
                    </style>
                </head>
                <body>
                <div class="popover-content" style="width: 1000px;">
                    <table style="">
                        <tbody>
                        <tr>
                            <td></td>
                            <td></td>
                            <td>&nbsp;</td>
                            <td>&nbsp;</td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td rowspan="8" style="text-align: center;vertical-align: middle;">
                                <img id="img_2" src="/ems/img/a3.jpg" style="height: 135px;width: 110px;">
                                <input type="file" name="myfiles" id="file_2" class="input_text" onchange="onChangFile('2')" style="width: 110px">
                                <%--<label id="upd_file_1_base" style="color: red;width:140px;height: auto">&nbsp;&nbsp;&nbsp;</label>--%>
                            </td>
                        </tr>
                        <tr>

                            <input id="updfid" type="hidden">
                            <input id="fNursingHomeID" type="hidden" value="33">
                            <td align="right" style="width:70px;">老人编号：</td>
                            <td style="width: 170px">
                                <input  id="updfoldManNum" type="hidden">
                                <input placeholder="自动生成" readonly="readonly" type="text" maxlength="4"  required style="width: 90px;height: 23px">
                            </td>
                            <td align="right" style="width:70px;">老人姓名：</td>
                            <td style="width: 130px">
                                <input onblur="updCheck_name_base()" name="foldManName" type="text" maxlength="8" id="updfoldManName" placeholder="必填项" required style="width: 90px;height: 23px">
                                <label id="upd_name_base" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>

                            </td>
                            <td align="right" style="width:70px;">老人性别：</td>
                            <td>
                                <select name="fOldManIDnSex" id="updfOldManIDnSex">
                                </select>
                            </td>
                            <td align="right" style="width:80px;">&nbsp;老人状态：</td>
                            <td>
                                <select name="foldManStatusID" id="updfoldManStatusID" required style="width: 90px;height: 23px">

                                </select>
                            </td>

                        </tr>

                        <tr>
                            <td align="right">老人职业：</td>
                            <td>
                                <select id="updfoccupation" name="foccupation">

                                </select>
                            </td>
                            <td align="right">出生日期：</td>
                            <td>
                                <input onblur="updCheck_birth_base()" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" type="text" id="updfoldManBirth" style="width: 70px;height: 23px">
                                <label id="upd_birth_base" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                                <input id="updfoldManIsLunar" type="checkbox" value="农历" />农历
                            </td>
                            <td align="right">政治面貌：</td>
                            <td>
                                <select name="foldManPoliticsID" id="updfoldManPoliticsID">

                                </select>
                                <%--<input  type="text" maxlength="4"   required style="width: 90px;height: 23px">--%>
                            </td>
                            <td align="right">老人民族：</td>
                            <td>
                                <select name="foldManNationID" id="updfoldManNationID">

                                </select>
                            </td>

                        </tr>
                        <tr>
                            <td align="right">媒体渠道：</td>
                            <td>
                                <select name="foldManMediaID" id="updfoldManMediaID">

                                </select>
                                <%--<input  type="text" maxlength="10"   required style="width: 90px;height: 23px">--%>
                            </td>

                            <td align="right">合同号：</td>
                            <td>
                                <input name="fcontractNo" type="text" maxlength="4" id="updfcontractNo"  required style="width: 90px;height: 23px">
                            </td>
                            <td align="right">合同开始：</td>
                            <td>
                                <input onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" type="text" id="updfcontractBegin" style="width: 90px;height: 23px">
                                <%--<label id="upd_fcontractBegin_base" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>--%>
                            </td>
                            <td align="right">合同结束：</td>
                            <td>
                                <input onblur="updCheck_contentStopDate_base()" onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" type="text" id="updfcontractEnd" style="width: 90px;height: 23px">
                                <label id="upd_fcontractEnd_base" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                            </td>
                        </tr>

                        <tr>
                            <td align="right">医保类型：</td>
                            <td>
                                <select id="updfMInsuranceType" name="fMInsuranceType">

                                </select>
                                <%--<input name="fMInsuranceType" type="text" maxlength="11" id="fMInsuranceType"  required style="width: 90px;height: 23px">--%>
                            </td>
                            <td align="right">老人卡号：</td>
                            <td>
                                <input type="text" maxlength="10" id="updfoldManCardNo"  required style="width: 90px;height: 23px">
                            </td>
                            <td align="right">办理人：</td>
                            <td>
                                <input name="ftransactor" type="text" maxlength="11" id="updftransactor"  required style="width: 90px;height: 23px">
                            </td>
                            <td align="right">护理员：</td>
                            <td>
                                <input name="fnursing" type="text" maxlength="11" id="updfnursing"  required style="width: 90px;height: 23px">
                            </td>
                        </tr>

                        <tr>
                            <td align="right">老人信仰：</td>
                            <td>
                                <select name="foldManBeliefID" id="updfoldManBeliefID">

                                </select>
                            </td>
                            <td align="right">入住类型</td>
                            <td>
                                <select name="foldManTypeID" id="updfoldManTypeID" required style="width: 90px;height: 23px">

                                </select>
                            </td>
                            <td align="right">老人手机：</td>
                            <td>
                                <input onblur="updCheckMobilePhone()" name="updfoldManMobile" type="text" maxlength="11" id="updfoldManMobile"  required style="width: 90px;height: 23px">
                                <label id="upd_foldManMobile_base" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                            </td>
                            <td align="right">入住日期：</td>
                            <td>
                                <input onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" name="fcheckinTime" type="text" maxlength="10" id="updfcheckinTime"  required style="width: 90px;height: 23px">
                                <%--<label id="upd_fcheckinTime_base" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>--%>
                            </td>
                        </tr>

                        <tr>
                            <td align="right">所住大厦：</td>
                            <td>
                                <select  onblur="updCheck_buildingID_base()" name="fbuildingID" id="updfbuildingID" style="width: 90px;height: 23px">

                                </select>
                                <label id="upd_build_base" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>

                            </td>

                            <td align="right">所住房间：</td>
                            <td>
                                <select  onblur="updCheck_roomID_base()" id="updfroomID">

                                </select>
                                <label id="upd_froomID_base" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                            </td>
                            <td align="right">所住床位：</td>
                            <td colspan="2">
                                <select id="updfbedID" onchange="addBedPrice()" style="width: 90px">

                                </select>
                                <%--<label id="upd_fbedID_base" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>--%>
                                <input value="9" name="updfisEntire" id="updfisEntire" type="checkbox" onclick="myUpdGray(this)"/>整租
                            </td>

                        </tr>

                        <tr>
                            <td align="right">身份证号：</td>
                            <td>
                                <input  onblur="updCheck_cardId_base()" id="updfoldManIdCard" type="text" maxlength="18" id="" placeholder="必填项" required style="width: 135px;height: 23px">
                                <label id="upd_cardId_base" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                            </td>

                            <td align="right">护理级别：</td>
                            <td colspan="2">
                                <select id="updfnursingLevel">

                                </select>
                                <%--<input type="text" id="updfnursingLevel" name="fnursingLevel" style="width: 90px;height: 23px">--%>
                                <%--<input type="hidden" id="updNursingLevelId">--%>
                                <%--<label id="upd_fnursingLevel_base" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>--%>
                                <%--<button id="btn_add" type="button" data-toggle="modal" data-target="#addModal" onclick="showName()" >--%>
                                    <%--<span  aria-hidden="true"></span>定级--%>
                                <%--</button>--%>
                            </td>

                        </tr>
                        <tr>
                            <td align="right">户籍：</td>
                            <td colspan="8">
                                <input onblur="updCheck_oldManNative_base()" type="text" maxlength="200" id="updfoldManNative"  required style="width: 710px;height: 23px">
                                <label id="upd_foldManNative_base" style="color: red;width:10px;height: auto">&nbsp;&nbsp;&nbsp;</label>
                            </td>
                        </tr>
                        <tr>
                            <td align="right">说明：</td>
                            <td colspan="8">
                                <textarea style="width: 710px;" name="fInstruction" id="updfInstruction"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4" style="text-align:center;vertical-align:middle;">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            </td>
                            <td colspan="4" style="text-align:center;vertical-align:middle;">
                                <button type="button" class="btn btn-primary" id="baseBtn" onclick="updBase()">修改</button>
                            </td>
                        </tr>

                        </tbody>
                    </table>
                </div>

                </body>

            </div>
        </div>

    </div>
</form>