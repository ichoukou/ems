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
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">新增</h4>
      </div>
      <div class="modal-body">
		  <div class="popover-content">
			  <table style="position: relative; top: -30px;">
				  <tbody>
				  <tr>
					  <td width="90" height="26px"></td>
					  <td></td>
					  <td width="70"></td>
					  <td></td>
				  </tr>
				  <tr>
					  <td width="90" height="26px"></td>
					  <td></td>
					  <td width="70"></td>
					  <td></td>
				  </tr>
				  <tr>
					  <td align="right" for="exampleInputEmail1">分值下限：</td>
					  <td>
						 <input id="addFLowerLimit" type="text" >
					  </td>
					  <td align="right" for="exampleInputEmail1">分值上线：</td>
					  <td>
						  <input id="addFHighLimit" type="text">
					  </td>
				  </tr>
				  <tr>
					  <td width="90" height="13px"></td>
					  <td></td>
					  <td width="70"></td>
					  <td></td>
				  </tr>
				  <tr>
					  <td align="right" for="exampleInputEmail1">考核系数：</td>
					  <td>
						  <input type="text" id="addFCoefficient">
					  </td>
					  <td align="right" for="exampleInputEmail1">考核结果：</td>
					  <td>
						  <input type="text" id="addFAssessmentResult">
					  </td>
				  </tr>
				  </tbody>
			  </table>
		  </div>
	  </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="addStandard()">保存</button>
      </div>
    </div>
	</div>
	</div>
</form>