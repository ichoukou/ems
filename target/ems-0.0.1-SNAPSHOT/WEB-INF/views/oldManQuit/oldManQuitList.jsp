<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>老人退住列表</title>

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
        <div class="panel-heading">查询条件</div>

        <div class="panel-body">
            <form id="formSearch" class="form-horizontal">
                <div class="form-group" style="margin-top:15px">

                    <label class="control-label col-sm-1" for="serviceItemName">老人姓名</label>
                    <div class="col-sm-2">
                            <input type="text" class="form-search" name="foldManName" id="foldManName"/>
                    </div>
                    <label class="control-label col-sm-1" for="serviceItemType">开始时间</label>
                    <div class="col-sm-2">
                       <input type="text" id="startDate"  class="Wdate" readonly="readonly" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}',lang:'en'})"/>
                    </div>
                    <label class="control-label col-sm-1" for="serviceItemType">终止时间</label>
                    <div class="col-sm-2">
                       <input type="text" id="endDate"  class="Wdate" readonly="readonly" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}',lang:'en'})"/> 
                    </div>
                    <div class="col-sm-1" style="text-align:left;">
                        <button type="button" style="margin-left: 20px" id="btn_clear" class="btn btn-primary" onclick="clearQueryInput();">清空</button>
                    </div>
                    <div class="col-sm-1" style="text-align:left;">
                        <button type="button" style="margin-left: 30px" id="btn_query" class="btn btn-primary" onclick="queryBy();">查询</button>
                    </div>

                </div>
            </form>
        </div>
    </div>
    <div id="toolbar" class="btn-group">
        <button  type="button" class="btn btn-success" id="addQuit_button" data-toggle="modal" data-target="#addModal" >
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
        </button>

        <!-- <button  type="button" class="btn btn-default"   data-toggle="modal" onclick="deleteLeave()">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span>撤销退住
        </button>
         -->
    </div>

    <table id="tb_oldManUnsubList"></table>
</div>

<!-- 控制修改按钮 -->
<button id="update_btn" type="button" class="btn btn-default" data-toggle="modal" data-target="#updateModal" style="display:none">
</button>
<button id="add_btn" type="button" class="btn btn-default" data-toggle="modal" data-target="#addModal" style="display:none">
</button>
<button id="type_add_btn" type="button" class="btn btn-default" data-toggle="modal" data-target="#typeAddModal" style="display:none">
</button>

<jsp:include  page="../alert.jsp"/>
<jsp:include page="./oldManQuitAdd.jsp"></jsp:include>
<jsp:include  page="../common/oldManModal.jsp"/>
<!-- 全局js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/oldManQuit/oldManQuitList.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>
<script src="${pageContext.request.contextPath}/script/my97DatePicker/WdatePicker.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/getOldMan.js"></script>

<!-- Bootstrap table -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

</body>
</html>
