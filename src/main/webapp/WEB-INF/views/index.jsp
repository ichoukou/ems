<%@ page import="java.util.List" %>
<%@ page import="com.channelsoft.ems.po.MenuPo" %>
<%@ page import="com.channelsoft.ems.po.UserPo" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <title>养老管理系统</title>


    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="favicon.ico">
     <link href="${pageContext.request.contextPath}/script/lib/H+/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/script/lib/H+/css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header">
                        <div class="dropdown profile-element">
                            <span><img alt="image" class="img-circle" style="width: 64px;height: 64px;" src="${pageContext.request.contextPath}\\img\\<%=((UserPo)session.getAttribute("loginUser")).getStaffPicture()%>" /></span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                <span class="block m-t-xs"><strong class="font-bold"><%=((UserPo)session.getAttribute("loginUser")).getUname()%></strong></span>
                                <span class="text-muted text-xs block"><%=((UserPo)session.getAttribute("loginUser")).getRoleName()%><b class="caret"></b></span>
                                </span>
                            </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a class="J_menuItem" href="${pageContext.request.contextPath}/login/Pass.do">修改密码</a>
                                </li>
                                <li><a class="J_menuItem"  href="${pageContext.request.contextPath}/login/User.do" >个人资料</a>
                                </li>
                                <li class="divider"></li>
                                <li><a href="${pageContext.request.contextPath}/login/quit.do">安全退出</a>
                                </li>
                            </ul>
                        </div>
                        <div class="logo-element">
                        	<img alt="image" src="${pageContext.request.contextPath}/img/logomini.png"/>
                        </div>
                    </li>
                    <%
                    List list=(List)request.getSession().getAttribute("list");

                        String id="";
                        for(int i=0;i<list.size();i++){
                            MenuPo po=(MenuPo)list.get(i);

                            if(i==0){%>
                              <%--  out.print(po.getSparentid()+""+po.getSname()+""+po.getSoname()+"</br>");--%>
                    <li>
                        <a href="#"><span class="nav-label"><%=po.getSname()%></span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="${pageContext.request.contextPath}<%=po.getSurl()%>"><%=po.getSoname()%></a>
                            </li>
                           <% }else{

                                if(po.getSparentid().equals(id)){%>
                                  <%--  out.print(""+po.getSoname()+"</br>");--%>
                            <li>
                                <a class="J_menuItem" href="${pageContext.request.contextPath}<%=po.getSurl()%>"><%=po.getSoname()%></a>
                            </li>

                                 <%}else{%>

                            <%--  out.print(po.getSparentid()+""+po.getSname()+""+po.getSoname()+"</br>");--%>
                        </ul>
                    </li>    <li>
                                <a href="#"><span class="nav-label"><%=po.getSname()%></span><span class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a class="J_menuItem" href="${pageContext.request.contextPath}<%=po.getSurl()%>"><%=po.getSoname()%></a>
                                    </li>

                                <%}
                            }
                           id=po.getSparentid();
                        }
                    %>





                <%--    //头
                    <li>
                        <a href="#"><span class="nav-label">系统设置</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">


                            //头

                            <li>
                                <a class="J_menuItem" href="${pageContext.request.contextPath}/sys/dcList.do">字典管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="${pageContext.request.contextPath }/user/userm.do">用户管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="${pageContext.request.contextPath}/role/roleList.do">角色管理</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="${pageContext.request.contextPath }/author/authorm.do">权限分配</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="${pageContext.request.contextPath }/nursing/nursing.do">养老院管理</a>
                            </li>
                  //第二个开始
                        </ul>
                    </li>
                    <li>
                        <a href="#"><span class="nav-label">评估管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">

                  //第二个开始


                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/health/level.do">评估项目</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath }/rate/range.do">评估等级范围</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath }/assess/rank.do">评估定级</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><span class="nav-label">老人管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/hosing/oldMan.do">办理入住</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/manCharge/omCharge.do">老人费用</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/leave/omLeave.do">请假管理</a>
                            </li></li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/free/omFree.do">减免单据</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/record/getRecordList.do">日常记录</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/quit/leaveList.do">退住管理</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><span class="nav-label">费用管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="#">缴费管理</a>
                            </li>
                            <li><a class="J_menuItem" href="#">缴费查询</a>
                            </li>
                            <li><a class="J_menuItem" href="#">退住结算</a>
                            </li>
                            <li><a class="J_menuItem" href="#">收入分析</a>
                            </li>
                            <li><a class="J_menuItem" href="#">收入月报</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><span class="nav-label">员工管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/depart/depart.do">部门管理</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/employee/employList.do">员工信息</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/arrg/arrg.do">员工排房</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/employ/employLeave.do">员工请假</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/rewards/employRewards.do">员工奖惩</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/standard/perfStandard.do">绩效标准</a>
                            </li>
                            <li><a class="J_menuItem"  href="${pageContext.request.contextPath}/maintain/perfMaintain.do">员工绩效</a>
                            </li>
                        </ul>
                    </li>
                    <li>

                        <a href="#"><span class="nav-label">居家管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/Order/order.do">居家服务订单</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/homeServiceItem/hsList.do">居家服务项目</a>
                            </li>
                        </ul>
                    </li>
                    <li>

                        <a href="#"><span class="nav-label">财务管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="#">账户收入</a>
                            </li>
                            <li><a class="J_menuItem" href="#">账户支出</a>
                            </li>
                            <li><a class="J_menuItem" href="#">收支查询</a>
                            </li>
                            <li><a class="J_menuItem" href="#">月份分析</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/cwglPayment/gotoList.do">收支用途分类</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/fundAcc/getFundAccList.do">资金账户</a>
                            </li>
                            <li><a class="J_menuItem" href="#">业务项目设置</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><span class="nav-label">资料管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath}/charge/chList.do">收费标准</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath }/building/buList.do">大厦管理</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath }/floor/flList.do">楼层管理</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath }/room/roList.do">房间管理</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><span class="nav-label">库存管理</span><span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath }/storageGoods/sgsList.do">物品分类</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath }/storageGoods/sgmList.do">物品管理</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath }/manager/providerManager.do">供应商管理</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath }/StoreHome/storeHome.do">仓库管理</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath }/wareHouse/resEnterWareHouse.do">物品采购</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath }/InStorage/inStorage.do">物品入库</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath }/StorageOut/soList.do">物品出库</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath }/StockAccount/salist.do">库存台账</a>
                            </li>
                            <li><a class="J_menuItem" href="${pageContext.request.contextPath }/StorageCheck/scList.do">库存盘点</a>
                            </li>
     &lt;%&ndash;             下面 ul li可以不进行遍历          &ndash;%&gt;

                        </ul>
                    </li>--%>
