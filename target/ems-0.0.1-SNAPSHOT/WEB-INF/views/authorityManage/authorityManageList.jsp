<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>权限管理</title>
	
	    <link rel="shortcut icon" href="favicon.ico"> 
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/font-awesome.css?v=4.4.0" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/animate.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/style.css?v=4.1.0" rel="stylesheet">
	</head>

<body class="gray-bg">
	<div class="panel-body" style="padding-bottom:0px;">
   
    
        <div class="form-group">         
         <label for="role_meun" style="width: 100px;">请选择一个角色:</label>
         <select style="width:130px;height: 34px;font-weight: bold" id="role_meun">
                                               
                            </select>                   
      </div>
	  <div id="toolbar" class="btn-group">
	    <button id="btn_add" type="button" class="btn btn-success" data-toggle="modal" data-target="#addModal" >
	    <span  aria-hidden="true"></span>分配权限
	   </button>
	  </div>
	
	  
	  <table id="tb_authorityManage"></table>
	</div>
 
	<!-- 控制修改按钮 -->
	<button id="update_btn" type="button" class="btn btn-default" data-toggle="modal" data-target="#updateModal" style="display:none">
	   </button>

	<jsp:include  page="../alert.jsp"/>

    <!-- 全局js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>

    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
	<script src="${pageContext.request.contextPath}/script/app-resources/roleBasedAccess/authorityManage.js"></script>
	<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>
	
    <!-- Bootstrap table -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
	<script type="text/javascript">
			var contextPath = "${pageContext.request.contextPath}";
	</script>

</body>
</html>
