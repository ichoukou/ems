<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- meta使用viewport以确保页面可自由缩放 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- 引入 jQuery Mobile 样式 -->
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/jquery.mobile-1.4.5.min.css" rel="stylesheet">

	<link
	href="${pageContext.request.contextPath}/script/lib/H+/css/bootstrap.min.css?v=3.3.6"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/script/lib/H+/css/font-awesome.css?v=4.4.0"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/script/lib/H+/css/plugins/bootstrap-table/bootstrap-table.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/script/lib/H+/css/animate.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/script/lib/H+/css/style.css?v=4.1.0"
	rel="stylesheet">
</head>
<title>博爱养老</title>
<body>
<div data-role="page" id="staffMessage">

    <!-- 引入 jQuery 库 -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js"></script>
    <!-- 引入 jQuery Mobile 库 -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.mobile-1.4.5.min.js"></script>

    <div data-role="header">
        <a href="#" class="ui-btn ui-shadow ui-corner-all ui-icon-back" data-rel="back">返回</a>
        <h1>今日通知</h1>
        <a href="${pageContext.request.contextPath}/mobile/quit.do" class="ui-btn-right ui-btn ui-corner-all">退出</a>
    </div>

    <div data-role="content">
<!--         <table data-role="table"  data-column-btn-text="点我显示或隐藏列!" class="ui-responsive ui-shadow" id="myTable">
            <thead>
                <tr>
                    <th>任务ID</th>
                    <th data-priority="2">名称</th>
                    <th data-priority="1">数量</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>1</td>
                    <td>今日任务数量</td>
                    <td>100</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>已完成任务数量</td>
                    <td>50</td>

                </tr>
                <tr>
                    <td>3</td>
                    <td>未完成任务数量</td>
                    <td>50</td>
                </tr>
            </tbody>
        </table> -->
        
        
        <table id="tb_todayCheckOldman" data-role="table" ></table>
    </div>
    <div data-role="footer"  data-position="fixed">
        <jsp:include page="../include/footer.jsp"></jsp:include>
    </div>
</div>

	<!-- 全局js -->
	<script
		src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
	<script
		src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>
	<script
		src="${pageContext.request.contextPath}/script/my97DatePicker/WdatePicker.js"></script>

	<!-- 自定义js -->
	<script
		src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
	<script
		src="${pageContext.request.contextPath}/script/app-resources/mobile/staffMessage.js"></script>

	<!-- Bootstrap table -->
	<script
		src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

	<script type="text/javascript">
		var contextPath = "${pageContext.request.contextPath}";
	</script>
</body>
</html>