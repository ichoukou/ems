$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});
/**
 * 张鑫
 * @returns {Object}
 * @constructor
 */
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_empLeave').bootstrapTable({
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
                field: 'fId',
                title: '编号'
            }, {
                field: 'fStaffName',
                title: '员工姓名'
            }, {
                field: 'fStartTime',
                title: '请假日期'
            }, {
                field: 'fStopTime',
                title: '销假日期'
            }, {
                field: 'fLeaveReason',
                title: '请假事由'
            }, {
                field: 'fExplain',
                title: '说明'
            }, {
                field: 'fCreatorName',
                title: '操作人'
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset, //页码
            fStaffId: $("#searchName option:selected").val(),
            fStartTime: $("#searchLeaveData option:selected").val()
        };
        return temp;
    };
    return oTableInit;
};

$(document).ready(
    getemp(),
    getMonth()
)
//获得月份
function getMonth() {
    var now = new Date(); //当前日期
    var nowYear = now.getYear(); //当前年
    var nowYearQuarter = (now.getFullYear())+"-"+(now.getMonth()+1)+"-"+now.getDate();
    if(now.getMonth()+1>0&&now.getMonth()+1<10){
        var nowYearMonth = (now.getFullYear())+"-0"+(now.getMonth()+1);
    }else {
        var nowYearMonth = (now.getFullYear())+"-"+(now.getMonth()+1); //当前年月
    }
    console.log(now.getMonth());
    if(now.getMonth()+1>9){
        var yearBeforeMonth = (now.getFullYear())+"-"+now.getMonth(); //当前年，上个月
    }else if(now.getMonth()+1>1&&now.getMonth()+1<10) {
        var yearBeforeMonth = (now.getFullYear())+"-0"+now.getMonth();
    }else if(now.getMonth()==0){
        var yearBeforeMonth = (now.getFullYear()-1)+"-"+"12"; //去年，12月
    }
    nowYear += (nowYear < 2000) ? 1900 : 0;
    var lastMonthDate = new Date(); //上月日期
    lastMonthDate.setDate(1);
    lastMonthDate.setMonth(lastMonthDate.getMonth() - 1);
    var lastMonth = lastMonthDate.getMonth();
    function formatDate(date) {
        var myyear = date.getFullYear();
        var mymonth = date.getMonth() + 1;
        var myweekday = date.getDate();

        if (mymonth < 10) {
            mymonth = "0" + mymonth;
        }
        if (myweekday < 10) {
            myweekday = "0" + myweekday;
        }
        return (myyear + "-" + mymonth + "-" + myweekday);
    }
    $("#searchLeaveData").html("");
    var $search = $("#searchLeaveData");
    $search.append("<option value=''>    </option>");
    $search.append("<option value='"+nowYearMonth+"'>本月</option>");
    $search.append("<option value='"+yearBeforeMonth+"'>上月</option>");
    $search.append("<option value='"+ nowYearQuarter+"'>本季度</option>");
    $search.append("<option value='"+nowYear+"'>本年</option>");
}
//得到员工信息
function getemp() {
    $.ajax({
        url:contextPath+"/employee/query.do",
        type:"post",
        data:{
            page:0,
            pageSize:10000000
        },
        success:function(data) {
            $("#searchName").html("");
            var $add=$("#searchName");
            $add.append("<option value=''>选择员工</option>");
            for (var i=0;i<data.total;i++){
                if(data.rows[i].fState=="1")
                $add.append("<option value='"+data.rows[i].fId+"'>"+data.rows[i].fStaffName+"</option>");
            }

           $("#addFStaffName").html("");
             var $add=$("#addFStaffName");
             $add.append("<option value=''>选择员工</option>");
             for (var i=0;i<data.total;i++){
                 if(data.rows[i].fState=="1")
             $add.append("<option value='"+data.rows[i].fId+"'>"+data.rows[i].fStaffName+"</option>");
             }
        }
    });
}
//验证
function add_check_leave() {
    var result=true;
    var name = $("#addFStaffName").val().trim();
    if(name==""||name.length==0){
        $("#add_FStaffName_message").html("请选择员工！");
        result = false;
    }
    var addFStartTime = $("#addFStartTime").val();
    if (addFStartTime==""||addFStartTime.length==0){
        $("#add_FStartTime_message").html("请选择日期！");
        result = false;
    }
    var addFStopTime = $("#addFStopTime").val();
    if (addFStopTime==""||addFStopTime.length==0){
        $("#add_FStopTime_message").html("请选择日期！");
        result = false;
    }
    return result;
}
function add_FStaffName() {
    var name = $("#addFStaffName").val().trim();
    $("#add_FStaffName_message").html("");
    if (name == null || name.length == 0){
        $("#add_FStaffName_message").html("请选择员工姓名！");
    }
}
function add_FStartTime() {
    var name = $("#addFStartTime").val().trim();
    $("#add_FStartTime_message").html("");
    if (name == null || name.length == 0){
        $("#add_FStartTime_message").html("请选择日期！");
    }
}
function add_FStopTime() {
    var name = $("#addFStopTime").val().trim();
    $("#add_FStopTime_message").html("");
    if (name == null || name.length == 0){
        $("#add_FStopTime_message").html("请选择日期！");
    }
}

