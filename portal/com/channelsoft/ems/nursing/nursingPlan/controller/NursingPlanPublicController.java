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
import com.channelsoft.ems.nursing.nursingPlan.po.RoomPo;
import com.channelsoft.ems.nursing.nursingPlan.po.PublicServiceItemPo;
import com.channelsoft.ems.nursing.nursingPlan.service.NursingPlanPublicService;
import com.channelsoft.ems.nursing.nursingProject.po.NursingProjectPo;
import com.channelsoft.ems.nursing.nursingProject.service.NursingProjectService;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.DataDictionaryPo;

/** 
 * 
 * 护理公共计划controller  
 * @author  lwj
 * @date 创建时间：2017年02月09日 下午14:31:41 
 * @parameter  
 * @return  
 */
@Controller
@RequestMapping("/nursingPlanPublic")
public class NursingPlanPublicController {
	private static Logger logger = Logger.getLogger(NursingPlanPublicController.class);
	@Autowired
	private NursingPlanPublicService nursingPlanPublicService;
	
	@Autowired
	private NursingProjectService nursingProjectService;
	
	
	@RequestMapping("/index")
    public String index(){
        logger.debug("公共计划index页面已经跳转");
        return "nursing/nursingPlanPublic/index";
    }
	
	@RequestMapping("/chooseRoom")
    public String chooseRoom(){
        logger.debug("选择公共页面已经跳转");
        return "nursing/nursingPlanPublic/chooseRoom";
    }
	
	/**
     * 从数据字典获取公共状态下拉选项值
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getFoldManStatusID")
    public void getFoldManStatusID(HttpServletRequest request , HttpServletResponse response){
    	DataDictionaryPo dc=new DataDictionaryPo();
        dc.setName("公共状态");
        List<DataDictionaryPo> serviceLevels=nursingProjectService.getDcValueByName(dc);
        ResponseJsonUtil.writeResultNoTrans(response, JSON.toJSON(serviceLevels));
    }
	
    /**
     * 护理计划 公共项目护理类型查询
     * @param po
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/queryList")
    public AjaxResultPo queryList(PublicServiceItemPo po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ po.toString());
    	String froomid=po.getFroomid();
    	if(froomid==null || "".equals(froomid)){
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
    		List<PublicServiceItemPo> pos=nursingPlanPublicService.queryList(po);
            int totalSize=nursingPlanPublicService.getTotalSize(po);
            return new AjaxResultPo(true, "success", pos.size(), pos);
    	}
    }
    
	/**
	 * 护理计划的公共项目数据查询
	 * @param po
	 * @param request
	 * @param response
	 * @return
	 */
	@ResponseBody
    @RequestMapping("/queryDetailList")
    public AjaxResultPo queryDetailList(PublicServiceItemPo po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ po.toString());
    	String froomid=po.getFroomid();
    	if(froomid==null || "".equals(froomid)){
    		NursingProjectPo proPo=new NursingProjectPo();
    		proPo.setfServiceGroupID(po.getfServiceGroupID());
    		proPo.setFserviceLevels(po.getFserviceLevels());
    		proPo.setFserviceType(po.getFserviceType());
    		List<NursingProjectPo> details=nursingProjectService.queryDetailList(proPo);
    		return new AjaxResultPo(true, details);
    	}else{
    		List<PublicServiceItemPo> details=nursingPlanPublicService.queryDetailList(po);
            
    		return new AjaxResultPo(true, details);
    	}
        
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
    	String fBuildingName=po.getfBuildingName();
    	String fFLoorName=po.getfFLoorName();
    	try {
    		if(fBuildingName !=null){
    			fBuildingName=new String(fBuildingName.getBytes("ISO-8859-1"),"UTF-8");
    		}
    		if(fFLoorName!=null){
    			fFLoorName=new String(fFLoorName.getBytes("ISO-8859-1"),"UTF-8");
    		}
			po.setfBuildingName(fBuildingName);
			po.setfFLoorName(fFLoorName);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	List<RoomPo> pos=nursingPlanPublicService.queryRoomList(po);
        int totalSize=nursingPlanPublicService.queryRoomTotal(po);
    	
        return new AjaxResultPo(true, "success", totalSize, pos);
    }
	
	/**
     * 保存公共服务项目
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/savePublicServiceItem")
    public AjaxResultPo savePublicServiceItem(String[] fids,String froomid,HttpServletRequest request , HttpServletResponse response){
    	try{
    		nursingPlanPublicService.savePublicServiceItem(fids,froomid);
    		
    		 return new AjaxResultPo(true, "保存公共护理项目成功");
    	}catch(Exception e){
    		logger.error("保存公共护理项目失败"+e.getMessage());
            return new AjaxResultPo(false,"保存公共护理项目失败");
    	}
    }
}
