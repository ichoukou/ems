package com.channelsoft.ems.expenses.mouthblance.service;

import java.text.ParseException;
import java.util.List;

import com.channelsoft.ems.expenses.rpayment.po.Oldmanblance;
import com.channelsoft.ems.expenses.rpayment.po.Rpayment;


/** 
 * 
 * 月结账service  
 * @author  lwj
 * @date 创建时间：2017年3月6日21:18:20 
 * @parameter  
 * @return  
 */
public interface MouthblanceService {

    int deleteByPrimaryKey(String fid);

    int insert(Oldmanblance record);

    int insertSelective(Oldmanblance record);

    Oldmanblance selectByPrimaryKey(String fid);

    int updateByPrimaryKeySelective(Oldmanblance record);

    int updateByPrimaryKey(Oldmanblance record);

	Oldmanblance getOldManBlance();

	void paymentSubmit ();

	void paymentSubmitBack();

	List<Oldmanblance> QueryList(Oldmanblance po);

	int getTotalSize(Oldmanblance po);
}
