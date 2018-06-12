package com.channelsoft.ems.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.channelsoft.ems.po.DepartmentPo;

/** 
 * 
 * 部门管理
 * @author  wuhl
 * @date 创建时间：2016年12月17日 下午16:13:41 
 * @parameter  
 * @return  
 */
public interface DepartmentManagerService {
	
	public List<DepartmentPo> quertDepartment();

	//查询上级 下拉菜单
	public List<DepartmentPo> queryDepartmentHigh(DepartmentPo po);
	
    public int addDepartment(DepartmentPo po);
    
    public int delectDepartment(DepartmentPo po);

	public int deletcBefore(DepartmentPo po);


	public int updataDepartment(DepartmentPo po);
	
public List<Map<String,String>> quertSonDepartment( String id);

	public int CheckUpdateEmp(DepartmentPo po);

	public int CheckEmp(DepartmentPo po);

	public int DelectCount(DepartmentPo po);




}
