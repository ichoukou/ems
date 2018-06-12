package com.channelsoft.ems.service;

import com.channelsoft.ems.po.OldManPaymentEntryPo;

/**
 * Created by wangjs on 2016/12/28.
 */
public interface OldManPaymentEntryService {

    public void addPaymentEntry(String[] arr);

    public void addPaymentEntryOne(OldManPaymentEntryPo po);

    public void updPaymentEntryOne(OldManPaymentEntryPo po);

    public void delPaymentEntryOne(OldManPaymentEntryPo po);
}

