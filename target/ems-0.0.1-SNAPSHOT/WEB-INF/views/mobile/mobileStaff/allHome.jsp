<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2017/3/19
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%--<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">--%>
<html>
<head>
    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>
    <!-- meta使用viewport以确保页面可自由缩放 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 引入 jQuery Mobile 样式 -->
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/jquery.mobile-1.4.5.min.css" rel="stylesheet">
</head>
<title>员工护理房间</title>
<body>
<div data-role="page" id="allHome">

    <!-- 引入 jQuery 库 -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
    <!-- 引入 jQuery Mobile 库 -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.mobile-1.4.5.min.js"></script>
    <script type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
    </script>
    <script src="${pageContext.request.contextPath}/script/app-resources/mobile/staff.js"></script>

    <div data-role="header">
        <a href="#" class="ui-btn ui-shadow ui-corner-all ui-icon-back" data-rel="back">返回</a>
        <h1>全院的房间</h1>
        <a href="${pageContext.request.contextPath}/mobile/quit.do" class="ui-btn-right ui-btn ui-corner-all">退出</a>
    </div>

    <div data-role="main" class="ui-content">
        <table id="test" align="center">
            <tr><th>房间卫生</th><th>个人护理</th></tr>
                <c:forEach var="i" begin="0" end="${allRoomCleanStateList.size()}" step ="1">
                    <c:forEach var="j" begin="0" end="${allRoomCleanStateList[i].size()-1}" step ="1">
                        <tr>
                            <td><a href='staffHomeDetail.do?froomID=${allRoomCleanStateList[i][j].fID}' data-theme="d" data-role='button' rel="external">${allRoomCleanStateList[i][j].fRoomName}${allRoomCleanStateList[i][j].fstatus}</a></td>
                            <td><input type="button" value="${allRoomCleanStateList[i][j].fRoomName}" onclick=""></td>
                        </tr>
                    </c:forEach>
                </c:forEach>

        </table>
    </div>

    <div data-role="footer"  data-position="fixed">
        <jsp:include page="../include/footer.jsp"></jsp:include>
    </div>
</div>
</body>
</html>
