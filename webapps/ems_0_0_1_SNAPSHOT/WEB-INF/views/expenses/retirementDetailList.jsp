<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>入住缴费实缴费</title>
</head>

<body class="gray-bg">
	<div class="panel-body" style="padding-bottom: 0px;" id="paymentListForm">
		<input type="hidden" name="foldmanid" id="foldmanid"/>
		<table id="tb_retirementDetailList"></table>
		
		<table class="table table-bordered">
			<tr>
				<td>应该收款:</td>
				<td><span id="rpaymetTotal"></span></td>
				<td>实际收款:</td>
				<td><span id="pamentTotal"></span></td>
				<td>老人应交余额:</td>
				<td><span id="fendamount"></span></td>
			</tr>
			
			<!-- <tr>
				<td>多缴费项目:</td>
				<td><span>
				<select id="fcostitem" name="fcostitem">
					
				</select>
				</span></td>
			</tr> -->
			
			<tr>
				<td>费用日期:</td>
				<td><input type="date" id="fpaymentdate" name="fpaymentdate" value="${now }"></td>
				<td>费用备注:</td>
				<td colspan="3"><input type="text" id="fremarks" name="fremarks"/></td>
			</tr>
			
			<!-- <tr>
				<td colspan="6" style="color: red">【提醒：老人多交款或者少交款部分，系统会自动处理成下次费用；挂账表示，本次不做缴费处理。】</td>
			</tr> -->
		</table>
	</div>

	
	<script
		src="${pageContext.request.contextPath}/script/app-resources/expenses/retirementDetailList.js"></script>
</body>
</html>
