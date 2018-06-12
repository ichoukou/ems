<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>居家服务订单管理</title>
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
          <button type="button" style="margin-left: 780px" id="btn_query" class="btn btn-primary" onclick="queryOrderBy();">查询</button>                    
           <button type="button" style="margin-left: 20px" id="btn_clear" class="btn btn-primary" onclick="queryclear();">清空</button>
           
        </div>

        <div class="panel-body" style="padding-bottom: 1px;">
            <form id="formSearch" class="form-horizontal;">
                <div class="form-group row" style="height: 50px;width: 1000px;">                                 
                    <label class="control-label col-sm-1" for="serviceOldName">老人姓名</label>
                    <div class="col-sm-2">
                            <input class="form-control" name="serviceOldName" id="serviceOldName" >                   
                    </div>

                    <label class="control-label col-sm-1" for="serviceOldPhone">联系电话</label>
                    <div class="col-sm-2">
                        <input class="form-control" name="serviceOldPhone" id="serviceOldPhone" 
                         onkeyup="value=value.replace(/[^\d]/g,'')"
                        >

                    </div>
                    <label class="control-label col-sm-1" for="serviceOldNumber">工单号</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="fOrderNo" id="serviceOldNumber" >
                            
                        </select>
                    </div>
                    <label class="control-label col-sm-1 " for="serviceStart">工单开始</label>
                     
                         <div class="col-sm-2 ">
                                                                                          
                <input style="width: 166px;" placeholder="点击选择开始时间" onFocus="WdatePicker({readOnly:true,maxDate:'#F{$dp.$D(\'serviceOver\')||\'new Date()\'}'})" type="text" class="form-control" id="serviceStart" name="serviceStart">
                         </div>
                    
                </div>
                <div class="form-group row"  style="height: 50px;width: 1000px;">  
                 <label class="control-label col-sm-1" for="serviceObject">服务对象</label>
                    <div class="col-sm-2">
                     <select class="form-control" name="serviceObject" id="serviceObject" >
                     </select>
                    </div>
                    <label class="control-label col-sm-1" for="serviceUser">服务人员</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="serviceUser" id="serviceUser" >

                        </select>
                    </div>
                    <label class="control-label col-sm-1" for="serviceStatus">处理状态</label>
                    <div class="col-sm-2">
                        <select class="form-control" name="serviceStatus" id="serviceStatus" >
                           
                        </select>
                    </div>
                    <label class="control-label col-sm-1" for="serviceOver">工单结束</label>
                    <div class="col-sm-2">
                        <input style="width: 166px;" placeholder="点击选择结束时间" onFocus="WdatePicker({readOnly:true,minDate:'#F{$dp.$D(\'serviceStart\')}',maxDate:new Date()})" type="text" class="form-control" id="serviceOver" name="serviceOver">

              </div>
                      
                </div>
         
            </form>
        </div>
    </div>
	  <div id="toolbar" class="btn-group ">
	  
	  
	   <button id="btn_add" type="button" class="btn btn-primary " data-toggle="modal" data-target="#addModal" onclick="getService()" >
	    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>新增订单
	   </button>
	   <button  type="button" class="btn btn-warning "  onclick="gotoPrin()">
	    <span class="glyphicon  glyphicon glyphicon-print" aria-hidden="true"></span>打印订单
	   </button>
	   <button  type="button" class="btn btn-success "  onclick="gotoUpdate()">
	    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>修改订单
	   </button>
	    <button  type="button" class="btn btn-danger "  onclick="gotoEval()">
	    <span class="glyphicon glyphicon glyphicon-signal" aria-hidden="true"></span>评价订单
	   </button>
	   <button id="btn_delete" type="button" class="btn btn-default " onclick="gotoDelete()">
	    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>取消订单
	   </button>
	  </div>
	  
	  <table id="tb_OrderManger" ></table>
	</div>
 
	<!-- 控制修改按钮 -->
	<button id="update_btn" type="button" class="btn btn-default notprint " data-toggle="modal" data-target="#updateModal" style="display:none">
	   </button>
	   
	<button id="eval_btn" type="button" class="btn btn-default notprint" data-toggle="modal" data-target="#evalModal" style="display:none">
	   </button>  
	     
 	 <button id="print_btn" type="button" class="btn btn-default notprint" data-toggle="modal" data-target="#printModal" style="display:none">
	   </button>    
	<jsp:include  page="./OrderManageEvaluation.jsp"/>
	<jsp:include  page="./OrderManageAdd.jsp"/>
	<jsp:include  page="./OrderManageUpdate.jsp"/>

    <jsp:include  page="./OrderManagePrint.jsp"/>

	<jsp:include  page="../alert.jsp"/>

    <!-- 全局js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/script/my97DatePicker/WdatePicker.js"></script>

    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
	<script src="${pageContext.request.contextPath}/script/app-resources/OrderManager/orderManager.js"></script>
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
