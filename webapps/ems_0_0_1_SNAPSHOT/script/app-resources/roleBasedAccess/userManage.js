$(function () {
	 //1.初始化Table
	 var oTable = new TableInit();
	 oTable.Init();
	
});

var TableInit = function () {
 var oTableInit = new Object();
 //初始化Table
 oTableInit.Init = function () {
	 //加载 更新员工tableUpdate
	$('#tb_empMangerUpdate').bootstrapTable({
		 url: contextPath+"/user/queryStaff.do",   //请求后台的URL（*）
		 method: 'get',      //请求方式（*）
		 striped: true,      //是否显示行间隔色
		 cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		 pagination: true,     //是否显示分页（*）
		 sortable: false,      //是否启用排序
		// sortOrder: "asc",     //排序方式
		 queryParams: oTableInit.queryParams1,//传递参数（*）
		 sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		 pageNumber:1,      //初始化加载第一页，默认第一页
		 pageSize: 10,      //每页的记录行数（*）
		pageList : [ 5, 10, 50, 100 ],
		 search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		 strictSearch: true,
		 showColumns: true,     //是否显示所有的列
		 showRefresh: true,     //是否显示刷新按钮
		 minimumCountColumns: 2,    //最少允许的列数
		 clickToSelect: true,    //是否启用点击选中行
		 height: 600,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		 uniqueId: "ID",      //每一行的唯一标识，一般为主键列
		 showToggle:true,     //是否显示详细视图和列表视图的切换按钮
		 cardView: false,     //是否显示详细视图
		 detailView: false,     //是否显示父子表
		 columns: [{
			 radio: true
		 }, {
			 field: 'fId',
			 title: '编号'
		 }, {
			 field: 'fStaffName',
			 title: '姓名'
		 }, {
			 field: 'fSex',
			 title: '性别'
		 }, {
			 field: 'fEntryDate',
			 title: '入职日期'
		 }, {
			 field: 'fDepartmentName',
			 title: '部门'
		 }, {
			 field: 'fPost',
			 title: '职务'
		 }, {
			 field: 'fBuildingName',
			 title: '所属大厦'
		 }, {
			 field: 'fMobileTel',
			 title: '电话'
		 }, {
			 field: 'fTitle',
			 title: '职称'
		 }, {
			 field: 'fSalryType',
			 title: '工资'
		 }, {
			 field: 'fStaffStatus',
			 title: '状态'
		 }],
		 onLoadSuccess: function(data){

		 }
	 });
  //加载另一个增加员工table
	 $('#tb_empManger').bootstrapTable({
		    url: contextPath+"/user/queryStaff.do",   //请求后台的URL（*）
		    method: 'get',      //请求方式（*）
		    striped: true,      //是否显示行间隔色
		    cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		    pagination: true,     //是否显示分页（*）
		    sortable: false,      //是否启用排序
		//    sortOrder: "asc",     //排序方式
		    queryParams: oTableInit.queryParams2,//传递参数（*）
		    sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
		    pageNumber:1,      //初始化加载第一页，默认第一页
		    pageSize: 10,      //每页的记录行数（*）
		 pageList : [ 5, 10, 50, 100 ],
		    search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		    strictSearch: true,
		    showColumns: true,     //是否显示所有的列
		    showRefresh: true,     //是否显示刷新按钮
		    minimumCountColumns: 2,    //最少允许的列数
		    clickToSelect: true,    //是否启用点击选中行
		    height: 600,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		    uniqueId: "ID",      //每一行的唯一标识，一般为主键列
		    showToggle:true,     //是否显示详细视图和列表视图的切换按钮
		    cardView: false,     //是否显示详细视图
		    detailView: false,     //是否显示父子表   
            columns: [{
                radio: true
            }, {
                field: 'fId',
                title: '编号'
            }, {
                field: 'fStaffName',
                title: '姓名'
            }, {
                field: 'fSex',
                title: '性别'
            }, {
                field: 'fEntryDate',
                title: '入职日期'
            }, {
                field: 'fDepartmentName',
                title: '部门'
            }, {
                field: 'fPost',
                title: '职务'
            }, {
                field: 'fBuildingName',
                title: '所属大厦'
            }, {
                field: 'fMobileTel',
                title: '电话'
            }, {
                field: 'fTitle',
                title: '职称'
            }, {
                field: 'fSalryType',
                title: '工资'
            }, {
                field: 'fStaffStatus',
                title: '状态'
            }],
		 onLoadSuccess: function(data){
		 }
        });
  //加载一个 用户table
  $('#tb_userManger').bootstrapTable({
   url: 'query.do',   //请求后台的URL（*）
   method: 'get',      //请求方式（*）
   toolbar: '#toolbar',    //工具按钮用哪个容器
   striped: true,      //是否显示行间隔色
   cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
   pagination: true,     //是否显示分页（*）
   sortable: false,      //是否启用排序
   sortOrder: "asc",     //排序方式
   queryParams: oTableInit.queryParams,//传递参数（*）
   sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
   pageNumber:1,      //初始化加载第一页，默认第一页
   pageSize: 10,      //每页的记录行数（*）
	pageList : [ 5, 10, 50, 100 ],
   search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
   strictSearch: true,
   showColumns: true,     //是否显示所有的列
   showRefresh: true,     //是否显示刷新按钮
   minimumCountColumns: 2,    //最少允许的列数
   clickToSelect: true,    //是否启用点击选中行
   height: 600,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
   uniqueId: "ID",      //每一行的唯一标识，一般为主键列
   showToggle:true,     //是否显示详细视图和列表视图的切换按钮
   cardView: false,     //是否显示详细视图
   detailView: false,     //是否显示父子表   
   columns: [{
    radio: true
   }, {
    field: 'uid',
    title: 'ID'
   }, {
    field: 'uname',
    title: '用户名'
   }, {
	field: 'name',
	title: '姓名'
   } , {
	field: 'roleName',
	title: '角色'
   } , {
	field: 'fStaffName',
    title: '所属员工'
   }, {
    field: 'oldhouse',
	title: '养老院'
    } , {
   field: 'state',
   title: '状态'	   
  }, ]
  });
 };

	//得到查询的参数
	oTableInit.queryParams2 = function (params) {
		var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			pageSize: params.limit, //页面大小
			page: params.offset, //页码
			fStaffName: $("#searchEmpName").val(),
			fStaffStatus: $("#searchEmpStatus option:selected").val(),
			fDepartmentID:$("#searchEmpDepartment option:selected").val()

		};
		return temp;
	};
	//得到更新查询参数
	oTableInit.queryParams1 = function (params) {
		var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			pageSize: params.limit, //页面大小
			page: params.offset, //页码

			fStaffName: $("#searchEmpNameUpdate").val(),
			fStaffStatus: $("#searchEmpStatusUpdate option:selected").val(),
			fDepartmentID:$("#searchEmpDepartmentUpdate option:selected").val()

		};
		return temp;
	};
	//得到查询的参数
   oTableInit.queryParams = function (params) {
  var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
	  uname: $("#userName").val(),
	  employId: $("#empName").val(),
	   pageSize: params.limit, //页面大小
	   page: params.offset, //页码
	
  };
  return temp;
 };
 return oTableInit;
};


