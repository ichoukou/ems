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
<form id="form_validate" class="form-horizontal">
                                  
    <div class="modal fade" id="printModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
           <div class="modal-dialog" style="width: 1000px">
            <div class="modal-content" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel"><label id="printOrderNo" >单号：</label>
                    </h4>
                </div>                             
                <div class="modal-body">

                    <div align="center" class="panel-heading" style="width: 100%;height: 60px; background-color: #F5F5F5" ><h2 class="modal-title" style="color: black">服务订单打印

                    </h2>
                    </div>
                    <div class="form-group" style="margin-top:15px">
                        <label class="control-label col-sm-1" for="printDate">日期：</label>
                        <div class="col-sm-3">
                            <span id="printDate"  ></span>
                        </div>
                    </div>

                    <table id="tb_order_print"  class="table table-bordered" style="border:solid 2px black;margin-top: 10px;color: black;margin-bottom: 0px;" >
                        <thead >
                        <tr>
                            <th style="text-align: center;width: 70px ;border-color: black" >
                                <div class="th-inner ">序号</div>
                            </th>
                            <th style="text-align: center;width: 120px;border-color: black " >
                                <div class="th-inner ">老人</div>
                            </th>
                            <th style="text-align: center;width: 120px ;border-color: black" >
                                <div class="th-inner ">项目</div>
                            </th>
                            <th style="text-align: center; width: 120px;border-color: black ">
                                <div class="th-inner ">金额</div>
                            </th>
                            <th style="text-align: center; width: 120px;border-color: black " >
                                <div class="th-inner ">服务时间</div>
                            </th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>


                    <table id="tb_order_sign"  class="table" style="" >
                        <thead >
                        <tr>
                            <th style="text-align: center;width: 70px ;" >
                                <div class="th-inner ">签字日期:</div>
                            </th>
                            <th style="text-align: center;width: 120px; " >
                                <div class="th-inner ">
                                </div>
                            </th>
                            <th style="text-align: center;width: 120px ;" >
                                <div class="th-inner ">老人(代理)签字人:</div>
                            </th>
                            <th style="text-align: center; width: 120px; " >
                                <div class="th-inner "> </div>
                            </th>
                        </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>



                <%--      <div class="form-group row">
                        <label for="printOrderfid" class="col-sm-2 control-label">序号</label>
                    
                        <label for="printfObjectName" class="col-sm-2 control-label" >老人</label>
                    
                        
                          <label for="printfServiceItem" class="col-sm-2 control-label" >项目</label>
                
                        
                          <label for="printfTotal" class="col-sm-2 control-label" >金额</label>
                      
                          <label for="printfFinishTime" class="col-sm-2 control-label" >服务时间</label>
                       
                    </div> 
                     <div class="form-group row">
                     
                         <div class="col-sm-2" style="padding-right: 0px;">
                            <input  class="form-control" id="printOrderfid" name="printOrderfid" readonly="readonly">
                                              
                        </div>
                     
                     
                         <div class="col-sm-2" style="padding-left: 0px;padding-right: 0px;">
                         <input type="text" class="form-control" id="printfObjectName" name="fObjectName" readonly="readonly">                          
                        </div>
                     
                             <div class="col-sm-2" style="padding-left: 0px;padding-right: 0px;">
                            <input  class="form-control" id="printfServiceItem" name="fServiceItem" readonly="readonly">
                            
                        </div>
                     
                       <div class="col-sm-2" style="padding-left: 0px;padding-right: 0px;">
                            <input class="form-control" id="printfTotal" name="fTotal" readonly="readonly">
                           
                        </div>
                        
                     
                      <div class="col-sm-2" style="padding-left: 0px;">
                            <input style="width: 176px;"  class="form-control" id="printfFinishTime" name="printfFinishTime" readonly="readonly">
                        </div>
                     </div>
                      <div class="form-group row">
                         
                        <label for="evalservice" style="width: 90px;" class="col-sm-2 control-label">服务评价</label>
                      
                        
                        <div class="col-sm-10">
                            <textarea class="form-control"  style="resize: none;height: 114px;width: 756px;"  id="evalservice" ></textarea>
                        </div>
                    </div>
                        <div class="form-group row">
                        
                            <label for="printtime" style="width: 90px;" class="col-sm-2 control-label">签字日期:</label>
                            <div class="col-sm-3" >
							<input type="text"  class="form-control" id="printtime" readonly="readonly"  name="printtime">
                               
                            </div>

                            <div class="col-sm-2"></div>

                            <label for="oldman" style="width: 140px;" class="col-sm-2 control-label">老人(代理)签字人:</label>
                            <div class="col-sm-3" >
                               <input type="text" class="form-control" id="oldman" readonly="readonly" >
                                
                            </div> 

                        </div>

                    --%>
             
      
              
                </div>
                <div class="modal-footer notprint">
                  <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="self.print()">打印</button>                                
                    <button type="button" class="btn btn-primary" data-dismiss="modal" >关闭</button> 
                </div>
            </div>
        </div>
      </div>
</form> 