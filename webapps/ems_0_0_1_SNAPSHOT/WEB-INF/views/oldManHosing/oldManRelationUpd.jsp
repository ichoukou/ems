<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Modal -->
<style>
    .modal-body .row label {
        line-height: 30px;
    }
    .row {
        margin-bottom: 5px;
    }
</style>
<form class="form-horizontal notprint">
	<div class="modal fade" id="relationUpd" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改亲属信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-group row">
						<label for="fRelationUpd" class="col-sm-2 control-label">关系</label>
							<div class="col-sm-4">
							<select class="form-control" id="fRelationUpd"
								name="fRelationUpd">
							</select>
							</div>
						<label for="fRelationNameUpd" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fRelationNameUpd" name="fRelationNameUpd">
						</div>
					</div>
					<div class="form-group row">
						<label for="fRelationSexUpd" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-4">
							<select class="form-control" id="fRelationSexUpd" name="fRelationSexUpd">
								<option selected="selected" value='男'>男</option>
                                <option value='女'>女</option>
							</select>
						</div>
						<label for="fRelationAgeUpd" class="col-sm-2 control-label">年龄</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fRelationAgeUpd" name="fRelationAgeUpd" placeholder="数字">
						</div>
					</div>
					<div class="form-group row">
						<label for="fRelationMobileUpd" class="col-sm-2 control-label">手机</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fRelationMobileUpd" name="fRelationMobileUpd" placeholder="15543783892">
						</div>
						<label for="fRelationPhoneUpd" class="col-sm-2 control-label">电话</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fRelationPhoneUpd" name="fRelationPhoneUpd" placeholder="0000-00000000">
						</div>
					</div>
					<div class="form-group row">
						<label for="fRelationQQUpd" class="col-sm-2 control-label">QQ</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fRelationQQUpd" name="fRelationQQUpd" placeholder="请输入有效QQ">
						</div>
						<label for="fRelationMMUpd" class="col-sm-2 control-label">微信</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fRelationMMUpd" name="fRelationMMUpd" placeholder="请输入有效微信">
						</div>
					</div>
					<div class="form-group row">
						<label for="fRelationCompanyUpd" class="col-sm-2 control-label">工作单位</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fRelationCompanyUpd" name="fRelationCompanyUpd" placeholder="不能为空">
						</div>
						<label for="fRelationAdrressUpd" class="col-sm-2 control-label">家庭住址</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fRelationAdrressUpd" name="fRelationAdrressUpd" placeholder="不能为空">
						</div>
					</div>
					<div class="form-group row">
						<label for="fIDUpd" class="col-sm-2 control-label"></label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fIDUpd" name="fIDUpd" style="visibility: hidden;">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal" id="addButton"
						onclick="updRelation()">修改</button>
					<button id="add_close_btn" type="button" class="btn btn-primary"
						data-dismiss="modal" onclick="clearInput()">关闭</button>
				</div>
			</div>
		</div>
	</div>
</form>