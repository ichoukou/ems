/**
 * Created by wangjs on 2017/1/6.
 */
$(document).ready(
    // getOldMan()

    // 列出查询的房间输入框
    getAllRoom(),
    // 列出查询的老人状态
    getAllOldManState()
);


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
            $("#searchFroom").html(room);
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
                    if(row[i].value!='出院'&&row[i].value!='结算'){
                        oldManState += "<option value='" + row[i].id + "'>" + row[i].value + "</option>";
                    }
                }
            }
            $("#searchFoldManStatusID").html(oldManState);
        }
    });
}


function initChooseOldManTb(){
    $('#tb_chooseOldMan').bootstrapTable({
        url: contextPath+'/hosing/queryOldManMainByState.do',   //请求后台的URL（*）
        method: 'get',      //请求方式（*）
        //toolbar: '',    //工具按钮用哪个容器
        striped: true,      //是否显示行间隔色
        cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,     //是否显示分页（*）
        sortable: false,      //是否启用排序
        sortOrder: "asc",     //排序方式
        queryParams: function (params) {
            var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                pageSize: params.limit, //页面大小
                page: params.offset, //页码
                foldManName : $("#searchFOldManName").val(), //老人姓名
                froomID : $("#searchFroom").val(), //房间
                // fOldManNumber : $("#searchFOldManNumber").val(), //老人编号
                foldManStatusID : $("#searchFoldManStatusID").val() //老人状态
            };
            return temp;
        },//传递参数（*）
        sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
        pageNumber:1,      //初始化加载第一页，默认第一页
        pageSize: 12,      //每页的记录行数（*）
        pageList: [12, 24, 48, 96],  //可供选择的每页的行数（*）
        search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
        strictSearch: true,
        showColumns: true,     //是否显示所有的列
        showRefresh: true,     //是否显示刷新按钮
        minimumCountColumns: 1,    //最少允许的列数
        clickToSelect: true,    //是否启用点击选中行
        height: 420,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "fId",      //每一行的唯一标识，一般为主键列
        showToggle:false,     //是否显示详细视图和列表视图的切换按钮
        showRefresh : false,  //是否显示刷新按钮
        showColumns : false,  //是否显示列表下拉按钮
        cardView: false,     //是否显示详细视图
        detailView: false,     //是否显示父子表
        singleSelect : true,
        showHeader : false,
        columns: [
            // {
            //     radio: true
            // }, {
            //     field: 'fID',
            //     title: '编号',
            //     align: "center",
            // }
        ],
        onLoadSuccess : function (data){
            $(".fixed-table-header").removeClass("fixed-table-header");
            var showHtml=getShowHtml(data);
            //$("#tb_chooseOldMan").html("");
            //$("#chooseOldMan .fixed-table-body").html(showHtml);
            $("#tb_chooseOldMan").html(showHtml);
        }
    });
};

function getShowHtml(data){
    var html="<tr><td>";

    var dataLength=data.rows.length;
    if(dataLength>0){
        var merchant=dataLength/4;
        var rowLength=Math.floor(merchant)+1;
        var start=0;
        var end=0;
        for(var i=0;i<rowLength;i++){
            html += "<div class='row' style='width:98%;'>";

            if (i == rowLength - 1) {
                start = i * 4;
                end = dataLength;

            } else {
                start = i * 4;
                end = (i + 1) * 4;
            }

            for (var j = start; j < end; j++) {
                var oldManStateName=data.rows[j].foldManStatusName;
                var oldMan = data.rows[j];
                html += "<div style='display: inline-block;background-color: #FFF;height: 149px;width: 251px'>";
                // html+="<div class='col-xs-6 col-md-3'>";
                var oldMan = data.rows[j];
                var dataHtml = getOneTdHtml(oldMan);
                html += dataHtml;
                html += "</div>";
            }

            html += "</div>";
        }
    }
    html+="</td></tr>";
    return html;
}

