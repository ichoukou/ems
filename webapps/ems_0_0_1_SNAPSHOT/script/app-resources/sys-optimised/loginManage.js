


$(document).ready(function(){

	/*//选择养老院
	$.ajax({
		url:contextPath+"/nursing/queryStartFNursing.do",
		type:"post",
		dataType:'json',
		success:function(data) {
			//增加养老院下拉框
			$("#txtOldHouse").html("");
			var $add=$("#txtOldHouse");
			$add.append("<option value=''>-请选择一个养老院-</option>");
			for (var i=0;i<data.total;i++){
				$add.append("<option value='"+data.rows[i].fID+"'>"+data.rows[i].fNursingName+"</option>");
			}

			//养老院进行改变
			$("#txtOldHouse").change(function() {
				if($("#txtOldHouse option:selected").val()!=''){
					$("#txtOldHouse_message").html('');
				}else{
					$("#txtOldHouse_message").html('选择养老院！');
				}
			})

		}
	});
*/



});

//密码校验
function txtUserPass_check(){
	var add=$("#txtUserPass").val().trim();
	$("#txtUserPass_message").html("");
	if(add==null||add.length==0||add==''){
		$("#txtUserPass_message").html("密码不能为空");
	}
}
//用户名校验
function txtUserName_check(){
	var user=$("#txtUserName").val().trim();
	$("#txtUserName_message").html("");
	if(user==null||user.length==0||user==''){
		$("#txtUserName_message").html("用户名不能为空！");
	}
}
//总校验
function check(form) {
	var pass=$("#txtUserPass").val().trim();
	var user=$("#txtUserName").val().trim();

	result = true;

	if(pass==null||pass.length==0){
		$("#txtUserPass_message").html("密码不能为空！");
		result = false;
	}

	if(user==null||user.length==0){
		$("#txtUserName_message").html("用户名不能为空！");
		result = false;

	}
	return result;

}




