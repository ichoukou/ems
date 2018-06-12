$(function() {
	// 1.初始化Table
	    getSearch();
		getStorageGoodsSorting();
	var oTable = new TableInit();
	oTable.Init();

});
var rows='';
var length1='';
var num='';
var son='';
var sonsize='';

var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {

		 //初始化物品入库清单
		$('#tb_InStorage').bootstrapTable({
			url : 'query.do', // 请求后台的URL（*）
			method : 'get', // 请求方式（*）
			toolbar : '#toolbar', // 工具按钮用哪个容器
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 是否显示分页（*）
			sortable : false, // 是否启用排序
		   sortOrder : "asc", // 排序方式
			queryParams : oTableInit.queryParams1,// 传递参数（*）
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
				field : 'fNumber',
				title : '单据编号',
				align: 'center'
			}, {
				field : 'fInStorageDate',
				title : '入库日期 ',
				align: 'center'

			}, {
				field : 'fStoreHouseName',
				title : '仓库'
			}, {
				field : 'fStoreName',
				title : '保管员'
			}, {
				field : 'fOperatorName',
				title : '经办人'
			}, {
				field : 'fRemarks',
				title : '说明'
			},{
				field : 'fid',
				title : '序号'

			},{
				field : 'fMaterialName',
				title : '物品名称'

			},{
				field : 'fStandard',
				title : '规格'

			},{
				field : 'fQty',
				title : '数量'

			}],
			onLoadSuccess: function(data){
				hebing();
			}


		});

		//初始化物资表
		$('#tb_Stock').bootstrapTable({
			url: 'querySonMaterial.do',   //请求后台的URL（*）
			method: 'get',      //请求方式（*）
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //是否显示分页（*）
			sortable: false,      //是否启用排序
			sortOrder: "asc",     //排序方式
			queryParams: oTableInit.queryParams2,//传递参数（*）
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 5,      //每页的记录行数（*）
			pageList: [5, 10, 15, 20],  //可供选择的每页的行数（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: true,
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: true,    //是否启用点击选中行
			// height: 600,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			// uniqueId: "ID",      //每一行的唯一标识，一般为主键列
			showToggle:true,     //是否显示详细视图和列表视图的切换按钮
			cardView: false,     //是否显示详细视图
			detailView: false,     //是否显示父子表
			columns: [
				{
					checkbox:true,
					width:40,
			},
				{
					field: 'material', /*'FStoreHouseName',*/
					title: '仓库',
					align: 'center',
					width:90,
					formatter:function(value1,row,index){

						return queryGetHouse(index);
					}
				}, {
					field:  'material', /*'FStaffName',*/
					title: '保管员',
					align: 'center',
					width:90,
					formatter:function(value1,row,index){
						return "<span id='span"+index+"'></span>";
					}
				}, {
					field: 'material',
					title: '物资',
					align: 'center',
					width:140,
				},{
					field: 'standrad',
					title: '规格',
					align: 'center',
					width:120,
				},{
					field: 'name',
					title: '入库数量',
					align: 'center',
					width:80,
					formatter:function(value1,row,index){
						return "<input  type='text' class='price' style='width: 70px' onkeyup=\"value=value.replace(/[^\\d]/g,'')\"/>";

					}
				},{
					field: 'unit',
					title: '单位',
					align: 'center',
					width:80,
				}, {
					field: 'remark',
					title: '备注',
					align: 'center',
					// width:100,
				}
			],onLoadSuccess: function(data){
                        num=data.total;

				for(var i=0;i<num;i++) {

					(function (i) {
						$("#house" + i + "").change(function () {
							$("#span" + i + "").html($("#house" + i + " option:selected").data("staffname"));

							});
					})(i);
				}

			}
		});

	}
	// 得到查询的参数
	oTableInit.queryParams1 = function(params) {

		var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			pageSize : params.limit, // 页面大小
			page : params.offset, // 页码
			fMaterialName:$("#materialName").val(),
			fStoreHouseName:$("#storeHouseName").val(),
			fStandard:$("#standard").val(),
			fNumber:$("#number").val(),
			start:$("#Edate").val(),
			finish:$("#Ldate").val(),
		};
		return temp;
	};
	//得到查询的参数
	oTableInit.queryParams2 = function (params) {
		var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			pageSize : 5, // 页面大小
			page : params.offset, // 页码
			material:$("#in_goodsAdd_material").val(),
			materialTypeID:$("#in_goodsAdd_type option:selected").val()

		};
		return temp;
	};

	return oTableInit;
};


