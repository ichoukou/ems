//初始化
$(document).ready(function () {

});
$(function () {
    // 1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_Analysis').bootstrapTable({
            toolbar: '#toolbar',    //工具按钮用哪个容器
            showExport:true,    //显示导出按钮
            exportDataType: "basic",//导出类型basic', 'all', 'selected'.当前页、所有数据、选中数据
            striped: true,      //是否显示行间隔色
            cache: false,      //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: false,     //是否显示分页（*）
            sortable: true,      //是否启用排序
            sortOrder: "asc",     //排序方式
            sidePagination: "server",   //分页方式：client客户端分页，server服务端分页（*）
            search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: false,
            showColumns: true,     //是否显示所有的列
            showRefresh: true,     //是否显示刷新按钮
            showToggle:false,     //是否显示详细视图和列表视图的切换按钮
            cardView: false,     //是否显示详细视图
            detailView: false,     //是否显示父子表
            columns: [
            ],
            onLoadSuccess: function () {

            }
        });
    };
    return oTableInit;
};
//查询数据
function queryIncomeAnalysisList(){
    var date=$("#date").val();
    var td=$("#tb_Analysis thead tr th");
    td.eq(1).html("<div class='th-inner '>"+date+"当日</div>");
    td.eq(2).html("<div class='th-inner '>"+date.substring(0,date.lastIndexOf("-"))+"月月累计</div>");
    td.eq(3).html("<div class='th-inner '>"+date.split("\-")[0]+"年年度累计</div>");
    $("#tb_Analysis tbody").empty();
    $.ajax({
        url:contextPath+"/incomeAnalysis/queryIncomeAnalysisList.do",
        type:"post",
        data:{
            date:date,
        },
        success:function(data) {
            console.log(data.rows);
            var str="";
            var hlcw=data.rows.hlcw;
            str="<tr><td>护理床位数</td>" +
                "<td>"+hlcw[0]+"</td>" +
                "<td>"+hlcw[0]+"</td>" +
                "<td>"+hlcw[0]+"</td>" +
                "<td>"+hlcw[0]+"</td>" +
                "<td>"+hlcw[0]+"</td>" +
                "<td>"+0+"</td>" +
                "<td>"+0+"</td></tr>"
            $("#tb_Analysis tbody").append(str);
            var zryt=data.rows.zryt;
            str="<tr><td>自然月天数</td>" +
                "<td>"+zryt[0]+"天</td>" +
                "<td>"+zryt[1]+"天</td>" +
                "<td>"+zryt[2]+"天</td>" +
                "<td>"+zryt[3]+"天</td>" +
                "<td>"+zryt[4]+"天</td>" +
                "<td>"+(parseInt(zryt[1])-parseInt(zryt[3]))+"天</td>" +
                "<td>"+(parseInt(zryt[2])-parseInt(zryt[4]))+"天</td></tr>";
            $("#tb_Analysis tbody").append(str);
            var sjcz=data.rows.sjcz;
            str="<tr><td>可出租床晚数</td>" +
                "<td>"+(hlcw[0]*zryt[0]-sjcz[0])+"</td>" +
                "<td>"+(hlcw[0]*zryt[1]-sjcz[1])+"</td>" +
                "<td>"+(hlcw[0]*zryt[2]-sjcz[2])+"</td>" +
                "<td>"+(hlcw[0]*zryt[3]-sjcz[3])+"</td>" +
                "<td>"+(hlcw[0]*zryt[4]-sjcz[4])+"</td>" +
                "<td>"+((hlcw[0]*zryt[1]-sjcz[1])-(hlcw[0]*zryt[3]-sjcz[3]))+"</td>" +
                "<td>"+((hlcw[0]*zryt[2]-sjcz[2])-(hlcw[0]*zryt[4]-sjcz[4]))+"</td></tr>";
            $("#tb_Analysis tbody").append(str);
            str="<tr><td>实际出租床晚数</td>" +
                "<td>"+parseInt(sjcz[0])+"</td>" +
                "<td>"+parseInt(sjcz[1])+"</td>" +
                "<td>"+parseInt(sjcz[2])+"</td>" +
                "<td>"+parseInt(sjcz[3])+"</td>" +
                "<td>"+parseInt(sjcz[4])+"</td>" +
                "<td>"+(parseInt(sjcz[1])-parseInt(sjcz[3]))+"</td>" +
                "<td>"+(parseInt(sjcz[2])-parseInt(sjcz[4]))+"</td></tr>";
            $("#tb_Analysis tbody").append(str);
            str="<tr><td>床位出租率</td>" +
                "<td>"+(sjcz[0]/(hlcw[0]*zryt[0])*100).toFixed(3)+"%</td>" +
                "<td>"+(sjcz[1]/(hlcw[0]*zryt[1])*100).toFixed(3)+"%</td>" +
                "<td>"+(sjcz[2]/(hlcw[0]*zryt[2])*100).toFixed(3)+"%</td>" +
                "<td>"+(sjcz[3]/(hlcw[0]*zryt[3])*100).toFixed(3)+"%</td>" +
                "<td>"+(sjcz[4]/(hlcw[0]*zryt[4])*100).toFixed(3)+"%</td>" +
                "<td>"+((sjcz[1]/(hlcw[0]*zryt[1])*100)-(sjcz[3]/(hlcw[0]*zryt[3])*100)).toFixed(3)+"%</td>" +
                "<td>"+((sjcz[2]/(hlcw[0]*zryt[2])*100)-(sjcz[4]/(hlcw[0]*zryt[4])*100)).toFixed(3)+"%</td></tr>";
            $("#tb_Analysis tbody").append(str);
            $("#tb_Analysis tbody").append("<tr><td colspan='8'></td></tr>");
            var zl=data.rows.zl;
            str="<tr><td>自理</td>" +
                "<td>"+parseInt(zl[0])+"</td>" +
                "<td>"+parseInt(zl[1])+"</td>" +
                "<td>"+parseInt(zl[2])+"</td>" +
                "<td>"+parseInt(zl[3])+"</td>" +
                "<td>"+parseInt(zl[4])+"</td>" +
                "<td>"+(parseInt(zl[1])-parseInt(zl[3]))+"</td>" +
                "<td>"+(parseInt(zl[2])-parseInt(zl[4]))+"</td></tr>";
            $("#tb_Analysis tbody").append(str);
            var jz=data.rows.jz;
            str="<tr><td>介助</td>" +
                "<td>"+parseInt(jz[0])+"</td>" +
                "<td>"+parseInt(jz[1])+"</td>" +
                "<td>"+parseInt(jz[2])+"</td>" +
                "<td>"+parseInt(jz[3])+"</td>" +
                "<td>"+parseInt(jz[4])+"</td>" +
                "<td>"+(parseInt(jz[1])-parseInt(jz[3]))+"</td>" +
                "<td>"+(parseInt(jz[2])-parseInt(jz[4]))+"</td></tr>";
            $("#tb_Analysis tbody").append(str);
            var jh=data.rows.jh;
            str="<tr><td>介护</td>" +
                "<td>"+parseInt(jh[0])+"</td>" +
                "<td>"+parseInt(jh[1])+"</td>" +
                "<td>"+parseInt(jh[2])+"</td>" +
                "<td>"+parseInt(jh[3])+"</td>" +
                "<td>"+parseInt(jh[4])+"</td>" +
                "<td>"+(parseInt(jh[1])-parseInt(jh[3]))+"</td>" +
                "<td>"+(parseInt(jh[2])-parseInt(jh[4]))+"</td></tr>";
            $("#tb_Analysis tbody").append(str);

            var qh=data.rows.qh;
            str="<tr><td>全护</td>" +
                "<td>"+parseInt(qh[0])+"</td>" +
                "<td>"+parseInt(qh[1])+"</td>" +
                "<td>"+parseInt(qh[2])+"</td>" +
                "<td>"+parseInt(qh[3])+"</td>" +
                "<td>"+parseInt(qh[4])+"</td>" +
                "<td>"+(parseInt(qh[1])-parseInt(qh[3]))+"</td>" +
                "<td>"+(parseInt(qh[2])-parseInt(qh[4]))+"</td></tr>";
            $("#tb_Analysis tbody").append(str);
            var th=data.rows.th;
            str="<tr><td>特护</td>" +
                "<td>"+parseInt(th[0])+"</td>" +
                "<td>"+parseInt(th[1])+"</td>" +
                "<td>"+parseInt(th[2])+"</td>" +
                "<td>"+parseInt(th[3])+"</td>" +
                "<td>"+parseInt(th[4])+"</td>" +
                "<td>"+(parseInt(th[1])-parseInt(th[3]))+"</td>" +
                "<td>"+(parseInt(th[2])-parseInt(th[4]))+"</td></tr>";
            $("#tb_Analysis tbody").append(str);
            $("#tb_Analysis tbody").append("<tr><td colspan='8'></td></tr>");
            var sfbz=data.rows.sfbz;
            for(var i=0;i<sfbz.length;i++){
                str="<tr>" +
                    "<td>"+sfbz[i][0]+"</td>" +
                    "<td>"+(sfbz[i][1]==null?0:sfbz[i][1])+"</td>" +
                    "<td>"+(sfbz[i][2]==null?0:sfbz[i][2])+"</td>" +
                    "<td>"+(sfbz[i][3]==null?0:sfbz[i][3])+"</td>" +
                    "<td>"+(sfbz[i][4]==null?0:sfbz[i][4])+"</td>" +
                    "<td>"+(sfbz[i][5]==null?0:sfbz[i][5])+"</td>" +
                    "<td>"+((sfbz[i][2]==null?0:sfbz[i][2])-(sfbz[i][4]==null?0:sfbz[i][4]))+"</td>" +
                    "<td>"+((sfbz[i][3]==null?0:sfbz[i][3])-(sfbz[i][5]==null?0:sfbz[i][5]))+"</td>" +
                    "</tr>";
                $("#tb_Analysis tbody").append(str);
            }
        }
    });
    
    
}
//清除选项
function queryclear() {
    $("#date").val("");
}

//跳转打印
function go_to_print() {
    $("#tb_print tbody").empty();
    var date=new Date();
    var datef=date.getFullYear()+"年"+(date.getMonth()+1)+"月"+date.getDate()+"日  "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
    $("#printDate").html(datef);
    $("#tb_Analysis tr").each(function () {
        var tr=$(this);
            $("#tb_print").append("<tr>"+tr.html()+"</tr>");
    })
        $("#print_btn").click();
}
