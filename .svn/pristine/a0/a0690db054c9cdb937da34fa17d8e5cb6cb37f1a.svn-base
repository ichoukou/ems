package com.channelsoft.ems.expenses.rpayment.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.channelsoft.ems.expenses.rpayment.po.Oldmanblance;
import com.channelsoft.ems.expenses.rpayment.po.Payment;
import com.channelsoft.ems.expenses.rpayment.po.Rpayment;
import com.channelsoft.ems.po.OldManChargePo;
/** 
 * 
 * 实际缴费mapper  
 * @author  lwj
 * @date 创建时间：2017年03月04日 下午14:31:41 
 * @parameter  
 * @return  
 */
public interface PaymentMapper {
    int deleteByPrimaryKey(String fid);

    int insert(Payment record);

    int insertSelective(Payment record);

    Payment selectByPrimaryKey(String fid);

    int updateByPrimaryKeySelective(Payment record);

    int updateByPrimaryKey(Payment record);

	List<Rpayment> queryPaymentList(Rpayment po);

	Oldmanblance getOldManBlance(Rpayment po);

	List<OldManChargePo> getFcostitem(String foldmanid);

	List<Payment> queryHasPaymentList(Payment po);
}