//加载函数直接遍历负责人select
var length='';
var row='';
var staff='';
var  stafflen='';
var  materialcount=1;//序号
var arr1=[];
var arr2=[];
var arr3=[];
var arr4=[];
$(document).ready(function (){


});


//可以进行选择仓库进行入库
function queryGetHouse(index){
	var c='';
	$.ajax({
		url : contextPath + "/InStorage/queryGetHouse.do",
		type : "post",
		success : function(data) {
			rows=data.rows;
			length1=data.total;
		}
	});
	  c="<select  id='house"+index+"'  ><option value=''  data-staffName='' data-staffid='' >-请选择-</option>"
	for ( var i = 0; i < length1; i++) {
		c+="<option value='" + rows[i].FID + "'  data-staffName='" + rows[i].FStaffName + "' data-staffid='" + rows[i].Staffid + "'>"+rows[i].FStoreHouseName +"</option>";
	}
      c+"</select>"
	return c;


}
// 按条件查询 遍历select
function getSearch() {
	// 条件查询 物资名称
	$.ajax({
		url : contextPath + "/InStorage/queryFMaterialName.do",
		type : "post",
		success : function(data) {
        	
			$("#materialName").html("");
			var $add = $("#materialName");
			$add.append("<option value='' selected>-请选择-</option>");
			for ( var i = 0; i < data.total; i++) {
				$add.append("<option value='" + data.rows[i].FMaterialName
						+ "'>" + data.rows[i].FMaterialName + "</option>");
			}

		}
	});
	// 条件查询 仓库名称
	$.ajax({
		url : contextPath + "/InStorage/queryFStoreHouseName.do",
		type : "post",
		success : function(data) {

			$("#storeHouseName").html("");
			var $add = $("#storeHouseName");
			$add.append("<option value=''>-请选择-</option>");
			for ( var i = 0; i < data.total; i++) {
				$add.append("<option value='" + data.rows[i].FStoreHouseName
						+ "'>" + data.rows[i].FStoreHouseName + "</option>");

			}
		}
	});
	// 条件查询 规格名称
	$.ajax({
		url : contextPath + "/InStorage/queryFStandard.do",
		type : "post",
		success : function(data) {
			
			$("#standard").html("");
			var $add = $("#standard");
			$add.append("<option value=''>-请选择-</option>");
			for ( var i = 0; i < data.total; i++) {
				$add.append("<option value='" + data.rows[i].FStandard + "'>"
						+ data.rows[i].FStandard + "</option>");
			}
		}

	});

}	
// 按条件查询 
function queryInStorage(){

	    fMaterialName=$("#materialName option:selected").val(),
		fStoreHouseName=$("#storeHouseName option:selected").val(),
		fStandard=$("#standard option:selected").val(),
		fNumber=$("#number").val(),
		start=$("#Edate").val(),
		finish=$("#Ldate").val(),
		$("#tb_InStorage").bootstrapTable('selectPage',1);

	/*$.ajax({
	        url: contextPath + "/InStorage/queryList.do",
	        type: "post",
	        data: {	
				fMaterialName:$("#materialName option:selected").val(),
				fStoreHouseName:$("#storeHouseName option:selected").val(),
				fStandard:$("#standard option:selected").val(),
				fNumber:$("#number").val(),
				start:$("#Edate").val(),
				finish:$("#Ldate").val(),	
	            pageSize: 10, //页面大小
	            page: 0, //页码
	            
	          },
	        success: function (data) {
	            $('#tb_InStorage').bootstrapTable('load', data);
	        }
	    });*/
	
	
}
// 清除查询条件
function clearaSelect(){
	   $("#materialName").val('');
	   $("#storeHouseName").val('');     
       $("#standard").val('');//编号
       $("#number").val('');  
       $("#Edate").val('');
       $("#Ldate").val('');     
}