function update_check_leave() {
    var result=true;
    var updateFStartTime = $("#updateFStartTime").val();
    if (updateFStartTime==""||updateFStartTime.length==0){
        $("#update_FStartTime_message").html("请选择日期！");
        result = false;
    }
    var updateFStopTime = $("#updateFStopTime").val();
    if (updateFStopTime==""||updateFStopTime.length==0){
        $("#update_FStopTime_message").html("请选择日期！");
        result = false;
    }
    return result;
}
function update_FStartTime() {
    var name = $("#updateFStartTime").val().trim();
    $("#update_FStartTime_message").html("");
    if (name == null || name.length == 0){
        $("#update_FStartTime_message").html("请选择日期！");
    }
}
function update_FStopTime() {
    var name = $("#updateFStopTime").val().trim();
    $("#update_FStopTime_message").html("");
    if (name == null || name.length == 0){
        $("#update_FStopTime_message").html("请选择日期！");
    }
}
//清空
function cleanData() {
        $("#searchName").val("");
        $("#searchLeaveData").val("");
        $('#tb_empLeave').bootstrapTable('refresh', {url: 'query.do'});
}
//查询
function queryEmpLeave(){
    $.ajax({
        url:contextPath+"/employ/query.do",
        type:"post",
        data:{
            fStaffId: $("#searchName option:selected").val(),
            fStartTime: $("#searchLeaveData option:selected").val(),
            page:0,
            pageSize:10
        },
        success:function(data) {
            $('#tb_empLeave').bootstrapTable('load', data);
        }
    });
}
//保存
function addLeave() {
    if(!add_check_leave()||!addTimeCheck()){
        return 0;
    }else {
    var date = new Date();
    var fCreateTime = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
    var fStaffId = $("#addFStaffName option:selected").val();
    var fStartTime = $("#addFStartTime").val();
    var fStopTime  = $("#addFStopTime").val();
    var fLeaveReason = $("#addFLeaveReason").val();
    var fExplain   = $("#addFExplain").val();
    var fWhenLong =  ((new Date(fStopTime)).getTime()-(new Date(fStartTime)).getTime())/ 1000 / 60 / 60 / 24;
    $.ajax({
            url: contextPath + "/employ/addEmpLeave.do",
            type: "post",
            data: {
                fStaffId: fStaffId,
                fStartTime: fStartTime,
                fStopTime: fStopTime,
                fLeaveReason:fLeaveReason,
                fExplain:fExplain,
                fCreateTime: fCreateTime,
                fWhenLong:fWhenLong
            },
            success: function (data) {
                console.log(data.message);
                setAlert(data.message, "操作成功");
                $('#tb_empLeave').bootstrapTable('refresh', {url: 'query.do'});
                $("#add_close_btn").click();
            }
        });
    }
    closeModal();
}
//修改
function updateLeave(){
    if (!update_check_leave()||!updateTimeCheck()){
        return 0;
    }else {
        var date = new Date();
        var fCreateTime = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
        var fStartTime = $("#updateFStartTime").val();
        var fStopTime = $("#updateFStopTime").val();
        var fWhenLong = ((new Date(fStopTime)).getTime() - (new Date(fStartTime)).getTime()) / 1000 / 60 / 60 / 24;
        $.ajax({
            url: contextPath + "/employ/updateEmpLeave.do",
            type: "post",
            data: {
                fId: $("#Leave_id").val(),
                // name:$("#updateName").val(),
                // attr:$("input[type='radio']:checked").val(),
                // oldHouse:$("#op option:selected").val(),
                fStaffId: $("#updateFStaffName").val(),
                fStartTime: $("#updateFStartTime").val(),
                fStopTime: $("#updateFStopTime").val(),
                fLeaveReason: $("#updateFLeaveReason").val(),
                fExplain: $("#updateFExplain").val(),
                fCreateTime: fCreateTime,
                fWhenLong: fWhenLong
            },
            success: function (data) {
                console.log(data.message);
                setAlert(data.message, "操作成功");
                $('#tb_empLeave').bootstrapTable('refresh', {url: 'query.do'});
                $("#update_close_btn").click();
            }
        });
    }
    closeModal();
}

