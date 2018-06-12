<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>养老管理系统</title>


    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <link rel="shortcut icon" href="favicon.ico">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/bootstrapvalidator/dist/css/bootstrapValidator.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/style.css?v=4.1.0" rel="stylesheet">
    <style type="text/css">
        body {
            margin: 0;
            padding: 0;
            background: url(${pageContext.request.contextPath}/img/bg1.jpg) center top ;


        }

        .main {
            width: 1000px;
            margin: 0 auto;
        }

        .div01 {
            width: 513px;
            margin-top: 200px;
            float: left;
            margin-right: 27px;
        }

        .div02 {
            width: 460px;
            float: left;
        }
        .logo{ width:460px; clear:both; margin-top:160px}


        .div03 {
            width: 460px;
            margin-top: 10px;
            clear: both;
        }

        .login {
            width: 370px;
            height: 310px;
            float: left;
            background-color: #81BDD8;
            padding-top: 30px;
            padding-left: 20px;
            padding-right: 0px;
        }

        .trai {
            width: 31px;
            height: 249px;
            float: left;
            background: url(${pageContext.request.contextPath}/img/triangle.png) -2px -8px no-repeat;

        }

        .tanchu {
            width: 500px;
            height: 214px;
            position: relative;
            left: 29px;
            top: 15px;
            background-color: #ad1703;
        }

        .yh {
            width: 100%;
            height: 27px;
            line-height: 27px;
            clear: both;
            padding-bottom: 15px;
            color: #fff;
            font-size: 16px;
            font-family: "微软雅黑";
            clear: both;
        }

        .yh input {
            width: 238px;
            height: 27px;
            background-color: #fff;
            border: none;
            padding-left: 3px;
            font-size: 16px;
            font-weight: bold;
            font-family: "微软雅黑";
            color: #666;
        }
        .yh select{
            width: 238px;
            height: 27px;
            background-color: #fff;
            border: none;
            padding-left: 3px;
            font-size: 16px;
            font-weight: bold;
            font-family: "微软雅黑";
            color: #666;
        }

        .btn {

            width: 304px;
            height: 42px;
            line-height: 35px;
            background-color: #D31619;
            text-align: center;
            margin-top: 10px;
            margin-left: 20px;
            font-size: 20px;
            font-family: "微软雅黑";
            color: #fff;
            border: none;
            cursor: pointer;


        }
    </style>
    <script type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
    </script>
    <script>
        if(window.top!==window.self){window.top.location=window.location};
    </script>


</head>

<body class="dl-con" style="color: #0e0e0e">


<form method="post" action="${pageContext.request.contextPath}/login/index.do" method="post">

    <div class="main">
        <div class="div01">
            <img src="${pageContext.request.contextPath}/img/login.jpg" width="513" style="height: 293px;"></div>
        <div class="div02">
                <div class="logo" style="margin-top: 10px;">
                <img src="${pageContext.request.contextPath}/img/LOGO.jpg" width="362" style="height: 200px;"></div>
                <div class=" div03">
                <div class="login">
                <%-- <div class="form-group row">

                        <label for="txtOldHouse" class=" control-label" style="margin-left: 20px;">养 老 院：</label>
                        <span class=" control-label" id="txtOldHouse_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>

                     <div>
                            <select type="text"  class=" form-control" id="txtOldHouse"  name="txtOldHouse" style=" width: 302px;margin-left: 20px;"  class="form-control"></select>
                        </div>
                    </div>--%>

                    <div class="form-group row">
                        <label for="txtUserName" class=" control-label" style="margin-left: 20px;">用 户 名：</label>
                        <span class=" control-label" id="txtUserName_message"   style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;<%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %></span>

                        <div>
                        <input onblur="txtUserName_check()" type="text" id="txtUserName" name="uname"   style="width:302px;margin-left: 20px;" class="form-control">
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="txtUserPass" class=" control-label" style="margin-left: 20px;">  密  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
                        <span class=" control-label" id="txtUserPass_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</span>
                        <div>
                            <input onblur="txtUserPass_check()" name="passWord"  type="password"  id="txtUserPass" style=" width: 302px;margin-left: 20px;" class="form-control">
                         </div>
                    </div>

                    <div class="form-group row">
                        <button type="submit" class="btn"  onclick="return check(this.form)">登录</button>

                    </div>

            </div>
                    </div>
                <div class=" trai">
                    <div class="tanchu"></div>
                </div>
               </div>
        </div>
    </div>

</form>

<!-- 全局js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>

<!-- 自定义js -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/content.js?v=1.0.0"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/sys-optimised/loginManage.js"></script>
<script src="${pageContext.request.contextPath}/script/app-resources/common/alert.js"></script>

<!-- Bootstrap table -->
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/bootstrapvalidator/dist/js/bootstrapValidator.js"></script>
<script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>



</body>

</html>
