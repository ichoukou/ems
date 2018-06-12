/**
 * Created by wangjs on 2017/2/15.
 */
/**
 * Created by wanjs on 2017/1/12.
 */
$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    var oTable2 = new TableInit2();
    oTable2.Init();

    var oTable3 = new TableInit3();
    oTable3.Init();
});
// 老人费用显示列表
var TableInit3=function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_omChargeAll').bootstrapTable({
            url: 'query.do',   //请求后台的URL（*）
            method: 'get',      //请求方式（*）
            toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页（*）
            // sortable: true,      //是否启用排序
            // sortName:"id",
            // sortOrder: "asc",     //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,      //初始化加载第一页，默认第一页
            pageSize: 10,      //每页的记录行数（*）
            pageList: [10, 25, 50, 100],  //可供选择的每页的行数（*）
            search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: false,
            searchOnEnterKey:false,
            showColumns: true,     //是否显示所有的列
            showRefresh: true,     //是否显示刷新按钮
            minimumCountColumns: 2,    //最少允许的列数
            clickToSelect: true,    //是否启用点击选中行
            height: 520,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",      //每一行的唯一标识，一般为主键列
            showToggle:true,     //是否显示详细视图和列表视图的切换按钮
            cardView: false,     //是否显示详细视图
            // detailView: true,     //是否显示父子表
            columns: [{
                radio: true
            }, {
                field: 'foldManName',
                title: '老人',
                align: "center",
            }, {
                field: 'fID',
                title: '序号',
                align: "center",
            }, {
                field: 'fOldChargeStatus',
                title: '收费项目状态',
                align: "center",
                formatter:function(value){
                    if(value=="0"){
                        return '<span style="color:#00ff00">待收费</span>'
                    }else if(value=="1"){
                        return '<span style="color:#0000cc">已收费</span>'
                    }else if(value=="2"){
                        return '<span style="color:#FF0000">停止收费</span>'
                    }
                }
            }, {
                field: 'fChrgeTypeName',
                title: '费用类型',
                align: "center",
            }, {
                field: 'fChrgeName',
                title: '费用名称',
                align: "center",
            }, {
                field: 'fChargePrice',
                title: '单价',
                align: "center",
            }, {
                field: 'fChargeStartTime',
                title: '收费开始时间',
                align: "center",
            }, {
                field: 'fChargeEndTime',
                title: '收费结束时间',
                align: "center",
            } ],
            onLoadSuccess: function () {
                hebing();
            }
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset, //页码
            fOldManID:$("#searchOldManFid").val()
            // sortOrder:this.sortOrder,
            // name: $("#searchName").val(),
            // value: $("#searchValue").val()
        };
        return temp;
    };
    return oTableInit;
};

