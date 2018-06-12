/**
 * Created by wangjs on 2016/12/29.
 */

$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});
// 初始化减免单据列表
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_free').bootstrapTable({
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
                valign: "middle",
            }, {
                field: 'fOldManName',
                title: '老人',
                align: "center",
                valign: "middle",
            }, {
                field: 'fChrgeName',
                title: '减免项目',
                align: "center",
                valign: "middle",
            }, {
                field: 'fFreeTotal',
                title: '减免金额',
                align: "center",
                valign: "middle",
            }, {
                field: 'fExplain',
                title: '备注',
                align: "center",
                valign: "middle",
            }, {
                field: 'fStaffName',
                title: '申请人',
                align: "center",
                valign: "middle",
            }, {
                field: 'fCreateTime',
                title: '申请时间',
                align: "center",
                valign: "middle",
            }, {
                align: "center",
                valign: "middle",
                field: 'fStatus',
                title: '单据状态',
                formatter:function(value,row,index){
                    if(value=='0'){
                        return "待确认";
                    }else if(value=='1'){
                        return "<span style='color:greenyellow '>已确认</span>";
                    }else if(value=='2'){
                        return "<span style='color:red'>已结算</span>";
                    }
                }
            }]
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

// 清空搜索框
function clearQueryInput(){
    $("#foldManName").val("");
    $("#searchStartTime").val("");
    $("#searchStopTime").val("");
}

//查询
function queryOmFree(){
    $.ajax({
        url:contextPath+"/free/query.do",
        type:"post",
        data:{
            fOldManName:$("#foldManName").val(),
            startTime:$("#searchStartTime").val(),
            stopTime:$("#searchStopTime").val(),
            page:0,
            pageSize:10
        },
        success:function(data) {
            $('#tb_free').bootstrapTable('load', data);
        }
    });
}


function selectOldMan(){
    $('#oldManModal').modal('show');
    // 初始化老人列表
    initChooseOldManTb();
}
// 点击照片得到老人
function getOldManWithPhoto(id,name){
    $("#addOldManFreeID").val(id);
    $("#oldManFreeName").val(name);
    // $("#addfOldManID").val(temp.getAttribute("selectOmId"));
    // $("#oldManName").val(temp.getAttribute("selectName"));
    $('#oldManModal').modal('hide')
}

// var record = { num: "" }
// var record2 = { num: "" }
// var record3 = { num: "" }
// var checkDecimal = function (n) {
//     var decimalReg = /^\d{0,8}\.{0,1}(\d{1,2})?$/;//var decimalReg=/^[-\+]?\d{0,8}\.{0,1}(\d{1,2})?$/;
//     if (n.value != "" && decimalReg.test(n.value)) {
//         record.num = n.value;
//         var sinprice = $("#addfFreePrice").val();
//         var hisnums = $("#addfFreeNumber").val();
//         if (sinprice != "" && sinprice != null && hisnums != "" && hisnums != null) {
//             var day = parseFloat(parseFloat(sinprice) * parseFloat(hisnums)).toFixed(2).toString();
//             record3.num = day;
//             $("#addfFreeTotal").val(day);
//         }
//     } else {
//         if (n.value != "") {
//             n.value = record.num;
//         }
//     }
// }
// var checkDecimal2 = function (n) {
//     //var decimalReg = /^[1-9]\d*$/;
//     var decimalReg=/^[-\+]?\d{0,8}\.{0,1}(\d{1,2})?$/;
//     if (n.value != "" && decimalReg.test(n.value)) {
//         record2.num = n.value;
//         var sinprice = $("#addfFreePrice").val();
//         var hisnums = $("#addfFreeNumber").val();
//         if (sinprice != "" && sinprice != null && hisnums != "" && hisnums != null) {
//             var day = parseFloat(parseFloat(sinprice) * parseFloat(hisnums)).toFixed(2).toString();
//             record3.num = day;
//             $("#addfFreeTotal").val(day);
//         }
//     } else {
//         if (n.value != "") {
//             n.value = record2.num;
//         }
//     }
// }
// var checkDecimal3 = function (n) {
//     //var decimalReg = /^[1-9]\d*$/;
//     var decimalReg=/^[-\+]?\d{0,8}\.{0,1}(\d{1,2})?$/;
//     if (n.value != "" && decimalReg.test(n.value)) {
//         record3.num = n.value;
//     } else {
//         if (n.value != "") {
//             n.value = record3.num;
//         }
//     }
// }

