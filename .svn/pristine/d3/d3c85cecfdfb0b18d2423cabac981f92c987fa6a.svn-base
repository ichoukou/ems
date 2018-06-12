package com.channelsoft.ems.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.LevelPo;
/**
 * 
 * @author wuhl
 * 
 * 健康水平评估 控制层
 */

@Controller
@RequestMapping("/healtha")
public class HealthLevelEvalController {

	private static Logger logger=Logger.getLogger(HealthLevelEvalController.class);
	
	@RequestMapping("/LvList")
    public String gotoLevel(HttpServletRequest request ,HttpServletResponse response){
		
		return "LevelProject/LevelProjectList";
	}
	
	/** 
	 * 分页查询
	 * @author  wuhl
	 * @date 创建时间：2017年2月14日 下午9:13:41
	 * @parameter  
	 * @return  
	 */
	@ResponseBody
	@RequestMapping("/query")
	public AjaxResultPo gotoList(LevelPo po,int page,int pageSize, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
		List<LevelPo> list = new ArrayList<LevelPo>();
//		list.add(new LevelPo("1","可自理","0","进餐","独立完成"));
//		list.add(new LevelPo("2","可自理","0","穿衣","独立完成"));
//		list.add(new LevelPo("3","不能自理","5","进餐","完全需要帮助"));
		return new AjaxResultPo(true, "success", list.size(), list);
	}
	
	
	/** 
	 * 增加级别
	 * @author  wuhl
	 * @date 创建时间：2017年2月14日 下午9:13:41
	 * @parameter  
	 * @return  
	 */
	
	@ResponseBody
	@RequestMapping("/addLv")
	public AjaxResultPo addLevel(LevelPo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入  addLevel()......");
		logger.debug("请求参数: "+ po.toString());
		
		return new AjaxResultPo(true, "success");
	}
	
	/** 
	 * 更新级别
	 * @author  wuhl
	 * @date 创建时间：2017年2月14日 下午9:13:41
	 * @parameter  
	 * @return  
	 */
	
	@ResponseBody
	@RequestMapping("/updateLv")
	public AjaxResultPo updateLevel(LevelPo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   updateLevel()......");
		logger.debug("请求参数: "+ po.toString());
		
		return new AjaxResultPo(true, "success");
	}
	
	/** 
	 * 删除级别
	 * @author  wuhl
	 * @date 创建时间：2017年2月14日 下午9:13:41
	 * @parameter  
	 * @return  
	 */
	
	@ResponseBody
	@RequestMapping("/deleteLv")
	public AjaxResultPo deleteLevel(LevelPo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   deleteLevel()......");
		logger.debug("请求参数: "+ po.toString());
		
		return new AjaxResultPo(true, "success");
	}
	



}