//合并编号相同的项
function hebing() {
    var trlist=$("#tb_omChargeAll  tbody tr");
    var beging=0;
    var end=0;
    var number=0;
    var tdlist;
    for(var i=0;i<trlist.size();i++)
    {
        tdlist=trlist.eq(i).find(' td ');
        if(number==tdlist.eq(1).html())
        {
            end=i;
            if(end==(trlist.size()-1))
            {
                tdlist=trlist.eq(beging).find(' td ');
                tdlist.eq(0).attr("rowspan",end-beging+1);
                tdlist.eq(1).attr("rowspan",end-beging+1);
                // tdlist.eq(2).attr("rowspan",end-beging+1);
                // tdlist.eq(3).attr("rowspan",end-beging+1);
                // tdlist.eq(4).attr("rowspan",end-beging+1);
                // tdlist.eq(5).attr("rowspan",end-beging+1);

                for(var j=(beging+1);j<=end;j++)
                {
                    tdlist=trlist.eq(j).find(' td ');
                    tdlist.eq(0).css('display','none');
                    tdlist.eq(1).css('display','none');
                    // tdlist.eq(2).css('display','none');
                    // tdlist.eq(3).css('display','none');
                    // tdlist.eq(4).css('display','none');
                    // tdlist.eq(5).css('display','none');

                }
            }
        }
        else{
            number=tdlist.eq(1).html();
            if((end-beging)>0)
            {
                tdlist=trlist.eq(beging).find(' td ');
                tdlist.eq(0).attr("rowspan",end-beging+1);
                tdlist.eq(1).attr("rowspan",end-beging+1);
                // tdlist.eq(2).attr("rowspan",end-beging+1);
                // tdlist.eq(3).attr("rowspan",end-beging+1);
                // tdlist.eq(4).attr("rowspan",end-beging+1);
                // tdlist.eq(5).attr("rowspan",end-beging+1);

                for(var j=(beging+1);j<=end;j++)
                {
                    tdlist=trlist.eq(j).find(' td ');
                    tdlist.eq(0).css('display','none');
                    tdlist.eq(1).css('display','none');
                    // tdlist.eq(2).css('display','none');
                    // tdlist.eq(3).css('display','none');
                    // tdlist.eq(4).css('display','none');
                    // tdlist.eq(5).css('display','none');
                }
            }
            beging=i;
            end=i;
        }
    }
}
//清空查询老人列表
function clear_queryAllCharge(){
    $("#fOldManNameShow").val("");
    $("#searchOldManFid").val("")
}
//查询老人费用列表
function queryAllCharge(){
    $.ajax({
        url:contextPath+"/manCharge/query.do",
        type:"post",
        data:{
            fOldManID:$("#searchOldManFid").val(),
            page:0,
            pageSize:10
        },
        success:function(data) {
            $('#tb_omChargeAll').bootstrapTable('refresh', {url: 'query.do'});
        }
    });
}


//收费标准列表
var TableInit2=function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#table_chargeStandard').bootstrapTable({
            url:contextPath+ '/charge/queryCharge.do',   //请求后台的URL（*）
            method: 'get',      //请求方式（*）
            toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            // pagination: true,     //是否显示分页（*）
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
            // pageNumber:1,      //初始化加载第一页，默认第一页
            // pageSize: 5,      //每页的记录行数（*）
            // pageList: [5,10, 25, 50, 100],  //可供选择的每页的行数（*）
            search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: false,
            searchOnEnterKey:false,
            // showColumns: true,     //是否显示所有的列
            // showRefresh: true,     //是否显示刷新按钮
            // minimumCountColumns: 2,    //最少允许的列数
            clickToSelect: true,    //是否启用点击选中行
            height: 300,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",      //每一行的唯一标识，一般为主键列
            // showToggle:true,     //是否显示详细视图和列表视图的切换按钮
            cardView: false,     //是否显示详细视图
            // detailView: true,     //是否显示父子表
            columns: [{
                radio: true
            }, {
                field: 'fID',
                title: '序号',
                align: "center",
            }, {
                field: 'fChrgeTypeName',
                title: '费用类型',
                align: "center",
            },  {
                field: 'fChrgeName',
                title: '费用名称',
                align: "center",
            }, {
                field: 'fPrice',
                title: '单价',
                align: "center",
            }, {
                field: 'fUnitName',
                title: '单位',
                align: "center",
            } ]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            fStatus: "11",
        };
        return temp;
    };
    return oTableInit;
};
// 老人添加费用时的列表
var TableInit=function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_omCharge').bootstrapTable({
            url: 'getList.do',   //请求后台的URL（*）
            method: 'get',      //请求方式（*）
            toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: false,     //是否显示分页（*）
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
            // pageNumber:1,      //初始化加载第一页，默认第一页
            // pageSize: 5,      //每页的记录行数（*）
            // pageList: [5,10, 25, 50, 100],  //可供选择的每页的行数（*）
            search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: false,
            searchOnEnterKey:false,
            // showColumns: true,     //是否显示所有的列
            // showRefresh: true,     //是否显示刷新按钮
            // minimumCountColumns: 2,    //最少允许的列数
            clickToSelect: true,    //是否启用点击选中行
            height: 300,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",      //每一行的唯一标识，一般为主键列
            // showToggle:true,     //是否显示详细视图和列表视图的切换按钮
            cardView: false,     //是否显示详细视图
            // detailView: true,     //是否显示父子表
            columns: [{
                checkbox:true
                // radio: true
            }, {
                field: 'fID',
                title: '序号',
                align: "center",
            }, {
                field: 'fOldChargeStatus',
                title: '收费项目状态',
                align: "center",
                formatter:function(value){
                    if(value=="0"){
                        return '<span style="color:#00ff00">待收费</span>'
                    }else if(value=="1"){
                        return '<span style="color:#0000cc">已收费</span>'
                    }else if(value=="2"){
                        return '<span style="color:#FF0000">停止收费</span>'
                    }
                }
            }, {
                field: 'fChrgeTypeName',
                title: '费用类型',
                align: "center",
            }, {
                field: 'fChrgeName',
                title: '费用名称',
                align: "center",
            }, {
                field: 'fChargePrice',
                title: '单价',
                align: "center",
            }, {
                field: 'fChargeStartTime',
                title: '收费开始时间',
                align: "center",
            }, {
                field: 'fChargeEndTime',
                title: '收费结束时间',
                align: "center",
            } ]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            // pageSize: params.limit, //页面大小
            // page: params.offset, //页码
            fOldManID:$("#oldManChargeAddId").val()
        };
        return temp;
    };
    return oTableInit;
};

