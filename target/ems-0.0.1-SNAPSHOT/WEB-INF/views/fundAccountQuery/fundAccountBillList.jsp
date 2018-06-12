<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>收支查询</title>

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
        <div class="panel-heading">查询条件</div>

        <div class="panel-body">
				<form id="formSearch" class="form-horizontal">
					<div class="form-group row" style="height: 50px;">
						<label class="control-label col-sm-1" for="fType">类型</label>
						<div class="col-sm-2">
							<select class="form-control" name="fType"
								id="fType">
								<option value=''></option>
								<option value='0'>期初</option>
								<option value='1'>转账</option>
								<option value='2'>收入</option>
								<option value='3'>支出</option>
							</select>
						</div>
						<label class="control-label col-sm-1" for="fPayments">收支杂项</label>
						<div class="col-sm-2">
								<select class="form-control" name="fPayments"
								id="fPayments">
							</select>
						</div>
						<label class="control-label col-sm-1 " for="startDate">记账日期</label>
						<div class="col-sm-2 ">
                       		<input type="text" id="startDate"  class="Wdate" readonly="readonly" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',minDate:'#F{$dp.$D(\'startDate\')}',lang:'en'})"/> 
						</div>
						<label class="control-label col-sm-1 " for="endDate">至</label>
						<div class="col-sm-2 ">
							 <input type="text" id="endDate"  class="Wdate" readonly="readonly" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'#F{$dp.$D(\'endDate\')}',lang:'en'})"/>
						</div>
					</div>
					<div class="form-group row" style="height: 50px;">
						<label class="control-label col-sm-1" for="fBusinessitem">项目</label>
						<div class="col-sm-2">
							<select class="form-control" name="fBusinessitem"
								id="fBusinessitem">
							</select>
						</div>
						<label class="control-label col-sm-1" for="fPayment">收支对象</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" name="fPayment" id="fPayment"/>
						</div>
						<label class="control-label col-sm-1" for="fFundaccount">记入账户</label>
						<div class="col-sm-2">
							<select class="form-control" name="fFundaccount"
								id="fFundaccount">
							</select>
						</div>
						<label class="control-label col-sm-1" for="foperator">经手人</label>
						<div class="col-sm-2">
							<input type="text" class="form-control" name="foperator" id="foperator"/>
						</div>
					</div>
					<div class="form-group row">
					<label class="control-label col-sm-1" for="fStatus">状态</label>
						<div class="col-sm-2">
							<select class="form-control" name="fStatus" id="fStatus">
								<option></option>
								<option value='0'>已审核</option>
								<option value='1'>未审核</option>
							</select>
						</div>
					<div class="col-sm-1" style="text-align:left;">
                        <button type="button" style="margin-left: 20px" id="btn_clear" class="btn btn-primary" onclick=" clearQueryInput()">清空</button>
                    </div>
						<div class="col-sm-1" style="text-align:left;">
                        <button type="button" style="margin-left: 30px" id="btn_query" class="btn btn-primary" onclick="queryBy()">查询</button>
                    	</div>
					</div>
				</form>
			</div>
    </div>
    <div id="toolbar" class="btn-group">
         <button  type="button" class="btn btn-info" id="updateButton" data-toggle="modal" onclick="getUpdateModal()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>修改
        </button>
        <button  type="button" class="btn btn-default" id="deleteButton" data-toggle="modal" onclick="getDeleteModal()">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span>删除 
        </button>
    </div>
    <table id="tb_fundAccountBill"></table>
</div>

<!-- 控制修改 -->					
<button id="updInBill_btn" type="button" class="btn btn-default" data-toggle="modal" data-target="#fundAccountBillUpd" style="display:none">
</button>
<!-- 控制修改 -->					
<button id="updOutBill_btn" type="button" class="btn btn-default" data-toggle="modal" data-target="#fundAccountBillOutUpd" style="display:none">
</button>
<!-- 控制删除 -->
<button id="deldBill_btn" type="button" class="btn btn-default" data-toggle="modal" data-target="#fundAccountBillDel" style="display:none">
</button>
<!-- 全局js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/fundAccountQuery/fundAccountBillList.js"></script>
<script src="${pageContext.request.contextPath}/script/my97DatePicker/WdatePicker.js"></script>

<!-- Bootstrap table -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/bootstrapvalidator/dist/js/bootstrapValidator.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/bootstrap-export/bootstrap-table-export.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/bootstrap-export/tableExport.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}";
</script>
<jsp:include  page="../alert.jsp"/>
<jsp:include page="./fundAccountBillUpd.jsp"/>
<jsp:include page="./fundAccountBillOutUpd.jsp"/>
<jsp:include page="./fundAccountBillDel.jsp"/>
</body>
</html>
