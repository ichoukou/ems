package com.channelsoft.ems.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.channelsoft.ems.common.MD5;
import com.channelsoft.ems.po.MessagePo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.RolePo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.UserManagerService;

/** 
 * 
 * 用户管理  
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午16:13:41 
 * @parameter  
 * @return  
 */
@Controller
@RequestMapping("/user")
public class UserManagerController {
	
	private static Logger logger = Logger.getLogger(UserManagerController.class);
	
	@Autowired
	 private UserManagerService userManagerService;
	
	@RequestMapping("/userm")
	public String gotodataUser(HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入后端跳转到显示页");
 
		return "userManage/userManageList";
	}
	

/** 
 * 
 * 查询用户
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午16:13:41 
 * @parameter  
 * @return  
 */
	@ResponseBody
	@RequestMapping("/query") 
	public AjaxResultPo queryUser(UserPo  po, @RequestParam(defaultValue="0")int page, @RequestParam(defaultValue="10") int pageSize, HttpServletRequest request , HttpServletResponse response)throws UnsupportedEncodingException {
		logger.debug("user请求参数:  page "+ page + " pageSize " + pageSize);
		po.setUname(new String(po.getUname().getBytes("ISO-8859-1"), "utf-8"));

		List<UserPo> list= this.userManagerService.queryAllUser(po,page,pageSize);
	   for(int i=0;i<list.size();i++){
	    	if(list.get(i).getState().equals("0")){
	    		list.get(i).setState("<span style='color:red'>已禁用</span>");
	    	}else{
	    		list.get(i).setState("<span style='color:green'>已启用</span>");
	    	}
	    	if(list.get(i).getRoleName().equals("部门经理")){
	    		list.get(i).setName(list.get(i).getName()+"<span style='color:red'>(部门经理)</span>");
	    	}
	    }
        int userCount = this.userManagerService.getUserCount();

		
		return new AjaxResultPo(true, "success", userCount, list);
	}

	

/** 
 *  查询员工 
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午16:13:41 
 * @parameter  
 * @return  
 */
	@ResponseBody
	@RequestMapping("/queryStaff")
	public AjaxResultPo gotoEmpMessageList(MessagePo po, int page, int pageSize, HttpServletRequest request , HttpServletResponse response){
		logger.debug("message--请求参数: "+ po.toString()+ "  page "+ page + " pageSize " + pageSize);
		List<MessagePo> messageList=this.userManagerService.queryList(po,page,pageSize);
		logger.debug("进入gotoEmpMessageList（）方法");
		int dataCount=userManagerService.queryCount(po);
		return new AjaxResultPo(true,"success",dataCount,messageList);
	}

