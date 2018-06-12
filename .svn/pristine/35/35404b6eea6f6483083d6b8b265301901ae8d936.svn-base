$(function() {
	// 1.初始化Table
	var oTable = new TableInit();
	oTable.Init();

});

var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#tb_StoreHome').bootstrapTable({
			url : 'query.do', // 请求后台的URL（*）
			method : 'get', // 请求方式（*）
			toolbar : '#toolbar', // 工具按钮用哪个容器
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 是否显示分页（*）
			sortable : false, // 是否启用排序
			sortOrder : "asc", // 排序方式
			queryParams : oTableInit.queryParams,// 传递参数（*）
			sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 5, // 每页的记录行数（*）
		//	pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
			search : false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch : true,
			showColumns : true, // 是否显示所有的列
			showRefresh : true, // 是否显示刷新按钮
			minimumCountColumns : 2, // 最少允许的列数
			clickToSelect : true, // 是否启用点击选中行
			height : 600, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId : "ID", // 每一行的唯一标识，一般为主键列
			showToggle : true, // 是否显示详细视图和列表视图的切换按钮
			cardView : false, // 是否显示详细视图
			detailView : false, // 是否显示父子表
		
			columns : [ {
				radio : true
			}, {
				field : 'fStoreHouseNumber',
				title : '编号'
			}, {
				field : 'fStoreHouseName',
				title : '仓库名称 '
			}, {
				field : 'fStoremanName',
				title : '负责人'
			}, {
				field : 'fTel',
				title : '联系电话'
			}, {
				field : 'fAddress',
				title : '联系地址'
			}, {
				field : 'fRemarks',
				title : '备注'
			} ],
		 onLoadSuccess: function(data){
			
		 }
		
		
		});
	};

	// 得到查询的参数
	oTableInit.queryParams = function(params) {
		
		var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			pageSize : params.limit, // 页面大小
			page : params.offset, // 页码
			fStoreHouseName:$("#searchfStoreHouseName").val(),
			fStoremanID:$("#searchfStoremanName option:selected").val(),
			fTel:$("#searchfTel").val()
			         
		};
		return temp;
	};
	
	
	return oTableInit;
};

//加载函数直接遍历负责人select
var length='';
var row='';
$(document).ready(function (){
	
	$.ajax({
		url : contextPath + "/Order/queryStaffMessage.do",
		type : "post",
		success : function(data) {
	    row=data.rows;
	    length=data.total;
	  
			 
			
			$("#searchfStoremanName").html("");
			var $add = $("#searchfStoremanName");
			$add.append("<option value=''>-请选择-</option>");
			for ( var i = 0; i < data.total; i++) {
				$add.append("<option value='" + data.rows[i].FID + "'>"
						+ data.rows[i].FStaffName + "</option>");
			 };
			 
			 //下拉框改变

		}

});

});

//按条件查询
function getSearch(){

	    $.ajax({
	        url: contextPath + "/StoreHome/query.do",
	        type: "post",
	        data: {	
	        	fStoreHouseName:$("#searchfStoreHouseName").val(),
				fStoremanID:$("#searchfStoremanName option:selected").val(),
				fTel:$("#searchfTel").val(),
	            pageSize: 5, //页面大小
	            page: 0, //页码
	            
	          },
	        success: function (data) {
	            $('#tb_StoreHome').bootstrapTable('load', data);
	        }
	    });
	}

//清除查询条件
function queryclear() {
	   $("#searchfStoreHouseName").val('');
	   $("#searchfTel").val('');     
       $("#searchfStoremanName").val('');//编号       
}
//时间格式转化函数
function formatDateTime(date) {
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	m = m < 10 ? ('0' + m) : m;
	var d = date.getDate();
	d = d < 10 ? ('0' + d) : d;
	var h = date.getHours();
	h = h < 10 ? ('0' + h) : h;
	var minute = date.getMinutes();
	minute = minute < 10 ? ('0' + minute) : minute;
	return y + '-' + m + '-' + d + ' ' + h + ':' + minute;
};
//时间物品入库订单号
function formatDateTimeNumber(date) {
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	m = m < 10 ? ('0' + m) : m;
	var d = date.getDate();
	d = d < 10 ? ('0' + d) : d;
	var h = date.getHours();
	h = h < 10 ? ('0' + h) : h;
	var minute = date.getMinutes();
	minute = minute < 10 ? ('0' + minute) : minute;
	var seconds=date.getSeconds();
	seconds = seconds < 10 ? ('0' + seconds) : seconds;
	return y + '' + m + '' + d + '' + h + '' + minute+''+seconds;
};
//增加仓库
function addHome(){

	 if(addHome_Check()){	
			// 获取UTC(国际统一时间/国际协调)格式的从1970.1.1 0:00以来的毫秒数
		 var now = new Date();
		 var num="NO"+formatDateTimeNumber(now);

		 $.ajax({
				url : contextPath + "/StoreHome/addStoreHome.do",
				type : "post",
				data : {
					fStoreHouseName:$("#addfStoreHouseName").val(),
					fStoremanID:$("#addfStoremanName option:selected").val(),
					fTel:$("#addfTel").val(),
					fRemarks:$("#addfRemarks").val(),
					fAddress :$("#addfAddress").val(),  
					fNursingHomeID:'1',
					fStoreHouseNumber:num,
									
				},
				success : function(data) {
					
		            setAlert(data.message,"增加仓库成功");
					$('#tb_StoreHome').bootstrapTable('refresh', {
						url : 'query.do'
					});
				
                   $("#add_close_btn").click();
                   closeModal();
				}
			});
		   
	 }
	
}
	