$(document).ready(function(){
	$("#userHouse_op").css("background-color","#FFFFCC");
	$("#updateUserHouse_op").css("background-color","#FFFFCC");

	//显示添加查询员工的条件
	 $.ajax({
         url:contextPath+"/employee/showDname.do",
         type:"post",
         dataType:'json',
         success:function(data) {
             $("#searchEmpDepartment").html("");
             var $add=$("#searchEmpDepartment");
             $add.append("<option value=''>-选择部门-</option>");
             for (var i=0;i<data.total;i++){
                 $add.append("<option value='"+data.rows[i].FID+"'>"+data.rows[i].FDepartmentName+"</option>");
             }


			 $("#searchEmpDepartmentUpdate").html("");
			 var $add=$("#searchEmpDepartmentUpdate");
			 $add.append("<option value=''>-选择部门-</option>");
			 for (var i=0;i<data.total;i++){
				 $add.append("<option value='"+data.rows[i].FID+"'>"+data.rows[i].FDepartmentName+"</option>");
			 }

         }
     });
	 //显示查询用户的条件
	$.ajax({
		url:contextPath+"/Order/queryStaffMessage.do",
		type:"post",
		dataType:'json',
		success:function(data) {
			$("#empName").html("");
			var $add=$("#empName");
			$add.append("<option value='' selected>-选择员工-</option>");
			for (var i=0;i<data.total;i++){
				$add.append("<option value='"+data.rows[i].FID+"'>"+data.rows[i].FStaffName+"</option>");
			}
		}
	});

});

