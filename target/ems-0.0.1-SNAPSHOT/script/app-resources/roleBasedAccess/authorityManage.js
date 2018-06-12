$(function () {
	 //1.初始化Table
	 var oTable = new TableInit();
	 oTable.Init();
});
var goal = [];
$(document).ready(function(){
role();
});
function role(){
	$.ajax({
		url:contextPath+"/author/queryRoleNotMeun.do",
		type:"post",
		dataType:'json',
		success:function(data) {
			//增加等级下拉框

			//查询角色权限匹配数据

			$.ajax({
				url:contextPath+"/author/queryRoleMeun.do",
				type:"post",
				dataType:'json',
				success:function(data1) {

					$("#role_meun").html("");
					var $add=$("#role_meun");
					$add.append("<option value=''>选择一个角色</option>");
					//查询有权限角色
					if(data1.total!=0){
						for (var i=0;i<data1.total;i++){
							$add.append("<option value='"+data1.rows[i].r_id+"-"+data1.rows[i].s_menuid+"'>"+data1.rows[i].r_name+"</option>");
						}
					}
					//查询没有权限角色
					if(data.totle!=0){
						for (var i=0;i<data.total;i++){
							$add.append("<option value='"+data.rows[i].r_id+"-0'>"+data.rows[i].r_name+"</option>");
						}
					}

				}
			});
		}
	});

}
var go;
var authy=[];
var TableInit = function () {
 var oTableInit = new Object();
 //初始化Table
 oTableInit.Init = function () {
  $('#tb_authorityManage').bootstrapTable({
   url: 'queryParentSon.do',   //请求后台的URL（*）
   method: 'get',      //请求方式（*）
   toolbar: '#toolbar',    //工具按钮用哪个容器
   striped: true,      //是否显示行间隔色
   cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
   pagination: false,     //是否显示分页（*）
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
  // height: 450,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
   uniqueId: "ID",      //每一行的唯一标识，一般为主键列
   showToggle:true,     //是否显示详细视图和列表视图的切换按钮
   cardView: false,     //是否显示详细视图
     //是否显示父子表
   columns: [{
	    field: 'father',
	    title:'模块',
        formatter:function(value,row,index){
        	  var e;
        	  if(index==0){
                  e="<input id='father"+row.fatherid+"'name='father"+row.fatherid+"' type='checkbox' >"+value;
        	  }else{
        		if(go==value){
                	  e="";	
                	}else{
                        e="<input id='father"+row.fatherid+"' name='father"+row.fatherid+"' type='checkbox' >"+value;
                         }
        	  }
        	
        	 go=value;
         return e;
               
                }
	   },{
                
        field: 'son',
        title:'子菜单',
         formatter:function(value,row,index){
         var e ="<input id='box"+row.sonid+"' name='box"+row.fatherid+"' type='checkbox' value="+row.sonid+">"+value;
         return e;
        }
              

		   }],
   
   onLoadSuccess: function(data){
	   $.ajax({
			url:contextPath+"/author/query.do",
			type:"post",
			dataType:'json', 
			success:function(data) {	

				//点击分配权限事件
				$("#btn_add").unbind('click');
				 $("#btn_add").click(function(){	   
					 
					   //判断角色是否有权限
					    var a=$("#role_meun option:selected").val();
					   
						var arr = a.split('-');
				
					   //获取被选中的checked
						for(var i=0;i<data.total;i++){
							 (function(i){  						
								 $("input[name='box"+data.rows[i].smenuid+"']:checked").each(function(){  
						               goal+=$(this).val()+',';						           
						           });						         								      
				            })(i);
				         }


					 console.log("111");
					 console.log(arr);
						//进行ajax 赋予权限
						if(arr[0]==""){
							alert("选择一个角色");
						}else{
						//执行一个ajax	
							 $.ajax({
									url:contextPath+"/author/addAuthor.do",
									type:"post",
									dataType:'json', 
									data:{
										oldrole:a,
										newAuthor:goal
							
									},
									success:function(data) {
										role();
										$('#tb_authorityManage').bootstrapTable('refresh', {url: 'queryParentSon.do'});

										setAlert(data.message,"操作成功");
										

									}
							 });
						}
						goal='';
				
				 });
				 
				
				//部分全选权限事件
				for(var i=0;i<data.total;i++){
					 (function(i){  
				
					
					$("#father"+data.rows[i].smenuid).click(function(){
					    
				           $("input[name='box"+data.rows[i].smenuid+"']").prop("checked",$(this).prop("checked"));
				         
				           });
				      
		            })(i);
		         }
			} 
	   
	   
	   });
	 
   }

  });
 };
 

 	//菜单触发显示权限勾选
	$("#role_meun").change(function(){ 
		//移除上传选择的
		$(":checkbox").removeAttr("checked");

		
		//选根据角色选择相应的菜单
		var a=$("#role_meun option:selected").val();
		var arr = a.split('-');
	
		
		if(arr[1]!==""){								
		var arr1=arr[1].split(',');			
		for(var b=0;b<arr1.length;b++){				
        $("#box"+arr1[b]).prop("checked","true");

		  }
		}
		
		
	}); 
 //得到查询的参数
 oTableInit.queryParams = function (params) {
  var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
	   pageSize: params.limit, //页面大小
	   page: params.offset + 1, //页码
	 
  };
  return temp;
 };
 
 return oTableInit;
 
};







function closeModal() {
	$("#addName").val("");
	$("#addValue").val("");
	$("#updateName").val("");
	$("#updateValue").val("");
}



