/**
 *lizhu
 */
/**
 * 校验关系
 * 
 * @returns {Boolean}
 */
function checkRelationAdd(){
	var fRelation=$.trim($("#fRelationAdd").val());
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
function checkRelationNameAdd(){
	var fRelationName=$.trim($("#fRelationNameAdd").val());
	if(fRelationName==""||fRelationName==null){
		alert('姓名不能为空');
		return false;
	}
	return true;
}

//年龄校验
function checkAgeAdd(){
	var fRelationAge=$.trim($("#fRelationAgeAdd").val());
	var reg=new RegExp(/^\d+$/g);
	if(fRelationAge!=""&&reg.test(parseInt(fRelationAge))){
		return true;
	}
	alert('年龄不能为空或格式不正确');
	return false;
	
}
//校验手机号
function checkMobileAdd(){
	var fRelationMobile=$.trim($("#fRelationMobileAdd").val());
	var reg=new RegExp(/^1[34578]\d{9}$/);
	if(fRelationMobile!=""&&reg.test(fRelationMobile)){
		return true;
	}
	alert('手机号码格式不正确');
	return false;
}

function checkPhoneAdd(){
	var fRelationPhone=$.trim($("#fRelationPhoneAdd").val());
	var reg=new RegExp(/^([0-9]{3,4}-)?[0-9]{7,8}$/);
	if(fRelationPhone!=""&&reg.test(fRelationPhone)){
		return true;
	}
	alert('固定电话格式不正确');
	return false;
}
function checkQQAdd(){
	var fRelationQQ=$.trim($("#fRelationQQAdd").val());
	//5到11位任意整数
	var reg=new RegExp(/^\d{5,11}$/);
	if(fRelationQQ!=""&&reg.test(fRelationQQ)){
		return true;
	}
	alert('QQ格式不正确');
	return false;
}
//微信校验
function checkMMAdd(){
	var fRelationMM=$.trim($("#fRelationMMAdd").val());
	//数字和字母组成即可
	var reg=new RegExp(/^[a-zA-Z0-9]+$/);
	if(fRelationMM!=""&&reg.test(fRelationMM)){
		return true;
	}
	alert('微信格式不正确');
	return false;
}
//校验公司
function checkCompanyAdd(){
	var fRelationCompany=$.trim($("#fRelationCompanyAdd").val());
	if(fRelationCompany!=""){
		return true;
	}
	alert('工作单位不能为空');
	return false;
}
//校验家庭住址
function checkAddressAdd(){
	var fRelationAdrress=$.trim($("#fRelationAdrressAdd").val());
	if(fRelationAdrress==""){
		alert('地址不能为空');
		return false;
	}
	return true;
}
/**
 * 添加校验
 */
function checkAddRelationAdd(){
	var fRelationMobile=$.trim($("#fRelationMobileAdd").val());
	var fRelationPhone=$.trim($("#fRelationPhoneAdd").val());
	var fRelationQQ=$.trim($("#fRelationQQAdd").val());
	var fRelationMM=$.trim($("#fRelationMMAdd").val());
	//if(checkRelationAdd()&&checkRelationNameAdd()&&checkAgeAdd()&&checkMobileAdd()&&checkPhoneAdd()&&checkQQAdd()&&checkMMAdd()&&checkCompanyAdd()&&checkAddressAdd()){
	if(checkRelationAdd()&&checkRelationNameAdd()&&checkAgeAdd()){
		if(fRelationMobile!=""){
			if(!checkMobileAdd()){
				return false;
			}
		}
		if(fRelationPhone!=""){
			if(!checkPhoneAdd()){
				return false;
			}
		}
		if(fRelationQQ!=""){
			if(!checkQQAdd()){
				return false;
			}
		}
		if(fRelationMM!=""){
			if(!checkMMAdd()){
				return false;
			}
		}
			return true;
	}
	return false;
}

//新增老人家属信息
function relationAdd(){
	var fOldManID=$("#addfOldManID").val();
	var fRelation=$("#fRelationAdd").val();
	var fRelationName=$("#fRelationNameAdd").val();
	var fRelationSex=$("#fRelationSexAdd").val();
	var fRelationAge=$("#fRelationAgeAdd").val();
	var fRelationMobile=$("#fRelationMobileAdd").val();
	var fRelationPhone=$("#fRelationPhoneAdd").val();
	var fRelationQQ=$("#fRelationQQAdd").val();
	var fRelationMM=$("#fRelationMMAdd").val();
	var fRelationCompany=$("#fRelationCompanyAdd").val();
	var fRelationAdrress=$("#fRelationAdrressAdd").val();
	if(checkAddRelationAdd()){
		$.ajax({
			url:contextPath+"/relation/addRelation.do",
			type:"post",
			data:{
				fOldManID:fOldManID,
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
					alert('添加成功');
					 $('#tb_relation').bootstrapTable('refresh', {url: contextPath + "/relation/queryRelation.do"});
					 $("#control_btn").click();
				}else{
					alert('添加失败');
				}
				closeModalAddRel();
			}
		});
	}else{
		alert('请检查输入');
	}
}

/**
 * 清空输入框
 */
function closeModalAddRel() {
    $("#fRelationNameAdd").val("");
    $("#fRelationAgeAdd").val("");
    $("#fRelationMobileAdd").val("");
    $("#fRelationPhoneAdd").val("");
    $("#fRelationQQAdd").val("");
    $("#fRelationMMAdd").val("");
    $("#fRelationCompanyAdd").val("");
    $("#fRelationAdrressAdd").val("");
}
