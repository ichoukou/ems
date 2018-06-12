<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>账户收入</title>

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/bootstrapvalidator/dist/css/bootstrapValidator.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="panel-body" style="padding-bottom:0px;">

    <div class="panel panel-default">
        <div class="panel-heading">账户收入</div>
        <div class="panel-body">
				<form id="form_validate" class="form-horizontal">
					<div class="form-group row" style="height: 50px;">
						<label class="control-label col-sm-1" for="fInAmount">收入金额</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" name="fInAmount" id="fInAmount"/>
						</div>
						<label class="control-label col-sm-1 " for="fInDate">收账日期</label>
						<div class="col-sm-2 ">
							<input class="form-control" style="width: 166px;" placeholder="点击选择时间"
								onFocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'nowtime\')}',readOnly:true})"
								type="text" class="form-control" id="fInDate" name="fInDate">
						</div>
						<label class="control-label col-sm-1 " for="fInPayments">收入杂项</label>
						<div class="col-sm-2 ">
							<select class="form-control" name="fInPayments"
								id="fInPayments">
							</select>
						</div>
					</div>
					<div class="form-group row" style="height: 50px;">
						<label class="control-label col-sm-1" for="fInFundaccount">记入账户</label>
						<div class="col-sm-2">
							<select class="form-control" name="fInFundaccount"
								id="fInFundaccount">
							</select>
						</div>
						<label class="control-label col-sm-1" for="fInBusinessitem">业务项目</label>
						<div class="col-sm-2">
						<select class="form-control" name="fInBusinessitem"
								id="fInBusinessitem">
							</select>
						</div>
						<label class="control-label col-sm-1" for="fInOperator">经手人</label>
						<div class="col-sm-2">
							<select class="form-control" name="fInOperator"
								id="fInOperator">
							</select>
						</div>
					</div>
					<div class="form-group row" style="height: 50px;">	
						<label class="control-label col-sm-1" for="fInPayment">支付人</label>
						<div class="col-sm-2">
						<input type="text" class="form-control" name="fInPayment" id="fInPayment"/>
						</div>
						<label class="control-label col-sm-1" for="fInProofdoc">凭据文件</label>
						<div class="col-sm-2">
						<input type="file" class="form-control" name="fInProofdoc" id="fInProofdoc"/>
						</div>
					</div>
					<div class="form-group row">
					<label for="fInRemarks" class="control-label col-sm-1">记账说明
					</label>
						<div class="col-sm-5">
							<textarea class="form-control" rows="3" style="resize: none;"
								name="fInRemarks" id="fInRemarks"></textarea>
						</div>
						<div class="col-sm-2">
							<input type="text" class="form-control"  style="visibility: hidden" name="nowtime" id="nowtime"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-3" style="text-align:center;">
                    	</div>
						<div class="col-sm-1" style="text-align:center;">
                        <button type="submit" style="margin-left: 30px" id="btn_query" class="btn btn-primary">保存</button>
                    	</div>
					</div>
				</form>
			</div>
    </div>
</div>
<!-- 全局js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/fundAccountIn/fundAccountIn.js"></script>
<script src="${pageContext.request.contextPath}/script/my97DatePicker/WdatePicker.js"></script>

<!-- Bootstrap table -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/bootstrapvalidator/dist/js/bootstrapValidator.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}";
</script>
<jsp:include  page="../alert.jsp"/>
</body>
</html>
