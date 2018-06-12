$(function () {
	//1.初始化Table
	 //var oTable = new TableInit();
	 //oTable.Init();
	initPublicPlanPublicTb();
	initPublicPlanExecuteTb()
});
	
function queryNursingPlanPublic(){
	$('#tb_publicPlanExecute').bootstrapTable('refresh');
}	

function initPublicPlanPublicTb(){
	  $('#tb_publicPlanPublic').bootstrapTable({
		   url: contextPath+'/publicPlanExecute/queryRoomList.do',   //请求后台的URL（*）
		   method: 'get',      //请求方式（*）
		   toolbar: '',    //工具按钮用哪个容器
		   striped: true,      //是否显示行间隔色
		   cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		   pagination: true,     //是否显示分页（*）
		   sortable: false,      //是否启用排序
		   sortOrder: "asc",     //排序方式
		   queryParams: function(params){
			   var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					   pageSize: params.limit, //页面大小
					   page: params.offset //页码
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
		   uniqueId: "fid",      //每一行的唯一标识，一般为主键列
		   showToggle:false,     //是否显示详细视图和列表视图的切换按钮
		   showRefresh : false,  //是否显示刷新按钮
		   showColumns : false,  //是否显示列表下拉按钮
		   cardView: false,     //是否显示详细视图
		   detailView: false,     //是否显示父子表
		   singleSelect : true,
		   showHeader : false,
		   columns: [
			       	{
					         field: 'id',
					         checkbox: true,
					         align: 'center',
					         valign: 'middle',
					         visible: true,
					         formatter : function(value,row,index){
					        	 if(index==0){
					        		 return true;
					        	 }else{
					        		 return false;
					        	 }
					         }
				       	},{
					       	 title: '房间信息',
					         field: 'fid',
					         align: 'center',
					         valign: 'middle',
					         sortable: true,
					         visible: true,
					         formatter : function(value,row,index){
					        	 var froomInfo=row.fBuildingName+"#"+row.fFLoorName;
					        	var html="<table class='table table-bordered' onclick=\"refreshPublicPlan('"+row.fid+"','"+row.fRoomName+"')\">";
					 			html+="<tr>";
					 			html+="<td>"+row.fRoomName+"</td>";
					 			html+="</tr>";
					 			
					 			html+="<tr>";
					 			html+="<td>"+froomInfo+"</td>";
					 			html+="</tr>";

					 			html+="</table>";
					 			return html;
					         }
			       		}
		    		  ],
		    		  onLoadSuccess : function(data){
		    			  var rows=data.rows;
		    			  if(rows.length>0){
		    				  var fid=rows[0].fid;
		    				  var fRoomName=rows[0].fRoomName;
		    				  refreshPublicPlan(fid,fRoomName);
		    			  }
		    		  }
		  });
}

function initPublicPlanExecuteTb(){
	  $('#tb_publicPlanExecute').bootstrapTable({
		   url: 'queryList.do',   //请求后台的URL（*）
		   method: 'get',      //请求方式（*）
		   toolbar: '',    //工具按钮用哪个容器
		   striped: true,      //是否显示行间隔色
		   cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		   pagination: true,     //是否显示分页（*）
		   sortable: false,      //是否启用排序
		   sortOrder: "asc",     //排序方式
		   queryParams: function(params){
			   var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
					   pageSize: params.limit, //页面大小
					   page: params.offset, //页码
					   froomid : $("#searchRoomFid").val()
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
		   //uniqueId: "fid",      //每一行的唯一标识，一般为主键列
		   showToggle:false,     //是否显示详细视图和列表视图的切换按钮
		   showRefresh : false,  //是否显示刷新按钮
		   showColumns : false,  //是否显示列表下拉按钮
		   cardView: false,     //是否显示详细视图
		   detailView: false,     //是否显示父子表
		   singleSelect : false,
		   uniqueId : "fServiceGroupID",
		   rowStyle:function rowStyle(row, index) {
			   var fexcludcount=row.fexcludcount;
			   var fplancount=row.fplancount;
			   if(fexcludcount >= fplancount){
				   return {
				      css: {"background-color": "#FF83FA"}
				    	};
			    }else{
			    	return {
					      css: {"background-color": "#4EEE94"}
					    };
			    }
			},
		   columns: [
			       		{
					       	 title: '护理类型ID',
					         field: 'fServiceGroupID',
					         align: 'center',
					         valign: 'middle',
					         sortable: true,
					         visible: false
			       		},{
					       	 title: '护理类型',
					         field: 'serviceGroupName',
					         align: 'center',
					         valign: 'middle',
					         sortable: true
			       		},{
					       	 title: '项目计划id',
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
				    	 },{
							 title: '执行频率',
							 field: 'fName',
							 align: 'center',
							 valign: 'middle',
							 sortable: true,
							 formatter : function(value,row,index){
								 //if(row.fExecuteType==1){
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
										html+="每"+	fExecutecycle +fExecutecycleUnit+"执行"+fExecuteQty+"次";
										if(row.fExecuteType==1){
											html+="/["+fExecutetime+"]";
										}
										return html;
								}
							 //}
						 },{
					       	 title: '项目周期',
					         field: 'fplancount',
					         align: 'center',
					         valign: 'middle',
					         sortable: false
						 },{
					       	 title: '实际执行次数',
					         field: 'fexcludcount',
					         align: 'center',
					         valign: 'middle',
					         sortable: false
						 },{
					       	 title: '操作',
					         field: 'fstatus',
					         align: 'center',
					         valign: 'middle',
					         sortable: false,
					         formatter : actionFmt
						 }
		    		  ],
		    		  onLoadSuccess : function(data){
		    			  //数据加载完之后重新合并页面数据
		    				reloadDataMergeCells();
		    		  }
		  });
}

function reloadDataMergeCells(){
	var flag = true;  // 定义开关

	//执行完过后调用该方法
	$("#tb_publicPlanExecute").on("load-success.bs.table", function(){
		if(flag){
			var datas = $("#tb_publicPlanExecute").bootstrapTable('getData');
			var merges = [];
			var position = 0; // 插入行坐标
			
			for(var i = 0; i < datas.length; i++){
				var finishCount = 0;
				var totalOrderCount = datas.length - 1;

				var fServiceGroupID = datas[i].fServiceGroupID;
				var froomid = $("#searchRoomFid").val();
				
				$.ajax({
					type : 'POST',
					url :contextPath+"/publicPlanExecute/queryDetailList.do",
					data :{fServiceGroupID : fServiceGroupID,
						   froomid : froomid
						},
					success : function(details) {
						if(details.success){
							$("#tb_publicPlanExecute").bootstrapTable('removeByUniqueId', details.rows[0].fServiceGroupID);  //删除本行
							var merge = {};
							merge["index"] = position;
							merge["rowspan"] = details.rows.length;
							merges.push(merge);
							
							for(var j=0;j<details.rows.length;j++){
								var row = details.rows[j];
								$("#tb_publicPlanExecute").bootstrapTable('insertRow', {
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
								$("#tb_publicPlanExecute").bootstrapTable('mergeCells', {
									index: m.index,
									field: 'fServiceGroupID',
									colspan: 0,
									rowspan: m.rowspan
								});
							
								$("#tb_publicPlanExecute").bootstrapTable('mergeCells', {
									index: m.index,
									field: 'serviceGroupName',
									colspan: 0,
									rowspan: m.rowspan
								});
							}
							var html = $("#tb_publicPlanExecute .pagination-info").html();
							$("#tb_publicPlanExecute .pagination-info").html(html);
						}
						finishCount++;
					}
				});
			}
			flag = false;
		}
	});

}

function refreshPublicPlan(fid,fRoomName){
	$("#searchRoomFid").val(fid);
	$("#fRoomNameShow").html(fRoomName);
	
	$('#tb_publicPlanExecute').bootstrapTable('refresh');
}

function actionFmt(value,row,index){
	var html="<a onclick=\"publicExecute('"+row.fid+"','"+row.froomid+"','"+row.fpublicserviceitemid+"')\">执行</a>";
	
	return html;
}

function publicExecute(fid,froomid,fpublicserviceitemid){
	$.confirm({
        title: '',
        content : '确认执行房间计划?',
        columnClass : 'col-md-offset-3 col-md-6',
        icon : '',
        confirmButton : '确认执行',
        confirm : function(){
        	savePublicPlanExecute(fid,froomid,fpublicserviceitemid);
        },
        onOpen:function(){
        	//add_init_comp(fid,froomid);
        }
    });
}

function savePublicPlanExecute(fserviceplanid,froomid,fpublicserviceitemid){
	//此处传入的fid 实际是 公共项目计划的fid，即执行表的fserviceplanid
	var flag;
	$.ajax({
		type : 'POST',
		url : contextPath+"/publicPlanExecute/savePublicPlanExecute.do",
		async: false,
		data : {
				fserviceplanid : fserviceplanid,
				froomid : froomid,
				fpublicserviceitemid : fpublicserviceitemid
				},
		dataType :'json',
		success : function(rs) {
			if(rs.success){
				//关闭弹出的选择老人窗口
				$(".closeIcon").click();
				
				alertx(rs.msg);
				flag =  true;
				
				//刷新列表
				$("#tb_publicPlanExecute").bootstrapTable("refresh");
			}else{
				alertx(rs.msg);
				flag = false;
			}
		},
		error : function() {
			flag = false;
		}
	});
	return flag;
}



