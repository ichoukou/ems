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
import com.channelsoft.ems.po.OldManHealthyPo;
import com.channelsoft.ems.po.OldManMainPo;
import com.channelsoft.ems.service.OldManHealthyService;
/**
 * 
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2016年12月21日
 */
@Controller
@RequestMapping("/healthy")
public class OldManHealthyController {
	
	 private static Logger logger=Logger.getLogger(OldManHealthyController.class);
	 
	 @Autowired
	 private OldManHealthyService oldManHealthyService;
	 
	 @RequestMapping("/getHealthyList")
	 public String getHealthyList(){
		 return "oldManHosing/oldManHealthyList";
	 }
	 
	 @RequestMapping("/query")
	 @ResponseBody
	 public AjaxResultPo queryToList(int page,int pageSize,OldManMainPo oldManMainPo,HttpServletRequest request,HttpServletResponse response){
		logger.debug("传进来的参数为"+oldManMainPo.toString());
		 List<OldManHealthyPo> list = oldManHealthyService.queryToList(page, pageSize, oldManMainPo);
		 int total =oldManHealthyService.getTotal(oldManMainPo);
		 return new AjaxResultPo(true,"success",total,list);
	 }
	 
	 
	 /**
	  * 增加老人健康信息
	  * @param oldManHealthy
	  * @param request
	  * @param response
	  * @return
	  */
	 @ResponseBody
	 @RequestMapping("/add")
	 public AjaxResultPo addOldManHealthy(OldManHealthyPo oldManHealthy,HttpServletRequest request,HttpServletResponse response){
		 	logger.debug("进入   addOldManHealthy()...");
			logger.debug("请求参数: "+ oldManHealthy.toString());
				int result=oldManHealthyService.addOldManHealthy(oldManHealthy,request);
				if(result==2){
					return new AjaxResultPo(true,"老人不存在");
				}else if(result==1){
					return new AjaxResultPo(true, "success");
				}else{
					return null;
				}
	 }
/*	 *//**
	  * 根据老人的id获取老人的健康信息
	  * @param oldManMainPo
	  * @param request
	  * @param response
	  * @return
	  *//*
	 @RequestMapping("/getHeal")
	 @ResponseBody
	 public AjaxResultPo getUpdateDate(OldManMainPo oldManMainPo,HttpServletRequest request,HttpServletResponse response){
		 logger.debug("传进来的参数为"+oldManMainPo.toString());
		 List<OldManHealthyPo> list = oldManHealthyService.queryToList(oldManMainPo);
		 if(list.size()<=0){
			 return new AjaxResultPo(true,"false");
		 }
		 return new AjaxResultPo(true,list.get(0));
		
	 }*/
	 /**
	  * 
	  * @return
	  */
	 @RequestMapping("/update")
	 @ResponseBody
	 public AjaxResultPo updateHealthy(OldManHealthyPo oldManHealthyPo,HttpServletRequest request,HttpServletResponse response){
		 logger.debug("传入的参数为"+oldManHealthyPo.toString());
		 int result=oldManHealthyService.udpateOldManHealthy(oldManHealthyPo);
		 if(result>0){
			 return new AjaxResultPo(true,"success");
		 }else{
			 return new AjaxResultPo(true,"failed");
		 }
	 }
}
