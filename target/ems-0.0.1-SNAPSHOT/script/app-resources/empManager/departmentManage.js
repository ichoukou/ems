$(function () {
	 //1.初始化Table
	 var oTable = new TableInit();
	 oTable.Init();
});

var TableInit = function () {
 var oTableInit = new Object();
 //初始化Table
 oTableInit.Init = function () {
  $('#tb_departmentManager').bootstrapTable({
	  url: 'query.do',   //请求后台的URL（*）
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
	   height: 600,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
	   uniqueId: "ID",      //每一行的唯一标识，一般为主键列
	   showToggle:true,     //是否显示详细视图和列表视图的切换按钮
	   cardView: false,     //是否显示详细视图
      detailView: true,     //是否显示父子表
   columns: [{
    radio: true
   }, {
    field: 'fDepartmentName',
    title: '部门名称',
    align: 'center',
       formatter:function(value,row,index){

          return value+ "<input type='hidden' value="+row.fid+">";
       }
   }, {
    field: 'fHigherUpID',
    title: '上级部门',
    align: 'center',    
    formatter:function(value,row,index){
    	
    	if(value=='0'){
    	
    		return "";
    	}else{
    		return value;
    	}
    	
    	
    }
    
   }, {
    field: 'fDepartmentAttrbute',
    title: '属性',
    align: 'center',   
   } , {
	field: 'fSortNumber',
	title: '排班',
	  align: 'center',   
    formatter:function(value,row,index){
    	if(value=='Y'){
    		return "是";
    	}else{
    		return "否";
    	}
    }
   }, {
	   
	field: 'fParameter',
	 title: '指定老人' ,
	  align: 'center',   
	formatter:function(value,row,index){
		if(value=='Y'){
    		return "是";
    	}else{
    		return "否";
    	}	
		    }		 
    },  {
	 field: 'fPortalType',
	 title: '排房',
	  align: 'center',   
    formatter:function(value,row,index){
    	if(value=='Y'){
    		return "是";
    	}else{
    		return "否";
    	}
    }
	 }  
   
   ],
   //加载字表
   onExpandRow: function (index, row, $detail) {
	 
	      abc(index, row, $detail);
   },


	  });
 };
 
 //定义加载字表的函数
 
 function abc (index, row, $detail) {


	    var cur_table = $detail.html('<table></table>').find('table');
        cur_table.bootstrapTable({

            url: 'querySon.do',
            method: 'get',       
            queryParams: { strParentID: row.fid},
            ajaxOptions: { strParentID: row.fid },
            clickToSelect: true,
            striped: true,      //是否显示行间隔色
     	    cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            striped: true,      //是否显示行间隔色
            detailView: true,//父子表
            uniqueId: "MENU_ID",
            pageSize: 10,
            pageList: [10, 25],
            showHeader:true,    //不显示标题
            cardView: false,     //是否显示详细视图          
            columns: [{
                radio: true
               }, {
                field: 'fDepartmentName',
                title: '部门名称',
                align: 'center',  
                formatter:function(value,row,index){

                	return value+ "<input type='hidden' value="+row.fid+">";
                	
                }
               }, {
                field: 'father',
                title: '上级部门',
                align: 'center',    
                formatter:function(value,row,index){
                	
                	if(value=='0'){
               
                		return "";
                	}else{
                		return value;
                	}
                	
                	
                }
                
               }, {
                field: 'fDepartmentAttrbute',
                title: '属性',
                align: 'center',   
               } , {
            	field: 'fSortNumber',
            	title: '排班',
            	  align: 'center',   
                formatter:function(value,row,index){
                	if(value=='Y'){
                		return "是";
                	}else{
                		return "否";
                	}
                }
               }, {
            	   
            	field: 'fParameter',
            	 title: '指定老人' ,
            	  align: 'center',   
            	formatter:function(value,row,index){
            		if(value=='Y'){
                		return "是";
                	}else{
                		return "否";
                	}	
            		    }		 
                },  {
            	 field: 'fPortalType',
            	 title: '排房',
            	  align: 'center',   
                formatter:function(value,row,index){
                	if(value=='Y'){
                		return "是";
                	}else{
                		return "否";
                	}
                }
            	 }  
               
               ],                
               onExpandRow: function (index, row, $detail) {
                  abc(index, row, $detail);
               },  
               formatNoMatches: function () {  //没有匹配的结果  
            	    return '没有相应数据';  
               },  
            
              
         })
 }
 //得到查询的参数
 oTableInit.queryParams = function (params) {
  var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
/*	   pageSize: params.limit, //页面大小
	   page: params.offset + 1, //页码
*/	
  };
  return temp;
 };
 return oTableInit;
};

