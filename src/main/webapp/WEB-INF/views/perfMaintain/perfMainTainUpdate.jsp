<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
	.popover-content{
		padding-bottom: 14px;
		padding-top: 14px;
	}
	tr {
		padding-bottom: 14px;
		padding-top: 14px;
	}
	td {
		vertical-align: middle;
		padding-bottom: 7px;
		font-size: 14px;
	}
	table {
		max-width: 100%;
		background-color: transparent;
		border-collapse: collapse;
		border-spacing: 0;
	}
</style>
 <!-- Modal -->
 <form id="form_validate" class="form-horizontal">
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">修改</h4>
      </div>
      <div class="modal-body">
		  <input type="hidden" id="miantain_id">
		  <div class="popover-content">
			  <table style="position: relative; top: -30px;">
				  <tbody>
				  <tr>
					  <td width="90" height="26px"></td>
					  <td><label id="update_name_message" style="color: red;width: 140px;height: auto">&nbsp;&nbsp;&nbsp;</label></td>
					  <td width="80"></td>
					  <td><label id="update_score_message" style="color: red;width: 140px;height: auto"></label></td>
				  </tr>
				  <tr>
					  <td align="right" for="exampleInputEmail1">员工姓名：</td>
					  <td>
						  <select disabled="disabled" id="updateFStaffName" class="input_text" required style="width: 150px;height: 26px">
						  </select>
					  </td>
					  <td align="right" for="exampleInputEmail1">总分：</td>
					  <td>
						  <input type="text" id="updateFScore" readonly="readonly"style="width: 150px">
					  </td>
				  </tr>
				  <tr>
					  <td width="90" height="13px"></td>
					  <td></td>
					  <td width="80"></td>
					  <td></td>
				  </tr>
				  <tr>
					  <td align="right" for="exampleInputEmail1">考核系数：</td>
					  <td>
						  <input type="text" id="updateFCoefficient" readonly="readonly" style="width: 150px">
					  </td>
					  <td align="right" for="exampleInputEmail1" readonly="readonly" style="padding-left: 7px; ">考核结果：</td>
					  <td>
						  <input type="text" id="updateFPerformanceResult" readonly="readonly" style="width: 150px">
					  </td>
				  </tr>
				  </tbody>
			  </table>
			  <div class="form-group " style="margin-bottom: 10px;">
				  <table id="updateTable" class="table table-striped table-bordered table-hover" style="position: relative; top: -30px;">
				  </table>
			  </div>
		  </div>
      </div>
      <div class="modal-footer">
        <button id="update_close_btn" type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="updateMaintain()">保存</button>
      </div>
    </div>
  </div>

</div>
</form>