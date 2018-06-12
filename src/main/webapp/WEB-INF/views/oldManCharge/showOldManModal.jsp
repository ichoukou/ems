<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2017/1/4
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page language="java" import="java.util.*" pageEncoding="utf-8"--%>
         <%--isELIgnored="false"%>--%>
<%--<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>--%>

<%--<body>--%>
<%--<div class="panel-body" style="padding-bottom: 0px;" id="chooseOldMan">--%>
    <%--<form id="formSearchOldMan" class="form-horizontal">--%>
        <%--<div class="modal fade" id="oldManModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"--%>
             <%--aria-hidden="true"--%>
             <%--style="margin-bottom: 10px;">--%>
            <%--<!-- 1查询条件 -->--%>
            <%--<div class="input-group" style="margin-left: 0px;margin-top: 0px;">--%>
                <%--<div class="input-group-addon">老人姓名</div>--%>
                <%--<input class="form-control input-sm" id="searchFOldManName" name="searchFOldManName" />--%>
            <%--</div>--%>

            <%--<!-- 2查询条件 -->--%>
            <%--<div class="input-group" style="margin-top: 0px;">--%>
                <%--<div class="input-group-addon">房间</div>--%>
                <%--<input class="form-control input-sm" id="searchFroom" name="searchFroom" />--%>
            <%--</div>--%>

            <%--<!-- 3查询条件 -->--%>
            <%--<div class="input-group" style="margin-top: 0px;">--%>
                <%--<div class="input-group-addon">老人编号</div>--%>
                <%--<input class="form-control input-sm" id="searchFOldManNumber" name="searchFOldManNumber" />--%>
            <%--</div>--%>

            <%--<!-- 4查询条件 -->--%>
            <%--<div class="input-group" style="margin-top: 0px;">--%>
                <%--<div class="input-group-addon">状态</div>--%>
                <%--<select class="form-control input-sm" id="searchFoldManStatusID" name="searchFoldManStatusID">--%>

                <%--</select>--%>
            <%--</div>--%>

            <%--<!-- 操作按钮2 -->--%>
            <%--<div class="form-group" style="margin-left: 0px;">--%>
                <%--<button type="button" class="btn btn-default btn-sm"--%>
                        <%--onclick="resetSearchOldMan()">清空</button>--%>
                <%--<button type="button" class="btn btn-primary btn-sm"--%>
                        <%--onclick="queryOldMan()">搜索</button>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</form>--%>

    <%--<table id="tb_chooseOldMan"></table>--%>
<%--</div>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="showOldManModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="width:1057px;">
            <div class="modal-content" style="height: 500px;">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <%--<h4 class="modal-title" id="myModalLabel">选择老人</h4>--%>

                    <div class="form-group row">
                        <label style="margin-top: 5px">老人姓名</label>
                        <input class="form-control" style="width: 160px;display: inline-block" type="text" id="searchFOldManName_chargeList">

                        <label style="margin-top: 5px">房间</label>
                        <select class="form-control" style="width: 160px;display: inline-block" type="text" id="searchFroom_chargeList">

                        </select>

                        <label style="margin-top: 5px">状态</label>
                        <select class="form-control" style="width: 160px;display: inline-block" id="searchFoldManStatusID_chargeList">

                        </select>
                        <button class="btn btn-primary" onclick="queryOldMan_chargeList()">搜索</button>
                        <button class="btn btn-primary" onclick="resetSearchOldMan_chargeList()">清空</button>
                    </div>
                </div>
                <table id="tb_chooseOldMan_chargeList"></table>
                <%--<div id="myDiv" class="modal-body" style="display: inline-block;background: #f4f4f4">--%>



                <%--</div>--%>
            </div>
        </div>

    </div>
</form>
