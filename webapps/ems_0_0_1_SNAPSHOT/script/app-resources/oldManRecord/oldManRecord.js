/**
 * lizhu
 */
$(function () {
    // 1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    getRecordType();
    getEmpMessage();
});

var TableInit = function () {
    var oTableInit = new Object();
    // 初始化Table
    oTableInit.Init = function () {
        $('#tb_oldManRecord').bootstrapTable({
            url: 'query.do',   // 请求后台的URL（*）
            method: 'get',      //请求方式（*）
            toolbar: '#toolbar',    // 工具按钮用哪个容器
            striped: true,      // 是否显示行间隔色
            cache: false,      // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     // 是否显示分页（*）
            sortable: false,      // 是否启用排序
            sortOrder: "asc",     // 排序方式
            queryParams: oTableInit.queryParams,// 传递参数（*）
            sidePagination: "server",   // 分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,      // 初始化加载第一页，默认第一页
            pageSize: 10,      // 每页的记录行数（*）
            pageList: [10, 25, 50, 100],  // 可供选择的每页的行数（*）
            search: false,      // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,     // 是否显示所有的列
            showRefresh: true,     // 是否显示刷新按钮
            minimumCountColumns: 2,    // 最少允许的列数
            clickToSelect: true,    // 是否启用点击选中行
            height: 350,      // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",      // 每一行的唯一标识，一般为主键列
            showToggle:true,     // 是否显示详细视图和列表视图的切换按钮
            cardView: false,     // 是否显示详细视图
            detailView: false,     // 是否显示父子表
            columns: [{
                radio: true
            }, {
                field: 'fID',
                title: '编号'
            },  {
                field: 'foldManName',
                title: '老人'
            }, {
                field: 'fKeeperName',
                title: '责任人'
            }, {
                field: 'fRecordDate',
                title: '时间'
            }, {
                field: 'fRecordName',
                title: '事故类型'
            }, {
                field: 'fExplain',
                title: '事故原因'
            }],
        });
    };

    // 得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, // 页面大小
            page: params.offset // 页码
        };
        return temp;
    };
    return oTableInit;
};
/**
 * 按条件检索
 */
function queryBy(){
	var foldManName=$("#foldManName").val();
	var startDate=$("#startDate").val();
	var endDate=$("#endDate").val();
	var fRecordDate;
	if(startDate!=""&&endDate!=""){
		fRecordDate=startDate+"@"+endDate;
	}else if(startDate!=""){
		fRecordDate=startDate;
	}else{
		fRecordDate=endDate;
	}
	$.ajax({
		url:contextPath + "/record/query.do",
		type:"post",
		data:{
			foldManName:foldManName,
			fRecordDate:fRecordDate,
			pageSize:10, // 页面大小
	        page:0 // 页码
		},
		success:function(data){
			 $('#tb_oldManRecord').bootstrapTable('load', data);
		}
	});
}

/**
 * 清空搜索框
 */
function clearQueryInput(){
	$("#foldManName").val("");
	$("#startDate").val("");
	$("#endDate").val("");
}

//请求选择老人界面
function selectOldMan(){
	$('#oldManModal').modal('show');
	// 初始化老人列表
	initChooseOldManTb();
}
//打通过照片取老人
function getOldManWithPhoto(ID,name){
	// $("#addfOldManID").val(temp.getAttribute("selectOmId"))
	// $("#addfOldManID").html(temp.getAttribute("selectName"))
	$("#addfOldManID").val(ID);
	$("#oldManName").val(name);
	// $("#addfOldManID").text(temp.getAttribute("selectName"))
	$('#oldManModal').modal('hide')
}

/**
 * 回显用的类型名称
 */
function getRecordType(){
	$.ajax({
		url:contextPath + "/record/queryType.do",
		type:"post",
		data:{
			dcName:"日常行为类型"
		},
		success:function(data){
			var dcList=data.rows;
			var dcLength=data.total;
			for(var i=0;i<dcLength;i++){
				$("#recordType").append("<option value='" + data.rows[i].id + "'>"
						+ data.rows[i].value + "</option>");
				$("#up_recordType").append("<option value='" + data.rows[i].id + "'>"
						+ data.rows[i].value + "</option>");
			}
		}
	});
}
/**
 * 得到员工表中信息  回显使用
 */
function getEmpMessage(){
	$.ajax({
		url:contextPath+"/record/getEmp.do",
		type:"post",
		data:{
		},
		success:function(data){
			var empList=data.rows;
			var empLength=data.total;
			for(var i=0;i<empLength;i++){
				$("#fKeeper").append("<option value='"+ data.rows[i].fId+"'>"
						+data.rows[i].fStaffName)+"</option>";
				$("#up_fKeeper").append("<option value='"+ data.rows[i].fId+"'>"
						+data.rows[i].fStaffName)+"</option>";
			}
		}
	});
}
/**
 * 添加老人日常事故
 */
function add(){
	var fOldManId=$("#addfOldManID").val();
	var fRecordDate=$("#fRecordDate").val();
	var fRecordType=$("#recordType").val();
	var fExplain=$("#fExplain").val();
	var fKeeper=$("#fKeeper").val();
	if(checkName()&&checkDate()&&checkReason()){
		document.getElementById("addButton").setAttribute("data-dismiss","modal");
		$.ajax({
			url:contextPath+"/record/addRecord.do",
			type:"post",
			data:{
				fOldManId:fOldManId,
				fRecordDate:fRecordDate,
				fExplain:fExplain,
				fKeeper:fKeeper,
				fRecordType:fRecordType
			},
			success:function(data){
				var msg=data.message;
				if(msg=="老人不存在"){
					document.getElementById("addButton").removeAttribute("data-dismiss");
					setAlert("error","老人不存在");;
				}else{
					document.getElementById("addButton").setAttribute("data-dismiss","modal");
					$('#tb_oldManRecord').bootstrapTable('refresh', {url: 'query.do'});
					setAlert("success","操作成功");
				}
			}
		});
	}else{
		document.getElementById("addButton").removeAttribute("data-dismiss");
		setAlert("error","操作失败");
	}
}
/**
 * 删除日常行为记录
 */
