<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>上传入口</title>
</head>
<body>
    <table id="uploadtable" style="margin: auto;">
        <tbody>
        <tr id="tr_1">

            <td bgcolor="#aaaaaa">
                <img id="img_1" height="100" width="100" src="">
            </td>
            <td>
                <input id="file_1" type="file" name="myfiles" onchange="onChangFile('1')" />
            </td>
            <td>
                <input id="uploadButton_1" type="button" value="上传" onclick="UploadFile('1')"/>
            </td>
            <td>
                <button onclick="deletUpload('1')">
                    <font color="red">X</font>
                </button>
            </td>
            <td>
                <span id="message_1"></span>
                <span id="url_1"></span>
            </td>
        </tr>
        </tbody>
    </table>
    <table style="margin: auto;">
        <tr>
            <td><input type="button" onclick="addUpload()" value="添加" />
            </td>
            <td><input type="button" onclick="batchUpload()" value="批量上传" /></td>
            <td><div id="result" style="margin-left:200px"></div></td>
        </tr>
    </table>

    <!-- 全局js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/script/lib/ajaxfileupload.js"></script>

    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
    <script src="${pageContext.request.contextPath}/script/app-resources/old_man/test.js"></script>
    <script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>


    <!-- Bootstrap table -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
    <script src="${pageContext.request.contextPath}/script/app-resources/old_man/oldManHosing.js"></script>
    <script src="${pageContext.request.contextPath}/script/app-resources/old_man/oldManHealthy.js"></script>
    <script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>
    <script type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
    </script>
</body>
</html>
