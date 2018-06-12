/**
 * Created by wangjs on 2017/2/21.
 */
// $(function () {
//     //1.初始化Table
//     var oTable2 = new TableInit2();
//     oTable2.Init();
// });
function init_updBed(){
    //修改房间时初始化床位
    var oTable2 = new TableInit2();
    oTable2.Init();
}

var TableInit2 = function () {
    var oTableInit2 = new Object();
    //初始化Table
    oTableInit2.Init = function () {
        $('#tb_UpdBed').bootstrapTable({
            url: contextPath + "/bed/queryBed.do",   //请求后台的URL（*）
            // method: 'queryBed',      //请求方式（*）
            //toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页（*）
            sortable: false,      //是否启用排序
            sortOrder: "asc",     //排序方式
            queryParams: oTableInit2.queryParams,//传递参数（*）
            sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,      //初始化加载第一页，默认第一页
            pageSize: 10,      //每页的记录行数（*）
            pageList: [10, 25, 50, 100],  //可供选择的每页的行数（*）
            // search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            // showColumns: true,     //是否显示所有的列
            // showRefresh: true,     //是否显示刷新按钮
            minimumCountColumns: 2,    //最少允许的列数
            clickToSelect: true,    //是否启用点击选中行
            height: 350,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",      //每一行的唯一标识，一般为主键列
            // showToggle: true,     //是否显示详细视图和列表视图的切换按钮
            // cardView: false,     //是否显示详细视图
            detailView: false,     //是否显示父子表

            columns: [{
                radio: true
            }, {
                field: 'fBedNumber',
                title: '床位号',
                align: "center",
                valign: "middle",
            }, {
                field: 'fRoomName',
                title: '房间名称',
                align: "center",
                valign: "middle",
            }, {
                field: 'fBedPrice',
                title: '床位价格',
                align: "center",
                valign: "middle",
            }, {
                field: 'fStatus',
                title: '状态',
                align: "center",
                valign: "middle",
                formatter:function(value){
                    if(value=='2'){
                        return '<span style="color:#00ff00">空闲</span>'
                    }else if(value=='11'){
                        return '<span style="color:#FF0000">使用</span>'
                    }else if(value=='10'){
                        return '<span style="color:#0000cc">请假</span>'
                    }else if(value=='01'){
                        return '<span style="color:#ffff00">预约</span>'
                    }
                }
            }, {
                field: 'fAdministratorsID',
                title: '护理员',
                align: "center",
                valign: "middle",
            }, {
                field: 'fExplain',
                title: '说明',
                align: "center",
                // editable:{
                //     type:'test',
                //     title:'说明2',
                //     validate:function(v){
                //         if(!v) return '内容不能为空';
                //     }
                // }
            },{
                field: 'id',
                title: '操作',
                align: 'center',
                width:280,
                formatter:function(value,row,index){
                    // console.log(JSON.stringify(row));
                    var str=JSON.stringify(row);
                    //str=str.substring(1,str.length-1);
                    str=str.replace(/\"/g,"=");
                    return  "<a href='javascript:void(0)' class='glyphicon glyphicon-pencil' style='color: #1C84C6' onclick=\"get_to_updateBed('"+str+"')\">修改</a>" +
                        "&nbsp;|&nbsp;<a href='javascript:void(0)'  class='glyphicon glyphicon-remove' style='color: #1C84C6' onclick=\"get_to_delBed('"+str+"')\">删除</a>"
                }
            }
            ],
            // onEditableSave:function(field,row,oldValue,$el){
            //     $.ajax({
            //         type:"post",
            //         url:"/",
            //         success:function(data,status){
            //             if(status=="success"){
            //                 alert("提交数据成功");
            //             }
            //         },
            //         error:function(){
            //             alert('编辑失败');
            //         },
            //     })
            // }
        });
    };

    //得到查询的参数
    oTableInit2.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset,//页码
            fRoomID: $("#updRoomId").val(),
            // value: $("#searchValue").val()
        };
        return temp;
    };
    return oTableInit2;
};

