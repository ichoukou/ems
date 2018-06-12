//初始化
$(document).ready(function () {
    //项目名称列表
    getHomeServiceItemNameList();
    //项目类型列表
    getHomeServiceItemTypeList();
    //项目单位列表
    getHomeServiceItemUnitList();
});
//查询条件
var serviceItemName="";
var serviceTypeName="";
var itemStatus="";
$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_homeServiceItem').bootstrapTable({
            url:contextPath+'/homeServiceItem/getHomeServiceItemList.do',   //请求后台的URL（*）
            method: 'post',      //请求方式（*）
            toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页（*）
            sortable: false,      //是否启用排序
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            // sortOrder: "asc",     //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,      //初始化加载第一页，默认第一页
            pageSize:5,      //每页的记录行数（*）
            // pageList: [10, 25, 50, 100],  //可供选择的每页的行数（*）
            search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,     //是否显示所有的列
            showRefresh: true,     //是否显示刷新按钮
            minimumCountColumns: 2,    //最少允许的列数
            clickToSelect: true,    //是否启用点击选中行
            height: 350,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            // uniqueId: "number",      //每一行的唯一标识，一般为主键列
            showToggle:true,     //是否显示详细视图和列表视图的切换按钮
            cardView: false,     //是否显示详细视图
            detailView: false,     //是否显示父子表
            columns: [{
                radio: true
            }, {
                field: 'number',
                title: '序号',
                width: 250
            }, {
                field: 'serviceItemName',
                title: '项目名称',
                width: 150
            },{
                field: 'serviceTypeName',
                title: '项目类型',
                width: 150
            },{
                field: 'price',
                title: '单价',
                width: 100

            },{
                field: 'itemUnit',
                title: '单位',
                width: 100
            },{
                field: 'itemStatus',
                title: '状态',
                width: 100
            },{
                field: 'explain',
                title: '说明',
                width: 200
            }]
        });
    };
    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset, //页码
            serviceItemName: serviceItemName,
            serviceTypeName: serviceTypeName,
            itemStatus: itemStatus,
            // serviceTypeName:encodeURI($("#serviceItemType").val()),
        };
        return temp;
    };
    return oTableInit;
};


//动态加载下拉框得到项目名称列表
function getHomeServiceItemNameList() {
    $.ajax({
        url:contextPath+"/homeServiceItem/getHomeServiceItemNameList.do",
        type:"post",
        success:function(data) {
            $("#serviceItemName").empty();
            $("#serviceItemName").append("<option value='' selected>全部</option>")
            $.each(data,function (key,Data) {
                $("#serviceItemName").append("<option value=" +Data.toString() + ">" + Data.toString() + "</option>")
            })
        }
    });
}
//动态加载下拉框得到项目类比列表
function getHomeServiceItemTypeList() {
    $.ajax({
        url:contextPath+"/homeServiceItem/getHomeServiceItemTypeList.do",
        type:"post",
        success:function(data) {
            // console.log(data[0].staffNameList);
            $("#add_item_type").empty();
            $("#update_item_type").empty();
            $("#serviceItemType").empty();
            $("#serviceItemType").append("<option value='' selected>全部</option>")
            $.each(data,function (key,Data) {
                $("#serviceItemType").append("<option value=" +Data.toString() + ">" + Data.toString() + "</option>")
                $("#update_item_type").append("<option value=" +Data.toString() + ">" + Data.toString() + "</option>")
                $("#add_item_type").append("<option value=" +Data.toString() + ">" + Data.toString() + "</option>")
            })
        }
    });
}
//动态加载下拉框得到项目单位列表
function getHomeServiceItemUnitList() {
    $.ajax({
        url:contextPath+"/homeServiceItem/getHomeServiceItemUnitList.do",
        type:"post",
        success:function(data) {
            $("#update_item_unit").empty();
            $("#add_item_unit").empty();
            $("#add_item_unit").append("<option value='' selected>-请选择-</option>")
            $.each(data,function (key,Data) {
                $("#update_item_unit").append("<option value="+Data.toString()+">"+Data.toString()+"</option>")
                $("#add_item_unit").append("<option value="+Data.toString()+">"+Data.toString()+"</option>")
            })
        }
    });
}


