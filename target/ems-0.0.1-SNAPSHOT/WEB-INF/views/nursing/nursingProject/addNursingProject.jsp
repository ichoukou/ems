<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>	

<div class="container-fluid" style="font-size: 11px;overflow:auto;"
	ng-app="ruleAddApp" id="ruleadd">
	<form class="form-horizontal" id="addNursingProject_form" action="#"
		role="form">
		<input  type="hidden" id="fid" name="fid" value=""/>
		<div class="form-inline" role="serchFrom" style="margin-bottom: 10px;">
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">护理编号:</div>
					<input type="text" class="form-control input-sm"
						name="fNumber" id="fNumber"
						value="${fNumber }"  readonly="readonly">
				</div>

				<div class="input-group">
					<div class="input-group-addon">护理类型</div>
						<select class="form-control input-sm" id="fServiceGroupID" name="fServiceGroupID"  >
							
						</select>
				</div>
			</div>
		</div>
		
		<div class="form-inline" role="serchFrom" style="margin-bottom: 10px;">
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">项目名称:</div>
					<input type="text" class="form-control input-sm" name="fName" id="fName" value="" >
				</div>

				<div class="input-group">
					<div class="input-group-addon">执行类型</div>
						<select class="form-control input-sm" id="fExecuteType" name="fExecuteType"  onchange="showOrHideCycle();">
							<option value="1">定时执行</option>
							<option value="2">随机执行</option>
						</select>
				</div>
			</div>
		</div>
		
		<div class="form-inline" role="serchFrom" style="margin-bottom: 10px;">
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">所属护理级别:</div>
					<select id="fserviceLevels" name="fserviceLevels" multiple="multiple" style="overflow:auto;">
						
					</select>
				</div>
			</div>
		</div>
		
		<div class="form-inline" role="serchFrom" style="margin-bottom: 10px;">
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">执行频率:</div>
					<div class="input-group-addon">
					每<input type="text" style="width: 50px" id="fExecutecycle">
					<select style="width: 50px" id="fExecutecycleUnit" name="fExecutecycleUnit" onchange="checkUnit();" >
							<option value="1">天</option>
							<option value="2">周</option>
							<option value="3">月</option>
							<option value="4">年</option>
						</select>执行
						<input type="text" style="width: 50px" name="fExecuteQty" id="fExecuteQty" value="">次，
						每次需花费<input type="text" style="width: 50px" name="fExcludtime" id="fExcludtime" value="">分钟 
						</div>
				</div>
			</div>
		</div>
		<div id="showTimingOptions">
		<div class="form-inline" role="serchFrom" style="margin-bottom: 10px;">
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">具体执行时间:</div>
					<div class="input-group-addon">
					<div class="row">
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="0">0点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="1">1点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="2">2点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="3">3点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="4">4点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="5">5点
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="6">6点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="7">7点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="8">8点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="9">9点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="10">10点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="11">11点
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="12">12点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="13">13点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="14">14点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="15">15点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="16">16点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="17">17点
						</div>
					</div>
					<div class="row">
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="18">18点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="19">19点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="20">20点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="21">21点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="22">22点
						</div>
						<div class="col-md-2">
							<input type="checkbox" class="form-control input-sm" name="fExecutetime" id="" value="23">23点
						</div>
					</div>
					</div>
				</div>
			</div>
		</div>
		</div>
		
		<div class="form-inline" role="serchFrom" style="margin-bottom: 10px;">
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">启用日期:</div>
					<input type="date" id="fStarteDate" name="fStarteDate" class="form-control input-sm">
				</div>
			</div>
		</div>
		
		<div class="form-inline" role="serchFrom" style="margin-bottom: 10px;">
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-addon">项目备注:</div>
					<input type="text" id="fRemarks" name="fRemarks" style="width: 300px;" class="form-control input-sm">
				</div>
			</div>
		</div>
		
		<div>
			<input type="hidden" id="fExecutecycleValue" name="fExecutecycle"/>
		</div>
	</form>
</div>


