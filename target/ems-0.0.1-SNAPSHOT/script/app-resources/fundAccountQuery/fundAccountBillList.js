/**
 * lizhu
 */
$(function () {
	// 1.初始化Table
	getPayments();
	getInPayments();
	getOutPayments();
	var oTable = new TableInit();
	oTable.Init();
	getDcList();
	getFundAccount();
	getEmpMessage();
});

var TableInit = function () {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function () {
		$('#tb_fundAccountBill').bootstrapTable({
			url: 'query.do',   // 请求后台的URL（*）
			method: 'post',      // 请求方式（*）
			contentType:"application/x-www-form-urlencoded; charset=UTF-8",
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
			showExport: true,                     //是否显示导出
			exportDataType: "selected",              //basic', 'all', 'selected'.
			columns: [{
				checkbox: true
			},{
				field: 'fbizdate',
				title: '记账日期'
			} ,{
				field: 'fNumber',
				title: '单据编号'
			},{
				field: 'fType',
				title: '类型',
				formatter:function(value,row,index){
					if(value=='0'){
						return '期初';
					}else if(value=='1'){
						return '转账';
					}else if(value=='2'){
						return '收入';
					}else if(value=='3'){
						return '支出';
					}
				}
			}, {
				field: 'fAmount',
				title: '金额'
			},{
				field: 'fName',
				title: '账户名称'
			},{
				field: 'fPayments',
				title: '收支杂项',
				formatter:function(value,row,index){
					var text='无';
					$("#fPayments").each(function(){
						$(this).children("option").each(function(){
							if(value==$(this).val()){
								text=$(this).text();
							}
						});
					});
					return text;
				}
			},{
				field: 'fPayment',
				title: '收支对象',
				formatter:function(value,row,index){
					if(value=='null'){
						return '无';
					}else{
						return value;
					}
				}
			}
				,{
					field: 'fBusinessitem',
					title: '业务项目',
					formatter:function(value,row,index){
						var text='无';
						$("#fBusinessitem").each(function(){
							$(this).children("option").each(function(){
								if(value==$(this).val()){
									text=$(this).text();
								}
							});
						});
						return text;
					}
				},{
					field: 'fAuditTime',
					title: '审核时间'
				},{
					field: 'fAuditorName',
					title: '审核人'
				},{
					field: 'fCreatorName',
					title: '经手人'
				},{
					field: 'fStatus',
					title: '操作',
					formatter:function(value,row,index){
						var fLink="";
						if(value=='1'){
							fLink= "<a href=\"javascript:void(0)\" onclick=\"changeStatus('"+row.fId+"')\">未审核</a>";
						}else{
							fLink= "<font color='red'>已审核</font>";
						}
						return fLink;
					}
				}],
			onLoadSuccess:function(data){
				console.log(data);
			}
		});
	};
	// 得到查询的参数
	oTableInit.queryParams = function (params) {
		var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			pageSize: params.limit, // 页面大小
			page: params.offset // 页码
		};
		return temp;
	};
	return oTableInit;
};

