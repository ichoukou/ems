<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2016/12/22
  Time: 17:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>费用信息</title>
    <!-- 全局js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/script/lib/bootstrap-multiselect/dist/js/bootstrap-multiselect.js"></script>
    <%--<script>--%>
        <%--$('#pre-selected-options').multiSelect();--%>
    <%--</script>--%>
    <script type="text/javascript">

    </script>
</head>

<body>
    <div id="">
        <input id="oldManChargeId" type="hidden">

        <div class="col-xs-5">
            <div style="text-align: center;font-size: 20px;">待选费用</div>
            <select name="from" id="undo_redo" class="form-control" size="13"
                    multiple="multiple">

            </select>
        </div>

        <div class="col-xs-2" style="padding-top: 60px;">

            <button type="hidden" id="undo_redo_rightAll"
                    class="btn btn-default btn-block">
                <i class="glyphicon glyphicon-forward"></i>
            </button>
            <button type="button" id="undo_redo_rightSelected"
                    class="btn btn-default btn-block">
                <i class="glyphicon glyphicon-chevron-right"></i>
            </button>
            <button type="button" id="undo_redo_leftSelected"
                    class="btn btn-default btn-block">
                <i class="glyphicon glyphicon-chevron-left"></i>
            </button>
            <button type="hidden" id="undo_redo_leftAll"
                    class="btn btn-default btn-block">
                <i class="glyphicon glyphicon-backward"></i>
            </button>

        </div>

        <div class="col-xs-5">
            <div style="text-align: center;font-size: 20px;">已选费用</div>
            <select name="to" id="undo_redo_to" class="form-control"
                    size="13" multiple="multiple"></select>
        </div>

        <div class="col-xs-2">
        </div>
        <div class="col-xs-2">
            <button class="btn btn-warning btn-block" id="b2" onclick="updChargeStatus(this.value,false)" value="0">停止已选费用</button>
        </div>

        <div class="col-xs-4">
            总费用：<input type="text" id="totalCost">
        </div>

        <div class="col-xs-2">
            <button class="btn btn-primary btn-block" id="b1" onclick="updChargeStatus(this.value,true)" value="1">保存已选费用</button>
        </div>
    </div>
</body>

</html>
