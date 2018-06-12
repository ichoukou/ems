package com.channelsoft.ems.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.DataDictionaryPo;
import com.channelsoft.ems.po.OldManMainPo;
import com.channelsoft.ems.service.OldManQuitService;

/**
 *   老人退住管理
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2016年12月27日
 */
@RequestMapping("/quit")
@Controller
public class OldManQuitController {
	
	private Logger logger=Logger.getLogger(OldManQuitController.class);
	
	@Autowired
	private OldManQuitService oldManQuitService;
	/**
	 * 查询所有
	 * @return
	 */
	@RequestMapping("/leaveList")
	public String goToLeaveList(){
		logger.debug("leaveList开始跳转");
		return "oldManQuit/oldManQuitList";
	}
	/**
	 * 初始化表格 有分页 有回显
	 * @param oldManMainPo
	 * @param page
	 * @param pageSize
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/query")
	@ResponseBody
	public AjaxResultPo queryAll(OldManMainPo oldManMainPo, int page, int pageSize,HttpServletRequest request,HttpServletResponse response){
		logger.debug("开始查询");
		logger.debug("传进来的对象"+oldManMainPo+"page="+page+"pageSize="+pageSize);
		logger.debug("传进来的参数"+oldManMainPo.toString());
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String foldManName=request.getParameter("foldManName");
		if(!StringUtils.isEmpty(foldManName)){
			oldManMainPo.setFoldManName(foldManName);
		}
		List<OldManMainPo> oldManMainPoList =oldManQuitService.query(oldManMainPo,page,pageSize);
		int count=oldManQuitService.getCount(oldManMainPo);
		for(int i=0;i<oldManMainPoList.size();i++){
			String typeId=oldManMainPoList.get(i).getfLeaveType();
			oldManMainPoList.get(i).setfLeaveTypeName(oldManQuitService.getLeaveTypeName(typeId));
		}
		return new AjaxResultPo(true, "success",count,oldManMainPoList);
	}
	/**
	 * 回显下拉框中的类型
	 * @param dc
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getLeaveType")
	@ResponseBody
	public AjaxResultPo getLeaveType(DataDictionaryPo dc,HttpServletRequest request,HttpServletResponse response){
		logger.debug("进入getLeaveType，传进来的对象为"+dc);
		logger.debug("传进来的值为"+dc.toString());
		List<DataDictionaryPo> leaveTypeList = oldManQuitService.queryLeaveType(dc.getName());
		return new AjaxResultPo(true,"success",leaveTypeList.size(),leaveTypeList);
	}
	/**
	 * 办理退住
	 * @param oldManMainPo
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addLeave")
	@ResponseBody
	public AjaxResultPo addLeave(OldManMainPo oldManMainPo,HttpServletRequest request,HttpServletResponse response){
		logger.debug("添加老人退住信息控制层");
		logger.debug("传进来的对象"+oldManMainPo);
		logger.debug("传进来的参数"+oldManMainPo.toString());
		int resultId;
		try {
			resultId = oldManQuitService.addLeave(oldManMainPo);
			if(resultId==2){
				return new AjaxResultPo(true,"老人不存在");
			}else if(resultId==1){
				return new AjaxResultPo(true, "success");
			}else{
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 撤销退住
	 * @param oldManMainPo
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/deleteLeave")
	@ResponseBody
	public AjaxResultPo deleteLeave(OldManMainPo oldManMainPo,HttpServletRequest request,HttpServletResponse response){
		logger.debug("撤销老人退住信息控制层");
		logger.debug("传进来的对象"+oldManMainPo);
		logger.debug("传进来的参数"+oldManMainPo.toString());
		int resultId=oldManQuitService.deleteLeave(oldManMainPo);
		if(resultId==1){
			return new AjaxResultPo(true, "success");
		}else{
			return null;
		}
	}
}
