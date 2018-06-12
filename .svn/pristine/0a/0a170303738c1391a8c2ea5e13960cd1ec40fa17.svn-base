var chargeStandardGrid;

$(function () {
	//初始化护理级别下拉选项值
	getSearchServiceLevels();
	
	//初始化老人状态下拉选项值
	getOldmanStatus();
	
	//初始化数据展示列表
	initRetirementTable();

});

function initRetirementTable(){
	  $('#tb_retirement').bootstrapTable({
		   url: 'queryRetirementList.do',   //请求后台的URL（*）
		   method: 'get',      //请求方式（*）
		   toolbar: '',    //工具按钮用哪个容器
		   striped: true,      //是否显示行间隔色
		   cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		   pagination: true,     //是否显示分页（*）
		   sortable: false,      //是否启用排序
		   sortOrder: "asc",     //排序方式
		   queryParams:  function (params) {
				  var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
						   pageSize: params.limit, // 页面大小
						   page: params.offset, //页码
						   foldmanName:$("#searchOldmanName").val(),
						   foldmanStatus:$("#searchOldmanStatus").val(),
						   roomName:$("#searchRoomName").val(),
						   nursingLevel : $("#searchNursingLevel").val(),
						   chargeStandardId : $("#searchChargeStandardId").val(),
						   startDate : $("#searchStartDate").val(),
						   endDate : $("#searchEndDate").val(),
						   startDateOut : $("#searchStartDateOut").val(),
						   endDateOut : $("#searchEndDateOut").val()
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
		   uniqueId: "foldmanid",      //每一行的唯一标识，一般为主键列
		   showToggle:false,     //是否显示详细视图和列表视图的切换按钮
		   showRefresh : false,  //是否显示刷新按钮
		   showColumns : false,  //是否显示列表下拉按钮
		   cardView: false,     //是否显示详细视图
		   detailView: false,     //是否显示父子表
		   singleSelect : true,
				   columns : [ {
					title : '',
					field : '',
					align : 'center',
					valign : 'middle',
					checkbox : true,
				}, {
					title : '老人编号',
					field : 'foldmanid',
					align : 'center',
					valign : 'middle',
					sortable : true,

				},{
					title : '状态',
					field : 'foldmanStatus',
					align : 'center',
					valign : 'middle',
					sortable : true,

				}, {
					title : '类型',
					field : 'foldmanType',
					align : 'center',
					valign : 'middle',
					sortable : true
				}, {
					title : '姓名',
					field : 'foldmanName',
					align : 'center',
					valign : 'middle',
					sortable : true
				},{
					title : '性别',
					field : 'foldmanSex',
					align : 'center',
					valign : 'middle',
					sortable : true
				}, {
					title : '入住时间',
					field : 'fcheckinTime',
					align : 'center',
					valign : 'middle',
					sortable : true,
					formatter : function(value,row,index){
						var date = new Date(value);
						return formatDate(date);
					 }
				}, {
					title : '床位',
					field : 'foldmanRoom',
					align : 'center',
					valign : 'middle',
					sortable : true
				},{
					title : '操作',
					field : 'fid',
					align : 'center',
					valign : 'middle',
					sortable : true,
					formatter : actionFmt
				} ]
		  });
}

function actionFmt(value,row,index){
	var html="";
	html+="<a onclick=\"retirementDetailShow('"+row.foldmanid+"')\"><img alt='' src='../img/fee.jpg' title='缴费' border='0' style='width:16px;height:16px;'></a>";
	
	return html;
}

function queryRetirement(){
	$('#tb_retirement').bootstrapTable('refresh');
}

function resetSearch(){
	$("#formSearch")[0].reset();
}

//请求缴费的页面
function retirementDetailShow(foldmanid){
	$.ajax({
        type: "POST",
        url: contextPath+"/retirement/retirementDetailListShow.do",
        success: function(data){
       	 	open_paymentShow_page(data,foldmanid);
    	 }
	});
}

//打開打开缴费頁面窗口
function open_paymentShow_page(html,foldmanid){
	$.confirm({
        title: '<h2>结款<h2>',
        content : html,
        columnClass : 'col-md-offset-2 col-md-8',
        icon : '',
        confirmButton : '确认结款',
        confirm : function(){
        		var flag = savepayMent();
            	if(flag){
            		return true;
            	}else{
            		return false;
            	}
        },
        onOpen:function(){
        	open_init_comp(foldmanid);
        }
    });
}
//保存缴费项目
function savepayMent(){
	var flag;
	var data=getAndCheckData();
	if(data){
		$.ajax({
			type : 'POST',
			url : contextPath+"/retirement/savePayMent.do",
			async: false,
			data : data,
			success : function(rs) {
				if(rs.success){
					alertx(rs.msg);
					flag =  true;
					
					//成功后重新刷新列表
					queryRetirement();
				}else{
					alertx(rs.msg);
					flag = false;
				}
			},
			error : function() {
				flag = false;
			}
		});
	}
	return flag;
}

function getAndCheckData(){
	var pamentTotal=$("#pamentTotal").html();
	var fpaymentdate=$("#fpaymentdate").val();
	var fremarks=$("#fremarks").val();
	var fcostitem=$("#fcostitem").val();
	
	if(pamentTotal){
		if(Number(pamentTotal)>0){
			/*if(!fcostitem){
				alertx("请选择多缴费项目!");
				return false;
			}*/
		}
	}
	
	if(!fpaymentdate){
		alertx("请选择缴费日期!");
		return false;
	}
	
	var rows=$('#tb_retirementDetailList').bootstrapTable("getData");
	
	/*if(rows.length<1){
		alertx("没有需要结算的的费用!");
		return false;
	}*/
	
	var rentryfids="";
	var rentryPayamounts="";
	for(var i=0;i<rows.length;i++){
		if(i==rows.length-1){
			rentryfids+=rows[i].fid;
			rentryPayamounts+=Number(rows[i].payamount).toFixed(2);
		}else{
			rentryfids+=rows[i].fid+",";
			rentryPayamounts+=Number(rows[i].payamount).toFixed(2)+",";
		}
	}
	
	
	var data={
		foldmanid : $("#foldmanid").val(),
		rentryfids : rentryfids,
		rentryPayamounts : rentryPayamounts,
		pamentTotal : pamentTotal,
		fcostitemid : fcostitem,
		fpaymentdate : fpaymentdate,
		fremarks : fremarks
	};
	
	return data;
}

function getSearchServiceLevels(){
	var flag;
	$.ajax({
		type : 'POST',
		url :  contextPath+"/nursingProject/getServiceLevels.do",
		data:{},
		async: false,
		success : function(rs) {
			var optionsHtml="";
			optionsHtml +="<option value=''>请选择</option>";
			for(var i=0;i<rs.length;i++){
				var detailInfo=rs[i];
				optionsHtml +="<option value='"+detailInfo.id+"'>"+detailInfo.value+"</option>"
			}
			
			$("#searchNursingLevel").append(optionsHtml);
			flag=true;
		},
		error : function() {
			flag = false;
		} 
	});
	return flag;
}

function getOldmanStatus(){
	var flag;
	$.ajax({
		type : 'POST',
		url :  contextPath+"/nursingProject/getDcValueByName.do",
		data:{name : "老人状态"},
		async: false,
		success : function(rs) {
			var optionsHtml="";
			optionsHtml +="<option value=''>请选择</option>";
			for(var i=0;i<rs.length;i++){
				var detailInfo=rs[i];
				optionsHtml +="<option value='"+detailInfo.id+"'>"+detailInfo.value+"</option>"
			}
			
			$("#searchOldmanStatus").append(optionsHtml);
			flag=true;
		},
		error : function() {
			flag = false;
		} 
	});
	return flag;
}

function getChargeStandard(){
	$.ajax({
        type: "POST",
        url: contextPath+"/Rpayment/getChargeStandard.do",
        success: function(data){
        	openChargeStandard(data);
    	 }
	});
}

function openChargeStandard(html){
	$.confirm({
        title: '<h2>选择费用类别<h2>',
        content : html,
        columnClass : 'col-md-12',
        icon : '',
        confirmButton : '确认',
        confirm : function(){
        	var datas=chargeStandardGrid.bootstrapTable("getSelections");
        	if(datas.length>0){
        		var data=datas[0];
        		$("#searchChargeStandardId").val(data.fID);
        		$("#searchChargeStandard").val(data.fChrgeName);
        		return true;
        	}else{
        		alert("请选择一条数据");
        		return false;
        	}
        },
        onOpen:function(){
        	
        }
    });
}

//时间格式转化函数（年月日时分秒）
function formatDateTime(date) {
   var y = date.getFullYear();
   var m = date.getMonth() + 1;
   m = m < 10 ? ('0' + m) : m;
   var d = date.getDate();
   d = d < 10 ? ('0' + d) : d;
   var h = date.getHours();
   var minute = date.getMinutes();
   minute = minute < 10 ? ('0' + minute) : minute;
   return y + '-' + m + '-' + d+' '+h+':'+minute;
};

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
