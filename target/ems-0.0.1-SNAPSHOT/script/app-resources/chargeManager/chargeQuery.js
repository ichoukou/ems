/**
 * Created by zhangxin on 2017/3/7.
 */
$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_chargeQuery').bootstrapTable({
            url: 'query.do',   //请求后台的URL（*）
            method: 'post', //请求方式（*）
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页（*）
            sortable: false,      //是否启用排序
            showExport:false,    //显示导出按钮
            exportDataType: "basic",//导出类型basic', 'all', 'selected'.当前页、所有数据、选中数据
            sortOrder: "asc",     //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,      //初始化加载第一页，默认第一页
            pageSize: 10,      //每页的记录行数（*）
            pageList: [10, 25, 50, 100],  //可供选择的每页的行数（*）
            search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: false,
            showColumns: false,     //是否显示所有的列
            showRefresh: false,     //是否显示刷新按钮
            minimumCountColumns: 2,    //最少允许的列数
            clickToSelect: true,    //是否启用点击选中行
            height: 600,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",      //每一行的唯一标识，一般为主键列
            showToggle:false,     //是否显示详细视图和列表视图的切换按钮
            cardView: false,     //是否显示详细视图
            detailView: false,     //是否显示父子表
            columns: [{
                field: 'fID',
                title: '编号'
            },{
                field: 'fNumber',
                title: '单据编号'
            }, {
                field: 'fCostItemName',
                title: '项目'
            }, {
                field: 'fOldManName',
                title: '姓名'
            }, {
                field: 'fBedName',
                title: '床位'
            }, {
                field: 'fCostItemTypeName',
                title: '类型'
            }, {
                field: 'fAmount',
                title: '金额'
            }, {
                field: 'fPaymentDate',
                title: '缴费日期'
            }, {
                field: 'fExplation',
                title: '说明'
            }],
			onLoadSuccess : function (data){
	    		$(".fixed-table-header").removeClass("fixed-table-header");
	    	}
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset, //页码
            fCostItemID:$("#searchName option:selected").val(),
            fOldManName:$("#searchOldName").val(),
            fCostItemType:$("#searchType option:selected").val(),
            fPaymentDate:$("#searchTime").val(),
            fStarDate:$("#searchStarDate").val(),
            fEndDate:$("#searchEndDate").val()
        };
        return temp;
    };
    return oTableInit;
};
//下拉框
$(function () {
    $.ajax({
        url:contextPath+"/charge/query.do",
        type:"post",
        data:{
            page:0,
            pageSize:1000000
        },
        success:function(data) {
            $("#searchName").html("");
            var $searchName =  $("#searchName");
            $searchName.html("<option value=''>--请选择--</option>")
            for(var i=0;i<data.total;i++){
                if(data.rows[i].fStatus=="11"){
                    $searchName.append("<option value='"+data.rows[i].fID+"'>"+data.rows[i].fChrgeName+"</option>");
                }
            }
            $("#searchType").html("");
            var $searchType = $("#searchType");
            $searchType.html("<option value=''>--请选择--</option>")
            for(var i=0;i<data.total;i++){
                if(data.rows[i].fStatus=="11"){
                    $searchType.append("<option value='"+data.rows[i].fChrgeType+"'>"+data.rows[i].fChrgeType+"</option>");
                }
            }
        }
    });

})

//查询
function queryChargeQuery(){
    $.ajax({
        url:contextPath+"/chargeMonth/query.do",
        type:"post",
        data:{
            page:0,
            pageSize:10,
            fCostItemID:$("#searchName option:selected").val(),
            fOldManName:$("#searchOldName").val(),
            fCostItemType:$("#searchType option:selected").val(),
            fPaymentDate:$("#searchTime").val(),
            fStarDate:$("#searchStarDate").val(),
            fEndDate:$("#searchEndDate").val()
        },
        success:function(data) {
            $('#tb_chargeQuery').bootstrapTable('load', data);
        }
    });
}
function cleanData() {
        $("#searchName").val("");
        $("#searchOldName").val("");
        $("#searchType").val("");
        $("#searchTime").val("");
        $("#searchStarDate").val("");
        $("#searchEndDate").val("");
}