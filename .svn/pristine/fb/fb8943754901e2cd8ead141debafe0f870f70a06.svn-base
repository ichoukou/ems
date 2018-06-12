var oTable=null;
$(function () {
	//1.初始化Table
	oTable = new TableInit();
	oTable.Init();
});

var TableInit = function () {
 var oTableInit = new Object();
 //初始化Table
 oTableInit.Init = function () {
  $('#tb_assessProject').bootstrapTable({
   url: 'query.do',   //请求后台的URL（*）
   method: 'post',      //请求方式（*）
   contentType:"application/x-www-form-urlencoded; charset=UTF-8",
   toolbar: '#toolbar',    //工具按钮用哪个容器
   striped: true,      //是否显示行间隔色
   cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
   pagination: true,     //是否显示分页（*）
   sortable: false,      //是否启用排序
   sortOrder: "asc",     //排序方式
   queryParams: oTableInit.queryParams,//传递参数（*）
   sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
   pageNumber:1,      //初始化加载第一页，默认第一页
   pageSize: 5,      //每页的记录行数（*）
   pageList: [10, 25, 50, 100],  //可供选择的每页的行数（*）
   search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
   strictSearch: true,
   showColumns: true,     //是否显示所有的列
   showRefresh: true,     //是否显示刷新按钮
   minimumCountColumns: 2,    //最少允许的列数
   clickToSelect: true,    //是否启用点击选中行
   // height: 350,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
   uniqueId: "ID",      //每一行的唯一标识，一般为主键列
   showToggle:true,     //是否显示详细视图和列表视图的切换按钮
   cardView: false,     //是否显示详细视图
   detailView: false,     //是否显示父子表
   columns: [{
       radio: true
   }, {
	   field: 'fEvaluationName',
	   title: '所属评估项目',
	   align: "center",
   }, {
       field: 'fEvaluationValue',
       title: '分值',
	   align: "center",
   }, {
       field: 'fLevelName',
       title: '评估等级',
	   align: "center",
   } , {
       field: 'fEvaluationDesc',
       title: '说明',
	   align: "center",
   } ]
  });
};

 //得到查询的参数
 oTableInit.queryParams = function (params) {
  var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
	   pageSize: params.limit, //页面大小
	   page: params.offset, //页码
	  fLevelName:$("#searchFLevelName").val(),
	  fEvaluationValue:$("#searchFEvaluationValue").val(),
  };
  return temp;
 };
 return oTableInit;
};

function queryClear(){
	$("#searchFLevelName").val("");
	$("#searchFEvaluationValue").val("");
}
//查询
function queryAssessProject(){
	$.ajax({
		url:contextPath+"/health/query.do",
		type:"post",
		data:{
			fLevelName:$("#searchFLevelName").val(),
			fEvaluationValue:$("#searchFEvaluationValue").val(),
			page:0,
			pageSize:5
		},
		success:function(data) {
			$('#tb_assessProject').bootstrapTable('load', data);
		}
	});
}

$(document).ready(function(){
	getDcList()
	// 新增 包括验证
	$('#assessProAddForm').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			fLevelName : {
				message : '请填写评估等级名',
				validators : {
					notEmpty : {
						message : '请填写评估等级名'
					},
					// threshold :  6 , //有6字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，6字符以上才开始）
					remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}
						url: contextPath+"/health/check.do",//验证地址
						message: '数据已存在，请重新输入',//提示消息
						delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
						type: 'POST',//请求方式
						//自定义提交数据，默认值提交当前input value
						data: function(validator) {
							return {
								// name:$('[name="addName"]').val(),
								fEvaluationID:$("#addFEvaluationName").val(),
								fLevelName:$("#fLevelName").val(),
								// fEvaluationValue:$("#fEvaluationValue").val(),
								// fEvaluationDesc:$("#fEvaluationDesc").val()
							};
						}
					},
				}
			}
		}
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		$("#addModal").modal('hide');
		$.ajax({
			url:contextPath+"/health/addpro.do",
			type:"post",
			data:{
				fEvaluationID:$("#addFEvaluationName").val(),
				fLevelName:$("#fLevelName").val(),
				fEvaluationValue:$("#fEvaluationValue").val(),
				fEvaluationDesc:$("#fEvaluationDesc").val()
			},
			success:function(data) {
				console.log(data.message);
				if(data.success){
					setAlert("success",data.msg);
				}else{
					setAlert("error",data.msg);
				}

				$('#tb_assessProject').bootstrapTable('refresh', {url: 'query.do'});
				// $('#tb_assessProject').bootstrapTable('load', data);
			}
		});
		closeModal();
	});

	//修改验证
	$('#assessProUpdForm').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			updFLevelName : {
				message : '请填写评估等级名',
				validators : {
					notEmpty : {
						message : '请填写评估等级名'
					},
					// threshold :  6 , //有6字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，6字符以上才开始）
					remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}
						url: contextPath+"/health/check.do",//验证地址
						message: '数据已存在，请重新输入',//提示消息
						delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
						type: 'POST',//请求方式
						//自定义提交数据，默认值提交当前input value
						data: function(validator) {
							return {
								fEvaluationID:$("#updFEvaluationName").val(),
								fLevelName:$("#updFLevelName").val(),
								// fEvaluationValue:$("#updFEvaluationValue").val(),
								// fEvaluationDesc:$("#updFEvaluationDesc").val()
							};
						}
					},
				}
			}
		}
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		$("#updateModal").modal('hide');
		$.ajax({
			url:contextPath+"/health/updatePro.do",
			type:"post",
			data:{
				fLevelID:$("#FLevelID").val(),
				fEvaluationID:$("#updFEvaluationName").val(),
				fLevelName:$("#updFLevelName").val(),
				fEvaluationValue:$("#updFEvaluationValue").val(),
				fEvaluationDesc:$("#updFEvaluationDesc").val()
			},
			success:function(data) {
				console.log(data.message);
				if(data.success){
					setAlert("success",data.msg);
				}else{
					setAlert("error",data.msg);
				}
				closeModal();
				$('#tb_assessProject').bootstrapTable('refresh', {url: 'query.do'});
				// $('#tb_assessProject').bootstrapTable('load', data);
			}
		});
		closeModal();
	});

});