//跳转更新
function get_to_updateBed(str) {
    str=str.replace(/\=/g,"\"");
    var po=JSON.parse(str);
    // $("#update_id").val(po.id);
    // $("#update_sorting_name").val(po.typeName);
    // $("#update_remarks").val(po.remark);
    // $("#update_name_message").html("&nbsp;&nbsp;");
    $("#updBedExplain").val(po.fExplain);
    $("#updStatus").val(po.fStatus);
    $("#updAdministratorsIDs").val(po.fAdministratorsID);
    $("#updBedPrice").val(po.fBedPrice);
    // getCharge(po.fBedPrice)
    $("#updBedNumber").val(po.fBedNumber);
    $("#updBedID").val(po.fID);

    // $("#updateBed_btn").click();
}

//删除
function get_to_delBed(str) {
    str=str.replace(/\=/g,"\"");
    var po=JSON.parse(str);
    $.ajax({
        url: contextPath + "/bed/delBed.do",
        type: "post",
        data: {
            fID:po.fID,
        },
        success: function (data) {
            console.log(data.message);
            // setAlert(data.message, "添加床位成功");
            alert("删除床位成功")
            $('#tb_Bed').bootstrapTable('load', data);
            $('#tb_Room').bootstrapTable('refresh', {url: 'query.do'});
            $('#tb_UpdBed').bootstrapTable('refresh', {url: contextPath + '/bed/queryBed.do'});
        }
    });
    // $("#updateBed_btn").click();
}
//修改床位
function updBed() {
    if(check_updBed()){
        $.ajax({
            url: contextPath + "/bed/updBed.do",
            type: "post",
            data: {
                fID:$("#updBedID").val(),
                fBedNumber: $("#updBedNumber").val(),
                fBedPrice: $("#updBedPrice").val(),
                fAdministratorsID: $("#updAdministratorsIDs").val(),
                fStatus: $("#updStatus").val(),
                fExplain: $("#updBedExplain").val(),

                fRoomID: $("#updRoomId").val()
            },
            success: function (data) {
                console.log(data.message);
                // setAlert(data.message, "添加床位成功");
                alert("修改床位成功")
                $('#tb_Bed').bootstrapTable('load', data);
                $('#tb_UpdBed').bootstrapTable('refresh', {url: contextPath + '/bed/queryBed.do'});
                $('#tb_Room').bootstrapTable('refresh', {url: 'query.do'});
            }
        });
    }else{
        return 0;
    }
    closeUpdBedModal()
}
// //房间价格取自缴费标准表
// function getCharge(bedCharge) {
//     $.ajax({
//         url: contextPath + "/charge/queryCharge.do",
//         type: "post",
//         success: function (data) {
//             var len3 = data.total;
//             var row3 = data.rows;
//             var charge = "<option value=''> --请选择-- </option>";
//             for (var i = 0; i < len3; i++) {
//                 var achargeName = row3[i].fChrgeType;
//                 if ("床费" == achargeName) {
//                     if(bedCharge==row3[i].fID){
//                         charge += "<option selected='selected' value='" + row3[i].fID + "'>" + row3[i].fPrice + "</option>";
//                     }else{
//                         charge += "<option value='" + row3[i].fID + "'>" + row3[i].fPrice + "</option>";
//                     }
//
//                 }
//             }
//             $("#updBedPrice").html(charge);
//
//         }
//     });
// }
function check_updBed(){
    var result=true;

    if(!check_updBed_bedNumber()){
        result=false;
    }

    if(!check_updBed_bedPrice()){
        result=false;
    }

    return result;
}

function check_updBed_bedNumber(){
    var result=true;
    var bedNumber = $("#updBedNumber").val().trim();
    $("#errorUpdBedNumber").html("");
    if (bedNumber==""){
        $("#errorUpdBedNumber").html("!!!");
        result = false;
    }
    return result;
}

function check_updBed_bedPrice(){
    var result=true;
    var bedPrice = $("#updBedPrice").val().trim();
    $("#errorUpdBedPrice").html("");
    if (bedPrice==""){
        $("#errorUpdBedPrice").html("!!!");
        result = false;
    }
    return result;
}

function closeUpdBedModal(flag) {
    $("#updBedExplain").val("");
    $("#updBedNumber").val("");
    $("#updBedPrice").val("");
    $("#updBedExplain").val("");
    if(flag==1){
        $("#updateModal").modal("hide");
        $("#addfRoomID").val("");
    }
    $('#tb_Bed').bootstrapTable('removeAll');
}


