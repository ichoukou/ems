/**
 * Created by wangjs on 2016/12/15.
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
        $('#tb_oldManHosing').bootstrapTable({
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
            strictSearch: false,
            searchOnEnterKey:false,
            showColumns: true,     //是否显示所有的列
            showRefresh: true,     //是否显示刷新按钮
            minimumCountColumns: 2,    //最少允许的列数
            clickToSelect: true,    //是否启用点击选中行
            // height: 350,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",      //每一行的唯一标识，一般为主键列
            showToggle:true,     //是否显示详细视图和列表视图的切换按钮
            cardView: false,     //是否显示详细视图
            detailView: false,     //是否显示父子表
            columns: [{
                radio: true
            }, {
                field: 'fID',
                title: '序号',
                align: "center",
                width:94
            }, {
                field: 'foldManStatusName',
                title: '状态',
                align: "center",
                // formatter:function(value){
                //     if(value=='10'){
                //         return '<span style="color:#00ff00">请假</span>'
                //     }else if(value=='2'){
                //         return '<span style="color:#FF0000">出院</span>'
                //     }else if(value=='3'){
                //         return '<span style="color:#0000cc">在院</span>'
                //     }
                // }
            },  {
                field: 'foldManName',
                title: '老人',
                align: "center",
            }, {
                field: 'fBuildingName',
                title: '大厦',
                align: "center",
            }, {
                field: 'fRoomName',
                title: '房间',
                align: "center",
            },
            //     {
            //     field: 'ffloorName',
            //     title: '楼层',
            //     align: "center",
            // },
                {
                field: 'fBedNumber',
                title: '床位',
                align: "center",
                // formatter:function(value){
                //     if(value==""){
                //         return '<span style="color:#00ff00">整租</span>'
                //     }else{
                //         return value
                //     }
                // }
            }, {
                field: 'fcheckinTime',
                title: '入住日期',
                align: "center",
                width:180,
            }, {
                field: 'fnursingLevelName',
                title: '护理级别',
                align: "center",
            },{
                field: 'fnursing',
                title: '护理员',
                align: "center",
            }
            ,{
                field: 'id',
                title: '操作',
                align: 'center',
                width: 95,
                formatter:function(value,row,index){
                    // console.log(JSON.stringify(row));
                    var str=JSON.stringify(row);
                    //str=str.substring(1,str.length-1);
                    str=str.replace(/\"/g,"=");
                    str=str.replace(/\\/g,"*");
                    return  "<a href='javascript:void(0)' class='glyphicon glyphicon-pencil' style='color: #1C84C6' onclick=\"goto_showBase('"+str+"')\">详细</a>" ;
                }
            }
            ]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset, //页码
            foldManName:$("#searchName").val(),
            foldManStatusID:$("#searchfoldManStatusID").val(),
            startTime:$("#searchfcheckinTime").val(),
            fnursing:$("#searchfnursing").val(),
            froomID:$("#searchfroomID").val(),
            stopTime:$("#searchFcheckoutTime").val(),
        };
        return temp;
    };
    return oTableInit;
};

function goto_showBase(str){
    $("#showModal").modal("show");
    str=str.replace(/\=/g,"\"");
    str=str.replace(/\*/g,"\\");
    var po= JSON.parse(str);
    $("#oldManNum").text(po.foldManNum);
    $("#oldMan_Name").text(po.foldManName);

    $("#oldManIDnSex").text(po.fOldManIDnSex);
    $("#oldManStatusID").text(po.foldManStatusName);
    $("#occupation").text(po.foccupation);
    $("#oldManBirth").text(po.foldManBirth);
    $("#oldManPoliticsID").text(po.foldManPoliticsID);
    $("#oldManNationID").text(po.foldManNationID);
    $("#oldManMediaID").text(po.foldManMediaID);
    $("#contractNo").text(po.fcontractNo);
    $("#contractBegin").text(po.fcontractBegin);
    $("#contractEnd").text(po.fcontractEnd);
    $("#minsuranceType").text(po.fMInsuranceType);
    $("#oldManCardNo").text(po.foldManCardNo);
    $("#transactor").text(po.ftransactor);
    $("#nursing").text(po.fnursing);
    $("#oldManBeliefID").text(po.foldManBeliefID);
    $("#oldManTypeID").text(po.foldManTypeName);
    $("#oldManMobile").text(po.foldManMobile);
    $("#checkinTime").text(po.fcheckinTime);
    $("#buildingID").text(po.fBuildingName);
    $("#roomID").text(po.fRoomName);
    var BedNumber="整租";
    if(po.fBedNumber!=null&&po.fBedNumber!=""){
        BedNumber=po.fBedNumber;
    }
    $("#bedID").text(BedNumber);


    $("#oldManIdCard").text(po.foldManIdCard);

    $("#nursingLevel").text(po.fnursingLevelName);

    $("#oldManNative").text(po.foldManNative);
    $("#instruction").text(po.fInstruction);

    $('#img_3').attr('src',"/ems/picture/"+po.fPhoto);
}
//清除选项
function queryclear() {
    $("#searchName").val("");
    $("#searchfoldManStatusID").val("");
    $("#searchfcheckinTime").val("");
    $("#searchfnursing").val("");
    $("#searchfroomID").val("");
    $("#searchFcheckoutTime").val("");
}

//查询
function queryOmHosing(){
    $.ajax({
        url:contextPath+"/hosing/query.do",
        type:"post",
        data:{
            foldManName:$("#searchName").val(),
            foldManStatusID:$("#searchfoldManStatusID").val(),
            startTime:$("#searchfcheckinTime").val(),
            fnursing:$("#searchfnursing").val(),
            froomID:$("#searchfroomID").val(),
            stopTime:$("#searchFcheckoutTime").val(),
            page:0,
            pageSize:10
        },
        success:function(data) {
            $('#tb_oldManHosing').bootstrapTable('load', data);
        }
    });
}

function getAllRoom(){
    $.ajax({
        url: contextPath + "/room/get.do",
        type: "post",
        success: function (data) {
            var roomLen = data.total;
            var roomRow = data.rows;
            var room = "<option value=''> --请选择-- </option>";
            for (var i = 0; i < roomLen; i++) {
                room += "<option value='" + roomRow[i].fID + "'>" + roomRow[i].fRoomName + "</option>";
            }
            $("#searchfroomID").html(room);
        }
    });
}

function getAllOldManState(){
    $.ajax({
        url: contextPath + "/sys/get.do",
        type: "post",
        success: function (data) {
            var len = data.total;
            var row = data.rows;
            var oldManState = "<option value=''> --请选择-- </option>";
            for (var i = 0; i < len; i++) {
                if(row[i].name=='老人状态'){
                    if(row[i].status!='10'){
                        oldManState += "<option value='" + row[i].id + "'>" + row[i].value + "</option>";
                    }
                }
            }
            $("#searchfoldManStatusID").html(oldManState);
        }
    });
}

//获取当前时间，格式YYYY-MM-DD
function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "";
    var year = date.getFullYear();
    var month = date.getMonth() + 1;
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = year + seperator1 + month + seperator1 + strDate;
    return currentdate;
}

// 圖片上傳
// 显示本地图片
function onChangFile(seqId){
    var obj = getObjectURL(document.getElementById('file_'+seqId).files[0]);
    $('#img_'+seqId).attr('src',obj);
    UploadFile(seqId)
    // UploadFile('1')
};

