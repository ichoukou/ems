package com.channelsoft.ems.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.mapper.DepartmentManagerMapper;
import com.channelsoft.ems.po.DepartmentPo;
import com.channelsoft.ems.service.DepartmentManagerService;

@Service
public class DepartmentManagerServiceImpl implements DepartmentManagerService {

	private Logger logger = Logger.getLogger(DepartmentManagerServiceImpl.class);

	@Autowired
	private DepartmentManagerMapper departmentManagerMapper;


	public List<DepartmentPo> quertDepartment() {
		// TODO Auto-generated method stub
		logger.debug("进入 quertDepartmentServiceImpl..... 查询部门的信息");
		return this.departmentManagerMapper.quertDepartment();

	}


	public List<DepartmentPo> queryDepartmentHigh(DepartmentPo po) {
		// TODO Auto-generated method stub
		logger.debug("进入 quertDepartmentServiceImpl..... 查询部门的上级信息");
		return this.departmentManagerMapper.queryDepartmentHigh(po);
	}


	public int addDepartment(DepartmentPo po) {
		// TODO Auto-generated method stub
		logger.debug("进入addDepartment方法");
		try {
			this.departmentManagerMapper.addDepartment(po);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
			logger.debug("增加部门失败");
			return 1;
		}
		return 0;
	}


	public int delectDepartment(DepartmentPo po) {
		// TODO Auto-generated method stub
		logger.debug("进入delectDepartment方法");
		try {
			this.departmentManagerMapper.delectDepartment(po);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
			logger.debug("删除部门失败");
			return 1;
		}
		return 0;
	}

	public int deletcBefore(DepartmentPo po) {
		return this.departmentManagerMapper.deletcBefore(po);
	}


	public int updataDepartment(DepartmentPo po) {
		// TODO Auto-generated method stub
		logger.debug("进入updataDepartment方法");
		try {
			this.departmentManagerMapper.updataDepartment(po);
		} catch (Exception e) {
			logger.debug(e.getMessage());
			e.printStackTrace();
			logger.debug("更新部门失败");
			return 1;
		}
		return 0;
	}


	public List<Map<String, String>> quertSonDepartment(String id) {
		// TODO Auto-generated method stub
		return this.departmentManagerMapper.quertSonDepartment(id);
	}


	public int CheckEmp(DepartmentPo po) {
		// TODO Auto-generated method stub
		logger.debug("进入CheckEmp方法");
		try {
			logger.debug("启用账号" + po.getfDepartmentName());
			if (this.departmentManagerMapper.CheckEmp(po) == 0) {
				logger.debug("不存在重复账号" + po.getfDepartmentName());
				return 0;
			}
			;
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug("验证部门名称出错" + e.getMessage());
			e.printStackTrace();
			return 1;
		}
		return 1;
	}

	public int DelectCount(DepartmentPo po) {
		logger.debug("进入DelectCount方法");
		try {
			logger.debug("删除账号" + po.getFid());
			if (this.departmentManagerMapper.DelectCount(po) == 0) {
				logger.debug("删除菜单" );
				return 0;
			}
			;
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug("查询菜单父类级别异常" + e.getMessage());
			e.printStackTrace();
			return 1;
		}
		return 1;
	}


	public int CheckUpdateEmp(DepartmentPo po) {
		// TODO Auto-generated method stub
		logger.debug("进入CheckUpdateEmp方法");
		try {
			logger.debug("更新账号" + po.getfDepartmentName());
			if (this.departmentManagerMapper.CheckUpdateEmp(po) == 0) {
				logger.debug("不存在重复部门名称" + po.getfDepartmentName());
				return 0;
			}
			;
		} catch (Exception e) {
			// TODO: handle exception
			logger.debug("验证账号出错" + e.getMessage());
			e.printStackTrace();
			return 1;
		}
		return 1;
	}
}