/**
 * lizhu
 */
$(function () {
    // 1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    getEmpMessage();
    getNowTime();
	getBalanceDate();
});

var TableInit = function () {
    var oTableInit = new Object();
    // 初始化Table
    oTableInit.Init = function () {
        $('#tb_fundAccount').bootstrapTable({
            url: 'queryIgnoreStatus.do',   // 请求后台的URL（*）
            method: 'get',      // 请求方式（*）
            toolbar: '#toolbar',    // 工具按钮用哪个容器
            striped: true,      // 是否显示行间隔色
            cache: false,      // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     // 是否显示分页（*）
            sortable: false,      // 是否启用排序
            sortOrder: "asc",     // 排序方式
            queryParams: oTableInit.queryParams,// 传递参数（*）
            sidePagination: "server",   // 分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,      // 初始化加载第一页，默认第一页
            pageSize: 10,      // 每页的记录行数（*）
            pageList: [10, 25, 50, 100],  // 可供选择的每页的行数（*）
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
            columns: [{
                radio: true
            }, {
                field: 'fId',
                title: '编号',
                visible: false
            },  {
                field: 'fName',
                title: '账户名称'
            }, {
                field: 'fNumber',
                title: '账户号'
            }, {
                field: 'fAmount',
                title: '期初金额'
            }, {
				field: 'fRestAmount',
				title: '实时余额'
			}, {
                field: 'fStaffName',
                title: '负责人'
            },{
                field: 'fStatusName',
                title: '状态'
            },{
                field: 'fLink',
                title: '操作'
            }]
        });
    };
    // 得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, // 页面大小
            page: params.offset // 页码
            // name: $("#searchName").val(),
            // value: $("#searchValue").val()
        };
        return temp;
    };
    return oTableInit;
};

function getNowTime(){
	var newfDate = new Date();
	//$("#fDate").val(formatDateTime(newfDate));
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
	return y + '-' + m + '-' + d;
};

function getStatus(){
	$.ajax({
		url:contextPath+"/fundAcc/getStatus.do",
		type:"post",
		data:{
			dcName:"账户状态"
		},
	success:function(data){
		var row=data.rows;
		var count=data.total;
		for(var i=0;i<count;i++){
			$("#status").append("<option value='" + data.rows[i].id + "'>"
					+ data.rows[i].value + "</option>");
		}
	}
	});
}
/**
 * 按条件检索
 */
function queryBy(){
	var fName=$("#fName").val();
	var fHeader=$("#fHeader").val();
	var fStatus=$("#fstatus").val();
	$.ajax({
		url:contextPath+"/fundAcc/queryIgnoreStatus.do",
		type:"post",
		data:{
			fName:fName,
			fHeader:fHeader,
			fStatus:fStatus,
			pageSize:10, // 页面大小
	        page:0 // 页码
		},
		success:function(data){
			 $('#tb_fundAccount').bootstrapTable('load', data);
		}
	});
}
/**
 * 清空搜索框
 */
function clearQueryInput(){
	$("#fName").val("");
	$("#fHeader").val("");
	$("#fstatus").val("");
}
/**
 * 改变状态
 */
function changeStatus(fStatus,fId){
	$.ajax({
		url:contextPath + "/fundAcc/changeStatus.do",
		type:"post",
		data:{
			fId:fId,
			fStatus:fStatus
		},
		success:function(data){
			 var msg=data.msg;
			 if(msg=="success"){
				 setAlert("success","操作成功");
			 }else{
				 setAlert("error","操作失败");
			 }
			 $('#tb_fundAccount').bootstrapTable('refresh', {url: 'queryIgnoreStatus.do'});
		}
	});
}


