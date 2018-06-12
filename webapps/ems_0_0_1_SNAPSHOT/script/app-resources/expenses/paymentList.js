$(function () {
	
});

function open_init_comp(foldmanid,fid){
	$("#foldmanid").val(foldmanid);
	$("#rpaymentfid").val(fid);
	
	//获取老人当期的 余额
	var flag = getOldManBlanceCurrent(foldmanid,fid);
	
	//初始化数据展示列表
	initPaymentTable();
	
	//初始化老人所有的费用项目的下拉框
	//initFcostitem(foldmanid);
	
	//默认设置缴费日期为当天日期
	//var now=formatDate(new Date());
	
	//$("#fpaymentdate").val(now);
}

function initPaymentTable(){
	  $('#tb_payment').bootstrapTable({
		   url: contextPath+'/payment/queryPaymentList.do',   //请求后台的URL（*）
		   method: 'get',      //请求方式（*）
		   toolbar: '',    //工具按钮用哪个容器
		   striped: true,      //是否显示行间隔色
		   cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		   pagination: false,     //是否显示分页（*）
		   sortable: false,      //是否启用排序
		   sortOrder: "asc",     //排序方式
		   queryParams:  function (params) {
				  var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
						   pageSize: params.limit, // 页面大小
						   page: params.offset, //页码
						   foldmanid : $("#foldmanid").val()
					  };
					  return temp;
					 },//传递参数（*）
		   sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		   pageNumber:1,      //初始化加载第一页，默认第一页
		   pageSize: 10,      //每页的记录行数（*）
		   pageList: [10, 25, 50, 100],  //可供选择的每页的行数（*）
		   search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		   strictSearch: true,
		   showColumns: true,     //是否显示所有的列
		   showRefresh: true,     //是否显示刷新按钮
		   minimumCountColumns: 2,    //最少允许的列数
		   clickToSelect: true,    //是否启用点击选中行
		   height: 350,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		   uniqueId: "fid",      //每一行的唯一标识，一般为主键列
		   showToggle:false,     //是否显示详细视图和列表视图的切换按钮
		   showRefresh : false,  //是否显示刷新按钮
		   showColumns : false,  //是否显示列表下拉按钮
		   cardView: false,     //是否显示详细视图
		   detailView: false,     //是否显示父子表
		   showFooter:true,       //是否显示列脚
		   singleSelect : true,
				   columns : [{
					title : '编号',
					field : 'fid',
					align : 'center',
					valign : 'middle',
					sortable : false
				},{
					title : '类型',
					field : 'paymentType',
					align : 'center',
					valign : 'middle',
					sortable : false
				},{
					title : '状态',
					field : '',
					align : 'center',
					valign : 'middle',
					sortable : false,
					formatter : function(value,row,index){
						var html="";
						if(Number(row.fArPaymentAmount)<0){
							html+="<select name='paymantStatus' disabled='disabled' id='paymantStatus"+index+"' dataRowFid='"+row.fid+"'  onchange=\"paymantStautsChange('"+index+"','"+row.fArPaymentAmount+"')\">";
						}else{
							html+="<select name='paymantStatus' id='paymantStatus"+index+"' dataRowFid='"+row.fid+"'  onchange=\"paymantStautsChange('"+index+"','"+row.fArPaymentAmount+"')\">";
						}
						html+="<option value='1'>待交款</option>";
						html+="<option value='2'>挂账</option>";
						html+="</select>";
						return html;
					}
				},{
					title : '金额',
					field : 'fArPaymentAmount',
					align : 'center',
					valign : 'middle',
					sortable : false,
					formatter : function(value,row,index){
						value=parseFloat(value+"").toFixed(2);
						var html="";
						
						html+="<input type='text' name='fArPaymentAmount' id='fArPaymentAmount"+index+"' value='"+value+"' readonly/>";
							
						return html;
					}
				}, {
					title : '说明',
					field : 'period',
					align : 'center',
					valign : 'middle',
					sortable : false,
					formatter:function(value,row,index){
						if(row.fbiztype=="2"){
							return "减免"+value;
						}else{
							return value;
						}
					}
				}],
				onLoadSuccess : function (data){
		    		$(".fixed-table-header").removeClass("fixed-table-header");
		    		
		    		//数据加载完成后，重新加载下方统计数据
		    		reloadTotalData();
		    	}
		  });
}

function paymantStautsChange(index,fArPaymentAmount){
	var rpaymetTotalCal=$("#rpaymetTotalCal").html();
	var famount=$("#famount").val();
	var fendamount=$("#fendamount").html();
	var paymantStatus=$("#paymantStatus"+index).val();
	if(paymantStatus=="2"){
		if(Number(Number(fendamount)+Number(rpaymetTotalCal)-Number(fArPaymentAmount))<0){
			alertx("老人余额充足，不能挂账!");
			$("#paymantStatus"+index).val("1").trigger("change");
		}
	}
	
	reloadTotalData();
}