function deleteRecord(){
	 var currentItem = $("#tb_oldManRecord").bootstrapTable('getSelections');
	    if(currentItem[0]){
	      $.ajax({
	    	 url:contextPath+"/record/deleteRecord.do",
	    	 type:"post",
	    	 data:{
	    		 fID:currentItem[0].fID
	    	 },
	    	 success:function(data){
	    		 $('#tb_oldManRecord').bootstrapTable('refresh', {url: 'query.do'});
		         setAlert("success","操作成功");
	    	 }
	      });
	    }else{
	        setAlert("error","请先选择一条数据");
	    }
}
/**
 * 跳转至修改页面并回显所有内容
 */
function getUpdateModal(){
	var currentItem=$("#tb_oldManRecord").bootstrapTable('getSelections');
	if(currentItem[0]){
		document.getElementById("updateButton").setAttribute("data-target", "#updateModal");
		$("#up_oldManId").val(currentItem[0].foldManName);
		$("#up_fRecordDate").val(currentItem[0].fRecordDate);
		$("#up_fExplain").val(currentItem[0].fExplain);
		$("#up_fID").val(currentItem[0].fID);
		//遍历下拉框中的所有值 与选中记录中的值进行对比  相同就让该项选中
		$("#up_recordType option").each(function () {
            var txt = $(this).text(); //获取单个text
            if(currentItem[0].fRecordName==txt){
            	$(this).attr("selected",true);
            }
        });
		$("#up_fKeeper option").each(function () {
            var txt = $(this).text(); //获取单个text
            if(currentItem[0].fKeeperName==txt){
            	$(this).attr("selected",true);
            }
        });
	}else{
		 setAlert("error","请先选择一条数据");
	}
}

function updateRecord(){
	var up_fID=$("#up_fID").val();
	var fRecordDate=$("#up_fRecordDate").val();
	var fRecordType=$("#up_recordType").val();
	var fExplain=$("#up_fExplain").val();
	var fKeeper=$("#up_fKeeper").val();
	if(up_checkReason()){
	$.ajax({
		url:contextPath+"/record/updateRecord.do",
		type:"post",
		data:{
			fID:up_fID,
			fRecordDate:fRecordDate,
			fExplain:fExplain,
			fKeeper:fKeeper,
			fRecordType:fRecordType
		},
		 success:function(data){
			 if(data.message=="success"){
				 $('#tb_oldManRecord').bootstrapTable('refresh', {url: 'query.do'});
	    		 document.getElementById("up_Button").setAttribute("data-dismiss","modal");
		         setAlert("success","操作成功");
			 }else{
				 setAlert("error","操作失败");
			 }
    	 }
	});
	}else{
		document.getElementById("up_Button").removeAttribute("data-dismiss");
	}
}

/**
 * 用户名校验（非空）
 */
function checkName(){
	var oldManName=$("#oldManName").val();
	if($("#showId")!=null||$("#showId")!=""){
		$("#showId").remove();
	}
	if(oldManName==""||oldManName=="单击选择老人"){
		$("#errorName").append("<font color='red' id='showId'>请选择老人</font>");
		return false;
	}
	$("#errorName").append("");
	return true;
}
/**
 * 退住时间非空校验
 */
function checkDate(){
	var fRecordDate=$("#fRecordDate").val();
	if($("#showTime")!=null||$("#showTime")!=""){
		$("#showTime").remove();
	}
	if(fRecordDate==""){
		$("#errorDate").append("<font color='red' id='showTime'>请选择时间</font>");
		return false;
	}
	$("#errorDate").append("");
	return true;
}
/**
 * 事故原因校验
 * @returns
 */
function checkReason(){
	var fExplain=$("#fExplain").val();
	if($("#showReason")!=null||$("#showReason")!=""){
		$("#showReason").remove();
	}
	if(fExplain==""){
		$("#errorReason").append("<font color='red' id='showReason'>请输入原因</font>");
		return false;
	}
	$("#errorReason").append("");
	return true;
}
/**
 * 这是修改时候的校验
 * @returns
 */
function up_checkReason(){
	var fExplain=$("#up_fExplain").val();
	if($("#up_showReason")!=null||$("#up_showReason")!=""){
		$("#up_showReason").remove();
	}
	if(fExplain==""){
		$("#up_errorReason").append("<font color='red' id='up_showReason'>请输入原因</font>");
		return false;
	}
	$("#up_errorReason").append("");
	return true;
}

$(function(){
	$("#addRecord_button").click(function(){
		clearInput();
	});
});

/**
 * 清除所有的框
 */
function clearInput(){
	$("#oldManName").val("");
	$("#fRecordDate").val("");
	$("#fExplain").val("");
	removeError();
}
/**
 * 去掉错误提示
 */
function removeError(){
	if($("#showId")!=null||$("#showId")!=""){
		$("#showId").remove();
	}
	if($("#showTime")!=null||$("#showTime")!=""){
		$("#showTime").remove();
	}
	if($("#showReason")!=null||$("#showReason")!=""){
		$("#showReason").remove();
	}
}