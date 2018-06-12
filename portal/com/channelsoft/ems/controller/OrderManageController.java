package com.channelsoft.ems.controller;

import java.io.UnsupportedEncodingException;
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
import com.channelsoft.ems.po.HomeServiceItemPo;
import com.channelsoft.ems.po.OrderPo;
import com.channelsoft.ems.service.OrderManageService;

@Controller
@RequestMapping("/Order")
public class OrderManageController {
	
	private static Logger logger = Logger.getLogger(OrderManageController.class);
	
	@Autowired
	 private OrderManageService orderManageService;
	
	@RequestMapping("/order")
	public String gotodataOrderManager(HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入后端跳转到显示页");

		return "OrderManage/OrderManageList";
	}
	

	@ResponseBody
	@RequestMapping("/query") 
	public AjaxResultPo queryOrder( OrderPo po,int page,int pageSize,HttpServletRequest request ,HttpServletResponse response) throws UnsupportedEncodingException {
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");

		po.setfNursingHomeID(user.getOldhouse());
		po.setfObjectName(new String(po.getfObjectName().getBytes("ISO-8859-1"), "utf-8"));
		po.setfServiceObject(new String(po.getfServiceObject().getBytes("ISO-8859-1"), "utf-8"));
		po.setfServiceUser(new String(po.getfServiceUser().getBytes("ISO-8859-1"), "utf-8"));
		po.setfDealStatus(new String(po.getfDealStatus().getBytes("ISO-8859-1"), "utf-8"));

		List<OrderPo> list=this.orderManageService.queryOrder(po, page, pageSize);
       int count=this.orderManageService.queryOrderCount(po);
	   return new AjaxResultPo(true, "success", count, list);
	}
	@ResponseBody
	@RequestMapping("/queryList")
	public AjaxResultPo queryList( OrderPo po,int page,int pageSize,HttpServletRequest request ,HttpServletResponse response) throws UnsupportedEncodingException {

		List<OrderPo> list=this.orderManageService.queryOrder(po, page, pageSize);
		int count=this.orderManageService.queryOrderCount(po);
		return new AjaxResultPo(true, "success", count, list);

	}

	@ResponseBody
	@RequestMapping("/queryLast") 
	public AjaxResultPo queryLast( OrderPo po,HttpServletRequest request ,HttpServletResponse response){
	   List<OrderPo> list=this.orderManageService.lastFid(po);
       
	   return new AjaxResultPo(true, "success", list.size(), list);
	}
	
	@ResponseBody
	@RequestMapping("/queryNumber") 
	public AjaxResultPo queryNumber( OrderPo po,HttpServletRequest request ,HttpServletResponse response){
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");

		po.setfNursingHomeID(user.getOldhouse());
		List<Map<String,String>> list=this.orderManageService.getForderNo(po);
     
	   return new AjaxResultPo(true, "success", list.size(), list);
	}
	
	
	@ResponseBody
	@RequestMapping("/queryData") 
	public AjaxResultPo queryData( HttpServletRequest request ,HttpServletResponse response){
		List<Map<String, String>>  list=this.orderManageService.getData_dic();
	    return new AjaxResultPo(true, "success", list.size(), list);
	}
	@ResponseBody
	@RequestMapping("/queryServiceItemName") 
	public AjaxResultPo queryServiceItemName( OrderPo po,HttpServletRequest request ,HttpServletResponse response){
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		po.setfNursingHomeID(user.getOldhouse());

		List<Map<String, String>> list= this.orderManageService.getServiceItemName(po);
	    return new AjaxResultPo(true, "success", list.size(), list);
	}
	@ResponseBody
	@RequestMapping("/queryServiceType") 
	public AjaxResultPo getServiceType( OrderPo po,HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入查询服务类别 和服务项目......");
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		po.setfNursingHomeID(user.getOldhouse());

		List<Map<String, String>>  list= this.orderManageService.getServiceType(po);
	    return new AjaxResultPo(true, "success", list.size(), list);
	}
	@ResponseBody
	@RequestMapping("/queryStaffMessage") 
	public AjaxResultPo getStaffMessage( HttpServletRequest request ,HttpServletResponse response){
		List<Map<String, String>>  list=this.orderManageService.getStaffMessage();     

	    return new AjaxResultPo(true, "success", list.size(), list);
	}
	

	
	@ResponseBody
	@RequestMapping("/addOrder")
	public AjaxResultPo addOrder(OrderPo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   addOrder()......");
		logger.debug("请求参数: "+ po.toString());
		logger.debug("穿过来的对象"+po);
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		po.setfNursingHomeID(user.getOldhouse());
		po.setfCreatorID(user.getEmployId());

		try {
			if(this.orderManageService.addOrder(po)==0){
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
	@RequestMapping("/deleteOrder")
	public AjaxResultPo deleteOrder(OrderPo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   deleteOrder()......");
		logger.debug("请求参数: "+ po.toString());
	
        logger.debug("禁用订单:"+po.getFid());	

		try {
			if(this.orderManageService.deleteOrder(po)==0){
		        logger.debug("禁用成功:"+po.getFid());	

		     return new AjaxResultPo(true, "success");
				
			}else{
				logger.debug("进入删除方法,删除失败");
				request.getSession().setAttribute("dmsg", "删除失败");
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.getSession().setAttribute("dmsg", "删除异常");
			logger.debug("异常:"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	
	}
	
	
	@ResponseBody
	@RequestMapping("/updateOrder")
	public AjaxResultPo updateOrder(OrderPo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   updateOrderPo()......");
		logger.debug("请求参数: "+ po.toString());
		UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
		po.setfNursingHomeID(user.getOldhouse());
		po.setfCreatorID(user.getEmployId());
		try {
			  logger.debug("更新id:"+po.getFid());	
			if(this.orderManageService.updateOrder(po)==0){
	      
			
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
	
	
		@ResponseBody
		@RequestMapping("/evalOrder")
		public AjaxResultPo evalOrder(OrderPo po, HttpServletRequest request ,HttpServletResponse response){
			logger.debug("进入   evalOrder()......");
			logger.debug("请求参数: "+ po.toString());
			
			try {
				  logger.debug("更新id:"+po.getFid());	
				if(this.orderManageService.evalOrder(po)==0){
		      
				
			     return new AjaxResultPo(true, "success");
					
				}else{
					logger.debug("进入评价订单方法,评价失败");
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