//合并编号相同的项
function hebing() {

	var trlist=$("#tb_InStorage tbody tr");

	var beging=0;
	var end=0;
	var number=0;
	var tdlist;
	for(var i=0;i<trlist.size();i++)
	{
		tdlist=trlist.eq(i).find(' td ');
		if(number==tdlist.eq(1).html())
		{
			end=i;
			if(end==(trlist.size()-1))
			{
				tdlist=trlist.eq(beging).find(' td ');
				tdlist.eq(0).attr("rowspan",end-beging+1);
				tdlist.eq(1).attr("rowspan",end-beging+1);
				tdlist.eq(2).attr("rowspan",end-beging+1);

				for(var j=(beging+1);j<=end;j++)
				{
					tdlist=trlist.eq(j).find(' td ');
					tdlist.eq(0).css('display','none');
					tdlist.eq(1).css('display','none');
					tdlist.eq(2).css('display','none');

				}
			}
		}
		else{
			number=tdlist.eq(1).html();
			if((end-beging)>0)
			{
				tdlist=trlist.eq(beging).find(' td ');
				tdlist.eq(0).attr("rowspan",end-beging+1);
				tdlist.eq(1).attr("rowspan",end-beging+1);
				tdlist.eq(2).attr("rowspan",end-beging+1);

				for(var j=(beging+1);j<=end;j++)
				{
					tdlist=trlist.eq(j).find(' td ');
					tdlist.eq(0).css('display','none');
					tdlist.eq(1).css('display','none');
					tdlist.eq(2).css('display','none');

				}
			}
			beging=i;
			end=i;
		}
	}
}

