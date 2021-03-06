<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>

<!-- meta使用viewport以确保页面可自由缩放 -->
<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- 引入 jQuery Mobile 样式 -->
	<link href="${pageContext.request.contextPath}/script/lib/H+/css/jquery.mobile-1.4.5.min.css" rel="stylesheet">

	<!-- 引入 jQuery 库 -->
	<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js"></script>

	<!-- 引入 jQuery Mobile 库 -->
	<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.mobile-1.4.5.min.js"></script>

<%--<!-- 引入 jQuery Mobile 样式 -->--%>
<%--<link rel="stylesheet" href="http://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.css">--%>

<%--<!-- 引入 jQuery 库 -->--%>
<%--<script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>--%>

<%--<!-- 引入 jQuery Mobile 库 -->--%>
<%--<script src="http://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>--%>

	<style>
		th {
			border-bottom: 1px solid #d6d6d6;
		}
		tr:nth-child(even) {
			background: #e9e9e9;
		}
	</style>
</head>
<title>博爱养老</title>
</head>
<body>
<div data-role="page">
	<div data-role="header">
	    <h1>AAA的任务版</h1>
	</div>
	<div data-role="main" class="ui-content">
		  <table data-role="table" data-mode="columntoggle" class="ui-responsive ui-shadow" id="myTable">
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
		  </table>
	  </div>
	<div data-role="footer"  data-position="fixed">
		<div data-role="navbar" >
		<ul>
			<li><a href="${pageContext.request.contextPath}/staff/StaffHome.do" class="ui-btn ui-icon-home ui-btn-icon-left">房间</a></li>
			<li><a href="${pageContext.request.contextPath}/staff/StaffOldMan.do" class="ui-btn ui-icon-user ui-btn-icon-left">老人</a></li>
			<li><a href="${pageContext.request.contextPath}/staff/StaffMessage.do" class="ui-btn ui-icon-mail ui-btn-icon-left">通知</a></li>
			<li><a href="${pageContext.request.contextPath}/mobilePresident/changePassword.do"  class="ui-btn ui-icon-user ui-btn-icon-left">我</a></li>
		</ul>
		</div>
	</div>
</div>
</body>
</html>