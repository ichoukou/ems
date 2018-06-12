$(function() {
	// 1.初始化Table
	 getDataList();// 获取数据字典里面
		getStaff();// 获取员工信息
		getService();// 获取服务相关信息
		getSearch();

	var oTable = new TableInit();
	oTable.Init();

});
var printfid="";
var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#tb_OrderManger').bootstrapTable({
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
			pageSize : 10, // 每页的记录行数（*）
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
				field : 'fid',
				title : '序号'
			}, {
				field : 'fOrderNo',
				title : '工单号 '
			}, {
				field : 'fObjectName',
				title : '老人姓名'
			}, {
				field : 'fObjectPhone',
				title : '联系电话'
			}, {
				field : 'fServiceObject',
				title : '服务对象'
			}, {
				field : 'fServiceUser',
				title : '服务人员'
			}, {
				field : 'fDealStatus',
				title : '处理状态'
			}, {
				field : 'fRequestTime',
				title : '要求服务时间',
				formatter:function(value,row,index) {


					return value==null?"":value.substring(0,value.length-5);

			}

			}, {
				field : 'fFinishTime',
				title : '服务完成时间',
				formatter:function(value,row,index){
					return value==null?"":value.substring(0,value.length-5);
				}
			}, {
				field : 'fOrderyExplain',
				title : '说明'
			}, {
				field : 'fEvaluationOrder',
				title : '服务评价'
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
			fObjectPhone:$("#serviceOldPhone").val(),
        	fOrderNo:$("#serviceOldNumber").val(),
        	fObjectName:$("#serviceOldName").val(),
        	fServiceObject:$("#serviceObject").val(),
        	fServiceUser:$("#serviceUser").val(),
        	fDealStatus:$("#serviceStatus").val(),
			startTime:$("#serviceStart").val(),
			overTime:$("#serviceOver").val(),
		};
		return temp;
	};
	return oTableInit;
};
var datalist="";
var datalength="";
var staff="";
var stafflen="";
var serv="";
var servlen="";
var servtype="";
var servtypelen="";
$(document).ready(
);

//清楚选项
function queryclear() {
	   $("#serviceOldName").val("");
	   $("#serviceOldPhone").val("");     
       $("#serviceOldNumber").val("");//编号
       $("#serviceUser").val("");//服务人员
       $("#serviceStatus").val("");//处理状态
       $("#serviceObject").val("");//服务对象
   	   $("#serviceStart").val("");
	   $("#serviceOver").val("");
        
}

//条件查询项目
function queryOrderBy(){

	  fObjectPhone=$("#serviceOldPhone").val(),
		fOrderNo=$("#serviceOldNumber").val(),
		fObjectName=$("#serviceOldName").val(),
		fServiceObject=$("#serviceObject").val(),
		fServiceUser=$("#serviceUser").val(),
		fDealStatus=$("#serviceStatus").val(),
		startTime=$("#serviceStart").val(),
		overTime=$("#serviceOver").val(),
		$("#tb_OrderManger").bootstrapTable('selectPage',1);

}


function getfDate() {
	var newfDate = new Date();
	$("#addfRecieveTime").val(formatDateTime(newfDate));
	$("#addfRequestTime").val(formatDateTime(newfDate));
	// 获取UTC(国际统一时间/国际协调)格式的从1970.1.1 0:00以来的毫秒数
	var now = new Date();

	$("#addOrderNumber").val("NO"+formatDateTimeNumber(now));
}
// 时间格式转化函数
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
// 时间格式转化编号
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

// 得到员工类型
function getStaff() {
	
	
	$.ajax({
		url : contextPath + "/Order/queryStaffMessage.do",
		type : "post",
		success : function(data) {
			staff=data.rows;
			stafflen=data.total;
			
			$("#addfRecieveUser").html("");
			var $add = $("#addfRecieveUser");
			for ( var i = 0; i < data.total; i++) {
				$add.append("<option value='" + data.rows[i].FID + "'>"
						+ data.rows[i].FStaffName + "</option>");
			}

			$("#addfServiceUser").html("");
			var $add = $("#addfServiceUser");
			for ( var i = 0; i < data.total; i++) {
				$add.append("<option value='" + data.rows[i].FID + "'>"
						+ data.rows[i].FStaffName + "</option>");
			}

		}
	});
	
	
}


