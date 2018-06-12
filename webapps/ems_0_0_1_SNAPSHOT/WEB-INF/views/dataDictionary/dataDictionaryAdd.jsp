<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!-- Modal -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">新增字典</h4>
            </div>

            <form id="dataDictionaryAddForm" class="form-horizontal">

                <div class="modal-body">

                    <div class="form-group">
                        <label>名称</label>
                        <input type="text" class="form-control" id="addName" name="addName" placeholder="name">
                    </div>
                    <%--<input type="tel" id="myWarn"/>--%>
                    <div class="form-group">
                        <label>数据</label>
                        <input type="text" class="form-control" id="addValue" name="addValue" placeholder="value">
                    </div>
                    <div class="form-group">
                        <label>状态</label>
                        <select class="form-control" id="addStatus" name="addStatus">
                            <option value="11">开启</option>
                            <option value="11">禁用</option>
                        </select>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="closeModal()">关闭</button>
                    <button type="submit" id="addData" class="btn btn-primary">保存</button>
                <%--onclick="addDictionary()"--%>
                </div>

            </form>

        </div>
    </div>
</div>