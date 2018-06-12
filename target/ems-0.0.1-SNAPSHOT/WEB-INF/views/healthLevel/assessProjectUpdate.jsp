<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <!-- Modal -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
    <div class="modal-content">
    
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
		<h4 class="modal-title" id="myModalLabel">修改评估项目</h4>
	</div>

	<form id="assessProUpdForm" class="form-horizontal">
		<div class="modal-body">
			<input type="hidden" id="FLevelID">
			<div class="form-group">
				<label>项目类型</label>
				<select class="form-control"  id="updFEvaluationName" name="updFEvaluationName">
				</select>
			</div>

			<div class="form-group">
				<label>评估等级</label>
				<input type="text" class="form-control"  name="updFLevelName" id="updFLevelName">
			</div>

			<div class="form-group">
				<label>分值</label>
				<select  class="form-control" id="updFEvaluationValue" name="updFEvaluationValue">
				</select>
			</div>

			<div class="form-group">
				<label>说明</label>
				<input type="text" class="form-control" name="updFEvaluationDesc" id="updFEvaluationDesc" placeholder="desc">
			</div>
		</div>

		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			<button type="SUBMIT" class="btn btn-primary">保存</button>
		</div>
	</form>
    </div>
  </div>

</div>