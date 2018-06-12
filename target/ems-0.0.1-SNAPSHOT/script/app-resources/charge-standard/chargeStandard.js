
$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_chargeStandard').bootstrapTable({
            url: 'query.do',   //请求后台的URL（*）
            method: 'post',      //请求方式（*）
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
            // height: 350,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",      //每一行的唯一标识，一般为主键列
            showToggle:true,     //是否显示详细视图和列表视图的切换按钮
            cardView: false,     //是否显示详细视图
            // detailView: false,     //是否显示父子表

            columns: [{
                radio: true
            }, {
                sortable: true,
                field: 'fID',
                title: '编号',
                align: "center",
            }, {
                field: 'fChrgeName',
                title: '费用名称',
                align: "center",
            }, {
                field: 'fChrgeTypeName',
                title: '费用类别',
                align: "center",
            }, {
                field: 'fChargeCycleName',
                title: '费用周期',
                align: "center",
            }, {
                field: 'fNursingLevelName',
                title: '护理级别',
                align: "center",
            }, {
                field: 'fPrice',
                title: '单价',
                align: "center",
            }, {
                field: 'fUnitName',
                title: '单位',
                align: "center",
            }, {
                field: 'fRefundType',
                title: '退住时退款',
                align: "center",
                formatter:function(value){
                    if(value=='1'){
                        return '<span>是</span>'
                    }else if(value=='0'){
                        return '<span>否</span>'
                    }
                }
            }, {
                field: 'fChrgeStartDate',
                title: '费用开始日期',
                align: "center",
            }, {
                field: 'fChrgeStopDate',
                title: '费用结束日期',
                align: "center",
            }, {
                field: 'fStatus',
                title: '状态',
                align: "center",
                formatter:function(value){
                    if(value=='11'){
                        return '<span>启用</span>'
                    }else if(value=='10'){
                        return '<span>禁用</span>'
                    }
                }
            }, {
                field: 'fExplain',
                title: '说明',
                align: "center",
            }, {
                field: 'fValidityStartDate',
                title: '有效期开始时间',
                align: "center",
            }, {
                field: 'fValidityEndDate',
                title: '有效期结束时间',
                align: "center",
            }, {
                field: 'fIsALLFee',
                title: '全院必收费用',
                align: "center",
                formatter:function(value){
                    if(value=='1'){
                        return '<span>是</span>'
                    }else if(value=='0'){
                        return '<span>否</span>'
                    }
                }
            }, {
                field: 'fIsCycleFee',
                title: '循环费用',
                align: "center",
                formatter:function(value){
                    if(value=='1'){
                        return '<span>是</span>'
                    }else if(value=='0'){
                        return '<span>否</span>'
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
            // flag:"true",
            fChrgeName:$("#searchName").val(),
            fChrgeType:$("#searchType").val(),
            fStatus:$("#searchStatus").val(),
            value: $("#searchValue").val()
        };
        return temp;
    };
    return oTableInit;
};
function queryClear(){
    $("#searchName").val(""),
    $("#searchType").val(""),
    $("#searchStatus").val("")
}
//查询收费标准
function queryStandard(){
    $.ajax({
        url:contextPath+"/charge/query.do",
        type:"post",
        data:{
            fChrgeName:$("#searchName").val(),
            fChrgeType:$("#searchType").val(),
            fStatus:$("#searchStatus").val(),
            page:0,
            pageSize:10
        },
        success:function(data) {
            $('#tb_chargeStandard').bootstrapTable('load', data);
        }
    });
}


$(document).ready(
    $.ajax({
        url:contextPath+"/sys/get.do",
        type:"post",
        success:function(data) {
            //查询条件下拉列表
            var len=data.total;
            var row=data.rows;
            var searchStatus="";
            searchStatus += "<option value=''>--请选择--</option>";
            searchStatus += "<option value='11'>启用</option>";
            searchStatus += "<option value='10'>禁用</option>";
            $("#searchStatus").html(searchStatus);

            var searchType="<option value=''> --请选择-- </option>";
            for(var i=0;i<len;i++){
                var ChrgeType=document.getElementById("ChrgeType").innerText;
                var ChargeTyleName=row[i].name;
                if(ChrgeType==ChargeTyleName) {
                    searchType += "<option value='" + row[i].id + "'>" + row[i].value + "</option>";
                }
            }
            $("#searchType").html(searchType);


        }
    })
);

//回显数据字典到添加收费标准界面的下拉框
function getDcList(){
    $.ajax({
        url:contextPath+"/sys/get.do",
        type:"post",
        success:function(data) {
            //查询条件下拉列表
            var len=data.total;
            var row=data.rows;
            var searchStatus="";
            searchStatus += "<option value=''>--请选择--</option>";
            searchStatus += "<option value='11'>启用</option>";
            searchStatus += "<option value='10'>禁用</option>";
            $("#searchStatus").html(searchStatus);

            //获取UTC(国际统一时间/国际协调)格式的从1970.1.1 0:00以来的毫秒数
            var newDate=new Date();
            $("#addChrgeNumber").val("No"+newDate.getTime());

            var searchType="<option value=''> --请选择-- </option>";
            for(var i=0;i<len;i++){
                var ChrgeType=document.getElementById("ChrgeType").innerText;
                var ChargeTyleName=row[i].name;
                if(ChrgeType==ChargeTyleName) {
                    searchType += "<option value='" + row[i].id + "'>" + row[i].value + "</option>";
                }
            }
            $("#searchType").html(searchType);

            var ChrgeTypeSel="";
            for(var i=0;i<len;i++){
                var ChrgeType=document.getElementById("ChrgeType").innerText;
                var ChargeTyleName=row[i].name;
                if(ChrgeType==ChargeTyleName) {
                    ChrgeTypeSel += "<option value='" + row[i].id + "'>" + row[i].value + "</option>";
                }
            }
            $("#addChrgeType").html(ChrgeTypeSel);

            var aUnitSel="";
            for(var i=0;i<len;i++){
                var aUnit=document.getElementById("aUnit").innerText;
                var aUnitleName=row[i].name;
                if(aUnit==aUnitleName) {
                    aUnitSel += "<option value='" + row[i].id + "'>" + row[i].value + "</option>";
                }
            }
            $("#addUnit").html(aUnitSel);

            var aChargeCycleSel="";
            for(var i=0;i<len;i++){
                var aChargeCycle=document.getElementById("aChargeCycle").innerText;
                var aChargeCycleName=row[i].name;
                if(aChargeCycle==aChargeCycleName) {
                    aChargeCycleSel += "<option value='" + row[i].id + "'>" + row[i].value + "</option>";
                }
            }
            $("#addChargeCycle").html(aChargeCycleSel);

            var aNursingLevelSel="";
            for(var i=0;i<len;i++){
                var aNursingLevel=document.getElementById("aNursingLevel").innerText;
                var aNursingLevelName=row[i].name;
                if(aNursingLevel==aNursingLevelName) {
                    aNursingLevelSel += "<option value='" + row[i].id + "'>" + row[i].value + "</option>";
                }
            }
            $("#addNursingLevel").html(aNursingLevelSel);

            // var aValueSel="";
            // for(var i=0;i<len;i++){
            //     var aValue=document.getElementById("aValue").innerText;
            //     var aValueName=row[i].name;
            //     if(aValue==aValueName) {
            //         aValueSel += "<option value='" + row[i].value + "'>" + row[i].value + "</option>";
            //     }
            // }
            // $("#addValue").html(aValueSel);
        }
    });
}

function goto_addStandard(){
    getDcList();
    getfDate()
}

function getfDate(){
    var newfDate=new Date();
    $("#addValidityStartDate").val(formatDateTime(newfDate));
    $("#addValidityEndDate").val(formatDateTime(newfDate));
    // $("#addChrgeStartDate").val(formatDateTime(newfDate));
    // $("#addChrgeStopDate").val(formatDateTime(newfDate));
}
//时间格式转化函数
 function formatDateTime(date) {
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    var h = date.getHours();
    var minute = date.getMinutes();
    minute = minute < 10 ? ('0' + minute) : minute;
    return y + '-' + m + '-' + d+' '+h+':'+minute;
};
function check_add(){
    var result=true;
    var chrgeName = $("#addChrgeName").val().trim();
    // $("#add_ChrgeName").html("");
    if (chrgeName==""){
        alert("请填写费用名称！")
        result = false;
    }

    var addPrice = $("#addPrice").val().trim();
    if (addPrice==""){
        alert("请填写费用价格！")
        result = false;
    }
    return result;
}
//新增收费标准
function addChargeStandard(){
    var addIsALLFee="";
    if($("#addIsALLFee").is(':checked')){
        addIsALLFee="1";
        // addIsALLFee=$("#addIsALLFee").val();
    }else{
        addIsALLFee="0";
    }

    var addIsCycleFee="";
    if($("#addIsCycleFee").is(':checked')){
        // addIsCycleFee=$("#addIsCycleFee").val();
        addIsCycleFee="1";
    }else{
        addIsCycleFee="0";
    }

    var addRefundType="";
    if($("#addRefundType").is(':checked')){
        addRefundType=$("#addRefundType").val();
    }else{
        addRefundType="0";
    }

    if(check_add()){
        var chargeStartDate="0000-00-00";
        if($("#addChrgeStartDate").val()!=""){
            chargeStartDate=$("#addChrgeStartDate").val();
        }
        var chargeStopDate="0000-00-00";
        if($("#addChrgeStopDate").val()!=""){
            chargeStopDate=$("#addChrgeStopDate").val();
        }

        $.ajax({
            url:contextPath+"/charge/addStandard.do",
            type:"post",
            data:{
                fChrgeNumber:$("#addChrgeNumber").val(),
                fChrgeName:$("#addChrgeName").val(),
                fChrgeType:$("#addChrgeType").val(),
                fNursingLevel:$("#addNursingLevel").val(),
                fPrice:$("#addPrice").val(),
                fUnit:$("#addUnit").val(),
                // fValue:$("#addValue").val(),
                fChargeCycle:$("#addChargeCycle").val(),

                fRefundType:addRefundType,
                fChrgeStartDate:chargeStartDate,
                fChrgeStopDate:chargeStopDate,
                fValidityStartDate:$("#addValidityStartDate").val(),
                fValidityEndDate:$("#addValidityEndDate").val(),

                fIsALLFee:addIsALLFee,

                fIsCycleFee:addIsCycleFee,

                fStatus:$("#addStatus").val(),
                fExplain:$("#addExplain").val()
            },
            success:function(data) {
                console.log(data.message);
                if(data.success){
                    setAlert("success",data.msg);
                }else{
                    setAlert("error",data.msg);
                }
                $('#tb_chargeStandard').bootstrapTable('refresh', {url: 'query.do'});
            }
        });
    }else{
        return 0;
    }

    closeModal();
}


//修改收费标准
function updChargeStandard(){

    var chargeStartDate="0000-00-00";
    if($("#updChrgeStartDate").val()!=""){
        chargeStartDate=$("#updChrgeStartDate").val();
    }
    var chargeStopDate="0000-00-00";
    if($("#updChrgeStopDate").val()!=""){
        chargeStopDate=$("#updChrgeStopDate").val();
    }

    var updRefundType="";
    if($("#updRefundType1").is(':checked')){
        updRefundType=$("#updRefundType1").val();
    }else{
        updRefundType="0";
    }

    var updIsALLFee="";
    if($("#updIsALLFee1").is(':checked')){
        updIsALLFee=$("#updIsALLFee1").val();
    }else{
        updIsALLFee="0";
    }

    var updIsCycleFee="";
    if($("#updIsCycleFee1").is(':checked')){
        updIsCycleFee=$("#updIsCycleFee1").val();
    }else{
        updIsCycleFee="0";
    }

    $.ajax({
        url:contextPath+"/charge/updStandard.do",
        type:"post",
        data:{
            fID:$("#FID").val(),

            fNursinghomeID:$("#updNursinghomeID").val(),
            fChrgeNumber:$("#updChrgeNumber").val(),
            fChrgeName:$("#updChrgeName").val(),
            fChrgeType:$("#updChrgeType").val(),
            fNursingLevel:$("#updNursingLevel").val(),
            fPrice:$("#updPrice").val(),
            fUnit:$("#updUnit").val(),
            // fValue:$("#updValue").val(),
            fChargeCycle:$("#updChargeCycle").val(),
            fRefundType:updRefundType,
            fChrgeStartDate:chargeStartDate,
            fChrgeStopDate:chargeStopDate,

            fValidityStartDate:$("#updValidityStartDate").val(),
            fValidityEndDate:$("#updValidityEndDate").val(),
            fIsALLFee:updIsALLFee,
            fIsCycleFee:updIsCycleFee,

            fStatus:$("#updStatus").val(),
            fExplain:$("#updExplain").val()
        },
        success:function(data) {
            console.log(data.message);
            if(data.success){
                setAlert("success",data.msg);
            }else{
                setAlert("error",data.msg);
            }
            $('#tb_chargeStandard').bootstrapTable('refresh', {url: 'query.do'});
        }
    });
    closeModal();
}

//删除收费标准
function gotoDelete(){
    var carrentItem = $("#tb_chargeStandard").bootstrapTable('getSelections');
    if(carrentItem[0]){
        $.ajax({
            url:contextPath+"/charge/delCharge.do",
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
                $('#tb_chargeStandard').bootstrapTable('refresh', {url: 'query.do'});

            }
        });
    }else{
        setAlert("error","请先选择一条数据");
    }
}

