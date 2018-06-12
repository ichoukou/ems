package com.channelsoft.ems.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.mapper.BalanceMapper;
import com.channelsoft.ems.po.BalancePo;
import com.channelsoft.ems.service.BalanceService;
@Service
public class BalanceServiceImpl implements BalanceService {

	private Logger logger=Logger.getLogger(BalanceServiceImpl.class);
	@Autowired
	private BalanceMapper balanceMapper;
	
	public List<BalancePo> queryByAccount(String fNumber) {
		logger.debug("开始查询余额表中记录");
		List<BalancePo> balancePo = balanceMapper.queryByAccount(fNumber);
		return balancePo;
	}

}
