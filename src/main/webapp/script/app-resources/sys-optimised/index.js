


$(document).ready(function(){



});


$(document).ready(function() {



	//更新  updateCheck
	$('#form_validate_update').bootstrapValidator({
		message : 'This value is not valid',
		feedbackIcons : {
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			addOldPass : {
				message : '请填写原来密码',
				validators : {
					notEmpty : {
						message : '请填写原来密码'
					},
					remote : {// ajax验证。server result:{"valid",true or false}
						// 向服务发送当前input
						// name值，获得一个json数据。例表示正确：{"valid",true}
						url : contextPath + "/login/CheckPass.do",// 验证地址
						message : '原密码输入错误',// 提示消息
						delay : 2000,// 每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
						type : 'POST',// 请求方式
						// 自定义提交数据，默认值提交当前input value
						data : function(validator) {
							return {
								passWord : $('[name="addOldPass"]').val(),
							};
						}
					},
					//
				}
			},
			addNewPass: {
				message : '请填写新密码',
				validators : {
					notEmpty : {
						message : '请填写新密码'
					}
				}
			}


		}
	}).on('success.form.bv', function(e) {
		e.preventDefault();
		$.ajax({
			url : contextPath + "/login/updatePass.do",
			type : "post",
			data : {
				passWord : $("#addNewPass").val(),
			},
			success : function(data) {
				if (data.msg == "success") {
					setAlert(data.message, "密码更新成功");
				} else if (data.msg == "error") {
					setAlert(data.message, "密码更新失败");
				}
				$("#addOldPass").val('');
				$("#addNewPass").val('');
				$("#txtUpdatePass_message").html("更改密码成功！");



			}
		});
		$('#form_validate_update').bootstrapValidator('resetForm', true);
	});


});

function updatePass(){

alert("更改密码");

}




function closeModal() {
/*
	$("#txtOldHouse_message").val("");
*/
	$("#txtUserName_message").val("");
	$('#txtUserPass_message').val("");
	/*$("#txtOldHouse").val("");*/
	$("#txtUserName").val("");
	$('#txtUserPass').val("");

}


