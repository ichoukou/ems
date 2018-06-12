/**
 * Created by wangjs on 2016/12/23.
 */
$(function () {
    var oldManChargeprice="";
    var oldManAllChargeprice="";
    $("#undo_redo_rightSelected").click(function () {
        //1,方式一
        //        var $option = $("#select1 option:selected");  //获取选中的选项
        //        var $remove = $option.remove(); //删除下拉列表中选中的选项
        //        $remove.appendTo("#select2");  //追加给对方
        // 2，方式二
        var $option = $("#undo_redo option:selected");  //获取选中的选项
        $option.prependTo("#undo_redo_to");  //追加给对方

        $("#oldManChargeId").val($option.val());
        oldManChargeprice=$option.attr("oldManChargeprice");
        oldManChargeprice=oldManChargeprice-0;

        oldManAllChargeprice=oldManAllChargeprice-0;
        oldManAllChargeprice+=oldManChargeprice;

        $("#totalCost").val(" ");
        $("#totalCost").val(oldManAllChargeprice);
        addOldManCharge(oldManChargeprice);

    });
    // $("#undo_redo_rightAll").click(function () {
    //     var $option = $("#undo_redo option");
    //
    //     $option.appendTo("#undo_redo_to");
    //     addOldManPaymentEntry();
    // });
    $("#undo_redo_leftSelected").click(function () {
        oldManAllChargeprice=oldManAllChargeprice-0;
        oldManAllChargeprice-=oldManChargeprice;

        $("#totalCost").val(" ");
        $("#totalCost").val(oldManAllChargeprice);
        var $option = $("#undo_redo_to option:selected");
        $option.prependTo("#undo_redo");

        delOldManCharge($option.val());
    });
    // $("#undo_redo_leftAll").click(function () {
    //     var $option = $("#undo_redo_to option");
    //     $option.appendTo("#undo_redo");
    // });

    //双击选项
    $('#select1').dblclick(function(){ //绑定双击事件
        //获取全部的选项,删除并追加给对方
        $("option:selected",this).appendTo('#select2'); //追加给对方
    });
});

function delOldManCharge(chargeId){
    $.ajax({
        url:contextPath+"/manCharge/delOldManCharge.do",
        type:"post",
        async:false,
        data:{
            fID:chargeId
        },
        success:function(data) {
            $('#tb_oldManHosing').bootstrapTable('refresh', {url: 'query.do'});
        }
    });
}

//新增收费项目
function addOldManCharge(oldManChargeprice){
    var chargeTime=now.getFullYear()+"-"+(now.getMonth()+1)+"-"+now.getDate()+" "+now.getHours()+":"+now.getMinutes()+":"+now.getSeconds();
    $.ajax({
        url:contextPath+"/manCharge/addOldManCharge.do",
        type:"post",
        async:false,
        data:{
            fOldChargeStatus:"0",
            fOldManID:$("#fOldManID").val(),
            fManChargeID:$("#oldManChargeId").val(),
            fChargePrice:oldManChargeprice,
            fNursingHomeID:"399",
            fChargeStartTime:chargeTime,
            fOldManName:$("#oldManName").val()
        },
        success:function(data) {
            $('#tb_oldManHosing').bootstrapTable('refresh', {url: 'query.do'});
        }
    });
    closeModal();
}

// var chargeArray=new Array();
// function getOldCharge(){
//     $.ajax({
//         url:contextPath+"/manCharge/getList.do",
//         type:"post",
//         async:false,
//         data:{
//
//             // fOldManID:$("#fOldManID").val()
//             fOldManID:"29"
//         },
//         success:function(data){
//             var len=data.total;
//             var row=data.rows;
//             for(var i=0;i<len;i++){
//                 chargeArray[i]=row[i].fManChargeID;
//             }
//             console.log(chargeArray);
//             getChargeMess()
//         }
//     })
// }

