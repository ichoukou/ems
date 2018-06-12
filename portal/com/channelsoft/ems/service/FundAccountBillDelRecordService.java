package com.channelsoft.ems.service;

import com.channelsoft.ems.po.FundAccountBillDelRecordPo;

import java.util.List;

/**
 * Created by liuxing on 2017/2/27.
 */
public interface FundAccountBillDelRecordService {
    //获取删除记录列表
    public List<FundAccountBillDelRecordPo> queryFundAccountBillDelRecord(String fOprationer,String Ldate,String Edate,int page,int pageSize);
    //获取删除记录列表数量
    public int queryFundAccountBillDelRecordCount(String fOprationer,String Ldate,String Edate,int page,int pageSize);
}