// 获取二进制对象
function getObjectURL(file) {
    var url = null ;
    if (window.createObjectURL!=undefined) { // basic
        url = window.createObjectURL(file) ;
    } else if (window.URL!=undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file) ;
    } else if (window.webkitURL!=undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file) ;
    }
    return url ;
};

//异步文件上传(jquery)
function UploadFile(seqId) {
    var now=new Date();
    var imageName=now.getFullYear()+""+(now.getMonth()+1)+""+now.getDate()+""+now.getHours()+""+now.getMinutes()+""+now.getSeconds();
    $("#imageName").val(imageName);
    $.ajaxFileUpload({
        url : contextPath+"/file/upload.do",   //submit to UploadFileServlet
        secureuri : false,
        fileElementId : 'file_'+seqId,
        dataType : 'JSON', //or json xml whatever you like~
        data: {//加入的文本参数
            "formFieldId": "param1",
            imgName:imageName
        },
        success : function(data, status) {
            alert("上传图片成功");
            // data = data.substring(data.indexOf("{"),data.indexOf("}")+1);
            // var json = eval("(" +data+ ")");
            // // 提示信息
            // $("#message_"+seqId).text(json.message);
            // // url 回写
            // $("#url_"+seqId).text(json.fileUrl);
            //
            // $("#uploadButton_"+seqId).attr("disabled",true);

        },
        error : function(data, status, e) {
            $("#result").append(data);
        }
    });
    // return false;
}

//回显数据到添加界面
$(document).ready(
    getAllRoom(),
    getAllOldManState()
)

//大厦，房间，床位联动
var buildSel=document.getElementById("fbuildingID");
buildSel.onchange=function(){
    var buildId=buildSel.options[buildSel.selectedIndex].value;
    if(buildId==""){
        $("#froomID").html("");
    }else{
        getRoom(buildId);
    }
    $("#fbedID").html("");
};

var roomSel=document.getElementById("froomID");
roomSel.onchange=function(){
    var roomId=roomSel.options[roomSel.selectedIndex].value;
    var administratorsId=getRoomByID(roomId);
    var administratorsName=getNameByID(administratorsId);
    //房间负责人
    $("#fnursing").val(administratorsName);
    getRoomPrice();
    if(roomId==""){
        $("#fbedID").html("");
    }else{
        getBed(roomId);
    }
};

function getNameByID(administratorsId){
    var administratorsName="";
    $.ajax({
        url: contextPath + "/employee/get.do",
        type: "post",
        async:false,
        data: {
            fId:administratorsId,
        },
        success: function (data) {
            administratorsName=data.rows[0].fStaffName;
        }
    });
    return administratorsName;
}
//修改时大厦，房间，床位联动
var updbuildSel=document.getElementById("updfbuildingID");
updbuildSel.onchange=function(){
    var buildId=updbuildSel.options[updbuildSel.selectedIndex].value;
    if(buildId==""){
        $("#updfroomID").html("");
    }else{
        getRoom(buildId);
    }
    $("#updfbedID").html("");
};
var updroomSel=document.getElementById("updfroomID");
updroomSel.onchange=function(){
    var roomId=updroomSel.options[updroomSel.selectedIndex].value;
    var administratorsId=getRoomByID(roomId);
    var administratorsName=getNameByID(administratorsId);
    //房间负责人
    $("#fnursing").val(administratorsName);
    getRoomPrice();
    if(roomId==""){
        $("#updfbedID").html("");
    }else{
        getBed(roomId);
    }
};

function getBuilding(fbuilding) {
    $.ajax({
        url: contextPath + "/building/get.do",
        type: "post",
        success: function (data) {
            var buildLen = data.total;
            var buildRow = data.rows;
            var build = "<option value=''> --请选择-- </option>";
            for (var i = 0; i < buildLen; i++) {
                if(fbuilding==buildRow[i].fID){
                    build += "<option selected='' value='" + buildRow[i].fID + "'>" + buildRow[i].fBuildingName + "</option>";
                }else{
                    if(buildRow[i].fStatus=="11"){
                        build += "<option  value='" + buildRow[i].fID + "'>" + buildRow[i].fBuildingName + "</option>";
                    }
                }
            }
            $("#fbuildingID").html(build);
            $("#updfbuildingID").html(build);
        }
    });
}

function getRoomPrice() {
    var myRoomPrice=$("#froomID").find("option:selected").attr("myRoomPrice")
    $("#myRoomPrice").val(myRoomPrice);
    var roomBed="";
    var roomBedCount = $("#froomID").find("option:selected").attr("roomBedCount");
    if (roomBedCount > 0) {
        for (var m = 0; m < roomBedCount; m++) {
            if(m!=(roomBedCount-1)) {
                roomBed += (m+1) + ",";
            }else{
                roomBed+=(m+1);
            }
        }
    }
    $("#roomBed").val(roomBed);
}

function getRoomByID(roomId) {
    var administratorsId="";
    $.ajax({
        url: contextPath + "/room/get.do",
        type: "post",
        async:false,
        data: {
            fID:roomId,
        },
        success: function (data) {
            administratorsId=data.rows[0].fAdministratorsID;
        }
    });
    return administratorsId;
}

function getRoom(buildId,roomId) {
    $.ajax({
        url: contextPath + "/room/get.do",
        type: "post",
        data: {
            fBuildingID:buildId,
        },
        success: function (data) {

            var roomLen = data.total;
            var roomRow = data.rows;
            var room = "<option value=''> --请选择-- </option>";
            for (var i = 0; i < roomLen; i++) {
                if(roomId==roomRow[i].fID){
                    room += "<option selected='selected' roomBedCount='"+roomRow[i].fBedCount+"' myRoomPrice='"+roomRow[i].fRoomPrice+"' value='" + roomRow[i].fID + "'>" + roomRow[i].fRoomName + "</option>";
                }else{
                    if(roomRow[i].fStatus!="11"&&roomRow[i].fStatus!="2"){
                        room += "<option roomBedCount='"+roomRow[i].fBedCount+"' myRoomPrice='"+roomRow[i].fRoomPrice+"' value='" + roomRow[i].fID + "'>" + roomRow[i].fRoomName + "</option>";
                    }
                }
            }
            $("#froomID").html(room);
            $("#updfroomID").html(room);
        }
    });
}

function addBedPrice(){
    var bedPrice=$("#fbedID").find("option:selected").attr("myPrice");
    $("#bedPrice").val(bedPrice);
}

function getBed(roomId,bedId) {
    $.ajax({
        url: contextPath + "/bed/get.do",
        type: "post",
        data: {
            fRoomID:roomId,
        },
        success: function (data) {

            var bedLen = data.total;
            var bedRow = data.rows;
            var bed = "<option value=''> --请选择-- </option>";
            for (var i = 0; i < bedLen; i++) {
                if(bedId==bedRow[i].fID){
                    bed += "<option selected='selected' myPrice='"+bedRow[i].fBedPrice+"' value='" + bedRow[i].fID + "'>" + bedRow[i].fBedNumber + "</option>";
                }else{
                    if(bedRow[i].fStatus=="2"){
                        bed += "<option myPrice='"+bedRow[i].fBedPrice+"' value='" + bedRow[i].fID + "'>" + bedRow[i].fBedNumber + "</option>";
                    }
                }
            }
            $("#fbedID").html(bed);
            $("#updfbedID").html(bed);

        }
    });
}

