var chargeStandardGrid;
$(function () {
	//初始化护理级别下拉选项值
	getSearchServiceLevels();
	
	//初始化老人状态下拉选项值
	getOldmanStatus();
	
	//初始化数据展示列表
	initMouthblanceTable();
});

function initMouthblanceTable(){
	  $('#tb_mouthblance').bootstrapTable({
		   url: 'queryList.do',   //请求后台的URL（*）
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
						   froomName:$("#searchRoomName").val(),
						   fbedNumber : $("#searchfbedNumber").val()
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
					title : '姓名',
					field : 'foldmanName',
					align : 'center',
					valign : 'middle',
					sortable : false
				},{
					title : '房间',
					field : 'froomName',
					align : 'center',
					valign : 'middle',
					sortable : false,
				}, {
					title : '床位',
					field : 'fbedNumber',
					align : 'center',
					valign : 'middle',
					sortable : false
				},{
					title : '余额',
					field : 'fendamount',
					align : 'center',
					valign : 'middle',
					sortable : false,
					formatter:function(value,row,index){
						if(Number(value)<0){
							return "<span style='color:green'>剩余  "+Number(Number(value)*(-1)).toFixed(2)+"</span>";
						}else if(Number(value)>0){
							return "<span style='color:red'>欠款   "+Number(value).toFixed(2)+"</span>";
						}else{
							return Number(value).toFixed(2);
						}
					}
				}],
				onLoadSuccess : function (data){
		    		$(".fixed-table-header").removeClass("fixed-table-header");
		    	}
		  });
}

function queryMouthblance(){
	$('#tb_mouthblance').bootstrapTable('refresh');
	
}

function resetSearch(){
	$("#formSearch")[0].reset();
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

//时间格式转化函数(年月日)
function formatDateYearMoun(date) {
   var y = date.getFullYear();
   var m = date.getMonth() + 1;
   m = m < 10 ? ('0' + m) : m;
   var d = date.getDate();
   d = d < 10 ? ('0' + d) : d;
   var h = date.getHours();
   var minute = date.getMinutes();
   minute = minute < 10 ? ('0' + minute) : minute;
   return y + '-' + m;
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
