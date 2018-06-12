<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>库存盘点</title>
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
<div class="panel-body notprint" style="padding-bottom:0px; ">

    <div class="panel panel-default">
        <div class="panel-heading">查询条件:</div>

        <div class="panel-body">
            <form id="formSearch" class="form-horizontal">

                <div class="form-group row" style="margin-top:15px">
                    <label class="control-label col-sm-1" for="storage">仓库</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="storage" id="storage"style="width: 150px;" >

                        </select>
                    </div>
                    <label class="control-label col-sm-1" for="Edate">开始日期</label>
                    <div class="col-sm-2">
                        <input id="Edate" class="form-control" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'Ldate\')}'})" style="width:150px; " />
                    </div>

                    <label class="control-label col-sm-1" for="Ldate">结束日期</label>
                    <div class="col-sm-2" >
                        <input id="Ldate" class="form-control" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'Edate\')}'})" style="width:150px;" />
                    </div>

                    <div class="col-sm-3" style="text-align:center;" >
                        <button  type="button" id="btn_clear" class="btn btn-primary" onclick="queryclear()">清空</button>
                        <button  style=" margin-left: 50px" type="button" id="btn_query" class="btn btn-primary" onclick="queryCheckList();">查询</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div id="toolbar" class="btn-group">

        <button  type="button" class="btn btn-primary"  onclick="go_to_add()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true">物品盘点</span>
        </button>
    </div>

    <table id="tb_storageCheckList"></table>
</div>

<!-- 控制修改按钮 -->
<button id="add_btn" type="button" class="btn btn-default notprint" data-toggle="modal" data-target="#addModal" style="display:none">
</button>
<button id="print_btn" type="button" class="btn btn-default notprint" data-toggle="modal" data-target="#printModal" style="display:none">
</button>


<!-- 全局js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${pageContext.request.contextPath}/script/my97DatePicker/WdatePicker.js"></script>
<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/storage-goods/storageCheck.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>

<!-- Bootstrap table -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}";
</script>
<jsp:include  page="./storageCheckAdd.jsp"/>
<jsp:include  page="./storageCheckPrint.jsp"/>
<jsp:include  page="../alert.jsp"/>
</body>
</html>

