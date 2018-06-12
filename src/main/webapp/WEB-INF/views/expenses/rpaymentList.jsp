<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>入住缴费应缴费</title>

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

<body class="gray-bg">
	<div class="panel-body" style="padding-bottom: 0px;">
		<div class="panel panel-default">
			<div class="panel-body">
				<form id="formSearch" class="form-horizontal">
						<div class="form-inline" role="serchFrom"
							style="margin-bottom: 10px;">
								<!-- 1查询条件 -->
								<div class="input-group">
									<div class="input-group-addon">老人姓名</div>
									 <input type="text" class="form-control" id="searchOldmanName">
								</div>
			                    
			                     <!-- 2查询条件 -->
			                    <div class="input-group">
									<div class="input-group-addon">护理级别</div>
									<select class="form-control input-sm" id="searchNursingLevel" name="searchNursingLevel">
										
									</select>
								</div>
			                    
			                    <!-- 3查询条件 -->
			                    <div class="input-group">
									<div class="input-group-addon">老人状态</div>
									<select class="form-control input-sm" id="searchOldmanStatus" name="searchNursingLevel">
										
									</select>
								</div>
			                    
			                    <!-- 4查询条件 -->
			                    <div class="input-group">
									<div class="input-group-addon">房间号</div>
									<input type="text" class="form-control" id="searchRoomName">
								</div>
						</div>
						
						<div class="form-inline" role="serchFrom"
							style="margin-bottom: 10px;">
								<!-- 1查询条件 -->
			                    <div class="input-group">
							     	<div class="input-group-addon">费用标准</div>
							     	<div onclick="getChargeStandard()">
							     		<input type="hidden" id="searchChargeStandardId" name="searchChargeStandardId"/>
							       		<input type="text" class="form-control input-sm" name="searchChargeStandard" id="searchChargeStandard" readonly>
							       		<span class="glyphicon glyphicon-search form-control-feedback my" aria-hidden="true"></span>
							    	</div>
						    	</div>
			                    
			                     <!-- 2查询条件 -->
								<div class="input-group">
							    	<div class="input-group-addon">入住时间</div>
							      <input id="searchStartDate" type="text" onFocus="WdatePicker({readOnly:true})" style="width:120px;font-size:18px;font-weight: 100"/>
		                           &nbsp;-&nbsp;
								   <input id="searchEndDate" type="text" onFocus="WdatePicker({readOnly:true})" style="width:120px;font-size:18px;font-weight: 100" />
			                	</div>
			                	
			                									<!-- 操作按钮2 -->
								<div class="form-group" style="margin-left: 20px;">
									<button type="button" class="btn btn-default btn-sm"
										onclick="resetSearch()">清空</button>
									<button type="button" class="btn btn-primary btn-sm"
										onclick="queryRpayment()">搜索</button>
								</div>
						</div>

				</form>
			</div>
		</div>

		<table id="tb_rpayment"></table>
	</div>

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
		src="${pageContext.request.contextPath}/script/app-resources/expenses/rpaymentList.js"></script>
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
