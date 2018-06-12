package com.channelsoft.ems.controller;

/**
 * Created by liuxing on 2017/2/24.
 */

import com.channelsoft.ems.po.UserPo;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/mobilePresident")
public class MobilePresidentController {
    private static Logger logger = Logger.getLogger(MobilePresidentController.class);

    //全院一览
    @RequestMapping("/allHomeView")
    public String PartialView(HttpServletRequest request,HttpServletResponse response){
        return "mobile/mobilePresident/allHomeView";
    }
    //院长日报
    @RequestMapping("/presidentDaily")
    public String presidentDaily(HttpServletRequest request,HttpServletResponse response){
        return "mobile/mobilePresident/presidentDaily";
    }
    //院长月报
    @RequestMapping("/presidentMonthly")
    public String presidentMonthly(HttpServletRequest request,HttpServletResponse response){
        return "mobile/mobilePresident/presidentMonthly";
    }
    //院长->我
    @RequestMapping("/changePassword")
    public String changePassword(HttpServletRequest request,HttpServletResponse response){
        return "mobile/mobilePresident/changePassword";
    }


}
