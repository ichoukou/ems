//出库单新增用于记录已选物品的一些信息
var  materialcount=1;
var  materialList=new Array();
var  material;
//tb_storageOutDetailedList的查询参数
var  paramfnumber="";
var  parammaterialID="";
var  paramstandard="";
var  paramstorageID="";
var  paramEdate="";
var  paramLdate="";
//tb_Stock的查询参数
var  param2storeHouseID="";
var  param2material="";
var  param2materialTypeID="";
//出库单修改存储修改前数据
var  datalist=new Array();
var  entry;
var fparentID;
//加载下拉框
$(document).ready(function () {
    getStorageOutMaterialList();//加载物品名称下拉框
    getStorageOutStandardList();//加载物品标准下拉框
    getStorageOutStoreHouseList();//加载仓库下拉框
})

$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_storageOutDetailedList').bootstrapTable({
            url: 'queryStorageOutDetailedList.do',   //请求后台的URL（*）
            method: 'post',      //请求方式（*）
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            toolbar: '#toolbar',    //工具按钮用哪个容器
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页（*）
            sortable: false,      //是否启用排序
            sortOrder: "asc",     //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,      //初始化加载第一页，默认第一页
            pageSize: 5,      //每页的记录行数（*）
            pageList: [5, 10, 50, 100],  //可供选择的每页的行数（*）
            search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,     //是否显示所有的列
            showRefresh: true,     //是否显示刷新按钮
            minimumCountColumns: 2,    //最少允许的列数
            // clickToSelect: true,    //是否启用点击选中行
            // height: 600,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            // uniqueId: "ID",      //每一行的唯一标识，一般为主键列
            showToggle:true,     //是否显示详细视图和列表视图的切换按钮
            cardView: false,     //是否显示详细视图
            detailView: false,     //是否显示父子表
            columns: [
                {
                    radio:true,
                },
                {
                    field: 'fnumber',
                    title: '单据编号',
                    align: 'center',
                    display:'inline',
                    // width:190,
                }, {
                    field: 'outDate',
                    title: '出库日期',
                    align: 'center',
                    // width:150,
                },{
                    field: 'operator',
                    title: '经办人',
                    align: 'center',
                    // width:270,
                },{
                    field: 'remark',
                    title: '说明',
                    align: 'center',
                    // width:270,
                },{
                    field: 'storageName',
                    title: '仓库',
                    align: 'center',
                    // width:190,
                },{
                    field: 'storageManName',
                    title: '保管员',
                    align: 'center',
                    // width:190,
                },{
                    field: 'materialName',
                    title: '物资名称',
                    align: 'center',
                    // width:270,
                },{
                    field: 'standard',
                    title: '规格',
                    align: 'center',
                    // width:270,
                } ,{
                    field: 'qty',
                    title: '数量',
                    align: 'center',

                    // width:270,
                } ,
            ],
            onLoadSuccess: function () {
                //相同编号的出库单信息合并
                hebing();
            }
        });
        $('#tb_Stock').bootstrapTable({
            url: 'queryOutMaterial.do',   //请求后台的URL（*）
            method: 'post',      //请求方式（*）
            contentType:"application/x-www-form-urlencoded; charset=UTF-8",
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,     //是否显示分页（*）
            sortable: false,      //是否启用排序
            sortOrder: "asc",     //排序方式
            queryParams: oTableInit.queryParams2,//传递参数（*）
            sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,      //初始化加载第一页，默认第一页
            pageSize: 5,      //每页的记录行数（*）
            pageList: [5, 10, 50, 100],  //可供选择的每页的行数（*）
            search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,     //是否显示所有的列
            showRefresh: true,     //是否显示刷新按钮
            minimumCountColumns: 2,    //最少允许的列数
            clickToSelect: true,    //是否启用点击选中行
            // height: 600,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            // uniqueId: "ID",      //每一行的唯一标识，一般为主键列
            showToggle:true,     //是否显示详细视图和列表视图的切换按钮
            cardView: false,     //是否显示详细视图
            detailView: false,     //是否显示父子表
            columns: [
                {
                    checkbox:true,
                    // radio: true,
                    width:40,
                },
                {
                    field: 'storeHouse',
                    title: '仓库',
                    align: 'center',
                    width:90,
                    // width:190,
                }, {
                    field: 'storeMan',
                    title: '保管员',
                    align: 'center',
                    width:90,
                }, {
                    field: 'material',
                    title: '物资',
                    align: 'center',
                    width:140,
                },{
                    field: 'standrad',
                    title: '规格',
                    align: 'center',
                    width:120,
                },{
                    field: 'getcount',
                    title: '取出数量',
                    align: 'center',
                    width:80,
                    formatter:function(value1,row,index){
                        //只能输入整数
                        return "<input  type='text'  placeholder='' style='width: 70px' onclick='' onkeyup=\"value=value.replace(/[^\\d]/g,'')\"/>";
                    }
                },{
                    field: 'unit',
                    title: '单位',
                    align: 'center',
                    width:70,
                },{
                    field: 'stockCount',
                    title: '库存量',
                    align: 'center',
                    width:90,
                    //显示的库存量=查出来的-materialList里面存储的记录
                    formatter:function(value1,row,index){
                        for(var i=0;i<materialList.length;i++)
                        {
                            if(row.id ==materialList[i].id )
                            {
                                row.stockCount=materialList[i].count;
                                value1=materialList[i].count;
                            }
                        }
                        if(parseInt(value1) < parseInt(row.minStockCount))
                        {
                            //少于自定义的最小库存量变红
                            return "<span>"+value1+"</span><span style='color: red;'>(请补充！)</span>";
                        }
                        else {
                            return "<span>"+value1+"</span>";
                        }
                    }
                },{
                    field: 'minStockCount',
                    title: '最少库存量',
                    align: 'center',
                    width:100,
                }, {
                    field: 'remark',
                    title: '备注',
                    align: 'center',
                    // width:100,
                }
            ],
        });
    };
    //得到查询的参数
    oTableInit.queryParams = function (params) {
        parampage1=params.limit;
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset , //页码
            fnumber:paramfnumber,
            materialID:parammaterialID,
            standard:paramstandard,
            storageID:paramstorageID,
            Edate:paramEdate,
            Ldate:paramLdate,
        };
        return temp;
    };
    //得到查询的参数
    oTableInit.queryParams2 = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset , //页码
            storeHouseID:param2storeHouseID,
            material:param2material,
            materialTypeID:param2materialTypeID,
        };
        return temp;
    };
    return oTableInit;
};
//加载出库单查询物资名称下拉框
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
//加载出库单查询物资规格下拉框
function getStorageOutStandardList() {
    $.ajax({
        url:contextPath+"/StorageOut/getStorageStandardList.do",
        type:"post",
        data:{

        },
        success:function(data) {
            $("#standard").empty();
            $("#standard").append("<option value='' selected>-请选择-</option>")
            $.each(data,function (key,Data) {
                $("#standard").append("<option value=" +Data.toString() + ">" + Data.toString() + "</option>")
            })
        }
    });
}
//加载出库单查询仓库下拉框
function getStorageOutStoreHouseList() {
    $.ajax({
        url:contextPath+"/StorageOut/getStorageOutStoreHouseList.do",
        type:"post",
        data:{

        },
        success:function(data) {
            $("#storeHouseName").empty();
            $("#out_goodsAdd_store").empty();
            $("#storeHouseName").append("<option value='' selected>-请选择-</option>")
            $("#out_goodsAdd_store").append("<option value='' selected>-请选择-</option>")
            $.each(data,function (key,Data) {
                $("#storeHouseName").append("<option value=" +Data.storageID + ">" + Data.storageName + "</option>")
                $("#out_goodsAdd_store").append("<option value=" +Data.storageID + ">" + Data.storageName + "</option>")
            })
        }
    });
}
//加载出库单添加经办人下拉框
function getStroageOutOperatorList() {
    $.ajax({
        url:contextPath+"/StorageOut/getStroageOutOperatorList.do",
        type:"post",
        data:{

        },
        success:function(data) {
            $("#add_operator").empty();
            $("#add_operator").append("<option value='' selected>-请选择-</option>")
            $.each(data,function (key,Data) {
                $("#add_operator").append("<option value=" +Data.operatorID + ">" + Data.operator + "</option>")
            })
        }
    });
}
//加载物品查询里的物品分类下拉框
function getStorageGoodsSorting(){
    $.ajax({
        url:contextPath+"/storageGoods/getStorageGoodsSortingTypeList.do",
        type:"post",
        data:{
            id:'',
        },
        success:function(data) {
            $("#out_goodsAdd_type").empty();
            $("#out_goodsAdd_type").append("<option value=''></option>")
            $.each(data,function (key,Data) {
                $("#out_goodsAdd_type").append("<option value=" +Data.id + ">" + Data.typeName + "</option>")
            })
        }
    });
}



