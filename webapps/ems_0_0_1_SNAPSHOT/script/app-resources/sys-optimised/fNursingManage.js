$(function() {
	getfChargeModeID();//加载函数直接就查询出收费模式
	// 1.初始化Table
	var oTable = new TableInit();
	oTable.Init();

});
//	fNursingName  fLeader  fLeaderPhone   fStatus


var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {

		 //初始化物品入库清单
		$('#tb_fNursing').bootstrapTable({
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
			pageList : [ 5, 10, 50, 100 ], // 可供选择的每页的行数（*）
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
				field : 'fID',
				title : '编号',
				align: 'center'
			}, {
				field : 'fNursingName',
				title : '养老院 ',
				align: 'center'

			}, {
				field : 'fLeader',
				title : '负责人'
			}, {
				field : 'fLeaderPhone',
				title : '负责人手机号'
			}, {
				field : 'fNursingAdd',
				title : '地址'
			}, {
				field : 'fRemarks',
				title : '说明'
			},{
				field : 'fDate',
				title : '截止日期'

			},{
				field : 'fStatus',
				title : '是否停用',
				formatter:function(value,row,index) {
					var r="<span style='color:red'>已禁用</span>";

				    var g="<span style='color:green'>已启用</span>"	;

					if(value=="1"){
						return g;
					}else{
						return r;
					}
						}


				},{
				field : 'fChargeModeName',
				title : '收费模式'

			}],
			onLoadSuccess: function(data){
			}


		});


	}
	// 得到查询的参数
	oTableInit.queryParams1 = function(params) {

		var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			pageSize : params.limit, // 页面大小
			page : params.offset, // 页码
			fNursingName:$("#fNursingName").val(),
			fLeader:$("#fLeader").val(),
			fStatus:$("#fStatus").val(),
			fLeaderPhone:$("#fLeaderPhone").val(),

		};
		return temp;
	};

	return oTableInit;
};

var fChargeMode="";
var fChargeModelength="";





function queryfNursing(){
	    fNursingName=$("#fNursingName").val(),
		fLeader=$("#fLeader").val(),
		fStatus=$("#fStatus option:selected").val(),
		fLeaderPhone=$("#fLeaderPhone").val(),
		$("#tb_fNursing").bootstrapTable('selectPage',1);

}
// 清除查询条件
function clearaSelect(){
	$("#fNursingName").val('');
	$("#fLeader").val('');
	$("#fStatus").val('');
	$("#fLeaderPhone").val('');
}
//用户删除
function gotoDelete(){
	var carrentItem = $("#tb_fNursing").bootstrapTable('getSelections');
	if(carrentItem[0]){
		if(carrentItem[0].fStatus=="0"){
			setAlert("error","该条记录已经是禁用状态");
		}else{
			$.ajax({
				url:contextPath+"/nursing/deleteFNursing.do",
				type:"post",
				data:{
					fID:carrentItem[0].fID
				},
				success:function(data) {
					$('#tb_fNursing').bootstrapTable('refresh', {url: 'query.do'});
					setAlert(data.msg,"禁用成功");

				}
			});
		}
	}else{
		setAlert("error","请先选择一条数据");
	}
}
//用户启用
function gotoStart(){
	var carrentItem = $("#tb_fNursing").bootstrapTable('getSelections');
	if(carrentItem[0]){
		if(carrentItem[0].fStatus=="1"){
			setAlert("error","该条记录已经是启用状态");
		}else{
			$.ajax({
				url:contextPath+"/nursing/startFNursing.do",
				type:"post",
				data:{
					fID:carrentItem[0].fID
				},
				success:function(data) {
					$('#tb_fNursing').bootstrapTable('refresh', {url: 'query.do'});
					setAlert(data.msg,"启用成功");

				}
			});
		}
	}else{
		setAlert("error","请先选择一条数据");
	}
}

function getfChargeModeID(){

	$.ajax({
		url : contextPath + "/nursing/showFNursing.do",
		type : "post",
		success : function(data) {
			fChargeMode=data.rows;
			fChargeModelength=data.total;

		}
	});
}



