$(function () {
	//初始化护理类型下拉框值
	getSearchServiceGroups();
	//初始化护理级别下拉选项值，公共服务没有护理级别
	//getSearchServiceLevels();

	//1.初始化Table
	 var oTable = new TableInit();
	 oTable.Init();
});

var TableInit = function () {
	 var oTableInit = new Object();
	 //初始化Table
	 oTableInit.Init = function () {
	  $('#tb_nursingPlanPublic').bootstrapTable({
	   url: 'queryList.do',   //请求后台的URL（*）
	   method: 'get',      //请求方式（*）
	   toolbar: '',    //工具按钮用哪个容器
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
	   height: 350,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
	   uniqueId: "fId",      //每一行的唯一标识，一般为主键列
	   showToggle:false,     //是否显示详细视图和列表视图的切换按钮
	   showRefresh : false,  //是否显示刷新按钮
	   showColumns : false,  //是否显示列表下拉按钮
	   cardView: false,     //是否显示详细视图
	   detailView: false,     //是否显示父子表
	   singleSelect : false,
	   uniqueId : "fServiceGroupID",
	   columns: [
		       		{
				       	 title: '护理类型ID',
				         field: 'fServiceGroupID',
				         align: 'center',
				         valign: 'middle',
				         sortable: true,
				         visible: false
		       		},{
				       	 title: '项目类型',
				         field: 'fserviceType',
				         align: 'center',
				         valign: 'middle',
				         sortable: true,
				         formatter : function(value,row,index){
							 if(value==1){
								 return "老人服务";
							 }
							 if(value==2){
								 return "公共服务";
							 }
						 }
		       		},{
				       	 title: '护理类型',
				         field: 'serviceGroupName',
				         align: 'center',
				         valign: 'middle',
				         sortable: true
		       		},{
				         field: 'id',
				         checkbox: true,
				         align: 'center',
				         valign: 'middle',
				         formatter : function(value,row,index){
				        	 if(row.fUsedStatus){
									if(row.fUsedStatus==1){
										return true;
									}else{
										return false
										}
				        	 }else{
									return false
							}
				         }
			       	},{
				       	 title: '护理项目id',
				         field: 'fid',
				         align: 'center',
				         valign: 'middle',
				         sortable: true,
				         visible: false
		       		},{
						 title: '护理项目',
						 field: 'fName',
						 align: 'center',
						 valign: 'middle',
						 sortable: true
			         },{
					     title: '执行类型',
					     field: 'fExecuteType',
					     align: 'center',
					     valign: 'middle',
					     sortable: true,
					     formatter : function(value,row,index){
							 if(value==1){
								 return "定时执行";
							 }
							 if(value==2){
								 return "随机执行";
							 }
						 }
			    	 },/*{
						 title: '状态',
						 field: 'fstatus',
						 align: 'center',
						 valign: 'middle',
						 sortable: true,
						 formatter : function(value,row,index){
							 if(value==1){
								 return "启用";
							 }
							 if(value==2){
								 return "<span style='color:red'>禁用</span>";
							 }
						 }
			         },*/{
						 title: '执行频率',
						 field: 'fName',
						 align: 'center',
						 valign: 'middle',
						 sortable: true,
						 formatter : function(value,row,index){
							 if(row.fExecuteType==1){
								 var html="";
								 var fExecutecycleUnit="天";
								 var fExecutecycle=row.fExecutecycle;
								 var fExecuteQty=row.fExecuteQty;
								 var fExecutetime=row.fExecutetime;
								 if(row.fExecutecycle%7==0){
										fExecutecycle=row.fExecutecycle/7;
										fExecutecycleUnit="周";
									}
									if(row.fExecutecycle%30==0){
										fExecutecycle=row.fExecutecycle/30;
										fExecutecycleUnit="月";
									}
									
									if(row.fExecutecycle%365==0){
										fExecutecycle=row.fExecutecycle/365;
										fExecutecycleUnit="年";
									}
								html+="每"+	fExecutecycle +fExecutecycleUnit+"执行"+fExecuteQty+"次/["+fExecutetime+"]";
								return html;
							}
						 }
					 },{
				       	 title: '执行时长',
				         field: 'fExcludtime',
				         align: 'center',
				         valign: 'middle',
				         sortable: true
					 },{
				       	 title: '备注',
				         field: 'fRemarks',
				         align: 'center',
				         valign: 'middle',
				         sortable: false
					 }
	    		  ],
	    		  onLoadSuccess : function(data){
	    			  $(".fixed-table-header").removeClass("fixed-table-header");
	    			  //数据加载完之后重新合并页面数据
	    				reloadDataMergeCells();
	    		  }
	  });
	 };
	 
	 //得到查询的参数
	 oTableInit.queryParams = function (params) {
	  var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
		   pageSize: params.limit, //页面大小
		   page: params.offset, //页码
		   fServiceGroupID: $("#searchServiceGroup").val(),
		   froomid : $("#searchPublicFid").val(),
		   fserviceType: "2"  //1-老人服务 2-公共服务
	  };
	  return temp;
	 };
	 return oTableInit;
	};
	
