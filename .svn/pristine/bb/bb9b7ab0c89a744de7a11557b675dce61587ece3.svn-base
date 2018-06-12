$(function () {
	
});

function open_init_comp(foldmanid){
	$("#foldmanid").val(foldmanid);
	//获取老人当期的 余额
	getOldManBlanceCurrent(foldmanid);
	
	//初始化数据展示列表
	initPaymentTable();
	
	//初始化老人所有的费用项目的下拉框
	//initFcostitem(foldmanid);
	
	//默认设置缴费日期为当天日期
	var now=formatDate(new Date());
	$("#fpaymentdate").val(now);
}

function initPaymentTable(){
	  $('#tb_retirementDetailList').bootstrapTable({
		   url: contextPath+'/retirement/retirementDetailList.do',   //请求后台的URL（*）
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
						var html="待交款";
						
						return html;
					}
				},{
					title : '金额',
					field : 'payamount',
					align : 'center',
					valign : 'middle',
					sortable : false,
					formatter : function(value,row,index){
						value=Number(value+"").toFixed(2)
						var html="";
						
						html+="<input type='text' name='fArPaymentAmount' id='fArPaymentAmount"+index+"' value='"+value+"' readonly/>"
							
						return html;
					}
				}, {
					title : '说明',
					field : 'period',
					align : 'center',
					valign : 'middle',
					sortable : false
				}],
				onLoadSuccess : function (data){
		    		$(".fixed-table-header").removeClass("fixed-table-header");
		    		
		    		//数据加载完成后，重新加载下方统计数据
		    		reloadTotalData();
		    	}
		  });
}

function reloadTotalData(){
	var rows= $('#tb_retirementDetailList').bootstrapTable("getData");
	var total=0;
	var foldmanName="";
	if(rows.length>0){
		foldmanName=rows[0].foldmanName;
	}
	
	var fArPaymentAmounts =document.getElementsByName("fArPaymentAmount");
	for (var i = 0;  i< fArPaymentAmounts.length; i++){
			var fArPaymentAmount=fArPaymentAmounts[i].value;
			total=total+Number(fArPaymentAmount);
	}
	
	total=Number(total).toFixed(2);
	
	var html="<table class='table table-bordered'>";
	html+="<tr>";
	html+="<td style='font-size:20px'>老人姓名:<span style='color:red'>"+foldmanName+"</span></td>";
	html+="<td style='font-size:20px'>费用合计:<span style='color:red'>"+total+"</span></td>";
	html+="</tr>";

	html+="</table>";

	$("#paymentListForm .fixed-table-footer").html(html);
	
	$("#rpaymetTotal").html(total);
	
	getPamentTotal();
}

function getOldManBlanceCurrent(foldmanid){
	$.ajax({
        type: "POST",
        url: contextPath+"/payment/getOldManBlanceCurrent.do",
        data : {foldmanid : foldmanid},
        success: function(data){
        	if(data){
	       	 	var fendamount=data.fendamount;
	       	 	if(fendamount !=null){
	       	 		$("#fendamount").html(Number(fendamount+"").toFixed(2));
	       	 	}else{
	       	 		$("#fendamount").html("0.00");
	       	 	}
       	 	}else{
       	 		$("#fendamount").html("0.00");
       	 	}
    	 }
	});
}

function getPamentTotal(){
	var rpaymetTotal=$("#rpaymetTotal").html();
	var fendamount=$("#fendamount").html();
	var pamentTotal=Number(Number(rpaymetTotal)+Number(fendamount)).toFixed(2);
	
	$("#pamentTotal").html(pamentTotal);
}

function initFcostitem(foldmanid){
	$.ajax({
        type: "POST",
        url: contextPath+"/payment/getFcostitem.do",
        data : {foldmanid : foldmanid},
        success: function(rs){
			var optionsHtml="";
			optionsHtml +="<option value=''>请选择</option>";
			for(var i=0;i<rs.length;i++){
				var detailInfo=rs[i];
				optionsHtml +="<option value='"+detailInfo.fID+"'>"+detailInfo.fChrgeType+"</option>"
			}
			
			$("#fcostitem").append(optionsHtml);
			flag=true;
    	 }
	});
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