//     $("#addUnit").change(function () {
//         if (this.value == "月") {
//             record2.num = $("#addfFreeNumber").val();
//             document.getElementById("addfFreeNumber").setAttribute("readonly", "true");
//             $("#addfFreeNumber").val("1");
//         } else {
//             $("#addfFreeNumber").val(record2.num);
//             document.getElementById("addfFreeNumber").removeAttribute("readonly");
//         }
//         // chooseOldMan($("#hdfOldId").val(), $("#txtOldName").val());
//     })
//     // $("#ReductionName").change(function () {
//     //     AddOption(this.value);
//     //     chooseOldMan($("#hdfOldId").val(), $("#txtOldName").val());
//     // })
//     //$("#ReducitonUnit").change(function () {
//     //    if (this.value != "次") {
//     //        $("#ToallFee").attr("readonly", true); $("#SinglePrice").attr("readonly", true);
//     //    } else {
//     //        $("#ToallFee").removeAttr("readonly"); $("#SinglePrice").removeAttr("readonly");
//     //    }
//     //})
// })
// function GetAll() {
//     $("#HiddenField1").val($("#ReducitonUnit").val());
//     return true;
// }
// 添加验证
// 添加减免单据验证
function add_check() {
    var result=true;

    if(!addCheck_name_free()){
        result=false;
    }


    if(!addCheck_FreeItem_free()){
        result=false;
    }


    if(!addCheck_FreeNumber_free()){
        result=false;
    }


    if(!addCheck_CreateTime_free()){
        result=false;
    }

    if(!addCheck_FreePrice_free()){
        result=false;
    }

    return result;
}

function addCheck_name_free(){
    var result=true;
    var name = $("#oldManFreeName").val().trim();
    $("#add_name_free").html("");
    if (name == null || name.length == 0){
        $("#add_name_free").html("请选择老人");
        result = false;
    }
    return result;
}

function addCheck_FreeItem_free(){
    var result=true;
    var fFreeItem = $("#addfFreeItem").val().trim();
    $("#add_Item_free").html("");
    if (fFreeItem==""){
        $("#add_Item_free").html("请选择减免项目");
        result = false;
    }
    return result;
}

function addCheck_FreeNumber_free(){
    var result=true;
    var fFreeNumber = $("#addfFreeNumber").val().trim();
    $("#add_number_free").html("");
    if (fFreeNumber==""){
        $("#add_number_free").html("请填写数量");
        result = false;
    }
    return result;
}

function addCheck_CreateTime_free(){
    var result=true;
    var fCreateTime = $("#addfCreateTime").val().trim();
    $("#add_time_free").html("");
    if (fCreateTime==""){
        $("#add_time_free").html("请选择时间");
        result = false;
    }
    return result;
}

function addCheck_FreePrice_free(){
    var result=true;
    var fFreePrice = $("#addfFreePrice").val().trim();
    $("#add_price_free").html("");
    if (fFreePrice==""){
        $("#add_price_free").html("请填写单价");
        result = false;
    }
    return result;
}

$("#addfFreePrice").change(function () {
    var freePrice=$("#addfFreePrice").val()-0;
    var freeNumner=$("#addfFreeNumber").val()-0;
    if(freePrice!=""&&freeNumner!=""){
        var freeTotal=freePrice*freeNumner;
        $("#addfFreeTotal").val(freeTotal)
    }
});
$("#addfFreeNumber").change(function () {
    var freePrice=$("#addfFreePrice").val()-0;
    var freeNumner=$("#addfFreeNumber").val()-0;
    if(freePrice!=""&&freeNumner!=""){
        var freeTotal=freePrice*freeNumner;
        $("#addfFreeTotal").val(freeTotal)
    }
});

