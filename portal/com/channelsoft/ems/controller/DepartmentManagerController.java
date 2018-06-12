
package com.channelsoft.ems.controller;

import java.util.ArrayList;
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
import com.channelsoft.ems.po.DepartmentPo;
import com.channelsoft.ems.po.RolePo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.DepartmentManagerService;
import com.channelsoft.ems.service.UserManagerService;

/** 
 * 
 * 部门管理    
 * @author  wuhl
 * @date 创建时间：2016年12月17日 下午16:13:41 
 * @parameter  
 * @return  
 */
@Controller
@RequestMapping("/depart")
public class DepartmentManagerController {
	private static List<DepartmentPo> poList=new ArrayList<DepartmentPo>();


	private static Logger logger = Logger.getLogger(DepartmentManagerController.class);

	@Autowired
	 private DepartmentManagerService departmentManagerService;
	
	@RequestMapping("/depart")
	public String gotodataDepartmentManager(HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入后端跳转到显示页");

		return "departmentManage/departmentManageList";
	}
	

/** 
 * 
 * 查询所有部门  
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */
	@ResponseBody
	@RequestMapping("/query") 
	public AjaxResultPo queryDepartment( HttpServletRequest request ,HttpServletResponse response){
	   List<DepartmentPo> list=this.departmentManagerService.quertDepartment();
      return new AjaxResultPo(true, "success", list.size(), list);
	}
	

/** 
 * 
 * 根据父亲id查询出相应的子部门 
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */
	@ResponseBody
	@RequestMapping("/querySon") 
	public  List<Map<String,String>> querySonDepartment( HttpServletRequest request ,HttpServletResponse response){
	  String id=request.getParameter("strParentID");
	  logger.debug("获取父菜单.....:"+id);
	 List<Map<String,String>> list=this.departmentManagerService.quertSonDepartment(id);
        
	     return list;
	}
	
	

/** 
 * 
 * 查询相应部门 为前端select 所使用
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */
	@ResponseBody
	@RequestMapping("/showDepartment") 
	public AjaxResultPo showDepartment( DepartmentPo po,HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入DepartmentManagerController....查询部门上级菜单信息:");
	   List<DepartmentPo> list=this.departmentManagerService.queryDepartmentHigh(po);

		poList.clear();
		listFormate(list,"0",0);

      return new AjaxResultPo(true, "success", poList.size(), poList);
	}

/** 
 * 
 * 增加部门
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */
	
	@ResponseBody
	@RequestMapping("/addDepartment")
	public AjaxResultPo addDepartment(DepartmentPo po, HttpServletRequest request ,HttpServletResponse response) {
		logger.debug("进入   addDepartment()......");
		logger.debug("请求参数: " + po.toString());
		logger.debug("穿过来的对象" + po);
		int result = this.departmentManagerService.CheckEmp(po);
		if (result == 1) {
			logger.debug("名称重复" + po);
			return new AjaxResultPo(false, "failed");
		} else {
			logger.debug("名称不重复" + po);
			logger.debug("需要添加字段" + po);
			try {
				if (this.departmentManagerService.addDepartment(po) == 0) {
					logger.debug("添加成功");
					return new AjaxResultPo(true, "success");
				} else {
					logger.debug("进入添加方法,添加失败");
					request.getSession().setAttribute("dmsg", "添加失败");
					return null;
				}
			} catch (Exception e) {
				// TODO: handle exception
				request.getSession().setAttribute("dmsg", "添加异常");
				logger.debug("异常:" + e.getMessage());
				e.printStackTrace();
				return null;
			}
		}

	}

	

/** 
 * 
 * 删除部门
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */
	@ResponseBody
	@RequestMapping("/deleteDepartment")
	public AjaxResultPo deleteDepartment(DepartmentPo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   deleteDepartment()......");
		logger.debug("请求参数: "+ po.toString());

		int count=this.departmentManagerService.DelectCount(po);
		if(count!=0){
			return new AjaxResultPo(false, "failed");
		}else{
			try {
				if(this.departmentManagerService.delectDepartment(po)==0){
					logger.debug("成功删除"+po.getFid());

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

	
	}

	

/** 
 * 
 * 没有子部门才可以删除
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */
	@ResponseBody
	@RequestMapping("/deleteBefore")
	public AjaxResultPo deleteBefore(DepartmentPo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   deleteBefore()......");
		logger.debug("请求参数: "+ po.toString());

		int count=this.departmentManagerService.deletcBefore(po);
		if(count==0){//可以删除
			return new AjaxResultPo(true, "success");

		}else{
			try {
				if(this.departmentManagerService.deletcBefore(po)!=0){
					logger.debug("成功删除"+po.getFid());

					return new AjaxResultPo(false, "failed");

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


	}


/** 
 * 
 * 更新部门
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */

	@ResponseBody
	@RequestMapping("/updateDepartment")
	public AjaxResultPo updateDepartment(DepartmentPo po, HttpServletRequest request ,HttpServletResponse response){
		logger.debug("进入   updateDepartment()......");
		logger.debug("请求参数: "+ po.toString());

		int result = this.departmentManagerService.CheckUpdateEmp(po);
		if (result == 1) {
			logger.debug("名称重复" + po);
			return new AjaxResultPo(false, "failed");
		} else {
			logger.debug("名称不重复" + po);
			logger.debug("需要添加字段" + po);
			try {
				if (this.departmentManagerService.updataDepartment(po) == 0) {
					logger.debug("更新成功");
					return new AjaxResultPo(true, "success");
				} else {
					logger.debug("进入更新方法,更新失败");
					request.getSession().setAttribute("dmsg", "更新失败");
					return null;
				}
			} catch (Exception e) {
				// TODO: handle exception
				request.getSession().setAttribute("dmsg", "添加异常");
				logger.debug("异常:" + e.getMessage());
				e.printStackTrace();
				return null;
			}
		}
	}
	//类型列表排序
	public static void listFormate(List<DepartmentPo> list,String id,int level){
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getfHigherUpID().equals(id))
			{
				StringBuffer str =new StringBuffer();
				for(int j=0;j<level;j++)
				{
					if(j==(level-1))
					{
						str.append("&nbsp;&nbsp;&nbsp;&nbsp;"+"▶");
					}
					else{
						str.append("&nbsp;&nbsp;&nbsp;&nbsp;");
					}
				}
				list.get(i).setfDepartmentName(str+list.get(i).getfDepartmentName());
				poList.add(list.get(i));
				listFormate(list,list.get(i).getFid(),level+1);
			}
		}
	}
	

/** 
 * 增加部门时候验证
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */

	@ResponseBody
	@RequestMapping("/addEmp_check")
	public AjaxResultPo addEmp_check(DepartmentPo po, HttpServletResponse response, HttpServletRequest request){
		logger.debug("进入   addEmp_check()......");
		logger.debug("请求参数: " + po.toString());

		logger.debug("判断名称是否重复" + po);
		try{

			int result=this.departmentManagerService.CheckEmp(po);
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
	 * 更新部门时候验证
	 * @author  wuhl
	 * @date 创建时间：2016年12月9日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */

	@ResponseBody
	@RequestMapping("/UpdateEmp_check")
	public AjaxResultPo checkUpdateUser(DepartmentPo po, HttpServletResponse response, HttpServletRequest request){
		logger.debug("进入   checkUpdateUser()......");
		logger.debug("请求参数: " + po.toString());

		logger.debug("判断名称是否重复" + po);
		try{

			int result=this.departmentManagerService.CheckUpdateEmp(po);
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
