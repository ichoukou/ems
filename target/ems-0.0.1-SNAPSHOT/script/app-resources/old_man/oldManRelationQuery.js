/**
 *lizhu
 */
$(function () {
	getOldManRelation();
});
function initTab1(value) {
	var TableInit = function() {
		var oTableInit = new Object();
		// 初始化Table
		oTableInit.Init = function() {
			$('#tb_relation').bootstrapTable({
				url : contextPath + "/relation/queryRelation.do", // 请求后台的URL（*）
				method: 'get',      // 请求方式（*）
	            striped: true,      // 是否显示行间隔色
	            cache: false,      // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
	            pagination: true,     // 是否显示分页（*）
	            sortable: false,      // 是否启用排序
	            sortOrder: "asc",     // 排序方式
	            queryParams: oTableInit.queryParams,// 传递参数（*）
                sidePagination: "server",   // 分页方式：client客户端分页，server服务端分页（*）
	            pageNumber:1,      // 初始化加载第一页，默认第一页
	            pageSize: 5,      // 每页的记录行数（*）
	            pageList: [5 ,10, 25, 50, 100],  // 可供选择的每页的行数（*）
	            search: false,      // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
	            strictSearch: true,
	            showColumns: true,     // 是否显示所有的列
	            showRefresh: true,     // 是否显示刷新按钮
	            minimumCountColumns: 2,    // 最少允许的列数
	            clickToSelect: true,    // 是否启用点击选中行
	            height: 350,      // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
	            uniqueId: "ID",      // 每一行的唯一标识，一般为主键列
	            showToggle:true,     // 是否显示详细视图和列表视图的切换按钮
	            cardView: false,     // 是否显示详细视图
	            detailView: false,     // 是否显示父子表
				columns : [ {
					radio : true
				}, {
					field : 'fID',
					title : '编号'
				}, {
					field : 'fRelationDict',
					title : '关系'
				}, {
					field : 'fRelationName',
					title : '姓名'
				}, {
					field : 'fRelationAge',
					title : '年龄'
				} , {
					field : 'fRelationMobile',
					title : '电话'
				}],
			});
		};
		// 得到查询的参数
		oTableInit.queryParams = function(params) {
			var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
				pageSize : params.limit, // 页面大小
				page : params.offset, // 页码
				fOldManID:value
			};
			return temp;
		};
		return oTableInit;
	};
	var oTable = new TableInit();
    oTable.Init();
}
/**
 * 数据字典中的老人亲属信息
 */
function getOldManRelation(){
	$.ajax({
		url:contextPath+"/relation/getRelation.do",
		type:"post",
		data:{
			name:"家属关系"
		},
		success:function(data){
			var num=data.total;
			var row=data.rows;
			$("#fRelation").empty();
			$("#fRelationUpd").empty();
			$("#fRelationAdd").empty();
			if(num==0){
				$("#fRelation").append("<option value='无'>请添加可选关系</option>");
				$("#fRelationUpd").append("<option value='无'>请添加可选关系</option>");
				$("#fRelationAdd").append("<option value='无'>请添加可选关系</option>");
			}
			for(var i=0;i<num;i++){
				$("#fRelation").append("<option value="+row[i].id+">"+row[i].value+"</option>");
				$("#fRelationUpd").append("<option value="+row[i].id+">"+row[i].value+"</option>");
				$("#fRelationAdd").append("<option value="+row[i].id+">"+row[i].value+"</option>");
			}
		}
	});
}


/**
 * 得到老人亲属列表
 */
function queryRelation(){
	var currentItem= $("#tb_oldManMain").bootstrapTable('getSelections');
	if(currentItem[0]){
		if(currentItem[0].foldManStatusName=='出院'||currentItem.foldManStatusName=='结算'){
			setAlert("error","状态不可选");
		}else {
			$("#fQueryId").val(currentItem[0].fID);
			$("#tb_relation").bootstrapTable('destroy');
			initTab1(currentItem[0].fID);
			$("#queryRelation_btn").click();
		}
	}else{
		setAlert("error","请选择一条数据");
	}
} 

function clearData(){
	$("#tb_relation").empty();  
}