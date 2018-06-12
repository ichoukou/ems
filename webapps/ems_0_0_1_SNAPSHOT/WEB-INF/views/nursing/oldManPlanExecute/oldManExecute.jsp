<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<head>
<style type="text/css">
	.cd_active{
    background-color:#4ad1b6;
    color: #fff;
	}
</style>
</head>

<body>
<div class="container-fluid" style="font-size: 11px; overflow: auto;"
	ng-app="ruleAddApp" id="chooseOldMan">
	<form id="formExecute" class="">
		<!-- 隐藏字段 -->
		<input type="hidden" id="foldmanid" name="foldmanid"/>
		<input type="hidden" id="fexecutepro" name="fexecutepro"/>
		<input type="hidden" id="fexcludreturn" name="fexcludreturn"/>
		<input type="hidden" id="foldmanserviceitemid" name="foldmanserviceitemid"/>
		<input type="hidden" id="fserviceplanid" name="fserviceplanid"/>
		<input type="hidden" id="fnursingHomeid" name="fnursingHomeid"/>
		
		<div class="row">
			<div class="col-xs-6 col-md-4" style="background-color: #eaeaea">
				<table class="table">
					<tr>
						<td align="center">
							<img alt="" src="xxx.png" id="oldManPhoto" name="oldManPhoto">
						</td>
					</tr>
					
					<tr>
						<td align="center">
							<span id="oldManName" name="oldManName" style="color: black;">赵楼</span>
						</td>
					</tr>
					
					<tr>
						<td align="center">
							<span id="oldManSexAge" name="oldManSexAge" style="color: black;">男/76</span>
						</td>
					</tr>
					
					<tr>
						<td align="center">
							<span id="oldManBuildingName" name="oldManBuildingName" style="color: black;">大楼1</span>
						</td>
					</tr>
				</table>
				
				<table class="table table-bordered">
					<tr>
						<td align="center">
							<span style="color: green;">护理员:</span>
						</td>
					</tr>
					<tr>
						<td align="center">
							<span id="oldManNursingName" name="oldManNursingName" style="color: black;">李护士</span>
						</td>
					</tr>
					<tr>
						<td align="center">
							<span id="oldManBuildingName" name="oldManBuildingName" style="color: green;">本次护理:</span>
						</td>
					</tr>
					<tr>
						<td align="center">
							<span id="oldManNursingTime" name="oldManNursingTime" style="color: black;">2017-02-25</span>  已执行<span id="oldManFexcludcount" name="oldManFexcludcount">0</span>次
						</td>
					</tr>
				</table>
			</div>
			<div class="col-xs-6 col-md-8">
				<table class="table">
					<tr>
						<td colspan="3" style="height: 30%;background-color: #4ad1b6;font-size: 20px;"><span><span id="oldManServiceItem" name="oldManServiceItem">整理衣物</span><span style="margin-left: 20px;">结果</span></span></td>						
					</tr>
					<tr>
						<td><span style="font-size: 15px;color: #0E977B">执行过程</span></td>
						<td colspan="2"><button type="button" id="executeSuccess" name="executeSuccess" onclick="getFexecuteproSuccess();" style="font-size: 15px;">执行顺利</button>
						<button type="button" id="executeFail" name="executeFail" onclick="getFexecuteproFail();" style="font-size: 15px;">老人不配合</button></td>						
					</tr>
					<tr>
						<td><span style="font-size: 15px;color: #0E977B">备注</span></td>
						<td colspan="2"><textarea rows="6" cols="" id="oldManFremarks" name="fremarks"></textarea></td>						
					</tr>
					<tr>
						<td  colspan="3" align="center">
						<button type="button" id="executeSure" name="executeSure" onclick="getFexcludreturnSure();" class="btn btn-warning btn-sm">确认执行</button>	
						<button type="button" id="executeNotIn" name="executeNotIn" onclick="getFexcludreturnNotIn();" class="btn btn-primary btn-sm">老人不在</button>	
						<button type="button" id="executeRefuse" name="executeRefuse" onclick="getFexcludreturnRefuse();" class="btn btn-primary btn-sm">老人拒绝</button>
						<button type="button" id="executeCancel" name="executeCancel" onclick="getFexcludreturnCancel();" class="btn btn-danger btn-sm">取消执行</button>
						</td>							
					</tr>
				</table>
			</div>
		</div>
	</form>