// 得到数据字典的数据
function getDataList() {
	
	$.ajax({
		url : contextPath + "/Order/queryData.do",
		type : "post",
		success : function(data) {

			datalist=data.rows;
			datalength=data.total;



			$("#addfRecieveDept").html("");
			var $add = $("#addfRecieveDept"); 
			for ( var i = 0; i < data.total; i++) {
				if (data.rows[i].DC_NAME == "受理部门") {
					$add.append("<option value='" + data.rows[i].DC_VALUE
							+ "'>" + data.rows[i].DC_VALUE + "</option>");
				}
			}

			$("#addfOrderEmergency").html("");
			var $add = $("#addfOrderEmergency");
			for ( var i = 0; i < data.total; i++) {
				if (data.rows[i].DC_NAME == "工单紧急程度") {
					$add.append("<option value='" + data.rows[i].DC_VALUE
							+ "'>" + data.rows[i].DC_VALUE + "</option>");
				}
			}

			$("#addfPayStyle").html("");
			var $add = $("#addfPayStyle");
			for ( var i = 0; i < data.total; i++) {
				if (data.rows[i].DC_NAME == "付款方式") {
					$add.append("<option value='" + data.rows[i].DC_VALUE
							+ "'>" + data.rows[i].DC_VALUE + "</option>");
				}
			}

			$("#addfDealStatus").html("");
			var $add = $("#addfDealStatus");
			for ( var i = 0; i < data.total; i++) {
				if (data.rows[i].DC_NAME == "处理状态") {
					$add.append("<option value='" + data.rows[i].DC_VALUE
							+ "'>" + data.rows[i].DC_VALUE + "</option>");
				}
			}

			$("#addfServiceObject").html("");
			var $add = $("#addfServiceObject");
			for ( var i = 0; i < data.total; i++) {
				if (data.rows[i].DC_NAME == "服务对象") {
					$add.append("<option value='" + data.rows[i].DC_VALUE
							+ "'>" + data.rows[i].DC_VALUE + "</option>");
				}
			}

			$("#addfOrderType").html("");
			var $add = $("#addfOrderType");
			for ( var i = 0; i < data.total; i++) {
				if (data.rows[i].DC_NAME == "工单类型") {
					$add.append("<option value='" + data.rows[i].DC_VALUE
							+ "'>" + data.rows[i].DC_VALUE + "</option>");
				}
			}

			$("#addfServiceProvide").html("");
			var $add = $("#addfServiceProvide");	
			for ( var i = 0; i < data.total; i++) {
				if (data.rows[i].DC_NAME == "服务方") {
					$add.append("<option value='" + data.rows[i].DC_VALUE
							+ "'>" + data.rows[i].DC_VALUE + "</option>");
				}
			}

		}

	});
}

// 得到服务项目 和种类


// 查询服务的内容
function  getServiceName(){
	$.ajax({
		url : contextPath + "/Order/queryServiceItemName.do",
		type : "post",
		dataType : 'json',
		success : function(data) {
			serv=data.rows;
			servlen=data.total;
		},
	});
}

function getService() {
	getfDate();
	getServiceName();
	// 查询服务的类型
	$.ajax({
		url : contextPath + "/Order/queryServiceType.do",
		type : "post",
		dataType : 'json',
		success : function(data) {
			servtype=data.rows;
			servtypelen=data.total;


			//写一个循环 把类型遍历出来
			$("#addfServiceType").html("");
			var $add = $("#addfServiceType");
			$add.append("<option value=''>-请选择-</option>");
			for ( var i = 0; i < data.total; i++) {
				$add.append("<option value='" + data.rows[i].FID + "'>"
					+ data.rows[i].FServiceTypeName + "</option>");
			}
			;


			//服务种类变化
			$("#addfServiceType").change(function (){
				if($("#addfServiceType option:selected").val()!=''){
					$("#addfServiceType_message").html('');
				}else{
					$("#addfServiceType_message").html('必选种类');
				}
				//类型select变化 项目跟着变化

				$("#addfServiceItem").html("");
				var $add = $("#addfServiceItem");
				$add.append("<option price='0' value=''>-请选择-</option>");
				for ( var i = 0; i < servlen; i++) {
					if(serv[i].ItemId==$("#addfServiceType option:selected").val()){
						$add.append("<option  price='" + serv[i].Fprice + "' Funit='元' value='"
							+ serv[i].FID + "'>"
							+ serv[i].FServiceItemName + "</option>");
					}

				}



			});

		},
	});


	// 服务变化 单价跟着总价变化
	$("#addfServiceItem").change(
		function() {
			if($("#addfServiceItem option:selected").val()!=''){
				$("#addfServiceItem_message").html('');

				$("#addfPrice").val(
					$("#addfServiceItem option:selected").attr(
						"price")+$("#addfServiceItem option:selected").attr(
						"Funit"));
				var price = $("#addfPrice").val();
				var priceF = parseFloat(price);
				if (!$("#addfNumber").val() == '') {
					var number = parseFloat($("#addfNumber").val());
					$("#addfTotal").val(
						parseFloat(number * priceF).toFixed(2)
						+ $("#addfServiceItem option:selected").attr(
							"Funit"));
				} else {
					$("#addfTotal").val(' ');
					$("#addfNumber").val(' ');
					$("#addfServiceItem_message").html(' ');

				}
			}else{
				$("#addfServiceItem_message").html('必选项目');
				$("#addfPrice").val('');
				$("#addfTotal").val('');
				$("#addfNumber").val('');
				$("#addfNumber_message").html('');


			}


		});
	// 数量变化总价也跟着变化
	$("#addfNumber").blur(function() {
		var num=$("#addfNumber").val();
	    $("addfNumber_message").html('');
	    if(num==''||num.length==0){
		    $("#addfNumber_message").html("数量不能为空");
		   	 $("#addfTotal").val('');	
		    }else if(num==0){
				   	  $("addfNumber_message").html(''); 
				      $("#addfNumber_message").html("数量不能为0");
				   	  $("#addfTotal").val('');	
				   	 
		    	
		    }else{
			    $("#addfNumber_message").html(" ");
                
                 
				var number1 = parseFloat($("#addfNumber").val());
				var price = $("#addfPrice").val();
			
				if(price==''){
				 	$("#addfServiceItem_message").html("必选项目！");
					
				}else{
					var priceF = parseFloat(price);
					$("#addfTotal").val(parseFloat(number1 * priceF).toFixed(2)+$("#addfServiceItem option:selected").attr(
							"Funit"));
				}
				

		    	
		    }
		
		
	
	});



}

