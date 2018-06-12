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
import com.channelsoft.ems.po.MessagePo;
import com.channelsoft.ems.po.OldManRecordPo;
import com.channelsoft.ems.service.EmpMessageService;
import com.channelsoft.ems.service.OldManRecordService;

/**
 * 老人日常行为记录controller
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2016年12月30日
 */
@Controller
@RequestMapping("/record")
public class OldManRecordController {
	
	@Autowired
	private OldManRecordService oldManRecordService;
	@Autowired
	private EmpMessageService empMessageService;
	
	private Logger logger=Logger.getLogger(OldManRecordController.class);
	/**
	 * 跳转至老人记录主页(列表)
	 * @return
	 */
	@RequestMapping("/getRecordList")
	public String getRecordList(){
		return "oldManRecord/oldManRecordList";
	}
	/**
	 * 查询所有老人日常记录
	 * @param page
	 * @param pageSize
	 * @param oldManRecordPo
	 * @param request
	 * @param response
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/query")
	@ResponseBody
	public AjaxResultPo showRecordList(int page,int pageSize,OldManRecordPo oldManRecordPo,HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		logger.debug("传进来的参数oldManRecordPo"+oldManRecordPo.toString());
		logger.debug("传进来的page="+page);
		logger.debug("传进来的pageSize"+pageSize);
		request.setCharacterEncoding("UTF-8");
		String foldManName=request.getParameter("foldManName");
		if(!StringUtils.isEmpty(foldManName)){
			oldManRecordPo.setFoldManName(foldManName);
		}
		List<OldManRecordPo> recordList = oldManRecordService.queryRecord(page, pageSize, oldManRecordPo);
		for(int i=0;i<recordList.size();i++){
			String typeId=recordList.get(i).getfRecordType();
			String typeName=oldManRecordService.getTypeNameById(typeId);
			recordList.get(i).setfRecordName(typeName);
			
			String staffId=recordList.get(i).getfKeeper();
			String fKeeperName=oldManRecordService.getStaffNameById(staffId);
			recordList.get(i).setfKeeperName(fKeeperName);
		}
		int count=oldManRecordService.getCount(oldManRecordPo);
		return new AjaxResultPo(true, "success",count, recordList);
	}
	/**
	 * 回显日常行为类型
	 * @param dc
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/queryType")
	@ResponseBody
	public AjaxResultPo getType(String dcName,HttpServletRequest request,HttpServletResponse response){
		logger.debug("传进来的值为"+dcName);
		List<DataDictionaryPo> dcList = oldManRecordService.getType(dcName);
		return new AjaxResultPo(true, "success", dcList.size(), dcList);
	}
	/**
	 * 添加老人日常行为
	 * @param oldManRecordPo
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addRecord")
	@ResponseBody
	public AjaxResultPo addRecord(OldManRecordPo oldManRecordPo,HttpServletRequest request,HttpServletResponse response){
		logger.debug("插入老人记录日常信息记录，传来的参数为"+oldManRecordPo.toString());
		int result=oldManRecordService.addRecord(oldManRecordPo,request,response);
		if(result==2){
			return new AjaxResultPo(true,"老人不存在");
		}else if(result==1){
			return new AjaxResultPo(true, "success");
		}else{
			return null;
		}
	}
	/**
	 * 查询员工表中内容  回显至下拉菜单使用
	 * @param po
	 * @param page
	 * @param pageSize
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/getEmp")
	@ResponseBody
	public AjaxResultPo queryEmpMessage(MessagePo po,HttpServletRequest request,HttpServletResponse response){
		logger.debug("传进来的参数"+po.toString());
		//此处这样写是因为 员工的相关程序不是我写的  查询所有员工需要一些参数
		int count=empMessageService.queryCount(po);
		int page=0;
		int pageSize=count;
		List<MessagePo> empList = empMessageService.queryList(po, page, pageSize);
		return new AjaxResultPo(true,"success",empList.size(),empList);
	}
	/**
	 * 删除老人日常行为记录
	 * @param oldManRecordPo
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/deleteRecord")
	@ResponseBody
	public AjaxResultPo deleteRecord(OldManRecordPo oldManRecordPo,HttpServletRequest request,HttpServletResponse response){
		logger.debug("删除老人日常行为记录");
		int result=oldManRecordService.deleteRecord(oldManRecordPo);
		if(result==1){
			return new AjaxResultPo(true,"success");
		}else{
			logger.debug("删除失败");
			return null;
		}
	}
	/**
	 * 修改老人日常行为记录
	 * @param oldManRecordPo
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/updateRecord")
	@ResponseBody
	public AjaxResultPo updateRecord(OldManRecordPo oldManRecordPo,HttpServletRequest request,HttpServletResponse response){
		int result=oldManRecordService.updateRecord(oldManRecordPo);
		if(result==1){
			return new AjaxResultPo(true,"success");
		}else{
			logger.debug("修改失败");
			return null;
		}
	}
	
}