$("#updfFreePrice").change(function () {
    var freePrice=$("#updfFreePrice").val()-0;
    var freeNumner=$("#updfFreeNumber").val()-0;
    if(freePrice!=""&&freeNumner!=""){
        var freeTotal=freePrice*freeNumner;
        $("#updfFreeTotal").val(freeTotal)
    }
});
$("#updfFreeNumber").change(function () {
    var freePrice=$("#updfFreePrice").val()-0;
    var freeNumner=$("#updfFreeNumber").val()-0;
    if(freePrice!=""&&freeNumner!=""){
        var freeTotal=freePrice*freeNumner;
        $("#updfFreeTotal").val(freeTotal)
    }
});

//新增减免单据,先添加应缴表，再添加减免单据，最后添加应缴明细
function addOldManFree(){
    if(add_check()){
        addOldManPayment("2");
    }else{
        return 0;
    }
    closeFreeModal()
}

// 关闭模态框
function closeFreeModal() {
     $("#oldManFreeName").val("");
     $("#addfFreeItem").val("");
     $("#addfFreePrice").val("");
     $("#addfFreeNumber").val("");
     $("#addfFreeTotal").val("");
     $("#addfExplain").val("");
     $("#addfCreateTime").val("");
    $("#addModal").modal('hide');

    $("#updateName").val("");
    $("#updateValue").val("");
}

// 添加应缴表
function addOldManPayment(bizType){
    var now=new Date();
    var chargeTime=now.getFullYear()+"-"+(now.getMonth()+1)+"-"+now.getDate();

    $.ajax({
        url:contextPath+"/pay/omPayment.do",
        type:"post",
        async:false,
        data:{
            // 1、老人应缴费费用 2、老人减免费用 3、	退老人应缴费用
            fBizType:bizType,
            fPaymentDate:chargeTime,
            fPeriod:now.getFullYear(),
            fMoun:(now.getMonth()+1),
            // 1：提交，2：审核，默认审核状态2
            fstatus:"2",
            foldmanID:$("#addOldManFreeID").val()
        },
        success:function(data) {
            getOldManPaymentId();
        }
    });
}
// 得到应缴表最后一条记录
function getOldManPaymentId(){
    $.ajax({
        url:contextPath+"/pay/queryLast.do",
        type:"post",
        async:false,
        success:function(data) {
            var paymentId=data.rows[0].fID;
            addFree(paymentId)

        }
    });
}

function addFree(paymentId){
    $.ajax({
        url:contextPath+"/free/addOmFree.do",
        type:"post",
        async:false,
        data:{
            fOldManID:$("#addOldManFreeID").val(),
            fFreeItem:$("#addfFreeItem").val(),
            fFreePrice:$("#addfFreePrice").val(),
            fUnit:$("#addUnit").val(),
            fFreeNumber:$("#addfFreeNumber").val(),
            fFreeTotal:$("#addfFreeTotal").val(),
            // 待确认0，已确认1（默认），已结算2
            fStatus:"0",
            fPaymentID:paymentId,
            fExplain:$("#addfExplain").val(),
            fCreateTime:$("#addfCreateTime").val()
        },
        success:function(data) {
            console.log(data.message);
            if(data.success){
                addOldManPaymentEntry(paymentId);
                setAlert("success",data.msg);
            }else{
                setAlert("error",data.msg);
            }
            $('#tb_free').bootstrapTable('refresh', {url: 'query.do'});
        }
    });
}
// 添加应缴明细表
function addOldManPaymentEntry(paymentId) {
    var freeId=getLastFree();
    $.ajax({
        url:contextPath+"/paymentEntry/addPaymentEntryOne.do",
        type:"post",
        async:false,
        traditional: true,
        data:{
            fParentid:paymentId,
            fitemID:$("#addfFreeItem").val(),
            fArPaymentAmount:-$("#addfFreeTotal").val(),
            fsourcebillid:freeId
        },
    });
}
// 得到减免单据表最后一条数据
function getLastFree(){
    var freeId="";
    $.ajax({
        url:contextPath+"/free/queryLastFree.do",
        type:"post",
        async:false,
        traditional: true,
        success:function(data) {
            freeId=data.rows[0].fID
        }
    });
    return freeId;
}