//InStorageList-->InStorageAdd
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
//显示入库菜单
function showInStorage(){
	$("#add_operator").val('');
	$("#add_explain").val('');
	$("#add_storageInDetailed tbody").empty();
	var newfDate = new Date();
	$("#addfInStorageDate").val(formatDateTime(newfDate));
	$("#add_number").val("IS"+formatDateTimeNumber(newfDate));
    //操作人下拉框
	$.ajax({
		url : contextPath + "/Order/queryStaffMessage.do",
		type : "post",
		success : function(data) {
			staff=data.rows;
			stafflen=data.total;
			
			$("#add_operator").html("");
			var $add = $("#add_operator");
			$add.append("<option value=''>-请选择-</option>");
			for ( var i = 0; i < data.total; i++) {
				$add.append("<option value='" + data.rows[i].FID + "'>"
						+ data.rows[i].FStaffName + "</option>");
			}
		}
	});
	$("#add_btn").click();//跳出菜单
}
//新建入库单里的物品添加
function add_In_Add() {
	$('#tb_Stock').bootstrapTable('refresh', {url: 'querySonMaterial.do'});
	 //下面进行动态赋值
	$("#addGoodsModal").modal('show');
	$("#addOrUpdate").val('');
	$("#addOrUpdate").val('add');
}
//新建入库单里的物品删除
function add_In_Delect() {

	$('#add_storageInDetailed tbody tr').each(function(){
		var input= $(this).find("input[type=checkbox]");
		if(input.prop("checked"))
		{
			input.parent().parent().remove();
			materialcount--;
		}
	});
	var count=1;
	$('#add_storageInDetailed tbody tr ').each(function(){
		var td=$(this).find('td');
		td.eq(1).html(count);
		count++;
	});
}
//新建入库单保存
function add_In_Save() {
    var inStorageEntrySql = "";
    var stockAccountSql = "";
    $("#in_message").html("");
    $("#in_in_message").html("");
    //验证
    if ($("#addfInStorageDate").val().trim() == "") {
        $("#in_message").html("");
        $("#in_in_message").html("");
        $("#in_message").html("请选择出库日期");
        $("#in_in_message").html("请选择出库日期");

    }
    else {
        if ($("#add_operator option:selected").val().trim() == "") {
            $("#in_message").html("");
            $("#in_in_message").html("");
            $("#in_message").html("请选择操作人");
            $("#in_in_message").html("请选择操作人");
        }
        else {
            if ($("#add_explain").val().trim() == "") {
                $("#in_message").html("");
                $("#in_in_message").html("");
                $("#in_message").html("请填写说明");
                $("#in_in_message").html("请填写说明");

            } else {
                var tr = $('#add_storageInDetailed tbody tr ');
                if (tr[0]) {
                    $("#in_message").html("");
                    $("#in_in_message").html("");
                    $('#add_storageInDetailed tbody tr ').each(function () {
                        var td = $(this).find('td');//仓库id  数量  备注  物料id  保管员id
                        inStorageEntrySql = inStorageEntrySql + "_" + td.eq(3).html() + "=" + td.eq(9).html() + "=" + td.eq(10).html() + "=" + td.eq(7).html() + "=" + td.eq(5).html();
                    });
                    $('#add_storageInDetailed tbody tr ').each(function () {
                        var td = $(this).find('td');//仓库id  物料id 数量 规格
                        stockAccountSql = stockAccountSql + "_" + td.eq(3).html() + "=" + td.eq(7).html() + "=" + td.eq(9).html() + "=" + td.eq(8).html();
                    });
                   $.ajax({
                        url: contextPath + "/InStorage/addInStorage.do",
                        type: "post",
                        data: {
                            //主表需要信息
                            fNumber: $("#add_number").val(),//主表单号
                            fInStorageDate: $("#addfInStorageDate").val(),//物品入库时间
                            fOperatorID: $("#add_operator option:selected").val(),//操作人id
                            fExplain: $("#add_explain").val(),//说明
                            //字表需要信息
                            inStorageEntrySql: inStorageEntrySql,
                            //库存表
                            stockAccountSql: stockAccountSql
                        },
                        success: function (data) {
                            $("#add_close_btn").click();
							$('#tb_InStorage').bootstrapTable('refresh', {url: 'query.do'});
							setAlert(data.message, "物品入库成功");
							closeModal();
                        }
                    });

                } else {
                    $("#in_message").html("");
                    $("#in_in_message").html("");
                     $("#in_message").html("请选择添加物品");
                    $("#in_in_message").html("请选择添加物品");

                }
            }
        }
    }
}



