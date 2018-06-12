/**
 * Created by zhangxin on 2017/3/1.
*/
//加载方法，不点查询时的页面显示
$(function () {
    var date = new Date();
    $("#searchEntryDate").val(getFirstAndLastMonthDay(date.getFullYear(),date.getMonth()+1));
    $("#searchEndDate").val(date.getFullYear()+"-"+getzf(date.getMonth()+1)+"-"+getzf(date.getDate()));
    $("#duringTime").text(getFirstAndLastMonthDay(date.getFullYear(),date.getMonth()+1)+"至"+(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate())+"期间");
    $("#printTime").text(date.getFullYear()+"-"+getzf(date.getMonth()+1)+"-"+getzf(date.getDate()));
    // $("#billHistory").append("<tr><td colspan='10' align='center'>" +
    //     "<span style='font-size: 14px;font-weight: bold;'>老人卡消费</span>" +
    //     "</td></tr>")
    //
    // $("#billHistory").append("<tr><td>卡号</td>" +
    //     "<td>状态</td>" +
    //     "<td colspan='2'>金额</td>" +
    //     "<td colspan='6'>说明</td></tr>");
    //
    // $("#billHistory").append("<tr><td colspan='10' style='text-align: right'>消费金额：" +
    //     "<span id='costCount1'>0</span>元</td></tr>");
    //
    // $("#billHistory").append("<tr><td colspan='10' style='text-align: right'>大写合计：" +
    //     "<span id='costCount2'>零</span>元</td></tr>");
})
//查询老人卡不知道怎么查
function queryBillHistory() {
    var date = new Date();
    var OldManName = $("#searchName").val();
    var searchEntryDate = $("#searchEntryDate").val();
    var searchEndDate = $("#searchEndDate").val();
    $("#duringTime").text(searchEntryDate+"至"+searchEndDate+"期间");
    $("#printTime").text(date.getFullYear()+"-"+getzf(date.getMonth()+1)+"-"+getzf(date.getDate()));
    $("#oldManName").text(OldManName);
    //通过老人ID查找到老人的基本信息，添加到表中
    $.ajax({
        url:contextPath+"/billHistory/queryOldMain.do",
        type:"post",
        data:{
            oldManId:$("#oldManId").val()
        },
        success:function(data) {
            $("#roomName").text(data.rows[0].FBuildingName+""+data.rows[0].FRoomName);
            $("#roomCount").text(1);
            $("#checkInDate").text(getMyDate(data.rows[0].FcheckinTime));
            if((data.rows[0].FcheckoutTime)!=null) {
                $("#checkOutDate").text(getMyDate(data.rows[0].FcheckoutTime));
            }
        }
    });
    $.ajax({
        url:contextPath+"/billHistory/queryOldManList.do",
        type:"post",
        data:{
            oldManId:$("#oldManId").val(),
            searchEntryDate:searchEntryDate,
            searchEndDate:searchEndDate
        },
        success:function(data) {
            var amount=0;
            $("#oldManList").html("");
            $("#oldManList").append("<tr><td colspan='10' style='text-align: center; font-size: 12px;font-weight: bold'>缴费情况</td></tr>");
            $("#oldManList").append("<tr><td colspan='2'>入账日期</td>" +
                    "<td>账单号</td>" +
                    "<td colspan='2'>账单内容</td>" +
                    "<td colspan='2'>金额</td>" +
                    "<td colspan='3'>累计金额</td></tr>");
            for(var i=0;i<data.total;i++){
            $("#oldManList").append("<tr><td colspan='2'>"+getMyDate(data.rows[i].FPaymentDate)+"</td>" +
                "<td colspan='1'>"+data.rows[i].FID+"</td>" +
                "<td colspan='2'>"+data.rows[i].FChrgeName+"</td>" +
                "<td colspan='2'>"+data.rows[i].FArPaymentAmount+"</td>" +
                "<td colspan='3'>"+(amount+data.rows[i].FArPaymentAmount)+"</tr>")
                amount = amount+data.rows[i].FArPaymentAmount;
            }
            hebing();
            $("#oldManList").append("<tr><td colspan='10' style='text-align: right'><span id='Sum'>缴费合计："+amount+"</span></td></tr> "+
            " <tr><td colspan='10' style='text-align: right'><span id='CapSum'>大写合计："+convertCurrency(amount)+"</span></td></tr>")
        }
    });
}

