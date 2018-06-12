package com.channelsoft.ems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.service.FundAccountCloseService;
/**
 *  结账 
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2017年2月28日
 */
@Controller
@RequestMapping("/fundAccColse")
public class FundAccountClose {
	
	private Logger logger=Logger.getLogger(FundAccountClose.class);
	
	@Autowired
	private FundAccountCloseService fundAccountCloseService;
	
	/**
	 * 得到账户结算界面
	 * @return
	 */
	@RequestMapping("/getClosePage")
	public String getFundAccountClosePage(){
		return "fundAccountClose/fundAccountClose";
	}
	
	@RequestMapping("/closeAccount")
	@ResponseBody
	public AjaxResultPo closeAccount(String fDate,HttpServletRequest request,HttpServletResponse response){
		logger.debug("传进来的参数fDate"+fDate);
		try {
			int result=fundAccountCloseService.jieZhang(fDate, request, response);
			logger.debug("result="+result);
			if(result==1){
				return new AjaxResultPo(true,"1");
			}else if(result==2){
				return new AjaxResultPo(true,"2");
			}else{
				return new AjaxResultPo(true,"0");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new AjaxResultPo(true,"0");
		}
	}
	
	@RequestMapping("/getMaxDate")
	@ResponseBody
	public AjaxResultPo getMaxDate(HttpServletRequest reqeust,HttpServletResponse response){
		String maxDate=fundAccountCloseService.getMaxDate();
		return new AjaxResultPo(true,maxDate);
	}
	/**
	 * 反结算
	 * @param fDate
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/balanceBack")
	@ResponseBody
	public AjaxResultPo balanceBack(String fDate,HttpServletRequest request,HttpServletResponse response){
		logger.debug("fDate="+fDate);
		int result=0;
		try{
		result=fundAccountCloseService.balanceBack(fDate);
		}catch (Exception e){
			result= -2;
		}
		if(result==-1){
			//无历史结算记录
			return new AjaxResultPo(true,"-1");
		}else if(result==-2){
			//反结算失败
			return new AjaxResultPo(true,"-2");
		}else{
			//反结算成功
		}
			return new AjaxResultPo(true,"0");
		}
}