//跳转出库单增加
function go_to_add() {
    //加载物品分类下拉框
    getStorageGoodsSorting();
    //加载经办人下拉框
    getStroageOutOperatorList();
    $("#out_add_title").html("出库单新增");
    //清除事件
    $("#out_add_add").unbind('click');
    $("#out_add_delect").unbind('click');
    $("#out_add_save").unbind('click');
    //出库单增加修改按钮事件
    $("#out_add_add").click(function () { add_Out_Add(); });
    $("#out_add_delect").click(function () { add_Out_Delect(); });
    $("#out_add_save").click(function () { add_Out_Save(); });
    //清空记录数组
    materialList.splice(0,materialList.length);
    //计数器归1
    materialcount=1;
    $("#add_operator").val('');
    $("#add_outTime").val('');
    $("#add_explain").val('');
    $("#add_storageOutDetailed tbody").empty();
    //自动生成编号
    var number=formatDateTime(new Date,"OS");
    $("#add_number").val(number);
    var number2=formatDateTime2(new Date,"");
    $("#add_outTime").val(number2);
    // alert(number);
    $("#add_btn").click();
}

//条件查询出库单列表
function queryOutDetailedList() {
    paramfnumber=$("#number").val();
    parammaterialID=$("#materialName").val();
    paramstandard=$("#standard").val();
    paramstorageID=$("#storeHouseName").val();
    paramEdate=$("#Edate").val();
    paramLdate=$("#Ldate").val();
    $("#tb_storageOutDetailedList").bootstrapTable('selectPage',1);
}