function myGray(obj){
    if(getAllBedStateByRoom($("#froomID").val(),'9')){
        document.getElementById("fisEntire").checked=false;
        // obj.checked=false;
    }else{
        var select=document.getElementById("fbedID");
        if(obj.checked==true) {
            $("#fbedID").val("");
            select.disabled = true;
            select.style="background-color: gray";
        }else{
            select.disabled = false;
            select.style=""
        }
    }

    // getChargeStandard(true);
}

function getAllBedStateByRoom(roomId,flag){
    var result=false;
    if(getBedStateByRoom(roomId,'11',flag)){
        result=true;
    }
    if(getBedStateByRoom(roomId,'10',flag)){
        result=true;
    }
    if(getBedStateByRoom(roomId,'01',flag)){
        result=true;
    }
    return result;
}
//此函数判断整租（9）  和修改时释放完床位查询此房间床位是否全是空闲
function getBedStateByRoom(roomId,state,zhengZu){
    var flag=false;
    $.ajax({
        url:contextPath+"/bed/get.do",
        type:"post",
        async:false,
        data:{
            fRoomID:roomId,
            fStatus:state
        },
        success:function(data) {
            // alert(data.total)
            // if(data.total==0){
            //     updRoomState($("#froomID").val())
            // }else
            if(data.total>0&&zhengZu=='9'){
                flag=true;
                alert("此房间不能整租")
            }
        }
    });
    return flag;
}

function myUpdGray(obj){
    var select=document.getElementById("updfbedID");
    if(obj.checked==true) {
        if(getAllBedStateByRoom($("#updfroomID").val(),'9')){
            obj.checked=false;
        }else{
            $("#updfbedID").val("");
            select.disabled = true;
            select.style="background-color: gray";
        }
    }else{
        select.disabled = false;
        select.style=""
    }

    // getChargeStandard(true);
}

function getDcList() {
    $.ajax({
        url: contextPath + "/sys/get.do",
        type: "post",
        success: function (data) {
            var now=new Date();
            var temp=now.getFullYear()+"-"+(now.getMonth()+1)+"-"+now.getDate();
            var str=now.getFullYear()+""+(now.getMonth()+1)+""+now.getDate()+""+now.getHours()+""+now.getMinutes()+""+now.getSeconds()+""+now.getMilliseconds();
            $("#fcontractNo").val("No" + str);
            $("#fcontractBegin").val(temp);
            $("#fcheckinTime").val(temp);

            //办理人和护理员
            // $("#ftransactor").val("jueye");

            var len = data.total;
            var row = data.rows;
            var foldManStatusIDStr = "";
            for (var i = 0; i < len; i++) {
                var foldManStatusIDStrName = row[i].name;
                if (foldManStatusIDStrName == "老人状态") {
                    if (row[i].status != '10') {
                        foldManStatusIDStr += "<option value='" + row[i].id + "'>" + row[i].value + "</option>";
                    }
                }
            }
            $("#foldManStatusID").html(foldManStatusIDStr);

            var foldManNationIDStr = "";
            for (var i = 0; i < len; i++) {
                var foldManNationIDName = row[i].name;
                if (foldManNationIDName == "民族") {
                    foldManNationIDStr += "<option value='" + row[i].value + "'>" + row[i].value + "</option>";
                }
            }
            $("#foldManNationID").html(foldManNationIDStr);

            var foldManTypeIDStr = "";
            for (var i = 0; i < len; i++) {
                var foldManTypeIDName = row[i].name;
                if (foldManTypeIDName == "入住类型") {
                    foldManTypeIDStr += "<option value='" + row[i].id + "'>" + row[i].value + "</option>";
                }
            }
            $("#foldManTypeID").html(foldManTypeIDStr);

            var foldManMediaIDStr = "";
            for (var i = 0; i < len; i++) {
                var foldManMediaIDName = row[i].name;
                if (foldManMediaIDName == "媒体渠道") {
                    foldManMediaIDStr += "<option value='" + row[i].value + "'>" + row[i].value + "</option>";
                }
            }
            $("#foldManMediaID").html(foldManMediaIDStr);

            var fOldManIDnSexStr = "";
            for (var i = 0; i < len; i++) {
                var fOldManIDnSexName = row[i].name;
                if (fOldManIDnSexName == "性别") {
                    fOldManIDnSexStr += "<option value='" + row[i].value + "'>" + row[i].value + "</option>";
                }
            }
            $("#fOldManIDnSex").html(fOldManIDnSexStr);

            var foldManBeliefIDStr = "";
            for (var i = 0; i < len; i++) {
                var foldManBeliefIDName = row[i].name;
                if (foldManBeliefIDName == "信仰") {
                    foldManBeliefIDStr += "<option value='" + row[i].value + "'>" + row[i].value + "</option>";
                }
            }
            $("#foldManBeliefID").html(foldManBeliefIDStr);

            var foldManPoliticsIDStr = "";
            for (var i = 0; i < len; i++) {
                var foldManPoliticsIDName = row[i].name;
                if (foldManPoliticsIDName == "政治面貌") {
                    foldManPoliticsIDStr += "<option value='" + row[i].value + "'>" + row[i].value + "</option>";
                }
            }
            $("#foldManPoliticsID").html(foldManPoliticsIDStr);

            var foccupationStr = "";
            for (var i = 0; i < len; i++) {
                var foccupationName = row[i].name;
                if (foccupationName == "职业") {
                    foccupationStr += "<option value='" + row[i].value + "'>" + row[i].value + "</option>";
                }
            }
            $("#foccupation").html(foccupationStr);

            var fMInsuranceTypeStr = "";
            for (var i = 0; i < len; i++) {
                var fMInsuranceTypeName = row[i].name;
                if (fMInsuranceTypeName == "医保类型") {
                    fMInsuranceTypeStr += "<option value='" + row[i].value + "'>" + row[i].value + "</option>";
                }
            }
            $("#fMInsuranceType").html(fMInsuranceTypeStr);

            var fnursingLevelStr = "";
            for (var i = 0; i < len; i++) {
                var fnursingLevelName = row[i].name;
                if (fnursingLevelName == "项目等级") {
                    fnursingLevelStr += "<option value='" + row[i].id + "'>" + row[i].value + "</option>";
                }
            }
            $("#fnursingLevel").html(fnursingLevelStr);
        }
    });
}
// 添加时加验证
function add_check_Base() {
    var result=true;

    if(!addCheck_name_base()){
        result=false;
    }

    // if(!addCheck_contentStopDate_base()){
    //     result=false;
    // }

    if(!addCheck_nursingLevel_base()){
        result=false;
    }

    // if(!addCheck_cardId_base()){
    //     result=false;
    // }

    if(!addCheck_buildingID_base()){
        result=false;
    }

    // if(!addCheck_fileUpload_base()){
    //     result=false;
    // }

    // if(!addCheck_oldManNative_base()){
    //     result=false;
    // }

    // if(!checkMobilePhone()){
    //     result=false;
    // }


    var optionBed=document.getElementById("fbedID").options;
    var optionRoom=document.getElementById("froomID").options;

    if(($("#fbedID").val()=="")&&(document.getElementById("fisEntire").checked!=true)){
        alert("请选择床位或者整租房间");
        result = false;
    }

    if((optionBed.length==0)&&(document.getElementById("fisEntire").checked!=true)){
        alert("请选择床位或者整租房间");
        result = false;
    }



    return result;
}
//点击添加或修改的时候验证，如果被占用直接不通过，如果床位是空闲，检查房间，如果房间被占用，验证不通过，
function check_reHosing(roomId,bedId){
    var result=true;
    //先判断是否是整租
    if(bedId==""||bedId==null){
        if(!check_reRoom(roomId)){
            result=false;
        }
    }else{
        if(check_reBed(bedId)){
            if(!check_reRoom(roomId)){
                result=false;
            }
        }else{
            result=false;
        }
    }
    return result;
}

