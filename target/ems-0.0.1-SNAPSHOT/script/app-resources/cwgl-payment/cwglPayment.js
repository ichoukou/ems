/**
 * Created by wanjs on 2017/1/12.
 */
$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    var oTable2 = new TableInit2();
    oTable2.Init();
});

// 支出用途分类带子表
var TableInit2=function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_cwglPaymentOut').bootstrapTable({
            url: 'query.do',   //请求后台的URL（*）
            method: 'get',      //请求方式（*）
            toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页（*）
            // sortable: true,      //是否启用排序
            // sortName:"id",
            // sortOrder: "asc",     //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
            // pageNumber:1,      //初始化加载第一页，默认第一页
            // pageSize: 5,      //每页的记录行数（*）
            // pageList: [5,10, 25, 50, 100],  //可供选择的每页的行数（*）
            search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: false,
            searchOnEnterKey:false,
            // showColumns: true,     //是否显示所有的列
            // showRefresh: true,     //是否显示刷新按钮
            // minimumCountColumns: 2,    //最少允许的列数
            clickToSelect: true,    //是否启用点击选中行
            height: 350,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",      //每一行的唯一标识，一般为主键列
            // showToggle:true,     //是否显示详细视图和列表视图的切换按钮
            cardView: false,     //是否显示详细视图
            detailView: true,     //是否显示父子表
            columns: [{
                radio: true
            }, {
                field: 'fname',
                title: '名称',
                align: "center",
            }, {
                field: 'parentName',
                title: '父级名称',
                align: "center",
                formatter:function(value){
                    return '<span>无</span>';
                }
            },{
                field: 'fid',
                title: '操作',
                align: "center",
                valign: "middle",
                formatter:function(value,row,index){
                    console.log(JSON.stringify(row));
                    var str=JSON.stringify(row);
                    //str=str.substring(1,str.length-1);
                    str=str.replace(/\"/g,"=");
                    // alert(str)
                    return  "<a href='javascript:void(0)' class='glyphicon glyphicon-pencil' style='color: #1C84C6' onclick=\"goto_updateOut('"+str+"')\">修改</a>" +
                        "&nbsp;|&nbsp;<a href='javascript:void(0)'  class='glyphicon glyphicon-remove' style='color: #1C84C6' onclick=\"get_to_delete('"+str+"')\">删除</a>"
                }
            } ],
            //加载子表
            onExpandRow: function (index, row, $detail) {
                abc(index, row, $detail);
            }
        });
    };

    //定义加载字表的函数
    function abc (index, row, $detail) {

        var cur_table = $detail.html('<table></table>').find('table');

        cur_table.bootstrapTable({
            url: 'querySon.do',
            method: 'get',
            queryParams: { fid: row.fid,level:row.level,flag:'1'},
            // ajaxOptions: { fid: row.fid,level:row.level},
            clickToSelect: true,
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            striped: true,      //是否显示行间隔色
            detailView: true,//父子表
            uniqueId: "fid",
            pageSize: 10,
            pageList: [10, 25],
            showHeader:true,    //不显示标题
            cardView: false,     //是否显示详细视图
            columns: [{
                radio: true
            }, {
                field: 'fname',
                title: '名称',
                align: "center",
                valign: "middle"
            }, {
                field: 'parentName',
                title: '父级名称',
                align: "center",
                valign: "middle"
            },{
                field: 'fid',
                title: '操作',
                align: "center",
                valign: "middle",
                formatter:function(value,row,index){
                    console.log(JSON.stringify(row));
                    var str=JSON.stringify(row);
                    //str=str.substring(1,str.length-1);
                    str=str.replace(/\"/g,"=");
                    return  "<a href='javascript:void(0)' class='glyphicon glyphicon-pencil' style='color: #1C84C6' onclick=\"goto_updateOut('"+str+"')\">修改</a>" +
                        "&nbsp;|&nbsp;<a href='javascript:void(0)'  class='glyphicon glyphicon-remove' style='color: #1C84C6' onclick=\"get_to_delete('"+str+"')\">删除</a>"
                }
            } ],
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
            // pageSize: params.limit, //页面大小
            // page: params.offset, //页码
            flag:"1"
            // sortOrder:this.sortOrder,
            // name: $("#searchName").val(),
            // value: $("#searchValue").val()
        };
        return temp;
    };
    return oTableInit;
};

// 支出用途分类带子表
var TableInit=function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_cwglPayment').bootstrapTable({
            url: 'query.do',   //请求后台的URL（*）
            method: 'get',      //请求方式（*）
            toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页（*）
            // sortable: true,      //是否启用排序
            // sortName:"id",
            // sortOrder: "asc",     //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
            // pageNumber:1,      //初始化加载第一页，默认第一页
            // pageSize: 5,      //每页的记录行数（*）
            // pageList: [5,10, 25, 50, 100],  //可供选择的每页的行数（*）
            search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: false,
            searchOnEnterKey:false,
            // showColumns: true,     //是否显示所有的列
            // showRefresh: true,     //是否显示刷新按钮
            // minimumCountColumns: 2,    //最少允许的列数
            clickToSelect: true,    //是否启用点击选中行
            height: 350,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",      //每一行的唯一标识，一般为主键列
            // showToggle:true,     //是否显示详细视图和列表视图的切换按钮
            cardView: false,     //是否显示详细视图
            detailView: true,     //是否显示父子表
            columns: [{
                radio: true
            }, {
                field: 'fname',
                title: '名称',
                align: "center",
                valign: "middle"
            }, {
                field: 'parentName',
                title: '父级名称',
                align: "center",
                formatter:function(value) {
                    return '<span>无</span>';
                }
            },{
                field: 'fid',
                title: '操作',
                align: "center",
                valign: "middle",
                formatter:function(value,row,index){
                    console.log(JSON.stringify(row));
                    var str=JSON.stringify(row);
                    //str=str.substring(1,str.length-1);
                    str=str.replace(/\"/g,"=");
                    // alert(str)
                    return  "<a href='javascript:void(0)' class='glyphicon glyphicon-pencil' style='color: #1C84C6' onclick=\"get_to_update('"+str+"')\">修改</a>" +
                        "&nbsp;|&nbsp;<a href='javascript:void(0)'  class='glyphicon glyphicon-remove' style='color: #1C84C6' onclick=\"get_to_delete('"+str+"')\">删除</a>"
                }
            } ],
            //加载子表
            onExpandRow: function (index, row, $detail) {
                abc(index, row, $detail);
            }
        });
    };

    //定义加载子表的函数
    function abc (index, row, $detail) {

        var cur_table = $detail.html('<table></table>').find('table');

        cur_table.bootstrapTable({
            url: 'querySon.do',
            method: 'get',
            queryParams: { fid: row.fid,level:row.level,flag:'0'},
            // ajaxOptions: { fid: row.fid,level:row.level},
            clickToSelect: true,
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            striped: true,      //是否显示行间隔色
            detailView: true,//父子表
            uniqueId: "fid",
            pageSize: 10,
            pageList: [10, 25],
            showHeader:true,    //不显示标题
            cardView: false,     //是否显示详细视图
            columns: [{
                radio: true
            }, {
                field: 'fname',
                title: '名称',
                align: "center",
                valign: "middle"
            }, {
                field: 'parentName',
                title: '父级名称',
                align: "center",
                valign: "middle"
            },{
                field: 'fid',
                title: '操作',
                align: "center",
                valign: "middle",
                formatter:function(value,row,index){
                    console.log(JSON.stringify(row));
                    var str=JSON.stringify(row);
                    //str=str.substring(1,str.length-1);
                    str=str.replace(/\"/g,"=");
                    return  "<a href='javascript:void(0)' class='glyphicon glyphicon-pencil' style='color: #1C84C6' onclick=\"get_to_update('"+str+"')\">修改</a>" +
                        "&nbsp;|&nbsp;<a href='javascript:void(0)'  class='glyphicon glyphicon-remove' style='color: #1C84C6' onclick=\"get_to_delete('"+str+"')\">删除</a>"
                }
            } ],
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
            // pageSize: params.limit, //页面大小
            // page: params.offset, //页码
            flag:"0"
            // sortOrder:this.sortOrder,
            // name: $("#searchName").val(),
            // value: $("#searchValue").val()
        };
        return temp;
    };
    return oTableInit;
};

// 添加收入用途分类验证
function add_check() {
    var result=true;
    $("#add_name_message").html("");
    var name = $("#addfname").val();
    if ((name == null || name.length == 0)) {
        $("#add_name_message").html("请输入名称！");
        result=false;
    }

    // $("#add_type_message").html("");
    // var obj = document.getElementsByName("checkbox");
    // var flag=false;
    // for(k in obj){
    //         if(obj[k].checked)
    //             flag=true;
    //     }
    // if (!flag) {
    //     $("#add_type_message").html("请选择类型！");
    //     result=false;
    // }
    return result;
}

// 添加支出用途分类验证
function addOut_check() {
    var result=true;
    $("#addOut_name_message").html("");
    var name = $("#addOutfname").val();
    if ((name == null || name.length == 0)) {
        $("#addOut_name_message").html("请输入名称！");
        result=false;
    }

    return result;
}

// 添加收入用途分类
function addPayment(){
    if(add_check()){
        // obj = document.getElementsByName("checkbox");
        // var check_val = "";
        // // check_val = [];
        // for(k in obj){
        //     if(obj[k].checked)
        //         check_val+=obj[k].value;
        // }
        // if(check_val.length==2){
        //     check_val="0,1";
        // }

        // var $box1= document.getElementById('checkbox1');
        // var $box2= document.getElementById('checkbox2');
        // var check_val="";
        // if(($box1.checked==true)&&($box2.checked==true)){
        //     check_val="2"
        // }else if($box2.checked==true){
        //     check_val=$("#checkbox2").val()
        // }else if($box1.checked==true){
        //     check_val=$("#checkbox1").val()
        // }
        $.ajax({
            url:contextPath+"/cwglPayment/addPayment.do",
            type:"post",
            data:{
                fnursinghomeID:'414',
                fname:$("#addfname").val(),
                fparentid:$("#add_father_id").val(),
                ftype:'0',
            },
            success:function(data) {
                if(data.success){
                    setAlert("success",data.msg);
                }
                else{
                    setAlert("error",data.msg);
                }
                setAlert(data.message, "操作成功");
                $('#tb_cwglPayment').bootstrapTable('refresh', {url: 'query.do'});
                $('#addModal').modal('hide')
            }
        });
    }else{
        return 0;
    }

}

// 添加支出用途分类
function addOutPayment(){
    if(addOut_check()){
        $.ajax({
            url:contextPath+"/cwglPayment/addPayment.do",
            type:"post",
            data:{
                fnursinghomeID:'414',
                fname:$("#addOutfname").val(),
                fparentid:$("#addOut_father_id").val(),
                ftype:'1',
            },
            success:function(data) {
                if(data.success){
                    setAlert("success",data.msg);
                }
                else{
                    setAlert("error",data.msg);
                }
                $('#tb_cwglPaymentOut').bootstrapTable('refresh', {url: 'query.do'});
                $('#addOutModal').modal('hide')
            }
        });
    }else{
        return 0;
    }

}

// 添加收入用途分类时回显下拉框
function add_getCwglPayment(){
    $.ajax({
        url:contextPath+"/cwglPayment/getPayList.do",
        type:"post",
        data:{
            id:'0',
        },
        success:function(data) {
            $("#add_father_id").empty();
            $("#add_father_id").append("<option value='0'>顶级类别</option>")
            $.each(data,function (key,Data) {
                $("#add_father_id").append("<option value=" +Data.fid + ">" + Data.fname + "</option>")
            })
        }
    });
}

// 添加支出用途分类时回显下拉框
function addOut_getCwglPayment(){
    $.ajax({
        url:contextPath+"/cwglPayment/getPayList.do",
        type:"post",
        data:{
            id:'1',
        },
        success:function(data) {
            $("#addOut_father_id").empty();
            $("#addOut_father_id").append("<option value='0'>顶级类别</option>")
            $.each(data,function (key,Data) {
                $("#addOut_father_id").append("<option value=" +Data.fid + ">" + Data.fname + "</option>")
            })
        }
    });
}

//跳转增加收入用途分类
function get_to_add() {
    // var date=new Date();
    // var number=formatDateTime(new Date(),"MC");
    // $("#add_number").val(number);
    // $("[name = checkbox]:checkbox").attr("checked", false);
    $("#addfname").val("");
    // $("#add_remarks").val("");
    // $("#update_name_message").html("&nbsp;&nbsp;");
    add_getCwglPayment();
    $("#add_btn").click();
}

//跳转增加支出用途分类
function goto_addOut() {
    // var date=new Date();
    // var number=formatDateTime(new Date(),"MC");
    // $("#add_number").val(number);
    // $("[name = checkbox]:checkbox").attr("checked", false);
    $("#addOutfname").val("");
    // $("#add_remarks").val("");
    // $("#update_name_message").html("&nbsp;&nbsp;");
    addOut_getCwglPayment();
    $("#addOut_btn").click();
}

//跳转更新收入用途分类
function get_to_update(str) {
    str=str.replace(/\=/g,"\"");
    var po=JSON.parse(str);
    update_getCwglPaymentList(po.fid,po.fparentid);
    $("#update_id").val(po.fid);
    $("#updfname").val(po.fname);
    // if(po.ftype=="0"){
    //     $("[id = chkItem1]:checkbox").attr("checked", true);
    // }else if(po.ftype=="1"){
    //     $("[id = chkItem2]:checkbox").attr("checked", true);
    // }else if(po.ftype=="2"){
    //     $("[id = chkItem1]:checkbox").attr("checked", true);
    //     $("[id = chkItem2]:checkbox").attr("checked", true);
    // }
    $("#update_name_message").html("&nbsp;&nbsp;");
    $("#old_update_father_id").val(po.fparentid);
    $("#update_btn").click();
}

//跳转更新支出用途分类
function goto_updateOut(str) {
    str=str.replace(/\=/g,"\"");
    var po=JSON.parse(str);
    updateOut_getCwglPaymentList(po.fid,po.fparentid);
    $("#updateOut_id").val(po.fid);
    $("#updOutfname").val(po.fname);
    $("#updateOut_name_message").html("&nbsp;&nbsp;");
    $("#old_updateOut_father_id").val(po.fparentid);
    $("#updateOut_btn").click();
}

//加载收入分类更新,所属父类下拉框
function update_getCwglPaymentList(id,fatherID){
    $.ajax({
        url:contextPath+"/cwglPayment/getPayList.do",
        type:"post",
        data:{
            id:'0',
        },
        success:function(data) {
            $("#update_father_id").empty();
            $("#update_father_id").append("<option value='0'></option>")
            $.each(data,function (key,Data) {
                if(Data.fid==fatherID)
                {
                    $("#update_father_id").append("<option selected value=" +Data.fid + ">" + Data.fname + "</option>")
                }
                else{
                    $("#update_father_id").append("<option value=" +Data.fid + ">" + Data.fname + "</option>")
                }
            })
        }
    });
}

function check_upd_RefatherId(){
    var fatherId=$("#update_father_id").val();
    var id=$("#update_id").val();
    if(fatherId==id){
        alert("所选父类不能是本身");
        var fatherId=$("#old_update_father_id").val();
        update_getCwglPaymentList(null,fatherId);
        // $("#update_btn").click();
    }
}

function check_updOut_RefatherId(){
    var fatherId=$("#updateOut_father_id").val();
    var id=$("#updateOut_id").val();
    if(fatherId==id){
        alert("所选父类不能是本身");
        var fatherId=$("#old_updateOut_father_id").val();
        updateOut_getCwglPaymentList(null,fatherId);
        // $("#updateOut_btn").click();
    }
}

//加载支出分类更新下拉框
function updateOut_getCwglPaymentList(id,fatherID){
    $.ajax({
        url:contextPath+"/cwglPayment/getPayList.do",
        type:"post",
        data:{
            id:'1',
        },
        success:function(data) {
            $("#updateOut_father_id").empty();
            $("#updateOut_father_id").append("<option value='0'></option>")
            $.each(data,function (key,Data) {
                if(Data.fid==fatherID)
                {
                    $("#updateOut_father_id").append("<option selected value=" +Data.fid + ">" + Data.fname + "</option>")
                }
                else{
                    $("#updateOut_father_id").append("<option value=" +Data.fid + ">" + Data.fname + "</option>")
                }
            })
        }
    });
}

// 跟新收入用途分类验证
function update_check() {
    var name = $("#updfname").val();
    $("#update_name_message").html("");
    if ((name == null || name.length == 0)) {
        $("#update_name_message").html("请输入名称！");
        return false;
    }else{
        return true;
    }
}

// 跟新支出用途分类验证
function updateOut_check() {
    var name = $("#updOutfname").val();
    $("#updateOut_name_message").html("");
    if ((name == null || name.length == 0)) {
        $("#updateOut_name_message").html("请输入名称！");
        return false;
    }else{
        return true;
    }
}

//更新收入用途分类
function updateCwglPayment() {
    // var $box1= document.getElementById('chkItem1');
    // var $box2= document.getElementById('chkItem2');
    // var check_val="";
    // if(($box1.checked==true)&&($box2.checked==true)){
    //     check_val="2"
    // }else if($box2.checked==true){
    //     check_val=$("#chkItem2").val()
    // }else if($box1.checked==true){
    //     check_val=$("#chkItem1").val()
    // }
    if(update_check()){
       $.ajax({
            url:contextPath+"/cwglPayment/updateCwglPayment.do",
            type:"post",
            data:{
                fid:$("#update_id").val(),
                fnursinghomeID:$("#fnursinghomeID").val(),
                fname:$("#updfname").val(),
                fparentid:$("#update_father_id").val(),
                ftype:'0',
            },
            success: function (data) {
                if(data.success){
                    setAlert("success",data.msg);
                }
                else{
                    setAlert("error",data.msg);
                }
                $('#tb_cwglPayment').bootstrapTable('refresh', {url: 'query.do'});
                $("#update_btn").click();
            }
        });
    }else {
       return 0;
    }
}

//更新支出用途分类
function updateOutCwglPayment() {
    if(updateOut_check()){
       $.ajax({
            url:contextPath+"/cwglPayment/updateCwglPayment.do",
            type:"post",
            data:{
                fid:$("#updateOut_id").val(),
                fnursinghomeID:$("#fnursinghomeID").val(),
                fname:$("#updOutfname").val(),
                fparentid:$("#updateOut_father_id").val(),
                ftype:'1',
            },
            success: function (data) {
                if(data.success){
                    setAlert("success",data.msg);
                }
                else{
                    setAlert("error",data.msg);
                }
                $('#tb_cwglPaymentOut').bootstrapTable('refresh', {url: 'query.do'});
                $("#updateOut_btn").click();
            }
        });
    }else {
       return 0;
    }
}

//确认删除，包括收入和支出
function get_to_delete(str) {
    str=str.replace(/\=/g,"\"");
    var po=JSON.parse(str);
    var flag=confirm("确认要删除 "+po.fname+" 吗？");
    if(flag){
        $.ajax({
            type:'post',
            url:contextPath+"/cwglPayment/deleteCwglPayment.do",
            data:{
                fid:po.fid,
            },
            success:function (data) {
                if(!data.success){
                    setAlert("error","含有子分类，无法删除！");
                }
                else{
                    setAlert(data.message,"删除成功！");
                    $('#tb_cwglPayment').bootstrapTable('refresh', {url: 'query.do'});
                    $('#tb_cwglPaymentOut').bootstrapTable('refresh', {url: 'query.do'});
                }
            }

        })
    }
}