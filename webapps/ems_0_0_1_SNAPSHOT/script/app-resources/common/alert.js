function setAlert(result,message){
	if("success"==result){
		$("#myAlert").attr("class","alert alert-success");
		$("#myAlert").show();
		$("#alert").html(message);
		$("#alert").show();
	}else if("error"==result){
		$("#myAlert").attr("class","alert alert-danger");
		$("#myAlert").show();
		$("#alert").html(message);
		$("#alert").show();
	}
	else if("empty"==result){
		// $("#myAlert").attr("class","alert alert-danger");
		// $("#myAlert").show();
		// $("#alert").html(message);
		// $("#alert").show();
	}
	
	window.setTimeout(function(){
		$("#myAlert").hide();
	},3000); 
}