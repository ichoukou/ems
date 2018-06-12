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
<form id="ts_form_validate" class="form-horizontal notprint">
			<div class="modal-content">
				<div class="modal-body">
					<div class="form-group row">
						<label for="fRelation" class="col-sm-2 control-label">关系</label>
							<div class="col-sm-4">
							<select class="form-control" id="fRelation"
								name="fRelation">
							</select>
							</div>
						<label for="fRelationName" class="col-sm-2 control-label">姓名</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fRelationName" name="fRelationName">
						</div>
					</div>
					<div class="form-group row">
						<label for="fRelationSex" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-4">
							<select class="form-control" id="fRelationSex" name="fRelationSex">
								<option selected="selected" value='男'>男</option>
                                <option value='女'>女</option>
							</select>
						</div>
						<label for="fRelationAge" class="col-sm-2 control-label">年龄</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fRelationAge" name="fRelationAge" placeholder="数字">
						</div>
					</div>
					<div class="form-group row">
						<label for="fRelationMobile" class="col-sm-2 control-label">手机</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fRelationMobile" name="fRelationMobile" placeholder="15543783892">
						</div>
						<label for="fRelationPhone" class="col-sm-2 control-label">电话</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fRelationPhone" name="fRelationPhone" placeholder="0000-00000000">
						</div>
					</div>
					<div class="form-group row">
						<label for="fRelationQQ" class="col-sm-2 control-label">QQ</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fRelationQQ" name="fRelationQQ" placeholder="请输入有效QQ">
						</div>
						<label for="fRelationMM" class="col-sm-2 control-label">微信</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fRelationMM" name="fRelationMM" placeholder="请输入有效微信">
						</div>
					</div>
					<div class="form-group row">
						<label for="fRelationCompany" class="col-sm-2 control-label">工作单位</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fRelationCompany" name="fRelationCompany" placeholder="不能为空">
						</div>
						<label for="fRelationAdrress" class="col-sm-2 control-label">家庭住址</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fRelationAdrress" name="fRelationAdrress" placeholder="不能为空">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary"  id="addRelation_Button" onclick="addRelation()">保存</button>
					<button id="validateBtn" type="button" class="btn btn-primary"  data-dismiss="modal" onclick="closeModal()">关闭</button>
				</div>
			</div>
</form>