//生成数据，显示更新页面
function gotoUpdate(){
    $("#update_itemname_message").html("");
    $("#update_price_message").html("");
    var carrentItem = $("#tb_homeServiceItem").bootstrapTable('getSelections');
    if(carrentItem[0]) {
        $("#update_item_number").val(carrentItem[0].number);
        $("#update_item_type").val(carrentItem[0].serviceTypeName);
        $("#update_item_name").val(carrentItem[0].serviceItemName);
        $("#update_item_price").val(carrentItem[0].price);
        $("#update_item_unit").val(carrentItem[0].itemUnit);
        // alert(carrentItem[0].itemStatus);
        if(carrentItem[0].itemStatus=="<span style='color:green'>已启用</span>"){
            $("#update_item_status").val("1");
        }else{
            $("#update_item_status").val("0");
        }
        $("#update_item_explain").val(carrentItem[0].explain);
        $("#update_btn").click();
    }else{
        setAlert("error","请先选择一条数据");
    }
}
//生成数据，显示添加项目页面
function gotoAdd(){
    // alert($("#add_item_type").val());
    if($("#add_item_type").val()==null)
    {
        alert("请先添加服务项目类型!");
    }
    else{
        $("#add_itemname_message").html("&nbsp;&nbsp;");
        $("#add_item_name").val("");
        $("#add_price_message").html("&nbsp;&nbsp;");
        $("#add_unit_message").html("&nbsp;&nbsp;");
        $("#add_item_price").val("");
        $("#add_item_unit").val("");
        $("#add_item_explain").val("");
        $("#add_item_status").val("1");
        var date=formatDateTime(new Date(),"HS");
        var num=date;

        $("#add_item_number").val(num);
        $("#add_btn").click();
    }
}
//生成数据，显示添加项目类型页面
function gotoTypeAdd() {
    $("#type_add_message").html("");
    $("#type_add_name").val("");
    var date=formatDateTime(new Date(),"HT");
    var num=date;
    $("#type_add_number").val(num);
    $("#type_add_btn").click();
}


//验证是否为空
function add_price_check() {
    var price = $("#add_item_price").val().trim();
    $("#add_price_message").html("");
    if (price == null || price.length == 0) {
        $("#add_price_message").html("请输入单价！");
    }
    else{
        if(price.indexOf(".",0)==-1)
        {
            price=price+".00";
            $("#add_item_price").val(price);
        }
        if(price.length-price.indexOf(".",0)==1)
        {
            price=price+"00";
            $("#add_item_price").val(price);
        }
        if(price.length-price.indexOf(".",0)==2)
        {
            price=price+"0";
            $("#add_item_price").val(price);
        }
        var rq="^([0-9]*[1-9][0-9]*\.[0-9]{2})$";
        if(!price.match(rq))
        {
            $("#add_price_message").html("格式错误！");
        }
    }
}
function add_name_check(){
    var name = $("#add_item_name").val().trim();
    $("#add_itemname_message").html("");
    if ((name == null || name.length == 0)) {
        $("#add_itemname_message").html("请输入项目名称！");
    }
}
function update_price_check() {
    var price = $("#update_item_price").val().trim();
    $("#update_price_message").html("");
    if (price == null || price.length == 0) {
        $("#update_price_message").html("请输入单价！");
    }
    else{
        if(price.indexOf(".",0)==-1)
        {
            price=price+".00";
            $("#update_item_price").val(price);
        }
        var rq="^([0-9]*[1-9][0-9]*\.[0-9]{2})$";
        if(!price.match(rq))
        {
            $("#update_price_message").html("格式错误！");
        }
    }
}
function update_name_check(){
    var name = $("#update_item_name").val().trim();
    $("#update_itemname_message").html("");
    if ((name == null || name.length == 0)) {
        $("#update_itemname_message").html("请输入项目名称！");
    }
}
function add_unit_check(){
    var unit = $("#add_item_unit").val().trim();
    $("#add_unit_message").html("");
    if ((unit == null || unit.length == 0)) {
        $("#add_unit_message").html("请选择！");
    }
}