//更新入库单 回显数据
function gotoUpdate(){
	var carrentItem = $("#tb_InStorage").bootstrapTable('getSelections');
	var str="";
	if(carrentItem[0]){
		//如果被选中
		$.ajax({
			url : contextPath + "/InStorage/getUpdateAllMaterial.do",
			type : "post",
			data:{
				fatherid:carrentItem[0].fParentID
			},
			success : function(data) {
					 son=data.rows;
				     sonsize=data.total;
				   console.log(data);
				$("#update_storageInDetailed tbody").html('');
				for(var i=0;i<data.total;i++){
					str+="<tr>"+
						"<td style='text-align: center; '>" +
						"<input name='btSelectItem' type='checkbox'>" +
						"</td> " +
						"<td style='text-align: center;display:none; ' >"+data.rows[i].FID+"</td> " +
						"<td style='text-align: center; '>"+data.rows[i].FStoreHouseName+"</td> " +
						"<td style='text-align: center;display:none; ' >"+data.rows[i].FStoreID+"</td> " +
						"<td style='text-align: center; '>"+data.rows[i].FStoreName+"</td> " +
						"<td style='text-align: center;display:none; ' >"+data.rows[i].FStoremanID+"</td> " +
						"<td style='text-align: center; '>"+data.rows[i].FMaterialName+"</td> " +
						"<td style='text-align: center; display:none;' >"+data.rows[i].FMaterialID+"</td> " +
						"<td style='text-align: center; '>"+data.rows[i].FStandard+"</td> " +
						"<td style='text-align: center; '>"+data.rows[i].FQty+"</td> " +
						"<td style='text-align: center; '>"+data.rows[i].FRemarks+"</td> </tr>" ;

				}
				$("#update_storageInDetailed").append(str);
				$('#update_storageInDetailed tbody tr').unbind('click');
				$('#update_storageInDetailed tbody tr').click(function () {
					var input = $(this).find("input[type=checkbox]");
					if(input.prop("checked"))
					{
						input.removeAttr("checked");
					}
					else
					{
						input.prop("checked","true");
					}
				});
				$("#update_id").val(data.rows[0].Fatherid);
				$("#update_number").val(data.rows[0].FNumber);
				$("#updatefInStorageDate").val(data.rows[0].FInStorageDate);
				$("#update_explain").val(data.rows[0].FExplain);
				//经办人
				$.ajax({
					url : contextPath + "/Order/queryStaffMessage.do",
					type : "post",
					success : function(data1) {
						$("#update_operator").html("");
						var $add = $("#update_operator");
						for ( var i = 0; i <data1.total; i++) {
							if(data.rows[0].FOperatorName== data1.rows[i].FStaffName) {
								$add.append("<option selected='selected' value='" + data1.rows[i].FID + "'>"
									+data1.rows[i].FStaffName + "</option>");
							}else{
								$add.append("<option value='" + data1.rows[i].FID + "'>"
									+ data1.rows[i].FStaffName + "</option>");
							}
						}
					}
				});

				}
	});




		$("#update_btn").click();
	}else{
		setAlert("error","请先选择一条数据");
	}





}
//全删除 根据指定单据编号 进行删除
function gotoDelete(){
	var carrentItem = $("#tb_InStorage").bootstrapTable('getSelections');
	var Delect="";
    if(carrentItem[0]){
		//如果被选中
		$.ajax({
			url : contextPath + "/InStorage/getUpdateAllMaterial.do",
			type : "post",
			data:{
				fatherid:carrentItem[0].fParentID
			},
			success : function(data) {
				son=data.rows;
				sonsize=data.total;

				for(var i=0;i<sonsize;i++){
					//仓库id  物料id 数量 规格
					Delect += "_" +son[i].FStoreID + "=" + son [i].FMaterialID+ "=" + son[i].FQty + "=" + son[i].FStandard+"="+son[i].FID;

				}
				$.ajax({
					url: contextPath + "/InStorage/deleteInStorage.do",
					type: "post",
					data: {
						//主表需要信息
						fid:carrentItem[0].fParentID,
						stockAccountSqlDelect:Delect

					},
					success: function (data) {
						$('#tb_InStorage').bootstrapTable('refresh', {url: 'query.do'});
						setAlert(data.message, "物品删除成功");
						closeModal();
					}
				});


			}});



		  console.log(carrentItem[0].fParentID);
		  console.log(Delect);


   }else{
	setAlert("error","请先选择一条数据");
   }

}
//更新入库单里面物品

