<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>

<div class="container-fluid" style="font-size: 11px;" ng-app="ruleAddApp" id="ruleadd">
	<div class="row" ng-controller="ruleAddCtrl">
		<div class="col-md-12">
	
			
			<form class="form-horizontal" id="addNursingServiceGroup_form" action="#" role="form">
				<input type="hidden" id="fid" name="fid"/>
				<div class="form-group has-error has-feedback">
					<label for="fName" class="col-sm-2 control-label">护理类型:</label>
					<div class="col-sm-6">
			 			<input class="form-control input-sm" id="fName" name="fName" check-type="required" required-message="">
			 		</div>	
				</div>
				
				<div class="form-group has-error has-feedback">
					<label for="fServiceType" class="col-sm-2 control-label">项目类型:</label>
					<div class="col-sm-6">
			 			<select class="form-control input-sm" id="fServiceType" name="fServiceType" check-type="required" required-message="">
							<option value="1">老人服务</option>
							<option value="2">公共服务</option>
						 </select>
			 		</div>	
				</div>
			</form>

		</div>
	</div>
</div>


<script type="text/javascript">
//初始化
function add_init_comp(fid){
	if(fid){
		var rows=$('#tb_nursingServiceGroup').bootstrapTable('getSelections');
		var serviceGroup=rows[0];
		$("#fid").val(fid);
		$("#fName").val(serviceGroup.fName);
		$("#fServiceType").val(serviceGroup.fServiceType).trigger("change");
	}
}
</script>
