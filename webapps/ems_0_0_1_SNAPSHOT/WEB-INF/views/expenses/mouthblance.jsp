<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>缴费月结</title>

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
	<div id="waiting"></div><!-- 动画效果 -->
	<div class="panel-body" style="padding-bottom: 0px;background-color: #96CDCD">
		<div class="container-fluid" style="font-size: 11px;overflow:auto;" ng-app="ruleAddApp" id="ruleadd" f/>
		<div align="center" style="font-size: 20px;">
		<div class="row" style="background-color: white;">
			<span>系统结账后可以选择反结账返回上一期进行处理业务,</span>
			<span>再进行结账处理</span>
		</div>
		<div lass="row">
			<span>目前还有</span><span id="oldmanTotalNopayment">0</span>
			<span>个老人没有交费,如果结账,费用可在下个月收费</span>
		</div>
		
		<div class="row">
			<span>当前期间:</span><span id="periodAndMouth">2017年3月</span>
		</div>
		
		<!-- 操作按钮3 -->
		<div class="form-group" style="margin-left: 10px;">
			<button type="button" id="paymentSubmit" style="font-size: 20px;margin-left: 10px;color: green;" class="btn btn-primary btn-sm"
			onclick="paymentSubmit()">结账</button>	
			<button type="button" id="paymentSubmitBack" style="font-size: 20px;margin-left: 10px;color: green;" class="btn btn-danger btn-sm"
			onclick="paymentSubmitBack()">反结账</button>	
		</div>
			
		</div>
		</div>
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
		src="${pageContext.request.contextPath}/script/app-resources/expenses/mouthblance.js"></script>
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
	<script src="${pageContext.request.contextPath}/script/lib/javascript/spin.js"></script>
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
