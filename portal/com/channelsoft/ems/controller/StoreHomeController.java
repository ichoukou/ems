package com.channelsoft.ems.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.channelsoft.ems.po.UserPo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.StoreHousePo;
import com.channelsoft.ems.service.OrderManageService;
import com.channelsoft.ems.service.StorehouseService;
@Controller
@RequestMapping("/StoreHome")
public class StoreHomeController {
private static Logger logger = Logger.getLogger(StoreHomeController.class);
	
	@Autowired
	 private StorehouseService storehouseService;
	
	@Autowired
	private OrderManageService orderManageService;
	
	@RequestMapping("/storeHome")
	public String gotoStoreHomeManager(HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入后端跳转到显示页");

		return "StoreHome/StoreHomeList";
	}
	

	@ResponseBody
	@RequestMapping("/query") 
	public AjaxResultPo queryStoreHome( StoreHousePo po,int page,int pageSize,HttpServletRequest request ,HttpServletResponse response){
	     logger.debug("进入查询仓库StoreHomeController.....");
		List<StoreHousePo> list=this.storehouseService.queryStoreHouse(po, page, pageSize);
       int count=this.storehouseService.queryStoreCount(po);
	   return new AjaxResultPo(true, "success", count, list);
	}

	

	@ResponseBody
	@RequestMapping("/queryStaffMessage") 
	public AjaxResultPo getStaffMessage( HttpServletRequest request ,HttpServletResponse response){
		List<Map<String, String>>  list=this.orderManageService.getStaffMessage();     

	    return new AjaxResultPo(true, "success", list.size(), list);
	}
	

	
	@ResponseBody
	@RequestMapping("/addStoreHome")
	public AjaxResultPo addStoreHome(StoreHousePo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   addStoreHome()......");
		logger.debug("请求参数: "+ po.toString());
		logger.debug("穿过来的对象"+po);
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		po.setfNursingHomeID(user.getOldhouse());

		

		try {
			if(this.storehouseService.addStoretHome(po)==0){
	            logger.debug("增加成功");	
                return new AjaxResultPo(true, "success");
 			}else{
				logger.debug("进入增加方法,增加失败");
				request.getSession().setAttribute("dmsg", "增加失败");
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.getSession().setAttribute("dmsg", "增加异常");
			logger.debug("异常:"+e.getMessage());
			e.printStackTrace();
			return null;
		}

	
	}

	
	@ResponseBody
	@RequestMapping("/updateStoreHome")
	public AjaxResultPo updateStoreHome(StoreHousePo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   updateOrderPo()......");
		logger.debug("请求参数: "+ po.toString());
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		po.setfNursingHomeID(user.getOldhouse());

		try {
			  logger.debug("更新id:"+po.getFid());	
			if(this.storehouseService.updateStoreHome(po)==0){
	      
			
		     return new AjaxResultPo(true, "success");
				
			}else{
				logger.debug("进入更新方法,更新失败");
				request.getSession().setAttribute("dmsg", "更新失败");
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.getSession().setAttribute("dmsg", "更新异常");
			logger.debug("异常:"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	
	}
	

}