//删除
$(document).ready(function() {
	$('#del_form_validate').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			del_fUpRemarks : {
				validators : {
					notEmpty : {
						message : '请填写删除说明'
					},
				}
			},
		}
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		$.ajax({
			url : contextPath + "/fundAccountBill/delFundAccount.do",
			type : "post",
			data : {
				fId:$("#del_fId").val(),
				fRemark:$("#del_fUpRemarks").val()
			},
			success : function(data) {
				if (data.msg == "success") {
					alert("删除成功");
					$("#del_close_btn").click();
					$('#del_form_validate').bootstrapValidator('resetForm', true);
					$('#tb_fundAccountBill').bootstrapTable('refresh', {url: 'query.do'});
				}
				else if (data.msg == "failed") {
					alert("删除失败");
				}
			}
		});
	});


	$('#form_validate').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			up_fInAmount : {
				validators : {
					notEmpty : {
						message : '请填写收入金额'
					},
					regexp : {// 匹配规则
						regexp : /^([1-9][0-9]*(\.[0-9]{1,4})?|0\.(?!0+$)[0-9]{1,4})$/,
						message : '格式不正确'
					},
				}
			},
			up_fInPayments : {
				validators : {
					callback: {
						message: '请选择杂项',
						callback: function(value) {
							var validator=$("#up_fInPayments").val();
							if(validator=='error'){
								return false;
							}
							return true;
						}
					},
				}
			},
			up_fInFundaccount : {
				validators : {
					callback: {
						message: '无可用账户',
						callback: function(value) {
							var validator=$("#up_fInFundaccount").val();
							if(validator=='error'){
								return false;
							}
							return true;
						}
					},
				}
			},
			up_fInPayment : {
				validators : {
					notEmpty : {
						message : '请输入支付人'
					},
					stringLength: {
						min: 1,
						max: 40,
						message: '不能超过40个字符 '
					},
				}
			},
		}
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		$.ajax({
			url : contextPath + "/fundAccountBill/updFundAccount.do",
			type : "post",
			data : {
				fId:$("#up_fId").val(),
				fNumber : $("#up_fInnumber").val(),
				fPayment:$("#up_fInPayment").val(),
				fCreateTime : $("#up_fInDate").val(),
				fPayments : $("#up_fInPayments").val(),
				fBusinessitem : $("#up_fInBusinessitem").val(),
				fOperator : $("#up_fInOperator").val(),
				fAmount : $("#up_fInAmount").val(),
				fNumber : $("#up_fInnumber").val(),
				fFundaccount :$("#up_fInFundaccount").val(),
				fRemarks : $("#up_fInRemarks").val(),
				fRemark: $("#up_fUpRemarks").val()
			},
			success : function(data) {
				if (data.msg == "success") {
					alert("修改账户收入成功");
					$('#form_validate').bootstrapValidator('resetForm', true);
					$('#tb_fundAccountBill').bootstrapTable('refresh', {url: contextPath+"/fundAccountBill/query.do"});
				}
				else if (data.msg == "failed") {
					alert("修改账户收入失败");
					$('#tb_fundAccountBill').bootstrapTable('refresh', {url: contextPath+"/fundAccountBill/query.do"});
				}
			}
		});
	});
	//修改转出
	$('#upd_form_validate').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			up_fOutPayments : {
				validators : {
					callback: {
						message: '请选择杂项',
						callback: function(value) {
							var validator=$("#up_fOutPayments").val();
							if(validator=='error'){
								return false;
							}
							return true;
						}
					} ,
				}
			},
			up_fOutFundaccount : {
				validators : {
					callback: {
						message: '无可用账户',
						callback: function(value) {
							var validator=$("#up_fOutFundaccount").val();
							if(validator=='error'){
								return false;
							}
							return true;
						}
					},
				}
			},
			up_fOutAmount : {
				validators : {
					notEmpty : {
						message : '请填写转出金额'
					},
					regexp : {// 匹配规则
						regexp : /^([1-9][0-9]*(\.[0-9]{1,4})?|0\.(?!0+$)[0-9]{1,4})$/,
						message : '格式不正确'
					},
					callback: {
						message: '余额不足',
						callback: function(value) {
							//之前支出金额
							var before_amount=$("#before_amount").val();
							var validator=$("#restAmount").val();
							if($("#before_account").val()==$("#up_fOutFundaccount").val()){
								if(parseFloat(value)>(parseFloat(validator)+parseFloat(before_amount))){
									return false;
								}else{
									return true;
								}
							}else{
								if(parseFloat(value)>parseFloat(validator)){
									return false;
								}else{
									return true;
								}
							}
						}
					}
				}
			},
			up_fOutPayment : {
				validators : {
					notEmpty : {
						message : '请输入支付人'
					},
					stringLength: {
						min: 1,
						max: 40,
						message: '不能超过40个字符 '
					},
				}
			},
		}
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		$.ajax({
			url : contextPath + "/fundAccountBill/updFundAccount.do",
			type : "post",
			data : {
				fId:$("#up_OutfId").val(),
				fNumber : $("#up_fOutnumber").val(),
				fPayment:$("#up_fOutPayment").val(),
				fCreateTime : $("#up_fOutDate").val(),
				fPayments : $("#up_fOutPayments").val(),
				fBusinessitem : $("#up_fOutBusinessitem").val(),
				fOperator : $("#up_fOutOperator").val(),
				fAmount : -$("#up_fOutAmount").val(),
				fNumber : $("#up_fOutnumber").val(),
				fFundaccount :$("#up_fOutFundaccount").val(),
				fRemarks : $("#up_fOutRemarks").val(),
				fRemark: $("#up_fOutRemarks").val()
			},
			success : function(data) {
				if (data.msg == "success") {
					alert("修改账户支出成功");
					$('#upd_form_validate').bootstrapValidator('resetForm', true);
					$('#tb_fundAccountBill').bootstrapTable('refresh', {url: contextPath+"/fundAccountBill/query.do"});
				}
				else if (data.msg == "failed") {
					alert("修改账户支出失败");
					$('#tb_fundAccountBill').bootstrapTable('refresh', {url: contextPath+"/fundAccountBill/query.do"});
				}
			}
		});
	});
});


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
	var fType=$("#fType").val();
	var fPayments=$("#fPayments").val();
	var fStartDate=$("#startDate").val();
	var fEndDate=$("#endDate").val();
	var fBusinessitem=$("#fBusinessitem").val();
	var fPayment=$("#fPayment").val();
	var fFundaccount=$("#fFundaccount").val();
	var fOperator=$("#foperator").val();
	var fStatus=$("#fStatus").val();
	//var fCreateTime;
	/*if(startDate!=""&&endDate!=""){
	 fCreateTime=startDate+"@"+endDate;
	 }else if(startDate!=""){
	 fCreateTime=startDate;
	 }else{
	 fCreateTime=endDate;
	 }*/
	$.ajax({
		url:contextPath+"/fundAccountBill/query.do",
		type:"post",
		data:{
			fType:fType,
			fPayments:fPayments,
			fStartDate:fStartDate,
			fEndDate:fEndDate,
			fBusinessitem:fBusinessitem,
			fPayment:fPayment,
			fFundaccount:fFundaccount,
			fOperator:fOperator,
			fStatus:fStatus,
			pageSize:10, // 页面大小
			page:0 // 页码
		},
		success:function(data){
			$('#tb_fundAccountBill').bootstrapTable('load', data);
		}
	});
}
/**
 * 清空搜索框
 */
