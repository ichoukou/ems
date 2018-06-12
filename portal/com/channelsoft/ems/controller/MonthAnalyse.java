package com.channelsoft.ems.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.AnalysePo;
import com.channelsoft.ems.po.FundAccountBillPo;
import com.channelsoft.ems.service.MonthAnalyseService;

@Controller
@RequestMapping("/analyse")
public class MonthAnalyse {
	
	@Autowired
	private MonthAnalyseService analyseService;
	
	private Logger logger=Logger.getLogger(MonthAnalyse.class);
	
	@RequestMapping("/getAnalysePage")
	public String getAnalysePage(){
		return "analyse/analysePage";
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public AjaxResultPo query(FundAccountBillPo fundAccountBillPo,HttpServletRequest request,HttpServletResponse response,int page,int pageSize){
		logger.debug("传进来的参数为"+fundAccountBillPo.toString() );
		List<AnalysePo> list = analyseService.monthAnalyse(page, pageSize, fundAccountBillPo);
		int total=analyseService.getTotal(fundAccountBillPo);
		return new AjaxResultPo(true,"success",total,list);
	}
	
	

}