//显示员工信息下拉框
function showDepartment(){
	$(":checkbox").removeAttr("checked");
	$("input[type='radio']").removeAttr('checked');	
	$.ajax({
		url:contextPath+"/depart/showDepartment.do",
		type:"post",
		dataType:'json',
		data:{
			fid:0,
		},
		success:function(data) {

			 //增加等级下拉框
			 $("#addfHigherUpID").html("");
			 var $add=$("#addfHigherUpID");
			     $add.append("<option value='0'></option>");
			 for (var i=0;i<data.total;i++){
				 $add.append("<option value='"+data.rows[i].fid+"'>"+data.rows[i].fDepartmentName+"</option>");			 
			 }	
		}
	});
	
	
	
}

//新增部门
function addDepartmentManager(){

    var add=$("#addfDepartmentName").val().trim();
    $("#addfDepartmentName_message").html("");
    if(add==null||add.length==0||add==''){
        $("#addfDepartmentName_message").html("不能为空！");
    }else{
        if($("input[type='radio'][name='fDepartmentAttrbute']:checked").val()==undefined){
            $("#addfDepartmentAttrbute_message").html("");
            $("#addfDepartmentAttrbute_message").html("必选！");

        }else{
            $("#addfDepartmentAttrbute_message").html("");

    /*        //增加部门
            console.log("------------");
            console.log( $("input[type='radio'][name='fDepartmentAttrbute']:checked").val());

            console.log("------------");
            console.log($("input[type='checkbox'][name='fSortNumber']").is(':checked'));
            console.log($("input[type='checkbox'][name='fParameter']").is(':checked'));
            console.log($("input[type='checkbox'][name='fPortalType']").is(':checked'));
            console.log($("input[type='checkbox'][name='fSortNumber']").is(':checked')?'Y':'N');//是否排班
            console.log($("input[type='checkbox'][name='fParameter']").is(':checked')?'Y':'N');//是否排人
            console.log($("input[type='checkbox'][name='fPortalType']").is(':checked')?'Y':'N');//是否排房

            console.log($("input[type='checkbox'][name='fSortNumber']").is(':checked')?'Y':'N');//是否排班
            console.log($("input[type='checkbox'][name='fParameter']").is(':checked')?'Y':'N');//是否排人
            console.log($("input[type='checkbox'][name='fPortalType']").is(':checked')?'Y':'N');//是否排房*/

             $.ajax({
             url:contextPath+"/depart/addDepartment.do",
             type:"post",
             data:{
             fDepartmentName:$("#addfDepartmentName").val(),
             fDepartmentAttrbute:$("input[type='radio'][name='fDepartmentAttrbute']:checked").val(),
             fHigherUpID:$("#addfHigherUpID option:selected").val(),
             fSortNumber:$("input[type='checkbox'][name='fSortNumber']").is(':checked')?'Y':'N',//是否排班
             fParameter:$("input[type='checkbox'][name='fParameter']").is(':checked')?'Y':'N',//是否排人
             fPortalType:$("input[type='checkbox'][name='fPortalType']").is(':checked')?'Y':'N',//是否排房
             },
             success:function(data) {

             if (!data.success) {
             $("#addfDepartmentName_message").html("该名称已存在！");
             }
             else {
             $("#addfDepartmentName_message").html("");
             $('#tb_departmentManager').bootstrapTable('refresh', {url: 'query.do'});
             setAlert(data.message,"添加操作成功");
             $("#add_emp1").click();
             closeModal();
             }


             }
             });
        }

    }




}
//修改部门
function updateDepartmentManager(){


      var add=$("#updatefDepartmentName").val().trim();
       $("#updatefDepartmentName_message").html("");
       if(add==null||add.length==0||add==''){
           $("#updatefDepartmentName_message").html("不能为空！");
       }else {
/*           console.log( $("input[type='radio'][name='updatefDepartmentAttrbute']:checked").val());
           console.log("------------");
           console.log($("input[type='checkbox'][name='updatefSortNumber']").is(':checked'));
           console.log($("input[type='checkbox'][name='updatefParameter']").is(':checked'));
           console.log($("input[type='checkbox'][name='updatefPortalType']").is(':checked'));
           console.log($("input[type='checkbox'][name='updatefSortNumber']").is(':checked')?'Y':'N');//是否排班
           console.log($("input[type='checkbox'][name='updatefParameter']").is(':checked')?'Y':'N');//是否排人
           console.log($("input[type='checkbox'][name='updatefPortalType']").is(':checked')?'Y':'N');//是否排房*/



                      $.ajax({
                          url: contextPath + "/depart/updateDepartment.do",
                          type: "post",
                          data: {
                              fid: $("#updatefid").val(),
                              fDepartmentName: $("#updatefDepartmentName").val(),
                              fDepartmentAttrbute: $("input[type='radio'][name='updatefDepartmentAttrbute']:checked").val(),
                              fHigherUpID: $("#updatefHigherUpID option:selected").val(),
                              fPortalType: $("input[type='checkbox'][name='updatefPortalType']").is(':checked') ? 'Y' : 'N', //是否排房
                              fSortNumber: $("input[type='checkbox'][name='updatefSortNumber']").is(':checked') ? 'Y' : 'N',//是否排班
                              fParameter: $("input[type='checkbox'][name='updatefParameter']").is(':checked') ? 'Y' : 'N',//是否排人

                          },
                          success: function (data) {
                              if (!data.success) {
                                  $("#updatefDepartmentName_message").html("该名称已存在！");
                              }
                              else {

                                  $("#updatefDepartmentName_message").html("");
                                  $("#update_emp1").click();
                                  $('#tb_departmentManager').bootstrapTable('refresh', {url: 'query.do'});
                                  setAlert(data.message, "更新操作成功");
                                  closeModal();


                              }


                          }
                      });
       }

}

