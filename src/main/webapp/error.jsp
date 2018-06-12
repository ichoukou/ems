<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>错误界面</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/app-resource/css/common/bootstrap-3.3.0.min.css">
<style type="text/css">
	body {
		font-family: Microsoft Yahei;
		padding: 10px;
	}
</style>
</head>
<body>

	<div class="alert alert-danger text-center" style="padding: 10px;">
		<span class="glyphicon glyphicon-exclamation-sign"></span> 操作失败，请联系技术人员！
	</div>

</body>
</html>