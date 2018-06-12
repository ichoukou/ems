<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<div class="container-fluid" style="font-size: 11px;">
	<div class="row">
		<div class="col-md-12">
	
			<form class="form-horizontal" id="edit_form" action="#" role="form">
				<div class="form-group">
					<label class="col-sm-2 control-label">任务名</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="edit_jobname" name="edit_jobname" readonly>
					</div>
				</div>
			
				<div class="form-group">
					<label class="col-sm-2 control-label">时间表达式</label>
					<div class="col-sm-6">
						<input type="text" class="form-control" id="edit_cronexpression" name="edit_cronexpression" check-type="required" required-message="请填写时间表达式。">
					</div>
				</div>
			</form>

		</div>
	</div>
</div>


<script type="text/javascript">
$(function(){
	setParams();
	
})

//赋值给控件
function setParams(){
	$("#edit_jobname").val(obj.jobname);
	$("#edit_cronexpression").val(obj.cronexpression);
	
}
</script>