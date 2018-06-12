<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- Modal -->
<form id="form_validate" class="form-horizontal">
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
        <div class="modal-dialog">
            <div class="modal-content" style="width:700px;">
                <div class="modal-header" style="width:700px;">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                   <center> <h4 class="modal-title" id="myModalLabel">分配房间</h4></center>
                </div>
                                
               <div class="modal-body"  style="width:700px;">
       
             </div>
                <div class="modal-footer" style="width:700px; border-top-width: 0px;">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="updateRoom()">保存</button>                                
                </div>
               </div>
        </div>
    </div>
</form>