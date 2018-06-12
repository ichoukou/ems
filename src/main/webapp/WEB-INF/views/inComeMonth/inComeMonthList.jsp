<%--
  Created by IntelliJ IDEA.
  User: zhangxin
  Date: 2017/3/3
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>收入月报</title>

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

<body class="gray-bg">
<div class="panel-body" style="padding-bottom:0px;">

    <div class="panel panel-default notprint" >
        <div class="panel-heading">查询条件</div>

        <div class="panel-body">
            <form id="formSearch" class="form-horizontal">
                <div class="form-group" style="margin-top:15px">

                    <label class="control-label col-sm-2" for="searchTime">查询时间</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="searchTime" onFocus="WdatePicker({dateFmt:'yyyy-MM',alwaysUseStartDate:true})"/>
                    </div>
                    <div class="col-sm-3" style="text-align:left;">
                        <button type="button" style="margin-left:70px" id="clean_query" class="btn btn-default" onclick="cleanData();">清空</button>
                        <button type="button" id="btn_query" class="btn btn-primary" onclick="queryInCome();">查询</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div id="toolbar" class="btn-group notprint">

        <button  type="button" class="btn btn-success" onclick="gotoDetail()">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>明细
        </button>
        <button  type="button" class="btn btn-success" onclick="self.print();">
            <span class="glyphicon glyphicon-print" aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;打印
        </button>
    </div>

    <table id="tb_inComeMonth"></table>
</div>

<!-- 控制修改按钮 -->
<button id="update_btn" type="button" class="btn btn-default notprint" data-toggle="modal" data-target="#updateModal" style="display:none">
</button>
<jsp:include page="inComeMonthUpdate.jsp"/>
<jsp:include  page="../alert.jsp"/>

<!-- 全局js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/chargeManager/inComeMonth.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>
<script src="${pageContext.request.contextPath}/script/my97DatePicker/WdatePicker.js"></script>

<!-- Bootstrap table -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap-table-export.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/tableExport.js"></script>

</body>
</html>

