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
<form id="healthyAdd_form" class="form-horizontal notprint">
	<div class="modal fade" id="healthyAdd" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:800px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">添加健康信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-group row">
						<label for="oldManId" class="col-sm-1 control-label">老人</label>
						<div class="col-sm-4">
                            <input type="hidden" id="addfOldManID" />
                            <input onclick="selectOldMan()" type="text" class="form-control"  placeholder="单击选择老人" id="oldManName" name="oldManName">
                        </div>
						<label for="fHealthyCondition" class="col-sm-2 control-label">健康信息</label>
						<div class="col-sm-5">
							 <textarea class="form-control"  id="fHealthyCondition" name="fHealthyCondition" rows="3"></textarea> 
							<!-- <input type="text" class="form-control" id="fHealthyCondition"
								name="fHealthyCondition" placeholder="不能为空" /> -->
						</div>
					</div>
					<div class="form-group row">
						<label for="fMedicalHistory" class="col-sm-1 control-label">病史</label>
						<div class="col-sm-4">
						 	<textarea class="form-control"  id="fMedicalHistory" name="fMedicalHistory" rows="3"></textarea> 
							<!-- <input type="text" class="form-control" id="fMedicalHistory"
								name="fMedicalHistory" placeholder="不能为空"> -->
						</div>
						<label for="fDietTraitAdd" class="col-sm-2 control-label">饮食特点</label>
						<div class="col-sm-5">
							<textarea class="form-control"  id="fDietTrait" name="fDietTrait" rows="3"></textarea> 
							<!-- <input type="text" class="form-control" id="fDietTrait"
								name="fDietTrait" placeholder="不能为空"> -->
						</div>
					</div>
					<div class="form-group row">
						<label for="fHobby" class="col-sm-1 control-label">嗜好</label>
						<div class="col-sm-4">
							<textarea class="form-control"  id="fHobby" name="fHobby" rows="3"></textarea> 
							<!-- <input type="text" class="form-control" id="fHobby" name="fHobby"
								placeholder="不能为空"> -->
						</div>
						<label for="fAttention" class="col-sm-2 control-label">注意事项</label>
						<div class="col-sm-5">
							<textarea class="form-control"  id="fAttention" name="fAttention" rows="3"></textarea> 
							<!-- <input type="text" class="form-control" id="fAttention"
								name="fAttention" placeholder="不能为空"> -->
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" id="addHealButton"
						onclick="addHealthy()">保存</button>
					<button id="add_close_btn" type="button" class="btn btn-primary"
						data-dismiss="modal" onclick="closeModal()">关闭</button>
						<button id="addBase_btn" type="button" class="btn btn-default" data-dismiss="modal" style="display:none">
						</button>
				</div>
			</div>
		</div>
	</div>
</form>