// 修改验证
function upd_check_free() {
    var result=true;

    if(!updCheck_name_free()){
        result=false;
    }


    if(!updCheck_FreeItem_free()){
        result=false;
    }


    if(!updCheck_FreeNumber_free()){
        result=false;
    }


    if(!updCheck_CreateTime_free()){
        result=false;
    }

    if(!updCheck_FreePrice_free()){
        result=false;
    }

    return result;
}
function updCheck_name_free(){
    var result=true;
    var name = $("#updOldManName").val().trim();
    $("#upd_name_free").html("");
    if (name == "" || name.length == 0){
        $("#upd_name_free").html("请选择老人");
        result = false;
    }
    return result;
}

function updCheck_FreeItem_free(){
    var result=true;
    var fFreeItem = $("#updfFreeItem").val().trim();
    $("#upd_Item_free").html("");
    if (fFreeItem==""){
        $("#upd_Item_free").html("请选择减免项目");
        result = false;
    }
    return result;
}

function updCheck_FreeNumber_free(){
    var result=true;
    var fFreeNumber = $("#updfFreeNumber").val().trim();
    $("#upd_number_free").html("");
    if (fFreeNumber==""){
        $("#upd_number_free").html("请填写数量");
        result = false;
    }
    return result;
}

function updCheck_CreateTime_free(){
    var result=true;
    var fCreateTime = $("#updfCreateTime").val().trim();
    $("#upd_time_free").html("");
    if (fCreateTime==""){
        $("#upd_time_free").html("请选择时间");
        result = false;
    }
    return result;
}

function updCheck_FreePrice_free(){
    var result=true;
    var fFreePrice = $("#updfFreePrice").val().trim();
    $("#upd_price_free").html("");
    if (fFreePrice==""){
        $("#upd_price_free").html("请填写单价");
        result = false;
    }
    return result;
}

//修改减免单据
function updOldManFree(){
    if(upd_check_free()){
        $.ajax({
            url:contextPath+"/free/updOldManFree.do",
            type:"post",
            data:{
                fID:$("#data_id").val(),
                // fNumber:$("#updfNumber").val(),
                fOldManID:$("#updfOldManID").val(),
                fFreeItem:$("#updfFreeItem").val(),
                fFreePrice:$("#updfFreePrice").val(),
                fUnit:$("#updUnit").val(),
                fFreeNumber:$("#updfFreeNumber").val(),
                fFreeTotal:$("#updfFreeTotal").val(),
                fStatus:"0",
                fExplain:$("#updfExplain").val(),
            },
            success:function(data) {
                console.log(data.msg);
                if(data.success){
                    updOldManPaymentEntry();
                    setAlert("success",data.msg);
                }else{
                    setAlert("error",data.msg);
                }
                $('#tb_free').bootstrapTable('refresh', {url: 'query.do'});
            }
        });
    }else{
        return 0;
    }

    // closeModal();
}

// 修改应缴明细表
function updOldManPaymentEntry() {
    $.ajax({
        url:contextPath+"/paymentEntry/updPaymentEntryOne.do",
        type:"post",
        async:false,
        traditional: true,
        data:{
            fParentid:$("#updfPaymentID").val(),
            fitemID:$("#updfFreeItem").val(),
            fArPaymentAmount:-$("#updfFreeTotal").val()
        },
        success:function(data) {
            // alert("减免单据修改成功")
        }
    });
}

//减免单据删除
function gotoDelete(){
    var carrentItem = $("#tb_free").bootstrapTable('getSelections');
    if(carrentItem[0]){
        if(carrentItem[0].fStatus!=2){
            $.ajax({
                url:contextPath+"/free/delOldManFree.do",
                type:"post",
                data:{
                    fID:carrentItem[0].fID
                },
                success:function(data) {
                    console.log(data.message);
                    if(data.success){
                        delOldManPaymentEntry(carrentItem[0].fPaymentID);
                        delOldManPayment(carrentItem[0].fPaymentID);
                        setAlert("success",data.msg);
                    }else{
                        setAlert("error",data.msg);
                    }
                    $('#tb_free').bootstrapTable('refresh', {url: 'query.do'});
                }
            });
        }else{
            setAlert("error","已结算，不能删除");
        }
    }else{
        setAlert("error","请先选择一条数据");
    }
}

