var chargeStandardGrid;
$(function () {
	//初始化护理级别下拉选项值
	getSearchServiceLevels();
	
	//初始化老人状态下拉选项值
	getOldmanStatus();
	
	//初始化数据展示列表
	initRpaymentTable();
});

function initRpaymentTable(){
	  $('#tb_rpayment').bootstrapTable({
		   url: 'queryList.do',   //请求后台的URL（*）
		   method: 'get',      //请求方式（*）
		   toolbar: '',    //工具按钮用哪个容器
		   striped: true,      //是否显示行间隔色
		   cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		   pagination: true,     //是否显示分页（*）
		   sortable: false,      //是否启用排序
		   sortOrder: "asc",     //排序方式
		   queryParams:  function (params) {
				  var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
						   pageSize: params.limit, // 页面大小
						   page: params.offset, //页码
						   foldmanName:$("#searchOldmanName").val(),
						   foldmanStatus:$("#searchOldmanStatus").val(),
						   roomName:$("#searchRoomName").val(),
						   nursingLevel : $("#searchNursingLevel").val(),
						   chargeStandardId : $("#searchChargeStandardId").val(),
						   startDate : $("#searchStartDate").val(),
						   endDate : $("#searchEndDate").val()
					  };
					  return temp;
					 },//传递参数（*）
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
		   height: 350,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		   uniqueId: "foldmanid",      //每一行的唯一标识，一般为主键列
		   showToggle:false,     //是否显示详细视图和列表视图的切换按钮
		   showRefresh : false,  //是否显示刷新按钮
		   showColumns : false,  //是否显示列表下拉按钮
		   cardView: false,     //是否显示详细视图
		   detailView: false,     //是否显示父子表
		   singleSelect : true,
				   columns : [ {
					title : '',
					field : '',
					align : 'center',
					valign : 'middle',
					checkbox : true,
				}, {
					title : '老人编号',
					field : 'foldmanid',
					align : 'center',
					valign : 'middle',
					sortable : true,

				},{
					title : '状态',
					field : 'foldmanStatus',
					align : 'center',
					valign : 'middle',
					sortable : true,

				}, {
					title : '类型',
					field : 'foldmanType',
					align : 'center',
					valign : 'middle',
					sortable : true
				}, {
					title : '姓名',
					field : 'foldmanName',
					align : 'center',
					valign : 'middle',
					sortable : true
				},{
					title : '性别',
					field : 'foldmanSex',
					align : 'center',
					valign : 'middle',
					sortable : true
				}, {
					title : '入住时间',
					field : 'fcheckinTime',
					align : 'center',
					valign : 'middle',
					sortable : true,
					formatter : function(value,row,index){
						var date = new Date(value);
						return formatDate(date);
					 }
				}, {
					title : '床位',
					field : 'foldmanRoom',
					align : 'center',
					valign : 'middle',
					sortable : true
				},{
					title : '操作',
					field : 'fid',
					align : 'center',
					valign : 'middle',
					sortable : true,
					formatter : actionFmt
				} ],
				onLoadSuccess : function (data){
		    		$(".fixed-table-header").removeClass("fixed-table-header");
		    	}
		  });
}

function actionFmt(value,row,index){
	var html="";
	html+="<a onclick=\"rpaymentShowPrint('"+row.foldmanid+"')\"><img alt='' src='../img/print.jpg' title='打印' border='0' style='width:16px;height:16px;'></a>";

	html+="<a onclick=\"paymentShow('"+row.foldmanid+"','"+row.fid+"')\"><img alt='' src='../img/fee.jpg' title='缴费' border='0' style='width:16px;height:16px;'></a>";
	
	return html;
}

function queryRpayment(){
	$('#tb_rpayment').bootstrapTable('refresh');
	
}

function resetSearch(){
	$("#formSearch")[0].reset();
}

//请求应缴费打印的页面
function rpaymentShowPrint(foldmanid){
	$.ajax({
        type: "POST",
        url: contextPath+"/payment/rpaymentListPrint.do",
        success: function(data){
        	open_rpaymentShowPrint_page(data,foldmanid);
    	 }
	});
	}	

	//打开应缴费打印頁面窗口
	function open_rpaymentShowPrint_page(html,foldmanid){
		$.confirm({
	        title: '',
	        content : html,
	        columnClass : 'col-md-offset-2 col-md-8',
	        icon : '',
	        confirmButton : '打印',
	        confirm : function(){
	        	var titleNew="应缴费单";
	        	document.title=titleNew;
	        	startToPrint("#paymentListPrintForm");
	            return true;
	        },
	        onOpen:function(){
	        	open_init_comp_print(foldmanid);
	        }
	    });
	}
	
	function startToPrint(divId){
	    var bdhtml=$(divId).html();
	    //var sprnstr="<!--startprint-->";  
	    //var eprnstr="<!--endprint-->"; 
	    var prnhtml=bdhtml;
	   
	    window.document.body.innerHTML=prnhtml;  
	    window.print();  
	    location.reload();
	}
	
