package com.channelsoft.ems.nursing.nursingPlanExcute.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.common.IdGen;
import com.channelsoft.ems.nursing.nursingPlan.po.OldManPo;
import com.channelsoft.ems.nursing.nursingPlan.po.OldManServiceItemPo;
import com.channelsoft.ems.nursing.nursingPlanExcute.mapper.OldManServiceExecutePoMapper;
import com.channelsoft.ems.nursing.nursingPlanExcute.po.OldManServiceExecutePo;
import com.channelsoft.ems.nursing.nursingPlanExcute.service.OldManServiceExecuteService;

/** 
 * 
 * 老人护理计划执行seviceImpl  
 * @author  lwj
 * @date 创建时间：2017年2月24日09:44:46
 * @parameter  
 * @return  
 */
@Service
public class OldManServiceExecuteServiceImpl implements OldManServiceExecuteService{
	
	@Autowired
	private OldManServiceExecutePoMapper mapper;

	@Override
	public List<OldManServiceExecutePo> queryList(OldManServiceExecutePo po) {
		return mapper.queryList(po);
	}

	@Override
	public int getTotalSize(OldManServiceExecutePo po) {
		return mapper.getTotalSize(po);
	}

	@Override
	public List<OldManServiceExecutePo> queryDetailList(OldManServiceExecutePo po) {
		return mapper.queryDetailList(po);
	}

	@Override
	public OldManPo showOldManInfo(String fid) {
		return mapper.showOldManInfo(fid);
	}

	@Override
	public OldManServiceExecutePo showOldManPlanInfo(String fid) {
		// TODO Auto-generated method stub
		return mapper.showOldManPlanInfo(fid);
	}

	@Override
	public void saveOldManPlanExecute(OldManServiceExecutePo po) {
		//插入执行记录
		String fid=IdGen.getRandomNoYMS("LRJHZX", 4);
		String fnumber=IdGen.getRandomNoYMS("JHZXN", 4);
		po.setFid(fid);
		po.setFnumber(fnumber);
		
		mapper.insertSelective(po);
		
		//反写修改 计划表 的执行次数 和状态
		mapper.updatePlanStatusExcludcount(po.getFserviceplanid());
	}
}
