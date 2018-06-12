package com.channelsoft.ems.nursing.nursingPlanExcute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.common.IdGen;
import com.channelsoft.ems.nursing.nursingPlanExcute.mapper.PublicServiceExecutePoMapper;
import com.channelsoft.ems.nursing.nursingPlanExcute.po.PublicServiceExecutePo;
import com.channelsoft.ems.nursing.nursingPlanExcute.service.PublicServiceExecuteService;

/** 
 * 
 * 公共护理计划执行seviceImpl  
 * @author  lwj
 * @date 创建时间：2017年2月24日09:44:46
 * @parameter  
 * @return  
 */
@Service
public class PublicServiceExecuteServiceImpl implements PublicServiceExecuteService{
	
	@Autowired
	private PublicServiceExecutePoMapper mapper;

	@Override
	public List<PublicServiceExecutePo> queryList(PublicServiceExecutePo po) {
		return mapper.queryList(po);
	}

	@Override
	public int getTotalSize(PublicServiceExecutePo po) {
		return mapper.getTotalSize(po);
	}

	@Override
	public List<PublicServiceExecutePo> queryDetailList(
			PublicServiceExecutePo po) {
		return mapper.queryDetailList(po);
	}

	@Override
	public void savePublicPlanExecute(PublicServiceExecutePo po) {
		//插入执行记录
				String fid=IdGen.getRandomNoYMS("GGJHZX", 4);
				String fnumber=IdGen.getRandomNoYMS("GGZXN", 4);
				po.setFid(fid);
				po.setFnumber(fnumber);
				
				mapper.insertSelective(po);
				
				//反写修改 计划表 的执行次数 和状态
				mapper.updatePlanStatusExcludcount(po.getFserviceplanid());
		
	}
}