function queryNursingPlanPublic(){
	$('#tb_nursingPlanPublic').bootstrapTable('refresh');
}	

//请求选择老人界面
function chooseRoom(){
	$.ajax({
        type: "POST",
        url: contextPath+"/nursingPlanPublic/chooseRoom.do",
        success: function(data){
       	 	open_choosePublic_page(data);
    	 }
	});
}

//打開选择老人頁面窗口
function open_choosePublic_page(html){
	var title="选择房间";
	$.confirm({
        title: '<h2>'+title+'<h2>',
        content : html,
        columnClass : 'col-md-12',
        icon : '',
        confirmButton : '确认',
        confirm : function(){
        	
        },
        onOpen:function(){
        	add_init_comp();
        }
    });
}

function getSearchServiceGroups(){
	var flag;
	$.ajax({
		type : 'POST',
		url : contextPath+"/nursingProject/getServiceGroups.do",
		data:{fServiceType : 2},
		async: false,
		success : function(rs) {
			var optionsHtml="";
			optionsHtml +="<option value=''>请选择</option>";
			for(var i=0;i<rs.length;i++){
				var detailInfo=rs[i];
				optionsHtml +="<option value='"+detailInfo.fid+"'>"+detailInfo.fName+"</option>"
			}
			
			$("#searchServiceGroup").append(optionsHtml);
			
			flag=true;
		},
		error : function() {
			flag = false;
		} 
	});
	return flag;
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

function reloadDataMergeCells(){
	var flag = true;  // 定义开关

	//执行完过后调用该方法
	$("#tb_nursingPlanPublic").on("load-success.bs.table", function(){
		if(flag){
			var datas = $("#tb_nursingPlanPublic").bootstrapTable('getData');
			var merges = [];
			var position = 0; // 插入行坐标
			
			for(var i = 0; i < datas.length; i++){
				var finishCount = 0;
				var totalOrderCount = datas.length - 1;

				var fServiceGroupID = datas[i].fServiceGroupID;
				var fserviceLevels=$("#searchNursingLevel").val();
				var froomid = $("#searchPublicFid").val();
				
				$.ajax({
					type : 'POST',
					url :contextPath+"/nursingPlanPublic/queryDetailList.do",
					data :{fServiceGroupID : fServiceGroupID,
						   fserviceLevels : fserviceLevels,
						   froomid : froomid
						},
					success : function(details) {
						if(details.success){
							$("#tb_nursingPlanPublic").bootstrapTable('removeByUniqueId', details.rows[0].fServiceGroupID);  //删除本行
							var merge = {};
							merge["index"] = position;
							merge["rowspan"] = details.rows.length;
							merges.push(merge);
							
							for(var j=0;j<details.rows.length;j++){
								var row = details.rows[j];
								$("#tb_nursingPlanPublic").bootstrapTable('insertRow', {
									index: position++,
									row: row
								});
							}
						}else{
							alertx(details.msg);
						}
					},
					complete : function(){
						if(finishCount == totalOrderCount){
							for(var k=0; k < merges.length; k++) {
								var m = merges[k];
								$("#tb_nursingPlanPublic").bootstrapTable('mergeCells', {
									index: m.index,
									field: 'fServiceGroupID',
									colspan: 0,
									rowspan: m.rowspan
								});
								$("#tb_nursingPlanPublic").bootstrapTable('mergeCells', {
									index: m.index,
									field: 'fserviceType',
									colspan: 0,
									rowspan: m.rowspan
								});
								$("#tb_nursingPlanPublic").bootstrapTable('mergeCells', {
									index: m.index,
									field: 'serviceGroupName',
									colspan: 0,
									rowspan: m.rowspan
								});
							}
							var html = $(".pagination-info").html();
							$(".pagination-info").html(html);
						}
						finishCount++;
					}
				});
			}
			flag = false;
		}
	});

}

//情况查询表单
function resetSearch(){
	$("#formSearch")[0].reset();
}

//保存老人护理项目
function savePublicNursingPlan(){
	var froomid=$("#searchPublicFid").val();
		if(froomid){
		var rows=$("#tb_nursingPlanPublic").bootstrapTable("getSelections");
		if(rows.length <1){
			alertx("请选择一条数据!");
		}else{
			var fids="";
			for(var i=0;i<rows.length;i++){
				if(i==rows.length-1){
					fids+=rows[i].fid;
				}else{
					fids+=rows[i].fid+",";
				}
			}
			
			$.ajax({
				type : 'POST',
				url : contextPath+"/nursingPlanPublic/savePublicServiceItem.do",
				async: false,
				data : {fids : fids,froomid : froomid},
				success : function(rs) {
					if(rs.success){
						alertx(rs.msg);
						//保存完了之后重新刷新表数据
						queryNursingPlanPublic();
					}else{
						alertx(rs.msg);
					}
				},
				error : function() {
				}
			});
		}
	}else{
		alertx("请先选择房间!");
	}
}