//删除应缴表
function delOldManPayment(fPaymentID){
    $.ajax({
        url:contextPath+"/pay/delOmPayment.do",
        type:"post",
        async:false,
        data:{
            fID:fPaymentID,
        },
        success:function(data) {
        }
    });
}

// 删除应缴明细表
function delOldManPaymentEntry(fPaymentID) {
    $.ajax({
        url:contextPath+"/paymentEntry/delPaymentEntryOne.do",
        type:"post",
        async:false,
        traditional: true,
        data:{
            fParentid:fPaymentID,
        },
        success:function(data) {
        }
    });
}

//回显下拉框
function getCharge(){
    var len="";
    var row="";
    $.ajax({
        url:contextPath+"/charge/queryCharge.do",
        type:"post",
        async:false,
        success:function(data) {
            len=data.total;
            row=data.rows;
        }
    });
    var addfFreeItem="<option value=''> --请选择-- </option>";
    for(var i=0;i<len;i++){
        addfFreeItem += "<option value='" + row[i].fID + "'>" + row[i].fChrgeName + "</option>";
    }
    $("#addfFreeItem").html(addfFreeItem);
}
//页面回显数据
function gotoUpdate(){
    var carrentItem = $("#tb_free").bootstrapTable('getSelections');
    if(carrentItem[0]){
        if(carrentItem[0].fStatus!=2){
            $("#data_id").val(carrentItem[0].fID);
            $("#updfOldManID").val(carrentItem[0].fOldManID);

            $("#updfNumber").val(carrentItem[0].fNumber);
            $("#updfNursinghomeID").val(carrentItem[0].fNursinghomeID);

            $("#updOldManName").val(carrentItem[0].fOldManName);
            var len="";
            var row="";
            $.ajax({
                url:contextPath+"/charge/queryCharge.do",
                type:"post",
                async:false,
                success:function(data) {
                    len=data.total;
                    row=data.rows;
                }
            });
            var updfFreeItem="";
            for(var i=0;i<len;i++){
                if(row[i].fChrgeName==carrentItem[0].fChrgeName){
                    updfFreeItem += "<option value='" + row[i].fID + "'>" + row[i].fChrgeName + "</option>";
                }
            }
            for(var i=0;i<len;i++){
                if(row[i].fChrgeName!=carrentItem[0].fChrgeName){
                    updfFreeItem += "<option value='" + row[i].fID + "'>" + row[i].fChrgeName + "</option>";
                }
            }
            $("#updfFreeItem").html(updfFreeItem);

            var unit="";
            if(carrentItem[0].fUnit=="天"){
                unit+="<option value='天'>天</option>";
                unit+="<option value='月'>月</option>";
            }else if(carrentItem[0].fUnit=="月"){
                unit+="<option value='月'>月</option>";
                unit+="<option value='天'>天</option>";
            }
            $("#updUnit").html(unit)

            $("#updfFreePrice").val(carrentItem[0].fFreePrice);
            $("#updfFreeNumber").val(carrentItem[0].fFreeNumber);
            $("#updfFreeTotal").val(carrentItem[0].fFreeTotal);
            $("#updfStatus").val(carrentItem[0].fStatus);
            $("#updfPaymentID").val(carrentItem[0].fPaymentID);
            $("#updfExplain").val(carrentItem[0].fExplain);
            $("#updfCreatorID").val(carrentItem[0].fCreatorID);
            $("#updfCreateTime").val(carrentItem[0].fCreateTime);
            $("#update_btn").click();
        }else{
            setAlert("error","已结算，不能修改");
        }
    }else{
        setAlert("error","请先选择一条数据");
    }
}

