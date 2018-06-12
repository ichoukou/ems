package com.channelsoft.ems.service.impl;

import com.channelsoft.ems.mapper.FundAccountBillDelRecordMapper;
import com.channelsoft.ems.mapper.FundAccountBillModRecordMapper;
import com.channelsoft.ems.po.FundAccountBillDelRecordPo;
import com.channelsoft.ems.service.FundAccountBillDelRecordService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liuxing on 2017/2/27.
 */
@Service
public class FundAccountBillDelServiceImpl implements FundAccountBillDelRecordService {
    private Logger logger=Logger.getLogger(FundAccountBillDelServiceImpl.class);

    @Autowired
    private FundAccountBillDelRecordMapper recordMapper;
    public List<FundAccountBillDelRecordPo> queryFundAccountBillDelRecord(String fOprationer,String Ldate,String Edate,int page,int pageSize) {
        logger.debug("进入queryFundAccountBillDelRecord 方法");
        List<FundAccountBillDelRecordPo> list = recordMapper.queryDelRecord(fOprationer,Ldate, Edate, page, pageSize);
        return list;
    }

    public int queryFundAccountBillDelRecordCount(String fOprationer, String Ldate, String Edate, int page, int pageSize) {
        return recordMapper.queryDelRecordCount(fOprationer,Ldate, Edate, page, pageSize);
    }
}