//增加接单时间验证
function addfRecieveTime_check(){	
	var recieveTime=$("#addfRecieveTime").val().trim(); 
	 $("#addfRecieveTime_message").html("");    
	 if(recieveTime==null||recieveTime.length==0){
    	 $("#addfRecieveTime_message").html("不能为空！");
         
    }
}

//更新接单时间验证
function updatefRecieveTime_check(){	
	var recieveTime=$("#updatefRecieveTime").val().trim(); 
	 $("#updatefRecieveTime_message").html("");    
	 if(recieveTime==null||recieveTime.length==0){
    	 $("#updatefRecieveTime_message").html("不能为空！");
         
    }
}
//更新订单验证
function updateOrder_Check(){
	var recieveTime=$("#updatefRecieveTime").val().trim();  
	var fServiceTypeid =$("#updatefServiceType option:selected").val();
	var fServiceItemid=$("#updatefServiceItem option:selected").val();
	var fnumber=$("#updatefNumber").val();
	 result = true;
	if(fServiceTypeid==null||fServiceTypeid.length==0){
   	 $("#updatefServiceType_message").html("必选种类！");
    	 result = false;
	}
	
	if(fServiceItemid==null||fServiceItemid.length==0){
	   	$("#updatefServiceItem_message").html("必选项目！");
	    result = false;
		
	}
	if(fnumber==null||fnumber.length==0||fnumber==''){
	   	$("#updatefNumber_message").html("数量不能为空！");
	    result = false;	
	}else{
		if(fnumber==0){
		   	$("#updatefNumber_message").html("数量不能为0！");
		    result = false;	
		}	
		
	}

    if(recieveTime==null||recieveTime.length==0){
    	 $("#updatefRecieveTime_message").html("不能为空！");
         result = false;
    }
         return result;
	}
//增加订单
function addOrder_Check(){
	var recieveTime=$("#addfRecieveTime").val().trim();  
	var fServiceTypeid =$("#addfServiceType option:selected").val();
	var fServiceItemid=$("#addfServiceItem option:selected").val();
	var fnumber=$("#addfNumber").val();
	 result = true;
	if(fServiceTypeid==null||fServiceTypeid.length==0){
   	 $("#addfServiceType_message").html("必选种类！");
    	 result = false;
	}
	
	if(fServiceItemid==null||fServiceItemid.length==0){
	   	$("#addfServiceItem_message").html("必选项目！");
	    result = false;
		
	}
	if(fnumber==null||fnumber.length==0||fnumber==''){
	   	$("#addfNumber_message").html("数量不能为空！");
	    result = false;	
	}else{
		if(fnumber==0){
		   	$("#addfNumber_message").html("数量不能为0！");
		    result = false;	
		}	
		
	}

    if(recieveTime==null||recieveTime.length==0){
    	 $("#addfRecieveTime_message").html("不能为空！");
         result = false;
    }
         return result;
	}

