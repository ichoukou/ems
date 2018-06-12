package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.po.FundAccountBillDelRecordPo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.channelsoft.ems.mapper.FundAccountBillModRecordMapper;
import com.channelsoft.ems.po.FundAccountBillModRecordPo;
import com.channelsoft.ems.service.FundAccountBillModRecordService;

import java.util.List;

@Service
public class FundAccountBillModServiceImpl implements FundAccountBillModRecordService {

	private Logger logger=Logger.getLogger(FundAccountBillModServiceImpl.class);
	
	@Autowired
	private FundAccountBillModRecordMapper recordMapper;
	/**
	 * 添加修改资金账户记录
	 */
	public int insert(FundAccountBillModRecordPo modRecordPo) {
		logger.debug("开始添加");
		int result =recordMapper.insertRecord(modRecordPo);
		if(result>0){
			return result;
		}
		return 0;
	}

	public List<FundAccountBillModRecordPo> queryFundAccountBillModRecord(String fOprationer,String Ldate,String Edate,int page,int pageSize) {
		logger.debug("进入queryFundAccountBillDelRecord 方法");
		List<FundAccountBillModRecordPo> list = recordMapper.queryModRecord(fOprationer,Ldate, Edate, page, pageSize);
		return list;
	}

	public int queryFundAccountBillModRecordCount(String fOprationer, String Ldate, String Edate, int page, int pageSize) {
		return recordMapper.queryModRecordCount(fOprationer,Ldate, Edate, page, pageSize);
	}
}