//新建出库单里的物品添加，列表刷新
function add_Out_Add() {
    $('#tb_Stock').bootstrapTable('refresh', {url: 'queryOutMaterial.do'});
}
//新建出库单里的已选物品删除
function add_Out_Delect() {
    // var table=$("#add_storageOutDetailed");
    $('#add_storageOutDetailed tbody tr').each(function(){
        var input= $(this).find("input[type=checkbox]");
        if(input.prop("checked"))
        {
            input.parent().parent().remove();//删除table中的行
            for(var i=0;i<materialList.length;i++)
            {
                if($(this).find("td").eq(2).html()==materialList[i].id)
                {
                    materialList.splice(i,1);//从materialList中删除记录
                }
            }
            materialcount--;
        }
    });
    //重新编号
    var count=1;
    $('#add_storageOutDetailed tbody tr ').each(function(){
        var td=$(this).find('td');
        td.eq(1).html(count);
        count++;
    });
}
//新建出库单输入验证
function add_Out_Save_Check(){
    var tr= $('#add_storageOutDetailed tbody tr ');
    var boolean=true;
    if(tr[0]){
        var outDate=$("#add_outTime").val().trim();
        var operator=$("#add_operator").val().trim();
        // var explain=$("#add_explain").val().trim();
        if(outDate=="")
        {
            alert("请选择出库日期！");
            boolean=false;
        }
        else {
            if (operator == "") {
                alert("请选择经办人！");
                boolean=false;
            }
        }
    }
    else{
        alert("请添加数据！");
        boolean=false
    };
    return boolean;
}
//新建出库单保存和输入验证
function add_Out_Save() {
    if(add_Out_Save_Check())
    {
        var tr= $('#add_storageOutDetailed tbody tr ');
        //出库单
        var outStorageSql="";
        //出库单子表
        var outStorageEntrySql="";
        //库存表
        var stockAccountSql="";
        //已小于最小库存量的警告
        var warningstr="";
        outStorageSql=$("#add_number").val()+"="+$("#add_outTime").val()+"="+$("#add_operator").val()+"="+$("#add_explain").val();
        $('#add_storageOutDetailed tbody tr ').each(function(){
            var td=$(this).find('td');
            outStorageEntrySql=outStorageEntrySql+"_"+td.eq(4).html()+"="+td.eq(6).html()+"="+td.eq(8).html()+"="+td.eq(9).html()+"="+td.eq(10).html()+"="+td.eq(11).html();
            stockAccountSql=stockAccountSql+"_"+td.eq(2).html()+"="+td.eq(12).html();
            if( parseInt(td.eq(12).html()) < parseInt(td.eq(13).html()))
            {
                warningstr=warningstr+td.eq(3).html()+"  中的 "+td.eq(7).html()+"已小于最小库存量!\n";
            }
        });
            warningstr=warningstr+"确认保存？";
            if(confirm(warningstr))
            {
                $.ajax({
                    url:contextPath+"/StorageOut/addOutDetailed.do",
                    type:"post",
                    data:{
                        outStorageSql:outStorageSql,
                        outStorageEntrySql:outStorageEntrySql,
                        stockAccountSql:stockAccountSql,
                    },
                    success:function(data) {
                        $("#add_close_btn").click();
                        if(data.success)
                        {
                            setAlert(data.message, "增加成功");
                        }
                        else{
                            setAlert(data.message, "增加失败");
                        }
                        $('#tb_storageOutDetailedList').bootstrapTable('refresh',{url: 'queryStorageOutDetailedList.do'});

                    }
                });
            };
    }
}

