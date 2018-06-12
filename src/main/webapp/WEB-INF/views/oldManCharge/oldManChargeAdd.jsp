<%--
  Created by IntelliJ IDEA.
  User: wangjs
  Date: 2017/2/15
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="addOldManChargeModal" tabindex="2" role="dialog" aria-hidden="true">
        <div class="modal-dialog" style="width: 1040px; margin-left: 0px; left: 20px;">
            <div class="modal-content" style="height: 520px">
                <div class="modal-header">
                    <button onclick="cleanAll()" type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <label style="font-size: 15px">新增费用</label>
                    <span style="float: right;padding-right: 330px">
                        <label style="font-size: 15px">选择老人</label>
                        <input type="hidden" value="" id="oldManChargeAddId">
                    <input onclick="selectOldMan()" type="text" id="oldManChargeAddName" placeholder="必填项"></span>
                </div>
                <div class="modal-body" style="height: 400px">
                    <div style="width:39%;display: inline-block;vertical-align: top;">
                        <label>待选费用</label>
                        <table id="table_chargeStandard"></table>
                    </div>
                    <div style="width:3%;display: inline-block;vertical-align: top;margin-top: 100px">
                        <button id="selected_left">>></button>
                        <button id="selected_right"><<</button>
                    </div>
                    <div style="width:57%;display: inline-block;vertical-align: top;">
                        <label>已选费用</label>
                        <table id="tb_omCharge"></table>

                    </div>

                </div>
                <div class="modal-footer" style="text-align:center;">
                    <button class="btn btn-primary" onclick="updChargeStatus(this.value,true)" value="1">保存已选费用</button>
                    <button class="btn btn-warning" onclick="updChargeStatus(this.value,false)" value="2">停止已选费用</button>
                </div>
            </div>
        </div>

    </div>
</form>
