
$(function () {
	getDcList();
	
    //1.初始化Table
	initChargeStandardTable();
	
	chargeStandardGrid=$("#tb_chargeStandard").bootstrapTable();
});

function initChargeStandardTable(){
    $('#tb_chargeStandard').bootstrapTable({
        url: contextPath+'/charge/query.do',   //请求后台的URL（*）
        method: 'post',      //请求方式（*）
        contentType:"application/x-www-form-urlencoded; charset=UTF-8",
        toolbar: '',    //工具按钮用哪个容器
        striped: true,      //是否显示行间隔色
        cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: true,     //是否显示分页（*）
        sortable: false,      //是否启用排序
        sortOrder: "asc",     //排序方式
        queryParams: function (params) {
            var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                    pageSize: params.limit, //页面大小
                    page: params.offset, //页码
                    // flag:"true",
                    fChrgeName:$("#searchName").val(),
                    fChrgeType:$("#searchType").val(),
                    fStatus:'11',  //默认查询启用状态的数据
                    value: $("#searchValue").val()
                };
                return temp;
            },//传递参数（*）
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
        height: 350,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        uniqueId: "ID",      //每一行的唯一标识，一般为主键列
        showToggle:false,     //是否显示详细视图和列表视图的切换按钮
        cardView: false,     //是否显示详细视图
        detailView: false,     //是否显示父子表

        columns: [{
            radio: true
        }, {
            sortable: true,
            field: 'fChrgeNumber',
            title: '编号',
            align: "center",
        }, {
            field: 'fChrgeName',
            title: '费用名称',
            align: "center",
        }, {
            field: 'fChrgeTypeName',
            title: '费用类别',
            align: "center",
        }, {
            field: 'fChargeCycleName',
            title: '费用周期',
            align: "center",
        }, {
            field: 'fNursingLevelName',
            title: '护理级别',
            align: "center",
        }, {
            field: 'fPrice',
            title: '单价',
            align: "center",
        }, {
            field: 'fUnitName',
            title: '单位',
            align: "center",
        }, {
            field: 'fRefundType',
            title: '退住时退款',
            align: "center",
            formatter:function(value){
                if(value=='1'){
                    return '<span>是</span>'
                }else if(value=='0'){
                    return '<span>否</span>'
                }
            }
        }, {
            field: 'fChrgeStartDate',
            title: '费用开始日期',
            align: "center",
        }, {
            field: 'fChrgeStopDate',
            title: '费用结束日期',
            align: "center",
        }, {
            field: 'fStatus',
            title: '状态',
            align: "center",
            formatter:function(value){
                if(value=='11'){
                    return '<span>启用</span>'
                }else if(value=='10'){
                    return '<span>禁用</span>'
                }
            }
        }, {
            field: 'fExplain',
            title: '说明',
            align: "center",
        }, {
            field: 'fValidityStartDate',
            title: '有效期开始时间',
            align: "center",
        }, {
            field: 'fValidityEndDate',
            title: '有效期结束时间',
            align: "center",
        }, {
            field: 'fIsALLFee',
            title: '全院必收费用',
            align: "center",
            formatter:function(value){
                if(value=='1'){
                    return '<span>是</span>'
                }else if(value=='0'){
                    return '<span>否</span>'
                }
            }
        }, {
            field: 'fIsCycleFee',
            title: '循环费用',
            align: "center",
            formatter:function(value){
                if(value=='1'){
                    return '<span>是</span>'
                }else if(value=='0'){
                    return '<span>否</span>'
                }
            }
        }],
		onLoadSuccess : function (data){
    		$(".fixed-table-header").removeClass("fixed-table-header");
    	}
    });
}

function queryClear(){
    $("#searchName").val(""),
    $("#searchType").val(""),
    $("#searchStatus").val("")
}
//查询收费标准
function queryStandard(){
    $.ajax({
        url:contextPath+"/charge/query.do",
        type:"post",
        data:{
            fChrgeName:$("#searchName").val(),
            fChrgeType:$("#searchType").val(),
            fStatus:$("#searchStatus").val(),
            page:0,
            pageSize:10
        },
        success:function(data) {
            $('#tb_chargeStandard').bootstrapTable('load', data);
        }
    });
}

var len="";
var row="";
//回显数据字典到添加收费标准界面的下拉框
function getDcList(){
    $.ajax({
        url:contextPath+"/sys/get.do",
        type:"post",
        data:{
            page:1,
            pageSize:10
        },
        success:function(data) {

            //获取UTC(国际统一时间/国际协调)格式的从1970.1.1 0:00以来的毫秒数
            var newDate=new Date();
            $("#addChrgeNumber").val("No"+newDate.getTime());

            len=data.total;
            row=data.rows;

            var searchType="<option value=''> --请选择-- </option>";
            for(var i=0;i<len;i++){
                 searchType += "<option value='" + row[i].id + "'>" + row[i].value + "</option>";
            }
            $("#searchType").html(searchType);
        }
    });
}

//时间格式转化函数
 function formatDateTime(date) {
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    var h = date.getHours();
    var minute = date.getMinutes();
    minute = minute < 10 ? ('0' + minute) : minute;
    return y + '-' + m + '-' + d+' '+h+':'+minute;
};