//增加  单独地址的验证
function addfAddress_check(){
	var add=$("#addfAddress").val().trim();
   	$("#addfAddress_message").html("");
	if(add==null||add.length==0||add==''){
	   	$("#addfAddress_message").html("地址不能为空！");
	}
}
//增加  单独名称的验证
function addfStoreHouseName_check(){
	var homeName=$("#addfStoreHouseName").val().trim(); 
	$("#addfStoreHouseName_message").html("");
	if(homeName==null||homeName.length==0){
	   	 $("#addfStoreHouseName_message").html("库名不能为空！");
		}	
}
//增加  单独电话名称的验证
function addfTel_check(){
	var tel=$("#addfTel").val().trim(); 
	
	$("#addfTel_message").html("");
	if(tel==null||tel.length==0){
	   	 $("#addfTel_message").html("不能为空！");
		}else{
			
			var reg=new RegExp(/^1[34578]\d{9}$/);
			if(reg.test(tel)){
			  $("#addfTel_message").html(" ");
			}else{
			  	 $("#addfTel_message").html("格式错误！");	
			}		
		}	
}
//增加验证
function addHome_Check(){	
	var homeName=$("#addfStoreHouseName").val().trim();  
	var tel=$("#addfTel").val().trim();
	var man=$("#addfStoremanName option:selected").val();
	var add=$("#addfAddress").val();	
	 result = true;
		if(tel==null||tel.length==0){
		   	 $("#addfTel_message").html("电话不能为空！");
		   	result = false;
			}else{
				
				var reg=new RegExp(/^1[34578]\d{9}$/);
				if(reg.test(tel)){
				  $("#addfTel_message").html(" ");
				  result = true;
				}else{
				  	 $("#addfTel_message").html("格式错误！");	
				  	result = false;
				}
			}
	if(homeName==null||homeName.length==0){
	   	 $("#addfStoreHouseName_message").html("库名不能为空！");
	    	 result = false;
		}
	if(man==0){
	   	$("#addfStoremanName_message").html("必选项！");
	    result = false;	
	}
	if(add==null||add.length==0||add==''){
	   	$("#addfAddress_message").html("地址不能为空！");
	    result = false;	
	}
   return result;
}
//select 显示员工
function showStarff(){

			$("#addfStoremanName").html("");
			var $add = $("#addfStoremanName");
			$add.append("<option value=''>-请选择-</option>");
			for ( var i = 0; i < length; i++) {
				$add.append("<option value='" + row[i].FID + "'>"
						+ row[i].FStaffName + "</option>");
			 };

	//人员的变化跟着select变化
	$("#addfStoremanName").change(	
			function() {	
				if($("#addfStoremanName option:selected").val()!=''){                   
				   	 $("#addfStoremanName_message").html('');
                   }else{     
               	   	$("#addfStoremanName_message").html("必选项！");
                   }
				
			
			});
}
//更新仓库
function updateHome(){
	 if(updateHome_Check()){	
			// 获取UTC(国际统一时间/国际协调)格式的从1970.1.1 0:00以来的毫秒数	 
		 $.ajax({
				url : contextPath + "/StoreHome/updateStoreHome.do",
				type : "post",
				data : {
					fid: $("#updatefid").val(),
					fStoreHouseName:$("#updatefStoreHouseName").val(),
					fStoremanID:$("#updatefStoremanName option:selected").val(),
					fTel:$("#updatefTel").val(),
					fRemarks:$("#updatefRemarks").val(),
					fAddress :$("#updatefAddress").val(),  
					fNursingHomeID:$("#updatefStoreHouseNumber").val(),
					fStoreHouseNumber:$("#updatefStoreHouseNumber").val(),
				},
				success : function(data) {				
		            setAlert(data.message,"更新仓库成功");
					$('#tb_StoreHome').bootstrapTable('refresh', {
						url : 'query.do'
					});			
                  $("#update_close_btn").click();       
                  closeModal();

				}
			});		   
	 }
}	
//更新 单独地址的验证
function updatefAddress_check(){
	var add=$("#updatefAddress").val().trim();
   	$("#updatefAddress_message").html("");
	if(add==null||add.length==0||add==''){
	   	$("#updatefAddress_message").html("地址不能为空！");
	}
}
//更新  单独名称的验证
function updatefStoreHouseName_check(){
	var homeName=$("#updatefStoreHouseName").val().trim(); 
	$("#updatefStoreHouseName_message").html("");
	if(homeName==null||homeName.length==0){
	   	 $("#updatefStoreHouseName_message").html("库名不能为空！");
		}	
}
//更新  单独电话名称的验证
function updatefTel_check(){
	var tel=$("#updatefTel").val().trim(); 
	
	$("#updatefTel_message").html("");
	if(tel==null||tel.length==0){
	   	 $("#updatefTel_message").html("不能为空！");
		}else{
			
			var reg=new RegExp(/^1[34578]\d{9}$/);
			if(reg.test(tel)){
			  $("#updatefTel_message").html(" ");
			}else{
			  	 $("#updatefTel_message").html("格式错误！");	

			}
			
		}	

}
//更新验证
function updateHome_Check(){
	
	
	var homeName=$("#updatefStoreHouseName").val().trim();  
	var tel=$("#updatefTel").val().trim();
	var man=$("#updatefStoremanName option:selected").val();
	var add=$("#updatefAddress").val();
	
	 result = true;

	if(tel==null||tel.length==0){
	   	 $("#updatefTel_message").html("电话不能为空！");
	   	result = false;
		}else{
			
			var reg=new RegExp(/^1[34578]\d{9}$/);
			if(reg.test(tel)){
			  $("#updatefTel_message").html(" ");
			  result = true;
			}else{
			  	 $("#updatefTel_message").html("格式错误！");	
			  	result = false;
			}
		}
	if(homeName==null||homeName.length==0){
	   	 $("#updatefStoreHouseName_message").html("库名不能为空！");
	    	 result = false;
		}
	if(man==0){
	   	$("#updatefStoremanName_message").html("必选项！");
	    result = false;
		
	}
	if(add==null||add.length==0||add==''){
	   	$("#updatefAddress_message").html("地址不能为空！");
	    result = false;	
	}
   return result;

}
//回显
function gotoUpdate() {

var carrentItem = $("#tb_StoreHome").bootstrapTable('getSelections');
console.log(carrentItem[0]);
if (carrentItem[0]) {
	
    $("#updatefid").val(carrentItem[0].fid);
	$("#updatefStoreHouseName").val(carrentItem[0].fStoreHouseName);
	$("#updatefTel").val(carrentItem[0].fTel);
	$("#updatefRemarks").val(carrentItem[0].fRemarks);
	$("#updatefAddress").val(carrentItem[0].fAddress);
	$("#updatefStoreHouseNumber").val(carrentItem[0].fStoreHouseNumber);
    $("#updatefNursingHomeID").val(carrentItem[0].fNursingHomeID);
	$("#updatefStoremanName").html("");
	var $add = $("#updatefStoremanName");
	for ( var i = 0; i < length; i++) {
		if(row[i].FID==carrentItem[0].fStoremanID){
			$add.append("<option   selected='selected' value='" + row[i].FID + "'>" + row[i].FStaffName
					+ "</option>");
		}else{
			$add.append("<option value='" + row[i].FID + "'>" + row[i].FStaffName
					+ "</option>");
		}
	
	}
	;
	// 人员的变化跟着select变化
	$("#updatefStoremanName").change(function() {
		if ($("#updatefStoremanName option:selected").val() != '') {
			$("#updatefStoremanName_message").html('');
		} else {
			$("#updatefStoremanName_message").html("必选项！");
		}
	});
	$("#update_btn").click();
} else {
	setAlert("error", "请先选择一条数据");
}

}
//关闭modal
function closeModal(){
	
	$("#updatefid").val('');
	$("#updatefStoreHouseName").val('');
	$("#updatefStoremanName").val('');
	$("#updatefTel").val('');
	$("#updatefRemarks").val('');
	$("#updatefAddress").val('');
	$("#updatefStoreHouseNumber").val('');
	$("#updatefNursingHomeID").val('');
	$("#addfStoreHouseName").val('');
	$("#addfStoremanName").val('');
	$("#addfTel").val('');
	$("#addfRemarks").val('');
	$("#addfAddress").val('');
	$("#addfStoreHouseNumber").val('');
	$("#addfNursingHomeID").val('');
};


