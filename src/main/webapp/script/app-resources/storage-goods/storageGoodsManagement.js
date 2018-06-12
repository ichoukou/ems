$(document).ready(function () {
    //物品分类列表
    getStorageGoodsSorting();
})
//查询条件
var status="";
var name="";
var type="";
$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {

        $('#tb_storageGoodsManagement').bootstrapTable({
            url: contextPath+'/storageGoods/getStorageGoodsManagementList.do',   //请求后台的URL（*）
            method: 'post',      //请求方式（*）
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
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
            pageList: [ 10, 20, 50, 100],  //可供选择的每页的行数（*）
            search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,     //是否显示所有的列
            showRefresh: true,     //是否显示刷新按钮
            minimumCountColumns: 2,    //最少允许的列数
            clickToSelect: true,    //是否启用点击选中行
            // height: 600,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",      //每一行的唯一标识，一般为主键列
            showToggle:true,     //是否显示详细视图和列表视图的切换按钮
            cardView: false,     //是否显示详细视图
            detailView: false,     //是否显示父子表
            columns: [
                {
                    radio: true
                },
                {
                    field: 'id',
                    title: '编号',
                    align: 'center',
                    width:80,
                }, {
                    field: 'name',
                    title: '物品名称',
                    align: 'center',
                    width:140,
                },{
                    field: 'type',
                    title: '产品类别',
                    align: 'center',
                    width:130,
                },{
                    field: 'standard',
                    title: '规格',
                    align: 'center',
                    width:80,
                },{
                    field: 'price',
                    title: '采购价',
                    align: 'center',
                    width:120,
                },{
                    field: 'unit',
                    title: '单位',
                    align: 'center',
                    width:80,
                },{
                    field: 'status',
                    title: '状态',
                    align: 'center',
                    width:80,
                    formatter:function(value,row,index){
                        var str;
                        if(value=="1")
                        {
                            str="<span style='color:green'>已启用</span>";
                        }
                        else{
                            str="<span style='color:red'>已禁用</span>";
                        }
                        return str;
                    }
                },{
                    field: 'lowStock',
                    title: '最小库存',
                    align: 'center',
                    width:130,
                },{
                    field: 'remark',
                    title: '备注',
                    align: 'center',
                    width:120,
                },
                // {
                //     field: 'typeStatus',
                //     title: '办理人',
                //     align: 'center',
                //     width:100,
                    // formatter:function(value,row,index){
                    //     return "小明";
                    // }
                // } ,
                {
                    field: 'delete',
                    title: '操作',
                    align: 'center',
                    width:100,
                    formatter:function(value,row,index){
                        if(row.status=="1")
                        {
                            return "<a id='update"+index+"' href='javascript:void(0)' class='glyphicon glyphicon-pencil' style='color: #1C84C6'>修改</a>"
                        }
                        else{
                            return "";
                        }
                    }
                } ,
            ],
            onLoadSuccess: function(data) {
                for(var i=0;i<data.total;i++){
                    (function(i){
                        $("#update"+i+"").click(function () {
                            get_to_update(data.rows[i]);
                        })
                    })(i);
                }
            }
            });
    };

    //定义加载字表的函数
    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset, //页码
            status:status,
            name:name,
            type:type,
        };
        return temp;
    };
    return oTableInit;
};

//加载物品分类下拉框
function getStorageGoodsSorting(){
    $.ajax({
        url:contextPath+"/storageGoods/getStorageGoodsSortingTypeList2.do",
        type:"post",
        data:{
            id:'',
        },
        success:function(data) {
            console.log(data);
            $("#type").empty();
            $("#type").append("<option value=''></option>");
            $.each(data,function (key,Data) {
                $("#type").append("<option value=" +Data.id + ">" + Data.typeName + "</option>")
            })
        }
    });
}

