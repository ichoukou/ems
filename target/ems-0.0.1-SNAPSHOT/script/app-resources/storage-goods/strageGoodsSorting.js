
$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_storageGoodsSorting').bootstrapTable({
            url: 'getStorageGoodsSortingList.do',   //请求后台的URL（*）
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
            columns: [
            //     {
            //     // radio: true
            //      radio: false
            // },
                {
                field: 'typeName',
                title: '类型名称',
                align: 'center',
                width:190
            }, {
                field: 'fatherID',
                title: '父级ID',
                align: 'center',
                width:150
            },  {
                field: 'level',
                title: '分类级别',
                align: 'center',
                width:190
            },{
                    field: 'remark',
                    title: '备注',
                    align: 'center',
                    width:270
                } ,{
                field: 'id',
                title: '操作',
                align: 'center',
                width:280,
                formatter:function(value,row,index){
                    var str=JSON.stringify(row);
                    str=str.replace(/\"/g,"=");
                    return  "<a href='javascript:void(0)' class='glyphicon glyphicon-pencil' style='color: #1C84C6' onclick=\"get_to_update('"+str+"')\">修改</a>" +
                        "&nbsp;|&nbsp;<a href='javascript:void(0)'  class='glyphicon glyphicon-remove' style='color: #1C84C6' onclick=\"get_to_forbidden('"+str+"')\">禁用</a>"
                }
            }
            ],
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
            url: 'getStorageGoodsSortingSonList.do',
            method: 'get',
            queryParams: { id: row.id,level:row.level},
            ajaxOptions: { id: row.id,level:row.level},
            clickToSelect: true,
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            striped: true,      //是否显示行间隔色
            detailView: true,//父子表
            uniqueId: "id",
            pageSize: 10,
            pageList: [10, 25],
            showHeader:true,    //不显示标题
            cardView: false,     //是否显示详细视图
            columns: [
            //     {
            //     // radio: true
            //     radio: false
            // },
                {
                field: 'typeName',
                title: '类型名称',
                align: 'center',
            }, {
                field: 'fatherID',
                title: '父级ID',
                align: 'center',
            }, {
                    field: 'level',
                    title: '分类级别',
                    align: 'center',
                },{
                field: 'remark',
                title: '备注',
                align: 'center',
            }, {
                field: 'id',
                title: '操作',
                align: 'center',
                formatter:function(value,row,index){
                    // console.log(JSON.stringify(row));
                    var str=JSON.stringify(row);
                    str=str.replace(/\"/g,"=");
                    return  "<a href='javascript:void(0)' class='glyphicon glyphicon-pencil' style='color: #1C84C6' onclick=\"get_to_update('"+str+"')\">修改</a>" +
                        "&nbsp;|&nbsp;<a href='javascript:void(0)'  class='glyphicon glyphicon-remove' style='color: #1C84C6' onclick=\"get_to_forbidden('"+str+"')\">禁用</a>"
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

//更新时物品类别下拉框
function update_getStorageGoodsSortingTypeList(id,fatherID){
    $.ajax({
        url:contextPath+"/storageGoods/getStorageGoodsSortingTypeList.do",
        type:"post",
        data:{
            id:id,
        },
        success:function(data) {
            $("#update_father_id").empty();
            $("#update_father_id").append("<option value='0'></option>")
            $.each(data,function (key,Data) {
                if(Data.id==fatherID)
                {
                    $("#update_father_id").append("<option selected value=" +Data.id + ">" + Data.typeName + "</option>")

                }
                else{
                    $("#update_father_id").append("<option value=" +Data.id + ">" + Data.typeName + "</option>")
                }
            })
        }
    });
}
//新增类别时，获取物品类别下拉框
function add_getStorageGoodsSorting(){
    $.ajax({
        url:contextPath+"/storageGoods/getStorageGoodsSortingTypeList.do",
        type:"post",
        data:{
            id:'',
        },
        success:function(data) {
            $("#add_father_id").empty();
            $("#add_father_id").append("<option value='0'></option>")
            $.each(data,function (key,Data) {
                    $("#add_father_id").append("<option value=" +Data.id + ">" + Data.typeName + "</option>")
            })
        }
    });
}

//跳转更新
function get_to_update(str) {
    str=str.replace(/\=/g,"\"");
    var po=JSON.parse(str);
    update_getStorageGoodsSortingTypeList(po.id,po.fatherID);
    $("#update_id").val(po.id);
    $("#update_sorting_name").val(po.typeName);
    $("#update_remarks").val(po.remark);
    $("#update_name_message").html("&nbsp;&nbsp;");
    // $("#update_father_id").val(po.fatherID);
    $("#update_btn").click();
}
//禁用物品类别
function get_to_forbidden(str) {
    str=str.replace(/\=/g,"\"");
    var po=JSON.parse(str);
    var flag=confirm("确认要禁用 "+po.typeName+" 吗？");
    if(flag){
        $.ajax({
            type:'post',
            url:contextPath+"/storageGoods/forbiddenStorageGoodsSortingType.do",
            data:{
                id:po.id,
            },
            success:function (data) {
                if(!data.success){
                    setAlert("error","含有子分类，无法禁用！");
                }
                else{
                    setAlert(data.message,"禁用成功！");
                    $('#tb_storageGoodsSorting').bootstrapTable('refresh', {url: 'getStorageGoodsSortingList.do'});
                }
            }

        })
    }
}
//跳转增加
function get_to_add() {
    var date=new Date();
    var number=formatDateTime(new Date(),"MC");
    $("#add_number").val(number);
    $("#add_sorting_name").val("");
    $("#add_remarks").val("");
    $("#update_name_message").html("&nbsp;&nbsp;");
    add_getStorageGoodsSorting();
    $("#add_btn").click();
}

//更新输入检查
function update_check() {
    var name = $("#update_sorting_name").val();
    if ((name == null || name.length == 0)) {
        $("#update_name_message").html("请输入名称！");
        return false;
    }
    else{
        return true;
    }
}
function update_name_check() {
    var name = $("#update_sorting_name").val();
    if ((name == null || name.length == 0)) {
        $("#update_name_message").html("请输入名称！");
    }
    else{
        $("#update_name_message").html("");
    }
}
function add_check() {
    var name = $("#add_sorting_name").val();
    if ((name == null || name.length == 0)) {
        $("#add_name_message").html("请输入名称！");
        return false;
    }
    else{
        return true;
    }
}
function add_name_check() {
    var name = $("#add_sorting_name").val();
    if ((name == null || name.length == 0)) {
        $("#add_name_message").html("请输入名称！");
    }
    else{
        $("#add_name_message").html("");
    }
}

//更新类别保存
function updateStorageGoodsSorting() {
    var result=update_check();
    if(!result){
        return 0;
    }
    else {
        $.ajax({
            url:contextPath+"/storageGoods/updateStorageGoodsSortingType.do",
            type:"post",
            data:{
                id:$("#update_id").val(),
                fatherID:$("#update_father_id").val(),
                typeName:$("#update_sorting_name").val(),
                remark:$("#update_remarks").val(),
            },
            success: function (data) {
                if(!data.success){
                    setAlert("error","更新失败！");
                }
                else{
                    setAlert(data.message,"更新成功！");
                    $('#tb_storageGoodsSorting').bootstrapTable('refresh', {url: 'getStorageGoodsSortingList.do'});
                }

                 $("#update_btn").click();
            }
        });
    }


}
//添加类别
function addStorageGoodsSorting() {
    var result=add_check();
    if(!result){
        return 0;
    }
    else {
        $.ajax({
            url: contextPath + "/storageGoods/addStorageGoodsSortingType.do",
            type: "post",
            data: {
                typeNumber: $("#add_number").val(),
                fatherID: $("#add_father_id").val(),
                typeName: $("#add_sorting_name").val(),
                remark: $("#add_remarks").val(),
            },
            success: function (data) {
                if(!data.success){
                    setAlert("error","添加失败！");
                }
                else{
                    setAlert(data.message, "操作成功");
                    $('#tb_storageGoodsSorting').bootstrapTable('refresh', {url: 'getStorageGoodsSortingList.do'});
                }
                $("#add_btn").click();
            }
        });
    }
}

//年月日时分秒
var formatDateTime = function (date,str) {
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    var h = date.getHours();
    h=h < 10 ? ('0' + h) : h;
    var minute = date.getMinutes();
    minute = minute < 10 ? ('0' + minute) : minute;
    var second=date.getSeconds();
    second=second < 10 ? ('0' + second) : second;
    return str+ y  + m  + d+  h  + minute + second;
};