<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2017/1/12
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>财务管理</title>

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <%--<link href="${pageContext.request.contextPath}/script/lib/H+/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">--%>
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/bootstrapvalidator/dist/css/bootstrapValidator.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="panel-body" style="padding-bottom:0px;">

    <%--<div class="panel panel-default">--%>
        <%--<div class="panel-heading">查询条件</div>--%>

        <%--<div class="panel-body">--%>
            <%--<form id="formSearch" class="form-horizontal">--%>
                <%--<div class="form-group" style="margin-top:15px">--%>

                    <%--<label class="control-label col-sm-1">名称</label>--%>
                    <%--<div class="col-sm-3">--%>
                        <%--<input type="text" class="form-control" id="searchName">--%>
                    <%--</div>--%>

                    <%--<label class="control-label col-sm-1">数据</label>--%>
                    <%--<div class="col-sm-3">--%>
                        <%--<input type="text" class="form-control" id="searchValue">--%>
                    <%--</div>--%>

                    <%--<div class="col-sm-4" style="text-align:left;">--%>
                        <%--<button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary" onclick="queryDictionary();">查询</button>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</form>--%>
        <%--</div>--%>
    <%--</div>--%>

    <div style="width:49%;display: inline-block;">
        <span class="btn btn-info">收入用途分类</span>
        <button style="float: right" id="btn_add" type="button" class="btn btn-info" onclick="get_to_add()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>
        <table id="tb_cwglPayment"></table>
    </div>

    <div style="width:50%;display: inline-block;">
        <span class="btn btn-info">支出用途分类</span>
        <button style="float: right" type="button" class="btn btn-info" onclick="goto_addOut()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>
        <table id="tb_cwglPaymentOut"></table>
    </div>
</div>

<!-- 控制修改按钮 -->
<button id="update_btn" type="button" class="btn btn-default" data-toggle="modal" data-target="#updateModal" style="display:none">
</button>
<button id="updateOut_btn" type="button" class="btn btn-default" data-toggle="modal" data-target="#updateOutModal" style="display:none">
</button>
<button id="add_btn" type="button" class="btn btn-default" data-toggle="modal" data-target="#addModal" style="display:none">
</button>
<button id="addOut_btn" type="button" class="btn btn-default" data-toggle="modal" data-target="#addOutModal" style="display:none">
</button>
<jsp:include  page="./cwglPaymentAdd.jsp"/>
<jsp:include  page="./cwglPaymentAddOut.jsp"/>
<jsp:include  page="./cwglPaymentUpd.jsp"/>
<jsp:include  page="./cwglPaymentUpdOut.jsp"/>
<jsp:include  page="../alert.jsp"/>

<!-- 全局js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>

<%--bootstrapValidator.js--%>
<script src="${pageContext.request.contextPath}/script/lib/bootstrapvalidator/dist/js/bootstrapValidator.js"></script>

<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/cwgl-payment/cwglPayment.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>

<!-- Bootstrap table -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}";
</script>

</body>
</html>
