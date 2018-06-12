$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_perfMainTain').bootstrapTable({
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
                field: 'fStaffName',
                title: '员工'
            }, {
                field: 'fPerformanceYear',
                title: '考核年份'
            } , {
                field: 'fPerformanceMonth',
                title: '考核月份'
            } , {
                field: 'fPerformanceDate',
                title: '考核日期'
            },{
                field: 'fTotal',
                title: '总分'
            },{
                field: 'fCoefficient',
                title: '考核系数'
            },{
                field: 'fPerformanceResult',
                title: '考核结果'
            }]
        });
    };
    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset, //页码
            fStaffID: $("#searchName option:selected").val()
        };
        return temp;
    };
    return oTableInit;
};
//添加验证
function addCheck() {
    var name = $("#addFStaffName").val();
    var result=true;
    if ((name == null || name.length == 0)) {
        $("#add_name_message").html("请选择项目员工！");
        result = false;
    }
    var addSum = $("#addFScore").val();
    if(addSum==""){
        $("#add_score_message").html("请填入分数！");
        result = false;
    }
    return result;
}
//更新验证
function updateCheck() {
    var result=true;
    var updateSum = $("#updateFScore").val();
    if(updateSum==""){
        $("#update_name_message").html("请选择项目员工！");
        result = false;
    }
    return result;
}

//添加员工姓名验证
function addFStaffName() {
    $("#add_name_message").html("");
    if($("#addFStaffName").val()!=""){
        $("#add_name_message").html("");
    }else {
        $("#add_name_message").html("请选择项目员工！");
    }
}

function queryMaintain(){
    $.ajax({
        url:contextPath+"/maintain/query.do",
        type:"post",
        data:{
            fStaffID: $("#searchName option:selected").val(),
            fPerformanceYear:$("#searchFPerformanceYear option:selected").val(),
            fPerformanceMonth:$("#searchFPerformanceMonth option:selected").val(),
            page:0,
            pageSize:10
        },
        success:function(data) {
            $('#tb_perfMainTain').bootstrapTable('load', data);
        }
    });
}

function cleanData() {
    $("#searchName").val("");
    $("#searchFPerformanceYear").val("");
    $("#searchFPerformanceMonth").val("");
}

