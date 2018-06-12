$(function () {
    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_RoleManage').bootstrapTable({
            url: 'query.do',   //请求后台的URL（*）
            method: 'post', //请求方式（*）
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
            pageSize: 10,      //每页的记录行数（*）
            //pageList: [10, 25, 50, 100],  //可供选择的每页的行数（*）
            search: false,      //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,     //是否显示所有的列
            showRefresh: true,     //是否显示刷新按钮
            minimumCountColumns: 2,    //最少允许的列数
            clickToSelect: true,    //是否启用点击选中行
            height: 600,      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "ID",      //每一行的唯一标识，一般为主键列
            showToggle:true,     //是否显示详细视图和列表视图的切换按钮
            cardView: false,     //是否显示详细视图
            detailView: false,     //是否显示父子表
            columns: [{
                radio: true
            }, {
                field: 'id',
                title: '编号'
            }, {
                field: 'name',
                title: '角色名称'
            }, {
                field: 'attr',
                title: '角色属性'
            }, {
                field: 'oldHouse',
                title: '所属养老院'
            }, {
                field: 'state',
                title: '状态',
                formatter:function(value) {
                    if (value == 1) {
                        return '<span style="color:#80b2ff">开启</span>'
                    } else if (value == 0) {
                        return '<span style="color:#FF0000">禁用</span>'
                    }
                }
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            pageSize: params.limit, //页面大小
            page: params.offset, //页码
            name: $("#searchName").val(),
            value: $("#searchValue").val()
        };
        return temp;
    };
    return oTableInit;
};
function gotoAdd(){
    getDataList(),
    getOldHouse()
}

//角色属性
function getDataList() {
    $.ajax({
        url:contextPath+"/sys/get.do",
        type:"post",
        data:{
            page:1,
            pageSize:10000000
        },
        success:function(data) {
          var $add = "";
            for (var i = 0; i < data.total; i++) {
                if (data.rows[i].name == "角色属性") {
                    $add+="<div class='col-sm-1'><label><input type='radio' name='name' value='"+data.rows[i].value+"'>"+data.rows[i].value+"</label></div>";
                }
            }
            $("#roleName").html($add);
            getAdd();
        }
    });
}

//养老院
function getOldHouse() {
    $.ajax({
        url:contextPath+"/nursing/queryStartFNursing.do",
        type:"post",
        dataType:'json',
        success:function(data) {
            //增加角色下拉框
            $("#addOldHome").html("");
            var $add=$("#addOldHome");
            $add.append("<option value=''>请选择一个养老院</option>");
            for (var i=0;i<data.total;i++){
                $add.append("<option value='"+data.rows[i].fID+"'>"+data.rows[i].fNursingName+"</option>");
            }
        }
    });
}

//新增，包括验证
function getAdd() {
    $('#form_validate').bootstrapValidator({
        message : 'This value is not valid',
        feedbackIcons : {
            valid : 'glyphicon glyphicon-ok',
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        fields : {
            addName : {
                message : '请填写角色名称',
                validators : {
                    notEmpty : {
                        message : '请填写角色名称'
                    },
                    remote : {// ajax验证。server result:{"valid",true or false}
                        // 向服务发送当前input
                        // name值，获得一个json数据。例表示正确：{"valid",true}
                        url : contextPath + "/role/check.do",// 验证地址
                        message : '角色名已存在，请重新输入',// 提示消息
                        delay : 2000,// 每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                        type : 'POST',// 请求方式
                        // 自定义提交数据，默认值提交当前input value
                        data : function(validator) {
                            return {
                                name : $('[name="addName"]').val(),
                            };
                        }
                    },
                }
            },
            addOldHome:{
                validators : {
                    notEmpty: {
                        message: '请选择养老院'
                    },
                }
            },
            name:{
                validators : {
                    notEmpty: {
                        message: '请选择角色属性'
                    },
                }
            }
        }
    }).on('success.form.bv', function(e) {
        e.preventDefault();
        $("#addModal").modal('hide');
        $.ajax({
            url : contextPath + "/role/addRole.do",
            type : "post",
            data : {
                name: $("#addName").val(),
                attr: $("input[type='radio']:checked").val(),
                oldHouseId: $("#addOldHome option:selected").val()
            },
            success : function(data) {
                if (data.msg == "success") {
                    setAlert(data.message, "添加成功");
                } else if (data.msg == "error") {
                    setAlert(data.message, "添加失败");
                }
                $('#tb_RoleManage').bootstrapTable('refresh', {
                    url : 'query.do'
                });
                clearInput();
            }
        });
        //重置表单
        $('#form_validate').bootstrapValidator('resetForm', true);
    });

}
//修改，包括验证
function getUpdate() {
    $('#up_form_validate').bootstrapValidator({
        message : 'This value is not valid',
        feedbackIcons : {
            valid : 'glyphicon glyphicon-ok',
            invalid : 'glyphicon glyphicon-remove',
            validating : 'glyphicon glyphicon-refresh'
        },
        fields : {
            updateName : {
                message : '请填写角色名称',
                validators : {
                    notEmpty : {
                        message : '请填写角色名称'
                    },
                    remote : {// ajax验证。server result:{"valid",true or false}
                        // 向服务发送当前input
                        // name值，获得一个json数据。例表示正确：{"valid",true}
                        url : contextPath + "/role/updateCheck.do",// 验证地址
                        message : '角色名已存在，请重新输入',// 提示消息
                        delay : 2000,// 每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）
                        type : 'POST',// 请求方式
                        // 自定义提交数据，默认值提交当前input value
                        data : function(validator) {
                            return {
                                name : $("#updateName").val(),
                                id:$('[name="role_id"]').val(),
                            };
                        }
                    },
                }
            },
            updateOldHome:{
                validators : {
                    notEmpty: {
                        message: '请选择养老院'
                    },
                }
            },
        }
    }).on('success.form.bv', function(e) {
        e.preventDefault();
        $("#updateModal").modal('hide');
        $.ajax({
            url : contextPath + "/role/updateRole.do",
            type : "post",
            data : {
                id: $("#role_id").val(),
                name: $("#updateName").val(),
                attr: $("input[name='updateName']:checked").val(),
                oldHouseId: $("#updateOldHome option:selected").val()
            },
            success : function(data) {
                if (data.msg == "success") {
                    setAlert(data.message, "更改成功");
                } else if (data.msg == "error") {
                    setAlert(data.message, "更改失败");
                }
                $('#tb_RoleManage').bootstrapTable('refresh', {
                    url : 'query.do'
                });
                clearInput();
            }
        });
        $('#up_form_validate').bootstrapValidator('resetForm', true);
    });
}


//禁用
function gotoDelete(){
    var carrentItem = $("#tb_RoleManage").bootstrapTable('getSelections');
    if(carrentItem[0]){
        $.ajax({
            url:contextPath+"/role/deleteRole.do",
            type:"post",
            data:{
                id:carrentItem[0].id
            },
            success:function(data) {
                $('#tb_RoleManage').bootstrapTable('load', data);

                if(data.success){
                    setAlert(data.msg,"操作成功");
                    $('#tb_RoleManage').bootstrapTable('refresh', {url: 'query.do'});
                }else{

                }
            }
        });
    }else{
        setAlert("error","请先选择一条数据");
    }
}

//启用
function gotoEnabled(){
    var carrentItem = $("#tb_RoleManage").bootstrapTable('getSelections');
    if(carrentItem[0]){
        if(carrentItem[0].state==1){
            setAlert("error","该条记录已经是启用状态");
        }else{
            $.ajax({
                url:contextPath+"/role/startRole.do",
                type:"post",
                data:{
                    id:carrentItem[0].id
                },
                success:function(data) {
                    $('#tb_RoleManage').bootstrapTable('refresh', {url: 'query.do'});
                    setAlert(data.msg,"启用成功");

                }
            });
        }
    }else{
        setAlert("error","请先选择一条数据");
    }
}

//清空
function clearInput() {
    $("#addName").val("");
    //$browsers.removeAttr("checked");
    $("input[type='radio']").removeAttr("checked");
    $("#updateName").val("");
    //$("input[type='radio']").val("");
    $("#addOldHome").val("");
    $("#updateOldHome").val("");
}

//页面回显数据
function gotoUpdate(){
    var carrentItem = $("#tb_RoleManage").bootstrapTable('getSelections');
    var bool='';
    if(carrentItem[0]){
        if(carrentItem[0].state=="0"){
            setAlert("error", "该记录已禁用，无法更新");
        }else {
            //获得养老院
            $.ajax({
                url: contextPath + "/nursing/queryStartFNursing.do",
                type: "post",
                dataType: 'json',
                success: function (data) {
                    for (var i = 0; i < data.total; i++) {
                        if (data.rows[i].fNursingName == carrentItem[0].oldHouse) {
                            bool = true;//如果bool=true 证明没有禁用 如果bool=''证明被禁用
                        }
                        $("#updateOldHome").html("");
                        if(bool==''){
                            var $update = $("#updateOldHome");
                            $update.append("<option value='"+carrentItem[0].oldHouseId+"' selected='selected'>"+carrentItem[0].oldHouse+"</option>");
                            for (var i=0;i<data.total;i++){
                                $update.append("<option value='"+data.rows[i].fID+"'>"+data.rows[i].fNursingName+"</option>");
                            }
                        }
                        //未被禁用
                        if(bool==true){
                            var $update=$("#updateOldHome");
                            for (var i=0;i<data.total;i++){
                                if(data.rows[i].fNursingName == carrentItem[0].oldHouse){
                                    $update.append("<option value='"+data.rows[i].fID+"' selected='selected' >"+data.rows[i].fNursingName+"</option>");
                                }else{
                                    $update.append("<option value='"+data.rows[i].fID+"'>"+data.rows[i].fNursingName+"</option>");
                                }
                            }
                        }
                    }
                }
            });

            //获得角色属性
            $.ajax({
                url: contextPath + "/sys/get.do",
                type: "post",
                data: {
                    page: 1,
                    pageSize: 100000000
                },
                success: function (data) {
                    $("#updateRoleName").html("");
                    var $update = $("#updateRoleName");
                    for (var i = 0; i < data.total; i++) {
                        if (data.rows[i].name == "角色属性") {
                            if (data.rows[i].value == carrentItem[0].attr) {
                                $update.append("<div class='col-sm-1'><label><input type='radio' name='updateName'checked='checked' value='"+data.rows[i].value+"'>"+data.rows[i].value+"</label></div>");
                                // $update.append("<input type='radio' value='" + data.rows[i].value + "'checked='checked' name='updateName'>");
                                // $update.append("<label style='width: 47px'>" + data.rows[i].value + "</label>");
                            } else {
                                $update.append("<div class='col-sm-1'><label><input type='radio' name='updateName' value='"+data.rows[i].value+"'>"+data.rows[i].value+"</label></div>");
                                // $update.append("<input type='radio' value='" + data.rows[i].value + "'name='updateName'>");
                                // $update.append("<label style='width: 47px'>" + data.rows[i].value + "</label>");
                            }
                        }
                    }
                    getUpdate();
                }
            });

            $("#role_id").val(carrentItem[0].id);
            $("#updateName").val(carrentItem[0].name);
            $("#updateOldHome option[value='" + carrentItem[0].oldHouse + "']").attr("selected", true);
            $("#update_btn").click();
        }
    }else{
        setAlert("error","请先选择一条数据");
    }
}