function check_reRoom(roomId){
    var result=false;
    $.ajax({
        url:contextPath+"/room/get.do",
        type:"post",
        async:false,
        data:{
            fID:roomId,
            //房间状态：11已满，01空闲，10未满，2停用
            // fStatus:11
        },
        success:function(data) {
            if(data.total>0){
                var state=data.rows[0].fStatus;
                if(state=="10"||state=="01"){
                    result=true;
                }else{
                    alert("此房间已被占用，请重新选择")
                }
            }
        }
    });
    return result;
}

function check_reBed(bedId) {
    var result=false;
    $.ajax({
        url:contextPath+"/bed/queryBedByRoom.do",
        type:"post",
        async:false,
        data:{
            fID:bedId,
            fStatus:2
        },
        success:function(data) {
            if(data.total>0){
                result=true;
            }else{
                alert("此床位已被占用，请重新选择")
            }
        }
    });
    return result;
}

// function checkMobilePhone(){
//     var result=true;
//     var fMobileTel = $("#foldManMobile").val().trim();
//     var reg=new RegExp(/^1[34578]\d{9}$/);
//     $("#add_foldManMobile_base").html("");
//     if (fMobileTel==""||!reg.test(fMobileTel)){
//         $("#add_foldManMobile_base").html("!");
//         result = false;
//     }
//     return result;
//
// }

function addCheck_name_base(){
    var result=true;
    var name = $("#foldManName").val().trim();
    $("#add_name_base").html("");
    if (name == null || name.length == 0){
        $("#add_name_base").html("!");
        result = false;
    }
    return result;
}

// function addCheck_contentStopDate_base(){
//     var result=true;
//     var contentStopDate = $("#fcontractEnd").val().trim();
//     $("#add_fcontractEnd_base").html("");
//     if (contentStopDate==""){
//         $("#add_fcontractEnd_base").html("!");
//         result = false;
//     }
//     return result;
// }

function addCheck_nursingLevel_base(){
    var result=true;
    var nursingLevel = $("#fnursingLevel").val();
    $("#add_fnursingLevel_base").html("");
    if (nursingLevel==""){
        $("#add_fnursingLevel_base").html("!");
        result = false;
    }
    return result;
}

function addCheck_buildingID_base(){
    var result=true;
    var buildingID = $("#fbuildingID").val();
    $("#add_build_base").html("");
    if(buildingID==""){
        $("#add_build_base").html("!");
        result = false;
    }
    return result;
}

function addCheck_roomID_base(){
    var result=true;
    var roomID = $("#froomID").val();
    $("#add_froomID_base").html("");
    if(roomID==""||roomID==null||(document.getElementById("froomID").options).length==0){
        $("#add_froomID_base").html("!");
        result = false;
    }
    return result;
}

// function addCheck_cardId_base(){
//     var result=true;
//     var cardId = $("#foldManIdCard").val().trim();
//     $("#add_cardId_base").html("");
//     var cardIdReg = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
//     if (cardId==""||!cardIdReg.test(cardId)){
//         $("#add_cardId_base").html("!");
//         result = false;
//     }
//     return result;
// }

function addCheck_birth_base(){
    var result=true;
    var birth = $("#foldManBirth").val().trim();
    $("#add_birth_base").html("");
    if (birth==""){
        $("#add_birth_base").html("!");
        result = false;
    }
    return result;
}

// function addCheck_fileUpload_base(){
//     var result=true;
//     var fileUpload1 = $("#file_1").val().trim();
//     $("#add_file_1_base").html("");
//     if (fileUpload1==""){
//         $("#add_file_1_base").html("请选择文件");
//         result = false;
//     }
//     return result;
// }

// function addCheck_oldManNative_base(){
//     var result=true;
//     var foldManNative = $("#foldManNative").val().trim();
//     $("#add_foldManNative_base").html("");
//     if (foldManNative==""){
//         $("#add_foldManNative_base").html("!");
//         result = false;
//     }
//     return result;
// }

