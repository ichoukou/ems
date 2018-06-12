package com.channelsoft.ems.nursing.nursingProject.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.channelsoft.ems.common.IdGen;
import com.channelsoft.ems.common.ResponseJsonUtil;
import com.channelsoft.ems.nursing.nursingPlan.po.OldManPo;
import com.channelsoft.ems.nursing.nursingPlan.po.OldManServiceItemPo;
import com.channelsoft.ems.nursing.nursingPlan.po.PublicServiceItemPo;
import com.channelsoft.ems.nursing.nursingPlan.po.RoomPo;
import com.channelsoft.ems.nursing.nursingPlan.service.NursingPlanOldManService;
import com.channelsoft.ems.nursing.nursingPlan.service.NursingPlanPublicService;
import com.channelsoft.ems.nursing.nursingProject.po.NursingProjectPo;
import com.channelsoft.ems.nursing.nursingProject.po.NursingServiceGroupPo;
import com.channelsoft.ems.nursing.nursingProject.po.NursingServiceItemLevelPo;
import com.channelsoft.ems.nursing.nursingProject.service.NursingProjectService;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.DataDictionaryPo;
import com.channelsoft.ems.po.UserPo;

/** 
 * 
 * 护理项目controller  
 * @author  lwj
 * @date 创建时间：2017年02月09日 下午14:31:41 
 * @parameter  
 * @return  
 */
@Controller
@RequestMapping("/nursingProject")
public class NursingProjectController {
	private static Logger logger = Logger.getLogger(NursingProjectController.class);
	
	@Autowired
	private NursingProjectService nursingProjectService;
	
	@Autowired
	private NursingPlanPublicService nursingPlanPublicService;
	
	@Autowired
	private NursingPlanOldManService nursingPlanOldManService;
	
    @RequestMapping("/index")
    public String index(){
        logger.debug("index已经跳转");
        return "nursing/nursingProject/index";
    }
    
    @RequestMapping("/indexServiceGroup")
    public String indexServiceGroup(){
        logger.debug("indexServiceGroup已经跳转");
        return "nursing/nursingServiceGroup/index";
    }
    
    @RequestMapping("/addNursingServiceGroup")
    public String addNursingServiceGroup(HttpServletRequest request , HttpServletResponse response){
        logger.debug("新增护理类型已经跳转");
        return "nursing/nursingServiceGroup/addNursingServiceGroup";
    }
    
    @RequestMapping("/addNursingProject")
    public ModelAndView addNursingProject(HttpServletRequest request , HttpServletResponse response){
        logger.debug("新增护理项目已经跳转");
        /**
         * 从数据字典中获取 护理级别
         */
        ModelAndView mv = new ModelAndView("nursing/nursingProject/addNursingProject");
        String fNumber=IdGen.getRandomNoYMS("HLXM",4);
        mv.addObject("fNumber",fNumber);
        
        return mv;
    }
    
