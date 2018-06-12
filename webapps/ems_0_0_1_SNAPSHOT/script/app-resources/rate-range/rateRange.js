$(function () {
	 //1.初始化Table
	 var oTable = new TableInit();
	 oTable.Init();
});

var TableInit = function () {
 var oTableInit = new Object();
 //初始化Table
 oTableInit.Init = function () {
  $('#tb_rateRange').bootstrapTable({
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
   pageList: [2, 5, 50, 100],  //可供选择的每页的行数（*）
   search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
   strictSearch: true,
   showColumns: true,     //是否显示所有的列
   showRefresh: true,     //是否显示刷新按钮
   minimumCountColumns: 2,    //最少允许的列数
   clickToSelect: true,    //是否启用点击选中行
   height: 350,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
   uniqueId: "ID",      //每一行的唯一标识，一般为主键列
   showToggle:true,     //是否显示详细视图和列表视图的切换按钮
   cardView: false,     //是否显示详细视图
   detailView: false,     //是否显示父子表
   columns: [{
    radio: true
   }, {
    field: 'fLevelID',
    title: '编号'
   }, {
    field: 'clevelName',
    title: '项目等级'
   }, {
    field: 'high',
    title: '分值上限'
   } , {
    field: 'low',
    title: '分值下限'
   } , {
    field: 'desc',
    title: '说明'
   } ]
  });
 };
 //得到查询的参数
 oTableInit.queryParams = function (params) {
  var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
	   pageSize: params.limit, //页面大小
	   page: params.offset , //页码
      clevelName: $("#searchName").val(),

  };
  return temp;
 };
 return oTableInit;
};

var fidata="";
var fidlength="";
var a=[];
var b=[];
var c='';
var d='';
//查询评估等级范围  
function queryRange(){

	     clevelName=$("#searchName").val(),

		$("#tb_rateRange").bootstrapTable('selectPage',1);

}

//清空
function clearaSelect(){
	$("#searchName").val("");
}

//新增评估等级范围  
function addRange(){

	if($("#addHigh option:selected").text()=='选择一个最高分'||$("#addLow option:selected").text()=='选择一个最低分'||$("#addClevelName option:selected").text()=='选择一个项目等级'){
		alert('请做出选择');
	}else{

	$.ajax({
		url:contextPath+"/rate/addRange.do",
		type:"post",
		data:{
			fLevelID:$("#addClevelName option:selected").val(),
			clevelName:$("#addClevelName option:selected").text(),
			high:$("#addHigh option:selected").text(),
			low:$("#addLow option:selected").text(),
			desc:$("#addDesc").val()
		},
		success:function(data) {
            $('#tb_rateRange').bootstrapTable('refresh', {url: 'query.do'});
            setAlert(data.message,"操作成功");
			//closeModal();


		}
	});
	}

	closeModal();
}


//修改评估等级范围  
function updateRange(){

	$.ajax({
		url:contextPath+"/rate/updateRange.do",
		type:"post",
		data:{
			clevelId:$("#updateClevelId").val(),
			fLevelID:$("#updateClevelName option:selected").val(),
			clevelName:$("#updateClevelName option:selected").text(),
			high:$("#updateHigh option:selected").text(),
			low:$("#updateLow option:selected").text(),
			desc:$("#updateDesc").val(),
		},
		success:function(data) {
            $('#tb_rateRange').bootstrapTable('refresh', {url: 'query.do'});
			setAlert(data.message,"操作成功");
		}
	});
	closeModal();
}

//评估等级范围  删除
function gotoDelete(){
	var carrentItem = $("#tb_rateRange").bootstrapTable('getSelections');
	if(carrentItem[0]){
		$.ajax({
			url:contextPath+"/rate/deleteRange.do",
			type:"post",
			data:{
				clevelId:carrentItem[0].fLevelID
				
			},
			success:function(data) {
                $('#tb_rateRange').bootstrapTable('refresh', {url: 'query.do'});


				if(data.success){
					setAlert(data.msg,"操作成功");
				}else{
					
				}
			}
		});
	}else{
		setAlert("error","请先选择一条数据");
	}
}

