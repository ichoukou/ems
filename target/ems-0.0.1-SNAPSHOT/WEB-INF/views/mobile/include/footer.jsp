<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2017/3/15
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div data-role="navbar" >
        <ul>
            <li><a href="#myPopup" data-rel="popup">房间</a></li>
            <%--<li><a href="#myPopup" id="demo" data-rel="popup" class="ui-btn ui-icon-home ui-btn-icon-left" data-position-to="#demo">房间</a></li>--%>
            <li><a href="#" data-rel="" class="ui-btn ui-icon-home ui-btn-icon-left">老人</a></li>
            <li><a href="${pageContext.request.contextPath}/staff/staffMessage.do" class="ui-btn ui-icon-mail ui-btn-icon-left">通知</a></li>
            <li><a href="${pageContext.request.contextPath}/staff/staffMine.do"  class="ui-btn ui-icon-user ui-btn-icon-left">我</a></li>
        </ul>
        <div data-role="popup" id="myPopup" class="ui-content">
        <%--<div data-role="popup" id="myPopup" class="ui-content" data-arrow="b">--%>
            <a href='${pageContext.request.contextPath}/staff/staffServiceHome.do' class='ui-btn' rel="external">我服务的房间</a>
            <a href='${pageContext.request.contextPath}/staff/allHome.do' class='ui-btn' rel="external">全院的房间</a>
        </div>
    </div>
</body>
</html>