function update_In_Add() {
	$('#tb_Stock').bootstrapTable('refresh', {url: 'querySonMaterial.do'});
	//下面进行动态赋值
	$("#addGoodsModal").modal('show');
	$("#addOrUpdate").val('');
	$("#addOrUpdate").val('update');

}
//更新入库单里面物品 删除物品
function update_In_Delect() {

	$('#update_storageInDetailed tbody tr').each(function(){
		var input= $(this).find("input[type=checkbox]");
		if(input.prop("checked"))
		{
			input.parent().parent().remove();

		}
	});

}
//更新保存
function update_In_Save() {

	var inStorageEntrySql = "";
	var stockAccountSql = "";
	var inStorageEntrySqlDelect = "";//未改动的库存信息
	var stockAccountSqlDelect = "";//未删除的库存信息
	$("#update_in_message").html("");
	$("#in_message_update").html("");
	//验证
	if ($("#updatefInStorageDate").val().trim() == "") {
		$("#update_in_message").html("");
		$("#in_message_update").html("");
		$("#update_in_message").html("请选择出库日期");
		$("#in_message_update").html("请选择出库日期");

	}
	else {
		if ($("#update_operator option:selected").val().trim() == "") {
			$("#update_in_message").html("");
			$("#in_message_update").html("");
			$("#update_in_message").html("请选择操作人");
			$("#in_message_update").html("请选择操作人");
		}
		else {
			if ($("#update_explain").val().trim() == "") {
				$("#update_in_message").html("");
				$("#in_message_update").html("");
				$("#update_in_message").html("请填写说明");
				$("#in_message_update").html("请填写说明");

			} else {
				var tr = $('#update_storageInDetailed tbody tr ');
				if (tr[0]) {
					$("#update_in_message").html("");
					$("#in_message_update").html("");
					$('#update_storageInDetailed tbody tr ').each(function () {
						var td = $(this).find('td');//仓库id  数量  备注  物料id  保管员id
						console.log(td.eq(1).html());
						//等于0代表直接增加的可用直接直接调用add方法
						if ((td.eq(1).html() == '0')) {
							inStorageEntrySql = inStorageEntrySql + "_" + td.eq(3).html() + "=" + td.eq(9).html() + "=" + td.eq(10).html() + "=" + td.eq(7).html() + "=" + td.eq(5).html();
						}else{
                            inStorageEntrySqlDelect += "_" + td.eq(1).html();
                        }


					});
					$('#update_storageInDetailed tbody tr ').each(function () {
						var td = $(this).find('td');//仓库id  物料id 数量 规格
						if ((td.eq(1).html() == '0')) {
							stockAccountSql = stockAccountSql + "_" + td.eq(3).html() + "=" + td.eq(7).html() + "=" + td.eq(9).html() + "=" + td.eq(8).html();
						}
					});

					console.log(inStorageEntrySql=="");
					console.log("准备新增的账户：" + stockAccountSql=="");
					console.log("准备更新的数据：" + inStorageEntrySqlDelect);
					console.log("准备更新的账户：" + stockAccountSqlDelect);
					console.log(son);
					console.log(sonsize);

                    arr2=inStorageEntrySqlDelect.split("_");

                    for(var i=0;i<sonsize;i++){
                        arr1+=son[i].FID+','; //仓库id  物料id 数量 规格
                        stockAccountSqlDelect += "_" +son[i].FStoreID + "=" + son [i].FMaterialID+ "=" + son[i].FQty + "=" + son[i].FStandard+"="+son[i].FID;

                    }


                    console.log("更新的父亲id："+$("#update_id").val());

                   	$.ajax({
                            url: contextPath + "/InStorage/updateInStorage.do",
                            type: "post",
                            data: {
                                //主表需要信息
								fid:$("#update_id").val(),
                                fNumber: $("#update_number").val(),//主表单号
                                fInStorageDate: $("#updatefInStorageDate").val(),//物品入库时间
                                fOperatorID: $("#update_operator option:selected").val(),//操作人id
                                fExplain: $("#update_explain").val(),//说明
                                //字表需要信息
                                inStorageEntrySql: inStorageEntrySql,
                                //库存表
                                stockAccountSql: stockAccountSql,
                                //需要对库存进行修改数据
                                stockAccountSqlDelect:stockAccountSqlDelect,
                                //不需要删除的数据
                                inStorageEntrySqlDelect:inStorageEntrySqlDelect,
                                //原来的数据
                                arr1:arr1

                            },
                            success: function (data) {
                                $("#update_close_btn").click();
                                $('#tb_InStorage').bootstrapTable('refresh', {url: 'query.do'});
                                setAlert(data.message, "物品更新成功");
								arr1="";
                                closeModal();
                            }
                        });

				} else {
					$("#update_in_message").html("");
					$("#in_message_update").html("");
					$("#update_in_message").html("请选择添加物品");
					$("#in_message_update").html("请选择添加物品");

				}
			}
		}
	}
}


