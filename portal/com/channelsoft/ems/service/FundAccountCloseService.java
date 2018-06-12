package com.channelsoft.ems.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.channelsoft.ems.po.BalancePo;

/**
 *  结账service
 * @author lizhu
 * @Copyright Channelsoft
 * @2017年2月28日
 */
public interface FundAccountCloseService {
	/**
	 * 查询余额表中记录
	 * @param balancePo
	 * @return
	 */
	public List<BalancePo> queryBalance(BalancePo balancePo);

	/**
	 * 添加账户余额
	 * @param balancePo
	 * @return
	 */
	public int insertBalance(BalancePo balancePo);

	/**
	 * 结账
	 * @param fDate
	 * @return
	 */
	public int jieZhang(String fDate,HttpServletRequest request,HttpServletResponse response)throws Exception;

	/**
	 * 反结账
	 * @param fDate
	 * @return
	 * @throws Exception
	 */
	public int balanceBack(String fDate) throws Exception;

	/**
	 * 得到余额表中最大的月份
	 * @return
	 */
	public String getMaxDate();


}
