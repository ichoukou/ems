package com.channelsoft.ems.controller;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.service.IncomeAnalysisService;
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
 * Created by liuxing on 2017/3/6.
 */
@Controller
@RequestMapping("/incomeAnalysis")
public class IncomeAnalysisController {
    private Logger logger =Logger.getLogger(IncomeAnalysisController.class);
    @Autowired
    public IncomeAnalysisService incomeAnalysisService;
    /**
     * 跳转收入分析页面
     */
    @RequestMapping("/gotoIncomeAnalysis")
    public String gotoIncomeAnalysis(HttpServletRequest request, HttpServletResponse response){
        logger.debug("进入 gotoIncomeAnalysis 方法");
        return "/incomeAnalysis/incomeAnalysisList";
    }
    /**
     * @description: 条件查询所有数据
     * @param date
     * @param request
     * @param response
     * @return AjaxResultPo
     * @author liuxing
     * @date 2017年3月10日
     */
    @ResponseBody
    @RequestMapping("/queryIncomeAnalysisList")
    public AjaxResultPo queryIncomeAnalysisList(String date,HttpServletRequest request,HttpServletResponse response)
    {
        logger.debug("进入 queryIncomeAnalysisList 方法");
        logger.debug("请求参数： date:"+date);
        Map<String,List<Object>> map=incomeAnalysisService.queryIncomeAnalysisList(date);
        return new AjaxResultPo(true,map);
    }
}
