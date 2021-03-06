<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>删除查询</title>

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="panel-body" style="padding-bottom:0px;">

    <div class="panel panel-default">
        <div class="panel-heading">查询条件</div>

        <div class="panel-body">
            <form id="formSearch" class="form-horizontal">
            <div class="form-group row" style="margin-top:15px">
                <label class="control-label col-sm-1" for="deleteOperator">删除人：</label>
                <div class="col-sm-2">
                    <input class="form-control" name="deleteOperator" id="deleteOperator"style="width: 150px;" />
                </div>

                <label class="control-label col-sm-1" for="Edate">开始日期</label>
                <div class="col-sm-2">
                    <input id="Edate" class="form-control" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'Ldate\')}'})" style="width:150px; " />
                </div>

                <label class="control-label col-sm-1" for="Ldate">结束日期</label>
                <div class="col-sm-2" >
                    <input id="Ldate" class="form-control" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'Edate\')}'})" style="width:150px;" />
                </div>

                <div class="col-sm-3" style="text-align:left;" >
                    <button style="width: 100px;" type="button" id="btn_clear" class="btn btn-primary" onclick="queryclear()">清空</button>
                    <button style="width: 100px;margin-left: 10px" type="button" id="btn_query" class="btn btn-primary" onclick="queryFundDelList();">查询</button>
                </div>
            </div>
            </form>
        </div>
    </div>

    <table id="tb_fundDelRecord"></table>
</div>

<!-- 全局js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${pageContext.request.contextPath}/script/my97DatePicker/WdatePicker.js"></script>

<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/fundQuery/fundDelQuery.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>

<!-- Bootstrap table -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}";
</script>
<jsp:include  page="../alert.jsp"/>
</body>
</html>