//查询相应的用户
function queryUserList(){
	$.ajax({
		url: contextPath+"/user/queryList.do",
		type:"post",
		data:{
			uname: $("#userName").val(),
			employId: $("#empName option:selected").val(),
			page:0,
			pageSize:10
		},
		success:function(data) {

			$('#tb_userManger').bootstrapTable('load', data);
		}
	});

}

//清空用户
function queryclear(){
$("#userName").val("");
$("#empName").val("");
}


//查询相应的员工进行查询
function queryMessageUpdate(){
	$.ajax({
		url: contextPath+"/user/queryStaff.do",
		type:"post",
		data:{
			fStaffName: $("#searchEmpNameUpdate").val(),
			fStaffStatus: $("#searchEmpStatusUpdate option:selected").val(),
			fDepartmentID:$("#searchEmpDepartmentUpdate option:selected").val(),
			page:0,
			pageSize:10
		},
		success:function(data) {

			$('#tb_empMangerUpdate').bootstrapTable('load', data);
		}
	});
}
//清空更新查询条件
function clearMessageUpdate(){
	$("#searchEmpNameUpdate").val('');
	$("#searchEmpStatusUpdate").val('');
	$("#searchEmpDepartmentUpdate").val('');
}
//查询相应的员工进行添加
function queryMessage(){


    $.ajax({
        url: contextPath+"/user/queryStaff.do",
        type:"post",
        data:{
            fStaffName: $("#searchEmpName").val(),
            fStaffStatus: $("#searchEmpStatus option:selected").val(),
            fDepartmentID:$("#searchEmpDepartment option:selected").val(),
            page:0,
            pageSize:10
        },
        success:function(data) {

            $('#tb_empManger').bootstrapTable('load', data);
        }
    });
}
//清空查询条件
function clearMessage(){
	$("#searchEmpName").val('');
	$("#searchEmpStatus").val('');
	$("#searchEmpDepartment").val('');
}
//添加员工
function addEmp(){
	var carrentItem = $("#tb_empManger").bootstrapTable('getSelections');
	if(carrentItem[0]){
		console.log(carrentItem[0]);
		console.log("养老院id:"+carrentItem[0]);
		$("#emp_message").html(" ");
		$("#emp_footer_message").html(" ");
        $("#addEmployId").val(carrentItem[0].fStaffName);
        $("#addStaff_id").val(carrentItem[0].fId);
		$("#userHouse_op").val(carrentItem[0].fNursinghomeID);
		$('#empModal').modal('hide');		
        $('#addEmployId_message').html('');
        
	}else{
		$("#emp_message").html("请选择一个员工");
		$("#emp_footer_message").html("请选择一个员工");

	}
	
}
//更新添加员
//添加员工
function updateEmp(){
	var carrentItem = $("#tb_empMangerUpdate").bootstrapTable('getSelections');
	if(carrentItem[0]){
		$("#emp_messageUpdate").html(" ");
		$("#emp_footer_messageUpdate").html(" ");
		$("#updateEmployId").val(carrentItem[0].fStaffName);
		$("#updateStaff_id").val(carrentItem[0].fId);
		$("#updateUserHouse_op").val(carrentItem[0].fNursinghomeID);
		$('#empUpdateModal').modal('hide');
		$('#addEmployId_message').html('');


	}else{
		$("#emp_messageUpdate").html("请选择一个员工");
		$("#emp_footer_messageUpdate").html("请选择一个员工");

	}

}

