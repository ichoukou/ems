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
        $('#tb_empRewards').bootstrapTable({
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
                field: 'fStaffName',
                title: '员工姓名'
            }, {
                field: 'fRewardType',
                title: '奖惩类型'
            }, {
                field: 'fRewardReason',
                title: '奖惩原因'
            }, {
                field: 'fRewardMoney',
                title: '金额'
            }, {
                field: 'fExplain',
                title: '说明'
            }, {
                field: 'fCreatorName',
                title: '操作员'
            },{
                field: 'fCreateTime',
                title: '操作日期'
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset, //页码
            fStaffID: $("#searchName option:selected").val(),
            fRewardDate: $("#searchLeaveData option:selected").val(),
            fRewardType: $("#searchFRewardType option:selected").val(),
        };
        return temp;
    };
    return oTableInit;
};

$(document).ready(
    getDataList(),
    getemp(),
    getMonth()
)
//获得数据字典数据
function getDataList() {
    $.ajax({
        url: contextPath + "/sys/get.do",
        type: "post",
        data: {
            page: 1,
            pageSize: 100000000
        },
        success: function (data) {

            $("#searchFRewardType").html("");
            var $search = $("#searchFRewardType");
            $search.append("<option value=''>    </option>");
            for (var i = 0; i < data.total; i++) {
                if (data.rows[i].name == "奖惩类型") {
                    $search.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                }
            }

            $("#addFRewardType").html("");
            var $add = $("#addFRewardType");
            $add.append("<option value=''>    </option>");
            for (var i = 0; i < data.total; i++) {
                if (data.rows[i].name == "奖惩类型") {
                    $add.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                }
            }
        }
    });
}
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
function add_check_rewards() {
    var result=true;
    var name = $("#addFStaffName").val().trim();
    if(name==""||name.length==0){
        $("#add_FStaffName_message").html("请选择员工！");
        result = false;
    }
    var addFRewardDate = $("#addFRewardDate").val();
    if (addFRewardDate==""||addFRewardDate.length==0){
        $("#add_FRewardDate_message").html("请选择日期！");
        result = false;
    }
    var addFRewardType = $("#addFRewardType").val();
    if (addFRewardType==""||addFRewardType.length==0){
        $("#add_FRewardType_message").html("请选择类型！");
        result = false;
    }
    var addFRewardMoney = $("#addFRewardMoney").val();
    var reg =new RegExp(/[^\d]/g);
    if (addFRewardMoney==""||addFRewardMoney.length==0){
        $("#add_FRewardMoney_message").html("请输入金额！");
        result = false;
    }else if(reg.test(addFRewardMoney)){
        $("#add_FRewardMoney_message").html("请输入数字！");
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
function add_FRewardDate() {
    var name = $("#addFRewardDate").val().trim();
    $("#add_FRewardDate_message").html("");
    if (name == null || name.length == 0){
        $("#add_FRewardDate_message").html("请选择日期！");
    }
}
function add_FRewardType() {
    var name = $("#addFRewardType").val().trim();
    $("#add_FRewardType_message").html("");
    if (name == null || name.length == 0){
        $("#add_FRewardType_message").html("请选择类型！");
    }
}
function add_FRewardMoney() {
    var name = $("#addFRewardMoney").val().trim();
    var reg =new RegExp(/[^\d]/g);
    $("#add_FRewardMoney_message").html("");
    if (name == null || name.length == 0){
        $("#add_FRewardMoney_message").html("请输入奖金！");
    }else if(reg.test(name)){
        $("#add_FRewardMoney_message").html("请输入数字！");
    }
}

function update_check_rewards() {
    var result=true;
    var name = $("#updateFStaffName").val().trim();
    if(name==""||name.length==0){
        $("#update_FStaffName_message").html("请选择员工！");
        result = false;
    }
    var addFRewardDate = $("#updateFRewardDate").val();
    if (addFRewardDate==""||addFRewardDate.length==0){
        $("#add_FRewardDate_message").html("请选择日期！");
        result = false;
    }
    var addFRewardType = $("#updateFRewardType").val();
    if (addFRewardType==""||addFRewardType.length==0){
        $("#update_FRewardType_message").html("请选择类型！");
        result = false;
    }
    var addFRewardMoney = $("#updateFRewardMoney").val();
    var reg =new RegExp(/[^\d]/g);
    if (addFRewardMoney==""||addFRewardMoney.length==0){
        $("#update_FRewardMoney_message").html("请输入金额！");
        result = false;
    }else if(reg.test(addFRewardMoney)){
        $("#update_FRewardMoney_message").html("请输入数字！");
        result = false;
    }
    return result;
}
function update_FRewardDate() {
    var name = $("#updateFRewardDate").val().trim();
    $("#update_FRewardDate_message").html("");
    if (name == null || name.length == 0){
        $("#update_FRewardDate_message").html("请选择日期！");
    }
}
function update_FRewardType() {
    var name = $("#updateFRewardType").val().trim();
    $("#update_FRewardType_message").html("");
    if (name == null || name.length == 0){
        $("#update_FRewardType_message").html("请选择类型！");
    }
}
function update_FRewardMoney() {
    var name = $("#updateFRewardMoney").val().trim();
    var reg =new RegExp(/[^\d]/g);
    $("#update_FRewardMoney_message").html("");
    if (name == null || name.length == 0){
        $("#update_FRewardMoney_message").html("请输入奖金！");
    }else if(reg.test(name)){
        $("#update_FRewardMoney_message").html("请输入数字！");
    }
}
//清空
function cleanData() {
    $("#searchName").val("");
    $("#searchLeaveData").val("");
    $("#searchFRewardType").val("");
    $('#tb_empRewards').bootstrapTable('refresh', {url: 'query.do'});
}
//查询
function queryEmpRewards(){
    $.ajax({
        url:contextPath+"/rewards/query.do",
        type:"post",
        data:{
            fStaffID: $("#searchName option:selected").val(),
            fRewardDate: $("#searchLeaveData option:selected").val(),
            fRewardType: $("#searchFRewardType option:selected").val(),
            page:0,
            pageSize:10
        },
        success:function(data) {
            $('#tb_empRewards').bootstrapTable('load', data);
        }
    });
}
//得到时间
function getTimeRndString() {
     var tm=new Date();
     var str=tm.getMilliseconds()+tm.getSeconds()*60+tm.getMinutes()*3600+tm.getHours()*60*3600+tm.getDay()*3600*24+tm.getMonth()*3600*24*31+tm.getYear()*3600*24*31*12;
     return str;
}
//保存
function addRewards() {
    if(!add_check_rewards()){
        return 0;
    }else {
        var date = new Date();
        var fCreateTime = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate() + " " + date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
        var fNumber = getTimeRndString();
        var fStaffId = $("#addFStaffName option:selected").val();
        var fRewardType = $("#addFRewardType option:selected").val();
        var fRewardDate = $("#addFRewardDate").val();
        var fRewardMoney = $("#addFRewardMoney").val();
        var fRewardReason = $("#addFRewardReason").val();
        var fExplain = $("#addFExplain").val();
        $.ajax({
            url: contextPath + "/rewards/addEmpRewards.do",
            type: "post",
            data: {
                fNumber: fNumber,
                fStaffID: fStaffId,
                fRewardDate: fRewardDate,
                fRewardType: fRewardType,
                fRewardMoney: fRewardMoney,
                fRewardReason: fRewardReason,
                fExplain: fExplain,
                fCreateTime: fCreateTime,
            },
            success: function (data) {
                console.log(data.message);
                setAlert(data.message, "操作成功");
                $('#tb_empRewards').bootstrapTable('refresh', {url: 'query.do'});
                $("#add_close_btn").click();
            }
        });
    }
    closeModal();
}
//修改
function updateRewards(){
    if(!update_check_rewards()){
        return 0;
    }else {
        var date = new Date();
        var fCreateTime = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();
        $.ajax({
            url: contextPath + "/rewards/updateEmpRewards.do",
            type: "post",
            data: {
                fID: $("#Rewards_id").val(),
                // name:$("#updateName").val(),
                // attr:$("input[type='radio']:checked").val(),
                // oldHouse:$("#op option:selected").val(),
                fStaffID: $("#updateFStaffName").val(),
                fRewardDate: $("#updateFRewardDate").val(),
                fRewardType: $("#updateFRewardType").val(),
                fRewardMoney: $("#updateFRewardMoney").val(),
                fRewardReason: $("#updateFRewardReason").val(),
                fExplain: $("#updateFExplain").val(),
                fCreateTime: fCreateTime
            },
            success: function (data) {
                console.log(data.message);
                setAlert(data.message, "操作成功");
                $('#tb_empRewards').bootstrapTable('refresh', {url: 'query.do'});
                $("#update_close_btn").click();
            }
        });
    }
    closeModal();
}

//删除
function gotoDelete(){
    var carrentItem = $("#tb_empRewards").bootstrapTable('getSelections');
    if(carrentItem[0]){
        $.ajax({
            url:contextPath+"/rewards/deleteEmpRewards.do",
            type:"post",
            data:{
                fID:carrentItem[0].fID
            },
            success:function(data) {
                $('#tb_empRewards').bootstrapTable('refresh', {url: 'query.do'});

                if(data.success){
                    setAlert(data.msg,"操作成功");
                    $('#tb_empRewards').bootstrapTable('refresh', {url: 'query.do'});
                }
            }
        });
    }else{
        setAlert("error","请先选择一条数据");
    }
}


function closeModal() {
    $("#addFStaffName").val("");
    $("#addFRewardDate").val("");
    $("#addFRewardType").val("");
    $("#addFRewardMoney").val("");
    $("#addFRewardReason").val("");
    $("#addFExplain").val("");
    $("#updateFStaffName").val("");
    $("#updateFRewardDate").val("");
    $("#updateFRewardType").val("");
    $("#updateFRewardMoney").val("");
    $("#updateFRewardReason").val("");
    $("#updateFExplain").val("");
}

//页面回显数据
function gotoUpdate(){
    var carrentItem = $("#tb_empRewards").bootstrapTable('getSelections');
    if(carrentItem[0]){

        $.ajax({
            url: contextPath + "/sys/get.do",
            type: "post",
            data: {
                page: 0,
                pageSize: 1000000
            },
            success: function (data) {
                $("#updateFRewardType").html("");
                var $update = $("#updateFRewardType");
                $update.append("<option value=''>    </option>");
                for (var i = 0; i < data.total; i++) {
                    if (data.rows[i].name == "奖惩类型") {
                        if (data.rows[i].value == carrentItem[0].fRewardType) {
                            $update.append("<option value='" + data.rows[i].value + "' selected='selected'>" + data.rows[i].value + "</option>");
                        }else {
                            $update.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                        }
                    }
                }
            }
        });
        $.ajax({
            url:contextPath+"/employee/query.do",
            type:"post",
            data:{
                page:0,
                pageSize:100000000
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
        $("#Rewards_id").val(carrentItem[0].fID);
        $("#updateFStaffName").val(carrentItem[0].fStaffName);
        $("#updateFRewardDate").val(carrentItem[0].fRewardDate);
        $("#updateFRewardMoney").val(carrentItem[0].fRewardMoney);
        $("#updateFRewardReason").val(carrentItem[0].fRewardReason);
        $("#updateFExplain").val(carrentItem[0].fExplain);
        $("#updateFRewardType option[value='"+carrentItem[0].fRewardType+"']").attr("selected", true);
        // $("#updateFStaffName").val(carrentItem[0].name);
        // $("input[type='radio'][value="+carrentItem[0].attr+"]").attr("checked",'checked');
        // $("#updateFStaffName option[value='"+carrentItem[0].oldHouse+"']").attr("selected", true);
        $("#update_btn").click();
    }else{
        setAlert("error","请先选择一条数据");
    }
}