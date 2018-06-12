<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2016/12/26
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>老人请假</title>

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

    <div class="panel panel-default">
        <div class="panel-heading">查询条件
            <button type="button" style="margin-left: 780px" id="btn_query" class="btn btn-primary" onclick="queryOmLeave();">查询</button>
            <button type="button" style="margin-left: 20px" id="btn_clear" class="btn btn-primary" onclick="queryClear();">清空</button>

        </div>

        <div class="panel-body">
            <form id="formSearch" class="form-horizontal">
                <div class="form-group" style="margin-top:15px">

                    <div class="form-group" style="margin-top:15px">
                        <label class="control-label col-sm-1">老人姓名</label>
                        <div class="col-sm-2">
                            <input type="text" class="form-control" name="searchOldManID" id="searchOldManName"/>
                        </div>
                        <label class="control-label col-sm-1">状态</label>
                        <div class="col-sm-2">
                            <select class="form-control" name="searchLeaveStatus" id="searchLeaveStatus">
                                <option value="">--请选择--</option>
                                <option value="1">请假</option>
                                <option value="2">销假</option>
                            </select>
                        </div>
                        <label class="control-label col-sm-1">请假日期</label>
                        <div class="col-sm-2">
                            <input onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" type="text" class="form-control" id="startTime">
                        </div>
                        <label class="control-label col-sm-1">销假日期</label>
                        <div class="col-sm-2">
                            <input onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})" type="text" class="form-control" id="stopTime">
                        </div>

                    </div>
                </div>
            </form>
        </div>
    </div>

    <div id="toolbar" class="btn-group">

        <button id="btn_add" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addLeaveModal"  >
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>老人请假
        </button>

        <button  type="button" class="btn btn-success"  onclick="gotoUpdate()">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>老人销假
        </button>

        <button id="btn_delete" type="button" class="btn btn-default" onclick="gotoDelete()">
            <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除
        </button>
    </div>

    <table id="tb_leave"></table>
</div>

<!-- 控制修改按钮 -->
<button id="update_btn" type="button" class="btn btn-default" data-toggle="modal" data-target="#updateModal" style="display:none">
</button>

<jsp:include  page="oldManLeaveAdd.jsp"/>
<jsp:include  page="../common/oldManModal.jsp"/>
<jsp:include  page="oldManLeaveUpd.jsp"/>
<jsp:include  page="../alert.jsp"/>

<!-- 全局js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${pageContext.request.contextPath}/script/my97DatePicker/WdatePicker.js"></script>

<!-- Bootstrap table -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}";
</script>

<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/om-leave/omLeave.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/getOldMan.js"></script>

</body>
</html>

