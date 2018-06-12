package com.channelsoft.ems.nursing.nursingPlanExcute.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
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
import com.channelsoft.ems.nursing.nursingPlan.po.OldManPo;
import com.channelsoft.ems.nursing.nursingPlan.service.NursingPlanOldManService;
import com.channelsoft.ems.nursing.nursingPlanExcute.po.OldManServiceExecutePo;
import com.channelsoft.ems.nursing.nursingPlanExcute.service.OldManServiceExecuteService;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.UserPo;

/** 
 * 
 * 老人护理计划执行controller  
 * @author  lwj
 * @date 创建时间：2017年2月24日09:44:46
 * @parameter  
 * @return  
 */
@Controller
@RequestMapping("/oldManPlanExecute")
public class OldManServiceExecuteController {
	private static Logger logger = Logger.getLogger(OldManServiceExecuteController.class);
	@Autowired
	private OldManServiceExecuteService oldManServiceExecuteService;
	
	@Autowired
	private NursingPlanOldManService nursingPlanOldManService;
	
	@RequestMapping("/index")
    public String index(){
        logger.debug("老人计划index页面已经跳转");
        return "nursing/oldManPlanExecute/index";
    }
	
	@RequestMapping("/oldManExecute")
    public String oldManExecute(){
        logger.debug("老人计划执行情况页面已经跳转");
        return "nursing/oldManPlanExecute/oldManExecute";
    }
	
	/**
	 * 护理计划老人信息数据查询
	 * @param po
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/queryOldManList")
    public AjaxResultPo queryOldManList(OldManPo po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ po.toString());
    	UserPo user=(UserPo)request.getSession().getAttribute("loginUser");
    	//当前登录人的用户ID
    	String fcurUserID=user.getUid();
    	po.setFcurUserID(fcurUserID);
    	
    	List<OldManPo> pos=nursingPlanOldManService.queryOldManList(po);
        int totalSize=nursingPlanOldManService.queryOldManTotal(po);
    	
        return new AjaxResultPo(true, "success", totalSize, pos);
    }
	
    /**
     * 护理计划 老人项目护理计划
     * @param po
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryList")
    public AjaxResultPo queryList(OldManServiceExecutePo po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ po.toString());
    	
    	List<OldManServiceExecutePo> pos=oldManServiceExecuteService.queryList(po);
        int totalSize=oldManServiceExecuteService.getTotalSize(po);
        return new AjaxResultPo(true, "success", totalSize, pos);
    }
    
	/**
	 * 护理计划的老人项目数据查询
	 * @param po
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/queryDetailList")
    public AjaxResultPo queryDetailList(OldManServiceExecutePo po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ po.toString());
    	String foldmanid=po.getFoldmanid();
    	List<OldManServiceExecutePo> details=new ArrayList<OldManServiceExecutePo>();
    	if(foldmanid !=null && !"".equals(foldmanid)){
	    	details=oldManServiceExecuteService.queryDetailList(po);
    	}
    	
    	return new AjaxResultPo(true, details);
        
    }
	
	/**
	 * 根据老人ID 查询老人信息
	 * @param po
	 * @param request
	 * @param response
	 * @return
	 */
    @RequestMapping("/showOldManInfo")
    public void showOldManInfo(String fid,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ fid);
    	OldManPo po=new OldManPo();
    	if(fid !=null && !"".equals(fid)){
	    	po=oldManServiceExecuteService.showOldManInfo(fid);
    	}
    	
    	ResponseJsonUtil.writeResultNoTrans(response, JSON.toJSON(po));
        
    }
	
	/**
	 * 根据老人计划ID 查询老人计划信息
	 * @param po
	 * @param request
	 * @param response
	 * @return
	 */
    @RequestMapping("/showOldManPlanInfo")
    public void showOldManPlanInfo(String fid,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ fid);
    	OldManServiceExecutePo po=new OldManServiceExecutePo();
    	if(fid !=null && !"".equals(fid)){
	    	po=oldManServiceExecuteService.showOldManPlanInfo(fid);
    	}
    	
    	ResponseJsonUtil.writeResultNoTrans(response, JSON.toJSON(po));
        
    }
    
	/**
	 * 保存计划执行记录并在计划表反写数据
	 * @param po
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/saveOldManPlanExecute")
    public AjaxResultPo saveOldManPlanExecute(OldManServiceExecutePo po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ po.toString());
    	UserPo user=(UserPo)request.getSession().getAttribute("loginUser");
    	try{
    		po.setFcreatorid(user.getUid());
    		po.setFcreatetime(new Date());
    		po.setFmodifierid(user.getUid());
    		po.setFmodificationtime(new Date());
    		po.setFauditorid(user.getUid());
    		po.setFaudittime(new Date());
    		po.setFserviceexecutedate(new Date());
    		
    		oldManServiceExecuteService.saveOldManPlanExecute(po);
    		
    		 return new AjaxResultPo(true, "执行成功");
    	}catch(Exception e){
    		logger.error("保存老人护理项目失败"+e.getMessage());
            return new AjaxResultPo(false,"执行失败");
    	}
        
    }
}
