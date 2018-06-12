package com.channelsoft.ems.service;

import java.util.List;

import com.channelsoft.ems.po.BalancePo;

/**
 *  余额service
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2017年1月12日
 */
public interface BalanceService {
	
	public List<BalancePo> queryByAccount(String fNumber);

}