    /**
     * 从数据字典获取护理级别下拉选项值(待全部源代码移交后，迁移到 SysManagerService 中去 )
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getServiceLevels")
    public void getServiceLevels(HttpServletRequest request , HttpServletResponse response){
    	DataDictionaryPo dc=new DataDictionaryPo();
        dc.setName("项目等级");
        List<DataDictionaryPo> serviceLevels=nursingProjectService.getDcValueByName(dc);
        ResponseJsonUtil.writeResultNoTrans(response, JSON.toJSON(serviceLevels));
    }
    
    /**
     * 从数据字典根据name获取value值
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getDcValueByName")
    public void getDcValueByName(DataDictionaryPo  po,HttpServletRequest request , HttpServletResponse response){
    	DataDictionaryPo dc=new DataDictionaryPo();
        dc.setName(po.getName());
        List<DataDictionaryPo> pos=nursingProjectService.getDcValueByName(dc);
        ResponseJsonUtil.writeResultNoTrans(response, JSON.toJSON(pos));
    }
    
    /**
     * 获取护理类型下拉选项值
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getServiceGroups")
    public void getServiceGroups(String fServiceType,HttpServletRequest request , HttpServletResponse response){
    	Map<String,String> map=new HashMap<String, String>();
    	map.put("fServiceType", fServiceType);
        List<NursingServiceGroupPo> serviceGroups=nursingProjectService.getServiceGroups(map);
        ResponseJsonUtil.writeResultNoTrans(response, JSON.toJSON(serviceGroups));
    }
    
    /**
     * 根据fid获取护理项目数据
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getNursingProject")
    public void getNursingProject(String fid,HttpServletRequest request , HttpServletResponse response){
    	NursingProjectPo po=nursingProjectService.getNursingProject(fid);
        ResponseJsonUtil.writeResultNoTrans(response, JSON.toJSON(po));
    }
    
    /**
     * 根据FparentId获取护理项目所对应的护理级别数据
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/getServiceLevelByFparentId")
    public void getServiceLevelByFparentId(String fid,HttpServletRequest request , HttpServletResponse response){
    	List<NursingServiceItemLevelPo> levels=nursingProjectService.getServiceLevelByFparentId(fid);
        ResponseJsonUtil.writeResultNoTrans(response, JSON.toJSON(levels));
    }
    
    @ResponseBody
    @RequestMapping("/queryServiceGroupList")
    public AjaxResultPo queryServiceGroupList(NursingServiceGroupPo po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ po.toString());
    	
    	List<NursingServiceGroupPo> pos=nursingProjectService.queryServiceGroupList(po);
        int totalSize=nursingProjectService.getServiceGroupTotalSize(po);
        return new AjaxResultPo(true, "success", totalSize, pos);
    }
    
    @ResponseBody
    @RequestMapping("/queryList")
    public AjaxResultPo queryList(NursingProjectPo po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ po.toString());
    	List<NursingProjectPo> pos=nursingProjectService.queryList(po);
        int totalSize=nursingProjectService.getTotalSize(po);
        return new AjaxResultPo(true, "success", totalSize, pos);
    }
    
    @ResponseBody
    @RequestMapping("/queryDetailList")
    public AjaxResultPo queryDetailList(NursingProjectPo po,HttpServletRequest request , HttpServletResponse response){
    	logger.debug("请求参数: "+ po.toString());
    	List<NursingProjectPo> details=nursingProjectService.queryDetailList(po);
        
        return new AjaxResultPo(true, details);
    }
    
    @ResponseBody
    @RequestMapping("/saveNursingServiceGroup")
    public AjaxResultPo saveNursingServiceGroup(NursingServiceGroupPo po,HttpServletRequest request , HttpServletResponse response){
    	 logger.debug("saveNursingServiceGroup（）方法");
    	 UserPo user=(UserPo)request.getSession().getAttribute("loginUser");
    	 String prev="";
	        try{
	        	if(po.getFid()==null || "".equals(po.getFid())){
	        		String fid=nursingProjectService.checkNursingServiceGroupName(po.getfName());
	        		if(fid !=null && !"".equals(fid)){
	        			return new AjaxResultPo(false,"该护理类型["+po.getfName()+"]已存在");
	        		}
	        		prev="添加";
	        		po.setfCreatorID(user.getUid());
	        		po.setfCreateTime(new Date());
	        		po.setfModifierID(user.getUid());
	        		po.setfModifierTime(new Date());
	        	}else{
	        		prev="修改";
	        		po.setfModifierID(user.getUid());
	        		po.setfModifierTime(new Date());
	        	}
	        	//根据当前登录人的养老院作为默认值，暂时先固定写死一个值
	        	String fNursingHomeID=nursingProjectService.getFnursingHomeIDByUserID(user.getUid());
	        	po.setfAuditorID(user.getUid());
	        	po.setfAuditTime(new Date());
	        	po.setfNursingHomeID(fNursingHomeID);
	        	nursingProjectService.saveNursingServiceGroup(po);
	            logger.debug("成功---添加护理类型");
	            return new AjaxResultPo(true,prev+"护理类型成功");
	        }catch (Exception e){
	            logger.error("护理类型添加失败"+e.getMessage());
	            return new AjaxResultPo(false,"添加护理类型失败!");
	        }
    }
    
    @ResponseBody
    @RequestMapping("/saveNursingProject")
    public AjaxResultPo saveNursingProject(NursingProjectPo po,HttpServletRequest request , HttpServletResponse response){
    	 logger.debug("saveNursingProject（）方法");
    	 UserPo user=(UserPo)request.getSession().getAttribute("loginUser");
    	 String prev="";
	        try{
	        	if(po.getFid()==null || "".equals(po.getFid())){
	        		String fid=nursingProjectService.checkNursingProjectName(po.getfName());
	        		if(fid !=null && !"".equals(fid)){
	        			return new AjaxResultPo(false,"该护理项目["+po.getfName()+"]已存在");
	        		}
	        		po.setfCreatorID(user.getUid());
	        		po.setfCreateTime(new Date());
	        		po.setfModifierID(user.getUid());
	        		po.setfModifierTime(new Date());
		        	
		        	prev="添加";
	        	}else{
	        		po.setfModifierID(user.getUid());
	        		po.setfModifierTime(new Date());
	        		
		        	prev="修改";
	        	}
	        	//根据当前登录人的养老院作为默认值，暂时先固定写死一个值
	        	String fNursingHomeId=nursingProjectService.getFnursingHomeIDByUserID(user.getUid());
	        	po.setfAuditorID(user.getUid());
	        	po.setfAuditTime(new Date());
	        	po.setfNursingHomeID(fNursingHomeId);
	        	nursingProjectService.saveNursingProject(po);
	        	
	        	if("添加".equals(prev)){
	        		/**
	        		 * 如果是新增了一个护理项目时
	        		 * 1-检验是否是 公共服务 项目 serviceType=1(老人服务) serviceType=2(公共服务)
	        		 * 2-如果是 公共服务项目，则往每个 公共服务项目表
	        		 * 每个房间 都插入这个项目的记录
	        		 */
	        		String serviceType=nursingProjectService.checkServiceType(po.getfServiceGroupID());
	        		if("2".equals(serviceType)){
	        			List<RoomPo> rooms=nursingPlanPublicService.getAllRoom();
	        			for (RoomPo roomPo : rooms) {
	        				PublicServiceItemPo publicServiceItemPo=new PublicServiceItemPo();
	        				
	        				String fid=IdGen.getRandomNoYMS("GGXM", 4);
	        				String fnursingHomeid=po.getfNursingHomeID();
	        				String fnumber=IdGen.getRandomNoYMS("GGXMN", 4);
	        				String fstatus="1";  //先统一设置成 禁用，再改符合房间级别的的项目为启用
	        				String fserviceitemid=po.getFid();
	        				
	        				publicServiceItemPo.setFid(fid);
	        				publicServiceItemPo.setFnursingHomeid(fnursingHomeid);
	        				publicServiceItemPo.setFnumber(fnumber);
	        				publicServiceItemPo.setFstatus(fstatus);
	        				publicServiceItemPo.setFserviceitemid(fserviceitemid);
	        				publicServiceItemPo.setFroomid(roomPo.getFid());
	        				publicServiceItemPo.setFserviceenddate(new Date());
	        				publicServiceItemPo.setFserviceenddate(null);
	        				
	        				nursingPlanPublicService.insertSelective(publicServiceItemPo);
						}
	        		}else{
	        			String levels="";
	    				if(po.getFserviceLevels() !=null && !"".equals(po.getFserviceLevels())){
	    					String[] fserviceLevels=po.getFserviceLevels().split(",");
	    					for (int i=0;i<fserviceLevels.length;i++ ) {
	    						if(i==fserviceLevels.length-1){
	    							levels+="'"+fserviceLevels[i]+"'";
	    						}else{
	    							levels+="'"+fserviceLevels[i]+"',";
	    						}
	    					}
	    					
	    					List<OldManPo> oldMans=nursingPlanOldManService.getLevelOldMan(levels);
		        			
		        			for (OldManPo oldManPo : oldMans) {
		        				OldManServiceItemPo oldManServiceItemPo=new OldManServiceItemPo();
		        				String fid=IdGen.getRandomNoYMS("LRXM", 4);
		        				String fnursingHomeid=fNursingHomeId;
		        				String fnumber=IdGen.getRandomNoYMS("LRXMN", 4);
		        				String fstatus="2";  //先统一设置成 禁用，再改符合老人级别的的项目为启用
		        				String fserviceitemid=po.getFid();
		        				String fnurselevelid=oldManPo.getFnursingLevel();
		        				
		        				oldManServiceItemPo.setfCreateTime(new Date());
		        				oldManServiceItemPo.setfCreatorID(user.getUid());
		        				oldManServiceItemPo.setfModifierTime(new Date());
		        				oldManServiceItemPo.setfModifierID(user.getUid());
		        				oldManServiceItemPo.setFaudittime(new Date());
		        				oldManServiceItemPo.setFauditorid(user.getUid());
		        				
		        				oldManServiceItemPo.setFid(fid);
		        				oldManServiceItemPo.setFnursingHomeid(fnursingHomeid);
		        				oldManServiceItemPo.setFnumber(fnumber);
		        				oldManServiceItemPo.setFstatus(fstatus);
		        				oldManServiceItemPo.setFserviceitemid(fserviceitemid);
		        				oldManServiceItemPo.setFoldmanid(oldManPo.getFid());
		        				oldManServiceItemPo.setFnurselevelid(fnurselevelid);
		        				
		        				nursingPlanOldManService.insertSelective(oldManServiceItemPo);
							}
	    				}
	        		}
	        	}
	        	
	            logger.debug("成功---添加护理项目");
	            return new AjaxResultPo(true,prev+"护理项目成功");
	        }catch (Exception e){
	            logger.error("护理类型添加失败"+e.getMessage());
	            return new AjaxResultPo(false,"添加护理项目失败");
	        }
    }
    
    /**
     * 根据fid删除护理项目数据
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/delNursingProject")
    public AjaxResultPo delNursingProject(String fid,HttpServletRequest request , HttpServletResponse response){
    	try{
    		nursingProjectService.delNursingProject(fid);
    		logger.debug("成功---删除护理项目");
            return new AjaxResultPo(true,"删除护理项目成功");
    	}catch(Exception e){
    		logger.error("护理项目删除失败"+e.getMessage());
            return new AjaxResultPo(false,"删除护理项目失败");
    	}
    }
    
    /**
     * 根据fid修改护理项目状态
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateNursingProject")
    public AjaxResultPo updateNursingProject(NursingProjectPo po,HttpServletRequest request , HttpServletResponse response){
    	try{
    		nursingProjectService.updateNursingProject(po);
    		logger.debug("成功---修改护理项目状态");
            return new AjaxResultPo(true,"修改护理项目状态成功");
    	}catch(Exception e){
    		logger.error("修改护理项目状态失败"+e.getMessage());
            return new AjaxResultPo(false,"修改护理项目状态失败");
    	}
    }
    
    /**
     * 判断项目是否被 老人或者公共服务项目引用
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkProjectUsed")
    public AjaxResultPo checkProjectUsed(NursingProjectPo po,HttpServletRequest request , HttpServletResponse response){
    	try{
    		boolean flag=nursingProjectService.checkProjectUsed(po);
    		logger.debug("成功---修改护理项目状态");
    		if(flag){
    			  return new AjaxResultPo(true,"有被引用");
    		}else{
    			 return new AjaxResultPo(false,"未被引用");
    		}
    	}catch(Exception e){
    		logger.error("修改护理项目状态失败"+e.getMessage());
            return new AjaxResultPo(false,"修改护理项目状态失败");
    	}
    }
}
