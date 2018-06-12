<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>养老院管理</title>

	    <link rel="shortcut icon" href="favicon.ico"> 
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/font-awesome.css?v=4.4.0" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/script/lib/bootstrapvalidator/dist/css/bootstrapValidator.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/script/lib/H+/css/animate.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/style.css?v=4.1.0" rel="stylesheet">
	<script type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
    </script>
	</head>

<body class="gray-bg">


    <div class="panel-body" style="padding-bottom:0px;">

    <div class="panel panel-default">
        <div class="panel-heading">条件查询
            <button type="button" style="margin-left: 780px" id="btn_query" class="btn btn-primary" onclick="queryfNursing();">查询</button>
            <button type="button" style="margin-left: 20px" id="btn_clear" class="btn btn-primary" onclick="clearaSelect();">清空</button>
        </div>

        <div class="panel-body">
            <form id="formSearch" class="form-horizontal">

                <div class="form-group row" style="margin-top:15px">
                    <label class="control-label col-sm-1" for="fNursingName" style="padding-right: 1px;">养老院名称</label>
                    <div class="col-sm-2">
                        <input class="form-control" name="fNursingName" id="fNursingName"style="width: 150px;" />
                    </div>
                    <label class="control-label col-sm-1" for="fLeader">负责人</label>
                    <div class="col-sm-2">
                        <input class="form-control" name="fLeader" id="fLeader"style="width: 150px;" />


                    </div>
                    <label class="control-label col-sm-1" for="fLeaderPhone">手机号</label>
                    <div class="col-sm-2">
                        <input class="form-control" name="fLeaderPhone" id="fLeaderPhone" style="width: 150px;" />

                    </div>

                    <label class="control-label col-sm-1" for="fStatus">是否停用</label>
                    <div class="col-sm-2 ">
                        <select class="form-control" name="fStatus" id="fStatus"style="width: 150px;" >
                             <option value>请选择</option>
                            <option value="1">正常</option>
                            <option value="0">停用</option>

                        </select>
                    </div>
                </div>

            </form>
        </div>

    </div>
	 <div id="toolbar" class="btn-group">

         <button id="btn_add" type="button" class="btn btn-primary" data-toggle="modal" data-target="#addModal" onclick="showfChargeModeID()">
             <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增
         </button>

         <button  type="button" class="btn btn-success"  onclick="gotoUpdate()">
             <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改
         </button>
         <button id="btn_delete" type="button" class="btn btn-default" onclick="gotoDelete()">
             <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>禁用
         </button>
         <button id="btn_start" type="button" class="btn btn-warning" onclick="gotoStart()">
             <span class="glyphicon glyphicon-ok" aria-hidden="true"></span>启用
         </button>
	  </div>



	  <table id="tb_fNursing" ></table>
	</div>
 
	<!-- 控制修改按钮 -->
	<button id="update_btn" type="button" class="btn btn-default notprint " data-toggle="modal" data-target="#updateModal" style="display:none">
	   </button>
	   

    <!-- 全局js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/script/my97DatePicker/WdatePicker.js"></script>

    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
	<script src="${pageContext.request.contextPath}/script/app-resources/sys-optimised/fNursingManage.js"></script>
	<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>
	
    <!-- Bootstrap table -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/lib/bootstrapvalidator/dist/js/bootstrapValidator.js"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
	<script type="text/javascript">
			var contextPath = "${pageContext.request.contextPath}";
	</script>

    <jsp:include  page="fNursingAdd.jsp"/>
    <jsp:include  page="fNursingUpdate.jsp"/>
    <jsp:include  page="../alert.jsp"/>

</body>
</html>
