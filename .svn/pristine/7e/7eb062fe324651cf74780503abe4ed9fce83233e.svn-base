package com.channelsoft.ems.nursing.nursingPlan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.nursing.nursingPlan.mapper.PublicServicePlanPoMapper;
import com.channelsoft.ems.nursing.nursingPlan.po.PublicServicePlanPo;
import com.channelsoft.ems.nursing.nursingPlan.service.PublicServicePlanService;
/** 
 * 
 * 房间护理项目计划serviceImpl  
 * @author  lwj
 * @date 创建时间：2017年2月22日20:49:32
 * @parameter  
 * @return  
 */
@Service
public class PublicServicePlanServiceImpl implements PublicServicePlanService{
	@Autowired
	private PublicServicePlanPoMapper mapper;

	@Override
	public void insertSelective(PublicServicePlanPo oldManServicePlanPo) {
		mapper.insertSelective(oldManServicePlanPo);
		
	}

	@Override
	public void updatePlanStatus(PublicServicePlanPo publicServicePlanPo) {
		mapper.updatePlanStatus(publicServicePlanPo);
	}
	
}
