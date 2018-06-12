<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>老人入住</title>

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/bootstrap-toastr/toastr.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/style.css?v=4.1.0" rel="stylesheet">
    <script type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
    </script>
</head>

<body class="gray-bg">
<div class="panel-body" style="padding-bottom:0px;">

    <div class="panel panel-default">
        <div class="panel-body">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group" style="margin-top: 15px">
						<label class="control-label col-sm-1">姓名</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="searchName">
						</div>
						<div class="col-sm-1" style="text-align: left;">
							<button type="button" style="margin-left: 20px" id="btn_clear"
								class="btn btn-primary" onclick="clearSearch()">清空</button>
						</div>
						<div class="col-sm-1" style="text-align: left;">
							<button type="button" style="margin-left: 30px" id="btn_query"
								class="btn btn-primary" onclick="queryBy();">查询</button>
						</div>
					</div>
				</form>
			</div>
    </div>

    <div id="toolbar" class="btn-group">

        <button id="btn_add" type="button" class="btn btn-primary" data-toggle="modal" onclick="getAddRelation()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加亲属
        </button>
        <button id="btn_updheal" type="button" class="btn btn-primary" onclick="queryRelation()"  >
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>查询
        </button>
    </div>
    <table id="tb_oldManMain"></table>
</div>

<!-- 控制修改按钮 -->
 <button id="addRelation_btn" type="button" class="btn btn-default" data-toggle="modal" data-target="#relationAdd" style="display:none">
</button>
<button id="updRel_btn" type="button" class="btn btn-default" data-toggle="modal" data-target="#healthyUpd" style="display:none">
</button>
<button id="queryRelation_btn" type="button" class="btn btn-default" data-toggle="modal" data-target="#relationList" style="display:none">
</button>
<jsp:include  page="./getOldManRelationList.jsp"/>
<jsp:include  page="./oldManRelationAdd.jsp"/>
<jsp:include  page="./oldManRelationUpd.jsp"/>
<jsp:include  page="../common/oldManModal.jsp"/>
<jsp:include  page="../alert.jsp"/>
<!-- 全局js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${pageContext.request.contextPath}/script/my97DatePicker/WdatePicker.js"></script>

<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/getOldMan.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>

<%--文件上傳js--%>
<script src="${pageContext.request.contextPath}/script/lib/ajaxfileupload.js"></script>

<!-- Bootstrap table -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/bootstrapvalidator/dist/js/bootstrapValidator.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/bootstrap-toastr/toastr.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/bootstrap-toastr/toastr.setting.js"></script>
<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/old_man/oldManRelation.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/old_man/oldManRelationAdd.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/old_man/oldManRelationQuery.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/old_man/oldManRelationUpd.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>
<script type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}";
</script>
</body>
</html>

