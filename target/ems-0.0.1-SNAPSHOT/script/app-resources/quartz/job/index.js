
	$(function(){
		//1.初始化Table
		 var oTable = new TableInit();
		 oTable.Init();
	});
	
	var TableInit = function () {
		 var oTableInit = new Object();
		 //初始化Table
		 oTableInit.Init = function () {
		  $('#tb_quartzs').bootstrapTable({
		   url: 'data.do',   //请求后台的URL（*）
		   method: 'get',      //请求方式（*）
		   //toolbar: '',    //工具按钮用哪个容器
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
		   uniqueId: "id",      //每一行的唯一标识，一般为主键列
		   showToggle:false,     //是否显示详细视图和列表视图的切换按钮
		   showRefresh : false,  //是否显示刷新按钮
		   showColumns : false,  //是否显示列表下拉按钮
		   cardView: false,     //是否显示详细视图
		   detailView: false,     //是否显示父子表
		   singleSelect : true,
		   columns: [{
					         field: 'id',
					         checkbox: true,
					         align: 'center',
					         valign: 'middle'
				       	},{
							 title: '任务名',
							 field: 'jobname',
							 align: 'center',
							 valign: 'middle',
							 sortable: true
				         },{
						     title: '时间表达式',
						     field: 'cronexpression',
						     align: 'center',
						     valign: 'middle',
						     sortable: true
				    	 },{
							 title: '执行类',
							 field: 'jobclass',
							 align: 'center',
							 valign: 'middle',
							 sortable: true
				         },{
					       	 title: '触发器名',
					         field: 'triggername',
					         align: 'center',
					         valign: 'middle',
					         sortable: true
						 },{
					       	 title: '状态',
					         field: 'state',
					         align: 'center',
					         valign: 'middle',
					         sortable: false,
					         formatter :stare_formatter
						 },{
					       	 title: '备注',
					         field: 'description',
					         align: 'center',
					         valign: 'middle',
					         sortable: false
						 },{
					       	 title: '操作',
					         field: '',
					         align: 'center',
					         valign: 'middle',
					         sortable: false,
					         formatter : edit
						 }
		    		  ],
		  	    	onLoadSuccess : function (data){
			    		$(".fixed-table-header").removeClass("fixed-table-header");
			    	}
		  });
		 };
		 
		 //得到查询的参数
		 oTableInit.queryParams = function (params) {
		  var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			   pageSize: params.limit, //页面大小
			   page: params.offset //页码
		  };
		  return temp;
		 };
		 return oTableInit;
		};
		
	function table_query(){
		$('#tb_quartzs').bootstrapTable('refresh');
	}
	
	function edit(value, row, index) {
		var html = "";
		html += "<div class='btn-group btn-group-xs' role='group'>";
		if (row.state == 'NORMAL') {
			html += "<button type='button' class='btn btn-default' onclick='pause(\""
					+ row.jobdetail.name + "\")'>暂停</button>";
		} else if (row.state == 'PAUSED') {
			html += "<button type='button' class='btn btn-default' onclick='start(\""
					+ row.jobdetail.name + "\")'>开启</button>";
		}
		html += "<button type='button' class='btn btn-default' onclick='del(\""+row.jobdetail.name+"\",\""+row.triggername+"\")'>删除</button>";
		html += "<button type='button' class='btn btn-default btn-xs' onclick='open_edit_page(\""
				+ row.jobdetail.name + "\")'>修改参数</button>";
		html += "</div>";
		return html;
	}

	var obj; 
	//打开修改表达式页面
 	function open_edit_page(name) {
    	$.post(contextPath+"/job/quartz/getByName.do",{jobname:name},function(data){
    		obj = data;
			$.confirm({
		        title: '<h6>修改任务<h6>',
		        content : 'URL:edit.do',
		        columnClass : 'col-md-offset-2 col-md-8',
		        confirm : function(){
		        	$.ajax({
		        		type : 'POST',
		        		async: false,
		        		url : "change_exp.do",
		        		data : $('#edit_form').serialize(),
		        		success : function(rs) {
		        			if(rs.success){
		        				table_query();
		        				return true;
		        			}else{
		        				alertx(rs.msg);
		        				return false;
		        			}
		        		},
		        		error : function() {
		        			alertx("修改失败,请检查数据!");
		        			return false;
		        		}
		        	});
		        }
		    });
    	}).error(function() { alertx("系统错误,请查看日志!"); });
	}

	//修改表达式
	function change_exp(){
		if ($("#form").valid() == true) {
			$.ajax({
				type : 'POST',
				url : "quartz/change_exp.do",
				data : {
					key : $("#m_name").val(),
					cronexpression : $("#m_cronexpression").val()
				},
				success : function(rs) {
					if(rs.success){
						table_query();
					}else{
						$.alert({
			                title: '<h5>保存失败!</h5>',
			                content: rs.msg,
			                confirmButton: '确认',
			                confirmButtonClass: 'btn-info',
			                animation: 'bottom',
			                icon: 'fa fa-check',
			                backgroundDismiss: false
			            });
					}
				},
				error : function() {
					$.alert({
		                title: '<h5>保存失败!</h5>',
		                content: '表达式格式不正确',
		                confirmButton: '确认',
		                confirmButtonClass: 'btn-info',
		                animation: 'bottom',
		                icon: 'fa fa-check',
		                backgroundDismiss: false
		            });
					return;
				}
			});
		}else{
			
			$.alert({
                title: '<h5>保存失败!</h5>',
                content: '内容填写不完整.',
                confirmButton: '确认',
                confirmButtonClass: 'btn-info',
                animation: 'bottom',
                icon: 'fa fa-check',
                backgroundDismiss: false
            });
			
			return false;
		}

	}

	//根据key暂停job
	function pause(value,refresh) {
		$.ajax({
			type : 'POST',
			url : contextPath+"/job/quartz/pausebykey.do",
			async: false,
			data : {
				key : value,
			},
			success : function(rs) {
				//是否需要刷新  批量时不需要立刻刷新  无参数 立刻刷新
				if(!(refresh==false)) {
					table_query();
				}
			},
			error : function() {
				return;
			}
		});
	}

	//根据key开启job
	function start(value,refresh) {
		$.ajax({
			type : 'POST',
			url : contextPath+"/job/quartz/startbykey.do",
			async: false,
			data : {
				key : value,
			},
			success : function(rs) {
				//是否需要刷新  批量时不需要立刻刷新  无参数 立刻刷新
				if(!(refresh==false)) {
					table_query();
				}
			},
			error : function() {
				return;
			}
		});
	}
	
	//立刻执行一次选中的job
	function invoke_job(){
		var selects = $("#tb_quartzs").bootstrapTable('getSelections');
		var arrs = [];
		for (var i=0; i<selects.length; i++) {
			var obj = selects[i];
			arrs.push(obj.jobname);
		}
		
		$.ajax({
			type : 'POST',
			url : contextPath+"/job/quartz/invoke_job.do",
			data : {
				t : Math.random(),
				keys : arrs.toString()
			},
			success : function(rs) {
 				if(rs.success){
 					alertx("已提交至后台执行!");
 				}
			}
		});
		
	}
	
	//状态 formatter
	function stare_formatter(value){
		if('PAUSED' == value){
			return '已暂停';
		}else if('NORMAL' == value){
			return '执行中';
		}else if('BLOCKED' == value){
			return "执行中";
		}else{
			return "未知状态";
		}
	}
	
	function jobDataMap_formatter(value){
		return JSON.stringify(value);
	}
	
