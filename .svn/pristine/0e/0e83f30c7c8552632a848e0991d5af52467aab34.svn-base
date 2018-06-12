package com.channelsoft.ems.expenses.mouthblance.controller;

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
import com.channelsoft.ems.expenses.mouthblance.service.MouthblanceService;
import com.channelsoft.ems.expenses.rpayment.po.Oldmanblance;
import com.channelsoft.ems.expenses.rpayment.po.Rpayment;
import com.channelsoft.ems.expenses.rpayment.service.RpaymentService;
import com.channelsoft.ems.po.AjaxResultPo;

/** 
 * 
 * 月结账controller  
 * @author  lwj
 * @date 创建时间：2017年3月6日21:19:05
 * @parameter  
 * @return  
 */
@Controller
@RequestMapping("/mouthblance")
public class MouthblanceConntroller {
	private static Logger logger = Logger.getLogger(MouthblanceConntroller.class);
	@Autowired
	private MouthblanceService mouthblanceService;
	
	@Autowired
	private RpaymentService rpaymentService;
	
    @RequestMapping("/index")
    public String index(){
        logger.debug("index已经跳转");
        return "expenses/mouthblance";
    }
    
    @RequestMapping("/mouthblanceQuery")
    public String mouthblanceQuery(){
        logger.debug("index已经跳转");
        return "expenses/mouthblanceQuery";
    }
    
    @ResponseBody
    @RequestMapping("/queryList")
    public AjaxResultPo queryList(Oldmanblance po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ "  page "+ po.getPage() + " pageSize " + po.getPageSize());
    	List<Oldmanblance> pos=mouthblanceService.QueryList(po);
    	int totalSize=mouthblanceService.getTotalSize(po);
    	
        return new AjaxResultPo(true, "success", totalSize, pos);
    }
    
    /**
     * 获取当前老人余额表期数
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getOldManBlance")
    public void getOldManBlance(HttpServletRequest request , HttpServletResponse response){
    	Oldmanblance oldmanblance=mouthblanceService.getOldManBlance();
        ResponseJsonUtil.writeResultNoTrans(response, JSON.toJSON(oldmanblance));
    }
    
    /**
     * 获取当前未交费老人数量
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getOldmanTotalNopayment")
    public void getOldmanTotalNopayment(HttpServletRequest request , HttpServletResponse response){
    	Rpayment po=new Rpayment();
    	int totalSize=rpaymentService.getTotalSize(po);
    	ResponseJsonUtil.writeResultNoTrans(response, JSON.toJSON(totalSize));
    }
    
    /**
     * 结账
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/paymentSubmit")
    public AjaxResultPo paymentSubmit(HttpServletRequest request , HttpServletResponse response){
    	try{
    		 mouthblanceService.paymentSubmit();
    		 logger.error("结账成功");
    		 return new AjaxResultPo(true, "结账成功");
    	}catch(Exception e){
    		logger.error("结账失败"+e.getMessage());
            return new AjaxResultPo(false,"结账失败");
    	}
    }
    
    /**
     * 反结账
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/paymentSubmitBack")
    public AjaxResultPo paymentSubmitBack(HttpServletRequest request , HttpServletResponse response){
    	try{
    	mouthblanceService.paymentSubmitBack();
    	 logger.error("反结账成功");
   		 return new AjaxResultPo(true, "反结账成功");
   	}catch(Exception e){
   		logger.error("反结账"+e.getMessage());
           return new AjaxResultPo(false,"反结账");
   	}
    }
}