$(document).ready(function() {
	// 新增 包括验证
	$('#form_validate').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			fname : {
				message : '请填写账户名称',
				validators : {
					notEmpty : {
						message : '请填写账户名称'
					},
					remote : {// ajax验证。server result:{"valid",true or false}
								// 向服务发送当前input
								// name值，获得一个json数据。例表示正确：{"valid",true}
						url : contextPath + "/fundAcc/check.do",// 验证地址
						message : '账户名已存在，请重新输入',// 提示消息
						delay : 2000,// 每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
						type : 'POST',// 请求方式
						// 自定义提交数据，默认值提交当前input value
						data : function(validator) {
							return {
								fName : $('[name="fname"]').val(),
							};
						}
					},
				}
			},
			fNumber : {
				validators : {
					notEmpty : {
						message : '请填写账户号'
					},
					regexp : {// 匹配规则
						regexp : /^[0-9]*$/,
						message : '格式不正确'
					},
					remote : {// ajax验证。server result:{"valid",true or false}
								// 向服务发送当前input
								// name值，获得一个json数据。例表示正确：{"valid",true}
						url : contextPath + "/fundAcc/check.do",// 验证地址
						message : '账户号已存在，请重新输入',// 提示消息
						delay : 2000,// 每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
						type : 'POST',// 请求方式
						// 自定义提交数据，默认值提交当前input value
						data : function(validator) {
							return {
								fNumber : $('[name="fNumber"]').val(),
							};
						}
					},
				}
			},
			fAmount : {
				validators : {
					notEmpty : {
						message : '请填写期初金额'
					},
					regexp : {// 匹配规则
						regexp : /^([1-9][0-9]*(\.[0-9]{1,4})?|0\.(?!0+$)[0-9]{1,4})$/,
						message : '格式不正确'
					},
				}
			},
		}
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		$("#addModal").modal('hide');
		$.ajax({
			url : contextPath + "/fundAcc/add.do",
			type : "post",
			data : {
				fName : $("#fname").val(),
				fNumber : $("#fNumber").val(),
				fHeader : $("#fKeeper").val(),
				fAmount : $("#fAmount").val()
			},
			success : function(data) {
				if (data.msg == "success") {
					setAlert(data.message, "添加成功");
				} else if (data.msg == "error") {
					setAlert(data.message, "添加失败");
				}
				$('#tb_fundAccount').bootstrapTable('refresh', {
					url : 'queryIgnoreStatus.do'
				});
				///重置表单
				$('#form_validate').bootstrapValidator('resetForm', true);
			}
		});
	});
	
	// 修改 包括验证
	$('#up_form_validate').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			up_fname : {
				message : '请填写账户名称',
				validators : {
					notEmpty : {
						message : '请填写账户名称'
					},
					remote : {// ajax验证。server result:{"valid",true or false}
								// 向服务发送当前input
								// name值，获得一个json数据。例表示正确：{"valid",true}
						url : contextPath + "/fundAcc/check.do",// 验证地址
						message : '账户名已存在，请重新输入',// 提示消息
						delay : 2000,// 每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
						type : 'POST',// 请求方式
						// 自定义提交数据，默认值提交当前input value
						data : function(validator) {
							return {
								fName : $('[name="up_fname"]').val(),
								fId:$('[name="up_fId"]').val(),
							};
						}
					},
				}
			},
			up_fNumber : {
				validators : {
					notEmpty : {
						message : '请填写账户号'
					},
					regexp : {// 匹配规则
						regexp : /^[0-9]*$/,
						message : '格式不正确'
					},
					remote : {// ajax验证。server result:{"valid",true or false}
								// 向服务发送当前input
								// name值，获得一个json数据。例表示正确：{"valid",true}
						url : contextPath + "/fundAcc/check.do",// 验证地址
						message : '账户号已存在，请重新输入',// 提示消息
						delay : 2000,// 每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
						type : 'POST',// 请求方式
						// 自定义提交数据，默认值提交当前input value
						data : function(validator) {
							return {
								fNumber : $('[name="up_fNumber"]').val(),
								fId:$('[name="up_fId"]').val(),
							};
						}
					},
				}
			},
			up_fAmount : {
				validators : {
					notEmpty : {
						message : '请填写期初金额'
					},
					regexp : {// 匹配规则
						regexp : /^([1-9][0-9]*(\.[0-9]{1,4})?|0\.(?!0+$)[0-9]{1,4})$/,
						message : '格式不正确'
					},
				}
			},
		}
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		$("#updateModal").modal('hide');
		$.ajax({
			url : contextPath + "/fundAcc/update.do",
			type : "post",
			data : {
				fName : $("#up_fname").val(),
				fNumber : $("#up_fNumber").val(),
				fHeader : $("#up_fKeeper").val(),
				fAmount : $("#up_fAmount").val(),
				fId:$("#up_fId").val()
			},
			success : function(data) {
				if (data.msg == "success") {
					setAlert(data.message, "账户更改成功");
				} else if (data.msg == "error") {
					setAlert(data.message, "账户更改失败");
				}
				$('#tb_fundAccount').bootstrapTable('refresh', {
					url : 'queryIgnoreStatus.do'
				});
			}
		});
	});
	
	//转账包括验证
	$('#ts_form_validate').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			outAmount : {
				validators : {
					notEmpty : {
						message : '请填写期初金额'
					},
					regexp : {// 匹配规则
						regexp :/^([1-9][0-9]*(\.[0-9]{1,4})?|0\.(?!0+$)[0-9]{1,4})$/,
						message : '格式不正确'
					},
					 callback: { 
                         message: '余额不足',  
                         callback: function(value) { 
                        	 var validator=$("#restAmount").val();
                        	 if(parseFloat(value)>parseFloat(validator)){
                        		 return false; 
                        	 }
                        	 return true;
                         }  
                     } 
				}
			},
		}
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		$("#transferModal").modal('hide');
		$.ajax({
			url : contextPath + "/fundAcc/transfer.do",
			type : "post",
			data : {
				outAccount:$("#fOutId").val(),
				inAccount:$("#inAccount").val(),
				outAmount:$("#outAmount").val(),
				fbizdate:$("#fDate").val(),
				ts_fKeeper:$("#ts_fKeeper").val(),
				fRemarks:$("#fRemarks").val()
			},
			success : function(data) {
				if (data.msg == "success") {
					setAlert(data.message, "转账成功");
				} else if (data.msg == "error") {
					setAlert(data.message, "转账失败");
				}
				$('#tb_fundAccount').bootstrapTable('refresh', {
					url : 'queryIgnoreStatus.do'
				});
			}
		});
	});

});
// 清除添加框
function clearInput(){
	$("#fname").val("");
	$("#fNumber").val("");
	$("#fAmount").val("");
}

