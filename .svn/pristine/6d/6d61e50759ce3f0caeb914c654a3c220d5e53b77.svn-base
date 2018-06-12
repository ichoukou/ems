//右下角提示
function openNotice(title,content) {
	var colors = ['red', 'green', 'blue', 'yellow']; //'black',
	var currentColor = 0;
	
	new jBox('Notice', {
		autoClose : 1000*100,
		attributes : {
			x : 'right',
			y : 'bottom'
		},
		stack : false,
		animation : {
			open : 'tada',
			close : 'zoomIn'
		},
		title : title,
		content : content,
		onInit : function() {
			this.options.color = 'yellow';
			currentColor++;
			(currentColor >= colors.length) && (currentColor = 0);
		},
	});
}

//提示框
function alertx(content){
	$.alert({
        title: "<div id='alertx_title_div' class='alert alert-warning'>友情提示</div>",
        content: "<div id='alertx_content_div' class='alert alert-info'>"+content+"</div>",
        confirmButton: '确认',
        confirmButtonClass: 'btn-info',
        columnClass : 'col-md-offset-4 col-md-4',
        animation: 'bottom',
        backgroundDismiss: false
    });
	
	$("#alertx_title_div").parent().css("padding-bottom","0px");
	$("#alertx_content_div").parent().css("margin-bottom","0px");
	
}

//确认提示框
function alertc(content){
   $.confirm({
        title: '注意!',
        content: content,
        confirmButton : '确认',
        confirm: function(){
        	return true;
        },
        cancel: function(){
            return false;
        }
    });
}



//opts 可从网站在线制作
var toppx = ($(window.parent).height()*0.5 - 120)+'px';
var leftpx = ($(window.parent).width()*0.5 - 200)+'px';
var opts = {            
  lines: 12, // 花瓣数目
  length: 5, // 花瓣长度
  width: 5, // 花瓣宽度
  radius: 15, // 花瓣距中心半径
  corners: 1, // 花瓣圆滑度 (0-1)
  rotate: 24, // 花瓣旋转角度
  direction: 1, // 花瓣旋转方向 1: 顺时针, -1: 逆时针
  color: 'red', // 花瓣颜色
  speed: 1, // 花瓣旋转速度
  trail: 80, // 花瓣旋转时的拖影(百分比)
  shadow: true, // 花瓣是否显示阴影
  hwaccel: true, //spinner 是否启用硬件加速及高速旋转            
  className: 'spinner', // spinner css 样式名称
  zIndex: 2e9, // spinner的z轴 (默认是2000000000)
  top:toppx, // spinner 相对父容器Top定位 单位 px
  left:leftpx // spinner 相对父容器Left定位 单位 px
};
var spinner;
function showwaiting(){
	spinner = new Spinner(opts);
	//parent 代表 index.jsp页面
	parent.$("#mask").css("height",$(window.parent).height());  
	parent.$("#mask").css("width",$(window.parent).width());  
	parent.$("#mask").show();
	var target = document.getElementById('waiting');
	spinner.spin(target); 
}

function closewaiting(){
	parent.$("#mask").hide();
	spinner.spin();
}

function ymd(val) {
	if(val==undefined || val=="" ){
		return "";
	}
	var time;
	if(val != null && val != ""){
		var year  = parseInt(val.year) + 1900;
		var month = parseInt(val.month) + 1;
		var date  = parseInt(val.date);
		
		month = month > 9 ? month : ('0' + month);
		date  = date > 9 ? date : ('0' + date);
		
		time  = year + '-' + month + '-' + date;
	}
	return time;
}

function ymd_hms(val) {
	if(val==undefined || val=="" ){
		return "";
	}
	var time;
	if(val != null && val != ""){
		var year  = parseInt(val.year) + 1900;
		var month = parseInt(val.month) + 1;
		var date  = parseInt(val.date);
		
		month = month > 9 ? month : ('0' + month);
		date = date > 9 ? date : ('0' + date);
		
		var hours   = parseInt(val.hours);
		var minutes = parseInt(val.minutes);
		var seconds = parseInt(val.seconds);
		
		hours   = hours > 9 ? hours : ('0' + hours);
		minutes = minutes > 9 ? minutes : ('0' + minutes);
		seconds = seconds > 9 ? seconds : ('0' + seconds);
		
		time = year + '-' + month + '-' + date + ' ' + hours + ':' + minutes + ':' + seconds;
	}
	return time;
}

function Date2Str(date){
	var day = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
	var month = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0"
	+ (date.getMonth() + 1);
	return date.getFullYear() + '-' + month + '-' + day;
}