//验证增加时同一员工请假时间不重复
function addTimeCheck(){
    var fStartTime = $("#addFStartTime").val();
    var fStopTime  = $("#addFStopTime").val();
    var result=true;
    $.ajax({
        url: contextPath + "/employ/addTimeCheck.do",
        type: "post",
        async:false,
        data: {
            fStaffId:$("#addFStaffName option:selected").val()
        },
        success: function (data) {
            for(var i=0;i<data.total;i++){
                if(fStartTime<data.rows[i].fStopTime&&fStopTime>data.rows[i].fStartTime){
                    $("#time_message").html("该员工在此期间已经请过假了");
                    result = false;
                }
            }
        }
    });
    return result;
}

//验证更新时同一员工请假时间不重复
function updateTimeCheck(){
    var fStartTime = $("#updateFStartTime").val();
    var fStopTime = $("#updateFStopTime").val();
    var result = true;
    $.ajax({
        url: contextPath + "/employ/updateTimeCheck.do",
        type: "post",
        async: false,
        data: {
            fId: $("#Leave_id").val(),
            fStaffId: $("#updateFStaffName option:selected").val()
        },
        success: function (data) {
            for (var i = 0; i < data.total; i++) {
                if (fStartTime < data.rows[i].fStopTime && fStopTime > data.rows[i].fStartTime) {
                    $("#up_time_message").html("该员工在此期间已经请过假了");
                    result = false;
                }
            }
        }
    });
    return result;
}

//字典删除
function gotoDelete(){
    var carrentItem = $("#tb_empLeave").bootstrapTable('getSelections');
    if(carrentItem[0]){
        $.ajax({
            url:contextPath+"/employ/deleteEmpLeave.do",
            type:"post",
            data:{
                fId:carrentItem[0].fId
            },
            success:function(data) {
                $('#tb_empLeave').bootstrapTable('refresh', {url: 'query.do'});

                if(data.success){
                    setAlert(data.msg,"操作成功");
                    $('#tb_empLeave').bootstrapTable('refresh', {url: 'query.do'});
                }
            }
        });
    }else{
        setAlert("error","请先选择一条数据");
    }
}


function closeModal() {
    $("#addFStaffName").val("");
    $("#addFStartTime").val("");
    $("#addFStopTime").val("");
    $("#addFLeaveReason").val("");
    $("#time_message").html("");
    $("#addFExplain").val("");
    $("#updateFStaffName").val("");
    $("#updateFStartTime").val("");
    $("#updateFStopTime").val("");
    $("#updateFLeaveReason").val("");
    $("#updateFExplain").val("");
    $("#up_time_message").html("");
}


//页面回显数据
function gotoUpdate(){
    var carrentItem = $("#tb_empLeave").bootstrapTable('getSelections');
    if(carrentItem[0]){
        $.ajax({
            url:contextPath+"/employee/query.do",
            type:"post",
            data:{
                page:0,
                pageSize:10000000
            },
            success:function(data) {
                $("#updateFStaffName").html("");
                var updateFStaffName=$("#updateFStaffName");
                updateFStaffName.append("<option value=''>选择员工</option>");
                for (var i=0;i<data.total;i++) {
                    if (data.rows[i].fStaffName == carrentItem[0].fStaffName && data.rows[i].fState!="0") {
                        updateFStaffName.append("<option value='" + data.rows[i].fId + "' selected='selected' >" + data.rows[i].fStaffName + "</option>");
                    } else if(data.rows[i].fStaffName == carrentItem[0].fStaffName && data.rows[i].fState=="0"){
                        updateFStaffName.append("<option value='" + data.rows[i].fId + "' selected='selected' >" + data.rows[i].fStaffName  + "&nbsp;&nbsp; 已禁用</option>");
                    } else if(data.rows[i].fStaffName != carrentItem[0].fStaffName && data.rows[i].fState=="1"){
                        updateFStaffName.append("<option value='" + data.rows[i].fId + "'>" + data.rows[i].fStaffName + "</option>");
                    }
                }
            }
        });
        $("#Leave_id").val(carrentItem[0].fId);
        $("#updateFStartTime").val(carrentItem[0].fStartTime);
        $("#updateFStopTime").val(carrentItem[0].fStopTime);
        $("#updateFLeaveReason").val(carrentItem[0].fLeaveReason);
        $("#updateFExplain").val(carrentItem[0].fExplain);
        $("#updateFStaffName option[value='"+carrentItem[0].fStaffId+"']").attr("selected", true);
        // $("#updateFStaffName").val(carrentItem[0].name);
        // $("input[type='radio'][value="+carrentItem[0].attr+"]").attr("checked",'checked');
        // $("#updateFStaffName option[value='"+carrentItem[0].oldHouse+"']").attr("selected", true);
        $("#update_btn").click();
    }else{
        setAlert("error","请先选择一条数据");
    }
}