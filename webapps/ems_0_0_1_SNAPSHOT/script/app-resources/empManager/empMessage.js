/**
 * 张鑫
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
        $('#tb_empMessage').bootstrapTable({
            url: 'queryTranscoding.do',   //请求后台的URL（*）
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
                field: 'fId',
                title: '编号'
            }, {
                field: 'fStaffName',
                title: '姓名'
            }, {
                field: 'fSex',
                title: '性别'
            }, {
                field: 'fEntryDate',
                title: '入职日期'
            }, {
                field: 'fDepartmentName',
                title: '部门'
            }, {
                field: 'fPost',
                title: '职务'
            }, {
                field: 'fBuildingName',
                title: '所属大厦'
            }, {
                field: 'fMobileTel',
                title: '电话'
            }, {
                field: 'fTitle',
                title: '职称'
            }, {
                field: 'fSalryType',
                title: '工资'
            }, {
                field: 'fStaffStatus',
                title: '员工状态'
            }, {
                field: 'fState',
                title: '状态',
                formatter:function(value) {
                    if (value == 1) {
                        return '<span style="color:#80b2ff">开启</span>'
                    } else if (value == 0) {
                        return '<span style="color:#FF0000">禁用</span>'
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
            name: $("#searchName").val(),
            fStaffStatus: $("#searchStatus option:selected").val(),
            fDepartmentID:$("#searchDepartment option:selected").val()
        };
        return temp;
    };
    return oTableInit;
};
function gotoAdd() {
        getDataList(),
        getDepartment(),
        getFBuildingID(),
        getOldHouse()
}

//验证
function add_check_Message() {
    var name = $("#txtName").val().trim();
    var result=true;
    if (name == null || name.length == 0){
        $("#add_textName_message").html("!");
        result = false;
    }
    var inData = $("#inData").val().trim();
    if (inData==""){
        $("#add_inData_message").html("!");
        result = false;
    }
    var cardId = $("#cardId").val().trim();
    var cardIdReg = /^(\d{16}|\d{19})$/;
    if (cardId==""||!cardIdReg.test(cardId)){
        $("#add_cardId_message").html("!");
        result = false;
    }

    var fMobileTel = $("#FMobileTel").val().trim();
    var reg=new RegExp(/^1[34578]\d{9}$/);
    if (fMobileTel==""||!reg.test(fMobileTel)){
        $("#add_FMobileTel_message").html("!");
        result = false;
    }

    var birth = $("#birth").val().trim();
    if (birth==""){
        $("#add_birth_message").html("!");
        result = false;
    }

    var sex = $("#addSex option:selected").val().trim();
    if (sex==""){
        $("#add_addSex_message").html("!");
        result = false;
    }
    var stature = $("#addStature option:selected").val().trim();
    if (stature==""){
        $("#add_addStature_message").html("!");
        result = false;
    }
    var department = $("#addDepartment option:selected").val().trim();
    if (department==""){
        $("#add_addDepartment_message").html("!");
        result = false;
    }
    var buildingID = $("#FBuildingID option:selected").val();
    if (buildingID==""|| buildingID.length==0){
        $("#add_FBuildingID_message").html("!");
        result = false;
    }
    var FNursinghomeID = $("#FNursinghomeID option:selected").val();
    if (FNursinghomeID==""|| FNursinghomeID.length==0){
        $("#add_FNursinghomeID_message").html("!");
        result = false;
    }
    return result;
}
function add_textName() {
    var name = $("#txtName").val().trim();
    $("#add_textName_message").html("");
    if (name == null || name.length == 0){
        $("#add_textName_message").html("!");
    }
}
function add_idCard() {
    var name = $("#idCard").val().trim();
    var reg=new RegExp(/^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/);
    $("#add_idCard_message").html("");
    if (name == null || !reg.test(name)){
        $("#add_idCard_message").html("!");
    }
}
function add_inData() {
    var name = $("#inData").val().trim();
    $("#add_inData_message").html("");
    if (name == null || name.length == 0){
        $("#add_inData_message").html("!");
    }
}
function add_cardId() {
    var name = $("#cardId").val().trim();
    $("#add_cardId_message").html("");
    var cardIdReg = /^(\d{16}|\d{19})$/;
    if (name == null ||! cardIdReg.test(name)){
        $("#add_cardId_message").html("!");
    }
}
function add_FMobileTel() {
    var name = $("#FMobileTel").val().trim();
    $("#add_FMobileTel_message").html("");
    var reg=new RegExp(/^1[34578]\d{9}$/);
    if (name == null || !reg.test(name)){
        $("#add_FMobileTel_message").html("!");
    }
}
function add_birth() {
    var name = $("#birth").val().trim();
    $("#add_birth_message").html("");
    if (name == null || name.length == 0){
        $("#add_birth_message").html("!");
    }
}
function add_addSex() {
    var name = $("#addSex").val().trim();
    $("#add_addSex_message").html("");
    if (name == null || name.length == 0){
        $("#add_addSex_message").html("!");
    }
}
function add_addStature() {
    var name = $("#addStature").val().trim();
    $("#add_addStature_message").html("");
    if (name == null || name.length == 0){
        $("#add_addStature_message").html("!");
    }
}
function add_addDepartment() {
    var name = $("#addDepartment").val().trim();
    $("#add_addDepartment_message").html("");
    if (name == null || name.length == 0){
        $("#add_addDepartment_message").html("!");
    }
}
function add_FBuildingID() {
    $("#add_FBuildingID_message").html("");
    var buildingID = $("#FBuildingID option:selected").val();
    if (buildingID==""){
        $("#add_FBuildingID_message").html("!");
    }
}
function add_FNursinghomeID() {
    $("#add_FNursinghomeID_message").html("");
    var buildingID = $("#FNursinghomeID option:selected").val();
    if (buildingID==""){
        $("#add_FNursinghomeID_message").html("!");
    }
}

function update_check_Message() {
    var name = $("#updatetxtName").val().trim();
    var result=true;
    if (name == null || name.length == 0){
        $("#update_textName_message").html("!");
        result = false;
    }
    var inData = $("#updateEntryDate").val().trim();
    if (inData==""){
        $("#update_inData_message").html("!");
        result = false;
    }
    var cardId = $("#updateBankCard").val().trim();
    var cardIdReg = /^(\d{16}|\d{19})$/;
    if (cardId==""||!cardIdReg.test(cardId)){
        $("#update_cardId_message").html("!");
        result = false;
    }
    var fMobileTel = $("#updateMobileTel").val().trim();
    var reg=new RegExp(/^1[34578]\d{9}$/);
    if (fMobileTel==""||!reg.test(fMobileTel)){
        $("#update_FMobileTel_message").html("!");
        result = false;
    }
    var birth = $("#updateBirth").val().trim();
    if (birth==""){
        $("#update_birth_message").html("!");
        result = false;
    }

    var sex = $("#updateSex option:selected").val().trim();
    if (sex==""){
        $("#update_addSex_message").html("!");
        result = false;
    }
    var stature = $("#updateStature option:selected").val().trim();
    if (stature==""){
        $("#update_addStature_message").html("!");
        result = false;
    }
    var department = $("#updateDepartment option:selected").val().trim();
    if (department==""){
        $("#update_addDepartment_message").html("!");
        result = false;
    }
    var buildingID = $("#updateBuildingID option:selected").val();
    if (buildingID==""|| buildingID.length==0){
        $("#update_FBuildingID_message").html("!");
        result = false;
    }
    var FNursinghomeID = $("#updateFNursinghomeID option:selected").val();
    if (FNursinghomeID==""|| FNursinghomeID.length==0){
        $("#update_FNursinghomeID_message").html("!");
        result = false;
    }
    return result;
}
function update_textName() {
    var name = $("#updatetxtName").val().trim();
    $("#update_textName_message").html("");
    if (name == null || name.length == 0){
        $("#update_textName_message").html("!");
    }
}
function update_idCard() {
    var name = $("#updateIdentityCardID").val().trim();
    var reg=new RegExp(/^(\d{15}$|^\d{18}$|^\d{17}(\d|X|x))$/);
    $("#update_idCard_message").html("");
    if (name == null || !reg.test(name)){
        $("#update_idCard_message").html("!");
    }
}
function update_inData() {
    var name = $("#updateEntryDate").val().trim();
    $("#update_inData_message").html("");
    if (name == null || name.length == 0){
        $("#update_inData_message").html("!");
    }
}
function update_cardId() {
    var name = $("#updateBankCard").val().trim();
    $("#update_cardId_message").html("");
    var cardIdReg = /^(\d{16}|\d{19})$/;
    if (name == null ||! cardIdReg.test(name)){
        $("#update_cardId_message").html("!");
    }
}
function update_FMobileTel() {
    var name = $("#updateMobileTel").val().trim();
    $("#update_FMobileTel_message").html("");
    var reg=new RegExp(/^1[34578]\d{9}$/);
    if (name == null || !reg.test(name)){
        $("#update_FMobileTel_message").html("!");
    }
}
function update_birth() {
    var name = $("#updateBirth").val().trim();
    $("#update_birth_message").html("");
    if (name == null || name.length == 0){
        $("#update_birth_message").html("!");
    }
}
function update_addSex() {
    var name = $("#updateSex").val().trim();
    $("#update_addSex_message").html("");
    if (name == null || name.length == 0){
        $("#update_addSex_message").html("!");
    }
}
function update_addStature() {
    var name = $("#updateStature").val().trim();
    $("#update_addStature_message").html("");
    if (name == null || name.length == 0){
        $("#update_addStature_message").html("!");
    }
}
function update_addDepartment() {
    var name = $("#updateDepartment").val().trim();
    $("#update_addDepartment_message").html("");
    if (name == null || name.length == 0){
        $("#update_addDepartment_message").html("!");
    }
}
function update_FBuildingID() {
    $("#update_FBuildingID_message").html("");
    var buildingID = $("#updateFBuildingID option:selected").val();
    if (buildingID==""){
        $("#update_FBuildingID_message").html("!");
    }
}
function update_FNursinghomeID() {
    $("#update_FNursinghomeID_message").html("");
    var buildingID = $("#updateFNursinghomeID option:selected").val();
    if (buildingID==""){
        $("#update_FNursinghomeID_message").html("!");
    }
}
//得到大厦名称
function getFBuildingID(){
    $.ajax({
        url:contextPath+"/building/query.do",
        type:"post",
        data:{
            page:0,
            pageSize:10000000
        },
        success:function(data) {
            $("#FBuildingID").html("");
            var $add = $("#FBuildingID");
            $add.append("<option value=''>    </option>");
            for (var i = 0; i < data.total; i++) {
                    if (data.rows[i].fStatus==11){
                    $add.append("<option value='" + data.rows[i].fID + "'>" + data.rows[i].fBuildingName + "</option>");
            }
            }
        }
    });
}

//得到数据字典的数据
function getDataList() {
    $.ajax({
        url:contextPath+"/sys/get.do",
        type:"post",
        data:{
            page:1,
            pageSize:1000000
        },
        success:function(data) {

            $("#addForeign").html("");
            var $add = $("#addForeign");
            $add.append("<option value=''>    </option>");
            for (var i = 0; i < data.total; i++) {
                if (data.rows[i].name == "外语水平") {
                    $add.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                }
            }


            $("#addComputer").html("");
            var $add = $("#addComputer");
            $add.append("<option value=''>    </option>");
            for (var i = 0; i < data.total; i++) {
                if (data.rows[i].name == "电脑水平") {
                    $add.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                }
            }

            $("#addEducation").html("");
            var $add = $("#addEducation");
            $add.append("<option value=''>    </option>");
            for (var i = 0; i < data.total; i++) {
                if (data.rows[i].name == "学历") {
                    $add.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                }
            }

            $("#addMarry").html("");
            var $add = $("#addMarry");
            $add.append("<option value=''>    </option>");
            for (var i = 0; i < data.total; i++) {
                if (data.rows[i].name == "婚姻状况") {
                    $add.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                }
            }

            $("#addSal").html("");
            var $add = $("#addSal");
            $add.append("<option value=''>选择职称</option>");
            for (var i = 0; i < data.total; i++) {
                if (data.rows[i].name == "薪资类别") {
                    $add.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                }
            }

            $("#addJobTitle").html("");
            var $add = $("#addJobTitle");
            $add.append("<option value=''>选择职称</option>");
            for (var i = 0; i < data.total; i++) {
                if (data.rows[i].name == "职称") {
                    $add.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                }
            }

            $("#addDuty").html("");
            var $add = $("#addDuty");
            $add.append("<option value=''>选择职务</option>");
            for (var i = 0; i < data.total; i++) {
                if (data.rows[i].name == "职务") {
                    $add.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                }
            }

                $("#nation").html("");
                var $add = $("#nation");
                $add.append("<option value=''>选择民族</option>");
                for (var i = 0; i < data.total; i++) {
                    if (data.rows[i].name == "民族") {
                        $add.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                    }
                }

        }
    });
}

//得到部门管理数据
function getDepartment() {
    $.ajax({
            url:contextPath+"/employee/showDname.do",
            type:"post",
            dataType:'json',
            success:function(data) {
                $("#addDepartment").html("");
                var $add=$("#addDepartment");
                $add.append("<option value=''>选择部门</option>");
                for (var i=0;i<data.total;i++){
                    if(data.rows[i].FStatus=="Y")
                    $add.append("<option value='"+data.rows[i].FID+"'>"+data.rows[i].FDepartmentName+"</option>");
                }

                // $("#searchDepartment").html("");
                // var $search=$("#searchDepartment");
                // $search.append("<option value=''>选择部门</option>");
                // for (var i=0;i<data.total;i++){
                //     if(data.rows[i].FStatus=="Y")
                //     $search.append("<option value='"+data.rows[i].FID+"'>"+data.rows[i].FDepartmentName+"</option>");
                // }
            }
        });
}

$(document).ready(function(){
    $.ajax({
        url:contextPath+"/employee/showDname.do",
        type:"post",
        dataType:'json',
        success:function(data) {
            $("#searchDepartment").html("");
            var $search=$("#searchDepartment");
            $search.append("<option value=''>选择部门</option>");
            for (var i=0;i<data.total;i++){
                if(data.rows[i].FStatus=="Y")
                $search.append("<option value='"+data.rows[i].FID+"'>"+data.rows[i].FDepartmentName+"</option>");
            }
        }
    });
})

//养老院
function getOldHouse() {
    $.ajax({
        url:contextPath+"/nursing/queryStartFNursing.do",
        type:"post",
        dataType:'json',
        success:function(data) {
            $("#FNursinghomeID").html("");
            var $add=$("#FNursinghomeID");
            $add.append("<option value=''>选择养老院</option>");
            for (var i=0;i<data.total;i++){
                $add.append("<option value='"+data.rows[i].fID+"'>"+data.rows[i].fNursingName+"</option>");
            }
        }
    });
}

//查询
function queryMessage(){
    $.ajax({
        url:contextPath+"/employee/query.do",
        type:"post",
        data:{
            fStaffName: $("#searchName").val(),
            fStaffStatus: $("#searchStatus option:selected").val(),
            fDepartmentID:$("#searchDepartment option:selected").val(),
            page:0,
            pageSize:10
        },
        success:function(data) {
            $('#tb_empMessage').bootstrapTable('load', data);
        }
    });
}
//清空
function cleanData() {
    $("#searchName").val("");
    $("#searchStatus").val("");
    $("#searchDepartment").val("");
    $('#tb_empMessage').bootstrapTable('refresh', {url: 'query.do'});
}

//保存
function addEmp() {
    if(!add_check_Message()){
        return 0;
    }else {
        UploadFile();
        var curDateDir=getNowFormatDate();
        var urlPicture="";
        var imageName=$("#imageName").val();
        if(imageName!=""){
            urlPicture=curDateDir+"\\"+imageName+".jpg"
        }

    var birth1 = "0000-00-00";
    var birth2 = "0000-00-00";

    var name = $("#txtName").val();
    var card = $("#idCard").val();
    var health = $("#health").val();
    var political = $("#political").val();
    var inData = $("#inData").val();
    var outData = $("#outData").val();
    var census = $("#census").val();
    var school = $("#school").val();
    var major = $("#major").val();
    var usbKey = $("#usbKey").val();
    var cardId = $("#cardId").val();
    var fTel = $("#FTel").val();
    var fPostcode = $("#FPostcode").val();
    var fMobileTel = $("#FMobileTel").val();
    var phone = $("#Phone").val();
    var remark = $("#remark").val();
    var sex = $("#addSex option:selected").val();
    var stature = $("#addStature option:selected").val();
    var nation = $("#nation option:selected").val();
    var department = $("#addDepartment option:selected").val();
    var duty = $("#addDuty option:selected").val();
    var title = $("#addJobTitle option:selected").val();
    var sal = $("#addSal option:selected").val();
    var marry = $("#addMarry option:selected").val();
    var education = $("#addEducation option:selected").val();
    var computer = $("#addComputer option:selected").val();
    var foreign = $("#addForeign option:selected").val();
    var buildingID = $("#FBuildingID option:selected").val();
    var FNursinghomeID = $("#FNursinghomeID option:selected").val();
    var fruit = $("input[type='checkbox']:checked").val();
    if(fruit=="1"){
         birth2 = $("#birth").val();
    }else {
         birth1 = $("#birth").val();
    }
    if(outData==""){
         outData="0000-00-00";
    }
        $.ajax({
            url: contextPath + "/employee/addEmp.do",
            type: "post",
            data: {
                fStaffName: name,
                fStaffStatus: stature,
                fFnation: nation,
                fDepartmentID:department,
                fPost: duty,
                fTitle: title,
                fEntryDate: inData,
                fDismissalDate:outData,
                fBuildingID: buildingID,
                fIdentityCardID: card,
                fBrith: birth1,//非农历生日
                fLunarCalendar:fruit,
                fLunarBrith: birth2,//农历生日
                fMaritalStatus: marry,
                fGraduateSchool: school,
                fEducation:education,
                fMajor: major,
                fCertificate: usbKey,
                fComputerLevel: computer,
                fLanguageLevel:foreign,
                fSalryType: sal,
                fBankCardID: cardId,
                fHealth: health,
                fPostcode:fPostcode,
                fHpisejpldRegister: census,
                fHomeAddress: phone,
                fPhotoID: urlPicture,
                fSex:sex,
                fPoliticalStatus: political,
                fTel: fTel,
                fMobileTel: fMobileTel,
                fNursinghomeID:FNursinghomeID,
                fWechatNumber:$("#FWechatNumber").val(),
                fRemarks:remark
            },
            success: function (data) {
                setAlert(data.message, "操作成功");
                $('#tb_empMessage').bootstrapTable('refresh', {url: 'queryTranscoding.do'});
                $("#add_close_btn").click();
            }
        });
    }
    closeModal();
    }

//修改
function updateEmp() {
    if(!update_check_Message()){
        return 0;
    }else {
        var imgUrl;
        var imgName = $("#up_imageName").val();
        var updateFNursinghomeID = $("#updateFNursinghomeID option:selected").val();
        var carrentItem = $("#tb_empMessage").bootstrapTable('getSelections');
        //更新养老院id
        if(updateFNursinghomeID!=carrentItem[0].fNursinghomeID){
            $.ajax({
                url: contextPath + "/employee/updateUser.do",
                type: "post",
                data: {
                    fId:carrentItem[0].fId,
                    fNursinghomeID: $("#updateFNursinghomeID option:selected").val()
                }
            })
        }
        var curDateDir=getNowFormatDate();
        // 图片存储文件夹
        if(imgName.indexOf("\\")>0){
            var newImg = imgName;
        }else {
            var newImg=curDateDir+"\\"+imgName+".jpg"
        }
        var oldImg=carrentItem[0].fPhotoID;
        if(newImg!=oldImg){
            imgUrl=newImg;
        }else{
            imgUrl=oldImg;
        }
        var birth = "0000-00-00";
        var lunarBrith = "0000-00-00";
        var fDismissalDate = $("#updateDismissalDate").val();
        if(fDismissalDate==""){
            fDismissalDate="0000-00-00";
        }
        var fruit = $("input[type='checkbox']:checked").val();
        if (fruit == "1") {
            lunarBrith = $("#updateBirth").val();
        } else {
            birth = $("#updateBirth").val();
        }
        $.ajax({
            url: contextPath + "/employee/updateEmp.do",
            type: "post",
            data: {
                fId: $("#emp_id").val(),
                fStaffName: $("#updatetxtName").val(),
                fStaffStatus: $("#updateStature").val(),
                fFnation: $("#updateNation").val(),
                fDepartmentID: $("#updateDepartment").val(),
                fPost: $("#updateDuty").val(),
                fTitle: $("#updateTitle").val(),
                fEntryDate: $("#updateEntryDate").val(),
                fDismissalDate:fDismissalDate ,
                fBuildingID: $("#updateBuildingID").val(),
                fIdentityCardID: $("#updateIdentityCardID").val(),
                fBrith: birth,//非农历生日
                fLunarCalendar: fruit,
                fLunarBrith: lunarBrith,//农历生日
                fMaritalStatus: $("#updateMaritalStatus").val(),
                fGraduateSchool: $("#updateGraduateSchool").val(),
                fEducation: $("#updateEducation").val(),
                fMajor: $("#updateMajor").val(),
                fCertificate: $("#updateCertificate").val(),
                fComputerLevel: $("#updateComputer").val(),
                fLanguageLevel: $("#updateLanguageLevel").val(),
                fSalryType: $("#updateSal").val(),
                fBankCardID: $("#updateBankCard").val(),
                fHealth: $("#updateHealth").val(),
                fPostcode: $("#updatePostcode").val(),
                fHpisejpldRegister: $("#updateCensus").val(),
                fHomeAddress: $("#updateMalingAddress").val(),
                fPhotoID:imgUrl,
                fSex: $("#updateSex").val(),
                fPoliticalStatus: $("#updatePoliticalStatus").val(),
                fTel: $("#updateTel").val(),
                fMobileTel: $("#updateMobileTel").val(),
                fNursinghomeID: $("#updateFNursinghomeID option:selected").val(),
                fWechatNumber:$("#updateFWechatNumber").val(),
                fRemarks: $("#updateRemark").val()
            },
            success: function (data) {
                setAlert(data.message, "操作成功");
                $('#tb_empMessage').bootstrapTable('refresh', {url: 'queryTranscoding.do'});
                $("#update_close_btn").click();
            }
        });
    }
    closeModal();
}

//禁用
function gotoDelete(){
    var carrentItem = $("#tb_empMessage").bootstrapTable('getSelections');
    if(carrentItem[0]){
        if(carrentItem[0].fState==0){
            setAlert("error","该条记录已经是禁用状态");
        }else {
            $.ajax({
                url: contextPath + "/employee/deleteEmp.do",
                type: "post",
                data: {
                    fId: carrentItem[0].fId
                },
                success: function (data) {
                    $('#tb_empMessage').bootstrapTable('refresh', {url: 'queryTranscoding.do'});
                    if (data.success) {
                        setAlert(data.msg, "操作成功");
                        $('#tb_empMessage').bootstrapTable('refresh', {url: 'queryTranscoding.do'});
                    }
                }
            });
        }
    }else{
        setAlert("error","请先选择一条数据");
    }
}

//启用
function gotoEnabled(){
    var carrentItem = $("#tb_empMessage").bootstrapTable('getSelections');
    if(carrentItem[0]){
        if(carrentItem[0].fState==1){
            setAlert("error","该条记录已经是启用状态");
        }else{
            $.ajax({
                url:contextPath+"/employee/startMessage.do",
                type:"post",
                data:{
                    fId:carrentItem[0].fId
                },
                success:function(data) {
                    $('#tb_empMessage').bootstrapTable('refresh', {url: 'queryTranscoding.do'});
                    setAlert(data.msg,"启用成功");

                }
            });
        }
    }else{
        setAlert("error","请先选择一条数据");
    }
}

//关闭
function closeModal() {
    document.getElementById("Imagel").src="/ems/img/a3.jpg";
    document.getElementById("Imagel2").src="/ems/img/a3.jpg";
    $("#imageName").val("");
    $("#txtName").val("");
    $("#idCard").val("");
    $("#health").val("");
    $("#political").val("");
    $("#inData").val("");
    $("#outData").val("");
    $("#census").val("");
    $("#school").val("");
    $("#major").val("");
    $("#usbKey").val("");
    $("#cardId").val("");
    $("#FTel").val("");
    $("#FPostcode").val("");
    $("#FMobileTel").val("");
    $("#Phone").val("");
    $("#remark").val("");
    $("#FWechatNumber").val("");
    $("#FileUpload1").val("");
    $("#addSex").val("");
    $("#addStature").val("");
    $("#nation").val("");
    $("#addDepartment").val("");
    $("#addDuty").val("");
    $("#addJobTitle").val("");
    $("#addSal").val("");
    $("#addMarry").val("");
    $("#addEducation").val("");
    $("#addComputer").val("");
    $("#addForeign").val("");
    $("#FBuildingID").val("");
    $(":checkbox").removeAttr("checked")
    $("#birth").val("");
    $("#updatetxtName").val("");
    $("#updateStature").val("");
    $("#updateNation").val("");
    $("#updateDepartment").val("");
    $("#updateDuty").val("");
    $("#updateTitle").val("");
    $("#updateEntryDate").val("");
    $("#updateDismissalDate").val("");
    $("#updateBuildingID").val("");
    $("#updateIdentityCardID").val("");
    $("#updateMaritalStatus").val("");
    $("#updateGraduateSchool").val("");
    $("#updateEducation").val("");
    $("#updateMajor").val("");
    $("#updateCertificate").val("");
    $("#updateComputer").val("");
    $("#updateLanguageLevel").val("");
    $("#updateSal").val("");
    $("#updateBankCard").val("");
    $("#updateHealth").val("");
    $("#updatePostcode").val("");
    $("#updateCensus").val("");
    $("#updateMalingAddress").val("");
    $("#updateFileUpload1").val("");
    $("#updateSex").val("");
    $("#updatePoliticalStatus").val("");
    $("#updateTel").val("");
    $("#updateMobileTel").val("");
    $("#updateWechatNumber").val("");
    $("#updateRemark").val("");
    $("#updateFileUpload2").val("");
}

//页面回显数据
function gotoUpdate() {
    var bool="";
        var carrentItem = $("#tb_empMessage").bootstrapTable('getSelections');
        if (carrentItem[0]) {
            if(carrentItem[0].fState=="0"){
                setAlert("error", "该记录已禁用，无法更新");
            }else {
                $.ajax({
                    url: contextPath + "/sys/get.do",
                    type: "post",
                    data: {
                        page: 1,
                        pageSize: 10000000
                    },
                    success: function (data) {

                        $("#updateLanguageLevel").html("");
                        var updateLanguageLevel = $("#updateLanguageLevel");
                        updateLanguageLevel.append("<option value=''>    </option>");
                        for (var i = 0; i < data.total; i++) {
                            if (data.rows[i].name == "外语水平") {
                                if (data.rows[i].value == carrentItem[0].fLanguageLevel) {
                                    updateLanguageLevel.append("<option value='" + data.rows[i].value + "' selected='selected'>" + data.rows[i].value + "</option>");
                                } else {
                                    updateLanguageLevel.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                                }
                            }
                        }
                        $("#updateComputer").html("");
                        var updateComputer = $("#updateComputer");
                        updateComputer.append("<option value=''>    </option>");
                        for (var i = 0; i < data.total; i++) {
                            if (data.rows[i].name == "电脑水平") {
                                if (data.rows[i].value == carrentItem[0].fComputerLevel) {
                                    updateComputer.append("<option value='" + data.rows[i].value + "'selected='selected'>" + data.rows[i].value + "</option>");
                                } else {
                                    updateComputer.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                                }
                            }
                        }

                        $("#updateEducation").html("");
                        var updateEducation = $("#updateEducation");
                        updateEducation.append("<option value=''>    </option>");
                        for (var i = 0; i < data.total; i++) {
                            if (data.rows[i].name == "学历") {
                                if (data.rows[i].value == carrentItem[0].fEducation) {
                                    updateEducation.append("<option value='" + data.rows[i].value + "' selected='selected'>" + data.rows[i].value + "</option>");
                                } else {
                                    updateEducation.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                                }
                            }
                        }

                        $("#updateMaritalStatus").html("");
                        var updateMaritalStatus = $("#updateMaritalStatus");
                        updateMaritalStatus.append("<option value=''>    </option>");
                        for (var i = 0; i < data.total; i++) {
                            if (data.rows[i].name == "婚姻状况") {
                                if (data.rows[i].value == carrentItem[0].fMaritalStatus) {
                                    updateMaritalStatus.append("<option value='" + data.rows[i].value + "' selected='selected'>" + data.rows[i].value + "</option>");
                                } else {
                                    updateMaritalStatus.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                                }
                            }
                        }

                        $("#updateSal").html("");
                        var updateSal = $("#updateSal");
                        updateSal.append("<option value=''>选择职称</option>");
                        for (var i = 0; i < data.total; i++) {
                            if (data.rows[i].name == "薪资类别") {
                                if (data.rows[i].value == carrentItem[0].fSalryType) {
                                    updateSal.append("<option value='" + data.rows[i].value + "' selected='selected' >" + data.rows[i].value + "</option>");
                                } else {
                                    updateSal.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                                }
                            }
                        }

                        $("#updateTitle").html("");
                        var updateTitle = $("#updateTitle");
                        updateTitle.append("<option value=''>选择职称</option>");
                        for (var i = 0; i < data.total; i++) {
                            if (data.rows[i].name == "职称") {
                                if (data.rows[i].value == carrentItem[0].fTitle) {
                                    updateTitle.append("<option value='" + data.rows[i].value + "' selected='selected' >" + data.rows[i].value + "</option>");
                                } else {
                                    updateTitle.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                                }
                            }
                        }

                        $("#updateDuty").html("");
                        var updateDuty = $("#updateDuty");
                        updateDuty.append("<option value=''>选择职务</option>");
                        for (var i = 0; i < data.total; i++) {
                            if (data.rows[i].name == "职务") {
                                if (data.rows[i].value == carrentItem[0].fPost) {
                                    updateDuty.append("<option value='" + data.rows[i].value + "' selected='selected' >" + data.rows[i].value + "</option>");
                                } else {
                                    updateDuty.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                                }
                            }
                        }

                        $("#updateNation").html("");
                        var updateNation = $("#updateNation");
                        updateNation.append("<option value=''>选择民族</option>");
                        for (var i = 0; i < data.total; i++) {
                            if (data.rows[i].name == "民族") {
                                if (data.rows[i].value == carrentItem[0].fFnation) {
                                    updateNation.append("<option value='" + data.rows[i].value + "' selected='selected'>" + data.rows[i].value + "</option>");
                                } else {
                                    updateNation.append("<option value='" + data.rows[i].value + "'>" + data.rows[i].value + "</option>");
                                }
                            }
                        }

                    }
                });
                $.ajax({
                    url: contextPath + "/building/query.do",
                    type: "post",
                    data: {
                        page: 0,
                        pageSize: 10000000
                    },
                    success: function (data) {
                        $("#updateBuildingID").html("");
                        var updateBuildingID = $("#updateBuildingID");
                        updateBuildingID.append("<option value=''>    </option>");
                        for (var i = 0; i < data.total; i++) {
                            if (data.rows[i].fBuildingName == carrentItem[0].fBuildingName && data.rows[i].fStatus!="10") {
                                updateBuildingID.append("<option value='" + data.rows[i].fID + "' selected='selected' >" + data.rows[i].fBuildingName + "</option>");
                            } else if(data.rows[i].fBuildingName == carrentItem[0].fBuildingName && data.rows[i].fStatus=="10"){
                                updateBuildingID.append("<option value='" + data.rows[i].fID + "' selected='selected' >" + data.rows[i].fBuildingName  + "&nbsp;&nbsp; 已禁用</option>");
                            } else if(data.rows[i].fBuildingName != carrentItem[0].fBuildingName && data.rows[i].fStatus=="11"){
                                updateBuildingID.append("<option value='" + data.rows[i].fID + "'>" + data.rows[i].fBuildingName + "</option>");
                            }
                        }
                    }
                });
                $.ajax({
                    url: contextPath + "/employee/showDname.do",
                    type: "post",
                    dataType: 'json',
                    success: function (data) {

                        $("#updateDepartment").html("");
                        var updateDepartment = $("#updateDepartment");
                        updateDepartment.append("<option value=''>选择部门</option>");
                        for (var i = 0; i < data.total; i++) {
                            if (data.rows[i].FDepartmentName == carrentItem[0].fDepartmentName && data.rows[i].FStatus!="N") {
                                updateDepartment.append("<option value='" + data.rows[i].FID + "' selected='selected' >" + data.rows[i].FDepartmentName + "</option>");
                            } else if(data.rows[i].FDepartmentName == carrentItem[0].fDepartmentName && data.rows[i].FStatus=="N"){
                                updateDepartment.append("<option value='" + data.rows[i].FID + "' selected='selected' >" + data.rows[i].FDepartmentName + "</option>");
                            } else if(data.rows[i].FDepartmentName != carrentItem[0].fDepartmentName && data.rows[i].FStatus=="Y"){
                                updateDepartment.append("<option value='" + data.rows[i].FID + "'>" + data.rows[i].FDepartmentName + "</option>");
                            }
                        }
                    }
                });
                $.ajax({
                    url: contextPath + "/nursing/queryStartFNursing.do",
                    type: "post",
                    dataType: 'json',
                    success: function (data) {
                        for (var i=0;i<data.total;i++) {
                            if (data.rows[i].fID == carrentItem[0].fNursinghomeID) {
                                bool = true;//如果bool=true 证明没有禁用 如果bool=''证明被禁用
                            }
                        }
                        $("#updateFNursinghomeID").html("");
                        if(bool==''){
                            var $update = $("#updateFNursinghomeID");
                            $update.append("<option value='"+carrentItem[0].fNursinghomeID+"' selected='selected'>"+carrentItem[0].fNursinghome+"</option>");
                            for (var i=0;i<data.total;i++){
                                $update.append("<option value='"+data.rows[i].fID+"'>"+data.rows[i].fNursingName+"</option>");
                            }
                        }
                                //未被禁用
                        if(bool==true){
                            var $update=$("#updateFNursinghomeID");
                            for (var i=0;i<data.total;i++){
                                if(data.rows[i].fID==carrentItem[0].fNursinghomeID){
                                        $update.append("<option value='"+data.rows[i].fID+"' selected='selected' >"+data.rows[i].fNursingName+"</option>");
                                }else{
                                    $update.append("<option value='"+data.rows[i].fID+"'>"+data.rows[i].fNursingName+"</option>");
                                }
                            }
                        }
                    }
                });
                if (carrentItem[0].fLunarCalendar == 1) {
                    $("#updateBirth").val(carrentItem[0].fLunarBrith);
                    $("input[type='checkbox'][name='updateFruit']").prop("checked",true);
                }
                if (carrentItem[0].fLunarCalendar == "") {
                    $("input[type='checkbox'][name='updateFruit']").prop("checked",false);
                    $("#updateBirth").val(carrentItem[0].fBrith);
                }
                document.getElementById("Imagel2").src = "\\ems\\img\\" + carrentItem[0].fPhotoID;
                $("#emp_id").val(carrentItem[0].fId);
                $("#up_imageName").val(carrentItem[0].fPhotoID);
                $("#updatetxtName").val(carrentItem[0].fStaffName);
                $("#updateIdentityCardID").val(carrentItem[0].fIdentityCardID);
                $("#updateHealth").val(carrentItem[0].fHealth);
                $("#updatePoliticalStatus").val(carrentItem[0].fPoliticalStatus);
                $("#updateEntryDate").val(carrentItem[0].fEntryDate);
                $("#updateDismissalDate").val(carrentItem[0].fDismissalDate);
                $("#updateCensus").val(carrentItem[0].fHpisejpldRegister);
                $("#updateGraduateSchool").val(carrentItem[0].fGraduateSchool);
                $("#updateMajor").val(carrentItem[0].fMajor);
                $("#updateCertificate").val(carrentItem[0].fCertificate);
                $("#updateBankCard").val(carrentItem[0].fBankCardID);
                $("#updateTel").val(carrentItem[0].fTel);
                $("#updateSex").val(carrentItem[0].fSex);
                $("#updatePostcode").val(carrentItem[0].fPostcode);
                $("#updateMobileTel").val(carrentItem[0].fMobileTel);
                $("#updateMalingAddress").val(carrentItem[0].fHomeAddress);
                $("#updateRemark").val(carrentItem[0].fRemarks);
                $("#updateFWechatNumber").val(carrentItem[0].fWechatNumber);
                $("#updateStature").val(carrentItem[0].fStaffStatus);
                $("#updateSex option[value='" + carrentItem[0].fSex + "']").attr("selected", true);
                $("#updateStature option[value='" + carrentItem[0].fStaffStatus + "']").attr("selected", true);
                $("#updateNation option[value='" + carrentItem[0].fFnation + "']").attr("selected", true);
                $("#updateDepartment option[value='" + carrentItem[0].fDepartmentID + "']").attr("selected", true);
                $("#updateDuty option[value='" + carrentItem[0].fPost + "']").attr("selected", true);
                $("#updateTitle option[value='" + carrentItem[0].fTitle + "']").attr("selected", true);
                $("#updateSal option[value='" + carrentItem[0].fSalryType + "']").attr("selected", true);
                $("#updateMaritalStatus option[value='" + carrentItem[0].fMaritalStatus + "']").attr("selected", true);
                $("#updateEducation option[value='" + carrentItem[0].fEducation + "']").attr("selected", true);
                $("#updateComputer option[value='" + carrentItem[0].fComputerLevel + "']").attr("selected", true);
                $("#updateLanguageLevel option[value='" + carrentItem[0].fLanguageLevel + "']").attr("selected", true);
                $("#updateBuildingID option[value='" + carrentItem[0].fBuildingID + "']").attr("selected", true);
                $("#update_btn").click();
            }
        } else {
            setAlert("error", "请先选择一条数据");
        }
 }

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

// //上传文件
// function onChangFile(seqId){
//     var obj = getObjectURL(document.getElementById('FileUpload'+seqId).files[0]);
//     $('#Imagel').attr('src',obj);
//
//     // 文件改变,单上传功能启用
//     $('#uploadButton_'+seqId).attr("disabled",false);
//
//     UploadFile('1')
// };
//
//异步文件上传(jquery)
function UploadFile() {
    var now=new Date();
    var imageName=now.getFullYear()+""+(now.getMonth()+1)+""+now.getDate()+""+now.getHours()+""+now.getMinutes()+""+now.getSeconds();
    $("#imageName").val(imageName);
    $.ajaxFileUpload({
        url : contextPath+"/files/upload.do",   //submit to UploadFileServlet
        secureuri : false,
        fileElementId : 'FileUpload1',
        dataType : 'JSON', //or json xml whatever you like~
        data: {//加入的文本参数
            "formFieldId": "param1",
            imgName:imageName
        }
    });
    return false;
}

function updateUploadFile() {
    var now=new Date();
    var imageName=now.getFullYear()+""+(now.getMonth()+1)+""+now.getDate()+""+now.getHours()+""+now.getMinutes()+""+now.getSeconds();
    $("#up_imageName").val(imageName);
    $.ajaxFileUpload({
        url : contextPath+"/files/upload.do",   //submit to UploadFileServlet
        secureuri : false,
        fileElementId : 'updateFileUpload2',
        dataType : 'JSON', //or json xml whatever you like~
        data: {//加入的文本参数
            "formFieldId": "param1",
            imgName:imageName
        }
    });
    return false;
}
//新增的图片显示
function onChangFile(seqId){
    var file=document.getElementById('FileUpload'+seqId);
    var filename=file.value;
    var file_ext=filename.substring((filename.lastIndexOf("\."))+1);
    var allowedExt=new Array("gif", "GIF",
        "jpg", "JPG", "swf", "SWF", "PNG", "png", "FLV",
        "flv", "FLA", "fla", "jpeg");
    var bool=false;
    for(var i=0;i<allowedExt.length;i++)
    {
        if(allowedExt[i]==file_ext){
            bool=true;
        }
    }
    if(bool==true){
        var maxsize=1000*1024;
        if(file.files[0].size < maxsize)
        {
            $('#Imagel').attr('src',getObjectURL(file.files[0]));
        }
    }
    else{
        alert("文件格式错误！\n 请传入以下类型文件："+allowedExt.toString());
        $("#FileUpload"+seqId).val("");
        $('#Imagel').attr('src',"");
    }
};
//更新中的图片显示
function onUpdateFile(seqId){
    var file=document.getElementById('updateFileUpload'+seqId);
    var filename=file.value;
    var file_ext=filename.substring((filename.lastIndexOf("\."))+1);
    var allowedExt=new Array("gif", "GIF",
        "jpg", "JPG", "swf", "SWF", "PNG", "png", "FLV",
        "flv", "FLA", "fla", "jpeg");
    var bool=false;
    for(var i=0;i<allowedExt.length;i++)
    {
        if(allowedExt[i]==file_ext){
            bool=true;
        }
    }
    if(bool==true){
        var maxsize=1000*1024;
        if(file.files[0].size < maxsize)
        {
            $('#Imagel2').attr('src',getObjectURL(file.files[0]));
            updateUploadFile();
        }
    }
    else{
        alert("文件格式错误！\n 请传入以下类型文件："+allowedExt.toString());
        $("#updateFileUpload"+seqId).val("");
        $('#Imagel2').attr('src',"");
    }
};