//清空添加和修改界面输入框中的数据
function closeModal() {
    // $("#addNursinghomeID").val("");
    // $("#addChrgeNumber").val("");
    $("#addChrgeName").val("");
    // $("#addChrgeType").val("");
    // $("#addNursingLevel").val("");
    $("#addPrice").val("");
    // $("#addUnit").val("");
    // $("#addChargeCycle").val("");
    $("#addRefundType").attr("checked",false);
    $("#addIsALLFee").prop("checked",false);
    $("#addIsCycleFee").attr("checked",false);
    $("#addChrgeStartDate").val("");
    $("#addChrgeStopDate").val("");
    $("#addValidityStartDate").val("");
    $("#addValidityEndDate").val("");
    // $("#addStatus").val("");
    $("#addExplain").val("");
    $("#addIsALLFee").val("");
    $("#addIsCycleFee").val("");
    $("#addModal").modal('hide');

    // $("#updRefundType1").attr("checked",false);
    // $("#updIsALLFee1").prop("checked",false);
    // $("#updIsCycleFee1").attr("checked",false);
    // $("#updRefundType1").val("");
    // $("#updIsALLFee1").val("");
    // $("#updIsCycleFee1").val("");

    $("#FID").val("");
    $("#updNursinghomeID").val();
    $("#updChrgeNumber").val();
    $("#updChrgeName").val();
    $("#updChrgeType").val();
    $("#updNursingLevel").val();
    $("#updPrice").val();
    $("#updUnit").val();
    $("#updValue").val();
    $("#updChargeCycle").val();
    $(".updRefundType").val();
    $("#updChrgeStartDate").val();
    $("#updChrgeStopDate").val();
    $("#updStatus").val();
    $("#updExplain").val();
}


