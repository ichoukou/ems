/**
 * Created by lizhu
 */
//新增健康信息
function healthyAdd(){
		if(checkAddHeal()){
			$.ajax({
				url:contextPath+"/healthy/add.do",
				type:"post",
				data:{
					fOldManID:$("#addfOldManID").val(),
					fHealthyCondition:$("#fHealthyConditionAdd").val(),
					fMedicalHistory:$("#fMedicalHistoryAdd").val(),
					fDietTrait:$("#fDietTraitAdd").val(),
					fAttention:$("#fAttentionAdd").val(),
					fHobby:$("#fHobbyAdd").val(),
				},
				success:function(data) {
		            $('#tb_oldManHealthy').bootstrapTable('refresh', {url: 'oldMan.do'});
		            if(data.msg=="success"){
		            	setAlert("success","添加成功");
		            	closeModal();
		            }else{
		            	setAlert("error","添加失败");
		            }
				}
			});
		}
	}
/**
 * 清除输入框
 */
function closeModal() {
    $("#fHealthyConditionAdd").val("");
    $("#fMedicalHistoryAdd").val("");
    $("#fDietTraitAdd").val("");
    $("#fAttentionAdd").val("");
    $("#fHobbyAdd").val("");
}
//健康信息新增
function checkAddFHealthyCondition(){
	var fHealthyCondition=$("#fHealthyConditionAdd").val().trim();
	if(fHealthyCondition==""){
		alert('请填写健康信息');
		return false;
	}
	return true;
}
//医疗病史新增
function checkAddFMedicalHistory(){
	var fMedicalHistory=$("#fMedicalHistoryAdd").val().trim();
	if(fMedicalHistory==""){
		alert('请填写老人病史');
		return false;
	}
	return true;
}
//饮食特点新增
function checkAddFDietTrait(){
	var fDietTrait=$("#fDietTraitAdd").val().trim();
	if(fDietTrait==""){
		alert('请填写饮食特点');
		return false;
	}
	return true;
}
//注意事项新增
function checkAddFAttention(){
	var fAttention=$("#fAttentionAdd").val().trim();
	if(fAttention==""){
		alert('请填写注意事项');
		return false;
	}
	return true;
}
//注意老人嗜好新增
function checkAddFHobby(){
	var fHobby=$("#fHobbyAdd").val().trim();
	if(fHobby==""){
		alert('请填写老人嗜好');
		return false;
	}
	return true;
}
//校验
function checkAddHeal(){
	if(checkAddFHealthyCondition()&&checkAddFMedicalHistory()&&checkAddFDietTrait()&&checkAddFAttention()&&checkAddFHobby()){
		return true;
	}
	return false;
}

function clearInputAdd(){
	$("#fHealthyConditionAdd").val("");
	$("#fMedicalHistoryAdd").val("");
	$("#fDietTraitAdd").val("");
	$("#fAttentionAdd").val("");
	$("#fHobbyAdd").val("");
}