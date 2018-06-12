<%--
  Created by IntelliJ IDEA.
  User: zhangxin
  Date: 2017/2/28
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>历史账单</title>
    <style type="text/css" media="print">
        .notprint {visibility:hidden}
    </style>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/style.css?v=4.1.0" rel="stylesheet">
    <script type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
    </script>
</head>

<body class="gray-bg" >
<div class="panel-body" style="padding-bottom:0px;">

    <div class="panel panel-default ">
        <div class="panel-heading notprint">历史账单</div>
        <div class="panel-body ">
            <form id="formSearch" class="form-horizontal notprint">
                <div class="form-group row notprint" style="margin-top:15px">
                    <div class="col-sm-6" style="text-align:right;">
                        <label for="searchName" style="font-size: 18px;font-weight: bold">你正在查看老人</label>
                        <input type="hidden" id="oldManId">
                        <input type="text" style=" text-align: center; font-size: 18px;font-weight: bold;width:100px;border-style: solid; border-width: 0" id="searchName">
                        <label for="searchName" style="font-size: 18px;font-weight: bold">的信息</label>
                        <button type="button" id="clean_query" class="btn btn-primary" onclick="chooseOldMan();">选择老人</button>
                    </div>
                    <div class="col-sm-6" style="text-align:left;">
                        <label for="searchEntryDate" style="font-size: 18px;font-weight: bold">缴费日期</label>
                        <input id="searchEntryDate" type="text" onFocus="WdatePicker({readOnly:true,maxDate:'#F{$dp.$D(\'searchEndDate\')||\'new Date()\'}'})" style="width:120px;font-size:18px;font-weight: 100"/>
                        -
                        <input id="searchEndDate" type="text" onFocus="WdatePicker({readOnly:true,minDate:'#F{$dp.$D(\'searchEntryDate\')}',maxDate:new Date()})" style="width:120px;font-size:18px;font-weight: 100" />
                        <button type="button" id="btn_query" class="btn btn-primary" onclick="queryBillHistory();">查询</button>
                    </div>
                </div>
            </form>
            <div align="center">
                <table id="billHistory" border="1" width="840px">
                    <thead>
                    <tr><td width='83px;'></td><td width='83px;'></td><td width='83px;'></td><td width='83px;'></td>
                        <td width='83px;'></td><td width='83px;'></td><td width='83px;'></td><td width='83px;'></td>
                        <td width='83px;'></td><td width='83px;'></td></tr>
                    <tr><td colspan="10" style="font-size: 20px;font-weight: bold;text-align: center"><span>老人历史账单记录</span></td></tr>
                    <tr><td>期间：</td><td colspan="9"><span id="duringTime"></span></td></tr>
                    <tr><td>打印时间：</td><td colspan="9"><span id="printTime"></span></td></tr>
                    <tr><td>老人姓名：</td><td><span id="oldManName"></span></td>
                        <td>房间号：</td><td><span id="roomName" style="font-size: 12px;"></span></td>
                        <td>人数：</td><td><span id="roomCount"></span></td>
                        <td>入住日期：</td><td><span id="checkInDate"></span></td>
                        <td>退住日期：</td><td><span id="checkOutDate"></span></td>
                    </tr>
                    </thead>
                    <tbody id="oldManList">
                    <tr><td colspan="10" style="font-size: 14px;font-weight: bold;text-align: center"><span>缴费情况</span></td></tr>
                    <tr><td colspan="2">入账日期</td><td>账单号</td><td colspan="2">账单内容</td>
                        <td colspan="2">金额</td><td colspan="3">累计金额</td></tr>
                    <tr><td colspan="10" style="text-align: right"><span id="Sum">缴费合计：</span></td></tr>
                    <tr><td colspan="10" style="text-align: right"><span id="CapSum">大写合计：</span></td></tr>
                    </tbody>
                    <tfoot id="oldManCard">
                    <tr><td colspan="10" style="text-align: center;font-weight: bold;font-size: 14px">老人卡消费</td></tr>
                    <tr><td colspan="3">卡号</td><td colspan="2">状态</td><td colspan="2">金额</td>
                        <td colspan="3">说明</td></tr>
                    <tr><td colspan="10" style="text-align: right"><span id="paySum">消费合计：</span></td></tr>
                    <tr><td colspan="10" style="text-align: right"><span id="payCapSum">大写合计：</span></td></tr>
                    </tfoot>
                </table>
            </div>
        </div>
    </div>
</div>
<div class="col-sm-12 notprint" align="right">
    <button  type="button" class="btn btn-success"  style="margin-right: 60px" onclick="self.print();">
        <span class="glyphicon glyphicon-print" aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;打印
    </button>
</div>


<jsp:include  page="../common/oldManModal.jsp"/>
<jsp:include  page="../alert.jsp"/>

<!-- 全局js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/chargeManager/billHistory.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>
<script src="${pageContext.request.contextPath}/script/my97DatePicker/WdatePicker.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/getOldMan.js"></script>

<!-- Bootstrap table -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

</body>
</html>
