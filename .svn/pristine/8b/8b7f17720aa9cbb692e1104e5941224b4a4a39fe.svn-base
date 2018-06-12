package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.service.BillHistoryService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangxin on 2017/2/28.
 */
@Controller
@RequestMapping("billHistory")
public class BillHistoryController {
    private static Logger logger = Logger.getLogger(BillHistoryController.class);

    @Autowired
    private BillHistoryService historyService;
    @RequestMapping("/history")
    public String gotoBillHistory(){
        logger.debug("历史账单，已经跳转");
        return "historyBill/historyBillList";
    }
    /**
    *@Description:根据老人ID查询信息
    *@Param:oldManId
    *@return:AjaxResultPo
    *@author:zhangxin
    *@Date:2017/3/13
    */

    @ResponseBody
    @RequestMapping("/queryOldMain")
    public AjaxResultPo queryOldMain(String oldManId, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入queryOldMain()方法");
        List<Map<String,String>> list = this.historyService.getOldManMessage(oldManId);
        return new AjaxResultPo(true,"success",list.size(),list);
    }
    /**
     *@Description:根据老人ID 日期 查询信息
     *@Param:oldManId
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */

    @ResponseBody
    @RequestMapping("/queryOldManList")
    public AjaxResultPo queryOldManList(String oldManId, String searchEntryDate, String searchEndDate, HttpServletRequest request , HttpServletResponse response){
        logger.debug("进入queryOldManList()方法");
        List<Map<String,String>> list = this.historyService.getOldManList(oldManId,searchEntryDate,searchEndDate);
        return new AjaxResultPo(true,"success",list.size(),list);
    }
}
