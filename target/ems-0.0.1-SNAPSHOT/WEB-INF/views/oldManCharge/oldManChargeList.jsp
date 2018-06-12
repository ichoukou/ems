<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2017/2/15
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>老人费用</title>

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/plugins/bootstrap-table/bootstrap-table.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/bootstrapvalidator/dist/css/bootstrapValidator.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/style.css?v=4.1.0" rel="stylesheet">
    <script type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
    </script>
</head>

<body class="gray-bg">
<div class="panel-body" style="padding-bottom:0px;">

    <div id="toolbar" class="btn-group">
        <button id="btn_add" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addOldManChargeModal">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>

        <button  type="button" class="btn btn-default"  onclick="clear_queryAllCharge()">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>清空
        </button>

        <button type="button" class="btn btn-success" onclick="queryAllCharge()">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>查询
        </button>

        <label class="control-label col-sm-2" style="margin-top: 7px">老人姓名</label>
        <div class="col-sm-4">
            <input type="hidden" id="searchOldManFid">
            <input onclick="selectOldManWithChargeList()" type="text" class="form-control" id="fOldManNameShow"/>
        </div>
    </div>
    <table id="tb_omChargeAll"></table>
</div>

<!-- 控制修改按钮 -->
<button id="update_btn" type="button" class="btn btn-default" data-toggle="modal" data-target="#updateModal" style="display:none">
</button>

<jsp:include  page="./oldManChargeAdd.jsp"/>
<jsp:include  page="./showOldManModal.jsp"/>
<jsp:include  page="../common/oldManModal.jsp"/>
<%--<jsp:include  page="../common/chooseOldMan.jsp"/>--%>
<%--<jsp:include  page="./cwglPaymentUpd.jsp"/>--%>
<jsp:include  page="../alert.jsp"/>

<!-- 全局js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>

<%--bootstrapValidator.js--%>
<script src="${pageContext.request.contextPath}/script/lib/bootstrapvalidator/dist/js/bootstrapValidator.js"></script>

<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/om-charge/oldManCharge.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/om-charge/getOldManWithChargeList.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/getOldMan.js"></script>

<!-- Bootstrap table -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

<script type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}";
</script>

</body>
</html>