function reloadTotalData(){
	var rows= $('#tb_payment').bootstrapTable("getData");
	var total=getRpayTotal();
	var billtotal=getBillTotal();
	var foldmanName="";
	if(rows.length>0){
		foldmanName=rows[0].foldmanName;
	}
	
	total=Number(total).toFixed(2);
	billtotal=Number(billtotal).toFixed(2);
	
	var html="<table class='table table-bordered'>";
	html+="<tr>";
	html+="<td style='font-size:20px'>老人姓名:<span style='color:red'>"+foldmanName+"</span></td>";
	html+="<td style='font-size:20px'>应交金额合计:<span style='color:red' id='rpaymetTotalCal'>"+total+"</span></td>";
	html+="<td style='font-size:20px'>挂账金额合计:<span style='color:red' id='billtotalAmount'>"+billtotal+"</span></td>";
	html+="</tr>";

	html+="</table>";

	$("#paymentListForm .fixed-table-footer").html(html);
	
	//通过应缴金额和老人应缴余额 算出现金
	var fendamount=$("#fendamount").html();
	
	var famount=Number(Number(total)+Number(fendamount)).toFixed(2);
	
	$("#rpaymetTotal").html(famount);
	if(famount<0){
		$("#rpaymetTotalShow").html("0.00");
		$("#famount").val("0.00");
	}else{
		$("#rpaymetTotalShow").html(famount);
		$("#famount").val(famount);
	}
	
	getMorePaymentAmount();
}

function getRpayTotal(){
	var total=0;
	var fArPaymentAmounts =document.getElementsByName("fArPaymentAmount");
	var paymantStatuss =document.getElementsByName("paymantStatus");
	for (var i = 0;  i< fArPaymentAmounts.length; i++){
		var paymantStatus=paymantStatuss[i].value;
		if(paymantStatus !=2){
			var fArPaymentAmount=fArPaymentAmounts[i].value;
			total=total+Number(fArPaymentAmount);
		}
	}
	
	return total;
}

function getBillTotal(){
	var billtotal=0;
	var fArPaymentAmounts =document.getElementsByName("fArPaymentAmount");
	var paymantStatuss =document.getElementsByName("paymantStatus");
	for (var i = 0;  i< fArPaymentAmounts.length; i++){
		var paymantStatus=paymantStatuss[i].value;
		if(paymantStatus ==2){
			var fArPaymentAmount=fArPaymentAmounts[i].value;
			billtotal=billtotal+Number(fArPaymentAmount);
		}
	}
	
	return billtotal;
}


function getOldManBlanceCurrent(foldmanid,fid){
	var flag=false;
	$.ajax({
        type: "POST",
        url: contextPath+"/payment/getOldManBlanceCurrent.do",
        async: false,
        data : {foldmanid : foldmanid,fid : fid},
        success: function(data){
        	if(data){
	       	 	var fendamount=data.fendamount;
	       	 	if(fendamount !=null){
	       	 		$("#fendamount").html(Number(fendamount+"").toFixed(2));
	       	 		if(Number(fendamount)<=0){
	       	 			$("#fendamountShow").html("剩余  "+Number(Number(fendamount)*(-1)).toFixed(2));
	       	 		}else{
	       	 			$("#fendamountShow").html("欠账 "+Number(fendamount+"").toFixed(2));
	       	 		}
	       	 	}else{
	       	 		$("#fendamount").html("0.00");
	       	 		$("#fendamountShow").html("0.00");
	       	 	}
	       	 	
	       	 	//设置费用日期选择范围
	       	 	setPaymentDateScope(data);
       	 	}else{
       	 		$("#fendamount").html("0.00");
       	 		$("#fendamountShow").html("0.00");
       	 	}
        	flag=true;
    	 }
	});
	return flag;
}

function getMorePaymentAmount(){
	var rpaymetTotal=$("#rpaymetTotal").html();
	var famount=$("#famount").val();
	var morePaymentAmount="0.00";
	
	if(Number(rpaymetTotal)<0){
		if(Number(famount)<0){
			alertx("现金不能小于0!");
			$("#famount").val("0.00");
			return;
		}
		morePaymentAmount=famount;
	}else{
		if(Number(famount)<0){
			alertx("现金不能小于0!");
			$("#famount").val(rpaymetTotal);
			return;
		}
		morePaymentAmount=Number(Number(famount)-Number(rpaymetTotal)).toFixed(2);
		$("#morePaymentAmount").html(morePaymentAmount);
	}
	$("#morePaymentAmount").html(morePaymentAmount);
}

function initFcostitem(foldmanid){
	var flag=false;
	$.ajax({
        type: "POST",
        url: contextPath+"/payment/getFcostitem.do",
        data : {foldmanid : foldmanid},
        success: function(rs){
			var optionsHtml="";
			optionsHtml +="<option value=''>请选择</option>";
			for(var i=0;i<rs.length;i++){
				var detailInfo=rs[i];
				optionsHtml +="<option value='"+detailInfo.fID+"'>"+detailInfo.fChrgeName+"</option>"
			}
			
			$("#fcostitem").append(optionsHtml);
			flag=true;
    	 }
	});
	return flag;
}

function setPaymentDateScope(data){
	var y=data.fperiod;
	var fmoun=data.fmoun;
	m=fmoun<10?("0"+fmoun):fmoun;
	
	var min=y + '-' + m + '-' + "01";
	var max=y + '-' + m + '-' + "31";
	
	$("#fpaymentdate").attr("min",min);
	$("#fpaymentdate").attr("max",max);
	
	$("#fperiod").val(y);
	$("#fmoun").val(m);
}

//时间格式转化函数(年月日)
function formatDate(date) {
   var y = date.getFullYear();
   var m = date.getMonth() + 1;
   m = m < 10 ? ('0' + m) : m;
   var d = date.getDate();
   d = d < 10 ? ('0' + d) : d;
   var h = date.getHours();
   var minute = date.getMinutes();
   minute = minute < 10 ? ('0' + minute) : minute;
   return y + '-' + m + '-' + d;
};