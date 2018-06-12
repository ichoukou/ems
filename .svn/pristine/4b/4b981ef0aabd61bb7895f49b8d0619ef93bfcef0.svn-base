<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>库存台账</title>
    <style type="text/css" media="print">
        .notprint {visibility:hidden}
    </style>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="panel-body notprint" style="padding-bottom:0px;">

    <div class="panel panel-default" >
        <div class="panel-heading">查询条件</div>

        <div class="panel-body">
            <form id="formSearch" class="form-horizontal">
                <div class="form-group" style="margin-top:15px">

                    <label class="control-label col-sm-1" for="storageName">仓库名称</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="storageName" id="storageName" >

                        </select>
                    </div>

                    <label class="control-label col-sm-1" for="materialName">物资名称</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="materialName" id="materialName" >

                        </select>
                    </div>
                    <div class="col-sm-3">
                    </div>

                    <div class="col-sm-1" style="text-align:right;">
                        <button type="button" style="margin-left: 20px" id="btn_clear" class="btn btn-primary" onclick="queryclear();">清空</button>
                    </div>
                    <div class="col-sm-1" style="text-align:right;">
                        <button type="button" style="margin-left: 30px" id="btn_query" class="btn btn-primary" onclick="queryStockAccountList();">查询</button>
                    </div>

                </div>
            </form>
        </div>
    </div>

    <div id="toolbar" class="btn-group">

        <button  type="button" class="btn btn-success"  onclick="gotoPrint();">
            <span class="glyphicon glyphicon-print" aria-hidden="true"></span>&nbsp;&nbsp;&nbsp;打印
        </button>

    </div>

    <table id="tb_stockAccount"></table>
</div>

<!-- 控制修改按钮 -->
<button id="StockAccountPrint" type="button" class="btn btn-default notprint" data-toggle="modal" data-target="#printModal" style="display:none">
</button>

<!-- 全局js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/storage-goods/stockAccount.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>

<!-- Bootstrap table -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap-table-export.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/tableExport.js"></script>

<script type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}";
</script>
<jsp:include  page="./stockAccountListPrint.jsp"/>
<jsp:include  page="../alert.jsp"/>
</body>
</html>