//打开添加页面 
function open_add(obj){
	$.confirm({
        title: '<h6>添加任务<h6>',
        content : 'URL:basepage.do',
        columnClass : 'col-md-offset-2 col-md-8',
        confirm : function(){
        		var flag = add();
            	if(flag){
            		return true;
            	}
        	return false;
        }
    });

}

//提交form表单
function add(){
	$.ajax({
		type : 'POST',
		url : contextPath+"/job/quartz/add.do",
		async: false,
		data : $('#add_form').serialize(),
		dataType :'json',
		success : function(rs) {
			if(rs.success){
				alertx(rs.msg);
				//保存完了之后重新刷新表数据
				table_query();
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
	return flag;
}

//删除job
function del(jobname,triggername){
	$.ajax({
		type : 'POST',
		url : contextPath+"/job/quartz/del.do",
		data : {
			jobname : jobname,
			triggername : triggername
		},
		success : function(rs) {
			if(rs.success){
				table_query();
			}else{
				alertx(rs.msg);
				flag = false;
			}
		},
		error : function() {
			return ;
		}
	});
}

function start_or_pause(state,is_all){
	var selects = null; //操作数据
	var content = ''; //提示信息
	if(is_all){  //全部
		selects = $("#tb_quartzs").bootstrapTable('getData');
		content =  '没有可操作的数据!';
	}else{ // 选中
		selects = $("#tb_quartzs").bootstrapTable('getSelections');
		content =  '请选择操作的数据!';
	}
	if(selects == null || selects.length == 0){
		alertx(content);
		return;
	}
	for (var i=0; i<selects.length; i++) {
		var obj = selects[i];
		if(state=='start'){
			start(obj.jobname,false);
		}else if(state=='pause'){
			pause(obj.jobname,false);
		}
	}
	
	table_query();
}

//开启选中任务
function open_cheak_job(){
	start_or_pause('start')
}  

//暂停选中任务
function pause_cheak_job(){
	start_or_pause('pause');
}

//开启所有任务
function open_all_job(){
	start_or_pause('start',true);
}

//暂停所有任务
function pause_all_job(){
	start_or_pause('pause',true);
}