function showName(){
	$.ajax({
		url:contextPath+"/rate/showName.do",
		type:"post",
		dataType:'json', 
		success:function(data) {
                console.log(data);
            //查询可以分配的等级
            $.ajax({
                url:contextPath+"/rate/showFLevelID.do",
                type:"post",
                dataType:'json',
                success:function(data1) {
                    console.log(data1);


                    fidata=data1.rows;
                    fidlength=data1.total;


                    for(var i=0;i<data.total;i++){
                        a[i]=data.rows[i].DC_ID;
                    }
                    for(var i=0;i<fidlength;i++){
                        b[i]=fidata[i].FLevelID;
                    }
                    c= Array.intersect(a,b);
                    //没有被选中的
                     d=Array.complement(a,b);

                    //增加等级下拉框
                    $("#addClevelName").html("");
                    var $add=$("#addClevelName");
                    $add.append("<option value=''>选择一个项目等级</option>");

                    for (var i=0;i<data.total;i++) {
                        for (var j = 0; j < d.length; j++) {
                            if (data.rows[i].DC_ID == d[j]) {
                                $add.append("<option value='" + data.rows[i].DC_ID + "'  >" + data.rows[i].DC_VALUE + "</option>");
                            }
                        }
                    }
                    for (var i=0;i<data.total;i++) {
                        for (var j = 0; j < fidlength; j++) {
                            if (data.rows[i].DC_ID == fidata[j].FLevelID) {
                                $add.append("<option value='" + data.rows[i].DC_ID + "' disabled='disabled' style='background:#BDBE9E' >" + data.rows[i].DC_VALUE + "</option>");
                            }
                        }
                    }

                    //增加分数上限下拉框
                    $("#addHigh").html("");
                    var $add=$("#addHigh");
                    $add.append("<option value=''>选择一个最高分</option>");
                    for (var i=0;i<=100;i++){
                            $add.append("<option value='"+i+"'>"+i+"</option>");
                    }

                    //增加分数下限下拉框
                    $("#addLow").html("");
                    var $add=$("#addLow");
                    $add.append("<option value=''>选择一个最低分</option>");
                    for (var i=0;i<=100;i++){
                            $add.append("<option value='"+i+"'>"+i+"</option>");
                    }
                     //将已经存在的禁用
                    for(var i=0;i<fidlength;i++){
                        for(var j=fidata[i].FLevel_Low;j<=fidata[i].FLevel_High;j++){

                            $("#addHigh option").each(function(){

                                if($(this).val()!=''){
                                    if(parseInt($(this).val())==parseInt(j)){
                                        $(this).prop('disabled','true');
                                        $(this).css("background-color","#C2C2C2");
                                    }
                                }

                            });
                            $("#addLow option").each(function(){

                                if($(this).val()!=''){
                                    if(parseInt($(this).val())==parseInt(j)){
                                        $(this).prop('disabled','true');
                                        $(this).css("background-color","#C2C2C2");
                                    }
                                }
                            });


                        }
                    }

                    //分数上限变化 下限跟着变化
                    $("#addHigh").change(function (){

                        //如果点击请选择最高分 全部还原 移除灰色
                        if($("#addHigh option:selected").val()==''){
                            $("#addLow option").each(function(){
                                if($(this).css("background-color")=='rgb(189, 190, 158)'){
                                    $(this).removeAttr('disabled');
                                    $(this).css("background-color",'');
                                }
                            });

                            changeLowMethod();

                        }else{
                            $("#addLow option").each(function(){

                                if($(this).css("background-color")=='rgb(189, 190, 158)'){
                                    $(this).removeAttr('disabled');
                                    $(this).css("background-color",'');
                                }

                                /*
                                 1
                                 rateRange.js:265 rgb(189, 190, 158)
                                 rateRange.js:266 true*/

                                /*6
                                 rateRange.js:265 rgb(25, 185, 9)
                                 rateRange.js:266 false
                                 rateRange.js:267 true*/

                            });
                            changeLowMethod();
                        }

                    });
                    //分数下限变化 上限跟着变化
                    $("#addLow").change(function (){
                        if($("#addLow option:selected").val()==''){
                            $("#addHigh option").each(function(){

                                if($(this).css("background-color")=='rgb(189, 190, 158)'){
                                    $(this).removeAttr('disabled');
                                    $(this).css("background-color",'');
                                }

                                /*
                                 1
                                 rateRange.js:265 rgb(189, 190, 158)
                                 rateRange.js:266 true*/

                                /*6
                                 rateRange.js:265 rgb(25, 185, 9)
                                 rateRange.js:266 false
                                 rateRange.js:267 true*/

                            });

                            changeHighMethod();
                        }else{
                            $("#addHigh option").each(function(){
                                if($(this).css("background-color")=='rgb(189, 190, 158)'){
                                    $(this).removeAttr('disabled');
                                    $(this).css("background-color",'');
                                }
                            })
                            changeHighMethod();

                        }

                    });



                }
            })



		}
	});

	
	
}


