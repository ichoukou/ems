package com.channelsoft.ems.expenses.rpayment.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.channelsoft.ems.common.ResponseJsonUtil;
import com.channelsoft.ems.expenses.rpayment.po.Rpayment;
import com.channelsoft.ems.expenses.rpayment.po.Rpaymententry;
import com.channelsoft.ems.expenses.rpayment.service.RpaymentService;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.DataDictionaryPo;

/** 
 * 
 * 应缴费Controller  
 * @author  lwj
 * @date 创建时间：2017年03月04日 下午14:31:41 
 * @parameter  
 * @return  
 */
@Controller
@RequestMapping("/Rpayment")
public class RpaymentConntroller {
	private static Logger logger = Logger.getLogger(RpaymentConntroller.class);
	@Autowired
	private RpaymentService rpaymentService;
	
    @RequestMapping("/rpaymentList")
    public String index(){
        logger.debug("index已经跳转");
        return "expenses/rpaymentList";
    } 
    
    @RequestMapping("/getChargeStandard")
    public String getChargeStandard(){
        logger.debug("getChargeStandard已经跳转");
        return "expenses/chargeStandard";
    } 
    
    @ResponseBody
    @RequestMapping("/queryList")
    public AjaxResultPo queryList(Rpayment po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ "  page "+ po.getPage() + " pageSize " + po.getPageSize());
    	List<Rpayment> pos=rpaymentService.QueryList(po);
    	int totalSize=rpaymentService.getTotalSize(po);
    	
        return new AjaxResultPo(true, "success", totalSize, pos);
    }
}
