package com.channelsoft.ems.expenses.rpayment.service;

import java.util.List;

import com.channelsoft.ems.expenses.rpayment.po.Oldmanblance;
import com.channelsoft.ems.expenses.rpayment.po.Payment;
import com.channelsoft.ems.expenses.rpayment.po.Rpayment;
import com.channelsoft.ems.po.OldManChargePo;

/** 
 * 
 * 实际缴费service  
 * @author  lwj
 * @date 创建时间：2017年03月04日 下午14:31:41 
 * @parameter  
 * @return  
 */
public interface PaymentService {

    int deleteByPrimaryKey(String fid);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(String fid);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);
    
    List<Rpayment> queryPaymentList(Rpayment po);

	Oldmanblance getOldManBlanceCurrent(Rpayment po);

	List<OldManChargePo> getFcostitem(String foldmanid);

	String savePayMent(Payment po);

	List<Payment> queryHasPaymentList(Payment po);

}