function closeModal() {
	$("#addClevelId").val("");
	$("#addClevelName").val("");
	$("#addHigh").val("");
	$("#addLow").val("");
	$("#addDesc").val("");
	$("#updateClevelId").val("");
	$("#updateClevelName").val("");
	$("#updateHigh").val("");
	$("#updateLow").val("");
	$("#updateDesc").val("");
}

//页面回显数据
function gotoUpdate(){
	var carrentItem = $("#tb_rateRange").bootstrapTable('getSelections');
	if(carrentItem[0]){
		$("#updateClevelId").val(carrentItem[0].fLevelID);
		$("#updateDesc").val(carrentItem[0].desc);
	
		$.ajax({
			url:contextPath+"/rate/showName.do",
			type:"post",
			dataType:'json', 
			success:function(data) {


                //  #C2C2C2   #19B909

                //查询可以分配的等级
                $.ajax({
                    url:contextPath+"/rate/showFLevelID.do",
                    type:"post",
                    dataType:'json',
                    success:function(data1) {

                        fidata=data1.rows;
                        fidlength=data1.total;


                        for(var i=0;i<data.total;i++){
                            a[i]=data.rows[i].DC_ID;
                        }
                        for(var i=0;i<fidlength;i++){
                            b[i]=fidata[i].FLevelID;
                        }
                        var c= Array.intersect(a,b);
                        //没有被选中的
                        var d=Array.complement(a,b);

                        //增加等级下拉框
                        $("#updateClevelName").html("");
                        var $add=$("#updateClevelName");
                        $add.append("<option value=''>选择一个项目等级</option>");

                        for (var i=0;i<data.total;i++) {
                            for (var j = 0; j < d.length; j++) {
                                if (data.rows[i].DC_ID == d[j]) {
                                    $add.append("<option value='" + data.rows[i].DC_ID + "'  >" + data.rows[i].DC_VALUE + "</option>");
                                }
                            }
                        }
                        for (var i=0;i<data.total;i++) {
                            for (var j = 0; j < fidlength; j++) {


                                    if (data.rows[i].DC_ID == fidata[j].FLevelID) {
                                        if(data.rows[i].DC_VALUE==carrentItem[0].clevelName) {
                                            $add.append("<option value='" + data.rows[i].DC_ID + "' selected='selected' style='background:#BDBE9E' >" + data.rows[i].DC_VALUE + "</option>");

                                        }else{
                                            $add.append("<option value='" + data.rows[i].DC_ID + "' disabled='disabled' style='background:#BDBE9E' >" + data.rows[i].DC_VALUE + "</option>");

                                        }
                                }
                            }
                        }

                        //增加分数上限下拉框
                        $("#updateHigh").html("");
                        var $add=$("#updateHigh");
                        $add.append("<option value=''>选择一个最高分</option>");
                        for (var i=0;i<=100;i++){
                            $add.append("<option value='"+i+"'>"+i+"</option>");
                        }

                        //增加分数下限下拉框
                        $("#updateLow").html("");
                        var $add=$("#updateLow");
                        $add.append("<option value=''>选择一个最低分</option>");
                        for (var i=0;i<=100;i++){
                            $add.append("<option value='"+i+"'>"+i+"</option>");
                        }
                        //将已经存在的禁用
                        for(var i=0;i<fidlength;i++){
                            for(var j=fidata[i].FLevel_Low;j<=fidata[i].FLevel_High;j++){

                                $("#updateHigh option").each(function(){

                                    if($(this).val()!=''){
                                        if(parseInt($(this).val())==parseInt(j)){
                                            $(this).prop('disabled','true');
                                            $(this).css("background-color","#C2C2C2");
                                            if(parseInt(carrentItem[0].high)==parseInt($(this).val())){
                                                   $(this).removeClass('disabled');
                                                   $(this).prop("selected",'true');

                                               }
                                        }

                                    }

                                });
                                $("#updateLow option").each(function(){

                                    if($(this).val()!=''){
                                        if(parseInt($(this).val())==parseInt(j)){
                                            $(this).prop('disabled','true');
                                            $(this).css("background-color","#C2C2C2");
                                            if(parseInt(carrentItem[0].low)==parseInt($(this).val())){
                                                $(this).removeClass('disabled');
                                                $(this).prop("selected",'true');

                                            }
                                        }
                                    }
                                });


                            }
                        }

                        //分数上限变化 下限跟着变化
                        $("#updateHigh").change(function (){

                            //如果点击请选择最高分 全部还原 移除灰色
                            if($("#updateHigh option:selected").val()==''){
                                $("#updateLow option").each(function(){
                                    if($(this).css("background-color")=='rgb(189, 190, 158)'){
                                        $(this).removeAttr('disabled');
                                        $(this).css("background-color",'');
                                    }
                                });

                                changeUpdateLowMethod();

                            }else{
                                $("#updateLow option").each(function(){

                                    if($(this).css("background-color")=='rgb(189, 190, 158)'){
                                        $(this).removeAttr('disabled');
                                        $(this).css("background-color",'');
                                    }

                                    /*
                                     1
                                     rateRange.js:265 rgb(189, 190, 158)
                                     rateRange.js:266 true*/

                                    /*6
                                     rateRange.js:265 rgb(25, 185, 9)
                                     rateRange.js:266 false
                                     rateRange.js:267 true*/

                                });
                                changeUpdateLowMethod();
                            }

                        });
                        //分数下限变化 上限跟着变化
                        $("#updateLow").change(function (){
                            if($("#updateLow option:selected").val()==''){
                                $("#updateHigh option").each(function(){

                                    if($(this).css("background-color")=='rgb(189, 190, 158)'){
                                        $(this).removeAttr('disabled');
                                        $(this).css("background-color",'');
                                    }

                                    /*
                                     1
                                     rateRange.js:265 rgb(189, 190, 158)
                                     rateRange.js:266 true*/

                                    /*6
                                     rateRange.js:265 rgb(25, 185, 9)
                                     rateRange.js:266 false
                                     rateRange.js:267 true*/

                                });
                                changeUpdateHighMethod();
                            }else{
                                $("#updateHigh option").each(function(){
                                    if($(this).css("background-color")=='rgb(189, 190, 158)'){
                                        $(this).removeAttr('disabled');
                                        $(this).css("background-color",'');
                                    }
                                })
                                changeUpdateHighMethod();

                            }

                        });



                    }
                })
		
	/*	//增加等级下拉框
		 $("#updateClevelName").html("");
		 var $update=$("#updateClevelName");

		 for (var i=0;i<data.total;i++){
			 if(data.rows[i].DC_VALUE==carrentItem[0].clevelName){
                 $update.append("<option value='"+data.rows[i].DC_ID+"' selected='selected'>"+data.rows[i].DC_VALUE+"</option>");
             }else{
                 $update.append("<option value='"+data.rows[i].DC_ID+"'>"+data.rows[i].DC_VALUE+"</option>");
		 }
	  }

		 //增加分数上限下拉框
		 $("#updateHigh").html("");
		 var $update=$("#updateHigh");
                for (var i=0;i<=20;i++){
                    if(i==carrentItem[0].high){
                        $update.append("<option value='"+i+"' selected='selected'>"+i+"</option>");
                    }else{
                        $update.append("<option value='"+i+"'>"+i+"</option>");

                    }

                }

		 //增加分数下限下拉框
		 $("#updateLow").html("");
		 var $update=$("#updateLow");
		 for (var i=0;i<=20;i++){
             if(i==carrentItem[0].low){
                 $update.append("<option value='"+i+"' selected='selected'>"+i+"</option>");
             }else{
                 $update.append("<option value='"+i+"'>"+i+"</option>");

             }

		 }*/
			}
		
		})
		$("#update_btn").click();
	}else{
		setAlert("error","请先选择一条数据");
	}
}

