<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>仓库管理</title>
	<style type="text/css" media="print"> 
       .notprint {visibility:hidden}
     </style> 
   
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

	<div class="panel-body notprint" style="padding-bottom:0px;">
     
    <!-- 模糊查询 -->
    <div class="panel panel-default ">
        <div class="panel-heading">查询条件                 

        </div>

        <div class="panel-body" style="padding-bottom: 1px;">
            <form id="formSearch" class="form-horizontal;">
      
                <div class="form-group row"  style="height: 50px;width: 1000px;">  
                 <label class="control-label col-sm-1" for="searchfStoreHouseName">仓库名称</label>
                    <div class="col-sm-2">
                     <input class="form-control" type="text"  name="fStoreHouseName" id="searchfStoreHouseName" >
                     
                    </div>
                    <label class="control-label col-sm-1" for="searchfStoremanName">负责人</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="fStoremanName" id="searchfStoremanName" >
                         </select>  
                        
                    </div>
                    
                    <label class="control-label col-sm-1" for="searchfTel">联系电话</label>
                    <div class="col-sm-2">
                        <input  class="form-control" onkeyup="value=value.replace(/[^\d]/g,'')" type="text" name="fTel" id="searchfTel" >            
                    </div>
             
              
                 <div class="col-sm-3">
                 <button type="button" style="margin-left: 20px" id="btn_query" class="btn btn-primary" onclick="getSearch();">查询</button>                    
                 <button type="button" style="margin-left: 20px" id="btn_clear" class="btn btn-primary" onclick="queryclear();">清空</button>
                    
                 </div> 
                </div>
         
            </form>
        </div>
    </div>
	  <div id="toolbar" class="btn-group ">
	  
	  
	   <button id="btn_add" type="button" class="btn btn-primary " data-toggle="modal" data-target="#addModal" onclick="showStarff()" >
	    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增仓库
	   </button>
	 
	   <button  type="button" class="btn btn-success "  onclick="gotoUpdate()">
	    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改仓库
	   </button>
	  
	  
	  </div>
	  
	  <table id="tb_StoreHome" ></table>
	</div>
 
	<!-- 控制修改按钮 -->
	<button id="update_btn" type="button" class="btn btn-default notprint " data-toggle="modal" data-target="#updateModal" style="display:none">
	   </button>
	   
	
	<jsp:include  page="./StoreHomeAdd.jsp"/>
	<jsp:include  page="./StoreHomeUpdate.jsp"/>
	<jsp:include  page="../alert.jsp"/>

    <!-- 全局js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/script/my97DatePicker/WdatePicker.js"></script>

    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
	<script src="${pageContext.request.contextPath}/script/app-resources/storage-goods/storeHomeManager.js"></script>
	<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>
	
    <!-- Bootstrap table -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
	<script type="text/javascript">
			var contextPath = "${pageContext.request.contextPath}";
	</script>
</p> 
</body>
</html>
