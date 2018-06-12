$(function () {
	//初始化页面查询 当期未交费老人人数
	getOldmanTotalNopayment();
	
	//初始化页面 当前老人余额表期数
	getOldManBlance();
	
});

function getOldmanTotalNopayment(){
	$.ajax({
        type: "POST",
        url: contextPath+"/mouthblance/getOldmanTotalNopayment.do",
        data : {},
        success: function(rs){
			if(rs){
				$("#oldmanTotalNopayment").html(rs);
			}
    	 }
	});
};

function getOldManBlance(){
	$.ajax({
        type: "POST",
        url: contextPath+"/mouthblance/getOldManBlance.do",
        data : {},
        success: function(rs){
			if(rs){
				var periodAndMouth="";
				var fperiod=rs.fperiod;
				var fmoun=rs.fmoun;
				
				periodAndMouth=fperiod+"年"+fmoun+"月";
				
				$("#periodAndMouth").html(periodAndMouth);
			}
    	 }
	});
};

function paymentSubmit(){
	//开始动画
	showwaiting();
	$.ajax({
        type: "POST",
        url: contextPath+"/mouthblance/paymentSubmit.do",
        data : {},
        success: function(rs){
			if(rs){
				alertx(rs.msg);
				
				//结束动画
				closewaiting();
				
				//初始化页面查询 当期未交费老人人数
				getOldmanTotalNopayment();
				
				//初始化页面 当前老人余额表期数
				getOldManBlance();
			}else{
				alertx(rs.msg);
				
				//结束动画
				closewaiting();
			}
    	 }
	});
}

function paymentSubmitBack(){
	$.confirm({
        title: '',
        content : "是否确认反结账?",
        confirmButton : '确认',
        icon : '',
        columnClass : 'col-md-offset-4 col-md-4',
        confirm : function(){
        	paymentSubmitBackReal();
            return true;
        }
    });
}

function paymentSubmitBackReal(){
	//开始动画
	showwaiting();
	$.ajax({
        type: "POST",
        url: contextPath+"/mouthblance/paymentSubmitBack.do",
        data : {},
        success: function(rs){
			if(rs){
				alertx(rs.msg);
				
				//结束动画
				closewaiting();
				
				//初始化页面查询 当期未交费老人人数
				getOldmanTotalNopayment();
				
				//初始化页面 当前老人余额表期数
				getOldManBlance();
			}else{
				alertx(rs.msg);
				
				//结束动画
				closewaiting();
			}
    	 }
	});
}
