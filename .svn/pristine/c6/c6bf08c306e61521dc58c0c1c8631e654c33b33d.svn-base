package com.channelsoft.ems.service;

import com.channelsoft.ems.po.FundAccountBillDelRecordPo;
import com.channelsoft.ems.po.FundAccountBillModRecordPo;

import java.util.List;

/**
 *  资金账户修改记录
 	* @author lizhu
 	* @Copyright Channelsoft
	* @2017年2月20日
 */
public interface FundAccountBillModRecordService {
	/**
	 * 添加资金账户的修改记录
	 * @param modRecordPo
	 * @return
	 */
	public int  insert(FundAccountBillModRecordPo modRecordPo);
	//获取删除记录列表
	public List<FundAccountBillModRecordPo> queryFundAccountBillModRecord(String fOprationer, String Ldate, String Edate, int page, int pageSize);
	//获取删除记录列表数量
	public int queryFundAccountBillModRecordCount(String fOprationer,String Ldate,String Edate,int page,int pageSize);


}