function getOneTdHtml(obj){
    var fPhotoSrc=contextPath+"/picture/"+obj.fPhoto;
    var html="<table class='table table-bordered'>";
    html+="<tr>";
    html+="<td rowspan='4'><img style='height: 135px;width: 110px;' name='' src='"+fPhotoSrc+"' onclick=\"getOldManWithPhoto('"+obj.fID+"','"+obj.foldManName+"')\" /></td>";
    // html+="<td rowspan='4'><img style='height: 135px;width: 110px;' name='' src='"+fPhotoSrc+"' onclick=\"chooseOldManOver('"+obj.fid+"','"+obj.fOldManName+"')\" /></td>";
    html+="<td>姓 名:"+obj.foldManName+"</td>";
    html+="</tr>";

    html+="<tr>";
    html+="<td>性 别:"+obj.fOldManIDnSex+"</td>";
    html+="</tr>";

    html+="<tr>";
    html+="<td>房间信息:"+obj.fBuildingName+'#'+obj.fRoomName+'#'+obj.fBedNumber+"</td>";
    html+="</tr>";

    html+="<tr>";
    html+="<td>护理信息:"+obj.fnursingLevelName+"</td>";
    html+="</tr>";

    html+="</table>";

    return html;
}

function queryOldMan(){
    $('#tb_chooseOldMan').bootstrapTable('refresh');
}

//清空老人查询条件
function resetSearchOldMan(){
    $("#searchFOldManName").val("");//老人姓名
    $("#searchFroom").val(""); //房间
    $("#searchFoldManStatusID").val(""); //老人状态
}

// function getOldMan(){
//     $.ajax({
//         url:contextPath+"/hosing/getom.do",
//         type:"post",
//         data:{
//         },
//         success:function(data) {
//             // alert(data)
//             console.log(data)
//             var len=data.total;
//             var row=data.rows;
//
//             for(var i=0;i<len;i++){
//                 if(row[i].foldManStatusName!='出院'){
//                     if(row[i].fPhoto==null){
//                         var div=document.createElement('div');
//                         div.style="display: inline-block;background-color: #FFF;height: 149px;width: 330px";
//                         var tempName=row[i].foldManName;
//                         // div.id="div_"+i;
//                         div.innerHTML='<img selectName="'+tempName+'" selectOmId="'+row[i].fID+'" onclick="getOldManWithPhoto(this)" src="/ems/img/a1.jpg" style="height: 117px;width: 99px;">' +
//                             '<span style="display: inline-block;"><ul><li>姓名：'+tempName+' </li> <li> 性别：'+row[i].fOldManIDnSex+' </li>' +
//                             ' <li> 房间信息：'+row[i].fBuildingName+'#'+row[i].fRoomName+'#'+row[i].fBedNumber+' </li> <li> 护理级别：'+row[i].fnursingLevelName+' </li></ul> </span>';
//                         document.getElementById("myDiv").appendChild(div);
//                     }else{
//                         var div=document.createElement('div');
//                         // div.id="div_"+i;
//                         div.style="display: inline-block;background-color: #FFF;height: 149px;width: 330px";
//                         var tempName=row[i].foldManName;
//                         div.innerHTML='<img selectName="'+tempName+'" selectOmId="'+row[i].fID+'" onclick="getOldManWithPhoto(this)" src="/ems/picture/'+row[i].fPhoto+'" style="height: 117px;width: 99px;">' +
//                             '<span style="display: inline-block;"><ul><li>姓名：'+row[i].foldManName+' </li> <li> 性别：'+row[i].fOldManIDnSex+' </li>' +
//                             ' <li> 房间信息：'+row[i].fBuildingName+'#'+row[i].fRoomName+'#'+row[i].fBedNumber+' </li> <li> 护理级别：'+row[i].fnursingLevelName+' </li></ul> </span>';
//                         document.getElementById("myDiv").appendChild(div);
//                     }
//                 }
//             }
//         }
//     });
// }