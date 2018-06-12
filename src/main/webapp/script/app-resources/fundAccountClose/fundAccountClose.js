$(function(){
	// getNowTime();
	getBalanceDate();
});


function getBalanceDate(){
	$.ajax({
		url:contextPath+"/fundAccColse/getMaxDate.do",
		type:"post",
		data:{
			
		},
		success:function(data){
			var msg=data.msg;
			$("#fDate").val(msg);
		}
	});
}

/**
 * 结账
 */
function jieZhang(){
	var fDate=$("#fDate").val();
	$.ajax({
		url:contextPath+"/fundAccColse/closeAccount.do",
		type:"post",
		data:{
			fDate:fDate
		},
		success:function(data){
			if(data.msg=="1"){
				alert("本期无数据");
			}else if(data.msg=="2"){
				alert("结账成功");
				getBalanceDate();
			}else{
				alert("结账失败");
			}
		}
	});
}
/**
 * 反结账
 */
function balanceBack(){
	var fDate=$("#fDate").val();
	$.ajax({
		url:contextPath+"/fundAccColse/balanceBack.do",
		type:"post",
		data:{
			fDate:fDate
		},
		success:function(data){
			//alert(data.msg);
			if(data.msg=="0"){
				alert("反结算成功");
				//getBalanceDate();
			}else if(data.msg=="-1"){
				alert("无历史结算记录");
				//getBalanceDate();
			}else{
				alert("反结算失败");
			}
			getBalanceDate();
		}
	});
}