//删除
function gotoDelete(){
	var carrentItem = $("#tb_assessProject").bootstrapTable('getSelections');
	if(carrentItem[0]){
		$.ajax({
			url:contextPath+"/health/deletePro.do",
			type:"post",
			data:{
				fLevelID:carrentItem[0].fLevelID
			},
			success:function(data) {
				if(data.success){
					setAlert("success",data.msg);
				}else{
					setAlert("error",data.msg);
				}
				$('#tb_assessProject').bootstrapTable('refresh', {url: 'query.do'});
				// $('#tb_assessProject').bootstrapTable('load', data);
			}
		});
	}else{
		setAlert("error","请先选择一条数据");
	}
}

function closeModal() {
    // $("#addFEvaluationName").val();
    $("#fLevelName").val("");
    // $("#fEvaluationValue").val();
    $("#fEvaluationDesc").val("");
    // $("#FLevelID").val();
    // $("#updFEvaluationName").val();
    $("#updFLevelName").val("");
    // $("#updFEvaluationValue").val();
    $("#updFEvaluationDesc").val("");
}

var len="";
var row="";
function getDcList(){
	$.ajax({
		url:contextPath+"/sys/get.do",
		type:"post",
		success:function(data) {
			var Sel="";
			len=data.total;
			row=data.rows;
			for(var i=0;i<len;i++){
				if((row[i].name=="项目")&&(row[i].status=="11")) {
					Sel += "<option value='" + row[i].id + "'>" + row[i].value + "</option>";
				}
			}
			$("#addFEvaluationName").html(Sel);
			var sSel="";
			for(var i=0;i<=20;i++){
				sSel+="<option value='"+i+"'>"+i+"</option>";
			}
			$("#fEvaluationValue").html(sSel);
		}
	});
}

//页面回显数据
function gotoUpdate(){
	var carrentItem = $("#tb_assessProject").bootstrapTable('getSelections');

	if(carrentItem[0]){
		var Sel="";
		for(var i=0;i<len;i++){
			if((row[i].name=="项目")&&(row[i].status=="11")){
				if (carrentItem[0].fEvaluationID == row[i].id) {
					Sel += "<option selected='selected' value='" + row[i].id + "'>" + row[i].value + "</option>";
				} else {
					Sel += "<option value='" + row[i].id + "'>" + row[i].value + "</option>";
				}
			}
		}
		$("#updFEvaluationName").html(Sel);

		// $("#updFEvaluationName").val(carrentItem[0].fEvaluationID);
		$("#updFLevelName").val(carrentItem[0].fLevelName);
		var sSel="";
		for(var i=0;i<=20;i++){
			if(carrentItem[0].fEvaluationValue==i){
				sSel+="<option selected='selected' value='"+i+"'>"+i+"</option>";
			}else{
				sSel+="<option value='"+i+"'>"+i+"</option>";
			}

		}
		$("#updFEvaluationValue").html(sSel);
		// $("#updFEvaluationValue").val(carrentItem[0].fEvaluationValue);
        $("#FLevelID").val(carrentItem[0].fLevelID);
		$("#updFEvaluationDesc").val(carrentItem[0].fEvaluationDesc);
		$("#update_btn").click();
	}else{
		setAlert("error","请先选择一条数据");
	}
}