//选择老人modal显示
function selectOldMan(){
    $('#oldManModal').modal('show');
    // 初始化老人列表
    initChooseOldManTb();
}
// 选择老人
function getOldManWithPhoto(id,name){
    // $("#oldMan_Id").val(temp.getAttribute("selectOmId"));
    // $("#oldManName").val(temp.getAttribute("selectName"));
    // 老人费用新增的查询
    $("#oldManChargeAddId").val(id);
    $("#oldManChargeAddName").val(name);
    $('#oldManModal').modal('hide');
    queryOldManCharge();
}

//费用列表选择老人modal显示
function selectOldManWithChargeList(){
    $('#showOldManModal').modal('show');
    // 初始化老人列表
    initChooseOldManTb_charge();
}
// 费用列表选择老人
function getOldManWithPhotoWithCharge(id,name){
    //老人费用列表页的查询
    $("#fOldManNameShow").val(name);
    $("#searchOldManFid").val(id);
    queryAllCharge();
    $('#showOldManModal').modal('hide');
}

//查询老人费用
function queryOldManCharge(){
    $.ajax({
        url:contextPath+"/manCharge/getList.do",
        type:"post",
        data:{
            fOldManID:$("#oldManChargeAddId").val()
        },
        success:function(data) {
            $('#tb_omCharge').bootstrapTable('refresh', {url: 'getList.do'});
        }
    });
}

// 清除所选老人和该老人的费用
function cleanAll(){
    $("#oldManChargeAddId").val("");
    $("#oldManChargeAddName").val("");
    queryOldManCharge()
}
// 点击>>把收费标准表添加到老人费用表
$("#selected_left").click(function(){
    var carrentItem = $("#table_chargeStandard").bootstrapTable('getSelections');
    if(carrentItem[0]){
        var oldManName=$("#oldManChargeAddName").val();
        if(oldManName==""){
            alert("请选择老人")
        }else{
            if(check_Recharge(carrentItem[0].fID,$("#oldManChargeAddId").val())){
                alert("数据已存在");
            }else{
                $.ajax({
                    url:contextPath+"/manCharge/addOldManCharge.do",
                    type:"post",
                    async:false,
                    data:{
                        fOldChargeStatus:"0",
                        fOldManID:$("#oldManChargeAddId").val(),
                        fManChargeID:carrentItem[0].fID,
                        fChargePrice:carrentItem[0].fPrice,
                        // fChargeStartTime:chargeTime,
                        fOldManName:oldManName
                    },
                    success:function(data) {
                        $('#tb_omCharge').bootstrapTable('refresh', {url: 'getList.do'});
                        $('#tb_omChargeAll').bootstrapTable('refresh', {url: 'query.do'});
                    }
                });
            }
        }
    }else{
        alert("请选择要缴费的项目")
    }
});
// 验证老人是否已经添加此费用
function check_Recharge(id,oldManId){
    var result=false;
    $.ajax({
        url:contextPath+"/manCharge/getOldManCharge.do",
        type:"post",
        async:false,
        data:{
            fOldManID:oldManId
        },
        success:function(data){
            for(var i=0;i<data.total;i++){
                if(data.rows[i].fManChargeID==id){
                    result=true;
                }
            }
        }
    })
    return result;
}

