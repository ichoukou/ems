<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2016/12/1
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>收费标准</title>

    <link rel="shortcut icon" href="favicon.ico">
    <script type="text/javascript">
        var contextPath = "${pageContext.request.contextPath}";
    </script>
</head>

<body class="gray-bg">
<div class="panel-body" style="padding-bottom:0px;">

    <div class="panel panel-default">
        <%--<div class="panel-heading">查询条件</div>--%>

        <div class="panel-body">
            <form id="formSearch" class="form-horizontal">
                <div class="form-group">

                    <label class="control-label col-sm-1">费用名称</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="searchName">
                    </div>

                    <label class="control-label col-sm-1">费用类别</label>
                    <div class="col-sm-2">
                        <select class="form-control" id="searchType">


                        </select>
                        <%--<input type="text" class="form-control" id="searchType">--%>
                    </div>

                    <div class="col-sm-3" style="text-align:right;">
                        <button type="button" style="margin-left:50px" id="btn_query" class="btn btn-primary" onclick="queryStandard();">查询</button>
                        <button type="button" style="margin-left:50px" class="btn btn-primary" onclick="queryClear();">清空</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <table id="tb_chargeStandard"></table>

</div>


<script src="${pageContext.request.contextPath}/script/app-resources/expenses/chargeStandard.js"></script>

</body>
</html>
