<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>物品入库</title>
	
   
	    <link rel="shortcut icon" href="favicon.ico"> 
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/font-awesome.css?v=4.4.0" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/animate.css" rel="stylesheet">
	    <link href="${pageContext.request.contextPath}/script/lib/H+/css/style.css?v=4.1.0" rel="stylesheet">
	<script type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
    </script>
	</head>

<body class="gray-bg">


    <div class="panel-body" style="padding-bottom:0px;">

    <div class="panel panel-default">
        <div class="panel-heading">条件查询</div>

        <div class="panel-body">
            <form id="formSearch" class="form-horizontal">

                <div class="form-group row" style="margin-top:15px">
                    <label class="control-label col-sm-1" for="number">单据编号</label>
                    <div class="col-sm-2">
                        <input class="form-control" name="number" id="number"style="width: 150px;" />
                    </div>

                    <label class="control-label col-sm-1" for="materialName">物品名称</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="materialName" id="materialName"style="width: 150px;" >

                        </select>
                    </div>
                    <label class="control-label col-sm-1" for="standard">规格</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="standard" id="standard" style="width: 150px;" >

                        </select>
                    </div>

                    <label class="control-label col-sm-1" for="storeHouseName">仓库</label>
                    <div class="col-sm-2 ">
                        <select class="form-control" name="storeHouseName" id="storeHouseName"style="width: 150px;" >

                        </select>
                    </div>
                </div>
                <div class="form-group row" style="margin-top:15px" style="margin-top: 10px">
                    <label class="control-label col-sm-1" for="Edate">查询开始</label>
                    <div class="col-sm-2">
                        <input id="Edate" class="form-control" type="text" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'Ldate\')}'})" style="width:150px; "/>
                    </div>

                    <label class="control-label col-sm-1" for="Ldate">结束</label>
                    <div class="col-sm-2" >
                        <input id="Ldate" class="form-control" type="text" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'Edate\')}'})" style="width:150px;" />
                    </div>

                    <div class="col-sm-5" style="text-align:right;" >
                        <button type="button" id="btn_clear" class="btn btn-primary" onclick="clearaSelect()">清空</button>
                        <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary" onclick="queryInStorage();">查询</button>
                    </div>
                </div>
            </form>
        </div>

    </div>
	 <div id="toolbar" class="btn-group">
	  
	  
	   <button id="btn_add" type="button" class="btn btn-primary " data-toggle="modal" data-target="#addModal" onclick="showInStorage()" >
	    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>添加入库单
	   </button>

         <button type="button" class="btn btn-success" onclick="gotoUpdate()">
             <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改入库单
         </button>

         <button id="btn_delete" type="button" class="btn btn-default" onclick="gotoDelete()">
             <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>删除入库单
         </button>
	  </div>



	  <table id="tb_InStorage" ></table>
	</div>
 
	<!-- 控制修改按钮 -->
	<button id="update_btn" type="button" class="btn btn-default notprint " data-toggle="modal" data-target="#updateModal" style="display:none">
	   </button>

    <jsp:include  page="./InStorageAdd.jsp"/>
    <jsp:include  page="./InStorageUpdate.jsp"/>
    <jsp:include  page="./storageInGoodsAdd.jsp"/>
    <jsp:include  page="../alert.jsp"/>

    <!-- 全局js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/script/my97DatePicker/WdatePicker.js"></script>

    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
	<script src="${pageContext.request.contextPath}/script/app-resources/storage-goods/inStoreManage.js"></script>
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