//页面回显数据
function gotoUpdate(){
    var carrentItem = $("#tb_chargeStandard").bootstrapTable('getSelections');
    if(carrentItem[0]){
        $.ajax({
            url: contextPath + "/sys/get.do",
            type: "post",
            async:false,
            success: function (data) {
                var len=data.total;
                var row=data.rows;
                var ChrgeTypeSel = "";
                for (var i = 0; i < len; i++) {
                    var ChrgeType = document.getElementById("ChrgeType").innerText;
                    var ChargeTyleName = row[i].name;
                    if (ChrgeType == ChargeTyleName) {
                        var valueTemp1 = row[i].id;
                        var tempValue1 = carrentItem[0].fChrgeType;
                        if (valueTemp1 == tempValue1) {
                            ChrgeTypeSel += "<option selected='selected' value='" + row[i].id + "'>" + row[i].value + "</option>";
                        } else {
                            ChrgeTypeSel += "<option value='" + row[i].id + "'>" + row[i].value + "</option>";
                        }
                    }
                }
                $("#updChrgeType").html(ChrgeTypeSel);

                var aUnitSel = "";
                for (var i = 0; i < len; i++) {
                    var uUnit = document.getElementById("uUnit").innerText;
                    var aUnitleName = row[i].name;
                    if (uUnit == aUnitleName) {
                        var valueTemp2 = row[i].id;
                        var tempValue2 = carrentItem[0].fUnit;
                        if (valueTemp2 == tempValue2) {
                            aUnitSel += "<option selected='selected' value='" + row[i].id + "'>" + row[i].value + "</option>";
                        } else {
                            aUnitSel += "<option value='" + row[i].id + "'>" + row[i].value + "</option>";
                        }
                    }
                }
                $("#updUnit").html(aUnitSel);

                var uChargeCycleSel = "";
                for (var i = 0; i < len; i++) {
                    var uChargeCycle = document.getElementById("uChargeCycle").innerText;
                    var aChargeCycleName = row[i].name;
                    if (uChargeCycle == aChargeCycleName) {
                        var valueTemp3 = row[i].id;
                        var tempValue3 = carrentItem[0].fChargeCycle;
                        if (valueTemp3 == tempValue3) {
                            uChargeCycleSel += "<option selected='selected' value='" + row[i].id + "'>" + row[i].value + "</option>";
                        } else {
                            uChargeCycleSel += "<option value='" + row[i].id + "'>" + row[i].value + "</option>";
                        }

                    }
                }
                $("#updChargeCycle").html(uChargeCycleSel);

                var aNursingLevelSel = "";
                for (var i = 0; i < len; i++) {
                    var uNursingLevel = document.getElementById("uNursingLevel").innerText;
                    var aNursingLevelName = row[i].name;
                    if (uNursingLevel == aNursingLevelName) {
                        var valueTemp4 = row[i].id;
                        var tempValue4 = carrentItem[0].fNursingLevel;
                        if (valueTemp4 == tempValue4) {
                            aNursingLevelSel += "<option selected='selected' value='" + row[i].id + "'>" + row[i].value + "</option>";
                        } else {
                            aNursingLevelSel += "<option value='" + row[i].id + "'>" + row[i].value + "</option>";
                        }

                    }
                }
                $("#updNursingLevel").html(aNursingLevelSel);
            }
        })
        // var aValueSel="";
        // for(var i=0;i<len;i++){
        //     var uValue=document.getElementById("uValue").innerText;
        //     var aValueName=row[i].name;
        //     if(uValue==aValueName) {
        //         var valueTemp5=row[i].value;
        //         var tempValue5=carrentItem[0].fValue;
        //         if(valueTemp5==tempValue5){
        //             aValueSel += "<option selected='selected' value='" + row[i].value + "'>" + row[i].value + "</option>";
        //         }else {
        //             aValueSel += "<option value='" + row[i].value + "'>" + row[i].value + "</option>";
        //         }
        //
        //     }
        // }
        // $("#updValue").html(aValueSel);

        $("#FID").val(carrentItem[0].fID);
        $("#updNursinghomeID").val(carrentItem[0].fNursinghomeID);
        $("#updChrgeNumber").val(carrentItem[0].fChrgeNumber);
        $("#updChrgeName").val(carrentItem[0].fChrgeName);
        $("#updPrice").val(carrentItem[0].fPrice);

        var bigObj = document.getElementById("updRefundType1");
        if((carrentItem[0].fRefundType)=="1"){
            bigObj.checked = true;
        }else{
            bigObj.checked = false;
        }
        // $(".updRefundType").val(carrentItem[0].fRefundType);
        $("#updChrgeStartDate").val(carrentItem[0].fChrgeStartDate);
        $("#updChrgeStopDate").val(carrentItem[0].fChrgeStopDate);

        $("#updValidityStartDate").val(carrentItem[0].fValidityStartDate);
        $("#updValidityEndDate").val(carrentItem[0].fValidityEndDate);
        // $("#updIsALLFee").val(carrentItem[0].fIsALLFee);
        // $("#updIsCycleFee").val(carrentItem[0].fIsCycleFee);

        $("#updValidityStartDate").val(carrentItem[0].fValidityStartDate);
        $("#updValidityEndDate").val(carrentItem[0].fValidityEndDate);

        var updIsALLFee = document.getElementById("updIsALLFee1");
        if((carrentItem[0].fIsALLFee)=="1"){
            updIsALLFee.checked = true;
        }else{
            updIsALLFee.checked = false;
        }

        var updIsCycleFee = document.getElementById("updIsCycleFee1");
        if((carrentItem[0].fIsCycleFee)=="1"){
            updIsCycleFee.checked = true;
        }else{
            updIsCycleFee.checked = false;
        }
        // $(".updIsALLFee").val(carrentItem[0].fIsALLFee);
        // $(".updIsCycleFee").val(carrentItem[0].fIsCycleFee);
        $("#updStatus").val(carrentItem[0].fStatus);
        $("#updExplain").val(carrentItem[0].fExplain);
        $("#update_btn").click();
    }else{
        setAlert("error","请先选择一条数据");
    }
}