//请求缴费的页面
function paymentShow(foldmanid,fid){
	$.ajax({
        type: "POST",
        url: contextPath+"/payment/paymentList.do",
        success: function(data){
       	 	open_paymentShow_page(data,foldmanid,fid);
    	 }
	});
}

//打開打开缴费頁面窗口
function open_paymentShow_page(html,foldmanid,fid){
	$.confirm({
        title: '<h2>老人缴费<h2>',
        content : html,
        columnClass : 'col-md-offset-2 col-md-8',
        icon : '',
        confirmButton : '确认缴费',
        confirm : function(){
        		var flag = savepayMent();
            	if(flag){
            		return true;
            	}else{
            		return false;
            	}
        },
        onOpen:function(){
        	open_init_comp(foldmanid,fid);
        }
    });
}
//保存缴费项目
function savepayMent(){
	var foldmanid=$("#foldmanid").val();
	var fpaymentdate=$("#fpaymentdate").val();
	var flag;
	var data=getAndCheckData();
	if(data){
		$.ajax({
			type : 'POST',
			url : contextPath+"/payment/savePayMent.do",
			async: false,
			data : data,
			success : function(rs) {
				if(rs.success){
					$.confirm({
				        title: '',
				        content : rs.msg,
				        confirmButton : '确认',
				        cancelButton : '',
				        icon : '',
				        columnClass : 'col-md-offset-4 col-md-4',
				        confirm : function(){
				        	var fid=rs.rows;
				        	console.info(rs.rows);
				        	//成功缴费后 打开打印缴费单页面
							paymentShowPrint(foldmanid,fpaymentdate,fid);
				            return true;
				        }
				    });
					
					//成功后重新刷新列表
					queryRpayment();
					flag =  true;
				}else{
					alertx(rs.msg);
					flag = false;
				}
			},
			error : function() {
				flag = false;
			}
		});
	}
	return flag;
}

function getAndCheckData(){
	var famount=$("#famount").val();
	var morePaymentAmount=$("#morePaymentAmount").html();
	var fpaymentdate=$("#fpaymentdate").val();
	var fremarks=$("#fremarks").val();
	var fcostitem=$("#fcostitem").val();
	var billtotalAmount=$("#billtotalAmount").html();
	var rpaymetTotal=$("#rpaymetTotal").html();
	
	var rows=$("#tb_payment").bootstrapTable("getData");
	if(rows.length<1){
		alertx("未有可缴费的项目!");
		return false;
	}
	
	if(!famount){
		alertx("请填写现金!");
		return false;
	}
	
	//当有挂账时，又有多缴费金额时，不能保存
	if(Number(billtotalAmount)>0){
		if(Number(morePaymentAmount)>0){
			alertx("有挂账费用时，无法多缴费，请检查!");
			return false;
		}
	}
	
	if(morePaymentAmount){
		if(Number(morePaymentAmount)>0){
			/*if(!fcostitem){
				alertx("请选择多缴费项目!");
				return false;
			}*/
		}else if(Number(morePaymentAmount)<0){
			alertx("现金不能小于应缴费金额!");
			return false;
		}
	}
	
	if(!fpaymentdate){
		alertx("请选择缴费日期!");
		return false;
	}
	
	var fyearmoun=$("#fperiod").val()+"-"+$("#fmoun").val();
	var fpaymentdateNow=formatDateYearMoun(new Date(fpaymentdate));
	if(fyearmoun !=fpaymentdateNow){
		alertx("当前费用期间与系统时间不在同一期间范围内,当前费用期间:"+fyearmoun);
		return false;
	}
	
	
	var fids=new Array();
	var paymantStatuss =document.getElementsByName("paymantStatus");
	for (var i = 0;  i< paymantStatuss.length; i++){
		var paymantStatus=paymantStatuss[i].value;
		var dataRowFid=$(paymantStatuss[i]).attr("dataRowFid");
		if(paymantStatus !=2){
			fids.push(dataRowFid);
		}
	}
	
	var rentryfids ="";
	for(var i=0;i<fids.length;i++){
		if(i==fids.length-1){
			rentryfids+=fids[i];
		}else{
			rentryfids+=fids[i]+",";
		}
	}
	
	var rpaymentfid=$("#rpaymentfid").val();
	
	var data={
		rpaymentfid	: rpaymentfid,
		foldmanid : $("#foldmanid").val(),
		rentryfids : rentryfids,	
		famount : famount,
		fcostitemid : fcostitem,
		morePaymentAmount : morePaymentAmount,
		rpaymetTotal : rpaymetTotal,
		fpaymentdate : fpaymentdate,
		fremarks : fremarks
	};
	
	return data;
}

