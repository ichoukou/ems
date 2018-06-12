<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<html>
<head>
	<%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
	<!-- meta使用viewport以确保页面可自由缩放 -->
	<%--<meta name="viewport" content="width=device-width, initial-scale=1">--%>
	<!-- 引入 jQuery Mobile 样式 -->
	<link href="${pageContext.request.contextPath}/script/lib/H+/css/jquery.mobile-1.4.5.min.css" rel="stylesheet">
	<!-- 引入 jQuery 库 -->
	<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js"></script>
	<!-- 引入 jQuery Mobile 库 -->
	<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.mobile-1.4.5.min.js"></script>
</head>
<title>博爱养老</title>
<body>
<div data-role="page" id="login">
	<div data-role="header">
	    <h1>欢迎来到博爱养老院</h1>
	</div>

	<div data-role="content">
	    <form method="post" action="${pageContext.request.contextPath}/mobile/index.do" data-ajax="false">
			<label style="color: red">${sessionScope.get("msg")}</label>
			<div>
				<label for="roleName">角色:</label>
				<select type="text" id="roleName" name="roleName" placeholder="">
					<option value="护理">护理员</option>
					<option value="院长">院长</option>
					<%--<option value="家属">家属</option>--%>
					<%--<option value="老人">老人</option>--%>
				</select>
				<label for="uname">用户名:</label>
				<input type="text" name="uname" id="uname" placeholder="用户名" required>
				<label for="passWord">密码:</label>
				<input type="password" name="passWord" id="passWord" placeholder="密码" required>
			</div>
			<div style="height: 30px;text-align:center;"  >
				<input type="submit" data-inline="true" value="登录">
			</div>
	    </form>
	</div>
</div>
</body>
</html>