//新增主要信息
function addBase(){
    // alert($("#nursingLevelId").val())
    if(add_check_Base()){
        if(check_reHosing($("#froomID").val(),$("#fbedID").val())){
            var foldManIsLunar="";
            // 判断农历复选框是否选中
            if($('#foldManIsLunar').is(':checked')) {
                foldManIsLunar=$("#foldManIsLunar").val();
            }

            $("#baseBtn").attr("disabled",true);

            var myRoomBed="";
            var select=document.getElementById("fbedID");
            var isEntire="";
            //新增时如果整租，先修改房间状态，在修改房间内所有床位的状态
            if(select.disabled){
                // myRoomBed=$("#roomBed").val();
                isEntire=$("#fisEntire").val();
                // updRoomState($("#froomID").val(),'11');
                //
                // $.ajax({
                //     url:contextPath+"/bed/updBedStateByRoom.do",
                //     type:"post",
                //     async:false,
                //     data:{
                //         fRoomID:$("#froomID").val(),
                //         fStatus:11
                //     },
                //     success:function(data) {
                //         console.log(data.message);
                //     }
                // });

            }else{
                myRoomBed=$("#fbedID").val();

                // $.ajax({
                //     url:contextPath+"/bed/updBedState.do",
                //     type:"post",
                //     async:false,
                //     data:{
                //         fID:$("#fbedID").val(),
                //         fStatus:11
                //     },
                //     success:function(data) {
                //         console.log(data.message);
                //     }
                // });
                //
                // $.ajax({
                //     url:contextPath+"/bed/get.do",
                //     type:"post",
                //     async:false,
                //     data:{
                //         fRoomID:$("#froomID").val(),
                //         fStatus:2
                //     },
                //     success:function(data) {
                //         // alert(data.total)
                //         if(data.total==0){
                //             updRoomState($("#froomID").val(),'11')
                //         }else{
                //             updRoomState($("#froomID").val(),'10')
                //         }
                //     }
                // });


            }


            //获取UTC(国际统一时间/国际协调)格式的从1970.1.1 0:00以来的毫秒数
            var newDate = new Date();
            var oldManNum="baseNum" + newDate.getTime();
            // 图片存储文件夹
            var curDateDir=getNowFormatDate();
            var urlPicture="";
            var imageName=$("#imageName").val();
            if(imageName!=""){
                urlPicture=curDateDir+"\\"+imageName+".jpg"
            }
            $.ajax({
                url:contextPath+"/hosing/addBase.do",
                type:"post",
                async:false,    //ajax调用ajax时让他有先后顺序
                data:{
                    foldManNum:oldManNum,
                    foldManName:$("#foldManName").val(),
                    fOldManIDnSex:$("#fOldManIDnSex").val(),
                    foldManStatusID:$("#foldManStatusID").val(),
                    fbuildingID:$("#fbuildingID").val(),
                    froomID:$("#froomID").val(),
                    fbedID:myRoomBed,

                    fisEntire:isEntire,
                    foccupation:$("#foccupation").val(),
                    foldManIdCard:$("#foldManIdCard").val(),
                    foldManBirth:$("#foldManBirth").val(),
                    foldManIsLunar:foldManIsLunar,
                    foldManPoliticsID:$("#foldManPoliticsID").val(),
                    foldManNationID:$("#foldManNationID").val(),
                    foldManMediaID:$("#foldManMediaID").val(),
                    fcontractNo:$("#fcontractNo").val(),
                    fcontractBegin:$("#fcontractBegin").val(),
                    fcontractEnd:$("#fcontractEnd").val(),
                    fMInsuranceType:$("#fMInsuranceType").val(),
                    foldManCardNo:$("#foldManCardNo").val(),
                    ftransactor:$("#ftransactor").val(),
                    fnursing:$("#fnursing").val(),
                    foldManBeliefID:$("#foldManBeliefID").val(),
                    foldManTypeID:$("#foldManTypeID").val(),
                    foldManMobile:$("#foldManMobile").val(),
                    fcheckinTime:$("#fcheckinTime").val(),
                    //定级按钮
                    // fnursingLevel:$("#nursingLevelId").val(),
                    fnursingLevel:$("#fnursingLevel").val(),
                    fAccidentInsurance:$("#fAccidentInsurance").val(),
                    fmealFee:$("#fmealFee").val(),
                    fPledge:$("#fPledge").val(),
                    foldManNative:$("#foldManNative").val(),
                    fInstruction:$("#fInstruction").val(),
                    fPhoto:urlPicture
                },
                success:function(data) {
                    console.log(data.message);
                    // setAlert(data.message,"操作成功");
                    // var myRoomBed="";
                    var select=document.getElementById("fbedID");
                    // var isEntire="";
                    //新增时如果整租，先修改房间状态，在修改房间内所有床位的状态
                    if(select.disabled){
                        // myRoomBed=$("#roomBed").val();
                        // isEntire=$("#fisEntire").val();
                        updRoomState($("#froomID").val(),'11');

                        $.ajax({
                            url:contextPath+"/bed/updBedStateByRoom.do",
                            type:"post",
                            async:false,
                            data:{
                                fRoomID:$("#froomID").val(),
                                fStatus:11
                            },
                            success:function(data) {
                                console.log(data.message);
                            }
                        });

                    }else{
                        // myRoomBed=$("#fbedID").val();

                        $.ajax({
                            url:contextPath+"/bed/updBedState.do",
                            type:"post",
                            async:false,
                            data:{
                                fID:$("#fbedID").val(),
                                fStatus:11
                            },
                            success:function(data) {
                                console.log(data.message);
                            }
                        });

                        $.ajax({
                            url:contextPath+"/bed/get.do",
                            type:"post",
                            async:false,
                            data:{
                                fRoomID:$("#froomID").val(),
                                fStatus:2
                            },
                            success:function(data) {
                                // alert(data.total)
                                if(data.total==0){
                                    updRoomState($("#froomID").val(),'11')
                                }else{
                                    updRoomState($("#froomID").val(),'10')
                                }
                            }
                        });


                    }
                    $('#tb_oldManHosing').bootstrapTable('refresh', {url: 'query.do'});
                    alert("老人基本信息保存成功，现在可以添加老人其它信息")
                }
            });
        }else{
            return 0;
        }
    }else{
        return 0;
    }
    closeModalBase()
}

function updRoomState(myUpdRoomBed,state){
    $.ajax({
        url:contextPath+"/room/updRoomState.do",
        type:"post",
        async:false,
        data:{
            fID:myUpdRoomBed,
            fStatus:state
        },
        success:function(data) {
            console.log(data.message);
        }
    });
}

function btnBaseOpen(){
    getDcList(),
    getBuilding(null),
    $("#fbedID").html(""),
    $("#froomID").html("")
}

function closeModalBase(flag) {
    // $(":checkbox").removeAttr("checked");
    // $("input[type='radio']").removeAttr('checked');
    $("input[type='checkbox']").removeAttr('checked');

    $('#img_1').attr('src',"/ems/img/a1.jpg");
    $("#imageName").val("");

    var select=document.getElementById("fbedID");
    select.disabled = false;
    $("#fbedID").removeAttr('style');

    $("#baseBtn").attr("disabled",false);
    // $("#foldManNum").val("");
    $("#foldManName").val("");
    // $("#fOldManIDnSex").val("");
    // $("#foldManStatusID").val("");
    $("#fbuildingID").val("");
    $("#froomID").val("");
    $("#fbedID").val("");
    $("#fbedID").html("");
    $("#froomID").html("");
    // $("#updfroomID").html(room);


    $("#fisEntire").val("");
    // $("#foccupation").val("");
    $("#foldManIdCard").val("");
    $("#foldManBirth").val("");
    // $("#foldManIsLunar").val("");
    // $("#foldManPoliticsID").val("");
    // $("#foldManNationID").val("");
    // $("#foldManMediaID").val("");
    // $("#fcontractNo").val("");
    // $("#fcontractBegin").val("");
    $("#fcontractEnd").val("");
    // $("#fMInsuranceType").val("");
    $("#foldManCardNo").val("");
    // $("#ftransactor").val("");
    $("#fnursing").val("");
    // $("#foldManBeliefID").val("");
    // $("#foldManTypeID").val("");
    $("#foldManMobile").val("");
    // $("#fcheckinTime").val("");
    $("#fnursingLevel").val("");
    $("#nursingLevelId").val("");
    $("#fAccidentInsurance").val("");
    $("#fmealFee").val("");
    $("#fPledge").val("");
    $("#foldManNative").val("");
    $("#fInstruction").val("");
    if(flag==1){
        $("#addModal1").modal("hide");
        $("#updBaseModal").modal("hide");
    }
    // $("#updBaseModal").modal("hide");
    $("#updateName").val("");
    $("#updateValue").val("");
}

