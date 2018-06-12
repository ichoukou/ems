/**
 * lizhu
 */
$(function () {
	getEmpMessage();
	getFundAccount();
	getDcList();
	// setFInnumber();
	gePayments();
	getNowTime();
	//得到余额表中最大的年月
	getBalanceDate();
});

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
			fInAmount : {
				validators : {
					notEmpty : {
						message : '请填写收入金额'
					},
					regexp : {// 匹配规则
						regexp :/^([1-9][0-9]*(\.[0-9]{1,4})?|0\.(?!0+$)[0-9]{1,4})$/,
						message : '格式不正确'
					},
				}
			},
			fInPayments : {
				validators : {
					callback: {
						message: '请选择杂项',
						callback: function(value) {
							var validator=$("#fInPayments").val();
							if(validator=='error'){
								return false;
							}
							return true;
						}
					} ,
				}
			},
			fInPayment : {
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
			url : contextPath + "/fundAccountBill/fundAccountIn.do",
			type : "post",
			data : {
				//fnumber : $("#fInnumber").val(),
				fPayment:$("#fInPayment").val(),
				fbizdate : $("#fInDate").val(),
				fPayments : $("#fInPayments").val(),
				fBusinessitem : $("#fInBusinessitem").val(),
				fOperator : $("#fInOperator").val(),
				fAmount : $("#fInAmount").val(),
				fNumber : $("#fInnumber").val(),
				fType:'2',
				fStatus:'1',
				fFundaccount :$("#fInFundaccount").val(),
				fRemarks : $("#fInRemarks").val()
			},
			success : function(data) {
				if (data.msg == "success") {
					alert("账户收入添加成功");
				}
				else if (data.msg == "failed") {
					alert("账户收入添加失败");
				}
				///重置表单
				$('#form_validate').bootstrapValidator('resetForm', true);
				$('#fInRemarks').val("");
			}
		});
	});
});
//获得单号
/*function setFInnumber(){
 var v=new Date();
 $("#fInnumber").val(v.getTime());
 }*/

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
				$("#fInOperator").append("<option value='"+ data.rows[i].fId+"'>"
					+data.rows[i].fStaffName)+"</option>";
			}
		}
	});
}

function getNowTime(){
	var newfDate = new Date();
	//$("#fInDate").val(formatDateTime(newfDate));
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

/**
 * 得到转出账户
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
			for(var i=0;i<data.total;i++){
				$("#fInFundaccount").append("<option value='"+ data.rows[i].fId+"'>"
					+data.rows[i].fName)+"</option>";
			}
		}
	});
}

function getDcList() {
	$.ajax({
		url: contextPath + "/sys/get.do",
		type: "post",
		success: function (data) {
			var len = data.total;
			var row = data.rows;
			for (var i = 0; i < len; i++) {
				var fInBusinessitem = row[i].name;
				if (fInBusinessitem == "财务业务项目") {
					$("#fInBusinessitem").append("<option value='" + row[i].id + "'>" + row[i].value + "</option>");
				}
			}
		}
	});
}
//加载下拉框
function gePayments(){
	$.ajax({
		url:contextPath+"/fundAccountBill/getPayments.do",
		type:"post",
		data:{
			id:'',
			type:'0'
		},
		success:function(data) {
			$("#fInPayments").empty();
			$("#fInPayments").append("<option value='error'>请选择杂项</option>");
			$.each(data,function (key,Data) {
				if(Data.fRemarks=='0'){
					$("#fInPayments").append("<option value=" +Data.fid + ">" + Data.fname + "</option>")
				}else{
					$("#fInPayments").append("<option value=" +Data.fid + "  disabled='disabled'>" + Data.fname + "</option>")
				}
			})
		}
	});
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