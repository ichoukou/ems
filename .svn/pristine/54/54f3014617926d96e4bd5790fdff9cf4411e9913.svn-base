package com.channelsoft.ems.expenses.retirement.mapper;

import java.util.List;
import java.util.Map;

import com.channelsoft.ems.expenses.retirement.po.RetirementPo;
import com.channelsoft.ems.expenses.rpayment.po.Rpayment;

/** 
 * 
 * 退住借款mapper  
 * @author  lwj
 * @date 创建时间：2017年3月10日09:43:42
 * @parameter  
 * @return  
 */
public interface RetirementMapper {
	
	List<Rpayment> QueryList(Rpayment po);

	int getTotalSize(Rpayment po);

	List<RetirementPo> getRetirementPoHistorys(RetirementPo po);

	List<RetirementPo> getRetirementPoOnes(RetirementPo po);

	List<RetirementPo> getRetirementPoPhasicRpays(RetirementPo po);

	List<RetirementPo> getRetirementPoMounLoopRpays(RetirementPo po);

	List<RetirementPo> getRetirementPoPhasicPays(RetirementPo po);

	List<RetirementPo> getRetirementPoMounLoopPays(RetirementPo po);

	List<RetirementPo> getRetirementPoReductions(RetirementPo po);

	void updateOldmanStatus(Map<String,String> map);
}