//部门删除
function gotoDelete(){
	var tr=$("input[type='radio'][name='btSelectItem']:checked").closest('tr').html();
	
	

	var dfid=$("input[type='radio'][name='btSelectItem']:checked").closest('tr').children('td').eq(2).find("input[type='hidden']").val();
	
	
	if(tr!=undefined){


        //进行查询

        $.ajax({
            url:contextPath+"/depart/deleteBefore.do",
            type:"post",
            data:{
                fid:dfid,

            },
            success:function(data) {
                console.log("打印一下是什么")
                console.log(data)
                if (!data.success) {
                    //代表不能删除
                    setAlert("error","该部门已经被占用，不能删除");
                }
                else {
                    $.ajax({
                        url:contextPath+"/depart/deleteDepartment.do",
                        type:"post",
                        data:{
                            fid:dfid,

                        },
                        success:function(data) {
                            console.log("");
                            if (!data.success) {
                                setAlert("error","含有子分类，无法删除！");
                            }
                            else {
                                setAlert(data.msg,"删除操作成功");
                                $('#tb_departmentManager').bootstrapTable('refresh', {url: 'query.do'});
                            }
                        }
                    });
                }
            }
        });


	}else{
		setAlert("error","请先选择一条数据");
	}
}

function closeModal() {
    $("#updatefid").val('');
	$("#updatefHigherUpID").val('');	
	$("#addfDepartmentAttrbute").val('');
	$("#addfDepartmentName").val('');
	$("#addfDepartmentName_message").html("");
    $("#addfDepartmentAttrbute_message").html("");
    $("#updatefDepartmentName_message").html("");


}
//单独验证 更新
function updateEmp_check(){
	var add=$("#updatefDepartmentName").val().trim();
	$("#updatefDepartmentName_message").html("");
	if(add==null||add.length==0||add==''){
		$("#updatefDepartmentName_message").html("不能为空！");
	}else{
		//ajax:验证
		$.ajax({
			url: contextPath + "/depart/UpdateEmp_check.do",
			type: "post",
			data: {
				fDepartmentName: add,
				fid :$("#updatefid").val()
			},
			success: function (data) {
				if (!data.success) {
					$("#updatefDepartmentName_message").html("该名称已存在！");
				}
				else {
					$("#updatefDepartmentName_message").html("");
				}
			}
		})
	}
}
//单独验证 增加
function addEmp_check(){
	var add=$("#addfDepartmentName").val().trim();
	$("#addfDepartmentName_message").html("");
	if(add==null||add.length==0||add==''){
		$("#addfDepartmentName_message").html("不能为空！");
	}else{
		//ajax:验证
		$.ajax({
			url: contextPath + "/depart/addEmp_check.do",
			type: "post",
			data: {
				fDepartmentName: add,
			},
			success: function (data) {
				if (!data.success) {
					$("#addfDepartmentName_message").html("该名称已存在！");
				}
				else {
					$("#addfDepartmentName_message").html("");
				}
			}
		})
	}

}
//页面回显数据
function gotoUpdate(){
      //清空上一次记录
/*	$("input[type='checkbox'][name='fParameter']").prop("checked",false);
	$("input[type='checkbox'][name='fPortalType']") .prop("checked",false);
	$("input[type='checkbox'][name='fSortNumber']").prop("checked",false);*/
	var tr=$("input[type='radio'][name='btSelectItem']:checked").closest('tr').html();

        if(tr!=undefined){//只要被选中 就进入

            var DepartmentName=$("input[type='radio'][name='btSelectItem']:checked").closest('tr').children('td').eq(2).text();

            var fid=$("input[type='radio'][name='btSelectItem']:checked").closest('tr').children('td').eq(2).find("input[type='hidden']").val();

            var high=$("input[type='radio'][name='btSelectItem']:checked").closest('tr').children('td').eq(3).text();

            var  attr=$("input[type='radio'][name='btSelectItem']:checked").closest('tr').children('td').eq(4).text();

            var SortNumber=$("input[type='radio'][name='btSelectItem']:checked").closest('tr').children('td').eq(5).text();

            var Parameter=$("input[type='radio'][name='btSelectItem']:checked").closest('tr').children('td').eq(6).text();

            var PortalType=$("input[type='radio'][name='btSelectItem']:checked").closest('tr').children('td').eq(7).text();


               $("#updatefid").val(fid);
               $("#updatefDepartmentName").val(DepartmentName);

               $("input[type='radio'][value='"+attr+"']").prop("checked",'true');
            //是否排班
            if(SortNumber=='是'){
                $("input[type='checkbox'][name='updatefSortNumber']").prop("checked",true);
            }else{
                $("input[type='checkbox'][name='updatefSortNumber']").prop("checked",false);
            };
            //是否排人
                if(Parameter=='是'){
                    $("input[type='checkbox'][name='updatefParameter']").prop("checked",true);
                }else{
					$("input[type='checkbox'][name='updatefParameter']").prop("checked",false);
				};
            //是否排房
              if(PortalType=='是'){
                     $("input[type='checkbox'][name='updatefPortalType']") .prop("checked",true);
                 }else{
				  $("input[type='checkbox'][name='updatefPortalType']") .prop("checked",false);
			  };

       $.ajax({
            url:contextPath+"/depart/showDepartment.do",
            type:"post",
            dataType:'json',
            data:{
                fid:$("#updatefid").val(),//传入后端一个id
            },
            success:function(data) {
                //增加等级下拉框
         $("#updatefHigherUpID").html("");
         var $update=$("#updatefHigherUpID");
        if(high==''){
         $update.append("<option value='0' selected='selected' ></option>");

        }
            for (var i=0;i<data.total;i++){
            if((data.rows[i].fDepartmentName.split("▶")[1]!=undefined&&data.rows[i].fDepartmentName.split("▶")[1]==high)||(data.rows[i].fDepartmentName.split("▶")[1]==undefined &&data.rows[i].fDepartmentName.split("▶")[0]==high)){
                    $update.append("<option value='"+data.rows[i].fid+"' selected='selected' >"+data.rows[i].fDepartmentName+"</option>");
                }else if(i==data.total-1){

                    $update.append("<option value='"+data.rows[i].fid+"'>"+data.rows[i].fDepartmentName+"</option><option value='0'></option>");

                }else{
                    $update.append("<option value='"+data.rows[i].fid+"'>"+data.rows[i].fDepartmentName+"</option>");

                }


            }
        }



        });
        $("#update_btn").click();


    }else{
			setAlert("error","请先选择一条数据");
    }
}