// 保存
function addOrder(){
	 if(addOrder_Check()){	 
		 $.ajax({
				url : contextPath + "/Order/addOrder.do",
				type : "post",
				data : {
					fOrderNo :$("#addOrderNumber").val(),
					fRecieveDept:$("#addfRecieveDept option:selected").val(),
					fRecieveUser :$("#addfRecieveUser option:selected").text(),
					fRecieveTime : $("#addfRecieveTime").val(),
					fPayStyle : $("#addfPayStyle option:selected").val(),
					fOrderEmergency :$("#addfOrderEmergency option:selected ").val(),
					fDealStatus : $("#addfDealStatus option:selected").val(),
					fServiceObject : $("#addfServiceObject option:selected").val(),
					fCallName : $("#addfCallName").val(),
					fCallPhone : $("#addfCallPhone").val(),
					fObjectName : $("#addfObjectName").val(),
					fObjectPhone : $("#addfObjectPhone").val(),
					fRequestTime : $("#addfRequestTime").val(),
					fServiceAdd: $("#addfServiceAdd").val(),		
					fOrderyExplain:$("#addfOrderExplain").val(),
					fOrderType : $("#addfOrderType option:selected").val(),
					fServiceProvide :$("#addfServiceProvide option:selected").val(),		                       
					fServiceUser :$("#addfServiceUser option:selected").text(),
					fServiceTypeid : $("#addfServiceType option:selected").val(),
					fServiceItemid:$("#addfServiceItem option:selected").val(),
					fPrice:parseFloat($("#addfPrice").val().substring(0, $("#addfPrice").val().length - 1)),
					fNumber : parseFloat($("#addfNumber").val()),
					fTotal :parseFloat($("#addfTotal ").val().substring(0, $("#addfTotal").val().length - 1)) ,
					fCreatorID : "创建人",
					fEvaluationOrder : "",	
				},
				success : function(data) {			
		            setAlert(data.message,"增加订单成功");
					getSearch();
					$('#tb_OrderManger').bootstrapTable('refresh', {
						url : 'query.do'
					});			
                    $("#add_close_btn").click();
                    closeModal();
				}
			});
		   
 
	 }
	

}

// 修改
function updateOrder() {

	if(updateOrder_Check()){
		$.ajax({
			url : contextPath + "/Order/updateOrder.do",
			type : "post",
			data : {
				fid:$("#updatefid").val(),
				fRecieveDept:$("#updatefRecieveDept option:selected").val(),
				fRecieveUser :$("#updatefRecieveUser option:selected").text(),
				fRecieveTime : $("#updatefRecieveTime").val(),
				fPayStyle : $("#updatefPayStyle option:selected").val(),
				fOrderEmergency :$("#updatefOrderEmergency option:selected ").val(),
				fDealStatus : $("#updatefDealStatus option:selected").val(),
				fServiceObject : $("#updatefServiceObject option:selected").val(),
				fCallName : $("#updatefCallName").val(),
				fCallPhone : $("#updatefCallPhone").val(),
				fObjectName : $("#updatefObjectName").val(),
				fObjectPhone : $("#updatefObjectPhone").val(),
				fRequestTime : $("#updatefRequestTime").val(),
				fServiceAdd: $("#updatefServiceAdd").val(),		
				fOrderyExplain:$("#updatefOrderExplain").val(),
				fOrderType : $("#updatefOrderType option:selected").val(),
				fServiceProvide :$("#updatefServiceProvide option:selected").val(),		                       
				fServiceUser :$("#updatefServiceUser option:selected").text(),
				fServiceType : $("#updatefServiceType option:selected").val(),
				fServiceItem:$("#updatefServiceItem option:selected").val(),
				fPrice:parseFloat($("#updatefPrice").val().substring(0, $("#updatefPrice").val().length - 1)),
				fNumber : parseFloat($("#updatefNumber").val()),
				fTotal :parseFloat($("#updatefTotal ").val().substring(0, $("#updatefTotal").val().length - 1)) ,
			
			
			},
			success : function(data) {
	            setAlert(data.message,"更改订单成功");
				$('#tb_OrderManger').bootstrapTable('refresh', {
					url : 'query.do'
				});
               
                $("#update_close_btn").click();
				closeModal();
			}
		});
		
	}
	
		
}
// 删除