//出库单修改物品添加
function update_Out_Add(){
    $('#tb_Stock').bootstrapTable('refresh', {url: 'queryOutMaterial.do'});
}
//出库单修改物品修改
function update_Out_Delect(){
    $('#add_storageOutDetailed tbody tr').each(function(){
        var input= $(this).find("input[type=checkbox]");
        if(input.prop("checked"))
        {
            //删除table中行
            input.parent().parent().remove();
            for(var i=0;i<materialList.length;i++)
            {
                //如果是新增的，删除materialList中记录的数据
                if($(this).find("td").eq(2).html()==materialList[i].id)
                {
                    //删除数组元素。两个参数，第一个参数（要删除第一项的位置），第二个参数（要删除的项数）
                    materialList.splice(i,1);
                }
            }
            materialcount--;
        }
    });
    //重新编号
    var count=1;
    $('#add_storageOutDetailed tbody tr ').each(function(){
        var td=$(this).find('td');
        td.eq(1).html(count);
        count++;
    });
}
//出库单修改保存
function update_Out_Save(){
    if(add_Out_Save_Check())
    {
        var tr= $('#add_storageOutDetailed tbody tr ');
        //出库单子表
        var outStorageEntrySql="";
        //出库单子表删除
        var delectFidList="";
        //库存表
        var delectQtyList="";
        var afterlist=new Array();
        //把datalist数组的值全部赋给after数组
        afterlist= [].concat(datalist);
        //库存表
        var stockAccountSql="";
        //警告提示
        var warningstr="";
        var outStorageSql=$("#add_number").val()+"="+$("#add_outTime").val()+"="+$("#add_operator").val()+"="+$("#add_explain").val();
        $('#add_storageOutDetailed tbody tr ').each(function(){
            var td=$(this).find('td');
            //eq(14).html()=="0"表示是修改时新添加的
            if(td.eq(14).html()=="0")
            {
                outStorageEntrySql=outStorageEntrySql+"_"+fparentID+"="+td.eq(4).html()+"="+td.eq(6).html()+"="+td.eq(8).html()+"="+td.eq(9).html()+"="+td.eq(10).html()+"="+td.eq(11).html();
                stockAccountSql=stockAccountSql+"_"+td.eq(2).html()+"="+td.eq(12).html();
                if( parseInt(td.eq(12).html()) < parseInt(td.eq(13).html()))
                {
                    warningstr=warningstr+td.eq(3).html()+"  中的 "+td.eq(7).html()+"已小于最小库存量!\n";
                }
            }
            else {
                //afterlist中删除未修改的行。只剩下需要出库单子表需要删除的行
                for(var i=0;i<afterlist.length;i++){
                    if(td.eq(14).html()==afterlist[i].fid)
                    {
                        afterlist.splice(i,1);
                    }
                }
            }
        });
        for(var i=0;i<afterlist.length;i++) {
            delectFidList=delectFidList+"="+afterlist[i].fid;
            delectQtyList=delectQtyList+"_"+afterlist[i].storageID+"="+afterlist[i].materialID+"="+afterlist[i].qty;
        }
        warningstr=warningstr+"确认保存？";
        if(confirm(warningstr))
        {
            $.ajax({
                url:contextPath+"/StorageOut/updateOutDetailed.do",
                type:"post",
                data:{
                    delectFidList:delectFidList,
                    outStorageSql:outStorageSql,
                    outStorageEntrySql:outStorageEntrySql,
                    stockAccountSql:stockAccountSql,
                    delectQtyList:delectQtyList,
                },
                success:function(data) {
                    $("#add_close_btn").click();
                    if(data.success)
                    {
                        setAlert(data.message, "更新成功");
                    }
                    else{
                        setAlert(data.message, "更新失败");
                    }
                    $('#tb_storageOutDetailedList').bootstrapTable('refresh',{url: 'queryStorageOutDetailedList.do'});
                }
            });
        };
    }
}
//物品条件查询
function queryOutMaterialList(){
    param2storeHouseID=$("#out_goodsAdd_store").val();
    param2material=$("#out_goodsAdd_material").val();
    param2materialTypeID=$("#out_goodsAdd_type").val();
    $("#tb_Stock").bootstrapTable('selectPage',1);
}
//物料添加的输入验证
function out_goodsadd() {
    //输入验证
    if (out_goodsaddcheck()) {
        var carrentItem=$("#tb_Stock").bootstrapTable('getSelections');
        var list=0;
        $('#tb_Stock tbody tr td input[type=checkbox]').each(function(){
            if($(this).prop("checked"))
            {
                count=$(this).parent().parent().find('input[type=text]');
                var boolean = true;
                for(var i=0;i<materialList.length;i++){
                    //如果materialList中已经有了，则只修改其中数据
                    if(carrentItem[list].id == materialList[i].id)
                    {
                        materialList[i].count=materialList[i].count-parseInt(count.val());
                        $('#add_storageOutDetailed tbody tr').each(function () {
                            var ttd=$(this).find(" td ");
                            if(ttd.eq(2).html() == carrentItem[list].id)
                            {
                                boolean = false;
                                ttd.eq(10).html(parseInt(ttd.eq(10).html())+parseInt(count.val()));
                                ttd.eq(12).html(parseInt(ttd.eq(12).html())-parseInt(count.val()));
                            }
                        });
                    }
                };
                //如果之前没有添加这个物品，添加到显示行中
                if(boolean){
                    var span=$(this).parent().parent().find(' span ');
                    var count2 = span.eq(0).html() - count.val();
                    str="<tr > " +
                        "<td style='text-align: center; '>" +
                        "<input name='btSelectItem' type='checkbox'>" +
                        "</td> " +
                        "<td style='text-align: center; '>"+ materialcount +"</td> " +
                        "<td style='text-align: center;display:none; '>"+carrentItem[list].id+"</td> " +
                        "<td style='text-align: center; '>"+carrentItem[list].storeHouse+"</td> " +
                        "<td style='text-align: center;display:none; ' >"+carrentItem[list].storeHouseID+"</td> " +
                        "<td style='text-align: center; '>"+carrentItem[list].storeMan+"</td> " +
                        "<td style='text-align: center;display:none; ' >"+carrentItem[list].storeManID+"</td> " +
                        "<td style='text-align: center; '>"+carrentItem[list].material+"</td> " +
                        "<td style='text-align: center; display:none;' >"+carrentItem[list].materialID+"</td> " +
                        "<td style='text-align: center; '>"+carrentItem[list ].standrad+"</td> " +
                        "<td style='text-align: center; '>"+count.val()+"</td> " +
                        "<td style='text-align: center; '>"+carrentItem[list].remark+"</td> " +
                        "<td style='text-align: center; display:none;'>"+count2+"</td> " +
                        "<td style='text-align: center; display:none;'>"+carrentItem[list].minStockCount+"</td> " +
                        "<td style='text-align: center; display:none;'>"+"0"+"</td> " +
                        "</tr>";
                    //同时在materialList中添加一条信息
                    material=new Object();
                    material.id=carrentItem[list].id;
                    material.count=count2;
                    materialList.push(material);
                    $("#add_storageOutDetailed").append(str);
                    //设置单击选中行
                    $('#add_storageOutDetailed tbody tr').unbind('click');
                    $('#add_storageOutDetailed tbody tr').click(function () {
                        var input = $(this).find("input[type=checkbox]");
                        if(input.prop("checked"))
                        {
                            input.removeAttr("checked");
                        }
                        else
                        {
                            input.prop("checked","true");
                        }
                    });
                    materialcount++;
                }
                list++;
            }

        });
        $("#out_goodsAdd_close_btn").click();
    }
}
//物料添加验证
function out_goodsaddcheck() {
    var bool=true;
    var count;
    var carrentItem = $("#tb_Stock").bootstrapTable('getSelections');
    if (carrentItem[0]) {
        $('#tb_Stock tbody tr td input[type=checkbox]').each(function(){
            $(this).parent().parent().find('input[type=text]').attr("placeholder","") ;
            if($(this).prop("checked")) {
                count = $(this).parent().parent().find('input[type=text]');
                count.attr("placeholder", "请填写");
                var rq = "^([0-9]*[1-9][0-9]*)$";
                if(bool){
                    if (count.val() == '') {
                        bool=false;
                        alert("请填写取出数量！");
                    }
                    else {
                        if (!count.val().match(rq)) {
                            bool=false;
                            alert("数量格式错误！");
                            count.val("");
                        }
                        else {
                            var span=$(this).parent().parent().find(' span ');
                            var count2 = span.eq(0).html() - count.val();
                            if (count2 < 0) {
                                bool=false;
                                alert("库存量不足" + count.val());
                                count.val("");
                            }

                        }
                   }
                }
            }
            else{
                $(this).parent().parent().find('input[type=text]').val("");
            }
        });
    }
    else
    {
        bool=false;
        alert("请选择！");
    }
    return bool;
}

