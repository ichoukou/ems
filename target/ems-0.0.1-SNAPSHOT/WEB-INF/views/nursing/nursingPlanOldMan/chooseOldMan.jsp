<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>	

<body>
<div class="panel-body" style="padding-bottom: 0px;" id="chooseOldMan">	
	<form id="formSearchOldMan" class="form-horizontal">
		<div class="form-inline" role="serchFrom"
							style="margin-bottom: 10px;">
								<!-- 1查询条件 -->
								<div class="input-group" style="margin-left: 0px;margin-top: 0px;">
									<div class="input-group-addon">老人姓名</div>
									<input class="form-control input-sm" id="searchFOldManName" name="searchFOldManName" />
								</div>

								<!-- 2查询条件 -->
								<div class="input-group" style="margin-top: 0px;">
									<div class="input-group-addon">房间</div>
									<input class="form-control input-sm" id="searchFroom" name="searchFroom" />
								</div>
								
								<!-- 3查询条件 -->
								<div class="input-group" style="margin-top: 0px;">
									<div class="input-group-addon">老人编号</div>
									<input class="form-control input-sm" id="searchFOldManNumber" name="searchFOldManNumber" />
								</div>
								
								<!-- 4查询条件 -->
								<div class="input-group" style="margin-top: 0px;">
									<div class="input-group-addon">状态</div>
									<select class="form-control input-sm" id="searchFoldManStatusID" name="searchFoldManStatusID">
										
									</select>
								</div>
								
								<!-- 操作按钮2 -->
								<div class="form-group" style="margin-left: 0px;">
									<button type="button" class="btn btn-default btn-sm"
										onclick="resetSearchOldMan()">清空</button>
									<button type="button" class="btn btn-primary btn-sm"
										onclick="queryOldMan()">搜索</button>
								</div>
						</div>
	</form>
	
	<table id="tb_chooseOldMan"></table>
</div>


<script type="text/javascript">
	$(function(){
		
	});
	
	//清空老人查询条件
	function resetSearchOldMan(){
		$("#formSearchOldMan")[0].reset();
	}
		
		function queryOldMan(){
			$('#tb_chooseOldMan').bootstrapTable('refresh');
		}
		
		function add_init_comp(){
			//初始化查询条件的 老人状态下拉框值
			getFoldManStatusID();
			
			//1.初始化老人Table
			initChooseOldManTb();	
		}
		
		function getShowHtml(data){
			var html="<tr><td>";
			
			var dataLength=data.rows.length;
			if(dataLength>0){
				var merchant=dataLength/4;
				var rowLength=Math.floor(merchant)+1;
				var start=0;
				var end=0;
				for(var i=0;i<rowLength;i++){
					html+="<div class='row' style='width:98%;'>";
					
					if(i==rowLength-1){
						start=i*4;
						end=dataLength;
						
					}else{
						start=i*4;
						end=(i+1)*4;
					}
					
					for(var j=start;j<end;j++){
						html+="<div class='col-xs-6 col-md-3'>";
						var oldMan=data.rows[j];
						var dataHtml=getOneTdHtml(oldMan);
						html+=dataHtml;
						html+="</div>";
					}
					
					html+="</div>";
				}
			}
			html+="</td></tr>";
			return html;
		}
		
		function getOneTdHtml(obj){
			var fPhotoSrc=contextPath+"/picture/"+obj.fPhoto;
			var html="<table class='table table-bordered'>";
			html+="<tr>";
			html+="<td rowspan='4'><img name='' src='"+fPhotoSrc+"' onclick=\"chooseOldManOver('"+obj.fid+"','"+obj.fOldManName+"')\" /></td>";
			html+="<td>姓 名:"+obj.fOldManName+"</td>";
			html+="</tr>";
			
			html+="<tr>";
			html+="<td>性 别:"+obj.fOldManIDnSex+"</td>";
			html+="</tr>";
			
			html+="<tr>";
			html+="<td>房间信息:"+obj.froomInfo+"</td>";
			html+="</tr>";
			
			html+="<tr>";
			html+="<td>护理信息:"+obj.fnursingLevelName+"</td>";
			html+="</tr>";

			html+="</table>";
			
			return html;
		}
		
		function getFoldManStatusID(){
			var flag;
			$.ajax({
				type : 'POST',
				url : contextPath+"/nursingPlanOldMan/getFoldManStatusID.do",
				data:{},
				async: false,
				success : function(rs) {
					var optionsHtml="";
					optionsHtml +="<option value=''>请选择</option>"
					for(var i=0;i<rs.length;i++){
						var detailInfo=rs[i];
						optionsHtml +="<option value='"+detailInfo.id+"'>"+detailInfo.value+"</option>"
					}
					
					$("#searchFoldManStatusID").append(optionsHtml);
					
					flag=true;
				},
				error : function() {
					flag = false;
				} 
			});
			return flag;
		}
		
	function chooseOldManOver(fid,fOldManName){
		$("#fOldManNameShow").html(fOldManName);
		$("#searchOldManFid").val(fid);
		//关闭弹出的选择老人窗口
		$(".closeIcon").click();
		//选择完老人之后，重新刷新项目列表数据
		$('#tb_nursingPlanOldMan').bootstrapTable('refresh');
	}
	
	function initChooseOldManTb(){
		  $('#tb_chooseOldMan').bootstrapTable({
			   url: contextPath+'/nursingPlanOldMan/queryOldManList.do',   //请求后台的URL（*）
			   method: 'get',      //请求方式（*）
			   //toolbar: '',    //工具按钮用哪个容器
			   striped: true,      //是否显示行间隔色
			   cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			   pagination: true,     //是否显示分页（*）
			   sortable: false,      //是否启用排序
			   sortOrder: "asc",     //排序方式
			   queryParams: function (params) {
					  var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
							   pageSize: params.limit, //页面大小
							   page: params.offset, //页码
							   fOldManName : $("#searchFOldManName").val(), //老人姓名
							   froomName : $("#searchFroom").val(), //老人姓名
							   fOldManNumber : $("#searchFOldManNumber").val(), //老人编号
							   foldManStatusID : $("#searchFoldManStatusID").val() //老人状态
						  };
						  return temp;
						 },//传递参数（*）
			   sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
			   pageNumber:1,      //初始化加载第一页，默认第一页
			   pageSize: 12,      //每页的记录行数（*）
			   pageList: [12, 24, 48, 96],  //可供选择的每页的行数（*）
			   search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			   strictSearch: true,
			   showColumns: true,     //是否显示所有的列
			   showRefresh: true,     //是否显示刷新按钮
			   minimumCountColumns: 1,    //最少允许的列数
			   clickToSelect: true,    //是否启用点击选中行
			   height: 350,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			   uniqueId: "fId",      //每一行的唯一标识，一般为主键列
			   showToggle:false,     //是否显示详细视图和列表视图的切换按钮
			   showRefresh : false,  //是否显示刷新按钮
			   showColumns : false,  //是否显示列表下拉按钮
			   cardView: false,     //是否显示详细视图
			   detailView: false,     //是否显示父子表
			   singleSelect : true,
			   showHeader : false,
			   columns: [],
			   onLoadSuccess : function (data){
				    $(".fixed-table-header").removeClass("fixed-table-header");
				    var showHtml=getShowHtml(data);
				    //$("#tb_chooseOldMan").html("");
				    //$("#chooseOldMan .fixed-table-body").html(showHtml);
				    $("#tb_chooseOldMan").html(showHtml);
				 }
			  });
	};
</script>
</body>
