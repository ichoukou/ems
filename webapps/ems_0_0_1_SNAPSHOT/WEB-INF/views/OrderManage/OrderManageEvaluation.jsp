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

<form id="form_validate" class="form-horizontal notprint">
    <div class="modal fade" id="evalModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
           <div class="modal-dialog" style="width: 700px">
            <div class="modal-content" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">居家订单评价</h4>
                </div>                             
                <div class="modal-body" style="padding-bottom: 10px;">
                
             	<input type="hidden" class="form-control" id="Evalfid"	name="updatefid">
                        
                    <div class="form-group row">
                    <div class="col-sm-3"></div>
                        	<label for="EvalfObjectName" class=" col-sm-2 control-label">老人姓名</label>
						<div class="col-sm-4">
							<input type="text"  class="form-control"
								id="EvalfObjectName" name="fObjectName" readonly="readonly">

						</div>
 
                   </div>
                        
                         <div class="form-group row">
                          <div class="col-sm-3"></div>
                         
                 <label for="EvalOrderNumber" class=" col-sm-2 control-label">工单号</label>
						<div class="col-sm-4">
							<input type="text" 
								class="form-control" id="EvalOrderNumber" readonly="readonly"
								name="fOrderNo"> </div>   
                         
                         </div>
                          <div class="form-group row">
                           <div class="col-sm-3"></div>
                          
                          	<label for="evalfFinishTime" class=" col-sm-2 control-label">服务完成时间</label>
						<div class="col-sm-4">
							<input 
								onFocus="WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})"
								type="text" class="form-control" id="evalfFinishTime"
								name="fFinishTime">
						</div>
                          
                          </div>
                         

                    <div class="form-group row">
                     <div class="col-sm-3"></div>
                      

                        <label for="EvalfEvaluationOrder" class="col-sm-2 control-label">评价订单</label>
				       <div class="col-sm-4">
                            <textarea class="form-control"  style="resize: none;height: 114px;"  name="fEvaluationOrder" id="EvalfEvaluationOrder" ></textarea>
					   </div>
                   </div>    
                <div class="modal-footer" style="padding-bottom: 5px;">
                  <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="addEvaluation()">保存评价</button>  
                </div>
            </div>
        </div>
      </div>
    </div>
</form>