//增加  单独账号验证
function addUname_check(){
	var add=$("#addUname").val().trim();
   	$("#addUname_message").html("");
	if(add==null||add.length==0||add==''){
	   	$("#addUname_message").html("账号不能为空！");
	}else{
		//ajax:验证
		$.ajax({
			url: contextPath + "/user/checkUser.do",
			type: "post",
			data: {
				uname: add,
			},
			success: function (data) {
				if (!data.success) {
					$("#addUname_message").html("该名称已存在！");
				}
				else {
					$("#addUname_message").html("");

				}
			}
		})
	}
}
//增加  单独密码的验证
function addPass_check(){
	var addPass=$("#addPass").val().trim(); 
	$("#addPass_message").html("");
	if(addPass==null||addPass.length==0){
	   	 $("#addPass_message").html("密码不能为空！");
		}	
}
//增加  单独所属员工的验证
function addEmployId_check(){
	var addEmployId=$("#addEmployId").val().trim(); 
	$("#addEmployId_message").html("");
	if(addEmployId==null||addEmployId.length==0){
	   	 $("#addEmployId_message").html("请选择一个员工！");
		}	
}
//增加 单独姓名验证
function addName_check(){
	var addName=$("#addName").val().trim(); 
	$("#addName_message").html("");
	if(addName==null||addName.length==0){
	   	 $("#addName_message").html("名字不能为空！");
		}
	
}
//增加单独的手机验证
function addPhoneNum_check(){
	var tel=$("#addPhoneNum").val().trim(); 	
	$("#addPhoneNum_message").html("");
	if(tel==null||tel.length==0){
	   	 $("#addPhoneNum_message").html("电话不能为空！");
		}else{		
			var reg=new RegExp(/^1[34578]\d{9}$/);
			if(reg.test(tel)){
			  $("#addPhoneNum_message").html(" ");
			}else{
			  	 $("#addPhoneNum_message").html("格式错误！");	
			}		
		}	
}
//增加验证
function addUser_Check(){	
	var add=$("#addUname").val().trim();
	var addPass=$("#addPass").val().trim(); 
	var addName=$("#addName").val().trim(); 
	var addEmployId=$("#addEmployId").val().trim(); 
	var tel=$("#addPhoneNum").val().trim(); 	
	var userHouse=$("#userHouse_op option:selected").val();
	var user=$("#user_op option:selected").val();

	

	var result = true;
		if(tel==null||tel.length==0){
		   	 $("#addPhoneNum_message").html("电话不能为空！");
		    	result = false;
			}else{
				
				var reg=new RegExp(/^1[34578]\d{9}$/);
				if(reg.test(tel)){
				  $("#addPhoneNum_message").html(" ");
				  result = true;
				}else{
				  	 $("#addPhoneNum_message").html("格式错误！");	
				  	result = false;
				}
			}
		if(add==null||add.length==0||add==''){
		   	$("#addUname_message").html("账号不能为空！");
	        result = false;
		}else{
			//ajax:验证
			$.ajax({
				url: contextPath + "/user/checkUser.do",
				type: "post",
				data: {
					uname: add,
				},
				success: function (data) {
					if (!data.success) {
						$("#addUname_message").html("该名称已存在！");
						result = false;

					}
					else {
						$("#addUname_message").html("");
						result = true;

					}
				}
			})
		}
		if(addPass==null||addPass.length==0){
		   	 $("#addPass_message").html("密码不能为空！");
	    	 result = false;
		}
		if(addName==null||addName.length==0){
		   	 $("#addName_message").html("名字不能为空！");
	    	 result = false;
	    }
		if(addEmployId==null||addEmployId.length==0){
		   	 $("#addEmployId_message").html("请选择一个员工！");
	    	 result = false;
	    }
		if(userHouse==null||userHouse.length==0||userHouse==''){
			 $("#userHouse_op_message").html("请选择!");
	    	 result = false;
		}if(user==null||user.length==0||user==''){
			 $("#user_op_message").html("请选择!");
	    	 result = false;
		}  
        return result;
}
//更新的验证
function updateUser_Check(){	
	var add=$("#updateUname").val().trim();
	var addPass=$("#updatePass").val().trim(); 
	var addName=$("#updateName").val().trim(); 
	var addEmployId=$("#updateEmployId").val().trim(); 
	var tel=$("#updatePhoneNum").val().trim(); 	
	var userHouse=$("#updateUserHouse_op option:selected").val();
	var user=$("#updateUser_op option:selected").val();
	var result = true;
		if(tel==null||tel.length==0){
		   	 $("#updatePhoneNum_message").html("电话不能为空！");
		    	result = false;
			}else{
				
				var reg=new RegExp(/^1[34578]\d{9}$/);
				if(reg.test(tel)){
				  $("#updatePhoneNum_message").html(" ");
				  result = true;
				}else{
				  	 $("#updatePhoneNum_message").html("格式错误！");	
				  	result = false;
				}
			}
		if(add==null||add.length==0||add==''){
		   	$("#updateUname_message").html("账号不能为空！");
	        result = false;
		}else{
			//ajax:验证
			$.ajax({
				url: contextPath + "/user/checkUpdateUser.do",
				type: "post",
				data: {
					uname: add,
					uid:$('#user_id').val(),
				},
				success: function (data) {
					if (!data.success) {
						$("#addUname_message").html("该名称已存在！");
						result = false;

					}
					else {
						$("#addUname_message").html("");
						result = true;


					}
				}
			})
		}
		if(addPass==null||addPass.length==0){
		   	 $("#updatePass_message").html("密码不能为空！");
	    	 result = false;
		}
		if(addName==null||addName.length==0){
		   	 $("#updateName_message").html("名字不能为空！");
	    	 result = false;
	    }
		if(addEmployId==null||addEmployId.length==0){
		   	 $("#updateEmployId_message").html("请选择一个员工！");
	    	 result = false;
	    }
		if(userHouse==null||userHouse.length==0||userHouse==''){
			 $("#updateUserHouse_op_message").html("请选择!");
	    	 result = false;
		}if(user==null||user.length==0||user==''){
			 $("#updateUser_op_message").html("请选择!");
	    	 result = false;
		}  
        return result;
}
//更新 单独账号验证
function updateUname_check(){
	var add=$("#updateUname").val().trim();
   	$("#updateUname_message").html("");
	if(add==null||add.length==0||add==''){
	   	$("#updateUname_message").html("账号不能为空！");
	}else{
		//ajax:验证
		$.ajax({
			url: contextPath + "/user/checkUpdateUser.do",
			type: "post",
			data: {
				uname: add,
				uid:$('#user_id').val(),
			},
			success: function (data) {
				if (!data.success) {
					$("#updateUname_message").html("该名称已存在！");
				}
				else {
					$("#updateUname_message").html("");

				}
			}
		})
	}
}
//增加  单独密码的验证
function updatePass_check(){
	var addPass=$("#updatePass").val().trim(); 
	$("#updatePass_message").html("");
	if(addPass==null||addPass.length==0){
	   	 $("#updatePass_message").html("密码不能为空！");
		}	
}
//增加  单独所属员工的验证
function updateEmployId_check(){
	var addEmployId=$("#updateEmployId").val().trim(); 
	$("#updateEmployId_message").html("");
	if(addEmployId==null||addEmployId.length==0){
	   	 $("#updateEmployId_message").html("请选择一个员工！");
		}	
}
//增加 单独姓名验证
function updateName_check(){
	var addName=$("#updateName").val().trim(); 
	$("#updateName_message").html("");
	if(addName==null||addName.length==0){
	   	 $("#updateName_message").html("名字不能为空！");
		}
	
}
//增加单独的手机验证
function updatePhoneNum_check(){
	var tel=$("#updatePhoneNum").val().trim(); 	
	$("#updatePhoneNum_message").html("");
	if(tel==null||tel.length==0){
	   	 $("#updatePhoneNum_message").html("电话不能为空！");
		}else{		
			var reg=new RegExp(/^1[34578]\d{9}$/);
			if(reg.test(tel)){
			  $("#updatePhoneNum_message").html(" ");
			}else{
			  	 $("#updatePhoneNum_message").html("格式错误！");	
			}		
		}	
}
//新增用户信息
function addUser(){

	if(addUser_Check()){
		var add=$("#addUname_message").html();
		if(add!=''){
			$("#addUname_message").html("该名称已存在！");
		}else{
			$.ajax({
				url:contextPath+"/user/addUser.do",
				type:"post",
				data:{
					uname:$("#addUname").val(),
					passWord:$("#addPass").val(),
					phoneNum:$("#addPhoneNum").val(),
					name:$("#addName").val(),
					employId:$("#addStaff_id").val(),
					roleId:$("#user_op option:selected").val(),
					oldhouse:$("#userHouse_op option:selected").val()
				},
				success:function(data) {

					if (!data.success) {
						$("#addUname_message").html("该名称已存在！");
					}
					else {
						$("#addUname_message").html("");
						$('#tb_userManger').bootstrapTable('refresh', {url: 'query.do'});
						setAlert(data.message,"增加用户成功");
						$("#add_close_btn").click();
						closeModal();
					}

				}
			});
		}

	}	
}
//修改用户信息
function updateUser() {
	if (updateUser_Check()) {
		var add = $("#updateUname_message").html();
		if (add != '') {
			$("#updateUname_message").html("该名称已存在！");
		} else {
			$.ajax({
				url: contextPath + "/user/updateUser.do",
				type: "post",
				data: {
					uid: $('#user_id').val(),
					uname: $("#updateUname").val(),
					passWord: $("#updatePass").val(),
					phoneNum: $("#updatePhoneNum").val(),
					name: $("#updateName").val(),
					employId: $("#updateStaff_id").val(),
					roleId: $("#updateUser_op option:selected").val(),
					oldhouse: $("#updateUserHouse_op option:selected").val()

				},
				success: function (data) {
					if (!data.success) {
						$("#updateUname_message").html("该名称已存在！");
					}
					else {
						$("#updateUname_message").html("");
						$('#tb_userManger').bootstrapTable('refresh', {url: 'query.do'});
						setAlert(data.message, "更改用户成功");
						$("#update_close_btn").click();
						closeModal();
					}


				}
			});
		}
	}

}
//用户删除
function gotoDelete(){
	var carrentItem = $("#tb_userManger").bootstrapTable('getSelections');
	if(carrentItem[0]){
		if(carrentItem[0].state=="<span style='color:red'>已禁用</span>"){
			setAlert("error","该条记录已经是禁用状态");
		}else{
			$.ajax({
				url:contextPath+"/user/deleteUser.do",
				type:"post",
				data:{
					uid:carrentItem[0].uid
				},
				success:function(data) {	
		            $('#tb_userManger').bootstrapTable('refresh', {url: 'query.do'});		
					setAlert(data.msg,"禁用成功");
					
				}
			});	
		}
	}else{
		setAlert("error","请先选择一条数据");
	}
}
//用户启用
function gotoStart(){
	var carrentItem = $("#tb_userManger").bootstrapTable('getSelections');
	if(carrentItem[0]){
		if(carrentItem[0].state=="<span style='color:green'>已启用</span>"){
			setAlert("error","该条记录已经是启用状态");
		}else{
			$.ajax({
				url:contextPath+"/user/startUser.do",
				type:"post",
				data:{
					uid:carrentItem[0].uid
				},
				success:function(data) {			
		            $('#tb_userManger').bootstrapTable('refresh', {url: 'query.do'});			
					setAlert(data.msg,"启用成功");

				}
			});
		}
	}else{
		setAlert("error","请先选择一条数据");
	}
}
//自己修改
function closeModal() {
	$("#addUname").val("");
	$("#addPass").val("");
	$("#addEmployId").val("");
	$("#addName").val("");
	$("#addPhoneNum").val("");
	$("#addStaff_id").val("");
	$("#updateStaff_id").val("");
	$("#user_id").val("");
	$("#userHouse_op").val("");
	$("#user_op").val("");	
	$("#updateUname").val("");
	$("#updatePass").val("");
	$("#updateEmployId").val("");
	$("#updateName").val("");
	$("#updatePhoneNum").val("");
	$("#updateUserHouse_op").val("");
	$("#updateUser_op").val("");
	$("#addUname_message").html(" ");
	$("#addPass_message").html(" ");
	$("#addName_message").html(" ");
	$("#addEmployId_message").html(" ");
	$("#addPhoneNum_message").html(" ");
	$("#userHouse_op_message").html(" ");
	$("#user_op_message").html(" ");
	$("#updateUname_message").html("");
	$("#updatePass_message").html(" ");
	$("#updateEmployId_message").html(" ");
	$("#updateName_message").html(" ");
	$("#updatePhoneNum_message").html(" ");
	$("#updateUserHouse_op_message").html(" ");
	$("#updateUser_op_message").html(" ");
	$("#emp_message").val("");
	$("#emp_footer_message").val("");

}
//显示角色
function showRole(){
	$('#tb_userManger').bootstrapTable('refresh', {url: 'query.do'});

	$("#addUname").val('');
	$("#addPass").val('');

	$("#addEmployId").click(function(){
		$('#empModal').modal('show');
	});

	//显示角色
	$.ajax({
		url:contextPath+"/user/showRole.do",
		type:"post",
		dataType:'json', 
		success:function(data) {		
			 //增加角色下拉框
			 $("#user_op").html("");
			 var $add=$("#user_op");
			     $add.append("<option value=''>-请选择一个角色-</option>");
			 for (var i=0;i<data.total;i++){
				 $add.append("<option value='"+data.rows[i].r_id+"'>"+data.rows[i].r_name+"</option>");			 
			 }
			  //角色动态显示		
			    $("#user_op").change(	
					function() {	
						if($("#user_op option:selected").val()!=''){                   
						   	 $("#user_op_message").html('');
		                   }else{     
		               	   	$("#user_op_message").html("必选项！");
		                   }
						
					
					});


			//显示养老院
			$.ajax({
				url:contextPath+"/nursing/queryAllFNursing.do",
				type:"post",
				dataType:'json',
				success:function(data) {
					console.log();
					//增加角色下拉框
					$("#userHouse_op").html("");
					var $add=$("#userHouse_op");
					$add.append("<option value=''>-请选择一个养老院-</option>");
					for (var i=0;i<data.total;i++){
						$add.append("<option value='"+data.rows[i].fID+"'>"+data.rows[i].fNursingName+"</option>");
					}

					//养老院动态显示
					$("#userHouse_op").change(
						function() {
							if($("#userHouse_op option:selected").val()!=''){
								$("#userHouse_op_message").html('');
							}else{
								$("#userHouse_op_message").html("必选项！");
							}


						});


				}




			});
			 
		}
	
	    
	
	
	});



}
//页面回显示
function gotoUpdate(){
   var bool="";
	$("#updateEmployId").click(function(){
		$('#empUpdateModal').modal('show');
	});
	var carrentItem = $("#tb_userManger").bootstrapTable('getSelections');
	if(carrentItem[0]){
		if( carrentItem[0].state=="<span style='color:red'>已禁用</span>"){
			setAlert("error", "该条记录无法修改");
		}else{

			var ss="<span style='color:red'>(部门经理)</span>";
			str=carrentItem[0].name.replace(ss,"");
			$('#user_id').val(carrentItem[0].uid);
			$("#updateUname").val(carrentItem[0].uname);
			$("#updatePass").val(carrentItem[0].passWord);
			$("#updatePhoneNum").val(carrentItem[0].phoneNum);
			$("#updateName").val(str);
			$("#updateEmployId").val(carrentItem[0].fStaffName);
			$("#updateStaff_id").val(carrentItem[0].employId);
			//页面回显  角色
			$.ajax({
				url:contextPath+"/user/showRole.do",
				type:"post",
				dataType:'json',
				success:function(data) {

					for (var i=0;i<data.total;i++){
                      if(data.rows[i].r_name==carrentItem[0].roleName){
                        bool=true;
					  }
					}
					$("#updateUser_op").html("");

					//已经被禁用
					if(bool==''){
						var $update=$("#updateUser_op");
						$update.append("<option value='"+carrentItem[0].roleId+"' selected='selected' >"+carrentItem[0].roleName+"</option>");
						for (var i=0;i<data.total;i++){

								$update.append("<option value='"+data.rows[i].r_id+"'>"+data.rows[i].r_name+"</option>");

							}

					}

					//未被禁用
					if(bool==true){
						var $update=$("#updateUser_op");
						for (var i=0;i<data.total;i++){
							if(data.rows[i].r_name==carrentItem[0].roleName){
								$update.append("<option value='"+data.rows[i].r_id+"' selected='selected' >"+data.rows[i].r_name+"</option>");
							}else{
								$update.append("<option value='"+data.rows[i].r_id+"'>"+data.rows[i].r_name+"</option>");

							}
						}
					}

					//页面回显示
					$.ajax({
						url:contextPath+"/nursing/queryAllFNursing.do",
						type:"post",
						dataType:'json',
						success:function(data) {
							console.log(data);

							//增加角色下拉框
							$("#updateUserHouse_op").html("");
							var $update=$("#updateUserHouse_op");
							for (var i=0;i<data.total;i++){
								if(data.rows[i].fNursingName==carrentItem[0].oldhouse){

									$update.append("<option value='"+data.rows[i].fID+"' selected='selected' >"+data.rows[i].fNursingName+"</option>");
								}else{
									$update.append("<option value='"+data.rows[i].fID+"'>"+data.rows[i].fNursingName+"</option>");
								}
							}
						}
					});
				}
			});
			$("#update_btn").click();
		}

	}else{
		setAlert("error","请先选择一条数据");
	}
}


