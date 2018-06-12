<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2016/12/4
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<style>
    .col-sm-2{
        width:13.666667%;
    }
</style>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="width: 950px">
            <div class="modal-content" style="height: 990px">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">新增房间</h4>
                </div>

                    <%--<label for="addNursinghomeID" class="col-sm-2 control-label">养老院ID</label>--%>
                    <%--<div class="col-sm-4">--%>
                    <%--<input type="hidden" id="queryBuildId">--%>
                    <%--<input type="hidden" id="queryFloorId">--%>
                    <%--</div>--%>

                    <div class="form-group row">
                        <label class="col-sm-2 control-label">大厦名称</label>
                        <div class="col-sm-4">
                            <select onblur="addCheck_BuildingID_room()" class="form-control" id="addfBuildingID" onchange="getBuildID()"
                                    name="addfBuildingID" style="width:250px;display: inline-block">

                            </select>
                            <label id="errorfBuildingID" style="color: red" >&nbsp;&nbsp;&nbsp;</label>
                        </div>

                        <label for="addfFLoorID" class="col-sm-2 control-label">楼层名称</label>
                        <div class="col-sm-4">
                            <select onblur="addCheck_floorName_room()" class="form-control" id="addfFLoorID" name="addfFLoorID"
                                    style="width:250px;display: inline-block">

                            </select>
                            <label id="errorfFLoorID" style="color: red" >&nbsp;&nbsp;&nbsp;</label>
                        </div>
                    </div>


                    <div class="form-group row">
                        <label for="addfRoomNumber" class="col-sm-2 control-label">房间编码</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="addfRoomNumber" name="addfRoomNumber" readonly="readonly"
                                   style="width:250px;display: inline-block">
                        </div>

                        <label id="afRoomName" class="col-sm-2 control-label" value="单位">房间名称</label>
                        <div class="col-sm-4">
                            <input onblur="addCheck_RoomName_room()" type="text" class="form-control" id="addfRoomName" name="addfRoomName"
                                   style="width:250px;display: inline-block">
                            <label id="errorfRoomName" style="color: red" >&nbsp;&nbsp;&nbsp;</label>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 control-label" id="fRoomType" value="房间类型">房间类型</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="addfRoomType" name="addfRoomType"
                                    style="width:250px;display: inline-block">

                            </select>
                        </div>

                        <label id="afRoomOrientation" class="col-sm-2 control-label" value="房间朝向">房间朝向</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="addfRoomOrientation" name="addfRoomOrientation"
                                    style="width:250px;display: inline-block">

                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label id="afRoomPrice" class="col-sm-2 control-label" value="房间费">房间费</label>
                        <div class="col-sm-4">
                            <input onblur="addCheck_RoomPrice_room()" class="form-control" id="addfRoomPrice"
                                   style="width:250px;display: inline-block">
                            <label id="errorfRoomPrice" style="color: red" >&nbsp;&nbsp;&nbsp;</label>
                        </div>

                        <label id="afAdministratorsID" class="col-sm-2 control-label" value="分值">房间负责人</label>
                        <div class="col-sm-4">
                            <select onblur="addCheck_administratorsId_room()" class="form-control" id="administratorsId" name="administratorsId"
                                    style="width:250px;display: inline-block">
                                <%--<option value="jueye">jueye</option>--%>
                            </select>
                            <label id="errorfRoomMan" style="color: red" >&nbsp;&nbsp;&nbsp;</label>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="addfBedCount" class="col-sm-2 control-label">房间床数</label>
                        <div class="col-sm-4">
                            <input onblur="addCheck_BedCount_room()" type="text" class="form-control" id="addfBedCount" name="addfBedCount"
                                   style="width:250px;display: inline-block">
                            <label id="errorfBedCount" style="color: red" >&nbsp;&nbsp;&nbsp;</label>
                        </div>

                        <label for="addfManNumber" class="col-sm-2 control-label">房间人数</label>
                        <div class="col-sm-4">
                            <input onblur="addCheck_ManNumber_room()" type="text" class="form-control" id="addfManNumber" name="addfManNumber"
                                   style="width:250px;display: inline-block">
                            <label id="errorfManNumber" style="color: red" >&nbsp;&nbsp;&nbsp;</label>
                        </div>
                    </div>

                <div class="form-group row">
                    <label class="col-sm-2 control-label">房间状态</label>
                    <div class="col-sm-4">
                        <select class="form-control" id="addRoomStatus" name="addRoomStatus" style="width:250px;display: inline-block">
                            <option value="01">空闲</option>
                            <option value="11">已满</option>
                            <option value="10">未满</option>
                            <option value="2">停用</option>
                        </select>
                    </div>

                    <label class="col-sm-2 control-label">房间说明</label>
                    <div class="col-sm-4">
                        <textarea class="form-control" name="addRoomExplain" id="addRoomExplain" placeholder="说明"></textarea>
                    </div>
                </div>



                <div class="modal-footer">
                    <button type="button" class="btn btn-default" onclick="closeModal_Room(1)">关闭</button>
                    <button type="button" id="roomBtn" class="btn btn-primary" onclick="addRoom()">保存</button>
                </div>


                <input type="hidden" id="addfRoomID">
                    <div class="form-group row">
                        <label for="addfBedNumber" class="col-sm-2 control-label">床位号</label>
                        <div class="col-sm-4">
                            <input onblur="check_add_BedNumber()" type="text" class="form-control" id="addfBedNumber" name="addfBedNumber"
                                   style="width:250px;display: inline-block">
                            <label id="errorfBedNumber" style="color: red" >&nbsp;&nbsp;&nbsp;</label>
                        </div>

                        <label id="afBedPrice" class="col-sm-2 control-label" value="床费">床费</label>
                        <div class="col-sm-4">
                            <input onblur="check_add_bedPrice()" class="form-control" id="addfBedPrice"
                                    style="width:250px;display: inline-block">
                            <label id="errorfBedPrice" style="color: red" >&nbsp;&nbsp;&nbsp;</label>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2 control-label">护理员</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="addfAdministratorsIDs" name="addfAdministratorsIDs"
                                    style="width:250px;display: inline-block">
                                <option value="jueye">jueye</option>
                            </select>
                            <label id="errorfMan" style="color: red" >&nbsp;&nbsp;&nbsp;</label>
                            <%--<input class="addRefundType" type="checkbox" name="addRefundType" id="addRefundType" value="1"/>是--%>
                        </div>

                        <label class="col-sm-2 control-label">床位状态</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="addfStatus" name="addfStatus"
                                    style="width:250px;display: inline-block">
                                <option value="2">空闲</option>
                                <option value="11">使用</option>
                                <option value="01">预约</option>
                                <option value="10">请假</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label for="addBedExplain" class="col-sm-2 control-label">床位说明</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" name="addBedExplain" id="addBedExplain" placeholder="说明"></textarea>
                        </div>
                    </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" onclick="closeBedModal(1)">关闭</button>
                    <button type="button" class="btn btn-primary" id="bedBtn" disabled="disabled" onclick="addBed()">保存</button>
                </div>

                <table id="tb_Bed"></table>
            </div>
        </div>

    </div>
</form>
<script src="${pageContext.request.contextPath}/script/app-resources/t-bed/tBed.js"></script>