//验证添加项目
function addCheck() {
    var name = $("#add_item_name").val().trim();
    var price = $("#add_item_price").val().trim();
    var unit = $("#add_item_unit").val().trim();
    var result=true;
    if ((name == null || name.length == 0)) {
        $("#add_itemname_message").html("请输入项目名称！");
        result = false;
    }
    if (price == null || price.length == 0) {
        $("#add_price_message").html("请输入单价！");
        result = false;
    }else{
        if(!($("#add_price_message").html()==""))
        {
            result = false;
        }
    }
    if (unit == null || unit.length == 0) {
        $("#add_unit_message").html("请选择！");
        result = false;
    }

    return result;
}
//验证更新项目
function updateCheck() {
        var name = $("#update_item_name").val();
        var price = $("#update_item_price").val();
        var result=true;
        if ((name == null || name.length == 0)) {
            $("#update_itemname_message").html("请输入项目名称！");
            result=false;
        }
        if (price == null || price.length == 0) {
            $("#update_price_message").html("请输入单价！");
            result=false;
        }
        else{
            if(!($("#update_price_message").html()==""))
            {
                result=false;
            }
        }
        return result;
    }
//验证添加项目类型
function addTypeCheck() {
        var name = $("#type_add_name").val();
        if (name == null || name.length == 0) {
            $("#type_add_message").html("请填写类型名称！");
            return 0;
        }
        else {
            return 1;
        }
    }






//增加项目类型
    function addHomeServiceType() {

        if (addTypeCheck() == 0) {
            return 0;
        }
        else {
            $.ajax({
                url: contextPath + "/homeServiceItem/addServiceType.do",
                type: "post",
                data: {
                    number: $("#type_add_number").val(),
                    serviceTypeName: $("#type_add_name").val(),
                },
                success: function (data) {
                    if (!data.success) {
                        $("#type_add_message").html("该名称已存在！");
                    }
                    else {
                        setAlert(data.message, "操作成功");
                        getHomeServiceItemTypeList();
                        $("#typeadd_close_btn").click();
                    }
                }
            });
        }
    }

//增加项目
    function addHomeServiceItem() {
        if (!addCheck()) {
            return 0;
        }
        else {
            $.ajax({
                url: contextPath + "/homeServiceItem/addServiceItem.do",
                type: "post",
                data: {
                    number: $("#add_item_number").val(),
                    serviceItemName: $("#add_item_name").val(),
                    serviceTypeName: $("#add_item_type").val(),
                    price: $("#add_item_price").val(),
                    itemUnit: $("#add_item_unit").val(),
                    itemStatus: $("#add_item_status").val(),
                    explain: $("#add_item_explain").val(),
                },
                success: function (data) {
                    if(data.success)
                    {
                        setAlert(data.message, "操作成功");
                    }
                    else{
                        setAlert("error","操作失败")
                    }
                    getHomeServiceItemNameList();
                    $("#add_close_btn").click();
                    $('#tb_homeServiceItem').bootstrapTable('refresh', {url : 'getHomeServiceItemList.do'});


                }
            });
        }
    }

//更新项目
    function updateHomeServiceItem() {
        if (!updateCheck()) {
            return 0;
        }
        else {
            $.ajax({
                url: contextPath + "/homeServiceItem/updateServiceItem.do",
                type: "post",
                data: {
                    number: $("#update_item_number").val(),
                    serviceItemName: $("#update_item_name").val(),
                    serviceTypeName: $("#update_item_type").val(),
                    price: $("#update_item_price").val(),
                    itemUnit: $("#update_item_unit").val(),
                    itemStatus: $("#update_item_status").val(),
                    explain: $("#update_item_explain").val(),
                },
                success: function (data) {
                    if(data.success)
                    {
                        setAlert(data.message, "操作成功");
                    }
                    else{
                        setAlert("error","操作失败")
                    }
                    queryHomeServiceItem();
                    $("#update_close_btn").click();
                }
            });
        }
    }

//条件查询项目
    function queryHomeServiceItem() {
        serviceItemName=$("#serviceItemName").val();
        serviceTypeName=$("#serviceItemType").val();
        itemStatus=$("#serviceItemStatus").val();
        $('#tb_homeServiceItem').bootstrapTable('selectPage',1);
    }
//清除选项
function queryclear() {
        $("#serviceItemName").val("");
        $("#serviceItemType").val("");
        $("#serviceItemStatus").val("");
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