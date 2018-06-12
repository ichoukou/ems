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
import com.channelsoft.ems.po.BalancePo;
import com.channelsoft.ems.service.BalanceService;

/**
 *  余额表controller
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2017年1月12日
 */
@Controller
@RequestMapping("/balance")
public class BalanceController {

	@Autowired
	private BalanceService balanceService;

	private Logger logger=Logger.getLogger(BalanceController.class);
	@RequestMapping("/getBalanceList")
	public String getBalanceList(){
		return "balance/balanceList";
	}
	/**
	 * 根据账户id查询余额表中记录
	 * @param fundAccountId
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/queryByAccount")
	@ResponseBody
	public AjaxResultPo queryByAccount(String fNumber,HttpServletRequest request,HttpServletResponse response){
		logger.debug("传进来的参数fNumber="+fNumber);
		List<BalancePo> balancePo = balanceService.queryByAccount(fNumber);
		if(balancePo.size()>0){
			//代表余额表中存在该账户记录 
			return new AjaxResultPo(true,"true");
		}else{
			//代表余额表中没有该账户记录
			return new AjaxResultPo(true,"false");
		}
	}
}