$(document).ready(
    getDataList(),
    getemp(),
    getQuery()
)
function getQuery() {
    var date = new Date();
    var fYear = date.getFullYear();
    var fMonth = date.getMonth()+1;
    $("#searchFPerformanceYear").html("");
    var $searchYear = $("#searchFPerformanceYear");
    $searchYear.append("<option value=''>选择一个年份</option>");
    for (var i=2016;i<2050;i++){
        $searchYear.append("<option value='"+i+"'>"+i+"年</option>");
    }
    $("#searchFPerformanceMonth").html("");
    var $searchMonth = $("#searchFPerformanceMonth");
    $searchMonth.append("<option value=''>选择一个月份</option>");
    for (var i=1;i<13;i++){
        $searchMonth.append("<option value='"+i+"'>"+i+"月</option>");
    }
}

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
//得到数据字典的数据
var arr=[];
var ary=[];
var count;
function getDataList() {
    $.ajax({
        url:contextPath+"/maintain/showDCName.do",
        type:"post",
        dataType:'json',
        success:function(data) {
            count = data.total;
            $("#table").html("");
            var $tab1 = $("#table").append("<tr>"+
                "<td width='90px' style='vertical-align:middle; text-align:center;'>序号</td>"+
                "<td width='90px' style='vertical-align:middle; text-align:center;'>定级项目</td>"+
                "<td width='190px' style='vertical-align:middle; text-align:center;'>项目内容</td>"+
                "<td style='vertical-align:middle; text-align:center;'>分值</td>"+
                "</tr>");
            for (var i = 0; i < data.total; i++) {
                $tab1.append("<tr id=" + "tr" + i + "></tr>");
            }
            for (var i = 0; i < data.total; i++) {
                $("#tr" + i + "").append(
                    "<td style='vertical-align:middle; text-align:center;'>"+(i+1)+"</td>"+
                    "<input type='hidden' name='DC_ID' id='"+data.rows[i].DC_ID+"'>"+
                    "<td style='vertical-align:middle; text-align:center;'>"+data.rows[i].DC_NAME + "</td>" +
                    "<td style='vertical-align:middle; text-align:center;'>"+data.rows[i].DC_VALUE+"</td>" +
                    "<td style='vertical-align:middle; text-align:center; padding: 0px'>" +
                    "<input name='inp-sum' class='inp-sum' id='" + "inp" + i + "' placeholder='请输入1-5的数字' style='border:none;text-align:center;height: 33px;'>" +
                    "</td>");
            }
            //输入框限制1-5之间的数字
            $('input').keyup(function() {
                var c = $(this);
                var temp_amount = c.val().replace(/[^\d]/g, '');
                temp_amount = temp_amount < 1 ? "": temp_amount > 5 ? 5 : temp_amount;
                $(this).val(temp_amount);
            });
            //得到子表信息
            var ary1 = document.getElementsByName("DC_ID");
            for(var i=0;i<ary1.length;i++){
                arr+=ary1[i].id+',';
            }
            console.log(arr)
                for(var i=0;i<data.total;i++){
                    (function(i){
                        $("#inp"+i+"").keyup(function() {
                            $("#inp"+i+"").val();
                            var ary2 = document.getElementsByName("inp-sum");
                            for(var i=0;i<ary2.length;i++){
                                ary+=ary2[i].value+',';
                            }
                            var num=0;
                            for(var j=0;j<data.total;j++) {
                                (function(j){
                                    num=num+parseInt($("#inp"+j+"").val());
                                    if(!isNaN(num)) {
                                        $("#addFScore").val(num);
                                        $("#add_score_message").html("");
                                    }else{
                                        $("#addFScore").val("");
                                        $("#add_score_message").html("请填入分数！");
                                    }
                                })(j);
                            }
                            if (!isNaN(num)) {
                                $.ajax({
                                    url: contextPath + "/maintain/showSum.do",
                                    type: "post",
                                    dataType: 'json',
                                    data: {
                                        SUM: num
                                    },
                                    success: function (data) {
                                        $("#addFCoefficient").val(data.rows[0].FCoefficient);
                                        $("#addFPerformanceResult").val(data.rows[0].FAssessmentResult);
                                        console.log(data.message);
                                    }
                                });
                            }
                            else {
                                $("#addFCoefficient").val("");
                                $("#addFPerformanceResult").val("");
                            }
                        })
                    })(i);
                }
        }
    });
    arr="";
    ary="";
}
//得到时间
function getTimeRndString() {
    var tm=new Date();
    var str=tm.getMilliseconds()+tm.getSeconds()*60+tm.getMinutes()*3600+tm.getHours()*60*3600+tm.getDay()*3600*24+tm.getMonth()*3600*24*31+tm.getYear()*3600*24*31*12;
    return str;
}
// /新增等级范围
function addMaintain(){
    if(!addCheck()){
        return 0;
    }else {
    //获得当前时间
    var fNumber = getTimeRndString();
    var date = new Date();
    var fCreateTime = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
    var fYear = date.getFullYear();
    var fMonth = date.getMonth()+1;
    $.ajax({
        url:contextPath+"/maintain/addMaintain.do",
        type:"post",
        data:{
            fStaffID:$("#addFStaffName option:selected").val(),
            fNumber:fNumber,
            fPerformanceDate:fCreateTime,
            fPerformanceYear:fYear,
            fPerformanceMonth:fMonth,
            fTotal:$("#addFScore").val(),
            fCoefficient:$("#addFCoefficient").val(),
            fPerformanceResult:$("#addFPerformanceResult").val(),
            fCreateTime:fCreateTime,
            fProjectID:arr,
            fScore:ary,
            count:count
        },
        success:function(data) {
            console.log(data.message);
            $('#tb_perfMainTain').bootstrapTable('refresh', {url: 'query.do'});
            setAlert(data.message,"操作成功");
            $("#add_close_btn").click();
        }
    });
    }
    closeModal();
}