//查询所有收费标准
function queryStandard(){
    $.ajax({
        url:contextPath+"/charge/queryCharge.do",
        type:"post",
        success:function(data) {
            var len=data.total;
            var row=data.rows;
            // var allCharge="<option>序号 费用类型 费用名称 单价 单位</option>";
            var allCharge="";
            for(var i=0;i<len;i++){
                if($("#chargeId").val()==row[i].fID||$("#chargeHuId").val()==row[i].fID){
                    allCharge+="<option style='color: red;' oldManChargePrice='"+row[i].fPrice+"' value='"+row[i].fID+"'>"+row[i].fID+" "+row[i].fChrgeType+" "+row[i].fChrgeName+" "+row[i].fPrice+" "+row[i].fUnit+"</option>";
                }
            }
            for(var i=0;i<len;i++){
                // allCharge+="<tr><td><option value='"+row[i].fID+"'>"+row[i].fID+"</option></td><td>费用类型</td><td>费用名称</td><td><option value='"+row[i].fPrice+"'>"+row[i].fPrice+"</option></td><td>单位</td></tr>"
                allCharge+="<option oldManChargePrice='"+row[i].fPrice+"' value='"+row[i].fID+"'>"+row[i].fID+" "+row[i].fChrgeType+" "+row[i].fChrgeName+" "+row[i].fPrice+" "+row[i].fUnit+"</option>";
            }
            $("#undo_redo").html(allCharge);
        }
    });
}

// function getChargeMess(){
//     $.ajax({
//         url:contextPath+"/charge/queryChargeMess.do",
//         type:"post",
//         async:false,
//         traditional: true,
//         data:{
//             arrayCharge:chargeArray
//         },
//         success:function(data){
//             var len=data.total;
//             var row=data.rows;
//             // var allCharge="<option>序号 费用类型 费用名称 单价 单位</option>";
//             var allCharge="";
//             for(var i=0;i<len;i++){
//                 // allCharge+="<tr><td><option value='"+row[i].fID+"'>"+row[i].fID+"</option></td><td>费用类型</td><td>费用名称</td><td><option value='"+row[i].fPrice+"'>"+row[i].fPrice+"</option></td><td>单位</td></tr>"
//                 allCharge+="<option value='"+row[i].fID+"'>"+row[i].fID+" "+row[i].fChrgeType+" "+row[i].fChrgeName+" "+row[i].fPrice+" "+row[i].fUnit+"</option>";
//             }
//             $("#undo_redo").html(allCharge);
//         }
//     })
// }

//把收费状态设成1收费开始
//把收费状态设成0收费无效
function updChargeStatus(chargeStatus,flag){
    var selectArray=new Array();
    var chargeStatus=chargeStatus;

    var selectData=document.getElementById('undo_redo_to').children;
    var oldManId=$("#fOldManID").val();
    for(var i=0,len=selectData.length;i<len;i++){
        selectArray[i]=chargeStatus+"-"+selectData[i].value+"-"+oldManId;
    }
    $.ajax({
        url:contextPath+"/manCharge/updChargeStatus.do",
        type:"post",
        async:false,
        traditional: true,
        data:{
            selectDataList:selectArray
        },
        success:function(data){
            //新增老人的時候添加应缴表
            if(flag){
                addOldManPayment();
            }else{
                alert("停止已选费用成功");
            }

        }
    })

}

function addOldManPayment(){
    $.ajax({
        url:contextPath+"/pay/omPayment.do",
        type:"post",
        async:false,
        data:{
            fnursing_homeID:"3434",
            fnumber:"1234567890",
            fstatus:"1",
            foldmanID:$("#fOldManID").val()
        },
        success:function(data) {
            getOldManPaymentId();
        }
    });
}

function getOldManPaymentId(){
    $.ajax({
        url:contextPath+"/pay/queryLast.do",
        type:"post",
        async:false,
        success:function(data) {
            var parentId=data.rows[0].fID;
            addOldManPaymentEntry(parentId)
        }
    });
}

function addOldManPaymentEntry(parentId) {
    $("#b1").attr("disabled",true)
    //批量新增收费项目
    var chargeArr=new Array();

    var $option = $("#undo_redo_to option");
    var selectData=document.getElementById('undo_redo_to').children;

    for(var i=0;i<$option.length;i++){
        chargeArr[i]=parentId+"="+selectData[i].value+"="+$option.attr("oldManChargePrice");
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
            alert("老人费用添加成功")
        }
    });
    closeModal();
}