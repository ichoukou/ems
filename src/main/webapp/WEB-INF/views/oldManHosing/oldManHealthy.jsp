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
<form id="healthy_form_validate" class="form-horizontal notprint">
					<br/>
					<br/>
					<div class="form-group row">
						<label for="fHealthyCondition" class="col-sm-2 control-label">健康信息</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"   id="fHealthyCondition" name="fHealthyCondition" placeholder="不能为空"/>
						</div>
						<label for="fMedicalHistory" class="col-sm-2 control-label">有何病史</label>
						<div class="col-sm-4">
							<input type="text" class="form-control"  id="fMedicalHistory" name="fMedicalHistory" placeholder="不能为空">
						</div>
					</div>
					<div class="form-group row">
						<label for="fDietTrait" class="col-sm-2 control-label">饮食特点</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="fDietTrait" name="fDietTrait" placeholder="不能为空">
						</div>
						<label for="fHobby" class="col-sm-2 control-label">嗜好</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="fHobby" name="fHobby" placeholder="不能为空">
						</div>
					</div>
					<div class="form-group row">
						<label for="fAttention" class="col-sm-2 control-label">注意事项</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="fAttention" name="fAttention" placeholder="不能为空">
						</div>
						<label for="" class="col-sm-2 control-label"></label>
					<div class="col-sm-2"><button type="button" class="btn btn-primary"  id="addButton" onclick="addHealthy()">保存</button></div>
					<div class="col-sm-2"><button id="add_close_btn" type="button" class="btn btn-primary" data-dismiss="modal"  onclick="clearInput()">关闭</button></div>
					</div>
</form>