//修改等级范围
function updateMaintain(){
    if(!updateCheck()){
        return 0;
    }else {
    var date = new Date();
    var fYear = date.getFullYear();
    var fMonth = date.getMonth()+1;
    var fCreateTime = date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate();
    var fNumber = getTimeRndString();
    $.ajax({
        url:contextPath+"/maintain/updateMaintain.do",
        type:"post",
        data:{
            fID:$("#miantain_id").val(),
            fStaffID:$("#updateFStaffName option:selected").val(),
            fNumber:fNumber,
            fPerformanceDate:fCreateTime,
            fPerformanceYear:fYear,
            fPerformanceMonth:fMonth,
            fTotal:$("#updateFScore").val(),
            fCoefficient:$("#updateFCoefficient").val(),
            fPerformanceResult:$("#updateFPerformanceResult").val(),
            fCreateTime:fCreateTime,
            DCID:DCID,
            DCScore:DCScore,
            DCCount:DCCount,
            DCProjectID:DCProjectID
        },
        success:function(data) {
            console.log(data.message);
            $('#tb_perfMainTain').bootstrapTable('refresh', {url: 'query.do'});
            setAlert(data.message,"操作成功");
            $("#update_close_btn").click();
        }
    });
    }
    closeModal();
}

//删除
function gotoDelete(){
    var carrentItem = $("#tb_perfMainTain").bootstrapTable('getSelections');
    if(carrentItem[0]){
        $.ajax({
            url: contextPath + "/maintain/deleteMaintain.do",
            type: "post",
            data: {
                fID: carrentItem[0].fID//主表中的FID，子表中的FNUMBER
            },
            success: function (data) {
                $('#tb_perfMainTain').bootstrapTable('refresh', {url: 'query.do'});
                if (data.success) {
                    setAlert(data.msg, "操作成功");
                    $('#tb_perfMainTain').bootstrapTable('refresh', {url: 'query.do'});
                }
            }
        });
    }else{
        setAlert("error","请先选择一条数据");
    }
}

function closeModal() {
    $("#addFScore").val("");
    $("#addFCoefficient").val("");
    $("#addFStaffName").val("");
    $("#addFPerformanceResult").val("");
    var inp = document.getElementsByName("inp-sum");
    for(var i=0;i<inp.length;i++){
        inp[i].value="";
    }
    $("#add_inp").hide();
    $("#updateFScore").val("");
    $("#updateFCoefficient").val("");
    $("#updateFStaffName").val("");
    $("#updateFPerformanceResult").val("");

}

