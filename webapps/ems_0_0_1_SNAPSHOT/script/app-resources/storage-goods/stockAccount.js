//初始化
$(document).ready(function () {
    //物品列表
    getStorageOutMaterialList();
    //仓库下拉框
    getStorageOutStoreHouseList();
});

$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_stockAccount').bootstrapTable({
            url:'queryStockAccountList.do',   //请求后台的URL（*）
            method: 'post',      //请求方式（*）
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            toolbar: '#toolbar',    //工具按钮用哪个容器
            showExport:true,    //显示导出按钮
            exportDataType: "basic",//导出类型basic', 'all', 'selected'.当前页、所有数据、选中数据
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页（*）
            sortable: true,      //是否启用排序
            sortOrder: "asc",     //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,      //初始化加载第一页，默认第一页
            pageSize:10,      //每页的记录行数（*）
            pageList: [10, 20, 50, 100],  //可供选择的每页的行数（*）
            search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,     //是否显示所有的列
            showRefresh: true,     //是否显示刷新按钮
            minimumCountColumns: 2,    //最少允许的列数
            clickToSelect: true,    //是否启用点击选中行
            // height: 350,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            // uniqueId: "number",      //每一行的唯一标识，一般为主键列
            showToggle:true,     //是否显示详细视图和列表视图的切换按钮
            cardView: false,     //是否显示详细视图
            detailView: false,     //是否显示父子表
            columns: [
                {
                    checkbox:true,
                // radio: true
            },
            // {
            //     field: 'number',
            //     title: '编号',
            //     // width: 250
            // },
            {
                field: 'id',
                title: '编号',
                // width: 250
            },{
                field: 'material',
                title: '物资名称',
                // width: 150
            },{
                field: 'standrad',
                title: '规格',
                // width: 150
            },{
                field: 'storeHouse',
                title: '仓库名称',
                // width: 100

            },{
                field: 'stockCount',
                title: '库存数量',
                formatter:function(value1,row,index){
                    if(parseInt(value1) < parseInt(row.minStockCount))
                    {
                        return value1+"<span style='color: red;'>(请补充！)</span>";
                    }
                    else {
                        return value1;
                    }
                }
                // width: 100
            },{
                    field: 'nursingHomeName',
                    title: '养老院名称',
                    // width: 100

                }],
            onLoadSuccess: function(data) {
                // console.log(data);
                }
            
        });
    };
    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset, //页码
            storeHouseID: $("#storageName").val(),
            materialID: $("#materialName").val(),
        };
        return temp;
    };
    return oTableInit;
};


//动态加载下拉框得到物品名称列表
function getStorageOutMaterialList(){
    $.ajax({
        url:contextPath+"/StorageOut/getStorageMaterialNameList.do",
        type:"post",
        data:{

        },
        success:function(data) {
            $("#materialName").empty();
            $("#materialName").append("<option value='' selected>-请选择-</option>")
            $.each(data,function (key,Data) {
                $("#materialName").append("<option value=" +Data.materialID + ">" + Data.materialName + "</option>")
            })
        }
    });
}
//动态加载下拉框得到仓库名称列表
function getStorageOutStoreHouseList() {
    $.ajax({
        url:contextPath+"/StorageOut/getStorageOutStoreHouseList.do",
        type:"post",
        data:{

        },
        success:function(data) {
            $("#storageName").empty();
            $("#storageName").append("<option value='' selected>-请选择-</option>")
            $.each(data,function (key,Data) {
                $("#storageName").append("<option value=" +Data.storageID + ">" + Data.storageName + "</option>")
            })
        }
    });
}


//条件查询项目
function queryStockAccountList() {
    $.ajax({
        url: contextPath + "/StockAccount/queryStockAccountList.do",
        type: "post",
        data: {
            pageSize: 5, //页面大小
            page: 0, //页码
            storeHouseID: $("#storageName").val(),
            materialID: $("#materialName").val(),
        },
        success: function (data) {
            $('#tb_stockAccount').bootstrapTable('load', data);
        }
    });
}
//清空条件
function queryclear() {
    $("#storageName").val("");
    $("#materialName").val("");
}

//跳转打印
function gotoPrint() {
    $("#tb_print tbody").empty();
    var date=new Date();
    var checkbox;
    var td;
    var str;
    var count=0;
    var datef=date.getFullYear()+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日  "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
    $("#printDate").html(datef);
    $("#tb_stockAccount tbody tr").each(function () {
        checkbox=$(this).find('td  input[type=checkbox] ');
        td=$(this).find(" td ");
        if(checkbox.prop("checked"))
        {
            count++;
            str="<tr>" +
                "<td style='border-color: black'>"+td.eq(1).html()+"</td>" +
                "<td style='border-color: black'>"+td.eq(2).html()+"</td>" +
                "<td style='border-color: black'>"+td.eq(3).html()+"</td>" +
                "<td style='border-color: black'>"+td.eq(4).html()+"</td>" +
                "<td style='border-color: black'>"+td.eq(5).html()+"</td>" +
                "</tr>";
            $("#tb_print").append(str);
        }
    })
    if(count==0)
    {
        setAlert("error","请选择打印数据！");
    }
    else{
        $("#StockAccountPrint").click();
    }

}
