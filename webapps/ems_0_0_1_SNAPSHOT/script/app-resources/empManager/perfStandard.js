$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_perfStandard').bootstrapTable({
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
            height: 350,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
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
                field: 'fAssessmentResult',
                title: '考核结果'
            }, {
                field: 'fCoefficient',
                title: '考核系数'
            } , {
                field: 'fLowerLimit',
                title: '分值下限'
            } , {
                field: 'fHighLimit',
                title: '分值上限'
            } ]
        });
    };
    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset, //页码
        };
        return temp;
    };
    return oTableInit;
};
//新增等级范围
function addStandard(){
    //获得当前时间
    var date = new Date();
    var fCreateTime = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
        $.ajax({
            url:contextPath+"/standard/addStandard.do",
            type:"post",
            data:{
                fLowerLimit:$("#addFLowerLimit").val(),
                fHighLimit:$("#addFHighLimit").val(),
                fCoefficient:$("#addFCoefficient").val(),
                fAssessmentResult:$("#addFAssessmentResult").val(),
                fCreateTime:fCreateTime
            },
            success:function(data) {
                console.log(data.message);
                $('#tb_perfStandard').bootstrapTable('refresh', {url: 'query.do'});
                setAlert(data.message,"操作成功");
            }
        });

    closeModal();
}

//修改等级范围
function updateStandard(){

    var date = new Date();
    var fCreateTime = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
    $.ajax({
        url:contextPath+"/standard/updateStandard.do",
        type:"post",
        data:{
            fID:$("#standard_id").val(),
            fLowerLimit:$("#updateFLowerLimit").val(),
            fHighLimit:$("#updateFHighLimit").val(),
            fCoefficient:$("#updateFCoefficient").val(),
            fAssessmentResult:$("#updateFAssessmentResult").val(),
            fCreateTime:fCreateTime
        },
        success:function(data) {
            console.log(data.message);
            $('#tb_perfStandard').bootstrapTable('refresh', {url: 'query.do'});
            setAlert(data.message,"操作成功");
        }
    });
    closeModal();
}

//等级范围  删除
function gotoDelete(){
    var carrentItem = $("#tb_perfStandard").bootstrapTable('getSelections');
    if(carrentItem[0]){
        $.ajax({
            url:contextPath+"/standard/deleteStandard.do",
            type:"post",
            data:{
                fID:carrentItem[0].fID

            },
            success:function(data) {
                $('#tb_perfStandard').bootstrapTable('refresh', {url: 'query.do'});

                if(data.success){
                    setAlert(data.msg,"操作成功");
                }else{

                }
            }
        });
    }else{
        setAlert("error","请先选择一条数据");
    }
}

function closeModal() {
    $("#addFLowerLimit").val("");
    $("#addFHighLimit").val("");
    $("#addFCoefficient").val("");
    $("#addFAssessmentResult").val("");
    $("#updateFLowerLimit").val("");
    $("#updateFHighLimit").val("");
    $("#updateFCoefficient").val("");
    $("#updateFAssessmentResult").val("");
}

//页面回显数据
function gotoUpdate(){
    var carrentItem = $("#tb_perfStandard").bootstrapTable('getSelections');
    if(carrentItem[0]){
        $("#standard_id").val(carrentItem[0].fID);
        $("#updateFLowerLimit").val(carrentItem[0].fLowerLimit);
        $("#updateFHighLimit").val(carrentItem[0].fHighLimit);
        $("#updateFCoefficient").val(carrentItem[0].fCoefficient);
        $("#updateFAssessmentResult").val(carrentItem[0].fAssessmentResult);
        $("#update_btn").click();
    }else{
        setAlert("error","请先选择一条数据");
    }
}

