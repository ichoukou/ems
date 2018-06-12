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
<form id="healthyUpd_form_validate" class="form-horizontal notprint">
	<div class="modal fade" id="healthyUpd" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:800px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改健康信息</h4>
				</div>
				<div class="modal-body">
					<div class="form-group row">
						<label for="fHealthyConditionUpd" class="col-sm-2 control-label">健康信息</label>
						<div class="col-sm-4">
							<textarea class="form-control"  id="fHealthyConditionUpd" name="fHealthyConditionUpd" rows="3"></textarea> 
							<!-- <input type="text" class="form-control" id="fHealthyConditionUpd"
								name="fHealthyConditionUpd" placeholder="不能为空" /> -->
						</div>
						<label for="fMedicalHistoryUpd" class="col-sm-1 control-label">病史</label>
						<div class="col-sm-5">
						<textarea class="form-control"  id="fMedicalHistoryUpd" name="fMedicalHistoryUpd" rows="3"></textarea>
							<!-- <input type="text" class="form-control" id="fMedicalHistoryUpd"
								name="fMedicalHistoryUpd" placeholder="不能为空"> -->
						</div>
					</div>
					<div class="form-group row">
						<label for="fDietTraitUpd" class="col-sm-2 control-label">饮食特点</label>
						<div class="col-sm-4">
						  <textarea class="form-control"  id="fDietTraitUpd" name="fDietTraitUpd" rows="3"></textarea>
							<!-- <input type="text" class="form-control" id="fDietTraitUpd"
								name="fDietTraitUpd" placeholder="不能为空"> -->
						</div>
						<label for="fHobbyUpd" class="col-sm-1 control-label">嗜好</label>
						<div class="col-sm-5">
						 <textarea class="form-control"  id="fHobbyUpd" name="fHobbyUpd" rows="3"></textarea>
							<!-- <input type="text" class="form-control" id="fHobbyUpd" name="fHobbyUpd"
								placeholder="不能为空"> -->
						</div>
					</div>
					<div class="form-group row">
						<label for="fAttentionUpd" class="col-sm-2 control-label">注意事项</label>
						<div class="col-sm-4">
						  <textarea class="form-control"  id="fAttentionUpd" name="fAttentionUpd" rows="3"></textarea>
							<!-- <input type="text" class="form-control" id="fAttentionUpd"
								name="fAttentionUpd" placeholder="不能为空"> -->
						</div>
						<label for="" class="col-sm-2 control-label"></label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="fOldManId"
								name="fOldManId" style="visibility: hidden;">
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary" data-dismiss="modal" id="addButton"
						onclick="updateHeal()">修改</button>
					<button id="add_close_btn" type="button" class="btn btn-primary"
						data-dismiss="modal" onclick="clearInput()">关闭</button>
				</div>
			</div>
		</div>
	</div>
</form>