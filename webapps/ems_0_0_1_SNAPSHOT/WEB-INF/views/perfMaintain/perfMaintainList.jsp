<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>绩效维护</title>
	
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

					<label class="control-label col-sm-1" for="searchName">员工</label>
					<div class="col-sm-2">
						<select class="form-control" id="searchName">
						</select>
					</div>

					<label class="control-label col-sm-1" for="searchFPerformanceYear">考核年份</label>
					<div class="col-sm-2">
						<select name="leaveData" class="form-control" id="searchFPerformanceYear">
						</select>
					</div>

					<label class="control-label col-sm-1" for="searchFPerformanceMonth">考核月份</label>
					<div class="col-sm-2">
						<select class="form-control" name="searchFPerformanceMonth" id="searchFPerformanceMonth"style="width: 150px">
						</select>
					</div>
					<div class="col-sm-3" style="text-align:left;">
						<button type="button" style="margin-left:70px" id="clean_query" class="btn btn-default" onclick="cleanData();">清空</button>
						<button type="button" id="btn_query" class="btn btn-primary" onclick="queryMaintain();">查询</button>
					</div>
				</div>
			</form>
		</div>
	</div>

	<div id="toolbar" class="btn-group">
		<button id="btn_add" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal" >
			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
		</button>

		<button  type="button" class="btn btn-success"  onclick="gotoUpdate()">
			<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
		</button>

		<button id="btn_delete" type="button" class="btn btn-default" onclick="gotoDelete()">
			<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>禁用
		</button>
	</div>

	<table id="tb_perfMainTain"></table>
</div>
 
	<!-- 控制修改按钮 -->
	<button id="update_btn" type="button" class="btn btn-default" data-toggle="modal" data-target="#updateModal" style="display:none">
	   </button>
	<jsp:include  page="./perfMainTainAdd.jsp"/>
	<jsp:include  page="./perfMainTainUpdate.jsp"/>
	<jsp:include  page="../alert.jsp"/>

    <!-- 全局js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
	<script src="${pageContext.request.contextPath}/script/app-resources/empManager/perfMainTain.js"></script>
	<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>
	
    <!-- Bootstrap table -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
	<script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap-table-export.js"></script>
	<script src="${pageContext.request.contextPath}/script/lib/H+/js/tableExport.js"></script>

</body>
</html>
