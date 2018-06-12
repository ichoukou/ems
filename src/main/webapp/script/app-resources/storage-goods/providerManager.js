/**
 * Created by zhangxin on 2016/12/27.
 */
$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_providerManager').bootstrapTable({
            url: 'query.do',   //请求后台的URL（*）
            method: 'post', //请求方式（*）
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
            detailView: false,     //是否显示父子表
            columns: [{
                radio: true
            }, {
                field: 'fID',
                title: '编号'
            }, {
                field: 'fSupplierName',
                title: '供应商名称'
            }, {
                field: 'fContactsName',
                title: '联系人'
            }, {
                field: 'fMobileTel',
                title: '联系电话'
            }, {
                field: 'fMailingAddress',
                title: '联系地址'
            }, {
                field: 'sTATUS',
                title: '状态',
                formatter:function(value){
                    if(value==1){
                        return '<span style="color:#80b2ff">开启</span>'
                    }else if(value==0){
                        return '<span style="color:#FF0000">禁用</span>'
                    }
                }
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset, //页码
            fSupplierName: $("#searchFSupplierName").val(),
            fContactsName: $("#searchFContactsName").val(),
            fMobileTel:$("#searchFMobileTel").val()
        };
        return temp;
    };
    return oTableInit;
};
//新增验证
function add_provider_ckeck() {
    var result=true;
    var fSupplierName = $("#addFSupplierName").val();
    if(fSupplierName ==""){
        $("#add_suname_message").html("请添加！");
        result = false;
    }
    var fContactsName = $("#addFContactsName").val();
    if (fContactsName==""){
        $("#add_coname_message").html("请添加！");
        result = false;
    }
    return result;
}
//更新验证
function update_provider_ckeck() {
    var result=true;
    var fSupplierName = $("#updateFSupplierName").val();
    if(fSupplierName ==""){
        $("#update_suname_message").html("请添加！");
        result = false;
    }
    var fContactsName = $("#updateFContactsName").val();
    if (fContactsName==""){
        $("#update_coname_message").html("请添加！");
        result = false;
    }
    return result;
}
//验证
function add_suname_check(){
    var name = $("#addFSupplierName").val().trim();
    $("#add_suname_message").html("");
    if ((name == null || name.length == 0)) {
        $("#add_suname_message").html("请添加！");
    }
}
function add_coname_check(){
    var name = $("#addFContactsName").val().trim();
    $("#add_coname_message").html("");
    if ((name == null || name.length == 0)) {
        $("#add_coname_message").html("请输入！");
    }
}
function add_moname_check(){
    $("#add_moname_message").html("");
    var fMobileTel = $("#addFMobileTel").val().trim();
    var fMobile=fMobileTel.trim();
    var reg=new RegExp(/^1[34578]\d{9}$/);
    if(fMobile!=""&&!reg.test(fMobile)){
        $("#add_moname_message").html("号码不正确！");
    }
}

function update_suname_check(){
    var name = $("#updateFSupplierName").val().trim();
    $("#update_suname_message").html("");
    if ((name == null || name.length == 0)) {
        $("#update_suname_message").html("请添加！");
    }
}
function update_coname_check(){
    var name = $("#updateFContactsName").val().trim();
    $("#update_coname_message").html("");
    if ((name == null || name.length == 0)) {
        $("#update_coname_message").html("请输入！");
    }
}
function update_moname_check(){
    $("#update_moname_message").html("");
    var fMobileTel = $("#updateFMobileTel").val().trim();
    var fMobile=fMobileTel.trim();
    var reg=new RegExp(/^1[34578]\d{9}$/);
    if(fMobile!=""&&!reg.test(fMobile)){
        $("#update_moname_message").html("号码不正确！");
    }
}

//查询
function queryProviderManager(){
    $.ajax({
        url:contextPath+"/manager/query.do",
        type:"post",
        data:{
            fSupplierName: $("#searchFSupplierName").val(),
            fContactsName: $("#searchFContactsName").val(),
            fMobileTel:$("#searchFMobileTel").val(),
            page:0,
            pageSize:10
        },
        success:function(data) {
            $('#tb_providerManager').bootstrapTable('load', data);
        }
    });
}
//清空
function cleanData() {
    $("#searchFSupplierName").val("");
    $("#searchFContactsName").val("");
    $("#searchFMobileTel").val("");
    $('#tb_providerManager').bootstrapTable('refresh', {url: 'query.do'});
}
//新增
function addProviderManager() {
    if(!add_provider_ckeck()){
        return 0;
    }else {
        var date = new Date();
        var fSupplierNumber = "No" + date.getFullYear() + (date.getMonth() + 1) + date.getDate() + date.getHours() + date.getMinutes() + date.getSeconds();
        $.ajax({
            url: contextPath + "/manager/addProviderManager.do",
            type: "post",
            data: {
                fSupplierName: $("#addFSupplierName").val(),
                fSupplierNumber: fSupplierNumber,
                fContactsName: $("#addFContactsName").val(),
                fMobileTel: $("#addFMobileTel").val(),
                fMailingAddress: $("#addFMailingAddress").val(),
                fBank:$("#addFBank").val(),
                fAccountNumber:$("#addFAccountNumber").val(),
                fDutyParagraph:$("#addFDutyParagraph").val(),
                fTel:$("#addFTel").val(),
                fQqID:$("#addFQqID").val(),
                fWechatNumber:$("#addFWechatNumber").val()
            },
            success: function (data) {
                console.log(data.message);
                setAlert(data.message, "操作成功");
                $('#tb_providerManager').bootstrapTable('refresh', {url: 'query.do'});
                $("#add_close_btn").click();
            }
        });
    }
    closeModal();
}