function showfChargeModeID(){
    //多选框 移除选中
	$(":checkbox").removeAttr("checked");

	var newfDate = new Date();
	$("#addfDate").val(formatDateTime(newfDate));

	$("#addfFreeDays").val('0');

	$("#addfStatus").val("1");
	//收费下拉框
	$("#addfChargeModeID").html("");
	var $add = $("#addfChargeModeID");
	$add.append("<option value='" + fChargeMode[0].DC_ID + "'>"+fChargeMode[0].DC_VALUE +"</option>");
	for ( var i = 1; i < fChargeModelength; i++) {
		$add.append("<option value='" + fChargeMode[i].DC_ID + "'>"
			+ fChargeMode[i].DC_VALUE + "</option>");
	}

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



$(document).ready(function() {


	//增加
	$('#form_validate').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			addfNursingName : {
                message : '请填写账户名称',
                validators : {
                    notEmpty : {
                        message : '请填写账户名称'
                    },
					remote : {// ajax验证。server result:{"valid",true or false}
						// 向服务发送当前input
						// name值，获得一个json数据。例表示正确：{"valid",true}
						url : contextPath + "/nursing/check.do",// 验证地址
						message : '养老院已存在，请重新输入',// 提示消息
						delay : 2000,// 每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
						type : 'POST',// 请求方式
						// 自定义提交数据，默认值提交当前input value
						data : function(validator) {
							return {
								fNursingName : $('[name="addfNursingName"]').val(),
							};
						}
					},
                    //
                }
            },
            addfFreeDays: {
                message : '请填写退房天数名称',
                validators : {
                    notEmpty : {
                        message : '请填写退房天数名称'
                    }
                }
            },
            addfLeader : {
                message : '请填写管理人名称',
                validators : {
                    notEmpty : {
                        message : '请填写管理人名称'
                    }
                }
            },
            addfLeaderPhone : {
                message: '请填写管理人手机号',
                validators: {
                    notEmpty: {
                        message: '请填写管理人手机号'
                    },
                    regexp : {// 匹配规则
                        regexp :  /^1[34578]\d{9}$/,
                        message : '格式不正确'
                    },
                }
            },
            addfNursingAdd : {
                message : '请填写养老院地址',
                    validators
            :
                {
                    notEmpty : {
                        message : '请填写养老院地址'
                    }
                }
            },

		}
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		$("#addModal").modal('hide');
		$.ajax({
			url : contextPath + "/nursing/addFNursingPo.do",
			type : "post",
			data : {

		  fNursingName:$("#addfNursingName").val(),
		  fLeader:$("#addfLeader").val(),
		  fLeaderPhone:$("#addfLeaderPhone").val(),
		  fDate:$("#addfDate").val(),
		  fNursingAdd:$("#addfNursingAdd").val(),
		  fStatus:$("#addfStatus option:selected").val(),
		  fFreeDays:$("#addfFreeDays").val(),
		  fChargeModeID:$("#addfChargeModeID option:selected").val(),
		  fFirstFee:$("input[type='checkbox'][name='addfFirstFee']").is(':checked')?'1':'0',
		  fLastFee:$("input[type='checkbox'][name='addfLastFee']").is(':checked')?'1':'0',
		  fBedFree:$("input[type='checkbox'][name='addfBedFree']").is(':checked')?'1':'0',
		  fServiceFree:$("input[type='checkbox'][name='addfServiceFree']").is(':checked')?'1':'0',
		  fMealFree:$("input[type='checkbox'][name='addfMealFree']").is(':checked')?'1':'0',
		  fRemarks:$("#addfRemarks").val()

			},
			success : function(data) {
				if (data.msg == "success") {
					setAlert(data.message, "养老院添加成功");
				} else if (data.msg == "error") {
					setAlert(data.message, "养老院添加失败");
				}
				$('#tb_fNursing').bootstrapTable('refresh', {
					url : 'query.do'
				});
				closeModal();

		}
		});
		$('#form_validate').bootstrapValidator('resetForm', true);

	});

	//更新  updateCheck
	$('#up_form_validate').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			updatefNursingName : {
				message : '请填写账户名称',
				validators : {
					notEmpty : {
						message : '请填写账户名称'
					},
					remote : {// ajax验证。server result:{"valid",true or false}
						// 向服务发送当前input
						// name值，获得一个json数据。例表示正确：{"valid",true}
						url : contextPath + "/nursing/updateCheck.do",// 验证地址
						message : '养老院已存在，请重新输入',// 提示消息
						delay : 2000,// 每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
						type : 'POST',// 请求方式
						// 自定义提交数据，默认值提交当前input value
						data : function(validator) {
							return {
								fNursingName : $('[name="updatefNursingName"]').val(),
								fID : $('[name="updatefID"]').val(),
							};
						}
					},
					//
				}
			},
			updatefFreeDays: {
				message : '请填写退房天数名称',
				validators : {
					notEmpty : {
						message : '请填写退房天数名称'
					}
				}
			},
			updatefLeader : {
				message : '请填写管理人名称',
				validators : {
					notEmpty : {
						message : '请填写管理人名称'
					}
				}
			},
			updatefLeaderPhone : {
				message: '请填写管理人手机号',
				validators: {
					notEmpty: {
						message: '请填写管理人手机号'
					},
					regexp : {// 匹配规则
						regexp :  /^1[34578]\d{9}$/,
						message : '格式不正确'
					},
				}
			},
			updatefNursingAdd : {
				message : '请填写养老院地址',
				validators
					:
				{
					notEmpty : {
						message : '请填写养老院地址'
					}
				}
			},

		}
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		$("#updateModal").modal('hide');
		$.ajax({
			url : contextPath + "/nursing/updateFNursingPo.do",
			type : "post",
			data : {
				fID:$("#updatefID").val(),
				fNursingName:$("#updatefNursingName").val(),
				fLeader:$("#updatefLeader").val(),
				fLeaderPhone:$("#updatefLeaderPhone").val(),
				fDate:$("#updatefDate").val(),
				fNursingAdd:$("#updatefNursingAdd").val(),
				fStatus:$("#updatefStatus option:selected").val(),
				fFreeDays:$("#updatefFreeDays").val(),
				fChargeModeID:$("#updatefChargeModeID option:selected").val(),
				fFirstFee:$("input[type='checkbox'][name='updatefFirstFee']").is(':checked')?'1':'0',
				fLastFee:$("input[type='checkbox'][name='updatefLastFee']").is(':checked')?'1':'0',
				fBedFree:$("input[type='checkbox'][name='updatefBedFree']").is(':checked')?'1':'0',
				fServiceFree:$("input[type='checkbox'][name='updatefServiceFree']").is(':checked')?'1':'0',
				fMealFree:$("input[type='checkbox'][name='updatefMealFree']").is(':checked')?'1':'0',
				fRemarks:$("#updatefRemarks").val()

			},
			success : function(data) {
				if (data.msg == "success") {
					setAlert(data.message, "养老院更新成功");
				} else if (data.msg == "error") {
					setAlert(data.message, "养老院更新失败");
				}
				$('#tb_fNursing').bootstrapTable('refresh', {
					url : 'query.do'
				});
				closeModal();

			}
		});
		///重置表单
		$('#up_form_validate').bootstrapValidator('resetForm', true);
	});


});



