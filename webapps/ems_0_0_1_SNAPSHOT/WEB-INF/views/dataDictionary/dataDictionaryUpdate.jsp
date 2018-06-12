<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- Modal -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">修改字典</h4>
            </div>

            <form id="dataDictionaryUpdForm" class="form-horizontal">

                <div class="modal-body">
                    <input type="hidden" id="data_id">
                    <div class="form-group">
                        <label>名称</label>
                        <input type="text" class="form-control" id="updateName" name="updateName" placeholder="name">
                    </div>
                    <div class="form-group">
                        <label>数据</label>
                        <input type="text" class="form-control" id="updateValue" name="updateValue" placeholder="value">
                    </div>
                    <div class="form-group">
                        <label>状态</label>
                        <select class="form-control" id="updateStatus" name="updateValue">

                        </select>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">修改</button>
                </div>
            </form>
        </div>
    </div>

</div>