//清空查询条件
function clearSelect() {
    $("#out_goodsAdd_material").val("");
    $("#out_goodsAdd_store").val("");
    $("#out_goodsAdd_type").val("");

    $("#number").val("");
    $("#materialName").val("");
    $("#standard").val("");
    $("#storeHouseName").val("");
    $("#Edate").val("");
    $("#Ldate").val("");
}
//跳转出库单更新
function go_to_update(){
    var carrentItem = $("#tb_storageOutDetailedList").bootstrapTable('getSelections');
    if(carrentItem[0]){
//获取经办人列表
        $.ajax({
            url:contextPath+"/StorageOut/getStroageOutOperatorList.do",
            type:"post",
            data:{

            },
            success:function(data) {
                var bool=false;
                $("#add_operator").empty();
                $("#add_operator").append("<option value='' selected>-请选择-</option>")
                $.each(data,function (key,Data) {
                    $("#add_operator").append("<option value=" +Data.operatorID + ">" + Data.operator + "</option>")
                    if(Date.operatorID==carrentItem[0].operatorID)
                    {
                        bool=true;
                    }
                })
                if(bool==false)
                {
                    $("#add_operator").append("<option value=" +carrentItem[0].operatorID + ">" + carrentItem[0].operator + "</option>")
                }
                $("#add_operator").val(carrentItem[0].operatorID);
            }
        });

        //清空单击事件
        $("#out_add_title").html("出库单修改");
        $("#out_add_add").unbind('click');
        $("#out_add_delect").unbind('click');
        $("#out_add_save").unbind('click');
        //修改单击事件
        $("#out_add_add").click(function () { update_Out_Add(); });
        $("#out_add_delect").click(function () { update_Out_Delect(); });
        $("#out_add_save").click(function () { update_Out_Save(); });
        //数组清空
        datalist.splice(0,datalist.length);
        materialList.splice(0,materialList.length);
        materialcount=1;
        //回显数据
        $("#add_outTime").val(carrentItem[0].outDate);
        $("#add_explain").val(carrentItem[0].remark);
        $("#add_number").val(carrentItem[0].fnumber);
        //table清空
        $("#add_storageOutDetailed tbody").empty();
        //查询对应出库单号的数据
        $.ajax({
            url:contextPath+"/StorageOut/loadMaterialNameList.do",
            type:"post",
            data:{
                outNumber:carrentItem[0].fnumber,
            },
            success:function(data) {
                fparentID=data[0].fpid;
                var str;
                $.each(data,function (key,Data) {
                    entry=new Object();
                    entry.fid=Data.fid;
                    entry.storageID=Data.storageID;
                    entry.materialID=Data.materialID;
                    entry.qty=Data.qty;
                    //存放所有的行
                    datalist.push(entry);
                    str="<tr > " +
                        "<td style='text-align: center; '>" +
                        "<input name='btSelectItem' type='checkbox'>" +
                        "</td> " +
                        "<td style='text-align: center; '>"+ materialcount +"</td> " +
                        "<td style='text-align: center;display:none; '>"+"0"+"</td> " +
                        "<td style='text-align: center; '>"+Data.storageName+"</td> " +
                        "<td style='text-align: center;display:none; ' >"+Data.storageID+"</td> " +
                        "<td style='text-align: center; '>"+Data.storageManName+"</td> " +
                        "<td style='text-align: center;display:none; ' >"+Data.storageManID+"</td> " +
                        "<td style='text-align: center; '>"+Data.materialName+"</td> " +
                        "<td style='text-align: center; display:none;' >"+Data.materialID+"</td> " +
                        "<td style='text-align: center; '>"+Data.standard+"</td> " +
                        "<td style='text-align: center; '>"+Data.qty+"</td> " +
                        "<td style='text-align: center; '>"+Data.remark+"</td> " +
                        "<td style='text-align: center; display:none;'>"+"0"+"</td> " +
                        "<td style='text-align: center; display:none;'>"+Data.amount+"</td> " +
                        "<td style='text-align: center; display:none;'>"+Data.fid+"</td> " +
                        "</tr>";
                    //添加到table中，含有隐藏行
                    $("#add_storageOutDetailed").append(str);
                    $('#add_storageOutDetailed tbody tr').unbind('click');
                    $('#add_storageOutDetailed tbody tr').click(function () {
                        var input = $(this).find("input[type=checkbox]");
                        if(input.prop("checked"))
                        {
                            input.removeAttr("checked");
                        }
                        else
                        {
                            input.prop("checked","true");
                        }
                    });
                    materialcount++;
                })
            }
        });
        $("#add_btn").click();
    }else{
        setAlert("error","请先选择一条数据");
    }
}
//删除出库单
function go_to_delect(){
    var carrentItem = $("#tb_storageOutDetailedList").bootstrapTable('getSelections');
    if(carrentItem[0]) {
        // alert(carrentItem[0].fnumber);
        warningstr="确定要删除编号为："+carrentItem[0].fnumber+" 的出库单？";
        if(confirm(warningstr))
        {
            $.ajax({
                url:contextPath+"/StorageOut/deleteOutDetailed.do",
                type:"post",
                data:{
                    fnumber:carrentItem[0].fnumber,
                },
                success:function(data) {
                    if(data.success)
                    {
                        setAlert(data.message, "删除成功");
                    }
                    else{
                        setAlert(data.message, "删除失败");
                    }
                    $('#tb_storageOutDetailedList').bootstrapTable('refresh',{url: 'queryStorageOutDetailedList.do'});
                }
            });
        };
    }else{
    setAlert("error","请先选择一条数据");
    }
}
//合并编号相同的项
function hebing() {
    var trlist=$("#tb_storageOutDetailedList  tbody tr");
    //记录合并的初行
    var beging=0;
    //记录合并的末行
    var end=0;
    //出库单编号
    var number=0;
    var tdlist;
    //依次遍历所有行
    for(var i=0;i<trlist.size();i++)
    {
        tdlist=trlist.eq(i).find(' td ');
        //判断出库单编号是否相同
        if(number==tdlist.eq(1).html())
        {
            end=i;//出库单编号相同,记录行数
            //如果到了本页最后一行，直接合并
            if(end==(trlist.size()-1))
            {
                //首行rowspan
                tdlist=trlist.eq(beging).find(' td ');
                tdlist.eq(0).attr("rowspan",end-beging+1);
                tdlist.eq(1).attr("rowspan",end-beging+1);
                tdlist.eq(2).attr("rowspan",end-beging+1);
                tdlist.eq(3).attr("rowspan",end-beging+1);
                tdlist.eq(4).attr("rowspan",end-beging+1);
                //其他行隐藏
                for(var j=(beging+1);j<=end;j++)
                {
                    tdlist=trlist.eq(j).find(' td ');
                    tdlist.eq(0).css('display','none');
                    tdlist.eq(1).css('display','none');
                    tdlist.eq(2).css('display','none');
                    tdlist.eq(3).css('display','none');
                    tdlist.eq(4).css('display','none');

                }
            }
        }
        else{
            //如果记录的出库单号跟当前行出库单号不等
            number=tdlist.eq(1).html();//重新记录出库单号
            if((end-beging)>0)//如果记录的首行和末行不是同一行，则进行合并
            {
                tdlist=trlist.eq(beging).find(' td ');
                tdlist.eq(0).attr("rowspan",end-beging+1);
                tdlist.eq(1).attr("rowspan",end-beging+1);
                tdlist.eq(2).attr("rowspan",end-beging+1);
                tdlist.eq(3).attr("rowspan",end-beging+1);
                tdlist.eq(4).attr("rowspan",end-beging+1);

                for(var j=(beging+1);j<=end;j++)
                {
                    tdlist=trlist.eq(j).find(' td ');
                    tdlist.eq(0).css('display','none');
                    tdlist.eq(1).css('display','none');
                    tdlist.eq(2).css('display','none');
                    tdlist.eq(3).css('display','none');
                    tdlist.eq(4).css('display','none');
                }
            }
            beging=i;//重新记录首行
            end=i;//重新记录末行
        }
    }
}
//年月日时分秒
var formatDateTime = function (date,str) {
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    var h = date.getHours();
    h=h < 10 ? ('0' + h) : h;
    var minute = date.getMinutes();
    minute = minute < 10 ? ('0' + minute) : minute;
    var second=date.getSeconds();
    second=second < 10 ? ('0' + second) : second;
    return str+ y  + m  + d+  h  + minute + second;
};
//年月日
var formatDateTime2 = function (date,str) {
    var y = date.getFullYear();
    var m = date.getMonth() + 1;
    m = m < 10 ? ('0' + m) : m;
    var d = date.getDate();
    d = d < 10 ? ('0' + d) : d;
    return str+ y + "-" + m + "-" + d;
};