//更新入库单 回显数据
function gotoUpdate(){
	var carrentItem = $("#tb_fNursing").bootstrapTable('getSelections');

	if(carrentItem[0]){

		if( carrentItem[0].fStatus=="0"){
			setAlert("error", "该条记录无法修改");
		}else{
			$("#updatefID").val(carrentItem[0].fID);
			$("#updatefNursingName").val(carrentItem[0].fNursingName);
			$("#updatefLeader").val(carrentItem[0].fLeader);
			$("#updatefLeaderPhone").val(carrentItem[0].fLeaderPhone);
			$("#updatefDate").val(carrentItem[0].fDate);
			$("#updatefNursingAdd").val(carrentItem[0].fNursingAdd);
			$("#updatefFreeDays").val(carrentItem[0].fFreeDays);
			$("#updatefRemarks").val(carrentItem[0].fRemarks);
			$("#updatefStatus").val(carrentItem[0].fStatus)

			if(carrentItem[0].fFirstFee=='1'){
				$("input[type='checkbox'][name='updatefFirstFee']").prop("checked",true);
			}else{
				$("input[type='checkbox'][name='updatefFirstFee']").prop("checked",false);
			};
			if(carrentItem[0].fLastFee=='1'){
				$("input[type='checkbox'][name='updatefLastFee']").prop("checked",true);
			}else{
				$("input[type='checkbox'][name='updatefLastFee']").prop("checked",false);
			};
			if(carrentItem[0].fBedFree=='1'){
				$("input[type='checkbox'][name='updatefBedFree']").prop("checked",true);
			}else{
				$("input[type='checkbox'][name='updatefBedFree']").prop("checked",false);
			};
			if(carrentItem[0].fServiceFree=='1'){
				$("input[type='checkbox'][name='updatefServiceFree']").prop("checked",true);
			}else{
				$("input[type='checkbox'][name='updatefServiceFree']").prop("checked",false);
			};
			if(carrentItem[0].fMealFree=='1'){
				$("input[type='checkbox'][name='updatefMealFree']").prop("checked",true);
			}else{
				$("input[type='checkbox'][name='updatefMealFree']").prop("checked",false);
			};



			$("#updatefChargeModeID").html("");
			var $add = $("#updatefChargeModeID");
			for ( var i = 0; i < fChargeModelength; i++) {

				if(fChargeMode[i].fChargeModeID ==carrentItem[0].fChargeModeID){
					$add.append("<option  selected='selected'   value='"
						+ fChargeMode[i].DC_ID + "'>"
						+ fChargeMode[i].DC_VALUE + "</option>");
				}else{
					$add.append("<option   value='"
						+ fChargeMode[i].DC_ID  + "'>"
						+ fChargeMode[i].DC_VALUE  + "</option>");
				}

			}
			;
			$("#update_btn").click();


		}
	}else{
		setAlert("error","请先选择一条数据");
	}





}



function closeModal(){
	$(":checkbox").removeAttr("checked");//全部清除
	clearaSelect();
	$("#addfNursingName").val("");
	$("#addfLeader").val("");
	$("#addfLeaderPhone").val("");
	$("#addfNursingAdd").val("");
	$("#addfFreeDays").val("0");
	$("#addfChargeModeID").val("");//如果不行 val("184")
    $("#addfRemarks").val("");
	$("#updatefRemarks").val("");
};



