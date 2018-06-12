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

    </head>
    <title>博爱养老</title>
</head>
<body>
<div data-role="page">
    <div data-role="header">
        <a href="#" class="ui-btn ui-shadow ui-corner-all ui-icon-back ui-btn-icon-notext" data-rel="back"></a>
        <h1>院长月报</h1>
    </div>
    <div>
        <div data-role="main" class="ui-content">
            <h2 align="center">博爱养老机构</h2>
            <div data-role="collapsible">
                <h1>2月份收支情况</h1>
                <table  class="ui-responsive" id="myTable1" align="center" style="width: 100%;text-align: center">
                    <tr>
                        <td>收入</td>
                        <td>支出</td>
                        <td>收支差额</td>
                    </tr>
                    <tr>
                        <td>100</td>
                        <td>50</td>
                        <td>50%</td>
                    </tr>
                </table>	  </div>
            <div data-role="collapsible">
                <h1>2月份员工情况</h1>
                <table class="ui-responsive" id="myTable2" align="center" style="width: 100%;text-align: center">

                    <tr>
                        <td>入职员工</td>
                        <td>离职员工</td>
                        <td>请假员工</td>
                    </tr>
                    <tr>
                        <td>50</td>
                        <td>50</td>
                        <td>50</td>
                    </tr>
                </table>	  </div>
            <div data-role="collapsible">
                <h1>老人情况</h1>

                <table  class="ui-responsive" id="myTable3" align="center" style="width: 100%;text-align: center">

                    <tr>
                        <td>入院</td>
                        <td>出院</td>
                        <td>死亡</td>
                        <td>请假</td>
                        <td>总人数</td>

                    </tr>
                    <tr>
                        <td>50</td>
                        <td>50</td>
                        <td>50</td>
                        <td>50</td>
                        <td>50</td>
                    </tr>
                </table>
            </div>
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