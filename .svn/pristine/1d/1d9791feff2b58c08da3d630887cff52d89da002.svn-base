/**
 * Created by wangjs on 2016/12/26.
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
        $('#tb_leave').bootstrapTable({
            url: 'query.do',   //请求后台的URL（*）
            method: 'post',      //请求方式（*）
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页（*）
            // sortable: false,      //是否启用排序
            // sortOrder: "asc",     //排序方式
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
            height: 350,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",      //每一行的唯一标识，一般为主键列
            showToggle:true,     //是否显示详细视图和列表视图的切换按钮
            cardView: false,     //是否显示详细视图
            detailView: false,     //是否显示父子表
            columns: [{
                radio: true
            }, {
                field: 'fID',
                title: '编号',
                align: "center",
            }, {
                field: 'fOldManName',
                title: '老人',
                align: "center",
            }, {
                align: "center",
                field: 'fLeaveStatus',
                title: '状态',
                formatter:function(value){
                    if(value=="47"){
                        return '<span style="color:#00ff00">请假</span>'
                    }else if(value=="46"){
                        return '<span style="color:#FF0000">已销假</span>'
                    }
                }
            }, {
                field: 'fBuildingName',
                title: '大厦',
                align: "center",
            }, {
                field: 'fRoomName',
                title: '房间',
                align: "center",
            }, {
                field: 'fStartTime',
                title: '报价日期',
                align: "center",
            }, {
                field: 'fStopTime',
                title: '销假日期',
                align: "center",
            }, {
                field: 'fDays',
                title: '天数',
                align: "center",
            }, {
                field: 'fExplain',
                title: '说明',
                align: "center",
            }, {
                field: 'fStaffName',
                title: '办理人',
                align: "center",
            }, {
                field: 'fCreateTime',
                title: '操作日期',
                align: "center",
            } ]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset //页码
        };
        return temp;
    };
    return oTableInit;
};

//清除选项
function queryClear() {
    $("#searchOldManName").val("");
    $("#searchLeaveStatus").val("");
    $("#startTime").val("");
    $("#stopTime").val("");
}


//查询
function queryOmLeave(){
    $.ajax({
        url:contextPath+"/leave/query.do",
        type:"post",
        data:{
            fOldManName:$("#searchOldManName").val(),
            fLeaveStatus:$("#searchLeaveStatus").val(),
            fStartTime:$("#startTime").val(),
            fStopTime:$("#stopTime").val(),
            page:0,
            pageSize:10
        },
        success:function(data) {
            $('#tb_leave').bootstrapTable('load', data);
        }
    });
}

//页面回显数据
function gotoUpdate(){
    var carrentItem = $("#tb_leave").bootstrapTable('getSelections');
    if(carrentItem[0]){
        if(carrentItem[0].fLeaveStatus==2){
            setAlert("error","此老人已销假，请确认后重试");
        }else {
            $("#data_id").val(carrentItem[0].fID);
            $("#updfOldManID").val(carrentItem[0].fOldManID);
            $("#updoldManName").val(carrentItem[0].fOldManName);
            $("#updfStartTime").val(carrentItem[0].fStartTime);
            $("#updfStopTime").val(carrentItem[0].fStopTime);
            $("#fExplain").val(carrentItem[0].fExplain);
            $("#update_btn").click();
        }

    }else{
        setAlert("error","请先选择一条数据");
    }
}

//请求选择老人界面
function selectOldMan(){
    $('#oldManModal').modal('show');
    // 初始化老人列表
    initChooseOldManTb();
}
//打通过照片取老人
function getOldManWithPhoto(ID,name){
    // $("#addfOldManID").val(temp.getAttribute("selectOmId"))
    // $("#addfOldManID").html(temp.getAttribute("selectName"))
    $("#addOldManLeaveID").val(ID);
    $("#oldManLeaveName").val(name);
    // $("#addfOldManID").text(temp.getAttribute("selectName"))
    $('#oldManModal').modal('hide')
}
function add_check() {
    var result = true;

    if(!addCheck_name_leave()){
        result=false;
    }

    if(!addCheck_startTime_leave()){
        result=false;
    }


    return result;
}

function addCheck_name_leave(){
    var result = true;

    var name = $("#oldManLeaveName").val().trim();
    $("#errorOldManName").html("");
    if (name == "" || name.length == 0) {
        $("#errorOldManName").html("不能为空");
        result = false;
    }
    return result;
}

function addCheck_startTime_leave(){
    var result = true;
    var startTime = $("#addfStartTime").val().trim();
    $("#errorStartTime").html("");
    if (startTime == null||startTime.length == 0) {
        $("#errorStartTime").html("不能为空");
        result = false;
    }
    return result;
}

//新增老人请假
function addOldManLeave(){
    if(add_check()){
        if(getOldManByStatus(47)==0){
            $.ajax({
                url:contextPath+"/leave/addOldManLeave.do",
                type:"post",
                async:false,
                data:{
                    fOldManID:$("#addOldManLeaveID").val(),
                    fLeaveStatus:"47",
                    fStartTime:$("#addfStartTime").val(),
                    fExplain:$("#fExplain").val(),
                },
                success:function(data) {
                    console.log(data.success);
                    if(data.success){
                        setAlert("success",data.msg);
                    }else{
                        setAlert("error",data.msg);
                    }
                    updOldManStatus(47)
                    closeModal();
                    $('#tb_leave').bootstrapTable('refresh', {url: 'query.do'});
                }
            });
        }else{
            alert("此老人已经请假了！")
        }

    }else{
        return 0;
    }
    closeModal()
}

function getOldManByStatus(status) {
    var result="";
    $.ajax({
        url:contextPath+"/hosing/getom.do",
        type:"post",
        async:false,
        data:{
            fID:$("#addOldManLeaveID").val(),
            foldManStatusID:status
        },
        success:function(data) {
            console.log(data.message);
            result=data.total
        }
    });
    return result;
}

function updOldManStatus(state) {
    $.ajax({
        url:contextPath+"/hosing/updOldManState.do",
        type:"post",
        async:false,
        data:{
            fID:$("#addOldManLeaveID").val(),
            foldManStatusID:state
        },
        success:function(data) {
            console.log(data.message);
        }
    });

}

function closeModal() {
    $("#oldManLeaveName").val("");
    $("#addfStartTime").val("");
    $("#fExplain").val("");
    $("#addLeaveModal").modal('hide');

    $("#updfStopTime").val("");
    $("#updfExplain").val("");

    $("#updateModal").modal('hide');
}

function check_updLeave(){
    var result=true;
    var updTime = $("#updfStopTime").val().trim();
    $("#errorUpdTime").html("");
    if (updTime==""){
        $("#errorUpdTime").html("销假日期不能为空！");
        result = false;
    }

    return result;
}
//老人销假
function updOldManLeave(){
    if(check_updLeave()){
        if(getOldManByStatus(47)==0){
            alert("此老人没有请假")
        }else {
            var leaveStart=$("#updfStopTime").val();
            var leaveStop=$("#updfStartTime").val();
            leaveStart=leaveStart.replace(/-/g,"/");
            leaveStop=leaveStop.replace(/-/g,"/");
            var date1 = Date.parse(leaveStart);
            var date2 = Date.parse(leaveStop);
            var dayNum=Math.ceil((date1-date2)/(24*60*60*1000));
            $.ajax({
                url: contextPath + "/leave/updOldManLeave.do",
                type: "post",
                data: {
                    fID: $("#data_id").val(),
                    fLeaveStatus: "46",
                    fStopTime: $("#updfStopTime").val(),
                    fExplain: $("#updfExplain").val(),
                    fDays:dayNum
                },
                success: function (data) {
                    console.log(data.message);
                    updOldManStatus(46);
                    if(data.success){
                        setAlert("success", data.msg);
                    }else{
                        setAlert("error", data.msg);
                    }

                    $('#tb_leave').bootstrapTable('refresh', {url: 'query.do'});
                }
            });
        }
    }else{
        return 0;
    }
    closeModal();
}

//删除
function gotoDelete(){
    var carrentItem = $("#tb_leave").bootstrapTable('getSelections');
    if(carrentItem[0]){
        $.ajax({
            url:contextPath+"/leave/delOldManLeave.do",
            type:"post",
            data:{
                fID:carrentItem[0].fID,
            },
            success:function(data) {
                if(data.success){
                    setAlert("success",data.msg);
                }else{
                    setAlert("error",data.msg);
                }

                $('#tb_leave').bootstrapTable('refresh', {url: 'query.do'});
            }
        });
    }else{
        setAlert("error","请先选择一条数据");
    }
}