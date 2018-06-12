package com.channelsoft.ems.service;

import com.channelsoft.ems.po.CwglPaymentPo;

import java.util.List;

/**
 * Created by wangjs on 2017/1/12.
 */
public interface CwglPaymentService {

    public List<CwglPaymentPo> queryPayList(CwglPaymentPo po, String flag);

    public List<CwglPaymentPo> getPayList(String id);

    public List<CwglPaymentPo> queryPaySonList(String parentId,String flag);

    public void addPayment(CwglPaymentPo po);

    public void updateCwglPayment(CwglPaymentPo po);

    public int searchCwglPayment(String id);

    public void deleteCwglPayment(String id);


}