<script type="text/javascript">
	$(function(){
		//初始化护理类型下拉选项值
		getServiceGroups();
		//初始化护理级别下拉选项值
		getServiceLevels();
		$('#fserviceLevels').multiselect({
			nonSelectedText:"请选择",

	        includeSelectAllOption: true,

	        numberDisplayed: 100,

	        maxHeight:200
		}
		);
		var today=new Date();
		today=formatDate(today);
		
		//设置启用日期只能选今天及之后的日期
		$("#fStarteDate").attr("min",today);
		
		//检查 执行频率
		checkUnit();
	})
	
	function getServiceGroups(){
		var flag;
		$.ajax({
			type : 'POST',
			url : contextPath+"/nursingProject/getServiceGroups.do",
			data:{},
			async: false,
			success : function(rs) {
				var optionsHtml="";
				for(var i=0;i<rs.length;i++){
					var detailInfo=rs[i];
					optionsHtml +="<option value='"+detailInfo.fid+"'>"+detailInfo.fName+"</option>"
				}
				
				$("#fServiceGroupID").append(optionsHtml);
				
				flag=true;
			},
			error : function() {
				flag = false;
			} 
		});
		return flag;
	}
	
	function getServiceLevels(){
		var flag;
		$.ajax({
			type : 'POST',
			url :  contextPath+"/nursingProject/getServiceLevels.do",
			data:{},
			async: false,
			success : function(rs) {
				var optionsHtml="";
				for(var i=0;i<rs.length;i++){
					var detailInfo=rs[i];
					optionsHtml +="<option value='"+detailInfo.id+"'>"+detailInfo.value+"</option>"
				}
				
				$("#fserviceLevels").append(optionsHtml);
				flag=true;
			},
			error : function() {
				flag = false;
			} 
		});
		return flag;
	}
	//初始化
	function add_init_comp(fid,fserviceType) {
		if(fid){
			$("#fid").val(fid);
			getNursingProject(fid);
			
			//判断项目是否被老人或者公共引用
			checkProjectUsed(fid,fserviceType);
		}
	}
	
	function getNursingProject(fid){
			var flag;
			$.ajax({
				type : 'POST',
				url :  contextPath+"/nursingProject/getNursingProject.do",
				data:{fid : fid},
				async: false,
				success : function(rs) {
					var fserviceLevels=getServiceLevelByFparentId(fid);
					//设置值
					setFormValues(rs,fserviceLevels);
					flag=true;
				},
				error : function() {
					flag = false;
				} 
			});
			return flag;
	}
	
	function checkProjectUsed(fid,fserviceType){
		var flag;
		$.ajax({
			type : 'POST',
			url :  contextPath+"/nursingProject/checkProjectUsed.do",
			data:{fid : fid,fserviceType : fserviceType},
			async: false,
			success : function(rs) {
				if(rs.success){
					//有被引用时，不能修改启用日期
					$("#fStarteDate").attr("disabled",true);
				}else{
					//未被引用时，可以修改启用日期
					$("#fStarteDate").disabled = false;
				}
				flag=true;
			},
			error : function() {
				flag = false;
			} 
		});
		return flag
	}
	
	function getServiceLevelByFparentId(fid){
		var fserviceLevels="";
		$.ajax({
			type : 'POST',
			url :  contextPath+"/nursingProject/getServiceLevelByFparentId.do",
			data:{fid : fid},
			async: false,
			success : function(rs) {
				for (var i = 0; i < rs.length; i++) {
					if(i==(rs.length-1)){
						fserviceLevels+=rs[i].fNurseLevelID;
					}else{
						fserviceLevels+=rs[i].fNurseLevelID+",";
					}
				}
			},
			error : function() {
			} 
		});
		return fserviceLevels;
	}
	
	function setFormValues(nursingProject,fserviceLevels){
		$("#fNumber").val(nursingProject.fNumber);
		$("#fExecuteType").val(nursingProject.fExecuteType).trigger("change");
		$("#fName").val(nursingProject.fName);
		//护理类型
		$("#fServiceGroupID").val(nursingProject.fServiceGroupID).trigger("change");
		//护理级别单独设置
		setServiceLevelsValue(fserviceLevels);
		
		//执行平率单独设置
		setExecutecycleValue(nursingProject.fExecutecycle);
		
		$("#fExecuteQty").val(nursingProject.fExecuteQty);
		$("#fExcludtime").val(nursingProject.fExcludtime);
		//执行时间单独设置
		setExecuteTimeValue(nursingProject.fExecutetime)
		
		var fStarteDate=formatDate(new Date(nursingProject.fStarteDate));
		$("#fStarteDate").val(fStarteDate);
		$("#fRemarks").val(nursingProject.fRemarks);
	}
	
	function setServiceLevelsValue(fserviceLevels){
		
		 var val = fserviceLevels.split(",");
		 var valArr=new Array();
		 for (var i = 0; i < val.length; i++) {
			 valArr.push(val[i])
		}
		 $('#fserviceLevels').multiselect('select', valArr);
	}
	
	function setExecutecycleValue(fExecutecycle){
		if(fExecutecycle){
			var fExecutecycleUnit="1";
			if(fExecutecycle%7==0){
				fExecutecycle=fExecutecycle/7;
				fExecutecycleUnit="2";
			}
			if(fExecutecycle%30==0){
				fExecutecycle=fExecutecycle/30;
				fExecutecycleUnit="3";
			}
			
			if(fExecutecycle%365==0){
				fExecutecycle=fExecutecycle/365;
				fExecutecycleUnit="4";
			}
			
			$("#fExecutecycle").val(fExecutecycle);
			$("#fExecutecycleUnit").val(fExecutecycleUnit).trigger("change");
		}
	}
	
	function setExecuteTimeValue(fExecutetime){
		if(fExecutetime){
			 var val = fExecutetime.split(",");
			    var boxes = document.getElementsByName("fExecutetime");
			    for(var i=0;i<boxes.length;i++){
			        for(var j=0;j<val.length;j++){
			            if(boxes[i].value == val[j]){
			                boxes[i].checked = true;
			                break;
			            }
			        }
			    }
		    }
	}
	
	function showOrHideCycle(){
		//当执行类型为 2-随机执行时，隐藏执行频率
		var fExecuteType=$("#fExecuteType").val();
		if(fExecuteType==2){
			$("#showTimingOptions").hide();
		}else{
			$("#showTimingOptions").show();
		}
	}
	
	function checkSomeValue(){
		var flag=true;
		
		var fName=$("#fName").val();
		if(fName==null || fName ==""){
			alertx("请填写项目名称!");
			flag=false;
			return flag;
		}
		
		
		var fExecuteType=$("#fExecuteType").val();
		
			var fExecutecycle=$("#fExecutecycle").val();
			if(fExecutecycle==null || fExecutecycle ==""){
				alertx("执行频率,数据未填写完全!");
				flag=false;
				return flag;
			}
			
			var fExecuteQty=$("#fExecuteQty").val();
			if(fExecuteQty==null || fExecuteQty ==""){
				alertx("执行频率,数据未填写完全!");
				flag=false;
				return flag;
			}
			
			var fExcludtime=$("#fExcludtime").val();
			if(fExcludtime==null || fExcludtime ==""){
				alertx("执行频率,数据未填写完全!");
				flag=false;
				return flag;
			}
			
			 var fExecutetime=document.getElementsByName("fExecutetime");
			 var fExecutetimes=new Array();
			 for(var i=0;i<fExecutetime.length;i++){
		         if(fExecutetime[i].checked){
		         	fExecutetimes.push(fExecutetime[i].value);
		       }
		    }
			 
		if(fExecuteType==1){	 
			if(fExecutetimes.length<1){
				alertx("请勾选执行时间!");
				flag=false;
				return flag;
			}else{
				if(fExecuteQty !=fExecutetimes.length){
					alertx("执行次数与执行时间次数不一致!");
					flag=false;
					return flag;
				}
			}
		}
		
		var fStarteDate=$("#fStarteDate").val();
		if(fStarteDate==null || fStarteDate ==""){
			alertx("请填写启用日期!");
			flag=false;
			return flag;
		}
		
		var unit =$("#fExecutecycleUnit").val();
		if(unit==1){
			if(fExecutecycle !=1 && fExecuteQty !=1){
				alertx("执行频率只能为1天N次或者N天1次!");
				flag=false;
				return flag;
			}
		}
		
		return flag;
	}
	
	function checkUnit(){
		var unit =$("#fExecutecycleUnit").val();
		if(unit==1){
			//$("#fExecutecycle").attr("disabled",true).val("1");
			$("#fExecuteQty").attr("disabled",false);
		}else{
			$("#fExecutecycle").attr("disabled",false);
			$("#fExecuteQty").attr("disabled",true).val("1");
		}
		
	}
</script>
