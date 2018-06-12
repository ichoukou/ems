$(function () {
	 //1.初始化Table
	 var oTable = new TableInit();
	 oTable.Init();
	
});

var TableInit = function () {
	 var oTableInit = new Object();
	 //初始化Table
	 oTableInit.Init = function () {
	  $('#tb_nursingServiceGroup').bootstrapTable({
	   url: 'queryServiceGroupList.do',   //请求后台的URL（*）
	   method: 'get',      //请求方式（*）
	  // toolbar: '',    //工具按钮用哪个容器
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
	   singleSelect : true,
	   uniqueId : "fServiceGroupID",
	   columns: [
	             	{
				         field: 'id',
				         checkbox: true,
				         align: 'center',
				         valign: 'middle'
			       	},{
				       	 title: '护理类型',
				         field: 'fName',
				         align: 'center',
				         valign: 'middle',
				         sortable: true
		       		},{
					     title: '服务类型',
					     field: 'fServiceType',
					     align: 'center',
					     valign: 'middle',
					     sortable: true,
					     formatter : function(value,row,index){
							 if(value==1){
								 return "老人服务";
							 }else if(value==2){
								 return "公共服务";
							 }
						 }
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
		   page: params.offset, //页码
		   fServiceType: $("#searchNursingServiceType").val(),
		   fName:$("#searchServiceGroupName").val()
	  };
	  return temp;
	 };
	 return oTableInit;
	};
	
function queryNursingServiceGroup(){
	$('#tb_nursingServiceGroup').bootstrapTable('refresh');
}	

//请求护理类型的页面
function addNursingServiceGroup(fid){
	$.ajax({
        type: "POST",
        url: contextPath+"/nursingProject/addNursingServiceGroup.do",
        success: function(data){
       	 	open_addNursingServiceGroup_page(data,fid);
    	 }
	});
}

//打開护理类型頁面窗口
function open_addNursingServiceGroup_page(html,fid){
	var title="";	
	if(fid){
		title="修改护理类型";
	}else{
		title="新增护理类型";
	}
	$.confirm({
        title: '<h2>'+title+'<h2>',
        content : html,
        columnClass : 'col-md-offset-2 col-md-8',
        icon : '',
        confirm : function(){
        		var flag = saveNursingServiceGroup();
            	if(flag){
            		return true;
            	}
        },
        onOpen:function(){
        	add_init_comp(fid);
        }
    });
}

function saveNursingServiceGroup(){
	var flag;
	$.ajax({
		type : 'POST',
		url : contextPath+"/nursingProject/saveNursingServiceGroup.do",
		async: false,
		data : $('#addNursingServiceGroup_form').serialize(),
		success : function(rs) {
			if(rs.success){
				alertx(rs.msg);
				//保存成功了之后重新刷新表数据
				queryNursingServiceGroup();
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

//修改护理类型
function editNursingServiceGroup(){
	var rows=$('#tb_nursingServiceGroup').bootstrapTable('getSelections');
	if(rows.length !=1){
		alertx("请选择一条数据");
	}else{
		var fid=rows[0].fid;
		addNursingServiceGroup(fid);
	}
}

//删除护理类型
function delNursingProject(){
	var rows=$('#tb_nursingServiceGroup').bootstrapTable('getSelections');
	if(rows.length !=1){
		alertx("请选择一条数据");
	}else{
		$.ajax({
			type : 'POST',
			url : contextPath+"/nursingProject/delNursingProject.do",
			async: false,
			data : {fid : rows[0].fid},
			success : function(rs) {
				console.info(rs);
				if(rs.success){
					alertx(rs.msg);
					//删除完了之后重新刷新表数据
					queryNursingServiceGroup();
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
}

function resetSearch(){
	$("#formSearch")[0].reset();
}