</div>


<script type="text/javascript">
	function add_init_comp(fid, foldmanid) {
		$("#fid").val(fid);
		$("#foldmanid").val(foldmanid);
		showOldManInfo(foldmanid);
		showOldManPlanInfo(fid);
	}
	
	function showOldManInfo(fid){
		$.ajax({
			type : 'POST',
			url : contextPath+"/oldManPlanExecute/showOldManInfo.do",
			async: false,
			data : {fid :fid},
			dataType :'json',
			success : function(obj) {
				var fPhotoSrc=contextPath+"/picture/"+obj.fPhoto;
				$("#oldManPhoto").attr("src",fPhotoSrc);
				$("#oldManName").html(obj.fOldManName);
				
				$("#oldManSexAge").html(obj.fOldManIDnSex);
				
				$("#oldManBuildingName").html(obj.fbuildingName);
				
				$("#oldManNursingName").html(obj.fnursing);
			},
			error : function() {
				flag = false;
			}
		});
	};
	
	function showOldManPlanInfo(fid){
		$.ajax({
			type : 'POST',
			url : contextPath+"/oldManPlanExecute/showOldManPlanInfo.do",
			async: false,
			data : {fid :fid},
			dataType :'json',
			success : function(obj) {
				var planDate=formatDate(new Date(obj.fserviceexecuteplandate));
				$("#oldManNursingTime").html(planDate);
				$("#oldManServiceItem").html(obj.serviceGroupName);
				$("#oldManFexcludcount").html(obj.fexcludcount);
				
				$("#foldmanserviceitemid").val(obj.foldmanserviceitemid);
				$("#fserviceplanid").val(obj.fserviceplanid);
				$("#fnursingHomeid").val(obj.fnursingHomeid);
			},
			error : function() {
				flag = false;
			}
		});
	}; 
	
	function getFexecuteproSuccess(){
		$("#executeSuccess").addClass("cd_active");
		$("#executeFail").removeClass("cd_active");
		$("#fexecutepro").val($("#executeSuccess").html());
	};
	
	function getFexecuteproFail(){
		$("#executeFail").addClass("cd_active");
		$("#executeSuccess").removeClass("cd_active");
		$("#fexecutepro").val($("#executeFail").html());
	};
	
	function getFexcludreturnSure(){
		$("#fexcludreturn").val("1");
    	saveOldManPlanExecute();
	}
	
	function getFexcludreturnNotIn(){
		$("#fexcludreturn").val("2");
    	saveOldManPlanExecute();
	}
	
	function getFexcludreturnRefuse(){
		$("#fexcludreturn").val("3");
    	saveOldManPlanExecute();
	}
	
	function getFexcludreturnCancel(){
		$("#fexcludreturn").val("4");
    	saveOldManPlanExecute();
	}
	
	function saveOldManPlanExecute(){
		var flag;
		$.ajax({
			type : 'POST',
			url : contextPath+"/oldManPlanExecute/saveOldManPlanExecute.do",
			async: false,
			data : $('#formExecute').serialize(),
			dataType :'json',
			success : function(rs) {
				if(rs.success){
					//关闭弹出的选择老人窗口
					$(".closeIcon").click();
					
					alertx(rs.msg);
					flag =  true;
					
					//刷新列表
					$("#tb_oldManPlanExecute").bootstrapTable("refresh");
				}else{
					alertx(rs.msg);
					flag = false;
				}
			},
			error : function() {
				flag = false;
			}
		});
		return flag;
	}
	
	//时间格式转化函数(年月日)
	function formatDate(date) {
	   var y = date.getFullYear();
	   var m = date.getMonth() + 1;
	   m = m < 10 ? ('0' + m) : m;
	   var d = date.getDate();
	   d = d < 10 ? ('0' + d) : d;
	   var h = date.getHours();
	   var minute = date.getMinutes();
	   minute = minute < 10 ? ('0' + minute) : minute;
	   return y + '-' + m + '-' + d;
	};
</script>
</body>