// 关闭
function closeModal(){
	$("#addOrderNumber").val('');
	$("#addfPrice").val('');
	$("#addfNumber").val('');
    $("#addfTotal ").val('');
	$("#addfCallName").val('');
	$("#addfCallPhone").val('');
	$("#addfObjectName").val('');
	$("#addfObjectPhone").val('');
    $("#addfServiceAdd").val('');	
	$("#addfOrderExplain").val('');
	 $("#addfRecieveDept option[value='养老院(默)']").attr("selected", true);
	 $("#addfRecieveUser option[value='1']").attr("selected", true);
	 $("#addfPayStyle option[value='现金(默)']").attr("selected", true);
	 $("#addfOrderEmergency option[value='一般(默)']").attr("selected", true);
	 $("#addfDealStatus option[value='已分配(默)']").attr("selected", true);
	 $("#addfServiceObject option[value='院内(默)']").attr("selected", true);
	 $("#addfOrderType option[value='服务预定(默)']").attr("selected", true);
	 $("#addfServiceProvide option[value='养老院(默)']").attr("selected", true);
	 $("#addfServiceUser option[value='1']").attr("selected", true);
	$("#addfServiceType").val("");
	 $("#addfServiceItem").val("");
	 $("#updatefPrice").val('');
	 $("#updatefNumber").val('');
	 $("#updatefTotal ").val('');
     $("#updatefCallName").val('');
     $("#updatefCallPhone").val('');
     $("#updatefObjectName").val('');
     $("#updatefObjectPhone").val('');
     $("#updatefServiceAdd").val('');	
     $("#updatefOrderExplain").val('');
	/*
     $("#printOrderNo").html('');  
	 $("#printOrderfid").val('');
	 $("#printfObjectName").val('');
	 $("#printfServiceItem").val('');
	 $("#printfTotal").val('');
	   */
	
	
}