//跳转更新
function get_to_update(po) {
    //加载物品类别列表
    $.ajax({
        url:contextPath+"/storageGoods/getStorageGoodsSortingTypeList.do",
        type:"post",
        data:{
            id:'',
        },
        success:function(data) {
            var bool=false;
            $("#update_type").empty();
            $.each(data,function (key,Data) {
                $("#update_type").append("<option value=" +Data.id + ">" + Data.typeName + "</option>")
                if(Data.id==po.typeID)
                {
                    bool=true;
                }
            })
            if(bool==false)
            {
                    $("#update_type").append("<option value=" +po.typeID + ">" + po.type + "</option>");
            }
            $("#update_type").val(po.typeID);
        }
    });
    $("#Goods_id").val(po.id);
    $("#update_name").val(po.name);
    $("#update_standard").val(po.standard);
    $("#update_price").val(po.price);
    $("#update_lowStock").val(po.lowStock);
    $("#update_unit").val(po.unit);
    $("#update_remark").val(po.remark);
    $("#update_name_message").html("&nbsp;&nbsp;&nbsp;");
    $("#update_standard_message").html("&nbsp;&nbsp;&nbsp;");
    $("#update_price_message").html("&nbsp;&nbsp;&nbsp;");
    $("#update_type_message").html("&nbsp;&nbsp;&nbsp;");
    $("#update_unit_message").html("&nbsp;&nbsp;&nbsp;");
    $("#update_lowStock_message").html("&nbsp;&nbsp;&nbsp;");
    $("#update_btn").click();
}
//跳转添加
function go_to_add() {
    var date=new Date();
    var number=formatDateTime(new Date(),"MA");
    $("#add_Goods_number").val("FN"+number);
    // $("#add_type").val("");
    $.ajax({
        url:contextPath+"/storageGoods/getStorageGoodsSortingTypeList.do",
        type:"post",
        data:{
            id:'',
        },
        success:function(data) {

            $("#add_type").empty();
            $("#add_type").append("<option value='' selected>-请选择-</option>");
            $.each(data,function (key,Data) {
                $("#add_type").append("<option value=" +Data.id + ">" + Data.typeName + "</option>")
            })
        }
    });
    $("#add_name").val("");
    $("#add_standard").val("");
    $("#add_price").val("");
    $("#add_lowStock").val("");
    $("#add_unit").val("");
    $("#add_remark").val("");
    $("#add_name_message").html("&nbsp;&nbsp;&nbsp;");
    $("#add_standard_message").html("&nbsp;&nbsp;&nbsp;");
    $("#add_price_message").html("&nbsp;&nbsp;&nbsp;");
    $("#add_type_message").html("&nbsp;&nbsp;&nbsp;");
    $("#add_unit_message").html("&nbsp;&nbsp;&nbsp;");
    $("#add_lowStock_message").html("&nbsp;&nbsp;&nbsp;");
    $("#add_btn").click();
}


//addcheck
function add_check_type() {
    var type = $("#add_type").val().trim();
    if (type == "") {
        $("#add_type_message").html("请选择！");
    }
    else{
        $("#add_type_message").html("&nbsp;&nbsp;&nbsp;");
    }
}
function add_check_name() {
    var name = $("#add_name").val().trim();
    if ((name == null || name.length == 0)) {
        $("#add_name_message").html("请填写！");
    }
    else{
        $("#add_name_message").html("&nbsp;&nbsp;&nbsp;");
    }
}
function add_check_standard() {
    var standard = $("#add_standard").val().trim();
    if ((standard == null || standard.length == 0)) {
        $("#add_standard_message").html("请填写！");
    }
    else{
        $("#add_standard_message").html("&nbsp;&nbsp;&nbsp;");
    }
}
function add_check_price() {
    var price = $("#add_price").val().trim();
    $("#add_price_message").html("&nbsp;&nbsp;&nbsp;");
    if (price == null || price.length == 0) {
        $("#add_price_message").html("请填写！");
    }
    else{
        if(price.indexOf(".",0)==-1)
        {
            price=price+".00";
            $("#add_price").val(price);
        }
        if(price.length-price.indexOf(".",0)==1)
        {
            price=price+"00";
            $("#add_price").val(price);
        }
        if(price.length-price.indexOf(".",0)==2)
        {
            price=price+"0";
            $("#add_price").val(price);
        }
        var rq="^([0-9]*[1-9][0-9]*\.[0-9]{2})$";
        if(!price.match(rq))
        {
            $("#add_price_message").html("格式错误！");
        }
    }
}
function add_check_lowStock() {
    var lowStock = $("#add_lowStock").val().trim();
    if ((lowStock == null || lowStock.length == 0)) {
        $("#add_lowStock_message").html("请填写！");
    }
    else{
        $("#add_lowStock_message").html("&nbsp;&nbsp;&nbsp;");
    }
}
function add_check_unit() {
    var unit = $("#add_unit").val().trim();
    if ((unit == null || unit.length == 0)) {
        $("#add_unit_message").html("请填写！");
    }
    else{
        $("#add_unit_message").html("&nbsp;&nbsp;&nbsp;");
    }
}

