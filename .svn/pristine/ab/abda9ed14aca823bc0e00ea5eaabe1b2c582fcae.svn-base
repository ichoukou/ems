/**
 * lizhu
 */
$(function () {
    // 1.初始化Table
	 getPayments();
    var oTable = new TableInit();
    oTable.Init();
    getDcList();
    getFundAccount();
});

var TableInit = function () {
    var oTableInit = new Object();
    // 初始化Table
    oTableInit.Init = function () {
        $('#tb_fundAccountAnalyse').bootstrapTable({
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
                field: 'period',
                title: '月份'
            },{
                field: 'fInAmount',
                title: '收入金额'
            }, {
                field: 'fOutAmount',
                title: '支出金额'
            },{
                field: 'changeAmount',
                title: '支出差额'
            }]
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

/**
 * 按条件检索
 */
function queryBy(){
	var fPayments=$("#fPayments").val();
	var fStartDate=$("#startDate").val();
	var fEndDate=$("#endDate").val();
	var fBusinessitem=$("#fBusinessitem").val();
	var fPayment=$("#fPayment").val();
	var fFundaccount=$("#fFundaccount").val();
	var fOperator=$("#foperator").val();
	$.ajax({
		url:contextPath+"/analyse/query.do",
		type:"post",
		data:{
			fPayments:fPayments,
			fStartDate:fStartDate,
			fEndDate:fEndDate,
			fBusinessitem:fBusinessitem,
			fPayment:fPayment,
			fFundaccount:fFundaccount,
			fOperator:fOperator,
			pageSize:10, // 页面大小
	        page:0 // 页码
		},
		success:function(data){
			$('#tb_fundAccountAnalyse').bootstrapTable('load', data);
		}
	});
}
/**
 * 清空搜索框
 */
function clearQueryInput(){
	$("#fPayments").val("");
	$("#startDate").val("");
	$("#endDate").val("");
	$("#fBusinessitem").val("");
	$("#fPayment").val("");
	$("#fFundaccount").val("");
	$("#foperator").val("");
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
				for(var i=0;i<data.total;i++){
					$("#fFundaccount").append("<option value='"+ data.rows[i].fId+"'>"
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
            for (var i = 0; i < len; i++) {
                var fBusinessitem = row[i].name;
                if (fBusinessitem == "财务业务项目") {
                	$("#fBusinessitem").append("<option value='" + row[i].id+ "'>" + row[i].value + "</option>");
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
             $("#up_fInPayments").empty();
             $("#up_fOutPayments").empty();
             $("#del_fInPayments").append("<option value='error'>请选择杂项</option>");
            $.each(data,function (key,Data) {
                $("#fPayments").append("<option value=" +Data.fid + ">" + Data.fname + "</option>");
                $("#up_fInPayments").append("<option value=" +Data.fid + ">" + Data.fname + "</option>");
                $("#up_fOutPayments").append("<option value=" +Data.fid + ">" + Data.fname + "</option>");
                $("#del_fInPayments").append("<option value=" +Data.fid + ">" + Data.fname + "</option>");
            })
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
		if(currentItem[0].fStatus=='1'){
			setAlert("error","未核实账户不支持该业务");
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
		if(currentItem[0].fStatus=='1'){
			setAlert("error","未核实账户不支持该业务");
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

