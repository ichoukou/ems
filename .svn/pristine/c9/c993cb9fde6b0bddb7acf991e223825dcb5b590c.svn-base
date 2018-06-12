package com.channelsoft.ems.expenses.rpayment.controller;

import java.util.Date;
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
import com.channelsoft.ems.expenses.rpayment.po.Oldmanblance;
import com.channelsoft.ems.expenses.rpayment.po.Payment;
import com.channelsoft.ems.expenses.rpayment.po.Rpayment;
import com.channelsoft.ems.expenses.rpayment.service.PaymentService;
import com.channelsoft.ems.expenses.rpayment.service.RpaymentService;
import com.channelsoft.ems.nursing.nursingProject.service.NursingProjectService;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.OldManChargePo;
import com.channelsoft.ems.po.UserPo;

/** 
 * 
 * 实际缴费controller  
 * @author  lwj
 * @date 创建时间：2017年03月04日 下午14:31:41 
 * @parameter  
 * @return  
 */
@Controller
@RequestMapping("/payment")
public class PaymentConntroller {
	private static Logger logger = Logger.getLogger(PaymentConntroller.class);
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private RpaymentService rpaymentService;
	
	@Autowired
	private NursingProjectService nursingProjectService;
	
    @RequestMapping("/paymentList")
    public String index(){
        logger.debug("index已经跳转");
        return "expenses/paymentList";
    }
    
    @RequestMapping("/rpaymentListPrint")
    public String rpaymentListPrint(){
        logger.debug("paymentListPrint 打印应缴费页面  已经跳转");
        return "expenses/rpaymentListPrint";
    }
    
    @RequestMapping("/paymentListPrint")
    public String paymentListPrint(){
        logger.debug("paymentListPrint  打印实际缴费页面 已经跳转");
        return "expenses/paymentListPrint";
    }
    
    @ResponseBody
    @RequestMapping("/queryPaymentList")
    public AjaxResultPo queryPaymentList(Rpayment po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ "  page "+ po.getPage() + " pageSize " + po.getPageSize());
    	List<Rpayment> pos=paymentService.queryPaymentList(po);
    	
        return new AjaxResultPo(true, "success", pos.size(), pos);
    }
    
    @ResponseBody
    @RequestMapping("/queryHasPaymentList")
    public AjaxResultPo queryHasPaymentList(Payment po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ "  page "+ po.getPage() + " pageSize " + po.getPageSize());
    	List<Payment> pos=paymentService.queryHasPaymentList(po);
    	
        return new AjaxResultPo(true, "success", pos.size(), pos);
    }
    
    /**
     *根据老人ID 和 应缴费ID 从老人余额表获取老人余额
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getOldManBlanceCurrent")
    public void getOldManBlanceCurrent(Rpayment po,HttpServletRequest request , HttpServletResponse response){
    	
    	//po= rpaymentService.selectByPrimaryKey(po.getFid());
    	
    	Oldmanblance oldmanblance=paymentService.getOldManBlanceCurrent(po);
    	if(oldmanblance==null){
    		oldmanblance=new Oldmanblance();
    	}
    	
        ResponseJsonUtil.writeResultNoTrans(response, JSON.toJSON(oldmanblance));
    }
    
    /**
     *根据老人ID 查询老人的所有费用项目
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getFcostitem")
    public void getFcostitem(String  foldmanid,HttpServletRequest request , HttpServletResponse response){
    	
    	List<OldManChargePo> pos=paymentService.getFcostitem(foldmanid);
    	
        ResponseJsonUtil.writeResultNoTrans(response, JSON.toJSON(pos));
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
    		
    		String fid=paymentService.savePayMent(po);
    		
    		 return new AjaxResultPo(true, "入住缴费成功",0,fid);
    	}catch(Exception e){
    		logger.error("入住缴费失败"+e.getMessage());
            return new AjaxResultPo(false,"入住缴费失败");
    	}
    }
	
}
