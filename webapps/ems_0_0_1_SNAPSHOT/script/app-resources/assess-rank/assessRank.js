$(function () {
	 //1.初始化Table
	 var oTable = new TableInit();
	 oTable.Init();
});

var list1;
/**
 * 获得定级项目
 */
$(document).ready(function(){
	$.ajax({
		url:contextPath+"/assess/showDname.do",
		type:"post",
		dataType:'json',
		success:function(data) {
			for (var i = 0; i < data.total; i++) {
					list1 = data;
			}
		}
	});
})
var TableInit = function () {
 var oTableInit = new Object();
 //初始化Table
 oTableInit.Init = function () {
  $('#tb_assessRank').bootstrapTable({
   url: 'query.do',   //请求后台的URL（*）
   method: 'get',      //请求方式（*）
   toolbar: '#toolbar',    //工具按钮用哪个容器
   striped: true,      //是否显示行间隔色
   cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
   pagination: true,     //是否显示分页（*）
   sortable: false,      //是否启用排序
   sortOrder: "asc",     //排序方式
   queryParams: oTableInit.queryParams,//传递参数（*）
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
   height: 600,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
   uniqueId: "ID",      //每一行的唯一标识，一般为主键列
   showToggle:true,     //是否显示详细视图和列表视图的切换按钮
   cardView: false,     //是否显示详细视图
   detailView: false,     //是否显示父子表
   columns: [{
    radio: true
   }, {
	   field: 'resultId',
	   title: '评估定级结果'
   },{
	   field:'resultSum',
	   title:'评估合计分值'
   }]
  });
 };
 //得到查询的参数
 oTableInit.queryParams = function (params) {
  var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
	   pageSize: params.limit, //页面大小
	   page: params.offset + 1, //页码
	   name: $("#searchName").val()
  };
  return temp;
 };
 return oTableInit;
};


//保存按钮
function updateRank(){
	var resultSum = parseInt($("#inp-inp").val());
	$.ajax({
		url:contextPath+"/assess/addAssRank.do",
		type:"post",
		data:{
			resultSum : resultSum
		},
		success:function(data) {
			$('#tb_assessRank').bootstrapTable('load', data);
			setAlert(data.message,"操作成功");
		}
	});
	closeModal();
}
/**
 * 计算总分
 */
function changeNum(){
	for(var i=0;i<list1.total;i++){
		(function(i){
			$("#sel"+i+"").change(function() {
				$("#inp"+i+"").val($("#sel"+i+" option:selected").val());
				var num=0;
				for(var j=0;j<list1.total;j++) {
					(function(j){
						num=num+parseInt($("#inp"+j+"").val());
						console.log(num);
						$("#inp-inp").val(num);
					})(j);
				}
				$.ajax({
					url:contextPath+"/assess/showSum.do",
					type:"post",
					dataType:'json',
					data:{
						SUM : num
					},
					success:function(data) {
						$("#inp_ID").val(data.rows[0].FScoreID);
						$("#inp").val(data.rows[0].DC_VALUE);
					}
				});
			})
		})(i);
	}
}
/**
 * 新增
 */
function showName(){
	$.ajax({
		url:contextPath+"/assess/showName.do",
		type:"post",
		dataType:'json',
		success:function(data) {
			$("#table").html("");
			var $tab1 = $("#table").append("<tr>"+
			"<th style='width: 140px;text-align:center;vertical-align:middle;'>定级项目</th>"+
			"<th style='width: 140px;text-align:center;vertical-align:middle;'>程度等级</th>"+
			"<th style='width: 140px;text-align:center;vertical-align:middle;'>分值</th>"+
			"</tr>");
				for (var i = 0; i < list1.total; i++) {
						$tab1.append("<tr id=" + "tr" + i + "></tr>");
				}
				for (var i = 0; i < list1.total; i++) {
					$("#tr" + i + "").html("<td style='width: 140px;text-align:center;vertical-align:middle;font-size:22px;'>" + list1.rows[i].DC_VALUE + "</td><td style='width: 140px;text-align:center;vertical-align:middle;font-size:18px;'><select  id='" + "sel" + i + "' name='FLevelName' ></select></td><td style='width: 140px;text-align:center;vertical-align:middle;'>" + "<input style='border-style:none;width: 30px; font-size:22px;' readonly='readonly'  id='" + "inp" + i + "'>" + "</td>");
					$("#sel" + i + "").append("<option value='' style='display: none'>请选择一个等级</option>");
					for (var j = 0; j < data.total; j++) {
						if(data.rows[j].dcName==list1.rows[i].DC_VALUE) {
							$("#sel" + i + "").append("<option class='selectNum' style=' text-align:center' value='" + data.rows[j].evaluationValue + "'>" + data.rows[j].levelName + "</option>");
						}
					}
				}
			$tab1.append("<tr>" +
				"<td style=' text-align:center; font-size: 22px;'>结果</td>" +
				"<td style='display:none; '><input id='inp_ID'></td>" +
				"<td style=' text-align:center'><input style=' border-style:none; text-align:center;width: 50px; font-size:18px;' readonly='readonly' id='inp' type='text'></td>" +
				"<td style=' text-align:center'><input style=' border-style:none;width: 30px; font-size:22px;' readonly='readonly' id='inp-inp' type='text'></td>" +
				"</tr>");
			for(var i=0;i<list1.total;i++){
				$("#inp"+i+"").val(0);
			}
			$("#inp-inp").val(0);
			$(".selectNum").click(changeNum());
 		}
	});
	closeModal();
}

function closeModal() {
	$("#addName").val("");
	$("#addValue").val("");
	$("#updateName").val("");
	$("#updateValue").val("");
}