    //条件查询
	@ResponseBody
	@RequestMapping("/queryList")
	public AjaxResultPo queryList( UserPo  po,int page,int pageSize,HttpServletRequest request ,HttpServletResponse response) {
		logger.debug("进入查询用户信息......");


		List<UserPo> list=this.userManagerService.queryAllUser(po,page,pageSize);
		for(int i=0;i<list.size();i++){
			if(list.get(i).getState().equals("0")){
				list.get(i).setState("<span style='color:red'>已禁用</span>");
			}else{
				list.get(i).setState("<span style='color:green'>已启用</span>");
			}
			if(list.get(i).getRoleName().equals("部门经理")){
				list.get(i).setName(list.get(i).getName()+"<span style='color:red'>(部门经理)</span>");
			}
		}

		int count=this.userManagerService.queryAllUserCount(po);
		return new AjaxResultPo(true, "success", count, list);
	}


/** 
 * 
 * 增加用户
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午16:13:41 
 * @parameter  
 * @return  
 */
	@ResponseBody
	@RequestMapping("/addUser")
	public AjaxResultPo addUser(UserPo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   addUser()......");
        String md5=new MD5().getMD5ofString(po.getPassWord());
		po.setPassWord(md5);
		logger.debug("请求参数: "+ po.toString());
		logger.debug("穿过来的对象"+po);
		int result=this.userManagerService.CheckUser(po);
		if(result==1){
			logger.debug("名称重复" + po);
			return new AjaxResultPo(false, "failed");
		}else{
			try {
				if(this.userManagerService.addUser(po)==0){
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

	
	}


/** 
 * 
 * 删除用户管理  
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午16:13:41 
 * @parameter  
 * @return  
 */
	@ResponseBody
	@RequestMapping("/deleteUser")
	public AjaxResultPo deleteUser(UserPo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   deleteUser()......");
		logger.debug("请求参数: "+ po.toString());
		
		try {
			if(this.userManagerService.updateState(po)==0){
	        logger.debug("成功删除"+po.getUid());	
			
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
	@RequestMapping("/startUser")
	public AjaxResultPo startUser(UserPo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   startUser()......");
		logger.debug("请求参数: "+ po.toString());


		try {
			if(this.userManagerService.startState(po)==0){
	        logger.debug("成功启用"+po.getUid());	
		
		     return new AjaxResultPo(true, "success");
				
			}else{
				logger.debug("进入启用方法,启用失败");
				request.getSession().setAttribute("dmsg", "启用失败");
				return null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			request.getSession().setAttribute("dmsg", "启用异常");
			logger.debug("异常:"+e.getMessage());
			e.printStackTrace();
			return null;
		}
	
	}

/** 
 * 
 *  更新用户  
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午16:13:41 
 * @parameter  
 * @return  
 */
	@ResponseBody
	@RequestMapping("/updateUser")
	public AjaxResultPo updateUser(UserPo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   updateRole()......");
		logger.debug("请求参数: "+ po.toString());
		String md5=new MD5().getMD5ofString(po.getPassWord());
		po.setPassWord(md5);
		int result=this.userManagerService.CheckUpdateUser(po);
		if(result==1){
			logger.debug("名称重复" + po);
			return new AjaxResultPo(false, "failed");
		}else {
			try {
				if (this.userManagerService.updataUser(po) == 0) {
					logger.debug("更新id:" + po.getUid());

					return new AjaxResultPo(true, "success");

				} else {
					logger.debug("进入更新方法,更新失败");
					request.getSession().setAttribute("dmsg", "更新失败");
					return null;
				}
			} catch (Exception e) {
				// TODO: handle exception
				request.getSession().setAttribute("dmsg", "更新异常");
				logger.debug("异常:" + e.getMessage());
				e.printStackTrace();
				return null;
			}
		}
	}
	

/** 
 * 显示角色 
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午16:13:41 
 * @parameter  
 * @return  
 */
	@ResponseBody
	@RequestMapping("/showRole") 
	public AjaxResultPo showRole( HttpServletRequest request ,HttpServletResponse response){
	
		List<Map<String,String>> list= this.userManagerService.getALLRole();
		logger.debug("数据查询完毕");
		
		return new AjaxResultPo(true, "success", list.size(), list);
	}


/** 
 * 
 * 查询用户  
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午16:13:41 
 * @parameter  
 * @return  
 */

	@ResponseBody
	@RequestMapping("/checkUser")
	public AjaxResultPo checkUser(UserPo po, HttpServletResponse response, HttpServletRequest request){
		logger.debug("进入   checkUser()......");
		logger.debug("请求参数: " + po.toString());

		logger.debug("判断名称是否重复" + po);
	 try{

		 int result=this.userManagerService.CheckUser(po);
		 if(result==1){
			 logger.debug("名称重复" + po);
			 return new AjaxResultPo(false, "failed");
		 }
		 else{
			 return new AjaxResultPo(true, "success");
		 }

	 } catch (Exception e) {
				// TODO: handle exception
				request.getSession().setAttribute("dmsg", "验证异常");
				logger.debug("异常:" + e.getMessage());
				e.printStackTrace();
				return null;
			}
		}
	

/** 
 * 
 * 核对用户密码
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午16:13:41 
 * @parameter  
 * @return  
 */

	@ResponseBody
	@RequestMapping("/checkUpdateUser")
	public AjaxResultPo checkUpdateUser(UserPo po, HttpServletResponse response, HttpServletRequest request){
		logger.debug("进入   checkUpdateUser()......");
		logger.debug("请求参数: " + po.toString());

		logger.debug("判断名称是否重复" + po);
		try{

			int result=this.userManagerService.CheckUpdateUser(po);
			if(result==1){
				logger.debug("名称重复" + po);
				return new AjaxResultPo(false, "failed");
			}
			else{
				return new AjaxResultPo(true, "success");
			}

		} catch (Exception e) {
			// TODO: handle exception
			request.getSession().setAttribute("dmsg", "验证异常");
			logger.debug("异常:" + e.getMessage());
			e.printStackTrace();
			return null;
		}
	}
	
}
