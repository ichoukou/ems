package com.channelsoft.ems.expenses.rpayment.mapper;

import com.channelsoft.ems.expenses.rpayment.po.Paymententry;

public interface PaymententryMapper {
    int deleteByPrimaryKey(String fid);

    int insert(Paymententry record);

    int insertSelective(Paymententry record);

    Paymententry selectByPrimaryKey(String fid);

    int updateByPrimaryKeySelective(Paymententry record);

    int updateByPrimaryKey(Paymententry record);
}