// 页面回显数据
function gotoUpdate() {
	var bool="";
	var carrentItem = $("#tb_OrderManger").bootstrapTable('getSelections');
  
	if (carrentItem[0]) {
	
		if(carrentItem[0].fDealStatus!='已分配(默)'){
			setAlert("error", "该条订单无法更改");
			
		}else{
		
		 $("#updatefid").val(carrentItem[0].fid);
		 $("#updateOrderNumber").val(carrentItem[0].fOrderNo);
		 $("#updatefRecieveTime").val(carrentItem[0].fRecieveTime);
		 $("#updatefCallName").val(carrentItem[0].fCallName);
	     $("#updatefCallPhone").val(carrentItem[0].fCallPhone);
		 $("#updatefObjectName").val(carrentItem[0].fObjectName);
		 $("#updatefObjectPhone").val(carrentItem[0].fObjectPhone);
		 $("#updatefRequestTime").val(carrentItem[0].fRequestTime);
		 $("#updatefServiceAdd").val(carrentItem[0].fServiceAdd);		
		 $("#updatefOrderExplain").val(carrentItem[0].fOrderyExplain);

			getServiceName();//动态生成服务名字
			//动态生成服务种类
			$("#updatefServiceType").html("");
			var $add = $("#updatefServiceType");
			for ( var i = 0; i < servtypelen; i++) {
				if(servtype[i].FID==carrentItem[0].fServiceTypeid ){
					$add.append("<option selected='selected' value='" + servtype[i].FID + "'>"
						+ servtype[i].FServiceTypeName + "</option>");
				}else{
					$add.append("<option value='" + servtype[i].FID + "'>"
						+ servtype[i].FServiceTypeName + "</option>");
				}

			}
			;



		   //进行判断正在更改的服务项目名称是否被禁用
			for (var i=0;i<servlen;i++){
				if(serv[i].FID==carrentItem[0].fServiceItemid){
					bool=true;
				}
			}
			$("#updateUser_op").html("");

			//已经被禁用
			if(bool==''){

				var $add = $("#updatefServiceItem");
				$add.append("<option value='"+carrentItem[0].fServiceItemid+"' selected='selected' >"+carrentItem[0].fServiceItemName+"</option>");

				for ( var i = 0; i < servlen; i++) {
					if(serv[i].ItemId==$("#updatefServiceType option:selected").val()){
							$add.append("<option  price='" + serv[i].Fprice + "' Funit='元' value='"
								+ serv[i].FID + "'>"
								+ serv[i].FServiceItemName + "</option>");
						}

					}

			}

			//未被禁用
			if(bool==true){
				$("#updatefServiceItem").html("");
				var $add = $("#updatefServiceItem");
				for ( var i = 0; i < servlen; i++) {
					if(serv[i].ItemId==$("#updatefServiceType option:selected").val()){
						if(serv[i].FID==carrentItem[0].fServiceItemid){
							$add.append("<option  price='" + serv[i].Fprice + "' selected='selected'  Funit='元' value='"
								+ serv[i].FID + "'>"
								+ serv[i].FServiceItemName + "</option>");
						}else{
							$add.append("<option  price='" + serv[i].Fprice + "' Funit='元' value='"
								+ serv[i].FID + "'>"
								+ serv[i].FServiceItemName + "</option>");
						}

					}

				}

			}



			//更新的时候  项目类型动态生成项目名称
			//类型select变化 项目跟着变化

			//服务种类变化
			$("#updatefServiceType").change(function (){

				//类型select变化 项目跟着变化

				$("#updatefServiceItem").html("");
				var $add = $("#updatefServiceItem");
				$add.append("<option price='0' value=''>-请选择-</option>");
				for ( var i = 0; i < servlen; i++) {
					if(serv[i].ItemId==$("#updatefServiceType option:selected").val()){
						$add.append("<option  price='" + serv[i].Fprice + "' Funit='元' value='"
							+ serv[i].FID + "'>"
							+ serv[i].FServiceItemName + "</option>");
					}

				}



			});



		//单价 数量  总价直接显示


		$("#updatefPrice").val(carrentItem[0].fPrice+carrentItem[0].funit);
		$("#updatefNumber").val(carrentItem[0].fNumber);
		$("#updatefTotal").val(carrentItem[0].fTotal+carrentItem[0].funit);
		$("#updatefFinishTime").val(carrentItem[0].fFinishTime);
		$("#updatefRecieveTime").val(carrentItem[0].fRecieveTime);
		
		//更新验证种类的变化

		
		// 服务变化 单价跟着总价变化
		$("#updatefServiceItem").change(	
				function() {	
					$("#updatefPrice").val(
							$("#updatefServiceItem option:selected").attr(
									"price")+$("#updatefServiceItem option:selected").attr(
								"Funit"));
					var price = $("#updatefPrice").val();
					var priceF = parseFloat(price);
					if (!$("#updatefNumber").val() == '') {
						var number = parseFloat($("#updatefNumber").val());
						$("#updatefTotal").val(
								parseFloat(number * priceF).toFixed(2)
										+ $("#updatefServiceItem option:selected").attr(
									"Funit"));
					} else {
						$("#updatefTotal").val('0'+$("#updatefServiceItem option:selected").attr(
								"Funit"));
						$("#updatefNumber").val('0');
					}
				});

		// 数量变化总价也跟着变化
	
	
		
		// 数量变化总价也跟着变化
		$("#updatefNumber").blur(function() {
			var num=$("#updatefNumber").val();
		    $("updatefNumber_message").html('');
		    if(num==''||num.length==0){
			    $("#updatefNumber_message").html("数量不能为空");
			   	 $("#updatefTotal").val('');	
			    }else if(num==0){
					   	  $("#updatefNumber_message").html(''); 
					      $("#updatefNumber_message").html("数量不能为0");
					   	  $("#updatefTotal").val('');	
					   	 
			    	
			    }else{
				    $("#updatefNumber_message").html(" ");
	                
	                 
					var number1 = parseFloat($("#updatefNumber").val());
					var price = $("#updatefPrice").val();
				
					if(price==''){
					 	$("#updatefServiceItem_message").html("必选项目！");
						
					}else{
						var priceF = parseFloat(price);
						$("#updatefTotal").val(parseFloat(number1 * priceF).toFixed(2) +$("#updatefServiceItem option:selected").attr(
								"Funit"));
					}
								    	
			    }
		});
		
		
		
	//


	
		$("#updatefRecieveUser").html("");
		var $add = $("#updatefRecieveUser");
		for ( var i = 0; i < stafflen; i++) {
			if(staff[i].FStaffName==carrentItem[0].fRecieveUser){
				$add.append("<option  selected='selected' value='" + staff[i].FID + "'>"
						+ staff[i].FStaffName + "</option>");
			}else{
				$add.append("<option value='" + staff[i].FID + "'>"
						+ staff[i].FStaffName + "</option>");
			}
		}

		$("#updatefServiceUser").html("");
		var $add = $("#updatefServiceUser");
		for ( var i = 0; i < stafflen; i++) {	
			if( staff[i].FStaffName==carrentItem[0].fServiceUser){
				$add.append("<option  selected='selected' value='" + staff[i].FID + "'>"
						+ staff[i].FStaffName + "</option>");
			}else{
				$add.append("<option value='" + staff[i].FID + "'>"
						+ staff[i].FStaffName + "</option>");
			}
		
			
		}

		
		
		
		$("#updatefRecieveDept").html("");
		var $add = $("#updatefRecieveDept"); 
		for ( var i = 0; i < datalength; i++) {
			if (datalist[i].DC_NAME == "受理部门") {
				if(datalist[i].DC_VALUE==carrentItem[0].fRecieveDept){
					$add.append("<option selected='selected' value='" + datalist[i].DC_VALUE
							+ "'>" + datalist[i].DC_VALUE + "</option>");
				}else{
					$add.append("<option value='" + datalist[i].DC_VALUE
							+ "'>" + datalist[i].DC_VALUE + "</option>");
				}
			}
		}

		$("#updatefOrderEmergency").html("");
		var $add = $("#updatefOrderEmergency");
		for ( var i = 0; i < datalength; i++) {
			if (datalist[i].DC_NAME == "工单紧急程度") {
				if(datalist[i].DC_VALUE==carrentItem[0].fOrderEmergency){
					$add.append("<option selected='selected' value='" + datalist[i].DC_VALUE
							+ "'>" + datalist[i].DC_VALUE + "</option>");
				}else{
					$add.append("<option value='" + datalist[i].DC_VALUE
							+ "'>" + datalist[i].DC_VALUE + "</option>");
				}
			}
		}

		$("#updatefPayStyle").html("");
		var $add = $("#updatefPayStyle");
		for ( var i = 0; i < datalength; i++) {
			if (datalist[i].DC_NAME == "付款方式") {
				if(datalist[i].DC_VALUE==carrentItem[0].fPayStyle){
					$add.append("<option selected='selected' value='" + datalist[i].DC_VALUE
							+ "'>" + datalist[i].DC_VALUE + "</option>");
				}else{
					$add.append("<option value='" + datalist[i].DC_VALUE
							+ "'>" + datalist[i].DC_VALUE + "</option>");
				}
			}
		}

		$("#updatefDealStatus").html("");
		var $add = $("#updatefDealStatus");
		for ( var i = 0; i < datalength; i++) {
			if (datalist[i].DC_NAME == "处理状态") {
				if(datalist[i].DC_VALUE==carrentItem[0].fDealStatus){
					$add.append("<option selected='selected' value='" + datalist[i].DC_VALUE
							+ "'>" + datalist[i].DC_VALUE + "</option>");
				}else{
					$add.append("<option value='" + datalist[i].DC_VALUE
							+ "'>" + datalist[i].DC_VALUE + "</option>");
				}
			}
		}

		$("#updatefServiceObject").html("");
		var $add = $("#updatefServiceObject");
		for ( var i = 0; i < datalength; i++) {
			if (datalist[i].DC_NAME == "服务对象") {
				if(datalist[i].DC_VALUE==carrentItem[0].fServiceObject){
					$add.append("<option selected='selected' value='" + datalist[i].DC_VALUE
							+ "'>" + datalist[i].DC_VALUE + "</option>");
				}else{
					$add.append("<option value='" + datalist[i].DC_VALUE
							+ "'>" + datalist[i].DC_VALUE + "</option>");
				}
			}
		}

		$("#updatefOrderType").html("");
		var $add = $("#updatefOrderType");
		for ( var i = 0; i < datalength; i++) {
			if (datalist[i].DC_NAME == "工单类型") {
				if(datalist[i].DC_VALUE==carrentItem[0].fOrderType){
					$add.append("<option selected='selected' value='" + datalist[i].DC_VALUE
							+ "'>" + datalist[i].DC_VALUE + "</option>");
				}else{
					$add.append("<option value='" + datalist[i].DC_VALUE
							+ "'>" + datalist[i].DC_VALUE + "</option>");
				}
				
			}
		}

		$("#updatefServiceProvide").html("");
		var $add = $("#updatefServiceProvide");	
		for ( var i = 0; i < datalength; i++) {
			if (datalist[i].DC_NAME == "服务方") {
				
				if(datalist[i].DC_VALUE==carrentItem[0].fServiceProvide){
					$add.append("<option selected='selected' value='" + datalist[i].DC_VALUE
							+ "'>" + datalist[i].DC_VALUE + "</option>");
				}else{
					$add.append("<option value='" + datalist[i].DC_VALUE
							+ "'>" + datalist[i].DC_VALUE + "</option>");
				}
				
				
				
			}
		}
		
		$("#update_btn").click();
	}
		
		
	} else {
		setAlert("error", "请先选择一条数据");
	}
}