$("#selected_right").click(function(){
    var carrentItem = $("#tb_omCharge").bootstrapTable('getSelections');
    if(carrentItem[0]){
        var oldManName=$("#oldManChargeAddName").val();
        if(oldManName==""){
            alert("请选择老人")
        }else{
            if(carrentItem[0].fOldChargeStatus!='0'){
                alert("数据已使用，不允许删除")
            }else{
                $.ajax({
                    url:contextPath+"/manCharge/delOldManCharge.do",
                    type:"post",
                    async:false,
                    data:{
                        fID:carrentItem[0].fID
                    },
                    success:function(data) {
                        $('#tb_omCharge').bootstrapTable('refresh', {url: 'getList.do'});
                        $('#tb_omChargeAll').bootstrapTable('refresh', {url: 'query.do'});
                    }
                });
            }
        }
    }else{
        alert("请选择取消缴费的项目")
    }
});
//批量更改费用状态，包括添加应缴表和应缴明细表
function updChargeStatus(chargeStatus,flag){
    var oldManName=$("#oldManChargeAddName").val();
    if(oldManName==""){
        alert("请选择老人")
    }else {
        var carrentItem = $("#tb_omCharge").bootstrapTable('getSelections');
        if (carrentItem[0]) {
            if(judgeState(carrentItem,chargeStatus)){
                var selectArray = new Array();
                var chargeStatus = chargeStatus;
                var oldManId = $("#oldManChargeAddId").val();
                //新增是添加费用开始时间，停止时添加费用结束时间
                var now=new Date();
                var chargeTime=now.getFullYear()+"-"+(now.getMonth()+1)+"-"+now.getDate();
                for (var i = 0; i < carrentItem.length; i++) {
                    selectArray[i] = chargeStatus + "=" + carrentItem[i].fID + "=" + oldManId+"="+chargeTime;
                }

                // 批量修改费用状态
                updSelectChargeStatus(selectArray);
                // 1、老人应缴费费用 2、老人减免费用 3、	退老人应缴费用
                if (flag) {
                    addOldManPayment("1");
                } else {
                    addOldManPayment("3","tui");
                }
            }
        } else {
            alert("请选择数据")
        }
    }
}