//修改
function updateProviderManager() {
    if(!update_provider_ckeck()){
        return 0;
    }else {
    $.ajax({
        url: contextPath + "/manager/updateProviderManager.do",
        type: "post",
        data: {
            fID: $("#provider_id").val(),
            fSupplierName:$("#updateFSupplierName").val(),
            fContactsName:$("#updateFContactsName").val(),
            fMobileTel:$("#updateFMobileTel").val(),
            fMailingAddress:$("#updateFMailingAddress").val(),
            fBank:$("#updateFBank").val(),
            fAccountNumber:$("#updateFAccountNumber").val(),
            fDutyParagraph:$("#updateFDutyParagraph").val(),
            fTel:$("#updateFTel").val(),
            fQqID:$("#updateFQqID").val(),
            fWechatNumber:$("#updateFWechatNumber").val(),
        },
        success: function (data) {
            console.log(data.message);
            setAlert(data.message, "操作成功");
            $('#tb_providerManager').bootstrapTable('refresh', {url: 'query.do'});
            $("#update_close_btn").click();
        }
    });
    }
    closeModal();
}
//禁用
function gotoDelete(){
    var carrentItem = $("#tb_providerManager").bootstrapTable('getSelections');
    if(carrentItem[0]){
        if(carrentItem[0].sTATUS==0){
            setAlert("error","该条记录已经是禁用状态");
        }else{
        $.ajax({
            url:contextPath+"/manager/deleteProviderManager.do",
            type:"post",
            data:{
                fID:carrentItem[0].fID
            },
            success:function(data) {
                $('#tb_providerManager').bootstrapTable('refresh', {url: 'query.do'});
                if(data.success){
                    setAlert(data.msg,"操作成功");
                    $('#tb_providerManager').bootstrapTable('refresh', {url: 'query.do'});
                }
            }
        });
    }
    }else{
        setAlert("error","请先选择一条数据");
    }
}
//启用
function gotoEnabled(){
    var carrentItem = $("#tb_providerManager").bootstrapTable('getSelections');
    if(carrentItem[0]){
        if(carrentItem[0].sTATUS==1){
            setAlert("error","该条记录已经是启用状态");
        }else{
            $.ajax({
                url:contextPath+"/manager/startRole.do",
                type:"post",
                data:{
                    fID:carrentItem[0].fID
                },
                success:function(data) {
                    $('#tb_providerManager').bootstrapTable('refresh', {url: 'query.do'});
                    setAlert(data.msg,"启用成功");
                }
            });
        }
    }else{
        setAlert("error","请先选择一条数据");
    }
}

//关闭
function closeModal() {
    $("#addFSupplierName").val("");
    $("#addFContactsName").val("");
    $("#addFMobileTel").val("");
    $("#addFMailingAddress").val("");
    $("#addFBank").val("");
    $("#addFAccountNumber").val("");
    $("#addFDutyParagraph").val("");
    $("#addFTel").val("");
    $("#addFQqID").val("");
    $("#addFWechatNumber").val("");
    $("#updateFSupplierName").val("");
    $("#updateFContactsName").val("");
    $("#updateFMobileTel").val("");
    $("#updateFMailingAddress").val("");
    $("#updateFBank").val("");
    $("#updateFAccountNumber").val("");
    $("#updateFDutyParagraph").val("");
    $("#updateFTel").val("");
    $("#updateFQqID").val("");
    $("#updateFWechatNumber").val("");
}

//页面回显数据
function gotoUpdate() {
    var carrentItem = $("#tb_providerManager").bootstrapTable('getSelections');
    if (carrentItem[0]) {
        $("#provider_id").val(carrentItem[0].fID);
        $("#updateFSupplierName").val(carrentItem[0].fSupplierName);
        $("#updateFContactsName").val(carrentItem[0].fContactsName);
        $("#updateFMobileTel").val(carrentItem[0].fMobileTel);
        $("#updateFMailingAddress").val(carrentItem[0].fMailingAddress);
        $("#updateFBank").val(carrentItem[0].fBank);
        $("#updateFAccountNumber").val(carrentItem[0].fAccountNumber);
        $("#updateFDutyParagraph").val(carrentItem[0].fDutyParagraph);
        $("#updateFTel").val(carrentItem[0].fTel);
        $("#updateFQqID").val(carrentItem[0].fQqID);
        $("#updateFWechatNumber").val(carrentItem[0].fWechatNumber);
        // var status="";
        // if(carrentItem[0].sTATUS==1){
        //     status+="<option value='1'>开启</option>";
        //     status+="<option value='0'>禁用</option>";
        //     $("#updateStatus").html(status);
        // }else if(carrentItem[0].sTATUS==0){
        //     status+="<option value='0'>禁用</option>";
        //     status+="<option value='1'>开启</option>";
        //     $("#updateStatus").html(status);
        // }
        $("#update_btn").click();
    } else {
        setAlert("error", "请先选择一条数据");
    }
}

