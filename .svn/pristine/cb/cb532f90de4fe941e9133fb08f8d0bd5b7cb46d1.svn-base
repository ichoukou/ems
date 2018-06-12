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
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
					<h4 class="modal-title" id="myModalLabel">添加供应商</h4>
				</div>
				<div class="modal-body">
					<div class="form-group row">
						<div class="col-sm-2" style="padding-right: 1px;">
							<label for="addFSupplierName" >供应商名称</label>
							<label id="add_suname_message" style="color: red;width: 94px;height: auto">&nbsp;&nbsp;&nbsp;</label>
						</div>
						<div class="col-sm-4">
						<input type="text" class="form-control" id="addFSupplierName" placeholder="供应商名称" onblur="add_suname_check()">
						</div>
						<label for="addFAccountNumber" class="col-sm-2 control-label" style="padding-right: 1px;">账号</label>
						<div class="col-sm-4">
						<input type="text" class="form-control" id="addFAccountNumber" placeholder="账号">
						</div>
					</div>
					<div class="form-group row">
						<div class="col-sm-2" style="padding-right: 1px;">
							<label for="addFContactsName">联系人</label>
							<label id="add_coname_message" style="color: red;width: 94px;height: auto">&nbsp;&nbsp;&nbsp;</label>
						</div>
						<div class="col-sm-4">
						<input type="text" class="form-control" id="addFContactsName" placeholder="联系人" onblur="add_coname_check()">
						</div>
						<label for="addFBank" class="col-sm-2 control-label" style="padding-right: 1px;">开户行</label>
						<div class="col-sm-4">
						<input type="text" class="form-control" id="addFBank" placeholder="">
						</div>
					</div>
					<div class="form-group row">
						<label for="addFMailingAddress" class="col-sm-2 control-label" style="padding-right: 1px;" >联系地址</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="addFMailingAddress" placeholder="联系地址" >
						</div>

						<div class="col-sm-2" class="col-sm-2 control-label" style="padding-right: 1px;">
						<label for="addFMobileTel">手机</label>
						<label id="add_moname_message" style="color: red;width: 94px;height: auto">&nbsp;&nbsp;&nbsp;</label>
						</div>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="addFMobileTel" placeholder="联系电话" onblur="add_moname_check()">
						</div>
					</div>
					<div class="form-group row">
						<label for="addFMailingAddress" class="col-sm-2 control-label" style="padding-right: 1px;">税号</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="addFDutyParagraph" placeholder="" >
						</div>

						<label for="addFTel" class="col-sm-2 control-label" style="padding-right: 1px;">固定电话</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="addFTel" placeholder="">
						</div>
					</div>
					<div class="form-group row">
						<label for="addFQqID" class="col-sm-2 control-label" style="padding-right: 1px;">QQ号</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="addFQqID" placeholder="" >
						</div>

						<label for="addFWechatNumber" class="col-sm-2 control-label" style="padding-right: 1px;">微信</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="addFWechatNumber" placeholder="">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button id="add_close_btn" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="addProviderManager()">保存</button>
				</div>
			</div>
		</div>

	</div>
</form>