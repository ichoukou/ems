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

import com.channelsoft.ems.nursing.nursingPlan.po.RoomPo;
import com.channelsoft.ems.nursing.nursingPlan.service.NursingPlanPublicService;
import com.channelsoft.ems.nursing.nursingPlanExcute.po.PublicServiceExecutePo;
import com.channelsoft.ems.nursing.nursingPlanExcute.service.PublicServiceExecuteService;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.UserPo;

/** 
 * 
 * 公共护理计划执行controller  
 * @author  lwj
 * @date 创建时间：2017年2月24日09:44:46
 * @parameter  
 * @return  
 */
@Controller
@RequestMapping("/publicPlanExecute")
public class PublicServiceExecuteController {
	private static Logger logger = Logger.getLogger(PublicServiceExecuteController.class);
	@Autowired
	private PublicServiceExecuteService publicServiceExecuteService;
	
	@Autowired
	private NursingPlanPublicService nursingPlanPublicService;
	
	@RequestMapping("/index")
    public String index(){
        logger.debug("公共计划index页面已经跳转");
        return "nursing/publicPlanExecute/index";
    }
	
	/**
	 * 护理计划公共信息数据查询
	 * @param po
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/queryRoomList")
    public AjaxResultPo queryRoomList(RoomPo po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ po.toString());
    	UserPo user=(UserPo)request.getSession().getAttribute("loginUser");
    	
    	//当前登录人的用户ID
    	String fcurUserID=user.getUid();
    	po.setFcurUserID(fcurUserID);
    	
    	List<RoomPo> pos=nursingPlanPublicService.queryRoomList(po);
        int totalSize=nursingPlanPublicService.queryRoomTotal(po);
    	
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
    public AjaxResultPo queryList(PublicServiceExecutePo po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ po.toString());
    	
    	List<PublicServiceExecutePo> pos=publicServiceExecuteService.queryList(po);
        int totalSize=publicServiceExecuteService.getTotalSize(po);
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
    public AjaxResultPo queryDetailList(PublicServiceExecutePo po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ po.toString());
    	String froomid=po.getFroomid();
    	List<PublicServiceExecutePo> details=new ArrayList<PublicServiceExecutePo>();
    	if(froomid !=null && !"".equals(froomid)){
	    	details=publicServiceExecuteService.queryDetailList(po);
    	}
    	
    	return new AjaxResultPo(true, details);
        
    }
	
	/**
	 * 保存计划执行记录并在计划表反写数据
	 * @param po
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/savePublicPlanExecute")
    public AjaxResultPo savePublicPlanExecute(PublicServiceExecutePo po,HttpServletRequest request , HttpServletResponse response){
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
    		
    		publicServiceExecuteService.savePublicPlanExecute(po);
    		
    		 return new AjaxResultPo(true, "执行成功");
    	}catch(Exception e){
    		logger.error("保存老人护理项目失败"+e.getMessage());
            return new AjaxResultPo(false,"执行失败");
    	}
        
    }
}
