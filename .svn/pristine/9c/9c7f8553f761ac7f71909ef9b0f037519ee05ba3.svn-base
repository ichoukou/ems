package com.channelsoft.ems.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.mapper.AssessProjectMapper;
import com.channelsoft.ems.po.LevelPo;
import com.channelsoft.ems.service.IAssessProject;

/**
 * 
 * @author wangjs
 *
 */
@Service
public class AssessProjectImpl implements IAssessProject {

	private Logger logger=Logger.getLogger(AssessProjectImpl.class);
	
	@Autowired
	private AssessProjectMapper assProjectMapper;

	/**
	 * @Method: queryCount
	 * @Description: 查询评估项目总数
	 * @Para: [LevelPo]
	 * @Retun: int
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	public int queryCount(LevelPo po){
		int dataCount=assProjectMapper.queryCount(po);
		logger.debug("AssessProjectImpl.dataCount"+dataCount);
		return dataCount;
	}

	/**
	 * @Method: queryProject
	 * @Description: 分页查询评估项目
	 * @Para: [LevelPo po,int page,int pageSize]
	 * @Retun: List<LevelPo>
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	public List<LevelPo> queryProject(LevelPo po,int page,int pageSize) {
		logger.debug("进入AssessProjectImpl.queryProject()方法");
		List<LevelPo> proList=assProjectMapper.queryProList(po,page,pageSize);
		logger.debug("评估项目，查询得到:"+proList.size()+"条数据");
		return proList;
	}

	/**
	 * @Method: getProject
	 * @Description: 查询评估项目
	 * @Para: [LevelPo]
	 * @Retun: List<LevelPo>
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	public List<LevelPo> getProject(LevelPo po) {
		logger.debug("进入AssessProjectImpl.queryProject()方法");
		List<LevelPo> proList=assProjectMapper.getProject(po);
		logger.debug("评估项目（不带分页），查询得到:"+proList.size()+"条数据");
		return proList;
	}

	/**
	 * @Method: checkAp
	 * @Description: 评估项目验证
	 * @Para: [LevelPo]
	 * @Retun: int
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	public int checkAp(LevelPo po){
		logger.debug("进入 AssessProjectImpl.checkDc()......");
		logger.debug("评估项目验证，查询参数: " + po.toString());
		int result = assProjectMapper.checkAp(po);
		logger.debug("评估项目验证，查询结果："+result);
		return result;
	}

	/**
	 * @Method: addProject
	 * @Description: 添加评估项目
	 * @Para: [LevelPo]
	 * @Retun: void
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	public void addProject(LevelPo po){
		logger.debug("进入AssessProjectImpl.addProject()方法");
		try{
			assProjectMapper.addProject(po);
			logger.debug("添加评估项目成功");
		}catch (Exception e){
			logger.error("添加评估项目异常:"+e.getMessage());
		}
	}

	/**
	 * @Method: updProject
	 * @Description: 修改评估项目
	 * @Para: [LevelPo]
	 * @Retun: void
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	public void updProject(LevelPo po){
		logger.debug("进入AssessProjectImpl.updProject()方法");
		try{
			assProjectMapper.updProject(po);
			logger.debug("修改评估项目成功");
		}catch (Exception e){
			logger.error("修改评估项目异常:"+e.getMessage());
		}
	}

	/**
	 * @Method: delProject
	 * @Description: 删除评估项目
	 * @Para: [LevelPo]
	 * @Retun: void
	 * @Author: wangjs
	 * @Date: 2017/2/26
	 */
	public void delProject(LevelPo po){
		logger.debug("进入AssessProjectImpl.delProject（）方法");
		try{
			assProjectMapper.delProject(po);
			logger.debug("删除评估项目成功");
		}catch (Exception e){
			logger.error("删除评估项目异常:"+e.getMessage());
		}
	}
}
