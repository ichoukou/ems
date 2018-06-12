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
		<input type="hidden" name="rpaymentfid" id="rpaymentfid"/>
		<input type="hidden" name="fperiod" id="fperiod"/>
		<input type="hidden" name="fmoun" id="fmoun"/>
		
		<table id="tb_payment"></table>
		
		<table class="table table-bordered">
			<tr>
				<td>应该收款:</td>
				<td><span id="rpaymetTotal" style="display:none"></span><span id="rpaymetTotalShow"></span></td>
				<td style="display: none;">实际收款:</td>
				<td style="display: none;"><span id="pamentTotal"></span></td>
				<td>老人余额:</td>
				<td><span id="fendamount" style="display: none;"></span><span id="fendamountShow"></span></td>
				<td>现金:</td>
				<td><span><input name="famount" id="famount" type="text" onblur="getMorePaymentAmount()"/></span></td>
			</tr>
			
			<tr style="display: none;">
				<td>多缴费项目:</td>
				<td><span>
				<select id="fcostitem" name="fcostitem">
					
				</select>
				</span></td>
				<td>多缴费金额:</td>
				<td><span id="morePaymentAmount"></span></td>
			</tr>
			
			<tr>
				<td>费用日期:</td>
				<td><input type="date" id="fpaymentdate" name="fpaymentdate" value="${now }"></td>
				<td>费用备注:</td>
				<td colspan="3"><input type="text" id="fremarks" name="fremarks"/></td>
			</tr>
			
			<tr>
				<td colspan="6" style="color: red">【提醒：老人多交款或者少交款部分，系统会自动处理成下次费用；挂账表示，本次不做缴费处理。】</td>
			</tr>
		</table>
	</div>

	
	<script
		src="${pageContext.request.contextPath}/script/app-resources/expenses/paymentList.js"></script>
</body>
</html>
