package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.InComeMonthPo;
import com.channelsoft.ems.service.InMonthService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zhangxin on 2017/3/3.
 */
@Controller
@RequestMapping("/inMonth")
public class InMonthController {
    private static Logger logger = Logger.getLogger(InMonthController.class);

    @Autowired
    private InMonthService monthService;

    @RequestMapping("/inMonth")
    public String gotoInMonth(){
        logger.debug("进入收入月报");
        return "inComeMonth/inComeMonthList";
    }
    /**
    *@Description:查询 分页用
    *@Param:po
     * @Param:page
     * @param:pageSize
    *@return:AjaxResultPo
    *@author:zhangxin
    *@Date:2017/3/13
    */

    @ResponseBody
    @RequestMapping("/query")
    public AjaxResultPo gotoIncomeList(InComeMonthPo po, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="10")int pageSize, HttpServletRequest request , HttpServletResponse response){
        logger.debug("incomeList--请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
        List<InComeMonthPo> inComecList=monthService.queryList(po,page,pageSize);
        logger.debug("进入gotoEmpMessageList（）方法");
        int dataCount=monthService.queryCount(po);
        return new AjaxResultPo(true,"success",dataCount,inComecList);
    }
}