function gotoUpdBase(){
    // 先清空选择整租按钮，防止之前修改失败，整租打钩没去掉
    var bigObj = document.getElementById("updfisEntire");
    var Obj = document.getElementById("updfoldManIsLunar");
    bigObj.checked = false;
    Obj.checked = false;
    var carrentItem = $("#tb_oldManHosing").bootstrapTable('getSelections');
    if(carrentItem[0]){
        // 判断农历复选框是否选中
        var oldManIsLunar=carrentItem[0].foldManIsLunar;
        if(oldManIsLunar=="农历"){
            Obj.checked=true;
        }else{
            Obj.checked=false;
        }

        $('#img_2').attr('src',"/ems/picture/"+carrentItem[0].fPhoto);
        var isEntire=carrentItem[0].fisEntire;
        var select=document.getElementById("updfbedID");
        if(isEntire=="9"){
            var bigObj = document.getElementById("updfisEntire");
            bigObj.checked = true;
            // $("input[type='checkbox'][name='updfisEntire']").checkbox;
            $("#updfbedID").val("");
            select.disabled = true;
            select.style="background-color: gray";
        }else{
            getBed(carrentItem[0].froomID,carrentItem[0].fbedID);
            select.disabled = false;
            select.style=" ";
        }

        $("#updfid").val(carrentItem[0].fID);
        $("#updfoldManNum").val(carrentItem[0].foldManNum);
        $("#updfoldManName").val(carrentItem[0].foldManName);
        $("#updfoldManIdCard").val(carrentItem[0].foldManIdCard);
        $("#updfoldManBirth").val(carrentItem[0].foldManBirth);
        $("#updfcontractNo").val(carrentItem[0].fcontractNo);
        $("#updfcontractBegin").val(carrentItem[0].fcontractBegin);
        $("#updfcontractEnd").val(carrentItem[0].fcontractEnd);
        $("#updfoldManCardNo").val(carrentItem[0].foldManCardNo);
        $("#updftransactor").val(carrentItem[0].ftransactor);
        $("#updfnursing").val(carrentItem[0].fnursing);
        $("#updfoldManMobile").val(carrentItem[0].foldManMobile);
        $("#updfcheckinTime").val(carrentItem[0].fcheckinTime);

        $("#updfoldManNative").val(carrentItem[0].foldManNative);
        $("#updfInstruction").val(carrentItem[0].fInstruction);

        getBuilding(carrentItem[0].fbuildingID);
        getRoom(carrentItem[0].fbuildingID,carrentItem[0].froomID);

        $.ajax({
            url: contextPath + "/sys/get.do",
            type: "post",
            success: function (data) {
                var base_len = data.total;
                var base_row = data.rows;

                var fOldManIDnSex=carrentItem[0].fOldManIDnSex;
                var fOldManIDnSexStr = "<option value='" + fOldManIDnSex + "'>" + fOldManIDnSex + "</option>";
                for (var i = 0; i < base_len; i++) {
                    var fOldManIDnSexName = base_row[i].name;
                    if (fOldManIDnSexName == "性别") {
                        if(base_row[i].value != fOldManIDnSex){
                            fOldManIDnSexStr += "<option value='" + base_row[i].value + "'>" + base_row[i].value + "</option>";
                        }
                    }
                }
                $("#updfOldManIDnSex").html(fOldManIDnSexStr);

                var foldManStatusID=carrentItem[0].foldManStatusID;
                var foldManStatusIDStr ="";
                for (var i = 0; i < base_len; i++) {
                    var foldManStatusIDStrName = base_row[i].name;
                    if (foldManStatusIDStrName == "老人状态") {
                        if(foldManStatusID==base_row[i].id){
                            foldManStatusIDStr += "<option selected='selected' value='" + base_row[i].id + "'>" + base_row[i].value + "</option>";
                        }else{
                            foldManStatusIDStr += "<option value='" + base_row[i].id + "'>" + base_row[i].value + "</option>";
                        }
                    }
                }
                // if(foldManStatusID=='10'){
                //     foldManStatusIDStr+="<option value='10'>请假</option>";
                //     foldManStatusIDStr+="<option value='3'>在院</option>";
                //     foldManStatusIDStr+="<option value='2'>退住</option>";
                // }else if(foldManStatusID=='2'){
                //     foldManStatusIDStr+="<option value='2'>退住</option>";
                //     foldManStatusIDStr+="<option value='10'>请假</option>";
                //     foldManStatusIDStr+="<option value='3'>在院</option>";
                // }else if(foldManStatusID=='3'){
                //     foldManStatusIDStr+="<option value='3'>在院</option>";
                //     foldManStatusIDStr+="<option value='2'>退住</option>";
                //     foldManStatusIDStr+="<option value='10'>请假</option>";
                // }
                $("#updfoldManStatusID").html(foldManStatusIDStr);

                var foccupation=carrentItem[0].foccupation;
                var foccupationStr = "<option value='" + foccupation + "'>" + foccupation + "</option>";
                for (var i = 0; i < base_len; i++) {
                    var foccupationName = base_row[i].name;
                    if (foccupationName == "职业") {
                        if(foccupation!=base_row[i].value){
                            foccupationStr += "<option value='" + base_row[i].value + "'>" + base_row[i].value + "</option>";
                        }
                    }
                }
                $("#updfoccupation").html(foccupationStr);

                var foldManPoliticsID=carrentItem[0].foldManPoliticsID;
                var foldManPoliticsIDStr = "<option value='" + foldManPoliticsID + "'>" + foldManPoliticsID + "</option>";
                for (var i = 0; i < base_len; i++) {
                    var foldManPoliticsIDName = base_row[i].name;
                    if (foldManPoliticsIDName == "政治面貌") {
                        if(foldManPoliticsID!=base_row[i].value){
                            foldManPoliticsIDStr += "<option value='" + base_row[i].value + "'>" + base_row[i].value + "</option>";
                        }
                    }
                }
                $("#updfoldManPoliticsID").html(foldManPoliticsIDStr);

                var foldManNationID=carrentItem[0].foldManNationID;
                var foldManNationIDStr = "<option value='" + foldManNationID + "'>" + foldManNationID + "</option>";
                for (var i = 0; i < base_len; i++) {
                    var foldManNationIDName = base_row[i].name;
                    if (foldManNationIDName == "民族") {
                        if(foldManNationID!=base_row[i].value){
                            foldManNationIDStr += "<option value='" + base_row[i].value + "'>" + base_row[i].value + "</option>";
                        }
                    }
                }
                $("#updfoldManNationID").html(foldManNationIDStr);

                var foldManMediaID=carrentItem[0].foldManMediaID;
                var foldManMediaIDStr = "<option value='" + foldManMediaID + "'>" + foldManMediaID + "</option>";
                for (var i = 0; i < base_len; i++) {
                    var foldManMediaIDName = base_row[i].name;
                    if (foldManMediaIDName == "媒体渠道") {
                        if(foldManMediaID!=base_row[i].value){
                            foldManMediaIDStr += "<option value='" + base_row[i].value + "'>" + base_row[i].value + "</option>";
                        }
                    }
                }
                $("#updfoldManMediaID").html(foldManMediaIDStr);

                var foldManBeliefID=carrentItem[0].foldManBeliefID;
                var foldManBeliefIDStr = "<option value='" + foldManBeliefID + "'>" + foldManBeliefID + "</option>";
                for (var i = 0; i < base_len; i++) {
                    var foldManBeliefIDName = base_row[i].name;
                    if (foldManBeliefIDName == "信仰") {
                        if(foldManBeliefID!=base_row[i].value){
                            foldManBeliefIDStr += "<option value='" + base_row[i].value + "'>" + base_row[i].value + "</option>";
                        }
                    }
                }
                $("#updfoldManBeliefID").html(foldManBeliefIDStr);

                var foldManTypeID=carrentItem[0].foldManTypeID;
                var foldManTypeIDStr="";
                for (var i = 0; i < base_len; i++) {
                    var foldManTypeIDName = base_row[i].name;
                    if (foldManTypeIDName == "入住类型") {
                        if(foldManTypeID==base_row[i].value){
                            foldManTypeIDStr += "<option selected='selected' value='" + base_row[i].id + "'>" + base_row[i].value + "</option>";
                        }else{
                            foldManTypeIDStr += "<option value='" + base_row[i].id + "'>" + base_row[i].value + "</option>";
                        }
                    }
                }
                $("#updfoldManTypeID").html(foldManTypeIDStr);

                var fMInsuranceType=carrentItem[0].fMInsuranceType;
                var fMInsuranceTypeStr = "<option value='" + fMInsuranceType + "'>" + fMInsuranceType + "</option>";
                for (var i = 0; i < base_len; i++) {
                    var fMInsuranceTypeName = base_row[i].name;
                    if (fMInsuranceTypeName == "医保类型") {
                        if(fMInsuranceType==base_row[i].value){
                            fMInsuranceTypeStr += "<option value='" + base_row[i].value + "'>" + base_row[i].value + "</option>";
                        }
                    }
                }
                $("#updfMInsuranceType").html(fMInsuranceTypeStr);

                var updfnursingLevel="";
                for(var i = 0; i < base_len; i++){
                    var nursingLevel = base_row[i].name;
                    if (nursingLevel == "项目等级") {
                        if(base_row[i].id==carrentItem[0].fnursingLevel){
                            updfnursingLevel+="<option selected='selected' value='"+base_row[i].id+"'>"+base_row[i].value+"</option>";
                            // $("#updfnursingLevel").val(base_row[i].value);
                            // $("#updNursingLevelId").val(carrentItem[0].fnursingLevel);
                        }else{
                            updfnursingLevel+="<option value='"+base_row[i].id+"'>"+base_row[i].value+"</option>";
                        }
                    }
                }
                $("#updfnursingLevel").html(updfnursingLevel);

            }
        });
        $("#updBase_btn").click();
    }else{
        setAlert("error","请先选择一条数据");
    }
}

