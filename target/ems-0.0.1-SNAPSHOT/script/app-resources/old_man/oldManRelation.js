$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    getOldManRelation();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_oldManMain').bootstrapTable({
            url: contextPath+'/hosing/query.do',   //请求后台的URL（*）
            method: 'post',      //请求方式（*）
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页（*）

            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,      //初始化加载第一页，默认第一页
            pageSize: 5,      //每页的记录行数（*）
            pageList: [5,10, 25, 50, 100],  //可供选择的每页的行数（*）
            search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: false,
            searchOnEnterKey:false,
            showColumns: true,     //是否显示所有的列
            showRefresh: true,     //是否显示刷新按钮
            minimumCountColumns: 2,    //最少允许的列数
            clickToSelect: true,    //是否启用点击选中行
            height: 350,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",      //每一行的唯一标识，一般为主键列
            showToggle:true,     //是否显示详细视图和列表视图的切换按钮
            cardView: false,     //是否显示详细视图
            detailView: false,     //是否显示父子表
            columns: [{
                radio: true
            }, {
                field: 'fID',
                title: '序号',
                align: "center",
                width:94
            }, {
                field: 'foldManStatusName',
                title: '状态',
                align: "center",
                /*formatter:function(value){
                    if(value=='111'){
                        return '<span style="color:#00ff00">请假</span>'
                    }else if(value=='2'){
                        return '<span style="color:#FF0000">出院</span>'
                    }else if(value=='3'){
                        return '<span style="color:#0000cc">在院</span>'
                    }
                }*/
            },  {
                field: 'foldManName',
                title: '老人',
                align: "center",
            }
            ]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset, //页码
            foldManName:$("#searchName").val()
        };
        return temp;
    };
    return oTableInit;
};




function getAddRelation(){
	var currentItem= $("#tb_oldManMain").bootstrapTable('getSelections');
	if(currentItem[0]){
		if(currentItem[0].foldManStatusName=='出院'||currentItem.foldManStatusName=='结算'){
			setAlert("error","状态不可选");
		}else{
			$("#addfOldManID").val(currentItem[0].fID);
			$("#addRelation_btn").click();
		}
	}else{
		setAlert("error","请选择一条数据");
	}
}
/**
 * 清空输入框
 */
function closeModal() {
    $("#fRelationName").val("");
    $("#fRelationAge").val("");
    $("#fRelationMobile").val("");
    $("#fRelationPhone").val("");
    $("#fRelationQQ").val("");
    $("#fRelationMM").val("");
    $("#fRelationCompany").val("");
    $("#fRelationAdrress").val("");
}

function queryBy(){
	foldManName=$("#searchName").val();
	$("#tb_oldManMain").bootstrapTable('selectPage',1);
}

function clearSearch(){
	$("#searchName").val("");
}

/**
 * 数据字典中的老人亲属信息
 */
function getOldManRelation(){
	$.ajax({
		url:contextPath+"/relation/getRelation.do",
		type:"post",
		data:{
			name:"家属关系"
		},
		success:function(data){
			var num=data.total;
			var row=data.rows;
			$("#fRelation").empty();
			$("#fRelationUpd").empty();
			$("#fRelationAdd").empty();
			if(num==0){
				$("#fRelation").append("<option value='无'>请添加可选关系</option>");
				$("#fRelationUpd").append("<option value='无'>请添加可选关系</option>");
				$("#fRelationAdd").append("<option value='无'>请添加可选关系</option>");
			}
			for(var i=0;i<num;i++){
				$("#fRelation").append("<option value="+row[i].id+">"+row[i].value+"</option>");
				$("#fRelationUpd").append("<option value="+row[i].id+">"+row[i].value+"</option>");
				$("#fRelationAdd").append("<option value="+row[i].id+">"+row[i].value+"</option>");
			}
		}
	});
}


/**
 * 得到老人亲属列表
 */
function queryRelation(){
	var currentItem= $("#tb_oldManMain").bootstrapTable('getSelections');
	if(currentItem[0]){
		if(currentItem[0].foldManStatusName=='出院'||currentItem.foldManStatusName=='结算'){
			setAlert("error","状态不可选");
		}else {
			//增加老人是使用的id
			$("#fIDAddRel").val(currentItem[0].fID);
			$("#updRelation_btn").click();
		}
	}else{
		setAlert("error","请选择一条数据");
	}
} 
/**
 * 修改老人亲属信息回显使用
 */
function updateRel(){
	var currentItem= $("#tb_relation").bootstrapTable('getSelections');
	if(currentItem[0]){
		$("#nocheck").html("");
		$.ajax({
			url : contextPath + "/relation/queryRelation.do",
			type:"post",
			data:{
				fID :currentItem[0].fID
			},
			success:function(data){
				var rows=data.rows;
				var total=data.total;
				$("#fIDUpd").val(currentItem[0].fID);
				$("#fRelationUpd").val(rows[0].fRelation);
				$("#fRelationNameUpd").val(rows[0].fRelationName);
				$("#fRelationSexUpd").val(rows[0].fRelationSex);
				$("#fRelationAgeUpd").val(rows[0].fRelationAge);
				$("#fRelationMobileUpd").val(rows[0].fRelationMobile);
				$("#fRelationPhoneUpd").val(rows[0].fRelationPhone);
				$("#fRelationQQUpd").val(rows[0].fRelationQQ);
				$("#fRelationMMUpd").val(rows[0].fRelationMM);
				$("#fRelationCompanyUpd").val(rows[0].fRelationCompany);
				$("#fRelationAdrressUpd").val(rows[0].fRelationAdrress);
				$("#queryRel_btn").click();
			}
		});
	}else{
		$("#nocheck").html("<font color='red'>请选择一条数据</red>");
	}
}