//根据老人和应缴费类型判断老人应缴表是否已经有记录
// function check_oldManPayment(oldManId,bizType){
//     var result="";
//     $.ajax({
//         url: contextPath + "/pay/queryList.do",
//         type: "post",
//         async: false,
//         traditional: true,
//         data: {
//             foldmanID:oldManId,
//             fBizType:bizType
//         },
//         success: function (data) {
//             if(data.total>0){
//                 result=data.rows[0];
//             }
//         }
//     })
//     return result;
// }
// 0待收费
//1已收费
//2停止收费
function updSelectChargeStatus(selectArray){
    $.ajax({
        url: contextPath + "/manCharge/updChargeStatus.do",
        type: "post",
        async: false,
        traditional: true,
        data: {
            selectDataList: selectArray
        },
        success: function (data) {
            $('#tb_omCharge').bootstrapTable('refresh', {url: 'getList.do'});
            $('#tb_omChargeAll').bootstrapTable('refresh', {url: 'query.do'});
        }
    })
}
// 如果费用状态为已收费则不能再次收费，费用状态为停止收费和待收费则不能停止收费
function judgeState(carrentItem,chargeStatus){
    var result=true;
    for(var i=0;i<carrentItem.length;i++){
        if(carrentItem[i].fOldChargeStatus==chargeStatus){
            result=false;
            alert("有不合法数据，请重新选择");
            break;
        }
        if(carrentItem[i].fOldChargeStatus=='0'&&chargeStatus=='2'){
            result=false;
            alert("有不合法数据，请重新选择");
            break;
        }
    }
    return result;
}
// 添加应缴表
function addOldManPayment(bizType,flag){
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
            foldmanID:$("#oldManChargeAddId").val()
        },
        success:function(data) {
            getOldManPaymentId(flag);
        }
    });
}
// 得到应缴表最后一条数据
function getOldManPaymentId(flag){
    $.ajax({
        url:contextPath+"/pay/queryLast.do",
        type:"post",
        async:false,
        success:function(data) {
            var parentId=data.rows[0].fID;
            addOldManPaymentEntry(parentId,flag)
        }
    });
}
// 批量添加应缴明细表
function addOldManPaymentEntry(parentId,flag) {
    // $("#b1").attr("disabled",true)
    //批量新增收费项目
    var chargeArr=new Array();

    var carrentItem = $("#tb_omCharge").bootstrapTable('getSelections');
    for(var i=0;i<carrentItem.length;i++){
        // 判断是新增收费还是停止收费
        if(flag=="tui"){
            chargeArr[i]=parentId+"="+carrentItem[i].fID+"="+carrentItem[i].fManChargeID+"="+"-"+getChargeByHomeId(carrentItem[i].fChargePrice,carrentItem[i].fManChargeID);
        }else{
            chargeArr[i]=parentId+"="+carrentItem[i].fID+"="+carrentItem[i].fManChargeID+"="+getChargeByHomeId(carrentItem[i].fChargePrice,carrentItem[i].fManChargeID);
        }
    }

    $.ajax({
        url:contextPath+"/paymentEntry/addPaymentEntry.do",
        type:"post",
        async:false,
        traditional: true,
        data:{
            chargeArrPara:chargeArr
        },
        success:function(data) {
            if(flag=="tui"){
                alert("停止已选费用成功");
            }else{
                alert("老人费用添加成功");
            }

        }
    });
    // closeModal();
}
// 费用周期：每次（费用项目周期编码196）
// 因为是一次性费用，所以应该是全款1500元。

// 费用周期：阶段（费用项目周期编码16）
// 如果缴费日期在费用开始结束时间之中：费用=价格/(结束时间-开始时间)*(结束时间-当前日期)
// 否则，全额收费