// 修改时加验证
function upd_check_Base() {
    var result=true;

    if(!updCheck_name_base()){
        result=false;
    }

    // if(!updCheck_contentStopDate_base()){
    //     result=false;
    // }

    // if(!updCheck_nursingLevel_base()){
    //     result=false;
    // }

    if(!updCheck_buildingID_base()){
        result=false;
    }

    // if(!updCheck_fileUpload_base()){
    //     result=false;
    // }

    // if(!updCheck_oldManNative_base()){
    //     result=false;
    // }

    // if(!updCheckMobilePhone()){
    //     result=false;
    // }


    // 如果选择房间后既没选择床位也没选择整租，不能提交
    var optionBed=document.getElementById("updfbedID").options;
    var optionRoom=document.getElementById("updfroomID").options;

    if(($("#updfbedID").val()=="")&&(document.getElementById("updfisEntire").checked!=true)){
        alert("请选择床位或者整租房间");
        result = false;
    }

    if((optionBed.length==0)&&(document.getElementById("updfisEntire").checked!=true)){
        alert("请选择床位或者整租房间");
        result = false;
    }

    return result;
}

// function updCheckMobilePhone(){
//     var result=true;
//     var fMobileTel = $("#updfoldManMobile").val().trim();
//     var reg=new RegExp(/^1[34578]\d{9}$/);
//     $("#upd_foldManMobile_base").html("");
//     if (fMobileTel==""||!reg.test(fMobileTel)){
//         $("#upd_foldManMobile_base").html("!");
//         result = false;
//     }
//     return result;
//
// }

function updCheck_name_base(){
    var result=true;
    var name = $("#updfoldManName").val().trim();
    $("#add_name_base").html("");
    if (name == null || name.length == 0){
        $("#add_name_base").html("!");
        result = false;
    }
    return result;
}

// function updCheck_contentStopDate_base(){
//     var result=true;
//     var contentStopDate = $("#updfcontractEnd").val().trim();
//     $("#upd_fcontractEnd_base").html("");
//     if (contentStopDate==""){
//         $("#upd_fcontractEnd_base").html("!");
//         result = false;
//     }
//     return result;
// }

// function updCheck_nursingLevel_base(){
//     var result=true;
//     var nursingLevel = $("#updfnursingLevel").val().trim();
//     $("#upd_fnursingLevel_base").html("");
//     if (nursingLevel==""){
//         $("#upd_fnursingLevel_base").html("!");
//         result = false;
//     }
//     return result;
// }

function updCheck_buildingID_base(){
    var result=true;
    var buildingID = $("#updfbuildingID").val().trim();
    $("#upd_build_base").html("");
    if(buildingID==""){
        $("#upd_build_base").html("!");
        result = false;
    }
    return result;
}

function updCheck_roomID_base(){
    var result=true;
    var roomID = $("#updfroomID").val();
    $("#upd_froomID_base").html("");
    if(roomID==""||roomID==null||(document.getElementById("updfroomID").options).length==0){
        $("#upd_froomID_base").html("!");
        result = false;
    }
    return result;
}

// function updCheck_cardId_base(){
//     var result=true;
//     var cardId = $("#updfoldManIdCard").val().trim();
//     $("#upd_cardId_base").html("");
//     var cardIdReg = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
//     if (cardId==""||!cardIdReg.test(cardId)){
//         $("#upd_cardId_base").html("!");
//         result = false;
//     }
//     return result;
// }

function updCheck_birth_base(){
    var result=true;
    var birth = $("#updfoldManBirth").val().trim();
    $("#upd_birth_base").html("");
    if (birth==""){
        $("#upd_birth_base").html("!");
        result = false;
    }
    return result;
}

// function updCheck_fileUpload_base(){
//     var result=true;
//     var fileUpload1 = $("#file_1").val().trim();
//     $("#add_file_1_base").html("");
//     if (fileUpload1==""){
//         $("#add_file_1_base").html("请选择文件");
//         result = false;
//     }
//     return result;
// }

// function updCheck_oldManNative_base(){
//     var result=true;
//     var foldManNative = $("#updfoldManNative").val().trim();
//     $("#upd_foldManNative_base").html("");
//     if (foldManNative==""){
//         $("#upd_foldManNative_base").html("!");
//         result = false;
//     }
//     return result;
// }

function updBedStateByRoom(roomID,status){
    $.ajax({
        url:contextPath+"/bed/updBedStateByRoom.do",
        type:"post",
        async:false,
        data:{
            fRoomID:roomID,
            fStatus:status
        },
        success:function(data) {
            console.log(data.message);
        }
    });
}

function updBedState(bedId,state){
    $.ajax({
        url:contextPath+"/bed/updBedState.do",
        type:"post",
        async:false,
        data:{
            fID:bedId,
            fStatus:state
        },
        success:function(data) {
            console.log(data.message);
        }
    });
}