<%--              在此之上进行遍历           --%>
                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                        <form role="search" class="navbar-form-custom" method="post" action="search_results.html">
                            <div class="form-group">
                               <%--  <img alt="image"  src="${pageContext.request.contextPath}/img/title.png" > --%>
                            </div>
                        </form>
                    </div>
                    <ul class="nav navbar-top-links navbar-right">
                        <li class="dropdown">
                            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                <i class="fa fa-envelope"></i> <span class="label label-warning">16</span>
                            </a>
                            <ul class="dropdown-menu dropdown-messages">
                                <li class="m-t-xs">
                                    <div class="dropdown-messages-box">
                                        <a href="profile.html" class="pull-left">
                                            <img alt="image" class="img-circle" src="${pageContext.request.contextPath}/img/a7.jpg">
                                        </a>
                                        <div class="media-body">
                                            <small class="pull-right">46小时前</small>
                                            <strong>小四</strong> 这个在日本投降书上签字的军官，建国后一定是个不小的干部吧？
                                            <br>
                                            <small class="text-muted">3天前 2014.11.8</small>
                                        </div>
                                    </div>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <div class="dropdown-messages-box">
                                        <a href="profile.html" class="pull-left">
                                            <img alt="image" class="img-circle" src="${pageContext.request.contextPath}/img/a4.jpg">
                                        </a>
                                        <div class="media-body ">
                                            <small class="pull-right text-navy">25小时前</small>
                                            <strong>国民岳父</strong> 如何看待“男子不满自己爱犬被称为狗，刺伤路人”？——这人比犬还凶
                                            <br>
                                            <small class="text-muted">昨天</small>
                                        </div>
                                    </div>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <div class="text-center link-block">
                                        <a class="J_menuItem" href="${pageContext.request.contextPath}/msg/mailbox.do">
                                            <i class="fa fa-envelope"></i> <strong> 查看所有消息</strong>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                <i class="fa fa-bell"></i> <span class="label label-primary">8</span>
                            </a>
                            <ul class="dropdown-menu dropdown-alerts">
                                <li>
                                    <a href="mailbox.html">
                                        <div>
                                            <i class="fa fa-envelope fa-fw"></i> 您有16条未读消息
                                            <span class="pull-right text-muted small">4分钟前</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="profile.html">
                                        <div>
                                            <i class="fa fa-qq fa-fw"></i> 3条新回复
                                            <span class="pull-right text-muted small">12分钟钱</span>
                                        </div>
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <div class="text-center link-block">
                                        <a class="J_menuItem" href="notifications.html">
                                            <strong>查看所有 </strong>
                                            <i class="fa fa-angle-right"></i>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                      <!--   <li class="hidden-xs">
                            <a href="index_v1.html" class="J_menuItem" data-index="0"><i class="fa fa-cart-arrow-down"></i> 购买</a>
                        </li> -->
                        <li class="dropdown hidden-xs">
                            <a class="right-sidebar-toggle" aria-expanded="false">
                                <i class="fa fa-tasks"></i> 主题
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="row content-tabs"><button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
                </button>
                <nav class="page-tabs J_menuTabs">
                    <div class="page-tabs-content">
                        <a href="javascript:;" class="active J_menuTab" data-id="#">首页</a>
                    </div>
                </nav>
                <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
                </button>
                <div class="btn-group roll-nav roll-right">
                    <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                    </button>
                    <ul role="menu" class="dropdown-menu dropdown-menu-right">
                        <li class="J_tabShowActive"><a>定位当前选项卡</a>
                        </li>
                        <li class="divider"></li>
                        <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                        </li>
                        <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                        </li>
                    </ul>
                </div>
                <a href="${pageContext.request.contextPath}/login/quit.do" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
            </div>
            <div class="row J_mainContent" id="content-main">
                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="${pageContext.request.contextPath}/sys/dcList.do" frameborder="0" data-id="index_v1.html" seamless></iframe>


            </div>
            <div class="footer">
                <div class="pull-right">&copy; 2014-2015 <a href="#" target="_blank">footer</a>
                </div>
            </div>
        </div>
        <!--右侧部分结束-->
        <!--右侧边栏开始-->
        <div id="right-sidebar">
            <div class="sidebar-container">

                <ul class="nav nav-tabs navs-3">

                    <li class="active">
                        <a data-toggle="tab" href="#tab-1">
                            <i class="fa fa-gear"></i> 主题
                        </a>
                    </li>
                    <li class=""><a data-toggle="tab" href="#tab-2">
                        通知
                    </a>
                    </li>
                    <li><a data-toggle="tab" href="#tab-3">
                        项目进度
                    </a>
                    </li>
                </ul>

                <div class="tab-content">
                    <div id="tab-1" class="tab-pane active">
                        <div class="sidebar-title">
                            <h3> <i class="fa fa-comments-o"></i> 主题设置</h3>
                            <small><i class="fa fa-tim"></i> 你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>
                        </div>
                        <div class="skin-setttings">
                            <div class="title">主题设置</div>
                            <div class="setings-item">
                                <span>收起左侧菜单</span>
                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu">
                                        <label class="onoffswitch-label" for="collapsemenu">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="setings-item">
                                <span>固定顶部</span>

                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox" id="fixednavbar">
                                        <label class="onoffswitch-label" for="fixednavbar">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="setings-item">
                                <span>
                        固定宽度
                    </span>

                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox" id="boxedlayout">
                                        <label class="onoffswitch-label" for="boxedlayout">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="title">皮肤选择</div>
                            <div class="setings-item default-skin nb">
                                <span class="skin-name ">
                         <a href="#" class="s-skin-0">
                             默认皮肤
                         </a>
                    </span>
                            </div>
                            <div class="setings-item blue-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-1">
                            蓝色主题
                        </a>
                    </span>
                            </div>
                            <div class="setings-item yellow-skin nb">
                                <span class="skin-name ">
                        <a href="#" class="s-skin-3">
                            黄色/紫色主题
                        </a>
                    </span>
                            </div>
                        </div>
                    </div>
                    <div id="tab-2" class="tab-pane">

                        <div class="sidebar-title">
                            <h3> <i class="fa fa-comments-o"></i> 最新通知</h3>
                            <small><i class="fa fa-tim"></i> 您当前有10条未读信息</small>
                        </div>

                        <div>

                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="${pageContext.request.contextPath}/img/a1.jpg">

                                        <div class="m-t-xs">
                                            <i class="fa fa-star text-warning"></i>
                                            <i class="fa fa-star text-warning"></i>
                                        </div>
                                    </div>
                                    <div class="media-body">

                                        据天津日报报道：瑞海公司董事长于学伟，副董事长董社轩等10人在13日上午已被控制。
                                        <br>
                                        <small class="text-muted">今天 4:21</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="${pageContext.request.contextPath}/img/a2.jpg">
                                    </div>
                                    <div class="media-body">
                                        HCY48之音乐大魔王会员专属皮肤已上线，快来一键换装拥有他，宣告你对华晨宇的爱吧！
                                        <br>
                                        <small class="text-muted">昨天 2:45</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="${pageContext.request.contextPath}/img/a3.jpg">

                                        <div class="m-t-xs">
                                            <i class="fa fa-star text-warning"></i>
                                            <i class="fa fa-star text-warning"></i>
                                            <i class="fa fa-star text-warning"></i>
                                        </div>
                                    </div>
                                    <div class="media-body">
                                        写的好！与您分享
                                        <br>
                                        <small class="text-muted">昨天 1:10</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="${pageContext.request.contextPath}/img/a4.jpg">
                                    </div>

                                    <div class="media-body">
                                        国外极限小子的炼成！这还是亲生的吗！！
                                        <br>
                                        <small class="text-muted">昨天 8:37</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="${pageContext.request.contextPath}/img/a8.jpg">
                                    </div>
                                    <div class="media-body">

                                        一只流浪狗被收留后，为了减轻主人的负担，坚持自己觅食，甚至......有些东西，可能她比我们更懂。
                                        <br>
                                        <small class="text-muted">今天 4:21</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="${pageContext.request.contextPath}/img/a7.jpg">
                                    </div>
                                    <div class="media-body">
                                        这哥们的新视频又来了，创意杠杠滴，帅炸了！
                                        <br>
                                        <small class="text-muted">昨天 2:45</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="${pageContext.request.contextPath}/img/a3.jpg">

                                        <div class="m-t-xs">
                                            <i class="fa fa-star text-warning"></i>
                                            <i class="fa fa-star text-warning"></i>
                                            <i class="fa fa-star text-warning"></i>
                                        </div>
                                    </div>
                                    <div class="media-body">
                                        最近在补追此剧，特别喜欢这段表白。
                                        <br>
                                        <small class="text-muted">昨天 1:10</small>
                                    </div>
                                </a>
                            </div>
                            <div class="sidebar-message">
                                <a href="#">
                                    <div class="pull-left text-center">
                                        <img alt="image" class="img-circle message-avatar" src="${pageContext.request.contextPath}/img/a4.jpg">
                                    </div>
                                    <div class="media-body">
                                        我发起了一个投票 【你认为下午大盘会翻红吗？】
                                        <br>
                                        <small class="text-muted">星期一 8:37</small>
                                    </div>
                                </a>
                            </div>
                        </div>

                    </div>
                    <div id="tab-3" class="tab-pane">

                        <div class="sidebar-title">
                            <h3> <i class="fa fa-cube"></i> 最新任务</h3>
                            <small><i class="fa fa-tim"></i> 您当前有14个任务，10个已完成</small>
                        </div>

                        <ul class="sidebar-list">
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">9小时以后</div>
                                    <h4>市场调研</h4> 按要求接收教材；

                                    <div class="small">已完成： 22%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                                    </div>
                                    <div class="small text-muted m-t-xs">项目截止： 4:00 - 2015.10.01</div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">9小时以后</div>
                                    <h4>可行性报告研究报上级批准 </h4> 编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的 开发进度作出一个合理的比对

                                    <div class="small">已完成： 48%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 48%;" class="progress-bar"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">9小时以后</div>
                                    <h4>立项阶段</h4> 东风商用车公司 采购综合综合查询分析系统项目进度阶段性报告武汉斯迪克科技有限公司

                                    <div class="small">已完成： 14%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="label label-primary pull-right">NEW</span>
                                    <h4>设计阶段</h4>
                                    <!--<div class="small pull-right m-t-xs">9小时以后</div>-->
                                    项目进度报告(Project Progress Report)
                                    <div class="small">已完成： 22%</div>
                                    <div class="small text-muted m-t-xs">项目截止： 4:00 - 2015.10.01</div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">9小时以后</div>
                                    <h4>拆迁阶段</h4> 科研项目研究进展报告 项目编号: 项目名称: 项目负责人:

                                    <div class="small">已完成： 22%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 22%;" class="progress-bar progress-bar-warning"></div>
                                    </div>
                                    <div class="small text-muted m-t-xs">项目截止： 4:00 - 2015.10.01</div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">9小时以后</div>
                                    <h4>建设阶段 </h4> 编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的 开发进度作出一个合理的比对

                                    <div class="small">已完成： 48%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 48%;" class="progress-bar"></div>
                                    </div>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <div class="small pull-right m-t-xs">9小时以后</div>
                                    <h4>获证开盘</h4> 编写目的编写本项目进度报告的目的在于更好的控制软件开发的时间,对团队成员的 开发进度作出一个合理的比对

                                    <div class="small">已完成： 14%</div>
                                    <div class="progress progress-mini">
                                        <div style="width: 14%;" class="progress-bar progress-bar-info"></div>
                                    </div>
                                </a>
                            </li>

                        </ul>

                    </div>
                </div>

            </div>
        </div>
        
    </div>

    <!-- 全局js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/layer/layer.min.js"></script>
	
    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/hplus.js?v=4.1.0"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/script/lib/H+/js/contabs.js"></script>

    <!-- 第三方插件 -->
    <script src="${pageContext.request.contextPath}/script/lib/H+/js/plugins/pace/pace.min.js"></script>



</body>

</html>



