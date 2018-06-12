<%@ page import="java.util.List" %>
<%@ page import="com.channelsoft.ems.po.MessagePo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>个人资料</title>
    <style>
        .modal-body .row label {
            line-height: 30px;
        }
        .row {
            margin-bottom: 5px;
        }
    </style>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/bootstrapvalidator/dist/css/bootstrapValidator.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg">


<form id="form_validate_update" class="form-horizontal notprint">
        <div class="modal-dialog" >

            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="myModalLabel">更改密码  <span class=" control-label" id="txtUpdatePass_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                    </h4>
                </div>
                <div class="modal-body" style="height: 550px;">
                    <div class="popover-content" style="width: 1000px;">
                        <div class="form-group row">

                            <label for="addOldPass" class="col-sm-2 control-label">请输入原密码</label>
                            <div class="col-sm-3">
                                <input type="password" class="form-control" id="addOldPass"  name="addOldPass"  placeholder="必填项"><%-- --%>
                            </div>




                        </div>

                        <div class="form-group row">


                            <label for="addNewPass" class="col-sm-2 control-label">输入新密码</label>
                            <div class="col-sm-3">
                                <input type="password" class="form-control" id="addNewPass"  name="addNewPass"  placeholder="必填项"><%-- --%>
                            </div>




                        </div>


                        <div class="form-group row">

                            <div class="col-sm-2"></div>

                            <div class="col-sm-3">
                                <button type="submit" type="button" class="btn btn-primary" >更改密码</button>
                            </div>




                        </div>





                    </div>
                </div>
            </div>

        </div>
</form>



<!-- 全局js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/sys-optimised/index.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>

<!-- Bootstrap table -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/bootstrapvalidator/dist/js/bootstrapValidator.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}";

</script>

</body>
</html>