$(document).ready(function(){
    //分数上限变化  下限跟着变化



});

//上面下拉框进行修改样式
function changeHighMethod(){
    var len = $("#addHigh option").length;

    //对指定的最低分上面进行禁用
    $("#addHigh option").each(function(){
        if($(this).val()!=''){
            if(parseInt($(this).val())<parseInt($("#addLow option:selected").val())&&!$(this).prop('disabled')){
             if(!$(this).prop('disabled')){
               $(this).prop('disabled','true');
               $(this).css("background-color","#BDBE9E");
              }
            }
        }
    });

    var  b=parseInt($("#addLow option:selected").val());

    //对指定的最低分下面进行禁用
    for(var i=b;i<len;i++){
        if($("#addHigh option[value='"+i+"']").prop("disabled")){
            //如果获取等于disabled第一处索引
            for(var j=i;j<len;j++){
                if(!$("#addHigh option[value='"+j+"']").prop("disabled")){
                    $("#addHigh option[value='"+j+"']").prop('disabled','true');
                    $("#addHigh option[value='"+j+"']").css("background-color","#BDBE9E");
                }
            }
            break;
        }
    }




}

//下面下拉框进行修改样式
function changeLowMethod(){
    var len = $("#addLow option").length;
    //对指定的最高分下面进行禁用
   $("#addLow option").each(function(){

        if($(this).val()!=''){
            if(parseInt($(this).val())>parseInt($("#addHigh option:selected").val())&&!$(this).prop('disabled')){
              $(this).prop('disabled','true');
              $(this).css("background-color","#BDBE9E");
          }
        }
    });
    var  b=parseInt($("#addHigh option:selected").val());

    //对指定的最高分上面进行禁用
    for(var i=b;i>=0;i--){
            if($("#addLow option[value='"+i+"']").prop("disabled")){
                //如果获取等于disabled第一处索引
                  for(var j=i;j>=0;j--){
                     if(!$("#addLow option[value='"+j+"']").prop("disabled")){
                         $("#addLow option[value='"+j+"']").prop('disabled','true');
                         $("#addLow option[value='"+j+"']").css("background-color","#BDBE9E");
                      }
                  }
                break;
            }
          }


}


