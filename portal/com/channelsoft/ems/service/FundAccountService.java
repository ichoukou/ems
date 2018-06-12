package com.channelsoft.ems.service;

import com.channelsoft.ems.po.FundAccountBillPo;

import com.channelsoft.ems.po.FundAccountPo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *  资金账户
 * @author lizhu
 * @Copyright Channelsoft
 * @2017年1月5日
 */
public interface FundAccountService {
	/**
	 * 查询资金账户
	 * @param page
	 * @param pageSize
	 * @param fundAccountPo
	 * @param request
	 * @param response
	 * @return
	 */
	public List<FundAccountPo> queryFundAccount(int page, int pageSize, FundAccountPo fundAccountPo, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 查询所有包括禁用
	 * @param page
	 * @param pageSize
	 * @param fundAccountPo
	 * @param request
	 * @param response
	 * @return
	 */
	public List<FundAccountPo> queryIgnoreStatus(int page, int pageSize, FundAccountPo fundAccountPo, HttpServletRequest request, HttpServletResponse response);
	/**
	 * 得到总条数  分页用
	 * @param fundAccountPo
	 * @return
	 */
	public int getCount(FundAccountPo fundAccountPo);


	/**
	 * 得到总条数  分页用   忽略状态
	 * @param fundAccountPo
	 * @return
	 */
	public int getCountIgnoreStatus(FundAccountPo fundAccountPo);


	/**
	 * 添加
	 * @param fundAccountPo
	 * @return
	 * @throws Exception
	 */
	public int addFundAccount(FundAccountPo fundAccountPo, HttpServletRequest request) throws Exception;

	/**
	 * 根据字典id得到字典名称
	 * @param id
	 * @return
	 */
	public String getStatusNameById(String id);

	/**
	 * 修改状态
	 * @param fId
	 * @param fStatus
	 * @return
	 */
	public int changeStatus(String fId, String fStatus);

	/**
	 * 校验账户名和账户号是否存在
	 * @param fundAccountPo
	 * @return
	 */
	public int check(FundAccountPo fundAccountPo);

	/**
	 * 修改资金账户信息
	 * @param fundAccountPo
	 * @return
	 * @throws Exception
	 */
	public int updateFundAccount(FundAccountPo fundAccountPo, HttpServletRequest request) throws Exception;

	/**
	 * 修改账户余额信息
	 * @param fundAccountPo
	 * @return
	 */
	public int updateFundAmount(FundAccountPo fundAccountPo, HttpServletRequest request);

	/**
	 * 转账
	 * @param request
	 * @param response
	 * @return
	 */
	public int transfer(HttpServletRequest request, HttpServletResponse response) throws Exception;

	/**
	 * 账户收入
	 * @param fundAccountPo
	 * @return
	 * @throws Exception
	 */
	public int fundAccountIn(FundAccountPo fundAccountPo, FundAccountBillPo fundAccountBillPo, HttpServletRequest request) throws Exception;

	/**
	 * 账户支出
	 * @param fundAccountPo
	 * @return
	 */
	public int fundAccountOut(FundAccountPo fundAccountPo, FundAccountBillPo fundAccountBillPo, HttpServletRequest request)throws Exception;

}
