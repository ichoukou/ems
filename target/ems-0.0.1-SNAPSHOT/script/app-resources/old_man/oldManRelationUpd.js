/**
 *lizhu
 */
$(function () {
	getOldManRelation();
});
/**
 * 校验关系
 * 
 * @returns {Boolean}
 */
function checkRelationUpd(){
	var fRelation=$.trim($("#fRelationUpd").val());
	if(fRelation=="无"||fRelation==null){
		alert('无可选关系');
		return false;
	}
	return true;
}

/**
 * 校验姓名
 * 
 * @returns {Boolean}
 */
function checkRelationNameUpd(){
	var fRelationName=$.trim($("#fRelationNameUpd").val());
	if(fRelationName==""||fRelationName==null){
		alert('姓名不能为空');
		return false;
	}
	return true;
}

//年龄校验
function checkAgeUpd(){
	var fRelationAge=$.trim($("#fRelationAgeUpd").val());
	var reg=new RegExp(/^\d+$/g);
	if(fRelationAge!=""&&reg.test(parseInt(fRelationAge))){
		return true;
	}
	alert('年龄不能为空或格式不正确');
	return false;
	
}
//校验手机号
function checkMobileUpd(){
	var fRelationMobile=$.trim($("#fRelationMobileUpd").val());
	var reg=new RegExp(/^1[34578]\d{9}$/);
	if(fRelationMobile!=""&&reg.test(fRelationMobile)){
		return true;
	}
	alert('手机号码格式不正确');
	return false;
}

function checkPhoneUpd(){
	var fRelationPhone=$.trim($("#fRelationPhoneUpd").val());
	var reg=new RegExp(/^([0-9]{3,4}-)?[0-9]{7,8}$/);
	if(fRelationPhone!=""&&reg.test(fRelationPhone)){
		return true;
	}
	alert('固定电话格式不正确');
	return false;
}
function checkQQUpd(){
	var fRelationQQ=$.trim($("#fRelationQQUpd").val());
	//5到11位任意整数
	var reg=new RegExp(/^\d{5,11}$/);
	if(fRelationQQ!=""&&reg.test(fRelationQQ)){
		return true;
	}
	alert('QQ格式不正确');
	return false;
}
//微信校验
function checkMMUpd(){
	var fRelationMM=$.trim($("#fRelationMMUpd").val());
	//数字和字母组成即可
	var reg=new RegExp(/^[a-zA-Z0-9]+$/);
	if(fRelationMM!=""&&reg.test(fRelationMM)){
		return true;
	}
	alert('微信格式不正确');
	return false;
}
//校验公司
function checkCompanyUpd(){
	var fRelationCompany=$.trim($("#fRelationCompanyUpd").val());
	if(fRelationCompany!=""){
		return true;
	}
	alert('工作单位不能为空');
	return false;
}
//校验家庭住址
function checkAddressUpd(){
	var fRelationAdrress=$.trim($("#fRelationAdrressUpd").val());
	if(fRelationAdrress==""){
		alert('地址不能为空');
		return false;
	}
	return true;
}
/**
 * 添加校验
 */
function checkAddRelationUpd(){
	//if(checkRelationUpd()&&checkRelationNameUpd()&&checkAgeUpd()&&checkMobileUpd()&&checkPhoneUpd()&&checkQQUpd()&&checkMMUpd()&&checkCompanyUpd()&&checkAddressUpd()){
	if(checkRelationUpd()&&checkRelationNameUpd()){
		return true;
	}
	return false;
}

//修改老人亲属信息
function updRelation(){
	var fID=$("#fIDUpd").val();
	var fRelation=$("#fRelationUpd").val();
	var fRelationName=$("#fRelationNameUpd").val();
	var fRelationSex=$("#fRelationSexUpd").val();
	var fRelationAge=$("#fRelationAgeUpd").val();
	var fRelationMobile=$("#fRelationMobileUpd").val();
	var fRelationPhone=$("#fRelationPhoneUpd").val();
	var fRelationQQ=$("#fRelationQQUpd").val();
	var fRelationMM=$("#fRelationMMUpd").val();
	var fRelationCompany=$("#fRelationCompanyUpd").val();
	var fRelationAdrress=$("#fRelationAdrressUpd").val();
	if(checkAddRelationUpd()){
		$.ajax({
			url:contextPath+"/relation/updateRelation.do",
			type:"post",
			data:{
				fID:fID,
				fRelation:fRelation,
				fRelationName:fRelationName,
				fRelationSex:fRelationSex,
				fRelationAge:fRelationAge,
				fRelationMobile:fRelationMobile,
				fRelationPhone:fRelationPhone,
				fRelationQQ:fRelationQQ,
				fRelationMM:fRelationMM,
				fRelationCompany:fRelationCompany,
				fRelationAdrress:fRelationAdrress,
			},
			success:function(data) {
				if(data.msg=="success"){
					alert('修改成功');
					 $('#tb_relation').bootstrapTable('refresh', {url: contextPath + "/relation/queryRelation.do"});
				}else{
					alert('修改失败');
				}
				closeModal();
			}
		});
	}else{
		alert('请检查输入');
	}
}

/**
 * 清空输入框
 */
function closeModalUpd() {
    $("#fRelationNameUpd").val("");
    $("#fRelationAgeUpd").val("");
    $("#fRelationMobileUpd").val("");
    $("#fRelationPhoneUpd").val("");
    $("#fRelationQQUpd").val("");
    $("#fRelationMMUpd").val("");
    $("#fRelationCompanyUpd").val("");
    $("#fRelationAdrressUpd").val("");
}
