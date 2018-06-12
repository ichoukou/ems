package com.channelsoft.ems.service;

import com.channelsoft.ems.po.OldManPaymentPo;

import java.util.List;

/**
 * Created by wangjs on 2016/12/27.
 */
public interface OldManPaymentService {

    public List<OldManPaymentPo> queryLast();

    public List<OldManPaymentPo> queryList(OldManPaymentPo po);

    public void addPayment(OldManPaymentPo po);

    public void updOmPayment(OldManPaymentPo po);

    public void delOmPayment(OldManPaymentPo po);
}
