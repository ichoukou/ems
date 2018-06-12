package com.channelsoft.ems.nursing.nursingPlan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.nursing.nursingPlan.mapper.OldManServicePlanPoMapper;
import com.channelsoft.ems.nursing.nursingPlan.po.OldManServicePlanPo;
import com.channelsoft.ems.nursing.nursingPlan.service.OldManServicePlanService;
/** 
 * 
 * 老人护理项目计划serviceImpl  
 * @author  lwj
 * @date 创建时间：2017年2月22日20:49:32
 * @parameter  
 * @return  
 */
@Service
public class OldManServicePlanServiceImpl implements OldManServicePlanService{
	@Autowired
	private OldManServicePlanPoMapper mapper;

	@Override
	public void insertSelective(OldManServicePlanPo oldManServicePlanPo) {
		mapper.insertSelective(oldManServicePlanPo);
		
	}

	@Override
	public void updatePlanStatus(OldManServicePlanPo oldManServicePlanPo) {
		mapper.updatePlanStatus(oldManServicePlanPo);
	}
}