/**
 * 得到员工表中信息  回显使用  此处为了避免重复代码 使用日常行为记录中的得到职工的信息
 */
function getEmpMessage(){
	$.ajax({
		url:contextPath+"/record/getEmp.do",
		type:"post",
		data:{
		},
		success:function(data){
			var empList=data.rows;
			var empLength=data.total;
			for(var i=0;i<empLength;i++){
				$("#fKeeper").append("<option value='"+ data.rows[i].fId+"'>"
						+data.rows[i].fStaffName)+"</option>";
				$("#up_fKeeper").append("<option value='"+ data.rows[i].fId+"'>"
						+data.rows[i].fStaffName)+"</option>";
				$("#ts_fKeeper").append("<option value='"+ data.rows[i].fId+"'>"
						+data.rows[i].fStaffName)+"</option>";
			}
		}
	});
}
/**
 * 得到除了转出账户之外的所有账户
 */
function getFundAccount(fNumber){
	$.ajax({
		url:contextPath+"/fundAcc/query.do",
		type:"post",
		data:{
			page:0,//使用query方法  必须传的参数
			pageSize:10,//使用query方法  必须传的参数
			fNumber:fNumber
		},
		success:function(data){
			$("#inAccount").html("");
				for(var i=0;i<data.total;i++){
					$("#inAccount").append("<option value='"+ data.rows[i].fId+"'>"
							+data.rows[i].fName)+"</option>";
			}
		}
	});
}
/**
 * 跳转至修改页面并回显所有内容   回显之前需要查询余额表中是否存在该账户的信息
 */
function getUpdateModal(){
	var currentItem=$("#tb_fundAccount").bootstrapTable('getSelections');
	if(currentItem[0]){
		document.getElementById("updateButton").setAttribute("data-target", "#updateModal");
		$.ajax({
			url:contextPath+"/fundAccountBill/query.do",
			type:"post",
			data:{
				page:0,//使用query方法  必须传的参数
				pageSize:10,//使用query方法  必须传的参数
				fFundaccount:currentItem[0].fId
			},
			success:function(data){
				var total=data.total;
				$("#up_fname").val(currentItem[0].fName);
				$("#up_fNumber").val(currentItem[0].fNumber);
				$("#up_fAmount").val(currentItem[0].fAmount);
				$("#up_fId").val(currentItem[0].fId);
				//遍历下拉框中的所有值 与选中记录中的值进行对比  相同就让该项选中
				$("#up_fKeeper option").each(function () {
		            var txt = $(this).text(); //获取单个text
		            if(currentItem[0].fHeader==txt){
		            	$(this).attr("selected",true);
		            }
		        });
				if(total>0){
					document.getElementById("up_fAmount").setAttribute("readonly", "readonly");
				}else{
						document.getElementById("up_fAmount").removeAttribute("readonly");
					}
			}
		});
	}else{
		 setAlert("error","请先选择一条数据");
	}
}
/**
 * 得到转账页面
 */
function getTransferModal(){
	var currentItem=$("#tb_fundAccount").bootstrapTable('getSelections');
	if(currentItem[0]){
		document.getElementById("transferButton").setAttribute("data-target", "#transferModal");
		//账户名称
		$("#outAccount").val(currentItem[0].fName);
		//可转金额
		$("#restAmount").val(currentItem[0].fRestAmount);
		$("#outAmount").val("0");
		
		$("#fOutId").val(currentItem[0].fId);
		//可转账户
		getFundAccount(currentItem[0].fNumber);
	}else{
		setAlert("error","请先选择一条数据");
	}
}

//查询表中日期最大的年月
function getBalanceDate(){
	$.ajax({
		url:contextPath+"/fundAccColse/getMaxDate.do",
		type:"post",
		data:{

		},
		success:function(data){
			var msg=data.msg;
			// msg.append('-01');
			msg=msg+'-01';
			$("#nowtime").val(msg);
		}
	});
}