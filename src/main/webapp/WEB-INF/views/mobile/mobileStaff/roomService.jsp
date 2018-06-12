<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2017/3/7
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- meta使用viewport以确保页面可自由缩放 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 引入 jQuery Mobile 样式 -->
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/jquery.mobile-1.4.5.min.css" rel="stylesheet">
    <title>按房间服务</title>
</head>
<body>
    <div data-role="page" id="roomService">
        <!-- 引入 jQuery 库 -->
        <script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js"></script>
        <!-- 引入 jQuery Mobile 库 -->
        <script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.mobile-1.4.5.min.js"></script>

        <script type="text/javascript">
            var contextPath = "${pageContext.request.contextPath}";
        </script>
        <script src="${pageContext.request.contextPath}/script/app-resources/mobile/staff.js"></script>


    <div data-role="header">
        <a href="#" class="ui-btn ui-shadow ui-corner-all ui-icon-back" data-rel="back">返回</a>
        <h1>XXX房间卫生</h1>
        <a href="${pageContext.request.contextPath}/mobile/quit.do" class="ui-btn-right ui-btn ui-corner-all">退出</a>
    </div>

    <div data-role="content">

        <ul data-role="listview" data-inset="true">
            <table id="roomClean" align="center">
                <div data-role="controlgroup" data-type="horizontal" style="text-align:center">
                    <a href="#" data-role="button" id="btn2">执行选中</a>
                    <a href="#" data-role="button" id="btn3">取消执行</a>
                </div>
                <tr><th style="width: 30px"><input type="checkbox" id="checkAll"></th><th>服务项目</th><th>实际数</th><th>计划数</th></tr>
                <c:forEach var="i" begin="0" end="${list.size()-1}" step ="1">
                    <tr>
                        <fieldset data-role="controlgroup">
                            <td><input type="checkbox" id="checkbox-${i}" value="${list[i].fID}" name="item" class="checkbox"></td>
                            <td><input type="button" value="${list[i].fname}"></td>
                            <td><input type="button" id="fexcludcount-${i}" value="${list[i].fexcludcount}"></td>
                            <td><input type="button" id="fplancount-${i}" value="${list[i].fplancount}"></td>
                        </fieldset>
                    </tr>
                </c:forEach>
            </table>
        </ul>
    </div>

    <div data-role="footer" data-position="fixed">
        <jsp:include page="../include/footer.jsp"></jsp:include>
    </div>
</div>
    <script type="text/javascript">
        //先解绑，再绑定
        $('#btn2').unbind().bind('click', function() {
            var arr=new Array();
            var flag=true;
            $.each($(".checkbox:checked"),function(j,n){
                arr[j]=n.value;
                var fexcludcount=$("#fexcludcount-"+[j]+"").val();
                var fplancount=$("#fplancount-"+[j]+"").val();

                if(fexcludcount>=fplancount){
                    flag=false;
                }
            });
            if(flag){
                $.ajax({
                    url: contextPath + "/staff/staffHomeDetailPerform.do",
                    type: "post",
                    async:false,
//                traditional 为true阻止深度序列化,传递参数为数组
                    traditional: true,
                    data: {
                        arrData:arr
                    },
                    success: function (data) {
                        //执行成功后页面刷新
                        location.reload([true])
                    }
                });
            }else{
                alert("服务已完成")
            }
        });
        //on直接绑定
        $('#btn3').on('click', function() {
            var arr=new Array();
            $.each($(".checkbox:checked"),function(j,n){
                arr[j]=n.value;
            });
            $.ajax({
                url: contextPath + "/staff/staffHomeDetailCancelPerform.do",
                type: "post",
                async:false,
//                traditional 为true阻止深度序列化,传递参数为数组
                traditional: true,
                data: {
                    arrData:arr
                },
                success: function (data) {
                    //执行成功后页面刷新
                    location.reload([true])
                }
            });
        });


        $("#checkAll").click(function () {
            var items = $(':checkbox[name=item]');
            if ($("#checkAll").is(':checked')) {
//                $("input[type='checkbox']").attr("checked",true).checkboxradio("refresh");
//                $("input[type='checkbox']").prop('checked').checkboxradio("refresh");
//                $('input[type="checkbox"]').attr('data-cacheval','false');
                items.each(function () {
                    $(this).prop('checked', true);
                })
            } else {
//                $("input[type='checkbox']").attr("checked",false).checkboxradio("refresh");
//                $("input[type='checkbox']").prop('checked', false).checkboxradio("refresh");
//                $('input[type="checkbox"]').attr('data-cacheval','true');
                items.each(function () {
                    $(this).prop('checked', false);
                })
            }
        });

    </script>
</body>
</html>
