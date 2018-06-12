/**
 * Created by zhangxin on 2017/3/3.
 */
$(function () {
    //1.初始化Table
    SearchTime();
    var oTable = new TableInit();
    oTable.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_inComeMonth').bootstrapTable({
            url: 'query.do',   //请求后台的URL（*）
            method: 'post', //请求方式（*）
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页（*）
            sortable: false,      //是否启用排序
            showExport:true,    //显示导出按钮
            exportDataType: "basic",//导出类型basic', 'all', 'selected'.当前页、所有数据、选中数据
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
                field: 'fContant',
                title: '合同号'
            }, {
                field: 'fOldName',
                title: '老人姓名'
            }, {
                field: 'fIdCard',
                title: '身份证号'
            }, {
                field: 'fBeginAmount',
                title: '本月期初'
            }, {
                field: 'fArAmount',
                title: '本月应收'
            }, {
                field: 'fApAmount',
                title: '本月实收'
            }, {
                field: 'fRpayYear',
                title: '本年应收'
            }, {
                field: 'fPayYear',
                title: '本年实收'
            }, {
                field: 'fEndAmount',
                title: '期末余额'
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset, //页码
            fPaymentDate: $("#searchTime").val()
        };
        return temp;
    };
    return oTableInit;
};
function getzf(num){
    if(parseInt(num) < 10){
        num = '0'+num;
    }
    return num;
}
//下拉框
function SearchTime() {
    var date = new Date();
    $("#searchTime").val(date.getFullYear() + "-" + getzf(date.getMonth() + 1));
}

//查询
function queryInCome(){
    $.ajax({
        url:contextPath+"/inMonth/query.do",
        type:"post",
        data:{
            page:0,
            pageSize:10,
            fPaymentDate: $("#searchTime").val()
        },
        success:function(data) {
            $('#tb_inComeMonth').bootstrapTable('load', data);
        }
    });
}
function cleanData() {
    var date = new Date();
    $("#searchTime").val(date.getFullYear() + "-" + getzf(date.getMonth() + 1));
}
//关闭
function closeModal() {
}

//页面回显数据
function gotoDetail() {
    var carrentItem = $("#tb_inComeMonth").bootstrapTable('getSelections');
    if (carrentItem[0]) {
        $("#updateOldManName").val(carrentItem[0].fOldName);
        $("#updateOldManName").attr("readonly",true);
        $("#updateDuringTime").val($("#searchTime").val());
        $("#updateDuringTime").attr("readonly",true);
        var balanceAll = parseInt(carrentItem[0].fBeginAmount)+parseInt(carrentItem[0].fApAmount);
        var balance = (balanceAll-carrentItem[0].fArAmount).toFixed(6);
        $("#oldManList").html("");
        $("#oldManList").append("<tr><td></td><td>初期金额</td>" +
            "<td></td><td></td><td>"+carrentItem[0].fBeginAmount+"</td></tr>");
        $("#oldManList").append("<tr><td>1</td><td>"+carrentItem[0].fArFnumber+"</td>" +
            "<td>"+carrentItem[0].fArAmount+"</td><td></td><td>"+(carrentItem[0].fBeginAmount-carrentItem[0].fArAmount).toFixed(6)+"</td></tr>");
        $("#oldManList").append("<tr><td>2</td><td>"+carrentItem[0].fApFnumber+"</td>" +
            "<td></td><td>"+carrentItem[0].fApAmount+"</td><td>"+balance+"</td></tr>");
        $("#oldManList").append("<tr><td></td><td>期末余额</td>" +
            "<td></td><td></td><td>"+balance+"</td></tr>");
        $("#update_btn").click();
    } else {
        setAlert("error", "请先选择一条数据");
    }
}