//评价订单
function addEvaluation(){
	

	$.ajax({
	url : contextPath + "/Order/evalOrder.do",
	type : "post",
	data : {
		fid:$("#Evalfid").val(),//订单id
		fFinishTime:$("#evalfFinishTime").val(),//完成时间
		fEvaluationOrder : $("#EvalfEvaluationOrder").val(),//评价订单

	
	
	},
	success : function(data) {
        setAlert(data.message,"评价订单成功");
		$('#tb_OrderManger').bootstrapTable('refresh', {
			url : 'query.do'
		});
	}
});
closeModal();
}

//评价订单回显示
function gotoEval(){
	$("#EvalfEvaluationOrder").val('');
	var carrentItem = $("#tb_OrderManger").bootstrapTable('getSelections');  
	if (carrentItem[0]){
		if(carrentItem[0].fDealStatus=='已完成'){
			setAlert("error", "该条订单无法评价");
		}else{
		 $("#Evalfid").val(carrentItem[0].fid);
		 $("#EvalOrderNumber").val(carrentItem[0].fOrderNo);
		 $("#EvalfObjectName").val(carrentItem[0].fObjectName);
		 var newfDate = new Date();
		 $("#evalfFinishTime").val(formatDateTime(newfDate));
		 $("#eval_btn").click();
	    }
		
		
	} else {
	  setAlert("error", "请先选择一条数据");
	}
}


