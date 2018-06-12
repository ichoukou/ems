package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.ChargeQueryPo;
import com.channelsoft.ems.service.ChargeQueryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zhangxin on 2017/3/7.
 */
@Controller
@RequestMapping("/chargeMonth")
public class ChargeQueryController {
    private static Logger logger = Logger.getLogger(ChargeQueryController.class);

    @Autowired
    private ChargeQueryService chargeQueryService;

    @RequestMapping("/chListMonth")
    public String gotoChargeQuery(){
        logger.debug("进入缴费查询");
        return "chargeQuery/chargeQueryList";
    }
    /**
     *@Description:根据老人ID 日期 查询信息
     *@Param:oldManId
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/query")
    public AjaxResultPo queryChargeList(ChargeQueryPo po, int page, int pageSize, HttpServletRequest request, HttpServletResponse response){
        logger.debug("进入queryChargeList()方法");
        logger.debug("传入参数："+po+"size"+page+"pageSize"+pageSize);
        List<ChargeQueryPo> list = this.chargeQueryService.queryList(po,page, pageSize) ;
        logger.debug("进入gotoEmpMessageList（）方法");
        int dataCount=chargeQueryService.queryCount(po);
        return new AjaxResultPo(true,"success",dataCount,list);
    }
}