function changeUpdateHighMethod(){
    var len = $("#updateHigh option").length;

    //对指定的最低分上面进行禁用
    $("#updateHigh option").each(function(){
        if($(this).val()!=''){
            if(parseInt($(this).val())<parseInt($("#updateLow option:selected").val())&&!$(this).prop('disabled')){
                if(!$(this).prop('disabled')){
                    $(this).prop('disabled','true');
                    $(this).css("background-color","#BDBE9E");
                }
            }
        }
    });

    var  b=parseInt($("#updateLow option:selected").val());

    //对指定的最低分下面进行禁用
    for(var i=b;i<len;i++){
        if($("#updateHigh option[value='"+i+"']").prop("disabled")){
            //如果获取等于disabled第一处索引
            for(var j=i;j<len;j++){
                if(!$("#updateHigh option[value='"+j+"']").prop("disabled")){
                    $("#updateHigh option[value='"+j+"']").prop('disabled','true');
                    $("#updateHigh option[value='"+j+"']").css("background-color","#BDBE9E");
                }
            }
            break;
        }
    }


}

function changeUpdateLowMethod(){
    var len = $("#updateLow option").length;
    //对指定的最高分下面进行禁用
    $("#updateLow option").each(function(){

        if($(this).val()!=''){
            if(parseInt($(this).val())>parseInt($("#updateHigh option:selected").val())&&!$(this).prop('disabled')){
                $(this).prop('disabled','true');
                $(this).css("background-color","#BDBE9E");
            }
        }
    });
    var  b=parseInt($("#updateHigh option:selected").val());

    //对指定的最高分上面进行禁用
    for(var i=b;i>=0;i--){
        if($("#updateLow option[value='"+i+"']").prop("disabled")){
            //如果获取等于disabled第一处索引
            for(var j=i;j>=0;j--){
                if(!$("#updateLow option[value='"+j+"']").prop("disabled")){
                    $("#updateLow option[value='"+j+"']").prop('disabled','true');
                    $("#updateLow option[value='"+j+"']").css("background-color","#BDBE9E");
                }
            }
            break;
        }
    }

}


//获取已经存在的项目类别
function queryFLevelID(){

};

//获得已经存在的项目分数
function  FilterData(a,b)
{   //循环判断数组a里的元素在b里面有没有，有的话就放入新建立的数组中
    var result = new Array();
    var c=b.toString();
    for(var i=0;i<a.length;i++)
    {
        if(c.indexOf(a[i].toString())>-1)
        {
            result.push(a[i]);
        }
    }
    return result;
}

Array.intersect = function(a, b){
    return a.uniquelize().each(function(o){return b.contains(o) ? o : null});
};
Array.complement = function(a, b){
    return Array.minus(Array.union(a, b),Array.intersect(a, b));
};
Array.prototype.uniquelize = function(){
    var ra = new Array();
    for(var i = 0; i < this.length; i ++){
        if(!ra.contains(this[i])){
            ra.push(this[i]);
        }

    }
    return ra;
};
Array.minus = function(a, b){
    return a.uniquelize().each(function(o){return b.contains(o) ? null : o});
};
Array.union = function(a, b){
    return a.concat(b).uniquelize();
};
Array.prototype.contains = function(obj) {
    var i = this.length;
    while (i--) {
        if (this[i] === obj) {
            return true;
        }
    }
    return false;
}
Array.prototype.each = function(fn){
    fn = fn || Function.K;
    var a = [];
    var args = Array.prototype.slice.call(arguments, 1);
    for(var i = 0; i < this.length; i++){
        var res = fn.apply(this,[this[i],i].concat(args));
        if(res != null) a.push(res);
    }
    return a;
};