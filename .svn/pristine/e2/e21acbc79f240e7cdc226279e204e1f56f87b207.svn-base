package com.channelsoft.ems.expenses.retirement.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.ems.expenses.retirement.po.RetirementPo;
import com.channelsoft.ems.expenses.retirement.service.RetirementService;
import com.channelsoft.ems.expenses.rpayment.po.Payment;
import com.channelsoft.ems.expenses.rpayment.po.Rpayment;
import com.channelsoft.ems.expenses.rpayment.service.PaymentService;
import com.channelsoft.ems.expenses.rpayment.service.RpaymentService;
import com.channelsoft.ems.nursing.nursingProject.service.NursingProjectService;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.UserPo;

/** 
 * 
 * 退住借款controller  
 * @author  lwj
 * @date 创建时间：2017年3月10日09:43:42
 * @parameter  
 * @return  
 */
@Controller
@RequestMapping("/retirement")
public class RetirementController {
	private static Logger logger = Logger.getLogger(RetirementController.class);
	
	@Autowired
	private RetirementService retirementService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private NursingProjectService nursingProjectService;
	
    @RequestMapping("/retirementList")
    public String retirementList(){
        logger.debug("退住结款页面已经跳转");
        return "expenses/retirementList";
    }
    
    @RequestMapping("/retirementDetailListShow")
    public String retirementDetailListShow(){
        logger.debug("退住结款详细费用页面已经跳转");
        return "expenses/retirementDetailList";
    }
    
    @ResponseBody
    @RequestMapping("/queryRetirementList")
    public AjaxResultPo queryPaymentList(Rpayment po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ "  page "+ po.getPage() + " pageSize " + po.getPageSize());
    	List<Rpayment> pos=retirementService.QueryList(po);
    	int totalSize=retirementService.getTotalSize(po);
    	
        return new AjaxResultPo(true, "success", totalSize, pos);
    }
    
    @ResponseBody
    @RequestMapping("/retirementDetailList")
    public AjaxResultPo retirementDetailList(RetirementPo po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ "  foldmanid "+po.getFoldmanid());
    	List<RetirementPo> pos=retirementService.queryRetirementDetailList(po);
    	
        return new AjaxResultPo(true, "success", pos.size(), pos);
    }
    
    @ResponseBody  
    @RequestMapping("/savePayMent")
    public AjaxResultPo savePayMent(Payment po,HttpServletRequest request , HttpServletResponse response){
    	UserPo user=(UserPo)request.getSession().getAttribute("loginUser");
    	try{
    		po.setFcreatorid(user.getUid());
    		po.setFcreatetime(new Date());
    		po.setFmodifierid(user.getUid());
    		po.setFmodificationtime(new Date());
    		po.setFauditorid(user.getUid());
    		po.setFaudittime(new Date());
    		
    		//根据当前登录人的养老院作为默认值
        	String fNursingHomeID=nursingProjectService.getFnursingHomeIDByUserID(user.getUid());
    		po.setFnursinghomeid(fNursingHomeID);
    		
    		retirementService.savePayMent(po);
    		
    		 return new AjaxResultPo(true, "退住结款成功");
    	}catch(Exception e){
    		e.printStackTrace();
    		logger.error("退住结款"+e.getMessage());
            return new AjaxResultPo(false,"退住结款失败");
    	}
    }
}