function clearQueryInput(){
	$("#fType").val("");
	$("#fPayments").val("");
	$("#startDate").val("");
	$("#endDate").val("");
	$("#fBusinessitem").val("");
	$("#fPayment").val("");
	$("#fFundaccount").val("");
	$("#foperator").val("");
	$("#fStatus").val("");
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
			$('#tb_fundAccount').bootstrapTable('refresh', {url: 'query.do'});
		}
	});
}

/**
 * 得到账户
 */
function getFundAccount(){
	$.ajax({
		url:contextPath+"/fundAcc/query.do",
		type:"post",
		data:{
			page:0,//使用query方法  必须传的参数
			pageSize:10,//使用query方法  必须传的参数
		},
		success:function(data){
			$("#fFundaccount").append("<option value=''></option>");
			if(data.total==0){
				$("#up_fInFundaccount").append("<option value='error'>请添加可用账户</option>");
				$("#up_fOutFundaccount").append("<option value='error'>请添加可用账户</option>");
				$("#del_fInFundaccount").append("<option value='error'>请添加可用账户</option>");
			}
			for(var i=0;i<data.total;i++){
				$("#fFundaccount").append("<option value='"+ data.rows[i].fId+"'>"
					+data.rows[i].fName)+"</option>";
				$("#up_fInFundaccount").append("<option value='"+ data.rows[i].fId+"'>"
					+data.rows[i].fName)+"</option>";
				$("#up_fOutFundaccount").append("<option value='"+ data.rows[i].fId+"'>"
					+data.rows[i].fName)+"</option>";
				$("#del_fInFundaccount").append("<option value='"+ data.rows[i].fId+"'>"
					+data.rows[i].fName)+"</option>";
			}
		}
	});
}

/**
 * 得到财务项目
 */
function getDcList() {
	$.ajax({
		url: contextPath + "/sys/get.do",
		type: "post",
		success: function (data) {
			var len = data.total;
			var row = data.rows;
			$("#fBusinessitem").append("<option value=''></option>");
			if(row==0){
				$("#up_fInBusinessitem").append("<option value='error'>请先填加财务业务项目</option>");
				$("#up_fOutBusinessitem").append("<option value='error'>请先填加财务业务项目</option>");
				$("#del_fInBusinessitem").append("<option value='error'>请先填加财务业务项目</option>");
			}
			for (var i = 0; i < len; i++) {
				var fBusinessitem = row[i].name;
				if (fBusinessitem == "财务业务项目") {
					$("#fBusinessitem").append("<option value='" + row[i].id+ "'>" + row[i].value + "</option>");
					$("#up_fInBusinessitem").append("<option value='" + row[i].id+ "'>" + row[i].value + "</option>");
					$("#up_fOutBusinessitem").append("<option value='" + row[i].id+ "'>" + row[i].value + "</option>");
					$("#del_fInBusinessitem").append("<option value='" + row[i].id+ "'>" + row[i].value + "</option>");
				}
			}
		}
	});
}