//请求实缴费打印的页面
function paymentShowPrint(foldmanid,fpaymentdate,fid){
	$.ajax({
        type: "POST",
        url: contextPath+"/payment/paymentListPrint.do",
        success: function(data){
        	open_paymentShowPrint_page(data,foldmanid,fpaymentdate,fid);
    	 }
	});
	}	

	//打开实缴费打印頁面窗口
	function open_paymentShowPrint_page(html,foldmanid,fpaymentdate,fid){
		$.confirm({
	        title: '',
	        content : html,
	        columnClass : 'col-md-offset-2 col-md-8',
	        icon : '',
	        confirmButton : '打印',
	        confirm : function(){
	        	var titleNew="实缴费单";
	        	document.title=titleNew;
	        	startToPrint("#paymentHasListPrintForm");
	            return true;
	        },
	        onOpen:function(){
	        	open_init_comp_printHas(foldmanid,fpaymentdate,fid);
	        }
	    });
	}

function getSearchServiceLevels(){
	var flag;
	$.ajax({
		type : 'POST',
		url :  contextPath+"/nursingProject/getServiceLevels.do",
		data:{},
		async: false,
		success : function(rs) {
			var optionsHtml="";
			optionsHtml +="<option value=''>请选择</option>";
			for(var i=0;i<rs.length;i++){
				var detailInfo=rs[i];
				optionsHtml +="<option value='"+detailInfo.id+"'>"+detailInfo.value+"</option>"
			}
			
			$("#searchNursingLevel").append(optionsHtml);
			flag=true;
		},
		error : function() {
			flag = false;
		} 
	});
	return flag;
}

function getOldmanStatus(){
	var flag;
	$.ajax({
		type : 'POST',
		url :  contextPath+"/nursingProject/getDcValueByName.do",
		data:{name : "老人状态"},
		async: false,
		success : function(rs) {
			var optionsHtml="";
			optionsHtml +="<option value=''>请选择</option>";
			for(var i=0;i<rs.length;i++){
				var detailInfo=rs[i];
				optionsHtml +="<option value='"+detailInfo.id+"'>"+detailInfo.value+"</option>"
			}
			
			$("#searchOldmanStatus").append(optionsHtml);
			flag=true;
		},
		error : function() {
			flag = false;
		} 
	});
	return flag;
}

function getChargeStandard(){
	$.ajax({
        type: "POST",
        url: contextPath+"/Rpayment/getChargeStandard.do",
        success: function(data){
        	openChargeStandard(data);
    	 }
	});
}

function openChargeStandard(html){
	$.confirm({
        title: '<h2>选择费用类别<h2>',
        content : html,
        columnClass : 'col-md-12',
        icon : '',
        confirmButton : '确认',
        confirm : function(){
        	var datas=chargeStandardGrid.bootstrapTable("getSelections");
        	if(datas.length>0){
        		var data=datas[0];
        		$("#searchChargeStandardId").val(data.fID);
        		$("#searchChargeStandard").val(data.fChrgeName);
        		return true;
        	}else{
        		alert("请选择一条数据");
        		return false;
        	}
        },
        onOpen:function(){
        	
        }
    });
}

//时间格式转化函数(年月日)
function formatDateYearMoun(date) {
   var y = date.getFullYear();
   var m = date.getMonth() + 1;
   m = m < 10 ? ('0' + m) : m;
   var d = date.getDate();
   d = d < 10 ? ('0' + d) : d;
   var h = date.getHours();
   var minute = date.getMinutes();
   minute = minute < 10 ? ('0' + minute) : minute;
   return y + '-' + m;
};

//时间格式转化函数(年月日)
function formatDate(date) {
   var y = date.getFullYear();
   var m = date.getMonth() + 1;
   m = m < 10 ? ('0' + m) : m;
   var d = date.getDate();
   d = d < 10 ? ('0' + d) : d;
   var h = date.getHours();
   var minute = date.getMinutes();
   minute = minute < 10 ? ('0' + minute) : minute;
   return y + '-' + m + '-' + d;
};