//页面回显数据
var DCID=[];
var DCScore=[];
var DCProjectID=[];
var DCCount;
var list1="";
function gotoUpdate(){
    var carrentItem = $("#tb_perfMainTain").bootstrapTable('getSelections');
    if(carrentItem[0]){
        $(document).ready(
            getList(),
            getEmp()
        )
        function getList() {
            $.ajax({
                url:contextPath+"/maintain/queryScore.do",
                type:"post",
                data:{
                    fNumber:carrentItem[0].fID
                },
                success:function(data) {
                    for (var i=0;i<data.total;i++){
                        DCID+=data.rows[i].FID+',';
                    }
                    list1=data;
                    getDCname();
                }
            });
            DCID="";
        }
        function getEmp() {
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
                            updateFStaffName.append("<option disabled='disabled' value='" + data.rows[i].fId + "' selected='selected' >" + data.rows[i].fStaffName  + "&nbsp;&nbsp; 已禁用</option>");
                        } else if(data.rows[i].fStaffName != carrentItem[0].fStaffName && data.rows[i].fState=="1"){
                            updateFStaffName.append("<option value='" + data.rows[i].fId + "'>" + data.rows[i].fStaffName + "</option>");
                        }
                    }
                }
            });
        }
        function getDCname() {
            $.ajax({
                url:contextPath+"/maintain/showDCName.do",
                type:"post",
                dataType:'json',
                success:function(data) {
                    DCCount = data.total;
                    console.log(DCCount);
                    $("#updateTable").html("");
                    var $updateTable = $("#updateTable").append("<tr>"+
                        "<td width='90px' style='vertical-align:middle; text-align:center;'>序号</td>"+
                        "<td width='90px' style='vertical-align:middle; text-align:center;'>定级项目</td>"+
                        "<td width='190px' style='vertical-align:middle; text-align:center;'>项目内容</td>"+
                        "<td style='vertical-align:middle; text-align:center;'>分值</td>"+
                        "</tr>");
                    for (var i = 0; i < data.total; i++) {
                        $updateTable.append("<tr id=" + "ty" + i + "></tr>");
                    }
                    for (var i = 0; i < data.total; i++) {
                        $("#ty" + i + "").append(
                            "<td style='vertical-align:middle; text-align:center;'>"+(i+1)+"</td>"+
                            "<input type='hidden' name='DC' id='"+data.rows[i].DC_ID+"'>"+
                            "<td style='vertical-align:middle; text-align:center;'>"+data.rows[i].DC_NAME + "</td>" +
                            "<td style='vertical-align:middle; text-align:center;'>"+data.rows[i].DC_VALUE+"</td>" +
                            "<td style='vertical-align:middle; text-align:center; padding: 0px'>" +
                            "<input name='inp_sum'placeholder='请输入1-5的数字' value='0' class='inp_sum' id='" + "input" + i + "' style='border:none;text-align:center;height: 33px;' ></td>");
                    }
                    //对于数字的验证
                    $('input').keyup(function() {
                        var c = $(this);
                        var temp_amount = c.val().replace(/[^\d]/g, '');
                        temp_amount = temp_amount < 1 ? "" : temp_amount > 5 ? 5 : temp_amount;
                        $(this).val(temp_amount);
                    });
                    var ary1 = document.getElementsByName("DC");
                    for(var i=0;i<ary1.length;i++){
                        DCProjectID+=ary1[i].id+',';
                    }
                    for(var i=0;i<data.total;i++){
                        $("#input"+i+"").val(list1.rows[i].FScore);
                    }
                    for(var i=0;i<data.total;i++){
                        (function(i){
                            $("#input"+i+"").keyup(function() {
                                $("#input"+i+"").val();

                                var ary2 = document.getElementsByName("inp_sum");
                                for(var i=0;i<ary2.length;i++){
                                    DCScore+=ary2[i].value+',';
                                }
                                var num=0;
                                for(var j=0;j<data.total;j++) {
                                    (function(j){
                                        num=num+parseInt($("#input"+j+"").val());
                                        if(!isNaN(num)) {
                                            $("#updateFScore").val(num);
                                            $("#update_score_message").html("");
                                        }else{
                                            $("#updateFScore").val("");
                                            $("#update_score_message").html("请填入分数!");
                                        }
                                    })(j);
                                }
                                if(!isNaN(num)){
                                $.ajax({
                                    url:contextPath+"/maintain/showSum.do",
                                    type:"post",
                                    dataType:'json',
                                    data:{
                                        SUM : num
                                    },
                                    success:function(data) {
                                        $("#updateFCoefficient").val(data.rows[0].FCoefficient);
                                        $("#updateFPerformanceResult").val(data.rows[0].FAssessmentResult);
                                        console.log(data.message);
                                    }
                                });
                                }else {
                                    $("#updateFCoefficient").val("");
                                    $("#updateFPerformanceResult").val("");
                                }
                            })
                        })(i);
                    }
                }
            });

            DCProjectID="";
        }


        $("#miantain_id").val(carrentItem[0].fID);
        $("#updateFScore").val(carrentItem[0].fTotal);
        $("#updateFCoefficient").val(carrentItem[0].fCoefficient);
        $("#updateFPerformanceResult").val(carrentItem[0].fPerformanceResult);
        $("#update_btn").click();
    }else{
        setAlert("error","请先选择一条数据");
    }
}

