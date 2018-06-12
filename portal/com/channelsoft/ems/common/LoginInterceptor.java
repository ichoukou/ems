
package com.channelsoft.ems.common;

import com.channelsoft.ems.po.MenuPo;
import com.channelsoft.ems.po.UserPo;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;


/** 
 * 
 * 拦截器  pc端主要起到权限拦截，登录非当前用户可以访问地址时候 进行拦截
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    // 登录登出等公共权限
    private static final String[] loginURL = {
            "/login/index.do/"
    };

    //移动端所有的权限
    private static final String[] ALLMobileURL = {
        "/mobile/index.do/", "/mobile/CheckPass.do/", "/mobile/quit.do/",
        //院长的url
        "/mobilePresident/allHomeView.do/","/mobilePresident/presidentDaily.do/","/mobilePresident/presidentMonthly.do/","/mobilePresident/changePassword.do/",
        //护理的url
        "/staff/staffOldMan.do/","/staff/staffServiceHome.do/","/staff/staffMessage.do/","/staff/staffMine.do/"
            ,"/staff/getRoomCleanState.do/","/staff/staffHomeDetail.do/","/staff/getStaffHomeDetail.do/"
            ,"/staff/allHome.do/","/staff/staffHomeDetailPerform.do/","/staff/staffHomeDetailCancelPerform.do/",

    };
    // 登录登出等公共权限
    private static final String[] loginMobileURL = {
       "/mobile/index.do/","/mobile/quit.do/"
    };

// "/login/quit.do","/login/User.do/",      "login/Pass.do/" ,"/login/CheckPass.do/" ,"/login/updatePass.do"
    //跳转登录界面      //输入用户名密码

    private static final String[] ALL_URL = {
            // 系统设置
            "/sys/dcList.do/", "/user/userm.do/", "/role/roleList.do/", "/author/authorm.do/","/nursing/nursing.do/",
            // 评估等级
            "/health/level.do/", "/rate/range.do/", "/assess/rank.do/",
            // 老人管理
            "/hosing/oldMan.do/" , "/manCharge/omCharge.do/",  "/leave/omLeave.do/",  "/free/omFree.do/",  "/record/getRecordList.do/",
            "/quit/leaveList.do/","/healthy/getHealthyList.do/","/relation/getRelationList.do/",
            // 费用管理
            "/charge/chList.do/",
            // 员工管理
            "/depart/depart.do/",   "/employee/employList.do/" ,  "/arrg/arrg.do/",  "/rewards/employRewards.do/" , "/standard/perfStandard.do/",
              "/maintain/perfMaintain.do/",  "/employ/employLeave.do/",
            // 居家服务管理
            "/Order/order.do/",    "/homeServiceItem/hsList.do/",
         // 财务管理
            "/fundAccountBill/getFundAccountIn.do/" ,  "/fundAccountBill/getFundAccountOut.do/",
            "/fundAccountBill/getFundAccountBillList.do/",   "/cwglPayment/gotoList.do/",
            "/fundAcc/getFundAccList.do/","/fundDelQuery/gotoFundDel.do/","/fundDelQuery/gotoFundMod.do/","/analyse/getAnalysePage.do","/fundAccColse/getClosePage.do",
            //资料管理
            "/charge/chList.do/",    "/building/buList.do/",  "/floor/flList.do/", "/room/roList.do/",
            //库存管理
            "/storageGoods/sgsList.do/",   "/storageGoods/sgmList.do/" ,  "/manager/providerManager.do/",
            "/StoreHome/storeHome.do/",    "/wareHouse/resEnterWareHouse.do/",  "/InStorage/inStorage.do/",
            "/StorageOut/soList.do/",    "/StockAccount/salist.do/",    "/StorageCheck/scList.do/",
            
            //护理康复
            "/nursingProject/indexServiceGroup.do","/nursingProject/index.do","/nursingPlanOldMan/index.do",
            "/nursingPlanPublic/index.do","/oldManPlanExecute/index.do","/publicPlanExecute/index.do",
            //定时任务
            "/job/quartz/index.do",
            //费用管理
            "/Rpayment/rpaymentList.do","/incomeAnalysis/gotoIncomeAnalysis.do/"
};




    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {


        // 登录标识
       boolean flag = false;
        // 权限标识

        //移动端登录表示
        boolean mobileflag=false;


        boolean privilegeFlag = false;
        String requestURL = request.getServletPath();
        String requestType = request.getHeader("X-Requested-With");//请求类型

        System.out.println("请求地址>>>: " + requestURL);
        if (!requestURL.endsWith("/")) {
            requestURL += "/";
        }
      UserPo loginUser = (UserPo) request.getSession().getAttribute( "loginUser"  );
        if (loginUser != null) {
            flag = true;
             //如果已经登录


            // 是否在已登录的情况下再次请求登录界面
            boolean loginAgain = false;
            if (Arrays.asList(loginURL).contains(requestURL)) {
                loginAgain = true;
            }

            // 跳转到主页面

            if (loginAgain) {


                request.getRequestDispatcher("/WEB-INF/views/index.jsp")
                        .forward(request, response);

            } else {//已经登录之后 进行请求

                //进行查询当前用户权限
                String [] QC_URL= ( String [])request.getSession().getAttribute("QC_URL");


                   //权限正确
                    if (Arrays.asList(QC_URL).contains(requestURL)) {
                        privilegeFlag = true;
                    }

                    //如果既不在总的里面也不在该用户权限里面
                if(!Arrays.asList(QC_URL).contains(requestURL)&&!Arrays.asList(ALL_URL).contains(requestURL)){
                    privilegeFlag = true;

                }

                if (!privilegeFlag) {
                   flag = false;
                    // 访问被拦截跳转页面
                   request.getRequestDispatcher("/WEB-INF/views/forbidden.jsp")
                            .forward(request, response);

                }
            }
        }
        else if (Arrays.asList(ALLMobileURL).contains(requestURL)){
            //判断请求是否是登录页,如果是登录页，无论登没登陆过，都跳到登录页
            if (Arrays.asList(loginMobileURL).contains(requestURL)) {
                flag=true;
            }else{
                //判断是否登陆过，如果已经登录，直接跳到请求地址，如果未登录，无论请求地址是什么都跳到登录页
                UserPo mobile = (UserPo) request.getSession().getAttribute("mobileUser");
                if(mobile!=null){
                    flag=true;
                }else{
                    response.sendRedirect(request.getContextPath()
                            + "/mobile/index.do");
                    flag=true;
                }
            }

//            UserPo mobile = (UserPo) request.getSession().getAttribute( "mobileUser"  );
//               if(mobile!=null){
//                   mobileflag=true;
//                   // 是否在已登录的情况下再次请求登录界面
//                   boolean loginMobileAgain = false;
//                   if (requestURL.equals("/mobile/index.do/")) {
//                       loginMobileAgain = true;
//                   }
//                   if ( Arrays.asList(ALLMobileURL).contains(requestURL)) {
//                       flag = true;
//                   }
//
//                   // 跳转到主页面
//                   if (loginMobileAgain) {
//                       response.sendRedirect(request.getContextPath()
//                               + "/mobile/index.do");
//
//                   }
//               }else{
//                   if (Arrays.asList(loginMobileURL).contains(requestURL)) {
//                       mobileflag = true;
//                   }
//                   if(!mobileflag){
//                       response.sendRedirect(request.getContextPath()
//                               + "/mobile/index.do");
//                   }
//                   if(mobileflag){
//                       flag=true;
//                   }
//
//               }
        }
        else {
            if (Arrays.asList(loginURL).contains(requestURL)) {
            flag = true;
         }

         if (!flag) {

            response.sendRedirect(request.getContextPath()
                     + "/login/index.do");
         }

        }
        return flag;
    }

    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

    }

}

