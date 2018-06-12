<%--
  Created by IntelliJ IDEA.
  User: 张鑫
  Date: 2016/12/27
  Time: 11:38
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <!-- Modal -->
 <form id="form_validate" class="form-horizontal">
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
    <div class="modal-content">

      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">更新供应商</h4>
      </div>
		<div class="modal-body">
			<input type="hidden" id="provider_id">
			<div class="form-group row">
				<div class="col-sm-2" class="col-sm-2 control-label" style="padding-right: 1px;">
				<label for="updateFSupplierName" >供应商名称</label>
				<label id="update_suname_message" style="color: red;width: 94px;height: auto">&nbsp;&nbsp;&nbsp;</label>
				</div>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="updateFSupplierName" placeholder="供应商名称" onblur="update_suname_check()">
				</div>
				<label for="updateFAccountNumber" class="col-sm-2 control-label" style="padding-right: 1px;">账号</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="updateFAccountNumber" placeholder="账号">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-2" class="col-sm-2 control-label" style="padding-right: 1px;">
				<label for="updateFContactsName">联系人</label>
				<label id="add_coname_message" style="color: red;width: 94px;height: auto">&nbsp;&nbsp;&nbsp;</label>
				</div>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="updateFContactsName" placeholder="联系人" onblur="update_coname_check()">
				</div>
				<label for="updateFBank" class="col-sm-2 control-label" style="padding-right: 1px;">开户行</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="updateFBank" placeholder="">
				</div>
			</div>
			<div class="form-group row">
				<label for="updateFMailingAddress" class="col-sm-2 control-label" style="padding-right: 1px;" >联系地址</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="updateFMailingAddress" placeholder="联系地址" >
				</div>
				<div class="col-sm-2" class="col-sm-2 control-label" style="padding-right: 1px;">
				<label for="updateFMobileTel">手机</label>
				<label id="update_moname_message" style="color: red;width: 94px;height: auto">&nbsp;&nbsp;&nbsp;</label>
				</div>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="updateFMobileTel" placeholder="联系电话" onblur="update_moname_check()">
				</div>
			</div>
			<div class="form-group row">
				<label for="updateFMailingAddress" class="col-sm-2 control-label" style="padding-right: 1px;">税号</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="updateFDutyParagraph" placeholder="" >
				</div>

				<label for="updateFTel" class="col-sm-2 control-label" style="padding-right: 1px;">固定电话</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="updateFTel" placeholder="">
				</div>
			</div>
			<div class="form-group row">
				<label for="updateFQqID" class="col-sm-2 control-label" style="padding-right: 1px;">QQ号</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="updateFQqID" placeholder="" >
				</div>

				<label for="updateFWechatNumber" class="col-sm-2 control-label" style="padding-right: 1px;">微信</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="updateFWechatNumber" placeholder="">
				</div>
			</div>
		</div>
      <div class="modal-footer">
		  <button id="update_close_btn" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		  <button type="button" class="btn btn-primary" onclick="updateProviderManager()">保存</button>
      </div>
    </div>
  </div>

</div>
</form>