function updBase(){
    if(upd_check_Base()){
        // if(check_reHosing($("#updfroomID").val(),$("#updfbedID").val())){
            var updfoldManIsLunar="";
            // 判断农历复选框是否选中
            if($('#updfoldManIsLunar').is(':checked')) {
                updfoldManIsLunar = $("#updfoldManIsLunar").val();
            }

            var myUpdRoomBed="";
            var select=document.getElementById("updfbedID");
            var isEntire="";
            //先判断是否是整租，如果本来是整租就先释放房间，在释放房间里所有床位，
            // 不是整租先释放床位，再看房间内所有床位的状态，全是空闲，修改房间状态为空闲，否则改成未满
            // var carrentItem = $("#tb_oldManHosing").bootstrapTable('getSelections');
            // if(carrentItem[0].fisEntire=='9'){
            //     updRoomState(carrentItem[0].froomID,'01');
            //
            //     updBedStateByRoom(carrentItem[0].froomID,'2')
            //
            // }else{
            //     updBedState(carrentItem[0].fbedID,'2')
            //
            //     if(!getAllBedStateByRoom(carrentItem[0].froomID)){
            //         updRoomState(carrentItem[0].froomID,'01')
            //     }else{
            //         updRoomState(carrentItem[0].froomID,'10')
            //     }
            //
            // }

            //如果修改之后是整租，那么先修改房间状态为已满（11），在修改房间内所有的床位状态为使用（11）
            // 如果不是整租，先修改床位状态为使用，在查询房间内的所有床位状态，如果没有空闲（2），则修改房间状态为已满（11）
            if(select.disabled){
                // var bed_len;
                // $.ajax({
                //     url:contextPath+"/bed/get.do",
                //     type:"post",
                //     async:false,
                //     data:{
                //         fRoomID:$("#updfroomID").val(),
                //     },
                //     success:function(data) {
                //         bed_len=data.total;
                //     }
                // });
                // for(var i=1;i<=bed_len;i++){
                //     if(i==1){
                //         myUpdRoomBed+=""+i+"";
                //     }
                //     myUpdRoomBed+=","+i+"";
                // }

                isEntire=$("#updfisEntire").val();
                // updRoomState($("#updfroomID").val(),'11');
                //
                // updBedStateByRoom($("#updfroomID").val(),'11')

            }else{
                myUpdRoomBed=$("#updfbedID").val();

                // updBedState($("#updfbedID").val(),'11')
                //
                // $.ajax({
                //     url:contextPath+"/bed/get.do",
                //     type:"post",
                //     async:false,
                //     data:{
                //         fRoomID:$("#updfroomID").val(),
                //         fStatus:2
                //     },
                //     success:function(data) {
                //         // alert(data.total)
                //         if(data.total==0){
                //             updRoomState($("#updfroomID").val(),'11')
                //         }
                //     }
                // });
            }

            var carrentItem = $("#tb_oldManHosing").bootstrapTable('getSelections');
            // 图片存储文件夹
            var curDateDir=getNowFormatDate();

            var imgUrl=carrentItem[0].fPhoto;
            var imageName=$("#imageName").val();
            var oldImg=curDateDir+"\\"+imageName+".jpg";
            if(imageName!=""&&imgUrl!=oldImg){
                imgUrl=oldImg;
            }

            $.ajax({
                url:contextPath+"/hosing/updBase.do",
                type:"post",
                async:false,
                data:{
                    fID:$("#updfid").val(),
                    foldManNum:$("#updfoldManNum").val(),
                    foldManName:$("#updfoldManName").val(),
                    fOldManIDnSex:$("#updfOldManIDnSex").val(),
                    foldManStatusID:$("#updfoldManStatusID").val(),
                    fbuildingID:$("#updfbuildingID").val(),
                    froomID:$("#updfroomID").val(),
                    fbedID:myUpdRoomBed,

                    fisEntire:isEntire,
                    foccupation:$("#updfoccupation").val(),
                    foldManIdCard:$("#updfoldManIdCard").val(),
                    foldManBirth:$("#updfoldManBirth").val(),

                    foldManIsLunar:updfoldManIsLunar,

                    foldManPoliticsID:$("#updfoldManPoliticsID").val(),
                    foldManNationID:$("#updfoldManNationID").val(),
                    foldManMediaID:$("#updfoldManMediaID").val(),
                    fcontractNo:$("#updfcontractNo").val(),
                    fcontractBegin:$("#updfcontractBegin").val(),
                    fcontractEnd:$("#updfcontractEnd").val(),
                    fMInsuranceType:$("#updfMInsuranceType").val(),
                    foldManCardNo:$("#updfoldManCardNo").val(),
                    ftransactor:$("#updftransactor").val(),
                    fnursing:$("#updfnursing").val(),
                    foldManBeliefID:$("#updfoldManBeliefID").val(),
                    foldManTypeID:$("#updfoldManTypeID").val(),
                    foldManMobile:$("#updfoldManMobile").val(),
                    fcheckinTime:$("#updfcheckinTime").val(),
                    // fnursingLevel:$("#updNursingLevelId").val(),
                    fnursingLevel:$("#updfnursingLevel").val(),
                    fAccidentInsurance:$("#updfAccidentInsurance").val(),
                    fmealFee:$("#updfmealFee").val(),
                    fPledge:$("#updfPledge").val(),
                    foldManNative:$("#updfoldManNative").val(),
                    fInstruction:$("#updfInstruction").val(),
                    fPhoto:imgUrl
                },
                success:function(data){
                    if(data.success){
                        setAlert("success",data.msg);
                    }else{
                        setAlert("error",data.msg);
                    }
                    // var myUpdRoomBed="";
                    var select=document.getElementById("updfbedID");
                    // var isEntire="";
                    //先判断是否是整租，如果本来是整租就先释放房间，在释放房间里所有床位，
                    // 不是整租先释放床位，再看房间内所有床位的状态，全是空闲，修改房间状态为空闲，否则改成未满
                    var carrentItem = $("#tb_oldManHosing").bootstrapTable('getSelections');
                    if(carrentItem[0].fisEntire=='9'){
                        updRoomState(carrentItem[0].froomID,'01');

                        updBedStateByRoom(carrentItem[0].froomID,'2')

                    }else{
                        updBedState(carrentItem[0].fbedID,'2')

                        if(!getAllBedStateByRoom(carrentItem[0].froomID)){
                            updRoomState(carrentItem[0].froomID,'01')
                        }else{
                            updRoomState(carrentItem[0].froomID,'10')
                        }

                    }

                    //如果修改之后是整租，那么先修改房间状态为已满（11），在修改房间内所有的床位状态为使用（11）
                    // 如果不是整租，先修改床位状态为使用，在查询房间内的所有床位状态，如果没有空闲（2），则修改房间状态为已满（11）
                    if(select.disabled){
                        // var bed_len;
                        // $.ajax({
                        //     url:contextPath+"/bed/get.do",
                        //     type:"post",
                        //     async:false,
                        //     data:{
                        //         fRoomID:$("#updfroomID").val(),
                        //     },
                        //     success:function(data) {
                        //         bed_len=data.total;
                        //     }
                        // });
                        // for(var i=1;i<=bed_len;i++){
                        //     if(i==1){
                        //         myUpdRoomBed+=""+i+"";
                        //     }
                        //     myUpdRoomBed+=","+i+"";
                        // }

                        // isEntire=$("#updfisEntire").val();
                        updRoomState($("#updfroomID").val(),'11');

                        updBedStateByRoom($("#updfroomID").val(),'11')

                    }else{
                        // myUpdRoomBed=$("#updfbedID").val();

                        updBedState($("#updfbedID").val(),'11')

                        $.ajax({
                            url:contextPath+"/bed/get.do",
                            type:"post",
                            async:false,
                            data:{
                                fRoomID:$("#updfroomID").val(),
                                fStatus:2
                            },
                            success:function(data) {
                                // alert(data.total)
                                if(data.total==0){
                                    updRoomState($("#updfroomID").val(),'11')
                                }
                            }
                        });
                    }

                    closeModalBase(1);
                    $('#tb_oldManHosing').bootstrapTable('refresh', {url: 'query.do'});
                }
            })
        // }else{
        //     return 0;
        // }
    }else{
        return 0;
    }
}