function gotoDelete(){
	var carrentItem = $("#tb_OrderManger").bootstrapTable('getSelections');
	if (carrentItem[0]) {
	
		if(carrentItem[0].fDealStatus!='已分配(默)'){
		
			setAlert("error", "该订单无法禁用");
			
		}else{
			$.ajax({
				url : contextPath + "/Order/deleteOrder.do",
				type : "post",
				data : {
					fid:carrentItem[0].fid
				
				},
				success : function(data) {
		            setAlert(data.message,"禁用订单成功");
					$('#tb_OrderManger').bootstrapTable('refresh', {
						url : 'query.do'
					});
					
				}
				
			});
			
		}

	} else {
		
		setAlert("error", "请先选择一条数据");
	
	}
}

//打印回显示
function gotoPrin(){
	var str='';

	$("#evalservice").val("");
	var carrentItem = $("#tb_OrderManger").bootstrapTable('getSelections');
	  
	if (carrentItem[0]){
		if(carrentItem[0].fDealStatus!='已分配(默)'){
		
			setAlert("error", "该条订单无法打印");

			
		}else{
			$("#tb_order_print tbody").empty();

			var fServiceItem='';
			for ( var i = 0; i < servlen; i++) {
				if(serv[i].FID ==carrentItem[0].fServiceItemid){
					fServiceItem=serv[i].FServiceItemName;
				}
			
			}


			str="<tr>" +
				"<td style='border-color: black'>"+carrentItem[0].fid+"</td>" +
				"<td style='border-color: black'>"+carrentItem[0].fObjectName+"</td>" +
				"<td style='border-color: black'>"+fServiceItem+"</td>" +
				"<td style='border-color: black'>"+carrentItem[0].fTotal+"元"+"</td>" +
				"<td style='border-color: black'>"+carrentItem[0].fFinishTime+"</td>" +
				"</tr>";

			var newfDate = new Date();
			$("#printDate").html(formatDateTime(newfDate));

			     $("#printOrderNo").html(carrentItem[0].fOrderNo);
			     $("#tb_order_print").append(str);
				 $("#printtime").val('');
				 $("#print_btn").click(); 

	    }
		
		
	} else {
	  setAlert("error", "请先选择一条数据");
	}
}

//按条件查询
function getSearch(){
	
	$.ajax({
		url : contextPath + "/Order/queryNumber.do",
		type : "post",
		success : function(data) {
			
			$("#serviceOldNumber").html("");
			var $add = $("#serviceOldNumber");
			$add.append("<option value=''>-请选择-</option>");
			for ( var i = 0; i < data.total; i++) {
				$add.append("<option value='" + data.rows[i].FOrderNo +  "'>"
						+ data.rows[i].FOrderNo + "</option>");
			}



		}
	});
	
	$.ajax({
		url : contextPath + "/Order/queryData.do",
		type : "post",
		success : function(data) {
			
			$("#serviceObject").html("");
			var $add = $("#serviceObject");
			$add.append("<option value=''>-请选择-</option>");
			for ( var i = 0; i < data.total; i++) {
				if (data.rows[i].DC_NAME == "服务对象") {
						$add.append("<option value='" + data.rows[i].DC_VALUE
								+ "'>" + data.rows[i].DC_VALUE + "</option>");
					
				}
			}


			$("#serviceStatus").html("");
			var $add = $("#serviceStatus");
			$add.append("<option value=''>-请选择-</option>");
			for ( var i = 0; i < data.total; i++) {
				if (data.rows[i].DC_NAME == "处理状态") {
					
						$add.append("<option value='" + data.rows[i].DC_VALUE
								+ "'>" + data.rows[i].DC_VALUE + "</option>");
				
				}
			}


		}
		});
	//查询条件的select
	$.ajax({
		url : contextPath + "/Order/queryStaffMessage.do",
		type : "post",
		success : function(data) {
			
			
			$("#serviceUser").html("");
			var $add = $("#serviceUser");
			$add.append("<option value=''>-请选择-</option>");
			for ( var i = 0; i < data.total; i++) {
				$add.append("<option value='" + data.rows[i].FStaffName  + "'>"
						+ data.rows[i].FStaffName + "</option>");
			}
	
		}
	});


}
	





