<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2017/2/21
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>老人基本信息</title>
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
                <input type="hidden" id="imageName" value="">
                <img id="img_3" src="/ems/img/a1.jpg" style="height: 135px;width: 110px;">
                <%--<input type="file" name="myfiles" id="file_1" class="input_text" onchange="onChangFile('1')" style="width: 110px">--%>
                <%--<label id="add_file_1_base" style="color: red;width:140px;height: auto">&nbsp;&nbsp;&nbsp;</label>--%>
            </td>
        </tr>
        <tr>
            <td align="right" style="width:70px;">老人编号：</td>
            <td style="width: 150px">
                <span id="oldManNum"></span>
            </td>
            <td align="right" style="width:70px;">老人姓名：</td>
            <td style="width: 145px">
                <span id="oldMan_Name"></span>
            </td>
            <td align="right" style="width:70px;">老人性别：</td>
            <td>
                <span id="oldManIDnSex"></span>
            </td>
            <td align="right" style="width:80px;">&nbsp;老人状态：</td>
            <td>
                <span id="oldManStatusID" style="width: 90px;height: 23px"></span>
            </td>

        </tr>

        <tr>
            <td align="right">老人职业：</td>
            <td>
                <span id="occupation"></span>
            </td>
            <td align="right">出生日期：</td>
            <td>
                <span id="oldManBirth"></span>
            </td>
            <td align="right">政治面貌：</td>
            <td>
                <span id="oldManPoliticsID"></span>
            </td>
            <td align="right">老人民族：</td>
            <td>
                <span id="oldManNationID"></span>
            </td>

        </tr>
        <tr>
            <td align="right">媒体渠道：</td>
            <td>
                <span id="oldManMediaID"></span>
            </td>

            <td align="right">合同号：</td>
            <td>
                <span id="contractNo"></span>
            </td>
            <td align="right">合同开始：</td>
            <td>
                <span id="contractBegin"></span>
            </td>
            <td align="right">合同结束：</td>
            <td>
                <span id="contractEnd"></span>
            </td>
        </tr>

        <tr>
            <td align="right">医保类型：</td>
            <td>
                <span id="minsuranceType"></span>
            </td>
            <td align="right">老人卡号：</td>
            <td>
                <span id="oldManCardNo"></span>
            </td>
            <td align="right">办理人：</td>
            <td>
                <span id="transactor"></span>
            </td>
            <td align="right">护理员：</td>
            <td>
                <span id="nursing"></span>
            </td>
        </tr>

        <tr>
            <td align="right">老人信仰：</td>
            <td>
                <span id="oldManBeliefID"></span>
            </td>
            <td align="right">入住类型:</td>
            <td>
                <span id="oldManTypeID"></span>
            </td>
            <td align="right">老人手机：</td>
            <td>
                <span id="oldManMobile"></span>
            </td>
            <td align="right">入住日期：</td>
            <td>
                <span id="checkinTime"></span>
            </td>
        </tr>

        <tr>
            <td align="right">所住大厦：</td>
            <td>
                <span id="buildingID"></span>
            </td>

            <td align="right">所住房间：</td>
            <td>
                <span id="roomID"></span>
            </td>
            <td align="right">所住床位：</td>
            <td colspan="2">
                <span id="bedID"></span>
            </td>

        </tr>

        <tr>
            <td align="right">身份证号：</td>
            <td>
                <span id="oldManIdCard"></span>
            </td>

            <td align="right">护理级别：</td>
            <td colspan="4">
                <span id="nursingLevel"></span>
            </td>

        </tr>
        <tr>
            <td align="right">户籍：</td>
            <td colspan="8">
                <span id="oldManNative"></span>
            </td>
        </tr>
        <tr>
            <td align="right">说明：</td>
            <td colspan="8">
                <span id="instruction"></span>
                <%--<textarea style="width: 710px;" name="fInstruction" id=""></textarea>--%>
            </td>
        </tr>

        </tbody>
    </table>
</div>

</body>
</html>
<%--<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>--%>
<%--<script src="${pageContext.request.contextPath}/script/app-resources/old_man/oldManHosing.js"></script>--%>