//加载下拉框
function getPayments(){
	$.ajax({
		url:contextPath+"/fundAccountBill/getPayments.do",
		type:"post",
		data:{
			id:'',
		},
		success:function(data) {
			$("#fPayments").empty();
			$("#fPayments").append("<option value=''></option>");
			//$("#up_fInPayments").empty();
		//	$("#up_fOutPayments").empty();
			$("#del_fInPayments").append("<option value='error'>请选择杂项</option>");
			$.each(data,function (key,Data) {
				$("#fPayments").append("<option value=" +Data.fid + ">" + Data.fname + "</option>");
				//$("#up_fInPayments").append("<option value=" +Data.fid + ">" + Data.fname + "</option>");
				//$("#up_fOutPayments").append("<option value=" +Data.fid + ">" + Data.fname + "</option>");
				$("#del_fInPayments").append("<option value=" +Data.fid + ">" + Data.fname + "</option>");
			})
		}
	});
}

//加载下拉框
function getOutPayments(){
	$.ajax({
		url:contextPath+"/fundAccountBill/getPayments.do",
		type:"post",
		data:{
			id:'',
			type:'1'
		},
		success:function(data) {
			$("#up_fOutPayments").empty();
			$("#up_fOutPayments").append("<option value='error'>请选择杂项</option>");
			$.each(data,function (key,Data) {
				if(Data.fRemarks=='0'){
					$("#up_fOutPayments").append("<option value=" +Data.fid + ">" + Data.fname + "</option>")
				}else{
					$("#up_fOutPayments").append("<option value=" +Data.fid + "  disabled='disabled'>" + Data.fname + "</option>")
				}
			})
		}
	});
}

//加载下拉框
function getInPayments(){
	$.ajax({
		url:contextPath+"/fundAccountBill/getPayments.do",
		type:"post",
		data:{
			id:'',
			type:'0'
		},
		success:function(data) {
			$("#up_fInPayments").empty();
			$("#up_fInPayments").append("<option value='error'>请选择杂项</option>");
			$.each(data,function (key,Data) {
				if(Data.fRemarks=='0'){
					$("#up_fInPayments").append("<option value=" +Data.fid + ">" + Data.fname + "</option>")
				}else{
					$("#up_fInPayments").append("<option value=" +Data.fid + "  disabled='disabled'>" + Data.fname + "</option>")
				}
			})
		}
	});
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
			if(empLength==0){
				$("#up_fInOperator").append("<option value='error'>请添加员工</option>");
				$("#up_fOutOperator").append("<option value='error'>请添加员工</option>");
				$("#del_fInOperator").append("<option value='error'>请添加员工</option>");
			}
			for(var i=0;i<empLength;i++){
				$("#up_fInOperator").append("<option value='"+ data.rows[i].fId+"'>"
					+data.rows[i].fStaffName)+"</option>";
				$("#up_fOutOperator").append("<option value='"+ data.rows[i].fId+"'>"
					+data.rows[i].fStaffName)+"</option>";
				$("#del_fInOperator").append("<option value='"+ data.rows[i].fId+"'>"
					+data.rows[i].fStaffName)+"</option>";
			}
		}
	});
}


/**
 * 改变状态
 */
function changeStatus(fId){
	$.ajax({
		url:contextPath + "/fundAccountBill/changeStatus.do",
		type:"post",
		data:{
			fId:fId,
		},
		success:function(data){
			var msg=data.msg;
			if(msg=="success"){
				setAlert("success","操作成功");
			}else{
				setAlert("error","操作失败");
			}
			$('#tb_fundAccountBill').bootstrapTable('refresh', {url: 'query.do'});
		}
	});
}

