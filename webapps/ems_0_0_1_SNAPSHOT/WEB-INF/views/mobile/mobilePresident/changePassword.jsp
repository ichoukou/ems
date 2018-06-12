<%@ page import="com.channelsoft.ems.po.UserPo" %>
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
        <link rel="shortcut icon" href="favicon.ico">
        <link href="${pageContext.request.contextPath}/script/lib/H+/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/script/lib/H+/css/font-awesome.css?v=4.4.0" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/script/lib/H+/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/script/lib/H+/css/animate.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/script/lib/H+/css/style.css?v=4.1.0" rel="stylesheet">
    <%--<!-- 引入 jQuery Mobile 样式 -->--%>
        <%--<link rel="stylesheet" href="http://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.css">--%>

        <%--<!-- 引入 jQuery 库 -->--%>
        <%--<script src="http://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>--%>

        <%--<!-- 引入 jQuery Mobile 库 -->--%>
        <%--<script src="http://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>--%>

    </head>
    <title>博爱养老</title>
</head>
<body>
<div data-role="page">
    <div data-role="header">
        <a href="#" class="ui-btn ui-shadow ui-corner-all ui-icon-back ui-btn-icon-notext" data-rel="back"></a>
        <h1>登录人：<%=((UserPo)request.getSession().getAttribute("mobileUser")).getName()%></h1>
    </div>
    <div>
        <div data-role="main" class="ui-content">
            <form method="post" id="mobileChangePass" action="${pageContext.request.contextPath}/mobile/CheckPass.do" >
                <label style="color: red"> <%=request.getSession().getAttribute("dmsg")==null?"":request.getSession().getAttribute("dmsg")%></label>
                <div class="ui-field-contain">
                    <label for="oldPassword" class=" control-label">原密码:</label>
                    <input type="password" class="form-control" name="oldPassword" id="oldPassword" required>
                    <label for="passWord" class=" control-label">新密码</label>
                    <input type="password" class="form-control" name="passWord" id="passWord" required>

                </div>
                <div style="height: 30px;text-align:center;"  >
                    <input type="submit" data-inline="true" value="修改密码">
                </div>
            </form>
        </div>
    </div>
    <div data-role="footer"  data-position="fixed">
            <div data-role="navbar" >
                <ul>
                    <li><a href="${pageContext.request.contextPath}/mobilePresident/allHomeView.do"  class="ui-btn ui-icon-bars ui-btn-icon-top">全院一览</a></li>
                    <li><a href="${pageContext.request.contextPath}/mobilePresident/presidentDaily.do"   class="ui-btn ui-icon-bullets ui-btn-icon-top">院长日报</a></li>
                    <li><a href="${pageContext.request.contextPath}/mobilePresident/presidentMonthly.do"  class="ui-btn ui-icon-calendar ui-btn-icon-top">院长月报</a></li>
                    <li><a href="${pageContext.request.contextPath}/mobilePresident/changePassword.do"  class="ui-btn ui-icon-user ui-btn-icon-top">我</a></li>
                </ul>
            </div>
    </div>

</div>

</body>
</html>