// 根据登录人养老院ID查出应缴费类型
// 184,：费用周期是每月的费用，（老人入住的月份的最后一天减去老人入住日期再加上一天的结果）如果等于本月的天数就是满月，
// 185：如果小于本月的天数就是不满月。比如说老人是3月1号入住，那么（31-1+1）=31月3月份的31天相等就算满月，
// 186：如果老人是3月2号入住，那么（31-2+1）=30 小于 3月份的31天，那就不算满月。
function getChargeByHomeId(charge,chargeId){
    var realCharge="";
    $.ajax({
        url:contextPath+"/nursing/getNusingHomeById.do",
        type:"post",
        async:false,
        traditional: true,
        success:function(data) {
            var flag="";

            var date = new Date();
            var nowYear=date.getFullYear();
            var nowMouth = date.getMonth() + 1;
            var nowDate=date.getDate();

            var chargeData=getChargeCycleById(chargeId);
            var chargeCycle=chargeData.fChargeCycle;
            // 费用周期，15每月，16阶段，196，每次
            if(chargeCycle=="15"){
                var row=data.rows;
                var chargeModeId=row[0].fChargeModeID;
                //满月按照月收费，不满月按照天收费，日费用=月费用/30天
                if(chargeModeId=="184"){
                    // 费用实际天数
                    var realDayNum=(30-nowDate)+1;
                    // 当月实际天数
                    var mouthDayNum=getDays();
                    if(mouthDayNum==realDayNum){
                        flag="fullMouth";
                    }
                    if(flag=="fullMouth"){
                        realCharge=charge;
                    }else{
                        realCharge=(charge/30)*realDayNum;
                    }
                }
                //满月按照实际天数收费，不满月按照天，日费用=月费用/30天
                if(chargeModeId=="185"){
                    // 费用实际天数
                    var realDayNum=(30-nowDate)+1;
                    // 当月实际天数
                    var mouthDayNum=getDays();
                    if(mouthDayNum==realDayNum){
                        flag="fullMouth";
                    }
                    if(flag=="fullMouth"){
                        realCharge=(charge/30)*realDayNum;
                    }
                }
                //满月按照月收费，不满月按照天收费，日费用=月费用/月实际天数
                if(chargeModeId=="186"){
                    var day = new Date(nowYear,nowMouth,0);
                    var lastDay = day.getDate();    //获取月份的最后一天
                    // 费用实际天数
                    var realDayNum=(lastDay-nowDate)+1;
                    // 当月实际天数
                    var mouthDayNum=getDays();
                    if(mouthDayNum==realDayNum){
                        flag="fullMouth";
                    }
                    if(flag=="fullMouth"){
                        realCharge=charge;
                    }else{
                        realCharge=(charge/mouthDayNum)*realDayNum;
                    }
                }
            }
            // 费用周期：阶段（费用项目周期编码16）
            // 如果缴费日期在费用开始结束时间之中：费用=价格/(结束时间-开始时间)*(结束时间-当前日期)
            // 否则，全额收费
            if(chargeCycle=="16"){
                var nowDate=nowYear+"-"+nowMouth+"-"+nowDate;
                if(Date.parse(chargeData.fChrgeStopDate)>Date.parse(nowDate)&&Date.parse(nowDate)>Date.parse(chargeData.fChrgeStartDate)){
                    var ChargeDays=DateDiff((chargeData.fChrgeStopDate),(chargeData.fChrgeStartDate));
                    // alert(ChargeDays)
                    var realDays=DateDiff((chargeData.fChrgeStopDate),nowDate);
                    // alert(realDays)
                    realCharge=charge/(ChargeDays+1)*(realDays+1);
                }else{
                    realCharge=charge;
                }
            }

            if(chargeCycle=="196"){
                realCharge=charge;
            }

        }
    });
    // alert(realCharge)
    return realCharge;
}
function getChargeCycleById(chargeId){
    var chargeCycle="";
    $.ajax({
        url:contextPath+"/charge/queryCharge.do",
        type:"post",
        async:false,
        data:{
            fID:chargeId
        },
        success:function(data) {
            if(data.total>0){
                chargeCycle=data.rows[0]
            }else{
                console.log("根据收费标准查费用周期失败")
            }
        }
    })
    return chargeCycle;
}
//计算天数差的函数，通用
function  DateDiff(sDate1,  sDate2){    //sDate1和sDate2是2017-3-18格式
    var  aDate,  oDate1,  oDate2,  iDays;
    aDate  =  sDate1.split("-");
    oDate1  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0]);    //转换为3-18-2017格式
    aDate  =  sDate2.split("-");
    oDate2  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0]);
    iDays  =  parseInt(Math.abs(oDate1  -  oDate2)  /  1000  /  60  /  60  /24);  //把相差的毫秒数转换为天数
    return  iDays
}

// 得到当月天数
function getDays(){
    var date = new Date();
    var year = date.getFullYear();
    var mouth = date.getMonth() + 1;
    //定义当月的天数；
    var days ;

    //当月份为二月时，根据闰年还是非闰年判断天数
    if(mouth == 2){
        days= year % 4 == 0 ? 29 : 28;
    }
    else if(mouth == 1 || mouth == 3 || mouth == 5 || mouth == 7 || mouth == 8 || mouth == 10 || mouth == 12){
        //月份为：1,3,5,7,8,10,12 时，为大月.则天数为31；
        days= 31;
    }
    else{
        //其他月份，天数为：30.
        days= 30;
    }
    return days;
}