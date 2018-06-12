$(function () {
	//1.初始化Table
	var oTable = new TableInit();
	oTable.Init();
});

var TableInit=function () {
	var oTableInit = new Object();
	//初始化Table
	oTableInit.Init = function () {
		$('#tb_dataDictionary').bootstrapTable({
			url: 'query.do',   //请求后台的URL（*）
			method: 'post',      //请求方式（*）
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
			toolbar: '#toolbar',    //工具按钮用哪个容器
			striped: true,      //是否显示行间隔色
			cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination: true,     //是否显示分页（*）
			// sortable: true,      //是否启用排序
			// sortName:"id",
			// sortOrder: "asc",     //排序方式
			queryParams: oTableInit.queryParams,//传递参数（*）
			sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			pageNumber:1,      //初始化加载第一页，默认第一页
			pageSize: 5,      //每页的记录行数（*）
			pageList: [5,10, 25, 50, 100],  //可供选择的每页的行数（*）
			search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch: false,
			searchOnEnterKey:false,
			showColumns: true,     //是否显示所有的列
			showRefresh: true,     //是否显示刷新按钮
			minimumCountColumns: 2,    //最少允许的列数
			clickToSelect: true,    //是否启用点击选中行
			height: 350,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId: "ID",      //每一行的唯一标识，一般为主键列
			showToggle:true,     //是否显示详细视图和列表视图的切换按钮
			cardView: false,     //是否显示详细视图
			detailView: false,     //是否显示父子表
			columns: [{
				radio: true
			}, {
				field: 'id',
				title: '编号',
				align: "center",
				valign: "middle"
			}, {
				sortable: true,
				field: 'name',
				title: '名称',
				align: "center",
				valign: "middle"
			}, {
				field: 'value',
				title: '数据',
				align: "center",
				valign: "middle"
			}, {
				field: 'status',
				title: '状态',
				align: "center",
				valign: "middle",
				formatter:function(value){
					if(value==11){
						return '<span style="color:#00ff00">开启</span>'
					}else if(value==10){
						return '<span style="color:#FF0000">禁用</span>'
					}
				}
			}
			// , {
			// 	field: 'statusStr',
			// 	title: '状态',
			// 	align: "center",
			// 	valign: "middle",
			// }
			]
		});
	};

	//得到查询的参数
	oTableInit.queryParams = function (params) {
		var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			pageSize: params.limit, //页面大小
			page: params.offset, //页码
			sortName: this.sortName,
			sortOrder:this.sortOrder,
			name: $("#searchName").val(),
			value: $("#searchValue").val()
		};
		return temp;
	};
	return oTableInit;
};
// 清空查询条件
function queryClear(){
	$("#searchName").val(""),
	$("#searchValue").val("")
}
//查询数据字典
function queryDictionary(){
	$.ajax({
		url:contextPath+"/sys/query.do",
		type:"post",
		data:{
			name:$("#searchName").val(),
			value:$("#searchValue").val(),
			page:0,
			pageSize:5
		},
		success:function(data) {
			$('#tb_dataDictionary').bootstrapTable('load', data);
		}
	});
}

