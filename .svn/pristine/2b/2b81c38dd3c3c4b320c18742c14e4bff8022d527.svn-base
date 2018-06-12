package com.channelsoft.ems.expenses.rpayment.service;

import java.util.List;

import com.channelsoft.ems.expenses.rpayment.po.Rpayment;

/** 
 * 
 * 应缴费service  
 * @author  lwj
 * @date 创建时间：2017年03月04日 下午14:31:41 
 * @parameter  
 * @return  
 */
public interface RpaymentService {

    int deleteByPrimaryKey(String fid);

    int insert(Rpayment record);

    int insertSelective(Rpayment record);

    Rpayment selectByPrimaryKey(String fid);

    int updateByPrimaryKeySelective(Rpayment record);

    int updateByPrimaryKey(Rpayment record);
    
    List<Rpayment> selectByOldManId(String oldmanid);
    
    List<Rpayment> QueryList(Rpayment po);

	int getTotalSize(Rpayment po);

}