function hebing() {
    var trlist=$("#oldManList tr");
    var beging=0;
    var end=0;
    var number=0;
    var tdlist;
    for(var i=0;i<trlist.size();i++)
    {
        tdlist=trlist.eq(i).find(' td ');
        if(number==tdlist.eq(1).html())
        {
            end=i;
            if(end==(trlist.size()-1))
            {
                tdlist=trlist.eq(beging).find(' td ');
                tdlist.eq(0).attr("rowspan",end-beging+1);
                tdlist.eq(1).attr("rowspan",end-beging+1);
                for(var j=(beging+1);j<=end;j++)
                {
                    tdlist=trlist.eq(j).find(' td ');
                    tdlist.eq(0).css('display','none');
                    tdlist.eq(1).css('display','none');
                }
            }
        }
        else{
            number=tdlist.eq(1).html();
            if((end-beging)>0)
            {
                tdlist=trlist.eq(beging).find(' td ');
                tdlist.eq(0).attr("rowspan",end-beging+1);
                tdlist.eq(1).attr("rowspan",end-beging+1);
                for(var j=(beging+1);j<=end;j++)
                {
                    tdlist=trlist.eq(j).find(' td ');
                    tdlist.eq(0).css('display','none');
                    tdlist.eq(1).css('display','none');
                }
            }
            beging=i;
            end=i;
        }
    }
}

//得到老人照片
function chooseOldMan() {
    $('#oldManModal').modal('show')
}
function getOldManWithPhoto(temp){
    $("#oldManId").val(temp.getAttribute("selectOmId"));
    $("#searchName").val(temp.getAttribute("selectName"));
    $('#oldManModal').modal('hide')
}


//工具方法：
//将金额转化为大写
function convertCurrency(money) {
    //汉字的数字
    var cnNums = new Array('零', '壹', '贰', '叁', '肆', '伍', '陆', '柒', '捌', '玖');
    //基本单位
    var cnIntRadice = new Array('', '拾', '佰', '仟');
    //对应整数部分扩展单位
    var cnIntUnits = new Array('', '万', '亿', '兆');
    //对应小数部分单位
    var cnDecUnits = new Array('角', '分', '毫', '厘');
    //整数金额时后面跟的字符
    var cnInteger = '整';
    //整型完以后的单位
    var cnIntLast = '元';
    //最大处理的数字
    var maxNum = 999999999999999.9999;
    //金额整数部分
    var integerNum;
    //金额小数部分
    var decimalNum;
    //输出的中文金额字符串
    var chineseStr = '';
    //分离金额后用的数组，预定义
    var parts;
    if (money == '') { return ''; }
    money = parseFloat(money);
    if (money >= maxNum) {
        //超出最大处理数字
        return '';
    }
    if (money == 0) {
        chineseStr = cnNums[0] + cnIntLast + cnInteger;
        return chineseStr;
    }
    //转换为字符串
    money = money.toString();
    if (money.indexOf('.') == -1) {
        integerNum = money;
        decimalNum = '';
    } else {
        parts = money.split('.');
        integerNum = parts[0];
        decimalNum = parts[1].substr(0, 4);
    }
    //获取整型部分转换
    if (parseInt(integerNum, 10) > 0) {
        var zeroCount = 0;
        var IntLen = integerNum.length;
        for (var i = 0; i < IntLen; i++) {
            var n = integerNum.substr(i, 1);
            var p = IntLen - i - 1;
            var q = p / 4;
            var m = p % 4;
            if (n == '0') {
                zeroCount++;
            } else {
                if (zeroCount > 0) {
                    chineseStr += cnNums[0];
                }
                //归零
                zeroCount = 0;
                chineseStr += cnNums[parseInt(n)] + cnIntRadice[m];
            }
            if (m == 0 && zeroCount < 4) {
                chineseStr += cnIntUnits[q];
            }
        }
        chineseStr += cnIntLast;
    }
    //小数部分
    if (decimalNum != '') {
        var decLen = decimalNum.length;
        for (var i = 0; i < decLen; i++) {
            var n = decimalNum.substr(i, 1);
            if (n != '0') {
                chineseStr += cnNums[Number(n)] + cnDecUnits[i];
            }
        }
    }
    if (chineseStr == '') {
        chineseStr += cnNums[0] + cnIntLast + cnInteger;
    } else if (decimalNum == '') {
        chineseStr += cnInteger;
    }
    return chineseStr;
}
//获得年月日  得到日期oTime
function getMyDate(str){
    var oDate = new Date(str),
        oYear = oDate.getFullYear(),
        oMonth = oDate.getMonth()+1,
        oDay = oDate.getDate(),
        oTime = oYear +'-'+ getzf(oMonth) +'-'+ getzf(oDay);//最后拼接时间
    return oTime;
};
//补0操作
function getzf(num){
    if(parseInt(num) < 10){
        num = '0'+num;
    }
    return num;
}
//获得每个月的第一天或者最后一天
function getFirstAndLastMonthDay( year, month){
    var firstdate = year + '-' + getzf(month) +'-01';
    var day = new Date(year,month,0);
    var lastdate = year + '-' + getzf(month) + '-' + getzf(day.getDate());//获取当月最后一天日期
    //给文本控件赋值。同下
    return firstdate;
}
