package com.channelsoft.ems.nursing.nursingPlan.controller;

import java.io.UnsupportedEncodingException;
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
import com.channelsoft.ems.nursing.nursingPlan.po.OldManServiceItemPo;
import com.channelsoft.ems.nursing.nursingPlan.service.NursingPlanOldManService;
import com.channelsoft.ems.nursing.nursingProject.po.NursingProjectPo;
import com.channelsoft.ems.nursing.nursingProject.service.NursingProjectService;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.DataDictionaryPo;

/** 
 * 
 * 护理老人计划controller  
 * @author  lwj
 * @date 创建时间：2017年02月09日 下午14:31:41 
 * @parameter  
 * @return  
 */
@Controller
@RequestMapping("/nursingPlanOldMan")
public class NursingPlanOldManController {
	private static Logger logger = Logger.getLogger(NursingPlanOldManController.class);
	@Autowired
	private NursingPlanOldManService nursingPlanOldManService;
	
	@Autowired
	private NursingProjectService nursingProjectService;
	
	
	@RequestMapping("/index")
    public String index(){
        logger.debug("老人计划index页面已经跳转");
        return "nursing/nursingPlanOldMan/index";
    }
	
	@RequestMapping("/chooseOldMan")
    public String chooseOldMan(){
        logger.debug("选择老人页面已经跳转");
        return "nursing/nursingPlanOldMan/chooseOldMan";
    }
	
	/**
     * 从数据字典获取老人状态下拉选项值
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getFoldManStatusID")
    public void getFoldManStatusID(HttpServletRequest request , HttpServletResponse response){
    	DataDictionaryPo dc=new DataDictionaryPo();
        dc.setName("老人状态");
        List<DataDictionaryPo> serviceLevels=nursingProjectService.getDcValueByName(dc);
        ResponseJsonUtil.writeResultNoTrans(response, JSON.toJSON(serviceLevels));
    }
	
    /**
     * 护理计划 老人项目护理类型查询
     * @param po
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryList")
    public AjaxResultPo queryList(OldManServiceItemPo po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ po.toString());
    	String foldmanid=po.getFoldmanid();
    	if(foldmanid==null || "".equals(foldmanid)){
    		NursingProjectPo proPo=new NursingProjectPo();
    		proPo.setfServiceGroupID(po.getfServiceGroupID());
    		proPo.setFserviceLevels(po.getFserviceLevels());
    		proPo.setFserviceType(po.getFserviceType());
    		proPo.setPage(po.getPage());
    		proPo.setPageSize(po.getPageSize());
        	List<NursingProjectPo> pos=nursingProjectService.queryList(proPo);
            int totalSize=nursingProjectService.getTotalSize(proPo);
            return new AjaxResultPo(true, "success", totalSize, pos);
    	}else{
    		List<OldManServiceItemPo> pos=nursingPlanOldManService.queryList(po);
            int totalSize=nursingPlanOldManService.getTotalSize(po);
            return new AjaxResultPo(true, "success", pos.size(), pos);
    	}
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
    public AjaxResultPo queryDetailList(OldManServiceItemPo po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ po.toString());
    	String foldmanid=po.getFoldmanid();
    	if(foldmanid==null || "".equals(foldmanid)){
    		NursingProjectPo proPo=new NursingProjectPo();
    		proPo.setfServiceGroupID(po.getfServiceGroupID());
    		proPo.setFserviceLevels(po.getFserviceLevels());
    		proPo.setFserviceType(po.getFserviceType());
    		List<NursingProjectPo> details=nursingProjectService.queryDetailList(proPo);
    		return new AjaxResultPo(true, details);
    	}else{
    		List<OldManServiceItemPo> details=nursingPlanOldManService.queryDetailList(po);
            
    		return new AjaxResultPo(true, details);
    	}
        
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

    	List<OldManPo> pos=nursingPlanOldManService.queryOldManList(po);
        int totalSize=nursingPlanOldManService.queryOldManTotal(po);
    	
        return new AjaxResultPo(true, "success", totalSize, pos);
    }
	
	/**
     * 保存老人服务项目
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/saveOldManServiceItem")
    public AjaxResultPo saveOldManServiceItem(String[] fids,String foldmanid,HttpServletRequest request , HttpServletResponse response){
    	try{
    		nursingPlanOldManService.saveOldManServiceItem(fids,foldmanid);
    		
    		 return new AjaxResultPo(true, "保存老人护理项目成功");
    	}catch(Exception e){
    		logger.error("保存老人护理项目失败"+e.getMessage());
            return new AjaxResultPo(false,"保存老人护理项目失败");
    	}
    }
    
    /**
     * 插入老人服务项目
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/insert")
    public void insert(HttpServletRequest request , HttpServletResponse response){
    	try{
    		String foldmanid="198";
    		String fnursingLevel="20";
    		nursingPlanOldManService.insertOldManServiceItemByContidtion(foldmanid, fnursingLevel);
    		
    	}catch(Exception e){
    		logger.error("保存老人护理项目失败"+e.getMessage());
    	}
    } 
}
