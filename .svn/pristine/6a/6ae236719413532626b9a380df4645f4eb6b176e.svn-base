package com.channelsoft.ems.expenses.rpayment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.expenses.rpayment.mapper.RpaymentMapper;
import com.channelsoft.ems.expenses.rpayment.mapper.RpaymententryMapper;
import com.channelsoft.ems.expenses.rpayment.po.Rpayment;
import com.channelsoft.ems.expenses.rpayment.service.RpaymentService;

/** 
 * 
 * 应缴费serviceImpl  
 * @author  lwj
 * @date 创建时间：2017年03月04日 下午14:31:41 
 * @parameter  
 * @return  
 */
@Service
public class RepaymentServiceImpl implements RpaymentService{

	@Autowired
	private RpaymentMapper rpayMapper;
	@Autowired
	private RpaymententryMapper rpayentryMapper;
	
	public int deleteByPrimaryKey(String fid) {
		return rpayMapper.deleteByPrimaryKey(fid);
	}

	public int insert(Rpayment record) {
		return rpayMapper.insert(record);
	}

	public int insertSelective(Rpayment record) {
		return rpayMapper.insertSelective(record);
	}

	public Rpayment selectByPrimaryKey(String fid) {
		// TODO Auto-generated method stub
		return rpayMapper.selectByPrimaryKey(fid);
	}

	public int updateByPrimaryKeySelective(Rpayment record) {
		// TODO Auto-generated method stub
		return rpayMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Rpayment record) {
		// TODO Auto-generated method stub
		return rpayMapper.updateByPrimaryKey(record);
	}

	public List<Rpayment>  selectByOldManId(String oldmanid) {
		// TODO Auto-generated method stub
		return rpayMapper.selectByOldManId(oldmanid);
	}


	public List<Rpayment> QueryList(Rpayment po) {
		return rpayMapper.QueryList(po);
	}

	@Override
	public int getTotalSize(Rpayment po) {
		return rpayMapper.getTotalSize(po);
	}

}
