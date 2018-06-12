<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>定时任务</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="品胜" />
<meta http-equiv="description" content="品胜" />
<meta name="renderer" content="ie-stand">
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

body {
	padding-top: 20px;
}
a,div,button {
	cursor:pointer;
	outline:0 none !important; blr:expression(this.onFocus=this.blur()); 
}
</style>

<%-- <%@include file="/WEB-INF/views/common/base_bootstrap.jspf"%> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/script/app-resources/common/json2.js"></script>

<link rel="shortcut icon" href="favicon.ico">
<link
	href="${pageContext.request.contextPath}/script/lib/H+/css/bootstrap.min.css?v=3.3.6"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/script/lib/H+/css/font-awesome.css?v=4.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/script/lib/H+/css/plugins/bootstrap-table/bootstrap-table.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/script/lib/H+/css/animate.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/script/lib/H+/css/style.css?v=4.1.0"
	rel="stylesheet">

</head>

<body>
	
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				 <button class="btn btn-info btn-xs" type="button" onclick="open_add(this)">添加任务</button>
				 <button class="btn btn-danger btn-xs" type="button" onclick="open_cheak_job()">开启选中任务</button>
				 <button class="btn btn-danger btn-xs" type="button" onclick="pause_cheak_job()">暂停选中任务</button>
 				 <button class="btn btn-warning btn-xs" type="button" onclick="invoke_job()">立即执行一次</button>
				 
				 <!-- 暂停使用 
				 <button class="btn btn-warning" type="button" onclick="open_all_job()">开启所有任务</button>
				 <button class="btn btn-warning" type="button" onclick="pause_all_job()">暂停所有任务</button>
				 -->
			</div>
		</div>
	</div>
	
	<!-- quartz列表 start -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<!-- <table id="tb_quartzs" data-toggle="table" data-query-params="query_params" style="font-family: 'Helvetica Neue',Helvetica,Arial,sans-serif;font-size: 11px;">
					<thead>
						<tr>
							<th data-checkbox="true"></th>
							<th data-field="jobname">任务名</th>
							<th data-field="cronexpression">时间表达式</th>
							<th data-field="jobclass">执行类</th>
							<th data-field="triggername">触发器名</th>
							<th data-field="state" data-formatter="stare_formatter">状态</th>
							<th data-field="jobDataMap" data-formatter="jobDataMap_formatter">自定义参数</th>
							<th data-field="description">备注</th>
							<th data-formatter="edit">操作</th>
						</tr>
					</thead>
				</table> -->
				<table id="tb_quartzs"></table>
			</div>
		</div>
	</div>
	<!-- quartz列表 end -->
	
	
	<!-- 全局js -->
	<script
		src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>
	<script
		src="${pageContext.request.contextPath}/script/my97DatePicker/WdatePicker.js"></script>

	<!-- 自定义js -->
	<script
		src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
	<script
		src="${pageContext.request.contextPath}/script/app-resources/quartz/job/index.js"></script>
	<script
		src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>

	<!-- Bootstrap table -->
	<script
		src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
	
	<!-- query.form start-->
	<script src="${pageContext.request.contextPath}/script/lib/javascript/jquery.form.js"></script>
	<script src="${pageContext.request.contextPath}/script/lib/javascript/base.js"></script>
	<!-- query.form end-->
	
	<!-- confirm start -->
	<script src="${pageContext.request.contextPath}/script/lib/confirm/js/jquery-confirm.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/script/lib/confirm/js/jquery-confirm-default-params.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/script/lib/confirm/css/jquery-confirm.css" type="text/css"/>
	<!-- confirm end -->	

	<script type="text/javascript">
		var contextPath = "${pageContext.request.contextPath}";
	</script>
	
</body>
</html>
