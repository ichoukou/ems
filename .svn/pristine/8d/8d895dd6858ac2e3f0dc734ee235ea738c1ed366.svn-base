package com.channelsoft.ems.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.DataDictionaryPo;
import com.channelsoft.ems.po.OldManRelationPo;
import com.channelsoft.ems.service.OldManRelationService;

@Controller
@RequestMapping("/relation")
public class OldManRelationController {
	private Logger logger=Logger.getLogger(OldManRelationController.class);
	@Autowired
	private OldManRelationService oldManRelationService;
	
	@RequestMapping("/getRelationList")
	public String getRelationList(){
		return "oldManHosing/oldManRelationList";
	}
	
	/**
	 * 获得所有亲属
	 * @return
	 */
	@RequestMapping("/getRelation")
	@ResponseBody
	public AjaxResultPo getRelation(DataDictionaryPo dict,HttpServletRequest request,HttpServletResponse response){
		logger.debug("将所有亲属信息查出来");
		List<DataDictionaryPo> dictList = oldManRelationService.getRelation(dict);
		return new AjaxResultPo(true, "success", dictList.size(), dictList);
	}
	/**
	 * 添加老人亲属信息
	 * @param oldManRelationPo
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/addRelation")
	@ResponseBody
	public AjaxResultPo addOldManRelation(OldManRelationPo oldManRelationPo,HttpServletRequest request,HttpServletResponse response){
		logger.debug("进入OldManRelationController中addOldManRelation方法");
		logger.debug("传进来参数"+oldManRelationPo.toString());
		try{
			if(oldManRelationService.addOldManRelation(oldManRelationPo,request)==1){
			logger.debug("添加老人亲属信息成功");
			return new AjaxResultPo(true,"success");
		}else{
			logger.debug("添加老人亲属信息失败");
			request.getSession().setAttribute("dmsg", "增加失败");
			return new AjaxResultPo(true,"error");
			}
		}catch(Exception e){
			request.getSession().setAttribute("dmsg", "增加异常");
			logger.debug("异常:"+e.getMessage());
			e.printStackTrace();
			return new AjaxResultPo(true,"error");
		}
	}
	/**
	 * 根据老人信息获取其亲属信息
	 * @param
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/queryRelation")
	@ResponseBody
	public AjaxResultPo queryRelation(OldManRelationPo oldManRelationPo,HttpServletRequest request,HttpServletResponse response){
		logger.debug("传进来的参数为"+oldManRelationPo.toString());
		List<OldManRelationPo> relationList=oldManRelationService.queryRelation(oldManRelationPo);
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String foldManName=request.getParameter("foldManName");
		if(!StringUtils.isEmpty(foldManName)){
			oldManRelationPo.getfOldManName();
		}
		if(relationList==null){
			return new AjaxResultPo(true,"尚未录入亲属信息");
		}else{
			for(int i=0;i<relationList.size();i++){
				DataDictionaryPo dict=new DataDictionaryPo();
				dict.setId(relationList.get(i).getfRelation());
				List<DataDictionaryPo> dictList = oldManRelationService.getRelation(dict);
				if(dictList.size()>0){
					relationList.get(i).setfRelationDict(dictList.get(0).getValue());
				}
			}
			return new AjaxResultPo(true, "success", relationList.size(), relationList);
		}
	}
	
	/**
	 * 更新老人亲属信息
	 * @param oldManRelationPo
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/updateRelation")
	@ResponseBody
	public AjaxResultPo updateRelation(OldManRelationPo oldManRelationPo,HttpServletRequest request,HttpServletResponse response){
		logger.debug("传进来的参数为"+oldManRelationPo.toString());
		int result =oldManRelationService.updateRelation(oldManRelationPo);
		if(result>0){
			return new AjaxResultPo(true,"success");
		}else{
			return new AjaxResultPo(true,"fail");
		}
	}
}
