package com.channelsoft.ems.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.channelsoft.ems.po.CwglPaymentPo;
import com.channelsoft.ems.po.FundAccountBillPo;

/**
 * 资金账户收支明细
 * @author lizhu
 * @Copyright Channelsoft
 * @2017年2月14日
 */
public interface FundAccountBillService {
	/**
	 * 得到资金杂项用于回显在账户收入和账户支出的杂项下拉框中
	 * @param id
	 * @return
	 */
	public List<CwglPaymentPo> getPayments(String id,String type);

	/**
	 * 在添加资金账户的同时向收支明细中添加一条账户 
	 * @param fundAccountBillPo
	 * @return
	 * @throws Exception
	 */
	public int addFundAccountBill(FundAccountBillPo fundAccountBillPo,HttpServletRequest request);

	/**
	 * 收支明细的查询
	 * @param page
	 * @param pageSize
	 * @param fundAccountBillPo
	 * @return
	 */
	public List<FundAccountBillPo> queryFundAccountBill(int page,int pageSize,FundAccountBillPo fundAccountBillPo);

	/**
	 * 根据日期查询本期的收支明细
	 * @param fDate
	 * @return
	 */
	public List<FundAccountBillPo> queryFundAccountBillByDate(String fDate,String fundAccount,String fType);

	/**
	 * 按照月份去重查询账户
	 * @param fDate
	 * @return
	 */
	public List<String> queryDistinct(String fDate);

	/**
	 * 查询表中总数
	 * @return
	 */
	public int getTotal(FundAccountBillPo fundAccountBillPo);

	/**
	 * 更改状态
	 * @param fundAccountBillPo
	 * @return
	 */
	public int changeStatus(FundAccountBillPo fundAccountBillPo);

	/**
	 * 修改资金账户
	 * @param fundAccountBillPo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int updateFundAccountBill(FundAccountBillPo fundAccountBillPo,HttpServletRequest request) throws Exception;

	/**
	 * 删除资金账户
	 * @param fundAccountBillPo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public int delFundAccountBill(FundAccountBillPo fundAccountBillPo,HttpServletRequest request) throws Exception;

}
