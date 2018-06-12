/**
 * Created by Administrator on 2016/12/27.
 */
//全局计数对象
var i = 1;

// 显示本地图片
function onChangFile(seqId){
    var obj = getObjectURL(document.getElementById('file_'+seqId).files[0]);
    $('#img_'+seqId).attr('src',obj);

    // 文件改变,单上传功能启用
    $('#uploadButton_'+seqId).attr("disabled",false);
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

// 添加一个单位
function addUpload(){
    i++;
    var s = '<tr id="tr_'+i+'">';
    s += '<td><img id="img_'+i+'" height="100" width="100" src=""></td>';
    s += '<td><input id="file_'+i+'" type="file" name="myfiles" onchange="onChangFile(\''+i+'\')" /></td>';
    s += '<td><input id="uploadButton_'+i+'" type="button" value="上传" disabled onclick="UploadFile(\''+i+'\')"/></td>';
    s += '<td><button onclick="deletUpload(\''+i+'\')"><font color="red">X</font></button></td>';
    //s += '<td><img id="img_'+i+'_'+i+'" height="100" width="100" src=""></td>';
    s += '<td><span id="message_'+i+'"></span><span id="url_'+i+'"></span></td>';
    s += '</tr>';
    $("#uploadtable >tbody").append(s);
    $('#file_'+i).trigger("click");
};

// 删除一个单位
function deletUpload(seqId){
    $('#tr_'+seqId).remove();
};

//异步文件上传(jquery)
function UploadFile(seqId) {
    $.ajaxFileUpload({
        url : contextPath+"/file/upload.do",   //submit to UploadFileServlet
        secureuri : false,
        fileElementId : 'file_'+seqId,
        dataType : 'JSON', //or json xml whatever you like~
        data: {//加入的文本参数
            "formFieldId": "param1",
        },
        success : function(data, status) {
            data = data.substring(data.indexOf("{"),data.indexOf("}")+1);
            var json = eval("(" +data+ ")");
            // 提示信息
            $("#message_"+seqId).text(json.message);
            // url 回写
            $("#url_"+seqId).text(json.fileUrl);

            $("#uploadButton_"+seqId).attr("disabled",true);

        },
        error : function(data, status, e) {
            $("#result").append(data);
        }
    });
    return false;
}

// 批量提交
function batchUpload(){

    // 所有可用按钮触发
    $("input[id^='uploadButton']").each(function(){
        if($(this).attr("disabled")==undefined){
            //$(this).trigger("click");
            $(this).trigger("click");
        }
    });
};