function getUpdateModal(){
	var currentItem=$("#tb_fundAccountBill").bootstrapTable('getSelections');
	if(currentItem.length>1){
		setAlert("error","只能修改一条记录");
	}else if(currentItem.length<1){
		setAlert("error","请选择一条记录");
	}else{
		if(currentItem[0].fStatus=='0'){
			setAlert("error","核实账户不支持该业务");
		}else{
			if(currentItem[0].fType=='1'){
				setAlert("error","转账类型不支持修改");
			}else if(currentItem[0].fType=='0'){
				setAlert("error","期初类型不支持修改");
			}else{
				$.ajax({
					url:contextPath+"/fundAccountBill/query.do",
					type:"post",
					data:{
						page:0,
						pageSize:1,
						fId:currentItem[0].fId
					},
					success:function(data){
						var row=data.rows;
						var total=data.total;
						if(total==1){
							if(row[0].fType=='2'){
								$("#up_fId").val(row[0].fId);
								$("#up_fInAmount").val(row[0].fAmount);
								$("#up_fInnumber").val(row[0].fNumber);
								$("#up_fInDate").val(row[0].fCreateTime);
								$("#up_fInPayments").val(row[0].fPayments);
								$("#up_fInFundaccount").val(row[0].fFundaccount);
								$("#up_fInBusinessitem").val(row[0].fBusinessitem);
								$("#up_fInOperator").val(row[0].fOperator);
								$("#up_fInPayment").val(row[0].fPayment);
								$("#up_fInProonum").val(row[0].fProofnumber);
								$("#up_fInRemarks").val(row[0].fRemarks);
								$("#updInBill_btn").click();
							}else{
								$("#up_OutfId").val(row[0].fId);
								$("#up_fOutAmount").val(parseFloat(-row[0].fAmount));
								$("#before_amount").val(parseFloat(-row[0].fAmount));
								$("#before_account").val(row[0].fFundaccount);
								$("#up_fOutnumber").val(row[0].fNumber);
								$("#up_fOutDate").val(row[0].fCreateTime);
								$("#up_fOutPayments").val(row[0].fPayments);
								$("#up_fOutFundaccount").val(row[0].fFundaccount);
								$("#up_fOutBusinessitem").val(row[0].fBusinessitem);
								$("#up_fOutOperator").val(row[0].fOperator);
								$("#up_fOutPayment").val(row[0].fPayment);
								$("#up_fOutProonum").val(row[0].fProofnumber);
								$("#up_fOutRemarks").val(row[0].fRemarks);
								getRestAccount();
								$("#updOutBill_btn").click();
							}
						}else{
							setAlert("error","不存在该条记录，请联系管理员");
						}
					}

				});
			}
		}
	}
}


function getDeleteModal(){
	var currentItem=$("#tb_fundAccountBill").bootstrapTable('getSelections');
	if(currentItem.length>1){
		setAlert("error","只能删除一条记录");
	}else if(currentItem.length<1){
		setAlert("error","请选择一条记录");
	}else{
		if(currentItem[0].fStatus=='0'){
			setAlert("error","核实账户不支持该业务");
		}else{
			if(currentItem[0].fType=='1'){
				setAlert("error","转账类型不支持删除");
			}else if(currentItem[0].fType=='0'){
				setAlert("error","期初类型不支持删除");
			}else{
				$.ajax({
					url:contextPath+"/fundAccountBill/query.do",
					type:"post",
					data:{
						page:0,
						pageSize:1,
						fId:currentItem[0].fId
					},
					success:function(data){
						var row=data.rows;
						var total=data.total;
						if(total==1){
							$("#del_fId").val(row[0].fId);
							$("#del_fInAmount").val(row[0].fAmount);
							$("#del_fInnumber").val(row[0].fNumber);
							$("#del_fInDate").val(row[0].fCreateTime);
							$("#del_fInPayments").val(row[0].fPayments);
							$("#del_fInFundaccount").val(row[0].fFundaccount);
							$("#del_fInBusinessitem").val(row[0].fBusinessitem);
							$("#del_fInOperator").val(row[0].fOperator);
							$("#del_fInPayment").val(row[0].fPayment);
							$("#del_fInProonum").val(row[0].fProofnumber);
							$("#del_fInRemarks").val(row[0].fRemarks);
							$("#deldBill_btn").click();
						}else{
							setAlert("error","不存在该条记录，请联系管理员");
						}
					}

				});
			}
		}
	}
}

function clearInput(){
	$("#up_fInAmount").val("");
	$("#up_fInnumber").val("");
	$("#up_fInPayment").val("");
	$("#up_fInProonum").val("");
	$("#up_fInRemarks").val("");
	$("#up_fUpRemarks").val("");

	$("#up_fOutAmount").val("");
	$("#up_fOutnumber").val("");
	$("#up_fOutPayment").val("");
	$("#up_fOutProonum").val("");
	$("#up_fOutRemarks").val("");
	$("#up_fUpRemarks").val("");
}

//得到账户余额
function getRestAccount(){
	var fId=$("#up_fOutFundaccount").val();
	$.ajax({
		url:contextPath+"/fundAcc/query.do",
		type:"post",
		data:{
			page:0,//使用query方法  必须传的参数
			pageSize:10,//使用query方法  必须传的参数
			fId:fId
		},
		success:function(data){
			var row=data.rows;
			var total=data.total;
			if(total>0){
				$("#restAmount").val(row[0].fRestAmount);
			}else{
				$("#restAmount").val('0');
			}
		}
	});
}

function onchangeFundAcc(){
	getRestAccount();
	$("#up_fOutAmount").val("");
}