function addCheck() {
    var name = $("#add_name").val().trim();
    var standard = $("#add_standard").val().trim();
    var price = $("#add_price").val().trim();
    var lowStock = $("#add_lowStock").val().trim();
    var type = $("#add_type").val().trim();
    var unit = $("#add_unit").val().trim();
    var result= true;
    if ((name == null || name.length == 0)) {
        $("#add_name_message").html("请填写！");
        result = false;
    }
    if ((standard == null || standard.length == 0)) {
        $("#add_standard_message").html("请填写！");
        result = false;
    }
    if (price == null || price.length == 0) {
        $("#add_price_message").html("请填写！");
        result = false;
    }else{
        if(!($("#add_price_message").html()=="&nbsp;&nbsp;&nbsp;"))
        {
            result = false;
        }
    }
    if (lowStock == null || lowStock.length == 0) {
        $("#add_lowStock_message").html("请填写！");
        result = false;
    }
    if (type=='') {
        $("#add_type_message").html("请选择！");
        result = false;
    }
    if (unit == null || unit.length == 0) {
        $("#add_unit_message").html("请填写！");
        result = false;
    }

    return result;
}

//updatecheck
function update_check_type() {
    var type = $("#update_type").val().trim();
    if (type == "") {
        $("#update_type_message").html("请选择！");
    }
    else{
        $("#update_type_message").html("&nbsp;&nbsp;&nbsp;");
    }
}
function update_check_name() {
    var name = $("#update_name").val().trim();
    if ((name == null || name.length == 0)) {
        $("#update_name_message").html("请填写！");
    }
    else{
        $("#update_name_message").html("&nbsp;&nbsp;&nbsp;");
    }
}
function update_check_standard() {
    var standard = $("#update_standard").val().trim();
    if ((standard == null || standard.length == 0)) {
        $("#update_standard_message").html("请填写！");
    }
    else{
        $("#update_standard_message").html("&nbsp;&nbsp;&nbsp;");
    }
}
function update_check_price() {
    var price = $("#update_price").val().trim();
    $("#update_price_message").html("&nbsp;&nbsp;&nbsp;");
    if (price == null || price.length == 0) {
        $("#update_price_message").html("请填写！");
    }
    else{
        if(price.indexOf(".",0)==-1)
        {
            price=price+".00";
            $("#update_price").val(price);
        }
        if(price.length-price.indexOf(".",0)==1)
        {
            price=price+"00";
            $("#update_price").val(price);
        }
        if(price.length-price.indexOf(".",0)==2)
        {
            price=price+"0";
            $("#update_price").val(price);
        }
        var rq="^([0-9]*[1-9][0-9]*\.[0-9]{2})$";
        if(!price.match(rq))
        {
            $("#update_price_message").html("格式错误！");
        }
    }
}
function update_check_lowStock() {
    var lowStock = $("#update_lowStock").val().trim();
    if ((lowStock == null || lowStock.length == 0)) {
        $("#update_lowStock_message").html("请填写！");
    }
    else{
        $("#update_lowStock_message").html("&nbsp;&nbsp;&nbsp;");
    }
}
function update_check_unit() {
    var unit = $("#update_unit").val().trim();
    if ((unit == null || unit.length == 0)) {
        $("#update_unit_message").html("请填写！");
    }
    else{
        $("#update_unit_message").html("&nbsp;&nbsp;&nbsp;");
    }
}

function updateCheck() {
    var name = $("#update_name").val().trim();
    var standard = $("#update_standard").val().trim();
    var price = $("#update_price").val().trim();
    var lowStock = $("#update_lowStock").val().trim();
    var type = $("#update_type").val().trim();
    var unit = $("#update_unit").val().trim();
    var result= true;
    if ((name == null || name.length == 0)) {
        $("#update_name_message").html("请填写！");
        result = false;
    }
    if ((standard == null || standard.length == 0)) {
        $("#update_standard_message").html("请填写！");
        result = false;
    }
    if (price == null || price.length == 0) {
        $("#update_price_message").html("请填写！");
        result = false;
    }else{
        if(!($("#update_price_message").html()=="&nbsp;&nbsp;&nbsp;"))
        {
            result = false;
        }
    }
    if (lowStock == null || lowStock.length == 0) {
        $("#update_lowStock_message").html("请填写！");
        result = false;
    }
    if (type=='') {
        $("#update_type_message").html("请选择！");
        result = false;
    }
    if (unit == null || unit.length == 0) {
        $("#update_unit_message").html("请填写！");
        result = false;
    }

    return result;
}