//InStorageAdd<-->storageInGoodsAdd

//加载物品查询里的物品分类下拉框
function getStorageGoodsSorting(){
	$.ajax({
		url:contextPath+"/storageGoods/getStorageGoodsSortingTypeList.do",
		type:"post",
		data:{
			id:'',
		},
		success:function(data) {
			$("#in_goodsAdd_type").empty();
			$("#in_goodsAdd_type").append("<option value='' selected>-请选择-</option>")
			$.each(data,function (key,Data) {
				$("#in_goodsAdd_type").append("<option value=" +Data.id + ">" + Data.typeName + "</option>")
			})
		}
	});

}
//清空条件
function clearSelect(){
	$("#in_goodsAdd_type").val('');
	$("#in_goodsAdd_material").val('');
}
//入库物品条件查询
function queryInMaterialList(){

	$.ajax({
		url:contextPath+"/InStorage/querySonMaterial.do",
		type:"post",
		data:{
			pageSize:5, //页面大小
			page: 0 , //页码
			material:$("#in_goodsAdd_material").val(),
			materialTypeID:$("#in_goodsAdd_type option:selected").val()
		},
		success:function(data) {
			$("#tb_Stock").bootstrapTable('load',data);
			for(var i=0;i<num;i++) {

				(function (i) {
					$("#house" + i + "").change(function () {
						$("#span" + i + "").html($("#house" + i + " option:selected").data("staffname"));
					});
				})(i);
			}
		}
	});
}
//入库物品添加
function in_check_goodsadd() {
	$("#in_head_message").html("");
	$("#in_footer_message").html("");

	var carrentItem = $("#tb_Stock").bootstrapTable('getSelections');
	var str=[];
	if(carrentItem[0]){
		$('#tb_Stock tbody tr td input[type=checkbox]:checked').each(function(index){
			if($(this).closest('tr').children('td').eq(2).text()==''){
					$("#in_head_message").html("")
					$("#in_head_message").html("请选择仓库");
					$("#in_footer_message").html("");
					$("#in_footer_message").html("请选择仓库");
			 	str[index]=false;

				}else {
					if ($(this).closest('tr').children('td').eq(5).find('input[type=text]').val() == '') {

						$("#in_head_message").html("")
						$("#in_head_message").html("添加物品数量不能为空");
						$("#in_footer_message").html("");
						$("#in_footer_message").html("添加物品数量不能为空");

						str[index]=false;
					} else {
						if ($(this).closest('tr').children('td').eq(5).find('input[type=text]').val() == '0') {

							$("#in_head_message").html("")
							$("#in_head_message").html("添加物品数量不能为0");
							$("#in_footer_message").html("");
							$("#in_footer_message").html("添加物品数量不能为0");
							str[index]=false;
						}else{
							str[index]=true;
						}
					}
				}
		});

	}else{
		$("#in_head_message").html("")
		$("#in_head_message").html("至少选择一行");
		$("#in_footer_message").html("");
		$("#in_footer_message").html("至少选择一行");
         str[0]=false;
	}
    return str;
}
//入库物品添加到入库单里面
function in_goodsadd(){


	console.log($("#addOrUpdate").val());
	console.log($("#addOrUpdate").val()=='add');
	console.log($("#addOrUpdate").val()=='update');



var str="";
   if(in_check_goodsadd().toString().indexOf("false")==-1){
	   var carrentItem = $("#tb_Stock").bootstrapTable('getSelections');

	   if($("#addOrUpdate").val()=='add'){
		   $('#tb_Stock tbody tr td input[type=checkbox]:checked').each(function(index){


			   str+="<tr>"+
				   "<td style='text-align: center; '>" +
				   "<input name='btSelectItem' type='checkbox'>" +
				   "</td> " +
				   "<td style='text-align: center; '>"+ materialcount +"</td> " +
				   "<td style='text-align: center; '>"+$(this).closest('tr').children('td').eq(1).find('select option:selected').html()+"</td> " +
				   "<td style='text-align: center;display:none; ' >"+$(this).closest('tr').children('td').eq(1).find('select option:selected').val()+"</td> " +
				   "<td style='text-align: center; '>"+$(this).closest('tr').children('td').eq(2).text()+"</td> " +
				   "<td style='text-align: center;display:none; ' >"+$(this).closest('tr').children('td').eq(1).find('select option:selected').data('staffid')+"</td> " +
				   "<td style='text-align: center; '>"+carrentItem[index].material+"</td> " +
				   "<td style='text-align: center; display:none;' >"+carrentItem[index].id+"</td> " +
				   "<td style='text-align: center; '>"+carrentItem[index].standrad+"</td> " +
				   "<td style='text-align: center; '>"+$(this).closest('tr').children('td').eq(5).find('input[type=text]').val()+"</td> " +
				   "<td style='text-align: center; '>"+carrentItem[index].remark+"</td> </tr>" ;

			   materialcount++;


		   });
		   $("#add_storageInDetailed").append(str);
		   $('#add_storageInDetailed tbody tr').unbind('click');
		   $('#add_storageInDetailed tbody tr').click(function () {
			   var input = $(this).find("input[type=checkbox]");
			   if(input.prop("checked"))
			   {
				   input.removeAttr("checked");
			   }
			   else
			   {
				   input.prop("checked","true");
			   }
		   });
	   }else{
		   $('#tb_Stock tbody tr td input[type=checkbox]:checked').each(function(index){

			   str+="<tr>"+
				   "<td style='text-align: center; '>" +
				   "<input name='btSelectItem' type='checkbox'>" +
				   "</td> " +
				   "<td style='text-align: center;display:none; ' >0</td> " +
				   "<td style='text-align: center; '>"+$(this).closest('tr').children('td').eq(1).find('select option:selected').html()+"</td> " +
				   "<td style='text-align: center;display:none; ' >"+$(this).closest('tr').children('td').eq(1).find('select option:selected').val()+"</td> " +
				   "<td style='text-align: center; '>"+$(this).closest('tr').children('td').eq(2).text()+"</td> " +
				   "<td style='text-align: center;display:none; ' >"+$(this).closest('tr').children('td').eq(1).find('select option:selected').data('staffid')+"</td> " +
				   "<td style='text-align: center; '>"+carrentItem[index].material+"</td> " +
				   "<td style='text-align: center; display:none;' >"+carrentItem[index].id+"</td> " +
				   "<td style='text-align: center; '>"+carrentItem[index].standrad+"</td> " +
				   "<td style='text-align: center; '>"+$(this).closest('tr').children('td').eq(5).find('input[type=text]').val()+"</td> " +
				   "<td style='text-align: center; '>"+carrentItem[index].remark+"</td> </tr>" ;



		   });
		   $("#update_storageInDetailed").append(str);
		   $('#update_storageInDetailed tbody tr').unbind('click');
		   $('#update_storageInDetailed tbody tr').click(function () {
			   var input = $(this).find("input[type=checkbox]");
			   if(input.prop("checked"))
			   {
				   input.removeAttr("checked");
			   }
			   else
			   {
				   input.prop("checked","true");
			   }
		   });


	   }

	   $("#in_goodsAdd_close_btn").click();
	   $("#in_message").html("");
	   $("#in_in_message").html("");



   }
}
//关闭modal
function closeModal(){
	clearaSelect();
	$("#in_head_message").html("")
	$("#in_footer_message").html("");

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