$(document).ready(function(){
	// 新增 包括验证
	$('#dataDictionaryAddForm').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			addName : {
				message : '请填写数据字典名',
				validators : {
					notEmpty : {
						message : '请填写数据字典名'
					},
					// stringLength: {
					// 	min: 6,
					// 	max: 20,
					// 	message: '用户名必须在6到20位之内'
					// },
					/*regexp: {
					 regexp: '^[a-zA-Z0-9]*$',
					 message: '用户名格式有误,只允许输入数字或字母'
					 }*/
				}
			},
			addValue : {
				validators : {
					notEmpty : {
						message : '请填写数据字典值'
					},
					// threshold :  6 , //有6字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，6字符以上才开始）
					remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}
						url: contextPath+"/sys/check.do",//验证地址
						message: '数据已存在，请重新输入',//提示消息
						delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
						type: 'POST',//请求方式
						//自定义提交数据，默认值提交当前input value
						data: function(validator) {
							return {
								name:$('[name="addName"]').val(),
								value:$("#addValue").val(),
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
			url: contextPath + "/sys/addDc.do",
			type: "post",
			data: {
				name: $("#addName").val(),
				value: $("#addValue").val(),
				status:$("#addStatus").val()
			},
			success: function (data) {
				console.log(data.message);
				if(data.success){
					setAlert("success", data.msg);
				}else{
					setAlert("error", data.msg);
				}
				$('#tb_dataDictionary').bootstrapTable('refresh', {url: 'query.do'});
			}
		});

		closeModal();
	});

	//修改验证
	$('#dataDictionaryUpdForm').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			updateName : {
				message : '请填写数据字典名',
				validators : {
					notEmpty : {
						message : '请填写数据字典名'
					},
				}
			},
			updateValue : {
				validators : {
					notEmpty : {
						message : '请填写数据字典值'
					},
					// threshold :  6 , //有6字符以上才发送ajax请求，（input中输入一个字符，插件会向服务器发送一次，设置限制，6字符以上才开始）
					remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}
						url: contextPath+"/sys/check.do",//验证地址
						message: '数据已存在，请重新输入',//提示消息
						delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
						type: 'POST',//请求方式
						//自定义提交数据，默认值提交当前input value
						data: function(validator) {
							return {
								name:$('[name="updateName"]').val(),
								value:$("#updateValue").val(),
								status:$("#updateStatus").val()
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
			url:contextPath+"/sys/updateDc.do",
			type:"post",
			data:{
				id:$("#data_id").val(),
				name:$("#updateName").val(),
				value:$("#updateValue").val(),
				status:$("#updateStatus").val()
			},
			success:function(data) {
				console.log(data.message);
				if(data.success){
					setAlert("success", data.msg);
				}else{
					setAlert("error", data.msg);
				}
				$('#tb_dataDictionary').bootstrapTable('refresh', {url: 'query.do'});
			}
		});
		closeModal();
	});


});

//新增数据字典
// function addDictionary(){
// 	$.ajax({
// 		url: contextPath + "/sys/addDc.do",
// 		type: "post",
// 		data: {
// 			name: $("#addName").val(),
// 			value: $("#addValue").val()
// 		},
// 		success: function (data) {
// 			console.log(data.message);
// 			setAlert(data.message, "新增数据字典成功");
// 			$('#tb_dataDictionary').bootstrapTable('refresh', {url: 'query.do'});
// 		}
// 	});
//
// 	closeModal();
// }

// //修改数据字典
// function updateDictionary(){
// 	$.ajax({
// 		url:contextPath+"/sys/updateDc.do",
// 		type:"post",
// 		data:{
// 			id:$("#data_id").val(),
// 			name:$("#updateName").val(),
// 			value:$("#updateValue").val()
// 		},
// 		success:function(data) {
// 			console.log(data.message);
// 			setAlert(data.message,"操作成功");
// 			$('#tb_dataDictionary').bootstrapTable('refresh', {url: 'query.do'});
// 		}
// 	});
// 	closeModal();
// }

//字典 逻辑删除 状态修改
function gotoDelete(){
	var carrentItem = $("#tb_dataDictionary").bootstrapTable('getSelections');
	if(carrentItem[0]){
		$.ajax({
			url:contextPath+"/sys/updDcStatus.do",
			type:"post",
			data:{
				id:carrentItem[0].id,
				status:"10"
			},
			success:function(data) {
				if(data.success){
					setAlert("success", data.msg);
				}else{
					setAlert("error", data.msg);
				}
				$('#tb_dataDictionary').bootstrapTable('refresh', {url: 'query.do'});
			}
		});
	}else{
		setAlert("error","请先选择一条数据");
	}
}


function closeModal() {
	$("#addName").val("");
	$("#addValue").val("");
	$('#dataDictionaryAddForm').data('bootstrapValidator').resetForm(true);
	// $("#updateName").val("");
	// $("#updateValue").val("");
	// $('#dataDictionaryUpdForm').data('bootstrapValidator').resetForm(true);
}


//页面回显数据
function gotoUpdate(){
	var carrentItem = $("#tb_dataDictionary").bootstrapTable('getSelections');
	if(carrentItem[0]){
		$("#data_id").val(carrentItem[0].id);
		$("#updateName").val(carrentItem[0].name);
		$("#updateValue").val(carrentItem[0].value);
		var status="";
		if(carrentItem[0].status==11){
			status+="<option value='11'>开启</option>";
			status+="<option value='10'>禁用</option>";
			$("#updateStatus").html(status);
		}else if(carrentItem[0].status==10){
			status+="<option value='10'>禁用</option>";
			status+="<option value='11'>开启</option>";
			$("#updateStatus").html(status);
		}

		$("#update_btn").click();
	}else{
		setAlert("error","请先选择一条数据");
	}
}
