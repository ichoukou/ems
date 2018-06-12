<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>财务结账</title>

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/bootstrapvalidator/dist/css/bootstrapValidator.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="panel-body" style="padding-bottom:0px;">

    <div class="panel panel-default">
        <div class="panel-heading">查询条件</div>

        <div class="panel-body">
            <form id="jiezhang" class="form-horizontal">
            	<p class="text-center">系统结账后可以选择反结账返回上一期进行处理业务，在进行结账处理</p>
                <div class="form-group" style="margin-top:15px">
                    <label class="control-label col-sm-1"  for="fDate">当期时间</label>
                   <div class="col-sm-2">
                    		<input   type="text"  readonly="readonly" class="form-control" name="fDate" id="fDate">
				</div>
                </div>
    <div id="toolbar" class="btn-group">
         <button  type="button" class="btn btn-info" id="updateButton" data-toggle="modal" data-backdrop="static" onclick="jieZhang()">
            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>结账
        </button>
        <button  type="button" class="btn btn-default" id="transferButton" data-toggle="modal" onclick="balanceBack()">
            <span class="glyphicon glyphicon-pencil" aria-hidden="true" ></span>反结账
        </button>
    </div>
            </form>
        </div>
    </div>
</div>
<!-- 全局js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>

<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>
<script src="${pageContext.request.contextPath}/script/my97DatePicker/WdatePicker.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/fundAccountClose/fundAccountClose.js"></script>


<!-- Bootstrap table -->
<script type="text/javascript">
    var contextPath = "${pageContext.request.contextPath}";
</script>
<jsp:include  page="../alert.jsp"/>
</html>