//更新物品
function updateStorageGoodsManagement() {
    if(!updateCheck()){
        return 0;
    }
    else {
        var date=new Date();
        var enterTime=date.getFullYear()+"-"+date.getMonth()+"-"+date.getDate();
        $.ajax({
            url:contextPath+"/storageGoods/updateStorageGoodsManagement.do",
            type:"post",
            data:{
                id:$("#Goods_id").val(),
                typeID:$("#update_type").val(),
                name:$("#update_name").val(),
                standard:$("#update_standard").val(),
                price:$("#update_price").val(),
                lowStock:$("#update_lowStock").val(),
                unit:$("#update_unit").val(),
                remark:$("#update_remark").val(),
                enterTime:enterTime.toString(),
            },
            success: function (data) {
                if(!data.success){
                    setAlert("error","更新失败！");
                }
                else{
                    setAlert(data.message, "更新成功");
                    $('#tb_storageGoodsManagement').bootstrapTable('refresh', {url: 'getStorageGoodsManagementList.do'});
                }
                $("#update_close_btn").click();
            }
        });
    }
}
//添加物品
function addStorageGoodsManagement() {
    if(!addCheck()){
        return 0;
    }
    else{
        var date=new Date();
        var enterTime=date.getFullYear()+"-"+date.getMonth()+"-"+date.getDate();
        $.ajax({
            url:contextPath+"/storageGoods/addStorageGoodsManagement.do",
            type:"post",
            data:{
                typeID:$("#add_type").val(),
                name:$("#add_name").val(),
                standard:$("#add_standard").val(),
                price:$("#add_price").val(),
                lowStock:$("#add_lowStock").val(),
                unit:$("#add_unit").val(),
                remark:$("#add_remark").val(),
                enterTime:enterTime.toString(),
                number:$("#add_Goods_number").val(),
            },
            success: function (data) {
                if(!data.success){
                    setAlert("error","更新失败！");
                }
                else {
                    setAlert(data.message, "添加成功");
                    $('#tb_storageGoodsManagement').bootstrapTable('refresh', {url: 'getStorageGoodsManagementList.do'});
                }
                $("#add_close_btn").click();
            }
        });
    }

}

//清空条件
function clearSelect() {
    $("#Status").val("");
    $("#name").val("");
    $("#type").val("");
}
//查询
function queryGoods(){
    status=$("#Status").val();
    name=$("#name").val();
    type=$("#type").val();
    $('#tb_storageGoodsManagement').bootstrapTable('selectPage',1);
}

//物品禁用
function gotoDelete(){
    var carrentItem = $("#tb_storageGoodsManagement").bootstrapTable('getSelections');
    if(carrentItem[0]){
        if(carrentItem[0].status=="2"){
            setAlert("error","该条记录已经是禁用状态");
        }else{
            $.ajax({
                url:contextPath+"/storageGoods/forbiddenStorageGoodsManagement.do",
                type:"post",
                data:{
                    id:carrentItem[0].id
                },
                success:function(data) {
                    $('#tb_storageGoodsManagement').bootstrapTable('refresh', {url: 'getStorageGoodsManagementList.do'});
                    if(data.success){
                        setAlert(data.msg,"禁用成功");
                    }
                    else{
                        setAlert(data.msg,"禁用失败");
                    }

                }
            });
        }
    }else{
        setAlert("error","请先选择一条数据");
    }
}
//物品启用
function gotoStart(){
    var carrentItem = $("#tb_storageGoodsManagement").bootstrapTable('getSelections');
    if(carrentItem[0]){
        if(carrentItem[0].status=="1"){
            setAlert("error","该条记录已经是启用状态");
        }else{
            $.ajax({
                url:contextPath+"/storageGoods/startStorageGoodsManagement.do",
                type:"post",
                data:{
                    id:carrentItem[0].id
                },
                success:function(data) {
                    $('#tb_storageGoodsManagement').bootstrapTable('refresh', {url: 'getStorageGoodsManagementList.do'});
                    if(data.success){
                        setAlert(data.msg,"启用成功");
                    }
                    else{
                        setAlert(data.msg,"启用失败");
                    }
                }
            });
        }
    }else{
        setAlert("error","请先选择一条数据");
    }
}

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