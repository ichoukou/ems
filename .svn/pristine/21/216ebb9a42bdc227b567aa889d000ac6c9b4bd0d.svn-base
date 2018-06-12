$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_Building').bootstrapTable({
            url: 'query.do',   //请求后台的URL（*）
            method: 'post',      //请求方式（*）
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页（*）
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
                valign: "middle",
            }, {
                field: 'fBuildingName',
                title: '大厦名称',
                align: "center",
                valign: "middle",
            }, {
                field: 'fStatusStr',
                title: '状态',
                align: "center",
                valign: "middle",
            },  {
                field: 'fExplain',
                title: '说明',
                align: "center",
                valign: "middle",
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset, //页码
            fBuildingName: $("#searchName").val(),
            fStatus: $("#searchValue").val()
        };
        return temp;
    };
    return oTableInit;
};
function queryClear(){
    $("#searchName").val(""),
    $("#searchValue").val("")
}

//查询大厦
function queryDictionary(){
    $.ajax({
        url:contextPath+"/building/query.do",
        type:"post",
        data:{
            fBuildingName:$("#searchName").val(),
            fStatus:$("#searchValue").val(),
            page:0,
            pageSize:10
        },
        success:function(data) {
            $('#tb_Building').bootstrapTable('refresh', {url: 'query.do'});
        }
    });
}

function check_add(){
    var result=true;

    if(!check_addName()){
        result=false;
    }

    if(!check_addfStatus()){
        result=false;
    }

    return result;
}

function check_addName(){
    var result=true;
    var addName = $("#addName").val().trim();
    $("#errorName").html("");
    if (addName==""){
        $("#errorName").html("请填写大厦名称！");
        result = false;
    }
    return result;
}

function check_addfStatus(){
    var result=true;
    var addfStatus = $("#addfStatus").val().trim();
    $("#errorType").html("");
    if (addfStatus==""){
        $("#errorType").html("请选择大厦状态");
        result = false;
    }
    return result;
}

//新增大厦
function addBuilding(){
    if(check_add()){
        $.ajax({
            url:contextPath+"/building/addBuilding.do",
            type:"post",
            data:{

                fBuildingNumber:$("#addfBuildingNumber").val(),
                fBuildingName:$("#addName").val(),
                fAdministratorsID:$("#addfAdministratorsID").val(),

                fStatus:$("#addfStatus").val(),
                fExplain:$("#addfExplain").val()
            },
            success:function(data) {
                console.log(data.message);
                if(data.success){
                    setAlert("success",data.msg);
                }else{
                    setAlert("error",data.msg);
                }
                $('#tb_Building').bootstrapTable('refresh', {url: 'query.do'});
            }
        });
    }else{
        return 0;
    }

    closeModal();
}

function closeModal() {
    $("#addName").val("");
    $("#addfStatus").val("");
    $("#addfExplain").val("");
    $("#addModal").modal("hide");

    $("#updChrgeStopDate").val();
    $("#updStatus").val();
    $("#updExplain").val();
    $("#updateModal").modal("hide")
}
function check_upd(){
    var result=true;
    var updName = $("#updName").val().trim();
    $("#errorUpdName").html("");
    if (updName==""){
        $("#errorUpdName").html("大厦名称不能为空！");
        result = false;
    }

    // var addfStatus = $("#addfStatus").val().trim();
    // $("#errorType").html("");
    // if (addfStatus==""){
    //     $("#errorType").html("请选择大厦状态");
    //     result = false;
    // }
    return result;
}
//修改大厦
function updBuilding(){
    if(check_upd()){
        $.ajax({
            url:contextPath+"/building/updBuilding.do",
            type:"post",
            data:{
                fID:$("#building_id").val(),

                fBuildingName:$("#updName").val(),
                fStatus:$("#updfStatus").val(),
                fExplain:$("#updfExplain").val()
            },
            success:function(data) {
                console.log(data.message);
                if(data.success){
                    setAlert("success",data.msg);
                }else{
                    setAlert("error",data.msg);
                }
                $('#tb_Building').bootstrapTable('refresh', {url: 'query.do'});
            }
        });
    }else{
        return 0;
    }

    closeModal();
}

//删除大厦
function gotoDelete(){
    var carrentItem = $("#tb_Building").bootstrapTable('getSelections');
    if(carrentItem[0]){
        $.ajax({
            url:contextPath+"/building/delBuilding.do",
            type:"post",
            data:{
                fID:carrentItem[0].fID
            },
            success:function(data) {
                if(data.success){
                    setAlert("success",data.msg);
                }else{
                    setAlert("error",data.msg);
                }
                $('#tb_Building').bootstrapTable('refresh', {url: 'query.do'});
            }
        });
    }else{
        setAlert("error","请先选择一条数据");
    }
}

//页面回显数据
function gotoUpdate(){
    var carrentItem = $("#tb_Building").bootstrapTable('getSelections');
    if(carrentItem[0]){
        $("#building_id").val(carrentItem[0].fID);

        $("#updName").val(carrentItem[0].fBuildingName);
        $("#updfStatus").val(carrentItem[0].fStatus);
        $("#updfExplain").val(carrentItem[0].fExplain);
        $("#update_btn").click();
    }else{
        setAlert("error","请先选择一条数据");
    }
}
