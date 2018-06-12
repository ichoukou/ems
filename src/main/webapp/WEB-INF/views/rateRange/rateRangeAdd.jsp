<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <!-- Modal -->
 <form id="form_validate" class="form-horizontal">
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">新增范围</h4>
      </div>
      <div class="modal-body">
     <!--   <div class="form-group">
		    <label for="exampleInputEmail1">编号</label>
		    <input type="text" class="form-control" id="addClevelId" placeholder="clevelId">
  	   </div> -->
	  <div class="form-group">
	    <label for="addClevelName">项目等级</label>
	     <select class="form-control" id="addClevelName" placeholder="clevelName" name="clevelName">
	    
	     </select>
	   
	  </div>
	  <div class="form-group">
	    <label for="addHigh">分值上限</label>
	   <!--  <input type="text" class="form-control" id="addHigh" placeholder="high"> -->
	    <select class="form-control" id="addHigh" placeholder="high" name="high">
                  
              </select>
	  </div>
	  <div class="form-group">
	    <label for="addLow">分值下限</label>
	   <!--  <input type="text" class="form-control" id="addLow" placeholder="low"> -->
	         <select class="form-control" id="addLow" placeholder="low" name="low">
                  
              </select>
       
	  </div>
	  <div class="form-group">
	    <label for="addDesc">说明</label>
	   <!--  <input type="text" class="form-control" id="addDesc" placeholder="desc"> -->
	   <textarea type="text" style="resize: none;" class="form-control" id="addDesc" placeholder="desc"></textarea>
	    
	  </div>
	  <!-- <div class="form-group">
	    <label for="exampleInputFile">File input</label>
	    <input type="file" id="exampleInputFile">
	    <p class="help-block">Example block-level help text here.</p>
	  </div> -->
	  <!-- <div class="checkbox">
	    <label>
	      <input type="checkbox"> Check me out
	    </label>
	  </div> -->
	  	 <!-- <button type="submit" class="btn btn-default">Submit</button> -->
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="addRange()">保存</button>
      </div>
    </div>
  </div>

</div>
</form>