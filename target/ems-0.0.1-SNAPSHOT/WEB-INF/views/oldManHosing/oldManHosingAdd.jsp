<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2016/12/15
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="addModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">

        <div class="modal-dialog" style="width: 100%">
            <div class="modal-content" style="height: 580px">

                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">老人入住新增</h4>
                </div>

                <div class="modal-body">

                    <ul id="myTab" class="nav nav-pills" role="tablist">
                        <li class="active">
                            <a href="#base" data-toggle="tab">老人基本信息</a>
                        </li>
                        <%--<li> &lt;%&ndash;onclick="close_tab()"&ndash;%&gt;--%>
                            <%--<a href="#charge" onclick="close_tab()">费用信息</a>--%>
                        <%--</li>--%>
                        <!-- <li>
                            <a href="#health" data-toggle="tab">健康信息</a>
                        </li>
                        <li>
                            <a href="#relation" data-toggle="tab">亲属信息</a>
                        </li> -->
                    </ul>

                    <div id="myTabContent" class="tab-content">
                        <div class="tab-pane fade in active" id="base">
                            <jsp:include page="baseAdd.jsp"></jsp:include>
                        </div>

                        <%--<div class="tab-pane fade" id="charge">--%>
                            <%--<jsp:include page="oldManChargeAdd.jsp"></jsp:include>--%>
                        <%--</div>--%>

                     <%--    <div class="tab-pane fade" id="health">
							  <jsp:include  page="oldManHealthy.jsp"></jsp:include>
                        </div>

                        <div class="tab-pane fade" id="relation">
                            <jsp:include page="oldManRelation.jsp"></jsp:include>
                        </div> --%>
                    </div>

                </div>

            </div>
        </div>

    </div>
</form>
<script>
//    $('#myTab li:eq(2) a').tab('show')

//    $('#myTab a').click(function (e) {
//        e.preventDefault()
//        $(this).tab('show')
//    })
</script>
