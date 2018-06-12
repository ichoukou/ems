package com.channelsoft.ems.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.MenuPo;
import com.channelsoft.ems.service.AuthorityManageService;


/** 
 * 
 * 权限分配
 * @author  wuhl
 * @date 创建时间：2016年12月1日 下午16:13:41 
 * @parameter  
 * @return  
 */
@Controller
@RequestMapping("/author")
public class AuthorityManageController {

	private static Logger logger = Logger.getLogger(AuthorityManageController.class);
	
	
	@Autowired
	 private AuthorityManageService authorityManageService;
	
	@RequestMapping("/authorm")
	public String gotodataAuthority(HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入菜单显示页");
 
		return "authorityManage/authorityManageList";
	}	
	

/** 
 * 
 *  查询所有权限
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */
	
	@ResponseBody
	@RequestMapping("/query") 
	public AjaxResultPo queryAuthority(MenuPo po, HttpServletRequest request ,HttpServletResponse response){
		
	
		List<MenuPo> list= this.authorityManageService.getMenu();
	
		
		return new AjaxResultPo(true, "success", list.size(), list);
		
	}
	
	

/** 
 * 
 * 根据模块id  查出对应的子菜单  
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */
	@ResponseBody
	@RequestMapping("/querySon") 
	public List<MenuPo> queryAuthoritySon(MenuPo po,HttpServletRequest request ,HttpServletResponse response){
		logger.debug("menu子菜单查询请: "+ po.toString());
        String strParentID=request.getParameter("strParentID");
        List<MenuPo> list= this.authorityManageService.getSonMenu(strParentID);
	    
        return list;
		
	}
	
	

/** 
 * 
 * 查询有权限的角色和其相应的权限
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */
	@ResponseBody
	@RequestMapping("/queryRoleMeun") 
	public AjaxResultPo queryRoleMeun(HttpServletRequest request ,HttpServletResponse response){
		logger.debug("查询角色权限匹配");
 
		List<Map<String,String>> list= this.authorityManageService.getRoleMenu();
	    
		return new AjaxResultPo(true, "success", list.size(), list);
		
	}
	

/** 
 * 
 * 查询没有权限的角色
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */
	@ResponseBody
	@RequestMapping("/queryRoleNotMeun") 
	public AjaxResultPo queryRoleNotMeun(HttpServletRequest request ,HttpServletResponse response){
		logger.debug("查询不存在权限的角色");
		List<Map<String,String>> list= this.authorityManageService.getRoleNotMeun();
	    
		return new AjaxResultPo(true, "success", list.size(), list);
		
	}
	

/** 
 * 
 * 父菜单 子菜单一起关联
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */
	@ResponseBody
	@RequestMapping("/queryParentSon") 
	public AjaxResultPo queryParentSon(HttpServletRequest request ,HttpServletResponse response){
		logger.debug("查询父子菜单关联起来数据");
		List<Map<String,String>> list= this.authorityManageService.getParenSon();
	    
		return new AjaxResultPo(true, "success", list.size(), list);
		
	}

/** 
 * 
 * 为角色增加权限 其中涉及更新和增加
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */

	@ResponseBody
	@RequestMapping("/addAuthor") 
	public AjaxResultPo addAuthor( HttpServletRequest request ,HttpServletResponse response){
		
        String roleid= request.getParameter("oldrole");	
	    String oldAuthority=request.getParameter("newAuthor");		
	    //获取角色id
	    String[] ss=roleid.split("-");	  
        int newrole=Integer.parseInt(ss[0]);
	    //获取新权限
	    String  newAuthority =oldAuthority.substring(0,oldAuthority.length()-1);

	    
	    if(ss[1].equals("0")){
	     	logger.debug("进行增加权限");
		
	         	try {
	     				if(this.authorityManageService.insertAuthority(newrole, newAuthority)==0){
		        		logger.debug("增加成功");	
	            
		        		List<Map<String,String>> list= this.authorityManageService.getParenSon();
					    
						return new AjaxResultPo(true, "success", list.size(), list);
	            	     
	    	
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
		
		
	     }else{
		
		      try {
		
			           logger.debug("进行更新");
			           if(this.authorityManageService.updateAuthority(newrole, newAuthority)==0){
			           logger.debug("更新成功");	
            
			       	List<Map<String,String>> list= this.authorityManageService.getParenSon();
				    
					return new AjaxResultPo(true, "success", list.size(), list);
            	      
		               }else{
			           logger.debug("进入更新方法,更新失败");
			           request.getSession().setAttribute("dmsg", "添加权限失败");
			            return null;
		               }
	         } catch (Exception e) {
		       // TODO: handle exception
	        	 		request.getSession().setAttribute("dmsg", "添加权限失败");
	        	 		logger.debug("异常:"+e.getMessage());
	        	 		e.printStackTrace();
	        	 		return null;
	  }
		
	
	}
	    
	   		
	}
	
	
}
